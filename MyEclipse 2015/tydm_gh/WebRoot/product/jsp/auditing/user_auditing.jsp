<%@ page language="java" pageEncoding="GBK" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@page import="com.ninemax.jpa.global.InitSysParams" %>
<%@page import="java.util.List,java.lang.*" %>
<%@page import="java.util.Date" %>
<%@page import="com.ninemax.jpa.code.bus.AuditingBus,com.ninemax.jpa.code.model.SmUser" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>注册用户信息审核</title>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript">

        function checkpass() {

            if (document.getElementById("info1").value.length > 200) {
                ymPrompt.alert({message:"审核意见不能超过200个字!", width:330, height:220, title:'提示信息'});
                return;
            }
            document.getElementById("ispass").value = "yes";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }

        function checknopass() {
            if (document.getElementById("info1").value.length > 200) {
                ymPrompt.alert({message:"审核意见不能超过200个字!", width:330, height:220, title:'提示信息'});
                return;
            }
            document.getElementById("ispass").value = "no";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }

    </script>

</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">
    <div align="right" style="float: right;">
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/>
    </div>
    审核 &gt;&gt; 审核管理 &gt;&gt; 注册用户信息审核
</div>
<div id="list_main">
    <form name="form1" id="form1" action="/bsweb/auditingauditUser.action" method="post" style="margin:0; padding:0;">
        <input name="ispass" id="ispass" type="hidden" value=""/>
        <input name="user.id" type="hidden" value="${user.id }"/>
        <input type="hidden" name="currentPath" value="<%=currentPath%>"/>

        <div class="page_div2 f_10"><br/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="80" align="center" nowrap="nowrap">审核意见：</td>
                    <td align="center"><textarea name="user.memo" rows="3" class="input_txt_morebz"
                                                 id="info1"></textarea></td>
                </tr>
                <tr>
                    <td align="center">审核结果：</td>
                    <td height="35" align="left"><input name="button3" type="button" class="btn_yes" id="button3"
                                                        value=" " onclick="checkpass();"/>
                        <input name="button3" type="button" class="btn_no" id="button4" value=" "
                               onclick="checknopass();"/></td>
                </tr>
            </table>
        </div>
        <br/>
    </form>

    <div class="list">
        <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
            <tr>
                <td class="title_txt">用户注册信息</td>
            </tr>
        </table>

        <div class="content">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bottom_border">
                <tr class="table_tr1">
                    <td width="10%" align="right">组织机构名称：</td>
                    <td width="20%">
                        ${user.jgmc }&nbsp;</td>
                    <td width="10%" align="right">用户名：</td>
                    <td colspan="3" style="text-align: left;">
                        ${user.username }&nbsp;</td>
                </tr>
                <tr class="table_tr1">
                    <td width="10%" align="right">经办人姓名：</td>
                    <td width="20%">
                        ${user.jbrxm }&nbsp;</td>
                    <td width="10%" align="right">经办人手机：</td>
                    <td width="20%">
                        ${user.jbrmobile }&nbsp;</td>
                    <td width="10%" align="right">经办人邮箱：</td>
                    <td width="30%">
                        ${user.jbremail }&nbsp;</td>
                </tr>
                <tr class="table_tr1">
                    <td align="right">经办人证件类型：</td>
                    <td>
                        ${user.jbrzjlx }&nbsp;</td>
                    <td align="right">经办人证件号码：</td>
                    <td colspan="3" style="text-align: left;">
                        ${user.jbrzjhm }&nbsp;</td>
                </tr>
            </table>
        </div>

    </div>
</div>
</body>

<script language="javascript">
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg!=null && !clsStringTool.isEmpty(msg.toString())){
    %>
    ymPrompt.succeedInfo('<%=msg.toString()%>',330,220, '提示信息', function () {
        window.location.href = "/bsweb/auditingauditUserList.html";
    });
    <%}%>
</script>
</html>
