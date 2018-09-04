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
		统一社会信用代码：
	</td>
	<td colspan=3 align="left">
		${jgdm.tyshxydm }
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		机构名称：
	</td>
	<td colspan=3 align="left">
		${jgdm.jgmc }
	</td>
</tr>
<tr>
	<td colspan=1 align="right">
		住所地址：
	</td>
	<td colspan=3 align="left">
		${jgdm.jgdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		住所行政区划：
	</td>
	<td class=td1>
		${jgdm.xzqh }
	</td>
	<td class=td1 align=right>
		住所邮政编码 ：
	</td>
	<td class=td1 >
		${jgdm.yzbm }
	</td>
</tr>

<tr>
	<td colspan=1 align="right">
		办公地址：
	</td>
	<td colspan=3 align="left">
		${jgdm.bgjgdz }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		办公行政区划：
	</td>
	<td class=td1>
		${jgdm.bgxzqh }
	</td>
	<td class=td1 align=right>
		办公邮政编码 ：
	</td>
	<td class=td1 >
		${jgdm.bgyzbm }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		成立日期：
	</td>
	<td class=td1>
	<fmt:formatDate value="${jgdm.zcrq }" pattern="yyyy-MM-dd"/>
	</td>
	<td class=td1 align=right>
		核准日期 ：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.bzrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		所在用人单位：
	</td>
	<td class=td1>
		${jgdm.zgmc }
	</td>
	<td class=td1 align=right>
		所在用人单位代码 ：
	</td>
	<td class=td1 >
		${jgdm.zgdm }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		批复建立工会文号：
	</td>
	<td class=td1>
		${jgdm.jlwh }
	</td>
	<td class=td1 align=right>
		审批日期 ：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.jlrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		批复选举结果文号：
	</td>
	<td class=td1>
		${jgdm.xjwh }
	</td>
	<td class=td1 align=right>
		审批日期 ：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.xjrq }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		有效期起：
	</td>
	<td class=td1>
	<fmt:formatDate value="${jgdm.yxqxs }" pattern="yyyy-MM-dd"/>
	</td>
	<td class=td1 align=right>
		有效期至 ：
	</td>
	<td class=td1 >
	<fmt:formatDate value="${jgdm.yxqxe }" pattern="yyyy-MM-dd"/>
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		机构电话：
	</td>
	<td class=td1>
		${jgdm.dhhm }
	</td>
	<td class=td1 align=right>
		机构类型 ：
	</td>
	<td class=td1 >
		${jgdm.jglx =="1"?"基层工会":"其他"}
	</td>
</tr>
<tr/>
	<td colspan=1 align="right">
		网址 ：
	</td>
	<td colspan=3 align="left">
		${jgdm.url ==null?"": jgdm.url}
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		经办人姓名：
	</td>
	<td class=td1>
		${jgdm.tbrxm }
	</td>
	<td class=td1 align=right>
		${jgdm.tbrzjlx eq "0"?"身份证":"其它"}：
	</td>
	<td class=td1 >
		${jgdm.tbrsfzh }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		经办人手机：
	</td>
	<td class=td1>
		${jgdm.tbrmobile }
	</td>
	<td class=td1 align=right>
		经办人座机：
	</td>
	<td class=td1 >
		${jgdm.tbrlxfs }
	</td>
</tr>
<tr>
	<td colspan=1 class=td1 align=right>
		备注：
	</td>
	<td colspan=3 class=td1>
		${jgdm.memo }
	</td>
</tr> 
<tr>
	<td colspan=1 align="right">
		发证机关：
	</td>
	<td colspan=3 align="left">
		${jgdm.pzjgmc }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		职工人数(人)：
	</td>
	<td class=td1>
		${jgdm.zgrs }
	</td>
	<td class=td1 align=right>
		会员人数 ：
	</td>
	<td class=td1 >
		${jgdm.hyrs }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		工会主席姓名：
	</td>
	<td class=td1>
		${jgdm.ghzxmc }
	</td>
	<td class=td1 align=right>
		经费情况(万元)：
	</td>
	<td class=td1 >
		${jgdm.qtsr }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		固定资金(万元)：
	</td>
	<td class=td1>
		${jgdm.gdzj }
	</td>
	<td class=td1 align=right>
		场所情况：
	</td>
	<td class=td1 >
		${jgdm.cshj }
	</td>
</tr>

	<%-- <td  class=td1 align=right>
		能否独立承担民事责任：
	</td>
	<td  class=td1>
		${jgdm.cdnl eq 0?'能':'否' }
	</td>
 --%>

<!--  <tr>
	<td class=td1 align=right>
		注册资金：
	</td>
	<td class=td1>
		${jgdm.zczj }
	</td>
	<td class=td1 align=right>
		货币种类 ：
	</td>
	<td class=td1 >
		${jgdm.hbzl }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		电子邮箱：
	</td>
	<td class=td1>
		${jgdm.email }
	</td>
	<td class=td1 align=right>
		网址 ：
	</td>
	<td class=td1 >
		${jgdm.url }
	</td>
</tr>
-->
<%-- <tr>
	<td class=td1 align=right>
		专职工会干部数：
	</td>
	<td class=td1>
		${jgdm.ghjs }
	</td>
	<td class=td1 align=right>
		工会届数 ：
	</td>
	<td class=td1 >
		${jgdm.ghjs }
	</td>
</tr> --%>

<!-- 	<td class=td1 align=right>
		电话 ：
	</td> 
	<td class=td1 >
		${jgdm.ghzxdh }
	</td>-->

<%-- <tr>
	<td class=td1 align=right>
		上年结余累计(万元)：
	</td>
	<td class=td1>
		${jgdm.snjylj }
	</td>
	<td class=td1 align=right>
		年会员缴纳会费收入(万元)：
	</td>
	<td class=td1 >
		${jgdm.hhsr }
	</td>
</tr> --%>
 
	<%-- <td class=td1 align=right>
		年2％拨交工会经费本级留成收入(万元)：
	</td>
	<td class=td1>
		${jgdm.lcsr }
	</td> --%>

	<%-- <td class=td1 align=right>
		流动资金(万元)：
	</td>
	<td class=td1 >
		${jgdm.ldzj }
	</td> --%>

<%-- <tr>
	<td class=td1 align=right>
		其他：
	</td>
	<td class=td1>
		${jgdm.qtzj }
	</td>
	<td class=td1 align=right>
		合计：
	</td>
	<td class=td1 >
		${jgdm.hjzj }
	</td>
</tr> --%>
<%-- <tr>
	<td class=td1 align=right>
		办 公 场 所(平方米)M2：
	</td>
	<td class=td1>
		${jgdm.bgcs }
	</td>
	<td class=td1 align=right>
		活 动 场 所(平方米)M2：
	</td>
	<td class=td1 >
		${jgdm.hdcs }
	</td>
</tr> --%>

<%-- 	<td class=td1 align=right>
		其 他 场 所：
	</td>
	<td class=td1>
		${jgdm.qtcs }
	</td> --%>





