<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>组织机构代码数字档案管理系统 ----用户登录</title>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="css/global.css" type=text/css rel=STYLESHEET>
<LINK href="css/main.css" type=text/css rel=STYLESHEET>
<script>
	function check(){
		var frm = document.form1;
		if(frm.userName.value==""){
			alert("用户名不能为空!");
			frm.userName.focus();
			return false;
		}else if(frm.password.value==""){
		    alert("登录密码不能为空!");
		    frm.userPwd.focus();
		    return false;
		}else {
			return true;
		}
	}
	
	function showMsg(flag){
		if(flag==1){
			document.getElementById("tijiao").disabled=true;
			document.getElementById("tjUserName").disabled=true;
			document.getElementById("tjPassword").disabled=true;
			document.getElementById("showMsgId").innerHTML = "<font color='red' size='3'>请安装新版控件！</font><a href='downloadFlie/nacaoOcx.exe' target='_blank' class=other>下 载</a>";
			return false;
		}else if(flag==2){
			document.getElementById("tijiao").disabled=true;
			document.getElementById("tjUserName").disabled=true;
			document.getElementById("tjPassword").disabled=true;
			document.getElementById("showMsgId").innerHTML = "<font color='red' size='3'>请下载安装控件！</font><a href='downloadFlie/nacaoOcx.exe' target='_blank' class=other>下 载</a>";
		    return false;
		}else {
			document.getElementById("tijiao").disabled=false;
			document.getElementById("tjUserName").disabled=false;
			document.getElementById("tjPassword").disabled=false;
			document.form1.userName.focus();
			return true;
		}
	}
</script>
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
<body bgcolor="#FFFFFF" leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="45">
          <td height="55" width="19">&nbsp;</td>
          <td width="950"></td>
          <td width="10"></td>
        </tr>
        <tr height="95">
          <td height="95" >&nbsp;</td>
          <td><img src="images/home_logo.gif"  height="95" alt="logo"></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="20"></td>
          <td></td>
          <td></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="826" height="298" align="right" background="images/login2009-6_09.jpg">
			<table width="250" border="0" align="right" >
				<tr>
					<td>
						<fieldset><legend><span class="STYLE5"><b>用户登陆</b></span></legend>
							<br>
							<s:form method="post" action="login.action" name="form1" onsubmit="return check()" theme="simple">
								<TABLE cellSpacing=0 cellPadding=0  align="center" width=210 border=0>
									<TBODY>
										<TR>
											<TD height=15 align=center id="showMsgId"><font color="red" size="3"><s:property value="tip" /></font></TD>
										</TR>
										<TR>
											<TD align=left>
												<SPAN class=content_black_bold>用户名</SPAN>
												<FONT class=form><!--<INPUT class=form value="<s:property value="userName" />"
														autocomplete="off" id="tjUserName" style="WIDTH: 150px"
														maxLength=28 name=userName>--><INPUT class=form value=""
														id="tjUserName" autocomplete="off" style="WIDTH: 150px"
														maxLength=20 name=userName></FONT>
												<input type="hidden" name="manager" value="true">
											</TD>
										</TR>
										<TR>
											<TD height=8>
											</TD>
										</TR>
										<TR>
											<TD align=left>
												<SPAN class=content_black_bold>密&nbsp;&nbsp;&nbsp;&nbsp;码</SPAN>
												<FONT class=form><!--<INPUT class=form id="tjPassword" value="<s:property value="password" />"
														style="WIDTH: 150px" type="password" maxLength=32
														name="password" >--><INPUT class=form  id="tjPassword"  value=""
														style="WIDTH: 150px" type="password" maxLength=32
														name="password"></FONT>
											</TD>
										</TR>
										<TR>
											<TD height=10></TD>
										</TR>
										<TR>
											<TD noWrap align=left>
												<span style="padding-left: 47px;"><input id="tijiao" type="submit" value="提  交"/></span><span style="padding-left: 20px;"><input type="reset" value="重   置"/></span>
											</TD>
										</TR>
										<TR>
											<TD height=10></TD>
										</TR>
										<TR>
											<TD class=content_gray vAlign=top align=center>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  href="javascript:;"><font color="#ffffff">忘记密码</font></A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  href="javascript:;"><font color="#ffffff">在线帮助</font></A>
											</TD>
										</TR>
										
									</TBODY>
								</TABLE>
							</s:form>
							<br>
						</fieldset>
				  </td>
				</tr>
		    </table>	
		</td>
        <td background="images/login2009-6_10.jpg">&nbsp;</td>
      </tr>
    </table>
	  <table width="100%" border="0" cellspacing="2" cellpadding="3">
        <tr>
          <td width="81%" height="25"><div valign="middle" class="STYLE1">
            <div align="right">全国组织机构代码管理中心   版权所有</div>
          </div></td>
          <td width="19%"><iframe src="checkOcxStatus.jsp" width="0" height="0" scrolling="no" frameborder="0" ></iframe></td>
        </tr>
      </table>
      <div id="info" class="divCs"></div>		
      </td>
  </tr>
</table>
</body>
</html>
