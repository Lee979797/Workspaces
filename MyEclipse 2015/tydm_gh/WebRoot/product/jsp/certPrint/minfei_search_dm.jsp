<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>

    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
           <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#jgdm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			fCheckValue();
		}
	   }
	</script>

    <script type='text/javascript' src='/js/tools.js'></script>
    <title>信息查询</title>
    <script type="text/javascript">
        function fCheckValue() {
            var jgdm = document.getElementById("jgdm");
            if (jgdm.value.length!=18) {
                ymPrompt.alert({message:"请输入正确的统一代码", width:330, height:220, handler:function () {
                    jgdm.focus();
                }});
              
            } else if(jgdm.value.substring(1,2)!='2'){
                ymPrompt.alert({message:"数据类型不正确！", width:330, height:220, handler:function () {
                    jgdm.focus();
                }});
            }else{
            	  document.thisForm.submit();
                }


        }
    </script>
</head>
<body style="background:#fff;" onload="document.getElementById('jgdm').focus()">
<div class="page_top">登记  >> 民办非企业单位业务 >> 证书补打</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb/certificatePrint_zb_info.action">
        <input type="hidden" name="source" value="${source}" id="source"/>
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                统一代码：
                <input type="text" name="jgdm.tyshxydm" size="21" id="jgdm"
                       maxlength="18" value="${jgdm.tyshxydm}" class="input_200"
                        >&nbsp;<input type="button" onclick="fCheckValue();" class="newBtn1" name="modify" value="查 询">
                <br/>
            </div>

            <br/>
        </div>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
<c:if test="${message!=null && message!=''}">
    <script language="javascript">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</html>
