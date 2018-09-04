<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    TJgdm tJgdm = (TJgdm) request.getAttribute("jgdm");
%>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="nnjjhyMap" value="<%= InitSysParams.jjhy2k1Map%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>校对单打印</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-barcode.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript'>
        var hkey_root, hkey_path, hkey_key
        hkey_root = "HKEY_CURRENT_USER"
        hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //设置网页打印的页眉页脚为空
        function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
            } catch (e) {
            }
        }
        function printPage() {
            pagesetup_null();
            window.print();
            history.back();
        }
    </script>
    <style type="text/css">
        .kt_18 {
            font-family: '楷体_gbk', serif;
            font-size: medium;
            font-weight: bold
        }

        td {
            text-align: left;
        }

        .jyfw {
            font-size: 6px;
            line-height: 8px;
        }
    </style>
</head>
<body>
<div class="page_top_fixed" id="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        <input name="button3" type="button" class="newBtn1" id="button31" value="打 印"
               onclick="page_top.style.display='none';printPage();"/>
        &nbsp;
        <input name="button3" type="button" class="newBtn1" id="back" value="返 回" onclick="history.back()"/>
        &nbsp;
    </div>
</div>

<div id="list_main" style="text-align: center">
<table border="0" width="667" cellpadding="0" cellspacing="0">
<tr>
    <td height="20">&nbsp;</td>
</tr>
<tr>
    <td height="88">
        <p style="text-align: center" style="line-height:50pt"><span class="kt_18">组织机构基本信息确认表</span>
            &nbsp;
    </td>
</tr>
<tr>
    <td height="7"></td>
