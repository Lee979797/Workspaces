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
<td  colspan=1 align="right">
机构名称：
</td>
<td  colspan=3 align="left">
${jgdm.jgmc }
</td>
</tr>
<TR>
	<c:choose>
	<c:when test="${jgdm.jglx eq '2'}">
	<td class=td1 align=right>
	${jgdm.fzxs }：

    </td>
    </c:when>
	<c:otherwise>
	<td class=td1 align=right>
     	  法定代表人/负责人：
    </td> 
	</c:otherwise>
	</c:choose>

    <td class=td1>
    <c:set var="name" value="${fn:trim(jgdm.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
        <input type="hidden" value="${jgdm.fddbr }" name="jgdm.fddbr">

    </td>
    
   
    <td class=td1 align="right">&nbsp; 
      <c:set var="name" value="${zjlxMap[fn:trim(jgdm.zjlx)]}"/>
        ${(name eq '' or name eq null)?"证件号码":name }：
    </td>
    <td class="td1" style="position:relative;display:block;overflow:visible;">
           <c:if test="${!(name eq '' or name eq null)}">
            <c:set var="name" value="${fn:trim(jgdm.zjhm)}"/>
            ${(name eq '' or name eq null)?"":name }
        </c:if>
        
    </td>
</TR>
<tr>

     <td class=td1 align=right>
        成立日期：
    </td>
    <td class=td1>
 	<c:set var="date" value="${jgdm.zcrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null or date eq '')}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
      <input type="hidden" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="jgdm.zcrq">
        </c:if>
    </td>
   <td class=td1 align=right >
        发证日期：
    </td>
    <td class=td1>
        <c:set var="date" value="${jgdm.bzrq}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        <input type="hidden" value=" <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="jgdm.bzrq">
        </c:if>
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自：
    </td>
    <td class=td1>
     <c:set var="date" value="${jgdm.yxqxs}"/>
        <c:if test="${date eq null}">
		
        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        </c:if>

        </A>
    </td>
   <td class=td1 align=right >
        有效期限至：
    </td>
    <td class=td1>
     <c:set var="date" value="${jgdm.yxqxe}"/>
        <c:if test="${date eq null}">

        </c:if>
        <c:if test="${!(date eq null)}">
            <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
        <input type="hidden" value=" <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" name="jgdm.yxqxe">
        </c:if>
    </td>
</tr>
<TR>
    <td class=td1 align=right>
         住所：
    </td>
    <td class=td1 colSpan=3>
       <c:set var="name" value="${fn:trim(jgdm.jgdz)}"/>
        ${(name eq '' or name eq null)?"":name }
       <input type="hidden" value="${jgdm.jgdz }" name="jgdm.jgdz">
    </td>
</TR>
<TR> 
    <td class=td1 align=right>
        住所行政区划：
    </td>
    <td class=td1  style="position:relative;display:block;overflow:visible;">
         <c:set var="name" value="${xzqhMap[fn:trim(jgdm.xzqh)]}"/>
        ${jgdm.xzqh }
        ${(name eq '' or name eq null)?"":name }
		<input type="hidden" value="${jgdm.xzqh }" name="jgdm.xzqh">
    </td>
      <!--    <td class=td1 align=right>
        	生产经营地行政区划
    </td>
    <td class=td1>
        <input name="scjyxzqh" id="scjyxzqh" type="text"  style="z-index: 100; position: relative; width:200px;"
               value="">
        <span id="pzjginfo"></span>
    </td>
    -->
    <c:set var="jglx" value="${jgdm.jglx}"/>
  <c:if test="${'3' eq jglx}">
    <td class="td1" align="right">
     基金会类型：
    </td>
    <td class="td1">
        <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.jjhlx)]}"/>
        ${(name eq '' or name eq null)?"":name }

    <input type="hidden" value="${jgdm.jjhlx }" name="jgdm.jjhlx">
    </td>
   </c:if>
  <%--  <c:if test="${'1' eq jglx}">
	    <td class="td1" align="right">
	        活动地域：
	    </td>
	    <td class="td1" >
	        <c:set var="name" value="${fn:trim(jgdm.hddy)}"/>
	        ${(name eq '' or name eq null)?"":name }
	<input type="hidden" value="${jgdm.hddy }" name="jgdm.hddy">
	    </td>
	</c:if> --%>
	<c:if test="${'2' eq jglx}">
	    <td class="td1" align="right">
	        登记类型：
	    </td>
	    <td class="td1" >
         <c:set var="name" value="${nnjglxMap[fn:trim(jgdm.jjlx2011)]}"/>
        ${jgdm.jjlx2011 }
        ${(name eq '' or name eq null)?"":name }
        <input type="hidden" value="${jgdm.jjlx2011 }" name="jgdm.jjlx2011">
	    </td>
	</c:if>



<TR>
    <td class=td1 align=right>
        业务范围：
    </td>
    <c:set var="name" value="${fn:trim(jgdm.jyfw)}"/>
    <td class="td1" colspan="3"
        style="word-break:break-all;word-wrap: break-word;">
        <div style="display: block;word-break:break-all;width: 100%">
            ${(name eq '' or name eq null)?"":name }
        </div>
        <input type="hidden" value="${jgdm.jyfw }" name="jgdm.jyfw">
    </td>
