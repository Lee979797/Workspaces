<%@ page language="java" pageEncoding="UTF-8" %>
<HTML>
<HEAD>
<title></title>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">

<OBJECT id="CryptCtrl" border="0" classid="CLSID:3C474273-7F8B-4690-8C34-855C4528658D" ></OBJECT>

<script src="crypt.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--

/**  
* 执行基本ajax请求,返回XMLHttpRequest  
* Ajax.request(url,{
*      method  请求方式 POST or GET(默认)  
*      data    请求参数 (键值对字符串)  
*      handler 请求后响应函数，参数为返回的数据  
* });
*/ 
IscAjax = function() {  

    function request(url, opt) {  

        function fn(){}  

        var method  = opt.method    || 'GET',  
            data    = opt.data      || null,  
            handler = opt.handler   || fn,
            method  = method.toUpperCase();  

        if ( method == 'GET' && data) {  
            url += (url.indexOf('?') == -1 ? '?' : '&') + data;  
            data = null;  
        }
        
        var xhr = function GetXMLHttpObj()
        {
            var xmlHttpObj = null;
            try {
            	xmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
            }
            catch(e) {
                try {
                    xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch(sc) {
                    xmlHttpObj = null;
                }
            }
            
            if ( !xmlHttpObj && typeof XMLHttpRequest != "undefined" ) {
                xmlHttpObj = new XMLHttpRequest();
            }
            
            return xmlHttpObj;
        }();

        xhr.onreadystatechange = function() {
            _onStateChange(xhr, handler);
        };

        xhr.open(method, url, false);

        if(method == 'POST'){  
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded;');
        }

        xhr.send(data);
        return xhr;   
    }  

    function _onStateChange(xhr, handler){
        
        if(xhr.readyState == 4){

            var s = xhr.status;  
            if(s>= 200 && s < 300){  
            	handler(xhr.responseText);  
            }
            else{  
            	handler("-1::"+xhr.status);  
            }  
        }
        else{}  
    }  
    return {request:request};     
}(); 


/*
 * 证书登陆
*/
function SecureLogin()
{
	var rtn = openDeviceEx(0, pwd.txtPwd.value);
    
	if ( rtn != 0) {
		alert("openDevice err!"+rtn);
	    return;
	}

    rtn = MakeClientHello();
    if (rtn != 0) {
    	return; 
    }
   // alert("MakeClientHello OK!");
    
	IscAjax.request('verify.jsp', {  
		method: "POST",
        data : "type=CLIENT-HELLO&clientHello=" + escape(CryptCtrl.strResult),  
        handler : function(response){
		    
		    var strArr = response.split("::");
		    if (strArr[0] == -1 ) {
		    	alert("获取serverHello错误："+strArr[1]);
		    	return;
		    }
		    
		    serverPacket = strArr[1];
		    serverRandom = strArr[2];
		    
		    rtn = MakeClientAuthCode();
		    if ( rtn != 0) {
		    	alert("生成 ClientAuthCode 失败，MakeClientAuthCode() return: " + rtn);
		    	return;
		    }
		    
		    IscAjax.request("verify.jsp", {
		        method: "POST",
		        data : "type=CLIENT-AUTHCODE&clientAuthCode="+clientAuthCode+"&serverRandom="+serverRandom,
		        handler : function(response) {
		            var strArr = response.split("::");
		            if (strArr[0] == -1 ) {
		                alert("ServerAuth 失败:" + strArr[1]);
		                return;
		            }
		            serverPacket = strArr[1];
		            top.document.location.href="zlogin.action";
		        }
		    });
        }
    });
}

function SecureLoginSM2()
{
	var rtn = openDeviceEx(1, pwd.txtPwd.value);
    
	if ( rtn != 0) {
		alert("openDevice err!"+rtn);
	    return;
	}

    rtn = MakeClientHello();
    if (rtn != 0) {
    	return; 
    }
   // alert("MakeClientHello OK!");
    
	IscAjax.request('verify.jsp', {  
		method: "POST",
        data : "type=CLIENT-HELLO&clientHello=" + escape(CryptCtrl.strResult),  
        handler : function(response){
		    
		    var strArr = response.split("::");
		    if (strArr[0] == -1 ) {
		    	alert("获取serverHello错误："+strArr[1]);
		    	return;
		    }
		    
		    serverPacket = strArr[1];
		    serverRandom = strArr[2];
		    
		    rtn = MakeClientAuthCode();
		    if ( rtn != 0) {
		    	alert("生成 ClientAuthCode 失败，MakeClientAuthCode() return: " + rtn);
		    	return;
		    }
		    
		    IscAjax.request("verify.jsp", {
		        method: "POST",
		        data : "type=CLIENT-AUTHCODE&clientAuthCode="+clientAuthCode+"&serverRandom="+serverRandom,
		        handler : function(response) {
		            var strArr = response.split("::");
		            if (strArr[0] == -1 ) {
		                alert("ServerAuth 失败:" + strArr[1]);
		                return;
		            }
		            serverPacket = strArr[1];
		            top.document.location.href="zlogin.action";
		        }
		    });
        }
    });
}

function OnKeyPress() {
    if (window.event.keyCode == 13) {
        SecureLogin();
    }
}        
//-->
</SCRIPT>
</HEAD>
<BODY bgcolor="#E4EBF1" >
<form name="pwd" style="visibility: visible" method="post">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="topbg.jpg">
      <tr>
        <td width="240">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="124">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td style="padding:10px;"><table width="603" height="301" border="0" align="center" cellpadding="0" cellspacing="0" background="image/logoinbg.gif" >
      <tr>
        <td width="235" height="301">&nbsp;</td>
        <td width="368"><table width="100%">
          <tr>
            <td><table width="100%" cellspacing="10">
              <tr>
                <td style="font-size:12px; color:#32537F">请输入口令：</td>
                <td><input type="password" id="txtPwd"    maxLength="8" style="border:1px solid #4C7499;"></td>
              </tr>
              <tr>
              	<td></td>
				<td><input type="button" name="Submit" value="登录      " style="width:120px;height:21px;border-left:1px solid #7EA0BF;border-top:1px solid #7EA0BF;border-right:1px solid #365D82;border-bottom:1px solid #365D82; background-color:#DDE9EF;" onclick=" SecureLoginSM2()"></td>
               
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table cellspacing="10">
              
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="24" style="padding-top:4px;padding-right:10px;border-top:1px solid #AAB8C3; text-align:right;color:#333333; font-family:Arial,宋体;font-size:12px;">版权所有&copy;颐信科技有限责任公司</td>
  </tr>
</table>
</form>

</BODY>	

</HTML>
