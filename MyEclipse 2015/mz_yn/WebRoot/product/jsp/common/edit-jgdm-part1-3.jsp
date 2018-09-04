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
<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="njglxMap" value="<%=InitSysParams.njglxMap%>"/>
<c:set var="thbList" value="<%=InitSysParams.thbList%>"/>
<c:set var="jglxList" value="<%=InitSysParams.tjglxList%>"/>
<c:set var="zjlxList" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="njjhyMap" value="<%=InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%=InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%=InitSysParams.njjlxMap%>"/>
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<c:set var="jjlxMap" value="<%=InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%=InitSysParams.xzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
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
	$(function(){   $("#zgrs").focus();  })
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
    <TD class="td1" align="right" width="15%">
        机构类型
    </TD>
    <TD class="td1" >
        <input name="jglx" id="jglx" type="hidden" value="${fn:trim(jgdm.jglx)}">
        <SELECT style="BACKGROUND-COLOR: #e0e0e0; width:200px;" readonly="readonly" disabled="disabled">
            <option value="0">请选择机构类型</option>
            <c:forEach var="jglx" items="${jglxList}">
                ${fn:trim(jglx.dm)}
                <OPTION value="${fn:trim(jglx.dm)}"  ${(fn:trim(jgdm.jglx) eq fn:trim(jglx.dm))?'selected':''}>${fn:trim(jglx.dm)}:${jglx.mc}</OPTION>
            </c:forEach>
        </SELECT>

    </TD>
    <TD class="td1" width="15%" align="right">
        新机构类型
    </TD>
    <TD class="td1" >
        <SELECT name="njglx" id="njglx" style=" width:200px;">
            <option value="0">请选择新机构类型</option>
            <c:forEach var="jglx" items="${njglxMap}">
                ${fn:trim(jglx.key)}
                <OPTION value="${fn:trim(jglx.key)}"  ${(fn:trim(jglx.key) eq fn:trim(jgdm.njglx))?'selected':''}>${fn:trim(jglx.key)}:${jglx.value}</OPTION>
            </c:forEach>

        </SELECT>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">

    </TD>
    <TD class="td1">
        <INPUT onclick="fChangeRadioForFlag(0);" type="radio"
        ${(jgdm.fkbz eq null or "0"==jgdm.fkbz)?"checked":""} value="0" name="fkbz"/>
        暂不发卡
        <INPUT onclick="fChangeRadioForFlag(1);" type="radio"  ${"1"==jgdm.fkbz?"checked":""} value="1" name="fkbz"/>
        发卡&nbsp;
        <span id="fkslmc" style="display:  ${"1"==jgdm.fkbz?"inline":"none"};">发卡数量：
        <INPUT onkeyup="onlyDecimal(this);" onafterpaste="onlyDecimal(this);;"
                 maxLength="2" size="2"
               value="${jgdm.fksl}" name="fksl" id="fksl"/>
        </span>
    </TD>
    <TD class="td1" align="right" width="15%">&nbsp;
    </TD>
    <TD class="td1" >
        正本数量
        <INPUT style="BACKGROUND-COLOR: #e0e0e0;width:20px;" size="2" value="${jgdm.zbsl eq null ?0:jgdm.zbsl}"
               name="zbsl"
               id="zbsl"
               readonly="readonly"/>&nbsp;
        副本数量
        <INPUT style="width:20px;BACKGROUND-COLOR: #e0e0e0;"
                maxLength="2"
               size="2" readonly='readonly'
               value="${jgdm.fbsl eq null ?1:jgdm.fbsl}" name="fbsl" id="fbsl"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        机构名称
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT name="jgmc" id="jgmc" value="${jgdm.jgmc}"
               style="BACKGROUND-COLOR: #e0e0e0; width:180%;position:absolute;" readonly="readonly"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="mcInfo"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        <label for="fddbr">法人代表</label>
    </TD>
    <TD class="td1">
        <INPUT readonly="readonly" name="fddbr" id="fddbr" value="${jgdm.fddbr}"
               style="BACKGROUND-COLOR: #e0e0e0; width:200px;"/>
        <%--<INPUT onClick=" return gopreview1();" type="button" value="查重" class="button"  name="Button"  />--%>
    </TD>
    <TD class="td1" align="right">
        <SELECT name="zjlx" id="zjlx">
            <c:forEach items="${zjlxList}" var="zjlx">
                <OPTION value="${zjlx.dm}" ${jgdm.zjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
            </c:forEach>
        </SELECT>
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT  onblur="this.className='input_off';return judgeFddbrZjh();"
               onpaste="return onCharsChange_sfzh(this);" onkeyup="return onCharsChange_sfzh(this);" name="zjhm"
               id="zjhm" maxlength="18"
               value="${jgdm.zjhm}" style=" width:200px; float:left; margin-right:5px;"/>
        <INPUT class="num no-border-bx"  tabIndex="100" readOnly size="2" value="${fn:length(jgdm.zjhm)}" name="charsmonitor_sfzh"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="zjhmInfo"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        行政区划
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT value="${fn:trim(jgdm.xzqh)}" name="xzqh" id="xzqh"
               readonly="readonly" style="z-index: 100; position: relative; width:200px;BACKGROUND-COLOR: #e0e0e0;"/>

        <span id="xzqh1"
              style="position:absolute; top:25px; left:5px;">${xzqhMap[fn:trim(jgdm.xzqh)]==null?"":xzqhMap[fn:trim(jgdm.xzqh)]}</span>
    </TD>
    <TD class="td1" align="right">
        职工人数
    </TD>
    <TD class="td1">
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);"
                 maxLength="6" size="19"
               name="zgrs" id="zgrs"
               value="${jgdm.zgrs}" style=" width:200px;"/>
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        单位地址
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT size="158" name="jgdz" id="jgdz" value="${jgdm.jgdz}" readonly="readonly"
               style="BACKGROUND-COLOR: #e0e0e0;  width:75%;"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营范围
    </TD>
    <TD class="td1" colSpan="3">
        <TEXTAREA
                name="jyfw" id="jyfw" rows="3"
                style="width:75%; border: 1 solid ;">${fn:trim(jgdm.jyfw)}</TEXTAREA>
        <INPUT class="num no-border-bx" id="jyfwlength"
               tabIndex="100" readOnly size="4" value="${2000 - fn:length(jgdm.jyfw)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("jyfw"), document.getElementById("jyfwlength"), 2000);
        </script>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经济行业(2011版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT   maxLength="6" size="23"
               name="nnjjhy" id="nnjjhy" value="${fn:trim(jgdm.nnjjhy)}"
               style="z-index: 100; position: relative; width:200px;"/>&nbsp;<INPUT class="button"
                                                                                    onClick="return selectUpWindow('t_nnjjhy');"
                                                                                    type="button"
                                                                                    value=选择 name="btselect4"/>
        <span id="nnjjhy1" style="position:absolute; top:25px; left:5px;">
            ${nnjjhyMap[fn:trim(jgdm.nnjjhy)]==null?"":nnjjhyMap[fn:trim(jgdm.nnjjhy)]}
        </span>

    </TD>
    <TD class="td1" align="right">
        经济行业(2000版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT   maxLength="5" id="njjhy"
               name="njjhy" style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.njjhy)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_njjhy');" type="button" value=选择 name="btselect2"/>
        <span
                id="njjhy1" style="position:absolute; top:25px; left:5px;">
            ${njjhyMap[fn:trim(jgdm.njjhy)]==null?"":njjhyMap[fn:trim(jgdm.njjhy)]}
        </span>
    </TD>
</TR>
<TR>

    <TD class="td1" align="right">
        经济类型(2000版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimal(this);" onafterpaste="onlyDecimal(this);"
                 maxLength="3" name="njjlx"
               id="njjlx" style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.njjlx)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_njjlx');" type="button"
               value=选择 name="btselect4">&nbsp;<span
            id="njjlx1"
            style="position:absolute; top:25px; left:5px;">${njjlxMap[fn:trim(jgdm.njjlx)]==null?"":njjlxMap[fn:trim(jgdm.njjlx)]}</span>
    </TD>
    <TD class="td1" align="right">
        经济类型(94版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimal(this);" onafterpaste="onlyDecimal(this);;"
                 maxLength="3" name="jjlx"
               id="jjlx" style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.jjlx)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_jjlx');" type="button"
               value=选择 name="btselect3">
        <span id="jjlx1"
              style="position:absolute; top:25px; left:5px;">${jjlxMap[fn:trim(jgdm.jjlx)]==null?"":jjlxMap[fn:trim(jgdm.jjlx)]}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        成立日期
    </TD>
    <TD class="td1">
        <INPUT 
               maxLength="10" size="23"
               name="tzcrq" id="zcrq"
               value="<fmt:formatDate value='${jgdm.zcrq}' pattern='yyyy-MM-dd'/>"
               style=" width:200px;" />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zcrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="middle" name="popcal"/>
        </A>
    </TD>
    <TD class="td1" align="right">
        办证日期
    </TD>
    <TD class="td1">
        <c:set var="date" value="<%=new Date()%>"/>
        <INPUT
                readonly="readonly" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               onChange="changeBzrq(this);" name="tbzrq" id="bzrq"
               value="<fmt:formatDate value='${jgdm.bzrq}' pattern='yyyy-MM-dd'/>"
                />
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        <label for="njqx">年检期限</label>
    </TD>
    <TD class="td1">
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('njqx')});"
               maxLength="10" size="23"
               name="tnjqx" id="njqx" value="<fmt:formatDate value='${jgdm.njqx}' pattern='yyyy-MM-dd'/>"
               style=" width:200px;" onclick="WdatePicker({el:$dp.$('njqx')});"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('njqx')});"
           href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="middle" name="popcal"/>
        </A>
    </TD>
    <TD class="td1" align="right">
        <label for="zfrq">作废日期</label>
    </TD>
    <TD class="td1">
        <INPUT readonly="readonly"
               name="tzfrq" id="zfrq" value="<fmt:formatDate value='${jgdm.zfrq}' pattern="yyyy-MM-dd" />"
               style="BACKGROUND-COLOR: #e0e0e0; width:200px;"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        注册资金
    </TD>
    <TD class="td1">
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
                 maxLength="14" size="22"
               name="zczj" id="zczj" value="<fmt:formatNumber value='${jgdm.zczj}'  pattern="0.0000"/>"
               style=" width:200px;"/>
        <FONT color="red">
            万元
        </FONT>
    </TD>
    <TD class="td1" align="right">
        货币种类
    </TD>
    <TD class="td1">
        <DIV>
            <c:set var="hbzl" value="${jgdm.hbzl==null?'156':jgdm.hbzl}"/>
            <SELECT name="hbzl" id="hbzl" style=" width:200px;">
                <c:forEach items="${thbList}" var="hb">
                    <OPTION value="${hb.dm}" ${hb.dm==hbzl?"selected":""}>${hb.dm}:${hb.mc} </OPTION>
                </c:forEach>
            </SELECT>
        </DIV>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        邮政编码
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT  onblur="this.className='input_off';checkPostPage(this,'post');"
               onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);;"
               maxLength="6" size="28" name="yzbm" id="yzbm" value="${jgdm.yzbm}" style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </TD>
    <TD class="td1" align="right">
        联系电话
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="25" size="19" name="dhhm" id="dhhm" value="${jgdm.dhhm}" style=" width:200px;"/>
        <INPUT class="num no-border-bx" readonly="readonly"
              tabIndex="100" size="2" value="${fn:length(jgdm.dhhm)}" name="charsmonitor_dhhm"/><span
            style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        批准机构
    </TD>
    <TD class="td1">
        <INPUT onkeyup="rightValues(this);" onafterpaste="rightValues(this);"
                 maxLength="9" size="23"
               name="pzjgdm" id="pzjgdm" style="z-index: 100; position: relative; width:200px;"
               value="${fn:trim(jgdm.pzjgdm)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_pzjg');" type="button"
               value=选择 name="btselect">
    </TD>
    <TD class="td1" align="right">
        批准机构名称
    </TD>
    <td class="td1">
        <input name="pzjgmc"  id="pzjgmc1" type="hidden" value="${jgdm.pzjgmc}">
        <span id="pzjginfo">${pzjgMap[fn:trim(jgdm.pzjgdm)]}</span>
    </td>
