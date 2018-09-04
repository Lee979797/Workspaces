<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript">

        function redoAudit() {
            document.busForm.action = "/bsweb/business_search.action";
            document.busForm.btok.disabled = "true";
            document.busForm.submit();

        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;"><strong>首页 &gt;&gt; 办证机构提交审核项目列表 &gt;&gt; 查看</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="newBtn1" onClick=" history.back()" type=button value="返 回" name='cmdExit'>
        &nbsp;
    </div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <h3><b>查看机构信息</b></h3>
                    <table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center bo%"
                           bgcolor="#eaf6fb">
                        <jsp:include page="../common/show-jgdm.jsp"/>
                    </table>
                </div>
                <div class="listbtn">
                    <INPUT class="newBtn1" onClick=" history.back()" type=button value="返 回"
                           name='cmdExit'>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
