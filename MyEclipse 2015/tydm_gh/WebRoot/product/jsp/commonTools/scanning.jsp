<%--@elvariable id="dm" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="message" type="java.lang.String"--%>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <title>��Ϣ��ѯ</title>
    <script type="text/javascript">
        function fCheckValue() {
            if (isEmpty(document.thisForm.dm.value)) {
                ymPrompt.alert({message: "�������벻��Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            if (/^[A-Z0-9]{8}$/.test(document.thisForm.dm.value)) {
                document.thisForm.submit();
                return true;
            } else {
                ymPrompt.alert({message: "�����������벻��ȷ!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }


        }
    </script>
</head>
<body>
<div class="page_top">��֤ &gt;&gt; ���ù��� &gt;&gt; ��ά���ȡ
</div>
<div id="list_main">
    <div class="list_box">
        <div class="list_box_top" style="text-align: center;">
            ��ά���ȡ��
            <TEXTAREA class="input_txt_morebz" onpaste="showLength(this);" onkeyup="showLength(this);"
                      name="sp.shreason" id="info1" rows="3"></TEXTAREA>
            <span style="color: #FF0000">�뽫��궨λ�������ı����У�</span>

        </div>
    </div>
    <div class="clears"/>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    <div style="font-size: 16px; text-shadow: teal;  width: 50%; margin-top: 50px ;  text-align:  center;display: ${(message!=null and message!='')?'block':'none'} ;">${message}</div>
</div>
</body>
</html>
