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
        �������룺
    </td>
    <td class="td1">
        <c:set var="name" value=" ${jgdm.jgdm}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <TD class="td1" align="right" width="15%">
        �ϴ����
    </TD>
    <TD class="td1">
        <c:if test="${jgdm.njrq ne null}">
            <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"/>
        </c:if>
    </TD>
</tr>
<tr>
    <td class="td1" align="right" width="15%">
        ��֤������
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value=" ${jgdm.bzjgdm}"/>
        ${(name eq '' or name eq null)?"":zrxzqhMap[fn:trim(name)] }
    </td>

</tr>
<tr>
    <td class="td1" align="right">
        �������ͣ�
    </td>
    <td class="td1">
        <c:set var="name" value="${jglxMap[fn:trim(jgdm.jglx)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        �»������ͣ�
    </td>
    <td class="td1">
        <c:set var="name" value="${njglxMap[jgdm.njglx]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        <c:if test="${('1' ne jgdm.fkbz )}">
        �ݲ�����&nbsp;&nbsp;</td>
    <td class="td1">
        </c:if>
        <c:if test="${('1' eq jgdm.fkbz)}">
        ����������
    </td>
    <td class="td1">${jgdm.fksl}
        </c:if>
    </td>
    <td class="td1" align="right">&nbsp;����������${jgdm.zbsl eq null?0:jgdm.zbsl}
    </td>
    <td class="td1">
        &nbsp;���������� ${jgdm.fbsl eq null?0:jgdm.fbsl}
    </td>
</tr>
<TR>
    <TD class="td1" align="right">
        �������ƣ�
    </TD>
    <TD class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jgmc)}"/>
        ${(name eq '' or name eq null)?"":name }
    </TD>
</TR>
<tr>
    <td class="td1" align="right">
        ���˴���
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">

        <c:set var="name" value="${zjlxMap[fn:trim(jgdm.zjlx)]}"/>
        ${(name eq '' or name eq null)?"֤��":name }��

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
        ����������
    </td>
    <td class="td1">
        <c:set var="name" value="${xzqhMap[fn:trim(jgdm.xzqh)]}"/>
        ${jgdm.xzqh }
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        ְ��������
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zgrs)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��λ��ַ��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��Ӫ��Χ��
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
        ������ҵ(2011��)��
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjghyMap[fn:trim(jgdm.nnjjhy)]}"/>
        ${jgdm.nnjjhy }
        ${(name eq '' or name eq null)?"":name }
    </TD>
    <td class="td1" align="right">
        ������ҵ(2000��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${njjhyMap[fn:trim(jgdm.njjhy)]}"/>
        ${jgdm.njjhy }
      ${(name eq '' or name eq null)?"":name }

    </td>

</tr>
<tr>
    <td class="td1" align="right">
        ��������(2000��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${njjlxMap[fn:trim(jgdm.njjlx)]}"/>
        ${jgdm.njjlx }
        ${(name eq '' or name eq null)?"":name }


    </td>
    <td class="td1" align="right">
        ��������(94��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${jjlxMap[fn:trim(jgdm.jjlx)]}"/>
        ${jgdm.jjlx }
        ${(name eq '' or name eq null)?"":name }
    </td>

</tr>
<tr>
    <td class="td1" align="right">
        �������ڣ�
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
        ��֤���ڣ�
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
        ������ޣ�
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
        �������ڣ�
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
        ע���ʽ�
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zczj)}"/>
        <c:if test="${(name eq '' or name eq null)}">

        </c:if>
        <c:if test="${!(name eq '' or name eq null)}">
            <fmt:formatNumber value='${name}' pattern="##.####"/>��Ԫ
        </c:if>
    </td>
    <td class="td1" align="right">
        �������ࣺ
    </td>
    <td class="td1">
        <c:set var="name" value="${hbMap[fn:trim(jgdm.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        �������룺
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.yzbm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        ��ϵ�绰��
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.dhhm)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��׼������
    </td>
    <td class="td1" colspan="3">${ jgdm.pzjgdm}  ${jgdm.pzjgmc}
        
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ע&nbsp;��&nbsp;�ţ�
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.zch)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        �Ƿ񹫿���
    </td>
    <td class="td1">
        ${("1" eq jgdm.gk or null eq jgdm.gk)?"��":("2" eq jgdm.gk)?"��":""}
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ���ܻ�����
    </td>
    <td class="td1" colspan="3">
      ${jgdm.zgdm }&nbsp;&nbsp;${jgdm.zgmc }
    </td>
