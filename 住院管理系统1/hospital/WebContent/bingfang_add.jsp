<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加病房</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">添加病房</a>
        <br>
        <br>
    </div>
    <br>
    <form action="bingfangAdd" method="post" onsubmit="return check()">
        <table class="index-content-table-add">
            <tr>
                <td width="12%">病房号：</td><td><input class="index-content-table-td-add" type="text" id="bingfangNo" name="bingfangNo" value=""/></td>
            </tr>
            <tr>
                <td width="12%">科室：</td><td><input class="index-content-table-td-add" type="text" id="bingfangName" name="bingfangName" value=""/></td>
            </tr>
            <tr>
                <td width="12%">类型：</td>
                <td>
                        <input name="bingfangType" type="radio" value="普通" checked="checked"/>&nbsp;&nbsp;&nbsp;普通&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="bingfangType" type="radio" value="重症"/>&nbsp;&nbsp;&nbsp;重症&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">容量：</td><td><input class="index-content-table-td-add" type="text" id="bingfangCount" name="bingfangCount" value=""/></td>
            </tr>
            <tr>
                <td width="12%">价格：</td><td><input class="index-content-table-td-add" type="text" id="bingfangPrice" name="bingfangPrice" value=""/></td>
            </tr>
            <tr>
                    <td width="12%">详情：</td><td><textarea id="bingfangText" name="bingfangText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......"></textarea></td>
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
        if (document.getElementById("bingfangNo").value.trim().length == 0) {
            alert("病房号不能为空!");
            return false;
        }
        if (document.getElementById("bingfangName").value.trim().length == 0) {
            alert("科室不能为空!");
            return false;
        }
        if (document.getElementById("bingfangCount").value.trim().length == 0) {
            alert("容量不能为空!");
            return false;
        }
        if (document.getElementById("bingfangPrice").value.trim().length == 0) {
            alert("价格不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