</tr>
<tr>
    <td>
        <div style="text-align: center">
            <table border="1" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td style="text-align: center" width="16%" height="30" valign="middle">机构代码条码</td>
                    <td height="30" style="text-align: center;line-height: 0pt;" colspan="5">
                        <div id="barcodeTarget"
                             style=" margin-top: 5px ;border: 0;"/>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center" width="16%" height="30" valign="middle">机构代码</td>
                    <td width="31%" valign="middle"
                        style="font-size: small;  font-weight: bold;">
                        &nbsp;${jgdm.jgdm}</td>
                    <td style="text-align: center" width="9%" valign="middle">IC卡</td>
                    <td valign="middle" style="font-size: small;   font-weight: bold; ">
                        &nbsp;${(jgdm.fkbz eq '1')?'是':"否"}
                    </td>
                    <td style="text-align: center" width="9%" valign="middle">信息公开</td>
                    <td width="24%" valign="middle" style="  font-weight: bold;">
                        &nbsp;${(jgdm.gk eq '1')?'是':"否"}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">机构名称</td>
                    <td colspan="5" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.jgmc}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">行政区划</td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.xzqh}&nbsp;${xzqhMap[jgdm.xzqh]}</td>
                    <td style="text-align: center" width="13%" valign="middle">
                        <div style="text-align: center">机构类型</div>
                    </td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.jglx}&nbsp;${jglxMap[jgdm.jglx]}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">单位地址</td>
                    <td colspan="5" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.jgdz}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">办证日期</td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">
                        &nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.bzrq}"/></td>
                    <td valign="middle">
                        <div style="text-align: center">作废日期</div>
                    </td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">&nbsp;<fmt:formatDate
                            pattern="yyyy-MM-dd"
                            value="${jgdm.zfrq}"/>
                    </td>
                </tr>
                <tr>
                    <td width="16%" style="text-align: center" height="30" valign="middle">法人/负责人</td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.fddbr}</td>
                    <td valign="middle">
                        <div style="text-align: center">证件号码</div>
                    </td>
                    <td colspan="2" valign="middle" style="font-weight: bold;">
                        &nbsp;${jgdm.zjhm}</td>
                </tr>
                <tr>
                    <td width="16%" style="text-align: center" height="30" valign="middle">经济行业(2011版)</td>
                    <td colspan="2" valign="middle">
                        &nbsp;${jgdm.nnjjhy}&nbsp;：&nbsp;${nnjjhyMap[fn:trim(jgdm.nnjjhy)]}</td>
                    <td valign="middle">
                        <div style="text-align: center">经济类型(2000版)</div>
                    </td>
                    <td colspan="2" valign="middle">
                        &nbsp;${jgdm.njjlx}&nbsp;：&nbsp;${njjlxMap[fn:trim(jgdm.njjlx)]}</td>
                </tr>
                <tr>
                    <td width="16%" style="text-align: center" height="30" valign="middle">经济行业(2000版)</td>
                    <td colspan="2" valign="middle">
                        &nbsp;${jgdm.njjhy}&nbsp;：&nbsp;${njjhyMap[fn:trim(jgdm.njjhy)]}</td>
                    <td valign="middle">
                        <div style="text-align: center">经济类型(94版)</div>
                    </td>
                    <td colspan="2" valign="middle">
                        &nbsp;${jgdm.jjlx}&nbsp;：&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">邮政编码</td>
                    <td colspan="2" valign="middle"><b>&nbsp;</b>${jgdm.yzbm}</td>
                    <td valign="middle">
                        <div style="text-align: center">联系电话</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.dhhm}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">批文或注册号</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.zch}</td>
                    <td valign="middle">
                        <div style="text-align: center">经办人</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.tbrxm}</td>
                </tr>
                <tr>
                    <td width="16%" style="text-align: center" height="30" valign="middle">批准机构名称</td>
                    <td colspan="5" valign="middle">
                        &nbsp;${jgdm.pzjgmc eq null ?pzjgMap[fn:trim(jgdm.pzjgdm)]:jgdm.pzjgmc}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">经营范围</td>
                    <td colspan="5"
                        <c:if test="${fn:length(fn:trim(jgdm.jyfw))>270}">class="jyfw"</c:if> valign="middle">
                        &nbsp;${fn:trim(jgdm.jyfw)}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">注册资金</td>
                    <td colspan="2" valign="middle">&nbsp;<fmt:formatNumber value="${jgdm.zczj}" pattern="#.####"/> 万元
                    </td>
                    <td valign="middle">
                        <div style="text-align: center">货币种类</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">职工人数</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.zgrs}</td>
                    <td valign="middle">
                        <div style="text-align: center">成立日期</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.zcrq}"
                            /></td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">主管机构</td>
                    <td colspan="2" valign="middle">
                        &nbsp;${jgdm.zgdm}&nbsp;${jgdm.zgmc eq null ?'':(jgdm.zgmc)}</td>
                    <td valign="middle">
                        <div style="text-align: center">副本数量</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.fbsl}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">电子信箱</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.email}</td>
                    <td valign="middle">
                        <div style="text-align: center">网 址</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.url}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">经营地址</td>
                    <td colspan="5" valign="middle">&nbsp;${jgdm.jydz}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">经营邮编</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.jyyb}</td>
                    <td valign="middle">
                        <div style="text-align: center">经营电话</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.jydh}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">开户银行</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.khyh}</td>
                    <td valign="middle">
                        <div style="text-align: center">经费来源</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.jfly}</td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">开户账号</td>
                    <td colspan="2" valign="middle">&nbsp;${jgdm.khzh}</td>
                    <td valign="middle">
                        <div style="text-align: center">经营期限</div>
                    </td>
                    <td colspan="2" valign="middle">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd"
                                                                          value="${jgdm.gsfzrq}"/></td>
                </tr>
                <tr>
                    <td style="text-align: center" height="30" valign="middle">主要产品</td>
                    <td colspan="5" valign="middle"
                            >
                        ${jgdm.zycp1}&nbsp;${zycpMap[fn:trim(jgdm.zycp1)]}<p/>
                        ${jgdm.zycp2}&nbsp;${zycpMap[fn:trim(jgdm.zycp2)]}<p/>
                        ${jgdm.zycp3}&nbsp;${zycpMap[fn:trim(jgdm.zycp3)]}
                    </td>
                </tr>
            </table>
        </div>
    </td>
</tr>
<tr>
    <td align="left" height="64" style="font-size: 13px;font-weight: bold;text-align: right;">
        请认真核对本表格，确认无误后签字，如发现证书有误由各单位自行负责！
        经办人签字：<span style="text-decoration:underline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </td>
</tr>
<tr>
    <td align="right" style="text-align: right" height="47">日期：
        <fmt:formatDate pattern="yyyy-MM-dd" value="<%=new Date()%>"/>&nbsp;&nbsp;
    </td>
</tr>
</table>
</div>
</body>

<script type="text/javascript">
    (function () {
        var settings = {
            output: "css",
            bgColor: "#FFFFFF",
            color: "#000000",
            barWidth: 2,
            barHeight: 35,
            moduleSize: 0,
            posX: 10,
            posY: 10,
            fontSize: 0,
            addQuietZone: 0
        };
        $("#barcodeTarget").html("").show().barcode("${jgdm.jgdm}", "code39", settings);
    })();
</script>
</html>
