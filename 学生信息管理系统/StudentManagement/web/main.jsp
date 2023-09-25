<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.sjsq.service.StudentService" %>
<%@ page import="com.sjsq.service.impl.StudentServiceImpl" %>
<%@ page import="com.sjsq.vo.Student" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查看学生</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        body {
            background-color: antiquewhite;
        }

        th, td {
            width: 70px;
            height: 35px;
            text-align: center;
        }

        #before {
            text-align: center;
        }

    </style>
</head>
<body>
    <%-- 头部 --%>
    <jsp:include page="top.jsp"/>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    StudentService studentService = new StudentServiceImpl();
    // 定义一个学生类
    Student student = new Student();

    // 获取上一个页面传过来的值
    if(request.getParameter("id")!=null && request.getParameter("id")!=""){
        Integer id = Integer.parseInt(request.getParameter("id"));
        student.setId(id);
    }

    // 获取所有学生
    List<Student> studentList = studentService.selectAll(student);
%>
<h1>学生列表</h1>
<hr/>
<div id="before">
    <form action="main.jsp" method="post">
        请输入姓名：<input type="text" name="id" placeholder="输入学号搜索">
        <input type="submit" value="查询" />
    </form>
</div>
<br>
<table align="center" cellspacing="0" align="center">
    <tr bgcolor="#5f9ea0">
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>民族</th>
        <th>省份</th>
        <th>专业</th>
        <th>班级</th>
        <th>成绩</th>
        <th colspan="2">操作</th>
    </tr>
    <%
        for (int i = 0;i<studentList.size();i++){
            Student s =studentList.get(i);
    %>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getSex()%></td>
        <td><%=s.getNation()%></td>
        <td><%=s.getPlace()%></td>
        <td><%=s.getMajor()%></td>
        <td><%=s.getClasses()%></td>
        <td><%=s.getgrade()%></td>
        <td>
            <a href="update_student.jsp?id=<%=s.getId()%>">修改</a>
            <a href="delete_student.jsp?id=<%=s.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
<table align="center">
    <tr>
        <td><a href="add_student.jsp">新增学生</a></td>
    </tr>
</table>

</body>
<%-- 底部 --%>
<jsp:include page="bottom.jsp"/>
</html>
