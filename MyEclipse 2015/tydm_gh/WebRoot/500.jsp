<%@ page language="java" import="org.apache.log4j.Logger" pageEncoding="GBK" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>出错了</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style type="text/css">
        .error {
            width: 60%;
            background: #fff;
            border: #ddd solid 2px;
            padding: 20px 40px 60px 40px;
            margin: 50px auto 0px;
        }

        .error h3 {
            height: 48px;
            line-height: 48px;
            border-bottom: #ccc solid 1px;
            font-size: 14px;
            font-weight: normal;
            margin: 0px 0px 20px 0px;
            padding: 0px 0px 10px 60px;
            background: url(/images/html_page_warning.png) no-repeat;
        }

        .error p {
            line-height: 25px;
            font-size: 14px;
            font-weight: normal;
            padding: 0px 0px 0px 60px;
            margin: 0px;
        }
    </style>
</head>

<%
    Logger logger = Logger.getLogger(getClass());
    logger.error("系统异常>>>" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) + ">>>" +
            request.getAttribute("javax.servlet.error.message"));
    String excDesc = pageContext.getException().toString();
    String errorDesc = "";
    if (excDesc.contains("NullPointerException")) {
        errorDesc = "存在为空的数据,请联系管理员!";
    }
    if (excDesc.contains("Cannot open connection")) {
        errorDesc = "jpa不能连接数据库,请联系管理员!";
    }
    if (excDesc.contains("IOException")) {
        errorDesc = "发生IO异常,请联系管理员!";
    } else {
        //  errorDesc = "数据库错误或其他错误,请联系管理员!";
    }
%>
<body>
<div class="error">
    <h3>系统执行发生错误，信息描述如下：</h3>

    <p>错误状态代码是：${pageContext.errorData.statusCode}</p>

    <p>错误发生页面是：${pageContext.errorData.requestURI}</p>

    <p>错误信息：${pageContext.exception}</p>

    <p>错误描述：<%=errorDesc%>
    </p>
</div>
</body>
</html>
