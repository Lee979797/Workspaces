<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD><TITLE>代码证书校对单打印</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type/>
    <META content="Microsoft FrontPage 4.0" name="GENERATOR"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-barcode.min.js"></script>
    <script type="text/javascript">
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
            history.back();
        }
    </script>
    <style type="text/css">
        <!--
        .page_top {
            font-size: 12px;
            position: fixed !important;
            margin-left: auto;
            margin-right: auto;
            top: 0px;
            height: 28px;
            line-height: 28px;
            overflow: hidden;
            _position: absolute;
            _bottom: auto;
            _top: expression(eval(document.documentElement.scrollTop));
            z-index: 101;
            background-repeat: repeat-x;
            background-image: url(../images/titbg1.gif);
            vertical-align: middle;
            text-indent: 10px;
            border: #b6dbed solid 1px;
            width: 99.9%;
        }

        .btn1 {
            width: 52px;
            height: 23px;
            line-height: 23px;
            text-decoration: none;
            padding: 0px;
            border: none;
            color: #000;
            cursor: pointer;
            background: url(/images/btn2_1.gif) no-repeat;
        }

        .btn1:hover {
            background-position: 0 -23px;
        }

        .btn1:active {
            background-position: 0 -46px;
        }

        .page_top strong {
            font-weight: normal;
        }

        .style6 {
            font-size: 14px
        }

        .style7 {
            font-size: 12px
        }

        td {
            height: 22.3pt;
        }

        -->
    </style>
</HEAD>

<BODY class=body leftMargin=0 topMargin=0>

<div class="page_top" id="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        <input name="button3" type="button" class="newBtn1" id="button31" value="打 印"
               onclick="page_top.style.display='none';pagesetup_null();"/>
        &nbsp;
        <input name="button3" type="button" class="newBtn1" id="back" value="返 回" onclick="history.back()"/>
        &nbsp;
    </div>
</div>
<center>
<table border="0" width="667" cellpadding="0" cellspacing="0" style="margin-top: 20px">
<tr>
    <td>
        <div style="line-height:30pt;text-align: center;"><b><font face="楷体_GB2312"
                                                                   size="4">海南省组织机构代码申报表</font></b>&nbsp;&nbsp;
            </div>
    </td>
</tr>
<tr>
    <td align="right"><span align="right" class="style7" style="line-height:20pt">流水号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </span>
    </td>
