<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">用户管理</a>
        <br>
        <br>
    </div>
    <br>
    <div class="index-content-operation">
        <button class="btn btn-rect btn-grad btn-primary btn-sm" <c:if test="${loginUser.userType != '管理员'}">disabled="disabled" title="没有权限！！！"</c:if> onclick="window.location.href='user_add.jsp'">添加</button>
        <div class="index-content-operation-search"><input id="search_keyword" placeholder="姓名" type="text" name="search_keyword"/><input type="hidden" id="searchColumn" name="searchColumn" value="real_name"/><button class="btn btn-rect btn-grad btn-danger btn-sm" onclick="searchList()">搜索</button></div>
    </div>
    <br>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr class="index-content-table-th">
            <th>用户名</th>
            <th>姓名</th>
            <th>性别</th>
            <th>手机</th>
            <th>备注</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="vo">
            <tr class="index-content-table-td">
                <td>${vo.username}</td>
                <td>${vo.realName}</td>
                <td>${vo.userSex}</td>
                <td>${vo.userPhone}</td>
                <td title="${vo.userText}">
                <c:choose>
                    <c:when test="${fn:length(vo.userText) > 19}">
                        <c:out value="${fn:substring(vo.userText, 0, 19)}..."/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${vo.userText}"/>
                    </c:otherwise>
                </c:choose>
                </td>
                <td>${vo.userType}</td>
                <td>
                    <button class="btn btn-rect btn-grad btn-info btn-sm" style="padding: 0px 1px;" onclick="window.location.href='userGet?id=${vo.id}'">详情</button>&nbsp;
                    <button class="btn btn-rect btn-grad btn-info btn-sm" style="padding: 0px 1px;"
                            <c:if test="${loginUser.userType != '管理员' && vo.id != loginUser.id}">disabled="disabled" title="没有权限！！！"</c:if>
                    onclick="window.location.href='userEditPre?id=${vo.id}'">编辑</button>&nbsp;
                    <button class="btn btn-rect btn-grad btn-danger btn-sm" style="padding: 0px 1px;" <c:if test="${loginUser.userType != '管理员'}">disabled="disabled" title="没有权限！！！"</c:if> onclick="if(window.confirm('将要删除：${vo.realName}？'))window.location.href='userDelete?id=${vo.id}'">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="float: right;padding-right: 10px;color: #515151;"><jsp:include page="split.jsp"/></div>
</div>
</body>
<script>
    function searchList() {
        window.location.href = "userList?searchColumn="+document.getElementById("searchColumn").value+"&keyword=" + document.getElementById("search_keyword").value;
    }
</script>
</html>
