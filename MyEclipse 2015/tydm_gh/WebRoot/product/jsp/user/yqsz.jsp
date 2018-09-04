<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    String paramString = request.getQueryString();
    String user_id = request.getParameter("user_id");
    int _user_id = 0;
    if (!clsStringTool.isEmpty(user_id)) {
        _user_id = Integer.parseInt(user_id);
    }

    UserBo userBo = new UserBo();
    User user = userBo.findById(_user_id);
    String regProvince = user.getUserProvince();
    if (regProvince == null || regProvince.equals("") || "null".equals(regProvince)) {
    }

%>
<c:set value="<%=InitSysParams.bzjgdmMap%>" var="bzjgMap"/>
<c:set var="user" value="<%=user%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>修改用户信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
	$(function(){   $("#yqsj").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <style type="text/css">
        table.table_bj1 td {
            height: 38px;
        }
    </style>
    <script type="text/javascript">
    </script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户管理 &gt;&gt; 延期设置</div>

<form method="post" action="/action/UserAction" name="userForm">
    <input type="hidden" name="method" value="yzsz"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="userId" id="userId" value="<%=user_id%>"/>
    <input type="hidden" name="firstXzqh" value="${sysUser.bzjgdm}"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                            <tr class="table1_tr1">
                                <td width="15%" class="table1_td1">用户名：</td>
                                <td style="position:relative;display:block;overflow:visible;"><%=user.getUserName() %>
                                </td>
                                <td width="15%" class="table1_td1" nowrap>真实姓名：</td>
                                <td>${fn:trim(user.userChinesename)}
                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" colspan="2">延长时间：</td>
                                <td colspan="2"><input type="text" id="yqsj" name="yqsj" onkeyup="onlyDecimal(this)" maxlength="5"
                                                       size="30" isnull="false"
                                                       class="page_input2"
                                                       value="${fn:trim(user.yqsj)}"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="submit" class="newBtn1" id="saveButton" value="保 存"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="重 填"
                               onclick="userForm.reset()"/>

                        <input name="button3" type="button" class="newBtn1" id="button3" value="返 回"
                               onclick="javascript:document.location.href='userList.jsp?<%=paramString %>'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    <%
        String msg =request.getParameter("msg");
        if(!clsStringTool.isEmpty(msg)){
            if("success".equals(msg)){
               %>
    ymPrompt.succeedInfo('延期设置成功！', 330, 220, '提示信息', function () {
        window.location.href = "userList.jsp";
    });
    <%
    }else{
     %>
    ymPrompt.alert('延期设置失败请重试！', 330, 220, '提示信息', function () {
        window.location.href = "userList.jsp";
    });
    <%
    }

}
%>
</script>
</html>