</TR>
<tr>
	
	<td class=td1 align=right>
            法定代表人手机：
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <c:set var="name" value="${fn:trim(jgdm.fddbr)}"/>
        ${(name eq '' or name eq null)?"":name }
        <input type="hidden" value="${jgdm.fddbr }" name="jgdm.fddbr">
    </TD>
    	<td class=td1 align=right>
            法定代表人座机：
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
       ${jgdm.mobile }

    </TD>

</tr>
<TR>
    <td class=td1 align=right>
        注册资金：
    </td>
    <td class=td1>
        <fmt:formatNumber value='${jgdm.zczj }' pattern="##.0000" />万元
    </td>
    <td class=td1 align=right>
        货币种类：
    </td>
    <td class=td1>
       
      <c:set var="name" value="${hbMap[fn:trim(jgdm.hbzl)]}"/>
        ${(name eq '' or name eq null)?"":name }
	<input type="hidden" value="${jgdm.hbzl }" name="jgdm.hbzl">
       
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        经济行业：
    </td>
          <td class=td1 style="position:relative;display:block;overflow:visible;">
          <c:set var="name" value="${nnjghyMap[fn:trim(jgdm.jjhy2011)]}"/>
        ${jgdm.jjhy2011 }
        ${(name eq '' or name eq null)?"":name }
        <input type="hidden" value="${jgdm.jjhy2011 }" name="jgdm.jjhy2011">
    </td>
<td class=td1 align=right>
        批准文号：
    </td>
    <td  class=td1>
    ${jgdm.zch }
    
    </td>

</TR>

<TR>
    <td class=td1 align=right>
        邮政编码 ：
    </td>
    <td class=td1>
    ${jgdm.yzbm }
    </td>
    <td class=td1 align=right>
        单位联系电话 ：
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
     ${jgdm.dhhm }
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	电子邮箱：
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
    ${jgdm.email }
    </TD>
    <td class=td1 align=right>
        网址：
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
     ${jgdm.url }
    </TD>
   
</TR>
<tr>
       <td class=td1 align=right>
        业务主管单位名称：
    </td>
    <td class=td1>
     ${jgdm.zgmc }
    </td>
    <td class=td1 align=right>
        业务主管单位代码：
    </td>
    <td class=td1>
    ${jgdm.zgdm }

    </td>

</TR>
<TR>
    <td class=td1 align=right>
        	工作人员数量：
    </td>
    <td class=td1>
     ${jgdm.zgrs }
       
    </td> 
   
 
    <%--  <td class=td1 align=right>
        兼职工作人员数量：
    </td>
    <td class=td1>
     ${jgdm.jzrysl }
      
    </td> --%>
</TR>
<%-- <TR>
    <td class=td1 align=right>
        	理事人数：
    </td>
    <td class=td1>
     ${jgdm.lssl }

    </td> 
   
 
     <td class=td1 align=right>
           监事人数：
    </td>
    <td class=td1>
    ${jgdm.jssl }
       
    </td>
</TR>
 --%>
   <c:if test="${jgdm.jglx eq '1'}">
  <%--  <TR>
    <td class=td1 align=right>
        	常务理事人数：
    </td>
    <td class=td1>
    ${jgdm.cwlssl }

    </td> 
   
 
</TR> --%>
<%-- <TR>
    <td class=td1 align=right>
        	社团会员（单位会员）数量：
    </td>
    <td class=td1>
     ${jgdm.dwhysl }

    </td> 
   
 
     <td class=td1 align=right>
        社团会员（个人会员）数量：
    </td>
    <td class=td1>
    ${jgdm.grhysl }

    </td>
</TR> --%>
</c:if>
<tr>
    
    <td class=td1 align=right>
        	经办人姓名：
    </td>
    <td class=td1>
    ${jgdm.tbrxm }

    </td>
     <td class=td1 align=right>
      <c:set var="name" value="${zjlxMap[fn:trim(jgdm.tbrzjlx)]}"/>
        ${(name eq '' or name eq null)?"证件号码":name }：


    </td>
    
    <td class=td1>
     	${jgdm.tbrsfzh }

    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人手机：
    </td>
    <td class=td1>
    ${jgdm.tbrmobile }

    </td> 
   
 <td class=td1 align=right>
        	经办人座机：
    </td>
    <td class=td1>
    ${jgdm.tbrlxfs }

    </td> 
     
</TR> 
<%-- <TR>
    <td class=td1 align=right>
        	开户银行：
    </td>
    <td class=td1>
    ${jgdm.khyh }

    </td> 
   
 <td class=td1 align=right>
        	开户帐号：
    </td>
    <td class=td1>
    ${jgdm.kyzh }

    </td> 
     
</TR>  --%>






<tr>

    <td class=td1 align=right>
        	备注：
    </td>
     <td class=td1 colSpan=3>
     ${jgdm.memo }

    </td>
 </tr>


