<%--@elvariable id="task" type="com.ninemax.jpa.code.model.TSmrw"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" language="java" isELIgnored="false" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.ninemax.jpa.code.model.SmTaskType" %>
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
<c:set var="types" value="<%=SmTaskType.values()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=5; IE=8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>�ޱ����ĵ�</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src='/dwr/engine.js'></script>
    <script type="text/javascript" src='/dwr/util.js'></script>
    <script type="text/javascript" src='/dwr/interface/monitor.js'></script>
</head>
<body>
<div class="page_top">
    <div align="left" style="float: left; margin-top: 3px">
        ����&gt;&gt; ɨ��������� &gt;&gt; �������뵵��ɨ��

    </div>
    <div align="right" style=" float: right;margin-top: 3px">
        <form name="form1" action="/bsweb/scanTask_upload" id="form1">
            <input name="id" type="hidden" id="id" value="${task.id}"/>
            <input name="status" type="hidden" id="status" value="${task.status}"/>
            <input name="source" type="hidden" id="source" value="${source}"/>
            <input name="codeid" type="hidden" id="codeid" value="<%=UUID.randomUUID().toString()%>"/>
            <input name="base64" type="hidden" id="base64" value="${imageData}"/>
            �������ڣ� <INPUT name="task.createTime" id="createTime" onclick="WdatePicker({el:$dp.$('createTime')});"
                        value="<fmt:formatDate value='${task.createTime}' pattern='yyyy-MM-dd'/>"
                        class="input_120"/>
            <IMG src="/images/icon_rili.gif" align="middle" onclick="WdatePicker({el:$dp.$('createTime')});"/>
            �������ͣ�<select name="type" id="type" ${(task.type eq null or task.type eq '')?'':'disabled="disabled"'}  >
            <c:forEach var="type" items="${types}">
                <option value="${type.value}" ${task.type eq type.value?"selected":""}>${type.name}</option>
            </c:forEach>
        </select>
            <input class="newBtn1" type="button" value="�� ��" id="uploadb" onclick=" uploadFile()">
            &nbsp;
            <input name="button3" type="reset" class="newBtn1"
                   id="button31" value="�� ��"
                   onclick="window.location.href='/bsweb/scanTask_${source}?task.status=${task.status}'"/>
            &nbsp;
        </form>


    </div>

</div>

<div align="center">
    <div align="left" style="text-align: left;margin-left: 5px">�������룺${task.jgdm}&nbsp;<span>�������ƣ�${task.jgmc}</span>
    </div>
    <OBJECT
            classid="clsid:A975D268-09B2-4390-ADA2-E83550AA59E4" ID="AAA"
            width=100%
            height=600
            align="center"
            hspace=0
            vspace=0
            CODEBASE="http://<%=request.getServerName()+":"+request.getServerPort()%>/product/jsp/scanTask/ImgEdit.CAB#Version=1,0,0,4">
        <param name="EditModel" value="0">
    </OBJECT>
