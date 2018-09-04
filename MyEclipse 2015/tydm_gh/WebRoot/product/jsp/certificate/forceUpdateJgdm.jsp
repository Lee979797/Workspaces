<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="net.sf.cglib.beans.BeanCopier" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    TJgdm tJgdm = (TJgdm) request.getAttribute("tjgdm");
    String bzDate = tJgdm.getBzrq() == null ? "" : tJgdm.getBzrq().toString().substring(0, 10);
    //String njDate = tJgdm.getNjqx() == null ? "" :  tJgdm.getNjqx().toString().substring(0, 10);
    String zfDate = tJgdm.getZfrq() == null ? "" : tJgdm.getZfrq().toString().substring(0, 10);
    request.setAttribute("tJgdm", tJgdm);
    String jglx = (String) request.getAttribute("jglx");
%>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jglxBsxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/btxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/qtmdkBus.js"></script>
    <script type="text/javascript">
	$(function(){   $("#jgmc").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function getItems(items) {
            if (items && items.length > 0) {
                var fields = items.split(",");
                for (var i = 0; i < fields.length; i++) {
                    var item = $(fields[i]);
                    if (item != undefined && (item.val() == null || item.val() == '')) {
                        return fields[i].substring(1, fields[i].length);
                    }
                }
            }
            return undefined;
        }
        function checkNotNull() {
            var item = getItems($("#btxs").val());

            if (item == undefined || item == null) {
                return true;
            } else {
                dwr.engine.setAsync(false);
                btxBus.getFieldName(item, function (data) {
                    ymPrompt.alert({message: data + "不能为空!", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                        if ("ok" == tp) {
                            $("#" + item).focus()
                            ;
                        }
                    }});
                });
                return false;
            }
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div style=" float: left;"> 发证 &gt;&gt; 常用工具 &gt;&gt; 强制修改</div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue(${jglx});" type=button value="修 改" name="btok"/>&nbsp;
        <INPUT class="newBtn1"
               onClick="window.location.href='<%=request.getContextPath() %>/product/jsp/certificate/forceUpdate.jsp'"
               type=button value="返 回" name="cmdExit"/>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>
<form method="post" action="/bsweb/certificate_forceUpdate.action" name="busForm">
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <INPUT type="hidden" name="btxs" id="btxs"/>
    <INPUT type="hidden" name="isxb" id="isxb" value="qzxg"/>
    <input type="hidden" name="bzjgdm" id="bzjgdm" value="${fn:trim(tJgdm.bzjgdm) }"/>
     <INPUT type="hidden" name="jgdm" id="jgdm" value="<%=tJgdm.getJgdm() %>"/>
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">

                    <div class="list listblue">
                        <h3><b>基础数据项</b><span>（请注意：此区域内容必须填写。）</span></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >

                            <TR>
                                <TD class=td1 width="15%" align=right id="needJgdm">
                                    统一代码
                                </TD>
                                <TD class=td1 >
                                    <INPUT readonly="true" size=28 name="tyshxydm" id="tyshxydm" value="<%=tJgdm.getTyshxydm()%>"
                                           style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"/>
                                </TD>
                                <td class=td1 width="15%" align="right"></td>
                                <td class=td1 ></td>
                            </TR>

                            <%@ include file="common_edit_choose1Save.jsp" %>

                        </TABLE>
                    </div>
                                        </div>
                        <div id="dj" class="list listblue">
					<h3><b>党建信息	&nbsp;&nbsp;
	   <INPUT onclick="fChangeDangJian(0);" type=radio
      value="0" name="isdang" ${("0"==tJgdm.isdang )?"checked":""}/>
        已建立党组织&nbsp;&nbsp;
        <INPUT onclick="fChangeDangJian(1);" type=radio  value="1"  name="isdang" ${("1"==tJgdm.isdang or tJgdm.isdang==null)?"checked":""}/>
    未建立党组织</b></h3>
	

    
	<div id="dangjian" style="${("1" eq tJgdm.isdang or tJgdm.isdang==null)?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
    

     <td class=td1 style="width:15%" align=right>
    	 党组织类型
    </td>
    
    <td class=td1>
     	
     
   
          <SELECT name="dzzlx" id="dzzlx" style="width:200px"/>
            <c:forEach items="${dzzlxList}" var="dzzlx">
          <OPTION value="${dzzlx.dm}" ${tJgdm.dzzlx==dzzlx.dm?"selected":""} >${dzzlx.mc} </OPTION>
         </c:forEach>
         
        </SELECT>
    </td>
</TR>
<tr>
 <td class=td1 align=right>
    	 党组织负责人
    </td>
    
    <td class=td1>
     	
     
   
          <input name="dzzfzr" id="dzzfzr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.dzzfzr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="dzzfzrzjlx" id="dzzfzrzjlx"/>
   
          <c:forEach items="${zjlxList}" var="zj">
          <OPTION value="${zj.dm}" ${tJgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="dzzfzrzjhm" id="dzzfzrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
        onpaste=" showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);"
               value="${tJgdm.dzzfzrzjhm }">
                            <INPUT class="num no-border-bx" id="dzzfzrzjhmlength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dzzfzrzjhm"), document.getElementById("dzzfzrzjhmlength"), 0);
        </script>
        <span id="pzjginfo"></span>
    </td>
</tr>
<tr>
 <td class=td1 align=right>
    	 党建联系人
    </td>
    
    <td class=td1>
     	
     
   
          <input name="djlxr" id="djlxr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.djlxr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="djlxrzjlx" id="djlxrzjlx"/>
   
          <c:forEach items="${zjlxList}" var="zj">
       			 <OPTION value="${zj.dm}" ${tJgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="djlxrzjhm" id="djlxrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);"
               value="${tJgdm.djlxrzjhm }">
                     <INPUT class="num no-border-bx" id="djlxrzjhmlength"         
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("djlxrzjhm"), document.getElementById("djlxrzjhmlength"), 0);
        </script>
    </td>
</tr>
<tr>
     <td class=td1 align=right>
       	党建联系人电话
    </td>
    <td class=td1>
         <input name="djlxrdhhm" id="djlxrdhhm" type="text" maxLength="25" 
         onpaste=" showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);"
         style="z-index: 100; position: relative; width:200px;" value="${tJgdm.djlxrdhhm }">
                          <INPUT class="num no-border-bx" id="djlxrdhhmlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("djlxrdhhm"), document.getElementById("djlxrdhhmlength"), 0);
        </script>
    </td>
     <td class=td1 align=right>
        	党组织成立时间
    </td>
    <td class=td1>
            <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('dzzclrq')}); "onclick="WdatePicker({el:$dp.$('dzzclrq')});"
               maxLength=10 size=23
               name="tdzzclrq" id="dzzclrq" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true"
               value="<fmt:formatDate value='${tJgdm.dzzclrq}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('dzzclrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>
  
    
