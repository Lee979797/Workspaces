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
 
    //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
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
        title = "��������ǼǱ�¼��";
    }
    if ("1".equals(formType)) {
        title = "�������Ÿ���ǼǱ�¼��";
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
    <title>ѡ���֤����</title>
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
    		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'���̶�ά��ɨ��', iframe: true});
    	}
 	
	  $(function(){   $("#zch").focus();  
	$("#memo2").val('С��΢����ҵ');
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
    <div align="left" style=" float: left;"><strong> �Ǽ� &gt;&gt; 
  <%
  	if("1".equals(jglx)){
  %>  
    �������ҵ��
    <%
  	}
    %>
    <%
  	if("2".equals(jglx)){
  %>  
    ������ҵ��λҵ��
    <%
  	}
    %>
    <%
  	if("3".equals(jglx)){
  %>  
    �����ҵ��
    <% 
  	}
    %>
     &gt;&gt; <%if ("1".equals(formType)) {%>��Ϣ��¼<%}else{ %> �����Ǽ�<%} %>
    </strong> 
  
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('${jglx}');" type=button value="�� ��" name="btok"/>&nbsp;
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}&jglx=${jglx }'" type=button value="�� ��" name="cmdExit"/>&nbsp;
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
<h3><b>������ҵ��λ�Ǽ�֤��</b></h3>
   <%
	}
   %>
   	<%
	if("1".equals(jglx)){
   %>
<h3><b>������巨�˵Ǽ�֤��</b></h3>
   <%
	}
   %>
   	<%
	if("3".equals(jglx)){
   %>
<h3><b>����ᷨ�˵Ǽ�֤��</b></h3>
   <%
	}
   %>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<%
    if ("1".equals(formType)) {
%>
<TR>

    <TD class=td1 align=right width="15%" id="needJgdm">
        ��������
    </TD>
    <TD class=td1 width="35%">
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';return judgeJgdm(document.getElementById('dmInfo'));"
               maxLength=9 size=28 name="jgdm" id="jgdm" value="${jgdmSave.jgdm}" style=" width:200px;"/> 
               <INPUT class="button" onClick="infoPush()" type="button" value=��ȡ
               name="btselect2"/>&nbsp;
        <span style="color:red;margin-left:5px;" id="dmInfo"></span>
    </TD>
    <td class=td1 width="15%" align="right"></td>
    <td class=td1></td>
</TR>
<%
    }
%>

<TR>
    <td class=td1 align=right width="15%">
          ��������
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
    <td class=td1 align=right>
        ��������
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" onblur="addYzbm()"
               maxLength=6 size=28 name="xzqh"
               id="xzqh" value="${fn:trim(jgdmSave.xzqh)}" style="z-index: 100; position: relative; width:200px;"/>
                 <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=ѡ��
               name="btselect2"/>&nbsp;
               <span style="color:red">*</span>
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span>
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdmSave.xzqh)]==null?"":xzqhMap[fn:trim(jgdmSave.xzqh)]}</span>
    </td>
    <td class=td1 align=right>
        ��������    
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength=6 size=28 name="yzbm"
               id="yzbm" style=" width:200px;" value="${jgdmSave.yzbm}"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </td>
    
</TR>
<tr>

     <td class=td1 align=right>
        ��������
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
        ��֤����
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
        ������λ
    </td>
    <td  class=td1>
        <input  
               
                maxlength="70" size=28 name="zch" id="zch" value="${jgdmSave.zch}" style=" width:200px;"/>
		<span style="color:red">*</span>

       <span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span>
  
    </td>
	<td class=td1 align=right>
        �����ĺ�
    </td>
    <td  class=td1>
        <input  
                onpaste="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
                onkeyup="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
                maxlength="70" size=28 name="zch" id="zch" value="��${jgdmSave.zch}��" style=" width:200px;"/>
		<span style="color:red">*</span>

       <span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span>
  
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       ��Ч������
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
        ��Ч������
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
<tr>
       <td class=td1 align=right>
        ���ܵ�λ����
    </td>
    <td class=td1>
        <input name="zgmc" id="zgmc" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="">
                <INPUT class="button" onClick="addZgdm()" type="button" value=��ѯ
               name="btselect2"/>&nbsp;
        <span id="pzjginfo"></span>
    </td>
    <td class=td1 align=right>
        ���ܵ�λ����
    </td>
    <td class=td1>
        <input name="zgdm" id="zgdm" onkeyup="onlyNumber(this);" type="text" maxLength=18  style="z-index: 100; position: relative; width:200px;"
               value="">
               <INPUT class="button" onClick="addZgmc()" type="button" value=��ѯ
               name="btselect2"/>&nbsp;
        <span id="pzjginfo"></span>
    </td>

