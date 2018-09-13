<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*,CertificateAuthorityServices.snca.*,com.snca.caplatform.services.domailmodel.xsd.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<base href="<%=basePath%>">
<title>组织机构代码中心网上办证系统 ----用户登 录</title>
<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/zz/js/caJgdm.js"></script>
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
<script  type="text/javascript">
		function flagCert(){
			var flag = document.getElementById("flag").value;
			var cert = document.getElementById("cert").value;
      
      if(flag){
      	//request.getRequestDispatcher("index.jsp").forward(request, response);
      	var a = getCertCssId(cert);
      	form1.userName2.value=a;
      	alert(a);
      	form1.submit();
      }else{
      	window.open("http://","_self","",false);
      }
		}
		
	</script>

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

<body bgcolor="#FFFFFF"  leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no"  onLoad="return flagCert();">
<%
			String signedText = request.getParameter("signedText");
			System.out.println("Signed text:" + "<br>" + signedText + "<br>");
			long starttime = System.currentTimeMillis();
			CertificateAuthorityServices client = new CertificateAuthorityServicesLocator();
			CertificateAuthorityServicesPortType service = client
					.getCertificateAuthorityServicesHttpSoap11Endpoint();
			Boolean b = service.checkSNCAPKCS7Certificate(signedText);
			
			String certcode = request.getParameter("certcode");
		%>
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
                <TD vAlign=center align=left width="338"><SPAN class=STYLE1 style="font-size:14px;color: #004B97">武汉机构登录</SPAN></TD>
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
										<TD align=center>
											<SPAN class=content_black_bold>用户名:</SPAN>
											<FONT class=form><INPUT type="hidden" class=form value="<s:property value="userName2" />"
													autocomplete="off" style="WIDTH: 150px"
													maxLength=28 name=userName2></FONT>
											<input type="hidden" name="state" value="false">
											<input type="hidden" name="flag" value="<%=b%>"/>
											<input type="hidden" name="cert" value="<%=certcode%>"/>
										</TD>
									</TR>
									<TR>
										<TD height=5>
										</TD>
									</TR>
									<TR>
										<TD align=center>
											<SPAN class=content_black_bold>密&nbsp;&nbsp;&nbsp;&nbsp;码:</SPAN>
											<FONT class=form><INPUT type="hidden" class=form value="1"
													style="WIDTH: 150px" type="password" maxLength=32
													name="userPwd2" ></FONT>
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