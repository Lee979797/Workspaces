<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.code.model.Jfly" %>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<div class="list">
<h3><span style="font-weight: bold;">辅助数据项</span><span>（此区域内容根据实际情况填写，其中带星号为必填项。）</span></h3>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<TR>
    <TD class="td1" align="right"  width="15%">
        经办人姓名
    </TD>
    <TD class="td1">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="30" size="28"
               name="tbrxm" id="tbrxm" value="${jgdmSave.tbrxm}" style=" width:200px;"/>
        ${empty requireds['tbrxm']?'':'<span class="required">*</span>'}
        <INPUT class="button"
               onClick="document.getElementById('tbrsfzh').value=document.getElementById('zjhm').value;document.getElementById('tbrxm').value=document.getElementById('fddbr')?document.getElementById('fddbr').value:''"
               type="button" value="复制" name="btselect2"/>
    </TD>
    <TD class="td1" align="right"  width="15%">
        证件号码
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               onblur="this.className='input_off';trimIntputValue(this);judgeZbrZjhm();"
               onpaste="return onCharsChange_tbrsfzh(this);" onkeyup="return onCharsChange_tbrsfzh(this);"
               maxLength="21" size="19" name="tbrsfzh" id="tbrsfzh" value="${jgdmSave.tbrsfzh}" style=" width:200px;"/>
        ${empty requireds['tbrsfzh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdmSave.tbrsfzh)}"
               name="charsmonitor_tbrsfzh"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="jbrzjhmInfo"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经办人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onafterpaste="onlyDecimalTel(this);"
               onblur="this.className='input_off';trimIntputValue(this);checkJbrTelPage(this);"
               onpaste="onlyDecimalTel(this);return onCharsChange_tbrlxfs(this);"
               onkeyup="return onCharsChange_tbrlxfs(this);onlyDecimalTel(this);"
               maxLength="50" size="19" name="tbrlxfs" id="tbrlxfs" style=" width:200px;" value="${jgdmSave.tbrlxfs}"/>
        ${empty requireds['tbrlxfs']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdmSave.tbrlxfs)}"
               name="charsmonitor_tbrlxfs"/><span
            style="color:red;position:absolute; top:25px; left:5px;" id="jbrTelInfo"></span>
    </TD>
    <TD class="td1" align="right">
        经营期限
    </TD>
    <TD class="td1">
        <INPUT
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="10" size="14"
               name="tgsfzrq" value="<fmt:formatDate value='${jgdmSave.gsfzrq}' pattern='yyyy-MM-dd'/>" id="gsfzrq"
               style=" width:200px;"/>
        ${empty requireds['tbrlxfs']?'':'<span class="required">*</span>'}
        <A hideFocus onclick="WdatePicker({el:$dp.$('gsfzrq')});"
           href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="absMiddle" border="0" name="popcal"/>
        </A>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right" width="15%">
        主管机构
    </TD>
    <TD class="td1"  style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="rightValues(this);" onafterpaste="rightValues(this);"

               name="zgdm" id="zgdm" value="${fn:trim(jgdmSave.zgdm)}"
               style=" width:200px;"/>
        ${empty requireds['zgdm']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zgjg');" type="button" value="选择"
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;" id="zgjgdmInfo"></span>
    </TD>
    <TD class="td1" align="right" width="15%">
        主管机构名称
    </TD>
    <TD class="td1" >
        <INPUT   maxLength="200" size="28"
               name="zgmc" id="zgmc" value="${jgdmSave.zgmc}"
               style=" width:200px;"/>
        ${empty requireds['zgmc']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        登记类型
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimal(this);" onafterpaste="onlyDecimal(this);;"
                 maxLength="3" size="23"
               name="nnjjlx" id="nnjjlx" value="${fn:trim(jgdmSave.nnjjlx)}"
               style=" width:200px;"/>
        ${empty requireds['nnjjlx']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('t_nnjjlx');" type="button"
               value=选择 name="btselect3">&nbsp;<span style="position:absolute; top:25px; left:5px;" id="nnjjlx1"></span>
    </TD>
    <TD class="td1" align="right">
        经济行业(94版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT   maxLength="5" id="jjhy"
               name="jjhy" style=" width:200px;"
               value="${fn:trim(jgdmSave.jjhy)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_jjhy');" type="button" value=选择
               name="btselect1">&nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="jjhy1">${jjhyMap[fn:trim(jgdmSave.jjhy)]}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        外方国别
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
                maxLength="10" size="28" name="wftzgb" id="wftzgb"
               style=" width:200px;" value="${fn:trim(jgdmSave.wftzgb)}"/>
        ${empty requireds['wftzgb']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('wfgb');" type="button" value=选择
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;"
                                             id="wftzgb1">${gjMap[fn:trim(jgdmSave.wftzgb)]==null?"":gjMap[fn:trim(jgdmSave.wftzgb)]}</span>
    </TD>
    <TD class="td1" align="right">
        EMAIL
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               onblur="this.className='input_off';trimIntputValue(this);return emailCheck(this,document.getElementById('email_warning'));"
               maxLength="50" size="19"
               name="email" id="email" value="${jgdmSave.email}" style=" width:200px;"/>
        ${empty requireds['email']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000" id="email_warning" style="position:absolute; top:25px; left:5px;"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        法人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT

               maxLength="11" size="28" name="mobile" id="mobile"
               style=" width:200px;" value="${jgdmSave.mobile}"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdmSave.mobile)}"
               name="charsmonitor_frsj"/>
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
    </TD>
    <TD class="td1" align="right">
        网 址
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
               onblur="this.className='input_off';trimIntputValue(this);URLCheck(this,document.getElementById('url_warning'));"
               maxLength="50"
               size="19"
               name="url" id="url" value="${jgdmSave.url}" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        经营地址
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="60" size="158"
               name="jydz" id="jydz" value="${jgdmSave.jydz}" style="width:75%;"/>
        ${empty requireds['jydz']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="copyAddress();" type="button" value="复制" name="btselect2"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营邮编
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);"
               onblur="this.className='input_off';trimIntputValue(this);checkPostPage(this,'jbrPost');" maxLength="6"
               size="19" name="jyyb" id="jyyb"
               style=" width:200px;" value="${jgdmSave.jyyb}"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="jbrPostInfo"></span>
        ${empty requireds['jyyb']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        经营电话
    </TD>
    <TD class="td1">
        <INPUT  onpaste="return onCharsChange_jydh(this);"
               onkeyup="return onCharsChange_jydh(this);"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="25" size="23" name="jydh" id="jydh"
               style=" width:200px;" value="${jgdmSave.jydh}"/>
        ${empty requireds['jydh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdmSave.jydh)}"
               name="charsmonitor_jydh"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        开户银行
    </TD>
    <TD class="td1">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="50" size="19" style=" width:200px;"
               name="khyh" id="khyh" value="${jgdmSave.khyh}"/>
        ${empty requireds['khyh']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        开户账号
    </TD>
    <TD class="td1">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="25" size="19" name="khzh" id="khzh"
               style=" width:200px;" value="${jgdmSave.khzh}"/>
        ${empty requireds['khzh']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经费来源
    </TD>
    <TD class="td1">
        <SELECT name="jfly" id="jfly" style=" width:200px;">
            <c:forEach var="jfly" items="<%=Jfly.values()%>">
                <OPTION value="${jfly.status}" ${(fn:trim(jfly.status) eq fn:trim(jgdmSave.jfly))?"selected":""}>${jfly.status}</OPTION>
            </c:forEach>
        </SELECT>
        ${empty requireds['jfly']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        机构信用代码
    </TD>
    <TD class="td1">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="25" size="23"
               name="jgxydm" id="jgxydm" value="${jgdmSave.jgxydm}"
               style=" width:200px;"/>
        ${empty requireds['jgxydm']?'':'<span class="required">*</span>'}
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        主要产品1
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;" colspan="3">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp1"
               id="zycp1"
               style=" width:200px;" value="${fn:trim(jgdmSave.zycp1)}"/>
        ${empty requireds['zycp1']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp1');" type="button" value=选择
               name="btselect2"/>&nbsp;<c:set
            var="zycp11" value="${zycpMap[fn:trim(jgdmSave.zycp1)]}"/>
        <span style="position:absolute; top:25px; left:5px;" id="zycp11">${zycp11==null?"":zycp11}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品2
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;" colspan="3">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp2"
               id="zycp2"
               style=" width:200px;" value="${fn:trim(jgdmSave.zycp2)}"/>
        ${empty requireds['zycp2']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp2');" type="button" value=选择
               name="btselect2"/>&nbsp;<c:set
            var="zycp21" value="${zycpMap[fn:trim(jgdmSave.zycp2)]}"/>
        <span style="position:absolute; top:25px; left:5px;" id="zycp21">${zycp21==null?"":zycp21}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品3
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;" colspan="3">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp3"
               id="zycp3"
               style=" width:200px;" value="${fn:trim(jgdmSave.zycp3)}"/>
        ${empty requireds['zycp3']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp3');" type="button" value=选择
               name="btselect2"/>&nbsp;<c:set
            var="zycp31" value="${zycpMap[fn:trim(jgdmSave.zycp3)]}"/>
        <span style="position:absolute; top:25px; left:5px;" id="zycp31">${zycp21==null?"":zycp31}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注1
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="memo" id="memo" value="<c:out  escapeXml="true" value="${jgdmSave.memo}" />"/>
        ${empty requireds['memo']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注2
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="memo2" id="memo2" value="<c:out  escapeXml="true" value="${jgdmSave.memo2}" />"/>
        ${empty requireds['memo2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注3
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="memo3" id="memo3" value="<c:out  escapeXml="true" value="${jgdmSave.memo3}" />"/>
        ${empty requireds['memo3']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注4
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="memo4" id="memo4" value="<c:out  escapeXml="true" value="${jgdmSave.memo4}" />"/>
        ${empty requireds['memo4']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注5
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak1" id="bak1" value="<c:out  escapeXml="true" value="${jgdmSave.bak1}" />"/>
        ${empty requireds['bak1']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注6
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak2" id="bak2" value="<c:out  escapeXml="true" value="${jgdmSave.bak2}" />"/>
        ${empty requireds['bak2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
       业务流水号:
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak3" id="bak3" value="<c:out  escapeXml="true" value="${jgdmSave.bak3}" />"/>
        ${empty requireds['bak3']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR style="display:none;">
    <TD class="td1" align="right">
        备&nbsp;注8
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak4" id="bak4" value="<c:out  escapeXml="true" value="${jgdmSave.bak4}" />"/>
    </TD>
</TR>
<TR style="display:none;">
    <TD class="td1" align="right">
        备&nbsp;注9
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak5" id="bak5" value="<c:out  escapeXml="true" value="${jgdmSave.bak5}" />"/>
        ${empty requireds['bak5']?'':'<span class="required">*</span>'}
    </TD>
</TR>
</TABLE>
<script type="text/javascript" defer="defer">
var jglx = '${jgdmSave.jglx}';
if(jglx!=""){
if (jglx == '1' || jglx == '2' || jglx == 'B') {
	document.getElementById("memo2").value = "小型微型企业";
}else{
	document.getElementById("memo2").value = "";
}
}
</script>
</div>