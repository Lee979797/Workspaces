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
<td  align="right">
统一社会信用代码：
</td>
<td>
<%=clsStringTool.convertNull(tJgdm.getTyshxydm())%>
</td>
<td align="right">
办证机构名称：
</td>
<td>
<%=tJgdm.getPzjgmc()%>
</td>
</tr>
<tr>
<td  colspan=1 align="right">
机构名称：
</td>
<td  colspan=3 align="left">
<%=clsStringTool.convertNull(tJgdm.getJgmc())%>
</td>
</tr>

<TR>
	<%
	if("2".equals(tJgdm.getJglx())){
   %>
    <td class=td1 align=right>
     <%=clsStringTool.convertNull(tJgdm.getFzxs())%>：

    </td>
    <%
    }else{
    %>

    <td class=td1 align=right>
     	  法定代表人/负责人：
    </td> 
    <% 
    }
    %>
    <td class=td1>
     <%=clsStringTool.convertNull(tJgdm.getFddbr())%>

    </td>
    
   
    <td class=td1 align="right">&nbsp; 
&nbsp;<%
        List<TZjlx> zjlxList = InitSysParams.tZjlxList;
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
    <td class="td1" style="position:relative;display:block;overflow:visible;">
    <%=clsStringTool.convertNull(tJgdm.getZjhm())%>
        
    </td>
</TR>
<tr>

     <td class=td1 align=right>
        成立日期：
    </td>
    <td class=td1>
 		<%=tJgdm.getZcrq() == null ? "" : DateUtil.dateToStr(tJgdm.getZcrq())%>
    </td>
   <td class=td1 align=right >
        发证日期：
    </td>
    <td class=td1>
       <%=tJgdm.getBzrq() == null ? "" : DateUtil.dateToStr(tJgdm.getBzrq())%>
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自：
    </td>
    <td class=td1>
    <%=tJgdm.getYxqxs() == null ? "" : DateUtil.dateToStr(tJgdm.getYxqxs())%>

        </A>
    </td>
   <td class=td1 align=right >
        有效期限至：
    </td>
    <td class=td1>
     <%=tJgdm.getZfrq() == null ? "" :DateUtil.dateToStr(tJgdm.getZfrq())%>
    </td>
</tr>
<TR>
    <td class=td1 align=right>
         住所：
    </td>
    <td class=td1 colSpan=3>
        <%=clsStringTool.convertNull(tJgdm.getJgdz())%>
    </td>
</TR>
<TR> 
    <td class=td1 align=right>
        住所行政区划：
    </td>
    <td class=td1  style="position:relative;display:block;overflow:visible;">
        <%=InitSysParams.xzqhMap.get(tJgdm.getXzqh()) == null ? "" : InitSysParams.xzqhMap.get(tJgdm.getXzqh())%>
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
    <%
    if("3".equals(tJgdm.getJglx())){
    %>
     <td class=td1 align=right>
             基金会类型：
    </td>
    <td class=td1>
        <%=clsStringTool.convertNull(tJgdm.getJjhlx())%>
    </td>
   <%
    }
   %>
   <%
	if("1".equals(tJgdm.getJglx())){
   %>

   <td class=td1 align=right>
   活动地域：
    </td>
   <td class=td1 >
         <%=clsStringTool.convertNull(tJgdm.getHddy())%>
    </td>
   
   <%
	}
   %>
   <%
	if("2".equals(tJgdm.getJglx())){
   %>
    <td class=td1 align=right >
        登记类型：
    </td>
   
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <%=InitSysParams.jjlx2k1Map==null?"":InitSysParams.jjlx2k1Map.get(tJgdm.getJjlx2011() == null ? "" : tJgdm.getJjlx2011().trim()) == null ? "" : InitSysParams.jjlx2k1Map.get(tJgdm.getJjlx2011().trim())%>
    </TD>
    <%
	}
   %>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  start -->

<TR>
	<td class="td1" align="right">是否为慈善组织</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getCishan()))?"是":"否"%>
	</td>
	<td class="td1" align="right">是否取得募捐资格</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getMujuan()))?"是":"否"%>
	</td>
</TR>
<%
	if("1".equals(tJgdm.getJglx())){
   %>
<TR>
	<td class="td1" align="right">是否为脱钩单位</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getTuogou()))?"是":"否"%>
	</td>
	<td class="td1" align="right"></td>
	<td class="td1" align="left"></td>
</TR>
   <%
	}
   %>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  end -->

<!-- lvwei 20170420 直接登记类型  start -->
<TR>
	<td class="td1" align="right">直接登记类型</td>
	<td class="td1" align="left">
	<%=("1").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"非直接登记类":""%>
	<%=("2").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"公益慈善类直接登记":""%>
	<%=("3").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"行业协会商会类直接登记":""%>
	<%=("4").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"科技类直接登记":""%>
	<%=("5").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"社区服务类直接登记":""%>
	<%=("6").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"其他类直接登记":""%>
	</td>	
</TR>	
<!-- lvwei 20170420 直接登记类型  end -->




