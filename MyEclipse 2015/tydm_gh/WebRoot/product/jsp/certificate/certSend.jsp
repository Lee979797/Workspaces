<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-5-20
  Time: ����11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <title>��Ϣ��ѯ</title>
    <script language="javascript">
        //��ֹ��F5��
        document.onkeydown= function () {
            if (event.keyCode == 116) {
                event.keyCode = 0;
                event.cancelBubble = true;
                return   false;
            }
        }
        /*//��ֹ�Ҽ������˵�
         document.oncontextmenu= function () {
            return   false;
        }*/
    </script>
</head>
<body>
<div class="prompt">
    <div class="promptou">��ʾ��Ϣ</div>
    <div class="prompti">
        <div class="prompt_left"><img src="/images/prompt_success.jpg" /></div>
        <div class="prompt_right">
            <ul>
                <li><b>${resultMsg}</b></li>
                <li>
                    <input type="submit" name="modify" value="�� ��" onClick="window.location.href='/bsweb/certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}'" class="newBtn1" />
                </li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</body>
</html>