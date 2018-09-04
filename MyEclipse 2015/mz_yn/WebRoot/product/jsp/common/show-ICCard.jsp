<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<style type="text/css">
table.tableBorder0 td{ border:#c4dbe5 1px solid;}
</style>
<c:set var="nnjghyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjglxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
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
<c:set var="njglxList" value="<%=InitSysParams.tnJglxList%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/dtree.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
</head>
<body>
<TR>
    <TD class="td1" align="right" width="15%">
        �������룺
    </TD>
    <TD class="td1" >
        ${icCard.jgdm}
    </TD>
    <TD class="td1" align="right" width="15%">
        ${jgdm.njrq ne null ?'�ϴ���죺':''}
    </TD>
    <TD class="td1" >
        <c:if test="${jgdm.njrq ne null}">
            <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"></fmt:formatDate>
        </c:if>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        �������ͣ�
    </TD>
    <TD class="td1">
        ${icCard.jglx}:${jglxMap[fn:trim(icCard.jglx)]}
    </TD>
    <td class="td1" align="right">
        �»������ͣ�
    </td>
    <td class="td1">
        <c:forEach var="jglx" items="${njglxList}">
            <c:if test="${(fn:trim(jglx.dm) eq fn:trim(jgdm.jglx))}">${jglx.mc}</c:if>
        </c:forEach>
    </td>
</TR>
<TR>
    <TD class="td1" colSpan="2">&nbsp;${("0" eq icCard.fkbz)?"�ݲ�����":("0" eq icCard.fkbz)?("����&nbsp;����������"+icCard.fksl):""}</TD>
    <TD class="td1" colSpan="2">
        &nbsp;���������� ${icCard.zbsl eq null?0:icCard.zbsl}&nbsp;���������� ${icCard.fbsl eq null?0:icCard.fbsl}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        �������ƣ�
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jgmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ���˴���
    </TD>
    <TD class="td1">
        ${icCard.fddbr}
    </TD>
    <TD class="td1" align="right">
        ${zjlxMap[fn:trim(icCard.zjlx)]}��
    </TD>
    <TD class="td1">&nbsp;${icCard.zjhm}:(${fn:length(icCard.zjhm)}λ)


    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ӫ��Χ��
    </TD>
    <TD class="td1" colSpan="3">${fn:trim(icCard.jyfw)}</TD>
</TR>

<tr>
    <TD class="td1" align="right">
        ������ҵ(2011��)��
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjghyMap[fn:trim(jgdm.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"��":name }
    </TD>
    <td class="td1" align="right">
        ������ҵ(2000��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm.njjhy)]}"/>
        ${(name eq '' or name eq null)?"��":name }

    </td>


</tr>
<tr>
    <td class="td1" align="right">
        ��������(2000��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm.njjlx)]}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
    <td class="td1" align="right">
        ��������(94��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm.jjlx)]}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</tr>

