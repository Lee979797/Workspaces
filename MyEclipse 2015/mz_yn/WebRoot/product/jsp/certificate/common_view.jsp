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
ͳһ������ô��룺
</td>
<td>
<%=clsStringTool.convertNull(tJgdm.getTyshxydm())%>
</td>
<td align="right">
��֤�������ƣ�
</td>
<td>
<%=tJgdm.getPzjgmc()%>
</td>
</tr>
<tr>
<td  colspan=1 align="right">
�������ƣ�
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
     <%=clsStringTool.convertNull(tJgdm.getFzxs())%>��

    </td>
    <%
    }else{
    %>

    <td class=td1 align=right>
     	  ����������/�����ˣ�
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
                        out.print(zjlx.getMc() + "��");
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
        �������ڣ�
    </td>
    <td class=td1>
 		<%=tJgdm.getZcrq() == null ? "" : DateUtil.dateToStr(tJgdm.getZcrq())%>
    </td>
   <td class=td1 align=right >
        ��֤���ڣ�
    </td>
    <td class=td1>
       <%=tJgdm.getBzrq() == null ? "" : DateUtil.dateToStr(tJgdm.getBzrq())%>
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       ��Ч�����ԣ�
    </td>
    <td class=td1>
    <%=tJgdm.getYxqxs() == null ? "" : DateUtil.dateToStr(tJgdm.getYxqxs())%>

        </A>
    </td>
   <td class=td1 align=right >
        ��Ч��������
    </td>
    <td class=td1>
     <%=tJgdm.getZfrq() == null ? "" :DateUtil.dateToStr(tJgdm.getZfrq())%>
    </td>
</tr>
<TR>
    <td class=td1 align=right>
         ס����
    </td>
    <td class=td1 colSpan=3>
        <%=clsStringTool.convertNull(tJgdm.getJgdz())%>
    </td>
</TR>
<TR> 
    <td class=td1 align=right>
        ס������������
    </td>
    <td class=td1  style="position:relative;display:block;overflow:visible;">
        <%=InitSysParams.xzqhMap.get(tJgdm.getXzqh()) == null ? "" : InitSysParams.xzqhMap.get(tJgdm.getXzqh())%>
    </td>
      <!--    <td class=td1 align=right>
        	������Ӫ����������
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
             ��������ͣ�
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
   �����
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
        �Ǽ����ͣ�
    </td>
   
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <%=InitSysParams.jjlx2k1Map==null?"":InitSysParams.jjlx2k1Map.get(tJgdm.getJjlx2011() == null ? "" : tJgdm.getJjlx2011().trim()) == null ? "" : InitSysParams.jjlx2k1Map.get(tJgdm.getJjlx2011().trim())%>
    </TD>
    <%
	}
   %>
<!-- xiaruibo 20170220 �Ƿ��ѹ�  �Ƿ���� �Ƿ�ļ��  start -->

<TR>
	<td class="td1" align="right">�Ƿ�Ϊ������֯</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getCishan()))?"��":"��"%>
	</td>
	<td class="td1" align="right">�Ƿ�ȡ��ļ���ʸ�</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getMujuan()))?"��":"��"%>
	</td>
</TR>
<%
	if("1".equals(tJgdm.getJglx())){
   %>
<TR>
	<td class="td1" align="right">�Ƿ�Ϊ�ѹ���λ</td>
	<td class="td1" align="left">
		<%=("1").equals(clsStringTool.convertNull(tJgdm.getTuogou()))?"��":"��"%>
	</td>
	<td class="td1" align="right"></td>
	<td class="td1" align="left"></td>
</TR>
   <%
	}
   %>
<!-- xiaruibo 20170220 �Ƿ��ѹ�  �Ƿ���� �Ƿ�ļ��  end -->

<!-- lvwei 20170420 ֱ�ӵǼ�����  start -->
<TR>
	<td class="td1" align="right">ֱ�ӵǼ�����</td>
	<td class="td1" align="left">
	<%=("1").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"��ֱ�ӵǼ���":""%>
	<%=("2").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"���������ֱ�ӵǼ�":""%>
	<%=("3").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"��ҵЭ���̻���ֱ�ӵǼ�":""%>
	<%=("4").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"�Ƽ���ֱ�ӵǼ�":""%>
	<%=("5").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"����������ֱ�ӵǼ�":""%>
	<%=("6").equals(clsStringTool.convertNull(tJgdm.getZjdjlx()))?"������ֱ�ӵǼ�":""%>
	</td>	
