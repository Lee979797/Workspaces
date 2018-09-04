<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    String formType = (String) request.getAttribute("formType");
    String jglx = (String) request.getAttribute("jglx");
    String title = "";
    String ywlx = "";
    if ("0".equals(formType)) {
        title = "申请表登记";
        ywlx = "10";
    }
    if ("1".equals(formType)) {
        title = "其他部门赋码";
        ywlx = "11";
    }
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>登记表查询</title>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/shadow.js"></script>
    <script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
        function checkForm() {
            if (!isNumber(document.searchForm.pageno.value)) {
                ymPrompt.alert('请输入数字！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        document.searchForm.pageno.focus();
                    }
                })
                return false;
            } else {
                var pno = searchForm.pageno.value;
                if (parseInt(pno) < 0) {
                    ymPrompt.alert({message: '输入页数不合法！', width: 330, height: 220, title: '提示信息'});
                    return;
                }
                var pageCount = parseInt(document.getElementById("totalPages").value);
                if (document.searchForm.pageno.value > pageCount) {
                    ymPrompt.alert('输入数字不能大于总页数！', 330, 220, '提示信息', function (data) {
                        if (data == "ok") {
                            document.searchForm.pageno.focus();
                        }
                    });
                    
                    return false;
                }
            }

            //申请表登记页面切换列表至非首页，查询不显示查询结果，列表左下角只提示查询到的记录条数
            var dm=$("#jgdm").val();
            var mc=$("#jgmc").val();
            if(<%=formType%>=="1"){
            	if($.trim(dm)!=''){
     				$("#pageno").val(1);
                     }
                }else{
                	 if($.trim(mc)!=''){
         				$("#pageno").val(1);
                         }
                    } 
        
                              
            document.searchForm.submit();
        }
        function checkCode(jgdm, type, id, sourceTable) {
 
 
   			
                if (type == 'update') {
                 
                    window.location.href = "/bsweb/certificate_updatePageSave.action?tyshxydm=" + jgdm + "&id=" + id + "&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=${jglx}&nav=1&sourceTable=" + sourceTable;
                } else{
                    window.location.href = "/bsweb/certificate_viewPage.action?djh=${djh}&id=" + id + "&type=2&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1&jglx=${jglx}";
                }
            
            
        }
        function checkCode2(jgdm, type, id, sourceTable) {
            dwr.engine.setAsync(false);
            var codeflag = false;
            spBus.isAudiaAll(jgdm, '<%=ywlx%>', function (data) {
                var index = data.indexOf(":");
                var s1 = data.substring(0, index);
                var s2 = data.substring(index + 1, data.length);
                if (s1 == "0") {
                    codeflag = false;
                }
                if (s1 == "1") {
                    ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '提示信息'});
                    codeflag = true;
                }
            });
            if (!codeflag) {
                if (type == 'update') {
               
                    window.location.href = "/bsweb/certificate_updatePage.action?tyshxydm=" + jgdm + "&id=" + id + "&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1&sourceTable=" + sourceTable;
                } else
                    window.location.href = "/bsweb/certificate_viewPage2.action?djh=${djh}&id=" + id + "&type=2&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1";
            }
        }
        $(function(){
            //alert('${list}');
            if(<%=formType%>=="1"){
                $("#jgdm").focus();
                }else{
                	$("#jgmc").focus();
                    } 
        	
        })
        document.onkeydown=function(){ 
				if(event.keyCode==13){
					checkForm();
				}
			}

		function daoru(){
			 ymPrompt.confirmInfo({
	                message: '获取三证合一接口数据会比较缓慢,请您耐心等待!',
	                width: 330,
	                height: 220,
	                title: '提示信息',
	                handler: function (btn) {
	                    if (btn == "ok") {
	                    	 show('获取接口数据请求中...');
	                    	 $.post(
	             	                "/servlet/HqGssj_hzServlet?method=hqJksj",
	             	                {'a': "1"},
	             	                function (data) {
	             	                    if (data == '1') {
	             	                    	ymPrompt.succeedInfo('获取成功！', 330, 220, '提示信息', function () {
	             	                    		window.location.href='/bsweb/certificate_list.action?formType=0';
	             	                   });
	             	                    }else{
	             	                    	ymPrompt.alert('获取出错!请联系管理员!', 330, 220, '提示信息', function () {
	             	                    		window.location.href='/bsweb/certificate_list.action?formType=0';
	             	                    	});
	             	                    	
	             	                    }
	             	                });
	                    }
			 }
			 });

			
			
		}
        
    </script>
