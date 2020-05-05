package cn.oyzc.service.impl;

import cn.oyzc.dao.RpaLogDao;
import cn.oyzc.domain.Page;
import cn.oyzc.domain.RpaLog;
import cn.oyzc.service.RpaLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RpaLogServiceImpl
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午11:09
 * @Version 1.0
 */
@Service
public class RpaLogServiceImpl implements RpaLogService {

    private RpaLogDao rpaLogDao;

    @Autowired
    public void setRpaLogDao(RpaLogDao rpaLogDao) {
        this.rpaLogDao = rpaLogDao;
    }

    @Override
    public List<RpaLog> findAll(Map<String, Object> map) {
        return rpaLogDao.findAllByPage(map);
    }

    @Override
    public List<RpaLog> findByResult(Map<String, Object> map) {
        return rpaLogDao.findByResultByPage(map);
    }

    @Override
    public List<RpaLog> findByTime(Map<String, Object> map) {
        return rpaLogDao.findByTimeByPage(map);
    }
}
