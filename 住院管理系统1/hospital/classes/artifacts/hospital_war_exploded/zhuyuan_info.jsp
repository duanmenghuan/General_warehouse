<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>住院详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">住院详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>姓名：<b>${vo.zhuyuanName}</b></td>
            </tr>
            <tr>
                <td>住院号：<b>${vo.zhuyuanHao}</b></td>
            </tr>
            <tr>
                <td>性别：
                    <b>${vo.zhuyuanSex}</b>
                </td>
            </tr>
            <tr>
                <td>科室：<b>${vo.zhuyuanKeshi}</b></td>
            </tr>
            <tr>
                <td>病房号：<b>${vo.zhuyuanBingfanghao}</b></td>
            </tr>
            <tr>
                <td>入院时间：<b>${vo.zhuyuanTime}</b></td>
            </tr>
            <tr>
                <td>护理医师：<b>${vo.zhuyuanYishi}</b></td>
            </tr>
            <tr>
                <td>备注：<b>${vo.zhuyuanText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
