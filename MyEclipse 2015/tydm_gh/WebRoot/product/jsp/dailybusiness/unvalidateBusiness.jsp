<%--@elvariable id="needAudit" type="java.lang.boolean"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>

<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
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
    String jglx = (String) request.getAttribute("jglx");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/dtree.js"></script>
    
    
    
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript">
    	$(function(){   $("#fzyj").focus();  })
    	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
		function formSubmit() {
            document.busForm.submit();
            
        }
    function validateBus() {

        <c:if test="${audit &&!needAudit}">
        document.busForm.btok.disabled  "disabled";
        document.busForm.btok1.disabled = "disabled";
        document.busForm.submit();
        return true;
        </c:if>
        <c:if test="${!(audit &&!needAudit)}">
        return fCheckValue();
        </c:if>


    }
    function redoAudit() {
        document.busForm.action = "/bsweb/business_search.action";
        document.busForm.btok.disabled = "disabled";
        document.busForm.btok1.disabled = "disabled";
        document.busForm.submit();
    }
    function back() {

        <c:if test="${source eq 'pendApproval'}">
        window.location.href = '/bsweb/pendApproval_list';
        </c:if>
        <c:if test="${source eq 'unvalidate'}">
        window.location.href = '/bsweb/business_list?source=unvalidate&jglx=${jgdm.jglx}';
        </c:if>

    }
   /*  function all ( request){
    	Enumeration e = request.getParameterNames();
      
      while(e.hasMoreElements())
      {
        String name = (String)e.nextElement();
        String value = request.getParameter(name);
        alert(name+":"+value);
      }
    } */
</script>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="left" style=" float: left;"><strong>登记 &gt;&gt;  <%
  	if("1".equals(jglx)){
  %>  
    社会团体业务
    <%
  	}
    %>
    <%
  	if("2".equals(jglx)){
  %>  
    民办非企业单位业务
    <%
  	}
    %>
    <%
  	if("3".equals(jglx)){
  %>  
    基金会业务
    <%
  	}
    %> &gt;&gt; 注销恢复</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit?"newBtn1":"newBtn1"}"
               onClick="${needAudit?'return validateBus();':'document.busForm.submit()'}"  type=button
               value="${needAudit?"提交审核":"恢 复"}"
               name="btok">
        &nbsp;
        <INPUT class="newBtn1" onClick=" back()" type=button value="返 回" name='cmdExit'>
        &nbsp;
    </div>
</div>
<form method="post" action="/bsweb/business_${needAudit==true?"auditUnValidate":"unValidate"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.tyshxydm" id="tyshxydm" value="${jgdm.tyshxydm}"/>
    <input type="hidden" name="jgdm.jgdm" id="jgdm" value="${jgdm.jgdm}"/>
    <input type="hidden" name="jgdm.jglx" id="jglx" value="${jgdm.jglx}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>
    <input type="hidden" name="type" value="unvalidate" id="nameType"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>
    <input type="hidden" name="source" value="unvalidate" id="source"/>
    <INPUT type="hidden" name="isxb" id="isxb" value="zxhf"/>
    
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <c:choose>
                        <c:when test="${audit &&!needAudit}">
                        <h3><b>代码恢复</b></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
							<TR>
							    <TD class="td1" align="right">
							        统一代码：
							    </TD>
							    <TD class="td1" colSpan="3">
							        ${jgdm.tyshxydm }
							    </TD>
							</TR>
                            <jsp:include page="../common/show-jgdm.jsp"/>
                        </TABLE>
                        </c:when>
                    
                    	<c:otherwise>
		                    <h3><b>基础数据项</b><span>（请注意：此区域内容必须填写。）</span></h3>
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
		                                统一社会信用代码
		                            </TD>
		                            <TD class=td1 >
		                                    ${jgdm.tyshxydm}
		                            </TD>
		                            <TD class=td1 align=right width="15%">
		                                    ${jgdm.njrq ne null ?'上次年检':''}
		                            </TD>
		                            <TD class=td1 >
		                                <c:if test="${jgdm.njrq ne null}">
		                                    <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"/>
		                                </c:if>
		                            </TD>
		                        </TR>
		                       <jsp:include page="../common/edit-jgdm-part1.jsp"/>
		                    </TABLE>
                    	</c:otherwise>
                    </c:choose>
                    
                    <%-- <jsp:include page="../common/show-fzr.jsp"/> --%>
                    <div id="list_context" class="list listblue">
	<h3><b>工会组织简况</b></h3>
