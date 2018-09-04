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
        名称
    </TD>
    <TD class="td1" colspan="3">
        <INPUT onblur="this.className='input_off';return judgeCodeName();"
               maxLength="120" size="28" name="jgdm.jgmc" id="jgmc" value="${jgdm.jgmc}"
               style="width:75%;"/>
        <span style="color:red">*</span>
        <span style="color:red;" id="mcInfo"></span>
    </TD>
</TR>
<TR>
<c:choose>
 <c:when test="${'2' eq jglx}">
    <td class=td1 align=right>
       <SELECT name="jgdm.fzxs" id="fzxs"/>
         <OPTION value="法定代表人" ${'法定代表人' eq jgdm.fzxs?"selected":"" }>法定代表人</OPTION>
         <OPTION value="负责人" ${'负责人' eq jgdm.fzxs?"selected":"" }>负责人</OPTION>
       </SELECT>
    </td>
</c:when>
  <c:otherwise>
    <TD class="td1" align="right">
        法定代表人/负责人
    </TD>
    </c:otherwise>
  </c:choose>
    <TD class="td1">
        <INPUT
               
                maxLength="50" size="28" name="jgdm.fddbr" id="fddbr" value="${jgdm.fddbr}" style=" width:200px;"/>
                  <span style="color:red">*</span>
        <%--<INPUT onClick=" return gopreview1();" type="button" value="查重" class="button"  name="Button"  />--%>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="fddbrInfo"></span>
    </TD>
    <TD class="td1" align="right"><label for="zjlx"></label><SELECT name="jgdm.zjlx" id="zjlx">
        <c:forEach items="${zjlxList}" var="zjlx">
            <OPTION value="${zjlx.dm}" ${jgdm.zjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
        </c:forEach>
    </SELECT>
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT 
         onblur="this.className='input_off';trimIntputValue(this);return judgeFddbrZjh(${jglx });"
               onpaste=" showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);" name="jgdm.zjhm"
               id="zjhm" maxlength="18"
               value="${jgdm.zjhm}" style=" width:200px; float:left; margin-right:5px;"/>
                 <span style="color:red">*</span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="zjhmInfo"></span>
            <INPUT class="num no-border-bx" id="zjhmlength"
               tabIndex=100 readOnly size=4 value="${18 - fn:length(jgdmSave.zjhm)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("zjhm"), document.getElementById("zjhmlength"), 18);
        </script>
    </TD>
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
        </A>
          <span style="color:red">*</span>
    </TD>
      <TD class="td1" align="right">
        发证日期
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
           </A>
             <span style="color:red">*</span>
    </TD>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自
    </td>
    <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('yxqxs')}); "onclick="WdatePicker({el:$dp.$('yxqxs')});"
               maxLength=10 size=23
               name="jgdm.yxqxs" id="yxqxs" style=" width:200px;"
               value="<fmt:formatDate value='${jgdm.yxqxs}' pattern='yyyy-MM-dd'/>"
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
    <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')}); "onclick="WdatePicker({el:$dp.$('zfrq')});"
               maxLength=10 size=23
               name="jgdm.zfrq" id="zfrq" style=" width:200px;"
               value="<fmt:formatDate value='${jgdm.zfrq}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
          <span style="color:red">*</span>
    </td>
</tr>
<TR>
    <TD class="td1" align="right">
         住所
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT
                maxLength="120" size="158"
                name="jgdm.jgdz" id="jgdz" value="${fn:endsWith(source,'in')?'':jgdm.jgdz}" style="width:75%;"/>
                  <span style="color:red">*</span>
    </TD>
</TR>
<TR>
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
                 <span style="color:red">*</span>
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span>
    </TD>
   <c:if test="${'3' eq jglx}">
       <td class=td1 align=right>
             基金会类型
    </td>
      <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jgdm.jjhlx" id="jjhlx" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${fn:trim(jjlx.dm) == fn:trim(jgdm.jjhlx)?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
    <span style="color:red">*</span>
    </TD>
   </c:if>
   <c:if test="${'1' eq jglx}">

   <td class=td1 align=right>
   活动地域
    </td>
    <%-- 以下是原版的活动地域，通过登录用户的办证机构代码来获取的地址
    <td class=td1>
        <INPUT 
               maxLength=120 size="158"
               name="jgdm.hddy" id="hddy" value="${bzjgdmMap[fn:trim(sysUser.bzjgdm)]}" style="width:200px;BACKGROUND-COLOR: #e0e0e0;" />
    </td> --%>
    <!-- xiaruibo  20170627 将原版活动地域改为，从数据的活动地域中获取，而不通过登录用户的办证机构代码来获取了 -->
    <td class=td1>
        <INPUT 
               maxLength=120 size="158"
               name="jgdm.hddy" id="hddy" value="${jgdm.hddy}" style="width:200px;BACKGROUND-COLOR: #e0e0e0;" />
    </td>
    
    
 </c:if>
   <c:if test="${'2' eq jglx}">
   	<TD class="td1" align="right">
        登记类型
    </TD>
  
  <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jgdm.jjlx2011" id="jjlx2011" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${fn:trim(jjlx.dm) == fn:trim(jgdm.jjlx2011)?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
    <span style="color:red">*</span>
    </TD>
   </c:if>
