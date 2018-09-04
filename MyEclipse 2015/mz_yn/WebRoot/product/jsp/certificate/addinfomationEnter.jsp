<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    User user = (User) session.getAttribute("sysUser");
    String id = (String) request.getAttribute("id");
    String bzDate = DateUtil.dateToStr(new Date());
    String jglx = request.getParameter("jglx");
    String validate="";
    if("2".equals(jglx)){
    	
     validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
    }else{
    	validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 5), 1));
    }
    String dateLimit = "";
 
    //1是定期年检 0是办证日期加一年
    //if (zrxzqh != null) {
       // if ("0".equals(zrxzqh.getNjfs())) {
           // dateLimit = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12);
       // } else {
           // dateLimit = DateUtil.addMonth(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2), 12);
       // }
    //}

    String formType = request.getParameter("formType");
    if (clsStringTool.isEmpty(formType)) {
        formType = "0";
    }
    String title = "";
    if ("0".equals(formType)) {
        title = "机构代码登记表录入";
    }
    if ("1".equals(formType)) {
        title = "其他部门赋码登记表录入";
    }
    try {
%>
<c:set var="thbList" value="<%=InitSysParams.thbList%>"/>


<c:set var="njjlxList" value="<%=InitSysParams.tnnJjlxList%>"/>
<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>

<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMapMc1%>"/>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>

<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>

<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
 
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js"></script>
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
    <script type="text/javascript" src="/dwr/interface/qtmdkBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/btxBus.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath() %>/js/highslide-4.1.8/highslide/highslidezx.css"/>
    <script type="text/javascript"
            src="<%=request.getContextPath() %>/js/highslide-4.1.8/highslide/highslide-with-html.js"
            charset="gbk"></script>
            
     <script type="text/javascript">
    
     if('<%=UserPropertiesData.getValueByPropertyName("gsTwoCode")%>'=='on'&&'<%=request.getParameter("isGs")%>'!='1'){
    		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'工商二维码扫描', iframe: true});
    	}
 	
	  $(function(){   $("#zch").focus();  
	$("#memo2").val('小型微型企业');
	  })
	  document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	   
	</script>
    <script type="text/javascript">
        hs.graphicsDir = '<%=request.getContextPath() %>/js/highslide-4.1.8/highslide/graphics/';
        hs.outlineType = 'rounded-white';
        hs.showCredits = false;
        hs.wrapperClassName = 'draggable-header';
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

        function copyNameAndCard() {
            document.getElementById("tbrxm").value = document.getElementById("fddbr").value;
            document.getElementById("tbrsfzh").value = document.getElementById("zjhm").value;
            document.getElementById("tbrlxfs").value = document.getElementById("mobile").value;
            //onCharsChange_tbrsfzh("tbrsfzh");
            document.getElementById("charsmonitor_tbrsfzh").value = document.getElementById("tbrsfzh").value.length;
            document.getElementById("charsmonitor_tbrlxfs").value = document.getElementById("tbrlxfs").value.length;
        }
        function add(){
            document.busForm.submit();
            }
   
        </script>
  	
    <style type="text/css">
        .highslide-maincontent a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!------------------------------------------------------------------------------------------------->
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="left" style=" float: left;"><strong> 登记 &gt;&gt; 
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
    %>
     &gt;&gt; <%if ("1".equals(formType)) {%>信息补录<%}else{ %> 设立登记<%} %>
    </strong> 

    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('${jglx}');" type=button value="保 存" name="btok"/>&nbsp;
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}&jglx=${jglx }'" type=button value="返 回" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/certificate_add.action" name="busForm">
<input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="formType" id="formType" value="${formType }"/>
<input type="hidden" name="bzjgdm" id="bzjgdm" value="${fn:trim(sysUser.bzjgdm) }"/>
<input type="hidden" name="nameType" value="add" id="nameType"/>
<input type="hidden" name="submitType" value="0" id="submitType"/>  
<INPUT type="hidden" name="btxs" id="btxs"/>
<INPUT type="hidden" name="isxb" id="isxb" value="xb"/>
<input type="hidden" name="jglx" value="${jglx }"/>

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
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<%
    if ("1".equals(formType)) {
%>
<!-- xiaruibo 20180321  下面要把信息补录功能修改成可以直接录入18位统一代码到主库中(t_jgdm),把原来的事件都屏蔽掉 -->
<TR>

    <TD class=td1 align=right width="15%" id="needJgdm">
        统一代码
    </TD>
    <TD class=td1 width="35%">
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';return judgeJgdm(document.getElementById('dmInfo'));"
               maxLength=18 size=28 name="tyshxydm" id="tyshxydm" value="${jgdmSave.tyshxydm}" style=" width:200px;"/> 
        <span style="color:red">*</span>
        <span style="margin-left:5px;" id="dmInfo"></span>
    </TD>
    <td class=td1 width="15%" align="right"></td>
    <td class=td1></td>
</TR>
<!-- xiaruibo 20180321 下面这个TR是原信息补录功能,上面的是复制过去的 -->
<%-- <TR>

    <TD class=td1 align=right width="15%" id="needJgdm">
        机构代码
    </TD>
    <TD class=td1 width="35%">
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';return judgeJgdm(document.getElementById('dmInfo'));"
               maxLength=9 size=28 name="jgdm" id="jgdm" value="${jgdmSave.jgdm}" style=" width:200px;"/> 
               <INPUT class="button" onClick="infoPush()" type="button" value=提取
               name="btselect2"/>&nbsp;
        <span style="color:red;margin-left:5px;" id="dmInfo"></span>
    </TD>
    <td class=td1 width="15%" align="right"></td>
    <td class=td1></td>
</TR> --%>
<%
    }
