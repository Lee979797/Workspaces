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
    <title>无标题文档</title>
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
    <div align="right" style=" float: right;margin-top: 3px">
        <input class="newBtn1" type="button" value="上 传" id="uploadb" onclick=" uploadFile()">
        &nbsp;
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/>
        &nbsp;
    </div>
    档案&gt;&gt; 扫描任务管理 &gt;&gt; 机构代码档案扫描
</div>
<div align="left" style="margin-top: 10px;margin-left: 30px;margin-bottom: 10px">
    <form name="form1" action="/bsweb/scanTask_upload" id="form1">
        <input name="id" type="hidden" id="id" value="${task.id}"/>
        <input name="id" type="hidden" id="status" value="${task.status}"/>
        <input name="source" type="hidden" id="source" value="${source}"/>
        <input name="codeid" type="hidden" id="codeid" value="<%=UUID.randomUUID().toString()%>"/>
        <input name="base64" type="hidden" id="base64" value="${imageData}"/>
        建档时间 <INPUT name="task.createTime" id="createTime" onclick="WdatePicker({el:$dp.$('createTime')});"
                    value="<fmt:formatDate value='${task.createTime}' pattern='yyyy-MM-dd'/>"
                    class="input_120"/>
        <IMG src="/images/icon_rili.gif" align="middle" onclick="WdatePicker({el:$dp.$('createTime')});"/>
        <c:if test="${task.type eq null or task.type eq ''}">
            任务类型：<select name="type" id="type">
            <c:forEach var="type" items="${types}">
                <option value="${type.value}">${type.name}</option>
            </c:forEach>
            </select>
        </c:if>
    </form>
</div>
<div align="center">
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
    ymPrompt.alert({message: '从Ftp服务器下载文件错误，或电子档案未找到！', width: 330, height: 220, title: '提示信息'});
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
        var base64file = scanner.ImageData;                                   //秦立：得到数据
        var baseSize = base64file.length;//放送base64file大小
        var wdidbs = scanner.ImageRemarkID;
        if (baseSize <= 0) {
            ymPrompt.alert("请先扫描档案！", 330, 220, "信息提示");
            return false;
        }
        if (!wdidbs || wdidbs == '' || /(^;.*|.*;;.*|.*;$)/.test(wdidbs.trim()) || wdidbs == '-1') {
            ymPrompt.alert("请先设置文档标识，再进行上传！", 330, 220, "信息提示");
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
                ymPrompt.alert("请调整文档图片顺序，按中心要求排序后再上传文档！", 330, 220, "信息提示");
                return false;
            }
        }
        if (baseSize > 1024 * 1000 * 500) {
            ymPrompt.alert("文件太大请重新扫描！", 330, 220, "信息提示");
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
                            ymPrompt.alert("上传图像数据异常，请重试。", 330, 220, "提示信息");
                        } else {
                            window.location.href = "/bsweb/scanTask_runTask?task.id=" + id + "&source=${source}&task.status=" + document.getElementById("status").value;
                        }
                    } else {
                        ymPrompt.close();
                        ymPrompt.alert("上传图像数据异常，请重试。", 330, 220, "提示信息");
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
                        ymPrompt.alert("图像信息删除成功，添加请重新上传！", 330, 220, "信息提示", function () {
                            window.location.href = '/bsweb/scanTask_edit?task.id=' + id + '&source=${source}';
                        });
                    } else {
                        ymPrompt.alert("删除图像失败，请重试。", 330, 220, "信息提示", function () {
                            window.location.href = '/bsweb/scanTask_edit?task.id=' + id + '&source=${source}';
                        });
                    }
                });
        return true;
    }
    (function () {
        var scanner = document.getElementById("AAA");
        scanner.ImageMenuText = "{未标识,-1,A};{申请表,1,B};{批准文件,2,C};{企业营业执照,21,D};{事业单位法人登记证,22,E};{社会团体法人登记证,23,F};{机关批准成立文件,24,G};{其他机构批准文件,25,H};{身份证明文件,3,I};{法人身份证明文件,31,J};{经办人身份证明文件,32,K};{微小企业,5,M};{其他,4,L}";
        <c:if test="${task.imagePath!=null and imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.Base64ImageStr = base64str;
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        <c:if test="${task.imagePath==null or imageData eq ''}">
        <c:forEach var="pic" items="${fn:split(pics,'$' )}">
        <c:if test="${pic!=null and 'null' ne pic and fn:startsWith(pic,'http')}">
        scanner.DownLoadImage('${pic}');
        </c:if>
        <c:if test="${pic!=null and 'null' ne pic and !fn:startsWith(pic,'http')}">
        scanner.DownLoadImage('http://${pic}');
        </c:if>
        </c:forEach>

        </c:if>
        <c:if test="${wdidbs != null} ">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        scanner.DIP = 200;
        scanner.ColorModel = 1;
        scanner.Depth = 8;
        scanner.EditModel = 2;
        scanner.ImageHeight = 600;
        scanner.ImageFormat = 0;
        scanner.RemarkFlag = 1;
        scanner.ModifyFlag = 1;
        scanner.CheckImageSize = 0;
    })();

</script>

</HTML>