<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<tr>
	<td class=td1 align=right width="15%">
        发证机关
    </td>
    <td  class=td1 colspan="3">
        <input  
               
              disabled  maxlength="70" size=28 name="zgmc" id="zgmc" value="${jgdm.zgmc}" style=" width:75%"/>
		<span style="color:red">*</span>

       <span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span>
  
    </td>
</tr>
<tr>
	   <td class=td1 align=right>
        	现职工人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zgrs" id="zgrs"
              style=" width:200px;" value="${jgdm.zgrs}"/>
             
    </td> 
 
   <%--  <td class=td1 align=right>
  
               专职工会干部数
    </td> 
     <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="gbrs" id="gbrs"
               style=" width:200px;" value="${jgdmSave.gbrs}"/>
    </td>  --%>
</tr>
<%-- <tr>
	   <td class=td1 align=right>
        	工会届数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="ghjs" id="ghjs"
             id="zzgzrysl" style=" width:200px;" value="${jgdmSave.ghjs}"/>
             
    </td> 
 
   <td class=td1 align=right>
        	电话
    </td>
     <td class=td1>
       <INPUT onkeyup="onlyDecimalTel(this);" onafterpaste="onlyDecimalTel(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=25 size=19 name="ghzxdh" id="ghzxdh"
                style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td> 
</tr>
 --%><tr>
	   <td class=td1 align=right>
        	会员人数
    </td>
    <td>
    	     <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="hyrs" id="hyrs"
               id="zzgzrysl" style=" width:200px;" value="${jgdm.hyrs}"/>
    </td>
       <td class=td1 align=right>
        	工会主席姓名
    </td>
    <td>
    	     <INPUT  name="ghzxmc" id="ghzxmc"
                style=" width:200px;" value="${jgdm.ghzxmc}"/><!-- onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 -->
    </td>
</tr>
</table>
</div>
<div id="list_context" class="list listblue">
	<h3><b>收入情况</b></h3>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">

<h3><b>经费情况</b></h3>
<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right width="15%">
        经费
   		</td>
		<td class=td1>
			<SELECT name="qtsr_1" id="qtsr_1"  onchange="jingFeiChange()">
				<OPTION value="1" >有结余经费</OPTION>
				<OPTION value="0" ${jgdm.qtsr==0?'selected':''}>有稳定的经费来源</OPTION>
			</SELECT>
			<FONT color=red> * </FONT>
		</td>
		<td class=td1 align=right id="shue_1">
			数额
		</td>
		<td class=td1 id="shue_2">		              
             <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.qtsr" id="qtsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.qtsr}' pattern="0.0000"/>"/>              
        		<FONT color=red>
            		万元*
        		</FONT>
        		<span style="color:red;" id="mcInfo"></span>
		</td>	
	</tr>
</table>

<h3><b> 固定资产情况</b></h3>
	 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
		<TR>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.gdzj" id="gdzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.gdzj}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
    </td>
    </table>
    
    
 <h3><b>场所情况</b></h3>
 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
     <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.cshj" id="cshj" style=" width:200px;"
               value="${jgdm.cshj}"/>
    
         <FONT color=red>
            平方米
        </FONT>
        </td>
</table>
 
   <%--  <td class=td1 align=right>
     流动资金(万元)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="ldzj" id="ldzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.ldzj}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
       
    <span style="color:red">*</span>
    </td> --%>
</TR>
<%-- <TR>
    <td class=td1 align=right>
        其他
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="qtzj" id="qtzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.qtzj}' pattern="0.0000"/>"/>
    
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        合计
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="hjzj" id="hjzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.hjzj}' pattern="0.0000"/>"/>
   
       
    <span style="color:red">*</span>
    </td>
</TR> --%>
	</table>
