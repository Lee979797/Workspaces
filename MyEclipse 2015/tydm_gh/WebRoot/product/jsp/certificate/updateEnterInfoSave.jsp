<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="net.sf.cglib.beans.BeanCopier" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.BeanUtilsEx" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    User user = (User) session.getAttribute("sysUser");
    TJgdmSave tJgdm = new TJgdmSave();
    String formType = request.getParameter("formType");
    Boolean needAudit = (Boolean) request.getAttribute("needAudit");
    Boolean audit = (Boolean) request.getAttribute("audit");
    Boolean repeatAudit = (Boolean) request.getAttribute("repeatAudit");
    if (clsStringTool.isEmpty(formType)) {
        formType = (String) request.getAttribute("formType");
    }
    String action = "update";
    //�Ѵ�t_jgdm����ȡ�õ����ݸ��Ƶ�t_jgdm_save�У����ڹ���һ��ҳ��
    if ("4".equals(formType) || "3".equals(formType)) {
        TJgdm tjgdm = (TJgdm) request.getAttribute("tjgdm");
        BeanUtilsEx.copyProperties(tJgdm, tjgdm);
        action = "updateJgdm";
    } else {
        tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
    }
    String title = "�����Ǽ�";
    if ("4".equals(formType)) {
        title = "������޸�";
    }
    String bzDate = tJgdm.getBzrq() == null ? "" : DateUtil.dateToStr(tJgdm.getBzrq());
    //String njDate = tJgdm.getNjqx() == null ? "" : DateUtil.dateToStr(tJgdm.getNjqx());
   // String zfDate = tJgdm.getZfrq() == null ? "" : DateUtil.dateToStr(tJgdm.getZfrq());
    //����ǻ�֤����

    if ("3".equals(formType)) {
        action = "certChange";
        bzDate = DateUtil.dateToStr(new Date());
        //zfDate = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 48);
       // njDate = "";
        //TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
        //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
        //if (zrxzqh != null && "0".equals(zrxzqh.getNjfs())) {
           // njDate = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12);
       // } else {
          // njDate = DateUtil.addMonth(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2), 12);
       // }
    }
    if ("2".equals(formType)) {
        bzDate = DateUtil.dateToStr(new Date());
    }
    String jgmc = tJgdm.getJgmc();
    if (jgmc.length() > 12) {
        jgmc = jgmc.substring(0, 12) + "...";
    }
    request.setAttribute("tJgdm", tJgdm);
    String jglx = (String) request.getAttribute("jglx");
