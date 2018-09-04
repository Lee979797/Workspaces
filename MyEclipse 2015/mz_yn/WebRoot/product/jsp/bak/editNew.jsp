<%--@elvariable id="task" type="com.ninemax.jpa.code.model.TSmtask"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" language="java" isELIgnored="false" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src='/dwr/engine.js'></script>
    <script type="text/javascript" src='/dwr/util.js'></script>
    <script type="text/javascript" src='/dwr/interface/monitor.js'></script>
</head>
<body onload="LoadCtrl();">
<div class="page_top">
    <div align="right" style=" float: right;margin-top: 3px">
        <%--<c:if test="${!(task.imagePath eq null)}">
            <input class="btn2" type="button" value="全部删除"   onclick="ymPrompt.confirmInfo('确认是否全部删除图像?',330,220,'提示信息',function (data){if(data == 'ok'){deleteFile();}else{return false;}})">
            &nbsp;
        </c:if>--%>
        <input class="newBtn1" type="button" value="上 传" onclick=" uploadFile()">
        &nbsp;
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/>
        &nbsp;
    </div>
    档案&gt;&gt; 扫描任务管理 &gt;&gt; 机构代码档案扫描
</div>
<div align="center" style="margin-top: 10px;">
    <form name="form1" action="/bsweb/scanTask_upload" id="form1">
        <input name="id" type="hidden" id="id" value="${task.id}">
        <input name="source" type="hidden" id="source" value="${source}">
        <input name="codeid" type="hidden" id="codeid" value="<%=UUID.randomUUID().toString()%>">
        <input name="base64" type="hidden" id="base64" value="${imageData}"/>
    </form>
</div>
<div align="center">
    <OBJECT
            classid="clsid:640D2EE0-67E6-44E0-A4E8-BA9D5A8F1F5B" ID="scanner"
            width=100%
            height=600
            align=center
            hspace=0
            vspace=0
            ></OBJECT>
</div>
</body>
<script type='text/javascript'>
    function uploadFile() {

        var id = $("#id").val();
        var codeid = $("#codeid").val();
        var scanner = document.getElementById("scanner");
        var base64file = scanner.ImageData;                                   //秦立：得到数据
        var baseSize = base64file.length;//放送base64file大小
        var wdidbs = scanner.ImageIDRemark;

        if (baseSize <= 0) {
            ymPrompt.alert("请先扫描档案！", 330, 220, "信息提示");
            return false;
        }
        if (wdidbs == undefined || wdidbs == null || wdidbs == "") {
            ymPrompt.alert("请先设置文档标识，再进行上传！", 330, 220, "信息提示");
            return false;
        }
        if (Number(wdidbs.split(';').length) != Number(scanner.ImageCount)) {
            ymPrompt.alert("请先设置文档标识，再进行上传！", 330, 220, "信息提示");
            return false;
        }
        if (scanner.CheckIsRemark() == 0) {
            if (!confirm("有未标识的图片文件，确认是否上传图像")) {
                return false;
            }
        }
        if (baseSize > 1024 * 1000 * 500) {
            ymPrompt.alert("文件太大请重新扫描！", 330, 220, "信息提示");
            return false;
        }
        $.post(
                "/bsweb/scanTask_update",
                {   'task.id': id,
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
                            window.location.href = "/bsweb/scanTask_runTask?task.id=" + id + "&source=${source}&task.status=${task.status}";
                        }

                    } else {
                        ymPrompt.close();
                        ymPrompt.alert("上传图像数据异常，请重试。", 330, 220, "提示信息");
                    }
                }
        );
        ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
        return true;
    }
    function deleteFile() {
        var id = $("#id").val();
        var scanner = document.getElementById("scanner");
        $.post(
                "/bsweb/scanTask_delete",
                {   'task.id': id },
                function (data, status) {
                    if (status == 'success') {
                        ymPrompt.alert("图像信息删除成功，添加请重新上传！", 330, 220, "信息提示", function () {
                            window.location.href = '/bsweb/scanTask_edit?task.id=' + id + '&source=${source}';
                        });

                    } else {
                        setImageRemark();
                        alert("删除图像失败，请重试。");
                    }
                });
        return true;
    }

    function AddMark() {
        var scanner = document.getElementById("scanner");
        scanner.AddMark('未标识', '-1', 'A');
        scanner.AddMark('申请表', '1', 'B');
        scanner.AddMark('批准文件', '2', 'C');
        scanner.AddMark('企业营业执照', '21', 'D');
        scanner.AddMark('事业单位法人登记证', '22', 'E');
        scanner.AddMark('社会团体法人登记证', '23', 'F');
        scanner.AddMark('机关批准成立文件', '24', 'G');
        scanner.AddMark('其他机构批准文件', '25', 'H');
        scanner.AddMark('身份证明文件', '3', 'I');
        scanner.AddMark('法人身份证明文件', '31', 'J');
        scanner.AddMark('经办人身份证明文件', '32', 'K');
        scanner.AddMark('其他', '4', 'L');

        /*scanner.AddMark('未标识','-1','0');
        scanner.AddMark('申请表','1','A');
        scanner.AddMark('企业营业执照','21','B');
        scanner.AddMark('事业单位法人登记证','22','C');
        scanner.AddMark('社会团体法人登记证','23','D');
        scanner.AddMark('机关批准成立文件','24','E');
        scanner.AddMark('其他机构批准文件','25','F');
        scanner.AddMark('法人身份证明文件','31','G');
        scanner.AddMark('经办人身份证明文件','32','H');
        scanner.AddMark('小微企业证明材料','41','J');
        scanner.AddMark('其他文件','42','I');
        */
    }

    function LoadCtrl() {
        var scanner = document.getElementById("scanner");

        scanner.DPI = 200;
        scanner.PixelType = 2;
        scanner.EditModel = 1;
        AddMark();
        <%--<c:if test="${task.imagePath!=null}">
        scanner.SetImage("http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${task.imagePath eq null?'':fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }");
        </c:if>--%>
        <c:if test="${task.imagePath!=null and imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.SetBase64Image(base64str);
        <c:if test="${wdidbs !=null} ">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        </c:if>

    }

</script>
<script type="text/javascript">
    <c:if test="${imageData eq ''}">
    ymPrompt.alert({message: '从Ftp服务器下载文件错误，或电子档案未找到！', width: 330, height: 220, title: '提示信息'});
    </c:if>
</script>
</HTML>
