<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
    String jglx = (String) request.getAttribute("jglx");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<c:set var="ywlxMap" value="<%=InitSysParams.ywlxMap%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�û���˹���</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#CalendarSelector1").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			Page.verify();
		}
	   }
	</script>
    <script type="text/javascript">
        function show_sp(lsh, submitType,ywlx) {
            if (submitType != '0') {
                window.location.href = 'bsweb/auditing_findInSameName?sp.ywlx='+ywlx+'&sp.lsh=' + lsh+'&jglx=${jglx}';
            } else {
                window.location.href = 'bsweb/auditingfindInData?sp.lsh=' + lsh+'&jglx=${jglx}';
            }
        }
    </script>
</head>
<body>
<div class="page_top">�Ǽ� &gt;&gt; <%
  	if("1".equals(jglx)){
  %>  
    �������ҵ��
    <%
  	}
    %>
    <%
  	if("2".equals(jglx)){
  %>  
    ������ҵ��λҵ��
    <%
  	}
    %>
    <%
  	if("3".equals(jglx)){
  %>  
    �����ҵ��
    <%
  	}
    %> &gt;&gt; �������</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/auditinginDataList.action">
        <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="jglx" value="${jglx }"/>
        <div class="list_box_top">
            ����ʱ�䣺
            <input id="CalendarSelector1" name="startDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${startDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector1'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            ����
            <input id="CalendarSelector2" name="endDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${endDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector2'})"/>
            ͳһ����/ҵ���ţ�<input name="_jgdm" type="text" class="input_200" id="jgdm" maxlength="18" value="${_jgdm}"/>
            <input name="button2" type="button" class="newBtn1" id="btn" value="�� ѯ"
                   onclick="Page.verify()"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">���</td>
                    <td class="list_table_top_td">
                        <div style="float:left">ҵ������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ywlx','${(page.orderByField eq 'ywlx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ywlx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">ͳһ����</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                         <td class="list_table_top_td">
                        <div style="float:left">��������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">��֤����</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('sendxzqh','${(page.orderByField eq 'sendxzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'sendxzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('sendman','${(page.orderByField eq 'sendman' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'sendman' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">����ʱ��</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('sendtime','${(page.orderByField eq 'sendtime' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'sendtime' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center">���</td>
                </tr>

                <c:forEach varStatus="i" var="sp" items="${spList}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        
              
                       	<td>
                       	<c:if test="${sp.ywlx eq '04'}">ע���ָ�</c:if>
                       	<c:if test="${sp.ywlx eq '07'}">����</c:if>
                       	<c:if test="${sp.ywlx eq '11'}">��Ϣ��¼</c:if>
                       	<c:if test="${sp.ywlx eq '13'}">��������</c:if>
                       	</td>
               
                 
                        
                        <td>${sp.tyshxydm }</td>
                           <td>${sp.jgmc }</td>
                        <td>${bzjgdmMap[fn:trim(sp.sendxzqh)]}</td>
                        <td>${sp.sendman }</td>
                        <td><fmt:formatDate value="${sp.sendtime }" pattern="yyyy-MM-dd"/></td>
                        <td align="center">
                            <img src="/product/images/icon_shenhe.gif" width="16"
                                 height="16" onclick="show_sp('${sp.lsh}','${sp.submitType}','${sp.ywlx}')"
                                 style="cursor:pointer;" title="���"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