</TR>
<tr>
	  <td class=td1 align=right>
       	上级党组织名称
    </td>
    <td class=td1  colSpan=3>
         <input name="sjdzzmc" id="sjdzzmc" type="text" maxLength="60" style="width:75%;" value="${tJgdm.sjdzzmc }">
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       专职工作人员数量中党员数量
    </td>
    <td class=td1>
         <input name="zzdysl" id="zzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.zzdysl }">
    </td>
     <td class=td1 align=right>
    	兼职工作人员数量中党员数量
    </td>
    
    <td class=td1>
          <input name="jzdysl" id="jzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.jzdysl }">
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="${"0" eq tJgdm.isdang?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right>
		未建立原因
		</td> 
		<td class=td1>
		<SELECT name="wjlyy" id="wjlyy" style="width:300px"/>
		 	<c:forEach items="${yyList}" var="yy">
       			 <OPTION value="${yy.dm}" ${tJgdm.wjlyy==yy.dm?"selected":""} >${yy.mc} </OPTION>
         	</c:forEach>
        </SELECT>
		</td>
	</tr>
	</TABLE>
	</div>
</div> 
             
					<div id="list_context" class="list listblue">
					         	<h3><b>负责人信息</b></h3>
                    <c:forEach varStatus="i" var="list" items="${listFzr}">
                    <div>
                    	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
                    	<input type="hidden" name="fzr.id" value="${list.lsh }"/>
								<tr>
									<td class=td1 align=right width="15%">
										姓名
									</td>
									<td class=td1>
										<input type="text" name="fzr.xm" value="${list.xm }" maxlength="50" >
											<c:if test="${i.count eq 1}">
										<INPUT class="button" onClick="copyFr()" type="button" value=复制 name="btselect2"/>&nbsp;
										</c:if>
									</td>
									<td class=td1 align="right">&nbsp;
        								<SELECT name="fzr.zjlx" id="ryzjlx"/>
        			    				 <c:forEach items="${zjlxList}" var="zj">
    					    				 <OPTION value="${zj.dm}" ${list.zjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
        								 </c:forEach>
        								</SELECT>
   										</td>
		
		
										<td class=td1>
										<input type="text" maxlength="18"  name="fzr.zjhm" onpaste=" showFzrLength();" onkeyup="onlySfzh(this);showFzrLength();" value="${list.zjhm }">
										 <script type="text/javascript">
               							showFzrLength1();
        								</script>
										</td>
								
								</tr>
								<tr>
									<td class=td1 align=right>
										性别
									</td>
									<td class=td1>
										<SELECT name="fzr.xb" id="xb">
											<OPTION value="男" ${'男' eq list.xb?"selected":""}>男 </OPTION>
											<OPTION value="女" ${'女' eq list.xb?"selected":""}>女</OPTION>
										</SELECT>
									</td>
									<td class=td1 align=right>
										职务
									</td>
									<td class=td1>
										<SELECT name="fzr.zw" id="zw">
											 <c:forEach items="${zwList}" var="zw">
          		 								 <OPTION value="${zw.dm}" ${list.zw==zw.dm?"selected":"" }>${zw.mc} </OPTION>
       										 </c:forEach>
       									</SELECT>
									</td>
									
								</tr>
								
								<tr>
									<td class=td1 align=right>
										民族
									</td>
									<td class=td1>
										<SELECT name="fzr.mz" id="mz">
				 							<c:forEach items="${mList}" var="mz">
          		 								 <OPTION value="${mz.dm}" ${list.mz==mz.dm?"selected":"" }>${mz.mc} </OPTION>
       										</c:forEach>
       								    </SELECT>
									</td>
									<td class=td1 align=right>
										国别
									</td>
									<td class=td1>
										<SELECT name="fzr.gj" style="width:200px"/>
				 							<c:forEach items="${gList}" var="gj">
          		  								<OPTION value="${gj.dm}" ${list.gj==gj.dm?"selected":"" }>${gj.mc} </OPTION>
       			 							</c:forEach>
        								</SELECT>
									</td>
								
								</tr>
									<tr>
									<td class=td1 align=right>
										任职时间
									</td>
									<td class=td1>
									        <INPUT  onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});"
									               maxLength="10" size="" onclick="WdatePicker({el:$dp.$(this)});"
									               name="fzr.memo1" id="rzsj" value="<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd'/>"
									                style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true"/>
									       
									</td>
									<td class=td1 align=right>
										政治面貌
									</td>
									<td class=td1>
											<SELECT name="fzr.zzmm" id="zzmm">
											 <c:forEach items="${zzList}" var="zz">
          		 								 <OPTION value="${zz.dm}" ${list.zzmm==zz.dm?"selected":"" }>${zz.mc} </OPTION>
       			 							 </c:forEach>
       			 							</SELECT>
									</td>
									
								</tr>
								<tr>
									<td class=td1 align=right>
										工作单位
									</td>
									<td class=td1>
										<input type="text" name="fzr.dzdw" value="${list.dzdw }" maxlength="200">
									</td>
									<td class=td1 align=right>
											专职/兼职
									</td>
									<td class=td1>
										<SELECT name="fzr.iszz" id="iszz">
											<OPTION value="0" ${'0' eq list.iszz?"selected":"" }>专职</OPTION>
											<OPTION value="1" ${'1' eq list.iszz?"selected":"" }>兼职</OPTION>
										</SELECT>
									</td>
								</tr>
									<tr>
									<td class=td1 align=right>
										座机
									</td>
									<td class=td1>
										<input type="text" name="fzr.lxdh" value="${list.lxdh }" onpaste="showDhLength();" onkeyup="onlyDecimalTel(this);showDhLength();" maxlength="25">
										<script type="text/javascript">
               							showDhLength1();
        								</script>
									</td>
									<td class=td1 align=right>
									手机
									</td>
									<td class=td1>
										<input type="text" name="fzr.lxmobile" onkeyup="onlyDecimalTel(this);;showMobileLength();" onafterpaste="onlyDecimalTel(this);;showMobileLength();" value="${list.lxmobile }" maxlength="11" >
										<script type="text/javascript">
               							showMobileLength1();
        								</script>
									</td>
								
								</tr>
									<tr>
									<td class=td1 align=right>
										通讯地址
									</td>
									<td class=td1 colSpan=3>
										<input type="text" name="fzr.txdz" size="158" style="width:75%;" value="${list.txdz }" maxlength="500">
									</td>
									</tr>
									<tr>
									<td class=td1 align=right>
										邮编
									</td>
									<td class=td1>
										<input type="text" name="fzr.yb" value="${list.yb }" maxLength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);">
									</td>
									
									<td class=td1 align=right>
										电子邮箱
									</td>
									<td class=td1>
										<input type="text" name="fzr.email" value="${list.email }" maxlength="100">
									</td>
									
								</tr>
								
								
								
						
								<c:if test="${i.count ne 1}">
								<tr>
									<td align="right" colspan="4"><INPUT class="newBtn1" onClick="deletelingjian(this)" type=button value="移除" name="btok"/></td>
								</tr>
								</c:if>
							</table>
							
							<hr color="#88a6d4" width="80%" style="...."/>
							</div>
                    </c:forEach>
                     <c:if test="${listFzr eq '[]'}">
                    <jsp:include page="../common/fzronload.jsp"/>
                    </c:if>
                    </div>
                    <div class="listbtn">
                 
                        <INPUT class="newBtn1" onClick="javascript:return fCheckValue(${jglx});" type=button value="修 改"
                               name="btok"/>&nbsp;
                        <INPUT class="newBtn1"
                               onClick="window.location.href='<%=request.getContextPath() %>/product/jsp/certificate/forceUpdate.jsp'"
                               type=button value="返 回" name="cmdExit"/>
                                <INPUT class="newBtn1" type=button onClick="add_div()" value="添加负责人"/>&nbsp;
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
<script>
    (function () {
        var $backToTopTxt = "返回顶部", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6下的定位
            if (!window.XMLHttpRequest) {
                $backToTopEle.css("top", st + winh - 166);
            }
        };
        $(window).bind("scroll", $backToTopFun);
        $(function () {
            $backToTopFun();
        });
    })();
</script>
<script>
    <%
   Object msg = request.getAttribute("resultMsg");
    if(msg != null&&!"".equals(msg.toString().trim())){
         if("codeRepeat".equals(msg.toString())){
    %>
    ymPrompt.alert('机构名称重复!存在${sourceTable}里!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}else if("zchRepeat".equals(msg.toString())){%>
    ymPrompt.alert('注册号重复!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}else if("fzcRepeat".equals(msg.toString())){%>
    ymPrompt.alert('机构名称，注册号不允许同时重复!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%
    }else{%>
    ymPrompt.alert('系统繁忙!请稍后再试!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}
    }
    %>
</script>
<script type="text/javascript">
    window.onload = function () {
        dwr.engine.setAsync(false);
        var lx=$("#jglx").val();
        if(lx==null || lx.trim()==""){
            return;
        }
        btxBus.getBtx( lx.trim(), function (data) {
            $(".required").remove();
            $("#btxs").val(data);
            $(data).after('<span class="required">*</span>');
        });
    }
</script>
</html>
