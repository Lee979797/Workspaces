<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
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
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>����֤���ӡ</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <%--  <script language="javascript" src="/js/LodopFuncs.js"></script>--%>
    <%--

        <jsp:include page="print_common.jsp"/>
    --%>
    <script type='text/javascript'>
        var fbids = [];
        <c:forEach var="fb" items="${certi.fbs}">
        fbids.push('${fb}');
        </c:forEach>
        /**
         *   djh �ǼǺ�
         *  type ֤������
         *  index �������
         *  flag ������
         *  again �ٴδ�ӡ
         **/
        function print_djh(djh, type, index, flag, again) {
            var print;
            print = document.getElementById("print");
            var p = print.CheckPrintName('${sysUser.printName}');
            if (p == 1) {
                ymPrompt.alert("��ӡ��ȱֽ��", 330, 220, "��ʾ��Ϣ");
                return false;
            }
            if (p == 2) {
                ymPrompt.alert("��ӡ������ϵ��", 330, 220, "��ʾ��Ϣ");
                return false;
            }
            if (p == 3) {
                ymPrompt.alert("��ӡ���쳣��", 330, 220, "��ʾ��Ϣ");
                return false;
            }
            if (p == 4) {
                ymPrompt.alert("û�а�װ��ӡ����", 330, 220, "��ʾ��Ϣ");
                return false;
            }
            /* if (p == 5) {
             ymPrompt.alert("��ӡ���������ô�������ִ�д�ӡ���ã�", 330, 220, "��ʾ��Ϣ");
             return false;
             }*/
            var printSUC = print.uo_printzdg("�����${sysUser.bzjgdm}-" + djh + "" + index);
            if (printSUC == 0) {
                if (flag && (flag == true || flag == "true")) {
                    ymPrompt.win({message: '/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + djh + '&source=3&index=' + index + '&flag=' + flag + '&again=' + again,
                        handler: callback, closeBtn: false, titleBar: false,
                        width: 400, height: 330, dragOut: false, iframe: true});
                    return true;
                } else {
                    callback(djh + ";" + type + ";" + index + ";" + flag + ";" + false + ";" + true);
                }
            } else {
                ymPrompt.alert("��ӡ���쳣,��ӡʧ�ܣ�", 330, 220, "��ʾ��Ϣ");
                return false;
            }
        }
        function callback(tp) {
            /**
             *   values[0] �ǼǺ�
             *  values[1] ֤������
             *  values[2] �������
             *  values[3] ������
             *  values[4]���´�ӡ
             *   isRight �Ƿ���������ȷ
             **/
            var djh, type, index, flag, again, isRight;
            if (tp != 'close' && tp != '') {
                var values = tp.split(';');
                djh = values[0];
                type = values[1];
                index = values[2];
                flag = values[3];
                again = values[4];
                isRight = values[5];
                //��ӡ����������ִ�лص�����
                if (index == "") {
                    document.searchForm.submit();
                    return;
                }
                if (fbids.length > 0) {
                    if (isRight && isRight == 'true') {
                        index = fbids.pop();
                    }
                    print_djh(djh, type, index, flag, again);
                } else {
                    document.searchForm.submit();
                    return;
                }
            }
        }
        function _printCode(tp) {
            if (tp == 'ok') {
                <c:if test="${'1' eq certi.type}">
                if (fbids.length > 1) {
                    var flag = confirm("���븱������𣿹���Ҫ����'" + fbids.length + "'�Σ�ȡ���󣬿�����֤���޸�ҳ��д֤����");
                    print_djh("${fn:trim(certi.djh)}-", 1, fbids.pop(), flag, false)
                } else if (fbids.length > 0) {
                    print_djh("${fn:trim(certi.djh)}-", 1, fbids.pop(), true, false)
                }
                </c:if>
                <c:if test="${'1' ne certi.type}">
                print_djh("${fn:trim(certi.djh)}", 0, '', true, false);
                </c:if>

            }
        }
        function _goBack() {
            window.history.back();
        }
    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<form name="searchForm" method="post" action="/bsweb/certificatePrint_print_special.action">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}">
    <input type="hidden" name="jgdm.fbsl" value="${jgdm.fbsl}">
    <input type="hidden" name="certi.type" value="${certi.type}">

</form>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style="width: 30% ; float: right;">
        <input type="button" class=btn2 value="��ӡ֤��" name="btok"
               onClick="ymPrompt.confirmInfo('��ȷ����ӡ��',null,null,null,_printCode);">
        &nbsp;
        <input type="button"
               value="�� ��"
               name="cmdExit"
               class="newBtn1"
               onclick="_goBack();">&nbsp;
    </div>
</div>

<jsp:include page="print_common.jsp"/>
</body>
</html>
