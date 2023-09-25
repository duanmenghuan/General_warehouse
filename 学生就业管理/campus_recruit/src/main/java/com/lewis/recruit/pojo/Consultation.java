package com.lewis.recruit.pojo;

public class Consultation {
    private Integer consultationId;
    //咨询的职位id
    private Integer positionId;
    //咨询的类型 1：咨询；2：回复
    private Integer type;
    //父级id
    private Integer parentId;
    //咨询的学生id
    private Integer studentId;
    //咨询的老师id
    private Integer teacherId;
    //咨询的公司id
    private Integer companyId;
    //咨询的内容
    private String content;
    //咨询的时间
    private String consultationDate;
    //职位对象
    private Position position;
    //职位对象
    private Student student;
    //职位对象
    private Teacher teacher;

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationId=" + consultationId +
                ", positionId=" + positionId +
                ", type=" + type +
                ", parentId=" + parentId +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", companyId=" + companyId +
                ", content='" + content + '\'' +
                ", consultationDate='" + consultationDate + '\'' +
                ", position=" + position +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
