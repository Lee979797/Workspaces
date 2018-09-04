<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
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
    <title>��Ϣ��ѯ</title>
    <script type="text/javascript">
        function fCheckValue() {
            document.thisForm.submit();
        }
    </script>
</head>

<body style="background:#fff;" onload="document.getElementById('jgdm').focus()">
<div class="page_top">${title}</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb/statistics_show${source}.action">
        <input type="hidden" name="source" value="${source}" id="source"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: left;margin-left: 10px">
                ��������/��������/ͳһ������ô��룺
                <input type="text" name="jgdm.jgmc" size="50" id="jgdm"
                       maxlength="50" value="${jgdm.jgmc}" class="input_200">


                �������ݿ⣺
                <select name="database" id="database">
                    <option value="<%=TJgdm.class.getName()%>">��Ч��</option>
                    <option value="<%=TFzdm.class.getName()%>">ע����</option>
                     <option value="<%=TBgk.class.getName()%>">��ʷ��</option>
                    <!--  <option value="<%=TBgk.class.getName()%>">��������</option> 
                    <option value="<%=TLjdm.class.getName()%>">��Ч�����</option>
                    <option value="<%=TQzjgdm.class.getName()%>">����Ǩַ��</option>-->
                </select>
                <input type="button" onclick="fCheckValue();" class="newBtn1" name="modify" value="�� ѯ">
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
        ymPrompt.errorInfo('${message}', 330, 220, '��ʾ��Ϣ');
    </script>
</c:if>
</html>
