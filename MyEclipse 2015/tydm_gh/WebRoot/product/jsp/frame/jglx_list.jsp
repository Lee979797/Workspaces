<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>用户组管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/delete_ajax.js'></script>
    <script type='text/javascript' src='/js/page_common.js'></script>
    <script type='text/javascript' src='/product/js/userlist.js'></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 系统设置 &gt;&gt; 必填项管理</div>
<div id="list_main">
    <div class="list_box">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td class="list_table_top_td" style="width:5%">序号</td>
                <td class="list_table_top_td">
                    <div style="float:left">类型代码</div>
                </td>
                <td class="list_table_top_td" align="center">类型名称</td>
                <td class="list_table_top_td" align="center">管理</td>
            </tr>
            <c:forEach var="dm" varStatus="i" items="${jglxMap}">
                <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                    <td>&nbsp;${i.count}</td>
                    <td>${dm.key}</td>
                    <td>${dm.value}</td>
                    <td align="center">
                        <img src="/product/images/icon_shenhe.gif" width="16"
                             height="16"
                             onclick="document.location.href='/bsweb/jglxBtx_show?jglx.dm=${dm.key}&jglx.mc=${dm.value}'"
                             style="cursor:pointer;"/>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </div>
</div>
</body>
</html>
