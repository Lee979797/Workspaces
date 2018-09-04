<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
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
    <title>У�Ե���ӡ</title>
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
            ymPrompt.alert({message: "��ӡ��ɣ�", width: 330, height: 220, handler: handler});
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
            font-family: '����_gbk', serif;
            font-size: medium;
            font-weight: bold
        }
    </style>
</head>
<body>
<div class="page_top_fixed" id="page_top">
    <div style=" float: right;display: inline;">
        <input name="bu3" type="button" class="newBtn1" id="bu31" value="�� ӡ"
               onclick="page_top.style.display='none';pagesetup_null();"/>
        &nbsp;
        <input name="butt" type="button" class="newBtn1" id="back" value="�� ��"
               onclick="history.back()"/>
        &nbsp;
    </div>
    ��֤ &gt;&gt; ֤���ӡ &gt;&gt; ����֤���ӡ &gt;&gt; ��ӡУ�Ե����
</div>
<div id="list_main" align="center">
<table border="0" width="650" cellpadding="0" cellspacing="0">
<tr>
    <td><p align="right" style="margin-left: 30"><span style="">�������룺<span
            style="font-weight: bold;">
        &nbsp;<strong>${jgdm.jgdm}
    </strong></span></span>&nbsp;</td>
</tr>
<tr>
    <td><p align="center" style="line-height:50pt"><span class="span_b_kt">
    ${zrxzqhMap[fn:trim(sysUser.userProvince)]}��֯���������걨��</span>
    </td>
</tr>
<tr>
    <td><p align="left" style="margin-left: 30"><span class="span_b_kt">���쵥λ��(����)</span>&nbsp;</td>
</tr>
<tr>
    <td><p align="right" style="margin-right: 30"><span class="span_b_kt">
        &nbsp;���ڣ�<strong>
        <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/>
    </strong></span></td>
</tr>
<tr>
<td>

<table border=1 cellspacing=0 cellpadding=0 width="100%">
<tr>
    <td colspan=42>
        <p style="line-height: 220%">
            &nbsp;����&nbsp;&nbsp;����&nbsp;&nbsp;���ڻ�֤��&nbsp;�����֤��&nbsp;IC����&nbsp;��֤��&nbsp;������</p>
    </td>
</tr>
<tr>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=38>
        <p align="left">&nbsp;<strong>${jgdm.jgmc}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:2;'>
    <td colspan=4>
        <p align="center">���˴���</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.fddbr}
        </strong></p></td>
    <td colspan=5>
        <p align="center">֤������</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.zjhm}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:3;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">��Ӫ��<br>
            ҵ��Χ</p></td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jyfw}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:4;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">���ܲ���</p></td>
    <td colspan=38>
        &nbsp;<strong>${jgdm.zgdm}
    </strong>&nbsp;<strong>${jgdm.zgmc}
    </strong>
    </td>