</TR>

<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  start -->

<TR>
	<td class="td1" align="right">是否为慈善组织</td>
	<td class="td1" align="left">
		<SELECT name="jgdm.cishan">
			<OPTION value="2" ${'2' eq jgdm.cishan?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq jgdm.cishan?"selected":""}>是</OPTION>
		</SELECT>
	</td>
	<td class="td1" align="right">是否取得募捐资格</td>
	<td class="td1" align="left">
		<SELECT name="jgdm.mujuan">
			<OPTION value="2" ${'2' eq jgdm.mujuan?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq jgdm.mujuan?"selected":""}>是</OPTION>
		</SELECT>
	</td>
</TR>

<c:if test="${'1' eq jglx}">
	<TR>
		<td class="td1" align="right">是否为脱钩单位</td>
		<td class="td1" align="left">
			<SELECT name="jgdm.tuogou">
				<OPTION value="2" ${'2' eq jgdm.tuogou?"selected":""}>否</OPTION>
				<OPTION value="1" ${'1' eq jgdm.tuogou?"selected":""}>是</OPTION>
			</SELECT>
		</td>
		<td class="td1" align="right">是否为志愿组织</td>
		<td class="td1" align="left">
			<SELECT name="jgdm.zhiyuan">
				<OPTION value="2" ${'2' eq jgdm.zhiyuan?"selected":""}>否</OPTION>
				<OPTION value="1" ${'1' eq jgdm.zhiyuan?"selected":""}>是</OPTION>
			</SELECT>
		</td>
	</TR>
</c:if>
<c:if test="${'2' eq jglx}">
	<TR>
		<td class="td1" align="right">是否为志愿组织</td>
		<td class="td1" align="left">
			<SELECT name="jgdm.zhiyuan">
				<OPTION value="2" ${'2' eq jgdm.zhiyuan?"selected":""}>否</OPTION>
				<OPTION value="1" ${'1' eq jgdm.zhiyuan?"selected":""}>是</OPTION>
			</SELECT>
		</td>
		<td class="td1" align="right"></td>
		<td class="td1" align="left"></td>
	</TR>
</c:if>
<c:if test="${'3' eq jglx}">
	<TR>
		<td class="td1" align="right">是否为志愿组织</td>
		<td class="td1" align="left">
			<SELECT name="jgdm.zhiyuan">
				<OPTION value="2" ${'2' eq jgdm.zhiyuan?"selected":""}>否</OPTION>
				<OPTION value="1" ${'1' eq jgdm.zhiyuan?"selected":""}>是</OPTION>
			</SELECT>
		</td>
		<td class="td1" align="right"></td>
		<td class="td1" align="left"></td>
	</TR>
</c:if>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  end -->



<!-- lvwei  20170429 直接登记类型 start -->
<TR>
	<td class="td1" align="right">直接登记类型</td>
	<td class="td1" align="left">
		<SELECT name="jgdm.zjdjlx">
