<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>
<%--@elvariable id="audit" type="java.lang.String"--%>
<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript">
    if('<%=UserPropertiesData.getValueByPropertyName("gsTwoCode")%>'=='on'){
		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'工商二维码扫描', iframe: true});
	}
	
    	$(function(){   $("#fzyj").focus();  })
    	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
    </script>
    <script type="text/javascript">
        function validateBus() {

           
            	 return fCheckValue('bg');
            
            /* if (isEmpty(fzyj.value)) {
             ymPrompt.alert({message: "变更依据不能为空!", width: 330, height: 220, title: '提示信息', handler: function () {
             fzyj.focus();
             }});

             return false;
             } else {*/
           // if (fzyj.value.length > 25) {
              //  ymPrompt.alert({message: "变更依据长度不能超过25个汉字!", width: 330, height: 220, title: '提示信息', handler: function () {
                  //  fzyj.focus();
                //}});
               // return false;
           // }
            /* }
             if (isEmpty(fzreson.value)) {
             ymPrompt.alert({message: "变更原因不能为空!", width: 330, height: 220, title: '提示信息', handler: function () {
             fzreson.focus();
             }});

             return false;
             } else {*/
           // if (fzreson.value.length > 100) {
               // ymPrompt.alert({message: "变更原因长度不能超过100个汉字!", width: 330, height: 220, title: '提示信息', handler: function () {
                  //  fzreson.focus();
                //}});
               // return false;
           // }
//            }
            
           
        }
        function formSubmit() {
            document.busForm.submit();
            //  dwr.engine.setAsync(false);
            /* jgdmBus.problemDatas(document.getElementById("jgdm").value, function (data) {
             if (data != "false") {
             ymPrompt.confirmInfo({message: data.split(":")[1], width: 330, height: 220, title: '提示信息', handler: function (tp) {
             if (tp == 'ok') {
             document.busForm.submit()
             }
             }});
             }
             });*/
        }
        function back() {

            <c:if test="${source eq 'pendApproval'}">
            window.location.href = '/bsweb/pendApproval_list';
            </c:if>
            <c:if test="${source eq 'update_no'}">
            window.location.href = '/bsweb/business_list?source=update_no&jglx=${jglx}';
            </c:if>
            <c:if test="${source eq 'uploadProblemData'}">
            window.location.href = '/bsweb/qualityManager_uploadProblemData';
            </c:if>
            <c:if test="${source eq 'nationProblemData'}">
            window.location.href = '/bsweb/qualityManager_nationProblemData';
            </c:if>
            <c:if test="${source eq 'auditProblemData'}">
            window.location.href = '/bsweb/qualityManager_auditProblemData';
            </c:if>
        }

    </script>
</head>
<body onload = "fChangeDangJian(2);" >
<form method="post" action="/bsweb/business_${needAudit==true?"auditUpdate_no":"update_no"}.action" name="busForm"
      id="busForm" >
   
     <input type="hidden" name="jgdm.tyshxydm" value="${jgdm.tyshxydm}" id="tyshxydm"/>
     <input type="hidden"  value="${jgdm.jgdm}" id="jgdm"/>
    <input type="hidden" name="audit" id="audit" value="${audit}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="update" id="nameType"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>
    <input type="hidden" name="source" value="${source}" id="source"/>
    <input type="hidden" name="jgdm.njrq" value="<fmt:formatDate value='${jgdm.njrq}' pattern='yyyy-MM-dd'/>" id="njrq"/>
    <input type="hidden" name="mc" value="${jgdm.tyshxydm}" id="mc"/>
    <input type="hidden" name="jglx" value="${jglx }">
    <INPUT type="hidden" name="isxb" id="isxb" value="bg"/>
    <input type="hidden" name="updataType" value="true" id="updataType"/>
    <div class="page_top_fixed" style="background:#F8F8F8">
        <div align="left" style=" float: left;">登记 &gt;&gt;工会业务 &gt;&gt; 变更登记</div>
        <div align="right" style=" float: right;">
            <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" type=button
                   onclick="${audit?'formSubmit()':'return validateBus();'}"
                   value="${needAudit?"提交审核":"提交更新"}" name="btok"/>
            <c:if test="${!audit}">
                &nbsp;
                <INPUT class="newBtn1" type=button onclick="window.location.reload();" value="重 填" name='reset'/>
            </c:if>
            &nbsp;
            <INPUT class="newBtn1" onClick="back()"
                   type=button value="返 回"/>
           
        </div>
    </div>
