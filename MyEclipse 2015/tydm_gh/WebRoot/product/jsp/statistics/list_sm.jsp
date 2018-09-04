<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.bzjgdmMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
        function exportExcel() {
            document.exportForm.submit();
        }
    </script>
</head>
<body>
<div class="page_top">
    <div align="right" style=" float: right;">
        <%--  <input class="newBtn1" onClick=" exportExcel()"
                 type="button" value="导 出"/>&nbsp;--%>
        <input class="newBtn1"
               onClick=" window.location.href='/bsweb/statistics_search?source=${source eq 'show_mc'?'bymc':'multitype'}'"
               type="button" value="返 回"/>&nbsp;
    </div>
    ${title}
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_${source}.action">
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }" id="jgmc"/>
        <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm }" id="bzjgdm"/>
        <input type="hidden" name="database" value="${database }" id="database"/>

        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <td class="list_table_top_td" style="width:15%">
                        <div style="float:left">统一社会信用代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('tyshxydm','${(page.orderByField eq 'tyshxydm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'tyshxydm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:15%" >
                        <div style="float:left">机构名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('tyshxydm','${(page.orderByField eq 'tyshxydm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'tyshxydm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:35%">
                        <div style="float:left">机构地址</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdz','${(page.orderByField eq 'jgdz' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdz' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">法人代表</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('fddbr','${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">行政区划</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('xzqh','${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center" style="width:5%">查看</td>
                </tr>

                <c:forEach varStatus="i" var="jgdm" items="${jgdms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${jgdm.tyshxydm	 }</td>
                        <td>${jgdm.jgmc }</td>
                      <%--   <td>${zrxzqhMap[jgdm.bzjgdm] }</td> --%>
                        <td>${jgdm.jgdz }</td>
                        <%-- <td>${jglxMap[jgdm.jglx] }</td> --%>
                        <td> ${jgdm.fddbr}</td>
                        <td>${jgdm.xzqh }</td>
                        <td align="center">
                            <img src="/product/images/icon_chakan.gif" width="16"
                                 height="16"
                                 onclick="Page.show('${jgdm.tyshxydm}')"
                                 style="cursor:pointer;" title="查看"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/statistics_show_da.action" name="showForm">
        <input type="hidden" name="jgdm.tyshxydm" id="jgdm"/>
    </form>
    <form action="/bsweb/statistics_export_mc.action" name="exportForm">
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }"/>
        <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm }"/>
        <input type="hidden" name="database" value="${database }"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
