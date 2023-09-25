<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext.request.contextPath }/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="themes/default/easyui.css"/>
    <link rel="stylesheet" href="themes/icon.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#tb").datagrid({
                url: "selUser.action",
                title: "用户信息",
                columns: [[
                    {field: 'identity', title: '身份证号', width: 100},
                    {field: 'username', title: '用户名', width: 100},
                    {field: 'fullname', title: '全名', width: 100},
                    {field: 'sex', title: '性别', width: 100},
                    {field: 'address', title: '地址', width: 100},
                    {field: 'phone', title: '手机号', width: 100},
                    {field: 'position', title: '职位', width: 100},
                    {field: 'userlevel', title: '用户等级', width: 100},
                    {field: 'userpwd', hidden: true}
                ]],
                fitColumns: true,
                striped: true,
                toolbar: "#tool",
                singleSelect: true,
                fit: true,
                pagination: true,
                rownumbers: true
            });

            $("#js").click(function () {
                $("#tb").datagrid("load", {
                    url: "selUser.action",
                    identity: $("#identity").val(),
                    username: $("#username").val(),
                    phone: $("#phone").val()
                });
            });


            $("#xg").click(function () {
                var c = $("#tb").datagrid("getSelected");
                if (c == null) {
                    $.messager.alert("警告", "请先选择一行");
                } else {
                    $("#xgck").dialog({
                        title: '修改窗口',
                        width: 400,
                        height: 400,
                        closed: false,
                        cache: false,
                        modal: true
                    });
                    $("#xgck").form("load", c);
                }
            });

            $("#xiugai").click(function () {
                $("#xgck").form("submit", {
                    url: "updUser.action",
                    success: function (r) {
                        msg = "";
                        if (r > 0) {
                            msg = "修改成功";
                            $("#xgck").dialog("close");
                            $("#tb").datagrid("reload")
                        } else {
                            msg = "修改失败"
                        }
                        $.messager.show({
                            title: "友情提示",
                            msg: msg,
                            timeout: 2000
                        });
                    }
                });
            });

            $("#quxiao").click(function () {
                $("#xgck").dialog("close");
            });


            $("#sc").click(function () {
                var c = $("#tb").datagrid("getSelected");
                if (c == null) {
                    $.messager.alert("警告", "请先选择一行");
                } else {
                    $.messager.confirm("确认", "确定要删除[" + c.username + "]么？", function (r) {
                        if (r) {
                            $.get("delUser.action", {"identity": c.identity}, function (f) {
                                msg = "";
                                if (f > 0) {
                                    msg = "删除成功";
                                    $("#tb").datagrid("reload")
                                } else {
                                    msg = "删除失败"
                                }
                                $.messager.show({
                                    title: "友情提示",
                                    msg: msg,
                                    timeout: 2000
                                });
                            });
                        }
                    });
                }
            });


        });
    </script>
</head>
<body>


<div id="tb"></div>
<div id="tool">
    身份证号<input class="easyui-textbox" id="identity" name="identity"/>
    用户名<input class="easyui-textbox" id="username" name="username"/>
    手机号<input class="easyui-textbox" id="phone" name="phone"/>
    <a id="js" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">检索</a>
    <a id="xg" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
    <a id="sc" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">删除</a>
</div>
<div align="center">
    <form id="xgck" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="username"></td>
            </tr>
            <tr>
                <td>身份证号:</td>
                <td><input class="easyui-textbox" data-options="readonly:true" name="identity"></td>
            </tr>
            <tr>
                <td>全名</td>
                <td><input class="easyui-textbox" data-options="required:true" name="fullname"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="radio" name="sex" data-options="required:true" value="男" checked="checked">男<input
                        type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="address"></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="phone"></td>
            </tr>
            <tr>
                <td>职位:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="position"></td>
            </tr>
            <tr>
                <td>用户等级:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="userlevel"></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input class="easyui-passwordbox" data-options="required:true" name="userpwd"></td>
            </tr>
        </table>
        <a id="xiugai" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
        <a id="quxiao" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
    </form>
</div>
</body>
</html>