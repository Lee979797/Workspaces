<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.Page" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdmSave" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="show" value="<%=Page.AttributeType.show%>"/>
<c:set var="sort" value="<%=Page.AttributeType.sort%>"/>
<c:set var="opt" value="<%=Page.AttributeType.opt%>"/>
<c:set var="nnjghyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njglxMap" value="<%= InitSysParams.njglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgdmMap%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
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
            document.getElementById("export").disabled = "disabled";
            document.getElementById("back").disabled = "disabled";
            ymPrompt.win({message: '/product/jsp/statistics/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
            document.exportForm_errorjg.submit();
        }
    </script>


</head>
<body>
<div class="page_top">
    <div align="right" style=" float: right;">
		<c:if test="${error_jg_list[0] != null}">
       		<input class="newBtn1" type="button" value="导 出" id="export"
               onclick="exportExcel();"/>&nbsp;
         </c:if>
        <input class="newBtn1" type="button" value="返 回" id="back"
               onclick=" window.location.href='/bsweb/statistics_search?source=import'"/>&nbsp;
    </div>
    ${title}
    <c:set var="dmsave" value="<%=TJgdmSave.class.getName()%>"/>
</div>

<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_export_search.action">
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }" id="jgmc"/>
        <input type="hidden" name="sqlwhere" value="${sqlwhere }" id="sqlwhere"/>
        <input type="hidden" name="order" value="${order }" id="order"/>
        <input type="hidden" name="database" value="${database }" id="database"/>
        <c:forEach varStatus="status" items="${fields}" var="field">
            <input type="hidden" name="fields[${status.index}].dm"
                   value="${field.dm}"/>
            <input type="hidden" name="fields[${status.index}].name"
                   value="${fn:trim(field.name)}"/>
            <input type="hidden" value="${field.select}"
                   name="fields[${status.index}].select"/>
        </c:forEach>

	<div>
		<div id="import_info">
			${import_info }	
			<br />
		</div>
		
		<c:if test="${error_jg_list != null}">
			<h2>问题数据列表:</h2>
        	<div class="list_box">       	
           		<table width="100%" border="0" cellpadding="0" cellspacing="0">
        		
           		<tr class="list_table_top">
                    <%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
                    <td class="list_table_top_td" style="width:3%">序号</td>
                	<td class="list_table_top_td" style="width:3%">统一社会信用代码</td>
              		<td class="list_table_top_td" style="width:3%">机构名称</td>
              		<td class="list_table_top_td" style="width:3%">行政区划</td>
               		<td class="list_table_top_td" style="width:3%">失败原因</td>
                </tr>
           		
					<c:forEach items="${error_jg_list }" var="jg" varStatus="i" >
						<tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
						<td>&nbsp;${i.count }</td>
						<td>${jg.tyshxydm }</td>
						<td>${jg.jgmc }</td>
						<td>${jg.xzqh }</td>
						<td>${jg.memo1 }</td>				
					</c:forEach>
            	</table>           	
        	</div>
        </c:if>
       </div>
    </form>
    <form action="/bsweb/statistics_show_dm.action" name="showForm">
        <input type="hidden" name="jgdm.tyshxydm" id="jgdm"/>
        <input type="hidden" name="database" value="${database }"/>
        <input type="hidden" name="source" value="${source }"/>
    </form>
    
    <form action="/bsweb/statistics_export2.action" method="post" name="exportForm_errorjg" id="exportForm_errorjg">
    	 <c:forEach items="${error_jg_list }" var="jg" varStatus="i" >
 			<input type="hidden" name="tyshxydm" value="${jg.tyshxydm }"/>
			<input type="hidden" name="jgmc" value="${jg.jgmc }"/>
			<input type="hidden" name="xzqh" value="${jg.xzqh }"/>
			<input type="hidden" name="memo1" value="${jg.memo1 }"/>				
		</c:forEach>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
