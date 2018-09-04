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
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>

    <title>代码证书打印</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <jsp:include page="print_common.jsp"/>
    <script language="javascript" type="text/javascript" src="/js/LodopFuncs.js"></script>
    <script type="text/javascript">
        function preview() {
            var LODOP = createPage();
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-${certi.djh}");
            LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
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
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-${certi.djh}");
            LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
            LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", 1);
            LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW", 1);
            LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW", 1);//隐藏打印按钮
            //  LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW", 1);//隐藏设置按钮
            // LODOP.SET_SHOW_MODE("HIDE_PAGE_PERCENT", 1);//隐藏缩放比例下拉选框
            //   LODOP.SET_SHOW_MODE("HIDE_QBUTTIN_PREVIEW", 1);//隐藏关闭按钮
            //   LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE", 1);
            LODOP.SET_SHOW_MODE("HIDE_TOOLS_PREVIEW", 1);
            LODOP.PREVIEW();
            document.searchForm.submit();
        }
        function printSpecial() {
            var LODOP = createPage();
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-${certi.djh}");
            LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
            //  LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' src='/images/cert.jpg'>");
            LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD", 1);
            LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW", 1);
            LODOP.SET_SHOW_MODE("HIDE_VBUTTIN_SETUP", 1);//隐藏预览按钮
            LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_PREVIEW", 1);//隐藏打印按钮
            LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW", 1);//隐藏设置按钮
            LODOP.SET_SHOW_MODE("HIDE_PAGE_PERCENT", 1);//隐藏缩放比例下拉选框
            //   LODOP.SET_SHOW_MODE("HIDE_QBUTTIN_PREVIEW", 1);//隐藏关闭按钮
            //   LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE", 1);
            LODOP.SET_SHOW_MODE("HIDE_TOOLS_PREVIEW", 1);
            var status = LODOP.PREVIEW();
            eval(status);
            LODOP = createPage();
            LODOP.PRINT();
            document.searchForm.submit();
        }
        function manage() {
            var LODOP = createPage();
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-${certi.djh}");
            LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
            // LODOP.SET_SHOW_MODE("HIDE_ABUTTIN_SETUP",1);//隐藏应用按钮
            // LODOP.SET_SHOW_MODE("HIDE_RBUTTIN_SETUP",1);//隐藏复原按钮
            LODOP.SET_SHOW_MODE("HIDE_VBUTTIN_SETUP", 1);//隐藏预览按钮
            LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_SETUP", 1);//隐藏打印按钮
//    LODOP.SET_SHOW_MODE("SETUP_ENABLESS",getCheckSS());
            LODOP.SET_SHOW_MODE("HIDE_DISBUTTIN_SETUP", 1);//隐藏那些无效按钮
            LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW", 1);
            // LODOP.SET_SHOW_MODE("HIDE_TOOLS_DESIGN", 1);
            var strProgram = LODOP.PRINT_SETUP();//  LODOP.PRINT_DESIGN(); // ;
            eval(strProgram);
            LODOP.SET_SHOW_MODE("PREVIEW_IN_BROWSE", 1);
            LODOP.SET_SHOW_MODE("HIDE_TOOLS_PREVIEW", 1);
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
        &nbsp;<input name="button3" type="button" class="btn2"
                     id="prn1_preview" value="打印预览"
                     onclick="preview()"/>
        &nbsp;<input name="button3" type="button" class="newBtn1"
                     id="prn1_print" value="打 印"
                     onclick="print()"/>
        &nbsp;<input name="button3" type="button" class="newBtn1"
                     id="back" value="返 回"
                     onclick="history.back()"/>
    </div>
</div>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"
        width="100%" height="1196" style="height:1196px; margin-top: 15px">
    <param name="Caption" value="显示区">
    <param name="Border" value="0">
    <param name="Color" value="white">
    <embed id="LODOP_EM" TYPE="application/x-print-lodop" width="100%" height="1196"
           border=0 Color="white" PLUGINSPAGE="/icocx/install_lodop.exe">
</object>
<form name="searchForm" method="post" action="/bsweb/certificatePrint_print_fb.action">
    <input type="hidden" name="jgdm.jgdm" value="${certi.jgdm}">
    <input type="hidden" name="jgdm.fbsl" value="${certi.fbNumber}">
    <input type="hidden" name="ywlc.ywlsh" value="${ywlc.ywlsh}"/>
    <input type="hidden" name="certi.type" value="${certi.type}">
    <input type="hidden" name="source" value="${source}">
</form>
</body>
<script language="javascript">
    var LODOP = createPage();
    LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "组代管${sysUser.bzjgdm}-${certi.djh}");
    LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
    LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
    LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
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
</script>
</html>

