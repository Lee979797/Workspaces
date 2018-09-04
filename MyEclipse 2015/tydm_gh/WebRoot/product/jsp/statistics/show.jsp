<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="dmStatus" type="java.lang.String"--%>
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
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">
        ${title}
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="history.back()" type="button"
               value="返 回"/>
    </div>
</div>
<form method="post" action="/bsweb/business_${needAudit==true?"auditValidate":"validateDM"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="source" value="validate" id="source"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>机构代码信息显示</b></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
                            <jsp:include page="../common_gh/show-jgdm.jsp"/>
                            <jsp:include page="../common_gh/show-jgdm-fddbr.jsp"/>
                        </TABLE>
                            <jsp:include page="../common_gh/show-jgdm-jl.jsp"/>
                       
                        
                    </div>
                    
                    <div class="listbtn">
                        <INPUT class="newBtn1" onclick="window.history.back();"
                               type=button
                               value="返 回"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
