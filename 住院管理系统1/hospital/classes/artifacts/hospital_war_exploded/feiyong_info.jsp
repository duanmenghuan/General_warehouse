<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>费用详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">费用详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>账单号：<b>${vo.feiyongNo}</b></td>
            </tr>
            <tr>
                <td>住院号：<b>${vo.feiyongZhuyuanhao}</b></td>
            </tr>
            <tr>
                <td>付款人：<b>${vo.feiyongName}</b></td>
            </tr>
            <tr>
                <td>金额：<b>${vo.feiyongJine}</b></td>
            </tr>
            <tr>
                <td>缴费方式：
                    <b>${vo.feiyongJiaofeifangshi}</b>
                </td>
            </tr>
            <tr>
                <td>缴费时间：<b>${vo.feiyongJiaofeishijian}</b></td>
            </tr>
            <tr>
                <td>备注：<b>${vo.feiyongText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-rect btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
