<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增学生</title>
    <style type="text/css">
        h1{
            text-align: center;
        }
        body{
            background-color: antiquewhite;
        }
        div{
            text-align: center;
        }
        #before{
            text-align: center;
        }
    </style>
</head>
<body>
    <%-- 头部 --%>
    <jsp:include page="top.jsp"/>

    <h1>新增学生</h1>
    <hr/>

    <div id="before">
        <a href="javascript: window.history.go(-1)">返回上一级</a>
    </div>
    </br>

    <form action="do_add_student.jsp" method="post" name="addForm">
        <div>
            <tr>
                <label>学号：</label>
                <input type="text" name="id" id="id" placeholder="学号" autofocus="autofocus">
            </tr>
        </div>
        <div>
            <tr>
                <label>姓名：</label></td>
                <input type="text" name="name" id="name" placeholder="姓名">
            </tr>
        </div>
        <div>
            <tr>
                <label>年龄：</label>
                <input type="text" name="age" id="age" placeholder="年龄">
            </tr>
        </div>
        <div>
            <tr>
                <label>性别：</label>
                <input type="text" name="sex" id="sex" placeholder="性别">
            </tr>
        </div>
        <div>
            <tr>
                <label>民族：</label>
                <input type="text" name="nation" id="nation" placeholder="民族">
            </tr>
        </div>
        <div>
            <tr>
                <label>省份：</label>
                <input type="text" name="place" id="place" placeholder="省份">
            </tr>
        </div>
        <div>
            <tr>
                <label>专业：</label>
                <input type="text" name="major" id="major" placeholder="专业">
            </tr>
        </div>
        <div>
            <tr>
                <label>班级：</label>
                <input type="text" name="classes" id="classes" placeholder="班级">
            </tr>
        </div>
        <div>
            <tr>
                <label>成绩：</label>
                <input type="text" name="grade" id="grade" placeholder="成绩">
            </tr>
        </div>

        <br>
        <div id="submit">
            <tr>
                <button type="submit" onclick="return checkForm()">添加</button>
                <button type="reset">重置</button>

            </tr>
        </div>
    </form>

    <script type="text/javascript">
        function checkForm() {
            var id = addForm.id.value;
            var name = addForm.name.value;

            // 学号和姓名不能为空
            if (id == "" || id == null) {
                alert("请输入学号");
                addForm.id.focus();
                return false;
            } else if (name == "" || name == null) {
                alert("请输入姓名");
                addForm.name.focus();
                return false;
            }
            alert('添加成功！');
            return true;
        }
    </script>

    <%-- 底部 --%>
    <jsp:include page="bottom.jsp"/>
</body>
</html>
