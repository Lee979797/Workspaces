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
		�������������
	</td>
	
</tr>
<tr>
	<td class=td1 align=right>
		���������ˣ�
	</td>
	<td class=td1>
		${fddbr.xm }
	</td>
	<td class=td1 align=right>
		�Ա�
	</td>
	<td class=td1 >
		${fddbr.xb }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		���壺
	</td>
	<td class=td1>
		<c:forEach items="${mList}" var="mz">
		<c:if test="${fn:trim(mz.dm) == fn:trim(fddbr.mz)}">
		${mz.mc }
		</c:if>
	   	</c:forEach>
	</td>
	<%-- <td class=td1 align=right>
		�������£�
	</td>
	<td class=td1 >
	<fmt:formatDate value="${fddbr.csrq }" pattern="yyyy-MM-dd"/>
	</td> --%>
</tr>
<tr>
	<td class=td1 align=right>
		�Ļ��̶ȣ�
	</td>
	<td class=td1>
		${fddbr.xl }
	</td>
	<td class=td1 align=right>
		������ò��
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
		�ֻ����룺
	</td>
	<td class=td1>
		${fddbr.lxmobile }
	</td>
	<td class=td1 align=right>
		����������������
	</td>
	<td class=td1 >
		${fddbr.lxdh }
	</td>
</tr>
<tr>
	<td  colspan=1 class=td1 align=right>
		ͨѶ��ַ��
	</td>
	<td colspan=3 class=td1>
		${fddbr.txdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�ʱࣺ
	</td>
	<td class=td1>
		${fddbr.yb }
	</td>
	<td class=td1 align=right>
		�������䣺
	</td>
	<td class=td1 >
		${fddbr.email }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		���ι���ְ��
	</td>
	<td class=td1>
		${fddbr.zw }
	</td>
	<td class=td1 align=right>
		��רְ����ְ��
	</td>
	<td class=td1 >
		${fddbr.iszz eq 0 ?'ȫְ':'��ְ'}
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		������ְ��ʼʱ�䣺
	</td>
	<td class=td1>
	<fmt:formatDate value="${fddbr.rzsj }" pattern="yyyy-MM-dd"/>
	</td>
	<%-- <td class=td1 align=right>
		��ʱ���빤����֯��
	</td>
	<td class=td1 >
	<fmt:formatDate value="${fddbr.rhsj }" pattern="yyyy-MM-dd"/>
	</td> --%>
</tr>
<tr>
	<td class=td1 align=right>
		��������ְ��
	</td>
	<td class=td1>
		${fddbr.qtzw }
	</td>
	<td class=td1 align=right>
		���֤���룺
	</td>
	<td class=td1 >
		${fddbr.zjhm }
	</td>
</tr>





