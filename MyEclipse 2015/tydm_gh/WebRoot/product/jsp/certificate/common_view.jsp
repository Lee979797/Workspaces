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
		统一社会信用代码：
	</td>
	<td colspan=3 align="left">
	
	<%=tJgdm.getTyshxydm()==null?"":tJgdm.getTyshxydm() %>

	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		机构名称：
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getJgmc()==null?"":tJgdm.getJgmc() %>
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		住所地址：
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getJgdz()==null?"":tJgdm.getJgdz() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		住所行政区划：
	</td>
	<td class=td1>
	<%=tJgdm.getXzqh()==null?"":tJgdm.getXzqh() %>
	</td>
	<td class=td1 align=right>
		住所邮政编码 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getYzbm()==null?"":tJgdm.getYzbm()  %>
	</td>
</tr>

<tr>
	<td colspan=1 align="right">
		办公地址：
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getBgjgdz()==null?"":tJgdm.getBgjgdz() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		办公行政区划：
	</td>
	<td class=td1>
	<%=tJgdm.getBgxzqh()==null?"":tJgdm.getBgxzqh() %>
	</td>
	<td class=td1 align=right>
		办公邮政编码 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getBgyzbm()==null?"":tJgdm.getBgyzbm()  %>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		成立日期：
	</td>
	<td class=td1>
		<%=tJgdm.getZcrq()==null?"":tJgdm.getZcrq() %>
	</td>
	<td class=td1 align=right>
		校准日期 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getBzrq()==null?"":tJgdm.getBzrq() %>
	</td>
</tr>
<tr>
	<td class=td1 align="right">
		所在用人单位：
	</td>
	<td class=td1 align="left">
		<%=tJgdm.getZgmc()==null?"":tJgdm.getZgmc() %>
	</td>
	<td class=td1 align="right">
		所在用人单位代码：
	</td>
	<td class=td1 align="left">
		<%=tJgdm.getZgdm()==null?"":tJgdm.getZgdm() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		批复建立工会文号：
	</td>
	<td class=td1>
		<%=tJgdm.getJlwh()==null?"":tJgdm.getJlwh()  %>
	</td>
	<td class=td1 align=right>
		审批日期 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getJlrq() ==null?"":tJgdm.getJlrq() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		批复选举结果文号：
	</td>
	<td class=td1>
		<%=tJgdm.getXjwh()==null?"":tJgdm.getXjwh()  %>
	</td>
	<td class=td1 align=right>
		审批日期 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getXjrq() ==null?"":tJgdm.getXjrq() %>
	</td>
</tr>
<%-- <tr>
	<td class=td1 align=right>
		批复选举结果文号：
	</td>
	<td class=td1>
		${tJgdm.xjwh }
		<%=tJgdm.getXjwh() %>
	</td>
	<td class=td1 align=right>
		审批日期 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getXjrq() %>
	</td>
</tr>  --%>
<tr>
	<td class=td1 align=right>
		有效期起：
	</td>
	<td class=td1>
	<%=tJgdm.getYxqxs() ==null?"":tJgdm.getYxqxs()%>
	</td>
	<td class=td1 align=right>
		有效期至 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getYxqxe()==null?"":tJgdm.getYxqxe() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		机构电话：
	</td>
	<td class=td1>
		<%=tJgdm.getDhhm()==null?"": tJgdm.getDhhm()%>
	</td>
	<td class=td1 align=right>
		机构类型 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getJglx().equals("1")?"基层工会":"其他"%>
	</td>
</tr>
<tr/>
	<td colspan=1 align="right">
		网址 ：
	</td>
	<td colspan=3 align="left">
		<%=tJgdm.getUrl()==null?"": tJgdm.getUrl()%>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		经办人姓名：
	</td>
	<td class=td1>
	<%=tJgdm.getTbrxm()==null?"":tJgdm.getTbrxm()%>
	</td>
	<td class=td1 align=right>
		证件类型：<%=tJgdm.getTbrzjlx()==null?"":tJgdm.getTbrzjlx()%>
	</td>
	<td class=td1 >
		<%=tJgdm.getTbrsfzh() ==null?"":tJgdm.getTbrsfzh()%>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		经办人移动电话：
	</td>
	<td class=td1>
		<%=tJgdm.getTbrmobile() ==null?"":tJgdm.getTbrmobile()%>
	</td>
	<td class=td1 align=right>
		经办人座机：
	</td>
	<td class=td1 >
		<%=tJgdm.getTbrlxfs()==null?"":tJgdm.getTbrlxfs()%>
	</td>
