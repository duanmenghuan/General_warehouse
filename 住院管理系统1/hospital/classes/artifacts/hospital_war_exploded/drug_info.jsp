<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>药品详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">药品详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>药品名称：<b>${vo.name}</b></td>
            </tr>
            <tr>
                <td>供应商：<b>${vo.supplier}</b></td>
            </tr>
            <tr>
                <td>出厂时间：
                    <b>${vo.initialtime}</b>
                </td>
            </tr>
            <tr>
                <td>保质期：<b>${vo.expirationdate}</b></td>
            </tr>
            <tr>
                <td>药效：<b>${vo.pesticideeffect}</b></td>
            </tr>
            <tr>
                <td>备注：
                    <b>${vo.remark}</b>
                </td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
