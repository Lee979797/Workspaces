<%@page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.HashMap" %>

<%
    HashMap hmSession = new HashMap();
    hmSession.put("SYS_NAME", "DSign");
    session.setAttribute("hmSession", hmSession);
    String url = request.getParameter("currentPage");
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String message = request.getParameter("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>CALogin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="${pageContext.request.contextPath}/js/alert/skin/dmm-green/ymPrompt.css"/>
</head>
<body bgcolor="#F0EBEF">
<object classid="clsid:06CA9432-D9BD-4867-8475-770B131E1759"
        codebase="${pageContext.request.contextPath}/icocx/JITDSign.cab" width="0" height="0"
        id="JITDSignOcx" size="0"></object>
<script type="text/javascript" id="clientEventHandlersJS">







    <%
    if(message!=null &&  "sessionOutTime".equals(message)){
    %>
    ymPrompt.alert({message: "系统等待时间过长，请重新登录！", title: '信息提示'});

    <%
     }
    %>
    function attachSign() {
        JITDSignOcx.SetCert("SC", "", "", "", "", "");
        txt_tip.value = "验证您的数字证书是否合法有效...";
        var caInfo = JITDSignOcx.getCertInfo("SC", 0, ""); //查看CA 加密的
        var array1 = caInfo.split(",");
        var cnValue;
        var cn;
        if (array1.length > 0) {
            cnValue = array1[4];
        }
        if (cnValue) {
            document.getElementById("cn").value = cnValue.substring(cnValue.indexOf("=") + 1);
        } else {
            ymPrompt.alert({message: "请选择正确的数字签名！", handler: function () {
                document.location.reload();
            }, title: '信息提示'});
            return false;
        }
        if (JITDSignOcx.GetErrorCode() != 0) {
            ymPrompt.alert({message: "错误码：" + JITDSignOcx.GetErrorCode() + " 错误信息：" + JITDSignOcx.GetErrorMessage(), handler: function () {
                document.location.reload();
            }, title: '信息提示'});
            return false;
        }
        document.f1.ENC_DATA.value = JITDSignOcx.AttachSign("", "yzsf");
        if (JITDSignOcx.GetErrorCode() != 0) {
            ymPrompt.alert({message: "错误码：" + JITDSignOcx.GetErrorCode() + " 错误信息：" + JITDSignOcx.GetErrorMessage(), handler: function () {
                document.location.reload();
            }, title: '信息提示'});
            return false;
        }
        return true;
    }
</SCRIPT>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td height="37">
            <div align="center"><font color="#FF0000"><br>
                <br>
                <br>
                <input name="txt_tip" type="text"
                       style="font-family:'幼圆'; font-size: 12pt; border: 1px solid #D4D0C8; padding-left: 4; padding-right: 4; padding-top: 1; padding-bottom: 1; background-color: #F0EBEF"
                       value="请选择[签名]数字证书！" size="38">
                <br>
                <br>
                <br>
            </font></div>
        </td>
    </tr>
</table>
<form name="f1" action="/action/UserAction" method="post">
    <input type="hidden" name="method" value="login"/>
    <input type="hidden" name="goPage" value="/product/index.html"/>
    <input type="hidden" name="currentPage" value="<%=url %>"/>
    <input type="hidden" name="ENC_DATA"/>
    <input type="hidden" name="cn" id="cn"/>
    <input name="ScreenPix" type="hidden"/>
    <input name="loginType" type="hidden" value="3"/>
    <input type="hidden" name="currentName" id="currentName"/>
</form>



<script type="text/javascript">

      function isIE(){
          return navigator.appName.indexOf("Microsoft Internet Explorer")!=-1;
      }

      function isIE6() {
          return navigator.userAgent.split(";")[1].toLowerCase().indexOf("msie 6.0")!=-1;
      }

      function isIE7(){
          return navigator.userAgent.split(";")[1].toLowerCase().indexOf("msie 7.0")!=-1;
      }

      function isIE8(){
          return navigator.userAgent.split(";")[1].toLowerCase().indexOf("msie 8.0")!=-1;
      }

      function isIE9(){
          return navigator.userAgent.split(";")[1].toLowerCase().indexOf("msie 9.0")!=-1;
      }

     
 </script> 



<script type="text/javascript">
	
		window.onload=function(){
				if(isIE()&&(isIE6()||isIE7()||isIE8()||isIE9())){
					window.screen.width > 800 ? document.f1.ScreenPix.value = true : document.f1.ScreenPix.value = false;
				    if (attachSign()) {
				        var cn = document.getElementById("cn").value;
				        ymPrompt.win({message: '/product/userSel.jsp?caName=' + cn, handler: callBack, width: 400, height: 120, dragOut: false, title: '用户选择', iframe: true});
				    }
					
				}else{
					ymPrompt.alert({message: "请使用IE浏览器(7,8,9)版本.或调整浏览器为IE兼容模式再进行登录!", title: '信息提示', handler: function () {
						window.close();
		            }});
						
				}
			
		}



    

    function callBack(tp) {
        if (tp != 'close' && tp != '') {
            document.getElementById("currentName").value = tp;
            document.f1.submit();
        }

    }
</script>

</body>
</html>