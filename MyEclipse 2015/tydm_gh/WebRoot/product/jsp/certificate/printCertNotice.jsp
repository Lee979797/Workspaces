<%@ page import="java.util.Calendar" %>
<%@page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <META content="text/html; charset=GBK" http-equiv=Content-Type/>
    <meta name="GENERATOR" content="Microsoft FrontPage 4.0"/>
    <meta name="ProgId" content="FrontPage.Editor.Document"/>
    <title>打印通知单</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript'>
        function pagesetup_null() {
            window.print();
            ymPrompt.alert({message:"打印完成！", handler:handler});
        }
        function handler(tp) {
            if (tp == 'ok') {
                window.history.back();
                //window.location.href = "/bsweb/certificatePrint_search?source=4";
            }
        }
    </script>
    <link Rel="STYLESHEET" Href="../style/common.css" Type="text/css"/>
</head>
<BODY style="background:#fff;" leftMargin=0 onload='window.defaultStatus="欢迎进入组织机构代码管理系统!!!"' topMargin=0>
<div class="page_top_fixed" id="page_top">
    <div style=" float: right;display: inline;">
        <input name="bu3" type="button" class="newBtn1" id="bu31" value="打 印"
               onclick="page_top.style.display='none';pagesetup_null();"/>
        &nbsp;<input name="butt" type="button" class="newBtn1" id="back" value="返 回"
                     onclick="history.back()"/>
    </div>
    发证 &gt;&gt; 申请表登记 &gt;&gt; 预赋码 &gt;&gt; 赋码通知单
</div>
<div align="center" style="margin-top: 40px;">
    <table width="90%" height="401" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <div align="center">
                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <td width="50%"></td>
                            <td width="25%" align="center" class="Tzd_content">
                                编号：〖 <%=Calendar.getInstance().get(Calendar.YEAR)%> 〗
                            </td>
                            <td width="25%" align="center" class="Tzd_content">第 ${jgdmSave.wjwlsh} 号</td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td><p align="center"><span class="Tzd_title">全国组织机构代码赋码通知单</span>&nbsp;(存根)</td>
        </tr>
        <tr>
            <td height="30" class="Tzd_value"><b>${jgdmSave.pzjgmc}:</b><br>&nbsp;下述机构已领取组织机构代码
            </td>
        </tr>
        <tr>
            <td>
                <div align="center">
                    <table border="1" cellpadding="0" cellspacing="0" width="100%" bordercolor="#000000"
                           bordercolorlight="#000000" bordercolordark="#000000">
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">机构名称</td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.jgmc}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">批准文号<br>
                                （或批准证书批准号）
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.pzwh}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">批文日期<br>
                                （或批准证书颁发日期）
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value"><fmt:formatDate value="${jgdmSave.pwrq}"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">组织机构代码
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.jgdm}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">赋码日期</td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value"><fmt:formatDate value="${jgdmSave.bzrq}"/></span>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" height="30"><p style="margin-right: 35"><span class="Tzd_content">经办人签字：</span><span
                    class="Tzd_value"><u>${jgdmSave.wjwtbr}</u></span><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
            </td>
        </tr>
        <tr>
            <td align="right" height="49"><u>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u><span
                    class="Tzd_content">(赋码机构盖章)</span></td>
        </tr>
        <tr>
            <td align="right" height="51"><p class="Tzd_value" style="margin-right: 155"><fmt:formatDate
                    value="<%=Calendar.getInstance().getTime()%>"/>
            </td>
        </tr>
    </table>
</div>
<div align="center">
    <table border="0" cellpadding="0" cellspacing="0" width="90%">
        <tr>
            <td><br>
                <hr size="1" color="#000000">
                <br></td>
        </tr>
    </table>
</div>

<div align="center">
    <table border="0" width="90%" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <div align="center">
                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <td width="50%"></td>
                            <td width="25%" align="center" class="Tzd_content">
                                编号：〖 <%=Calendar.getInstance().get(Calendar.YEAR)%> 〗
                            </td>
                            <td width="25%" align="center" class="Tzd_content">第 ${jgdmSave.wjwlsh} 号</td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td><p align="center"><span class="Tzd_title">全国组织机构代码赋码通知单</span>&nbsp;</td>
        </tr>
        <tr>
            <td height="30" class="Tzd_value"><b>${jgdmSave.pzjgmc}:</b><br>&nbsp;下述单位已领取组织机构代码
            </td>
        </tr>
        <tr>
            <td>
                <div align="center">
                    <table border="1" cellpadding="0" cellspacing="0" width="100%" bordercolor="#000000"
                           bordercolorlight="#000000" bordercolordark="#000000">
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">机构名称</td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.jgmc}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">批准文号<br>
                                （或批准证书批准号）
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.pzwh}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">批文日期<br>
                                （或批准证书颁发日期）
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value"><fmt:formatDate value="${jgdmSave.pwrq}"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">组织机构代码
                            </td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value">${jgdmSave.jgdm}</span>
                            </td>
                        </tr>
                        <tr>
                            <td width="37%" height="25" align="center" valign="middle" class="Tzd_content">赋码日期</td>
                            <td width="63%" valign="middle">&nbsp;<span
                                    class="Tzd_value"><fmt:formatDate value="${jgdmSave.bzrq}"/></span>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" height="30"><p style="margin-right: 35"><span class="Tzd_content">经办人签字：</span><span
                    class="Tzd_value"><u>${jgdmSave.wjwtbr}</u></span><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
            </td>
        </tr>
        <tr>
            <td align="right" height="46"><u>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u><span
                    class="Tzd_content">(赋码机构盖章)</span></td>
        </tr>
        <tr>
            <td align="right" height="30"><p class="Tzd_value" style="margin-right: 155"><fmt:formatDate
                    value="<%=Calendar.getInstance().getTime()%>"/>
            </td>
        </tr>
    </table>
</div>
</body>

</html>