</TR>
<TR>
    <td class=td1 align=right>
        ������ҵ
    </td>
          <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength=6 size=23
               name="jjhy2011" id="nnjjhy" value="${fn:trim(jgdmSave.jjhy2011)}"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class=button onClick="return selectUpWindow('t_nnjjhy');" type=button
               value=ѡ�� name=btselect4/>&nbsp;
               <span style="color:red">*</span>
               <span style="position:absolute; top:25px; left:5px;" id="nnjjhy1"></span>
    </td>

    <td class=td1 align=right>
        �绰 
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
        ע���ʽ�
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        ��������
    </td>
    <td class=td1>
       
            <SELECT name="hbzl" id="hbzl" style=" width:200px;">
              
                    <OPTION value="156">156:�����</OPTION>
              
            </SELECT>
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	��������
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
        ��ַ
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
        	��ְ������
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
             id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
             
    </td> 
 
    <td class=td1 align=right>
  
               רְ����ɲ���
    </td> 
     <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td> 
</tr>
<tr>
	   <td class=td1 align=right>
        	�������
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
             id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
             
    </td> 
 
   <td class=td1 align=right>
        	�绰
    </td>
     <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td> 
</tr>
<tr>
	   <td class=td1 align=right>
        	��Ա����
    </td>
    <td>
    	     <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td>
       <td class=td1 align=right>
        	������ϯ����
    </td>
    <td>
    	     <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.zgrs}"/>
    </td>
</tr>
<TR>
    <td class=td1 align=right>
        ��������ۼ�(��Ԫ)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        ���Ա���ɻ������(��Ԫ)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        ��2���������ᾭ�ѱ�����������(��Ԫ)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
     ��������(��Ԫ)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        �̶��ʽ�(��Ԫ)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
     �����ʽ�(��Ԫ)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        ����
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
    
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        �ϼ�
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
   
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        �� �� �� ��(ƽ����)M2
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
    
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
        �� �� �� ��(ƽ����)M2
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
   
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        �� �� �� ��
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
    
        <span style="color:red">*</span>
    </td>
    <td class=td1 align=right>
       �ϼ�
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="zczj" id="zczj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.zczj}' pattern="0.0000"/>"/>
   
       
    <span style="color:red">*</span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
         �е�������������״��
    </td>
    <td class=td1 colSpan=3>
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="jgdz" id="jgdz" value="${jgdmSave.jgdz}" style="width:75%;"/>
                <span style="color:red">*</span>
    </td>
   
</TR>
<tr>
    
    <td class=td1 align=right>
        	����������
    </td>
    <td class=td1>
        <input name="tbrxm" id="tbrxm" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" onkeyup="onlyMc(this);"
               value="">
              
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
        	�������ֻ�
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
        	����������
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
<tr>

    <td class=td1 align=right>
        	��ע
    </td>
     <td class=td1 colSpan=3>
        <INPUT  maxLength="500"
                size="158"
               name="memo" id="memo" value="${jgdmSave.memo}" style="width:75%;"/>
    </td>
    </tr>