<c:if test="${'1' eq jglx}">
			<OPTION value="1" ${'1' eq jgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq jgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>
			<OPTION value="3" ${'3' eq jgdm.zjdjlx?"selected":""}>行业协会商会类直接登记</OPTION>
			<OPTION value="4" ${'4' eq jgdm.zjdjlx?"selected":""}>科技类直接登记</OPTION>
			<OPTION value="5" ${'5' eq jgdm.zjdjlx?"selected":""}>社区服务类直接登记</OPTION>
			<OPTION value="6" ${'6' eq jgdm.zjdjlx?"selected":""}>其他类直接登记</OPTION>
</c:if>
<c:if test="${'2' eq jglx}">
			<OPTION value="1" ${'1' eq jgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq jgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>
			<OPTION value="4" ${'4' eq jgdm.zjdjlx?"selected":""}>科技类直接登记</OPTION>
			<OPTION value="5" ${'5' eq jgdm.zjdjlx?"selected":""}>社区服务类直接登记</OPTION>
			<OPTION value="6" ${'6' eq jgdm.zjdjlx?"selected":""}>其他类直接登记</OPTION>
</c:if>
<c:if test="${'3' eq jglx}">
			<OPTION value="1" ${'1' eq jgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq jgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>

</c:if>
		</SELECT>
	</td>
   
   </TD>
       <td class=td1 align=right>
        	发证机关
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT            
               maxLength="50" size="19"
               name="jgdm.pzjgmc" id="pzjgmc" value="${jgdm.pzjgmc}" style=" width:200px;"/>
        <span style="color: #ff0000" id="pzjgmc_warning" style="position:absolute; top:25px; left:5px;"></span>
    </TD>
    
    
</TR>
<!-- lvwei  20170429 直接登记类型 end -->



<TR>
    <TD class="td1" align="right">
        业务范围
    </TD>
    <TD class="td1" colSpan="3">
        <TEXTAREA name="jgdm.jyfw" id="jyfw" rows="3" style="width:75%;margin-top:3px;">${fn:trim(jgdm.jyfw)}</TEXTAREA>
             <INPUT class="num no-border-bx" id="jyfwlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("jyfw"), document.getElementById("jyfwlength"), 0);
        </script>
          <span style="color:red">*</span>
    </TD>
</TR>

<TR>
  <TD class="td1" align="right">
        法定代表人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalTel(this);showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);" onpaste="showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);"
               onafterpaste="onlyDecimal(this);"
               maxLength="11" size="28" name="jgdm.mobile" id="mobile"
               value="${jgdm.mobile}" style=" width:200px;"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
                 <INPUT class="num no-border-bx" id="mobilelength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("mobile"), document.getElementById("mobilelength"), 0);
        </script>
    </TD>

    <td class=td1 align=right>
            法定代表人座机
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
 			   onpaste="showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);"
               maxLength="25" size="28" name="jgdm.frdhhm" id="frdhhm"
               style=" width:200px;" value="${jgdm.frdhhm}"/>
        ${empty requireds['frdhhm']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
                  <INPUT class="num no-border-bx" id="frdhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("frdhhm"), document.getElementById("frdhhmlength"), 0);
        </script>
    </TD>



</TR>
<TR>
    <TD class="td1" align="right">
        注册资金
    </TD>
    <TD class="td1">
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               maxLength="14" size="22"
               name="jgdm.zczj" id="zczj" value="<fmt:formatNumber value='${jgdm.zczj}'  pattern="0.0000" />"
               style=" width:200px;"/>
        <FONT color="red">
            万元
        </FONT>
          <span style="color:red">*</span>
    </TD>
    <TD class="td1" align="right">
        货币种类
    </TD>
    <TD class="td1">
        
            <c:set var="hbzl" value="${jgdm.hbzl==null?'156':jgdm.hbzl}"/>
            <SELECT name="jgdm.hbzl" id="hbzl" style=" width:200px;">
                
              
                    <OPTION value="156">156:人民币</OPTION>
              
            </SELECT>
        <span style="color:red">*</span>
        
    </TD>
</TR>


<TR>
     <TD class="td1" align="right">
        经济行业
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="6" size="23"
               name="jgdm.jjhy2011" id="nnjjhy" value="${fn:trim(jgdm.jjhy2011)}"
               style="z-index: 100; position: relative; width:200px;"/>&nbsp;<INPUT class="button"
                                                                                    onClick="return selectUpWindow('t_nnjjhy');"
                                                                                    type="button"
                                                                                    value=选择 name="btselect4"/>
                                                                                      <span style="color:red">*</span>
        <span id="nnjjhy1" style="position:absolute; top:25px; left:5px;">
            ${nnjjhyMap[fn:trim(jgdm.jjhy2011)]==null?"":nnjjhyMap[fn:trim(jgdm.jjhy2011)]}
        </span>

    </TD>
    <td class=td1 align=right>
        批准文号
    </td>
    <td  class=td1>
        <input  
        		onblur="this.className='input_off';trimIntputValue(this);return judgeCodeZch();"
                onpaste="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
                onkeyup="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
                maxlength="70" size=28 name="jgdm.zch" id="zch" value="${jgdm.zch}" style=" width:200px;"/>
      	<span style="color:red;" id="zchInfo"></span>
        <script type="text/javascript">
            showLengthZch(document.getElementById("zch"), document.getElementById("zchlen"), 70);
        </script>
    </td>
  
</TR>
<TR>
    <TD class="td1" align="right">
        邮政编码
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT 
               onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength="6" size="28" name="jgdm.yzbm" id="yzbm" value="${jgdm.yzbm}" style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </TD>
    <TD class="td1" align="right">
      单位联系电话
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="25" size="19" name="jgdm.dhhm" id="dhhm" value="${jgdm.dhhm}" 
          onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
        style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                      <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </TD>
</TR>
<TR>
   </TD>
       <td class=td1 align=right>
        	电子邮箱
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
              
               maxLength="50" size="19"
               name="jgdm.email" id="email" value="${jgdm.email}" style=" width:200px;"/>
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
               name="jgdm.url" id="url" value="${jgdm.url}" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
 
</TR>
<TR>
    <TD class="td1" align="right" width="15%">
         业务主管单位名称
    </TD>
    <TD class="td1">
        <INPUT maxLength="200" size="28"
               name="jgdm.zgmc" id="zgmc"
               value="${fn:trim(jgdm.zgmc)}"
               style=" width:200px;"/>
                 <INPUT class="button" onClick="addZgdm()" type="button" value=查询
               name="btselect2"/>&nbsp;
        ${empty requireds['zgmc']?'':'<span class="required">*</span>'}
    </TD>
   
    <TD class="td1" align="right" width="15%">
          业务主管单位代码
    </TD>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyNumber(this);" maxLength="18" size="28"
               name="jgdm.zgdm" id="zgdm" style="z-index: 100; position: relative; width:200px;"
               value="${fn:trim(jgdm.zgdm)}"/>
               <INPUT class="button" onClick="addZgmc()" type="button" value=查询
               name="btselect2"/>&nbsp;
        ${empty requireds['zgdm']?'':'<span class="required">*</span>'}
        
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;" id="zgjgdmInfo"></span>

    </TD>
</TR>
<TR>
    <td class=td1 align=right>
        	专职工作人员数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.zzrysl" id="zzrysl"
               style=" width:200px;" value="${jgdm.zzrysl}"/>
    </td> 
   
 
     <td class=td1 align=right>
        兼职工作人员数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.jzrysl" id="jzrysl"
               style=" width:200px;" value="${jgdm.jzrysl}"/>
    </td>
</TR>

<TR>
    <td class=td1 align=right>
        	理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19  name="jgdm.lssl"
               id="lssl" style=" width:200px;" value="${jgdm.lssl}"/>
                 <span style="color:red">*</span>
    </td> 
   
 
     <td class=td1 align=right>
           监事人数
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.jssl" id="jssl"
              style=" width:200px;" value="${jgdm.jssl}"/>
    </td>
</TR>
<c:if test="${'1' eq jglx}">
   <TR>
    <td class=td1 align=right>
        	常务理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.cwlssl"
               id="cwlssl" style=" width:200px;" value="${jgdm.cwlssl}"/>
    </td> 
   
 
</TR>
<TR>
    <td class=td1 align=right>
        	社团会员（单位会员）数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.dwhysl" id="dwhysl"
            style=" width:200px;" value="${jgdm.dwhysl}"/>
    </td> 
   
 
     <td class=td1 align=right>
        社团会员（个人会员）数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.grhysl" id="grhysl"
               style=" width:200px;" value="${jgdm.grhysl}"/>
    </td>
</TR>
</c:if>
<tr>
    
    <td class=td1 align=right>
        	经办人姓名
    </td>
    <td class=td1>
        <input name="jgdm.tbrxm" id="tbrxm" type="text" maxLength="60"  style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.tbrxm }">
                <INPUT class="button" onClick="copy()" type="button" value=复制
               name="btselect2"/>&nbsp;
         <span style="color:red">*</span>
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
        </script>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人手机
    </td>
    <td class=td1>
        <input name="jgdm.tbrmobile" id="tbrmobile" type="text" maxLength="11"  
        onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
        style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.tbrmobile }">
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
        	开户银行
    </td>
    <td class=td1>
        <input name="jgdm.khyh" id="khyh" type="text"  style="z-index: 100; position: relative; width:200px;"
      
               value="${jgdm.khyh }" maxlength="200">
    
        
    </td>
   
	 <td class=td1 align=right>
        	开户账号
    </td>
    <td class=td1>
        <input name="jgdm.kyzh" id="kyzh" type="text"  style="z-index: 100; position: relative; width:200px;"
          onkeyup="onlyDecimalTel(this);"
               value="${jgdm.kyzh }" maxLength="50">
   
             
        
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