</tr>
<TR>

    <TD class="td1" align="right">
        �Ǽ����ͣ�
    </TD>
    <TD class="td1">
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.nnjjlx)]}"/>
        ${jgdm.nnjjlx }
        ${(name eq '' or name eq null)?"":name }
    </TD>
    <td class="td1" align="right">
        ������ҵ(94��)��
    </td>
    <td class="td1">
        <c:set var="name" value="${jjhyMap[fn:trim(jgdm.jjhy)]}"/>
        ${jgdm.jjhy }
        ${(name eq '' or name eq null)?"":name }
    </td>
</TR>

<tr>
    <td class="td1" align="right">
        �ⷽ����
    </td>
    <td class="td1">
        <c:set var="name" value="${gjMap[fn:trim(jgdm.wftzgb)]}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        EMAIL��
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.email)}"/>
        ${(name eq 'null' or name eq "")?"":name }

    </td>

</tr>

<tr>
    <td class="td1" align="right">
        �����ֻ���
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.mobile)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        �� ַ��
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.url)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ������������
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrxm)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        ֤�����룺
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrsfzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        �������ֻ���
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.tbrlxfs)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        ��Ӫ���ޣ�
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
        ��Ӫ��ַ��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.jydz)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��Ӫ�ʱࣺ
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jyyb)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        ��Ӫ�绰��
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jydh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        �������У�
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.khyh)}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
    <td class="td1" align="right">
        �����˺ţ�
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.khzh)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ������Դ��
    </td>
    <td class="td1">
        <c:set var="name" value="${fn:trim(jgdm.jfly)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
    <td class="td1" align="right">
        �������ô��룺
    </td>
    <td class="td1">
        <c:set var="jgxydm" value="${fn:trim(jgdm.jgxydm)}"/>
        ${(jgxydm eq '' or jgxydm eq null)?"":jgxydm }
    </td>
</tr>

<tr>
    <td class="td1" align="right">
        �����ˣ�
    </td>
    <td class="td1" colspan="3">
        <c:set var="lry" value="${fn:trim(jgdm.lry)}"/>
        ${(lry eq '' or lry eq null)?"":lry }

    </td>
    <%--<td class="td1" align="right">--%>
    <%--֤���ţ�--%>
    <%--</td>--%>
    <%--<td class="td1">--%>
    <%--<c:set var="zsbh" value="${fn:trim(jgdm.zslsh)}"/>--%>
    <%--${(zsbh eq '' or zsbh eq null)?"":zsbh }--%>
    <%--</td>--%>
</tr>
<tr>
    <td class="td1" align="right">
        ��Ҫ��Ʒ1��
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp1)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��Ҫ��Ʒ2��
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp2)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��Ҫ��Ʒ3��
    </td>
    <td class="td1" colspan="3">
        <c:set var="name" value="${zycpMap[fn:trim(jgdm.zycp3)]}"/>
        ${(name eq '' or name eq null)?"":name }
    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע1��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע2��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע3��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע4��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.memo4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע5��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak1)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע6��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak2)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע7��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak3)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr style="display:none;">
    <td class="td1" align="right">
        ��&nbsp;ע8��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak4)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>
<tr>
    <td class="td1" align="right">
        ��&nbsp;ע9��
    </td>
    <td class="td1" colSpan="3">
        <c:set var="name" value="${fn:trim(jgdm.bak5)}"/>
        ${(name eq '' or name eq null)?"":name }

    </td>
</tr>