%>

<TR>
    <td class=td1 align=right width="15%">
          名称
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=120 size=28 name="jgmc" id="jgmc" style="width:75%;"
                value="${jgdmSave.jgmc}"/>
           <span style="color:red">*</span>
        <span style="color:red;" id="mcInfo"></span>
    </td> 
</TR>

<TR>
	<%
	if("2".equals(jglx)){
   %>
    <td class=td1 align=right>
       <SELECT name="fzxs" id="fzxs"/>
         <OPTION value="法定代表人">法定代表人</OPTION>
         <OPTION value="负责人">负责人</OPTION>
       </SELECT>
    </td>
    <td class=td1>
        <INPUT maxLength=50 size=28 onkeyup="onlyMc(this);"
        	  onblur="this.className='input_off';trimIntputValue(this);"
                name="fddbr" id="fddbr" style=" width:200px;" value="${jgdmSave.fddbr}"/>
        <span style="color:red;" >*</span>
        <p style="color:red; top:25px; left:5px;" id="fddbrInfo"></p>
    </td>
    <%
    }else if("3".equals(jglx)){
    %>
     <td class=td1 align=right>
     	  法定代表人/负责人
    </td> 
    <td class=td1>
        <INPUT maxLength=50 size=28 onkeyup="onlyMc(this);"
        	  onblur="this.className='input_off';trimIntputValue(this);"
                name="fddbr" id="fddbr" style=" width:200px;" value="${jgdmSave.fddbr}"/>
        <span style="color:red;" >*</span>
        <p style="color:red; top:25px; left:5px;" id="fddbrInfo"></p>
    </td>    
	<%
	}else{
	 %>
    <td class=td1 align=right>
     	  法定代表人/负责人
    </td> 
    <td class=td1>
        <INPUT maxLength=50 size=28 onkeyup="onlyMc(this);"
        	  onblur="this.className='input_off';trimIntputValue(this);"
                name="fddbr" id="fddbr" style=" width:200px;" value="${jgdmSave.fddbr}"/>
        <span style="color:red;" >*</span>
        <p style="color:red; top:25px; left:5px;" id="fddbrInfo"></p>
    </td>
    <% 
    }
    %>
    
    <!-- 下面是原版负责人/法定负责人，四川要求民非(jglx为2)的不进行是否重复验证 -->
    <%-- <td class=td1 align=right>
     	  法定代表人/负责人
    </td> 
    <td class=td1>
        <INPUT maxLength=50 size=28 onkeyup="onlyMc(this);"
        	  onblur="this.className='input_off';trimIntputValue(this);return checkjudgeFddbr(<%=jglx %>);"
                name="fddbr" id="fddbr" style=" width:200px;" value="${jgdmSave.fddbr}"/>
        <span style="color:red;" >*</span>
        <p style="color:red; top:25px; left:5px;" id="fddbrInfo"></p>
    </td> --%>
    
   
    <td class=td1 align="right">&nbsp; 
        <SELECT name="zjlx" id="zjlx"/>
          <c:forEach items="${zjlx}" var="zj">
         <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
         </c:forEach>
        </SELECT>
    </td>
    <td class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
                onblur="this.className='input_off';trimIntputValue(this);return judgeFddbrZjh(<%=jglx %>);"
                onpaste=" showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);"
                maxLength=18 size="22" name="zjhm" id="zjhm" value="${jgdmSave.zjhm}"
                style=" width:200px; float:left; margin-right:5px;"/>
                <span style="color:red">*</span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="zjhmInfo"></span>
          <INPUT class="num no-border-bx" id="zjhmlength"
               tabIndex=100 readOnly size=4 value="${18 - fn:length(jgdmSave.zjhm)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("zjhm"), document.getElementById("zjhmlength"), 18);
        </script>
    </td>
