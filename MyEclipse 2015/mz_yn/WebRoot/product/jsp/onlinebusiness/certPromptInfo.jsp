<%@ page contentType="text/html; charset=gbk" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <title>信息查询</title>
    <script language="javascript">
        //禁止用F5键
        function document.onkeydown() {
            if (event.keyCode == 116) {
                event.keyCode = 0;
                event.cancelBubble = true;
                return   false;
            }
        }
        //禁止右键弹出菜单
        function document.oncontextmenu() {
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
                <li><input type="submit" class="newBtn1" onClick="window.location.href='/bsweb/onLine_jdList.action?zt=3&ywlx=3&pageno=${pageno}&rowNumsView=${rowNumsView}'" value="返 回" name="modify" /></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</body>
</html>