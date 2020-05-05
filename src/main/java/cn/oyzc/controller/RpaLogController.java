package cn.oyzc.controller;

import cn.oyzc.domain.Page;
import cn.oyzc.domain.RpaLog;
import cn.oyzc.dto.ResultData;
import cn.oyzc.dto.StatEnum;
import cn.oyzc.service.RpaLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RpaLogController
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午11:29
 * @Version 1.0
 */
@Controller
@RequestMapping("/rpaLog")
public class RpaLogController {

    private RpaLogService rpaLogService;

    @Autowired
    public void setRpaLogService(RpaLogService rpaLogService) {
        this.rpaLogService = rpaLogService;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<RpaLog>> findAll(HttpServletRequest request) {
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        Page page = new Page(currentPage, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        List<RpaLog> list = rpaLogService.findAll(map);
        if (list.size() == 0) {
            return ResultData.data(StatEnum.SUCCESS_NULL, list, page.getCount());
        }
        return ResultData.data(StatEnum.SUCCESS_RESULT, list, page.getCount());
    }

    @RequestMapping(value = "/findByResult", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<List<RpaLog>> findByResult(String result, int currentPage, int limit) {
        if (result == null || result.equals("")) {
            return ResultData.data("传入NULL值");
        }
        Page page = new Page(currentPage, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("result", result);
        List<RpaLog> list = rpaLogService.findByResult(map);
        if (list.size() == 0) {
            return ResultData.data(StatEnum.SUCCESS_NULL, list, page.getCount());
        }
        return ResultData.data(StatEnum.SUCCESS_RESULT, list, page.getCount());
    }

    @RequestMapping(value = "/findByTime", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<RpaLog>> findByTime(String startTime, String endTime, HttpServletRequest request) {
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        if (startTime == null || endTime == null) {
            return ResultData.data("传入NULL值");
        }
        try {
            Page page = new Page(currentPage, limit);
            Map<String, Object> map = new HashMap<>();
            map.put("page", page);
            map.put("startTime", startTime);
            map.put("endTime", endTime);
            List<RpaLog> list = rpaLogService.findByTime(map);
            if (list.size() == 0) {
                return ResultData.data(StatEnum.SUCCESS_NULL, list, page.getCount());
            }
            return ResultData.data(StatEnum.SUCCESS_RESULT, list, page.getCount());
        } catch (Exception e) {
            return ResultData.data(e.getMessage());
        }
    }

    @RequestMapping(value = "jump")
    public String jump(HttpServletRequest request) {
        return request.getParameter("path") == null ? "rpalogall" : String.valueOf(request.getParameter("path"));
    }
}
