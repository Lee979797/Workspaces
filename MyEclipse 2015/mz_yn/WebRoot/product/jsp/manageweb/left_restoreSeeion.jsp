<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.nacao.to.system.clsSysUserTO" %>
<%@ page import="com.ninemax.nacao.util.clsStringTool" %>


<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
String realSession = request.getParameter("realSession");
clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");
if(!clsStringTool.isEmpty(realSession)){
	sysuser.setItem1(realSession);
	session.setAttribute("sysUser",sysuser);
}
%>	
  