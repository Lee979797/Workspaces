<%@page import="com.itextpdf.text.Document"%>
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
    String printName=user.getPrintName();
    String id = (String) request.getAttribute("id");
    String bzDate = DateUtil.dateToStr(new Date());
    String jglx = request.getParameter("jglx");
    //String jglx  = $("#testSelect option:selected").val();
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
    String jgdmdm = request.getParameter("jgdmdm");
    if (clsStringTool.isEmpty(jgdmdm)) {
        jgdmdm = "";
    }
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
 	
	  $(function(){  
	  	var pzjgmc=$("#pzjgmc").val();
	  	if(!pzjgmc){
	  		$("#pzjgmc").val('<%=printName %>') 
	  	}
	   $("#zch").focus();  
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
 	����ҵ��
     &gt;&gt; <%if ("1".equals(formType)) {%>��Ϣ��¼<%}else{ %> �����Ǽ�<%} %>
    </strong> 
  
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('xb');" type=button value="�� ��" name="btok"/>&nbsp;
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}'" type=button value="�� ��" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/certificate_add.action" name="busForm">
<input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="formType" id="formType" value="<%=formType%>"/>
<input type="hidden" name="bzjgdm" id="bzjgdm" value="${fn:trim(sysUser.bzjgdm) }"/>
<input type="hidden" name="nameType" value="add" id="nameType"/>
<input type="hidden" name="submitType" value="0" id="submitType"/>  
<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>������Ϣ</b></h3>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<%
    if ("1".equals(formType)) {
%>
<TR>

    <TD class=td1 align=right width="15%" id="needJgdm">
        ��������1
    </TD>
    <TD class=td1 >
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';"
               maxLength=9 size=28 name="jgdm" id="jgdm" value="<%=jgdmdm %>" style=" width:200px;"/> 
        <span style="color:red;margin-left:5px;" id="dmInfo"></span>
    </TD>
    <td class=td1  align="right"></td>
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
                 <FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
  
</TR>
<TR>
    <td class=td1 align=right width="15%">
         ס����ַ
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=240 size=28 name="jgdz" id="jgdz" style="width:75%;"
                value="${jgdmSave.jgdz}"/>  <FONT color=red> * </FONT>
        <span style="color:red;" id="mcInfo"></span>
    </td>
  
</TR>
<TR> 
    <td class=td1 align=right>
        ס����������
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" onblur="addYzbm()"
               maxLength=6 size=28 name="xzqh"
               id="xzqh" value="${fn:trim(jgdmSave.xzqh)}" style="z-index: 100; position: relative; width:200px;"/>
                 <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=ѡ��
               name="btselect2"/>  <FONT color=red> * </FONT>&nbsp;
               <%-- <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span> --%>
        &nbsp;
       <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">
       		${xzqhMap[fn:trim(jgdmSave.xzqh)]==null?"":xzqhMap[fn:trim(jgdmSave.xzqh)]}
        </span> 
    </td>
    
   
    
    
    <td class=td1 align=right width="15%">
        ס����������    
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength=6 size=28 name="yzbm"
               id="yzbm" style=" width:200px;" value="${jgdmSave.yzbm}"/>  <FONT color=red> * </FONT>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </td>  
</TR>


<TR>
    <td class=td1 align=right width="15%">
         �칫��ַ
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this)"
                maxLength=240 size=28 name="bgjgdz" id="bgjgdz" style="width:75%;"
                value="${jgdmSave.bgjgdz}"/>
    </td>
  
</TR>
<TR> 
    <td class=td1 align=right>
        �칫��������
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZer/o(this);" 
               maxLength=6 size=28 name="bgxzqh"
               id="bgxzqh" value="${fn:trim(jgdmSave.bgxzqh)}" style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class="button" onClick="return selectUpWindow('bgxzqh');" type="button" value=ѡ��
               name="btselect2"/>
        &nbsp;
        <span
            style="position:absolute; top:25px; left:5px;"
            id="bgxzqh1">
            ${xzqhMap[fn:trim(jgdmSave.bgxzqh)]==null?"":xzqhMap[fn:trim(jgdmSave.bgxzqh)]}
        </span>    
    </td>
    <td class=td1 align=right width="15%">
        �칫�������� 
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength=6 size=28 name="bgyzbm"
               id="bgyzbm" style=" width:200px;" value="${jgdmSave.bgyzbm}"/> 
    </td>
    
</TR>

<TR>
    <td class=td1 align=right width="15%">
         ҵ��Χ
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                maxLength=240 size=28 name="jyfw" id="jyfw" style="width:75%;"
                value="${jgdmSave.jyfw}"/>
    </td>
</TR>
<TR> 
    <td class=td1 align=right>
        �������˵�λ
    </td>
    <td class=td1>
        <INPUT
              name = "zgmc" id="zgmc" style=" width:200px;" value="${jgdmSave.zgmc}"/> 
    </td>
    <td class=td1 align=right width="15%">
        �������˵�λ����   
    </td>
    <td class=td1>
        <INPUT maxLength=18 name="zgdm"
               id="zgdm" style=" width:200px;" value="${jgdmSave.zgdm}"/> 
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
        </A> <FONT color=red> * </FONT>
    </td>
   <td class=td1 align=right >
        ��׼����
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
        </A> <FONT color=red> * </FONT>
    </td>
</tr>
<tr>

     <td class=td1 align=right>
       ��Ч����
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
        </A> <FONT color=red> * </FONT>
    </td>
   <td class=td1 align=right >
        ��Ч����
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
        </A> <FONT color=red> * </FONT>
    </td>
</tr>
<TR>
 <td class=td1 align=right>
        �����绰 
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength=25
             onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
             size=19 name="dhhm" id="dhhm" style=" width:200px;" value="${jgdmSave.dhhm}"/> <FONT color=red> * </FONT>
            <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                    <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="${11 - fn:length(jgdmSave.mobile)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </td>
    <td class=td1 align=right>
        �������� 
    </td>
    <td class=td1 align=left>
      <SELECT name="jglx" id="jglx"/>
      	 <OPTION value="0">----��ѡ���������----</OPTION> 
         <OPTION value="1">���㹤��</OPTION> 
         <OPTION value="9">����</OPTION>              
        </SELECT>
        <FONT color=red> * </FONT>
    </td>
    
 </TR>
<tr>
       <td class=td1 align=right>
        �������������ĺ�
    </td>
    <td class=td1>
        <input name="jlwh" id="jlwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdmSave.jlwh }"> 

                  <span style="color:red;" id="mcInfo"></span>
    </td>
    <td class=td1 align=right>
        ��������
    </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('jlrq')}); "onclick="WdatePicker({el:$dp.$('jlrq')});"
               maxLength=10 size=23
               name="tjlrq" id="jlrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdmSave.jlrq }' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('jlrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
    </td>

