<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <%--
      Created by IntelliJ IDEA.
      User: yanzh
      Date: 12-5-20
      Time: 上午11:50
      To change this template use File | Settings | File Templates.
    --%>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }
    </script>
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
    <title>操作成功页面</title>
</head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="${source}">
    <div class="prompt">
        <div class="promptou">提示信息</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg" /></div>
            <div class="prompt_right">
                <ul>
                    <li><b>${resultMsg}</b></li>
                    <li><input type="button"
                               onclick="window.location.href='${pageContext.request.contextPath}/product/jsp/certificate/forceUpdateNoZs.jsp'"
         class="newBtn1"            name="modify" value="返 回" class=btn1/></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="promptdi"></div>
    </div>
</form>
</body>
</html>
