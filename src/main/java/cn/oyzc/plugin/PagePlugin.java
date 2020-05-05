package cn.oyzc.plugin;

import cn.oyzc.domain.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName PagePlugin
 * @Description 分页插件
 * @Author ouyangzicheng
 * @Date 2020/5/3 下午12:16
 * @Version 1.0
 */
@Intercepts(@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
))
public class PagePlugin implements Interceptor {

    /**
     * 插件到核心业务
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        /**
         * 1. 拿到原始到sql语句
         * 2. 修改原始sql增加分页 select * from user limit 0,10
         * 3. 执行jdbc查询总数
         */
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 获取原始sql
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println("原始sql:" + sql);

        // 分页参数
        Object parameterObject = boundSql.getParameterObject();

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        // 获取mapper接口中到方法名称
        String mappedMethodName = mappedStatement.getId();
        if (mappedMethodName.matches(".*ByPage$")) {
            Map<String, Object> params = (Map<String, Object>) parameterObject;
            Page page = (Page) params.get("page");
            String countSql = "select count(0) from (" + sql + ") a";
            System.out.println("查询总数sql:" + countSql);

            // 执行jdbc操作
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();
            if (rs.next()) {
                page.setCount(rs.getInt(1));
            }
            rs.close();
            countStatement.close();

            // 改造sql limit
            String pageSql = splicePageSql(sql, page);
            System.out.println("分页sql:" + pageSql);

            metaObject.setValue("delegate.boundSql.sql", pageSql);

        }
        // 把执行流程交给mybatis
        return invocation.proceed();
    }

    /**
     * 把自定义到插件加入到mybatis中执行
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置属性
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 根据原始sql生产带limit的sql
     * @return
     */
    public String splicePageSql(String sql, Page page) {
        return sql + " limit " + (page.getCurrentPage() - 1) * page.getLimit()  + "," + page.getLimit();
    }
}
