<%@page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
               <div id="dj" class="list listblue">
<h3><b>������Ϣ	&nbsp;&nbsp;
<c:set var="isdang" value="${jgdm.isdang}"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
<c:if test="${isdang eq '0'}">
 �ѽ�������֯
</c:if>
<c:if test="${isdang eq '1'}">
δ��������֯
</c:if>
       </b></h3>


   
<div id="dangjian" style="display:${isdang eq '0'?'':'none'}">
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
	<tr>
   

    <td class=td1  align=right>
   	 ����֯���ͣ�
   </td>
   
   <td class=td1 colSpan=3>
    	
    
  <c:set var="dzzlx" value="${jgdm.dzzlx}"/>
  <c:if test="${dzzlx eq '1'}">�����齨</c:if>
  <c:if test="${dzzlx eq '2'}">�����齨:����ҵ�齨</c:if>
  <c:if test="${dzzlx eq '3'}">�����齨:����λ�齨</c:if>
  <c:if test="${dzzlx eq '4'}">�����齨:�������齨</c:if>

    </td>
</TR>
<tr>
 <td class=td1 align=right>
    	 ����֯�����ˣ�
    </td>
    
    <td class=td1>
    ${jgdm.dzzfzr}
    
   </td>
   <td class=td1 align=right>
        &nbsp;
		    
		      <c:set var="name" value="${zjlxMap[fn:trim(jgdm.dzzfzrzjlx)]}"/>
                            ${(name eq '' or name eq null)?"֤������":name }��

   </td>
   
   <td class=td1>
    	
    	${jgdm.dzzfzrzjhm}
    </td>
</tr>
<tr>
 <td class=td1 align=right>
    	 ������ϵ�ˣ�
    </td>
    
    <td class=td1>
     	${jgdm.djlxr}
  
   </td>
   <td class=td1 align=right>
   				         &nbsp;
		    <c:set var="name" value="${zjlxMap[fn:trim(jgdm.djlxrzjlx)]}"/>
                            ${(name eq '' or name eq null)?"֤������":name }��
   </td>
   
   <td class=td1>
    	${jgdm.djlxrzjhm}

    </td>
</tr>
<tr>
     <td class=td1 align=right>
       	������ϵ�˵绰��
    </td>
    <td class=td1>
    ${jgdm.djlxrdhhm}
   </td>
    <td class=td1 align=right>
       	����֯����ʱ�䣺
   </td>
   <td class=td1>
   <fmt:formatDate value='${jgdm.dzzclrq}' pattern='yyyy-MM-dd' />

    </td>
  
    
</TR>
<tr>
	  <td class=td1 align=right>
       	�ϼ�����֯���ƣ�
    </td>
    <td class=td1  colSpan=3>
   ${jgdm.sjdzzmc}
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       רְ������Ա�����е�Ա������
    </td>
    <td class=td1>
    ${jgdm.zzdysl}
   </td>
    <td class=td1 align=right>
   	��ְ������Ա�����е�Ա������
   </td>
   
   <td class=td1>
    	${jgdm.jzdysl}
   
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="display:${isdang eq '1'?'':'none'}">
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<tr>
	<td class=td1 align=right>
	δ����ԭ��
	</td> 
	<td class=td1>
	<c:set var="wjlyy" value="${jgdm.wjlyy}"/>
	<c:if test="${wjlyy eq '1'}">���Ͻ�������֯��������δ����</c:if>
	<c:if test="${wjlyy eq '2'}">�е�Ա�������Ͻ�������</c:if>
	<c:if test="${wjlyy eq '3'}">�޵�Ա</c:if>
		</td>
	</tr>
	</TABLE>
	</div>
</div>

<div id="list_context" class="list listblue">
	<h3><b>��������Ϣ</b></h3>
	 <c:forEach var="list" items="${listFzr}">
<div id="lizi" style=""> 
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
<input type="hidden" name="fzr.id" value=""/>
	<tr>
		<td class=td1 align=right>
			������
		</td>
		<td class=td1>
		${list.xm }
		</td>
		    <td class=td1 align="right">&nbsp;
		    	&nbsp; <c:set var="name" value="${zjlxMap[fn:trim(jgdm.zjlx)]}"/>
                                     ${(name eq '' or name eq null)?"֤������":name }��
  				</td>
	
	
		<td class=td1>
		${list.zjhm }
		</td>
	
	</tr>
	<tr>
		<td class=td1 align=right>
			�Ա�
		</td>
		<td class=td1>
		${list.xb}

		</td>
			<td class=td1 align=right>
			ְ��
		</td>
		<td class=td1>
		<c:forEach items="${zList}" var="zw">
			<c:if test="${zw.dm eq list.zw and zw.jglx eq jglx}">
			${zw.mc }
			</c:if>
     			 </c:forEach>

		</td>
		
	</tr>
	
	<tr>
	<td class=td1 align=right>
			���壺
		</td>
		<td class=td1>
		
		<c:forEach items="${mList}" var="mz">
			<c:if test="${fn:trim(mz.dm) == fn:trim(list.mz)}">
			${mz.mc }
			</c:if>
     			 </c:forEach>
     			 
		</td>
		<td class=td1 align=right>
			����
		</td>
		<td class=td1>
	
	     <c:forEach items="${gList}" var="gj">
			<c:if test="${gj.dm eq list.gj}">
			${gj.mc }
			</c:if>
     			 </c:forEach>
     			 
		</td>
	
	</tr>
		<tr>
		<td class=td1 align=right>
			��ְʱ�䣺
		</td>
		<td class=td1>
		<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd' />
		</td>
			<td class=td1 align=right>
			������ò��
		</td>
		<td class=td1>
		 <c:forEach items="${zzList}" var="zz">
			<c:if test="${zz.dm eq list.zzmm}">
			${zz.mc }
			</c:if>
     			 </c:forEach>

		</td>
		
	</tr>
		<tr>
			<td class=td1 align=right>
			������λ��
		</td>
		<td class=td1>
		${list.dzdw }
		</td>
		<td class=td1 align=right>
			רְ/��ְ��
		</td>
		<td class=td1>
		<c:if test="${list.iszz eq '0'}">רְ</c:if>
		<c:if test="${list.iszz eq '1'}">��ְ</c:if>
		</td>
	</tr>
		<tr>
		<td class=td1 align=right>
			������
		</td>
		<td class=td1>
		${list.lxdh }
		</td>
			<td class=td1 align=right>
			�ֻ���
		</td>
		<td class=td1>
		${list.lxmobile }
		</td>
	
	</tr>
	
	</tr>
		<tr>
		<td class=td1 align=right>
			ͨѶ��ַ��
		</td>
		<td class=td1 colSpan=3>
		${list.txdz }
		</td>
	</tr>
<tr>

		<td class=td1 align=right>
			�ʱࣺ
		</td>
		<td class=td1>
		${list.yb }
		</td>
		<td class=td1 align=right>
			�������䣺
		</td>
		<td class=td1>
		${list.email }
			</td>
		
		</tr>

		
	</table>
				<hr color="#88a6d4" width="80%" style="...."/>

</div> 
	
	</c:forEach>
</div>
