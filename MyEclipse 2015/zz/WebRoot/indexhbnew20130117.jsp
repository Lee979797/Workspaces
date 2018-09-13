<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>组织机构代码中心网上办证系统 ----用户登 录</title>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="css/global.css" type=text/css rel=STYLESHEET>
<LINK href="css/main.css" type=text/css rel=STYLESHEET>
<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css" />
<script type="text/javascript" src="adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="ext-all.js"></script>
  <script type="text/javascript" src="locale/ext-lang-zh_CN.js"></script>
<script language="JavaScript" type="text/JavaScript" src="js/page.js"></script>
<script type='text/javascript' src='js/engine.js'></script>
<script type='text/javascript' src='js/util.js'></script>
<script language="JavaScript"  src="js/public.js"></script>
<script language="JavaScript"  src="js/corpnamevalidate.js"></script>
<script type="text/javascript" src="validate/validate.js"></script>
<style type="text/css">
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
</style>

<script>
	function check(){
		
		var frm = document.form1;
		if(frm.userName.value==""){
			alert("用户名不能为空!");
			frm.userName.focus();
			return false;
		}else if(frm.userPwd.value==""){
		    alert("登录密码不能为空!");
		    frm.userPwd.focus();
		    return false;
		}else if(frm.validateStr11.value==""){
			alert("验证码不能为空!");
		    frm.validateStr11.focus();
		    return false;
		}else {
			return true;
		}
	}
	
</script>
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
    var userName=document.getElementById("fuserName").value;
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
	}else{
		document.getElementById("s1").innerHTML = '请使用英文字母和数字填写用户名，最多16个字符，如smith。';
	}
}


function mySubmit(){
	var v;
	if(document.getElementById('fuserName').value==''){
		alert("“登录名称”不能为空！");
		return;
	}
	if(document.getElementById('fPassword').value==''){
		alert("“密码”不能为空！");
		return;
	}
	var value = document.getElementById('fPassword').value;
	if(value.length<6||value.length>20){
		alert("密码位数应为6-20位!");
		return;
	}
	if (document.getElementById('fPassword').value!=document.getElementById('rPassword').value) {
		alert("两次密码输入不一致！");
		return;
	}
	v = document.getElementById('validateStr').value;
	if(v==''){
		alert("“验证码”不能为空！");
		return;
	}
	v = document.getElementById("orgCode").value;
	if(v!=""){
		var flag = verifyCode(v);
		if(flag == false){
			alert("机构代码输入无效！");
			return;
		}
	}
	if (document.getElementById('orgName').value=='') {
		alert("“机构名称”不能为空！");
		return;
	}
	if (document.getElementById('pzjgmc').value=='') {
		alert("“批准机构名称”不能为空！");
		return;
	}
	v = document.getElementById('orgZch').value;
	if (v=='') {
		alert("批准文号或注册号”不能为空！");
		return;
	}
	if(v!=''){alert(v.length);
		if(v.length<15){
			var r=confirm("注册号长度少于15，确定要继续吗？");
			if (r==false){
			    return;
			}
		}
	}
	v = document.getElementById('email').value;
	if (v=='') {
		alert("“电子信箱”不能为空！");
		return;
	}
	if (v!='') {
		//alert("“电子信箱”！");
		var reg = /^\w*[-_]*\w*@\w+.com$/;
		//alert(v.match(reg));
		if(v.match(reg)==null){
			alert("“电子信箱”格式不正确！");
			return;
		}
	}
	v = document.getElementById('tel').value;
	if (v=='') {
		alert("“联系电话”不能为空！");
		return;
	}
	if (v!=''){
		if(v.length<3||v.length>20){
			return;
		}else{
			var reg = /^\d+[\d-]*$/;
			if(v.match(reg)==null){
				alert("“联系电话”输入的格式不正确!");
				return;
			}
		}
	}
	userRegisterForm.submit();
	
}


function changeImage() {
	//window.location.reload(true);
	document.getElementById("imageId").src="regImages.jsp?t=" + (new Date());
}
function changeImage1() {
	//window.location.reload(true);
	document.getElementById("imageId1").src="regImages1.jsp?t=" + (new Date());
}
 
function sss() {
	alert("ssss");
	window_pzjgQuery_ur.show();
}

</script>

