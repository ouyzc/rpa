package cn.oyzc.service;

import cn.oyzc.domain.RpaLog;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RpaLogService
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午11:04
 * @Version 1.0
 */
public interface RpaLogService {

    /**
     * 查询所有运行记录
     * @return
     */
    List<RpaLog> findAll(Map<String, Object> map);

    /**
     * 根据运行结果查询运行记录
     * @param map
     * @return
     */
    List<RpaLog> findByResult(Map<String, Object> map);

    /**
     * 根据运行开始与结束时间查询运行记录
     * @param map
     * @return
     */
    List<RpaLog> findByTime(Map<String, Object> map);
}
