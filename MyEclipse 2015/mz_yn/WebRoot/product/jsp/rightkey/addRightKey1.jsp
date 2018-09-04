<%@ page autoFlush="true" session="true" contentType="text/html; charset=gbk" %>
<form method="post" action="/servlet/RightKeyAction" name="keyForm">
<input type="hidden" name="actions" value="addRightKey" />
   <input type="hidden" name="pageURL" value="/sysmanage.jsp" />
<table width="60%" border="0" align="center" cellpadding="3" cellspacing="0">
  <tr align="left">
    <td width="115" class="box1">权限ID： </td>
    <td width="246" ><input type="text" name="rightkey_id" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">权限名称： </td>
    <td width="246"><input type="text" name="rightkey_name" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
   <tr align="left">
    <td width="115" class="box1">级别： </td>
    <td width="246" ><input type="text" name="rightkey_depth" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td height="24" class="box1">功能：</td>
    <td><input type="text" name="rightkey_func" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
 
    <tr align="left">
    <td width="115" class="box1">类型： </td>
    <td width="246" ><input type="text" name="rightkey_kind" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
    <tr align="left">
    <td width="115" class="box1">全名： </td>
    <td width="246" ><input type="text" name="rightkey_fullname" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">图片： </td>
    <td width="246" ><input type="text" name="pictrue" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">父类编号： </td>
    <td width="246" ><input type="text" name="parentId" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">页面： </td>
    <td width="246" ><input type="text" name="linkPage" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">排序： </td>
    <td width="246" ><input type="text" name="orderBy" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
  <tr align="left">
    <td width="115" class="box1">类型： </td>
    <td width="246" ><input type="text" name="type" maxlength="20"  isnull="false" kind="string" /></td>
  </tr>
   
   <tr align="center">
    <td colspan="2" class="box1"><input name="submit32" type="submit" value=" 保 存 ">&nbsp;<input name="submit32" type="reset" value=" 重 置 " />&nbsp;<input name="Submit222" type="button" onclick="window.close();" value=" 关 闭 " /></td>
  </tr>
</table></form>
