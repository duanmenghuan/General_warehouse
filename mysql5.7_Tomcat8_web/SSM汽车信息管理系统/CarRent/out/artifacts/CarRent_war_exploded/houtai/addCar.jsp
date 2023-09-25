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
                    url: "addCar.action",
                    success: function (r) {
                        msg = "";
                        if (r > 0) {
                            msg = "添加成功";
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
    <form id="fm" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>车牌号:</td>
                <td><input id="s" class="easyui-textbox" data-options="required:true" name="carnumber">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>型号:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="cartype"></td>
            </tr>
            <tr>
                <td>颜色:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="color"></td>
                <td>租赁价格:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="rentprice"></td>
            </tr>
            <tr>
                <td>押金:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="deposit"></td>
                <td>是否出租:</td>
                <td>
                    <select name="isrenting">
                        <option value="未出租">未出租</option>
                        <option value="已出租">已出租</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>座位数:</td>
                <td><input class="easyui-textbox" data-options="required:true" name="seat"></td>
                <td>车图:</td>
                <td><input type="file" name="photo"></td>
            </tr>
        </table>
        <br/>
        <div align="left" style="background-color: #3fc;"><font size="4">简介</font></div>
        <br/>
        <textarea rows="4" cols="170" name="cardesc"></textarea>
    </form>
    <a id="tj" class="easyui-linkbutton" href="javascript:void(0)">确定</a>
    <a id="cz" class="easyui-linkbutton" href="javascript:void(0)">重置</a>
</div>
</body>
</html>