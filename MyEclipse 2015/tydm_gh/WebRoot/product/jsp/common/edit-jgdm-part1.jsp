<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
  
%>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>

<c:set var="thbList" value="<%=InitSysParams.thbList%>"/>
<c:set var="njjlxList" value="<%=InitSysParams.tnnJjlxList%>"/>

<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>


<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>

<c:set var="zrxzqhMap" value="<%=InitSysParams.zrxzqhMap2%>"/>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMapMc1%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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

    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js"></script>

    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jglxBsxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/btxBus.js"></script>
    <script type="text/javascript">
    document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
    </script>
   
</head>
<body>


<TR>
    <TD class="td1" align="right">
        机构名称
    </TD>
    <TD class="td1" colspan="3">
        <INPUT onblur="this.className='input_off';return judgeCodeName();"
               maxLength="120" size="28" name="jgdm.jgmc" id="jgmc" value="${jgdm.jgmc}"
               style="width:75%;"/>
        <span style="color:red;" id="mcInfo"></span><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
</TR>
<TR>
    <td class=td1 align=right width="15%">
          住所地址
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=240 size=28 name="jgdz" id="jgdz" style="width:75%;"
                value="${jgdm.jgdz}"/>
        <span style="color:red;" id="mcInfo"></span><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
  
</TR>
<tr>
	<TD class="td1" align="right">
       住所行政区划
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" onblur="addYzbm()"
               maxLength="6" size="28"
               value="${fn:endsWith(source,'in')?'': fn:trim(jgdm.xzqh)}" name="jgdm.xzqh" id="xzqh"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=选择
               name="btselect2"/>&nbsp;
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
       <TD class="td1" align="right">
        住所邮政编码
    </TD>
    <TD class="td1">
        <INPUT 
               onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength="6" size="28" name="jgdm.yzbm" id="yzbm" value="${jgdm.yzbm}" style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
</tr>



<TR>
    <td class=td1 align=right width="15%">
         办公地址
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this)"
                maxLength=240 size=28 name="bgjgdz" id="bgjgdz" style="width:75%;"
                value="${jgdm.bgjgdz}"/>
    </td>
  
</TR>
<TR> 
    <td class=td1 align=right>
        办公行政区划
    </td>
    <td class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZer/o(this);" 
               maxLength=6 size=28 name="bgxzqh"
               id="bgxzqh" value="${fn:trim(jgdm.bgxzqh)}" style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class="button" onClick="return selectUpWindow('bgxzqh');" type="button" value=选择
               name="btselect2"/>
        &nbsp;
        <span
            style="position:absolute; top:25px; left:5px;"
            id="bgxzqh1">
            ${xzqhMap[fn:trim(jgdm.bgxzqh)]==null?"":xzqhMap[fn:trim(jgdm.bgxzqh)]}
        </span>    
    </td>
    <td class=td1 align=right width="15%">
        办公邮政编码 
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength=6 size=28 name="bgyzbm"
               id="bgyzbm" style=" width:200px;" value="${jgdm.bgyzbm}"/> 
    </td>
    
</TR>

<TR>
    <td class=td1 align=right width="15%">
         业务范围
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                maxLength=240 size=28 name="jyfw" id="jyfw" style="width:75%;"
                value="${jgdm.jyfw}"/>
    </td>
</TR>
<TR> 
    <td class=td1 align=right>
        所在用人单位
    </td>
    <td class=td1>
        <INPUT
              name = "zgmc" id="zgmc" style=" width:200px;" value="${jgdm.zgmc}"/> 
    </td>
    <td class=td1 align=right width="15%">
        所在用人单位代码   
    </td>
    <td class=td1>
        <INPUT maxLength=18  name="zgdm"
               id="zgdm" style=" width:200px;" value="${jgdm.zgdm}"/> 
    </td>
    	
</TR>


<tr>

        <TD class="td1" align="right">
        成立日期
    </TD>
    <TD class="td1">
        <INPUT 
               maxLength="10" size="23" onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')}); "onclick="WdatePicker({el:$dp.$('zcrq')});"
               name="jgdm.zcrq" id="zcrq"
               value="<fmt:formatDate value='${jgdm.zcrq}' pattern='yyyy-MM-dd'/>"
               style=" width:200px;" />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zcrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
        </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
      <TD class="td1" align="right">
        核准日期
    </TD>
    <TD class="td1">
        <c:set var="date" value="<%=new Date()%>"/>
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njfs}" id="njfs">
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njjzrq}" id="njjzrq">
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('bzrq')});"
                maxLength="10" size="23"
                onChange="changeBzrq(this);" name="jgdm.bzrq" id="bzrq" 
                value="<fmt:formatDate value='${jgdm.bzrq}' pattern='yyyy-MM-dd'/>"
                style=" width:200px;"/>
           <A hideFocus onclick="WdatePicker({el:$dp.$('bzrq')});"
              href="javascript:void(0)">
               <IMG src="/images/icon_rili.gif" align="absMiddle" border="0" name="popcal"/>
           </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </TD>