</head>
<body>
<div class="page_top">登记  &gt;&gt;  <%
  	if("1".equals(jglx)){
  %>  
    社会团体业务
    <%
  	}
    %>
    <%
  	if("2".equals(jglx)){
  %>  
    民办非企业单位业务
    <%
  	}
    %>
    <%
  	if("3".equals(jglx)){
  %>  
    基金会业务
    <%
  	}
    %> &gt;&gt; <%if ("1".equals(formType)) {%>信息补录<%}else{ %> 设立登记<%} %>
</div>
<form name="searchForm" method="post" action="/bsweb/certificate_list.action">
<input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
<input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
<input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
<input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
<input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
<input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
<input type="hidden"  name="formType" value="<%=formType%>"/>
<input type="hidden" name="jglx" value="<%=jglx %>"/>
<div id="list_main">
<div class="list_box">
<div class="list_box_top">
    <%if ("1".equals(formType)) {%>统一代码/机构代码：<input name="tyshxydm" type="text" class="input_200" id="jgdm" value="${tyshxydm}"
                                               maxlength="18"/><%}%>
    机构名称：<input name="jgmc" type="text" class="input_200" id="jgmc" value="${jgmc}" maxlength="120"/>
 
    
    
    
    <input name="button2" type="button"  class="newBtn1" id="button1" value="查 询" onclick="checkForm();"/>
    <input name="button2" type="button"  class="newBtn1" value="新 增"
           onclick="window.location.href='/bsweb/certificate_addJgdm.action?formType=<%=formType%>&jglx=<%=jglx %>'"/>
          
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr class="list_table_top">
    <td class="list_table_top_td" style="width:5%">
        <div style="float:left">&nbsp;序号</div>
    </td>
    <c:if test="${formType eq '1'}">
        <c:if test="${orderbyColum eq 'jgdm'}">
            <td class="list_table_top_td" style="width:8%">
                <div style="float:left">机构代码</div>
                <div class="jt_box" style="float:right">
                    <c:if test="${orderbyMethod eq 'desc'}">
                        <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                          height="16" title="排序字段"/></a>
                    </c:if>
                    <c:if test="${orderbyMethod ne 'desc'}">
                        <a href="#" onclick="pageSort('jgdm','desc')"><img src="../images/jt_1.gif" width="16"
                                                                           height="16" title="排序字段"/></a>
                    </c:if>
                </div>
            </td>
        </c:if>
        <c:if test="${orderbyColum ne 'jgdm'}">
            <td class="list_table_top_td" style="width:8%">
                <div style="float:left">机构代码</div>
                <div class="jt_box" style="float:right">
                    <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="排序字段"/></a>
                </div>
            </td>
        </c:if>
    </c:if>
    <c:if test="${orderbyColum eq 'jgmc'}">
        <td class="list_table_top_td">
            <div style="float:left">机构名称</div>
            <div class="jt_box" style="float:right">
                <c:if test="${orderbyMethod eq 'desc'}">
                    <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="排序字段"/></a>
                </c:if>
                <c:if test="${orderbyMethod ne 'desc'}">
                    <a href="#" onclick="pageSort('jgmc','desc')"><img src="../images/jt_1.gif" width="16"
                                                                       height="16" title="排序字段"/></a>
                </c:if>
            </div>
        </td>
    </c:if>
    <c:if test="${orderbyColum ne 'jgmc'}">
        <td class="list_table_top_td">
            <div style="float:left">机构名称</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16"
                                                                  height="16" title="排序字段"/></a>
            </div>
        </td>
    </c:if>

    <c:if test="${orderbyColum eq 'fddbr'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">法人代表</div>
            <div class="jt_box" style="float:right">
                <c:if test="${orderbyMethod eq 'desc'}">
                    <a href="#" onclick="pageSort('fddbr','asc')"><img src="../images/jt_2.gif" width="16"
                                                                       height="16" title="排序字段"/></a>
                </c:if>
                <c:if test="${orderbyMethod ne 'desc'}">
                    <a href="#" onclick="pageSort('fddbr','desc')"><img src="../images/jt_1.gif" width="16"
                                                                        height="16" title="排序字段"/></a>
                </c:if>
            </div>
        </td>
    </c:if>
    <c:if test="${orderbyColum ne 'fddbr'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">法人代表</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('fddbr','asc')"><img src="../images/jt_2.gif" width="16"
                                                                   height="16" title="排序字段"/></a>
            </div>
        </td>
    </c:if>

    <c:if test="${orderbyColum eq 'zjhm'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">证件号</div>
            <div class="jt_box" style="float:right">
                <c:if test="${orderbyMethod eq 'desc'}">
                    <a href="#" onclick="pageSort('zjhm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="排序字段"/></a>
                </c:if>
                <c:if test="${orderbyMethod ne 'desc'}">
                    <a href="#" onclick="pageSort('zjhm','desc')"><img src="../images/jt_1.gif" width="16"
                                                                       height="16" title="排序字段"/></a>
                </c:if>
            </div>
        </td>
    </c:if>
    <c:if test="${orderbyColum ne 'zjhm'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">证件号</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('zjhm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                  height="16" title="排序字段"/></a>
            </div>
        </td>
    </c:if>

    <c:if test="${orderbyColum eq 'bzrq'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">办证日期</div>
            <div class="jt_box" style="float:right">
                <c:if test="${orderbyMethod eq 'desc'}">
                    <a href="#" onclick="pageSort('bzrq','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="排序字段"/></a>
                </c:if>
                <c:if test="${orderbyMethod ne 'desc'}">
                    <a href="#" onclick="pageSort('bzrq','desc')"><img src="../images/jt_1.gif" width="16"
                                                                       height="16" title="排序字段"/></a>
                </c:if>
            </div>
        </td>
    </c:if>
    <c:if test="${orderbyColum ne 'bzrq'}">
        <td class="list_table_top_td" style="width:10%">
            <div style="float:left">办证日期</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('bzrq','asc')"><img src="../images/jt_2.gif" width="16"
                                                                  height="16" title="排序字段"/></a>
            </div>
        </td>
    </c:if>
 <c:if test="${formType ne 1}">
    <td class="list_table_top_td" align="center" style="width:5%">修改</td>
</c:if>
 <c:if test="${formType eq 1}">
    <td class="list_table_top_td" align="center" style="width:5%">确认</td>
</c:if>
    <c:if test="${formType eq 0}">
        <td class="list_table_top_td" align="center" style="width:5%">删除</td>
    </c:if>


        <td class="list_table_top_td" align="center" style="width:10%;">校对</td>

     
    
    <td class="list_table_top_td" align="center" style="width:5%">详细</td>
</tr>
<c:forEach varStatus="i" var="tjgdmsave" items="${list}">
    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
        <td>&nbsp;${i.count }</td>
        <%if ("1".equals(formType)) {%>
        <td>${tjgdmsave.jgdm }</td>
        <%}%>
        <td>${tjgdmsave.jgmc }</td>
        <td>${tjgdmsave.fddbr }</td>
        <td>${tjgdmsave.zjhm }</td>
        <td><fmt:formatDate value="${tjgdmsave.bzrq}" pattern="yyyy-MM-dd"/></td>

    <c:if test="${formType ne 1}">
      
              <c:choose>
            <c:when test="${tjgdmsave.flag eq ''}">
                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                        onclick="checkCode('${(tjgdmsave.jgdm eq null || fn:trim(tjgdmsave.jgdm) eq "" )? tjgdmsave.id:tjgdmsave.jgdm}','update','${tjgdmsave.id}','t_jgdm_save');"
                                        style="cursor:pointer" title="修改"/></td>
            </c:when>
            <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                        onclick="checkCode('${(tjgdmsave.jgdm eq null || fn:trim(tjgdmsave.jgdm) eq "" )? tjgdmsave.id:tjgdmsave.jgdm}','update','${tjgdmsave.id}','t_sptemp');"
                                        style="cursor:pointer" title="修改"/></td>
            </c:when>
            <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='0'}">
                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                        onclick="checkCode('${(tjgdmsave.jgdm eq null || fn:trim(tjgdmsave.jgdm) eq "" )? tjgdmsave.id:tjgdmsave.jgdm}','update','${tjgdmsave.id}','t_jgdm_save');"
                                        style="cursor:pointer" title="修改"/></td>
            </c:when>
            <c:otherwise>
                <td align="center"><img src="../../images/icon_edit1.gif" width="16" height="16"
                                        onclick="ymPrompt.alert({message:'已提交审核,不能修改！', width:330, height:220, title:'提示信息'});"
                                        style="cursor:pointer" title="修改"/></td>
            </c:otherwise>
        </c:choose>
	</c:if>
	<c:if test="${formType eq 1}">
      
              <c:choose>
            <c:when test="${tjgdmsave.flag eq ''}">
                <td align="center"><img src="../../images/icon_edit1.gif" width="16" height="16"
                                       onclick="ymPrompt.alert({message:'还未提交审核,不能确认！', width:330, height:220, title:'提示信息'});"
                                        style="cursor:pointer" title="确认"/></td>
            </c:when>
            <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                        onclick="checkCode('${(tjgdmsave.jgdm eq null || fn:trim(tjgdmsave.jgdm) eq "" )? tjgdmsave.id:tjgdmsave.jgdm}','update','${tjgdmsave.id}','t_sptemp');"
                                        style="cursor:pointer" title="确认"/></td>
            </c:when>
         
            <c:otherwise>
                <td align="center"><img src="../../images/icon_edit1.gif" width="16" height="16"
                                        onclick="ymPrompt.alert({message:'已提交审核,不能确认！', width:330, height:220, title:'提示信息'});"
                                        style="cursor:pointer" title="确认"/></td>
            </c:otherwise>
        </c:choose>
	</c:if>
        <c:if test="${formType eq 0}">
            <c:choose>
                <c:when test="${tjgdmsave.flag eq ''}">
                    <td align="center"><img src="../../images/icon_del.gif" width="16" height="16"
                                            onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${tjgdmsave.id}&type=1&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1&jglx=${jglx }'"
                                            style="cursor:pointer" title="删除"/></td>
                </c:when>
                <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                    <td align="center"><img src="../../images/icon_del.gif" width="16" height="16"
                                            onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${tjgdmsave.id}&type=1&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1${jglx }'"
                                            style="cursor:pointer" title="删除"/></td>
                </c:when>
                <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='0'}">
                    <td align="center"><img src="../../images/icon_del.gif" width="16" height="16"
                                            onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${tjgdmsave.id}&type=1&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1${jglx }'"
                                            style="cursor:pointer" title="删除"/></td>
                </c:when>
                <c:otherwise>
                    <td align="center"><img src="../../images/icon_del1.gif" width="16" height="16"
                                            onclick="ymPrompt.alert({message:'已提交审核,不能删除！', width:330, height:220, title:'提示信息'});"
                                            style="cursor:pointer" title="删除"/></td>
                </c:otherwise>
            </c:choose>
        </c:if>

  
            <c:choose>
                <c:when test="${tjgdmsave.flag=='0'}">
                    <td align="center">已提交审核</td>
                </c:when>
                <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                    <td align="center">已审核,允许重名</td>
                </c:when>
                <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='0'}">
                    <td align="center">已审核,不允许重名</td>
                </c:when>
                <c:when test="${tjgdmsave.flag eq ''}">
                    <td align="center"><img src="../../images/gonggaogl.png" width="16" height="16"
                                            onclick="checkCode('${(tjgdmsave.jgdm eq null || fn:trim(tjgdmsave.jgdm) eq "" )? tjgdmsave.id:tjgdmsave.jgdm}','revision','${tjgdmsave.id}');"
                                            style="cursor:pointer" title="校对赋码"/></td>
                </c:when>
            </c:choose>
 
            
     
   
        <td align="center"><img src="../../images/icon_chakan.gif" width="16" height="16"
                                onclick="window.location.href='/bsweb/certificate_viewPage.action?id=${tjgdmsave.id}&type=3&formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&nav=1'"
                                style="cursor:pointer" title="查看"/></td>
    </tr>
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
        <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页" onClick="previousPage();"
               style="cursor:pointer"/>
        <%} else {%>
        <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        <%if (pageComponent.hasNextPage()) {%>
        <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页" onClick="nextPage();"
               style="cursor:pointer"/>
        <%} else {%>
        <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        <%if (pageComponent.hasNextPage()) {%>

        <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" onClick="endPage();"
               style="cursor:pointer"/>
        <%} else {%>
        <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        转到
        <input value="${pages.currentPage }" name="pageno" id="pageno" type="text" class="input_ym"/>
        页
        <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="goPage();"
               style="cursor:pointer"/>
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

