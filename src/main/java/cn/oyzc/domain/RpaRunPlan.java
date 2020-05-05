package cn.oyzc.domain;

import java.io.Serializable;

/**
 * @ClassName RpaRunPlan
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午9:03
 * @Version 1.0
 */
public class RpaRunPlan implements Serializable {

    private Integer rparunplanId;

    private String runplanWeek;

    private String runplanTime;

    private Rpa rpa;

    public Integer getRparunplanId() {
        return rparunplanId;
    }

    public void setRparunplanId(Integer rparunplanId) {
        this.rparunplanId = rparunplanId;
    }

    public String getRunplanWeek() {
        return runplanWeek;
    }

    public void setRunplanWeek(String runplanWeek) {
        this.runplanWeek = runplanWeek;
    }

    public String getRunplanTime() {
        return runplanTime;
    }

    public void setRunplanTime(String runplanTime) {
        this.runplanTime = runplanTime;
    }

    public Rpa getRpa() {
        return rpa;
    }

    public void setRpa(Rpa rpa) {
        this.rpa = rpa;
    }

    @Override
    public String toString() {
        return "RpaRunPlan{" +
                "rparunplanId=" + rparunplanId +
                ", runplanWeek='" + runplanWeek + '\'' +
                ", runplanTime='" + runplanTime + '\'' +
                ", rpa=" + rpa +
                '}';
    }
}
