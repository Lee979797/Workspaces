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
		if(frm.userName2.value==""){
			alert("用户名不能为空!");
			frm.userName2.focus();
			return;
		}else if(frm.userPwd2.value==""){
		    alert("登录密码不能为空!");
		    frm.userPwd2.focus();
		    return;
		}else if(frm.userPwd2.value.length<6||frm.userPwd2.value.length>20){
			alert("密码位数应为6-20位!");
		    frm.userPwd2.focus();
		    return;
		}else if(frm.validateStr11.value==""){
			alert("验证码不能为空!");
		    frm.validateStr11.focus();
		    return;
		}else {
			//return true;
			//window.close();
			form1.submit();
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
	if(v!=''){
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
	}else{
		 
		var a=/^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])d{8}$)/;
		var b = /(^0?[1][35][0-9]{9}$)/;
		if(!a.test(v)&&!b.test(v)){
				alert("“联系电话”格式不正确！");
				return
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
function getOs()  
{  
    
   if(navigator.userAgent.indexOf("MSIE")>0) {  
       check();  
   }else{
	   alert("本系统仅支持IE浏览器，请自行切换浏览器！");
   }
   
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
<body bgcolor="#FFFFFF" leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no"  onLoad="javascript:document.form1.userName2.focus();">
<TABLE cellSpacing=0 cellPadding=0 width="985" align=center 
border=0>
  <TBODY>
  <TR>
    <TD vAlign=top width=2 background=index_files/index_11.gif></TD>
    <TD width=9 background=index_files/index_11.gif >　</TD>
    <TD vAlign=top width="100%">
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 bgColor=#e9f3fd>
        <TBODY>
        <TR>
          <TD height=10></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD colSpan=3>
            <TABLE id=__01 height=31 cellSpacing=0 cellPadding=0 width="100%" 
            align=center background=index_files/index_32_03.gif border=0>
              <TBODY>
              <TR>
                <TD align=left width=11><IMG height=31 alt="" 
                  src="index_files/index_32_01.gif" width=11></TD>
                <TD width=20><IMG height=16 alt="" 
                  src="index_files/index_32_06.gif" width=15></TD>
                <TD vAlign=center align=left width="558"><SPAN class=STYLE1 style="font-size:14px;">&nbsp;&nbsp;注册</SPAN></TD>
                <TD align=right width=11><IMG height=31 alt="" 
                  src="index_files/index_32_05.gif" width=5></TD>
                <TD width=5 style="background-color: white"></TD>
                <TD align=left width=11><IMG height=31 alt="" 
                  src="index_files/index_32_01.gif" width=11></TD>
                <TD width=20><IMG height=16 alt="" 
                  src="index_files/index_32_06.gif" width=15></TD>
                <TD vAlign=center align=left width="338"><SPAN class=STYLE1 style="font-size:14px;">&nbsp;&nbsp;登录</SPAN></TD>
                <TD align=right width=11><IMG height=31 alt="" 
                  src="index_files/index_32_05.gif" 
          width=5></TD></TR></TBODY></TABLE></TD>
          
        </TR>
        <TR>
          <TD width=1 background=index_files/index_13.gif bgColor=#e9f3fd></TD>
          <TD vAlign=top >
          	<!-- table 再此处开始 -->
          		<table  border="0" align="center" >
				
				<tr style="background:url(wsbl/wsbl_content_bg.png);">
					<td align=center >
						<s:form method="post" action="regZuser.action" id="userRegisterForm"  name="userRegisterForm"  theme="simple">
						<!-- <form name="userRegisterForm" method="post" action="regZuser.action">  -->
						<table width="600" border="0" align="center" height=300 cellpadding="3" cellspacing="0" >
							<tr style="height:28px; ">
								<td align="left" colspan="3" >
									<img src="wsbl/dlxx_title.png" style="text-align:center" />
								</td>
							</tr>
							<tr style="height:28px; ">
							    <td width="150"  align="right"><font color="red">*</font> 登录名称</td>
							    <td width="170" ><input maxlength="16" id="fuserName" name="userName1"   class="input1" class=form value="<s:property value="userName1" />"
																				autocomplete="off"  type="text" size="20" 
									onfocus="changeStyle('s1','msg2');" onblur="changeStyle('s1','msg1');checkZuser();"  class="input1">
									</td>
							    <td ><div id="s1" class="msg1" style="float:left">请用字母或数字填写用户名，最多16个。</div></td>
							</tr>
							     
							 
							<tr style="height:28px; ">
							    <td  align="right"><font color="red">*</font> 登录密码</td>
							    <td ><input id="fPassword"  name="userPwd1"  class="input1"    class=form value="<s:property value="userPwd1" />"
									autocomplete="off" type="password" size="20" maxlength="20" class="input1"
									onFocus="changeStyle('s2','msg2');"
									onBlur="changeStyle('s2','msg1');">
							      </td>
							    <td ><div id="s2" class="msg1" style="float:left">密码长度应为6-20位。</div></td>
							</tr>
						 
						   
							<tr style="height:28px; ">
						    	<td  align="right"><font color="red">*</font> 确认密码</td>
						    	<td ><input id="rPassword" name="userPwd12" class="input1"   class=form 
									autocomplete="off" type="password" size="20" maxlength="20"></td>
						    	<td ><div id="s3" class="msg1" style="float:left"></div></td>
							</tr>
						  	<tr style="height:28px; ">
							    <td  align="right"><font color="red">*</font> 验   证   码 </td>
							    <td >
							    	
							    	<input id="validateStr" name="validateStr" type="text" size="8" style="WIDTH: 85px"
									onfocus="changeStyle('s10','msg2');"
									onblur="changeStyle('s10','msg1');" >
									<img id = "imageId" src="regImages.jsp" align="absmiddle" onclick="changeImage()" style="cursor:pointer;"  title="看不清楚，换一个"/>
									<input id="validateStr2" name="validateStr2" type="hidden" value='<%=session.getAttribute("ccode")%>'/></td>
							    <td >
							    	<div id="s10" class="msg1" style="float:left">
							    		
							    		请输验证码！（<a onclick="changeImage()" style="cursor:hand;">看不清，更换验证码</a>）
							    	</div>
							    </td>
						  	</tr>  
						  	<tr style="height:28px; ">
						    	<td align="left" colspan="3">
									<img src="wsbl/jgxx_title.png" style="text-align:center" />
								</td> 
							</tr>
						 	<tr style="height:28px; ">
								<td  align="right">机构代码</td>
							    <td ><input name="orgCode" id="orgCode" class="input1" class=form value="<s:property value="orgCode" />"
																				autocomplete="off"  type="text" size="20"
									onfocus="changeStyle('s63','msg2');"
									onblur="changeStyle('s63','msg1');" ></td>
							    <td ><div id="s63" class="msg1" style="float:left">新办机构，无机构代码证书，可不用填写。</div></td>
							</tr>
						 	<tr style="height:28px; ">
								<td  align="right"><font color="red">*</font> 机构名称</td>
							    <td ><input name="orgName" id="orgName" class="input1" class=form value="<s:property value="orgName" />"
																				autocomplete="off"  type="text" size="30"
									onfocus="changeStyle('s62','msg2');"
									onblur="changeStyle('s62','msg1');" ></td>
							    <td ><div id="s62" class="msg1" style="float:left">机构名称请填写正确，否则不能办理。</div></td>
							</tr>
							<tr style="height:28px; ">
						    	<td  align="right"><font color="red">*</font> 机构地址</td>
						    	<td  colspan="2"><input name="address" id="address"style="width:430px" class=form value="<s:property value="address" />"
																				autocomplete="off"  type="text" size="80"></td>
						  	</tr>
						  	<tr style="height:28px; ">
						    	<td  align="right"><font color="red">*</font> 批准机构名称</td>
						    	<td ><input style="width:113px"  id="pzjgmc" class="input1" name="pzjgmc" class=form value="<s:property value="pzjgmc" />"
																				autocomplete="off"  type="text" size="30"
									onfocus="changeStyle('s120','msg2');"
									onblur="changeStyle('s120','msg1');" >
									<input id="pzjgdm" name="pzjgdm"  value="<s:property value="pzjgdm" />" autocomplete="off"  type="hidden" size="20">
									<input type="button" id="show-btn" value="查询" /></td>
						    	<td ><div id="s120" class="msg1" style="float:left">请输入批准登记注册批准的机构名称。</div></td>
							</tr>
							<tr style="height:28px; ">
								<td  align="right"><font color="red">*</font> 批准文号或注册号</td>
							    <td ><input name="orgZch" id="orgZch" class="input1" class=form value="<s:property value="orgZch" />"
																				autocomplete="off"  type="text" size="20"
									onfocus="changeStyle('s61','msg2');" onblur="changeStyle('s61','msg1');" ></td>
							    <td ><div id="s61" class="msg1" style="float:left">请注意：注册号为机构成立的批准证书编码。</div></td>
							</tr>
							 
							<tr style="height:28px; ">
						    	<td  align="right"><font color="red">*</font> 电子信箱</td>
						    	<td ><input id="email" class="input1" name="email" class=form value="<s:property value="email" />"
																				autocomplete="off"  type="text" size="20"
									onfocus="changeStyle('s20','msg2');"
									onblur="changeStyle('s20','msg1');" ></td>
						    	<td ><div id="s20" class="msg1" style="float:left">请输入真实有效的邮箱，可凭此找回密码。</div></td>
							</tr style="height:28px; ">
							
						  
						  	<!-- 
						  	<tr>
						    	<td  align="right">邮政编码</td>
						    	<td ><input name="postalcode" id="postalcode" value=""  type="text" maxlength="6" size="20"></td>
						    	<td >&nbsp;</td>
						  	</tr>
						  	 -->
							<tr style="height:28px; ">
							    <td  align="right"><font color="red">*</font> 联系电话</td>
							    <td ><input name="tel" class="input1"  id="tel"  class=form value="<s:property value="tel" />"
																				autocomplete="off"  type="text" size="20"
									onfocus="changeStyle('s40','msg2');"
									onblur="changeStyle('s40','msg1');" ></td>
							    <td ><div id="s40" class="msg1" style="float:left">格式如010-66692008 或 139********</div></td>
							</tr>
							<tr style="height:28px; ">
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
							<tr height="10"></tr>
						</table>
						
						</s:form>
						<!-- </form> -->
					</td>
					<td width="5"style="background-color: white"></td>
					<!-- 此为分界线 -->
        			<td align="right">
        				<s:form target="_blank" method="post" action="zlogin.action" id="form1" name="form1" theme="simple">
							<TABLE cellSpacing=0 cellPadding=0  align="top" width=380 height=300 border=0>
								<TBODY>
									<TR>
										<TD height=10 align=center><font color="red" size="3"><s:property value="tip" /></font></TD>
									</TR>
									<TR>
										<TD align=center>
											<SPAN class=content_black_bold>用户名:</SPAN>
											<FONT class=form><INPUT class=form value="<s:property value="userName2" />"
													autocomplete="off" style="WIDTH: 150px"
													maxLength=28 name=userName2></FONT>
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
											<FONT class=form><INPUT class=form value="<s:property value="userPwd2" />"
													style="WIDTH: 150px" type="password" maxLength=32
													name="userPwd2" ><!--<INPUT class=form value="1"
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
												<img src="wsbl/wsbl_nav_submit.png"onclick="check();" style="cursor:pointer;"/>
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
          	<!-- table 再此处结束 -->
          </TD>
          <TD width=1 background=index_files/index_17.gif bgColor=#e9f3fd></TD></TR>
        <TR>
          <TD colSpan=3><IMG height=3 alt="" src="index_files/index_28.gif" 
            width="100%"></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 bgColor=#e9f3fd background=index_files/index_32_03.gif>
        <TBODY>
        
        <TR background=index_files/index_32_03.gif>
          <TD align=left width=11><IMG height=31 alt="" 
                  src="index_files/index_32_01.gif" width=11></TD>
          <TD width=20><IMG height=16 alt="" 
            src="index_files/index_32_06.gif" width=15 ></TD>
          <TD vAlign=center align=left width="100%" ><SPAN class=STYLE1 >&nbsp;&nbsp;链接信息</SPAN></TD>
          <TD align=right width=11><IMG height=31 alt="" 
            src="index_files/index_32_05.gif" width=5></TD>
          
        </TR>
        </TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 bgColor=#e9f3fd>
        <TBODY>
        <TR>
        <!-- 在这加的连接 -->
        	<td >
					<table border='0' width="100%">
						<tr height="5"></tr>
						<tr ><!-- 12 -->
							<td><a href="" style="font-size:14px;float: left;">海南省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">四川省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">成都市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">云南省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">贵州省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">陕西省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">西安市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">深圳市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">广州市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">重庆市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">广东省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">广西壮族自治区&nbsp;&nbsp;</a></td>
						</tr>
						<tr ><!-- 12 -->
							<td><a href="" style="font-size:14px;float: left;">山西省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">吉林省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">长春市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">辽宁省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">沈阳市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">大连市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">上海市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">江苏省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">南京市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">武汉市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">哈尔滨市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">宁夏回族自治区&nbsp;&nbsp;</a></td>
						</tr>
						<tr ><!-- 12 -->
							
							<td><a href="" style="font-size:14px;float: left;">安徽省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">浙江省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">杭州市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">福建省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">厦门市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">江西省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">济南市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">青岛市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">湖北省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">黑龙江省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">内蒙古自治区&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">新疆维吾尔自治区&nbsp;&nbsp;</a></td>
						</tr>
						<tr ><!-- 12 -->
							
							<td><a href="" style="font-size:14px;float: left;">北京市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">天津市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">河北省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">青海省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">河南省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">甘肃省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">湖南省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">山东省&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">宁波市&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;">西藏自治区&nbsp;&nbsp;</a></td>
							<td><a href="" style="font-size:14px;float: left;"></a></td>
							<td><a href="" style="font-size:14px;float: left;"></a></td>
						</tr>
						
					</table>
				</td>
				<!-- 在这加的连接结束 -->
        </TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 bgColor=#e9f3fd>
        <TBODY>
        <TR>
          <TD height=5></TD></TR></TBODY></TABLE></TD>
    <TD width=9 background=index_files/index_11.gif >　</TD></TR></TBODY></TABLE>
</body>
</html>
