<%@page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
<div id="lizi1"> 
	
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<input type="hidden" name="fzr.id" value=""/>
		<tr>
			<td class=td1 align=right width="15%">
				姓名
			</td>
			<td class=td1>
				<input type="text" class="fzrxm" id="fzrXm" style="z-index: 100; position: relative; width:200px;" name="fzr.xm" maxlength="50" onkeyup="onlyMc(this);">
				 <INPUT class="button" onClick="copyFr()" type="button" value=复制
               name="btselect2"/>&nbsp;
				<span style="color:red">*</span>
			</td>
			    <td class=td1 align="right">&nbsp;
        			<SELECT name="fzr.zjlx" id="ryzjlx"/>
        			     <c:forEach items="${zjlx}" var="zj">
    					     <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
        				 </c:forEach>
        			</SELECT>
   				</td>
		
		
			<td class=td1>
				<input type="text" maxlength="18"  id="fzrZjhm"
				 onpaste=" showFzrLength();" onkeyup="onlySfzh(this);showFzrLength();"
				name="fzr.zjhm" id="fzrzjhm">
				<span style="color:red">*</span>
				       <INPUT class="num no-border-bx" name="fzrzjhmlength" id="fzrzjhmlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
       
			</td>
		
		</tr>
		<tr>
			<td class=td1 align=right>
				性别
			</td>
			<td class=td1 >
				<SELECT name="fzr.xb" id="xb">
				<OPTION value="男">男 </OPTION>
				<OPTION value="女">女</OPTION>
				</SELECT>
				<span style="color:red">*</span>
			</td>
				<td class=td1 align=right>
				职务
			</td>
			<td class=td1>
			<SELECT name="fzr.zw" id="zw">
				 <c:forEach items="${zList}" var="zw">
          		  <OPTION value="${zw.dm}">${zw.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
       			 <span style="color:red">*</span>
			</td>
			
		</tr>
		
		<tr>
		<td class=td1 align=right>
				民族
			</td>
			<td class=td1>
			<SELECT name="fzr.mz" id="mz">
				 <c:forEach items="${mList}" var="mz">
          		  <OPTION value="${mz.dm}">${mz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
       			 <span style="color:red">*</span>
			</td>
			<td class=td1 align=right>
				国别
			</td>
			<td class=td1>
		
			<SELECT name="fzr.gj" style="width:200px"/>
				  <c:forEach items="${gList}" var="gj">
          		  <OPTION value="${gj.dm}" ${'156' eq gj.dm?"selected":"" }>${gj.mc} </OPTION>
       			 </c:forEach>
        	</SELECT>
        	<span style="color:red">*</span>
			</td>
		
		</tr>
			<tr>
			<td class=td1 align=right>
				任职时间
			</td>
			<td class=td1 >
				<input type="text" name="fzr.memo1" style="z-index: 100; position: relative; width:200px;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true">
				<span style="color:red">*</span>
			</td>
				<td class=td1 align=right>
				政治面貌
			</td>
			<td class=td1>
			<SELECT name="fzr.zzmm" id="zzmm">
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}">${zz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
			
		</tr>
			<tr>
				<td class=td1 align=right>
				工作单位
			</td>
			<td class=td1 >
				<input type="text" style="z-index: 100; position: relative; width:200px;" name="fzr.dzdw" maxlength="200" onkeyup="onlyMc(this);">
			</td>
			<td class=td1 align=right>
				专职/兼职
			</td>
			<td class=td1>
				<SELECT name="fzr.iszz" id="iszz">
				<OPTION value="0">专职</OPTION>
				<OPTION value="1">兼职</OPTION>
				</SELECT>
			</td>
		</tr>
			<tr>
			<td class=td1 align=right>
				座机
			</td>
			<td class=td1>
				<input type="text" id="fzrLxdh" name="fzr.lxdh" style="z-index: 100; position: relative; width:200px;" onpaste="showDhLength();" onkeyup="onlyDecimalTel(this);showDhLength();" maxlength="25" >
					       <INPUT class="num no-border-bx" name="fzrlxdhlength" id="fzrlxdhlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
			</td>
				<td class=td1 align=right>
				手机
			</td>
			<td class=td1>
				<input type="text" id="fzrMobile" name="fzr.lxmobile" onkeyup="onlyDecimalTel(this);showMobileLength();" onafterpaste="onlyDecimalZero(this);showMobileLength();" maxlength="11" >
					       <INPUT class="num no-border-bx" name="fzrsjlength" id="fzrsjlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
			</td>
		
		</tr>
		
		</tr>
			<tr>
			<td class=td1 align=right>
				通讯地址
			</td>
			<td class=td1 colSpan=3>
				<input type="text" name="fzr.txdz" size="158" style="width:75%;" maxlength="500" >
			</td>
		</tr>
	<tr>
	
			<td class=td1 align=right>
				邮编
			</td>
			<td class=td1>
				<input type="text" name="fzr.yb"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);">
			</td>
			<td class=td1 align=right>
				电子邮箱
			</td>
			<td class=td1>
				<input type="text" name="fzr.email" maxlength="100" >
			</td>
		
		</tr>
	</table>
				<hr color="#88a6d4" width="80%" style="...."/>

</div> 
