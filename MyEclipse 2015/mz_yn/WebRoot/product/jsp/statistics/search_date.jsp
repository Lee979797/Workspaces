<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>数据查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <link rel="stylesheet" type="text/css" href="/js/highslide-4.1.8/highslide/highslide.css"/>
    <script type="text/javascript" src="/js/highslide-4.1.8/highslide/highslide-with-html.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
      /*   hs.graphicsDir = '/js/highslide-4.1.8/highslide/graphics/';
        hs.outlineType = 'rounded-white';
        hs.showCredits = false;
        hs.wrapperClassName = 'draggable-header'; */
        function checkForm() {
            searchForm.submit();
            return true;
        }
        function changeStatus(){
        	var checkedBox=$('input:checked')
        	
        	if(checkedBox&&checkedBox.size()!=0){
        		var arr="" ;
        		var i=0;
        		for(;i<checkedBox.size();i++){
        			if(i==checkedBox.size()-1){
        				arr+=checkedBox[i].value;
        			}else{
        				arr+=checkedBox[i].value+",";
        			}	
        		}
        		$.ajax({
	            	type: "post",
	         	  	url: "/bsweb/statistics_change_status.action",
	          	 	data: {"arr":arr},
	         	    dataType: "json",
	         	    success:function(){
	         	    	alert("成功")
	         	    	checkForm();
	         	    },
	         	    error:function(){
	         	    	alert("失败")
	         	    }
	         	 })
        	}else{
        		alert("请选择数据")
        	}
        	
        	
        }
        function selectAll(){
        	var boxlist=$(".checkbox");
        	if(boxlist){
        		for(var i=0;i<boxlist.size();i++){
        			boxlist[i].checked=true;
        		}
        	}else{
        		alert("无数据")
        	}
        	
        }
    </script>
</head>
<body>
<div class="page_top">查询&gt;&gt; 机构查询 &gt;&gt; 数据查询</div>
<form name="searchForm" method="post" action="/bsweb/statistics_show_date.action">
<input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
<input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
<input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
<input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
<%-- <input type="hidden" name="pages.orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
<input type="hidden" name="pages.orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>  --%>

 <div id="list_main">
    <div class="list_box">
        <div class="list_box_top">
            <!-- <input type="hidden" name="params.mdtype" value="0"/> -->

            录入时间：
            <input id="CalendarSelector1" name="startDate" 
                   type="text" class="input_120" onfocus="WdatePicker({el:'CalendarSelector1'})"/><IMG
                src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            至：
            <input id="CalendarSelector2" name="endDate"  type="text"
                   class="input_120" onfocus="WdatePicker({el:'CalendarSelector2'})"/><IMG
                src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                align=absMiddle onClick="WdatePicker({el:'CalendarSelector2'})"/>

            <input name="button2" type="button" class="newBtn1" id="button2" value="查 询" onclick="checkForm();"/>
            <input name="button3" type="button" class="newBtn1" id="button3" value="确认上报" onclick="changeStatus();"/>
        </div>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td class="list_table_top_td" style="width:5%">
                    <div style="float:left">
                    &nbsp;<input name="button4" type="button" class="newBtn1" id="button4" value="全选" onclick="selectAll();"/>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">统一社会信用代码</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('tyshxydm','${(pages.orderbyColum eq 'tyshxydm' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'tyshxydm' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">机构代码</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('jgdm','${(pages.orderbyColum eq 'jgdm' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'jgdm' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">机构名称</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('jgmc','${(pages.orderbyColum eq 'jgmc' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'jgmc' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>

                <td class="list_table_top_td">
                    <div style="float:left">机构地址</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('jgdz','${(pages.orderbyColum eq 'jgdz' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'jgdz' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">法定代表人</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('fddbr','${(pages.orderbyColum eq 'fddbr' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'fddbr' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">证件号码</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="pageSort('zjhm','${(pages.orderbyColum eq 'zjhm' and pages.orderbyMethod eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(pages.orderbyColum eq 'zjhm' and pages.orderbyMethod eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
            </tr>
            <c:set var="count" value="0"/>
            <c:forEach varStatus="i" var="md" items="${tjgdms}">
                <tr ${i.count%2 eq 1?"class='list_tr'":"class='list_tr2'" }>
                    <td>
                    	<input type="checkbox" class="checkbox" value="${md.tyshxydm}"/>
                    </td>
                    <td>${md.tyshxydm }</td>
                    <td>${md.jgdm }</td>
                    <td>${md.jgmc }</td>
                    <td>${md.jgdz }</td>
                    <td>${md.fddbr }</td>
                    <td>${md.zjhm }</td>
                </tr>
                <c:set var="count" value="${i.count}"/>
            </c:forEach>
           
        </table>

    </div>
    <div class="list_ym">
    
        <div class="left pageLeft">共 ${pages.totalSize} 条记录 共${pages.totalPages}页 第${pages.currentPage}页</div>
       <div class="right">
 
            <%
                clsPageComponent pageComponent = (clsPageComponent) request.getAttribute("pages");
                if (pageComponent.hasPreviousPage()) {
            %>
           <input name="button" onclick="firstPage()" type="button" class="list_ym_btn" id="button" value="首页"
                   style="cursor:pointer"/>
            <%} else {%>
            <input name="button" class="list_ym_btn" type="button" id="button" value="首页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasPreviousPage()) {%>
            <input name="button2" class="list_ym_btn" type="button" id="pre" value="上一页"
                   onClick="previousPage();" style="cursor:pointer"/>
            <%} else {%>
            <input name="button2" class="list_ym_btn" type="button" id="pre2" value="上一页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasNextPage()) {%>
            <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页"
                   onClick="nextPage();"
                   style="cursor:pointer"/>
            <%} else {%>
            <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页"
                   style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasNextPage()) {%>

            <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" onClick="endPage();"
                   style="cursor:pointer"/>
            <%} else {%>
            <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页"
                   style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            转到
            <input value="${pages.currentPage }" name="pageno" type="text" class="input_ym"/>
            页
            <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="goPage();"
                   style="cursor:pointer"/>
            <select name="rowNumsView" id="rowNumsView" style="height: 20px;" onchange="commitRowNum()">
                <option value="15" ${pages.pageSize==19?"selected":""} >15</option>
                <option value="20" ${pages.pageSize==20?"selected":""} >20</option>
                <option value="50" ${pages.pageSize==50?"selected":""} >50</option>
            </select>条
        </div> 
    </div> 
</div>

</div> 
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

</form>
</body>
 <script language="javascript">

    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg!=null && !clsStringTool.isEmpty(msg.toString())){
    %>
    ymPrompt.alert({message:'<%=msg.toString()%>', width:330, height:220, title:'提示信息'});
    <%}%>

</script>
</html>














































