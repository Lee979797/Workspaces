<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
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
    <TITLE>����֤��У�Ե���ӡ</TITLE>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-barcode.min.js"></script>
    <script type="text/javascript">
        var hkey_root,hkey_path,hkey_key
        hkey_root="HKEY_CURRENT_USER"
        hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //������ҳ��ӡ��ҳüҳ��Ϊ��
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
        <input name="button3" type="button" class="newBtn1" id="button31" value="�� ӡ"
               onclick="page_top.style.display='none';printPage();"/>
        &nbsp;
        <input name="button3" type="button" class="newBtn1" id="back" value="�� ��" onClick="history.back()"/>
        &nbsp;
    </div>
</div>
<center>
<table border="0" cellpadding="0" cellspacing="0" style="margin-top:20px; width:667px;">
<tr>
    <td valign="bottom">
        <div style="line-height:60pt;text-align: center;"><b><font face="����_GB2312" size="5">��֯�������������Ϣ�ǼǱ�</font></b>&nbsp;&nbsp;
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
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td width="15%">
        <div align="left" class="style6"><font face="����" size="3">&nbsp;${jgdm.jgdm}</font>
        </div>
    </td>
   
     <td width="15%">
        <div  align="center" class="style6"><strong>�����Ƿ�����</strong></div>
    </td>
    <td width="10%">
        <div align="left" class="style6">&nbsp;${(jgdm.gk ne '1')?'��':'��'}</div>
    </td>
    <td width="12%">
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
   <td  width="13%"><div align='left' class="style6">&nbsp;${jgdm.fbsl}</div></td>
    <td width="15%">
        <div align="center" class="style6"><strong>���Ӹ�������</strong></div>
    </td>
            <td ><div align='left' class="style6">&nbsp;${jgdm.fksl}</div></td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td colspan="7">
        <div align="left" valign="top" class="style6">&nbsp;${jgdm.jgmc}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>���˴���<br/>(������)</strong></div>
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
        <div align="center" class="style6"><strong>��Ӫ��Χ<br>��ְ�ܡ���ּ��</strong></div>
    </td>
    <td colspan="7">
        <div align="left" <c:if test="${fn:length(fn:trim(jgdm.jyfw))>300}">id="jyfw"</c:if>  class="style6">&nbsp;${jgdm.jyfw}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td>
        <div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd"
                                                               value="${jgdm.zcrq}"/></div>
    </td>
    <td>
        <div align="center" class="style6"><strong>��Ӫ����</strong></div>
    </td>
            <td colspan="2"><div align="left" class="style6">&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${jgdm.gsfzrq}"/></div></td>
    
    <td>
        <div align="center" class="style6"><strong>ְ������</strong></div>
    </td>
    <td colspan="2">
        <div align='left' class="style6">&nbsp;${jgdm.zgrs}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>ע���ʽ�</strong></div>
    </td>
    <td>
        <div align="left" class="style6">&nbsp;${jgdm.zczj}��Ԫ</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>�ⷽ����</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.wftzgb}&nbsp;${gjMap[jgdm.wftzgb]}</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>���ܲ���</strong></div>
    </td>
    <td colspan="7">
        <div style="text-align: left;" class="style6">
            &nbsp;${jgdm.zgmc eq null? zgjgMap[fn:trim(jgdm.zgdm)]:jgdm.zgmc }</div>
    </td>
</tr>
<tr>
    <td>
        <div align="center" class="style6"><strong>��׼����</strong></div>
    </td>
    <td colspan="4">
        <div align="left" class="style6">
            &nbsp;${jgdm.pzjgmc eq null ? pzjgMap[fn:trim(jgdm.pzjgdm)]:jgdm.pzjgmc}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>��ϵ�绰</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6" >&nbsp;${jgdm.dhhm}</div>
    </td>
</tr>




<tr>
    
    <td rowspan="2">
        <div align="center" class="style6"><strong>ע���<br>(��׼�ĺ�)</strong></div>
    </td>
    <td  rowspan="2" colspan="2" align="left">
        <div class="style6">&nbsp;${jgdm.zch}</div>
    </td>
    <td>
        <div align="center" class="style6"><strong>��ַ</strong></div>
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
        <div  align="center" class="style6"><strong>����ע���ַ</strong></div>
    </td>
    <td colspan="7">
        <div style="text-align: left"
             class="style6"><%--${xzqhMap[jgdm.xzqh]}--%>&nbsp;${jgdm.jgdz}</div>
    </td>
</tr>

<tr>
<td>
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td colspan="3">
        <div align="left" class="style6">&nbsp;${xzqhMap[jgdm.xzqh]}</div>
    </td>
    <td >
        <div align="center" class="style6"><strong>��������</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.yzbm}</div>
    </td>
</tr>

