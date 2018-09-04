<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list">
<h3><span style="font-weight: bold;">辅助数据项</span><span>（此区域内容根据实际情况填写，其中带星号为必填项。）</span></h3>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<TR>
    <TD class="td1" align="right"   width="15%">
        经办人姓名
    </TD>
    <TD class="td1">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="30" size="28"
               name="tbrxm" id="tbrxm" value="<%=tJgdm.getTbrxm()==null?"":tJgdm.getTbrxm()%>"
               style=" width:200px;"/>
        ${empty requireds['tbrxm']?'':'<span class="required">*</span>'}
        <INPUT class="button"
               onClick="document.getElementById('tbrsfzh').value=document.getElementById('zjhm').value;document.getElementById('tbrxm').value=document.getElementById('fddbr')?document.getElementById('fddbr').value:''"
               type="button" value="复制" name="btselect2"/>
    </TD>
    <TD class="td1" align="right"   width="15%">
        证件号码
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);judgeZbrZjhm();"
               onpaste="return onCharsChange_tbrsfzh(this);" onkeyup="return onCharsChange_tbrsfzh(this);"
               maxLength="21" size="19" name="tbrsfzh" id="tbrsfzh"
               value="<%=tJgdm.getTbrsfzh()==null?"":tJgdm.getTbrsfzh()%>" style=" width:200px;"/>
        ${empty requireds['tbrsfzh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2"
               value="<%=tJgdm.getTbrsfzh()==null?"0":tJgdm.getTbrsfzh().length()%>" name="charsmonitor_tbrsfzh"/>
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
               onpaste="return onCharsChange_tbrlxfs(this);"
               onkeyup="onlyDecimalTel(this);return onCharsChange_tbrlxfs(this);"
               maxLength="50" size="19" name="tbrlxfs" id="tbrlxfs"
               value="<%=tJgdm.getTbrlxfs()==null?"":tJgdm.getTbrlxfs()%>" style=" width:200px;"/>
        ${empty requireds['tbrlxfs']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2"
               value="<%=tJgdm.getTbrlxfs()==null?"0":tJgdm.getTbrlxfs().length()%>" name="charsmonitor_tbrlxfs"/><span
            style="color:red;position:absolute; top:25px; left:5px;" id="jbrTelInfo"></span>
    </TD>
    <TD class="td1" align="right">
        经营期限
    </TD>
    <TD class="td1">
        <INPUT  maxLength="10" size="14"
               name="tgsfzrq" id="gsfzrq" 
               value="<%=tJgdm.getGsfzrq()==null?"":DateUtil.dateToStr(tJgdm.getGsfzrq())%>"
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
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="9" size="28"
               name="zgdm" id="zgdm" style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getZgdm()==null?"":tJgdm.getZgdm().trim()%>"/>
        ${empty requireds['zgdm']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zgjg');" type="button" value=选择
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;" id="zgjgdmInfo"></span>
    </TD>
    <TD class="td1" align="right" width="15%">
        主管机构名称
    </TD>
    <TD class="td1">
        <INPUT maxLength="200" size="28"
               name="zgmc" id="zgmc"
               value="<%=clsStringTool.convertNull(tJgdm.getZgmc())%>"
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
               name="nnjjlx" id="nnjjlx" value="<%=tJgdm.getNnjjlx()==null?"":tJgdm.getNnjjlx().trim()%>"
               style="z-index: 100; position: relative; width:200px;"/>
        ${empty requireds['njjlxzk1']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('t_nnjjlx');" type="button"
               value=选择 name="btselect3">&nbsp;<span style="position:absolute; top:25px; left:5px;"
                                                     id="nnjjlx1"><%=InitSysParams.jjlx2k1Map == null ? "" : InitSysParams.jjlx2k1Map.get(tJgdm.getNnjjlx() == null ? "" : tJgdm.getNnjjlx().trim()) == null ? "" : InitSysParams.jjlx2k1Map.get(tJgdm.getNnjjlx() == null ? "" : tJgdm.getNnjjlx().trim())%></span>
    </TD>
    <TD class="td1" align="right">
        经济行业(94版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="5" id="jjhy"
               name="jjhy" style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getJjhy()==null?"":tJgdm.getJjhy().trim()%>"/>
        <INPUT class="button" onClick="return selectUpWindow('t_jjhy');" type="button" value=选择
               name="btselect1">&nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="jjhy1"><%=InitSysParams.jjhyMap.get(tJgdm.getJjhy()) == null ? "" : InitSysParams.jjhyMap.get(tJgdm.getJjhy())%></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        外方国别
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               maxLength="3" size="28" name="wftzgb" id="wftzgb"
               style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getWftzgb()==null?"":tJgdm.getWftzgb().trim()%>"/>
        ${empty requireds['wftzgb']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('wfgb');" type="button" value=选择
               name="btselect2"/>&nbsp;<span
            id="wftzgb1"
            style="position:absolute; top:25px; left:5px;"><%=tJgdm.getWftzgb() == null || tJgdm.getWftzgb().trim().equals("") ? "" : (InitSysParams.gjMap.get(tJgdm.getWftzgb()) == null ? "" : InitSysParams.gjMap.get(tJgdm.getWftzgb()))%></span>
    </TD>
    <TD class="td1" align="right">
        EMAIL
    </TD>
    <TD class="td1">
        <INPUT
                onblur="this.className='input_off';trimIntputValue(this);return emailCheck(this,document.getElementById('email_warning'));"
                maxLength="50" size="19" value="<%=tJgdm.getEmail()==null?"":"null".equals(tJgdm.getEmail())?"":tJgdm.getEmail()%>"
                name="email" id="email" style=" width:200px;"/>
        ${empty requireds['email']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000" id="email_warning"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        法人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="11" size="28" name="mobile" id="mobile"
                value="<%=tJgdm.getMobile()==null?"":tJgdm.getMobile()%>" style=" width:200px;"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2"
               value="<%=tJgdm.getMobile()==null?0:tJgdm.getMobile().length()%>"
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
                name="url" id="url" value="<%=tJgdm.getUrl()==null?"":tJgdm.getUrl()%>" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        经营地址
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="60" size="158"
               name="jydz" id="jydz" value="<%=tJgdm.getJydz()==null?"":tJgdm.getJydz()%>"
               style=" width:75%;"/>
        ${empty requireds['jydz']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="copyAddress();" type="button" value="复制" name="btselect2"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营邮编
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);checkPostPage(this,'jbrPost');"
               maxLength="6" size="19"
               name="jyyb" id="jyyb" value="<%=tJgdm.getJyyb()==null?"":tJgdm.getJyyb()%>"
               style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="jbrPostInfo"></span>
        ${empty requireds['jyyb']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        经营电话
    </TD>
    <TD class="td1">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="25" size="23" onpaste="return onCharsChange_jydh(this);"
               onkeyup="return onCharsChange_jydh(this);"
               name="jydh" id="jydh" value="<%=tJgdm.getJydh()==null?"":tJgdm.getJydh()%>"
               style=" width:200px;"/>
        ${empty requireds['jydh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2"
               value="<%=tJgdm.getJydh()==null?0:tJgdm.getJydh().length()%>"
               name="charsmonitor_jydh"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        开户银行
    </TD>
    <TD class="td1">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="50" style=" width:200px;"
               name="khyh" id="khyh" value="<%=tJgdm.getKhyh()==null?"":tJgdm.getKhyh()%>"/>
        ${empty requireds['khyh']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        开户账号
    </TD>
    <TD class="td1">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="25" size="19" name="khzh" id="khzh"
               value="<%=tJgdm.getKhzh()==null?"":tJgdm.getKhzh()%>" style=" width:200px;"/>
        ${empty requireds['khzh']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经费来源
    </TD>
    <TD class="td1">
        <SELECT name="jfly" id="jfly" style=" width:200px;">
            <OPTION value="" <%
                if ("".equals(tJgdm.getJfly()) || tJgdm.getJfly() == null) {
                    out.print("selected");
                }
            %>>
            </OPTION>
            <OPTION value="全额拨款" <%
                if ("全额拨款".equals(tJgdm.getJfly())) {
                    out.print("selected");
                }
            %>>
                全额拨款
            </OPTION>
            <OPTION value="差额拨款" <%
                if ("差额拨款".equals(tJgdm.getJfly())) {
                    out.print("selected");
                }
            %>>
                差额拨款
            </OPTION>
            <OPTION value="财政拨款" <%
                if ("财政拨款".equals(tJgdm.getJfly())) {
                    out.print("selected");
                }
            %>>
                财政拨款
            </OPTION>
            <OPTION value="自收自支" <%
                if ("自收自支".equals(tJgdm.getJfly())) {
                    out.print("selected");
                }
            %>>
                自收自支
            </OPTION>
            <OPTION value="其他" <%
                if ("其他".equals(tJgdm.getJfly())) {
                    out.print("selected");
                }
            %>>
                其他
            </OPTION>
        </SELECT>
        ${empty requireds['jfly']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        机构信用代码
    </TD>
    <TD class="td1">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="25" size="23"
               name="jgxydm" id="jgxydm" value="<%=clsStringTool.isEmpty(tJgdm.getJgxydm())?"":tJgdm.getJgxydm()%>"
               style="z-index: 100; position: relative; width:200px;"/>
        ${empty requireds['jgxydm']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品1
    </TD>
    <TD class="td1" colspan="3" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp1"
               id="zycp1"
               style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getZycp1()==null||"".equals(tJgdm.getZycp1().trim())?"":tJgdm.getZycp1().trim()%>"/>
        ${empty requireds['zycp1']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp1');" type="button" value=选择
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;"
                                             id="zycp11"><%=tJgdm.getZycp1() == null || "".equals(tJgdm.getZycp1().trim()) ? "" : (InitSysParams.zycpMap.get(tJgdm.getZycp1().trim()) == null ? "" : InitSysParams.zycpMap.get(tJgdm.getZycp1().trim()).length() > 50 ? InitSysParams.zycpMap.get(tJgdm.getZycp1().trim()).substring(0, 50) + "..." : InitSysParams.zycpMap.get(tJgdm.getZycp1().trim()))%></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品2
    </TD>
    <TD class="td1" colspan="3" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp2"
               id="zycp2"
               style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getZycp2()==null?"":tJgdm.getZycp2().trim()%>"/>
        ${empty requireds['zycp2']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp2');" type="button" value=选择
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;"
                                             id="zycp21"><%=tJgdm.getZycp2() == null || "".equals(tJgdm.getZycp2().trim()) ? "" : (InitSysParams.zycpMap.get(tJgdm.getZycp2().trim()) == null ? "" : InitSysParams.zycpMap.get(tJgdm.getZycp2().trim()).length() > 50 ? InitSysParams.zycpMap.get(tJgdm.getZycp2().trim()).substring(0, 50) + "..." : InitSysParams.zycpMap.get(tJgdm.getZycp2().trim()))%></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品3
    </TD>
    <TD class="td1" colspan="3" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               onblur="this.className='input_off';trimIntputValue(this);" maxLength="5" size="28" name="zycp3"
               id="zycp3"
               style="z-index: 100; position: relative; width:200px;"
               value="<%=tJgdm.getZycp3()==null?"":tJgdm.getZycp3().trim()%>"/>
        ${empty requireds['zycp3']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp3');" type="button" value=选择
               name="btselect2"/>&nbsp;<span style="position:absolute; top:25px; left:5px;"
                                             id="zycp31"><%=tJgdm.getZycp3() == null || "".equals(tJgdm.getZycp3().trim()) ? "" : (InitSysParams.zycpMap.get(tJgdm.getZycp3().trim()) == null ? "" : InitSysParams.zycpMap.get(tJgdm.getZycp3().trim()).length() > 50 ? InitSysParams.zycpMap.get(tJgdm.getZycp3().trim()).substring(0, 50) + "..." : InitSysParams.zycpMap.get(tJgdm.getZycp3().trim()))%></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注1
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="158" style="width:75%;"
               name="memo" id="memo" value="<c:out  escapeXml="true" value="${tJgdm.memo}" />"/>
        ${empty requireds['memo2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注2
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="158" style="width:75%;"
               name="memo2" id="memo2" value="<c:out  escapeXml="true" value="${tJgdm.memo2}" />"/>
        ${empty requireds['memo2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注3
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="158" style="width:75%;"
               name="memo3" id="memo3" value="<c:out  escapeXml="true" value="${tJgdm.memo3}" />"/>
        ${empty requireds['memo3']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注4
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="158" style="width:75%;"
               name="memo4" id="memo4" value="<c:out  escapeXml="true" value="${tJgdm.memo4}" />"/>
        ${empty requireds['memo4']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注5
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak1" id="bak1" value="<c:out  escapeXml="true" value="${tJgdm.bak1}" />"/>
        ${empty requireds['bak1']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注6
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak2" id="bak2" value="<c:out  escapeXml="true" value="${tJgdm.bak2}" />"/>
        ${empty requireds['bak2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        业务流水号:
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak3" id="bak3" value="<c:out  escapeXml="true" value="${tJgdm.bak3}" />"/>
        ${empty requireds['bak3']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR style="display:none;">
    <TD class="td1" align="right">
        备&nbsp;注8
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak4" id="bak4" value="<c:out  escapeXml="true" value="${tJgdm.bak4}" />"/>
    </TD>
</TR>
<TR style="display:none;">
    <TD class="td1" align="right">
        备&nbsp;注9
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="250" size="180" style="width:75%;"
               name="bak5" id="bak5" value="<c:out  escapeXml="true" value="${tJgdm.bak5}" />"/>
        ${empty requireds['bak5']?'':'<span class="required">*</span>'}
    </TD>
</TR>
</TABLE>
<script type="text/javascript" defer="defer">
var jglx = '${tJgdm.jglx}';
if(jglx!=""){
if (jglx == '1' || jglx == '2' || jglx == 'B') {
	document.getElementById("memo2").value = "小型微型企业";
}else{
	document.getElementById("memo2").value = "";
}
}
</script>
</div>
