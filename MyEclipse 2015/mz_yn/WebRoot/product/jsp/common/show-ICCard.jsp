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
    <title>选择办证机构</title>
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
        机构代码：
    </TD>
    <TD class="td1" >
        ${icCard.jgdm}
    </TD>
    <TD class="td1" align="right" width="15%">
        ${jgdm.njrq ne null ?'上次年检：':''}
    </TD>
    <TD class="td1" >
        <c:if test="${jgdm.njrq ne null}">
            <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"></fmt:formatDate>
        </c:if>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        机构类型：
    </TD>
    <TD class="td1">
        ${icCard.jglx}:${jglxMap[fn:trim(icCard.jglx)]}
    </TD>
    <td class="td1" align="right">
        新机构类型：
    </td>
    <td class="td1">
        <c:forEach var="jglx" items="${njglxList}">
            <c:if test="${(fn:trim(jglx.dm) eq fn:trim(jgdm.jglx))}">${jglx.mc}</c:if>
        </c:forEach>
    </td>
</TR>
<TR>
    <TD class="td1" colSpan="2">&nbsp;${("0" eq icCard.fkbz)?"暂不发卡":("0" eq icCard.fkbz)?("发卡&nbsp;发卡数量："+icCard.fksl):""}</TD>
    <TD class="td1" colSpan="2">
        &nbsp;正本数量： ${icCard.zbsl eq null?0:icCard.zbsl}&nbsp;副本数量： ${icCard.fbsl eq null?0:icCard.fbsl}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        机构名称：
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jgmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        法人代表：
    </TD>
    <TD class="td1">
        ${icCard.fddbr}
    </TD>
    <TD class="td1" align="right">
        ${zjlxMap[fn:trim(icCard.zjlx)]}：
    </TD>
    <TD class="td1">&nbsp;${icCard.zjhm}:(${fn:length(icCard.zjhm)}位)


    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营范围：
    </TD>
    <TD class="td1" colSpan="3">${fn:trim(icCard.jyfw)}</TD>
</TR>

<tr>
    <TD class="td1" align="right">
        经济行业(2011版)：
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjghyMap[fn:trim(jgdm.nnjjhy)]}"/>
        ${(name eq '' or name eq null)?"无":name }
    </TD>
    <td class="td1" align="right">
        经济行业(2000版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm.njjhy)]}"/>
        ${(name eq '' or name eq null)?"无":name }

    </td>


</tr>
<tr>
    <td class="td1" align="right">
        经济类型(2000版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm.njjlx)]}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
    <td class="td1" align="right">
        经济类型(94版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm.jjlx)]}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
</tr>

