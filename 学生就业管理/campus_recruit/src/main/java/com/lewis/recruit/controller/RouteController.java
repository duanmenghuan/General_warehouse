package com.lewis.recruit.controller;

import com.lewis.recruit.pojo.*;
import com.lewis.recruit.realm.MyToken;
import com.lewis.recruit.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class RouteController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private AdminServiceImpl adminService;

    protected static Logger logger = LoggerFactory.getLogger(RouteController.class);

    //跳转登录页面，默认为登录页面
    @RequestMapping({"/","/toLogin"})
    public String toLogin(){
        return "login";
    }

    //跳转到注册页面
    @RequestMapping("/toRegister")
    public String toRegister(Map<String,Object> map){
        return "register";
    }

    //登录操作
    @RequestMapping("/login")
    public String login(String username, String password,String loginType, Model model){
        logger.info("进行登录操作，登录类型为：" + loginType);
        //获取权限操作对象，利用这个对象完成登录操作
        Subject subject = SecurityUtils.getSubject();
        //判断当前用户是否已经进行认证
        if (!subject.isAuthenticated()){
            MyToken token = null;
            //判断登录用户的类型，然后调用不同的对象查询不同的数据库
            if (loginType.equals("student")){
                Student student = studentService.findStudentByStudentAccount(username);
                if (student != null){
                    //获取盐值
                    String salt = student.getStudentSalt();
                    //进行加密
                    Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
                    //创建用户认证的身份令牌
                    token = new MyToken(username, md5Hash.toHex(), loginType);
                }
            }
            if (loginType.equals("teacher")){
                Teacher teacher = teacherService.findTeacherByTeacherAccount(username);
                System.out.println(teacher);
                if (teacher != null){
                    //获取盐值
                    String salt = teacher.getTeacherSalt();
                    //进行加密
                    Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
                    //创建用户认证的身份令牌
                    token = new MyToken(username, md5Hash.toHex(), loginType);
                }
            }
            if (loginType.equals("company")){
                Company company = companyService.findCompanyByCompanyAccount(username);
                if (company != null){
                    //获取盐值
                    String salt = company.getCompanySalt();
                    //进行加密
                    Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
                    //创建用户认证的身份令牌
                    token = new MyToken(username, md5Hash.toHex(), loginType);
                }
            }
            if (loginType.equals("admin")){
                Admin admin = adminService.findAdminByAdminAccount(username);
                if (admin != null){
                    //获取盐值
                    String salt = admin.getAdminSalt();
                    //进行加密
                    Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
                    //创建用户认证的身份令牌
                    token = new MyToken(username, md5Hash.toHex(), loginType);
                }
            }

            try {
                //指定登录，使用Realm方法的认证方法
                subject.login(token);
                //根据登录类型，跳转响应的首页
                switch (loginType){
                    case "student":
                        logger.info("学生用户"+username+"进行登录");
                        return "redirect:/student/toIndex";
                    case "teacher":
                        logger.info("老师用户"+username+"进行登录");
                        return "redirect:/teacher/toIndex";
                    case "company":
                        logger.info("企业用户"+username+"进行登录");
                        return "redirect:/company/toIndex";
                    case "admin":
                        logger.info("管理员"+username+"进行登录");
                        return "redirect:/admin/toIndex";
                    default:
                        return "login";
                }
            }catch (UnknownAccountException e){
                e.printStackTrace();
                model.addAttribute("msg","用户名错误");
                return "login";
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                model.addAttribute("msg","用户名错误");
                return "login";
            } catch (IncorrectCredentialsException e){
                e.printStackTrace();
                model.addAttribute("msg","密码错误");
                return "login";
            } catch (LockedAccountException e){
                e.printStackTrace();
                model.addAttribute("msg","账号被锁定");
                return "login";
            }catch (AuthenticationException e){
                e.printStackTrace();
                model.addAttribute("msg","认证失败");
                return "login";
            }
        }
        return "login";
    }

    //登出操作
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        //登出当前用户，清空shiro当前登录用户的缓存
        subject.logout();
        return "redirect:/";
    }

    @RequestMapping("/error/400")
    public String er400( ){
        return "/error/400";
    }

    @RequestMapping("/error/404")
    public String er404( ){
        return "/error/404";
    }

    @RequestMapping("/error/403")
    public String er403( ){
        return "/error/403";
    }

    @RequestMapping("/error/500")
    public String er500( ){
        return "/error/500";
    }
}
