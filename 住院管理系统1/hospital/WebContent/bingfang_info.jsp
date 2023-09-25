<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>病房详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">病房详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>病房号：<b>${vo.bingfangNo}</b></td>
            </tr>
            <tr>
                <td>科室：<b>${vo.bingfangName}</b></td>
            </tr>
            <tr>
                <td>类型：
                    <b>${vo.bingfangType}</b>
                </td>
            </tr>
            <tr>
                <td>容量：<b>${vo.bingfangCount}</b></td>
            </tr>
            <tr>
                <td>价格：<b>${vo.bingfangPrice}</b></td>
            </tr>
            <tr>
                <td>详情：<b>${vo.bingfangText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
