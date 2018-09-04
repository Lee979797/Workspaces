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
<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>

<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMap%>"/>



<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>


<tr>
	<td colspan=1 align="right">
		ͳһ������ô��룺
	</td>
	<td colspan=3 align="left">
		${jgdm.tyshxydm }
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		�������ƣ�
	</td>
	<td colspan=3 align="left">
		${jgdm.jgmc }
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		ס����ַ��
	</td>
	<td colspan=3 align="left">
		${jgdm.jgdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		ס������������
	</td>
	<td class=td1>
		${jgdm.xzqh }
	</td>
	<td class=td1 align=right>
		ס���������� ��
	</td>
	<td class=td1 >
		${jgdm.yzbm }
	</td>
</tr>

<tr>
	<td colspan=1 align="right">
		�칫��ַ��
	</td>
	<td colspan=3 align="left">
		${jgdm.bgjgdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�칫����������
	</td>
	<td class=td1>
		${jgdm.bgxzqh }
	</td>
	<td class=td1 align=right>
		�칫�������� ��
	</td>
	<td class=td1 >
		${jgdm.bgyzbm }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������ڣ�
	</td>
	<td class=td1>
	<fmt:formatDate value="${jgdm.zcrq }" pattern="yyyy-MM-dd"/>
	</td>
	<td class=td1 align=right>
		��׼���� ��
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.bzrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������˵�λ��
	</td>
	<td class=td1>
		${jgdm.zgmc }
	</td>
	<td class=td1 align=right>
		�������˵�λ���� ��
	</td>
	<td class=td1 >
		${jgdm.zgdm }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������������ĺţ�
	</td>
	<td class=td1>
		${jgdm.jlwh }
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.jlrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		����ѡ�ٽ���ĺţ�
	</td>
	<td class=td1>
		${jgdm.xjwh }
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.xjrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		��Ч����
	</td>
	<td class=td1>
	<fmt:formatDate value="${jgdm.yxqxs }" pattern="yyyy-MM-dd"/>
	</td>
	<td class=td1 align=right>
		��Ч���� ��
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.yxqxe }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�����绰��
	</td>
	<td class=td1>
		${jgdm.dhhm }
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		${jgdm.jglx =="1"?"���㹤��":"����"}
	</td>
</tr>
<tr/>
	<td colspan=1 align="right">
		��ַ ��
	</td>
	<td colspan=3 align="left">
		${jgdm.url ==null?"": jgdm.url}
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		������������
	</td>
	<td class=td1>
		${jgdm.tbrxm }
	</td>
	<td class=td1 align=right>
		${jgdm.tbrzjlx eq "0"?"���֤":"����"}��
	</td>
	<td class=td1 >
		${jgdm.tbrsfzh }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������ֻ���
	</td>
	<td class=td1>
		${jgdm.tbrmobile }
	</td>
	<td class=td1 align=right>
		������������
	</td>
	<td class=td1 >
		${jgdm.tbrlxfs }
	</td>
</tr>
<tr>
	<td colspan=1 class=td1 align=right>
		��ע��
	</td>
	<td colspan=3 class=td1>
		${jgdm.memo }
	</td>
</tr> 
<tr>
	<td colspan=1 align="right">
		��֤���أ�
	</td>
	<td colspan=3 align="left">
		${jgdm.pzjgmc }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		ְ������(��)��
	</td>
	<td class=td1>
		${jgdm.zgrs }
	</td>
	<td class=td1 align=right>
		��Ա���� ��
	</td>
	<td class=td1 >
		${jgdm.hyrs }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		������ϯ������
	</td>
	<td class=td1>
		${jgdm.ghzxmc }
	</td>
	<td class=td1 align=right>
		�������(��Ԫ)��
	</td>
	<td class=td1 >
		${jgdm.qtsr }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�̶��ʽ�(��Ԫ)��
	</td>
	<td class=td1>
		${jgdm.gdzj }
	</td>
	<td class=td1 align=right>
		���������
	</td>
	<td class=td1 >
		${jgdm.cshj }
	</td>
</tr>

	<%-- <td  class=td1 align=right>
		�ܷ�����е��������Σ�
	</td>
	<td  class=td1>
		${jgdm.cdnl eq 0?'��':'��' }
	</td>
 --%>

<!--  <tr>
	<td class=td1 align=right>
		ע���ʽ�
	</td>
	<td class=td1>
		${jgdm.zczj }
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		${jgdm.hbzl }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������䣺
	</td>
	<td class=td1>
		${jgdm.email }
	</td>
	<td class=td1 align=right>
		��ַ ��
	</td>
	<td class=td1 >
		${jgdm.url }
	</td>
</tr>
-->
<%-- <tr>
	<td class=td1 align=right>
		רְ����ɲ�����
	</td>
	<td class=td1>
		${jgdm.ghjs }
	</td>
	<td class=td1 align=right>
		������� ��
	</td>
	<td class=td1 >
		${jgdm.ghjs }
	</td>
</tr> --%>

<!-- 	<td class=td1 align=right>
		�绰 ��
	</td> 
	<td class=td1 >
		${jgdm.ghzxdh }
	</td>-->

<%-- <tr>
	<td class=td1 align=right>
		��������ۼ�(��Ԫ)��
	</td>
	<td class=td1>
		${jgdm.snjylj }
	</td>
	<td class=td1 align=right>
		���Ա���ɻ������(��Ԫ)��
	</td>
	<td class=td1 >
		${jgdm.hhsr }
	</td>
</tr> --%>
 
	<%-- <td class=td1 align=right>
		��2���������ᾭ�ѱ�����������(��Ԫ)��
	</td>
	<td class=td1>
		${jgdm.lcsr }
	</td> --%>

	<%-- <td class=td1 align=right>
		�����ʽ�(��Ԫ)��
	</td>
	<td class=td1 >
		${jgdm.ldzj }
	</td> --%>

<%-- <tr>
	<td class=td1 align=right>
		������
	</td>
	<td class=td1>
		${jgdm.qtzj }
	</td>
	<td class=td1 align=right>
		�ϼƣ�
	</td>
	<td class=td1 >
		${jgdm.hjzj }
	</td>
</tr> --%>
<%-- <tr>
	<td class=td1 align=right>
		�� �� �� ��(ƽ����)M2��
	</td>
	<td class=td1>
		${jgdm.bgcs }
	</td>
	<td class=td1 align=right>
		�� �� �� ��(ƽ����)M2��
	</td>
	<td class=td1 >
		${jgdm.hdcs }
	</td>
</tr> --%>

<%-- 	<td class=td1 align=right>
		�� �� �� ����
	</td>
	<td class=td1>
		${jgdm.qtcs }
	</td> --%>





