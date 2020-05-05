package cn.oyzc.dao;

import cn.oyzc.domain.Page;
import cn.oyzc.domain.RpaLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RpaLogDaoTest
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午10:06
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RpaLogDaoTest {

    @Resource
    private RpaLogDao rpaLogDao;

    @Test
    public void findAll() {
        Page page = new Page();
        page.setCurrentPage(1);
        page.setLimit(3);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        List<RpaLog> list = rpaLogDao.findAllByPage(map);
        System.out.println("总数："+page.getCount());
        for (RpaLog rpaLog : list) {
            System.out.println(rpaLog);
        }
    }

    @Test
    public void findBySuccess() {
        Page page = new Page();
        page.setCurrentPage(1);
        page.setLimit(3);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "OK");
        map.put("page", page);
        List<RpaLog> list =rpaLogDao.findByResultByPage(map);
        for(RpaLog rpaLog : list) {
            System.out.println(rpaLog);
        }
    }

    @Test
    public void findByTime() {
        String startTime = "2020-05-02 21:00:00";
        String endTime = "2020-05-02 22:00:00";
        Page page = new Page();
        page.setCurrentPage(1);
        page.setLimit(3);
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("page", page);
        List<RpaLog> list = rpaLogDao.findByTimeByPage(map);
        for (RpaLog rpaLog : list) {
            System.out.println("结果："+rpaLog);
        }
    }
}