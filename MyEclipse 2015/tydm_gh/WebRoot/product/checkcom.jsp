<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.HashMap" %>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>确认端口</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/js/tools.js'></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/js/alert/skin/dmm-green/ymPrompt.css" />
<script language="JavaScript">
function submits(){
    var _value=  document.getElementById ('listCom').value;
       window.returnValue = _value;
       window.close();
}
</script>
</head>
<body >
   <br />
    <table width="350" border="0" cellpadding="0" cellspacing="0">

      <tr>
        <td  height="15" align="right" class="font_14">端口：</td>
        <td ><select name="listCom" id="listCom">
                <option value="1">com1</option>
                <option value="2">com2</option>
                <option value="3">com3</option>
                <option value="4">com4</option>
                <option value="5">com5</option>
                <option value="6">com6</option>
             </select></td>
        <td class="font_12_red"><input type="button" name = "button" class="logoin_btn_on" onclick="submits();" id="button" value="确定" /></td>
      </tr>
      <tr>
        <td height="15" align="right" class="font_14">&nbsp;</td>
        <td >&nbsp;</td>
        <td class="font_12_red" >&nbsp;</td>
      </tr>
    </table>

</body>
</html>
