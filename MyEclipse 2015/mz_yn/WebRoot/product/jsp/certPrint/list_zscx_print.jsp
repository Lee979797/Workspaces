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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>打印查询</title>
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
		 <form name="searchForm" method="post" action="/bsweb/certificatePrint_list_zscx_print.action">
		 	<div class="list_box_top" style="border: 1px;">
	           	机构代码：
	            <input type="text" name="tzs.jgdm" size="13" id="jgdm1"
	                   maxlength="9" value="${tzs.jgdm}" class="input_120"
	                    >&nbsp;<span
	                id="length" style="color: #ff0000"></span>
	           	 机构名称：
				<input type="text" name="tzs.jgmc" size="13" id="jgdm2"
	                   maxlength="9" value="${tzs.jgmc}" class="input_120"
	                    >&nbsp;<span
	                id="length" style="color: #ff0000"></span>
	            <input name="search" type="button" onclick="return verifydate();" class="newBtn1" id="btn1" value="查 询"/>
        	</div>
        	<div class="list_box">
	            <table width="100%" border="0" cellpadding="0" cellspacing="0">
	                <tr class="list_table_top">
	                    <td class="list_table_top_td" style="width:3%">
	                        <div style="float:left">&nbsp;序号</div>
	                    </td>
	                    <td class="list_table_top_td" >
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
	                    <td class="list_table_top_td" >
	                        <div style="float:left">有效期</div>
	                        <div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('yxq','${(page.orderByField eq 'yxq' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'yxq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                        </div>
	                    </td>
	                    <td class="list_table_top_td" >
	                        <div style="float:left">办证机构代码</div>
	                        <div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('bzjgdm','${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                        </div>
	                    </td>
	                   	<td class="list_table_top_td" >
	                        <div style="float:left">组代管</div>
	                        <div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('djh','${(page.orderByField eq 'djh' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'djh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                        </div>
	                    </td>
	                    <td class="list_table_top_td" >
	                        <div style="float:left">状态</div>
	                        <div class="jt_box" style="float:right">
	                            <a href="#"
	                               onclick="Page.sort('flag','${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'desc':'asc'}')">
	                                <img src="../images/${(page.orderByField eq 'filg' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
	                                     width="16" height="16" title="排序字段"/></a>
	                        </div>
	                    </td>
	                </tr>
	                <c:forEach varStatus="i" var="dm" items="${tzss}">
	                    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
	                        <td>&nbsp;${i.count}</td>
	                        <td>${dm.jgdm}</td>
	                        <td>${dm.jgmc}</td>
	                        <td>${dm.yxq}</td>
	                        <td>${dm.bzjgdm}</td>
	                        <td>${dm.djh}</td>
	                        <c:if test="${dm.flag == '0'}" var="作废" ><td>作废</td></c:if>
	                        <c:if test="${dm.flag == '1'}" var="正常" ><td>正常</td></c:if>
	                        <c:if test="${dm.flag == '2'}" var="挂失" ><td>挂失</td></c:if>
	                        <c:if test="${dm.flag == 'N'}" var="预约挂失" ><td>预约挂失</td></c:if>
	                        
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