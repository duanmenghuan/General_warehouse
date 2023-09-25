<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>公告管理</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">公告管理</a>
        <br>
        <br>
    </div>
    <br>
    <div class="index-content-operation">
        <button class="btn btn-rect btn-grad btn-primary btn-sm" <c:if test="${loginUser.userType != '管理员'}">disabled="disabled" title="没有权限！！！"</c:if> onclick="window.location.href='notice_add.jsp'">添加</button>
        <div class="index-content-operation-search"><input id="search_keyword" placeholder="标题" type="text" name="search_keyword"/><input type="hidden" id="searchColumn" name="searchColumn" value="notice_name"/><button class="btn btn-rect btn-grad btn-danger btn-sm" onclick="searchList()">搜索</button></div>
    </div>
    <br>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr class="index-content-table-th">
            <th>标题</th>
            <th>内容</th>
            <th>类型</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="vo">
            <tr class="index-content-table-td">
                <td>${vo.noticeName}</td>
                <td title="${vo.noticeText}">
                <c:choose>
                    <c:when test="${fn:length(vo.noticeText) > 19}">
                        <c:out value="${fn:substring(vo.noticeText, 0, 19)}..."/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${vo.noticeText}"/>
                    </c:otherwise>
                </c:choose>
                </td>
                <td>${vo.noticeType}</td>
                <td>${vo.createDate}</td>
                <td>
                    <button class="btn btn-rect btn-grad btn-info btn-sm" style="padding: 0px 1px;" onclick="window.location.href='noticeGet?id=${vo.id}'">详情</button>&nbsp;
                    <button class="btn btn-rect btn-grad btn-info btn-sm" style="padding: 0px 1px;"
                            <c:if test="${loginUser.userType != '管理员'}">disabled="disabled" title="没有权限！！！"</c:if>
                    onclick="window.location.href='noticeEditPre?id=${vo.id}'">编辑</button>&nbsp;
                    <button class="btn btn-rect btn-grad btn-danger btn-sm" style="padding: 0px 1px;" <c:if test="${loginUser.userType != '管理员'}">disabled="disabled" title="没有权限！！！"</c:if> onclick="if(window.confirm('将要删除：${vo.noticeName}？'))window.location.href='noticeDelete?id=${vo.id}'">删除</button>
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
        window.location.href = "noticeList?searchColumn="+document.getElementById("searchColumn").value+"&keyword=" + document.getElementById("search_keyword").value;
    }
</script>
</html>
