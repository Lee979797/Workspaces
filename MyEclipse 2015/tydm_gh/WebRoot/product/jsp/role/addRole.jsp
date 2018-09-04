<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/RoleBo.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/product/js/role.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 角色管理 &gt;&gt; 新增角色</div>
<form name="roleForm" method="post" action="/action/RoleAction">
    <input type="hidden" name="method" value="add"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="roleKind" value="1"/>
    <input type="hidden" name="roleStatus" value="0"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1">
                            <tr class="table1_tr1">
                                <td class="table1_td1" width="18%" align="right">角色名称：</td>
                                <td><input type="text" name="roleName" id="roleName" maxlength="20" isnull="false"
                                           onBlur="checkRoleName(this.value)" size="20" class="page_input2">
                                    <span id="roleDiv"></span>

                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">详细描述：</td>
                                <td><textarea name="roleMemo" id="roleMemo" cols="50" rows="8"
                                              class="page_input_txt"></textarea>
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
                               onclick="location.href='roleList.jsp'"/>

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
         if("AddRoleSuc".equals(request.getParameter("msg").trim())){
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
