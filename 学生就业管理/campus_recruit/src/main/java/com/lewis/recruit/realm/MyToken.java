package com.lewis.recruit.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyToken extends UsernamePasswordToken {
    //登录类型
	private String loginType;
 
    public MyToken() {}
 
    public MyToken(final String username, final String password, final String loginType) {
        super(username, password);
        this.loginType = loginType;
    }
 
    public String getLoginType() {
        return loginType;
    }
 
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}