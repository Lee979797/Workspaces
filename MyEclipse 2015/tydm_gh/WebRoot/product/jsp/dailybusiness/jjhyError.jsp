<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }

    </script>
    <title>错误页面</title>
    <c:set var="url"
           value="${source eq 'pendApproval'?'/bsweb/pendApproval_list':source eq 'uploadProblemData'?'/bsweb/qualityManager_uploadProblemData':source eq 'nationProblemData'?'/bsweb/qualityManager_nationProblemData':source eq 'auditProblemData'?'/bsweb/qualityManager_auditProblemData':source eq 'problem_datas'?'/bsweb/qualityManager_problem_datas':'/bsweb/business_list'}"/>
</head>
<body>
<form method="post" name='thisForm' action="${url}?source=${source}">
    <div class="prompt">
        <div class="promptou">提示信息</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <li><b>${message}</b></li>
                    
                    <li>
                        <input type="submit" name="modify" value="确 定"
                               class="newBtn1">
                    </li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="promptdi"></div>
    </div>
</form>
</body>
</html>
