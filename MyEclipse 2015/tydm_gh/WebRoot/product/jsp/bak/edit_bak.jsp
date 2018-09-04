<%@ page contentType="text/html; charset=gb2312" language="java" isELIgnored="false" %>
<%@ page import="java.util.UUID" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String osName = System.getProperty("os.name");
    Boolean linux = false;
    if (osName.contains("linux")) {
        linux = true;
    }
%>
<c:set var="linux" value="<%=linux%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=5; IE=8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>�ޱ����ĵ�</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src='/dwr/engine.js'></script>
    <script type="text/javascript" src='/dwr/util.js'></script>
    <script type="text/javascript" src='/dwr/interface/monitor.js'></script>
</head>
<body>
<div class="page_top">
    <div align="right" style=" float: right;margin-top: 3px">
        <input class="newBtn1" type="button" value="�� ��" onclick="return uploadFile();">
        &nbsp;
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="�� ��"
               onclick="history.go(-1);"/>
        &nbsp;
    </div>
    ���� &gt;&gt; ɨ��������� &gt;&gt; �������뵵��ɨ��
</div>
<div align="center" style="margin-top: 10px;">
    <form name="form1" action="/bsweb/scanTask_upload" id="form1">
        <input name="id" type="hidden" id="id" value="${task.id}">
        <input name="source" type="hidden" id="source" value="${source}">
        <input name="codeid" type="hidden" id="codeid" value="<%=UUID.randomUUID().toString()%>">
        <table align="left" border="0" cellspacing="1" cellpadding="0" class=tableBorder0>
            <tr>
                <td height="40">
                    �ĵ���ʶ��
                    <input name="wdidbz" id="wdidbz" type="hidden">
                    <input name="wdbz" type="text" readonly="readonly" id="wendangbiaoshi" size="40" maxlength="100"
                           class="input_120">
                    <select name="pageKind" class="input_120" onblur="makeString(this.value)">
                        <c:forEach var="pageKind" items="${pageKinds}">
                            <option value="${fn:trim(pageKind.pagekindId)}_${fn:trim(pageKind.pagekindName) }_${fn:trim(pageKind.pagekindKey)}">
                                    ${pageKind.pagekindName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td height="40">
                    &nbsp;&nbsp;
                    <input class="newBtn1" type="button" value="�� ��" onclick="setImageRemark()">&nbsp;&nbsp;
                    <input class="newBtn1" type="button" value="�� ��"
                           onclick="document.getElementById('wendangbiaoshi').value=''">
                    &nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>
    <form name="upload" method="post" action="/bsweb/scanTask_update" id="upload">
        <input name="task.id" type="hidden" id="task_id" value="${task.id}">
        <input name="fileName" type="hidden" id="fileName">
        <input name="file" type="hidden" id="file">
        <input name="wdidbs" type="hidden" id="wdidbs">
        <input name="imageCount" type="hidden" id="imageCount">
    </form>
</div>
<div align="center">
    <OBJECT
            classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"
            codebase="http://<%=request.getServerName()+":"+request.getServerPort()%>/product/jsp/icocx/NacaoScanProj.ocx#version=1,0,0,0"
            width="100%" height="600" align="center" hspace="0" vspace="0" id="scanner" name="scanner"></OBJECT>
    <%--  <OBJECT    classid="clsid:A975D268-09B2-4390-ADA2-E83550AA59E4" ID="AAA"              width=100%
              height=600                   align=center              hspace=0
              vspace=0
              CODEBASE="http://<%=request.getServerName()+":"+request.getServerPort()%>/product/jsp/scanTask/ImgEdit.CAB#Version=1,0,0,4">--%>
</div>
</body>
<script type='text/javascript'>
    function setImageRemark() {
        var scanner, txt;
        scanner = document.getElementById("AAA");
        txt = document.getElementById("wendangbiaoshi").value;
        scanner.ImageRemark = txt;
    }

    function makeString(value) {
        var wdbs = document.getElementById("wendangbiaoshi");
        var wdidbs = document.getElementById("wdidbz");
        var values = value.split("_");
        if (wdbs.value && !wdbs.value == "") {
            wdidbs.value += (";" + values[0] );
            wdbs.value += (";" + values[1] );
        } else {
            wdidbs.value = values[0];
            wdbs.value = values[1];
        }
    }
    function uploadFile() {
        var wdidbs = $("#wdidbz").val();
        var id = $("#id").val();
        var codeid = $("#codeid").val();
        var scanner = document.getElementById("AAA");
        var base64file = scanner.ImageData;                                   //�������õ�����
        var baseSize = base64file.length;//����base64file��С

        if (baseSize <= 0) {
            ymPrompt.alert("����ɨ�赵����", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        if (wdidbs == undefined || wdidbs == null || wdidbs == "") {
            ymPrompt.alert("���������ĵ���ʶ���ٽ����ϴ���", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        if (Number(wdidbs.split(';').length) != Number(scanner.ImageCount)) {
            ymPrompt.alert("���������ĵ���ʶ���ٽ����ϴ���", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        scanner.ImageRemark = wdidbs;
        if (baseSize > 1024 * 1024 * 5) {
            ymPrompt.alert("�ļ�̫��������ɨ�裡", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        $("#task_id").val(id);
        $("#fileName").val(encodeURIComponent(codeid));
        $("#wdidbs").val(encodeURIComponent(base64file));
        $("#imageCount").val(scanner.ImageCount);
        ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
        document.upload.submit();
        return true;
    }
    <%--$.post(--%>
    <%--"/bsweb/scanTask_update",--%>
    <%--{   'task.id':id,--%>
    <%--wdidbs:wdidbs,--%>
    <%--fileName:encodeURIComponent(codeid),--%>
    <%--imageCount:scanner.ImageCount,--%>
    <%--file:encodeURIComponent(base64file)--%>
    <%--},--%>
    <%--function (data, status) {--%>
    <%--alert(status);--%>
    <%--if (data.indexOf("ok") > 0) {--%>
    <%--window.location.href = "/bsweb/scanTask_runTask?task.id=" + id + "&source=${source}";--%>
    <%--} else {--%>
    <%--alert("�ϴ�ͼ�������쳣�������ԡ�");--%>
    <%--}--%>
    <%--});--%>
    (function () {
        var scanner = document.getElementById("AAA");
        scanner.DIP = 150;
        scanner.ColorModel = 1;
        scanner.Depth = 8;
        scanner.EditModel = 2;
        scanner.ImageHeight = 600;
        scanner.ImageFormat = 0;
        scanner.RemarkFlag = 1;
        scanner.ModifyFlag = 1;
        scanner.CheckImageSize = 0;
        <c:if test="${task.imagePath!=null}">
        scanner.DownLoadImage("http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }");
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        <c:if test="${wdidbs !=null}">
        scanner.ImageRemark = '${wdidbs}';
        document.getElementById("wendangbiaoshi").value = '${wdidbs}';
        </c:if>

    })();

</script>
</HTML>
