<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<style type="text/css">
table.tableBorder0 td{ border:#c4dbe5 1px solid;}
</style>

  <tr>
	<td colspan=1 align="right">
		ͳһ������ô��룺
	</td>
	<td colspan=3 align="left">
	
	<%=tJgdm.getTyshxydm()==null?"":tJgdm.getTyshxydm() %>

	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		�������ƣ�
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getJgmc()==null?"":tJgdm.getJgmc() %>
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		ס����ַ��
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getJgdz()==null?"":tJgdm.getJgdz() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		ס������������
	</td>
	<td class=td1>
	<%=tJgdm.getXzqh()==null?"":tJgdm.getXzqh() %>
	</td>
	<td class=td1 align=right>
		ס���������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getYzbm()==null?"":tJgdm.getYzbm()  %>
	</td>
</tr>

<tr>
	<td colspan=1 align="right">
		�칫��ַ��
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getBgjgdz()==null?"":tJgdm.getBgjgdz() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�칫����������
	</td>
	<td class=td1>
	<%=tJgdm.getBgxzqh()==null?"":tJgdm.getBgxzqh() %>
	</td>
	<td class=td1 align=right>
		�칫�������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getBgyzbm()==null?"":tJgdm.getBgyzbm()  %>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		�������ڣ�
	</td>
	<td class=td1>
		<%=tJgdm.getZcrq()==null?"":tJgdm.getZcrq() %>
	</td>
	<td class=td1 align=right>
		У׼���� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getBzrq()==null?"":tJgdm.getBzrq() %>
	</td>
</tr>
<tr>
	<td class=td1 align="right">
		�������˵�λ��
	</td>
	<td class=td1 align="left">
		<%=tJgdm.getZgmc()==null?"":tJgdm.getZgmc() %>
	</td>
	<td class=td1 align="right">
		�������˵�λ���룺
	</td>
	<td class=td1 align="left">
		<%=tJgdm.getZgdm()==null?"":tJgdm.getZgdm() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������������ĺţ�
	</td>
	<td class=td1>
		<%=tJgdm.getJlwh()==null?"":tJgdm.getJlwh()  %>
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getJlrq() ==null?"":tJgdm.getJlrq() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		����ѡ�ٽ���ĺţ�
	</td>
	<td class=td1>
		<%=tJgdm.getXjwh()==null?"":tJgdm.getXjwh()  %>
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getXjrq() ==null?"":tJgdm.getXjrq() %>
	</td>
</tr>
<%-- <tr>
	<td class=td1 align=right>
		����ѡ�ٽ���ĺţ�
	</td>
	<td class=td1>
		${tJgdm.xjwh }
		<%=tJgdm.getXjwh() %>
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getXjrq() %>
	</td>
</tr>  --%>
<tr>
	<td class=td1 align=right>
		��Ч����
	</td>
	<td class=td1>
	<%=tJgdm.getYxqxs() ==null?"":tJgdm.getYxqxs()%>
	</td>
	<td class=td1 align=right>
		��Ч���� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getYxqxe()==null?"":tJgdm.getYxqxe() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�����绰��
	</td>
	<td class=td1>
		<%=tJgdm.getDhhm()==null?"": tJgdm.getDhhm()%>
	</td>
	<td class=td1 align=right>
		�������� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getJglx().equals("1")?"���㹤��":"����"%>
	</td>
</tr>
<tr/>
	<td colspan=1 align="right">
		��ַ ��
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getUrl()==null?"": tJgdm.getUrl()%>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		������������
	</td>
	<td class=td1>
	<%=tJgdm.getTbrxm()==null?"":tJgdm.getTbrxm()%>
	</td>
	<td class=td1 align=right>
		֤�����ͣ�<%=tJgdm.getTbrzjlx()==null?"":tJgdm.getTbrzjlx()%>
	</td>
	<td class=td1 >
		<%=tJgdm.getTbrsfzh() ==null?"":tJgdm.getTbrsfzh()%>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�������ƶ��绰��
	</td>
	<td class=td1>
		<%=tJgdm.getTbrmobile() ==null?"":tJgdm.getTbrmobile()%>
	</td>
	<td class=td1 align=right>
		������������
	</td>
	<td class=td1 >
		<%=tJgdm.getTbrlxfs()==null?"":tJgdm.getTbrlxfs()%>
	</td>
</tr>
<tr>
	<td colspan=1 class=td1 align=right>
		��ע��
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getMemo() ==null?"":tJgdm.getMemo()%>
	</td>
</tr> 

<tr>
	<td colspan=1 class=td1 align=right>
		��֤���أ�
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getPzjgmc() ==null?"":tJgdm.getPzjgmc()%>
	</td>
</tr> 

<tr>
	<td class=td1 align=right>
		��ְ��������
	</td>
	<td class=td1>
		<%=tJgdm.getZgrs()==null?"": tJgdm.getZgrs()%>
	</td>
	<td class=td1 align=right>
		��Ա���� ��
	</td>
	<td class=td1 >
		<%=tJgdm.getHyrs()==null?"": tJgdm.getHyrs()%>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		������ϯ������
	</td>
	<td class=td1>
		<%=tJgdm.getGhzxmc()==null?"":tJgdm.getGhzxmc() %>
</td>
<td class=td1 align=right>
		�������(��Ԫ)��
	</td>
	<td class=td1 >
		<%=tJgdm.getQtsr() ==null?"":tJgdm.getQtsr() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		�̶��ʽ�(��Ԫ)��
	</td>
	<td class=td1>
		<%=tJgdm.getGdzj()==null?"":tJgdm.getGdzj() %>
	</td>
	<td class=td1 align=right>
		���������
	</td>
	<td class=td1 >
		<%=tJgdm.getCshj()==null?"":tJgdm.getCshj() %>
	</td>
</tr>




<%--
<tr>
	<td class=td1 align=right>
		רְ����ɲ�����
	</td>
	<td class=td1>
		<%=tJgdm.getGbrs() ==null?"":tJgdm.getGbrs()%>
	</td>
	 <td class=td1 align=right>
		������� ��
	</td>
	<td class=td1 >
	<%=tJgdm.getGhjs()==null?"":tJgdm.getGhjs() %>
	</td> 
</tr>--%>

<%-- 	<td class=td1 align=right>
		�绰 ��
	</td>
	<td class=td1 >
		<%=tJgdm.getGhzxdh() ==null?"":tJgdm.getGhzxdh()%>
	</td>--%>
</tr> 
<%-- <tr>
	<td class=td1 align=right>
		��������ۼ�(��Ԫ)��
	</td>
	<td class=td1>
		<%=tJgdm.getSnjylj()==null?"":tJgdm.getSnjylj() %>
	</td>
	<td class=td1 align=right>
		���Ա���ɻ������(��Ԫ)��
	</td>
	<td class=td1 >
		<%=tJgdm.getHhsr()==null?"":tJgdm.getHhsr() %>
	</td>
</tr> --%>
<tr>
	<%-- <td class=td1 align=right>
		��2���������ᾭ�ѱ�����������(��Ԫ)��
	</td>
	<td class=td1>
		<%=tJgdm.getLcsr() ==null?"":tJgdm.getLcsr() %>
	</td> --%>

	<%-- <td class=td1 align=right>
		�����ʽ�(��Ԫ)��
	</td>
	<td class=td1 >
		<%=tJgdm.getLdzj()==null?"":tJgdm.getLdzj() %>
	</td> --%>
</tr>
<%-- <tr>
	<td class=td1 align=right>
		������
	</td>
	<td class=td1>
		<%=tJgdm.getQtzj()==null?"":tJgdm.getQtzj()  %>
	</td>
	<td class=td1 align=right>
		�ϼƣ�
	</td>
	<td class=td1 >
		<%=tJgdm.getHjzj()==null?"":tJgdm.getHjzj()   %>
	</td>
</tr> --%>
<%-- <tr>
	<td class=td1 align=right>
		�� �� �� ��(ƽ����)M2��
	</td>
	<td class=td1>
		<%=tJgdm.getBgcs() ==null?"":tJgdm.getBgcs() %>
	</td>
	<td class=td1 align=right>
		�� �� �� ��(ƽ����)M2��
	</td>
	<td class=td1 >
		<%=tJgdm.getHdcs() ==null?"":tJgdm.getHdcs()%>
	</td>
</tr> --%>
<tr>
	<%-- <td class=td1 align=right>
		�� �� �� ����
	</td>
	<td class=td1>
		<%=tJgdm.getQtcs() ==null?"":tJgdm.getQtcs() %>
	</td> --%>

<%-- <tr>
	<td colspan=1 class=td1 align=right>
		�ܷ�����е��������Σ�
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getCdnl() ==null?"":tJgdm.getCdnl()%>
	</td>
</tr> --%>