</tr>
<tr>

     <td class=td1 align=right>
       有效期起
    </td>
    <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('yxqxs')}); "onclick="WdatePicker({el:$dp.$('yxqxs')});"
               maxLength=10 size=23
               name="jgdm.yxqxs" id="yxqxs" style=" width:200px;"
               value="<fmt:formatDate value='${jgdm.yxqxs}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('yxqxs')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
   <td class=td1 align=right >
        有效期至
    </td>
    <td class=td1>
    <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')}); "onclick="WdatePicker({el:$dp.$('zfrq')});"
               maxLength=10 size=23
               name="jgdm.yxqxe" id="zfrq" style=" width:200px;"
               value="<fmt:formatDate value='${jgdm.yxqxe}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
</tr>
<tr>
       <td  class=td1 align=right>
        批复建立工会文号
    </td>
    <td class=td1>
        <input name="jlwh" id="jlwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.jlwh }"/>
        <span id="pzjginfo"></span>
    </td> 
    <input name="jlwh" id="jlwh" type="hidden" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.jlwh }"/>
    <td class=td1 align=right>
        审批日期
     </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('jlrq')}); "onclick="WdatePicker({el:$dp.$('jlrq')});"
               maxLength=10 size=23
               name="jlrq" id="jlrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdm.jlrq }' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('jlrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>
    
</TR>
     <td class=td1 align=right>
        批复选举结果文号
    </td>
    <td class=td1>
        <input name="xjwh" id="xjwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.xjwh }">
        <span id="pzjginfo"></span>
        <FONT color=red> * </FONT>
    </td>
    <td class=td1 align=right>
        审批日期
    </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('xjrq')}); "onclick="WdatePicker({el:$dp.$('xjrq')});"
               maxLength=10 size=23
               name="xjrq" id="xjrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdm.xjrq}' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('xjrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
        <FONT color=red> * </FONT>
    </td>

</TR>


<TR>
 
    <TD class="td1" align="right">
      机构电话
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="25" size="19" name="jgdm.dhhm" id="dhhm" value="${jgdm.dhhm}" 
          onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
        style=" width:200px;"/><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                      <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </TD>
       <td class=td1 align=right>
        机构类型  
    </td>
    <td class=td1 align=left>
      <SELECT name="jglx" id="jglx"/>
      	 <OPTION value="0">----请选择机构类型----</OPTION> 
         <OPTION value="1"  ${jgdm.jglx eq "1"?"selected":""}>基层工会</OPTION> 
         <OPTION value="9"  ${jgdm.jglx eq "9"?"selected":""}>其他</OPTION>             
        </SELECT>
        <FONT color=red> * </FONT>
    </td>
    
  <%--   <td class=td1 align=right>
         承担民事责任能力状况
    </td>
   	<td class=td1 >
				<SELECT name="jgdm.cdnl" id="cdnl">
				<OPTION value="0" ${tJgdm.cdnl eq '0'?"selected":"">能 </OPTION>
				<OPTION value="1" ${tJgdm.cdnl eq '1'?"selected":"">否</OPTION>
				</SELECT>
	</td> --%>
	
<TR/>
 <td class=td1 align=right>
        网址
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               maxLength="50"
               size="19"
               name="url" id="url" value="${jgdm.url}" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
</TR>
	
	
</TR>
<tr>
    <input type= "hidden" id = "fddbr" value="${jgdm.fddbr }"/>
    <td class=td1 align=right>
        	经办人姓名
    </td>
    <td class=td1>
        <input name="jgdm.tbrxm" id="tbrxm" type="text" maxLength="60"  style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.tbrxm }"><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
     <td class=td1 align=right>
      <SELECT name="jgdm.tbrzjlx" id="tbrzjlx"/>
   
         <c:forEach items="${zjlxList}" var="zjlx">
            <OPTION value="${zjlx.dm}" ${jgdm.tbrzjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
        </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
        <input name="jgdm.tbrsfzh" id="tbrsfzh" type="text"  style="z-index: 100; position: relative; width:200px;" maxLength="18"
         onpaste=" showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);"
               value="${jgdm.tbrsfzh }">
         <span style="color:red">*</span>
                       <INPUT class="num no-border-bx" id="tbrsfzhlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrsfzh"), document.getElementById("tbrsfzhlength"), 0);
        </script><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人移动电话
    </td>
    <td class=td1>
        <input name="jgdm.tbrmobile" id="tbrmobile" type="text" maxLength="11"  
        onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
        style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.tbrmobile }"><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
        <span id="pzjginfo"></span>
                  <INPUT class="num no-border-bx" id="tbrmobilelength"
                     
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrmobile"), document.getElementById("tbrmobilelength"), 0);
        </script>
    </td>
   
   <td class=td1 align=right>
        	经办人座机
    </td>
    <td class=td1>
        <input name="jgdm.tbrlxfs" id="tbrlxfs" type="text" maxLength="25"  style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               value="${jgdm.tbrlxfs }">
        <span id="pzjginfo"></span>
                          <INPUT class="num no-border-bx" id="tbrlxfslength"
                      onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrlxfs"), document.getElementById("tbrlxfslength"), 0);
        </script>
    </td>
</TR>
<tr>

    <td class=td1 align=right>
        	备注
    </td>
    
    <td class=td1 colSpan=3>
        <input name="jgdm.memo" id="memo" size="158" type="text"  style="width:75%;"
            maxLength="500"   value="${jgdm.memo }">
        <span id="pzjginfo"></span>
    </td>
</tr>
</body>
</html>