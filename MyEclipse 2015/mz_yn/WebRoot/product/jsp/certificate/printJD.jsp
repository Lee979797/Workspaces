<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.system.bo.BzjgdmBo" %>
<%@ page import="com.ninemax.jpa.system.model.Bzjgdm" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus,com.ninemax.jpa.code.bus.PrintCertBus" %>
<%@page import="java.net.URLDecoder" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();

    String jgdm = request.getParameter("jgdm");
    User user = (User) session.getAttribute("sysUser");
//-------------------------
    PrintCertBus certBus = new PrintCertBus();
    int i = 0;
    Hashtable hashData = null;
//必输项vector
    Vector vecBsx = null;
//从Bean里取得的返回值
    Vector vecRet = certBus.printJd(jgdm, user.getBzjgdm());
    //提取返回值
    hashData = (Hashtable) vecRet.elementAt(0);
    String strJgdm = (String) hashData.get("jgdm");
    String strJgmc = (String) hashData.get("jgmc");
    String strFddbr = (String) hashData.get("fddbr");
    String strZjhm = (String) hashData.get("zjhm");
    String strJglx = (String) hashData.get("jglx");
    String strJgdz = (String) hashData.get("jgdz");
    String strYxq = (String) hashData.get("yxq");
    String strBfdw = (String) hashData.get("bfdw");
    String strJgdm1 = (String) hashData.get("jgdm1");
    String strCsmm = (String) hashData.get("csmm");
    String strDytz = (String) hashData.get("dytz");

    String strFkbz = (String) hashData.get("fkbz");
    String strGk = (String) hashData.get("gk");
    String strJjlx = (String) hashData.get("jjlx");
    String strJjhy = (String) hashData.get("jjhy");
    String strYzbm = (String) hashData.get("yzbm");
    String strDhhm = (String) hashData.get("dhhm");
    String strZch = (String) hashData.get("zch");
    String strTbrxm = (String) hashData.get("tbrxm");
    String strPzjgmc = (String) hashData.get("pzjgmc");
    String strJyfw = (String) hashData.get("jyfw");
    String strZczj = (String) hashData.get("zczj");
    String strHbzl = (String) hashData.get("hbzl");
    String strZgrs = (String) hashData.get("zgrs");
    String strZgdm = (String) hashData.get("zgdm");
    String strZgmc = (String) hashData.get("zgmc");
    String strZfrq = (String) hashData.get("zfrq");
    String strBzrq = (String) hashData.get("bzrq");
    String strZcrq = (String) hashData.get("zcrq");
    String strXzqh = (String) hashData.get("xzqh");
    String strXzqh1 = (String) hashData.get("xzqh1");

    String strEmail = (String) hashData.get("email");
    String strUrl = (String) hashData.get("url");
    String strGsfzrq = (String) hashData.get("gsfzrq");
    String strJydz = (String) hashData.get("jydz");
    String strJyyb = (String) hashData.get("jyyb");
    String strJydh = (String) hashData.get("jydh");
    String strJfly = (String) hashData.get("jfly");
    String strKhyh = (String) hashData.get("khyh");
    String strKhzh = (String) hashData.get("khzh");
    String strZycp1 = (String) hashData.get("zycp1");
    String strZycp11 = (String) hashData.get("zycp11");
    String strFbsl = (String) hashData.get("fbsl");

    String strToday = DateProcess.getSysDate();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>校对单打印</title>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript'>
        var hkey_root, hkey_path, hkey_key
        hkey_root = "HKEY_CURRENT_USER"
        hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //设置网页打印的页眉页脚为空
        //左右位置的设置，如果在边距设置10，则注册表的值为0.39370
        function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "margin_bottom"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.39370")
                hkey_key = "margin_left"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.39370")
                hkey_key = "margin_right"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.39370")
                hkey_key = "margin_top"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.39370")
                window.print()
            } catch (e) {
            }
        }
    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">发证 &gt;&gt; 证书打印 &gt;&gt; 校对单打印
    <p style="float:right; padding-right:5px;padding-top: 2.5px;"><input name="button3" type="button" class="newBtn1"
                                                                         id="button31" value="打 印"
                                                                         onclick="page_top.style.display='none';pagesetup_null();"/>
    </p></div>
