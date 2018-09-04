<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="jgdm2" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
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
<c:set var="njglxMap" value="<%= InitSysParams.njglxMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">��ѯ &gt;&gt; ������ѯ &gt;&gt; ���˲��� &gt;&gt; ���˻�����Ϣ�Ա�</div>
    <div style=" float: right;">
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_list_frs.action'" type=button
               value="�� ��"
               name='cmdExit'>
        &nbsp;
    </div>
</div>
<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue" style="border:none; background:none;">
<table cellSpacing=0 cellPadding=5 align=center border=1 width="100%" style="border-collapse: collapse;"
       bordercolor="#92c8e8">
<tr style="background:#b3e0fa;">
    <td width="20%">
        ��������
    </td>
    <td width="40%">
        <c:set var="name" value=" ${jgdm.jgmc}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
    <td width="40%" align=left>
        <c:set var="name" value=" ${jgdm2.jgmc}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</tr>
<tr>
    <td width="20%" style="background:#ddf1fa;">
        �������룺
    </td>
    <td width="40%">
        <c:set var="name" value=" ${jgdm.jgdm}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
    <td width="40%" align=left>
        <c:set var="name" value=" ${jgdm2.jgdm}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</tr>
<tr>
    <td width="20%" style="background:#ddf1fa;">
        �����ʱ�䣺
    </td>
    <td width="40%">

        <fmt:formatDate value="${jgdm.lastdate}" pattern="yyyy-MM-dd"/>
    </td>
    <td width="40%" align=left>
        <fmt:formatDate value="${jgdm2.lastdate}" pattern="yyyy-MM-dd"/>
    </td>
</tr>
<tr>
    <td width="20%" style="background:#ddf1fa;">
        �������ͣ�
    </td>
    <td width="40%">
        <c:set var="name" value="${jglxMap[fn:trim(jgdm.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td width="40%" align=left>
        <c:set var="name" value="${jglxMap[fn:trim(jgdm2.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td style="background:#ddf1fa;">
        �»������ͣ�
    </td>
    <td>
        <c:set var="name" value="${njglxMap[jgdm.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td align=left>
        <c:set var="name" value="${njglxMap[jgdm2.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td width="20%">
        ������Ϣ��
    </td>
    <td width="40%">
        <c:if test="${('0' eq jgdm.fkbz or jgdm.fkbz eq null)}">
            �ݲ�����&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq jgdm.fkbz)}">
            �������� &nbsp;${jgdm.fksl}
        </c:if>
    </td>
    <td align=left width="40%">
        <c:if test="${('0' eq jgdm2.fkbz or jgdm2.fkbz eq null)}">
            �ݲ�����&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq jgdm2.fkbz)}">
            �������� &nbsp;${jgdm2.fksl}
        </c:if>
    </td>
</tr>
<tr>
    <td width="20%">
        ֤����Ϣ��
    </td>
    <td>����������${jgdm.zbsl eq null?0:jgdm.zbsl}
        &nbsp;���������� ${jgdm.fbsl eq null?0:jgdm.fbsl}
    </td>
    <td align=left>����������${jgdm2.zbsl eq null?0:jgdm2.zbsl}
        &nbsp;���������� ${jgdm2.fbsl eq null?0:jgdm2.fbsl}
    </td>
</tr>
<tr>
    <td>
        �������ƣ�
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td align=left>
        <c:set var="name" value="${fn:trim(jgdm2.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ���˴���
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td align=left>
        <c:set var="name" value="${fn:trim(jgdm2.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ֤����

    </td>
    <td>
        <c:set var="name" value="${zjlxMap[fn:trim(jgdm.zjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
        <c:if test="${name eq '' or name eq null}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(jgdm.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
    </td>
    <td align=left>
        <c:set var="name" value="${zjlxMap[fn:trim(jgdm2.zjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
        <c:if test="${name eq '' or name eq null}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(jgdm2.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
    </td>
</tr>
<tr>
    <td>
        ��Ӫ��Χ��
    </td>
    <c:set var="name" value="${fn:trim(jgdm.jyfw)}"/>
    <td
            style="word-break:break-all;word-wrap: break-word;">
        ${(name eq '' or name eq null)?"":name }
    </td>
    <c:set var="name" value="${fn:trim(jgdm2.jyfw)}"/>
    <td align="left"
        style="word-break:break-all;word-wrap: break-word;">
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td>
        ������ҵ(2000��)��
    </td>
    <td>
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm.njjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td align="left">
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm2.njjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>