<!--     
	<div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                <div class="list listblue">
                 &nbsp;  
          	<INPUT onclick="fChangeDangJian(0);" type=radio  value="0" name="isdang" id="isdang" hidden/>
        	<FONT SIZE="5">变更基本信息<font/>&nbsp;&nbsp;
        	<INPUT onclick="fChangeDangJian(1);" type=radio  value="1" name="isdang" id="isdang" hidden/>
    		<FONT SIZE="5">变更法人信息<font/>&nbsp;&nbsp;
     		<INPUT onclick="fChangeDangJian(2);" type=radio  value="2" name="isdang" id="isdang" checked/>
    		<FONT SIZE="5">同时变更<font/>    	
    </div> 
-->
                <div class="list listblue">
                     <h3><b>变更依据</b></h3>
                	<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
                	
                	<input value="2" name="isdang" id="isdang" type = "hidden"/>
                		<tr>
                			<td class=td1 align=right width="15%">
                				申请变更文号
                			</td>
                			 <TD class="td1" colspan="3">
       							<INPUT onblur="this.className='input_off';"
               						maxLength="120"  name="jgdm.bgwh" id="bgwh" 
               							style="width:75%;"/>
    						</TD>
                		</tr>
                		<div >
                		<tr id="jbxxwh">
                			<td class=td1 align=right>
                				批准变更文号
                			</td>
                			 <TD class="td1">
       							<INPUT onblur="this.className='input_off';"
               						maxLength="120" name="pzbgwh" id="pzbgwh"  style="width:200px;"/><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    						</TD>
    						<TD class="td1" align="right">
                				审批时间
                			</td>
                			 <TD class="td1" >
       							  <INPUT 
               maxLength="10" size="23" onfocus="this.className='input_on';WdatePicker({el:$dp.$('jlrq')}); "onclick="WdatePicker({el:$dp.$('jlrq')});"
               name="jlrq" id="jlrq"           
               style=" width:200px;" /><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
        	   <A hideFocus onclick="WdatePicker({el:$dp.$('jlrq')});" href="javascript:void(0)">
            	<IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
               </A>
    						</TD>
                		</tr>
                		</div>
                		<!-- 
                		<div  >
                		<tr style="display:none" id="frxxwh">
                			<td class=td1 align=right>
                				批准选举结果文号
                			</td>
                			 <TD class="td1">
       							<INPUT onblur="this.className='input_off';"
               						maxLength="120" name="xjwh" id="xjwh"  style="width:200px;"/>
    						</TD>
    						<TD class="td1" align="right">
                				审批时间
                			</td>
                			 <TD class="td1" >
       							  <INPUT 
               maxLength="10" size="23" onfocus="this.className='input_on';WdatePicker({el:$dp.$('xjrq')}); "onclick="WdatePicker({el:$dp.$('xjrq')});"
               name="xjrq" id="xjrq"
               style=" width:200px;" /><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
        	   <A hideFocus onclick="WdatePicker({el:$dp.$('xjrq')});" href="javascript:void(0)">
            	<IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
               </A>
    						</TD>
                		</tr>
                	</div> -->
                			<tr>
                			<td class=td1 align=right width="15%">
                				变更原因
                			</td>
                			<td>
								<SELECT name="bgyy" id="bgyy" >
									<OPTION value="1">名称变更</OPTION>
									<OPTION value="2">住所变更</OPTION>
									<OPTION value="3">法定代表人变更</OPTION>
									<OPTION value="4">登记管理机关变更</OPTION>
									<OPTION value="5">其他</OPTION>
								</SELECT>
								<FONT color=red> * </FONT>
							</td>
                		</tr>
                	</TABLE>
                </div>
                <div class="list listblue" id="jbxx">
                    <h3><b>基本信息</b></h3>
                        <%-----%>
                        <c:choose>

                        <c:when test="${audit &&!needAudit}">
                            <h3><b>代码变更</b></h3>
                            <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        审核结果：
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"通过":"未通过"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        审核依据：
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                               
                                <jsp:include page="../common/show-jgdm.jsp"/>
                            </TABLE>
                        </c:when>
                        <c:otherwise>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <c:if test="${audit}">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        审核结果
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"通过":"未通过"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        审核依据
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                            </c:if>
                            <TR>
                                <TD class=td1 align=right width="15%">
                                    统一代码
                                </TD>
                            
                                <TD class=td1 >
                                        ${jgdm.tyshxydm}
                                </TD>
                            </TR>
             
                            <jsp:include page="../common/edit-jgdm-part1.jsp"/>
                        </TABLE>
                       <jsp:include page="../common/show_gh.jsp"/>
                    </div>
                    
                    </c:otherwise>
                    </c:choose>
   <div id="fddbrxx" style="display:none">

   <div id="list_context" class="list listblue">
	<h3><b>法定代表人情况</b></h3>
	 
	 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
		<tr>
			<td class=td1 align=right width="15%">
				法定代表人
			</td>
			<td class=td1>
				<input type="text" name="fddbr.xm" id="xm" style="z-index: 100; position: relative; width:200px;"  maxlength="50" onkeyup="onlyMc(this);" value="${tfddbr.xm }">
				<FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
			  
		
			
			<td class=td1 align=right>
				民族
			</td>
				<td class=td1>
			     <SELECT name="fddbr.mz" id="mz">
				 <c:forEach items="${mList}" var="mz">
          		  <OPTION value="${mz.dm}" ${tfddbr.mz==mz.dm?"selected":"" }>${mz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				性别
			</td>
			<td class=td1 >
				<SELECT name="fddbr.xb" id="xb">
				<OPTION value="男" ${'男' eq tfddbr.xb?"selected":""}>男 </OPTION>
				<OPTION value="女" ${'女' eq tfddbr.xb?"selected":""}>女</OPTION>
				</SELECT><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
			<td class=td1 align=right>
				文化程度
			</td>
			<td class=td1>
				<input type="text" name="fddbr.xl" id="xl" style="width:200px;" maxlength="500" value="${tfddbr.xl }">
			</td>
		</tr>
		<tr>
		<%-- 	<td class=td1 align=right>
				出生年月
			</td>
			<td class=td1 >
				<input value="<fmt:formatDate value='${tfddbr.csrq}' pattern='yyyy-MM-dd'/>" type="text" name="fddbr.csrq" id="csrq"   style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
				   <A hideFocus onclick="WdatePicker({el:$dp.$('csrq')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td> --%>
			<input type="hidden" name="fddbr.csrq" id="csrq" value = "1900-01-01"/>
			<td class=td1 align=right>
				政治面貌
			</td>
				<td class=td1>
			<SELECT name="fddbr.zzmm" id="zzmm">
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}"${tfddbr.zzmm==zz.dm?"selected":"" }>${zz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
		</tr>
		<tr>
	<td class=td1 align=right>
            手机号码
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
        </script><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
    	<td class=td1 align=right>
            法定代表人座机
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
				通讯地址
			</td>
			<td class=td1 colSpan=3>
				<input type="text" name="fddbr.txdz" id="txdz" size="158" style="width:75%;" maxlength="500" value="${tfddbr.txdz }">
			</td>
		</tr>
			<tr>
	
			<td class=td1 align=right>
				邮编
			</td>
			<td class=td1>
				<input type="text" name="fddbr.yb" id="yb" value="${tfddbr.yb }"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" style="width:200px">
			</td>
			<td class=td1 align=right>
				电子邮箱
			</td>
			<td class=td1>
				<input type="text" name="fddbr.email" id="email1" value="${tfddbr.email }" maxlength="100" style="width:200px">
			</td>
		
		</tr>
		<tr>
		
			<td class=td1 align=right>
				现任工会职务
			</td>
			<td class=td1>
				<input type="text" name="fddbr.zw" id="zw" value="${tfddbr.zw }" style="width:200px" maxlength="500"><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
      
			<td class=td1 align=right>
				本届任职起始时间
			</td>
			<td class=td1 >
				<input value="<fmt:formatDate value='${tfddbr.rzsj}' pattern='yyyy-MM-dd'/>" type="text" name="fddbr.rzsj" id="rzsj"  style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});"  readonly="true">
				 <A hideFocus onclick="WdatePicker({el:$dp.$('rzsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
		</tr>
				<td class=td1 align=right>
					属专职兼职
				</td>
					</td>
					<td class=td1>
					<SELECT name="fddbr.iszz" id="iszz" onchange="gradeChange()">	
					<OPTION value="1" ${tfddbr.iszz eq '1'?"selected":""}>兼职</OPTION>
					<OPTION value="0" ${tfddbr.iszz eq '0'?"selected":""}>专职</OPTION>
					</SELECT><FONT color=red> * </FONT>
			
					</td>
					<td class=td1 align=right id="job">
						现任其他职务
					</td>
					<td class=td1 id="job2">
						<input type="text" name="fddbr.qtzw" id="qtzw" value="${tfddbr.qtzw }" style="width:200px" maxlength="500"><FONT color=red> * </FONT>
					</td>									
		</tr>
		<tr>
		<%-- 	<td class=td1 align=right> 
				何时加入工会组织
			</td>
			<td class=td1>
			<input value="<fmt:formatDate value='${tfddbr.rhsj}' pattern='yyyy-MM-dd'/>" type="text" name="fddbr.rhsj" id="rhsj"  style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
			 <A hideFocus onclick="WdatePicker({el:$dp.$('rhsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>  --%>
			<input type="hidden"  name="fddbr.rhsj" id="rhsj" value = "1900-01-01"/>
			<td class=td1 align=right>
				<SELECT name="fddbr.zjlx" id="zjlx"/>
           			<c:forEach items="${zjlx}" var="zj">
         				<OPTION value="${zj.dm }" ${tfddbr.zjlx==zj.dm?"selected":""}>${zj.mc }</OPTION> 
         			</c:forEach>
        		</SELECT><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
			<td class=td1 >
				<input type="text" id = "zjhm" name="fddbr.zjhm" value="${tfddbr.zjhm }" style="width:200px" maxlength="18"><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
			</td>
		</tr>
	</table>


