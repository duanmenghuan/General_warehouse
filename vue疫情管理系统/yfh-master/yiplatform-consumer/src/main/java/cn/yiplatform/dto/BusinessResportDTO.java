package cn.yiplatform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @date 2022/3/9-14:15
 */
public class BusinessResportDTO implements Serializable {

    private Long id;

    private Long uid;

    private String userName;

    private String account;

    private Long department;

    private String startPlace;

    private String endPlace;

    private Date beginTime;

    private Date endTime;

    private String trafficTool;

    private Date backBeginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date backEndTime;

    private String backTrafficTool;

    private int isComplete;

    private int status;

    private Date createTime;

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

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
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

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTrafficTool() {
        return trafficTool;
    }

    public void setTrafficTool(String trafficTool) {
        this.trafficTool = trafficTool;
    }

    public Date getBackBeginTime() {
        return backBeginTime;
    }

    public void setBackBeginTime(Date backBeginTime) {
        this.backBeginTime = backBeginTime;
    }

    public Date getBackEndTime() {
        return backEndTime;
    }

    public void setBackEndTime(Date backEndTime) {
        this.backEndTime = backEndTime;
    }

    public String getBackTrafficTool() {
        return backTrafficTool;
    }

    public void setBackTrafficTool(String backTrafficTool) {
        this.backTrafficTool = backTrafficTool;
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BusinessResportDTO{" +
                "id=" + id +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", department=" + department +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", trafficTool='" + trafficTool + '\'' +
                ", backBeginTime=" + backBeginTime +
                ", backEndTime=" + backEndTime +
                ", backTrafficTool='" + backTrafficTool + '\'' +
                ", isComplete=" + isComplete +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
