package cn.yiplatform.dto;

import java.io.Serializable;

/**
 *
 * @date 2022/3/11-09:42
 */
public class UserDTO  implements Serializable {

    /**
     * 用户账号
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 旧密码
     */
    private String newPassword;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 住址
     */
    private String address;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