%>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js?v=ss"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jglxBsxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/btxBus.js"></script>
      <script type="text/javascript">
      if('<%=UserPropertiesData.getValueByPropertyName("gsTwoCode")%>'=='on'){
  		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'���̶�ά��ɨ��', iframe: true});
  	}
    	
	$(function(){   $("#jgmc").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function getItems(items) {
            if (items && items.length > 0) {
                var fields = items.split(",");
                for (var i = 0; i < fields.length; i++) {
                    var item = $(fields[i]);
                    if (item != undefined && (item.val() == null || item.val() == '')) {
                        return fields[i].substring(1, fields[i].length);
                    }
                }
            }
            return undefined;
        }
        function checkNotNull() {
            var item = getItems($("#btxs").val());

            if (item == undefined || item == null) {
                return true;
            } else {
                dwr.engine.setAsync(false);
                btxBus.getFieldName(item, function (data) {
                    ymPrompt.alert({message: data + "����Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
                        if ("ok" == tp) {
                            $("#" + item).focus()
                            ;
                        }
                    }});
                });
                return false;
            }
        }
    </script>
    <script type="text/javascript">
        function auditSubmit() {
            document.busForm.action = '/bsweb/certificate_auditSubmit.action';
            return fCheckValue();
        }


        //������޸�
         function addTableSubmit() {
            // if(${source == 'update'}){
             //ymPrompt.confirmInfo({message: "�����<font color=red>�������ơ�������ַ��ע���</font>�������޸ģ�������޷�ɾ�����Ƿ������", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
                // if ("ok" == tp) {
                    
           // return fCheckValue();
                // }
             //}});
           //  }else{
             return fCheckValue('xb');

                // }

        }

    </script>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div style=" float: left;"><strong> �Ǽ� &gt;&gt; 
    ����ҵ�� &gt;&gt;</strong>
    </div>
    <div align="right" style="width: 30% ; float: right;">
   
        <%if ("3".equals(formType)) {%>
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('<%=jglx %>');" type=button value="�� ֤" name="btok"/>
        <%}%>
        <%if (!"3".equals(formType)) {%>
        <INPUT class="newBtn1" onClick="javascript:return addTableSubmit();" type=button value="�� ��" name="btok"/>
        <%}%>&nbsp;
        <%
            if ("0".equals(formType) || "1".equals(formType) || "2".equals(formType)) {
        %>
        <INPUT class="newBtn1"
               onClick="window.location.href='certificate_list.action?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
               type=button value="�� ��" name="cmdExit"/>
        <%
            }
        %>

        <%
            if ("3".equals(formType)) {
        %>
        <c:if test="${djblx ne null}">
            <INPUT class="newBtn1" onClick="window.location.href='onLine_jdList.action?ywlx=3&opt=wsywjd&zt=3'" type=button
                   value="�� ��" name="cmdExit"/>
        </c:if>
        <c:if test="${djblx eq null}">
            <INPUT class="newBtn1"
                   onClick="window.location.href='certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                   type=button value="�� ��" name="cmdExit"/>
        </c:if>
        <%
            }
        %>

        <%
            if ("4".equals(formType)) {
        %>
        <INPUT class="newBtn1"
               onClick="window.location.href='certificate_operList.action?pageno=${pageno}&rowNumsView=${rowNumsView}'"
               type=button value="�� ��" name="cmdExit"/>
        <%
            }
        %>

    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>
<form method="post" action="/bsweb/certificate_<%=action%>.action" name="busForm">
    <c:set var="formType" value="<%=formType%>"/>
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <input type="hidden" name="formType" id="formType" value="<%=formType%>"/>
    <input type="hidden" name="id" id="id" value="<%=tJgdm.getId()%>"/>
    <input type="hidden" name="bzjgdm" id="bzjgdm" value="<%=tJgdm.getBzjgdm()%>"/>
    <input type="hidden" name="needAudit" value="${needAudit}" id="needAudit"/>
    <input type="hidden" name="audit" value="${audit}" id="audit"/>
    <input type="hidden" name="pageno" value="${pageno}"/>
    <input type="hidden" name="rowNumsView" value="${rowNumsView}"/>
    <input type="hidden" name="ywlsh" value="${ywlsh}"/>

    <input type="hidden" name="nameType" id="nameType" value="<%=action%>Name"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>
    <input type="hidden" name="btxs" id="btxs"/>
    <INPUT type="hidden" name="djblx" id="djblx" value="${djblx}"/>
    <%-- <input type="hidden" name="jglx" value="<%=jglx %>"> --%>
    <INPUT type="hidden" name="isxb" id="isxb" value="xg"/>
    <INPUT type="hidden" name="jgdm" id="jgdm" value="<%=tJgdm.getJgdm() %>"/>
 <c:set var="date" value="${tJgdm.njrq}"/>
 <c:if test="${!(tJgdm.njrq eq null)}">
 <input type="hidden" name="njrq" value=" <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>"/>
           
        </c:if>
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">

                    <div class="list listblue">
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                                                        
                            <%
                                if ("4".equals(formType) || "3".equals(formType)) {
                            %>
                            <TR>
                                <TD class=td1 width="15%" align="right">
                                    ͳһ����
                                </TD>
                                <TD class=td1>
                                    <INPUT readonly="true" size=28 name="tyshxydm" id="tyshxydm" value="<%=tJgdm.getTyshxydm()%>"
                                           style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"/>
                                </TD>
                                <td class=td1 align="right"></td>
                                <td class=td1></td>
                            </TR>
                            <%
                            } else {
                            %>
                            <input type="hidden" name="jgdm"
                                   value="<%=tJgdm.getJgdm()==null?"":tJgdm.getJgdm().trim()%>"/>
                            <%
                                }

                               
                            %>
              
                            <%@ include file="common_edit_choose1Save2.jsp" %>

                        </TABLE>
                        <jsp:include page="../common/show_gh2.jsp"/>
 <div id="list_context" class="list listblue">
	<h3><b>�������������</b></h3>
	 
	 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
		<tr>
			<td class=td1 align=right width="15%">
				����������
			</td>
			<td class=td1>
				<input type="text" name="fddbr.xm" id="xm" style="z-index: 100; position: relative; width:200px;" maxlength="50" onkeyup="onlyMc(this);" value="${tfddbr.xm }">
			</td>
			  
		
			
			<td class=td1 align=right>
				����
			</td>
				<td class=td1>
			     <SELECT name="fddbr.mz" id="mz">
				 <c:forEach items="${mList}" var="mz">
          		  <OPTION value="${mz.dm}" ${tfddbr.mz == mz.dm?"selected":""}>${mz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				�Ա�
			</td>
			<td class=td1 >
				<SELECT name="fddbr.xb" id="xb">
				<OPTION value="��" ${tfddbr.xb eq '��'?"selected":""}>�� </OPTION>
				<OPTION value="Ů" ${tfddbr.xb eq 'Ů'?"selected":""}>Ů</OPTION>
				</SELECT>
			</td>
			<td class=td1 align=right>
				�Ļ��̶�
			</td>
			<td class=td1>
				<input type="text" name="fddbr.xl" id="xl" style="width:200px;" maxlength="500" value="${tfddbr.xl }">
			</td>
		</tr>
		<tr>
<%-- 			<td class=td1 align=right>
				��������
			</td>
			<td class=td1 >
				<input type="text" name="fddbr.csrq" id="csrq"  value="<fmt:formatDate value='${tfddbr.csrq}' pattern='yyyy-MM-dd'/>" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
				   <A hideFocus onclick="WdatePicker({el:$dp.$('csrq')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
			</td> --%>
			<input type="hidden" name="fddbr.csrq" id="csrq" value = "1900-01-01"/>
			<td class=td1 align=right>
				������ò
			</td>
				<td class=td1>
			<SELECT name="fddbr.zzmm" id="zzmm">
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}" ${tfddbr.zzmm == zzmm.dm?"selected":""}>${zz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
		</tr>
		<tr>
	<td class=td1 align=right>
            �ֻ�����
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
 			   onpaste="onlyDecimalTel(this);showLength(document.getElementById('lxmobile'), document.getElementById('mobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('lxmobile'), document.getElementById('mobilelength'), 18);"
               maxLength="11" size="28" name="fddbr.lxmobile" id="lxmobile"
               style=" width:200px;" value="${tfddbr.lxmobile }"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
            <INPUT class="num no-border-bx" id="mobilelength"
               tabIndex=100 readOnly size=4 value="" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("lxmobile"), document.getElementById("mobilelength"), 0);
        </script>
    </TD>
    	<td class=td1 align=right>
            ��������������
    </td>
     <TD class="td1">
        <INPUT
			   onpaste=" showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);"
               maxLength="25" size="28" name="fddbr.lxdh" id="lxdh"
               style=" width:200px;" value="${tfddbr.lxdh }"/>
        ${empty requireds['frdhhm']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
              <INPUT class="num no-border-bx" id="frdhhmlength"
               tabIndex=100 readOnly size=4 value="" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("lxdh"), document.getElementById("frdhhmlength"), 0);
        </script>
    </TD>

