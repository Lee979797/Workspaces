<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-5-20
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <title>信息查询</title>
    <script language="javascript">
        //禁止用F5键
        document.onkeydown = function () {
            if (event.keyCode == 116) {
                event.keyCode = 0;
                event.cancelBubble = true;
                return   false;
            }
        }
        //禁止右键弹出菜单
        document.oncontextmenu = function () {
            return   false;
        }
    </script>
</head>
<body style="background:#fff;">
<div class="prompt">
    <div class="promptou">提示信息</div>
    <div class="prompti">
        <div class="prompt_left"><img src="/images/prompt_success.jpg" /></div>
        <div class="prompt_right">
            <ul>
                <li><b>${resultMsg}</b></li>
                <li>
                    <c:choose>
                        <c:when test="${source eq 'certChange'}">
                            <input type="submit" name="modify" value="返  回" class="newBtn1"
                               onClick="window.location.href='/bsweb/certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}'"
                               class="newBtn1" />
                        </c:when>
                        <c:otherwise>
                            <input type="submit" name="modify" value="返  回"  class="newBtn1"
                               onClick="window.location.href='/product/jsp/certificate/certSearch.jsp?source=${source}'"
                               class="newBtn1" />
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</body>
</html>