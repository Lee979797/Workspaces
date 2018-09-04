<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    UserBo userBo = new UserBo();
    String user_id = request.getParameter("user_id");
    int _user_id = 0;
    if (!clsStringTool.isEmpty(user_id)) {
        _user_id = Integer.parseInt(user_id);
    }
    User user = userBo.findById(_user_id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>密码初始化</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/product/js/user.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 密码初始化</div>
<form method="post" action="/action/UserAction" name="userForm">
    <input type="hidden" name="method" value="initPassword"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="user_id" value="<%=user_id%>"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" align="center">
                            <tr class="table1_tr1">
                                <td nowrap="nowrap" class="table1_td1" align="right">用户名：</td>
                                <td><%=user.getUserName() %>
                                </td>

                            </tr>
                            <tr class="table1_tr1">
                                <td nowrap="nowrap" class="table1_td1" align="right">新密码：</td>
                                <td><input type="password" class="page_input2" size="25"
                                           name="user_password1"/></td>

                            </tr>
                            <tr class="table1_tr1">
                                <td nowrap="nowrap" class="table1_td1" align="right">确认新密码：</td>
                                <td><input type="password" class="page_input2" size="25"
                                           name="user_password2"/></td>
                            </tr>
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="button" class="newBtn1" id="saveButton" value="保 存"
                               onClick="initPassword();"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="重 填"
                               onclick="userForm.reset()"/>

                        <input name="button3" type="button" class="newBtn1" id="button3" value="返 回"
                               onclick="location.href='userList.jsp'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</form>
</div>

</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "userList.jsp";
    });
    <%}%>
</script>
</html>