</TR>
      <td class=td1 align=right>
        ����ѡ�ٽ���ĺ�
    </td>
    <td class=td1>
        <input name="xjwh" id="xjwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdmSave.xjwh }">
        <span id="pzjginfo"></span> <FONT color=red> * </FONT>
        <span id="pzjginfo"></span>
    </td>
    <td class=td1 align=right>
        ��������
    </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';"onclick="WdatePicker({el:$dp.$('xjrq')});"
               maxLength=10 size=23
               name="txjrq" id="xjrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdmSave.xjrq}' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('xjrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A><FONT color=red> * </FONT>
    </td>

</TR>

       <!--  <td class=td1 align=right>
         �е�������������״��
    </td>
   	<td class=td1 >
				<SELECT name="cdnl" id="cdnl">
				<OPTION value="0">�� </OPTION>
				<OPTION value="1">��</OPTION>
				</SELECT>
</td> -->

<!--  <TR>
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
    -->
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
   <!--  
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
   
</TR>
-->
<tr>
    
    <td class=td1 align=right>
        	����������
    </td>
    <td class=td1>
        <input name="tbrxm" id="tbrxm" type="text" maxLength="60" style="z-index: 100; position: relative; width:200px;" onkeyup="onlyMc(this);"
               value="">  <FONT color=red> * </FONT>
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
               value=""><FONT color=red> * </FONT>
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
        	�������ƶ��绰
    </td>
    <td class=td1>
        <input name="tbrmobile" id="tbrmobile" type="text" maxLength="11"  style="z-index: 100; position: relative; width:200px;"
          onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
               value="">  <FONT color=red> * </FONT>
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
     	<tr>

    <td class=td1 align=right width="15%">
        	��ע
    </td>
     <td class=td1 colSpan=3>
        <INPUT  maxLength="500"
                size="158"
               name="memo" id="memo" value="${jgdmSave.memo}" style="width:75%;"/>
    </td>
    </tr>
