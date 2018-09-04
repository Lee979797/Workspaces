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
    String formType = (String)request.getAttribute("formType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>登记表查询</title>
<link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css" />
<link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="/js/tools.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#ywlsh").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		checkForm();
		}
	   } 
	</script>
<script type="text/javascript">
function checkForm(){
    if(!isNumber(document.searchForm.pageno.value)){
        ymPrompt.alert('请输入数字！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
        return false;
    }else{
        var pno = searchForm.pageno.value;
        if(parseInt(pno)<0){
		    ymPrompt.alert({message:'输入页数不合法！', width:330, height:220, title:'提示信息'});
		    return;
	    }
        var pageCount = parseInt(document.getElementById("totalPages").value);
        if(document.searchForm.pageno.value>pageCount){
            ymPrompt.alert('输入数字不能大于总页数！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
            return false;
        }
    }
    document.searchForm.submit();
}
</script>
</head>
<body>
<div class="page_top">发证 &gt;&gt; 申请表登记 &gt;&gt; 预赋码</div>
<form  name="searchForm" method="post" action="/bsweb/certificate_yfmList.action">
<input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
<input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
<input type="hidden" name="currentPath" value="<%=currentPath%>" />
<input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
<input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
<input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
<input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
<input type="hidden" name="formType" value="<%=formType%>" />
<div id="list_main">
  <div class="list_box">
    <div class="list_box_top">
        业务流水号：<input name="ywlsh" type="text" class="input_200" id="ywlsh" value="${ywlsh}" maxlength="12"/>
        机构名称：<input name="jgmc" type="text" class="input_200" id="jgmc" value="${jgmc}" maxlength="60"/>
        <input name="button2" type="button" class="newBtn1" id="button1" value="查 询" onclick="checkForm();"/>
        <input name="button2" type="button" class="newBtn1" value="新 增"
                       onclick="window.location.href='/product/jsp/certificate/addRequisition.jsp?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}'"/>
    </div>
     <table width="100%" border="0" cellpadding="0" cellspacing="0">
      	<tr class="list_table_top">
      	 	<td class="list_table_top_td" style="width:5%"><div style="float:left">&nbsp;序号</div></td>

            <c:if test="${orderbyColum eq 'ywlsh'}">
                <td class="list_table_top_td">
                       <div style="float:left">业务流水号</div>
                       <div class="jt_box" style="float:right">
                           <c:if test="${orderbyMethod eq 'desc'}">
                                <a href="#" onclick="pageSort('ywlsh','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                           <c:if test="${orderbyMethod ne 'desc'}">
                                <a href="#" onclick="pageSort('ywlsh','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                       </div>
                </td>
            </c:if>
            <c:if test="${orderbyColum ne 'ywlsh'}">
                <td class="list_table_top_td">
                       <div style="float:left">业务流水号</div>
                       <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('ywlsh','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                       </div>
                </td>
            </c:if>

            <%--<c:if test="${orderbyColum eq 'jgdm'}">
                <td class="list_table_top_td">
                       <div style="float:left">机构代码</div>
                       <div class="jt_box" style="float:right">
                           <c:if test="${orderbyMethod eq 'desc'}">
                                <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                           <c:if test="${orderbyMethod ne 'desc'}">
                                <a href="#" onclick="pageSort('jgdm','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                       </div>
                </td>
                </c:if>
                <c:if test="${orderbyColum ne 'jgdm'}">
                <td class="list_table_top_td">
                       <div style="float:left">机构代码</div>
                       <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                       </div>
                </td>
            </c:if>--%>

            <c:if test="${orderbyColum eq 'jgmc'}">
                <td class="list_table_top_td">
                       <div style="float:left">机构名称</div>
                       <div class="jt_box" style="float:right">
                           <c:if test="${orderbyMethod eq 'desc'}">
                                <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                           <c:if test="${orderbyMethod ne 'desc'}">
                                <a href="#" onclick="pageSort('jgmc','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="排序字段" /></a>
                           </c:if>
                       </div>
                </td>
            </c:if>
            <c:if test="${orderbyColum ne 'jgmc'}">
                <td class="list_table_top_td">
                       <div style="float:left">机构名称</div>
                       <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                       </div>
                </td>
            </c:if>

            <c:if test="${orderbyColum eq 'clsj'}">
            <td class="list_table_top_td">
                   <div style="float:left">业务受理日期</div>
                   <div class="jt_box" style="float:right">
                       <c:if test="${orderbyMethod eq 'desc'}">
                            <a href="#" onclick="pageSort('clsj','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                       </c:if>
                       <c:if test="${orderbyMethod ne 'desc'}">
                            <a href="#" onclick="pageSort('clsj','desc')"><img src="../images/jt_1.gif" width="16" height="16" title="排序字段" /></a>
                       </c:if>
                   </div>
            </td>
            </c:if>
            <c:if test="${orderbyColum ne 'clsj'}">
            <td class="list_table_top_td">
                   <div style="float:left">业务受理日期</div>
                   <div class="jt_box" style="float:right">
                        <a href="#" onclick="pageSort('clsj','asc')"><img src="../images/jt_2.gif" width="16" height="16" title="排序字段" /></a>
                   </div>
            </td>
            </c:if>
            <td class="list_table_top_td" align="center">
                通知单修改
            </td>
            <%--<td class="list_table_top_td" align="center">
                更新
            </td>--%>
            <%--<td class="list_table_top_td">
                <div style="float:left">删除</div>
            </td>--%>
           <%-- <td class="list_table_top_td" align="center">
                校对
            </td>--%>
            <td class="list_table_top_td" align="center">
                打印
            </td>
            <td class="list_table_top_td" align="center">
                详细
            </td>
      	</tr>
      	<c:forEach varStatus="i" var="ywlc" items="${ywlcList}">
      		<tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
      			<td>&nbsp;${i.count }</td>
                <td>${ywlc.ywlsh}</td>
                <%--<td>${ywlc.jgdm }</td>--%>
      			<td>${ywlc.jgmc }</td>
                <td><fmt:formatDate value="${ywlc.clsj}" pattern="yyyy-MM-dd" /></td>
                <td align="center"><img src="../../images/application_form_edit.png" width="16" height="16"
                         onclick="window.location.href='/bsweb/certificate_updateRequisitionPage.action?ywlsh=${ywlc.ywlsh}&id=${fn:trim(ywlc.jgdm)}&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}'"
                         style="cursor:pointer;" title="通知单修改"/></td>
                <%--<td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                         onclick="window.location.href='/bsweb/certificate_updatePage.action?id=${fn:trim(ywlc.jgdm)}&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}'"
                         style="cursor:pointer;" title="修改"/></td>--%>
                <%--<td><img src="../../images/icon_del.gif" width="16" height="16"
                         onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${tjgdmsave.id}&type=1&formType=${formType}'"
                         style="cursor:pointer;" title="删除"/></td>--%>
                <%--<td align="center"><img src="../../images/gonggaogl.png" width="16" height="16"
                         onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${fn:trim(ywlc.jgdm)}&type=2&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1'"
                         style="cursor:pointer;" title="校对"/></td>--%>
                <c:if test="${ywlc.ywlclx eq 5}">
                    <td align="center"><a href="/bsweb/requisition_printPage.action?id=${fn:trim(ywlc.jgdm)}&type=update"><img
                                    src="../../images/print_16x16.gif" width="16" height="16" style="cursor:pointer;"
                                    title="打印"/></a></td>
                </c:if>
                <c:if test="${ywlc.ywlclx eq 2}">
                    <td align="center"><a href="/bsweb/requisition_printPage.action?id=${fn:trim(ywlc.jgdm)}"><img
                                    src="../../images/print_16x16.gif" width="16" height="16" style="cursor:pointer;"
                                    title="打印"/></a></td>
                </c:if>
                <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16"
                         onclick="window.location.href='/bsweb/certificate_viewRequisitionPage.action?id=${fn:trim(ywlc.jgdm)}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1'"
                         style="cursor:pointer;" title="查看"/></td>
      		</tr>
      	</c:forEach>
    </table>
  </div>
 <div class="list_ym">
     <div class="left pageLeft">共 ${pages.totalSize} 条记录   共${pages.totalPages}页   第${pages.currentPage}页</div>
     <div class="right">

       <%clsPageComponent pageComponent = (clsPageComponent)request.getAttribute("pages");
       if(pageComponent.hasPreviousPage()){%>
		  	 <input name="button"  onclick="firstPage()" type="button" class="list_ym_btn" id="button" value="首页" style="cursor:pointer"/>
		   <%}else {%>
		   	<input name="button" class="list_ym_btn" type="button" id="button" value="首页" style="cursor:pointer" disabled="disabled"/>
		   <%}%>
		  <%if(pageComponent.hasPreviousPage()){%>
		 	 <input name="button2"  class="list_ym_btn" type="button" id="button2" value="上一页" onClick="previousPage();" style="cursor:pointer"/>
		  <%}else {%>
		 	 <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页"  style="cursor:pointer" disabled="disabled"/>
		  <%}%>
 		  <%if (pageComponent.hasNextPage()){%>
		  	 <input name="button3"   class="list_ym_btn" type="button" id="button3" value="下一页" onClick="nextPage();" style="cursor:pointer"/>
		  <%}else {%>
		  	  <input name="button3"  class="list_ym_btn" type="button" id="button3" value="下一页" style="cursor:pointer" disabled="disabled"/>
		  <%}%>
		  <%if(pageComponent.hasNextPage()){%>

		<input name="button4"  class="list_ym_btn" type="button" id="button4" value="尾页" onClick="endPage();" style="cursor:pointer"/>
		<%}else{%>
		<input name="button4"  class="list_ym_btn" type="button" id="button4" value="尾页" style="cursor:pointer" disabled="disabled"/>
		<%}%>
		转到
		<input value="${pages.currentPage }" name="pageno" type="text" class="input_ym" />
      	页
         <input name="button5" type="button" class="list_ym_btngo"  value="GO" onclick="goPage();" style="cursor:pointer"/>
      	<select name="rowNumsView" id="rowNumsView" style="height: 20px;" onchange="commitRowNum()">
              <option value="15" ${pages.pageSize==15?"selected":""} >15</option>
              <option value="20" ${pages.pageSize==20?"selected":""} >20</option>
              <option value="50" ${pages.pageSize==50?"selected":""} >50</option>
        </select>条
      </div>
    </div>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

</form>
</body>
</html>