<tr>
    <td>
        ������ҵ(94��)��
    </td>
    <td>
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm.jjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm2.jjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��������(2000��)��
    </td>
    <td>
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm.njjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm2.njjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��������(94��)��
    </td>
    <td>
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm.jjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm2.jjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td>
        �������ڣ�
    </td>
    <td>
        <c:set var="date" value="${jgdm.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td>
        <c:set var="date" value="${jgdm2.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
</tr>

<tr>
    <td>
        ��֤���ڣ�
    </td>
    <td>
        <c:set var="date" value="${jgdm.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td>
        <c:set var="date" value="${jgdm2.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td>
        ������ޣ�
    </td>
    <td>
        <c:set var="date" value="${jgdm.njqx}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td>
        <c:set var="date" value="${jgdm2.njqx}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
</tr>
<tr>
    <td>
        �������ڣ�
    </td>
    <td>
        <c:set var="date" value="${jgdm.zfrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td>
        <c:set var="date" value="${jgdm2.zfrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td>
        ����������
    </td>
    <td>
        <c:set var="name" value="${xzqhMap[fn:trim(jgdm.xzqh)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${xzqhMap[fn:trim(jgdm2.xzqh)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ְ��������
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��λ��ַ��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ע���ʽ�
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </td>
</tr>
<tr>
    <td>
        �������ࣺ
    </td>
    <td>
        <c:set var="name" value="${hbMap[fn:trim(jgdm.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${hbMap[fn:trim(jgdm2.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �������룺
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��ϵ�绰��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��׼������
    </td>
    <td>
        <c:set var="name" value="${pzjgMap[fn:trim(jgdm.pzjgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${pzjgMap[fn:trim(jgdm2.pzjgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ע&nbsp;��&nbsp;�ţ�
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �Ƿ񹫿���
    </td>
    <td>
        ${("1" eq jgdm.gk or null eq jgdm.gk)?"��":("2" eq jgdm.gk)?"��":""}
    </td>
    <td>
        ${("1" eq jgdm2.gk or null eq jgdm2.gk)?"��":("2" eq jgdm2.gk)?"��":""}
    </td>
</tr>
<tr>
    <td>
        ���ܻ�����
    </td>
    <td>
        <c:set var="name" value="${zgjgMap[fn:trim(jgdm.zgdm)]}"/>
        ${(name eq '' �Ǽ�����null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${zgjgMap[fn:trim(jgdm2.zgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ������ҵ(2011��)��
    </td>
    <td>
        <c:set var="name" value="${nnjjhyMap[fn:trim(jgdm.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${nnjjhyMap[fn:trim(jgdm2.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��������(2011��)��
    </td>
    <td>
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm2.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td>
        �ⷽ����
    </td>
    <td>
        <c:set var="name" value="${gjMap[fn:trim(jgdm.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${gjMap[fn:trim(jgdm2.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        EMAIL��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.email)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.email)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �����ֻ���
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �� ַ��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ������������
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ֤�����룺
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �������ֻ���
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��Ӫ���ޣ�
    </td>
    <td>
        <c:set var="date" value="${jgdm.gsfzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td>
        <c:set var="date" value="${jgdm2.gsfzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td>
        ��Ӫ��ַ��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��Ӫ�ʱࣺ
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��Ӫ�绰��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �������У�
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        �����˺ţ�
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ������Դ��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        �������ô��룺
    </td>
    <td>
        <c:set var="jgxydm" value="${fn:trim(jgdm.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
    <td>
        <c:set var="jgxydm" value="${fn:trim(jgdm2.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
</tr>
<tr>
    <td>
        ��Ҫ��Ʒ1��
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm2.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��Ҫ��Ʒ2��
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm2.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��Ҫ��Ʒ3��
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${zycpMap[fn:trim(jgdm2.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע1��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע2��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע3��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע4��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע5��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע6��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע7��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr style="display:none;">
    <td>
        ��&nbsp;ע8��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td>
        ��&nbsp;ע9��
    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm.bak5)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td>
        <c:set var="name" value="${fn:trim(jgdm2.bak5)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
</table>
</div>
<div class="listbtn">
    <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_update_history.action'" type=button value="�� ��">
</div>
</div>
</div>
</div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
