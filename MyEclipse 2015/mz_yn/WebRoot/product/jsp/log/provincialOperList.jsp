<%@ page contentType="text/html; charset=GBK"  %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    response.setHeader("Cache-Control","Public");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    String currentPath = request.getRequestURI();
    if(request.getQueryString() != null){
        currentPath = currentPath +"?"+request.getQueryString();
    }
%>
<c:set var="operMap" value="<%=InitSysParams.operTypeAllMap%>"/>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>�ǼǱ��ѯ</title>
<link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css" />
<script type='text/javascript' src="/js/tools.js"></script>
<script type='text/javascript' src="<%=request.getContextPath() %>/product/jsp/frame/js/calendar/WdatePicker.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#jgdm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		checkForm();
		}
	   }
	</script>
<script type="text/javascript">
function checkForm(){
    if(!isNumber(document.searchForm.pageno.value)){
        ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
        return false;
    }else{
        var pno = searchForm.pageno.value;
        if(parseInt(pno)<0){
		    ymPrompt.alert({message:'����ҳ�����Ϸ���', width:330, height:220, title:'��ʾ��Ϣ'});
		    return;
	    }
        var pageCount = parseInt(document.getElementById("totalPages").value);
        if(document.searchForm.pageno.value>pageCount){
            ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
            return false;
        }
    }
    document.searchForm.submit();
}
function exportData(){
    window.location.href="/bsweb/log_export.action";
}
</script>
</head>

<body>
<div class="page_top">ϵͳ &gt;&gt; ��־��ѯ &gt;&gt; ʡ���û�������־</div>
<form  name="searchForm" method="post" action="/bsweb/log_provincialOperList.action">
  <input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
  <input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
  <input type="hidden" name="currentPath" value="<%=currentPath%>" />
  <input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
  <input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
  <input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
  <input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
