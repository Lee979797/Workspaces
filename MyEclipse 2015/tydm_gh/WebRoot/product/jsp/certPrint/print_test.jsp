<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>����֤���ӡ</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <%-- <script language="javascript" src="/js/LodopFuncs.js"></script>
     <jsp:include page="print_common.jsp"/>--%>
    <script language="javascript" type="text/javascript">
        function printThis() {
            var print;
            print = document.getElementById("print");
            var p = print.CheckPrintName('${sysUser.printName}');
            if (p == 1) {
                ymPrompt.alert("��ӡ��ȱֽ��", 330, 220, "��ʾ��Ϣ");
                return;
            }
            if (p == 2) {
                ymPrompt.alert("��ӡ������ϵ��", 330, 220, "��ʾ��Ϣ");
                return;
            }
            if (p == 3) {
                ymPrompt.alert("��ӡ���쳣��", 330, 220, "��ʾ��Ϣ");
                return;
            }
            if (p == 4) {
                ymPrompt.alert("û�а�װ��ӡ����", 330, 220, "��ʾ��Ϣ");
                return;
            }
            /* if (p == 5) {
             ymPrompt.alert("��ӡ���������ô�������ִ�д�ӡ���ã�", 330, 220, "��ʾ��Ϣ");
             return;
             }*/
            var printSUC = print.uo_printzdg("${certi.djh}");
            if (printSUC == 0) {
                ymPrompt.alert("��ӡ���Գɹ���", 330, 220, "��ʾ��Ϣ");
            } else {
                ymPrompt.alert("��ӡ���쳣,��ӡʧ�ܣ�", 330, 220, "��ʾ��Ϣ");
            }
        }

    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">

        &nbsp;<input name="button3" type="button" class="newBtn1" id="prn1_print" value="�� ӡ"
                     onclick="printThis()"/>
    </div>
</div>
<div align="center" style="margin-top:20px;">
    <form name="searchForm" method="post" action="#">
        <input type="hidden" name="jgdm.jgdm" value="216542714">
        <input type="hidden" name="jgdm.fbsl" value="${jgdm.fbsl}">
        <input type="hidden" name="type" value="${type}">
        <OBJECT ID="print"
                CLASSID="CLSID:230DA4AF-6773-4D8E-AE36-FCE670FE3695"
                CODEBASE="/product/jsp/icocx/dmcj.CAB#version=1,7,0,0" width="930" height="700"
                style="text-align: center;">
            <param name="jgdm" value="000000000">
            <param name="frlx" value="����������">
            <param name="frmc" value="������">
            <param name="jgmc" value="${certi.jgmc}">
            <param name="jglxmc" value="��ҵ����">
            <param name="jgdz" value="ȫ����֯����������Ϣ�ɼ�ϵͳ��ַ��ӡ����">
            <param name="yxq" value="${certi.yxq}">
            <param name="bfdw" value="${zrxzqhMap[fn:trim(certi.bzjgdm)].jgmc}">
            <param name="djh" value="${certi.djh}">
            <param name="fbsl" value="3">
            <param name="ewm" value="000000000;ȫ����֯����������Ϣ�ɼ�ϵͳ���ƴ�ӡ����;ȫ����֯����������Ϣ�ɼ�ϵͳ��ַ��ӡ����">
            <param name="ts"
                   value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njtsbz?certi.tsxx1:''}${certi.tsxx2}${certi.tsxx3}">
            <param name="ermx" value="0">
            <param name="ermy" value="0">
            <param name="dyerm" value="0">
            <param name="osx" value="${sysUser.offsetx}">
            <param name="osy" value="${sysUser.offsety}">
            <param name="printname" value="${sysUser.printName}">
        </OBJECT>

    </form>
</div>
</body>

</html>

