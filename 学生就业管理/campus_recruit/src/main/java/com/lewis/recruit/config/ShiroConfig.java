package com.lewis.recruit.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.lewis.recruit.realm.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器

        /*
        anon: 无需认证就能访问
        authc：必须认证才能访问
        user: 必须拥有 记住我 功能才能访问
        perms：拥有对某个资源的权限才能访问
        role： 拥有某个角色权限才能访问
         */
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //开放注册功能
        map.put("/toRegister", "anon");
        map.put("/student/register", "anon");
        map.put("/teacher/register", "anon");
        map.put("/admin/register", "anon");
        map.put("/company/register", "anon");

        //开放登录功能
        map.put("/toLogin", "anon");
        map.put("/", "anon");

        //开放注册时，检测账号名是否被实用
        map.put("/student/check", "anon");
        map.put("/teacher/check", "anon");
        map.put("/admin/check", "anon");
        map.put("/company/check", "anon");
        map.put("/error/**", "anon");

        //设置所有请求均要对应角色权限
        map.put("/student/**", "authc,roles[student]");
        map.put("/teacher/**", "authc,roles[teacher]");
        map.put("/admin/**", "authc,roles[admin]");
        map.put("/company/**", "authc,roles[company]");

        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/error/403");
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);

        /*注入cookie管理器*/
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    //自定义Realm
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    //配置ShiroDialect，用于thymeleaf和shiro便签配合使用
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    //cookie管理对象
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端页面的checkbox的name=remremberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //cookie的有效时间为1小时，单位秒
        simpleCookie.setMaxAge(3600);
        return simpleCookie;
    }

}