</tr>
<tr style='mso-yfti-irow:5;'>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=19>
        <p>&nbsp;<strong><fmt:formatDate value="${jgdm.zcrq}" pattern="yyyy-MM-dd"/>
        </strong></p></td>
    <td colspan=4>
        <p align="center">��������</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong><fmt:formatDate value="${jgdm.zfrq}" pattern="yyyy-MM-dd"/>
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:5;'>
    <td colspan=4>
        <p align="center">ע���ʽ�</p></td>
    <td colspan=19>
        <p>&nbsp;<strong><fmt:formatNumber value="${jgdm.zczj}" pattern="#.####"/>
        </strong>��Ԫ</p></td>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.hbzl}&nbsp;${hbMap[jgdm.hbzl]}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:6;'>
    <td colspan=4>
        <p align="center">�ⷽ����</p></td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.wftzgb}
        </strong>&nbsp;<strong>${gjMap[jgdm.wftzgb]}
        </strong></p></td>
    <td colspan=4>
        <p align="center">ְ������</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.zgrs}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:6;'>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.xzqh}&nbsp;${xzqhMap[jgdm.xzqh]}
        </strong></p></td>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.yzbm}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:7;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">ע���ַ</p></td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jgdz}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:9;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">��׼����</p></td>
    <td colspan=31>
        <p>&nbsp;<strong> ${jgdm.pzjgdm}&nbsp;${pzjgMap[fn:trim(jgdm.pzjgdm)]}&nbsp;${jgdm.pzjgmc}
        </strong></p></td>
    <td colspan=4>
        <p align="center">�Ƿ�����</p></td>
    <td colspan=3>
        <p>&nbsp;<strong>${(jgdm.gk ne '1')?'��':'��'}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:8;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">�绰����</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.dhhm}
        </strong></p></td>
    <td colspan=9>
        <p align="center">��׼�ĺŻ�ע���</p></td>
    <td colspan=16>
        <p>&nbsp;<strong>${jgdm.zch}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:2;'>
    <td colspan=4>
        <p align="center">������</p></td>
    <td colspan=13>
        <p>&nbsp;<strong>${jgdm.tbrxm}
        </strong></p></td>
    <td colspan=5>
        <p align="center">֤������</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.tbrsfzh}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:10;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">�����ֻ�</p>
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
        <p align="center">�� ַ</p></td>
    <td colspan=31>
        <p>&nbsp;<strong>${jgdm.url}
        </strong></p></td>
    <td colspan=4>
        <p align="center">��������</p></td>
    <td colspan=3>
        <p>&nbsp;<strong>${jgdm.fbsl}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:13;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">��Ӫ��ַ</p>
    </td>
    <td colspan=38>
        <p>&nbsp;<strong>${jgdm.jydz}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:14;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">��Ӫ�ʱ�</p>
    </td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.jyyb}
        </strong></p>
    </td>
    <td colspan=4>
        <p align="center">��Ӫ�绰</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.jydh}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:15;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">��������</p>
    </td>
    <td colspan=19>
        <p>&nbsp;<strong>${jgdm.khyh}
        </strong></p>
    </td>
    <td colspan=4>
        <p align="center">�����˺�</p>
    </td>
    <td colspan=15>
        <p>&nbsp;<strong>${jgdm.khzh}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:16;page-break-inside:avoid;'>
    <td colspan=4 style="border-bottom: 1px #000000;">
        <p align="center">��Ҫ��Ʒ</p>
    </td>
    <td colspan=38 align="left" style="border-bottom: 1px #000000;">
        <p>&nbsp;��Ʒ1��<strong>${jgdm.zycp1}&nbsp;${zycpMap[fn:trim(jgdm.zycp1) ]}
        </strong><br>&nbsp;��Ʒ2��<strong>${jgdm.zycp2}&nbsp;${zycpMap[fn:trim(jgdm.zycp2)]}
        </strong><br>&nbsp;��Ʒ3��<strong>${jgdm.zycp3}&nbsp;${zycpMap[fn:trim(jgdm.zycp3)]}
        </strong><br>
        </p>
    </td>
</tr>
<tr bordercolor="#FFFFFF" style="border-right: none;">
    <td colspan=21 style='border:none;border-bottom:solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;'>
        <p>�����ɴ�����������д</p></td>
    <td colspan=21 style='border:none;border-bottom:
  solid windowtext 1.5pt;border-right: none; mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;'>
        <p><span></span></p></td>
<tr style='mso-yfti-irow:22;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">��������</p>
    </td>
    <td colspan=36>
        <p>&nbsp;<strong>${jgdm.jglx}&nbsp;${jglxMap[jgdm.jglx]}
        </strong></p></td>
</tr>
<tr style='mso-yfti-irow:20;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">������ҵ(2000��)</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.njjhy}&nbsp;${ njjhyMap[jgdm.njjhy]}
        </strong></p>
    </td>
    <td colspan=7>
        <p align="center">��������(2000��)</p>
    </td>
    <td colspan=9>
        <p>&nbsp;<strong>${jgdm.njjlx}&nbsp;${njjlxMap[jgdm.njjlx]}
        </strong></p>
    </td>
</tr>
<tr style='mso-yfti-irow:19;page-break-inside:avoid;'>
    <td colspan=6>
        <p align="center">������ҵ(94��)</p></td>
    <td colspan=20>
        <p>&nbsp;<strong>${jgdm.jjhy}&nbsp;${jjhyMap[fn:trim(jgdm.jjhy)]}
        </strong></p></td>
    <td colspan=7>
        <p align="center">��������(94��)</p>
    <td colspan=9>
        <p>&nbsp;<strong>${jgdm.jjlx}&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}
        </strong></p>
    </td>
</tr>

<tr style='mso-yfti-irow:24;page-break-inside:avoid;'>
    <td colspan=4>
        <p align="center">����Ա</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
    <td colspan=4>
        <p align="center">���Ա</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
    <td colspan=4>
        <p align="center">��ע</p>
    </td>
    <td colspan=10>
        <p><span></span></p>
    </td>
</tr>
<tr style='mso-yfti-irow:25;mso-yfti-lastrow:yes;page-break-inside:avoid;
  '>
    <td colspan=42>
        <p>ע������Ӫ��ҵ�񣩷�Χ���ܻ�λ���˹��������ڡ������Ƿ����ܡ��������ǣ����ṩ��Ч֤������������ݽ����롰����ʡ��֯����������Ϣ���ݿ⡱������Ὺ�ŷ���</p>
    </td>
</tr>
</table>

</td>
</tr>
<tr>
    <td align="left">&nbsp;������˶Ա����ȷ�������ǩ�֣��緢��֤�������ɸ���λ���и���</td>
</tr>
<tr>
    <td align="right"> ������ǩ�֣�<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </td>
</tr>
</table>
<!-- --------------------------- -->
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
