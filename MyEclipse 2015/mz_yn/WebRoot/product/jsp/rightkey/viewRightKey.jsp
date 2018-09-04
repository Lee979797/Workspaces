<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.Rightkey" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>编辑栏目、权限</title>
<script language="javascript">
function checkForm(){

    keyForm.submit();
}
</script>

</head>
<%
clsRightKeyBus rightKeyBus = new clsRightKeyBus();
String rightKeyId = request.getParameter("rightKeyId");
Rightkey rightKeyTO = rightKeyBus.GetRightKey(rightKeyId);
String rightKeyName = rightKeyTO.getRightkeyName();
String level = rightKeyTO.getRightkeyDepth();
String parentRightKey = rightKeyTO.getParentid();
String type = rightKeyTO.getType();
if("1".equals(type)){
    type = "栏目";
}
if("2".equals(type)){
    type = "权限";
}
%>
<body>
编辑栏目[<%=rightKeyName%>] 
<table width="330" border="0" align="center">
<form method="post" action="/action/RightKeyAction" enctype="multipart/form-data" name="keyForm" target="_parent">
<input type="hidden" name="method" value="modify" />
   <input type="hidden" name="currentPage" value="/product/jsp/rightkey/index.jsp" />
   <input type="hidden" name="id" value="<%=String.valueOf(rightKeyTO.getId()) %>" />
<input type="hidden" name="rightKey_id" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyId%>"/>
  <tr align="left">
    <td width="72" class="box1">权限ID： </td>
    <td width="248" ><input type="text" name="rightkeyId" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyId%>"/></td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">权限名称： </td>
    <td width="248"><input type="text" name="rightkeyName" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyName%>"/></td>
  </tr>
   <tr align="left">
    <td width="72" class="box1">级别： </td>
    <td width="248" ><%=level%><input type="hidden" name="rightkeyDepth" maxlength="20"  isnull="false" kind="string" value="<%=level%>"/></td>
  </tr>
  <tr align="left">
    <td height="24" class="box1">功能：</td>
    <td><input type="text" name="rightkeyFunc" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyTO.getRightkeyFunc()%>"/></td>
  </tr>
 
    <tr align="left">
    <td width="72" class="box1">类型： </td>
    <td width="248" ><input type="text" name="rightkeyKind" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyTO.getRightkeyKind()%>"/></td>
  </tr>
    <tr align="left">
    <td width="72" class="box1">全名： </td>
    <td width="248" ><input type="text" name="rightkeyFullname" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyTO.getRightkeyFullname()%>"/></td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">图片： </td>
    <td width="248" ><input type="hidden" name="pictrue" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyTO.getPictrue()%>"/>
	<input type="file" name="pictrue" /><img src="/product/jsp/images/menu/<%=rightKeyTO.getPictrue()%>"  height="20" width="20"/>
	</td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">父类编号： </td>
    <td width="248" ><%=parentRightKey%><input type="hidden" name="parentid" maxlength="20"  isnull="false" kind="string" value="<%=parentRightKey%>"/></td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">页面： </td>
    <td width="248" ><input type="text" name="linkpage" maxlength="150"  size="30" isnull="false" kind="string" value="<%=rightKeyTO.getLinkpage()%>"/></td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">排序： </td>
    <td width="248" ><input name="orderby" type="text" value="<%=rightKeyTO.getOrderby()%>" size="4" maxlength="4"  isnull="false" kind="string"/></td>
  </tr>
  <tr align="left">
    <td width="72" class="box1">类型： </td>
    <td width="248" ><input type="hidden" name="type" maxlength="20"  isnull="false" kind="string" value="<%=rightKeyTO.getType()%>" /><%=type%></td>
  </tr>
   
   <tr align="center">
    <td colspan="2" class="box1"><input name="submit32" type="button" value=" 保 存 " onclick="checkForm()"/>&nbsp;<input name="submit32" type="reset" value=" 重 置 " />&nbsp;<input name="Submit222" type="button" onclick="window.close();" value=" 关 闭 " /></td>
  </tr>
</form>
</table>

<br>
<table width="282" border="0" align="center">

  <tr>
    <td>当前部门相关操作 
      <label></label></td>
  </tr>
  <tr>
    <td align="center"><a href="addRightKey.jsp?parentId=<%=rightKeyId%>&type=1">新建下属栏目</a></td>
  </tr>
    <tr>
    <td align="center">
      <a href="/action/RightKeyAction?method=delete&rightkeyId=<%=rightKeyId%>&currentPage=/product/jsp/rightkey/index.jsp" target="_parent">删除当前栏目</a>    </td>
  </tr>
  <%
//  if(rightKeyBus.HasAddRight(rightKeyId)){
  %>
    <tr>
    <td align="center">
      <a href="manageRight.jsp?rightKeyId=<%=rightKeyId%>" >权限管理</a>    </td>
  </tr>
  <%//}%>
</table>

</body>
</html>
