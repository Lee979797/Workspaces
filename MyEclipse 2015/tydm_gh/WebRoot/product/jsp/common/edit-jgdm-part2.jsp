<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.Jfly" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>

<c:set var="nnjjhyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
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
   
    <script type="text/javascript">
        function getItems(items) {
            if (items && items.length > 0) {
                var fields = items.split(",");
                if (fields && fields.length > 0)
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
    </script>
</head>
<body>
<div class="list">
<h3><span style="font-weight: bold;">辅助数据项</span><span>（此区域内容根据实际情况填写，其中带星号为必填项。）</span></h3>
<INPUT type="hidden" value="${jgdm.dybz}" name="jgdm.dybz"/>
<INPUT type="hidden" value="${jgdm.zslsh}" name="jgdm.zslsh"/>
<input type="hidden" name="jgdm.scbzrq" value="<fmt:formatDate value="${jgdm.scbzrq}"/>" id="scbzrq"/>
<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
<TR>
    <TD class="td1" align="right"  width="15%">
        经办人姓名
    </TD>
    <TD class="td1">
        <INPUT
                maxLength="30" size="28"
                name="jgdm.tbrxm" id="tbrxm" value="${jgdm.tbrxm}" style=" width:200px;"/>
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
                onblur="this.className='input_off';judgeZbrZjhm();"
                onpaste="return onCharsChange_tbrsfzh(this);" onkeyup="return onCharsChange_tbrsfzh(this);"
                maxLength="21" size="21" name="jgdm.tbrsfzh" id="tbrsfzh" value="${jgdm.tbrsfzh}"
                style=" width:200px;"/>
        ${empty requireds['tbrsfzh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdm.tbrsfzh)}"
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
               onpaste="return onCharsChange_tbrlxfs(this);"
               onkeyup="onlyDecimalTel(this);return onCharsChange_tbrlxfs(this);"
               maxLength="50" size="19" name="jgdm.tbrlxfs" id="tbrlxfs" value="${jgdm.tbrlxfs}"
               style=" width:200px;"/>
        ${empty requireds['tbrlxfs']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdm.tbrlxfs)}"
               name="charsmonitor_tbrlxfs"/><span
            style="color:red;position:absolute; top:25px; left:5px;" id="jbrTelInfo"></span>
    </TD>
    <TD class="td1" align="right">
        经营期限
    </TD>
    <TD class="td1">
        <INPUT 
               maxLength="10" size="14"
               name="jgdm.gsfzrq" id="gsfzrq" value="<fmt:formatDate value='${jgdm.gsfzrq}' pattern='yyyy-MM-dd'/>"
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
               name="jgdm.zgdm" id="zgdm" style="z-index: 100; position: relative; width:200px;"
               value="${fn:trim(jgdm.zgdm)}"/>
        ${empty requireds['zgdm']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zgjg');" type="button" value=选择 name="btselect2"/>
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;" id="zgjgdmInfo"></span>

    </TD>
    <TD class="td1" align="right" width="15%">
        主管机构名称
    </TD>
    <TD class="td1">
        <INPUT maxLength="200" size="28"
               name="jgdm.zgmc" id="zgmc"
               value="${fn:trim(jgdm.zgmc)}"
               style=" width:200px;"/>
        ${empty requireds['zgmc']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>

    <TD class="td1" align="right">
        登记类型
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="3" size="23"
               name="jgdm.nnjjlx" id="nnjjlx" value="${fn:trim(jgdm.nnjjlx)}"
               style="z-index: 100; position: relative; width:200px;"/>
        ${empty requireds['njjlxzk1']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('t_nnjjlx');" type="button"
               value=选择 name="btselect3">&nbsp;<span id="nnjjlx1" style="position:absolute; top:25px; left:5px;">
        ${nnjjlxMap[fn:trim(jgdm.nnjjlx)]==null?"":nnjjlxMap[fn:trim(jgdm.nnjjlx)]}
    </span>
    </TD>
    <TD class="td1" align="right">
        经济行业(94版)
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="5" id="jjhy"
               name="jgdm.jjhy" style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.jjhy)}"/>
        <INPUT class="button" onClick="return selectUpWindow('t_jjhy');" type="button" value=选择
               name="btselect1">&nbsp;<span
            style="position:absolute; top:25px; left:5px;"
            id="jjhy1"> ${jjhyMap[fn:trim(jgdm.jjhy)]==null?"":jjhyMap[fn:trim(jgdm.jjhy)]}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        外方国别
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);"
               maxLength="10" size="28" name="jgdm.wftzgb" id="wftzgb"
               style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.wftzgb)}"/>
        ${empty requireds['wftzgb']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('wfgb');" type="button" value=选择
               name="btselect2"/>&nbsp;<span
            id="wftzgb1" style="position:absolute; top:25px; left:5px;">
        ${gjMap[fn:trim(jgdm.wftzgb)]==null?"":gjMap[fn:trim(jgdm.wftzgb)]}
    </span>
    </TD>
    <TD class="td1" align="right">
        EMAIL
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
                onblur="this.className='input_off';return emailCheck(this,document.getElementById('email_warning'));"
                maxLength="50" size="19" id="email"
                name="jgdm.email" value="${jgdm.email eq 'null'?'':jgdm.email}" style=" width:200px;"/>
        ${empty requireds['email']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="email_warning"></span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        法人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimal(this);return onCharsChange_frsj(this);" onpaste="return onCharsChange_frsj(this);"
               onafterpaste="onlyDecimal(this);"
               maxLength="11" size="28" name="jgdm.mobile" id="mobile"
               value="${jgdm.mobile}" style=" width:200px;"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdm.mobile)}"
               name="charsmonitor_frsj"/>
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
    </TD>
    <TD class="td1" align="right">
        <label for="url">网 址</label>
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
                onblur="this.className='input_off';URLCheck(this,document.getElementById('url_warning'));"
                maxLength="50"
                size="19" id="url"
                name="jgdm.url" value="${jgdm.url}" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
</TR>

<TR>
    <TD class="td1" align="right">
        经营地址
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="60" size="158"
               id="jydz" name="jgdm.jydz" value="${fn:endsWith(source,'in')?'':jgdm.jydz}" style=" width:75%;"/>
        ${empty requireds['jydz']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="copyAddress();" type="button" value="复制" name="btselect2"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经营邮编
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onblur="this.className='input_off';checkPostPage(this,'jbrPost');"
               maxLength="6" size="19"
               name="jgdm.jyyb" id="jyyb" value="${jgdm.jyyb}" style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="jbrPostInfo"></span>
        ${empty requireds['jyyb']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        经营电话
    </TD>
    <TD class="td1">
        <INPUT maxLength="25" size="23"
               onpaste="return onCharsChange_jydh(this);" onkeyup="return onCharsChange_jydh(this);"
               id="jydh" name="jgdm.jydh" value="${jgdm.jydh}" style=" width:200px;"/>
        ${empty requireds['jydh']?'':'<span class="required">*</span>'}
        <INPUT class="num no-border" tabIndex="100" readOnly size="2" value="${fn:length(jgdm.jydh)}"
               name="charsmonitor_jydh"/>
        <%--<span id="jydhmc"
              style="BORDER-LEFT-COLOR: #ffffff; BORDER-BOTTOM-COLOR: #ffffff; COLOR: #ff0000; BORDER-TOP-STYLE: solid; BORDER-TOP-COLOR: #ffffff; BORDER-RIGHT-STYLE: solid; BORDER-LEFT-STYLE: solid; BORDER-RIGHT-COLOR: #ffffff; BORDER-BOTTOM-STYLE: solid">
                 0
              </span>--%>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        开户银行
    </TD>
    <TD class="td1">
        <INPUT maxLength="100" size="158"
               id="khyh" name="jgdm.khyh" value="${jgdm.khyh}" style=" width:200px;"/>
        ${empty requireds['khyh']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        开户账号
    </TD>
    <TD class="td1">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               maxLength="25" size="19" name="jgdm.khzh"
               id="khzh" value="${jgdm.khzh}" style=" width:200px;"/>
        ${empty requireds['khzh']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        经费来源
    </TD>
    <TD class="td1">
        <SELECT name="jgdm.jfly" id="jfly" style=" width:200px;">
            <OPTION value="" ${(null eq jgdm.jfly || '' eq jgdm.jfly)?"selected":""}></OPTION>
            <c:forEach var="jfly" items="<%=Jfly.values()%>">
                <OPTION value="${jfly.status}" ${(jfly.status eq jgdm.jfly)?"selected":""}>${jfly.status}</OPTION>
            </c:forEach>
        </SELECT>
        ${empty requireds['jfly']?'':'<span class="required">*</span>'}
    </TD>
    <TD class="td1" align="right">
        机构信用代码
    </TD>
    <TD class="td1">
        <INPUT
                maxLength="25" size="25"
                name="jgdm.jgxydm" id="jgxydm" value="${jgdm.jgxydm}"
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
               maxLength="5" size="28" name="jgdm.zycp1" id="zycp1"
               style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.zycp1)}"/>
        ${empty requireds['zycp1']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp1');" type="button" value="选择" name="btselect2"/>&nbsp;<c:set
            var="zycp11" value="${zycpMap[fn:trim(jgdm.zycp1)]}"/>
        <span id="zycp11"
              style="position:absolute; top:25px; left:5px;">${zycp11==null?"":(fn:length(zycp11)>50?(fn:substring(zycp11,0,50)):zycp11)}${zycp11==null?"":(fn:length(zycp11)>50?("..."):"")}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品2
    </TD>
    <TD class="td1" colspan="3" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               maxLength="5" size="28" name="jgdm.zycp2" id="zycp2"
               style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.zycp2)}"/>
        ${empty requireds['zycp2']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp2');" type="button" value="选择" name="btselect2"/>&nbsp;<c:set
            var="zycp21" value="${zycpMap[fn:trim(jgdm.zycp2)]}"/>
        <span id="zycp21"
              style="position:absolute; top:25px; left:5px;">${zycp21==null?"":(fn:length(zycp21)>50?(fn:substring(zycp21,0,50)):zycp21)}${zycp21==null?"":(fn:length(zycp21)>50?("..."):"")}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        主要产品3
    </TD>
    <TD class="td1" colspan="3" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);"
               onafterpaste="onlyDecimalZero(this);;"
               maxLength="5" size="28" name="jgdm.zycp3" id="zycp3"
               style="z-index: 100; position: relative; width:200px;" value="${fn:trim(jgdm.zycp3)}"/>
        ${empty requireds['zycp3']?'':'<span class="required">*</span>'}
        <INPUT class="button" onClick="return selectUpWindow('zycp3');" type="button" value=选择
               name="btselect2"/>&nbsp;<c:set
            var="zycp31" value="${zycpMap[fn:trim(jgdm.zycp3)]}"/>
        <span id="zycp31"
              style="position:absolute; top:25px; left:5px;">${zycp31==null?"":(fn:length(zycp31)>50?(fn:substring(zycp31,0,50)):zycp31)}${zycp31==null?"":(fn:length(zycp31)>50?("..."):"")}</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注1
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="memo" name="jgdm.memo" value="${fn:escapeXml(jgdm.memo)}" style="width:75%;"/>
        ${empty requireds['memo']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注2
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="memo2" name="jgdm.memo2" value="${fn:escapeXml(jgdm.memo2)}" style="width:75%;"/>
        ${empty requireds['memo2']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注3
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="memo3" name="jgdm.memo3" value="${fn:escapeXml(jgdm.memo3)}" style="width:75%;"/>
        ${empty requireds['memo3']?'':'<span class="required">*</span>'}
        <INPUT type="hidden" name="btxs" id="btxs"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注4
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="memo4" name="jgdm.memo4" value="${fn:escapeXml(jgdm.memo4)}" style="width:75%;"/>
        ${empty requireds['memo4']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注5
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="bak1" name="jgdm.bak1" value="${fn:escapeXml(jgdm.bak1)}" style="width:75%;"/>
        ${empty requireds['bak1']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注6
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="bak2" name="jgdm.bak2" value="${fn:escapeXml(jgdm.bak2)}" style="width:75%;"/>
        ${empty requireds['bak2']?'':'<span class="required">*</span>'}
        <INPUT type="hidden" name="btxs" id="btxs"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注7
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="bak3" name="jgdm.bak3" value="${fn:escapeXml(jgdm.bak3)}" style="width:75%;"/>
        ${empty requireds['bak3']?'':'<span class="required">*</span>'}
    </TD>
</TR>
<TR style="display:none;">
    <TD class="td1" align="right">
        备&nbsp;注8
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="bak4" name="jgdm.bak4" value="${fn:escapeXml(jgdm.bak4)}" style="width:75%;"/>
        ${empty requireds['bak4']?'':'<span class="required">*</span>'}
        <INPUT type="hidden" name="btxs" id="btxs"/>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        备&nbsp;注9
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT maxLength="250" size="158"
               id="bak5" name="jgdm.bak5" value="${fn:escapeXml(jgdm.bak5)}" style="width:75%;"/>
        ${empty requireds['bak5']?'':'<span class="required">*</span>'}
    </TD>
</TR>
</TABLE>
</div>
</body>
</html>
<script type="text/javascript">
    window.onload = function () {
        dwr.engine.setAsync(false);
        var lx = $("#jglx").val();
        if (lx == null || lx.trim() == "") {
            return;
        }
        btxBus.getBtx(lx.trim(), function (data) {
            $(".required").remove();
            $("#btxs").val(data);
            $(data).after('<span class="required">*</span>');
        });
    }
</script>
<script type="text/javascript" defer="defer">
var jglx = '${jgdm.jglx}';
if(jglx!=""){
if (jglx == '1' || jglx == '2' || jglx == 'B') {
	document.getElementById("memo2").value = "小型微型企业";
}else{
	document.getElementById("memo2").value = "";
}
}
</script>