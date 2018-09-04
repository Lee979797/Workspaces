<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
<%@ page import="com.ninemax.jpa.system.model.Role" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    RoleBo roleBo = new RoleBo();
    String role_id = request.getParameter("role_id");
    String paramString = request.getQueryString();
    int _role_id = 0;
    if (!clsStringTool.isEmpty(role_id)) {
        _role_id = Integer.parseInt(role_id);
    }
    Role role = roleBo.findById(_role_id);

%>
<c:set var="role" value="<%=role%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>修改角色</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/RoleBo.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/product/js/role.js'></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
	$(function(){   $("#roleName").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 角色管理 &gt;&gt; 修改角色</div>

<form name="roleForm" method="post" action="/action/RoleAction">
    <input type="hidden" name="method" value="modify"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="roleKind" value="${role.roleKind}"/>
    <input type="hidden" name="roleStatus" value="${role.roleStatus}"/>
    <input type="hidden" name="roleId" id="roleId" value="<%=role_id%>"/>
    <input type="hidden" id="oldroleName" value="${role.roleName}"/>


    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">

                        <table width="100%" border="0" cellpadding="0" cellspacing="1">
                            <tr class="table1_tr1">
                                <td class="table1_td1" width="18%" align="right">角色名称：</td>
                                <td><input type="text" name="roleName" id="roleName" maxlength="20" isnull="false"
                                           onBlur="checkRoleName()" size="20" class="page_input2"
                                           value="${fn:trim(role.roleName)}"><span id="roleDiv"></span>

                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">详细描述：</td>
                                <td><textarea name="roleMemo" cols="50" rows="8" id="roleMemo"
                                              class="page_input_txt">${fn:trim(role.roleMemo)}</textarea>
                                </td>
                            </tr>


                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="saveButton" type="button" class="newBtn1" id="saveButton" value="保 存"
                               onClick="checkForm()"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="重 填"
                               onclick="roleForm.reset()"/>

                        <input name="button" type="button" class="newBtn1" id="button" value="返 回"
                               onclick="javascript:document.location.href='roleList.jsp?<%=paramString %>'"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){
         if("ModRoleSuc".equals(request.getParameter("msg").trim())){
    %>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "roleList.jsp";
    });
    <%}else{%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "roleList.jsp";
    });
    <%
         }
    }
    %>
</script>
</html>
