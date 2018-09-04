<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public"); response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>校对单打印</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript'>
        function pagesetup_null() {
            window.print();
            ymPrompt.alert({message: "打印完成！", width: 330, height: 220, handler: handler});
        }
        function handler(tp) {
            if (tp == 'ok') {
                window.history.back();
                //window.location.href = "/bsweb/certificatePrint_search?source=4";
            }
        }
    </script>
    <style type="text/css">
        .span_b_kt {
            font-family: '楷体_gbk', serif;
            font-size: medium;
            font-weight: bold
        }
    </style>
</head>
<body>
<div class="page_top_fixed" id="page_top">
    <div style=" float: right;display: inline;">
        <input name="bu3" type="button" class="newBtn1" id="bu31" value="打 印"
               onclick="page_top.style.display='none';pagesetup_null();"/>
        &nbsp;
        <input name="butt" type="button" class="newBtn1" id="back" value="返 回"
               onclick="history.back()"/>
        &nbsp;
    </div>
    发证 &gt;&gt; 证书打印 &gt;&gt; 代码证书打印 &gt;&gt; 打印校对单简表
</div>
<div id="list_main" align="center">
<table border="0" width="650" cellpadding="0" cellspacing="0">
<tr>
    <td><p align="right" style="margin-left: 30"><span style="">机构代码：<span
            style="font-weight: bold;">
        &nbsp;<strong>${jgdm.jgdm}
    </strong></span></span>&nbsp;</td>
</tr>
<tr>
    <td><p align="center" style="line-height:50pt"><span class="span_b_kt">
    ${zrxzqhMap[fn:trim(sysUser.userProvince)]}组织机构代码申报表</span>
    </td>
</tr>
<tr>
    <td><p align="left" style="margin-left: 30"><span class="span_b_kt">申领单位：(盖章)</span>&nbsp;</td>
</tr>
<tr>
    <td><p align="right" style="margin-right: 30"><span class="span_b_kt">
        &nbsp;日期：<strong>
        <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/>
    </strong></span></td>
</tr>
<tr>
<td>

<table border=1 cellspacing=0 cellpadding=0 width="100%">
<tr>
    <td colspan=42>
        <p style="line-height: 220%">
            &nbsp;申办□&nbsp;&nbsp;年检□&nbsp;&nbsp;到期换证□&nbsp;变更换证□&nbsp;IC卡□&nbsp;补证□&nbsp;补卡□</p>
    </td>
</tr>
<tr>
    <td colspan=4>
        <p align="center">机构名称</p></td>
    <td colspan=38>
        <p align="left">&nbsp;<strong>${jgdm.jgmc}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:2;'>
    <td colspan=4>
        <p align="center">法人代表</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.fddbr}
        </strong></p></td>
    <td colspan=5>
        <p align="center">证件号码</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.zjhm}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:3;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">经营或<br>
            业务范围</p></td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jyfw}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:4;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">主管部门</p></td>
    <td colspan=38>
        &nbsp;<strong>${jgdm.zgdm}
    </strong>&nbsp;<strong>${jgdm.zgmc}
    </strong>
    </td>
</tr>
<tr style='mso-yfti-irow:5;'>
    <td colspan=4>
        <p align="center">成立日期</p></td>
    <td colspan=19>
        <p>&nbsp;<strong><fmt:formatDate value="${jgdm.zcrq}" pattern="yyyy-MM-dd"/>
        </strong></p></td>
    <td colspan=4>
        <p align="center">作废日期</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong><fmt:formatDate value="${jgdm.zfrq}" pattern="yyyy-MM-dd"/>
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:5;'>
    <td colspan=4>
        <p align="center">注册资金</p></td>
    <td colspan=19>
        <p>&nbsp;<strong><fmt:formatNumber value="${jgdm.zczj}" pattern="#.####"/>
        </strong>万元</p></td>
    <td colspan=4>
        <p align="center">货币种类</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:6;'>
    <td colspan=4>
        <p align="center">外方国别</p></td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.wftzgb}
        </strong>&nbsp;<strong>${gjMap[jgdm.wftzgb]}
        </strong></p></td>
    <td colspan=4>
        <p align="center">职工人数</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.zgrs}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:6;'>
    <td colspan=4>
        <p align="center">行政区划</p></td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.xzqh}&nbsp;${xzqhMap[jgdm.xzqh]}
        </strong></p></td>
    <td colspan=4>
        <p align="center">邮政编码</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.yzbm}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:7;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">注册地址</p></td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jgdz}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:9;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">批准机构</p></td>
    <td colspan=31>
        <p>&nbsp;<strong> ${jgdm.pzjgdm}&nbsp;${pzjgMap[fn:trim(jgdm.pzjgdm)]}&nbsp;${jgdm.pzjgmc}
        </strong></p></td>
    <td colspan=4>
        <p align="center">是否涉密</p></td>
    <td colspan=3>
        <p>&nbsp;<strong>${(jgdm.gk ne '1')?'是':'否'}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:8;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">电话号码</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.dhhm}
        </strong></p></td>
    <td colspan=9>
        <p align="center">批准文号或注册号</p></td>
    <td colspan=16>
        <p>&nbsp;<strong>${jgdm.zch}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:2;'>
    <td colspan=4>
        <p align="center">经办人</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.tbrxm}
        </strong></p></td>
    <td colspan=5>
        <p align="center">证件号码</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.tbrsfzh}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:10;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">法人手机</p>
    </td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.mobile}
        </strong></p>
    </td>
    <td colspan=5>
        <p align="center">EMAIL</p>
    </td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.email}
        </strong></p>
