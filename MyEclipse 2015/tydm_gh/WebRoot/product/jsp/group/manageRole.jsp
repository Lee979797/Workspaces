<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UGRoleBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.system.model.Role" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    UGRoleBo uGRoleBo = new UGRoleBo();
    RoleBo roleBo = new RoleBo();
    UserGroupBo userGroupBo = new UserGroupBo();
    String group_id = request.getParameter("group_id");
    String group_name = request.getParameter("group_name");
    UserGroup userGroup = userGroupBo.findById(Integer.valueOf(group_id));
    group_name = userGroup.getUsergroupName();
    //group_name = java.net.URLDecoder.decode(group_name,"gbk");

    String group_kind = request.getParameter("group_kind");

    //显示所有角色
    List<Role> roles = roleBo.findAll();
    ArrayList selectedRoles = uGRoleBo.getRoleIdsByGroupId(group_id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>分配角色</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/js/managerole.js"></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户组管理 &gt;&gt; 分配角色</div>

<form method="post" action="/action/userGroupAction" name="groupForm">
    <input type="hidden" name="method" value="manageRole"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="group_id" value="<%=group_id%>"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <span> <img src="../images/icon_addgxlm.gif" width="16"
                                    height="16"/>
                                    用户组：<%=group_name%>
                        </span>
                        <br/>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                            <tr class="tr_top">
                                <td width="42%" align="center" class="box1">所有角色</td>
                                <td width="16%" align="center" class="box1">&nbsp;</td>
                                <td width="42%" align="center" class="box1">已选角色</td>
                            </tr>

                            <tr align='center'>
                                <td class="box2"><select name="alllist" size="18" style="width:200px" multiple>
                                    <%
                                        if (roles != null && roles.size() > 0) {

                                            for (Role r : roles) {

                                                String role_id = String.valueOf(r.getRoleId());
                                                if (selectedRoles != null) {
                                                    if (!userGroupBo.constainsRole_id(role_id, selectedRoles)) {
                                    %>
                                    <option value="<%=role_id%>"><%=r.getRoleName()%>
                                    </option>
                                    <%
                                                    }
                                                }
                                            }
                                        }
                                    %>
                                </select></td>
                                <td class="table1_td1">&nbsp;
                                    <table width="100%" border="0" cellspacing="2" cellpadding="5">

                                        <tr>
                                            <td align="center"><input name="addbutton" type="button"
                                                                      value="&gt;&gt;"
                                                                      class="btn_more"
                                                                      onClick="addAll('alllist','selectedrole')"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="center">
                                                <input name="addbutton" type="button" value="&gt;"
                                                       class="btn_more"
                                                       onClick="add('alllist','selectedrole')"/></td>
                                        </tr>
                                        <tr>
                                            <td align="center">
                                                <input name="delbutton" type="button" value="&lt;"
                                                       class="btn_more"
                                                       onClick="del('alllist','selectedrole')"/></td>
                                        </tr>


                                        <tr>
                                            <td align="center">
                                                <input name="delbutton" type="button"
                                                       value="&lt;&lt;"
                                                       class="btn_more"
                                                       onClick="delAll('alllist','selectedrole')"/>
                                            </td>
                                        </tr>


                                    </table>
                                </td>
                                <td class="box2">
                                    <select name="selectedrole" size="18" style="width:200px" multiple>
                                        <%
                                            if (selectedRoles != null && selectedRoles.size() > 0) {

                                                for (int rolesIndex = 0; rolesIndex < selectedRoles.size(); rolesIndex++) {
                                                    Role roleTO = (Role) selectedRoles.get(rolesIndex);
                                                    //clsRoleTO roleTO = roleBus.FindRoleById(role_id);

                                        %>
                                        <option value="<%=roleTO.getRoleId()%>"><%=roleTO.getRoleName()%>
                                        </option>
                                        <%
                                                }
                                            }
                                        %>

                                    </select></td>
                            </tr>

                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="button" class="newBtn1" id="button" value="保 存"
                               onclick="CheckValid()"/>
                        <input name="button" type="button" class="newBtn1" id="back" value="返 回"
                               onclick="location.href='groupList.jsp'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){%>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "groupList.jsp";
    });
    <%}%>
</script>
</html>
