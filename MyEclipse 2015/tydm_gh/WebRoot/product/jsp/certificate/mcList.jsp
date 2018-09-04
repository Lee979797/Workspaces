<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�ǼǱ��ѯ</title>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
</head>
<body>
<div class="page_top" style="text-align:center;font-weight:bold;">
    <c:if test="${'jgmc' eq path}">������������������</c:if>
    <c:if test="${'zch' eq path}">ע�������������</c:if>
    <c:if test="${'hzcq' eq path}">����֤����֤�������</c:if>
</div>
<div id="list_main">
    <div class="list_box">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">

                <td class="list_table_top_td">
                    <div style="float:left">��������</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">��������</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">��֤����</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">֤������</div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">��������</div>
                </td>
                <c:if test="${'hzcq'  ne path}">
                    <td class="list_table_top_td">
                        <div style="float:left">������Դ</div>
                    </td>
                </c:if>
                <td class="list_table_top_td" align="center">��ϸ</td>
            </tr>
            <c:forEach varStatus="i" var="tjgdmsave" items="${commonList}">
                <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                    <td>${fn:trim(tjgdmsave.jgdm) eq ""?"��":tjgdmsave.jgdm }</td>
                    <td>${tjgdmsave.jgmc }</td>
                    <td>${tjgdmsave.bzjgdm }</td>
                    <td>${tjgdmsave.zjhm }</td>
                    <td><fmt:formatDate value="${tjgdmsave.zfrq }"/></td>
                    <c:if test="${'hzcq'  ne path}">
                        <td>${tjgdmsave.sjly}</td>
                    </c:if>
                    <c:choose>
                        <c:when test="${tjgdmsave.tableName eq 't_jgdm_save' }">
                            <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16"
                                                    onclick="window.open('/bsweb/certificate_viewFddbrPage.action?id=${tjgdmsave.id}&sourceTable=${tjgdmsave.tableName}')"
                                                    style="cursor:pointer" title="�鿴"/></td>
                        </c:when>
                        <c:otherwise>
                            <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16"
                                                    onclick="window.open('/bsweb/certificate_viewFddbrPage.action?jgdm=${tjgdmsave.jgdm}&sourceTable=${tjgdmsave.tableName}')"
                                                    style="cursor:pointer" title="�鿴"/></td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

</body>
</html>

