<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="njqhs" type="java.util.List<com.ninemax.jpa.code.model.TKqnjqh>"--%>
<%--@elvariable id="message" type="com.ninemax.jpa.code.model.TKqnjqh"--%>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
%>
<c:set var="xzqhs" value="<%=InitSysParams.xzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>需处罚机构查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
</head>
<body>
<div class="page_top">${title}</div>
<form name="searchForm" method="post" action="/bsweb/xzqhManage_list_kqnjqh.action">
    <div class="list_box">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td class="list_table_top_td" style="width:5%">序号</td>
                <td class="list_table_top_td">
                    <div style="float:left">办证机构</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('xzqh','${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">名称</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('mc','${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td" align="center">年检区划设置</td>
            </tr>

            <c:forEach varStatus="i" var="cf" items="${njqhs}">
                <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                    <td>&nbsp;${i.count }</td>
                    <td>&nbsp;${cf.xzqh }</td>
                    <td>&nbsp;${xzqhs[cf.xzqh] }</td>
                    <td align="center">
                        <a href="/bsweb/xzqhManage_list_kqnjqh?kqnjqh.xzqh=${cf.xzqh}">
                            <img src="../../images/gonggaogl.png" width="16" height="16"
                                 style="cursor:pointer" title="${cf.sfkq eq '0'? '开启区划检查':'关闭区划检查'}"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="../common/pageCommon.jsp"/>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</form>
<form action=""></form>
</body>

<c:if test="${message!=null}">
    <script type="text/javascript">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '提示信息'});
    </script>
</c:if>
</html>

