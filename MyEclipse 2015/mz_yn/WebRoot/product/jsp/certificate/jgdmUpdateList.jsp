<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
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
%>
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
    <script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
     <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
       
            document.searchForm.submit();
         
        }
        function checkCode(jgdm, sourceTable) {
            dwr.engine.setAsync(false);
            var codeflag = false;
            jgdmBus.checkCert(jgdm, ${sysUser.bzjgdm},'${fn:trim(sysUser.userName)}', 'update', function (value) {
                var vs = value.split(":");
                if ("false" == vs[0]) {
                    ymPrompt.alert(vs[1], 400, 200, '提示信息');
                    codeflag = true;
                }
            });
            spBus.isAudiaAll(jgdm, '16', function (data) {
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
                window.location.href = "/bsweb/certificate_search.action?tyshxydm=" + jgdm + "&jglx=${jglx}&source=update&bzjgdm=${sysUser.bzjgdm}&pageno=${pageno}&rowNumsView=${rowNumsView}&sourceTable=" + sourceTable;
            }
        }
    </script>
</head>
<body onload="document.getElementById('jgdm').focus()" onkeypress=" return ches(document.searchForm,checkForm);">
<div class="page_top">登记 &gt;&gt;<c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if> &gt;&gt; 信息修改</div>
<form name="searchForm" method="post" action="/bsweb/certificate_operList.action">
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
    <input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
    <input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
    <input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
    <input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
    <input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
  <input type="hidden" name="jglx" value="${jglx }"/>
    <div id="list_main">
        <div class="list_box">
            <div class="list_box_top">
                统一代码/机构代码：<input name="tyshxydm" type="text" class="input_200" id="tyshxydm" value="${tyshxydm}" maxlength="18"/>
                机构名称：<input name="jgmc" type="text" class="input_200" id="jgmc" value="${jgmc}" maxlength="120"/>
                <input name="button2" type="button" class="newBtn1" id="button1" value="查 询" onclick="checkForm();"/>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">
                        <div style="float:left">&nbsp;序号</div>
                    </td>
                    <c:if test="${orderbyColum eq 'jgdm'}">
                        <td class="list_table_top_td" style="width:10%">
                            <div style="float:left">统一代码</div>
                            <div class="jt_box" style="float:right">
                                <c:if test="${orderbyMethod eq 'desc'}">
                                    <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif"
                                                                                      width="16" height="16"
                                                                                      title="排序字段"/></a>
                                </c:if>
                                <c:if test="${orderbyMethod ne 'desc'}">
                                    <a href="#" onclick="pageSort('jgdm','desc')"><img src="../images/jt_1.gif"
                                                                                       width="16" height="16"
                                                                                       title="排序字段"/></a>
                                </c:if>
                            </div>
                        </td>
                    </c:if>
                    <c:if test="${orderbyColum ne 'jgdm'}">
                        <td class="list_table_top_td" style="width:10%">
                            <div style="float:left">统一代码</div>
                            <div class="jt_box" style="float:right">
                                <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="排序字段"/></a>
                            </div>
                        </td>
                    </c:if>
                    <c:if test="${orderbyColum eq 'jgmc'}">
                        <td class="list_table_top_td">
                            <div style="float:left">机构名称</div>
                            <div class="jt_box" style="float:right">
                                <c:if test="${orderbyMethod eq 'desc'}">
                                    <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif"
                                                                                      width="16" height="16"
                                                                                      title="排序字段"/></a>
                                </c:if>
                                <c:if test="${orderbyMethod ne 'desc'}">
                                    <a href="#" onclick="pageSort('jgmc','desc')"><img src="../images/jt_1.gif"
                                                                                       width="16" height="16"
                                                                                       title="排序字段"/></a>
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
                       <td class="list_table_top_td">
                            <div style="float:left">行政区划</div>
                      </td>
                      <td class="list_table_top_td">
                            <div style="float:left">批准文号</div>
                      </td>
                    <c:if test="${orderbyColum eq 'bzrq'}">
                        <td class="list_table_top_td" style="width:10%">
                            <div style="float:left">办证日期</div>
                            <div class="jt_box" style="float:right">
                                <c:if test="${orderbyMethod eq 'desc'}">
                                    <a href="#" onclick="pageSort('bzrq','asc')"><img src="../images/jt_2.gif"
                                                                                      width="16" height="16"
                                                                                      title="排序字段"/></a>
                                </c:if>
                                <c:if test="${orderbyMethod ne 'desc'}">
                                    <a href="#" onclick="pageSort('bzrq','desc')"><img src="../images/jt_1.gif"
                                                                                       width="16" height="16"
                                                                                       title="排序字段"/></a>
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
             <td class="list_table_top_td" style="width:12%">重名审核</td>
                    <td class="list_table_top_td" style="width:5%" align="center">修改</td>
                </tr>
                <c:forEach varStatus="i" var="tjgdmsave" items="${tjgdmList}">
                    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${tjgdmsave.jgdm }</td>
                        <td>${tjgdmsave.jgmc }</td>
                        <td>${tjgdmsave.xzqh }</td>
                        <td>${tjgdmsave.zch }</td>
                        <td><fmt:formatDate value="${tjgdmsave.bzrq}" pattern="yyyy-MM-dd"/></td>
                                             <c:choose>
                            <c:when test="${tjgdmsave.flag=='0'}">
                                <td>已提交审核</td>
                                <td align="center"><img src="../../images/icon_edit1.gif" width="16" height="16"
                                                        onclick="ymPrompt.alert({message:'已提交审核,不能修改！', width:330, height:220, title:'提示信息'});"
                                                        style="cursor:pointer" title="修改"/></td>
                            </c:when>
                            <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='1'}">
                                <td>已审核,允许重名</td>
                                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                                        onclick="checkCode('${tjgdmsave.jgdm}','t_sptemp');"
                                                        style="cursor:pointer" title="修改"/></td>
                            </c:when>
                            <c:when test="${tjgdmsave.flag=='1' and fn:trim(tjgdmsave.shflag)=='0'}">
                                <td>已审核,不允许重名</td>
                                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                                        onclick="checkCode('${tjgdmsave.jgdm}','t_jgdm');"
                                                        style="cursor:pointer" title="修改"/></td>
                            </c:when>
                            <c:when test="${tjgdmsave.flag eq ''}">
                                <td>不需要重名审核</td>
                                <td align="center"><img src="../../images/icon_edit.gif" width="16" height="16"
                                                        onclick="checkCode('${tjgdmsave.jgdm}','t_jgdm');"
                                                        style="cursor:pointer" title="修改"/></td>
                            </c:when>
                        </c:choose>
                           
                             
                         
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
                <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页"
                       onClick="previousPage();" style="cursor:pointer"/>
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
                <input value="${pages.currentPage }" name="pageno" id="pageno"  type="text" class="input_ym"/>
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