</TR> 
</TABLE>

	<h3><b>������֯���</b></h3>
<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<tr>
	<td class=td1 align=right width="15%">
        ��֤����
    </td>
    <td  class=td1 colspan="3">
        <input  
               
               disabled maxlength="70" size=28 name="pzjgmc" id="pzjgmc" value="${jgdmSave.pzjgmc}" style=" width:75%"/> <FONT color=red> * </FONT>
       <span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span>
  
    </td>
</tr>
<tr>
	   <td class=td1 align=right>
        	ְ������(��)
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zgrs" id="zgrs"
              style=" width:200px;" value="${jgdmSave.zgrs}"/> <FONT color=red> * </FONT>
             
    </td> 
 
   <%--  <td class=td1 align=right>
  
               רְ����ɲ���
    </td> 
     <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="gbrs" id="gbrs"
               style=" width:200px;" value="${jgdmSave.gbrs}"/> <FONT color=red> * </FONT>
    </td>  --%>
</tr>
<%-- <tr>
	   <td class=td1 align=right>
        	�������
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="ghjs" id="ghjs"
             id="zzgzrysl" style=" width:200px;" value="${jgdmSave.ghjs}"/> <FONT color=red> * </FONT>
             
    </td> 
 
   <td class=td1 align=right>
        	�绰
    </td>
     <td class=td1>
       <INPUT onkeyup="onlyDecimalTel(this);" onafterpaste="onlyDecimalTel(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=25 size=19 name="ghzxdh" id="ghzxdh"
                style=" width:200px;" value="${jgdmSave.zgrs}"/><FONT color=red>
      *
        </FONT>
    </td> 
</tr> --%>
<tr>
	   <td class=td1 align=right>
        	��Ա����
    </td>
    <td>
    	     <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="hyrs" id="hyrs"
               id="zzgzrysl" style=" width:200px;" value="${jgdmSave.hyrs}"/> <FONT color=red> * </FONT>
    </td>
       <td class=td1 align=right>
        	������ϯ����
    </td>
    <td>
    	     <INPUT 
             
               name="ghzxmc" id="ghzxmc" 
                style=" width:200px;" value="${jgdmSave.ghzxmc}"/><!--  maxLength=6 size=19 onkeyup="onlyNumber(this);"   onblur="this.className='input_off';trimIntputValue(this);" onafterpaste="onlyNumber(this);;" -->
    </td>
</tr>
</table>


<%-- 	<TR>
    <td class=td1 align=right width="15%">
        ��������ۼ�(��Ԫ)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="snjylj" id="snjylj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.snjylj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
    </td>
    <td class=td1 align=right>
        ���Ա���ɻ������(��Ԫ)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="hhsr" id="hhsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.hhsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
    </td>
</TR> --%>

<!--  <td class=td1 align=right>
     ������� (��Ԫ)
    </td> -->
   
    
<h3><b>�������</b></h3>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class=td1 align=right width="15%">
        ����
   		</td>
		<td class=td1>
			<SELECT name="qtsr_1" id="qtsr_1"  onchange="jingFeiChange()">
				<OPTION value="1">�н��ྭ��</OPTION>
				<OPTION value="0">���ȶ��ľ�����Դ</OPTION>
			</SELECT>
			<FONT color=red> * </FONT>
		</td>
		<td class=td1 align=right id="shue_1">
			����
		</td>
		<td class=td1 id="shue_2">
			<input type="text" name="qtsr" id="qtsr" style="width:200px" maxlength="500"><FONT color=red> ��Ԫ* </FONT>
		</td>	
	</tr>
	</table>	
	
