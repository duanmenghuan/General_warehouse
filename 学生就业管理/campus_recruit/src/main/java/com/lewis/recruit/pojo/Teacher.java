package com.lewis.recruit.pojo;

//班主任
public class Teacher {
    private Integer teacherId;
    //账号
    private String teacherAccount;
    //密码
    private String teacherPassword;
    //密码盐值
    private String teacherSalt;

    private String teacherNo;
    private String teacherName;
    private String teacherPhone;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSalt() {
        return teacherSalt;
    }

    public void setTeacherSalt(String teacherSalt) {
        this.teacherSalt = teacherSalt;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherAccount='" + teacherAccount + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherSalt='" + teacherSalt + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                '}';
    }
}
