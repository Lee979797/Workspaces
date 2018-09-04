<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String title = "";
    String source = request.getParameter("source");
    if ("yygs".equals(source)) {
        title = "证书预约挂失";
    }
    if ("qxgs".equals(source)) {
        title = "取消预约挂失";
    }
    if ("qrgs".equals(source)) {
        title = "证书确认挂失";
    }
    boolean isYwlc = InitSysParams.system.getIsYwlc();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title></title>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zsBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/ywlcBus.js"></script>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>

    <script type="text/javascript">
        <c:if test="${resultMsg ne null and  resultMsg ne ''}">
        ymPrompt.alert({message: '${resultMsg}', width: 330, height: 220, title: '提示信息'});
        </c:if>
        function fCheckValue() {
            var jgdm;
            var source = document.getElementById("source").value;
            var isYwlc = document.getElementById("isYwlc").value;
            dwr.engine.setAsync(false);
            var codeflag;
            if ('false' == isYwlc) {
                if (isEmpty(thisForm.jgdm.value)) {
                    ymPrompt.alert({message: '请输入机构代码!', width: 330, height: 220, title: '提示信息'});
                    return false;
                } else
                    jgdm = thisForm.jgdm.value;
            }
            if ('true' == isYwlc) {
                if (isEmpty(thisForm.ywlsh.value)) {
                    ymPrompt.alert({message: '请输入业务流水号或机构代码!', width: 330, height: 220, title: '提示信息'});
                    return false;
                } else {
                    ywlcBus.findZSByYwlsh(thisForm.bzjgdm.value, thisForm.ywlsh.value, source, function (data) {
                        if (data && data.jgdm) {
                            jgdm = data.jgdm;
                            document.getElementById("jgdm").value = jgdm;
                        } else {
                            ymPrompt.alert({message: '不能办理此业务!', width: 330, height: 220, title: '提示信息'});
                            codeflag = true;
                            return false;
                        }
                    });
                }
            }
            if (codeflag) {
                return false;
            }
            codecheck.isCheckCode(jgdm, function (value) {
                if (value != true) {
                    ymPrompt.alert({message: '机构代码不正确!', width: 330, height: 220, title: '提示信息'});
                    codeflag = true;
                    return false;
                }
            });
            if (codeflag) {
                return false;
            }
            jgdmBus.checkCert(jgdm, thisForm.bzjgdm.value, '${fn:trim(sysUser.userName)}', source, function (value) {
                var vs = value.split(":");
                if ("false" == vs[0]) {
                    ymPrompt.alert(vs[1], 330, 220, '提示信息');
                    codeflag = true;
                    return false;
                }
            });
            if (codeflag) {
                return false;
            }
            zsBus.checkCert(jgdm, source, function (value) {
                var vs = value.split(":");
                if ("false" == vs[0]) {
                    ymPrompt.alert(vs[1], 330, 220, '提示信息');
                    codeflag = true;
                    return false;
                }
            });
            if (codeflag) {
                return false;
            }
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
        window.onload = function () {
            document.getElementById("jgdm").focus();
        }
    </script>
</head>
<body>
<div class="page_top">日常 &gt;&gt; 证书挂失 &gt;&gt; <%=title%>
</div>
<div id="list_main">
    <form name="thisForm" method="post" action="/bsweb/certificate_certLostSearch.action"
          onsubmit="return fCheckValue();">
        <input type="hidden" name="source" value="${param.source}" id="source"/>
        <input type="hidden" name="bzjgdm" value="${fn:trim(sysUser.bzjgdm)}" id="bzjgdm"/>
        <input type="hidden" name="isYwlc" value="<%=isYwlc%>" id="isYwlc"/>
        <%
            if (isYwlc) {
        %>
        <input type="hidden" name="jgdm" value=""/>
        <%
            }
        %>
        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                <%
                    if (isYwlc) {
                %>
                业务流水号或机构代码：
                <input name="ywlsh" type="text" class="input_120" maxlength="12" id="ywlsh" value=""/>
                <%
                    }
                %>
                <%
                    if (!isYwlc) {
                %>
                机构代码：
                <input name="jgdm" type="text" class="input_120" onkeyup="rightValues(this);" maxlength="9" id="jgdm"
                       value=""/>
                <%
                    }
                %>
                <input name="button2" type="button" class="newBtn1" id="button2" value="查 询" onclick="fCheckValue();"/>
            </div>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
</html>