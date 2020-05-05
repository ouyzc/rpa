package cn.oyzc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName RpaLog
 * @Description RPA运行记录
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午8:59
 * @Version 1.0
 */
public class RpaLog implements Serializable {

    private Integer rpalogId;

    private String company;

    private String name;

    private String startTime;

    private String endTime;

    private String runTime;

    private String result;

    public Integer getRpalogId() {
        return rpalogId;
    }

    public void setRpalogId(Integer rpalogId) {
        this.rpalogId = rpalogId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RpaLog{" +
                "rpalogId=" + rpalogId +
                ", company='" + company + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", runTime=" + runTime +
                ", result='" + result + '\'' +
                '}';
    }
}
