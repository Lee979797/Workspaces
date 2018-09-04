<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.HashMap" %>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);

	HashMap PMTranslates = InitSysParams.PMTranslates;//错作结果提示中文
	String error = request.getParameter("error");
	if(!clsStringTool.isEmpty(error)){

	    error=(String)PMTranslates.get(error);

	}else{
	    error="";
	}
	error=clsStringTool.convertNull(error);
	session.setAttribute("isWebSite","0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>全国组织机构代码管理系统</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/js/tools.js'></script>
<script language="JavaScript" src="../js/readiccard.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/js/alert/skin/dmm-green/ymPrompt.css " />
<script language="JavaScript">

function checkForm(oper){

	if(oper == 1){

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
	}
	loginForm.loginType.value=oper;
	if(oper == 2){

        var strPage = "<%=request.getContextPath() %>/product/checkpwd.jsp?random="+Math.random();
        var winFeatures = "dialogHeight:100px; dialogWidth:360px;status:no;scroll:no;dialogTop:300;dialogLeft:400px;";
        var value = window.showModalDialog(strPage,"",winFeatures);
        if(value == 'undefined'){
            return;
        }
        var values = value.split('@');
        loginForm.passwords.value = values[0];
        loginForm.listCom.value= values[1];
        Action_Do('icRead');
        //fReadCard();
		loginForm.submit();
	}
	
	
	//return true;
    
}
function view(val){
	//ymPrompt.win(<%=request.getContextPath() %>'/product/CALogin2.jsp',400,300,'CA登录页面',null,null,null,{id:'a'})
	document.location.href=<%=request.getContextPath() %>'/product/CALogin2.jsp';
}

function setAtt(){

	var WshShell=new ActiveXObject("WScript.Shell");
	//添加信任站点ip
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range100\\","");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range100\\http","2","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Ranges\\Range100\\:Range","192.168.12.198");
	//修改IE ActiveX安全设置 1本地 Intranet 区域2受信任的站点区域3Internet 区域
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\1001","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\1004","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\1200","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\1201","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\1405","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\\2201","0","REG_DWORD");

	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\1001","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\1004","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\1200","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\1201","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\1405","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\\2201","0","REG_DWORD");

	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\1001","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\1004","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\1200","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\1201","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\1405","0","REG_DWORD");
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\\2201","0","REG_DWORD");
	//禁用Winxp弹出窗口阻止程序
	WshShell.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\New Windows\\PopupMgr","no");	
}
</script>
</head>

<body id="body_bj">
<!-- 
<object scope="application" width="32" height="32" classid="CLSID:3EE0206D-697A-11D5-9BD3-00E01819D1CC"
     codebase="../icocx/jgdmicread.cab" name="jgdmicread" style="display:None">
</object>  -->
<object id="myIcApi" classid="CLSID:A8679675-AA12-4052-9062-6F494D7DF1CD" codebase="../icocx/IcFun.CAB#version=1,0,0,3" width="0" style="display:None"></object> 
<form name="loginForm" action="/action/UserAction" method="post" onsubmit="return checkForm('1')">
    <input type="hidden" name="method" value="login" />
   <input type="hidden" name="goPage" value="/product/index.html" />
    <input type="hidden" name="currentPage" value="<%=request.getRequestURI()%>" />
    <input type="hidden" name="listCom" id="listCom" value="1" />
    <input type="hidden" name="jgdm" id="jgdm" />
    <input type="hidden" name="loginType" id="loginType" />
    <input type="hidden" name="passwords" id="passwords" />
  <div id="logoin_box">
    <table width="550" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="4" align="center" class="font_12_wit">您好！ 欢迎登录全国组织机构代码管理系统！</td>
      </tr>
      <tr>
        <td height="70" colspan="4" align="right" class="font_14">&nbsp;<a href="#" onclick="checkForm('2')" name="iclogin" title="IC卡登录" ><img border="0" src="../images/ic.gif" alt="" /></a><br/>&nbsp;<a href="#" onclick="view('a')" name="calogin" title="CA登录" ><img border="0" src="../images/ca.gif" alt="" /></a></td>
      </tr>
      <tr>
        <td width="180" height="15" align="right" class="font_14">用户名：</td>
        <td width="165"><input class="input_out" id="username"  name="username" type="text" onfocus="this.className='input_on';this.onmouseout=''" onblur="this.className='input_off';this.onmouseout=function(){this.className='input_out'};" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"  style=";width:150px;"/></td>
        <td class="font_12_red" id="usernameInfo"></td>
      </tr>
      <tr>
        <td height="30" align="right" class="font_14">密&nbsp;码：</td>
        <td><input class="input_out" id="password"  name="password" type="password" onfocus="this.className='input_on';this.onmouseout=''" onblur="this.className='input_off';this.onmouseout=function(){this.className='input_out'};" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"  style=";width:150px;"/></td>
        <td class="font_12_red"  id="passwordInfo"></td>
      </tr>
      <tr>
        <td height="30" align="right" class="font_14">验证码：</td>
        <td><input name="ValidateCode" id="ValidateCode"  class="input_out" type="text" onfocus="this.className='input_on';this.onmouseout=''" onblur="this.className='input_off';this.onmouseout=function(){this.className='input_out'};" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"  style=";width:60px;"/>
        <a href="#" onclick="loginForm.validate.src='/action/ValidateCodeServlet?time='+Math.random();"><img src="/action/ValidateCodeServlet" width=58 height=21 border="0" align="top" style="vertical-align:top" id="validate"/></a>
        </td>
        <td class="font_12_red"  id="codeInfo"></td>
      </tr>
      <tr>
        <td height="40">&nbsp;</td>
        <td height="60">
          <input type="submit" class="logoin_btn_on" id="loginSubmit" name="loginSubmit" onclick="checkForm('1')" value="登录"/>
          <input type="reset" name = "reset" class="logoin_btn_on" id="reset" value="重置" /></td>
        <td height="30">&nbsp;</td>
      </tr>
      <tr>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2"><span class="logoin_txt">版权所有：全国组织机构代码中心&nbsp;</span><a href="#" onclick="setAtt();"><span style="font-size:12px">点击此处配置</span></a></td>
      </tr>
    </table>
  </div>
  <span class="clear"></span>
</form>
</body>
<script type="text/javascript" >
	loginForm.loginSubmit.focus();
	loginForm.username.focus();
	document.getElementById("codeInfo").innerHTML = "<%=error%>";
</script>
</html>