<div id="list_main">
    <center>
        <!-- --------------------------- -->
        <br/>
        <table border="0" width="98%" cellpadding="0" cellspacing="0">
            <tr>
                <td height="20">&nbsp;</td>
            </tr>
            <tr>
                <td height="88"><p align="center" style="line-height:50pt"><b><font face="楷体_gbk" size="18px">组织机构基本信息确认表</font></b>&nbsp;</td>
            </tr>
            <tr>
                <td height="7"></td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <table border="2" cellpadding="0" cellspacing="0" width="100%" bordercolor="#000000"
                               bordercolorlight="#000000" bordercolordark="#000000">
                            <tr>
                                <td width="14%" align="center" height="30" valign="middle">机构代码</td>
                                <td width="31%" valign="middle" bordercolor="#000000"><b><font size="3">&nbsp;<%=strJgdm%>
                                </font></b></td>
                                <td width="9%" valign="middle" align="center">IC卡</td>
                                <td valign="middle"><b><font size="3">&nbsp;<%=strFkbz%>
                                </font></b></td>
                                <td width="9%" valign="middle" align="center">信息公开</td>
                                <td width="24%" valign="middle"><b><font size="3">&nbsp;<%=strGk%>
                                </font></b></td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">机构名称</td>
                                <td colspan="5" valign="middle" bordercolor="#000000"><b><font size="3">&nbsp;<%=strJgmc%>
                                </font></b></td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">行政区划</td>
                                <td colspan="2" valign="middle" bordercolor="#000000"><b><font size="3">&nbsp;<%=strXzqh%>&nbsp;<%=strXzqh1%>
                                </font></b></td>
                                <td width="13%" valign="middle">
                                    <div align="center">机构类型</div>
                                </td>
                                <td colspan="2" valign="middle"><b><font size="3">&nbsp;<%=strJglx%>
                                </font></b></td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">单位地址</td>
                                <td colspan="5" valign="middle" bordercolor="#000000"><b><font size="3">&nbsp;<%=strJgdz%>
                                </font></b></td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">办证日期</td>
                                <td colspan="2" valign="middle" bordercolor="#000000"><b><font size="3">&nbsp;<%=strBzrq%>
                                </font></b></td>
                                <td valign="middle">
                                    <div align="center">作废日期</div>
                                </td>
                                <td colspan="2" valign="middle"><b><font size="3">&nbsp;<%=strZfrq%>
                                </font></b></td>
                            </tr>
                            <tr>
                                <td width="14%" align="center" height="30" valign="middle">法人/负责人</td>
                                <td colspan="2" valign="middle" bordercolor="#000000"><strong><font size="3">&nbsp;<%=strFddbr%>
                                </font></strong></td>
                                <td valign="middle">
                                    <div align="center">身份证号码</div>
                                </td>
                                <td colspan="2" valign="middle"><strong><font size="3">&nbsp;<%=strZjhm%>
                                </font></strong></td>
                            </tr>
                            <tr>
                                <td width="14%" align="center" height="30" valign="middle">经济行业</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strJjhy%>
                                </td>
                                <td valign="middle">
                                    <div align="center">经济类型</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strJjlx%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">邮政编码</td>
                                <td colspan="2" valign="middle" bordercolor="#000000"><b>&nbsp;</b><%=strYzbm%>
                                </td>
                                <td valign="middle">
                                    <div align="center">电话号码</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strDhhm%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">批文或注册号</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strZch%>
                                </td>
                                <td valign="middle">
                                    <div align="center">经办人</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strTbrxm%>
                                </td>
                            </tr>
                            <tr>
                                <td width="14%" align="center" height="30" valign="middle">批准机构名称</td>
                                <td colspan="5" valign="middle" bordercolor="#000000">&nbsp;<%=strPzjgmc%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">经营范围</td>
                                <td colspan="5" valign="middle" bordercolor="#000000">&nbsp;<%=clsStringTool.convertNull(strJyfw)%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">注册资金</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strZczj%>
                                </td>
                                <td valign="middle">
                                    <div align="center">货币种类</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strHbzl%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">职工人数</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strZgrs%>
                                </td>
                                <td valign="middle">
                                    <div align="center">成立日期</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strZcrq%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">主管机构</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strZgdm%>&nbsp;<%=strZgmc%>
                                </td>
                                <td valign="middle">
                                    <div align="center">副本数量</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strFbsl%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">EMAIL</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strEmail%>
                                </td>
                                <td valign="middle">
                                    <div align="center">单位网址</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strUrl%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">经营地址</td>
                                <td colspan="5" valign="middle" bordercolor="#000000">&nbsp;<%=strJydz%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">经营邮编</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strJyyb%>
                                </td>
                                <td valign="middle">
                                    <div align="center">经营电话</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strJydh%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">开户银行</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strKhyh%>
                                </td>
                                <td valign="middle" bordercolor="#000000">
                                    <div align="center">经费来源</div>
                                </td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strJfly%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">开户账号</td>
                                <td colspan="2" valign="middle" bordercolor="#000000">&nbsp;<%=strKhzh%>
                                </td>
                                <td valign="middle">
                                    <div align="center">经营期限</div>
                                </td>
                                <td colspan="2" valign="middle">&nbsp;<%=strGsfzrq%>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" height="30" valign="middle">主要产品</td>
                                <td colspan="5" valign="middle" bordercolor="#000000"><%=strZycp1%>&nbsp;<%=strZycp11%>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right" height="64"><strong>请认真核对本表格，确认无误后签字，如发现证书有误由各单位自行负责！经办人签字
                    ：</strong><u>&nbsp;</u>
                </td>
            </tr>
            <tr>
                <td align="right" height="47">日期：<%=strToday%>&nbsp;</td>
            </tr>
        </table>
        <!-- --------------------------- -->
    </center>
</div>
</body>
</html>