</TR>
<tr>

     <td class=td1 align=right>
        成立日期
    </td>
    <td class=td1>
    <c:set var="bzDate" value="<%=DateUtil.strToDate(bzDate)%>"/>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')}); "onclick="WdatePicker({el:$dp.$('zcrq')});"
               maxLength=10 size=23
               name="tzcrq" id="zcrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${bzDate}' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('zcrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
        <span style="color:red">*</span>
    </td>
   <td class=td1 align=right >
        发证日期
    </td>
    <td class=td1>
        <c:set var="bzrq" value="${jgdmSave.bzrq}"/>
        <c:set var="bzDate" value="<%=DateUtil.strToDate(bzDate)%>"/>
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njfs}" id="njfs">
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njjzrq}" id="njjzrq">
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('bzrq')});"
               maxLength=10 size=23
               name="tbzrq" id="bzrq" 
               value="<fmt:formatDate value='${(bzrq == null )? bzDate: bzrq}' pattern='yyyy-MM-dd'/>"
               style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" onclick="WdatePicker({el:$dp.$('bzrq')});"
              readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('bzrq')});"
           href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle border=0 name=popcal/>
        </A>
        <span style="color:red">*</span>
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自
    </td>
    <td class=td1>
     <c:set var="bzDate" value="<%=DateUtil.strToDate(bzDate)%>"/>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('yxqxs')}); "onclick="WdatePicker({el:$dp.$('yxqxs')});"
               maxLength=10 size=23
               name="tyxqxs" id="yxqxs" readonly="true" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" 
               value="<fmt:formatDate value='${bzDate}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('yxqxs')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
        <span style="color:red">*</span>
    </td>
   <td class=td1 align=right >
        有效期限至
    </td>
    <td class=td1>
     <c:set var="bzDate" value="<%=DateUtil.strToDate(validate)%>"/>
    <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')}); "onclick="WdatePicker({el:$dp.$('zfrq')});"
               maxLength=10 size=23
               name="tzfrq" id="zfrq"  readonly="true" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${bzDate}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
        <span style="color:red">*</span>
    </td>
</tr>
<TR>
    <td class=td1 align=right>
         住所
    </td>
    <td class=td1 colSpan=3>
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="jgdz" id="jgdz" value="${jgdmSave.jgdz}" style="width:75%;"/>
                <span style="color:red">*</span>
    </td>
   
</TR>
<TR> 
    <td class=td1 align=right>
        住所行政区划
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" 
               maxLength=6 size=28 name="xzqh"
               id="xzqh" value="${fn:trim(jgdmSave.xzqh)}" style="z-index: 100; position: relative; width:200px;"/>
                 <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=选择
               name="btselect2"/>&nbsp;
               <span style="color:red">*</span>
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span>
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdmSave.xzqh)]==null?"":xzqhMap[fn:trim(jgdmSave.xzqh)]}</span>
    </td>
      <!--<td class=td1 align=right>
        	生产经营地行政区划
    </td>
    <td class=td1>
        <input name="scjyxzqh" id="scjyxzqh" type="text"  style="z-index: 100; position: relative; width:200px;"
               value="">
        <span id="pzjginfo"></span>
    </td>
    -->
    <%
    if("3".equals(jglx)){
    %>
     <td class=td1 align=right>
             基金会类型
    </td>
  
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jjhlx" id="jjhlx" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${jgdmSave.nnjjlx==jjlx.dm?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
         <span style="color:red">*</span>
    </TD>
  
   <%
    }
   %>
   <%
	if("1".equals(jglx)){
   %>

   <td class=td1 align=right>
   活动地域
    </td>
   <td class=td1>
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               name="hddy" id="hddy" value="${bzjgdmMap[fn:trim(sysUser.bzjgdm)]}" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  />
                  <span style="color:red">*</span>
    </td>
   <%
	}
   %>
   <%
	if("2".equals(jglx)){
   %>
    <td class=td1 align=right>
        登记类型
    </td>
   
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jjlx2011" id="jjlx2011" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${jgdmSave.nnjjlx==jjlx.dm?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
         <span style="color:red">*</span>
    </TD>
   
    <%
	}
   %>
