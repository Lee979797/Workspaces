<%response.setHeader("Pragma","No-cache");//一定要写这句话，否则无法清空缓存，系统总是记忆使用showmoduledialog()第一次弹出的内容
response.setHeader("Cache-Control","no-cache");//一定要写这句话，否则无法清空缓存，系统总是记忆使用showmoduledialog()第一次弹出的内容
response.setDateHeader("Expires", 0);//一定要写这句话，否则无法清空缓存，系统总是记忆使用showmoduledialog()第一次弹出的内容
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page language = "java" import="java.sql.*,java.lang.*,java.util.*"%>
<HTML><TITLE>输入证书编号</TITLE>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<META content="text/html; charset=GBK" http-equiv=Content-Type>
<style type="text/css">
body, a, table, div, span, td, th, input, select{font:9pt;font-family: "宋体", Verdana, Arial, Helvetica, sans-serif;}
body {padding:5px}
</style>
<%
  String  zsbhPre="";
  String  returnValue="";
  String  strZsbh="",strZslx="",strSsbzjg="",strFlag="",strDysj="",strCzy="",strDjh="";
  String  strDjhReqTemp ="";
  String  strDjhReq ="";
  String  zsbhLength="1";
  String  zsbhpreType="hidden";
  String  strZfbFlag="";
  String  strJgmc="";
  String  strJgdm="";
  String  strOrgid="";
  String  strAddFuben="";
  String  strFbsl="";
  
  returnValue=request.getParameter("succes");
  if( "null".equals(returnValue) || returnValue=="null"){
	  strOrgid=request.getParameter("txtOrgid");
	  strFbsl=request.getParameter("txtFbsl");
	  strJgdm=request.getParameter("txtJgdm");
	  strZfbFlag=request.getParameter("zfbFlag");
	  strAddFuben=request.getParameter("addFuben");
	  strJgmc =request.getParameter("txtJgmc");
	  strDjhReqTemp =request.getParameter("txtDjh");
	  strDjhReq = new String(strDjhReqTemp.getBytes("ISO-8859-1"),"GBK");//strDjhReqTemp不能为null，否则转换出错
  }
%>
<script LANGUAGE="JavaScript">
function fCheckValue()
{
	if (frmThis.txtzsbh_suf.value==""){
   		alert("证书编号不允许为空！");
		frmThis.txtzsbh_suf.focus();
		return false;
	}
 	return true;
}

function window_onfocus() {
    frmThis.txtzsbh_suf.focus();
}

