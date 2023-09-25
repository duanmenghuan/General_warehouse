<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作失败</title>
    <style type="text/css">
        body{
            text-align: center;
        }
        h1{

        }
        #before{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>操作失败</h1>
    操作出错，请回到上一个页面！
    <div id="before">
        <a href="javascript: window.history.go(-1)">返回上一级</a>
    </div>
    </br>
</body>
</html>
