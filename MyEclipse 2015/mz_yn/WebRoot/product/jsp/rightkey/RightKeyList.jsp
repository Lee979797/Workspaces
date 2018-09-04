<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.sql.*" %>
<%@ page import="sun.jdbc.rowset.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<script language="JavaScript" type="text/JavaScript">
<!--
function selectAll(all) {
    var input_value = all.checked;

    var boxes = document.getElementsByName("event_id");

    for (var i = 0; i < boxes.length; i ++) {
         boxes.item(i).checked = input_value;
    }
}
function remove_event() {
    var event_ids = join_ids();
    location.href = "remove_calendar.asp?event_ids=" + event_ids;
}
function join_ids() {
    var event_ids = "";
    var boxes = document.getElementsByName("event_id");
    for (var i = 0; i < boxes.length; i ++) {
        if (boxes.item(i).checked) {
            if (event_ids != "") {
                event_ids = event_ids + "," + boxes.item(i).value
            }
            else {
                event_ids = boxes.item(i).value
            }
        }
    }
    return event_ids;
}
function delRecord() {
  var l=window.confirm("是否要删除吗?");
  if(l==true) {
    return true;
  } else {
    return false;
  }
}

function skipmain() {
  RoleList.action="../SysManage.jsp";
  RoleList.submit();
}
function down() {
  RoleList.page_no.value=parseInt(RoleList.page_no.value)+1;
  RoleList.submit();
}
function up() {
  RoleList.page_no.value=parseInt(RoleList.page_no.value)-1;
  RoleList.submit();
}
function firstpage(){
  RoleList.page_no.value=1;
  RoleList.submit();
}
function lastpage() {
  RoleList.page_no.value=parseInt(RoleList.pages.value);
  RoleList.submit();
}//-->
</script>
<%
    
%>
<link href="/images/style.css" rel="stylesheet" type="text/css">

<form  method="get" action="RoleList.jsp" name="RoleList">
<table width="778" height="535" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td height="520" align="center" valign="top" >
<table width="90%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="26" align="left" valign="top">&nbsp;</td>
                     <td height="26" align="right" class="big"><input name="Submit2" type="submit" value=" 新 增 " onClick="window.open('../Role/AddRole.jsp','','width=500,height=400,top=251,left=300')"></td>
                      </tr>
        </table>
             <table  border="0" width="90%" cellspacing="0" cellpadding="3" align="center"  >
                      <center>
                        <tr align="center" class="box1">
                          <td width="6%" align="center" class="box1">序号</td>
                          <td width="14%" align="center" class="box1">权限名称</td>
                          <td width="23%" class="box1">权限类型</td>
                          <td width="26%" class="box1">全名</td>
                          <td width="14%" class="box1">功能</td>
                          <td width="17%" class="box1">级别</td>
                        </tr>
                 
                            <tr align='center'>
                            <td class="box2">
                            
                            <td class="box2">&nbsp;</td>
                            <td class="box2">&nbsp;</td>
                            <td class="box2">&nbsp;</td>
                            <td class="box2">&nbsp;</td>
                            <td class="box2">&nbsp;</td>
                            </tr>
                       
                 
                    </table></td>
                      </tr>
        </table>
</form>