</TR>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  start -->

<TR>
	<td class="td1" align="right">是否为慈善组织</td>
	<td class="td1" align="left">
		<SELECT name="cishan">
			<OPTION value="2">否</OPTION>
			<OPTION value="1">是</OPTION>
		</SELECT>
	</td>
	<td class="td1" align="right">是否取得募捐资格</td>
	<td class="td1" align="left">
		<SELECT name="mujuan">
			<OPTION value="2">否</OPTION>
			<OPTION value="1">是</OPTION>
		</SELECT>
	</td>
</TR>
<%
	if("1".equals(jglx)){
   %>
<TR>
	<td class="td1" align="right">是否为脱钩单位</td>
	<td class="td1" align="left">
		<SELECT name="tuogou">
			<OPTION value="2">否</OPTION>
			<OPTION value="1">是</OPTION>
		</SELECT>
	</td>
	<td class="td1" align="right"></td>
	<td class="td1" align="left"></td>
</TR>
   <%
	}
   %>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  end -->

<!-- lvwei   20170420 直接登记类型 start -->
<TR>
	<td class="td1" align="right">直接登记类型</td>
	<td class="td1" align="left">
		<SELECT name="zjdjlx">
<c:if test="${jglx eq '1'}">
			<OPTION value="1">非直接登记类</OPTION>
			<OPTION value="2">公益慈善类直接登记</OPTION>
			<OPTION value="3">行业协会商会类直接登记</OPTION>
			<OPTION value="4">科技类直接登记</OPTION>
			<OPTION value="5">社区服务类直接登记</OPTION>
			<OPTION value="6">其他类直接登记</OPTION>
</c:if>
<c:if test="${jglx eq '2'}">
			<OPTION value="1">非直接登记类</OPTION>
			<OPTION value="2">公益慈善类直接登记</OPTION>
			<OPTION value="4">科技类直接登记</OPTION>
			<OPTION value="5">社区服务类直接登记</OPTION>
			<OPTION value="6">其他类直接登记</OPTION>
</c:if>
<c:if test="${jglx eq '3'}">
			<OPTION value="1">非直接登记类</OPTION>
			<OPTION value="2">公益慈善类直接登记</OPTION>
</c:if>
		</SELECT>
	</td>
	<td class="td1" align="right">是否为志愿组织</td>
	<td class="td1" align="left">
		<SELECT name="zhiyuan">
			<OPTION value="2">否</OPTION>
			<OPTION value="1">是</OPTION>
		</SELECT>
	</td>
</TR>
<!-- lvwei   20170420 直接登记类型 end -->

<TR>
    <td class=td1 align=right>
        业务范围
    </td>
    <td class=td1 colSpan=3>
        <TEXTAREA onblur="trimIntputValue(this);"
                  name="jyfw" id="jyfw"
                  rows=3 cols=129 style="width:75%;margin-top:3px;">${fn:trim(jgdmSave.jyfw)}</TEXTAREA>
    <span style="color:red">*</span>
      <INPUT class="num no-border-bx" id="jyfwlength"
               tabIndex=100 readOnly size=4 value="${0 + fn:length(jgdmSave.jyfw)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("jyfw"), document.getElementById("jyfwlength"), 0);
        </script>
    </td>
