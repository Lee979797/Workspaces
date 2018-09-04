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
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">查询 &gt;&gt; 数据变更历史查询 &gt;&gt; 数据变更历史查询 &gt;&gt; 详细信息</div>
    <div  style=" float: right;">
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_update_history.action'" type=button
               value="返 回"
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
        机构名称
    </td>
    <td  width="40%" >
        <c:set var="name" value=" ${bgk.jgmc}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
    <td  width="40%" align=left>
        <c:set var="name" value=" ${bgk2.jgmc}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
</tr>
<tr>
    <td   width="20%" style="background:#ddf1fa;">
        机构代码：
    </td>
    <td  width="40%" >
        <c:set var="name" value=" ${bgk.jgdm}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
    <td  width="40%" align=left>
        <c:set var="name" value=" ${bgk2.jgdm}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
</tr>
<tr>
    <td  width="20%" style="background:#ddf1fa;">
        变更时间：
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
        机构类型：
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
        新机构类型：
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
        发卡信息：
    </td>
    <td   width="40%">
        <c:if test="${('0' eq bgk.fkbz or bgk.fkbz eq null)}">
            暂不发卡&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq bgk.fkbz)}">
            发卡数量 &nbsp;${bgk.fksl}
        </c:if>
    </td>
    <td  align=left width="40%">
        <c:if test="${('0' eq bgk2.fkbz or bgk2.fkbz eq null)}">
            暂不发卡&nbsp;&nbsp;
        </c:if>
        <c:if test="${('1' eq bgk2.fkbz)}">
            发卡数量 &nbsp;${bgk2.fksl}
        </c:if>
    </td>
</tr>
<tr>
    <td   width="20%">
        证书信息：
    </td>
    <td  >正本数量：${bgk.zbsl eq null?0:bgk.zbsl}
        &nbsp;副本数量： ${bgk.fbsl eq null?0:bgk.fbsl}
    </td>
    <td  align=left>正本数量：${bgk2.zbsl eq null?0:bgk2.zbsl}
        &nbsp;副本数量： ${bgk2.fbsl eq null?0:bgk2.fbsl}
    </td>
</tr>
<tr>
    <td >
        机构名称：
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
        法人代表：
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
        证件：

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
        经营范围：
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
        经济行业(2000版)：
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
        经济行业(94版)：
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
        经济类型(2000版)：
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
        经济类型(94版)：
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
        成立日期：
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
        办证日期：
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
        年检期限：
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
        作废日期：
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
        行政区划：
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
        职工人数：
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
        单位地址：
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
        注册资金：
    </td>
    <td  >
        <c:set var="name" value="${fn:trim(bgk.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>万元
        </c:if>
    </td>
    <td >
        <c:set var="name" value="${fn:trim(bgk2.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>万元
        </c:if>
    </td>
</tr>
<tr>
    <td  >
        货币种类：
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
        邮政编码：
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
        联系电话：
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
        批准机构：
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
        注&nbsp;册&nbsp;号：
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
        是否公开：
    </td>
    <td  >
        ${("1" eq bgk.gk or null eq bgk.gk)?"是":("2" eq bgk.gk)?"否":""}
    </td>
    <td >
        ${("1" eq bgk2.gk or null eq bgk2.gk)?"是":("2" eq bgk2.gk)?"否":""}
    </td>
</tr>
<tr>
    <td  >
        主管机构：
    </td>
    <td  >
        <c:set var="name" value="${zgjgMap[fn:trim(bgk.zgdm)]}"/>
        ${(name eq '' or登记类型ll)?"":name }

    </td>
    <td >
        <c:set var="name" value="${zgjgMap[fn:trim(bgk2.zgdm)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td >
        经济行业(2011版)：
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
        经济类型(2011版)：
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
        外方国别：
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
        EMAIL：
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
        法人手机：
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
        网 址：
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
        经办人姓名：
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
        证件号码：
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
        经办人手机：
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
        经营期限：
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
        经营地址：
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
        经营邮编：
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
        经营电话：
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
        开户银行：
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
        开户账号：
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
        经费来源：
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
        机构信用代码：
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
        主要产品1：
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
        主要产品2：
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
        主要产品3：
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
        备&nbsp;注1：
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
        备&nbsp;注2：
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
        备&nbsp;注3：
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
        备&nbsp;注4：
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
        备&nbsp;注5：
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
        备&nbsp;注6：
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
        备&nbsp;注7：
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
        备&nbsp;注8：
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
        备&nbsp;注9：
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
    <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_update_history.action'" type=button value="返 回">
</div>
</div>
</div>
</div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