<link href="css/flow.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE1 {
	color: #3399FF;
	font-size: 12px;
	font-weight: bold;
}
.STYLE5 {
	color: #000000;
	font-size: 12px;
}
-->
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no"  onLoad="javascript:document.form1.userName.focus();">
<center>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:20px;">
  <tr>
    <td valign="middle">
   
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  height="100%" width="800" align="center">
			<table  border="0" align="center" >
				<tr style="height:36px; ">
					<td style="background:url(wsbl/wsbl_title_bg.png);padding-top:5px; text-align:center; line-height:150%; font-size:16px; color:#FFFFFF; font-weight:bold">注册信息</td>
					<td width="5"></td>
					<td style="background:url(wsbl/wsbl_title_bg.png);padding-top:5px; text-align:center;line-height:150%; font-size:16px; color:#FFFFFF;font-weight:bold">登录信息</td>
				</tr>
				<tr style="background:url(wsbl/wsbl_content_bg.png);">
					<td align=center >
						<s:form method="post" action="regZuser.action" id="userRegisterForm"  name="userRegisterForm"  theme="simple">
						<!-- <form name="userRegisterForm" method="post" action="regZuser.action">  -->
						<table width="600" border="0" align="center" height=300 cellpadding="3" cellspacing="0" >
							<tr>
								<td align="left" colspan="3" >
									<img src="wsbl/dlxx_title.png" style="text-align:center" />
								</td>
							</tr>
							<tr>
							    <td width="150"  align="right"><font color="red">*</font> 登录名称</td>
							    <td width="170" ><input maxlength="16" id="fuserName" name="userName"   class="input1" class=form value="<s:property value="userName" />"
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
						    	<td ><input id="rPassword" name="userPwd2" class="input1"   class=form 
									autocomplete="off" type="password" size="20" maxlength="20"></td>
						    	<td ><div id="s3" class="msg1" style="float:left"></div></td>
							</tr>
						  	<tr>
							    <td  align="right"><font color="red">*</font> 验   证   码 </td>
							    <td >
							    	
							    	<input id="validateStr" name="validateStr" type="text" size="8" style="WIDTH: 85px"
									onfocus="changeStyle('s10','msg2');"
									onblur="changeStyle('s10','msg1');" >
									<img id = "imageId" src="regImages.jsp" align="absmiddle" onclick="changeImage()" style="cursor:pointer;"  title="看不清楚，换一个"/>
									<input id="validateStr2" name="validateStr2" type="hidden" value='<%=session.getAttribute("ccode")%>'/></td>
							    <td ><div id="s10" class="msg1" style="float:left">请输验证码！（<a onclick="changeImage()" style="cursor:hand;">看不清，更换验证码</a>）</div></td>
						  	</tr>  
						  	<tr>
						    	<td align="left" colspan="3">
									<img src="wsbl/jgxx_title.png" style="text-align:center" />
								</td> 
							</tr>
						 	<tr>
								<td  align="right">机构代码</td>
							    <td ><input name="orgCode" id="orgCode" class="input1" class=form value="<s:property value="orgCode" />"
																				autocomplete="off"  type="text" size="20"
									onfocus="changeStyle('s63','msg2');"
									onblur="changeStyle('s63','msg1');" ></td>
							    <td ><div id="s63" class="msg1" style="float:left">新办机构，无机构代码证书，可不用填写。</div></td>
							</tr>
						 	<tr>
								<td  align="right"><font color="red">*</font> 机构名称</td>
							    <td ><input name="orgName" id="orgName" class="input1" class=form value="<s:property value="orgName" />"
																				autocomplete="off"  type="text" size="30"
									onfocus="changeStyle('s62','msg2');"
									onblur="changeStyle('s62','msg1');" ></td>
							    <td ><div id="s62" class="msg1" style="float:left">机构名称请填写正确，否则不能办理。</div></td>
							</tr>
							<tr>
						    	<td  align="right"><font color="red">*</font> 机构地址</td>
						    	<td  colspan="2"><input name="address" id="address"style="width:430px;margin-left:7px; float:left;" class=form value="<s:property value="address" />"
																				autocomplete="off"  type="text" size="80"></td>
						  	</tr>
						  	<tr>
						    	<td  align="right"><font color="red">*</font> 批准机构名称</td>
						    	<td ><input style="width:113px"  id="pzjgmc" class="input1" name="pzjgmc" class=form value="<s:property value="pzjgmc" />"
																				autocomplete="off"  type="text" size="30"
									onfocus="changeStyle('s120','msg2');"
									onblur="changeStyle('s120','msg1');" >
									<input id="pzjgdm" name="pzjgdm"  value="<s:property value="pzjgdm" />" autocomplete="off"  type="hidden" size="20">
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
							<tr>
								<td>&nbsp; </td>
							    <td align="center" >
							    	<!-- <input name="Submit22" onClick="mySubmit();" type="button" value="确 定"> -->
							    	
							    	<img onclick="return mySubmit();"  src="wsbl/wsbl_nav_confirm.png" style="cursor:pointer;" />
									&nbsp; 
									<!-- <input name="Submit22" type="reset"  value="重 置">  -->
							        <img src="wsbl/wsbl_nav_change.png" onclick="userRegisterForm.reset();"style="cursor:pointer;"/>
							      	&nbsp;
								</td>
							    <td align="center">&nbsp;
							    </td>
							 </tr>
						</table>
						
						<table height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
						  
						  
						</table>
						</s:form>
						<!-- </form> -->
					</td>
					<td width="5"style="background-color: white"></td>
					<!-- 此为分界线 -->
        			<td align="right">
        				<s:form method="post" action="zlogin.action" id="form1" name="form1" theme="simple">
							<TABLE cellSpacing=0 cellPadding=0  align="top" width=380 height=300 border=0>
								<TBODY>
									<TR>
										<TD height=10 align=center><font color="red" size="3"><s:property value="tip" /></font></TD>
									</TR>
									<TR>
										<TD align=center>
											<SPAN class=content_black_bold>用户名:</SPAN>
											<FONT class=form><INPUT class=form value="<s:property value="userName" />"
													autocomplete="off" style="WIDTH: 150px"
													maxLength=28 name=userName></FONT>
											<input type="hidden" name="state" value="false">
										</TD>
									</TR>
									<TR>
										<TD height=5>
										</TD>
									</TR>
									<TR>
										<TD align=center>
											<SPAN class=content_black_bold>密&nbsp;&nbsp;&nbsp;&nbsp;码:</SPAN>
											<FONT class=form><INPUT class=form value="<s:property value="userPwd" />"
													style="WIDTH: 150px" type="password" maxLength=32
													name="userPwd" ><!--<INPUT class=form value="1"
													style="WIDTH: 150px" type="password" maxLength=32
													name="userPwd">--></FONT>
										</TD>
									</TR>
									<TR>
										<TD height=5></TD>
									</TR>
									<TR>
										<td align=center>
										<SPAN class=content_black_bold>验证码:</SPAN>
									    	<FONT class=form><input class=form style="WIDTH: 85px"  id="validateStr11" name="validateStr11" type="text" size="8" 
											onfocus="changeStyle('s101','msg2');"
											onblur="changeStyle('s101','msg1');" ></FONT>
											<img id = "imageId1" src="regImages1.jsp" align="absmiddle" onclick="changeImage1()" style="cursor:pointer;"  title="看不清楚，换一个"/>
											<input id="validateStr21" name="validateStr21" type="hidden" value="<%=session.getAttribute("ccode1")%>"/>
											
										</td><!--  -->
									</TR>
									<TR>
										<TD height=5 align=center><div id="s101" class="msg1" style="float:center">请输验证码！（<a onclick="changeImage1()" style="cursor:hand;">看不清，更换验证码</a>）</div></TD>
									</TR>
									<TR>
										<TD noWrap align=center>
											<span style="padding-left: 47px;">
												<!-- <input type="submit" value="提  交"/> onclick="this.form.submit();" -->
												<img src="wsbl/wsbl_nav_submit.png"onclick="check();form1.submit();" style="cursor:pointer;"/>
											</span>
											<span style="padding-left: 20px;">
												<!-- <input type="reset" value="重   置"/> -->
												<img src="wsbl/wsbl_nav_change.png" onclick="form1.reset();"style="cursor:pointer;"/>
											</span>
										</TD>
									</TR>
									<TR>
										<TD height=5></TD>
									</TR>
									<TR>
										<TD class=content_gray vAlign=top align=center>
											
										</TD>
									</TR>
									
								</TBODY>
							</TABLE>
						</s:form>
        			</td>
				  	
				</tr>
				
		    </table>	
		</td>	
        
      </tr>
    </table>
	  
      <div id="info" class="divCs"></div>		
      </td>
  </tr>
</table>
</center>
</body>
</html>
