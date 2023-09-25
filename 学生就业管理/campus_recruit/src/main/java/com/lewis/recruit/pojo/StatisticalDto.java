package com.lewis.recruit.pojo;

public class StatisticalDto {
    private Integer deliverCount;
    private Integer deliverSuccessCount;
    private Integer haveJobsCount;
    private Integer noHaveJobsCount;
    private Integer positionCount;
    private Integer positionSuccessCount;

    public Integer getDeliverCount() {
        return deliverCount;
    }

    public void setDeliverCount(Integer deliverCount) {
        this.deliverCount = deliverCount;
    }

    public Integer getDeliverSuccessCount() {
        return deliverSuccessCount;
    }

    public void setDeliverSuccessCount(Integer deliverSuccessCount) {
        this.deliverSuccessCount = deliverSuccessCount;
    }

    public Integer getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(Integer positionCount) {
        this.positionCount = positionCount;
    }

    public Integer getPositionSuccessCount() {
        return positionSuccessCount;
    }

    public void setPositionSuccessCount(Integer positionSuccessCount) {
        this.positionSuccessCount = positionSuccessCount;
    }

    public Integer getHaveJobsCount() {
        return haveJobsCount;
    }

    public void setHaveJobsCount(Integer haveJobsCount) {
        this.haveJobsCount = haveJobsCount;
    }

    public Integer getNoHaveJobsCount() {
        return noHaveJobsCount;
    }

    public void setNoHaveJobsCount(Integer noHaveJobsCount) {
        this.noHaveJobsCount = noHaveJobsCount;
    }

    @Override
    public String toString() {
        return "StatisticalDto{" +
                "deliverCount=" + deliverCount +
                ", deliverSuccessCount=" + deliverSuccessCount +
                ", haveJobsCount=" + haveJobsCount +
                ", noHaveJobsCount=" + noHaveJobsCount +
                ", positionCount=" + positionCount +
                ", positionSuccessCount=" + positionSuccessCount +
                '}';
    }
}
