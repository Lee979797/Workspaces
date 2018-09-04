<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.Role" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
<%
    RoleBo roleBo = new RoleBo();
    String role_id = request.getParameter("role_id");
    int _role_id = 0;
    if (!clsStringTool.isEmpty(role_id)) {
        _role_id = Integer.parseInt(role_id);
    }
    String paramString = request.getQueryString();
    Role role = roleBo.findById(_role_id);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>查看角色</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
</head>
<body>
<div class="page_top">
    <div align="left" style=" float: left;">系统 &gt;&gt; 用户角色管理 &gt;&gt; 角色管理 &gt;&gt;
        查看角色(<%=role.getRoleName()%>)
    </div>
</div>
<div id="box">
    <div id="right">
        <div class="rightpart">
            <div class="list listblue">
                <table width="100%" border="0" cellpadding="0" cellspacing="1">
                    <tr>
                        <td class="table1_td1" width="18%" align="right">角色名称：</td>
                        <td>
                            <%=role.getRoleName() %>
                        </td>
                    </tr>
                    <tr>
                        <td class="table1_td1" align="right">详细描述：</td>
                        <td height="100"><%=role.getRoleMemo()%>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="listbtn">
                <input name="button" type="button" class="newBtn1" id="button" value="返 回"
                       onclick="javascript:document.location.href='roleList.jsp?<%=paramString %>'"/>

            </div>
        </div>
    </div>
</div>
</body>
</html>
