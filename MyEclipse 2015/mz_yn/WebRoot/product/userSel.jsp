<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String cn = request.getParameter("caName");
    UserBo userBo = new UserBo();
%>
<c:set var='list' value="<%=userBo.userCAList(cn)%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>确认端口</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="${pageContext.request.contextPath}/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script language="JavaScript">
        function submits() {
            var _value = document.getElementById('listUser').value;
            window.parent.ymPrompt.doHandler(_value, true);
        }
    </script>
</head>
<body style="background:#fff;">
<br/>
<table width="350" border="0" cellpadding="0" cellspacing="0">

    <tr>
        <td height="15" align="right" class="font_14">用户名：</td>
        <td>
            <select name="listUser" id="listUser">
                <c:if test="${fn:length(list)>0}">
                    <c:forEach var="user" items="${list}">
                        <option value="${user.userName}">${user.userName}</option>
                    </c:forEach>
                </c:if>
            </select>
        </td>
        <td class="font_12_red"><input type="button" name="button" class="logoin_btn_on" onclick="submits();"
                                       id="button" value="确定"/></td>
    </tr>
    <tr>
        <td height="15" align="right" class="font_14">&nbsp;</td>
        <td>&nbsp;</td>
        <td class="font_12_red">&nbsp;</td>
    </tr>
</table>
<script type="text/javascript">
    (function () {
        <c:if test="${fn:length(list) eq 1}">
        submits();
        </c:if>
    })();
</script>
</body>
</html>
