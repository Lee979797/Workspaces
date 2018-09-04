<%@ page contentType="text/html; charset=gbk" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title></title>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#jgdm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		fCheckValue();
		}
	   }
	</script>
    <script type="text/javascript">
        function fCheckValue() {
            var codeflag;
            if (isEmpty(thisForm.jgdm.value)) {
                ymPrompt.alert({message: '请输入统一代码!', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            dwr.engine.setAsync(false);
           // codecheck.isCheckCode(thisForm.jgdm.value, function (value) {
               // if (value != true) {
                   // ymPrompt.alert({message: '机构代码不正确!', width: 330, height: 220, title: '提示信息'});
                   // codeflag = true;
                   // return false;
               // }
            //});
           // if (codeflag) {
               // return false;
           // }
            thisForm.submit();
            return true;
        }
        function rightValues(obj) {
            if (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40") {
                return;
            }
            if (obj.value && obj.value.length > 0) {
                obj.value = obj.value.trim().toUpperCase();
                if (!(/^[A-Z0-9]{1,9}$/.test(obj.value))) {
                    obj.value = obj.value.substr(0, obj.value.length - 1);
                    rightValues(obj);
                }
            }
        }
    </script>
</head>
<body>
<div class="page_top">发证 &gt;&gt; 常用工具 &gt;&gt; 强制修改</div>
<div id="list_main">
    <form name="thisForm" method="post" action="/bsweb/certificate_forceUpdatePage.action"
          onsubmit="return fCheckValue();">
        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                统一代码：<input name="jgdm" type="text" class="input_200"  maxlength="18"
                            id="jgdm"/>
                <input name="button2" type="button" class="newBtn1" id="button2" value="查 询" onclick="fCheckValue();"/>
            </div>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
</html>
<script>
    <%
        Object msg = request.getAttribute("resultMsg");
        if(msg != null&&!"".equals(msg.toString().trim())){
            if("noCode".equals(msg.toString())){
    %>
    ymPrompt.alert({message: '机构代码不在主表中!', width: 330, height: 220, title: '提示信息'});
    <%}else{
    %>
    ymPrompt.alert({message: '<%=msg%>', width: 330, height: 220, title: '提示信息'});
    <%
    }



    }%>
</script>