</TR>
<tr>
	
	<td class=td1 align=right>
            法定代表人手机
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
 			   onpaste="onlyDecimalTel(this);showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);"
               maxLength="11" size="28" name="mobile" id="mobile"
               style=" width:200px;" value="${jgdmSave.mobile}"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
            <INPUT class="num no-border-bx" id="mobilelength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("mobile"), document.getElementById("mobilelength"), 0);
        </script>
        <span style="color:red">*</span>
    </TD>
    	<td class=td1 align=right>
            法定代表人座机
    </td>
     <TD class="td1">
        <INPUT
			   onpaste=" showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);"
               maxLength="25" size="28" name="frdhhm" id="frdhhm"
               style=" width:200px;" value="${jgdmSave.frdhhm}"/>
        ${empty requireds['frdhhm']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
              <INPUT class="num no-border-bx" id="frdhhmlength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("frdhhm"), document.getElementById("frdhhmlength"), 0);
        </script>
    </TD>

</tr>
<TR>
    <td class=td1 align=right>
        注册资金
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        货币种类
    </td>
    <td class=td1>
       
            <SELECT name="hbzl" id="hbzl" style=" width:200px;">
              
                    <OPTION value="156">156:人民币</OPTION>
              
            </SELECT>
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        经济行业
    </td>
          <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength=6 size=23
               name="jjhy2011" id="nnjjhy" value="${fn:trim(jgdmSave.jjhy2011)}"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class=button onClick="return selectUpWindow('t_nnjjhy');" type=button
               value=选择 name=btselect4/>&nbsp;
               <span style="color:red">*</span>
               <span style="position:absolute; top:25px; left:5px;" id="nnjjhy1"></span>
    </td>
    
    
	<td class=td1 align=right>
       	 批准文号
    </td>
    <td  class=td1>
        <input  
				onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeZch();"
                maxlength="70" size=28 name="zch" id="zch" value="${jgdmSave.zch}" style=" width:200px;"/>
		<span style="color:red">*</span>
   	<span style="color:red;" id="zchInfo" name="zchInfo"></span>
    </td>
</TR>

<TR>
    <td class=td1 align=right>
        邮政编码    
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength=6 size=28 name="yzbm"
               id="yzbm" style=" width:200px;" value="${jgdmSave.yzbm}"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </td>
    <td class=td1 align=right>
        单位联系电话 
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength=25
             onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
             size=19 name="dhhm" id="dhhm" style=" width:200px;" value="${jgdmSave.dhhm}"/>
            <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                    <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	电子邮箱
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               onblur="this.className='input_off';trimIntputValue(this);return emailCheck(this,document.getElementById('email_warning'));"
               maxLength="50" size="19"
               name="email" id="email" value="${jgdmSave.email}" style=" width:200px;"/>
        ${empty requireds['email']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000" id="email_warning" style="position:absolute; top:25px; left:5px;"></span>
    </TD>
    <td class=td1 align=right>
        网址
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               maxLength="50"
               size="19"
               name="url" id="url" value="http://" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
   
</TR>
<tr>
       <td class=td1 align=right>
        业务主管单位名称
    </td>
    <td class=td1>
        <input name="zgmc" id="zgmc" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="">
                <INPUT class="button" onClick="addZgdm()" type="button" value=查询
               name="btselect2"/>&nbsp;
        <span id="pzjginfo"></span>
    </td>
    <td class=td1 align=right>
        业务主管单位代码
    </td>
    <td class=td1>
        <input name="zgdm" id="zgdm" onkeyup="onlyNumber(this);" type="text" maxLength=18  style="z-index: 100; position: relative; width:200px;"
               value="">
               <INPUT class="button" onClick="addZgmc()" type="button" value=查询
               name="btselect2"/>&nbsp;
        <span id="pzjginfo"></span>
    </td>

</TR>
<TR>
    <td class=td1 align=right>
        	专职工作人员数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td> 
   
 
     <td class=td1 align=right>
        兼职工作人员数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jzrysl" id="jzrysl"
               id="jzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="lssl" id="lssl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.lssl}"/>
               <span style="color:red">*</span>
    </td> 
   
 
     <td class=td1 align=right>
           监事人数
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jssl" id="jssl"
               id="jzgzrysl" style=" width:200px;" value="${jgdmSave.jssl}"/>
              
    </td>
</TR>
  <%
	if("1".equals(jglx)){
   %>
   <TR>
    <td class=td1 align=right>
        	常务理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="cwlssl" id="cwlssl"
             style=" width:200px;" value="${jgdmSave.cwlssl}"/>
    </td> 
   
 
</TR>
<TR>
    <td class=td1 align=right>
        	社团会员（单位会员）数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="dwhysl" id="dwhysl"
                style=" width:200px;" value="${jgdmSave.dwhysl}"/>
    </td> 
   
 
     <td class=td1 align=right>
        社团会员（个人会员）数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="grhysl" id="grhysl"
                style=" width:200px;" value="${jgdmSave.grhysl}"/>
    </td>
</TR>
<%
	}
%>
<tr>
    
    <td class=td1 align=right>
        	经办人姓名
    </td>
    <td class=td1>
        <input name="tbrxm" id="tbrxm" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" onkeyup="onlyMc(this);"
               value="">
               <INPUT class="button" onClick="copy()" type="button" value=复制
               name="btselect2"/>&nbsp;
               <span style="color:red">*</span>
  
    </td>
     <td class=td1 align=right>
      <SELECT name="tbrzjlx" id="tbrzjlx"/>
   
           <c:forEach items="${zjlx}" var="zj">
         <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="tbrsfzh" id="tbrsfzh" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
        
         onpaste=" showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);"
               value="">
      <span style="color:red">*</span>
               <INPUT class="num no-border-bx" id="tbrsfzhlength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrsfzh"), document.getElementById("tbrsfzhlength"), 0);
        </script>
    </TD>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人手机
    </td>
    <td class=td1>
        <input name="tbrmobile" id="tbrmobile" type="text" maxLength="11"  style="z-index: 100; position: relative; width:200px;"
          onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
               value="">
        <span id="pzjginfo"></span>
                      <INPUT class="num no-border-bx" id="tbrmobilelength"
                     
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrmobile"), document.getElementById("tbrmobilelength"), 0);
        </script>
    </td> 
   
 <td class=td1 align=right>
        	经办人座机
    </td>
    <td class=td1>
        <input name="tbrlxfs" id="tbrlxfs" type="text" maxLength="25" style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               value="">
        <span id="pzjginfo"></span>
                          <INPUT class="num no-border-bx" id="tbrlxfslength"
                      
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrlxfs"), document.getElementById("tbrlxfslength"), 0);
        </script>
    </td> 
     