<!-- 	<h3><b>个人简历</b></h3>
	<div>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
			<td class=td1 align=center >任职时间</td>
			<td class=td1 align=center >工作单位</td>
			<td class=td1 align=center >职务</td>
		</tr>
		<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj1" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw1" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw1" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj2"  style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw2" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw2" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj3" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw3" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw3" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj4" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw4" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw4" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
			<input type="text" name="frjl.rzsj5" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw5" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw5" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj6" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw6" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw6" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj7" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw7" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw7" style="width:200px" maxlength="100">
			</td>
		</tr>
			<tr>
			<td class=td1 align=center>
				<input type="text" name="frjl.rzsj8" style="z-index: 100; position: relative; width:200px;" maxlength="100">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.gzdw8" style="width:200px" maxlength="240">
			</td>
		
			<td class=td1 align=center>
				<input type="text" name="frjl.zw8" style="width:200px" maxlength="100">
			</td>
		</tr>
		<tr>
		<td class=td1 align=right>
        	需要说明的问题
   		</td>
     <td class=td1 align=left colSpan=2>
        <INPUT  maxLength="500"
                size="158"
               name="frjl.wt"  style="width:75%;"/>
    </td>
		</tr>
	</table>
	</div> -->
	</div> 
</div>
                    <div class="listbtn">
                        <INPUT class="newBtn1" type=button
                               onclick="${audit?'formSubmit()':'return validateBus();'}"
                               value="${needAudit?"提交审核":"提交更新"}"/>
                        <c:if test="${!audit}">&nbsp;<INPUT class="newBtn1" type=button onclick="window.location.reload(); " value="重 填"
                            name='reset'/>
                        </c:if>
                         <INPUT class="newBtn1" onClick="back()" type=button value="返 回"/>&nbsp;
                    </div>
                </div>

            </div>
 
        </div>
    </div>
</form>
<script type="text/javascript">
    //(function(){
        //changeBzrq(document.getElementById("bzrq"));
    //})();
</script>
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