<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="jgdms" type="java.util.List<com.ninemax.jpa.code.model.TJgdm>"--%>
<%--@elvariable id="startDate" type="java.util.Date"--%>
<%--@elvariable id="endDate" type="java.util.Date"--%>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>外网数据审核</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/js/calendar/WdatePicker.js'></script>
    <script type="text/javascript">
        function chesThis() {
            switch (event.keyCode) {
                case 13:
                    search();
                    return false;
                default:
                    return true;
            }

        }
        window.onload = function () {
            document.getElementById("jgdm").focus();
        }
        window.onkeydown = chesThis;
    </script>
</head>
<body onkeydown="chesThis()">
<object scope="application" width="32" height="32" classid="CLSID:3EE0206D-697A-11D5-9BD3-00E01819D1CC"
        codebase="icocx/jgdmicread.cab" name="jgdmicread" style="display:None">
</object>
<div class="page_top">查询 &gt;&gt; 机构查询 &gt;&gt; 发卡信息查询</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_list_kxxk.action">
        <div class="list_box_top">
            发卡日期：
            <input id="CalendarSelector1" name="startDate" value="<fmt:formatDate value="${startDate}"/>"
                   type="text" class="input_120"
                   onfocus="WdatePicker({el:'CalendarSelector1'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            至：
            <input id="CalendarSelector2" name="endDate" value="<fmt:formatDate value="${endDate}"/>"
                   type="text" class="input_120"
                   onfocus="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG
                    src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                    align="middle" onClick="WdatePicker({el:'CalendarSelector2'})"/>
            &nbsp;<input name="button1" type="submit" class="newBtn1" id="btn" value="查 询"/>
        </div>
        <div class="list_box">
            <c:set var="dms" value="${jgdms }"/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">机构名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left;">办证日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:15%">
                        <div style="float:left">年检日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('njrq','${(page.orderByField eq 'njrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'njrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                </tr>
                <c:forEach varStatus="i" var="dm" items="${dms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>

                        <td>&nbsp;${i.count}</td>
                        <td>${dm.jgdm}</td>
                        <td>${dm.jgmc}</td>
                        <td><fmt:formatDate value="${dm.bzrq}"/></td>
                        <td><fmt:formatDate value="${dm.njrq}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>

        </div>

    </form>
    <form method="get" name='thisForm' action="/bsweb/business_search.action">
        <input name="mc" type="hidden" id="mc"/>
        <input type="hidden" value="${source}" name="type">
        <input type="hidden" value="${source}" name="source">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl"/>
        <input type="hidden" name="ywlx" id="ywlx"/>
    </form>
    <form method="post" name='deleteAllForm' action="/bsweb/business_validateAll.action">
        <input type="hidden" name="allJgdms" id="allJgdms">
        <input name="mc" type="hidden" id="mc2"/>
        <input type="hidden" value="${source}" name="type">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm2"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit2"/>
        <input type="hidden" name="audit" value="false" id="audit2"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl2"/>
        <input type="hidden" name="ywlx" id="ywlx2"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
