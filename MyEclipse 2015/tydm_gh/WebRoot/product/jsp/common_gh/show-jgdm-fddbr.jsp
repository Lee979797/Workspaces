<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
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


<tr>
	<td colspan=4 class=td1 align=center>
		法定代表人情况
	</td>
	
</tr>
<tr>
	<td class=td1 align=right>
		法定代表人：
	</td>
	<td class=td1>
		${fddbr.xm }
	</td>
	<td class=td1 align=right>
		性别：
	</td>
	<td class=td1 >
		${fddbr.xb }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		民族：
	</td>
	<td class=td1>
		<c:forEach items="${mList}" var="mz">
		<c:if test="${fn:trim(mz.dm) == fn:trim(fddbr.mz)}">
		${mz.mc }
		</c:if>
	   	</c:forEach>
	</td>
	<%-- <td class=td1 align=right>
		出生年月：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${fddbr.csrq }" pattern="yyyy-MM-dd"/>
	</td> --%>
</tr>
<tr>
	<td class=td1 align=right>
		文化程度：
	</td>
	<td class=td1>
		${fddbr.xl }
	</td>
	<td class=td1 align=right>
		政治面貌：
	</td>
	<td class=td1 >
	 <c:forEach items="${zzList}" var="zz">
	<c:if test="${zz.dm eq fddbr.zzmm}">
	${zz.mc }
	</c:if>
   	</c:forEach>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		手机号码：
	</td>
	<td class=td1>
		${fddbr.lxmobile }
	</td>
	<td class=td1 align=right>
		法定代表人座机：
	</td>
	<td class=td1 >
		${fddbr.lxdh }
	</td>
</tr>
<tr>
	<td  colspan=1 class=td1 align=right>
		通讯地址：
	</td>
	<td colspan=3 class=td1>
		${fddbr.txdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		邮编：
	</td>
	<td class=td1>
		${fddbr.yb }
	</td>
	<td class=td1 align=right>
		电子邮箱：
	</td>
	<td class=td1 >
		${fddbr.email }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		现任工会职务：
	</td>
	<td class=td1>
		${fddbr.zw }
	</td>
	<td class=td1 align=right>
		属专职属兼职：
	</td>
	<td class=td1 >
		${fddbr.iszz eq 0 ?'全职':'兼职'}
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		本届任职起始时间：
	</td>
	<td class=td1>
	<fmt:formatDate value="${fddbr.rzsj }" pattern="yyyy-MM-dd"/>
	</td>
	<%-- <td class=td1 align=right>
		何时加入工会组织：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${fddbr.rhsj }" pattern="yyyy-MM-dd"/>
	</td> --%>
</tr>
<tr>
	<td class=td1 align=right>
		现任其他职务：
	</td>
	<td class=td1>
		${fddbr.qtzw }
	</td>
	<td class=td1 align=right>
		身份证号码：
	</td>
	<td class=td1 >
		${fddbr.zjhm }
	</td>
</tr>





