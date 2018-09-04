<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>��ӡ</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='<c:url value="/js/tools.js"/>'></script>
    <jsp:include page="print_common.jsp"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script language="javascript" type="text/javascript">

        function print(text, type, flag) {
            var LODOP = createPage(text);
            LODOP.ADD_PRINT_TEXT(601, 169, 274, 48, "�����${sysUser.bzjgdm}-" + text);
            LODOP.SET_PRINT_STYLEA(0, "FontName", "����");
            LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
            LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
            LODOP.PRINT();
            if (flag) {
                var a = 0;
                showModalDialog('/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + text + "&source=3",
                        window, "dialogHeight:330px; dialogWidth: 400px; edge: raised; center: Yes; help: No; resizable: No; status: No; unadorned:1;");
            }

        }
        function load() {
            var start = Number("${certi.fbSn}");
            var fbNum = Number('${certi.fbNumber}');
            var b = false;
            var a = 0;
            if (fbNum > 1) {
                b = confirm("���븱������𣿹���Ҫ����'" + fbNum + "'�Σ�ȡ���󣬿�����֤���޸�ҳ��д֤����");
                for (var i = start; i < start + fbNum; i++) {
                    print("${certi.djhFbPre}" + (i + 1), 1, b);
                }
            } else {
                if (fbNum > 0)
                    print("${certi.djhFbPre}" + (start + 1), 1, true);
            }
            if (Number('${certi.zbNumber}') > 0)
                print("${certi.djhZb}", 0, true);
        }
        function printAgain(flag) {//�ٴδ�ӡ
            if (!confirm("ȷ��Ҫ�ٴδ�ӡ��")) {
                return;
            }
            if (flag == "0") {
                print("${certi.djhZb}", 0, true);
            }
            if (flag == "1") {
                var count = 0;
                var start = Number("${certi.fbSn}");
                var fbNum = Number('${certi.fbNumber}');
                var b = false;
                if (fbNum > 1) {
                    b = confirm("���븱������𣿹���Ҫ����'" + fbNum + "'�Σ�ȡ���󣬿�����֤���޸�ҳ��д֤����");
                    for (var i = start; i < start + fbNum; i++) {
                        print("${certi.djhFbPre}" + (i + 1), 1, b);
                    }
                } else {
                    print("${certi.djhFbPre}" + (start + 1), 1, true);
                }
            }
        }

    </script>

</HEAD>
<BODY style="background:#fff;" class="body">
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"
        width=0 height=0>
    <param name="Caption" value="��ʾ��">
    <param name="Border" value="0">
    <param name="Color" value="white">
    <embed id="LODOP_EM" TYPE="application/x-print-lodop" width=0 height=0
           border=0 Color="white" PLUGINSPAGE="<c:url value='/icocx/install_lodop.exe'/>">
</object>
<div class="prompt">
    <div class="promptou">��ʾ��Ϣ</div>
    <div class="prompti">
        <form method="POST" name='frmThis' action="/bsweb/certificatePrint_list_no_print">
            <input type="hidden" value="${type}" name="source"/>

            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <c:if test="${certi.zbNumber gt 0}">
                        <li>
                            <input class="btn2" type="button" value="�ٴδ�ӡ" name="B0"
                                   onclick="printAgain('0')"> <span>����(�������)</span>
                        </li>
                    </c:if>
                    <c:if test="${certi.fbNumber gt 0}">
                        <li>
                            <input class="btn2" type="button" value="�ٴδ�ӡ" name="B2"
                                   onclick="printAgain('1')"> <span>����(�������)</span>
                        </li>
                    </c:if>
                    <li>
                        <strong>����֤�鴦��</strong>����ȡ������֤���ţ�����ٴδ�ӡ������ӡ��ȷ����������Ӧ��ţ���ɴ�ӡ�󣬽�������֤������Դ��ģ�<br>
                        <strong>��ӡ���հ�֤�鴦��</strong>����ȡ������֤���ţ��Ѵ�����Ŀհ�֤��Żش�ӡ����Ȼ�����ٴδ�ӡ����������Ӧ���&nbsp;<br>
                        <strong>�ٴδ�ӡʱ��ˮ�Ų���,��Ƥ��治��</strong>
                    </li>
                    <li>
                        <b> <a href="#" onclick="document.frmThis.submit();">��ʼ�µĴ�ӡ</a> </b>
                    </li>
                </ul>
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</BODY>
<script type="text/javascript" language="javascript">
    window.onload = function () {
        load();
    };
</script>

</HTML>