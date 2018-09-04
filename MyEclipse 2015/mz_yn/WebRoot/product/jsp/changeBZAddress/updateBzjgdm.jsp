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
    String validate="";
    if("2".equals(jglx)){
    	
     validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
    }else{
    	validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 5), 1));
    }
    String dateLimit = "";

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
<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>

<%-- <c:set var="thbList" value="<%=InitSysParams.thbList%>"/>
<c:set var="njjlxList" value="<%=InitSysParams.tnnJjlxList%>"/>
<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>
 --%>
<%-- <c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/> --%>
<%-- <c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMapMc1%>"/>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<c:set var="yyList" value="<%= InitSysParams.yyList%>"/>
<c:set var="dzzlxList" value="<%= InitSysParams.dzzlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/> --%>

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
 	<!-- ����ҵ��
     &gt;&gt;  -->����Ǩַ &gt;&gt; �޸ķ�֤����
    </strong> 
  
    </div>

    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/change_upBzjgdm.action?" name="busForm">
 <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<%--<input type="hidden" name="formType" id="formType" value="<%=formType%>"/>
<input type="hidden" name="bzjgdm" id="bzjgdm" value="${fn:trim(sysUser.bzjgdm) }"/>
<input type="hidden" name="nameType" value="add" id="nameType"/>
<input type="hidden" name="submitType" value="0" id="submitType"/>   --%>
<input type="text" name="tydm" value= "${jgdm.tyshxydm }" />
<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>������Ϣ</b></h3>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">

<TR>

    <td class=td1 align=right width="15%">
          ͳһ������ô���
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=120 size=42 name="jgdm.tyshxydm" id="tyshxydm" style ="background-color:lightGray" style="width:75%;" readonly = "readonly"
                value="${jgdm.tyshxydm}"/>
                <!--  <FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span> -->
    </td>
    
  
</TR>
<TR>

    <td class=td1 align=right width="15%">
          ��������
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=120 size=42 name="jgdm.jgmc" id="jgmc" style ="background-color:lightGray;"  readonly = "readonly" 
                value="${jgdm.jgmc}"/>
                <!--  <FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span> -->
    </td>
    
  
</TR>

<TR> 
    <td class=td1 align=right>
        ��֤������������
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" onblur="addYzbm()"
               maxLength=6 size=28 name="jgdm.bzjgdm"
               id="xzqh" value="${fn:trim(jgdm.bzjgdm)}" style="z-index: 100; position: relative; width:200px;"/>
                 <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=ѡ��
               name="btselect2"/>  <FONT color=red> * </FONT>&nbsp;
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.bzjgdm)]==null?"":xzqhMap[fn:trim(jgdm.bzjgdm)]}</span>
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdmSave.bzjgdm)]==null?"":xzqhMap[fn:trim(jgdmSave.bzjgdm)]}</span>
    </td>
    
    
</TR>

</TABLE>

	

	
</div> 

<div class="listbtn">
    <INPUT class="newBtn1"  type=submit value="�� ��" name="btok"/>&nbsp;
    <c:if test="${jgdm.jglx eq '1'}">
   		<input type="button" value="�� ��" name="cmdExit" class="newBtn1"
               onclick="window.location.href='/product/jsp/changeBZAddress/search_shetuan_bzjgdm.jsp'"/>
	</c:if>
    <c:if test="${jgdm.jglx eq '2'}">
   		<input type="button" value="�� ��" name="cmdExit" class="newBtn1"
               onclick="window.location.href='/product/jsp/changeBZAddress/search_minfei_bzjgdm.jsp'"/>
	</c:if>
	<c:if test="${jgdm.jglx eq '3'}">
   		<input type="button" value="�� ��" name="cmdExit" class="newBtn1"
               onclick="window.location.href='/product/jsp/changeBZAddress/search_jijinhui_bzjgdm.jsp'"/>
	</c:if>    
        
        
    <div>
     <!-- onClick="window.location.href='/bsweb/change_searchBy.action'" -->
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
