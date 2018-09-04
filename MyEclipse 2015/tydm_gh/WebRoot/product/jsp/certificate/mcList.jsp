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
    <title>登记表查询</title>
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
    <c:if test="${'jgmc' eq path}">机构名称重名检测情况</c:if>
    <c:if test="${'zch' eq path}">注册号重名检测情况</c:if>
    <c:if test="${'hzcq' eq path}">法人证件换证超期情况</c:if>
</div>
<div id="list_main">
    <div class="list_box">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">

                <td class="list_table_top_td">
                    <div style="float:left">机构代码</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">机构名称</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">办证机构</div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">证件号码</div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">作废日期</div>
                </td>
                <c:if test="${'hzcq'  ne path}">
                    <td class="list_table_top_td">
                        <div style="float:left">数据来源</div>
                    </td>
                </c:if>
                <td class="list_table_top_td" align="center">详细</td>
            </tr>
            <c:forEach varStatus="i" var="tjgdmsave" items="${commonList}">
                <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                    <td>${fn:trim(tjgdmsave.jgdm) eq ""?"无":tjgdmsave.jgdm }</td>
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
                                                    style="cursor:pointer" title="查看"/></td>
                        </c:when>
                        <c:otherwise>
                            <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16"
                                                    onclick="window.open('/bsweb/certificate_viewFddbrPage.action?jgdm=${tjgdmsave.jgdm}&sourceTable=${tjgdmsave.tableName}')"
                                                    style="cursor:pointer" title="查看"/></td>
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

