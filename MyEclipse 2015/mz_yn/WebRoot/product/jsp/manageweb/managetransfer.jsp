<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.nacao.to.system.clsSysUserTO" %>
<%@ page import="com.ninemax.nacao.util.clsThreeDes" %>
<%@ page import="com.ninemax.nacao.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.nacao.util.clsStringTool" %>
<%@ page import="com.ninemax.nacao.to.system.clsSystemConfig" %>

<%
String egovDomain=clsSystemConfig.getEgovDomain();
		if(clsStringTool.isEmpty(egovDomain)){
			egovDomain="china.dongman.gov.cn";
}
if(session.getAttribute("sysUser")!=null){
clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");
clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
String userid=clsThreeDes.encryptMode3DES(sysuser.getUser_id());

boolean canLogin = false;//是否允许登录
if(sysuser.getItem2()!= null&&sysuser.getItem2().equals("1")){
	canLogin = true;
}
boolean canPublish = userRightKeyBus.HasRight(sysuser.getUser_id(),"300102");
 if(canLogin){
 String refererUrl=request.getHeader("referer");
 if(refererUrl==null||"null".equals(refererUrl)||"".equals(refererUrl)){
 refererUrl="http";
 }
 if(refererUrl.indexOf("https")>-1){
 response.sendRedirect("https://"+egovDomain+"/action/LoginAction?userId="+userid);
 }else{
  response.sendRedirect("http://"+egovDomain+"/action/LoginAction?userId="+userid);
  return ;
 }
 }else{
 response.getWriter().write("<script>alert('您没有此权限');window.open('','_self');window.close();</script>");

 }
 
}else{
response.getWriter().write("<script>alert('您没有此权限');window.open('','_self');window.close();</script>");
}
%>