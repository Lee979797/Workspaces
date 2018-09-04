<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="bgk" type="com.ninemax.jpa.code.model.TBgk"--%>
<%--@elvariable id="bgk2" type="com.ninemax.jpa.code.model.TBgk"--%>
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
    <div align="left" style=" float: left;">��ѯ &gt;&gt; ���ݱ����ʷ��ѯ &gt;&gt; ���ݱ����ʷ��ѯ &gt;&gt; ��ϸ��Ϣ</div>
    <div  style=" float: right;">
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_update_history.action'" type=button
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
<table  cellSpacing=0 cellPadding=5 align=center border=1 width="100%" style="border-collapse: collapse;" bordercolor="#92c8e8">
<tr style="background:#b3e0fa;">
    <td   width="20%">
        ��������
    </td>
    <td  width="40%" >
        <c:set var="name" value=" ${bgk.jgmc}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
    <td  width="40%" align=left>
        <c:set var="name" value=" ${bgk2.jgmc}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</tr>
<tr>
    <td   width="20%" style="background:#ddf1fa;">
        �������룺
    </td>
    <td  width="40%" >
        <c:set var="name" value=" ${bgk.jgdm}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
    <td  width="40%" align=left>
        <c:set var="name" value=" ${bgk2.jgdm}"/>
        ${(name eq '' or name eq null)?"��":name }
    </td>
</tr>
<tr>
    <td  width="20%" style="background:#ddf1fa;">
        ���ʱ�䣺
    </td>
    <td width="40%" >

        <fmt:formatDate value="${bgk.bgsj}" pattern="yyyy-MM-dd"/>
    </td>
    <td width="40%" align=left>
        <fmt:formatDate value="${bgk2.bgsj}" pattern="yyyy-MM-dd"/>
    </td>
</tr>
<tr>
    <td   width="20%" style="background:#ddf1fa;">
        �������ͣ�
    </td>
    <td  width="40%" >
        <c:set var="name" value="${jglxMap[fn:trim(bgk.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td  width="40%" align=left>
        <c:set var="name" value="${jglxMap[fn:trim(bgk2.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  style="background:#ddf1fa;">
        �»������ͣ�
    </td>
    <td  >
        <c:set var="name" value="${njglxMap[bgk.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td  align=left>
        <c:set var="name" value="${njglxMap[bgk2.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td   width="20%">
        ������Ϣ��
    </td>
    <td   width="40%">
        <c:if test="${('0' eq bgk.fkbz or bgk.fkbz eq null)}">
            �ݲ�����&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq bgk.fkbz)}">
            �������� &nbsp;${bgk.fksl}
        </c:if>
    </td>
    <td  align=left width="40%">
        <c:if test="${('0' eq bgk2.fkbz or bgk2.fkbz eq null)}">
            �ݲ�����&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq bgk2.fkbz)}">
            �������� &nbsp;${bgk2.fksl}
        </c:if>
    </td>
</tr>
<tr>
    <td   width="20%">
        ֤����Ϣ��
    </td>
    <td  >����������${bgk.zbsl eq null?0:bgk.zbsl}
        &nbsp;���������� ${bgk.fbsl eq null?0:bgk.fbsl}
    </td>
    <td  align=left>����������${bgk2.zbsl eq null?0:bgk2.zbsl}
        &nbsp;���������� ${bgk2.fbsl eq null?0:bgk2.fbsl}
    </td>
</tr>
<tr>
    <td >
        �������ƣ�
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td align=left>
        <c:set var="name" value="${fn:trim(bgk2.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ���˴���
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td  align=left>
        <c:set var="name" value="${fn:trim(bgk2.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ֤����

    </td>
    <td  >
        <c:set var="name" value="${zjlxMap[fn:trim(bgk.zjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
        <c:if test="${name eq '' or name eq null}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(bgk.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
    </td>
    <td  align=left>
        <c:set var="name" value="${zjlxMap[fn:trim(bgk2.zjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
        <c:if test="${name eq '' or name eq null}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(bgk2.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        ��Ӫ��Χ��
    </td>
    <c:set var="name" value="${fn:trim(bgk.jyfw)}"/>
    <td  
        style="word-break:break-all;word-wrap: break-word;">
        ${(name eq '' or name eq null)?"":name }
    </td>
    <c:set var="name" value="${fn:trim(bgk2.jyfw)}"/>
    <td  align="left"
        style="word-break:break-all;word-wrap: break-word;">
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td  >
        ������ҵ(2000��)��
    </td>
    <td  >
        <c:set var="name" value="${njjhyMap[fn:trim(bgk.njjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td  align="left">
        <c:set var="name" value="${njjhyMap[fn:trim(bgk2.njjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>

