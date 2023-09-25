package cn.yiplatform.dto;


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @date 2022/3/10-17:10
 */
public class TemperatureReportDTO implements Serializable {

    private Long id;

    private Long uid;

    private String userName;

    private String account;

    private Double temperature;

    private Date submitTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return "HealthyReportDTO{" +
                "id=" + id +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", temperature=" + temperature +
                ", submitTime=" + submitTime +
                '}';
    }
}