<TR>
    <TD class="td1" align="right">
        成立日期：
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.zcrq}" pattern="yyyy-MM-dd"/>
    </TD>
    <TD class="td1" align="right">
        办证日期：
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.bzrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        年检期限：
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.njqx}" pattern="yyyy-MM-dd"/>

    </TD>
    <TD class="td1" align="right">
        作废日期：
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.zfrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        行政区划：
    </TD>
    <TD class="td1">
        <c:set var="xzqhmc" value="${xzqhMap[fn:trim(icCard.xzqh)]}"/>
        ${icCard.xzqh} : ${xzqhmc == null ? "" : xzqhmc}
    </TD>
    <TD class="td1" align="right">
        职工人数：
    </TD>
    <TD class="td1">
        ${icCard.zgrs}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        单位地址：
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jgdz}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        注册资金：
    </TD>
    <TD class="td1">
        <c:set var="name" value="${fn:trim(icCard.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">
            无
        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>万元
        </c:if>
    </TD>
    <TD class="td1" align="right">
        货币种类：
    </TD>
    <TD class="td1">
        <c:set var="hbmc" value="${hbMap[fn:trim(icCard.hbzl)]}"/>
        ${icCard.hbzl} : ${hbmc == null ? "" : hbmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        邮政编码：
    </TD>
    <TD class="td1">
        ${icCard.yzbm}
    </TD>
    <TD class="td1" align="right">
        联系电话：
    </TD>
    <TD class="td1">
        ${icCard.dhhm}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        批准机构：
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="pzjgmc" value="${pzjgMap[fn:trim(icCard.pzjgdm)]}"/>
        ${icCard.pzjgdm} : ${pzjgmc == null ? "" : pzjgmc}
    </TD>
</TR>


<TR>
    <TD class="td1" align="right">
        注&nbsp;册&nbsp;号：
    </TD>
    <TD class="td1">
        ${icCard.zch}
    </TD>
    <TD class="td1" align="right">
        是否公开：
    </TD>
    <TD class="td1">
        ${("1" eq icCard.gk)?"是":("2" eq icCard.gk)?"否":""}

    </TD>
</TR>
<TR>
    <TD clas登记类型gn="right">
        主管机构：
    </TD>
    <td colspan="3">
        <c:set var="zgdmmc" value="${zgjgMap[fn:trim(icCard.zgdm)]}"/>
        ${icCard.zgdm} : ${zgdmmc == null ? "" : zgdmmc}
    </td>
</TR>
<TR>

    <TD class="td1" align="right">
        经济类型(2011版)：
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.nnjjlx)]}"/>
        ${(name eq '' or name eq null)?"无":name }
    </TD>
    <td class="td1" align="right">
        经济行业(94版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm.jjhy)]}"/>
        ${(name eq '' or name eq null)?"无":name }
    </td>
</TR>
<TR>
    <TD class="td1" align="right">
        外方国别：
    </TD>
    <TD class="td1">
        <c:set var="gjmc" value="${gjMap[fn:trim(icCard.wftzgb)]}"/>
        ${icCard.wftzgb} : ${gjmc == null ? "" : gjmc}
    </TD>
    <TD class="td1" align="right">
        EMAIL：
    </TD>
    <TD class="td1">
        ${icCard.email}
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        法人手机：
    </TD>
    <TD class="td1">
        ${icCard.mobile}
    </TD>
    <TD class="td1" align="right">
        网 址：
    </TD>
    <TD class="td1">
        ${icCard.url}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经办人姓名：
    </TD>
    <TD class="td1">
        ${icCard.tbrxm}
    </TD>
    <TD class="td1" align="right">
        证件号码：
    </TD>
    <TD class="td1">
        ${icCard.tbrsfzh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经办人手机：
    </TD>
    <TD class="td1">
        ${icCard.tbrlxfs}
    </TD>
    <TD class="td1" align="right">
        经营期限：
    </TD>
    <TD class="td1">
        <fmt:formatDate value="${icCard.gsfzrq}" pattern="yyyy-MM-dd"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营地址：
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.jydz}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营邮编：
    </TD>
    <TD class="td1">
        ${icCard.jyyb}
    </TD>
    <TD class="td1" align="right">
        经营电话：
    </TD>
    <TD class="td1">
        ${icCard.jydh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        开户银行：
    </TD>
    <TD class="td1">
        ${icCard.khyh}
    </TD>
    <TD class="td1" align="right">
        开户账号：
    </TD>
    <TD class="td1">
        ${icCard.khzh}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经费来源：
    </TD>
    <TD class="td1">
        ${icCard.jfly}
    </TD>
    <td class="td1" align="right">
        机构信用代码：
    </td>
    <td class="td1">
        <c:set var="jgxydm" value="${fn:trim(jgdm.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"无":jgxydm }
    </td>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品1：
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp1)]}"/>
        ${icCard.zycp1} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品2：
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp2)]}"/>
        ${icCard.zycp2} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品3：
    </TD>
    <TD class="td1" colspan="3">
        <c:set var="zycpmc" value="${zycpMap[fn:trim(icCard.zycp3)]}"/>
        ${icCard.zycp3} : ${zycpmc == null ? "" : zycpmc}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注：
    </TD>
    <TD class="td1" colSpan="3">
        ${icCard.memo2}
    </TD>
</TR>
</body>
</html>