</TR> 

<%
    if ("1".equals(formType)) {
%>
<tr>
 <td class=td1 align=right>
        	开户银行
    </td>
    <td class=td1>
        <input name="khyh" id="khyh" type="text"  style="z-index: 100; position: relative; width:200px;"
      
               value="" maxlength="200">
    
        
    </td>
   
	 <td class=td1 align=right>
        	开户账号
    </td>
    <td class=td1>
        <input name="kyzh" id="kyzh" type="text"  style="z-index: 100; position: relative; width:200px;"
          onkeyup="onlyDecimalTel(this);"
               value="" maxLength="50">
   
             
        
    </td>
</TR>
<%
    }
%>




<tr>

    <td class=td1 align=right>
        	备注
    </td>
     <td class=td1 colSpan=3>
        <INPUT  maxLength="500"
                size="158"
               name="memo" id="memo" value="${jgdmSave.memo}" style="width:75%;"/>
    </td>
    </tr>
</TABLE>
</div>
<div id="dj" class="list listblue">
	<h3><b>党建信息	&nbsp;&nbsp;
	   <INPUT onclick="fChangeDangJian(0);" type=radio
      value="0" name="isdang" id="isdang"/>
        已建立党组织&nbsp;&nbsp;
        <INPUT onclick="fChangeDangJian(1);" type=radio  value="1" checked name="isdang" id="isdang"/>
    未建立党组织</b></h3>
	

    
	<div id="dangjian" style="display:none">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
    

     <td class=td1 style="width:15%" align=right>
    	 党组织类型
    </td>
    
    <td class=td1>
     	
     
   
        <SELECT name="dzzlx" id="dzzlx" style="width:200px"/>
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
     	
     
   
          <input name="dzzfzr" id="dzzfzr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="" onkeyup="onlyMc(this);">
    </td>
    <td class=td1 align=right>
      <SELECT name="dzzfzrzjlx" id="dzzfzrzjlx"/>
   
             <c:forEach items="${zjlx}" var="zj">
         <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="dzzfzrzjhm" id="dzzfzrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
        onpaste=" showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('dzzfzrzjhm'), document.getElementById('dzzfzrzjhmlength'), 18);"
               value="">
        <span id="pzjginfo"></span>
               <INPUT class="num no-border-bx" id="dzzfzrzjhmlength"
                      
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
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
     	
     
   
          <input name="djlxr" id="djlxr" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" value="" onkeyup="onlyMc(this);">
    </td>
    <td class=td1 align=right>
      <SELECT name="djlxrzjlx" id="djlxrzjlx"/>
   
             <c:forEach items="${zjlx}" var="zj">
         <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
         </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
     	
     
   
        <input name="djlxrzjhm" id="djlxrzjhm" type="text"  maxLength="18" style="z-index: 100; position: relative; width:200px;"
           onpaste=" showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('djlxrzjhm'), document.getElementById('djlxrzjhmlength'), 18);"
               value="">
                   <INPUT class="num no-border-bx" id="djlxrzjhmlength"         
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
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
         <input name="djlxrdhhm" id="djlxrdhhm" type="text" maxLength="25" style="z-index: 100; position: relative; width:200px;" 
          onpaste=" showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('djlxrdhhm'), document.getElementById('djlxrdhhmlength'), 18);"
         value="">
                   <INPUT class="num no-border-bx" id="djlxrdhhmlength"         
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
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
               readonly="true"
               name="tdzzclrq" id="dzzclrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdmSave.dzzclrq}' pattern='yyyy-MM-dd'/>"
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
         <input name="sjdzzmc" id="sjdzzmc" type="text" maxLength="60" style="width:75%;" value="" onkeyup="onlyMc(this);">
    </td>