</TR>	
<!-- lvwei 20170420 ֱ�ӵǼ�����  end -->




<TR>
    <td class=td1 align=right>
        ҵ��Χ��
    </td>
    <td class=td1 colSpan=3 colspan=3>
       <%=clsStringTool.convertNull(tJgdm.getJyfw())%>
    </td>
</TR>
<tr>
	
	<td class=td1 align=right>
            �����������ֻ���
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
         <%=clsStringTool.convertNull(tJgdm.getMobile())%>
    </TD>
    	<td class=td1 align=right>
            ����������������
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <%=clsStringTool.convertNull(tJgdm.getFrdhhm())%>

    </TD>

</tr>
<TR>
    <td class=td1 align=right>
        ע���ʽ�
    </td>
    <td class=td1>
        <fmt:formatNumber value='<%=tJgdm.getZczj()==null?0:tJgdm.getZczj()%>' pattern="##.0000" />��Ԫ
    </td>
    <td class=td1 align=right>
        �������ࣺ
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
        ������ҵ��
    </td>
          <td class=td1 style="position:relative;display:block;overflow:visible;">
       ${jgdm.jjhy2011}
        <%=InitSysParams.jjhy2k1Map.get(tJgdm.getJjhy2011()) == null ? "" : InitSysParams.jjhy2k1Map.get(tJgdm.getJjhy2011())%>
    </td>
<td class=td1 align=right>
        ��׼�ĺţ�
    </td>
    <td  class=td1>
        <%=clsStringTool.convertNull(tJgdm.getZch())%>
    </td>

</TR>

<TR>
    <td class=td1 align=right>
        �������� ��
    </td>
    <td class=td1>
         <%=clsStringTool.convertNull(tJgdm.getYzbm())%>
    </td>
    <td class=td1 align=right>
        ��λ��ϵ�绰 ��
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <%=clsStringTool.convertNull(tJgdm.getDhhm())%>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	�������䣺
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
         <%=clsStringTool.convertNull(tJgdm.getEmail())%>
    </TD>
    <td class=td1 align=right>
        ��ַ��
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <%=clsStringTool.convertNull(tJgdm.getUrl())%>
    </TD>
   
</TR>
<tr>
       <td class=td1 align=right>
        ҵ�����ܵ�λ���ƣ�
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getZgmc())%>
    </td>
    <td class=td1 align=right>
        ҵ�����ܵ�λ���룺
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getZgdm())%>

    </td>

</TR>
<TR>
    <td class=td1 align=right>
        	רְ������Ա������
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZzrysl()))%>
       
    </td> 
   
 
     <td class=td1 align=right>
        ��ְ������Ա������
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getJzrysl()))%>
      
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	����������
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getLssl()))%>

    </td> 
   
 
     <td class=td1 align=right>
           ����������
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
        	��������������
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(String.valueOf(tJgdm.getCwlssl()))%>

    </td> 
   
 
</TR>
<TR>
    <td class=td1 align=right>
        	���Ż�Ա����λ��Ա��������
    </td>
    <td class=td1>
     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getDwhysl()))%>

    </td> 
   
 
     <td class=td1 align=right>
        ���Ż�Ա�����˻�Ա��������
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
        	������������
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
                        out.print(zjlx.getMc() + "��");
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
        	�������ֻ���
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(tJgdm.getTbrmobile())%>

    </td> 
   
 <td class=td1 align=right>
        	������������
    </td>
    <td class=td1>
      <%=clsStringTool.convertNull(tJgdm.getTbrlxfs())%>

    </td> 
     
</TR> 


<TR>
    <td class=td1 align=right>
        	�������У�
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getKhyh())%>

    </td> 
   
 <td class=td1 align=right>
        	�����ʺţ�
    </td>
    <td class=td1>
    <%=clsStringTool.convertNull(tJgdm.getKyzh())%>

    </td> 
     
</TR>



<tr>

    <td class=td1 align=right>
        	��ע��
    </td>
     <td class=td1 colSpan=3>
     <%=clsStringTool.convertNull(tJgdm.getMemo())%>

    </td>
 </tr>


