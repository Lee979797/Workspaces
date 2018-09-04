<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="source" type="java.lang.String"--%>

<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
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
    <title>打印代码查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript">
        function fCheckValue() {
            dwr.engine.setAsync(false);
            flag = false;
            var jgdm = document.getElementById("jgdm").value;
            var bzjgdm = document.searchForm.bzjgdm.value;

            /*      if (/^.*verify.*$/.test('
            ${source}')) {
             if (checkJgdmCode(jgdm) && checkJgdmWithBzjgdmNoPrint(jgdm, bzjgdm)) {
             document.searchForm.submit();
             } else {
             flag = false;
             }
             } else {*/
            if (checkJgdmCode(jgdm) && checkJgdmWithBzjgdmNoPrint(jgdm, bzjgdm,'${sysUser.userName}')) {
                document.searchForm.submit();
            } else {
                flag = false;
            }
            return flag;
            /*   }*/

        }
        function rightValues(obj) {
            if (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40") {
                return;
            }
            if (obj.value && obj.value.length > 0) {
                obj.value = obj.value.trim().toUpperCase();
                if (!/^[A-Z0-9]{1,9}$/.test(obj.value)) {
                    obj.value = obj.value.substr(0, obj.value.length - 1);
                    rightValues(obj);
                }
            }
        }
    </script>
</head>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<body style="background:#fff;" onload="document.getElementById('jgdm').focus()"
      onkeypress="ches(document.searchForm,fCheckValue);">
<div class="page_top">${title}</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/certificatePrint_${source}"
          onsubmit="return checkJgdmCode(document.getElementById('jgdm').value);">
        <input type="hidden" name="bzjgdm" value="${fn:trim(sysUser.bzjgdm)}" id="bzjgdm"/>
        <input type="hidden" name="certi.type" value="${certi.type}" id="type"/>
        <c:if test="${zrxzqhs[fn:trim(sysUser.bzjgdm)].fzflag eq 1}">
            <div class="list_box">
                <div class="list_box_top" style="text-align: center;">
                    <label for="jgdm">机构代码：</label>
                    <input type="text" name="jgdm.jgdm" size="13" id="jgdm"
                           maxlength="9" value="${jgdm.jgdm}" onkeyup="rightValues(this)"
                           class="input_120">
                    <input type="button" class="newBtn1" name="modify" onkeypress="return false;" value="查 询"
                           onclick="return fCheckValue();">
                    <span>&nbsp;${prompt}</span>
                    <br/>
                </div>
                <br/>
            </div>
        </c:if>
        <c:if test="${zrxzqhs[fn:trim(sysUser.bzjgdm)].fzflag ne 1}">
            当前用户没有打证权限，请联系省中心或上级主管部门处理！
        </c:if>
        <div style="background:url(/images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
<c:if test="${message!=null && message!=''}">
    <script language="javascript" type="text/javascript">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</html>
