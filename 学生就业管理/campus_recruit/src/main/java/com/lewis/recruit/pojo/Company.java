package com.lewis.recruit.pojo;

//公司
public class Company {
    private Integer companyId;
    //公司账号
    private String companyAccount;
    //公司密码
    private String companyPassword;
    //公司密码盐值
    private String companySalt;

    private String companyNo;
    //公司全称
    private String companyName;

    private String companyContact;

    private String companyPhone;

    //公司联系邮箱
    private String companyEmail;

    private String companyCode;

    //公司地址
    private String companyAddress;
    //公司简介
    private String companyDescribe;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getCompanySalt() {
        return companySalt;
    }

    public void setCompanySalt(String companySalt) {
        this.companySalt = companySalt;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDescribe() {
        return companyDescribe;
    }

    public void setCompanyDescribe(String companyDescribe) {
        this.companyDescribe = companyDescribe;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyAccount='" + companyAccount + '\'' +
                ", companyPassword='" + companyPassword + '\'' +
                ", companySalt='" + companySalt + '\'' +
                ", companyNo='" + companyNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyContact='" + companyContact + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyDescribe='" + companyDescribe + '\'' +
                '}';
    }
}
