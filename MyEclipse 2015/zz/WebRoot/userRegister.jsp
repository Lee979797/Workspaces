<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>组织机构代码中心网上办证系统 —— 用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #FFFFFF;
	}
	.input1 {
		width: 150px;
	}
-->
</style>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="js/page.js"></script>
<script type='text/javascript' src='js/engine.js'></script>
<script type='text/javascript' src='js/util.js'></script>
<script language="JavaScript"  src="js/public.js"></script>
<script language="JavaScript"  src="js/corpnamevalidate.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css" />
<script type="text/javascript" src="adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="ext-all.js"></script>
  <script type="text/javascript" src="locale/ext-lang-zh_CN.js"></script>  
<script type="text/javascript" src="userRegister.js"></script>
<script language="JavaScript" type="text/JavaScript">
function changeStyle(elementID,toStyle) {
  document.getElementById(elementID).className=toStyle;
}

//检查移动电话格式
function checkMobileAction(obj,strmsg) {
	if(obj==null)return true;
	var mobile = obj.value;
	if (mobile=="") {
		alert("["+strmsg+"]不能为空！");
		return false;
	}
	if (isNaN(mobile)||mobile.length!=11){
		window.alert("["+strmsg+"]输入的格式不正确!");
		return false;
	}else{
	}
	return true;
}

 
//核对用户名是否存在
function checkZuser(){
    var userName=document.getElementById("userName").value;
	if(userName!=null && userName.length>0){
   		Ext.Ajax.request({
			url : 'checkZuser.action?userName='+userName,
			success: function(result,request){
				var resultObject2 = Ext.util.JSON.decode(result.responseText); 
				//alert(resultObject2.success);
				if(resultObject2.success){
					changeStyle('s1','msg4');
		  	    	document.getElementById("s1").innerHTML = '用户名'+userName+'已被注册，请重新输入！';
				}else{
					changeStyle('s1','msg4');
		  	    	document.getElementById("s1").innerHTML = '用户名'+userName+'可以注册！';
				}				
			},
			failure : function() {
				alert("系统运行错误");
			}
		});
   		
	}
}


function mySubmit(){
	if(document.getElementById('userName').value==''){
		alert("“登录名称”不能为空！");
		return;
	}
	if(document.getElementById('fPassword').value==''){
		alert("“密码”不能为空！");
		return;
	}
	if (document.getElementById('fPassword').value!=document.getElementById('rPassword').value) {
		alert("两次密码输入不一致！");
		return;
	}
	if(document.getElementById('validateStr').value==''){
		alert("“验证码”不能为空！");
		return;
	}
	if (document.getElementById('orgName').value=='') {
		alert("“机构名称”不能为空！");
		return;
	}
	if (document.getElementById('pzjgmc').value=='') {
		alert("“批准机构名称”不能为空！");
		return;
	}
	if (document.getElementById('orgZch').value=='') {
		alert("批准文号或注册号”不能为空！");
		return;
	}
	
	if (document.getElementById('email').value=='') {
		alert("“电子信箱”不能为空！");
		return;
	}
	if (document.getElementById('tel').value=='') {
		alert("“联系电话”不能为空！");
		return;
	}
	userRegisterForm.submit();
	
}


function changeImage() {
	//window.location.reload(true);
	document.getElementById("imageId").src="regImages.jsp?t=" + (new Date());
}
 
function sss() {
	alert("ssss");
	window_pzjgQuery_ur.show();
}
 
</script>

<link href="css/flow.css" rel="stylesheet" type="text/css">
</head>

<body >
<center>	    
<div style="width:1000px; border-left:1px solid #cccccc; text-align:center;border-right:1px solid #cccccc">
<link href="css/outweball.css" rel="stylesheet" type="text/css" />
<table width="1000" border="0" cellpadding="0" cellspacing="0">
	<tr>
	  	<td><img src="images/userRegister.jpg" alt="" width="1000" height="145" border="0" ></td>
	</tr>
	<tr>
		<td height="25" background="images/head_banner_bg.jpg">
			<table width="100%" border="0" cellpadding="2" cellspacing="0">
			   <tr>
			     <td width="170" align="center"><script language="JavaScript">new Date();</script></td>
			     <td align="right">| 
			      <a href="index.jsp">首页</a>  |  <a href="javascript:window.showModalDialog('qa.htm',window,'dialogWidth:700px;dialogHeight:600px;center:yes;status:no;resizable:yes;help:no');">常见问题</a> |      下载中心 | 
			     <td width="10">&nbsp;</td>
			   </tr>
		 	</table>
		</td>
	</tr>
