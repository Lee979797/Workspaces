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
    //把从t_jgdm表中取得的数据复制到t_jgdm_save中，用于公用一个页面
    if ("4".equals(formType) || "3".equals(formType)) {
        TJgdm tjgdm = (TJgdm) request.getAttribute("tjgdm");
        BeanUtilsEx.copyProperties(tJgdm, tjgdm);
        action = "updateJgdm";
    } else {
        tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
    }
    String title = "申请表登记";
    if ("4".equals(formType)) {
        title = "申请表修改";
    }
    String bzDate = tJgdm.getBzrq() == null ? "" : DateUtil.dateToStr(tJgdm.getBzrq());
    //String njDate = tJgdm.getNjqx() == null ? "" : DateUtil.dateToStr(tJgdm.getNjqx());
    String zfDate = tJgdm.getZfrq() == null ? "" : DateUtil.dateToStr(tJgdm.getZfrq());
    //如果是换证功能

    if ("3".equals(formType)) {
        action = "certChange";
        bzDate = DateUtil.dateToStr(new Date());
        //zfDate = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 48);
       // njDate = "";
        //TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
        //1是定期年检 0是办证日期加一年
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
    <title>选择办证机构</title>
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
  		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'工商二维码扫描', iframe: true});
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
                    ymPrompt.alert({message: data + "不能为空!", width: 330, height: 220, title: '提示信息', handler: function (tp) {
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


        //申请表修改
         function addTableSubmit() {
            // if(${source == 'update'}){
             //ymPrompt.confirmInfo({message: "如果（<font color=red>机构名称、机构地址、注册号</font>）进行修改，申请表将无法删除！是否继续？", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                // if ("ok" == tp) {
                    
           // return fCheckValue();
                // }
             //}});
           //  }else{
             return fCheckValue('${jglx}');

                // }

        }

    </script>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div style=" float: left;"><strong> 登记 &gt;&gt; 
     <%
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
    %> &gt;&gt;
        <% if ("2".equals(formType)) { %>
        机构名称(<%=jgmc%>)预赋码更新
        <%} else if ("4".equals(formType)) {%>
        机构代码(<%=tJgdm.getJgdm()%>)信息修改
        <%} else if ("3".equals(formType)) {%>
        机构名称(<%=jgmc%>)换证
        <%} else if ("1".equals(formType)) {%>
        机构名称(<%=jgmc%>)其他部门赋码修改
        <%} else {%>
        机构名称(<%=jgmc%>)信息修改
        <%}%></strong>
    </div>
    <div align="right" style="width: 30% ; float: right;">
   
        <%if ("3".equals(formType)) {%>
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('<%=jglx %>');" type=button value="换 证" name="btok"/>
        <%}%>
        <%if (!"3".equals(formType)) {%>
        <INPUT class="newBtn1" onClick="javascript:return addTableSubmit();" type=button value="修 改" name="btok"/>
        <%}%>&nbsp;
        <%
            if ("0".equals(formType) || "1".equals(formType) || "2".equals(formType)) {
        %>
        <INPUT class="newBtn1"
               onClick="window.location.href='certificate_list.action?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
               type=button value="返 回" name="cmdExit"/>
        <%
            }
        %>

        <%
            if ("3".equals(formType)) {
        %>
        <c:if test="${djblx ne null}">
            <INPUT class="newBtn1" onClick="window.location.href='onLine_jdList.action?ywlx=3&opt=wsywjd&zt=3'" type=button
                   value="返 回" name="cmdExit"/>
        </c:if>
        <c:if test="${djblx eq null}">
            <INPUT class="newBtn1"
                   onClick="window.location.href='certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                   type=button value="返 回" name="cmdExit"/>
        </c:if>
        <%
            }
        %>

        <%
            if ("4".equals(formType)) {
        %>
        <INPUT class="newBtn1"
               onClick="window.location.href='certificate_operList.action?pageno=${pageno}&rowNumsView=${rowNumsView}'"
               type=button value="返 回" name="cmdExit"/>
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
    <input type="hidden" name="jglx" value="<%=jglx %>">
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
                   	<%
	if("2".equals(jglx)){
   %>
<h3><b>民办非企业单位登记证书</b></h3>
   <%
	}
   %>
   	<%
	if("1".equals(jglx)){
   %>
<h3><b>社会团体法人登记证书</b></h3>
   <%
	}
   %>
   	<%
	if("3".equals(jglx)){
   %>
<h3><b>基金会法人登记证书</b></h3>
   <%
	}
   %>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                                                        
                            <%
                                if ("4".equals(formType) || "3".equals(formType)) {
                            %>
                            <TR>
                                <TD class=td1 width="15%" align="right">
                                    统一代码
                                </TD>
                                <TD class=td1>
                                    <INPUT readonly="true" size=28 name="tyshxydm" id="tyshxydm" value="<%=tJgdm.getTyshxydm()%>"
                                           style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"/>
                                </TD>
                                <td class=td1 width="15%" align="right"></td>
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
              
                            <%@ include file="common_edit_choose1Save.jsp" %>

                        </TABLE>
                    </div>
                     <div id="dj" class="list listblue">
					<h3><b>党建信息	&nbsp;&nbsp;
	   <INPUT onclick="fChangeDangJian(0);" type=radio
      value="0" name="isdang" ${("0"==tJgdm.isdang )?"checked":""}/>
        已建立党组织&nbsp;&nbsp;
        <INPUT onclick="fChangeDangJian(1);" type=radio  value="1"  name="isdang" ${("1"==tJgdm.isdang )?"checked":""}/>
    未建立党组织</b></h3>
	

    
	<div id="dangjian" style="${"1" eq tJgdm.isdang?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
    

     <td class=td1 style="width:15%" align=right>
    	 党组织类型
    </td>
    
    <td class=td1>
     	
     
   
          <SELECT name="dzzlx" id="dzzlx" style="width:200px"/>
            <c:forEach items="${dzzlxList}" var="dzzlx">
          <OPTION value="${dzzlx.dm}" ${tJgdm.dzzlx==dzzlx.dm?"selected":""} >${dzzlx.mc} </OPTION>
         </c:forEach>
         
        </SELECT>
    </td>
</TR>
<tr>
 <td class=td1 align=right>
    	 党组织负责人
    </td>
    
    <td class=td1>
     	
     
   
          <input name="dzzfzr" id="dzzfzr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.dzzfzr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="dzzfzrzjlx" id="dzzfzrzjlx"/>
   
          <c:forEach items="${zjlxList}" var="zj">
          <OPTION value="${zj.dm}" ${tJgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="dzzfzrzjhm" id="dzzfzrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);"
               value="${tJgdm.dzzfzrzjhm }">
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
     	
     
   
          <input name="djlxr" id="djlxr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.djlxr }">
    </td>
    <td class=td1 align=right>
      <SELECT name="djlxrzjlx" id="djlxrzjlx"/>
   
          <c:forEach items="${zjlxList}" var="zj">
       			 <OPTION value="${zj.dm}" ${tJgdm.dzzfzrzjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="djlxrzjhm" id="djlxrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
        onpaste=" showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);"
               value="${tJgdm.djlxrzjhm }">
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
         <input name="djlxrdhhm" id="djlxrdhhm" type="text" maxLength="25"
           onpaste=" showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);"
          style="z-index: 100; position: relative; width:200px;" value="${tJgdm.djlxrdhhm }">
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
               name="tdzzclrq" id="dzzclrq" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true"
               value="<fmt:formatDate value='${tJgdm.dzzclrq}' pattern='yyyy-MM-dd'/>"
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
         <input name="sjdzzmc" id="sjdzzmc" type="text" maxLength="60" style="width:75%;" value="${tJgdm.sjdzzmc }">
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       专职工作人员数量中党员数量
    </td>
    <td class=td1>
         <input name="zzdysl" id="zzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.zzdysl }">
    </td>
     <td class=td1 align=right>
    	兼职工作人员数量中党员数量
    </td>
    
    <td class=td1>
     	
     
   
          <input name="jzdysl" id="jzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="${tJgdm.jzdysl }">
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="${"0" eq tJgdm.isdang?"display:none":"dsiplay:block" }">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right>
		未建立原因
		</td> 
		<td class=td1>
		<SELECT name="wjlyy" id="wjlyy" style="width:300px"/>
		 	<c:forEach items="${yyList}" var="yy">
       			 <OPTION value="${yy.dm}" ${tJgdm.wjlyy==yy.dm?"selected":""} >${yy.mc} </OPTION>
         	</c:forEach>
        </SELECT>
		</td>
	</tr>
	</TABLE>
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
										<input type="text" name="fzr.xm" style="z-index: 100; position: relative; width:200px;"  id="fzrXm" value="${list.xm }" maxlength="50" >
										 <c:if test="${i.count eq 1}">
										 <INPUT class="button" onClick="copyFr()" type="button" value=复制 name="btselect2"/>&nbsp;
										 </c:if>
										<span style="color:red">*</span>
									</td>
									<td class=td1 align="right">&nbsp;
        								<SELECT name="fzr.zjlx" id="ryzjlx"/>
        			    				 <c:forEach items="${zjlxList}" var="zj">
    					    				 <OPTION value="${zj.dm}" ${list.zjlx==zj.dm?"selected":""} >${zj.mc} </OPTION>
        								 </c:forEach>
        								</SELECT>
   										</td>
		
		
										<td class=td1>
										<input type="text" maxlength="18"  id="fzrZjhm"
										onpaste=" showFzrLength();" onkeyup="onlySfzh(this);showFzrLength();"
										 name="fzr.zjhm" value="${list.zjhm }">
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
										<SELECT name="fzr.zw" id="zw">
											 <c:forEach items="${zwList}" var="zw">
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
									        <INPUT  onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" style="z-index: 100; position: relative; width:200px;"
									               maxLength="10" size="" onclick="WdatePicker({el:$dp.$(this)});"
									               name="fzr.memo1" id="rzsj" value="<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd'/>"
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
											       <INPUT class="num no-border-bx" name="fzrlxdhlength" id="fzrlxdhlength" tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
               							<script type="text/javascript">
               							showDhLength1();
        								</script>
									</td>
									<td class=td1 align=right>
									手机
									</td>
									<td class=td1>
										<input type="text" name="fzr.lxmobile" id="fzrMobile" onkeyup="onlyDecimalTel(this);showMobileLength();" onafterpaste="onlyDecimalTel(this);showMobileLength();" value="${list.lxmobile }" maxlength="11" >
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
										<input type="text" name="fzr.txdz" size="158" style="width:75%;" value="${list.txdz }" maxlength="500" >
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
										<input type="text" name="fzr.email" value="${list.email }" maxlength="100" >
									</td>
									
								</tr>
								
								
								
						
								<c:if test="${i.count ne 1}">
								<tr>
									<td align="right" colspan="4"><INPUT class="newBtn1" onClick="deletelingjian(this)" type=button value="移除" name="btok"/></td>
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
                    <div class="listbtn">
                       
                     
                        <%if ("3".equals(formType)) {%>
                        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('<%=jglx %>');" type=button value="换 证"
                               name="btok"/>
                        <%}%>
                        <%if (!"3".equals(formType)) {%>
                        <INPUT class="newBtn1" onClick="javascript:return addTableSubmit();" type=button value="修 改"
                               name="btok"/><%}%>&nbsp;
                        <%
                            if ("0".equals(formType) || "1".equals(formType) || "2".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_list.action?formType=${formType}&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="返 回" name="cmdExit"/>
                        <%
                            }
                        %>

                        <%
                            if ("3".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_certOperList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="返 回" name="cmdExit"/>
                        <%
                            }
                        %>

                        <%
                            if ("4".equals(formType)) {
                        %>
                        <INPUT class="newBtn1"
                               onClick="window.location.href='certificate_operList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx %>'"
                               type=button value="返 回" name="cmdExit"/>
                        <%
                            }
                        %>
                        <INPUT class="newBtn1" type=button onClick="add_div()" value="添加负责人"/>&nbsp;
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
 

</script>
</html>
