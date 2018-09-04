<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<style type="text/css">
    table.tableBorder0 td {
        border: #c4dbe5 1px solid;
    }
</style>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<c:set var="nnjghyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjglxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njglxMap" value="<%= InitSysParams.njglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<tr>
    <td class="td1" align="right" width="15%">
        机构代码：
    </td>
    <td class="td1">
        <c:set var="name" value=" ${jgdm.jgdm}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <TD class="td1" align="right" width="15%">
        上次年检
    </TD>
    <TD class="td1">
        <c:if test="${jgdm.njrq ne null}">
            <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"/>
        </c:if>
    </TD>
</tr>
<tr>
    <td class="td1" align="right" width="15%">
        办证机构：
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value=" ${jgdm.bzjgdm}"/>
        ${(name eq '' or name eq null)?"":zrxzqhMap[fn:trim(name)] }
    </td>

</tr>
<tr>
    <td class="td1" align="right">
        机构类型：
    </td>
    <td class="td1">
        <c:set var="name" value="${jglxMap[fn:trim(jgdm.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        新机构类型：
    </td>
    <td class="td1">
        <c:set var="name" value="${njglxMap[jgdm.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        <c:if test="${('1' ne jgdm.fkbz )}">
        暂不发卡&nbsp;&nbsp;</td>
    <td class="td1">
        </c:if>
        <c:if test="${('1' eq jgdm.fkbz)}">
        发卡数量：
    </td>
    <td class="td1">${jgdm.fksl}
        </c:if>
    </td>
    <td class="td1" align="right">&nbsp;正本数量：${jgdm.zbsl eq null?0:jgdm.zbsl}
    </td>
    <td class="td1">
        &nbsp;副本数量： ${jgdm.fbsl eq null?0:jgdm.fbsl}
    </td>
</tr>
<TR>
    <TD class="td1" align="right">
        机构名称：
    </TD>
    <TD class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </TD>
</TR>
<tr>
    <td class="td1" align="right">
        法人代表：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">

        <c:set var="name" value="${zjlxMap[fn:trim(jgdm.zjlx)]}"/>
        ${(name eq '' or name eq null)?"证件":name }：

    </td>
    <td class="td1">
        <c:if test="${name eq '' or name eq null}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(jgdm.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        行政区划：
    </td>
    <td class="td1">
        <c:set var="name" value="${xzqhMap[fn:trim(jgdm.xzqh)]}"/>
        ${jgdm.xzqh }
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        职工人数：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        单位地址：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经营范围：
    </td>
    <c:set var="name" value="${fn:trim(jgdm.jyfw)}"/>
    <td class="td1" colspan="3"
        style="word-break:break-all;word-wrap: break-word;">
        <div style="display: block;word-break:break-all;width: 100%">
            ${(name eq '' or name eq null)?"":name }
        </div>
    </td>
</tr>
<tr>
    <TD class="td1" align="right">
        经济行业(2011版)：
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjghyMap[fn:trim(jgdm.nnjjhy)]}"/>
        ${jgdm.nnjjhy }
        ${(name eq '' or name eq null)?"":name }
    </TD>
    <td class="td1" align="right">
        经济行业(2000版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm.njjhy)]}"/>
        ${jgdm.njjhy }
      ${(name eq '' or name eq null)?"":name }

    </td>

</tr>
<tr>
    <td class="td1" align="right">
        经济类型(2000版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm.njjlx)]}"/>
        ${jgdm.njjlx }
        ${(name eq '' or name eq null)?"":name }


    </td>
    <td class="td1" align="right">
        经济类型(94版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm.jjlx)]}"/>
        ${jgdm.jjlx }
        ${(name eq '' or name eq null)?"":name }
    </td>

</tr>
<tr>
    <td class="td1" align="right">
        成立日期：
    </td>
    <td class="td1">
        <c:set var="date" value="${jgdm.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td class="td1" align="right">
        办证日期：
    </td>
    <td class="td1">
        <c:set var="date" value="${jgdm.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        年检期限：
    </td>
    <td class="td1">
        <c:set var="date" value="${jgdm.njqx}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

    </td>
    <td class="td1" align="right">
        作废日期：
    </td>
    <td class="td1">
        <c:set var="date" value="${jgdm.zfrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>

<tr>
    <td class="td1" align="right">
        注册资金：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>万元
        </c:if>
    </td>
    <td class="td1" align="right">
        货币种类：
    </td>
    <td class="td1">
        <c:set var="name" value="${hbMap[fn:trim(jgdm.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        邮政编码：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        联系电话：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        批准机构：
    </td>
    <td class="td1" colspan="3">${ jgdm.pzjgdm}  ${jgdm.pzjgmc}
        
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        注&nbsp;册&nbsp;号：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        是否公开：
    </td>
    <td class="td1">
        ${("1" eq jgdm.gk or null eq jgdm.gk)?"是":("2" eq jgdm.gk)?"否":""}
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        主管机构：
    </td>
    <td class="td1" colspan="3">
      ${jgdm.zgdm }&nbsp;&nbsp;${jgdm.zgmc }
    </td>
</tr>
<TR>

    <TD class="td1" align="right">
        登记类型：
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.nnjjlx)]}"/>
        ${jgdm.nnjjlx }
        ${(name eq '' or name eq null)?"":name }
    </TD>
    <td class="td1" align="right">
        经济行业(94版)：
    </td>
    <td class="td1">
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm.jjhy)]}"/>
        ${jgdm.jjhy }
        ${(name eq '' or name eq null)?"":name }
    </td>
</TR>

<tr>
    <td class="td1" align="right">
        外方国别：
    </td>
    <td class="td1">
        <c:set var="name" value="${gjMap[fn:trim(jgdm.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        EMAIL：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.email)}"/>
        ${(name eq 'null' or name eq "")?"":name }

    </td>

</tr>

<tr>
    <td class="td1" align="right">
        法人手机：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        网 址：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经办人姓名：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        证件号码：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经办人手机：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        经营期限：
    </td>
    <td class="td1">
        <c:set var="date" value="${jgdm.gsfzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经营地址：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经营邮编：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        经营电话：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        开户银行：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        开户账号：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        经费来源：
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        机构信用代码：
    </td>
    <td class="td1">
        <c:set var="jgxydm" value="${fn:trim(jgdm.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
</tr>

<tr>
    <td class="td1" align="right">
        操作人：
    </td>
    <td class="td1" colspan="3">
        <c:set var="lry" value="${fn:trim(jgdm.lry)}"/>
        ${(lry eq '' or lry eq null)?"":lry }

    </td>
    <%--<td class="td1" align="right">--%>
    <%--证书编号：--%>
    <%--</td>--%>
    <%--<td class="td1">--%>
    <%--<c:set var="zsbh" value="${fn:trim(jgdm.zslsh)}"/>--%>
    <%--${(zsbh eq '' or zsbh eq null)?"":zsbh }--%>
    <%--</td>--%>
</tr>
<tr>
    <td class="td1" align="right">
        主要产品1：
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        主要产品2：
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        主要产品3：
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注1：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注2：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注3：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注4：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注5：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注6：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注7：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr style="display:none;">
    <td class="td1" align="right">
        备&nbsp;注8：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        备&nbsp;注9：
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak5)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>