</tr>
<tr>
    
    <td class=td1 align=right>
       专职工作人员数量中党员数量
    </td>
    <td class=td1>
         <input name="zzdysl" id="zzdysl" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" type="text" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="">
    </td>
     <td class=td1 align=right>
    	兼职工作人员数量中党员数量
    </td>
    
    <td class=td1>
     	
     
   
          <input name="jzdysl" id="jzdysl" type="text" onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;" maxLength="6" style="z-index: 100; position: relative; width:200px;" value="">
    </td>
</TR>
	</TABLE>
	</div>
	<div id="dangjianf" style="display:block">
	<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right>
		未建立原因
		</td> 
		<td class=td1>
		<SELECT name="wjlyy" id="wjlyy" style="width:300px"/>
         	<c:forEach items="${yyList}" var="yy">
       			 <OPTION value="${yy.dm}">${yy.mc} </OPTION>
         	</c:forEach>
        </SELECT>
		</td>
	</tr>
	</TABLE>
	</div>
</div> 



<div id="list_context" class="list listblue">
	<h3><b>负责人信息</b></h3>
	<div id="lizi1"> 
	
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<input type="hidden" name="fzr.id" value=""/>
		<tr>
			<td class=td1 align=right width="15%">
				姓名
			</td>
			<td class=td1>
				<input type="text" class="fzrxm" id="fzrXm" style="z-index: 100; position: relative; width:200px;" name="fzr.xm" maxlength="50" onkeyup="onlyMc(this);">
				 <INPUT class="button" onClick="copyFr()" type="button" value=复制
               name="btselect2"/>&nbsp;
				<span style="color:red">*</span>
			</td>
			    <td class=td1 align="right">&nbsp;
        			<SELECT name="fzr.zjlx" id="ryzjlx"/>
        			     <c:forEach items="${zjlx}" var="zj">
    					     <OPTION value="${zj.dm }">${zj.mc }</OPTION> 
        				 </c:forEach>
        			</SELECT>
   				</td>
		
		
			<td class=td1>
				<input type="text" maxlength="18"  id="fzrZjhm"
				 onpaste=" showFzrLength();" onkeyup="onlySfzh(this);showFzrLength();"
				name="fzr.zjhm" id="fzrzjhm">
				<span style="color:red">*</span>
				       <INPUT class="num no-border-bx" name="fzrzjhmlength" id="fzrzjhmlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
       
			</td>
		
		</tr>
		<tr>
			<td class=td1 align=right>
				性别
			</td>
			<td class=td1 >
				<SELECT name="fzr.xb" id="xb">
				<OPTION value="男">男 </OPTION>
				<OPTION value="女">女</OPTION>
				</SELECT>
				<span style="color:red">*</span>
			</td>
				<td class=td1 align=right>
				职务
			</td>
			<td class=td1>
			<SELECT name="fzr.zw" id="zw">
				 <c:forEach items="${zwList}" var="zw">
          		  <OPTION value="${zw.dm}">${zw.mc} </OPTION>
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
          		  <OPTION value="${mz.dm}">${mz.mc} </OPTION>
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
          		  <OPTION value="${gj.dm}" ${'156' eq gj.dm?"selected":"" }>${gj.mc} </OPTION>
       			 </c:forEach>
        	</SELECT>
        	<span style="color:red">*</span>
			</td>
		
		</tr>
			<tr>
			<td class=td1 align=right>
				任职时间
			</td>
			<td class=td1 >
				<input type="text" name="fzr.memo1"  style="z-index: 100; position: relative; width:200px;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true">
				<span style="color:red">*</span>
			</td>
				<td class=td1 align=right>
				政治面貌
			</td>
			<td class=td1>
			<SELECT name="fzr.zzmm" id="zzmm">
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}">${zz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
			</td>
			
		</tr>
			<tr>
				<td class=td1 align=right>
				工作单位
			</td>
			<td class=td1 >
				<input type="text" style="z-index: 100; position: relative; width:200px;" name="fzr.dzdw" maxlength="200" onkeyup="onlyMc(this);">
			</td>
			<td class=td1 align=right>
				专职/兼职
			</td>
			<td class=td1>
				<SELECT name="fzr.iszz" id="iszz">
				<OPTION value="0">专职</OPTION>
				<OPTION value="1">兼职</OPTION>
				</SELECT>
			</td>
		</tr>
			<tr>
			<td class=td1 align=right>
				座机
			</td>
			<td class=td1>
				<input type="text" id="fzrLxdh" name="fzr.lxdh" style="z-index: 100; position: relative; width:200px;" onpaste="showDhLength();" onkeyup="onlyDecimalTel(this);showDhLength();" maxlength="25" >
					       <INPUT class="num no-border-bx" name="fzrlxdhlength" id="fzrlxdhlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
			</td>
				<td class=td1 align=right>
				手机
			</td>
			<td class=td1>
				<input type="text" id="fzrMobile" name="fzr.lxmobile" onkeyup="onlyDecimalTel(this);showMobileLength();" onafterpaste="onlyDecimalZero(this);showMobileLength();" maxlength="11" >
					       <INPUT class="num no-border-bx" name="fzrsjlength" id="fzrsjlength"         
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
			</td>
		
		</tr>
		
		</tr>
			<tr>
			<td class=td1 align=right>
				通讯地址
			</td>
			<td class=td1 colSpan=3>
				<input type="text" name="fzr.txdz" size="158" style="width:75%;" maxlength="500" >
			</td>
		</tr>
	<tr>
	
			<td class=td1 align=right>
				邮编
			</td>
			<td class=td1>
				<input type="text" name="fzr.yb"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);">
			</td>
			<td class=td1 align=right>
				电子邮箱
			</td>
			<td class=td1>
				<input type="text" name="fzr.email" maxlength="100" >
			</td>
		
		</tr>
	</table>
				<hr color="#88a6d4" width="80%" style="...."/>

