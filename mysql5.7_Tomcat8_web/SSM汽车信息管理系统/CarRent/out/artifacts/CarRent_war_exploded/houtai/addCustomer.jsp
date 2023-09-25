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
    <script type="text/javascript">

        $(function () {
            $("#tj").click(function () {
                $("#fm").form("submit", {
                    url: "addCustomer.action",
                    success: function (r) {
                        msg = "";
                        if (r > 0) {
                            msg = $("#s").val() + "添加成功";
                        } else {
                            msg = "添加失败";
                        }
                        $.messager.show({
                            title: "友情提示",
                            msg: msg,
                            timeout: 2000
                        });
                    }
                });
            })


            $("#cz").click(function () {
                $("#fm").form("reset");
            });
        });

    </script>
</head>
<body>
<div class="easyui-panel" data-options="title:'添加客户'" align="center">
    <form id="fm" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input id="s" class="easyui-textbox" data-options="required:true" name="custname">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>身份证号:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="identity"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input type="radio" name="sex" value="男" checked="checked">男<input type="radio" name="sex"
                                                                                       value="女">女
                </td>
                <td>地址:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="address"></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="phone"></td>
                <td>职位:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="career"></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input class="easyui-passwordbox" data-options="required:true" name="custpwd"></td>
            </tr>
        </table>
    </form>
    <a id="tj" class="easyui-linkbutton" href="javascript:void(0)">确定</a>
    <a id="cz" class="easyui-linkbutton" href="javascript:void(0)">重置</a>
</div>
</body>
</html>