</tr>
<tr>
	<td colspan=1 class=td1 align=right>
		备注：
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getMemo() ==null?"":tJgdm.getMemo()%>
	</td>
</tr> 

<tr>
	<td colspan=1 class=td1 align=right>
		发证机关：
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getPzjgmc() ==null?"":tJgdm.getPzjgmc()%>
	</td>
</tr> 

<tr>
	<td class=td1 align=right>
		现职工人数：
	</td>
	<td class=td1>
		<%=tJgdm.getZgrs()==null?"": tJgdm.getZgrs()%>
	</td>
	<td class=td1 align=right>
		会员人数 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getHyrs()==null?"": tJgdm.getHyrs()%>
	</td>
</tr>

<tr>
	<td class=td1 align=right>
		工会主席姓名：
	</td>
	<td class=td1>
		<%=tJgdm.getGhzxmc()==null?"":tJgdm.getGhzxmc() %>
</td>
<td class=td1 align=right>
		经费情况(万元)：
	</td>
	<td class=td1 >
		<%=tJgdm.getQtsr() ==null?"":tJgdm.getQtsr() %>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		固定资金(万元)：
	</td>
	<td class=td1>
		<%=tJgdm.getGdzj()==null?"":tJgdm.getGdzj() %>
	</td>
	<td class=td1 align=right>
		场所情况：
	</td>
	<td class=td1 >
		<%=tJgdm.getCshj()==null?"":tJgdm.getCshj() %>
	</td>
</tr>




<%--
<tr>
	<td class=td1 align=right>
		专职工会干部数：
	</td>
	<td class=td1>
		<%=tJgdm.getGbrs() ==null?"":tJgdm.getGbrs()%>
	</td>
	 <td class=td1 align=right>
		工会届数 ：
	</td>
	<td class=td1 >
	<%=tJgdm.getGhjs()==null?"":tJgdm.getGhjs() %>
	</td> 
</tr>--%>

<%-- 	<td class=td1 align=right>
		电话 ：
	</td>
	<td class=td1 >
		<%=tJgdm.getGhzxdh() ==null?"":tJgdm.getGhzxdh()%>
	</td>--%>
</tr> 
<%-- <tr>
	<td class=td1 align=right>
		上年结余累计(万元)：
	</td>
	<td class=td1>
		<%=tJgdm.getSnjylj()==null?"":tJgdm.getSnjylj() %>
	</td>
	<td class=td1 align=right>
		年会员缴纳会费收入(万元)：
	</td>
	<td class=td1 >
		<%=tJgdm.getHhsr()==null?"":tJgdm.getHhsr() %>
	</td>
</tr> --%>
<tr>
	<%-- <td class=td1 align=right>
		年2％拨交工会经费本级留成收入(万元)：
	</td>
	<td class=td1>
		<%=tJgdm.getLcsr() ==null?"":tJgdm.getLcsr() %>
	</td> --%>

	<%-- <td class=td1 align=right>
		流动资金(万元)：
	</td>
	<td class=td1 >
		<%=tJgdm.getLdzj()==null?"":tJgdm.getLdzj() %>
	</td> --%>
</tr>
<%-- <tr>
	<td class=td1 align=right>
		其他：
	</td>
	<td class=td1>
		<%=tJgdm.getQtzj()==null?"":tJgdm.getQtzj()  %>
	</td>
	<td class=td1 align=right>
		合计：
	</td>
	<td class=td1 >
		<%=tJgdm.getHjzj()==null?"":tJgdm.getHjzj()   %>
	</td>
</tr> --%>
<%-- <tr>
	<td class=td1 align=right>
		办 公 场 所(平方米)M2：
	</td>
	<td class=td1>
		<%=tJgdm.getBgcs() ==null?"":tJgdm.getBgcs() %>
	</td>
	<td class=td1 align=right>
		活 动 场 所(平方米)M2：
	</td>
	<td class=td1 >
		<%=tJgdm.getHdcs() ==null?"":tJgdm.getHdcs()%>
	</td>
</tr> --%>
<tr>
	<%-- <td class=td1 align=right>
		其 他 场 所：
	</td>
	<td class=td1>
		<%=tJgdm.getQtcs() ==null?"":tJgdm.getQtcs() %>
	</td> --%>

<%-- <tr>
	<td colspan=1 class=td1 align=right>
		能否独立承担民事责任：
	</td>
	<td colspan=3 class=td1>
		<%=tJgdm.getCdnl() ==null?"":tJgdm.getCdnl()%>
	</td>
</tr> --%>

