<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.sjsq.service.AdminService"%>
<%@ page import="com.sjsq.service.impl.AdminServiceImpl"%>
<%@ page import="com.sjsq.vo.Admin"%>
<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <style type="text/css">
        h1{
            text-align: center;
        }
        h4{
            text-align: center;color: red;
        }
        body{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
    <h1>用户登录</h1>
    <hr>
    <%
        // 设置接收的编码为UTF-8
        request.setCharacterEncoding("utf-8");


        // 获取前端传过来的字符串
        String username = request.getParameter("username");
        String password=request.getParameter("password");

        // 定义接受的对象
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);


        // 把数据库里面的Admin获取出来
        AdminService adminService = new AdminServiceImpl();
        // 注意数据的admin账号密码不能重复
        Admin adminLogin = adminService.login(admin);

        System.out.println("显示登录用户信息：");
        System.out.println(adminLogin);

        // 设置session
        session.setAttribute("admin",adminLogin);

        // 判断adminLogin是否为空
        if(!(adminLogin==null)){
            // 成功之后重定向到主页面
            response.sendRedirect("main.jsp");
        } else{
            // 失败之后重定向到失败页面
            response.sendRedirect("fail.jsp");
        }
    %>
</body>
</html>
