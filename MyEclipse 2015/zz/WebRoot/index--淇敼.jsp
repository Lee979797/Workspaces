<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>组织机构代码中心网上办证系统 ----用户登 录</title>
<link rel="shortcut icon" href="/zz/images/favicon.ico"/>
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
	if(userName!="" && userName.length>0){
   		Ext.Ajax.request({
			url : 'checkZuser.action?userName='+userName,
			success: function(result,request){
				var resultObject2 = Ext.util.JSON.decode(result.responseText); 
				//alert(resultObject2.success);
				if(resultObject2.success){
					changeStyle('s1','msg4');
		  	    	document.getElementById("s1").innerHTML = '用户名'+userName+'已被注册，请重新输入！';
				}else{
					//changeStyle('s1','msg4');
		  	    	document.getElementById("s1").innerHTML = '用户名'+userName+'可以注册！';
				}				
			},
			failure : function() {
				alert("系统运行错误");
			}
		});
	}else{
		document.getElementById("s1").innerHTML = '请用字母或数字填写用户名，最多16个。';
		changeStyle("s1","msg1");
	}
}


function changeImage() {
	//window.location.reload(true);
	document.getElementById("imageId").src="regImages.jsp?t=" + (new Date());
}
function changeImage1() {
	//window.location.reload(true);
	document.getElementById("imageId1").src="regImages1.jsp?t=" + (new Date());
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

<body bgcolor="#FFFFFF"  leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no"  onLoad="javascript:document.form1.userName2.focus();">

<TABLE cellSpacing=0 cellPadding=0 width="800" align=center 
border=0>
  <TBODY>
  	<tr>
  		<td colSpan=3>
  			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 >
		        <TBODY>
		        <TR >
		          <td height="2"></td></TR>
		        <TR >
		          <TD height=10><span style="font-size:12px;color:#BEBEBE;"><b>您的位置是：首页>>网上业务办理</b></span></TD></TR>
		        <TR >
		          <td ><hr/></td></TR>
		        </TBODY></TABLE>
  		</td>
  	</tr>
  	<tr>
  		<td width="380" colSpan=3>
  			<TABLE id=__01 height=31 cellSpacing=0 cellPadding=0 width="100%" 
            align=center background=index_files/index_32_03.gif border=0>
              <TBODY>
              <TR>
                <TD align=left width=11><IMG height=31 alt="" 
                  src="index_files/index_32_01.gif" width=11></TD>
                <TD width=20><IMG height=16 alt="" 
                  src="index_files/index_32_06.gif" width=15></TD>
                <TD vAlign=center align=left width="338"><SPAN class=STYLE1 style="font-size:14px;color: #004B97">机构登录</SPAN></TD>
                <TD align=right width=11><IMG height=31 alt="" 
                  src="index_files/index_32_05.gif" 
          width=5></TD></TR></TBODY></TABLE>
  		</td>
  	</tr>
  	<tr>
  		<td width="1" style="background:url(index_files/index_13.gif);"></td>
  		<td width="378" bgColor=#e9f3fd align="center">
  			<s:form target="_blank" method="post" action="zlogin.action" id="form1" name="form1" theme="simple">
							<TABLE cellSpacing=0 cellPadding=0  align="center" width=378 height=300 border=0>
								<TBODY>
									<TR>
										<TD height=10 align=center><font color="red" size="3"><s:property value="tip" /></font></TD>
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
													name="userPwd2" ></FONT>
										</TD>
									</TR>
									<TR>
										<TD height=5></TD>
									</TR>
									
									<TR>
										<TD noWrap align=center>
											<span style="padding-left: 47px;">
												<img src="wsbl/wsbl_nav_submit.png"onclick="check();" style="cursor:pointer;"/>
											</span>
											<span style="padding-left: 20px;">
												<img src="wsbl/wsbl_nav_change.png" onclick="form1.reset();"style="cursor:pointer;"/>
											</span>
											<span style="padding-left: 20px;">
												<a href="register.jsp"><img src="wsbl/wsbl_nav_reg.png" style="cursor:pointer;"/></a>
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
  		<td width="1" style="background:url(index_files/index_17.gif);"></td>
  	</tr>
  	<tr>
  		<td colSpan=3 background="index_files/index_28.gif" height="2"></td>
  	</tr>
  	<tr>
  		<td colSpan=3>
  			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 >
		        <TBODY>
		        <TR>
		          <TD height=8></TD></TR></TBODY></TABLE>
  		</td>
  	</tr>
  	
  	
  		<td colSpan=3 background="index_files/index_28.gif" height="2"></td>
  	</tr>
  </TBODY>
</TABLE>

</body>
</html>