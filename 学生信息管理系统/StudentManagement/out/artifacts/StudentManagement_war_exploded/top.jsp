<%@ page import="com.sjsq.vo.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #head{
            background: #eeeeee;height: 0px;
        }
    </style>
</head>
<body>

<%--头部信息--%>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    // 获取session
    Admin admin =(Admin) session.getAttribute("admin");
    System.out.println("登录用户："+admin);
    if(admin == null){
        response.sendRedirect("login.jsp");
    }else {
%>
<div id="head">
    <table width="100%">
        <td id="headWelLink">欢迎您：<%=admin.getUsername()%></td>
        <td align="right" id="headLink">
            <a href="logout.jsp">安全退出</a>
        </td>
    </table>
</div>
<%
    }
%>

</body>
</html>
