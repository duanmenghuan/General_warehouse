package com.lewis.recruit.pojo;

import java.io.Serializable;
import java.util.Date;

//职位
public class Position{
    private Integer positionId;
    //职位所属公司
    private Integer positionCompany;
    //职位名称
    private String positionName;
    //职位是否只招应届生
    private Integer positionFresh;
    //职位最低工资
    private Integer positionMinSalary;
    //职位最高工资
    private Integer positionMaxSalary;
    //职位招聘人数
    private Integer positionQuota;
    //职位工作城市
    private String positionCity;
    //职位需求
    private String positionRequire;
    //职位描述
    private String positionDescription;
    //职位福利
    private String positionWelfare;
    //职位发布时间
    private Date positionRelease;
    //职位发布时间
    private String positionStatus;
    //职位发布时间
    private String positionRemark;
    //职位被投递简历数量
    private Integer deliverCount;

    public Integer getPositionCompany() {
        return positionCompany;
    }

    public void setPositionCompany(Integer positionCompany) {
        this.positionCompany = positionCompany;
    }

    //职位所属公司
    private Company company;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionMinSalary() {
        return positionMinSalary;
    }

    public void setPositionMinSalary(Integer positionMinSalary) {
        this.positionMinSalary = positionMinSalary;
    }

    public Integer getPositionMaxSalary() {
        return positionMaxSalary;
    }

    public void setPositionMaxSalary(Integer positionMaxSalary) {
        this.positionMaxSalary = positionMaxSalary;
    }

    public Integer getPositionQuota() {
        return positionQuota;
    }

    public void setPositionQuota(Integer positionQuota) {
        this.positionQuota = positionQuota;
    }

    public String getPositionCity() {
        return positionCity;
    }

    public void setPositionCity(String positionCity) {
        this.positionCity = positionCity;
    }

    public String getPositionRequire() {
        return positionRequire;
    }

    public void setPositionRequire(String positionRequire) {
        this.positionRequire = positionRequire;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getPositionWelfare() {
        return positionWelfare;
    }

    public void setPositionWelfare(String positionWelfare) {
        this.positionWelfare = positionWelfare;
    }

    public Date getPositionRelease() {
        return positionRelease;
    }

    public void setPositionRelease(Date positionRelease) {
        this.positionRelease = positionRelease;
    }

    public Integer getDeliverCount() {
        return deliverCount;
    }

    public void setDeliverCount(Integer deliverCount) {
        this.deliverCount = deliverCount;
    }

    public String getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    public String getPositionRemark() {
        return positionRemark;
    }

    public void setPositionRemark(String positionRemark) {
        this.positionRemark = positionRemark;
    }

    public Integer getPositionFresh() {
        return positionFresh;
    }

    public void setPositionFresh(Integer positionFresh) {
        this.positionFresh = positionFresh;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionCompany=" + positionCompany +
                ", positionName='" + positionName + '\'' +
                ", positionFresh=" + positionFresh +
                ", positionMinSalary=" + positionMinSalary +
                ", positionMaxSalary=" + positionMaxSalary +
                ", positionQuota=" + positionQuota +
                ", positionCity='" + positionCity + '\'' +
                ", positionRequire='" + positionRequire + '\'' +
                ", positionDescription='" + positionDescription + '\'' +
                ", positionWelfare='" + positionWelfare + '\'' +
                ", positionRelease=" + positionRelease +
                ", positionStatus='" + positionStatus + '\'' +
                ", positionRemark='" + positionRemark + '\'' +
                ", deliverCount=" + deliverCount +
                ", company=" + company +
                '}';
    }
}
