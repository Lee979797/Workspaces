<%@ page import="com.ninemax.jpa.util.TomcatUtils" %>
<%@ page language="java" pageEncoding="GBK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
<%
    Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
    cookie.setPath(request.getContextPath());
    response.addCookie(cookie);
    response.addHeader("P3P", "CP=CAO PSA OUR");
    if (request.getRequestURL().toString().contains("https")) {
        response.sendRedirect("http://" + request.getServerName() + ":" + TomcatUtils.port() + "/product/login.jsp");
    } else {
        response.sendRedirect("/product/real.jsp");
//         request.getRequestDispatcher().forward(request, response);
    }
%>
</body>
</html>
