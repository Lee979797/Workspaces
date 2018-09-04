<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>打印</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <jsp:include page="print_common.jsp"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" language="javascript">

        function print(text, type, flag) {
            var LODOP = createPage();
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-" + text);
            LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
            LODOP.PRINT();
            if (flag) {
                showModalDialog('/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + text + "&source=3",
                        window, "dialogHeight:330px; dialogWidth: 400px; edge: raised; center: Yes; help: No; resizable: No; status: No; unadorned:1;");
            }
        }
        function prints() {
            var start = Number("${certi.fbSn}");
            var fbNumber = Number('${certi.fbNumber}');
            var b = false;
            var a = 0;
            if (fbNumber > 1) {
                b = confirm("输入副本编号吗？共需要输入'" + fbNumber + "'次，取消后，可以在证书修改页填写证书编号");
                for (var i = start; i < start + fbNumber; i++) {
                    print("${certi.djhFbPre}" + (i + 1), 1, b);
                }
            } else {
                print("${certi.djhFbPre}" + (start + 1), 1, true);
            }

        }
    </script>

</HEAD>
<BODY style="background:#fff;" class="body">
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"
        width=0 height=0>
    <param name="Caption" value="显示区">
    <param name="Border" value="0">
    <param name="Color" value="white">
    <embed id="LODOP_EM" TYPE="application/x-print-lodop" width=0 height=0
           border=0 Color="white" PLUGINSPAGE="/icocx/install_lodop.exe">
</object>
<div class="prompt">
    <div class="promptou">提示信息</div>
    <div class="prompti">
        <form method="POST" name='frmThis'
              action="/bsweb/certificatePrint_${source eq "3"?'search?source=3':'list_has_print'}">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <li>
                        <input class="btn2" type="button" value="再次打印" name="B2" onclick="prints()"> <span>副本(不减库存)</span>
                    </li>
                    <li>
                        <strong>卡坏证书处理</strong>：先取消输入证书编号，点击再次打印，当打印正确后再输入相应编号；完成打印后，将卡坏的证书做资源损耗；<br>
                        <strong>打印出空白证书处理</strong>：先取消输入证书编号，把打出来的空白证书放回打印机，然后点击再次打印，并输入相应编号&nbsp;<br>
                        <strong>再次打印时流水号不变,封皮库存不变</strong>
                    </li>
                    <li>
                        <b> <a href="#" onclick="document.frmThis.submit();">开始新的打印</a> </b>
                    </li>
                </ul>
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</BODY>
<script type="text/javascript" language="javascript">
    (function () {
        prints();
    })();
</script>
</HTML>