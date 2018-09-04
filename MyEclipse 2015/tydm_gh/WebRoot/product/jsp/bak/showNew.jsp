<%@ page contentType="text/html; charset=gbk" language="java" isELIgnored="false" %>
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
<script type="text/javascript">
    function down(){
        window.location.href="/servlet/DownLoadAction?id="+'${task.id}';
    }
</script>
<c:set var="linux" value="<%=linux%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body onload="LoadCtrl();">
<input name="base64" type="hidden" id="base64" value="${imageData}" />
<div class="page_top">
    <div align="right" style=" float: right;margin-top: 3px;">
        <c:if test="${!(task.imagePath eq null) and imageData ne ''}">
            <%--<a target="_blank"
               href="">
                下载档案
            </a>--%>
            <%--<input name="button" type="reset" class="btn2" id="button3" value="下载档案" onclick="window.open('http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }');"/>--%>
            <input name="button" type="reset" class="btn2" id="button3" value="下载档案" onclick="down();return false;" />
        </c:if>
        &nbsp;
        <input name="button3" type="reset" class="newBtn1" id="button31" value="返 回" onclick="history.go(-1);"/>
        &nbsp;
    </div>
    档案 &gt;&gt; 扫描任务管理 &gt;&gt; 机构代码档案
</div>
<div align="left" style="margin-left: 20px;">
    建档日期：<fmt:formatDate value='${task.compleTime}'/>
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
	function LoadCtrl() {
        var scanner = document.getElementById("scanner");
       /* <c:if test="${task.imagePath!=null}">
        scanner.SetImage("http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${task.imagePath eq null?'':fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }");
        </c:if>*/
        <c:if test="${task.imagePath!=null}">
            var base64str = document.getElementById("base64").value;
            scanner.SetBase64Image(base64str);
        </c:if>
        <c:if test="${wdidbs !=null}">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        scanner.DPI = 200;
        scanner.PixelType = 2;
        scanner.EditModel = 0;
    }
</script>
<script type='text/javascript'>
    <c:if test="${imageData eq ''}">
        ymPrompt.alert({message:'从Ftp服务器下载文件错误，或电子档案未找到！', width:330, height:220, title:'提示信息'});
    </c:if>
</script>
</HTML>
