<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%--%>
<%--    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme() + "://" + request.getServerName() + ":"--%>
<%--            + request.getServerPort() + path + "/";--%>
<%--%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--    <base href="<%=basePath %>" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
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
        a{
            text-decoration: none;font-size: 20px;color: black;
        }
        a:hover{
            text-decoration: underline;font-size: 24px;color: red;
        }
    </style>
</head>
<body>
<form action="check_register.jsp" method="post">
    <h1>用户注册</h1>
    <hr/>
    <table align="center">
        <tr>
            <td>账号：</td>
            <td><input type="text" name="username" placeholder="请输入您的账号" autofocus="autofocus"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" placeholder="请输入您的密码"></td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="注册"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
