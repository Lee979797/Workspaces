<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.Rightkey" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>栏目权限管理</title>
</head>
<%
clsRightKeyBus rightKeyBus = new clsRightKeyBus();
String rightKeyId = request.getParameter("rightKeyId");
Rightkey rightKeyTO = rightKeyBus.GetRightKey(rightKeyId);
List<Rightkey> childNodes = rightKeyBus.ListChildNode(rightKeyId);
String rightKeyName = rightKeyTO.getRightkeyName();
%>
<body>
管理权限[<%=rightKeyName%>] <a href="addRightKey.jsp?parentId=<%=rightKeyId%>&type=2" target="_self">添加</a>

<table width="329" border="0" align="center">

  <tr>
    <td width="40">编号</td>
    <td width="40">名称</td>
	<td width="40">等级</td>
	<td width="40">图片</td>
    <td width="147" align="center">操作</td>
    </tr>
	<%
	if(rightKeyBus.HasAddRight(rightKeyId)){
	if(childNodes!=null&& childNodes.size()>0){
	  
	  
	  for(int index=0;index<childNodes.size();index++){
	    
		Rightkey tmpRightKeyTO = (Rightkey)childNodes.get(index);
		String tmpRightKeyName = tmpRightKeyTO.getRightkeyName();
		String tmpRightKeyId = String.valueOf(tmpRightKeyTO.getRightkeyId());
		String tmpLevel = tmpRightKeyTO.getRightkeyDepth();
		String tmpPictrue = tmpRightKeyTO.getPictrue();
	
	
	%>
  <tr>
    <td><%=tmpRightKeyId%></td>
	<td><%=tmpRightKeyName%></td>
	<td><%=tmpLevel%></td>
	<td><img src="/manageweb/images/menu/<%=tmpPictrue%>"  height="20" width="20"/></td>
	<td align="center"><a href="viewRightKey.jsp?rightKeyId=<%=tmpRightKeyId%>" target="_self">修改</a> <a href="/servlet/RightKeyAction?actions=deleteRightKey&rightKeyId=<%=tmpRightKeyId%>&currentPage=/manageweb/rightkey/manageRight.jsp?rightKeyId=<%=rightKeyId%>" >删除</a> </td>
    </tr>
<%}}}%>
</table>

</body>
</html>
