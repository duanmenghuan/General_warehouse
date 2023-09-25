<%@ page import="com.sjsq.service.StudentService" %>
<%@ page import="com.sjsq.service.impl.StudentServiceImpl" %>
<%@ page import="com.sjsq.vo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    //获取main.jsp页面的id
    Integer id = Integer.parseInt(request.getParameter("id"));

    // 删除学生
    StudentService studentService = new StudentServiceImpl();
    Student student = new Student();
    student = studentService.selectStudent(id);
    System.out.println("删除的学生信息：");
    System.out.println(student);

    boolean flag=studentService.deleteStudent(id);

    if(flag){
        response.sendRedirect("main.jsp");
    }else{
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
