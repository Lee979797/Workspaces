<%@page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
             <c:set var="jglx" value="<%=tJgdm.getJglx() %>"/>
            <div id="dj" class="list listblue">
	<h3><b>党建信息	&nbsp;&nbsp;
	<c:set var="isdang" value="<%=tJgdm.getIsdang()%>"/>
	<c:if test="${isdang eq '0'}">
	 已建立党组织
	</c:if>
	<c:if test="${isdang eq '1'}">
	未建立党组织
	</c:if>
        </b></h3>
	

    
	<div id="dangjian" style="display:${isdang eq '0'?'':'none'}">
	<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
		<tr>
    

     <td class=td1  align=right>
    	 党组织类型：
    </td>
    
    <td class=td1 colSpan=3>
     	
     
   <c:set var="dzzlx" value="<%=tJgdm.getDzzlx() %>"/>
   <c:if test="${dzzlx eq '1'}">单独组建</c:if>
   <c:if test="${dzzlx eq '2'}">联合组建:按行业组建</c:if>
   <c:if test="${dzzlx eq '3'}">联合组建:按单位组建</c:if>
   <c:if test="${dzzlx eq '4'}">联合组建:按区域组建</c:if>

    </td>
</TR>
<tr>
 <td class=td1 align=right>
    	 党组织负责人：
    </td>
    
    <td class=td1>
     	 <%=clsStringTool.convertNull(tJgdm.getDzzfzr())%>
     
    </td>
    <td class=td1 align=right>
         &nbsp;<%
			         zjlxList = InitSysParams.tZjlxList;
			        if (zjlxList != null && zjlxList.size() > 0) {
			            for (TZjlx zjlx : zjlxList) {
			                if (zjlx != null) {
			                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getDzzfzrzjlx())) {
			                        out.print(zjlx.getMc() + "：");
			                        break;
			                    }
			                }
			            }
			        }
			    %>

    </td>
    
    <td class=td1>
     	
     <%=clsStringTool.convertNull(tJgdm.getDzzfzrzjhm())%>

    </td>
</tr>
<tr>
 <td class=td1 align=right>
    	 党建联系人：
    </td>
    
    <td class=td1>
     	
          <%=clsStringTool.convertNull(tJgdm.getDjlxr())%>
   
    </td>
    <td class=td1 align=right>
    				         &nbsp;<%
			         zjlxList = InitSysParams.tZjlxList;
			        if (zjlxList != null && zjlxList.size() > 0) {
			            for (TZjlx zjlx : zjlxList) {
			                if (zjlx != null) {
			                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getDjlxrzjlx())) {
			                        out.print(zjlx.getMc() + "：");
			                        break;
			                    }
			                }
			            }
			        }
			    %>
    </td>
    
    <td class=td1>
     	
      <%=clsStringTool.convertNull(tJgdm.getDjlxrzjhm())%>

    </td>
</tr>
<tr>
     <td class=td1 align=right>
       	党建联系人电话：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(tJgdm.getDjlxrdhhm())%>
    </td>
     <td class=td1 align=right>
        	党组织成立时间：
    </td>
    <td class=td1>
    <%=tJgdm.getDzzclrq() == null ? "" : tJgdm.getDzzclrq().toString().substring(0, 10)%>

    </td>
  
    
</TR>
<tr>
	  <td class=td1 align=right>
       	上级党组织名称：
    </td>
    <td class=td1  colSpan=3>
    <%=clsStringTool.convertNull(tJgdm.getSjdzzmc())%>
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       专职工作人员数量中党员数量：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZzdysl()))%>
    </td>
     <td class=td1 align=right>
    	兼职工作人员数量中党员数量：
    </td>
    
    <td class=td1>
     	
      <%=clsStringTool.convertNull(String.valueOf(tJgdm.getJzdysl()))%>
   
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="display:${isdang eq '1'?'':'none'}">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right>
		未建立原因：
		</td> 
		<td class=td1>
		<c:set var="wjlyy" value="<%=tJgdm.getWjlyy() %>"/>
		<c:if test="${wjlyy eq '1'}">符合建立党组织条件但尚未建立</c:if>
		<c:if test="${wjlyy eq '2'}">有党员但不符合建立条件</c:if>
		<c:if test="${wjlyy eq '3'}">无党员</c:if>
		</td>
	</tr>
	</TABLE>
	</div>
</div>

<div id="list_context" class="list listblue">
	<h3><b>负责人信息</b></h3>
	 <c:forEach var="list" items="${listFzr}">
	<div id="lizi" style=""> 
	<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
	<input type="hidden" name="fzr.id" value=""/>
		<tr>
			<td class=td1 align=right>
				姓名：
			</td>
			<td class=td1>
			${list.xm }
			</td>
			    <td class=td1 align="right">&nbsp;
			    	&nbsp;<%
			         zjlxList = InitSysParams.tZjlxList;
			        if (zjlxList != null && zjlxList.size() > 0) {
			            for (TZjlx zjlx : zjlxList) {
			                if (zjlx != null) {
			                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getZjlx())) {
			                        out.print(zjlx.getMc() + "：");
			                        break;
			                    }
			                }
			            }
			        }
			    %>
   				</td>
		
		
			<td class=td1>
			${list.zjhm }
			</td>
		
		</tr>
		<tr>
			<td class=td1 align=right>
				性别：
			</td>
			<td class=td1>
			${list.xb}

			</td>
				<td class=td1 align=right>
				职务：
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
				民族：
			</td>
			<td class=td1>
			<c:forEach items="${mList}" var="mz">
				<c:if test="${mz.dm eq list.mz}">
				${mz.mc }
				</c:if>
      			 </c:forEach>
      			 
			</td>
			<td class=td1 align=right>
				国别：
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
				任职时间：
			</td>
			<td class=td1>
			<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd' />
			</td>
				<td class=td1 align=right>
				政治面貌：
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
				工作单位：
			</td>
			<td class=td1>
			${list.dzdw }
			</td>
			<td class=td1 align=right>
				专职/兼职：
			</td>
			<td class=td1>
			<c:if test="${list.iszz eq '0'}">专职</c:if>
			<c:if test="${list.iszz eq '1'}">兼职</c:if>
			</td>
		</tr>
			<tr>
			<td class=td1 align=right>
				座机：
			</td>
			<td class=td1>
			${list.lxdh }
			</td>
				<td class=td1 align=right>
				手机：
			</td>
			<td class=td1>
			${list.lxmobile }
			</td>
		
		</tr>
		
		</tr>
			<tr>
			<td class=td1 align=right>
				通讯地址：
			</td>
			<td class=td1 colSpan=3>
			${list.txdz }
			</td>
		</tr>
	<tr>
	
			<td class=td1 align=right>
				邮编：
			</td>
			<td class=td1>
			${list.yb }
			</td>
			<td class=td1 align=right>
				电子邮箱：
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