<TR>
    <TD class="td1" align="right">
        �������ڣ�
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.zcrq}" pattern="yyyy-MM-dd"/>
    </TD>
    <TD class="td1" align="right">
        ��֤���ڣ�
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.bzrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ������ޣ�
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.njqx}" pattern="yyyy-MM-dd"/>

    </TD>
    <TD class="td1" align="right">
        �������ڣ�
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.zfrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ����������
    </TD>
    <TD class="td1">
        <c:set var="xzqhmc" value="${xzqhMap[fn:trim(icCard.xzqh)]}"/>
        ${icCard.xzqh} : ${xzqhmc == null ? "" : xzqhmc}
    </TD>
    <TD class="td1" align="right">
        ְ��������
    </TD>
    <TD class="td1">
        ${icCard.zgrs}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��λ��ַ��
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jgdz}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ע���ʽ�
    </TD>
    <TD class="td1">
        <c:set var="name" value="${fn:trim(icCard.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">
            ��
        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </TD>
    <TD class="td1" align="right">
        �������ࣺ
    </TD>
    <TD class="td1">
        <c:set var="hbmc" value="${hbMap[fn:trim(icCard.hbzl)]}"/>
        ${icCard.hbzl} : ${hbmc == null ? "" : hbmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        �������룺
    </TD>
    <TD class="td1">
        ${icCard.yzbm}
    </TD>
    <TD class="td1" align="right">
        ��ϵ�绰��
    </TD>
    <TD class="td1">
        ${icCard.dhhm}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��׼������
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="pzjgmc" value="${pzjgMap[fn:trim(icCard.pzjgdm)]}"/>
        ${icCard.pzjgdm} : ${pzjgmc == null ? "" : pzjgmc}
    </TD>
</TR>


<TR>
    <TD class="td1" align="right">
        ע&nbsp;��&nbsp;�ţ�
    </TD>
    <TD class="td1">
        ${icCard.zch}
    </TD>
    <TD class="td1" align="right">
        �Ƿ񹫿���
    </TD>
    <TD class="td1">
        ${("1" eq icCard.gk)?"��":("2" eq icCard.gk)?"��":""}

    </TD>
</TR>
<TR>
    <TD clas�Ǽ�����gn="right">
        ���ܻ�����
    </TD>
    <td colspan="3">
        <c:set var="zgdmmc" value="${zgjgMap[fn:trim(icCard.zgdm)]}"/>
        ${icCard.zgdm} : ${zgdmmc == null ? "" : zgdmmc}
    </td>
</TR>
<TR>

    <TD class="td1" align="right">
        ��������(2011��)��
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"��":name }
    </TD>
    <td class="td1" align="right">
        ������ҵ(94��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm.jjhy)]}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</TR>
<TR>
    <TD class="td1" align="right">
        �ⷽ����
    </TD>
    <TD class="td1">
        <c:set var="gjmc" value="${gjMap[fn:trim(icCard.wftzgb)]}"/>
        ${icCard.wftzgb} : ${gjmc == null ? "" : gjmc}
    </TD>
    <TD class="td1" align="right">
        EMAIL��
    </TD>
    <TD class="td1">
        ${icCard.email}
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        �����ֻ���
    </TD>
    <TD class="td1">
        ${icCard.mobile}
    </TD>
    <TD class="td1" align="right">
        �� ַ��
    </TD>
    <TD class="td1">
        ${icCard.url}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ������������
    </TD>
    <TD class="td1">
        ${icCard.tbrxm}
    </TD>
    <TD class="td1" align="right">
        ֤�����룺
    </TD>
    <TD class="td1">
        ${icCard.tbrsfzh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        �������ֻ���
    </TD>
    <TD class="td1">
        ${icCard.tbrlxfs}
    </TD>
    <TD class="td1" align="right">
        ��Ӫ���ޣ�
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.gsfzrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ӫ��ַ��
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jydz}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ӫ�ʱࣺ
    </TD>
    <TD class="td1">
        ${icCard.jyyb}
    </TD>
    <TD class="td1" align="right">
        ��Ӫ�绰��
    </TD>
    <TD class="td1">
        ${icCard.jydh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        �������У�
    </TD>
    <TD class="td1">
        ${icCard.khyh}
    </TD>
    <TD class="td1" align="right">
        �����˺ţ�
    </TD>
    <TD class="td1">
        ${icCard.khzh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ������Դ��
    </TD>
    <TD class="td1">
        ${icCard.jfly}
    </TD>
    <td class="td1" align="right">
        �������ô��룺
    </td>
    <td class="td1">
        <c:set var="jgxydm" value="${fn:trim(jgdm.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"��":jgxydm }
    </td>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ҫ��Ʒ1��
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp1)]}"/>
        ${icCard.zycp1} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ҫ��Ʒ2��
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp2)]}"/>
        ${icCard.zycp2} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��Ҫ��Ʒ3��
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp3)]}"/>
        ${icCard.zycp3} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        ��&nbsp;ע��
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.memo2}
    </TD>
</TR>
</body>
</html>
