<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>�½���Ŀ��Ȩ��</title>
<script language="javascript">
function checkForm(){

    keyForm.submit();
}
</script>
</head>
<%
String parentId = request.getParameter("parentId");
String type = request.getParameter("type");
String currentPage = "/manageweb/rightkey/index.jsp";
String target = "_parent";

if(clsStringTool.isEmpty(parentId)){
    parentId="";
	currentPage = "/product/jsp/rightkey/index.jsp";
}else{
    currentPage = "/product/jsp/rightkey/viewRightKey.jsp?rightKeyId="+parentId;
}


if("2".equals(type)){
	currentPage = "/product/jsp/rightkey/manageRight.jsp?rightKeyId="+parentId;
	target = "_self";
}else{
    currentPage = "/product/jsp/rightkey/index.jsp";
	//target = "_parent";
}

%>
<body>
�½���Ŀ��Ȩ��
<table width="307" border="0" align="center">
<form action="/action/RightKeyAction" method="post" enctype="multipart/form-data" name="keyForm"  target="<%=target%>">
<input type="hidden" name="method" value="add" />
   <input type="hidden" name="currentPage" value="<%=currentPage%>" />

  <tr align="left">
    <td width="67" class="box1">Ȩ��ID�� </td>
    <td width="230" ><input type="text" name="rightkeyId" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">Ȩ�����ƣ� </td>
    <td width="230"><input type="text" name="rightkeyName" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
   <tr align="left">
    <td width="67" class="box1">���� </td>
    <td width="230" ><input name="rightkeyDepth" type="text" size="2" maxlength="1"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td height="24" class="box1">���ܣ�</td>
    <td><input type="text" name="rightkeyFunc" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
 
    <tr align="left">
    <td width="67" class="box1">���ͣ� </td>
    <td width="230" ><input type="text" name="rightkeyKind" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
    <tr align="left">
    <td width="67" class="box1">ȫ���� </td>
    <td width="230" ><input type="text" name="rightkeyFullname" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">ͼƬ�� </td>
    <td width="230" >
     
      <input type="file" name="pictrue" />
      </td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">�����ţ� </td>
    <td width="230" ><input type="text" name="parentid" maxlength="20"  isnull="false" kind="string" value="<%=parentId%>"/></td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">ҳ�棺 </td>
    <td width="230" ><input type="text" name="linkpage" maxlength="150" size="30"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">���� </td>
    <td width="230" ><input name="orderby" type="text" size="4" maxlength="4"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="67" class="box1">���ͣ� </td>
    <td width="230" ><select name="type" >
	 <option value="1" <%if("1".equals(type))out.print("selected");%>>��Ŀ</option>
	 <option value="2" <%if("2".equals(type))out.print("selected");%>>Ȩ��</option></select></td>
  </tr>
   
   <tr align="center">
    <td colspan="2" class="box1"><input name="submit32" type="button" value=" �� �� " onclick="checkForm()">&nbsp;<input name="submit32" type="reset" value=" �� �� " />&nbsp;<input name="Submit222" type="button" onclick="window.close();" value=" �� �� " /></td>
  </tr>
</form>
</table>
</body>
</html>
