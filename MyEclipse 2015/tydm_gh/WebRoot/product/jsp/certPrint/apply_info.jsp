<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njglxMap" value="<%= InitSysParams.njglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <TITLE>代码证书校对单打印</TITLE>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-barcode.min.js"></script>
    <script type="text/javascript">
        var hkey_root,hkey_path,hkey_key
        hkey_root="HKEY_CURRENT_USER"
        hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //设置网页打印的页眉页脚为空
        function pagesetup_null(){
            try{
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key="header"
                RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")
                hkey_key="footer"
                RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")
            }catch(e){}
        }
        function printPage() {
            window.print();
            page_top.style.display='block';
        }
    </script>
    <style type="text/css">
        <!--
        .page_top_fixed {
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

        

        .style6 {
            font-size: 13px;
        }

        .style7 {
            font-size: 12px
        }

        td {
            height: 22.3pt;
        }
        #jyfw{
            font-size:6px;
            line-height:8px;
        }
        -->
    </style>
</HEAD>

<BODY class=body leftMargin=0 topMargin=0>
<div class="page_top_fixed" id="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        <input name="button3" type="button" class="newBtn1" id="button31" value="打 印"
               onclick="page_top.style.display='none';printPage();"/>
        &nbsp;
        <input name="button3" type="button" class="newBtn1" id="back" value="返 回" onClick="history.back()"/>
        &nbsp;
    </div>
</div>
<center>
<table border="0" cellpadding="0" cellspacing="0" style="margin-top:20px; width:667px;">
<tr>
    <td valign="bottom">
        <div style="line-height:60pt;text-align: center;"><b><font face="楷体_GB2312" size="5">组织机构代码基本信息登记表</font></b>&nbsp;&nbsp;
        </div>
    </td>
</tr>

<tr>
<td>


<div>
<table class=MsoNormalTable border=1 bordercolor="#000000" cellspacing=0 cellpadding=0
       style="border-collapse:collapse; width:667px;">


<tr>
    <td width="15%">
        <div align="center" class="style6"><strong>机构代码</strong></div>
    </td>
    <td width="15%">
        <div align="left" class="style6"><font face="黑体" size="3">&nbsp;${jgdm.jgdm}</font>
        </div>
    </td>
   
     <td width="15%">
        <div  align="center" class="style6"><strong>机构是否涉密</strong></div>
    </td>
    <td width="10%">
        <div align="left" class="style6">&nbsp;${(jgdm.gk ne '1')?'是':'否'}</div>
    </td>
    <td width="12%">
        <div align="center" class="style6"><strong>副本数量</strong></div>
    </td>
   <td  width="13%"><div align='left' class="style6">&nbsp;${jgdm.fbsl}</div></td>
    <td width="15%">
        <div align="center" class="style6"><strong>电子副本数量</strong></div>
    </td>
            <td ><div align='left' class="style6">&nbsp;${jgdm.fksl}</div></td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>机构名称</strong></div>
    </td>
    <td colspan="7">
        <div align="left" valign="top" class="style6">&nbsp;${jgdm.jgmc}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>法人代表<br/>(负责人)</strong></div>
    </td>
    <td colspan="2">
        <div style="text-align: left" class="style6">&nbsp;${jgdm.fddbr}</div>
    </td>
    <td  colspan="2">
        <div align="center" class="style6"><strong>${zjlxMap[jgdm.zjlx] }</strong></div>
    </td>
    <td colspan="3">
        <div style="text-align: left" class="style6">&nbsp;${jgdm.zjhm}</div>
    </td>
</tr>
<tr style="height:30pt;">
    <td>
        <div align="center" class="style6"><strong>经营范围<br>（职能、宗旨）</strong></div>
    </td>
    <td colspan="7">
        <div align="left" <c:if test="${fn:length(fn:trim(jgdm.jyfw))>300}">id="jyfw"</c:if>  class="style6">&nbsp;${jgdm.jyfw}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>成立日期</strong></div>
    </td>
    <td>
        <div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd"
                                                               value="${jgdm.zcrq}"/></div>
    </td>
    <td>
        <div align="center" class="style6"><strong>经营期限</strong></div>
    </td>
            <td colspan="2"><div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.gsfzrq}"/></div></td>
    
    <td>
        <div align="center" class="style6"><strong>职工人数</strong></div>
    </td>
    <td colspan="2">
        <div align='left' class="style6">&nbsp;${jgdm.zgrs}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>注册资金</strong></div>
    </td>
    <td>
        <div align="left" class="style6">&nbsp;${jgdm.zczj}万元</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>货币种类</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>外方国别</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.wftzgb}&nbsp;${gjMap[jgdm.wftzgb]}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>主管部门</strong></div>
    </td>
    <td colspan="7">
        <div style="text-align: left;" class="style6">
            &nbsp;${jgdm.zgmc eq null? zgjgMap[fn:trim(jgdm.zgdm)]:jgdm.zgmc }</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>批准机构</strong></div>
    </td>
    <td colspan="4">
        <div align="left" class="style6">
            &nbsp;${jgdm.pzjgmc eq null ? pzjgMap[fn:trim(jgdm.pzjgdm)]:jgdm.pzjgmc}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>联系电话</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6" >&nbsp;${jgdm.dhhm}</div>
    </td>
</tr>




