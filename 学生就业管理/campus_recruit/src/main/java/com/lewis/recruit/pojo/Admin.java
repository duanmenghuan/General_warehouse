package com.lewis.recruit.pojo;

//管理员
public class Admin {
    private Integer adminId;
    //管理员账号
    private String adminAccount;
    //管理员密码
    private String adminPassword;
    //管理员密码盐值
    private String adminSalt;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }

    public Admin(Integer adminId, String adminAccount, String adminPassword, String adminSalt) {
        this.adminId = adminId;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
        this.adminSalt = adminSalt;
    }

    public Admin(){

    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminSalt='" + adminSalt + '\'' +
                '}';
    }
}
