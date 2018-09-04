<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
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
        function fCheckValue() {
            dwr.engine.setAsync(false);
            flag = false;
            if (checkJgdmCode(thisForm.mc.value) && checkValidate()) {
                flag = true;
            } else {
                flag = false;
            }
        }
        function checkValidate() {
            var jgdm = thisForm.mc.value;
            var bzjgdm = thisForm.bzjgdm.value;
            var source = document.getElementById("source").value;
            if (source != "unvalidate") {
                if (!checkJgdmWithBzjgdm(jgdm, bzjgdm,'${sysUser.userName}')) {
                    return false;
                }
            } else {
                if (!checkFzdmExit(jgdm)) {
                    return false;
                }
            }
            if (!ywkz(jgdm, source)) {
                return false;
            }
            if (source == "check") {
                var b = false;
                kqnjBus.checkYear(jgdm, bzjgdm, function (value) {
                    var vs = value.split(":");
                    if ("false" == vs[0]) {
                        ymPrompt.alert({message:vs[1], width:330, height:220, handler:handler});
                        b = false;
                    } else {
                        b = true;
                    }
                });
                if (b)
                    document.thisForm.submit();
                return false;
            }
            if (source == "update") {
                if (needAudia(jgdm, "bgsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            if (source == "unvalidate") {
                if (needAudia(jgdm, "fzhfsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }
            }
            if (source == "validate") {
                if (needAudia(jgdm, "fzsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            if (source == "delete") {
                if (needAudia(jgdm, "deletesh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            return true;
        }
    </script>
</head>
<body style="background:#fff;" onload="document.getElementById('mc').focus()">
<div class="page_top">日常业务 &gt;&gt; 日常业务 &gt;&gt; 机构检索</div>
<div id="list_main">
    <form method="get" name='thisForm' action="/bsweb/business_search.action">
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl"/>
        <input type="hidden" name="source" value="${param.source}" id="source"/>
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="ywlx" id="ywlx"/>
        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                机构代码：
                <input type="text" name="mc" size="13" id="mc"
                       maclass="newBtn1"value="${mc}"       class="input_120">
                <input type="button" onclick="fCheckValue();" class="btn1" name="modify" value="查 询">
                <br/>
            </div>
            <br/>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
<c:if test="${message!=null && message!=''}">
    <script language="javascript">
        ymPrompt.errorInfo('${message}',330,220, '提示信息');
    </script>
</c:if>
</html>