</div>
</body>
<script type="text/javascript">
    <c:if test="${imageData eq ''}">
    ymPrompt.alert({message: '��Ftp�����������ļ����󣬻���ӵ���δ�ҵ���', width: 330, height: 220, title: '��ʾ��Ϣ'});
    </c:if>
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
        var id = $("#id").val();
        var codeid = $("#codeid").val();
        var scanner = document.getElementById("AAA");
        var base64file = scanner.ImageData;                                   //�������õ�����
        var baseSize = base64file.length;//����base64file��С
        var wdidbs = scanner.ImageRemarkID;
        if (baseSize <= 0) {
            ymPrompt.alert("����ɨ�赵����", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        if (!wdidbs || wdidbs == '' || /(^;.*|.*;;.*|.*;$)/.test(wdidbs.trim()) || wdidbs == '-1') {
            ymPrompt.alert("���������ĵ���ʶ���ٽ����ϴ���", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        var wdbss = wdidbs.split(";");
        <%--/* <c:choose>--%>
        <%--<c:when test="${task.type eq '0'}">--%>

        <%--</c:when>--%>
        <%--<c:when test="${task.type eq '4'}">--%>

        <%--</c:when>--%>
        <%--<c:when test="${task.type eq '0'}">--%>

        <%--</c:when>--%>
        <%--</c:choose>*/--%>
        for (var i = 0; i < wdbss.length - 1; i++) {
            if (wdbss[i] != 5 && wdbss[i + 1] != 5 && wdbss[i] > wdbss[i + 1]) {
                ymPrompt.alert("������ĵ�ͼƬ˳�򣬰�����Ҫ����������ϴ��ĵ���", 330, 220, "��Ϣ��ʾ");
                return false;
            }
        }
        if (baseSize > 1024 * 1000 * 500) {
            ymPrompt.alert("�ļ�̫��������ɨ�裡", 330, 220, "��Ϣ��ʾ");
            return false;
        }
        document.getElementById("uploadb").disabled = "disabled";
        $.post(
                "/bsweb/scanTask_update",
                {   'task.id': id,
                    'task.createTime': $("#createTime").val(),
                    type: $("#type").val(),
                    wdidbs: wdidbs,
                    fileName: encodeURIComponent(codeid),
                    imageCount: scanner.ImageCount,
                    file: encodeURIComponent(base64file)

                },
                function (data, status) {
                    if (status == 'success') {
                        ymPrompt.close();
                        if (data.toString().indexOf('nok') > 0) {
                            ymPrompt.alert("�ϴ�ͼ�������쳣�������ԡ�", 330, 220, "��ʾ��Ϣ", function () {
                                document.getElementById("uploadb").disabled = false;
                            });
                        } else {
                            window.location.href = "/bsweb/scanTask_runTask?task.id=" + id + "&source=${source}&task.status=" + document.getElementById("status").value;
                        }
                    } else {
                        ymPrompt.close();
                        ymPrompt.alert("�ϴ�ͼ�������쳣�������ԡ�", 330, 220, "��ʾ��Ϣ");
                    }
                });
        ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
        return true;
    }
    function deleteFile() {
        var id = $("#id").val();
        alert(id);
        $.post(
                "/bsweb/scanTask_delete",
                {   'task.id': id },
                function (data, status) {
                    if (status == 'success') {
                        ymPrompt.alert("ͼ����Ϣɾ���ɹ�������������ϴ���", 330, 220, "��Ϣ��ʾ", function () {
                            window.location.href = '/bsweb/scanTask_edit?task.id=' + id + '&source=${source}';
                        });
                    } else {
                        ymPrompt.alert("ɾ��ͼ��ʧ�ܣ������ԡ�", 330, 220, "��Ϣ��ʾ", function () {
                            window.location.href = '/bsweb/scanTask_edit?task.id=' + id + '&source=${source}';
                        });
                    }
                });
        return true;
    }
    (function () {
        var scanner = document.getElementById("AAA");
        scanner.ImageMenuText = "{�����,1,1};{��ҵ��׼�ļ�,21,2};{��ҵ��λ��׼�ļ�,22,3};{���������׼�ļ�,23,4};{������׼�ļ�,24,5};{����������׼�ļ�,25,6};{�������������֤��,31,7};{���������֤��,32,8};{С΢��ҵ֤������,5,a};{�����ļ�,4,9}";
        scanner.DIP = 150;
        scanner.ColorModel = 1;
        scanner.Depth = 8;
        scanner.EditModel = 2;
        scanner.ImageHeight = 600;
        scanner.ImageFormat = 0;
        scanner.RemarkFlag = 1;
        scanner.ModifyFlag = 1;
        scanner.CheckImageSize = 0;
        <c:if test="${task.imagePath!=null and imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.Base64ImageStr = base64str;
        <c:if test="${wdidbs != null} ">
        scanner.ImageRemark = '${wdidbs}';
        scanner.ImageRemarkID='${hidValue}';
        </c:if>
        </c:if>


    })();

</script>

</HTML>