</table>
<table width="800" align="center" cellpadding="3" cellspacing="0" align=center > 
	<tr>
		<td align="center" height=50><font size=5><b>用户注册</b></font></td>
	</tr>
	<tr>
		<td align="center"><font color=red><s:property value="tip" /></font></td>
	</tr>
</table>
<s:form method="post" action="regZuser.action" name="userRegisterForm"  theme="simple">
<!-- <form name="userRegisterForm" method="post" action="regZuser.action">  -->
<table width="800" align="center" cellpadding="3" cellspacing="0" align=center >
	<tr>
		<td colspan="3"  class="add_tr">登录信息：</td>
	</tr>
	<tr>
	    <td width="150"  align="right"><font color="red">*</font> 登录名称</td>
	    <td width="170" ><input maxlength="16" id="userName" name="userName"   class="input1" class=form value="<s:property value="userName" />"
														autocomplete="off"  type="text" size="20" 
			onfocus="changeStyle('s1','msg2');" onblur="changeStyle('s1','msg1');checkZuser();"  class="input1">
			</td>
	    <td ><div id="s1" class="msg1" style="float:left">请使用英文字母和数字填写用户名，最多16个字符，如smith。</div></td>
	</tr>
	     
	 
	<tr>
	    <td  align="right"><font color="red">*</font> 登录密码</td>
	    <td ><input id="fPassword"  name="userPwd"  class="input1"    class=form value="<s:property value="userPwd" />"
			autocomplete="off" type="password" size="20" maxlength="20" class="input1"
			onFocus="changeStyle('s2','msg2');"
			onBlur="changeStyle('s2','msg1');">
	      </td>
	    <td ><div id="s2" class="msg1" style="float:left">密码长度应为6-20位，建议大小写字母和符号的混合使用。</div></td>
	</tr>
 
   
	<tr>
    	<td  align="right"><font color="red">*</font> 确认密码</td>
    	<td ><input id="rPassword" name="userPwd2" class="input1"   class=form value="<s:property value="userPwd" />"
			autocomplete="off" type="password" size="20" maxlength="20"></td>
    	<td ><div id="s3" class="msg1" style="float:left"></div></td>
	</tr>
  	<tr>
	    <td  align="right"><font color="red">*</font> 验  证  码</td>
	    <td >
	    	
	    	<input id="validateStr" name="validateStr" type="text" size="8" 
			onfocus="changeStyle('s10','msg2');"
			onblur="changeStyle('s10','msg1');" >
			<input id="validateStr2" name="validateStr2" type="hidden" value='<%=session.getAttribute("ccode")%>'><img id = "imageId" src="regImages.jsp" align="absmiddle" onclick="changeImage()" style="cursor:pointer;"  title="看不清楚，换一个"/></td>
	    <td ><div id="s10" class="msg1" style="float:left">请输验证码！（<a onclick="changeImage()" style="cursor:hand;">看不清，更换验证码</a>）</div></td>
  	</tr>  
  	<tr>
    	<td colspan="3" class="add_tr">机构基本信息</td> 
	</tr>
 	<tr>
 		<td  align="right" colspan="3">机构代码</td>
		<!-- <td  align="right" >机构代码</td>
	    <td ><input name="orgCode" id="orgCode" class="input1" class=form value="<s:property value="orgCode" />"
														autocomplete="off"  type="text" size="20"
			onfocus="changeStyle('s63','msg2');"
			onblur="changeStyle('s63','msg1');" ></td>
	    <td ><div id="s63" class="msg1" style="float:left">新办机构，无机构代码证书，可不用填写。</div></td> -->
	</tr>
 	<tr>
		<td  align="right"><font color="red">*</font> 机构名称</td>
	    <td ><input name="orgName"  id="orgName"  class=form value="<s:property value="orgName" />"
														autocomplete="off"  type="text" size="30"
			onfocus="changeStyle('s62','msg2');"
			onblur="changeStyle('s62','msg1');" ></td>
	    <td ><div id="s62" class="msg1" style="float:left">机构名称请填写正确，否则不能办理。</div></td>
	</tr>
	<tr>
    	<td  align="right"><font color="red">*</font> 机构地址</td>
    	<td  colspan="2"><input name="address"   id="address" class=form value="<s:property value="address" />"
														autocomplete="off"  type="text" size="80"></td>
  	</tr>
  	<tr>
    	<td  align="right"><font color="red">*</font> 批准机构名称</td>
    	<td ><input id="pzjgmc" class="input1" name="pzjgmc" class=form value="<s:property value="pzjgmc" />"
														autocomplete="off"  type="text" size="30"
			onfocus="changeStyle('s120','msg2');"
			onblur="changeStyle('s120','msg1');" >
			<input id="pzjgmc" name="pzjgdm"  value="<s:property value="pzjgdm" />" autocomplete="off"  type="hidden" size="20">
			<input type="button" id="show-btn" value="查询" /></td>
    	<td ><div id="s120" class="msg1" style="float:left">请输入批准登记注册批准的机构名称，如工商局行政管理员等。</div></td>
	</tr>
	<tr>
		<td  align="right"><font color="red">*</font> 批准文号或注册号</td>
	    <td ><input name="orgZch" id="orgZch" class="input1" class=form value="<s:property value="orgZch" />"
														autocomplete="off"  type="text" size="20"
			onfocus="changeStyle('s61','msg2');" onblur="changeStyle('s61','msg1');" ></td>
	    <td ><div id="s61" class="msg1" style="float:left">请注意：注册号为机构成立的批准证书编码。</div></td>
	</tr>
	 
	<tr>
    	<td  align="right"><font color="red">*</font> 电子信箱</td>
    	<td ><input id="email" class="input1" name="email" class=form value="<s:property value="email" />"
														autocomplete="off"  type="text" size="20"
			onfocus="changeStyle('s20','msg2');"
			onblur="changeStyle('s20','msg1');" ></td>
    	<td ><div id="s20" class="msg1" style="float:left">请输入真实有效的邮箱地址，可凭此邮箱找回密码。</div></td>
	</tr>
	
  
  	<!-- 
  	<tr>
    	<td  align="right">邮政编码</td>
    	<td ><input name="postalcode" id="postalcode" value=""  type="text" maxlength="6" size="20"></td>
    	<td >&nbsp;</td>
  	</tr>
  	 -->
	<tr>
	    <td  align="right"><font color="red">*</font> 联系电话</td>
	    <td ><input name="tel" class="input1"  id="tel"  class=form value="<s:property value="tel" />"
														autocomplete="off"  type="text" size="20"
			onfocus="changeStyle('s40','msg2');"
			onblur="changeStyle('s40','msg1');" ></td>
	    <td ><div id="s40" class="msg1" style="float:left">电话号码仅允许输入数字，例如01066692008 或 139******** </div></td>
	</tr>
</table>

<table height="35"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center"><input name="Submit22" onClick="mySubmit();" type="button"  class="ButtonCss" value="确 定">

      &nbsp; </td>
    <td align="center">&nbsp;
        <input name="Submit22" type="reset"  class="ButtonCss" value="重 置">
      &nbsp; </td>
  </tr>
  
</table>
</s:form>
<!-- </form> -->

<style type="text/css">
<!--
.STYLE3 {color: #999999}
-->
</style>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td  align="center" background="images/index_11.jpg">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
		    <td align="center">
			    <span style="color: #FFFFFF;">建议使用IE6.0及以上版本, 分辨率1024x768.</span>
		    </td>
	  </tr>
	  <tr>
	        <td align="center"><span style="color: #FFFFFF;">全国组织机构代码管理中心&nbsp;&nbsp;&nbsp;&nbsp;版权所有</span></td>
	  </tr>
	 </table>
	</td>
  </tr>
</table>
</div>
</center>

	
</body>
</html>
