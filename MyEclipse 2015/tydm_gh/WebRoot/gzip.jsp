<%@ page language="java" pageEncoding="GBK" %>
<%
    System.out.println("-----"+request.getParameter("str"));
    out.println(com.ninemax.jpa.util.Gzip.gzip(request.getParameter("str")));
%>