<tr>
    <td rowspan="2">
        <div align="center" class="style6"><strong>������Ӫ��ַ</strong></div>
    </td>
    <td colspan="7">
        <div align='left' class="style6">&nbsp;${jgdm.jydz}</div>
    </td>
</tr>
<td>
        <div align="center" class="style6"><strong>��Ӫ�绰</strong></div>
    </td>
    <td colspan="3">
        <div align="left" class="style6">&nbsp;${jgdm.jydh}</div>
    </td>
    <td colspan="1">
        <div align="center" class="style6"><strong>��Ӫ�ʱ�</strong></div>
    </td>
    <td colspan="2">
        <div align="left" class="style6">&nbsp;${jgdm.jyyb}</div>
    </td>
</tr>


<tr>
    <td>
        <div align="center" class="style6"><strong>������</strong></div>
    </td>
    <td colspan="2">
        <div align='left' class="style6">&nbsp;${jgdm.tbrxm }</div>
    </td>
    <td colspan="2">
        <div align="center" class="style6"><strong>�������ֻ�</strong></div>
    </td>
    <td colspan="3">
        <div align='left' class="style6">&nbsp;${jgdm.tbrlxfs }</div>
    </td>
</tr>
<tr>
	 <td>
        <div align="center" class="style6"><strong>���������֤</strong></div>
    </td>
    <td colspan="7">
        <div align='left' class="style6">&nbsp;${jgdm.tbrsfzh}</div>
    </td>
</tr>
 <tr>
        	<td colspan="8">
            	<p style="text-align:left; font-size:14px;">������������Ϣ���˶ԣ�׼ȷ����ȷ����ȡ��֯��������֤�������������Ӹ������������Ϣ����δ��ʱ�빤����Ա�޸ģ���ɵ�һ����ʧ�����쵥λ���и���</p>
                <p style="text-align:right; font-size:14px;">�����ˣ�ǩ�֣���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
                <p style="text-align:right; font-size:14px;">�����뵥λ���£���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                <p style="text-align:right; font-size:14px;">�������ڣ�________��____��____��</p>
            </td>
        </tr>
        </table>

        <table class=MsoNormalTable border=1 bordercolor="#000000" cellspacing=0 cellpadding=0 style="border-collapse:collapse; width:667px;">
<tr bordercolor="#FFFFFF">
            <td colspan="6"><div align="center" class="style6"><b>�����ɷ�֤������д</b></div></td>
</tr>
<tr>
            <td colspan="6">
                <div class="style6">&nbsp;&nbsp;���걨��&nbsp; &nbsp;&nbsp;&nbsp;�����&nbsp;&nbsp;&nbsp;&nbsp;���ڻ�֤��&nbsp;&nbsp;&nbsp;&nbsp;Ǩ���&nbsp;&nbsp;&nbsp;&nbsp;��֤��&nbsp; &nbsp;&nbsp;&nbsp;������&nbsp;&nbsp;</div>
            </td>
        </tr>
        <tr>
            <td width="18%"><div align="center" class="style6"><strong>������ҵ(02��)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njjhy}&nbsp;&nbsp;${njjhyMap[fn:trim(jgdm.njjhy)]}</div></td>
            <td width="18%"><div align="center" class="style6"><strong>������ҵ(11��)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.nnjjhy}&nbsp;&nbsp;${ nnjjhyMap[jgdm.nnjjhy]}</div></td>
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>��������(94��)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.jjlx}&nbsp;&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}</div></td>
            <td><div align="center" class="style6"><strong>��������(02��)</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njjlx}&nbsp;${njjlxMap[jgdm.njjlx]}</div></td>
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>��������</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.jglx}&nbsp;&nbsp;${jglxMap[jgdm.jglx]}</div></td>
            <td><div align="center" class="style6"><strong>������</strong></div></td>
            <td colspan="2"><div align="right" class="style6">&nbsp;________��____��____��</div></td>
            
        </tr>
        <tr>
            <td><div align="center" class="style6"><strong>�»�������</strong></div></td>
            <td colspan="2"><div align='left' class="style6">&nbsp;${jgdm.njglx}&nbsp;&nbsp;${njglxMap[jgdm.njglx]}</div></td>
            <td><div align="center" class="style6"><strong>�����</strong></div></td>
            <td colspan="2"><div align="right" class="style6">&nbsp;________��____��____��</div></td>
            
        </tr>
       
        </table>
        </div>
        </td>
    </tr>
<tr>
    <td class="style7">
    	<div style="text-align: left">ע����������Ϣ�漰���һ��ܣ����ڡ������Ƿ����ܡ������ϡ��ǡ������ṩ��Ч֤������������ݽ����롰�ൺ����֯����������Ϣ���ݿ⡱������Ὺ�ŷ���</div>
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