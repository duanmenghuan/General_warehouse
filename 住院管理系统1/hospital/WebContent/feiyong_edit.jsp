<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改费用</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">修改费用</a>
        <br>
        <br>
    </div>
    <br>
    <form action="feiyongEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">账单号：</td><td><input class="index-content-table-td-add" type="text" id="feiyongNo" name="feiyongNo" value="${vo.feiyongNo}"/></td>
            </tr>
            <tr>
                <td width="12%">住院号：</td><td><input class="index-content-table-td-add" type="text" id="feiyongZhuyuanhao" name="feiyongZhuyuanhao" value="${vo.feiyongZhuyuanhao}"/></td>
            </tr>
            <tr>
                <td width="12%">付款人：</td><td><input class="index-content-table-td-add" type="text" id="feiyongName" name="feiyongName" value="${vo.feiyongName}"/></td>
            </tr>
            <tr>
                <td width="12%">金额：</td><td><input class="index-content-table-td-add" type="text" id="feiyongJine" name="feiyongJine" value="${vo.feiyongJine}"/></td>
            </tr>
            <tr>
                <td width="12%">缴费方式：</td>
                <td>
                   <input name="feiyongJiaofeifangshi" type="radio" value="现金" ${vo.feiyongJiaofeifangshi=='现金'?'checked':''}/>&nbsp;&nbsp;&nbsp;现金&nbsp;&nbsp;&nbsp;&nbsp;
                   <input name="feiyongJiaofeifangshi" type="radio" value="转帐" ${vo.feiyongJiaofeifangshi=='转帐'?'checked':''}/>&nbsp;&nbsp;&nbsp;转帐&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">缴费时间：</td><td><input class="index-content-table-td-add" type="text" id="feiyongJiaofeishijian" name="feiyongJiaofeishijian" value="${vo.feiyongJiaofeishijian}"/></td>
            </tr>
            <tr>
                <td width="12%">备注：</td><td><textarea id="feiyongText" name="feiyongText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......">${vo.feiyongText}</textarea></td>
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
        if (document.getElementById("feiyongNo").value.trim().length == 0) {
            alert("账单号不能为空!");
            return false;
        }
        if (document.getElementById("feiyongZhuyuanhao").value.trim().length == 0) {
            alert("住院号不能为空!");
            return false;
        }
        if (document.getElementById("feiyongName").value.trim().length == 0) {
            alert("付款人不能为空!");
            return false;
        }
        if (document.getElementById("feiyongJine").value.trim().length == 0) {
            alert("金额不能为空!");
            return false;
        }
        if (document.getElementById("feiyongJiaofeishijian").value.trim().length == 0) {
            alert("缴费时间不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