<%-- 	
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="qtsr" id="qtsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.qtsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ*
        </FONT>
    </td>  --%>      
 <%--    <td class=td1 align=right>
        ��2���������ᾭ�ѱ�����������(��Ԫ)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="lcsr" id="lcsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.lcsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
    </td> --%>

	<h3><b> �̶��ʲ����</b></h3>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		   <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="gdzj" id="gdzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.gdzj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
    </td>
<!--     <td class=td1 align=right width="15%">
        �̶��ʲ����(��Ԫ)
    </td> -->
 
   <%--  <td class=td1 align=right>
     �����ʽ�(��Ԫ)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="ldzj" id="ldzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.ldzj}' pattern="0.0000"/>"/>
        <FONT color=red>
            ��Ԫ
        </FONT>
    </td> --%>

<%-- <TR>
    <td class=td1 align=right>
        ����
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="qtzj" id="qtzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.qtzj}' pattern="0.0000"/>"/>
    </td>
    <td class=td1 align=right>
        �ϼ�
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="hjzj" id="hjzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdmSave.hjzj}' pattern="0.0000"/>"/>
    </td>
</TR> --%>
	</table>


	<h3><b>�������</b></h3>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
	
	    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="cshj" id="cshj" style=" width:200px;"
               value="${jgdmSave.cshj}"/>
                 <FONT color=red>
      				(ƽ����)
        		</FONT>
    	</td>

	<%-- <TR>
    <td class=td1 align=right width="15%">
           �� �� �� ��(ƽ����)M2
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="bgcs" id="bgcs" style=" width:200px;"
               value="${jgdmSave.bgcs}"/>
    
    </td>
    <td class=td1 align=right>
        �� �� �� ��(ƽ����)M2
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="hdcs" id="hdcs" style=" width:200px;"
               value="${jgdmSave.hdcs}"/>
    </td>
</TR> --%>
   <%--  <td class=td1 align=right>
        �� �� �� ��
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="qtcs" id="qtcs" style=" width:200px;"
               value="${jgdmSave.qtcs}"/>
    </td> --%>
<!--     <td class=td1 align=right>
       �ϼ�
    </td> -->

	</table>

</div>
<div id="list_context" class="list listblue">
	<h3><b>�������������</b></h3>
	<div id="lizi1"> 
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
			<td class=td1 align=right width="15%">
				����������
			</td>
			<td class=td1>
				<input type="text" name="tfddbr.xm" id="xm" style="z-index: 100; position: relative; width:200px;" maxlength="50" onkeyup="onlyMc(this);"><FONT color=red> * </FONT>
			</td>
			  
		
			
			<td class=td1 align=right>
				����
			</td>
				<td class=td1>
			     <SELECT name="tfddbr.mz" id="mz">
				 <c:forEach items="${mList}" var="mz">
          		  <OPTION value="${mz.dm}">${mz.mc} </OPTION>
       			 </c:forEach>
       			 </SELECT><FONT color=red> * </FONT>
			</td>
		</tr>
		<tr>
			<td class=td1 align=right>
				�Ա�
			</td>
			<td class=td1 >
				<SELECT name="tfddbr.xb" id="xb">
				<OPTION value="��">�� </OPTION>
				<OPTION value="Ů">Ů</OPTION>
				</SELECT><FONT color=red> * </FONT>
			</td>
			<td class=td1 align=right>
				�Ļ��̶�
			</td>
			<td class=td1>
				<input type="text" name="tfddbr.xl" id="xl" style="width:200px;" maxlength="500">
			</td>
		</tr>
		<tr>