</div>
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
		<%-- <tr>
			<td class=td1 align=right width="15%">
				姓名
			</td>
			<td class=td1>
				<input value="${tfddbr.xm }" type="text" class="tfddbr.xm" id="xm" style="z-index: 100; position: relative; width:200px;" name="fddbr.xm" maxlength="50" onkeyup="onlyMc(this);"/>
				<span style="color:red">*</span>
			</td>
			  
		<c:forEach items="${zjlxList}" var="zjlx">
            <OPTION value="${zjlx.dm}" ${jgdm.tbrzjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
        </c:forEach>
			
			<td class=td1 align=right>
				民族
			</td>
				
				<td class=td1>
				<SELECT name="fddbr.mz" id="mz">
						<c:forEach items="${mList}" var="mz">
    		 								 <OPTION value="${mz.dm}" ${list.mz==mz.dm?"selected":"" }>${mz.mc} </OPTION>
 										</c:forEach>
 								    </SELECT>
 								    <span style="color:red">*</span>
				
			     <SELECT name="tfddbr.mz" id="mz">
			     
				 <c:forEach items="${mList}" var="mz">
				  <c:if test="tfddbr.mz eq mz.dm">
				 <option value="tfddbr.mz" selected="selected">${mz.mc }</option>
				 	
				 </c:if> 
				 <c:if test="tfddbr.mz ne mz.dm">
				  <OPTION value="${mz.dm}" >${mz.mc } </OPTION>
				 </c:if>
				 
          		 <!-- ${tfddbr.mz==mz.dm?'selected':'no' } -->
          		 	  
       			 </c:forEach>
       			
       			 </SELECT>
       			 <span style="color:red">*</span>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				性别
			</td>
			<td class=td1 >
				<SELECT name="fddbr.xb" id="xb">
				<OPTION value="男">男 </OPTION>
				<OPTION value="女">女</OPTION>
				</SELECT>
				<span style="color:red">*</span>
			</td>
			<td class=td1 align=right>
				文化程度
			</td>
			<td class=td1>
				<input type="text" value="${tfddbr.xl }" name="fddbr.xl" id="xl" style="width:200px;" maxlength="500">
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				出生年月
			</td>
			<td class=td1 >
				<input type="text" value=<fmt:formatDate value='${fddbr.csrq}' pattern='yyyy-MM-dd'/> name="fddbr.csrq" id="csrq" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
				   <A hideFocus onclick="WdatePicker({el:$dp.$('csrq')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
				<span style="color:red">*</span>
			</td>
			<td class=td1 align=right>
				政治面貌
			</td>
				<td class=td1>
			<SELECT name="fddbr.zzmm" id="zzmm" >
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}">${zz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
		</tr>
		<tr>
	<td class=td1 align=right>
            法人手机
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
            法人座机
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
				<input type="text" value="${tfddbr.yb }" name="fddbr.yb" id="yb"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" style="width:200px">
			</td>
			<td class=td1 align=right>
				电子邮箱
			</td>
			<td class=td1>
				<input type="text" value="${tfddbr.email }" name="fddbr.email" id="email1" maxlength="100" style="width:200px">
			</td>
		
		</tr>
		<tr>
		
			<td class=td1 align=right>
				现任工会职务
			</td>
			<td class=td1>
				<input type="text" value="${tfddbr.zw }" name="fddbr.zw" id="zw" style="width:200px" maxlength="500">
			</td>
      
			<td class=td1 align=right>
				本届任职起始时间
			</td>
			<td class=td1 >
				<input type="text" value=<fmt:formatDate value='${tfddbr.rzsj }' pattern='yyyy-MM-dd'/> name="fddbr.rzsj" id="rzsj" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});"  readonly="true">
				 <A hideFocus onclick="WdatePicker({el:$dp.$('rzsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
				<span style="color:red">*</span>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				属专职兼职
			</td>
				</td>
				<td class=td1>
				<SELECT name="fddbr.iszz" id="iszz">
				<OPTION value="0">专职</OPTION>
				<OPTION value="1">兼职</OPTION>
				</SELECT>
			</td>
			<td class=td1 align=right>
				现任其他职务
			</td>
			<td class=td1>
				<input type="text" value="${tfddbr.qtzw }" name="fddbr.qtzw" id="qtzw" style="width:200px" maxlength="500">
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				何时加入工会组织
			</td>
			<td class=td1>
			<input type="text" value=<fmt:formatDate value='${tfddbr.rhsj}' pattern='yyyy-MM-dd'/> name="fddbr.rhsj" id="rhsj" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
			 <A hideFocus onclick="WdatePicker({el:$dp.$('rhsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A>
			</td>
			<td class=td1 align=right>
				身份证号码
			</td>
			<td class=td1 >
				<input type="text" value="${tfddbr.zjhm }" id="zjhm" name="fddbr.zjhm" style="width:200px" maxlength="18">
				<span style="color:red">*</span>
			</td>
		</tr> --%>
	</table>

