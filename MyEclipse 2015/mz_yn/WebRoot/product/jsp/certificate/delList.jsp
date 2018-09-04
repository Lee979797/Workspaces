<%@ page contentType="text/html; charset=GBK"  %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
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
    String delType = (String)request.getAttribute("delType");
    String title = "";
    String ywlx = "";
    if("1".equals(delType)){
        title = "�������Ÿ���ɾ��";
        ywlx = "08";

    }
    if("2".equals(delType)){
        title = "Ԥ����ɾ��";
        ywlx = "09";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>�ǼǱ��ѯ</title>
<link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css" />
<link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="/js/tools.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
    var dm=$("#jgdm").val();
    var mc=$("#jgmc").val();
    if($.trim(dm)!=''||$.trim(mc)!=''){
    	$("#pageno").val(0);
    }
    document.searchForm.submit();
}
function checkCode(jgdm,type,delFlag,id){
    dwr.engine.setAsync(false);
    var codeflag = false;
    spBus.isAudiaAll(jgdm,'<%=ywlx%>', function (data) {
        var index = data.indexOf(":");
        var s1 = data.substring(0, index);
        var s2 = data.substring(index + 1, data.length);
        if (s1 == "0") {
            codeflag = false;
        }
        if (s1 == "1") {
            ymPrompt.alert({message: s2,width:330,height:220,slideShowHide: false, title: '��ʾ��Ϣ'});
            codeflag = true;
        }
    });
    if(!codeflag){
        if(type=='audit'){
            window.location.href="/bsweb/certificate_viewPage.action?id="+id+"&type=1&formType=${delType}&delFlag="+delFlag+"&pageno=${pageno}&rowNumsView=${rowNumsView}";
        }else
            window.location.href="/bsweb/certificate_viewPage.action?id="+id+"&type=1&formType=${delType}&pageno=${pageno}&rowNumsView=${rowNumsView}";
    }
}
</script>
</head>
<body onload="document.getElementById('jgdm').focus()" onkeypress=" return ches(document.searchForm,checkForm);">
<div class="page_top">��֤ &gt;&gt; �����ɾ�� &gt;&gt; <%=title%></div>
<form  name="searchForm" method="post" action="/bsweb/certificate_delSaveList.action">
  <input type="hidden" name="currentPath" value="<%=currentPath%>" />
  <input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
  <input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
  <input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
  <input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
  <input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
  <input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
  <input type="hidden" name="delType" value="<%=delType%>" />
<div id="list_main">
  <div class="list_box">
    <div class="list_box_top">
        �������룺<input name="jgdm" type="text" class="input_120" id="jgdm" value="${jgdm}" maxlength="9"/>
        �������ƣ�<input name="jgmc" type="text" class="input_200" id="jgmc" value="${jgmc}" maxlength="120"/>
        <input name="button2" type="button" class="newBtn1" id="button1" value="�� ѯ" onclick="checkForm();"/>
    </div>
     <table width="100%" border="0" cellpadding="0" cellspacing="0">
      	<tr class="list_table_top">
      	 	<td class="list_table_top_td" style="width:5%"><div style="float:left">&nbsp;���</div></td>
            <c:if test="${orderbyColum eq 'jgdm'}">
                <td class="list_table_top_td" style="width:10%">
                       <div style="float:left">��������</div>
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
                <td class="list_table_top_td" style="width:10%">
                       <div style="float:left">��������</div>
                       <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </div>
                </td>
            </c:if>
            <c:if test="${orderbyColum eq 'jgmc'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('jgmc','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'jgmc'}">
            <td class="list_table_top_td">
                   <div style="float:left">��������</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum eq 'bzrq'}">
            <td class="list_table_top_td" style="width:10%">
                   <div style="float:left">��֤����</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('bzrq','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('bzrq','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="�����ֶ�" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'bzrq'}">
            <td class="list_table_top_td" style="width:10%">
                   <div style="float:left">��֤����</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('bzrq','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="�����ֶ�" /></a>
                   </div>
            </td>
            </c:if>
      	 	<c:if test="${needAudit}">
              <td class="list_table_top_td" style="width:10%"><div style="float:left">���״̬</div></td>
              <td class="list_table_top_td" style="width:5%" align="center">����</td>
            </c:if>
            <c:if test="${!needAudit}">
                <td class="list_table_top_td" style="width:5%" align="center">ɾ��</td>
            </c:if>
      	</tr>
      	<c:forEach varStatus="i" var="tjgdmsave" items="${vList}">
      		<tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
      			<td>&nbsp;${i.count }</td>
                <td>${tjgdmsave.jgdm }</td>
      			<td>${tjgdmsave.jgmc }</td>
                <td><fmt:formatDate value="${tjgdmsave.bzrq}" pattern="yyyy-MM-dd" /></td>
      			<c:if test="${tjgdmsave.flag=='0'}">
                    <td>���ύ���</td>
                    <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16" onclick="checkCode('${tjgdmsave.jgdm}','audit','0','${tjgdmsave.id}');" style="cursor:pointer" title="�鿴"/></td>
                </c:if>
                <c:if test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                    <td>���ͨ��</td>
                    <td align="center"><img src="../../images/icon_del.gif" width="16" height="16" onclick="checkCode('${tjgdmsave.jgdm}','audit','1','${tjgdmsave.id}');" style="cursor:pointer" title="ɾ��"/></td>
                </c:if>
                <c:if test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='0'}">
                    <td>�����,������ɾ��</td>
                    <td align="center"><img src="../../images/report_go.png" width="16" height="16" onclick="checkCode('${tjgdmsave.jgdm}','audit','3','${tjgdmsave.id}');" style="cursor:pointer" title="�����ύ���"/></td>
                </c:if>
                <c:if test="${tjgdmsave.flag=='2'}">
                    <td>��Ҫ���</td>
                    <td align="center"><img src="../../images/report_go.png" width="16" height="16" onclick="checkCode('${tjgdmsave.jgdm}','audit','2','${tjgdmsave.id}');" style="cursor:pointer" title="�ύ���"/></td>
                </c:if>
                <c:if test="${!needAudit}">
                <td align="center"><img src="../../images/icon_del.gif" width="16" height="16" onclick="checkCode('${tjgdmsave.jgdm}','no','0','${tjgdmsave.id}');" style="cursor:pointer" title="ɾ��"/></td>
                </c:if>
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
		<input value="${pages.currentPage }" name="pageno" id="pageno"  type="text" class="input_ym" />
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