</script>
</head>
<base target="_self">
<body bgcolor="#D4D0C8" onLoad="return window_onfocus()">
<%if ("false".equals(returnValue)){	
		//strJgdm=request.getParameter("txtJgdm");
		 // strZfbFlag=request.getParameter("zfbFlag");
		  strOrgid=request.getParameter("txtOrgid");
		  strFbsl=request.getParameter("txtFbsl");
		  strAddFuben=request.getParameter("addFuben");
		  strJgmc =request.getParameter("txtJgmc");
		  System.out.print("####################="+strJgmc);
		  strDjhReqTemp =request.getParameter("txtDjh");
		  strDjhReq = new String(strDjhReqTemp.getBytes("ISO-8859-1"),"GBK");//strDjhReqTemp不能为null，否则转换出错
		  System.out.print("@@@@@@@@@@@@@@@@@@@@="+strDjhReq);
}%>
<form name="frmThis" method="post" action="saveZsly.action" onSubmit="return fCheckValue()">
  <div align="center">
 <br><font color="#000000" size="3"><%=strJgmc%></font>(<font color="#0000FF" size="3">
<%
   if (strZfbFlag.equals("0")){	
	 	out.print("正本");
   }else if (strZfbFlag.equals("1")){
		out.print("副本");
   }else if (request.getParameter("txtZfbFlag").equals("0")){
     	out.print("正本");
   }else {
		out.print("副本");
   }

%></font>)<br><br>
 <div align="center">
	<%if (returnValue.equals("false")){%>
	      <table  border="1" align="center" cellspacing="0">
	      <tr> 
	        <td colspan="4"> <div align="center">该编号已被<font color="#FF0000">使用</font>，请确认证书编号输入是否正确！</div></td>
	      </tr>
	    </table>
	 <%}else{ %>
		<font color="#FF0000" size="3">已打印出，请按其右下角编号输入！</font>
	<%};%>
    <br><br>
    <table border="0" cellpadding="0" cellspacing="0">
      <tr> 
        <td width="97" height="27" valign="bottom"><div align="center"><font size="4">登 记 号：</font></div></td>
        <td width="240"><input name="txtdjh_show" type="text" style="font-family: 幼圆; font-size: 12pt; border: 1px solid #D4D0C8; padding-left: 4; padding-right: 4; padding-top: 1; padding-bottom: 1; background-color: #D4D0C8"  value="<%=strDjhReq%>" size="28">
        </td>
      </tr>
      <tr> 
	  <td width="97" height="27" valign="bottom"><div align="center"><font size="4">证书编号：</font></div></td>
        <td width="240"> 
            <input type="<%=zsbhpreType%>" name="txtzsbh_pre"  size="<%=zsbhLength%>"  value="<%=zsbhPre%>" style="font-family: Arial; font-size: 12pt;">
            <input type="text" name="txtzsbh_suf"  size="5" style="font-family: Arial; font-size: 12pt">
        </td>
      </tr>
      <tr> 
        <td height="37" colspan="2"> <div align="center"> 
            <input name="z_tjnr_z" type="submit" value="确认" style="font-family: 幼圆; font-size: 12pt">
            &nbsp;&nbsp;&nbsp;&nbsp; 
            <!--<input name="z_tjnr_z" type="button" value="取消" onclick="window.returnValue = '1';window.close();" style="font-family: 幼圆; font-size: 12pt">-->
          </div></td>
      </tr>
      <tr> 
        <td height="37" colspan="2"><div align="center"><font color="#FF0000">如果证书没有正确打印出来，请点击取消！</font></div></td>
      </tr>
      <tr> 
        <td colspan="2"> <table width="100%" border="0">
            <tr>
              <td colspan="2"><font color="#FF0000">*</font>谨慎输入，证书编号用作辨别证书真伪！ </td>
            </tr>
            <tr> 
              <td colspan="2"><font color="#FF0000">*</font>出现卡纸，走空纸等非正常情况，请不要输入编号！ 
              </td>
            </tr>
            <tr> 
              <td width="23%"> &nbsp;解决办法：</td>
              <td width="77%">1、等再次打印时再输入正确编号；</td>
            </tr>
            <tr> 
              <td>&nbsp;</td>
              <td>2、打印正确后到“修改证书编号”中输入。</td>
            </tr>
          </table></td>
      </tr>
    </table>
</div>
<input name="firstExec" type="hidden" value="1">
<input name="txtDjh" type="hidden" value="<%=strDjhReq%>">
<input name="txtZfbFlag" type="hidden" value="<%=strZfbFlag%>">
<input name="txtJgdm" type="hidden" value="<%=strJgdm%>">
<input name="txtJgmc" type="hidden" value="<%=strJgmc%>">
<input name="addFuben" type="hidden" value="<%=strAddFuben%>">
<input name="txtOrgid" type="hidden" value="<%=strOrgid%>">
<input name="txtFbsl" type="hidden" value="<%=strFbsl%>">


</form> 
</body>
<script>
<%if (request.getParameter("firstExec")==null){%>
	//frmThis.txtDjh.value=window.dialogArguments[0];
	//frmThis.txtZfbFlag.value=window.dialogArguments[1];
	//frmThis.txtJgdm.value=window.dialogArguments[2];
	//frmThis.txtJgmc.value=window.dialogArguments[3];
	//frmThis.txtdjh_show.value=window.dialogArguments[0];
<%};
if( "true".equals(returnValue)|| returnValue=="true"){
	out.print("window.returnValue = '1';window.close();");
}
%>
</script>
</html>