<div id="list_main">
  <div class="list_box">
    <div class="list_box_top">
        ͳһ���룺<input name="tyshxydm" type="text" class="input_200" id="jgdm" value="${tyshxydm}" maxlength="18"/>
        <label for="xzqh">��֤������</label>
        <select name="xzqh" id="xzqh"
                class="input_200">
            <option value=""></option>
            <c:forEach var="bzjg" items="${bzjgdmMap}">
                <option value="${bzjg.key}" ${xzqh eq bzjg.key?'selected="selected"':''} >${bzjg.value}</option>

            </c:forEach>
        </select>
   <!-- ��¼�û��� -->
        ����Ա��<input name="name" type="text" class="input_120" id="name" value="${name}" maxlength="15"/>
       ��������:
        <select name="type" id="type"
                class="input_200">
            <option value=""></option>
            <c:forEach var="bzjg" items="${operMap}">
                <option value="${bzjg.key}" ${type eq bzjg.key?'selected="selected"':''} >${bzjg.value}</option>

            </c:forEach>
        </select>
        <br/>��ʼ���ڣ�
        <label>
            <input id="CalendarSelector1" readOnly name="startDate" type="text" value="${startDate}"
                   class="input_120" onfocus="WdatePicker({el:'CalendarSelector1'})"/><img
                src="${requestScope.pageContext}/product/jsp/images/icon_day.gif" style="cursor:pointer;" align=absMiddle
                onclick="WdatePicker({el:'CalendarSelector1'})"/>
        </label>
        �������ڣ�
        <label>
            <input id="CalendarSelector2" readOnly name="endDate" value="${endDate}" type="text"
                   class="input_120" onfocus="WdatePicker({el:'CalendarSelector2'})"/><img
                src="${requestScope.pageContext}/product/jsp/images/icon_day.gif" style="cursor:pointer;" align=absMiddle
                onClick="WdatePicker({el:'CalendarSelector2'})"/>
        </label>

        <input name="button2" type="button" class="newBtn1" id="button1" value="�� ѯ" onclick="checkForm();" />
    <%--    <input name="exportBtn" type="button" class="newBtn1" id="exportBtn" value="�� ��" onclick="exportData();" />--%>
    </div>
     <table width="100%" border="0" cellpadding="0" cellspacing="0">
      	<tr class="list_table_top">
      	 	<td class="list_table_top_td" style="width:5%"><div style="float:left">&nbsp;���</div></td>

            <c:if test="${orderbyColum eq 'jgdm'}">
            <td class="list_table_top_td">
                   <div style="float:left">ͳһ����</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('jgdm','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'jgdm'}">
            <td class="list_table_top_td">
                   <div style="float:left">ͳһ����</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>

      	 	<c:if test="${orderbyColum eq 'name'}">
            <td class="list_table_top_td">
                   <div style="float:left">����Ա</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('name','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('name','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'name'}">
            <td class="list_table_top_td">
                   <div style="float:left">����Ա</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('name','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>

            <c:if test="${orderbyColum eq 'type'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('type','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('type','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'type'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('type','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>

            <c:if test="${orderbyColum eq 'date'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('date','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('date','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'date'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('date','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>

      	</tr>
      	<c:forEach varStatus="i" var="tczjl" items="${list}">
      		<tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
      			<td>&nbsp;${i.count }</td>
                <td>${tczjl.jgdm }</td>
      			<td>${tczjl.name }</td>
      			<td>${operMap[fn:trim(tczjl.type)]==null?"":operMap[fn:trim(tczjl.type)]}</td>
                <td><fmt:formatDate value="${tczjl.date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
      		</tr>
      	</c:forEach>
    </table>
  </div>
 <div class="list_ym">
     <div class="left pageLeft">�� ${pages.totalSize} ����¼   ��${pages.totalPages}ҳ   ��${pages.currentPage}ҳ</div>
     <div class="right">

       <%clsPageComponent pageComponent = (clsPageComponent)request.getAttribute("pages");
       if(pageComponent.hasPreviousPage()){%>
		  	 <input name="button"  onclick="firstPage()" type="button" class="list_ym_btn" id="button" value="��ҳ" style="cursor:pointer"/>
		   <%}else {%>
		   	<input name="button" class="list_ym_btn" type="button" id="button" value="��ҳ" style="cursor:pointer" disabled="disabled"/>
		   <%}%>
		  <%if(pageComponent.hasPreviousPage()){%>
		 	 <input name="button2"  class="list_ym_btn" type="button" id="button2" value="��һҳ" onClick="previousPage();" style="cursor:pointer"/>
		  <%}else {%>
		 	 <input name="button2" class="list_ym_btn" type="button" id="button2" value="��һҳ"  style="cursor:pointer" disabled="disabled"/>
		  <%}%>
 		  <%if (pageComponent.hasNextPage()){%>
		  	 <input name="button3"   class="list_ym_btn" type="button" id="button3" value="��һҳ" onClick="nextPage();" style="cursor:pointer"/>
		  <%}else {%>
		  	  <input name="button3"  class="list_ym_btn" type="button" id="button3" value="��һҳ" style="cursor:pointer" disabled="disabled"/>
		  <%}%>
		  <%if(pageComponent.hasNextPage()){%>

		<input name="button4"  class="list_ym_btn" type="button" id="button4" value="βҳ" onClick="endPage();" style="cursor:pointer"/>
		<%}else{%>
		<input name="button4"  class="list_ym_btn" type="button" id="button4" value="βҳ" style="cursor:pointer" disabled="disabled"/>
		<%}%>
		ת��
		<input value="${pages.currentPage }" name="pageno" type="text" class="input_ym" />
      	ҳ
         <input name="button5" type="button" class="list_ym_btngo"  value="GO" onclick="goPage();" style="cursor:pointer"/>
      	<select name="rowNumsView" id="rowNumsView" style="height: 20px;" onchange="commitRowNum()">
              <option value="15" ${pages.pageSize==15?"selected":""} >15</option>
              <option value="20" ${pages.pageSize==20?"selected":""} >20</option>
              <option value="50" ${pages.pageSize==50?"selected":""} >50</option>
        </select>��
      </div>
    </div>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

</form>
</body>
</html>