<TR>
    <td class=td1 align=right>
        业务范围：
    </td>
    <td class=td1 colSpan=3 colspan=3>
       <%=clsStringTool.convertNull(tJgdm.getJyfw())%>
    </td>
</TR>
<tr>
	
	<td class=td1 align=right>
            法定代表人手机：
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
         <%=clsStringTool.convertNull(tJgdm.getMobile())%>
    </TD>
    	<td class=td1 align=right>
            法定代表人座机：
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <%=clsStringTool.convertNull(tJgdm.getFrdhhm())%>

    </TD>

</tr>
<TR>
    <td class=td1 align=right>
        注册资金：
    </td>
    <td class=td1>
        <fmt:formatNumber value='<%=tJgdm.getZczj()==null?0:tJgdm.getZczj()%>' pattern="##.0000" />万元
    </td>
    <td class=td1 align=right>
        货币种类：
    </td>
    <td class=td1>
       
             <DIV>
            <%
                List<THb> list = InitSysParams.thbList;
                if (list != null && list.size() > 0) {
                    for (THb hb : list) {
                        if (hb != null) {
                            if (clsStringTool.convertNull(hb.getDm()).equals(tJgdm.getHbzl())) {
                                out.print(hb.getMc());
                                break;
                            }
                        }
                    }
                }
            %>
        </DIV>
       
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        经济行业：
    </td>
          <td class=td1 style="position:relative;display:block;overflow:visible;">
       ${jgdm.jjhy2011}
        <%=InitSysParams.jjhy2k1Map.get(tJgdm.getJjhy2011()) == null ? "" : InitSysParams.jjhy2k1Map.get(tJgdm.getJjhy2011())%>
    </td>
<td class=td1 align=right>
        批准文号：
    </td>
    <td  class=td1>
        <%=clsStringTool.convertNull(tJgdm.getZch())%>
    </td>

</TR>

<TR>
    <td class=td1 align=right>
        邮政编码 ：
    </td>
    <td class=td1>
         <%=clsStringTool.convertNull(tJgdm.getYzbm())%>
    </td>
    <td class=td1 align=right>
        单位联系电话 ：
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <%=clsStringTool.convertNull(tJgdm.getDhhm())%>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	电子邮箱：
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
         <%=clsStringTool.convertNull(tJgdm.getEmail())%>
    </TD>
    <td class=td1 align=right>
        网址：
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <%=clsStringTool.convertNull(tJgdm.getUrl())%>
    </TD>
   
</TR>
<tr>
       <td class=td1 align=right>
        业务主管单位名称：
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getZgmc())%>
    </td>
    <td class=td1 align=right>
        业务主管单位代码：
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getZgdm())%>

    </td>

</TR>
<TR>
    <td class=td1 align=right>
        	专职工作人员数量：
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZzrysl()))%>
       
    </td> 
   
 
     <td class=td1 align=right>
        兼职工作人员数量：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getJzrysl()))%>
      
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	理事人数：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getLssl()))%>

    </td> 
   
 
     <td class=td1 align=right>
           监事人数：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getJssl()))%>
       
    </td>
</TR>
  <%
	if("1".equals(tJgdm.getJglx())){
   %>
   <TR>
    <td class=td1 align=right>
        	常务理事人数：
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(String.valueOf(tJgdm.getCwlssl()))%>

    </td> 
   
 
</TR>
<TR>
    <td class=td1 align=right>
        	社团会员（单位会员）数量：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getDwhysl()))%>

    </td> 
   
 
     <td class=td1 align=right>
        社团会员（个人会员）数量：
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getGrhysl()))%>

    </td>
</TR>
<%
	}
%>
<tr>
    
    <td class=td1 align=right>
        	经办人姓名：
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(tJgdm.getTbrxm())%>

    </td>
     <td class=td1 align=right>
     &nbsp;<%
         zjlxList = InitSysParams.tZjlxList;
        if (zjlxList != null && zjlxList.size() > 0) {
            for (TZjlx zjlx : zjlxList) {
                if (zjlx != null) {
                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getTbrzjlx())) {
                        out.print(zjlx.getMc() + "：");
                        break;
                    }
                }
            }
        }
    %>

    </td>
    
    <td class=td1>
     	
      <%=clsStringTool.convertNull(tJgdm.getTbrsfzh())%>

    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人手机：
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(tJgdm.getTbrmobile())%>

    </td> 
   
 <td class=td1 align=right>
        	经办人座机：
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(tJgdm.getTbrlxfs())%>

    </td> 
     
</TR> 


<TR>
    <td class=td1 align=right>
        	开户银行：
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getKhyh())%>

    </td> 
   
 <td class=td1 align=right>
        	开户帐号：
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getKyzh())%>

    </td> 
     
</TR>



<tr>

    <td class=td1 align=right>
        	备注：
    </td>
     <td class=td1 colSpan=3>
     <%=clsStringTool.convertNull(tJgdm.getMemo())%>

    </td>
 </tr>


