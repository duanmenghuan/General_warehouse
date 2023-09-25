<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="index-nav">
    <div class="index-nav-frame clearfix">
        <div class="nav-line"></div>
        <div class="nav-small" tabindex="-1">
            <div class="nav-small-focus" tabindex="-1">
            </div>
            <img src="img/icon.png"/>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="userList">用户管理</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="bingfangList">病房管理</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="feiyongList">费用管理</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="zhuyuanList">住院管理</a>
        </div>
<%--        <div class="index-nav-frame-line" tabindex="-1">--%>
<%--            <a class="btn btn-rect btn-grad btn-danger btn-sm" href="noticeList">员工管理</a>--%>
<%--        </div>--%>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="drugList">药品管理</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-rect btn-grad btn-danger btn-sm btn-green" href="noticeList">公告管理</a>
        </div>

        <div class="index-nav-frame-line" style="float: right;" tabindex="-1">
            <a href="authLogout" class="btn btn-rect btn-grad btn-warning btn-sm btn-red">退出</a>
        </div>
        <div class="index-nav-frame-line" style="float: right;color: #000000;width: 200px">
            欢迎：<a>${loginUser.username}</a>
        </div>
    </div>
</div>
</div>
</div>
</body>
<style>
    .btn-green {
        background-color: green;
    }
</style>
</html>
