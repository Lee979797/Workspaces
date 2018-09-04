<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
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
            var xzqh = document.getElementById("xzqh");
            if (xzqh.value == "") {
                ymPrompt.alert({message: "请先选择需要准入的办证机构", width: 330, height: 220, title: '提示信息'});
                xzqh.focus();
                return false;
            }
            thisForm.submit();
            return true;

        }

    </script>
</head>
<body style="background:#fff;">
<div class="page_top">系统 &gt;&gt; 办证机构准入 &gt;&gt; 添加准入机构</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb//bsweb/xzqhManage_search.action">
        <input type="hidden" name="source" value="${param.source}" id="source"/>
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="ywlx" id="ywlx"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                行政区划：
                <select name="zrxzqh.xzqh" id="xzqh" class="input_200" style="width: 300px">
                    <option value="">请选择行政区划</option>
                    <c:forEach var="xzqh" items="${xzqhs}">
                        <option value="${xzqh.dm}">${xzqh.dm} ${xzqh.mc}</option>
                    </c:forEach>
                </select>
                &nbsp;
                <input type="button" name="modify" value="添 加" onClick="javascript:return fCheckValue();"
                       class="newBtn1">
            </div>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
<c:if test="${message!=null && message!=''}">
    <script language="javascript">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</html>