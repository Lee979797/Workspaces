<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    UserGroupBo userGroupBo = new UserGroupBo();
    String userGroup_id = request.getParameter("userGroup_id");
    String paramString = request.getQueryString();
    int _userGroup_id = 0;
    if (!clsStringTool.isEmpty(userGroup_id)) {
        _userGroup_id = Integer.parseInt(userGroup_id);
    }
    UserGroup userGroup = userGroupBo.findById(_userGroup_id);
%>
<c:set var="group" value="<%=userGroup%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/UserGroupBo.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/product/js/group.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type="text/javascript">
	$(function(){   $("#usergroupName").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户组管理 &gt;&gt; 修改用户组</div>
<form method="post" action="/action/userGroupAction" name="groupForm">
    <input type="hidden" name="method" value="modify"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="usergroupKind" value="1"/>
    <input type="hidden" name="usergroupStatus" value="0"/>
    <input type="hidden" name="usergroupId" id="usergroupId" value="${group.usergroupId}"/>
    <input type="hidden" id="oldGroupName" value="${group.usergroupName}"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                            <tr class="table1_tr1">
                                <td class="table1_td1" width="18%">组名称：</td>
                                <td>
                                    <input type="text" name="usergroupName" id="usergroupName" maxlength="20"
                                           isnull="false" onblur="checkGroupName()"
                                           value="${fn:trim(group.usergroupName)}" size="20" class="page_input2">
                                    <span id="groupDiv"></span>

                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1">详细描述：</td>
                                <td><textarea name="usergroupMemo" id="usergroupMemo" cols="50" rows="8"
                                              class="page_input_txt">${fn:trim(group.usergroupMemo)}</textarea></td>
                            </tr>

                        </table>

                    </div>
                    <div class="listbtn">
                        <td class="right"><input name="saveButton" type="button" class="newBtn1" value="保 存"
                                                 onClick="checkForm()" id="saveButton"/>
                            <input name="button" type="reset" class="newBtn1" id="reset" value="重 填"
                                    />
                            <input name="button" type="button" class="newBtn1" id="back" value="返 回"
                                   onclick="javascript:document.location.href='groupList.jsp?<%=paramString %>'"/>
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
         if("ModGroupSuc".equals(request.getParameter("msg").trim())){
    %>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "groupList.jsp";
    });
    <%}else{%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "groupList.jsp";
    });
    <%
         }
    }
    %>
</script>
</html>