</TR>
<TR>
    <TD class="td1" align="right">
        注&nbsp;册&nbsp;号
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">

        <INPUT  onblur="this.className='input_off';return judgeZch();"
               onpaste="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
               onkeyup="showLengthZch(document.getElementById('zch'),document.getElementById('zchlen'),70);"
               maxLength="70" size="28"
               name="zch" id="zch" ${(audit &&!needAudit)?'readOnly':''} value="${jgdm.zch}"
               style=" width:200px;"/>
        <INPUT class="num no-border-bx" id="zchlen"
               tabIndex="100" readOnly size="2" value="${fn:length(jgdm.zch)}" name="charsmonitor1"/>
        <%--<INPUT onclick=" return judgeZch();" type="button" class="button" value="查重" name="Button"  />--%><span
            style="color:red;position:absolute; top:25px; left:5px;" id="zchInfo"></span>
        <script type="text/javascript">
            showLengthZch(document.getElementById("zch"), document.getElementById("zchlen"), 70);
        </script>
    </TD>
    <TD class="td1" align="right">
        是否公开
    </TD>
    <TD class="td1">
        <INPUT type="radio"  ${(jgdm.gk eq null or "1"==jgdm.gk)?"checked":""} value="1" name="gk"/>
        是
        <INPUT type="radio" ${"2"==jgdm.gk?"checked":""} value="2" name="gk"/>
        否
    </TD>
</TR>
</body>

</html>