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
                url: "selAllCar.action",
                title: "汽车信息",
                columns: [[
                    {field: 'carnumber', title: '车牌号', width: 100},
                    {field: 'cartype', title: '型号', width: 100},
                    {field: 'color', title: '颜色', width: 100},
                    {field: 'rentprice', title: '租金', width: 100},
                    {field: 'deposit', title: '押金', width: 100},
                    {field: 'isrenting', title: '是否出租中', width: 100},
                    {field: 'seat', title: '几座车', width: 100},
                    {field: 'cardesc', title: '描述', width: 100},
                    {field: 'carimg', hidden: true}
                ]],
                fitColumns: true,
                striped: true,
                toolbar: "#tool",
                singleSelect: true,
                fit: true,
                pagination: true,
                rownumbers: true,
                pageList: [2, 5, 10, 20]
            });


            $("#js").click(function () {
                $("#tb").datagrid("load", {
                    url: "selAllCar.action",
                    seat: $("#seat").val(),
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
                        height: 350,
                        closed: false,
                        cache: false,
                        modal: true
                    });
                    $("#xgck").form("load", c);
                }
            });

            $("#xiugai").click(function () {
                $("#xgck").form("submit", {
                    url: "updCar.action",
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
                    $.messager.confirm("确认", "确定要删除[" + c.carnumber + "]么？", function (r) {
                        if (r) {
                            $.get("delCar.action", {"carnumber": c.carnumber}, function (f) {
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
<table id="tb"></table>

<div id="tool">
    几座车<input class="easyui-textbox" id="seat" name="seat"/>
    <a id="js" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">检索</a>
    <a id="xg" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
    <a id="sc" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">删除</a>
</div>

<div align="center">
    <form id="xgck" method="post">
        <table>
            <tr>
                <td>车牌号:</td>
                <td><input class="easyui-textbox" data-options="readonly:true" name="carnumber"></td>
            </tr>
            <tr>
                <td>车型:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="cartype"></td>
            </tr>
            <tr>
                <td>颜色:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="color"></td>
            </tr>
            <tr>
                <td>出租价格:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="rentprice"></td>
            </tr>
            <tr>
                <td>押金:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="deposit"></td>
            </tr>
            <tr>
                <td>是否出租中:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="isrenting"></td>
            </tr>
            <tr>
                <td>几座位:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="seat"></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="cardesc"></td>
            </tr>
        </table>
        <a id="xiugai" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
        <a id="quxiao" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
    </form>
</div>

</body>
</html>