</tr>
<tr>
<td>
<div align="center">
<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width=667
       style='width:500.4pt;border-collapse:collapse;border:none;mso-border-alt:solid windowtext 0.5pt;
 mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:.5pt solid windowtext;
 mso-border-insidev:.5pt solid windowtext'>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:22.3pt'>
    <td width="15%" colspan=2>
        <p align="center" class="style6"><strong>代码条码</strong></p></td>
    <td colspan=40>
        <div id="barcodeTarget"
             style="margin-left: 20%; text-align: center;"></div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:27.8pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>机构代码</strong></div>
    </td>
    <td colspan=18>
        <div align="left" class="style6"><font face="黑体" size="4">&nbsp;${jgdm.jgdm}</font></div>
    </td>
    <td colspan=18>
        <div align="center" class="style6"><strong>机构是否涉密（盖章确认）</strong></div>
    </td>
    <td colspan=4>
        <div align="left" class="style6">&nbsp;${(jgdm.gk ne '1')?'是':'否'}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:22.3pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>机构名称</strong></div>
    </td>
    <td colspan=40>
        <div align="left" valign="top" class="style6">&nbsp;${jgdm.jgmc}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:7;page-break-inside:avoid;height:21.55pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>注册地址</strong></div>
    </td>
    <td colspan=40>
        <div style="text-align: left" class="style6"><%--${xzqhMap[jgdm.xzqh]}--%>&nbsp;${jgdm.jgdz}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:2;height:22.7pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>法人代表</strong></div>
    </td>
    <td colspan=18>
        <div style="text-align: left" class="style6">&nbsp;${jgdm.fddbr}</div>
    </td>
    <td colspan=12>
        <div align="center" class="style6"><strong>身份证号</strong></div>
    </td>
    <td colspan=10>
        <div style="text-align: left" class="style6">&nbsp;${jgdm.zjhm}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:3;page-break-inside:avoid;height:25.55pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>经营或<br>
            业务范围</strong></div>
    </td>
    <td colspan=40>
        <div align="left" class="style6">&nbsp;${jgdm.jyfw}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:27.8pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>成立日期</strong></div>
    </td>
    <td colspan=10>
        <div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.zcrq}"/></div>
    </td>
    <td colspan=12>
        <div align="center" class="style6"><strong>经营期限</strong></div>
    </td>
    <td colspan=5>
        <div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.gsfzrq}"/></div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>&nbsp;&nbsp;</strong></div>
    </td>
    <td colspan=3>
        <div align="left" class="style6">&nbsp;&nbsp;</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:27.8pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>注册资金</strong></div>
    </td>
    <td colspan=10>
        <div align="left" class="style6">&nbsp;${jgdm.zczj}万元</div>
    </td>
    <td colspan=12>
        <div align="center" class="style6"><strong>货币种类
        </strong></div>
    </td>
    <td colspan=5>
        <div align="left" class="style6">&nbsp;${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}</div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>外方国别</strong></div>
    </td>
    <td colspan=3>
        <div align="left" class="style6">&nbsp;${jgdm.wftzgb}&nbsp;${gjMap[jgdm.wftzgb]}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:6;height:20.4pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong><%--行政区划--%></strong></div>
    </td>
    <td colspan=18>
        <div class="style6"><%--&nbsp;${jgdm.xzqh}&nbsp;&nbsp;${xzqhMap[jgdm.xzqh]}--%></div>
    </td>
    <td colspan=14>
        <div align="center" class="style6"><strong>批准文号或注册号</strong></div>
    </td>
    <td colspan=8>
        <div class="style6">&nbsp;${jgdm.zch}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:4;page-break-inside:avoid;height:21.6pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>主管部门</strong></div>
    </td>
    <td colspan=40>
        <div style="text-align: left;" class="style6">&nbsp;${jgdm.zgmc eq null? zgjgMap[fn:trim(jgdm.zgdm)]:jgdm.zgmc }&nbsp;&nbsp;${jgdm.zgdm}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:9;page-break-inside:avoid;height:14.65pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>批准机构</strong></div>
    </td>
    <td colspan=40>
        <div align="left" class="style6">
            &nbsp;${jgdm.pzjgdm}&nbsp;&nbsp;${jgdm.pzjgmc eq null ? pzjgMap[fn:trim(jgdm.pzjgdm)]:jgdm.pzjgmc}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:27.8pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>邮政编码</strong></div>
    </td>
    <td colspan=10>
        <div align="left" class="style6">&nbsp;${jgdm.yzbm}</div>
    </td>
    <td colspan=12>
        <div align="center" class="style6"><strong>电话号码
        </strong></div>
    </td>
    <td colspan=5>
        <div align="left" class="style6">&nbsp;${jgdm.dhhm}</div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>传真号码</strong></div>
    </td>
    <td colspan=3>
        <div align="left" class="style6">&nbsp;${jgdm.jydh}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:12;page-break-inside:avoid;height:21.0pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>网 址</strong></div>
    </td>
    <td colspan=17>
        <div align='left' class="style6">&nbsp;${jgdm.url}</div>
    </td>
    <td colspan=8>
        <div align="center" class="style6"><strong>E-mail</strong></div>
    </td>
    <td colspan=15>
        <div align='left' class="style6">&nbsp;${jgdm.email}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:13;page-break-inside:avoid;height:18.65pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>经营地址</strong></div>
    </td>
    <td colspan=40>
        <div align='left' class="style6">&nbsp;${jgdm.jydz}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:5;height:21.3pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>经营邮编</strong></div>
    </td>
    <td colspan=10>
        <div align='left' class="style6">&nbsp;${jgdm.jyyb}</div>
    </td>
    <td colspan=6>
        <div align="center" class="style6"><strong>职工人数</strong></div>
    </td>
    <td colspan=7>
        <div align='left' class="style6">&nbsp;${jgdm.zgrs}</div>
    </td>
    <td colspan=4>
        <div align="center" class="style6"><strong>副本数量</strong></div>
    </td>
    <td colspan=8>
        <div align='left' class="style6">&nbsp;${jgdm.fbsl}</div>
    </td>
    <td colspan=3>
        <div align="center" class="style6"><strong>IC卡数量</strong></div>
    </td>
    <td colspan=2>
        <div align='left' class="style6">&nbsp;${jgdm.fksl}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:16;page-break-inside:avoid;height:21.7pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>主要产品<br>(限生产企业)</strong></div>
    </td>
    <td colspan=40>
        <div align='left' class="style6">
            &nbsp;产品1：${fn:trim(jgdm.zycp1)}&nbsp;&nbsp;${zycpMap[fn:trim(jgdm.zycp1) ]}<br>
            &nbsp;产品2：${fn:trim(jgdm.zycp2)}&nbsp;&nbsp;${zycpMap[fn:trim(jgdm.zycp2) ]}<br>
            &nbsp;产品3：${fn:trim(jgdm.zycp3)}&nbsp;&nbsp;${zycpMap[fn:trim(jgdm.zycp3) ]}<br>
        </div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:1;height:22.3pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>产品执行标准</strong></div>
    </td>
    <td colspan=40>
        <div align="left" class="style6">&nbsp;${jgdm.memo2}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:15;page-break-inside:avoid;height:19.4pt'>
    <td colspan=2>
        <div align="center" class="style6"><strong>经办人姓名</strong></div>
    </td>
    <td colspan=23>
        <div align='left' class="style6">&nbsp;&nbsp;</div>
    </td>
    <td colspan=4>
        <div align="center" class="style6"><strong>身份证号</strong></div>
    </td>
    <td colspan=13>
        <div align='left' class="style6">&nbsp;&nbsp;</div>
    </td>
