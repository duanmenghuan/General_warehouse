package com.sjsq.controller;

import com.sjsq.pojo.Users;
import com.sjsq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //登录功能
    @RequestMapping("/login")
    public String Login(String auth, String userpwd, HttpSession session) {
        Users users = userService.login(auth, userpwd);
        if (users == null) {
            session.setAttribute("msg", "用户名或者密码错误");
            return "login.jsp";
        } else {
            session.setAttribute("users", users);
            session.setAttribute("username", users.getUsername());
            return "houtai/main.jsp";
        }
    }

    //退出功能
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.invalidate();
        return "login.jsp";
    }

    //添加用户功能
    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(Users u) {
        return userService.addUser(u);
    }

    //查询所有用户功能
    @RequestMapping("/selUser")
    @ResponseBody
    public List<Users> selUser(Users u) {
        return userService.selUser(u);
    }

    //修改用户信息
    @RequestMapping("/updUser")
    @ResponseBody
    public int updUser(Users u) {
        return userService.updUser(u);
    }

    //删除用户
    @RequestMapping("/delUser")
    @ResponseBody
    public int delUser(String identity) {
        return userService.delUser(identity);
    }
}
