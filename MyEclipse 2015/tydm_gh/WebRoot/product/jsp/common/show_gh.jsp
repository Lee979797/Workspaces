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
   
</head>
<body>
 <h3><b>工会组织简况</b></h3>
 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
<tr>
	<td class=td1 align=right width="15%">
        发证机关
    </td>
    <td  class=td1 colspan="3">
        <input  
               
              disabled  maxlength="70" size=28 name="jgdm.pzjgmc" id="zgmc" value="${jgdm.pzjgmc}" style=" width:75%"/>
       <span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
  
    </td>
</tr>
<tr>
	   <td class=td1 align=right>
        	职工人数(人)
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.zgrs" id="zgrs"
              style=" width:200px;" value="${jgdm.zgrs}"/><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
             
    </td> 
 
   <%--  <td class=td1 align=right>
  
               专职工会干部数
    </td> 
     <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.gbrs" id="gbrs"
               style=" width:200px;" value="${jgdm.gbrs}"/>
    </td> --%> 
</tr>
<%-- <tr>
	   <td class=td1 align=right>
        	工会届数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.ghjs" id="ghjs"
             id="zzgzrysl" style=" width:200px;" value="${jgdm.ghjs}"/>
             
    </td> 
 
   <td class=td1 align=right >
        	电话
    </td>
     <td class=td1>
       <INPUT onkeyup="onlyDecimalTel(this);" onafterpaste="onlyDecimalTel(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=25 size=19 name="jgdm.ghzxdh" id="ghzxdh"
                style=" width:200px;" value="${jgdm.zgrs}"/>
    </td> 
</tr> --%>
<tr>
	   <td class=td1 align=right>
        	会员人数
    </td>
    <td>
    	     <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jgdm.hyrs" id="hyrs"
               id="zzgzrysl" style=" width:200px;" value="${jgdm.hyrs}"/><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
       <td class=td1 align=right>
        	工会主席姓名
    </td>
    <td>
    	     <INPUT 
               name="jgdm.ghzxmc" id="ghzxmc"
                style=" width:200px;" value="${jgdm.ghzxmc}"/><!-- onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19  --><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
</tr>
</table>


	<h3><b>收入情况</b></h3>
	 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
	<%-- <TR>
    <td class=td1 align=right width="15%">
        上年结余累计(万元)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.snjylj" id="snjylj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.snjylj}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
    </td>
    <td class=td1 align=right >
        年会员缴纳会费收入(万元)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.hhsr" id="hhsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.hhsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
    </td>
</TR> --%>
<TR>
<%--     <td class=td1 align=right>
        年2％拨交工会经费本级留成收入(万元)
    </td>
    <td class=td1>
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.lcsr" id="lcsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.lcsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
    </td> --%>
 <%--  <td class=td1 align=right>
      经费情况 (万元)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.qtsr" id="qtsr" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.qtsr}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT><FONT color=red> * </FONT>
                  <span style="color:red;" id="mcInfo"></span>
    </td>
</TR>
</table>   --%>

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


<h3><b>资金情况</b></h3>
	 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
		<TR>
    <td class=td1 align=right width="15%">
       固定资产情况(万元)
    </td>
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
   <%--  <td class=td1 align=right>
     流动资金(万元)
    </td>
    <td class=td1>
       
                  <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.ldzj" id="ldzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.ldzj}' pattern="0.0000"/>"/>
        <FONT color=red>
            万元
        </FONT>
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
               name="jgdm.qtzj" id="qtzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.qtzj}' pattern="0.0000"/>"/>
    </td>
    <td class=td1 align=right>
        合计
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.hjzj" id="hjzj" style=" width:200px;"
               value="<fmt:formatNumber value='${jgdm.hjzj}' pattern="0.0000"/>"/>
    </td>
</TR> --%>
	</table>


	<h3><b>场所情况</b></h3>
 <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
	<%-- <TR>
    <td class=td1 align=right width="15%">
           办 公 场 所(平方米)M2
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.bgcs" id="bgcs" style=" width:200px;"
               value="${jgdm.bgcs}"/>
    
    </td>
    <td class=td1 align=right>
        活 动 场 所(平方米)M2
    </td>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.hdcs" id="hdcs" style=" width:200px;"
               value="${jgdm.hdcs}"/>
    </td>
</TR> --%>
<TR>
  <%--   <td class=td1 align=right>
        其 他 场 所
    </td>
    <td class=td1>
        <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.qtcs" id="qtcs" style=" width:200px;"
               value="${jgdm.qtcs}"/>
    </td>
    <td class=td1 align=right>
       合计
    </td> --%>
    <td class=td1>
       
                  <INPUT 
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=14 size=22
               name="jgdm.cshj" id="cshj" style=" width:200px;"
               value="${jgdm.cshj}"/>
    </td>
</TR>
	</table>
</body>
</html>