<%@ page autoFlush="true" session="true" contentType="text/html; charset=gbk" %>
<form method="post" action="/servlet/RightKeyAction" name="keyForm">
<input type="hidden" name="actions" value="addRightKey" />
   <input type="hidden" name="pageURL" value="/sysmanage.jsp" />
<table width="60%" border="0" align="center" cellpadding="3" cellspacing="0">
  <tr align="left">
    <td width="115" class="box1">Ȩ��ID�� </td>
    <td width="246" ><input type="text" name="rightkey_id" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">Ȩ�����ƣ� </td>
    <td width="246"><input type="text" name="rightkey_name" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
   <tr align="left">
    <td width="115" class="box1">���� </td>
    <td width="246" ><input type="text" name="rightkey_depth" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td height="24" class="box1">���ܣ�</td>
    <td><input type="text" name="rightkey_func" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
 
    <tr align="left">
    <td width="115" class="box1">���ͣ� </td>
    <td width="246" ><input type="text" name="rightkey_kind" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
    <tr align="left">
    <td width="115" class="box1">ȫ���� </td>
    <td width="246" ><input type="text" name="rightkey_fullname" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">ͼƬ�� </td>
    <td width="246" ><input type="text" name="pictrue" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">�����ţ� </td>
    <td width="246" ><input type="text" name="parentId" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">ҳ�棺 </td>
    <td width="246" ><input type="text" name="linkPage" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">���� </td>
    <td width="246" ><input type="text" name="orderBy" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">���ͣ� </td>
    <td width="246" ><input type="text" name="type" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
   
   <tr align="center">
    <td colspan="2" class="box1"><input name="submit32" type="submit" value=" �� �� ">&nbsp;<input name="submit32" type="reset" value=" �� �� " />&nbsp;<input name="Submit222" type="button" onclick="window.close();" value=" �� �� " /></td>
  </tr>
</table></form>