</div> 
 </div> 

<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return fCheckValue('${jglx}');" type=button value="保 存" name="btok"/>&nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}&jglx=${jglx}'"
        type=button
        value="返 回" name="cmdExit"/>&nbsp;
        <INPUT class="newBtn1" type=button onClick="add_div()" value="添加负责人"/>&nbsp;
    <div>
    </div>
</div>
</div>
</div>
</div>
</div>
</form>



</body>
<jsp:include page="../common/onload.jsp"/>

<script>
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg != null&&!"".equals(msg.toString().trim())){
         if("codeRepeat".equals(msg.toString())){
    %>
    ymPrompt.alert({message: '机构名称重复!存在${sourceTable}里!', width: 330, height: 220, title: '提示信息'});
    <%}else if("zchRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: '注册号重复!', width: 330, height: 220, title: '提示信息'});
    <%}else if("jgdmRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: '机构代码重复!', width: 330, height: 220, title: '提示信息'});
    <%}else if("codeNotExist".equals(msg.toString())){%>
    ymPrompt.alert({message: '机构代码不存在,请输入正确的机构代码!', width: 330, height: 220, title: '提示信息'});
    <%}else if("fzcRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: '机构名称，注册号不允许同时重复!', width: 330, height: 220, title: '提示信息'});
    <%
    }else{%>
    ymPrompt.alert({message: '系统繁忙!请稍后再试!', width: 330, height: 220, title: '提示信息'});
    <%}
    }
    }catch (Exception e){
        e.printStackTrace();
    }
    %>
</script>
<script type="text/javascript">
dwr.engine.setErrorHandler(function() { 
    // 
    }); 
 

</script>
</html>