<TR>
	<%
	if("2".equals(jglx)){
   %>
    <td class=td1 align=right>
       <SELECT name="fzxs" id="fzxs"/>
         <OPTION value="����������">����������</OPTION>
         <OPTION value="������">������</OPTION>
       </SELECT>
    </td>
    <%
    }else{
    %>

    <td class=td1 align=right>
     	  ����������/������
    </td> 
    <% 
    }
    %>
    <td class=td1>
        <INPUT maxLength=50 size=28 onkeyup="onlyMc(this);"
                name="fddbr" id="fddbr" style=" width:200px;" value="${jgdmSave.fddbr}"/>
        <span style="color:red;" id="fddbrInfo">*</span>
    </td>
    
   
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
</TABLE>
</div>
<div id="list_context" class="list listblue">
	<h3><b>�������������</b></h3>
	<div id="lizi1"> 
	
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<input type="hidden" name="fzr.id" value=""/>
		<tr>
			<td class=td1 align=right width="15%">
				����
			</td>
			<td class=td1>
				<input type="text" class="fzrxm" id="fzrXm" style="z-index: 100; position: relative; width:200px;" name="fzr.xm" maxlength="50" onkeyup="onlyMc(this);">
				<span style="color:red">*</span>
			<span style="float:right">�Ա�</span>
			</td>
			  
		
			<td class=td1 >
				<SELECT name="fzr.xb" id="xb">
				<OPTION value="��">�� </OPTION>
				<OPTION value="Ů">Ů</OPTION>
				</SELECT>
				<span style="color:red">*</span>
			<span style="float:right">����</span>
			</td>
				<td class=td1>
			<SELECT name="fzr.mz" id="mz">
				 <c:forEach items="${mList}" var="mz">
          		  <OPTION value="${mz.dm}">${mz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
       			 <span style="color:red">*</span>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				��������
			</td>
			<td class=td1 >
				<input type="text" name="fzr.memo1" style="z-index: 100; position: relative; width:200px;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true">
				<span style="color:red">*</span>
				<span style="float:right">�Ļ��̶�</span>
			</td>
			<td class=td1>
				<input type="text" >
				<span style="float:right">������ò</span>
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
            �����������ֻ�
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
    </TD>
    	<td class=td1 align=right>
            ��������������
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
	<tr>
			<td class=td1 align=right>
				ͨѶ��ַ
			</td>
			<td class=td1 colSpan=3>
				<input type="text" name="fzr.txdz" size="158" style="width:75%;" maxlength="500" >
			</td>
		</tr>
			<tr>
	
			<td class=td1 align=right>
				�ʱ�
			</td>
			<td class=td1>
				<input type="text" name="fzr.yb"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);">
			</td>
			<td class=td1 align=right>
				��������
			</td>
			<td class=td1>
				<input type="text" name="fzr.email" maxlength="100" >
			</td>
		
		</tr>
		<tr>
		
			<td class=td1 align=right>
				���ι���ְ��
			</td>
			<td class=td1>
			<SELECT name="fzr.zw" id="zw">
				 <c:forEach items="${zwList}" var="zw">
          		  <OPTION value="${zw.dm}">${zw.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
       			 <span style="color:red">*</span>
       			 <span style="float:right">��רְ����ְ</span>
			</td>
				<td class=td1>
				<SELECT name="fzr.iszz" id="iszz">
				<OPTION value="0">רְ</OPTION>
				<OPTION value="1">��ְ</OPTION>
				</SELECT>
				<span style="float:right">������ְ��ʼʱ��</span>
			</td>
			<td class=td1 >
				<input type="text" name="fzr.memo1" style="z-index: 100; position: relative; width:200px;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true">
				<span style="color:red">*</span>
				
			</td>
		</tr>
		
		<tr>
		
			<td class=td1 align=right>
				��ʱ���빤����֯
			</td>
			<td class=td1>
			<input type="text" name="fzr.memo1" style="z-index: 100; position: relative; width:200px;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" style="BACKGROUND-COLOR: #e0e0e0;"  readonly="true">
				<span style="color:red">*</span>
       			 <span style="color:red">*</span>
       			 <span style="float:right">��������ְ��</span>
			</td>
			<td class=td1>
			<SELECT name="fzr.zw" id="zw">
				 <c:forEach items="${zwList}" var="zw">
          		  <OPTION value="${zw.dm}">${zw.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT>
       			 <span style="color:red">*</span>
       			 <span style="float:right">���֤����</span>
			</td>
			<td class=td1 >
				<input type="text" name="zjhm" >
				<span style="color:red">*</span>
				
			</td>
		</tr>
	</table>

</div> 
 </div> 

<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return fCheckValue('${jglx}');" type=button value="�� ��" name="btok"/>&nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}&jglx=${jglx}'"
        type=button
        value="�� ��" name="cmdExit"/>&nbsp;
        
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
    ymPrompt.alert({message: '���������ظ�!����${sourceTable}��!', width: 330, height: 220, title: '��ʾ��Ϣ'});
    <%}else if("zchRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: 'ע����ظ�!', width: 330, height: 220, title: '��ʾ��Ϣ'});
    <%}else if("jgdmRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: '���������ظ�!', width: 330, height: 220, title: '��ʾ��Ϣ'});
    <%}else if("codeNotExist".equals(msg.toString())){%>
    ymPrompt.alert({message: '�������벻����,��������ȷ�Ļ�������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
    <%}else if("fzcRepeat".equals(msg.toString())){%>
    ymPrompt.alert({message: '�������ƣ�ע��Ų�����ͬʱ�ظ�!', width: 330, height: 220, title: '��ʾ��Ϣ'});
    <%
    }else{%>
    ymPrompt.alert({message: 'ϵͳ��æ!���Ժ�����!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
