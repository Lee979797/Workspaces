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

    <script type='text/javascript' src='/js/tools.js'></script>
    <title>信息查询</title>
    <script type="text/javascript">
        function download() {
            document.getElementById("down").disabled = 'disabled';
            document.thisForm.submit();
            setTimeout(function () {
                window.history.back();
//                window.location.href = "/bsweb/statistics_search?source=export";
            }, 2000);

        }
    </script>
</head>
<body style="background:#fff;">
<div class="page_top">${title}</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb/statistics_download.action">
        <input type="hidden" name="fileName" value="${fileName}" id="source"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                点击下载：&nbsp;<input type="button" onclick="download()" class="btn1" name="down" id="down"
                                  value="下 载">
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
