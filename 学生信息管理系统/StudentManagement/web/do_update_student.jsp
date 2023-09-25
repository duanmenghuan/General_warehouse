<%@ page import="com.sjsq.vo.Student" %>
<%@ page import="com.sjsq.service.impl.StudentServiceImpl" %>
<%@ page import="com.sjsq.service.StudentService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    //获取add_student.jsp页面提交的账号和密码,注意传过来的是字符串需要进行转化为对应的类型
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    Integer age = Integer.parseInt(request.getParameter("age"));
    String sex = request.getParameter("sex");
    String nation = request.getParameter("nation");
    String place = request.getParameter("place");
    String major = request.getParameter("major");
    String classes = request.getParameter("classes");
    String grade = request.getParameter("grade");


    // 将信息保存到实体类中
    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setAge(age);
    student.setSex(sex);
    student.setNation(nation);
    student.setPlace(place);
    student.setMajor(major);
    student.setClasses(classes);
    student.setgrade(grade);
    System.out.println("修改的学生信息");
    System.out.println(student);


    // 将数据写入到数据库
    StudentService studentService = new StudentServiceImpl();
    boolean flag = studentService.updateStudent(student);

    if(flag){
        response.sendRedirect("main.jsp");
    }else{
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
