<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">用户详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>用户名：<b>${vo.username}</b></td>
            </tr>
            <tr>
                <td>姓名：<b>${vo.realName}</b></td>
            </tr>
            <tr>
                <td>性别：
                    <b>${vo.userSex}</b>
                </td>
            </tr>
            <tr>
                <td>手机：<b>${vo.userPhone}</b></td>
            </tr>
            <tr>
                <td>备注：<b>${vo.userText}</b></td>
            </tr>
            <tr>
                <td>类型：
                    <b>${vo.userType}</b>
                </td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
