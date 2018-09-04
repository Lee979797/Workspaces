<%--@elvariable id="dm" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="message" type="java.lang.String"--%>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#dm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		fCheckValue();
		}
	   }
	</script>
    <title>信息查询</title>
    <script type="text/javascript">
        function fCheckValue() {
            if (isEmpty(document.thisForm.dm.value)) {
                ymPrompt.alert({message: "机构代码不能为空!", width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (/^[A-Z0-9]{8}$/.test(document.thisForm.dm.value)) {
                document.thisForm.submit();
                return true;
            } else {
                ymPrompt.alert({message: "机构代码输入不正确!", width: 330, height: 220, title: '提示信息'});
                return false;
            }


        }
    </script>
</head>
<body>
<div class="page_top">发证 &gt;&gt; 常用工具 &gt;&gt; 机构代码校验
</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb/commonTools_verifyCode" onkeypress="return ches(this);">
        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">

                机构代码：
                <input name="dm" type="text" class="input_120" maxlength="8" id="dm"
                       value="${fn:substring(dm,0,8)}"/>
                <span style="color: #FF0000">无校验位的八位代码</span>
                <input name="button2" type="button" class="newBtn1" id="button2" value="查 询" onclick="fCheckValue();"/>
            </div>
        </div>
        <div class="clears" style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
        <div style="font-size: 16px; text-shadow: teal;  width: 50%; margin-top: 50px ;  text-align:  center;display: ${(message!=null and message!='')?'block':'none'} ;">${message}</div>
    </form>
</div>
</body>
</html>