<tr>
    <td  >
        ������ҵ(94��)��
    </td>
    <td  >
        <c:set var="name" value="${jjhyMap[fn:trim(bgk.jjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${jjhyMap[fn:trim(bgk2.jjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��������(2000��)��
    </td>
    <td  >
        <c:set var="name" value="${njjlxMap[fn:trim(bgk.njjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${njjlxMap[fn:trim(bgk2.njjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��������(94��)��
    </td>
    <td  >
        <c:set var="name" value="${jjlxMap[fn:trim(bgk.jjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${jjlxMap[fn:trim(bgk2.jjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td  >
        �������ڣ�
    </td>
    <td  >
        <c:set var="date" value="${bgk.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td >
        <c:set var="date" value="${bgk2.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
</tr>

<tr>
    <td  >
        ��֤���ڣ�
    </td>
    <td  >
        <c:set var="date" value="${bgk.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td >
        <c:set var="date" value="${bgk2.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        ������ޣ�
    </td>
    <td  >
        <c:set var="date" value="${bgk.njqx}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td >
        <c:set var="date" value="${bgk2.njqx}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
</tr>
<tr>
    <td  >
        �������ڣ�
    </td>
    <td  >
        <c:set var="date" value="${bgk.zfrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td >
        <c:set var="date" value="${bgk2.zfrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        ����������
    </td>
    <td  >
        <c:set var="name" value="${xzqhMap[fn:trim(bgk.xzqh)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${xzqhMap[fn:trim(bgk2.xzqh)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ְ��������
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��λ��ַ��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ע���ʽ�
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        �������ࣺ
    </td>
    <td  >
        <c:set var="name" value="${hbMap[fn:trim(bgk.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${hbMap[fn:trim(bgk2.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �������룺
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��ϵ�绰��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��׼������
    </td>
    <td  >
        <c:set var="name" value="${pzjgMap[fn:trim(bgk.pzjgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${pzjgMap[fn:trim(bgk2.pzjgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ע&nbsp;��&nbsp;�ţ�
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �Ƿ񹫿���
    </td>
    <td  >
        ${("1" eq bgk.gk or null eq bgk.gk)?"��":("2" eq bgk.gk)?"��":""}
    </td>
    <td >
        ${("1" eq bgk2.gk or null eq bgk2.gk)?"��":("2" eq bgk2.gk)?"��":""}
    </td>
</tr>
<tr>
    <td  >
        ���ܻ�����
    </td>
    <td  >
        <c:set var="name" value="${zgjgMap[fn:trim(bgk.zgdm)]}"/>
        ${(name eq '' or�Ǽ�����ll)?"":name }

    </td>
    <td >
        <c:set var="name" value="${zgjgMap[fn:trim(bgk2.zgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td >
        ������ҵ(2011��)��
    </td>
    <td >
        <c:set var="name" value="${nnjjhyMap[fn:trim(bgk.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${nnjjhyMap[fn:trim(bgk2.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td >
        ��������(2011��)��
    </td>
    <td >
        <c:set var="name" value="${nnjglxMap[fn:trim(bgk.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td>
        <c:set var="name" value="${nnjglxMap[fn:trim(bgk2.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>

<tr>
    <td  >
        �ⷽ����
    </td>
    <td  >
        <c:set var="name" value="${gjMap[fn:trim(bgk.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${gjMap[fn:trim(bgk2.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        EMAIL��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.email)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.email)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �����ֻ���
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �� ַ��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ������������
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ֤�����룺
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �������ֻ���
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��Ӫ���ޣ�
    </td>
    <td  >
        <c:set var="date" value="${bgk.gsfzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
    <td >
        <c:set var="date" value="${bgk2.gsfzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        ��Ӫ��ַ��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��Ӫ�ʱࣺ
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��Ӫ�绰��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �������У�
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        �����˺ţ�
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ������Դ��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        �������ô��룺
    </td>
    <td  >
        <c:set var="jgxydm" value="${fn:trim(bgk.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
    <td >
        <c:set var="jgxydm" value="${fn:trim(bgk2.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
</tr>
<tr>
    <td  >
        ��Ҫ��Ʒ1��
    </td>
    <td  >
        <c:set var="name" value="${zycpMap[fn:trim(bgk.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${zycpMap[fn:trim(bgk2.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��Ҫ��Ʒ2��
    </td>
    <td  >
        <c:set var="name" value="${zycpMap[fn:trim(bgk.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${zycpMap[fn:trim(bgk2.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��Ҫ��Ʒ3��
    </td>
    <td  >
        <c:set var="name" value="${zycpMap[fn:trim(bgk.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td >
        <c:set var="name" value="${zycpMap[fn:trim(bgk2.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע1��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע2��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע3��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע4��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע5��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע6��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע7��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr style="display:none;">
    <td  >
        ��&nbsp;ע8��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td  >
        ��&nbsp;ע9��
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.bak5)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.bak5)}"/>
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