</tr>
<tr style='mso-yfti-irow:8;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">网 址</p></td>
    <td colspan=31>
        <p>&nbsp;<strong>${jgdm.url}
        </strong></p></td>
    <td colspan=4>
        <p align="center">副本数量</p></td>
    <td colspan=3>
        <p>&nbsp;<strong>${jgdm.fbsl}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:13;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">经营地址</p>
    </td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jydz}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:14;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">经营邮编</p>
    </td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.jyyb}
        </strong></p>
    </td>
    <td colspan=4>
        <p align="center">经营电话</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.jydh}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:15;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">开户银行</p>
    </td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.khyh}
        </strong></p>
    </td>
    <td colspan=4>
        <p align="center">开户账号</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.khzh}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:16;page-break-inside:avoid;'>
    <td colspan=4 style="border-bottom: 1px #000000;">
        <p align="center">主要产品</p>
    </td>
    <td colspan=38 align="left" style="border-bottom: 1px #000000;">
        <p>&nbsp;产品1：<strong>${jgdm.zycp1}&nbsp;${zycpMap[fn:trim(jgdm.zycp1) ]}
        </strong><br>&nbsp;产品2：<strong>${jgdm.zycp2}&nbsp;${zycpMap[fn:trim(jgdm.zycp2)]}
        </strong><br>&nbsp;产品3：<strong>${jgdm.zycp3}&nbsp;${zycpMap[fn:trim(jgdm.zycp3)]}
        </strong><br>
        </p>
    </td>
</tr>
<tr bordercolor="#FFFFFF" style="border-right: none;">
    <td colspan=21 style='border:none;border-bottom:solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;'>
        <p>下栏由代码管理机关填写</p></td>
    <td colspan=21 style='border:none;border-bottom:
  solid windowtext 1.5pt;border-right: none; mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;'>
        <p><span></span></p></td>
<tr style='mso-yfti-irow:22;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">机构类型</p>
    </td>
    <td colspan=36>
        <p>&nbsp;<strong>${jgdm.jglx}&nbsp;${jglxMap[jgdm.jglx]}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:20;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">经济行业(2000版)</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.njjhy}&nbsp;${ njjhyMap[jgdm.njjhy]}
        </strong></p>
    </td>
    <td colspan=7>
        <p align="center">经济类型(2000版)</p>
    </td>
    <td colspan=9>
        <p>&nbsp;<strong>${jgdm.njjlx}&nbsp;${njjlxMap[jgdm.njjlx]}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:19;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">经济行业(94版)</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.jjhy}&nbsp;${jjhyMap[fn:trim(jgdm.jjhy)]}
        </strong></p></td>
    <td colspan=7>
        <p align="center">经济类型(94版)</p>
    <td colspan=9>
        <p>&nbsp;<strong>${jgdm.jjlx}&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}
        </strong></p>
    </td>
</tr>

<tr style='mso-yfti-irow:24;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">受理员</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
    <td colspan=4>
        <p align="center">审核员</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
    <td colspan=4>
        <p align="center">备注</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:25;mso-yfti-lastrow:yes;page-break-inside:avoid;
  '>
    <td colspan=42>
        <p>注：若经营（业务）范围涉密或单位不宜公开，请在“机构是否涉密”中填上是，并提供有效证明。上述填报内容将编入“云南省组织机构代码信息数据库”并对社会开放服务。</p>
    </td>
</tr>
</table>

</td>
</tr>
<tr>
    <td align="left">&nbsp;请认真核对本表格，确认无误后签字，如发现证书有误由各单位自行负责！</td>
</tr>
<tr>
    <td align="right"> 经办人签字：<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </td>
</tr>
</table>
<!-- --------------------------- -->
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