</tr>
<tr bordercolor="#FFFFFF" style='mso-yfti-irow:17;page-break-inside:avoid;height:19.85pt'>
    <td colspan=21 style='width:248.75pt;border:none;border-bottom:
  solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;height:19.85pt'><br>

        <div align="center" class="style6"><b>下栏由代码管理机关填写</b></div>
    </td>
    <td colspan=21 style='width:251.65pt;border:none;border-bottom:
  solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;height:19.85pt'>
        <div><span class="style6"></span></div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:18;page-break-inside:avoid;height:17.0pt'>
    <td colspan=42>
        <div class="style6">&nbsp;&nbsp;新申报□&nbsp; &nbsp;到期换证□&nbsp;&nbsp;变更换证□&nbsp;&nbsp;
            IC卡□&nbsp;&nbsp;年检□&nbsp; &nbsp;变更换卡□&nbsp;&nbsp;补证□&nbsp;&nbsp;补卡□
        </div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:19;page-break-inside:avoid;height:20.7pt'>
    <td colspan=4>
        <div align="center" class="style6"><strong>经济行业(94版)</strong></div>
    </td>
    <td colspan=15>
        <div align='left' class="style6">&nbsp;${jgdm.jjhy}&nbsp;&nbsp;${jjhyMap[fn:trim(jgdm.jjhy)]}</div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>经济行业(02版)</strong></div>
    </td>
    <td colspan=13>
        <div align='left' class="style6">&nbsp;${jgdm.njjhy}&nbsp;&nbsp;${ njjhyMap[jgdm.njjhy]}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:20;page-break-inside:avoid;height:19.45pt'>
    <td colspan=4>
        <div align="center" class="style6"><strong>经济类型(94版)</strong></div>
    </td>
    <td colspan=15>
        <div align='left' class="style6">&nbsp;${jgdm.jjlx}&nbsp;&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}</div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>经济类型(02版)</strong></div>
    </td>
    <td colspan=13>
        <div align='left' class="style6">&nbsp;${jgdm.njjlx}&nbsp;${njjlxMap[jgdm.njjlx]}</div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:21;page-break-inside:avoid;height:17.65pt'>
    <td colspan=3>
        <div align="center" class="style6"><strong>机构类型</strong></div>
    </td>
    <td colspan=12>
        <div align='left' class="style6">&nbsp;${jgdm.jglx}&nbsp;&nbsp;${jglxMap[jgdm.jglx]}</div>
    </td>
    <td colspan=10>
        <div align="center" class="style6"><strong>办证日期</strong></div>
    </td>
    <td colspan=12>
        <div align='left' class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.bzrq}"/></div>
    </td>
    <td colspan=4>
        <div align="center" class="style6"><strong>有效期至</strong></div>
    </td>
    <td colspan=2>
        <div align='left' class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.zfrq}"/></div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:24;page-break-inside:avoid;height:17.0pt'>
    <td colspan=4>
        <div align="center" class="style6"><strong>受理人</strong></div>
    </td>
    <td colspan=7>
        <div><span class="style6"></span></div>
    </td>
    <td colspan=11>
        <div align="center" class="style6"><strong>审核人</strong></div>
    </td>
    <td colspan=8>
        <div><span class="style6"></span></div>
    </td>
    <td colspan=8>
        <div align="center" class="style6"><strong>录入人</strong></div>
    </td>
    <td colspan=4>
        <div><span class="style6"></span></div>
    </td>
</tr>
<tr bordercolor="#000000" style='mso-yfti-irow:19;page-break-inside:avoid;height:20.7pt'>
    <td colspan=4>
        <div align="center" class="style6"><strong>行政区划</strong></div>
    </td>
    <td colspan=15>
        <div align='left' class="style6">&nbsp;${jgdm.xzqh}&nbsp;&nbsp;${xzqhMap[jgdm.xzqh]}</div>
    </td>
    <td colspan=11>
        <div align="center" class="style6"><strong>填表日期</strong></div>
    </td>
    <td colspan=12>
        <div align='center' class="style6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</div>
    </td>
</tr>
</table>
</div>
</td>
</tr>
<tr style='mso-yfti-irow:25;mso-yfti-lastrow:yes;page-break-inside:avoid;
  height:31.2pt'>
    <td class="style7" colspan=42>
        <div style="text-align: left">
            <strong>请认真核对本表格，确认无误后签字。如表中信息有误，请及时与代码工作人员联系修改，否则造成代码证书信息错误由申领单位自行负责！</strong><br/>注：若本表信息涉及国家机密，请在“机构是否涉密”中填上“是”，并提供有效证明。上述填报内容将编入“海南省组织机构代码信息数据库”并对社会开放服务。
        </div>
    </td>
</tr>
</table>
</center>
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
</HTML>