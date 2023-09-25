package com.lewis.recruit.pojo;

//学生
public class Student {
    private Integer studentId;
    //学生账号
    private String studentAccount;
    //学生密码
    private String studentPassword;
    //学生密码盐值
    private String studentSalt;

    private String studentNo;

    private String studentClassg;

    private String studentPhone;

    private String studentResume;

    private Integer studentEmployment;

    private String employment;

    private String studentName;

    private String studentMajor;

    private String studentGrade;

    private String studentEmail;

    private Deliver deliver;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentSalt() {
        return studentSalt;
    }

    public void setStudentSalt(String studentSalt) {
        this.studentSalt = studentSalt;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentClassg() {
        return studentClassg;
    }

    public void setStudentClassg(String studentClassg) {
        this.studentClassg = studentClassg;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentResume() {
        return studentResume;
    }

    public void setStudentResume(String studentResume) {
        this.studentResume = studentResume;
    }

    public Integer getStudentEmployment() {
        return studentEmployment;
    }

    public void setStudentEmployment(Integer studentEmployment) {
        this.studentEmployment = studentEmployment;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentAccount='" + studentAccount + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentSalt='" + studentSalt + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentClassg='" + studentClassg + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentResume='" + studentResume + '\'' +
                ", studentEmployment=" + studentEmployment +
                ", studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentGrade='" + studentGrade + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", deliver=" + deliver +
                '}';
    }
}
