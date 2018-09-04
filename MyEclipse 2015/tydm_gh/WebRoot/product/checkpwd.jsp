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
<title>确认密码</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/js/tools.js'></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/js/alert/skin/dmm-green/ymPrompt.css" />
<script language="JavaScript">
function submits(){
    var value =  document.getElementById ('password').value;
    var value2 =  document.getElementById ('listCom').value;

    if(value != ''){
       window.returnValue = value+'@'+value2;
       window.close();
    }else{
        alert("请输入确认密码！",330,220,"提示信息");
        return;
    }
}
function closeWin(oper)
{
    if(oper=='1'){
        var value =  document.getElementById ('password').value;
        var value2 =  document.getElementById ('listCom').value;
        var result= '';
        if(value != ''){
           result = value+'@'+value2;
           //window.close();
        }else{
            //alert("请输入确认密码！",330,220,"提示信息");
            //ymPrompt.alert({title:"提示信息",message:'请输入确认密码！',showMask: false,dragOut:false});
            document.getElementById("passwordInfo").innerHTML = "请输入确认密码！";
            return;
        }
        window.parent.ymPrompt.doHandler(result,true);
    }else if(oper=='2'){
         window.parent.ymPrompt.doHandler('close',true);
    }
}
</script>
</head>

<body style="width:360px;height:100px;">
   <br />
    <table width="100%" border="0" cellpadding="0" cellspacing="0">

      <tr>
        <td  height="15" align="right" class="font_14" style="width:20%">端口：</td>
        <td ><select name="listCom" id="listCom">
                <option value="1">com1</option>
                <option value="2">com2</option>
                <option value="3">com3</option>
                <option value="4">com4</option>
                <option value="5">com5</option>
                <option value="6">com6</option>
             </select></td>
        <td  style="width:30%" class="font_12_red">&nbsp;</td>
      </tr>
      <tr>
        <td  height="15" align="right" class="font_14">密码：</td>
        <td ><input class="input_out" id="password"  name="password" type="password" onfocus="this.className='input_on';this.onmouseout=''" onblur="this.className='input_off';this.onmouseout=function(){this.className='input_out'};" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"  style=";width:150px;"/></td>
        <td class="font_12_red" id="passwordInfo"></td>
      </tr>
      <tr>
        <td align="right" class="font_14">&nbsp;</td>
        <td valign="middle" height="20" width="135px" >&nbsp;<input type="button" name = "button" class="logoin_btn_on" onclick="closeWin('1');" id="button" value="确定" /></td>
        <td class="font_12_red" align="left" >&nbsp;<input type="button" name = "button" class="logoin_btn_on" onclick="closeWin('2');" id="button1" value="取消" /></td>
      </tr>
    </table>
</body>
</html>