</div> 
</div> 
              <%--      <div type = 'hideen' id="list_context" class="list listblue">
                    <h3><b>负责人信息</b></h3>
                    <h3>卧槽1</h3>
                    <button >点id那</button>
                    <input value="${listFzr}" />
                    <c:forEach varStatus="i" var="list" items="${listFzr}">
                  	<h3>卧槽2</h3>
                    <div>
                    	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
                    	<input type="hidden" name="fzr.id" value="${list.lsh }"/>
                    	<h3>卧槽3</h3>
								<tr>
									<td class=td1 align=right width="15%">
										姓名
									</td>
									<td class=td1>
										<input type="text" name="fzr.xm" id="fzrXm" value="${list.xm }" maxlength="50" style="z-index: 100; position: relative; width:200px;">
											<c:if test="${i.count eq 1}">
										<INPUT class="button" onClick="copyFr()" type="button" value=复制 name="btselect2"/>&nbsp;
										</c:if>
										<span style="color:red">*</span>
									</td>
									<td class=td1 align="right">&nbsp;
        								<SELECT name="fzr.zjlx" id="ryzjlx"/>
        			    				 <c:forEach items="${zjlx}" var="zj">
    					    				 <OPTION value="${zj.dm}" ${list.zjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
        								 </c:forEach>
        								</SELECT>
   										</td>
		
		
										<td class=td1>
										<input type="text" maxlength="18" id="fzrZjhm" name="fzr.zjhm" onpaste=" showFzrLength();" onkeyup="onlySfzh(this);showFzrLength();" value="${list.zjhm }">
										<span style="color:red">*</span>
										       <INPUT class="num no-border-bx" name="fzrzjhmlength" id="fzrzjhmlength"         
              									 tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
               							 <script type="text/javascript">
               							showFzrLength1();
        								</script>
										</td>
								
								</tr>
								<tr>
									<td class=td1 align=right>
										性别
									</td>
									<td class=td1>
										<SELECT name="fzr.xb" id="xb">
											<OPTION value="男" ${'男' eq list.xb?"selected":""}>男 </OPTION>
											<OPTION value="女" ${'女' eq list.xb?"selected":""}>女</OPTION>
										</SELECT>
										<span style="color:red">*</span>
									</td>
									<td class=td1 align=right>
										职务
									</td>
									<td class=td1>
									<input type="text" value="${zList }">
										<SELECT name="fzr.zw" id="zw">
											 <c:forEach items="${zList}" var="zw">
          		 								 <OPTION value="${zw.dm}" ${list.zw==zw.dm?"selected":"" }>${zw.mc} </OPTION>
       										 </c:forEach>
       									</SELECT>
       									<span style="color:red">*</span>
									</td>
									
								</tr>
								
								<tr>
									<td class=td1 align=right>
										民族
									</td>
									<td class=td1>
										<SELECT name="fzr.mz" id="mz">
				 							<c:forEach items="${mList}" var="mz">
          		 								 <OPTION value="${mz.dm}" ${list.mz==mz.dm?"selected":"" }>${mz.mc} </OPTION>
       										</c:forEach>
       								    </SELECT>
       								    <span style="color:red">*</span>
									</td>
									<td class=td1 align=right>
										国别
									</td>
									<td class=td1>
										<SELECT name="fzr.gj" style="width:200px"/>
				 							<c:forEach items="${gList}" var="gj">
          		  								<OPTION value="${gj.dm}" ${list.gj==gj.dm?"selected":"" }>${gj.mc} </OPTION>
       			 							</c:forEach>
        								</SELECT>
        								<span style="color:red">*</span>
									</td>
								
								</tr>
									<tr>
									<td class=td1 align=right>
										任职时间
									</td>
									<td class=td1>
									       <INPUT  onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});"
									               maxLength="10" size=""   onclick="WdatePicker({el:$dp.$(this)});"   name="fzr.memo1" id="rzsj" style="z-index: 100; position: relative; width:200px;" value="<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd'/>"
									                style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true"/>
									                <span style="color:red">*</span>
									       
									</td>
									<td class=td1 align=right>
										政治面貌
									</td>
									<td class=td1>
											<SELECT name="fzr.zzmm" id="zzmm">
											 <c:forEach items="${zzList}" var="zz">
          		 								 <OPTION value="${zz.dm}" ${list.zzmm==zz.dm?"selected":"" }>${zz.mc} </OPTION>
       			 							 </c:forEach>
       			 							</SELECT>
									</td>
									
								</tr>
								<tr>
									<td class=td1 align=right>
										工作单位
									</td>
									<td class=td1>
										<input type="text" name="fzr.dzdw" value="${list.dzdw }" maxlength="200" style="z-index: 100; position: relative; width:200px;">
									</td>
									<td class=td1 align=right>
											专职/兼职
									</td>
									<td class=td1>
										<SELECT name="fzr.iszz" id="iszz">
											<OPTION value="0" ${'0' eq list.iszz?"selected":"" }>专职</OPTION>
											<OPTION value="1" ${'1' eq list.iszz?"selected":"" }>兼职</OPTION>
										</SELECT>
									</td>
								</tr>
									<tr>
									<td class=td1 align=right>
										座机
									</td>
									<td class=td1>
										<input type="text" name="fzr.lxdh" id="fzrLxdh" value="${list.lxdh }" onpaste="showDhLength();" onkeyup="onlyDecimalTel(this);showDhLength();" maxlength="25" style="z-index: 100; position: relative; width:200px;">
																       <INPUT class="num no-border-bx" name="fzrlxdhlength" id="fzrlxdhlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
               							<script type="text/javascript">
               							showDhLength1();
        								</script>
									</td>
									<td class=td1 align=right>
									手机
									</td>
									<td class=td1>
										<input type="text" name="fzr.lxmobile" id="fzrMobile" onkeyup="onlyDecimalTel(this);onlyDecimalZero(this);showMobileLength();" onafterpaste="onlyDecimalZero(this);showMobileLength();" value="${list.lxmobile }" maxlength="25" >
														       <INPUT class="num no-border-bx" name="fzrsjlength" id="fzrsjlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
              							<script type="text/javascript">
               							showMobileLength1();
        								</script>
									</td>
								
								</tr>
									<tr>
									<td class=td1 align=right>
										通讯地址
									</td>
									<td class=td1 colSpan=3>
										<input type="text" name="fzr.txdz" size="158" style="width:75%;" value="${list.txdz }" maxlength="200" >
									</td>
									</tr>
									<tr>
									<td class=td1 align=right>
										邮编
									</td>
									<td class=td1>
										<input type="text" name="fzr.yb" value="${list.yb }" maxLength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);">
									</td>
									
									<td class=td1 align=right>
										电子邮箱
									</td>
									<td class=td1>
										<input type="text" name="fzr.email" value="${list.email }" maxlength="100">
									</td>
									
								</tr>
								
								<c:if test="${i.count ne 1}">
								<tr>
									<td align="right" colspan="4">			<INPUT class="newBtn1" onClick="deletelingjian(this)" type=button value="移除" name="btok"/></td>
								</tr>
								</c:if>
								
						
								
							</table>
							
							<!-- <hr  color="#88a6d4" width="80%" style="...."/> -->
							<hr  width="80%" style="color:#88a6d4 "/>
							</div>
						
                    </c:forEach>
	                    <c:if test="${listFzr eq '[]'}">
	                    <jsp:include page="../common/fzronload.jsp"/>
	                    </c:if>
                </div>
               --%>  
                    
                <div class="listbtn">
                    <INPUT class="${needAudit?"newBtn1":"newBtn1"}"
                     onClick="formSubmit()"
                          <%--  onClick="${needAudit?'return validateBus();':'document.busForm.submit()'}" --%> type=button
                           value="${needAudit?"提交审核1":"恢 复"}"
                           name="btok" />
                           <c:if test="${needAudit}">
                           &nbsp;<!-- <INPUT class="newBtn1" type=button onClick="add_div()" value="添加负责人"/> -->
                           </c:if>
                           &nbsp;<INPUT class="newBtn1" onClick="back()" type=button value="返 回"
                                                    name='cmdExit'/>
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</body>
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
 
function jingFeiChange(){
     	var objS = document.getElementById("qtsr_1").value;
        if(objS == '0'){
        	$("#shue_1").hide(); 
        	$("#shue_2").hide(); 
        	document.getElementById("qtsr").value = "0";
        }else{
        	$("#shue_1").show();
        	$("#shue_2").show();
        }   
} 

</script>
<jsp:include page="../common/onload.jsp"/>
</html>
