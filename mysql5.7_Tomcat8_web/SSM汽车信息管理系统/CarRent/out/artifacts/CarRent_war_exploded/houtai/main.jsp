<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath }/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href="themes/default/easyui.css"/>
    <link rel="stylesheet" href="themes/icon.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <style type="text/css">
        iframe {
            width: 100%;
            height: 98%;
            border: none;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            //导航栏
            $(".easyui-tree").tree({
                onClick: function (node) {
                    if (node.attributes.url == null) {
                        return;
                    }
                    var s = $("#tabMenu").tabs('exists', node.text);
                    if (s) {
                        $("#tabMenu").tabs('select', node.text);
                    } else {
                        $("#tabMenu").tabs('add', {
                            "title": node.text,
                            closable: true,
                            content: "<iframe src='" + node.attributes.url + "'/>"
                        });
                    }
                }
            });
            //安全退出
            $("#tuichu").click(function () {
                $.messager.confirm("确定窗口", "确定要退出么？", function (r) {
                    if (r) {
                        window.location.href = "quit.action";
                    }
                });
            });
        });
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',height:'60px',split:true"
     style="background: url('../img/a.png') center;">
    <font color="white" size="3" style="position: relative; left:5px; top: 15px">汽车信息管理系统</font>
    <span style="float: right; margin-top: 25px; margin-right: 20px">
		<font color="white">欢迎<%=session.getAttribute("username")%>登录</font>
			<a id="tuichu" href="java:script(0)"><font color="white">退出登录</font></a>
		</span>
</div>
<div data-options="region:'center',split:true,closable:true">
    <div id="tabMenu" class="easyui-tabs" data-options="fit:true,closable:true">
        <div title="首页">
            <img src="img/c.jpg" width=100% height=451px/>
        </div>
    </div>
</div>
<div class="easyui-accordion" data-options="region:'west',title:'汽车信息管理系统',split:true,width:'200px'">
    <c:forEach items="${sessionScope.users.menus}" var="menu">
        <div title="${menu.menuname}">
            <ul class="easyui-tree"
                data-options="lines:true,animate:true">

                <c:forEach items="${menu.menus}" var="m">
                    <li data-options="attributes:{'url':'${m.connurl }'}"><span>${m.menuname}</span></li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
</div>
<div data-options="region:'south',split:true,height:'50px'">
    <center>
        <font size="2">QQ:3079118617 &copy;2022-2022 XXXX版权所有</font>
    </center>
</div>
</body>
</html>