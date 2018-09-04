<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>代码证书打印</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script language="javascript" src="/js/LodopFuncs.js"></script>
    <jsp:include page="print_common.jsp"/>
    <script language="javascript" type="text/javascript">
        function preview() {
            var LODOP = createPage();
            LODOP.SET_SHOW_MODE("PREVIEW_IN_BROWSE", 1);
            LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", 1);
            LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW", 1);
            LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW", 1);//隐藏打印按钮
            LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW", 1);//隐藏设置按钮
            // LODOP.SET_SHOW_MODE("HIDE_PAGE_PERCENT", 1);//隐藏缩放比例下拉选框
            LODOP.SET_SHOW_MODE("HIDE_QBUTTIN_PREVIEW", 1);//隐藏关闭按钮
            LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE", 1);
            LODOP.SET_SHOW_MODE("HIDE_TOOLS_PREVIEW", 1);
            LODOP.PREVIEW();
        }
        function print() {
            var LODOP = createPage();
            LODOP.PRINT();
            //      document.searchForm.submit();
        }
        function manage() {
            var LODOP = createPage();
            LODOP.SET_SHOW_MODE("PREVIEW_IN_BROWSE", 1);
//            LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", 1);
//            LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW", 1);
            //    LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW", 1);//隐藏打印按钮
            //   LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW", 1);
            //   LODOP.SET_SHOW_MODE("HIDE_TOOLS_DESIGN", 1);
            var strProgram = LODOP.PRINT_SETUP();
            eval(strProgram);
            LODOP.PREVIEW();
        }
        function show() {
            preview();
        }
    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        <input name="button3" type="button" class="btn2"
               id="manage" value="打印维护"
               onclick="manage()"/>
        &nbsp;<input name="button3" type="button" class="btn2" id="prn1_preview" value="打印预览"
                     onclick="preview()"/>
        &nbsp;<input name="button3" type="button" class="newBtn1" id="prn1_print" value="打 印"
                     onclick="print()"/>
        &nbsp;<input name="button3" type="button" class="newBtn1"
                     id="back" value="返 回"
                     onclick="history.back()"/>
    </div>
</div>

<form name="searchForm" method="post" action="#">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}">
    <input type="hidden" name="jgdm.fbsl" value="${jgdm.fbsl}">
    <input type="hidden" name="type" value="${type}">
    <c:forEach var="set" items="${settings}" varStatus="status">
        <input type="hidden" name="settings[${status.index}]" value="${settings[status.index]}">
    </c:forEach>

    <object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"
            width=100% height=1196 style="height:1196px; margin-top: 15px">
        <param name="Caption" value="显示区">
        <param name="Border" value="0">
        <param name="Color" value="white">
        <embed id="LODOP_EM" TYPE="application/x-print-lodop" width=100% height=1196
               border=0 Color="white" PLUGINSPAGE="/icocx/install_lodop.exe">
    </object>

</form>
</body>
<script language="javascript">
    show();
</script>
</html>