<tr>
    
    <td rowspan="2">
        <div align="center" class="style6"><strong>注册号<br>(批准文号)</strong></div>
    </td>
    <td  rowspan="2" colspan="2" align="left">
        <div class="style6">&nbsp;${jgdm.zch}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>网址</strong></div>
    </td>
    <td colspan="4">
        <div class="style6">&nbsp;${jgdm.url}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>E-mail</strong></div>
    </td>
    <td colspan="4">
        <div align="left" class="style6">&nbsp;${jgdm.email}</div>
    </td>
</tr>
<tr>
    <td rowspan="2">
        <div  align="center" class="style6"><strong>机构注册地址</strong></div>
    </td>
    <td colspan="7">
        <div style="text-align: left"
             class="style6"><%--${xzqhMap[jgdm.xzqh]}--%>&nbsp;${jgdm.jgdz}</div>
    </td>
</tr>

<tr>
<td>
        <div align="center" class="style6"><strong>行政区划</strong></div>
    </td>
    <td colspan="3">
        <div align="left" class="style6">&nbsp;${xzqhMap[jgdm.xzqh]}</div>
    </td>
    <td >
        <div align="center" class="style6"><strong>邮政编码</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.yzbm}</div>
    </td>
</tr>

<tr>
    <td rowspan="2">
        <div align="center" class="style6"><strong>机构经营地址</strong></div>
    </td>
    <td colspan="7">
        <div align='left' class="style6">&nbsp;${jgdm.jydz}</div>
    </td>
</tr>
<td>
        <div align="center" class="style6"><strong>经营电话</strong></div>
    </td>
    <td colspan="3">
        <div align="left" class="style6">&nbsp;${jgdm.jydh}</div>
    </td>
    <td colspan="1">
        <div align="center" class="style6"><strong>经营邮编</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.jyyb}</div>
    </td>
</tr>


<tr>
    <td>
        <div align="center" class="style6"><strong>经办人</strong></div>
    </td>
    <td colspan="2">
        <div align='left' class="style6">&nbsp;${jgdm.tbrxm }</div>
    </td>
    <td colspan="2">
        <div align="center" class="style6"><strong>经办人手机</strong></div>
    </td>
    <td colspan="3">
        <div align='left' class="style6">&nbsp;${jgdm.tbrlxfs }</div>
    </td>
</tr>
<tr>
	 <td>
        <div align="center" class="style6"><strong>经办人身份证</strong></div>
    </td>
    <td colspan="7">
        <div align='left' class="style6">&nbsp;${jgdm.tbrsfzh}</div>
    </td>
</tr>
 <tr>
        	<td colspan="8">
            	<p style="text-align:left; font-size:14px;">声明：以上信息经核对，准确无误，确认领取组织机构代码证正、副本及电子副本。如表中信息有误，未及时请工作人员修改，造成的一切损失由申领单位自行负责。</p>
                <p style="text-align:right; font-size:14px;">申领人（签字）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
                <p style="text-align:right; font-size:14px;">（申请单位公章）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                <p style="text-align:right; font-size:14px;">申领日期：________年____月____日</p>
            </td>
        </tr>
        </table>

        <table class=MsoNormalTable border=1 bordercolor="#000000" cellspacing=0 cellpadding=0 style="border-collapse:collapse; width:667px;">
<tr bordercolor="#FFFFFF">
            <td colspan="6"><div align="center" class="style6"><b>下栏由发证机关填写</b></div></td>
</tr>
<tr>
            <td colspan="6">
                <div class="style6">&nbsp;&nbsp;新申报□&nbsp; &nbsp;&nbsp;&nbsp;变更□&nbsp;&nbsp;&nbsp;&nbsp;到期换证□&nbsp;&nbsp;&nbsp;&nbsp;迁入□&nbsp;&nbsp;&nbsp;&nbsp;补证□&nbsp; &nbsp;&nbsp;&nbsp;其他□&nbsp;&nbsp;</div>
            </td>
        </tr>
        <tr>
            <td width="18%"><div align="center" class="style6"><strong>经济行业(02版)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njjhy}&nbsp;&nbsp;${njjhyMap[fn:trim(jgdm.njjhy)]}</div></td>
            <td width="18%"><div align="center" class="style6"><strong>经济行业(11版)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.nnjjhy}&nbsp;&nbsp;${ nnjjhyMap[jgdm.nnjjhy]}</div></td>
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>经济类型(94版)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.jjlx}&nbsp;&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}</div></td>
            <td><div align="center" class="style6"><strong>经济类型(02版)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njjlx}&nbsp;${njjlxMap[jgdm.njjlx]}</div></td>
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>机构类型</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.jglx}&nbsp;&nbsp;${jglxMap[jgdm.jglx]}</div></td>
            <td><div align="center" class="style6"><strong>受理人</strong></div></td>
            <td colspan="2"><div align="right" class="style6">&nbsp;________年____月____日</div></td>
            
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>新机构类型</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njglx}&nbsp;&nbsp;${njglxMap[jgdm.njglx]}</div></td>
            <td><div align="center" class="style6"><strong>审核人</strong></div></td>
            <td colspan="2"><div align="right" class="style6">&nbsp;________年____月____日</div></td>
            
        </tr>
       
        </table>
        </div>
        </td>
    </tr>
<tr>
    <td class="style7">
    	<div style="text-align: left">注：若本表信息涉及国家机密，请在“机构是否涉密”中填上“是”，并提供有效证明。上述填报内容将编入“青岛市组织机构代码信息数据库”并对社会开放服务。</div>
    </td>
</tr>
</table>
</center>

</body>
<!-- 
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
 -->
</HTML>