</tr>
	<tr>
			<td class=td1 align=right>
				ͨѶ��ַ
			</td>
			<td class=td1 colSpan=3>
				<input type="text" name="fddbr.txdz" id="txdz" size="158" style="width:75%;" maxlength="500" value="${tfddbr.txdz }">
			</td>
		</tr>
			<tr>
	
			<td class=td1 align=right>
				�ʱ�
			</td>
			<td class=td1>
				<input type="text" name="fddbr.yb" id="yb" value="${tfddbr.yb }"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" style="width:200px">
			</td>
			<td class=td1 align=right>
				��������
			</td>
			<td class=td1>
				<input type="text" name="fddbr.email" id="email1" value="${tfddbr.email }" maxlength="100" style="width:200px">
			</td>
		
		</tr>
		<tr>
		
			<td class=td1 align=right>
				���ι���ְ��
			</td>
			<td class=td1>
				<input type="text" name="fddbr.zw" id="zw" value="${tfddbr.zw }" style="width:200px" maxlength="500">
			</td>
      
			<td class=td1 align=right>
				������ְ��ʼʱ��
			</td>
			<td class=td1 >
				<input type="text" name="fddbr.rzsj" id="rzsj" value="<fmt:formatDate value='${tfddbr.rzsj}' pattern='yyyy-MM-dd'/>" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});"  readonly="true">
				 <A hideFocus onclick="WdatePicker({el:$dp.$('rzsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
			</td>
		</tr>		
		<tr>
				<td class=td1 align=right>
					��רְ��ְ
				</td>
					</td>
					<td class=td1>
					<SELECT name="fddbr.iszz" id="iszz" onchange="gradeChange()">	
					<OPTION value="1" ${tfddbr.iszz eq '1'?"selected":""}>��ְ</OPTION>
					<OPTION value="0" ${tfddbr.iszz eq '0'?"selected":""}>רְ</OPTION>
					</SELECT><FONT color=red> * </FONT>
			
					</td>
					<td class=td1 align=right id="job">
						��������ְ��
					</td>
					<td class=td1 id="job2">
						<input type="text" name="fddbr.qtzw" id="qtzw" value="${tfddbr.qtzw }" style="width:200px" maxlength="500"><FONT color=red> * </FONT>
					</td>	
									
		</tr>

			<%-- <td class=td1 align=right>
				��ʱ���빤����֯
			</td>
			<td class=td1>
			<input type="text" name="fddbr.rhsj" id="rhsj" value="<fmt:formatDate value='${tfddbr.rhsj}' pattern='yyyy-MM-dd'/>" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
			 <A hideFocus onclick="WdatePicker({el:$dp.$('rhsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
			</td> --%>
			<input type="hidden"  name="fddbr.rhsj" id="rhsj" value = "1900-01-01"/>
			<td class=td1 align=right>
				<SELECT name="fddbr.zjlx" id="zjlx"/>
           			<c:forEach items="${zjlxList}" var="zj">
         				<OPTION value="${zj.dm }" ${tfddbr.zjlx == zj.dm?"selected":""}>${zj.mc }</OPTION> 
         			</c:forEach>
        		</SELECT>
			</td>
			<td class=td1 >
				<input type="text" name="fddbr.zjhm" id="zjhm" value="${tfddbr.zjhm }" style="width:200px" maxlength="18">
			</td>
		</tr>
	</table>


	<%-- <h3><b>���˼���</b></h3>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
			<td class=td1 align=center >��ְʱ��</td>
			<td class=td1 align=center >������λ</td>
			<td class=td1 align=center >ְ��</td>
		</tr>
		<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj1" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj1 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw1" style="width:200px" maxlength="240" value="${frjl.gzdw1 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw1" style="width:200px" maxlength="100" value="${frjl.zw1 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj2"  style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj2 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw2" style="width:200px" maxlength="240" value="${frjl.gzdw2 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw2" style="width:200px" maxlength="100" value="${frjl.zw2 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj3" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj3 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw3" style="width:200px" maxlength="240" value="${frjl.gzdw3 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw3" style="width:200px" maxlength="100" value="${frjl.zw3 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj4" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj4 }">
			</td>
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw4" style="width:200px" maxlength="240" value="${frjl.gzdw4 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw4" style="width:200px" maxlength="100" value="${frjl.zw4 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj5" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj5 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw5" style="width:200px" maxlength="240" value="${frjl.gzdw5 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw5" style="width:200px" maxlength="100" value="${frjl.zw5 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj6" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj6 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw6" style="width:200px" maxlength="240" value="${frjl.gzdw6 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw6" style="width:200px" maxlength="100" value="${frjl.zw6 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj7" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj7 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw7" style="width:200px" maxlength="240" value="${frjl.gzdw7 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw7" style="width:200px" maxlength="100" value="${frjl.zw7 }">
			</td>
		</tr>
		<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj8" style="z-index: 100; position: relative; width:200px;" maxlength="100" value="${frjl.rzsj8 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw8" style="width:200px" maxlength="240" value="${frjl.gzdw8 }">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw8" style="width:200px" maxlength="100" value="${frjl.zw8 }">
			</td>
		</tr>
		<tr>
		<td class=td1 align=right>
        	��Ҫ˵��������
   		</td>
     <td class=td1 align=left colSpan=2>
        <INPUT  maxLength="500"
                size="158"
               name="frjl.wt"  style="width:75%;" value="${frjl.wt }"/>
    </td>
		</tr>
	</table>--%>
	</div>
</div>  
</div>
                    <div class="listbtn">
                       
                     
                        <%if ("3".equals(formType)) {%>
                        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('<%=jglx %>');" type=button value="�� ֤"
                               name="btok"/>
                        <%}%>
                        <%if (!"3".equals(formType)) {%>
                        <INPUT class="newBtn1" onClick="javascript:return addTableSubmit();" type=button value="�� ��"
                               name="btok"/><%}%>&nbsp;
                        <%
                            if ("0".equals(formType) || "1".equals(formType) || "2".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_list.action?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="�� ��" name="cmdExit"/>
                        <%
                            }
                        %>

                        <%
                            if ("3".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="�� ��" name="cmdExit"/>
                        <%
                            }
                        %>

                        <%
                            if ("4".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_operList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="�� ��" name="cmdExit"/>
                        <%
                            }
                        %>
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
<script type="text/javascript">
dwr.engine.setErrorHandler(function() { 
    // 
    }); 

function gradeChange(){
        var objS = document.getElementById("iszz").value;
        if(objS == '0'){
        	$("#job").hide(); 
        	$("#job2").hide();
        	document.getElementById("qtzw").value = "";
        }else{
        	$("#job").show();
        	$("#job2").show();
        }       
 }
 
$(document).ready(function(){    
    gradeChange();    
});    
$(document).ready(function(){    
    jingFeiChange();    
});  

</script>
</html>