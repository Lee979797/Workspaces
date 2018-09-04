<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
    UserGroupBo userGroupBo = new UserGroupBo();
    String userGroup_id = request.getParameter("userGroup_id");
//System.out.println("----"+userGroup_id);
    String paramString = request.getQueryString();
    int _userGroup_id = 0;
    if (!clsStringTool.isEmpty(userGroup_id)) {
        _userGroup_id = Integer.parseInt(userGroup_id);
    }
    com.ninemax.jpa.system.model.UserGroup userGroup = userGroupBo.findById(_userGroup_id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>查看用户组</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="js/alert/skin/dmm-green/ymPrompt.css"/>


</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户组管理 &gt;&gt; 查看用户组</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <table width="90%" border="0" cellpadding="0">
                        <tr class="table1_tr1">
                            <td class="table1_td1" align="right">用户组名称：</td>
                            <td>
                                <%=userGroup.getUsergroupName()%>
                            </td>
                        </tr>
                        <tr class="table1_tr1">
                            <td class="table1_td1" align="right">详细描述：</td>
                            <td><%=userGroup.getUsergroupMemo()%>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="listbtn" style=" width: 100%">
                    <input name="button" type="button" class="newBtn1" id="button" value="返 回"
                           onclick="javascript:document.location.href='groupList.jsp?<%=paramString %>'"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
