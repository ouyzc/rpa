package cn.oyzc.domain;

import java.io.Serializable;

/**
 * @ClassName Rpa
 * @Description TODO
 * @Author ouyangzicheng
 * @Date 2020/5/2 下午9:02
 * @Version 1.0
 */
public class Rpa implements Serializable {

    private Integer rpaId;

    private String company;

    private String name;

    public Integer getRpaId() {
        return rpaId;
    }

    public void setRpaId(Integer rpaId) {
        this.rpaId = rpaId;
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

    @Override
    public String toString() {
        return "Rpa{" +
                "rpaId=" + rpaId +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
