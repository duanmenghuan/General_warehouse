<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加药品</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">添加药品</a>
        <br>
        <br>
    </div>
    <br>
    <form action="drugAdd" method="post" onsubmit="return check()">
        <table class="index-content-table-add">
            <tr>
                <td width="12%">添加药品：</td><td><input class="index-content-table-td-add" type="text" id="name" name="name" value=""/></td>
            </tr>
            <tr>
                <td width="12%">供应商：</td><td><input class="index-content-table-td-add" type="text" id="supplier" name="supplier" value=""/></td>
            </tr>
            <tr>
                <td width="12%">出厂时间：</td><td><input class="index-content-table-td-add" type="text" id="initialtime" name="initialtime" value=""/></td>
            </tr>
            <tr>
                <td width="12%">保质期</：</td><td><input class="index-content-table-td-add" type="text" id="expirationdate" name="expirationdate" value=""/></td>
            </tr>
            <tr>
                <td width="12%">药效</：</td><td><input class="index-content-table-td-add" type="text" id="pesticideeffect" name="pesticideeffect" value=""/></td>
            </tr>
            <tr>
                <td width="12%">备注</：</td><td><input class="index-content-table-td-add" type="text" id="remark" name="remark" value=""/></td>
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
        if (document.getElementById("name").value.trim().length == 0) {
            alert("药品名称不能为空!");
            return false;
        }
        if (document.getElementById("supplier").value.trim().length == 0) {
            alert("供应商不能为空!");
            return false;
        }
        if (document.getElementById("expirationdate").value.trim().length == 0) {
            alert("保质期不能为空!");
            return false;
        }
        if (document.getElementById("pesticideeffect").value.trim().length == 0) {
            alert("药效不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
