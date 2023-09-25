package com.lewis.recruit.realm;


import com.lewis.recruit.pojo.Admin;
import com.lewis.recruit.pojo.Company;
import com.lewis.recruit.pojo.Student;
import com.lewis.recruit.pojo.Teacher;
import com.lewis.recruit.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private TeacherServiceImpl teacherService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object o = principalCollection.getPrimaryPrincipal();

        //定义一个hashset用来存放用户角色
        HashSet<String> roles = new HashSet<>();

        //根据当前用户所属的类，分配相应的权限角色
        if (o instanceof Student){
            roles.add("student");
        }
        if (o instanceof Teacher){
            roles.add("teacher");
        }
        if (o instanceof Admin){
            roles.add("student");
            roles.add("company");
            roles.add("admin");
            roles.add("teacher");
        }
        if (o instanceof Company){
            roles.add("company");
        }
        return new SimpleAuthorizationInfo(roles);
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        MyToken token = (MyToken) authenticationToken;
        String loginType = token.getLoginType();
        String username = token.getUsername();

        switch (loginType) {
            case "student":
                Student student = studentService.findStudentByStudentAccount(username);
                if (student == null)
                    return null;
                else
                    return new SimpleAuthenticationInfo(student, student.getStudentPassword(), getName());
            case "teacher":
                Teacher teacher = teacherService.findTeacherByTeacherAccount(username);
                if (teacher == null) {
                    return null;
                }
                return new SimpleAuthenticationInfo(teacher, teacher.getTeacherPassword(), getName());
            case "company":
                Company company = companyService.findCompanyByCompanyAccount(username);
                if (company == null) {
                    return null;
                }
                return new SimpleAuthenticationInfo(company, company.getCompanyPassword(), getName());
            case "admin":
                Admin admin = adminService.findAdminByAdminAccount(username);
                if (admin == null) {
                    return null;
                }
                return new SimpleAuthenticationInfo(admin, admin.getAdminPassword(), getName());
            default:
                return null;
        }
    }
}
