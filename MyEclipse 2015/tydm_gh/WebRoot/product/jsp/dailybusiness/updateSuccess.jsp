<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }

    </script>
    <title>操作成功页面</title>
    <%--@elvariable id="source" type="java.lang.String"--%>
    <c:set var="url"
           value="${source eq 'update_no'?'/bsweb/business_list?source=update_no':source eq 'update'?'/bsweb/business_list?source=update':source eq 'uploadProblemData'?'/bsweb/qualityManager_uploadProblemData': source eq 'auditProblemData'?'/bsweb/qualityManager_auditProblemData':source eq 'problem_datas'?'/bsweb/qualityManager_problem_datas':source eq 'welcome_wtdj'?'/bsweb/scanTask_welcome_task':'/bsweb/qualityManager_nationProblemData'}"/>
</head>
<body>
<form method="POST" name='thisForm' action="">
    <div class="prompt">
        <div class="promptou">提示信息</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
     
    
            <c:if test="${jgdm.dybz eq '0'}">
                             <li><b>
                                统一代码（${jgdm.tyshxydm}）信息更新成功，证书项信息发生变更，需要打证！
                            </b></li>
                       
            		 </c:if>
            		 <c:if test="${jgdm.dybz eq '1'}">
                            <li><b>
                                统一代码（${jgdm.tyshxydm}）信息更新成功！
                            </b></li>
                            </c:if>
                            <li>
                                <input type="button" value="确 定"
                                      onClick="window.location.href='/bsweb/business_list?source=update_no&jglx=${jglx}'"
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
