<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="ywlc" type="com.ninemax.jpa.code.model.TYwlc"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
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


</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<form name="searchForm" method="post" action="/bsweb/certificatePrint_print_zb">
    <input type="hidden" name="jgdm.jgdm" value="${certi.jgdm}">
    <input type="hidden" name="ywlc.ywlsh" value="${ywlc.ywlsh}"/>
    <input type="hidden" name="opJglx" value="${opJglx}"/>
</form>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        <input name="button3" type="button" class="newBtn1"
               id="prn1_print" value="打 印"
               onclick="printThis(true)"/>
        &nbsp;<input name="button3" type="button" class="newBtn1"
                     id="back" value="返 回"
                     onclick="window.location.href='/bsweb/certificatePrint_list_no_print'"/>
    </div>
</div>
<jsp:include page="print_common.jsp"/>
</body>
</html>

