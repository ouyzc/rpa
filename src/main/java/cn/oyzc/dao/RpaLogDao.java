package cn.oyzc.dao;

import cn.oyzc.domain.RpaLog;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RpaLogDao
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午9:09
 * @Version 1.0
 */
public interface RpaLogDao {

    /**
     * 根据偏移量查询运行记录
     * @return
     */
    List<RpaLog> findAllByPage(Map<String, Object> map);

    /**
     * 查询运行成功或失败的记录
     * @param map
     * @return
     */
    List<RpaLog> findByResultByPage(Map<String, Object> map);

    /**
     * 根据时间区间和偏移量查询运行记录
     * @param map
     * @return
     */
    List<RpaLog> findByTimeByPage(Map<String, Object> map);
}
