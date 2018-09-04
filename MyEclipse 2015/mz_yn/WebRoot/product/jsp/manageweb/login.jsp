<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.ninemax.nacao.util.clsInitSysParams" %>
<%@ page import="com.ninemax.nacao.util.clsStringTool" %>
<%@ page import="java.util.HashMap" %>
<%    
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

HashMap PMTranslates = clsInitSysParams.PMTranslates;//错作结果提示中文
 String error = request.getParameter("error");
 if(!clsStringTool.isEmpty(error)){
     
     error=(String)PMTranslates.get(error);
	 
 }else{
     error="";
 }
 session.setAttribute("isWebSite","0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="refresh" content="300"> 
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<style type="text/css">
#body_bj {
	background-color: #0886da;
	background-image: url(images/login_bottom.png);
	_background-image: url(0);
	background-repeat: no-repeat;
	background-position: left 0px;
}
</style>
<title>九瑞内容管理平台</title>
<link href="/manageweb/css/css_emc.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/js/tools.js'></script>
<script language="JavaScript">

function checkForm(){

	if(isEmpty(loginForm.username.value)){
		 
		 //alert("请输入用户名！");
		 document.getElementById("usernameInfo").innerHTML = "请输入用户名！";
		 loginForm.username.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(loginForm.username.value,special_char.username);
		 if(specialChar){
			 //alert("用户名不能包含+specialChar+");
			 document.getElementById("usernameInfo").innerHTML = "用户名不能包含+specialChar+";
			 loginForm.username.focus();
			 return false;
		 }
	}
	
	if(isEmpty(loginForm.password.value)){
		 
		 //alert("请输入密码！");
		 document.getElementById("passwordInfo").innerHTML = "请输入密码！";
		 loginForm.password.focus();
		 return false;
		 
	}else{
	
		 var specialChar = CheckSpecialChar(loginForm.password.value,special_char.passwd);
		 if(specialChar){
			 //alert("密码不能包含+specialChar+");
			 document.getElementById("passwordInfo").innerHTML = "密码不能包含+specialChar+";
			 loginForm.password.focus();
			 return false;
		 }
	}
	
	if(isEmpty(loginForm.ValidateCode.value)){
		 //alert("请输入验证码！");
		 document.getElementById("codeInfo").innerHTML = "请输入验证码！";
		 loginForm.ValidateCode.focus();
		 return false;
	}
	return true;
   // loginForm.submit();
}

</script>
</head>

<body id="body_bj">
<FORM name="loginForm" action="/servlet/sysUserAction" method="POST" onSubmit="return checkForm();">
    <input type="hidden" name="actions" value="login" />
   <input type="hidden" name="goPage" value="/manageweb/main.jsp" />
    <input type="hidden" name="currentPage" value="<%=request.getRequestURI()%>" />

<div id="logoin_bj">
  <div id="logoin_box">
    <table width="550" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="3" align="center" class="font_12_wit">您好！ 欢迎登录九瑞内容管理平台！</td>
      </tr>
      <tr>
        <td height="70" colspan="3" align="right" class="font_14">&nbsp;</td>
      </tr>
      <tr>
        <td width="180" height="15" align="right" class="font_14">用户名：</td>
        <td width="150"><input type="text" class="logoin_input_on" id="username"  name="username" /></td>
        <td class="font_12_red"><div class="login_tr3" id="usernameInfo"></div></td>
      </tr>
      <tr>
        <td height="30" align="right" class="font_14">密&nbsp;码：</td>
        <td><input name="password" type="password" class="logoin_input_on" id="password" /></td>
        <td class="font_12_red"><div class="login_tr3" id="passwordInfo"></div></td>
      </tr>
      <tr>
        <td height="30" align="right" class="font_14">验证码：</td>
        <td><input name="ValidateCode" type="text" class="logoin_input_on_yz" id="ValidateCode" />
		<a href="#" onClick="loginForm.validate.src='/servlet/ValidateCodeServlet?time='+Math.random();"><img src="/servlet/ValidateCodeServlet" width=58 height=21 border="0" align="top" style="vertical-align:top" id="validate"/></a>
		</td>
        <td class="font_12_red"><div class="login_tr3" id="codeInfo"></div></td>
      </tr>
      <tr>
        <td height="40">&nbsp;</td>
        <td height="30"><input type="submit" class="logoin_btn_on" id="loginSubmit" value="登录"   name="loginSubmit"/>
          <input TYPE="reset" name = "reset" class="logoin_btn_on" id="reset" value="重置" /></td>
        <td height="30">&nbsp;</td>
      </tr>
      <tr>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2"><span class="logoin_txt">版权所有：北京九瑞网络科技有限公司</span></td>
      </tr>
    </table>
  </div>
  <span class="clear"></span>
</div>
</FORM>
</body>
<script type="text/javascript">
	loginForm.loginSubmit.focus();
	loginForm.username.focus();
	document.getElementById("codeInfo").innerHTML = "<%=error%>";
</script>
</html>
