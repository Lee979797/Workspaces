<%--@elvariable id="mc" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>信息查询</title>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="/css/csstable.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/tools.js"></script>

</head>
<body style="background:#fff;">
<form method="post" name='thisForm' action="/bsweb/select_result.action">
    <br>
    <input type="hidden" name="source" value="${source}">
    <input type="hidden" name="filter" value="${filter}">

    <table align="center" border="1" cellpadding="1" cellspacing="0" class="tableBorder0"
           style="border-collapse:collapse; font-size:14px; line-height:30px; width:500px;" bordercolor="#B5D6EF">
        <tr class="list_table_top" style="height:40px;">
            <td align="center" class="td1" colspan="4" style="font-weight:bold;font-size:14px;">输入要查询的代码或名称</td>
        </tr>
        <tr style="height:40px;">
            <td align="center" style="font-size:12px;">代码或名称：
                <input onblur="this.value=this.value.trim();" type="text"
                       name="mc" id='mc' size="30" value="${mc}"
                       maxlength="50"></td>
        </tr>
        <tr style="height:40px;">
            <td align="center" class="td1" colspan="2">
                <input type="submit" class="list_ym_btn" name="modify" value="确 认"/>
                <input type="button" class="list_ym_btn" name="back" value="关 闭"
                       onClick="window.parent.ymPrompt.close()"/>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    (function () {
        var mc = document.getElementById("mc");
        mc.focus();
        mc.value = mc.value.replace(/(.*[^0])0*$/,'$1');
    })();
</script>

</body>
</html>