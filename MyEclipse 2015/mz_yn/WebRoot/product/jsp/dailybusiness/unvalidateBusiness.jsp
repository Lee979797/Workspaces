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
    </script>
</head>
<script type="text/javascript">
    function validateBus() {

        <c:if test="${audit &&!needAudit}">
        document.busForm.btok.disabled = "disabled";
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
               onClick="${needAudit?'return validateBus();':'document.busForm.submit()'}" type=button
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
                    </div>
                    
                     <jsp:include page="../common/show-fzr.jsp"/>
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
                </div>
                
                
                    <div class="list listblue">
                    
                    					<h3><b>党建信息	&nbsp;&nbsp;
	   <INPUT onclick="fChangeDangJian(0);" type=radio
      value="0" name="jgdm.isdang" ${("0"==jgdm.isdang )?"checked":""}/>
        已建立党组织&nbsp;&nbsp;
        <INPUT onclick="fChangeDangJian(1);" type=radio  value="1"  name="jgdm.isdang" ${("1"==jgdm.isdang or  jgdm.isdang == null)?"checked":""}/>
    未建立党组织</b></h3>
	

    
	<div id="dangjian" style="${("1" eq jgdm.isdang or jgdm.isdang == null) ?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
    

     <td class=td1 style="width:15%" align=right>
    	 党组织类型
    </td>
    
    <td class=td1>
     	
     
   
          <SELECT name="jgdm.dzzlx" id="dzzlx" style="width:200px"/>
            <c:forEach items="${dzzlxList}" var="dzzlx">
          		<OPTION value="${dzzlx.dm}" ${jgdm.dzzlx==dzzlx.dm?"selected":""} >${dzzlx.mc} </OPTION>
         	</c:forEach>
         
        </SELECT>
    </td>
</TR>
<tr>
 <td class=td1 align=right>
    	 党组织负责人
    </td>
    
    <td class=td1>
     	
     
   
       <input name="jgdm.dzzfzr" id="dzzfzr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${jgdm.dzzfzr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="jgdm.dzzfzrzjlx" id="dzzfzrzjlx"/>
   
             <c:forEach items="${zjlx}" var="zj">
          <OPTION value="${zj.dm}" ${jgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="jgdm.dzzfzrzjhm" id="dzzfzrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);"
               value="${jgdm.dzzfzrzjhm }">
        <span id="pzjginfo"></span>
                      <INPUT class="num no-border-bx" id="dzzfzrzjhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dzzfzrzjhm"), document.getElementById("dzzfzrzjhmlength"), 0);
        </script>
    </td>
</tr>
<tr>
 <td class=td1 align=right>
    	 党建联系人
    </td>
    
    <td class=td1>
     	
     
   
          <input name="jgdm.djlxr" id="djlxr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${jgdm.djlxr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="jgdm.djlxrzjlx" id="djlxrzjlx"/>
   
          <c:forEach items="${zjlx}" var="zj">
       			 <OPTION value="${zj.dm}" ${jgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="jgdm.djlxrzjhm" id="djlxrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);"
               value="${jgdm.djlxrzjhm }">
        <span id="pzjginfo"></span>
                    <INPUT class="num no-border-bx" id="djlxrzjhmlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("djlxrzjhm"), document.getElementById("djlxrzjhmlength"), 0);
        </script>
    </td>
</tr>
<tr>
     <td class=td1 align=right>
       	党建联系人电话
    </td>
    <td class=td1>
         <input name="jgdm.djlxrdhhm" id="djlxrdhhm" type="text" maxLength="25" 
         onpaste=" showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);"
         style="z-index: 100; position: relative; width:200px;" value="${jgdm.djlxrdhhm }">
                      <INPUT class="num no-border-bx" id="djlxrdhhmlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("djlxrdhhm"), document.getElementById("djlxrdhhmlength"), 0);
        </script>
    </td>
     <td class=td1 align=right>
        	党组织成立时间
    </td>
    <td class=td1>
            <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('dzzclrq')}); "onclick="WdatePicker({el:$dp.$('dzzclrq')});"
               maxLength=10 size=23
               name="jgdm.dzzclrq" id="dzzclrq" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true"
               value="<fmt:formatDate value='${jgdm.dzzclrq}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('dzzclrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>
  
    
</TR>
<tr>
	  <td class=td1 align=right>
       	上级党组织名称
    </td>
    <td class=td1  colSpan=3>
         <input name="jgdm.sjdzzmc" id="sjdzzmc" type="text" maxLength="60" style="width:75%;" value="${jgdm.sjdzzmc }">
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       专职工作人员数量中党员数量
    </td>
    <td class=td1>
         <input name="jgdm.zzdysl" id="zzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${jgdm.zzdysl }">
    </td>
     <td class=td1 align=right>
    	兼职工作人员数量中党员数量
    </td>
    
    <td class=td1>
     	
     
   
          <input name="jgdm.jzdysl" id="jzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${jgdm.jzdysl }">
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="${"0" eq jgdm.isdang?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right>
		未建立原因
		</td> 
		<td class=td1>
	 	<SELECT name="jgdm.wjlyy" id="wjlyy" style="width:300px"/>
		 	<c:forEach items="${yyList}" var="yy">
       			 <OPTION value="${yy.dm}" ${jgdm.wjlyy==yy.dm?"selected":""} >${yy.mc} </OPTION>
         	</c:forEach>
        </SELECT>
		</td>
	</tr>
	</TABLE>
	</div>
 </div> 

					</div>
                   <div id="list_context" class="list listblue">
                    <h3><b>负责人信息</b></h3>
                    
                    <c:forEach varStatus="i" var="list" items="${listFzr}">
                  
                    <div>
                    	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
                    	<input type="hidden" name="fzr.id" value="${list.lsh }"/>
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
							
							<hr color="#88a6d4" width="80%" style="...."/>
							</div>
						
                    </c:forEach>

                    <c:if test="${listFzr eq '[]'}">
                    <jsp:include page="../common/fzronload.jsp"/>
                    </c:if>
                    
                   
                    </div>
                </c:otherwise>
                </c:choose>
                    
                <div class="listbtn">
                    <INPUT class="${needAudit?"newBtn1":"newBtn1"}"
                           onClick="${needAudit?'return validateBus();':'document.busForm.submit()'}" type=button
                           value="${needAudit?"提交审核":"恢 复"}"
                           name="btok">
                           <c:if test="${needAudit}">
                           &nbsp;<INPUT class="newBtn1" type=button onClick="add_div()" value="添加负责人"/>
                           </c:if>
                           &nbsp;<INPUT class="newBtn1" onClick="back()" type=button value="返 回"
                                                    name='cmdExit'>
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
 

</script>
<jsp:include page="../common/onload.jsp"/>
</html>
