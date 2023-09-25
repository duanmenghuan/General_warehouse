<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加住院</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">添加住院</a>
        <br>
        <br>
    </div>
    <br>
    <form action="zhuyuanAdd" method="post" onsubmit="return check()">
        <table class="index-content-table-add">
            <tr>
                <td width="12%">姓名：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanName" name="zhuyuanName" value=""/></td>
            </tr>
            <tr>
                <td width="12%">住院号：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanHao" name="zhuyuanHao" value=""/></td>
            </tr>
            <tr>
                <td width="12%">性别：</td>
                <td>
                        <input name="zhuyuanSex" type="radio" value="男" checked="checked"/>&nbsp;&nbsp;&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="zhuyuanSex" type="radio" value="女"/>&nbsp;&nbsp;&nbsp;女&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">科室：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanKeshi" name="zhuyuanKeshi" value=""/></td>
            </tr>
            <tr>
                <td width="12%">病房号：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanBingfanghao" name="zhuyuanBingfanghao" value=""/></td>
            </tr>
            <tr>
                <td width="12%">入院时间：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanTime" name="zhuyuanTime" value=""/></td>
            </tr>
            <tr>
                <td width="12%">护理医师：</td><td><input class="index-content-table-td-add" type="text" id="zhuyuanYishi" name="zhuyuanYishi" value=""/></td>
            </tr>
            <tr>
                    <td width="12%">备注：</td><td><textarea id="zhuyuanText" name="zhuyuanText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......"></textarea></td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-rect btn-grad btn-primary btn-sm">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">取消</button>
    </form>
</div>

</body>
<script type="text/javascript">
    //提交之前进行检查，如果return false，则不允许提交
    function check() {
        //根据ID获取值
        if (document.getElementById("zhuyuanName").value.trim().length == 0) {
            alert("姓名不能为空!");
            return false;
        }
        if (document.getElementById("zhuyuanHao").value.trim().length == 0) {
            alert("住院号不能为空!");
            return false;
        }
        if (document.getElementById("zhuyuanKeshi").value.trim().length == 0) {
            alert("科室不能为空!");
            return false;
        }
        if (document.getElementById("zhuyuanBingfanghao").value.trim().length == 0) {
            alert("病房号不能为空!");
            return false;
        }
        if (document.getElementById("zhuyuanTime").value.trim().length == 0) {
            alert("入院时间不能为空!");
            return false;
        }
        if (document.getElementById("zhuyuanYishi").value.trim().length == 0) {
            alert("护理医师不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