<!-- 		<td class=td1 align=right>
				��������
			</td>
			<td class=td1 >
				<input type="hidden" value="null" name="tfddbr.csrq" id="csrq" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
				   <A hideFocus onclick="WdatePicker({el:$dp.$('csrq')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
			</td>  -->
			<input type="hidden" name="tfddbr.csrq" id="csrq" value = "1900-01-01"/>
			<td class=td1 align=right>
				������ò
			</td>
				<td class=td1>
			<SELECT name="tfddbr.zzmm" id="zzmm">
				 <c:forEach items="${zzList}" var="zz">
          		  <OPTION value="${zz.dm}">${zz.mc} </OPTION>
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
               maxLength="11" size="28" name="tfddbr.lxmobile" id="lxmobile"
               style=" width:200px;" value=""/><FONT color=red> * </FONT>
        ${empty requireds['lxmobile']?'':'<span class="required">*</span>'}
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
               maxLength="25" size="28" name="tfddbr.lxdh" id="lxdh"
               style=" width:200px;" value=""/>
        ${empty requireds['lxdh']?'':'<span class="required">*</span>'}
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
				<input type="text" name="tfddbr.txdz" id="txdz" size="158" style="width:75%;" maxlength="500" >
			</td>
		</tr>
			<tr>
	
			<td class=td1 align=right>
				�ʱ�
			</td>
			<td class=td1>
				<input type="text" name="tfddbr.yb" id="yb"  maxlength="6" onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" style="width:200px">
			</td>
			<td class=td1 align=right>
				��������
			</td>
			<td class=td1>
				<input type="text" name="tfddbr.email" id="email1" maxlength="100" style="width:200px">
			</td>
		
		</tr>
		<tr>
		
			<td class=td1 align=right>
				���ι���ְ��
			</td>
			<td class=td1>
				<input type="text" name="tfddbr.zw" id="zw" style="width:200px" maxlength="500"><FONT color=red> * </FONT>
			</td>
      
			<td class=td1 align=right>
				������ְ��ʼʱ��
			</td>
			<td class=td1 >
				<input type="text" name="tfddbr.rzsj" id="rzsj" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});"  readonly="true">
				 <A hideFocus onclick="WdatePicker({el:$dp.$('rzsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
			</td>
		</tr>
		<tr>
				<td class=td1 align=right>
					��רְ��ְ
				</td>
					</td>
					<td class=td1>
					<SELECT name="tfddbr.iszz" id="iszz" onchange="gradeChange()">
					<OPTION value="1">��ְ</OPTION>
					<OPTION value="0">רְ</OPTION>
					</SELECT><FONT color=red>*</FONT>
				</td>
					<td class=td1 align=right id="job">
						��������ְ��
					</td>
					<td class=td1 id="job2">
						<input type="text" name="tfddbr.qtzw" id="qtzw" style="width:200px" maxlength="500"><FONT color=red> * </FONT>
					</td>									
		</tr>
		<tr>
	<!-- 	<td class=td1 align=right>
				��ʱ���빤����֯
			</td>
			<td class=td1>
			<input type="text" name="tfddbr.rhsj" id="rhsj" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;" onfocus="this.className='input_on';WdatePicker({el:$dp.$(this)});" onclick="WdatePicker({el:$dp.$(this)});" readonly="true">
			 <A hideFocus onclick="WdatePicker({el:$dp.$('rhsj')});" href="javascript:void(0)">
          			  <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        		   </A><FONT color=red> * </FONT>
			</td> -->
			<input type="hidden"  name="tfddbr.rhsj" id="rhsj" value = "1900-01-01"/>
	<td class=td1 align=right>
		<SELECT name="zjlx" id="zjlx"/>   
          	<c:forEach items="${zjlx}" var="zj">
         	<OPTION value="${zj.dm }">${zj.mc }</OPTION> 
         	</c:forEach>       
        </SELECT>
	</td>
	<td class=td1 >
				<input type="text" name="tfddbr.zjhm" id="zjhm" style="width:200px" maxlength="18"><FONT color=red> * </FONT>
	</td>
	</tr>
	</table>

</div> 
	<!-- <h3><b>���˼���</b></h3>
	<div>
	<table class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
		<tr>
			<td class=td1 align=center>��ְʱ��</td>
			<td class=td1 align=center>������λ</td>
			<td class=td1 align=center>ְ��</td>
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
        	��Ҫ˵��������
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
<!-- $('#testSelect option:selected').val() -->
<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return fCheckValue('xb');" type=button value="�� ��" name="btok"/>&nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/certificate_list.action?formType=${formType}'"
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
</html>
