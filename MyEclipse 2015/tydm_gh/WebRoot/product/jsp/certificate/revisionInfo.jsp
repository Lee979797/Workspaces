<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-5-20
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=gbk" %>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/punishBus.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <title>信息查询</title>
    <script language="javascript">
        //禁止用F5键
        document.onkeydown=function () {
            if (event.keyCode == 116) {
                event.keyCode = 0;
                event.cancelBubble = true;
                return   false;
            }
        }
        //判断是否新办处罚，跳转到相应页面
        function choosePath(type) {
            dwr.engine.setAsync(false);
            if (1 == type)
                window.location.href = '/bsweb/certificatePrint_zb_print?jgdm.jgdm=${jgdm}&certi.type=1';
            if (2 == type)
                window.location.href = '/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm}';
            if (3 == type)
                window.location.href = '/bsweb/certificatePrint_verify_invoice?jgdm.jgdm=${jgdm}';
         /*   punishBus.isNewChuFa('${jgdm}', function (data) {
                if (data == '-1') {

                } else {
                    ymPrompt.confirmInfo({message: "新办超期，需要进行处罚！点击确定跳转到处罚页面！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                        if (tp == 'ok') {
                            window.location.href = '/bsweb/punish_show_punish?cfjl.id=' + data
                        }
                    }});
                }
            });*/
        }
    </script>
</head>
<body>

<div class="prompt">
    <div class="promptou">提示信息</div>
    <div class="prompti">
        <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
        <div class="prompt_right">
            <ul>
                <li><b>${resultMsg}</b></li>
             
                <li>
                   

                    <c:if test="${path eq null or path eq ''}">
                        <input type="submit" name="modify" value="返  回" class="newBtn1"
                               onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=${jglx }'"/>
                    </c:if>
                    <c:if test="${path eq 'page'}">
                        <input type="submit" name="modify" value="返  回" class="newBtn1"
                               onClick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=${formType}&jglx=${jglx }'"/>
                    </c:if>


                </li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</body>
</html>