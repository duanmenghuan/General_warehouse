<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/jquery.js" type="text/javascript" charset="UTF-8"></script>
    <style>
        body {
            background: url(img/bg.png) repeat-x;
            min-height: 600px;
            position: relative;

        }

        * {
            font-family: "微软雅黑";
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 14px;
            color: white;
        }

        html, body {
            height: 100%;
            width: 100%;;
        }

        a {
            text-decoration: none;
            color: rgba(255, 255, 255);
            cursor: pointer;
        }

        .name, .pwd {
            width: 310px;
            height: 44px;
            line-height: 44px;
            padding-left: 15px;
            outline: none;
            border-radius: 20px;
            background-color: #0A3C78;
            border: 1px solid #329BE0;
        }

        .name:hover, .pwd:hover, .name:focus, .pwd:focus {

            background-color: #052b64;
        }

        #login {

            background: #3fb9ff;
            font-size: 18px;
            width: 329px;
            height: 44px;
            outline: none;
            color: white;
            background: -webkit-linear-gradient(#3fb9ff, #099be7, #229de3);
            background: -o-linear-gradient(#3fb9ff, #099be7, #229de3);
            background: -moz-linear-gradient(#3fb9ff, #099be7, #229de3);
            background: linear-gradient(#3fb9ff, #099be7, #229de3);
            border-radius: 20px;
        }

        #login:hover {
            background: -webkit-linear-gradient(#229de3, #099be7, #3fb9ff);
            background: -o-linear-gradient(#229de3, #099be7, #3fb9ff);
            background: -moz-linear-gradient(#229de3, #099be7, #3fb9ff);
            background: linear-gradient(#229de3, #099be7, #3fb9ff);
        }

        #head {
            height: 50px;
            padding-top: 25px;
            margin-left: 14px;
        }

        #middle {
            margin-top: 100px;
            /* height:600px; */

        }

        #footer {

            text-align: center;
            bottom: 15px;
            position: absolute;
            width: 100%;
        }

        #footer a {
            color: black;
        }

        #middle li {
            list-style-type: none;
            margin-top: 15px;
        }

        #children li {
            list-style-type: none;
            height: 42px;
            line-height: 42px;
            border-bottom: 1px double rgb(5, 33, 113);

        }

        #children li a {
            color: rgba(255, 255, 255);
        }

        #children li:hover {
            background-color: #354d8d;

        }

        @-webkit-keyframes cloud {
            0% {
                background-position: top left
            }
            100% {
                background-position: top right
            }
        }

        @-moz-keyframes clouds {
            0% {
                background-position: top left
            }
            100% {
                background-position: top right
            }
        }

        #err {
            display: none;
            color: red;
        }


    </style>
</head>
<body>
<div id="sky"></div>
<div id="head"></div>
<div id="middle">
    <form action="login.action" method="get">
        <ul style="text-align: center;">
            <li style="font-size: 48px">汽车信息管理系统</li>

            <li><input class="name" name="auth" placeholder="请输入用户名"></li>
            <li><input type="password" name="userpwd" class="pwd" placeholder="请输入密码"></li>

            <li>
                <button id="login">立即登录</button>
            </li>
            <li><span id="err" style="display: inline-block;"><span>${msg}</span></span></li>


        </ul>
    </form>
</div>
<div id="footer">

    <a>QQ:3079118617 &nbsp &nbsp|&nbsp &nbsp</a>


    <a>Copyright © 2022-2022 XXXX版权所有</a>
</div>
<div id="cloud"></div>


</body>
</html>