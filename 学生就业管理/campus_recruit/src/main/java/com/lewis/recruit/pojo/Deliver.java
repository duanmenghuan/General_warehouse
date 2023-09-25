package com.lewis.recruit.pojo;

public class Deliver {
    private Integer deliverId;
    //投递的职位id
    private Integer positionId;
    //投递的学生id
    private Integer studentId;
    //投递的公司id
    private Integer companyId;
    //投递的状态
    private Integer deliverState;
    //投递的时间
    private String deliverDate;

    //投递的职位对象
    private Position position;

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDeliverState() {
        return deliverState;
    }

    public void setDeliverState(Integer deliverState) {
        this.deliverState = deliverState;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "deliverId=" + deliverId +
                ", positionId=" + positionId +
                ", studentId=" + studentId +
                ", companyId=" + companyId +
                ", deliverState=" + deliverState +
                ", deliverDate=" + deliverDate +
                ", position=" + position +
                '}';
    }
}
