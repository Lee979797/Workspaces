<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<c:set var="zgjgMap" value="<%=InitSysParams.zgjgMap%>"/>
<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>证书打印数量</title>
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
	<script type="text/javascript">
        function verifydate() {
            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }
    </script>
  </head>
<body onkeypress="ches(document.searchForm,verifydate);">
    <div class="page_top">${title}</div>
    <div id="list_main">
    	<form name="searchForm" method="post" action="/bsweb/certificatePrint_list_zstj_print.action">
    		<div class="list_box_top" style="border: 1px;">
           	机构代码：
           		<input type="text" name="tcjl.jgdm" size="13" id="jgdm1"
                 		    maxlength="9" value="${tcjl.jgdm}" class="input_120">&nbsp;<spanid="length"></span>
          	办证时间：
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
           		<input name="search" type="button" onclick="return verifydate();" class="newBtn1" id="btn1" value="查 询"/>
       		</div>
       		<div class="list_box">
       			<table width="100%" border="0" cellpadding="0" cellspacing="0">
       			<tr class="list_table_top">
      				<td class="list_table_top_td" style="width:8%">
                    <div style="float:left">&nbsp;序号</div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">主管机构</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('klsh','${(page.orderByField eq 'klsh' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">证书打印</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('type','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">正本打印</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('type','${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">副本打印</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('memo','${(page.orderByField eq 'memo' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">特殊正本打印</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('name','${(page.orderByField eq 'name' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
                    <td class="list_table_top_td" >
                    	<div style="float:left">特殊副本打印</div>
                    	<div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('xzqh','${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'type' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                    </div>
                    </td>
       			</tr>
       			<c:forEach varStatus="i" var="dm" items="${tCzjls}">
                    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${xzqhMap[fn:trim(dm.klsh)]}</td>
                        <td>${dm.jgdm}</td>
                        <td>${dm.type}</td>
                        <td>${dm.memo}</td>
                        <td>${dm.name}</td>
                        <td>${dm.xzqh}</td>
                    </tr>
               </c:forEach>
               </table>
               <jsp:include page="../common/pageCommon.jsp"/>
       		</div>
    	</form>
    </div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
<script language="javascript" type="text/javascript">
    (function () {
        <c:if test="${message!=null && message!=''}">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
        </c:if>
        document.getElementById("jgdm1").focus();
    })();
</script>
</html>