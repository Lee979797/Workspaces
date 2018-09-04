<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>

<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>登记表查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript">
        function verifyData() {
            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }
        function show(tyshxydm, xzqh, zb, fb) {
            document.showForm.tyshxydm.value = tyshxydm;
            document.showForm.submit();
        }
    </script>
</head>
<body onkeypress="ches(document.searchForm,verifyData);">
<div class="page_top">${title}</div>
<div id="list_main">

    <c:if test="true">
        <form name="searchForm" method="post" action="/bsweb/certificatePrint_list_no_print.action">
            <div class="list_box_top" style="border: 1px;">
            <input type="hidden" name="opJglx" value="${opJglx }"/>

                       统一代码/机构代码/机构名称： 
                       <input class="input_200" type="text" name="jgdm.tyshxydm" size="13" id="jgdm1"
                       maxlength="18" value="${jgdm.tyshxydm}">&nbsp;<span
                    id="length" style="color: #ff0000"></span>
                &nbsp;办理日期：
                <INPUT name="startDate" id="startDate" onclick="WdatePicker({el:$dp.$('startDate')});"
                       value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>"
                       class="input_120"/>
                <A hideFocus onclick="WdatePicker({el:$dp.$('startDate')});" href="javascript:void(0)">
                    <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
                </A>至<INPUT onclick="WdatePicker({el:$dp.$('endDate')});"
                            name="endDate" id="endDate"
                            value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"
                            class="input_120"/>
                <A hideFocus onclick="WdatePicker({el:$dp.$('endDate')});" href="javascript:void(0)">
                    <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
                </A>

                <input name="search" type="button" onclick="return verifyData();" class="newBtn1" id="btn1" value="查 询"/>
            </div>
            <div class="list_box">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="list_table_top">
                        <td class="list_table_top_td" style="width:3%">
                            <div style="float:left">&nbsp;序号</div>
                        </td>

                        <td class="list_table_top_td">
                            <div style="float:left">统一代码</div>
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
                        <td class="list_table_top_td">
                            <div style="float:left">发证机关</div>

                        </td>
                        <td class="list_table_top_td">
                            <div style="float:left">批准文号</div>

                        </td>
                        <td class="list_table_top_td">
                            <div style="float:left">办证日期</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>

                            <td class="list_table_top_td" align="center">
                                打印证书
                            </td>
                    </tr>
                    <c:forEach varStatus="i" var="dm" items="${jgdms}">
                        <tr ${i.index % 2==0?"class='list_tr'":"class='list_tr2'" }>
                            <td>&nbsp;${i.index+1 }</td>
                            <td>${dm.tyshxydm }</td>
                            <td>${dm.jgmc}</td>
                            <td>${dm.bzjgdm}</td>
                            <td>${dm.zch}</td>
                            <td><fmt:formatDate value="${dm.bzrq}" pattern="yyyy-MM-dd"/></td>
                                <td align="center">
                                    <img src="/product/images/print_16x16.gif" width="16" height="16"  onclick="show('${dm.tyshxydm}','${sysUser.bzjgdm}',1,0)" style="cursor:pointer" title="打证"/>
                                </td>
                        </tr>
                    </c:forEach>
                </table>
                <jsp:include page="../common/pageCommon.jsp"/>
            </div>
        </form>
        <form action="/bsweb/certificatePrint_zb_info.action" name="showForm">
            <input type="hidden" name="jgdm.jgdm" id="jgdm"/>
            <input type="hidden" name="jgdm.tyshxydm" id="tyshxydm"/>
            <input type="hidden" name="isdy" id="isdy" value="0">
        </form>
    </c:if>

</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
<script type="text/javascript">
    (function () {
        document.getElementById("jgdm1").focus();
    })();
</script>
</body>
</html>