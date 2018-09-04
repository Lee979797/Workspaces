<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="zrxzqh" type="com.ninemax.jpa.code.model.TZrxzqh"--%>
<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>准入办证机构</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/zrxzqhBs.js"></script>
       <script type="text/javascript">
	$(function(){   $("#xzqh").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function fCheckValue() {

            var jgmc, xzqh, sjxzqh, zslsh, njfs, jc, mc;
            jgmc = document.getElementById("jgmc");
            xzqh = document.getElementById("xzqh");
            sjxzqh = document.getElementById("sjxzqh");
            zslsh = document.getElementById("zslsh");
            jc = document.getElementById("jc");
            mc = document.getElementById("mc");
            if (xzqh.value.length != 6) {
                ymPrompt.alert({message: '办证机构输入有误,需要6位长度！', width: 330, height: 220, title: '提示信息'});
                xzqh.focus();
                return false;
            }
            if (!isXzqhUsed()) {
                ymPrompt.alert({message: '办证机构已经存在，请重新填写！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (mc.value.length <= 0) {
                ymPrompt.alert({message: '名称不能为空！', width: 330, height: 220, title: '提示信息'});
                mc.focus();
                return false;
            }
            if (!isMcUsed()) {
                ymPrompt.alert({message: '名称已经存在，请重新填写！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (jc.value.length <= 0) {
                ymPrompt.alert({message: '单位简称不能为空！', width: 330, height: 220, title: '提示信息'});
                document.getElementById("jc").focus();
                return false;
            }
            if (sjxzqh.value.length != 6) {
                ymPrompt.alert({message: '输入上级行政区划有误！', width: 330, height: 220, title: '提示信息'});
                sjxzqh.focus();
                return false;
            }
            var number = /[\d]+/;
            if (!number.test(zslsh.value) || zslsh.value.length <= 0) {
                ymPrompt.alert({message: '组代管流水号输入有误,输入只能是数字！', width: 330, height: 220, title: '提示信息'});
                zslsh.focus();
                return false;
            }
            if (jgmc.value.length <= 0) {
                ymPrompt.alert({message: '请先输入证书颁发单位！', width: 330, height: 220, title: '提示信息'});
                jgmc.focus();
                return false;
            }
            var obj = $("#njjzrq");
            var qsrq = $("#njqsrq");
            if (document.getElementById("njfs_dq").checked && qsrq.val() == "") {
                ymPrompt.alert('年检的起始日期不能为空', 330, 220, '提示信息', function () {
                    qsrq.focus();
                });
                return false;
            }
            if (document.getElementById("njfs_dq").checked && obj.val() == "") {
                ymPrompt.alert('年检的截止日期不能为空', 330, 220, '提示信息', function () {
                    obj.focus();
                });
                return false;
            }
            if (document.getElementById("njfs_dq").checked && $("#njqsrq").val() > obj.val()) {
                ymPrompt.alert('年检的起始日期不能大于截止日期', 330, 220, '提示信息', function () {
                    obj.focus();
                });
                return false;
            }
            thisForm.submit();
            return true;
        }
        function isXzqhUsed() {
            dwr.engine.setAsync(false);
            var flag = true;
            var xzqh = $("#xzqh");
            zrxzqhBs.findByDm(xzqh.val().trim(), function (value) {
                if (value != null) {
                    flag = false;
                    $("#prop").css("color", "red").html("办证机构已经存在，请重新填写！");
                    xzqh.focus();
                } else {
                    flag = true;
                    $("#prop").css("color", "green").html("办证机构可以使用！");
                }
            });
            return flag;
        }
        function isMcUsed() {
            var obj = $("#mc");
            dwr.engine.setAsync(false);
            var flag = true;
            zrxzqhBs.isMcUsedById(obj.val().trim(), $("#xzqh").val().trim(), function (xzqh) {
                if (xzqh) {
                    flag = false;
                    $("#propmc").css("color", "red").html("名称已经存在，请重新填写！");
                    obj.focus();
                } else {
                    flag = true;
                    $("#propmc").css("color", "green").html("名称可以使用！");
                }
            });
            return flag;
        }
        function disp(name) {
            document.getElementById("dqnj").style.display = name;
        }
        function checkLength(obj, length, message) {
            if (obj && obj.value) {
                if (obj.value.realLength() > length) {
                    obj.value = obj.value.zh_substr(0, length);
                    ymPrompt.alert({message: message, width: 330, height: 220, title: '提示信息'});
                    return false;
                }

            }
            return true;
        }
    </script>
    <style type="text/css">
        table.tableBorder0 td {
            height: 37px;
        }
    </style>
</head>
<body style="background:#fff;">
<div class="page_top">
    <div align="left" style=" float: left;">${fn:trim(fn:trim(title))}</div>
</div>
<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<form method="POST" name="thisForm" action="/bsweb/xzqhManage_${fn:trim(fn:trim(source))}.action">
<input type="hidden" value="${fn:trim(zrxzqh.flag)}" name="zrxzqh.flag">
<input type="hidden" name="zrxzqh.csxzqh" value="${zrxzqh.csxzqh}">
<table align=center border=0 class=tableBorder0 cellpadding=0 cellspacing=0 width="100%">
<tr>
    <td class=td1 align="right" width="15%">办证机构：</td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input type="text" name="zrxzqh.xzqh" id="xzqh" value="${fn:trim(zrxzqh.xzqh)}" ${zrxzqh.bzjgflag?'readonly':''}
               size="35" maxlength="6">&nbsp;<span style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="prop"></span>
    </td>
    <td class=td1 align="right" width="15%">名称：</td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.mc" id="mc" type="text" size="35" maxlength="60" value="${fn:trim(zrxzqh.mc)}">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propmc"></span>
    </td>
</tr>
<tr>
    <td align="left" class=td1>
        <div align="right">单位简称：</div>
    </td>
    <td align="left" class=td1 style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.jc" id='jc' type="text" value="${fn:trim(zrxzqh.jc)}" size="35"
               maxlength="20">&nbsp;<span style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propjc"></span>
    </td>

    <td class=td1 align="right" width="15%">机构代码：
    </td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.jgdm" id="jgdm" type="text" size="35" value="${fn:trim(zrxzqh.jgdm)}"
               maxlength="9">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propjgdm"></span>
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">
        <label for="zdlevel">行政级别：</label>

    </td>
    <td class=td1 align="left" >
        <select name="zrxzqh.zdlevel" id="zdlevel" style="width: 210px">
            <c:if test="${fn:substring(fn:trim(zrxzqh.xzqh),2,6) eq '0000' }">
                <option value="0" selected>中心级</option>
            </c:if>
            <c:if test="${fn:trim(fn:substring(fn:trim(zrxzqh.xzqh),2,6) ne '0000' and fn:substring(fn:trim(zrxzqh.xzqh),4,6) eq '00' )}">
                <option value="1" selected>地市级</option>
            </c:if>
            <c:if test="${fn:trim(fn:substring(fn:trim(zrxzqh.xzqh),2,6) ne '0000' and fn:substring(fn:trim(zrxzqh.xzqh),4,6) ne '00' )}">
                <option value="2" selected>区县级</option>
            </c:if>
        </select>
        <span style="color: #FF0000;">*</span>
    </td>
    <td class=td1 align="right" width="15%">
        上级行政区划：
    </td>
    <td class=td1 align="left">
        <input name="zrxzqh.sjxzqh" id="sjxzqh" type="text" size="35"
               maxlength="6"    ${fn:trim((source eq 'update_xzqh')?"readonly":"")}
               value="<c:choose><c:when test="${fn:trim(source) eq 'update_xzqh'}">${zrxzqh.sjxzqh}</c:when><c:when test="${fn:trim(source ne 'update_xzqh') and fn:substring(zrxzqh.xzqh,4,6) eq '00'}">${fn:substring(zrxzqh.xzqh,0 ,2 )}${'0000'}</c:when><c:otherwise>${fn:substring(zrxzqh.xzqh,0 ,4 )}${'00'}</c:otherwise></c:choose>"
                />
        <span style="color: #FF0000; ">*</span>
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">
        组代管流水号：
    </td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.zsbh" id="zslsh" type="text" size="35" value="${fn:trim(zrxzqh.zsbh)}"
               maxlength="6">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propzslsh"></span>
    </td>
    <td class=td1 align="right" width="15%">
        证书颁发单位：
    </td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.jgmc" id="jgmc" type="text" size="35" value="${fn:trim(zrxzqh.jgmc)}"
               maxlength="60">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propjgmc"></span>
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">
        单位地址：
    </td>
    <td class=td1 align="left" >
        <input name="zrxzqh.dz" id="dz" type="text" size="35" value="${fn:trim(zrxzqh.dz)}" maxlength="120">
    </td>
    <td class=td1 align="right" width="15%">
        邮政编码：
    </td>
    <td class=td1 align="left" width="26%">
        <input name="zrxzqh.yzbm" id="yzbm" type="text"
               size="35" value="${fn:trim(zrxzqh.yzbm)}"
               maxlength="6">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">联系人：</td>
    <td class=td1 align="left" >
        <input name="zrxzqh.lxr" id="lxr" type="text" size="35" value="${fn:trim(zrxzqh.lxr)}" maxlength="20">
    </td>
    <td class=td1 align="right" width="15%">联系电话：</td>
    <td class=td1 align="left" width="26%">
        <input name="zrxzqh.dh" id="dh" type="text" size="35" value="${fn:trim(zrxzqh.dh)}" maxlength="21">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">IP：</td>
    <td class=td1 align="left" >
        <input name="zrxzqh.ip" id="ip" value="${fn:trim(zrxzqh.ip)}" type="text" size="35" maxlength="15">
    </td>
    <td class=td1 align="right" width="15%">主从办证点：</td>
    <td class=td1 align="left" >
        ${zrxzqh.bzjgflag?"主":"从"}
        <input type="hidden" name="zrxzqh.bzjgflag" value="${zrxzqh.bzjgflag}">
    </td>
</tr>
<c:if test="${!zrxzqh.bzjgflag}">
    <tr>
        <td class=td1 align="right" width="15%">是否可发证：</td>
        <td class=td1 align="left" >
            <input type="radio" name="zrxzqh.fzflag" value="1" ${zrxzqh.fzflag ne '1'? "":"checked"}>
            是
            <input type="radio" name="zrxzqh.fzflag" ${zrxzqh.fzflag ne '1'? "checked":""} value="0">
            否
        </td>
        <td class=td1 align="right" width="15%">是否可赋码：</td>
        <td class=td1 align="left" width="26%">
            <input type="radio" name="zrxzqh.fmflag" value="true" checked>
            是
            <input type="radio" name="zrxzqh.fmflag" value="false">
            否
        </td>
    </tr>
</c:if>
<c:if test="${zrxzqh.bzjgflag}">
    <input type="hidden" name="zrxzqh.fzflag" value="1">
    <input type="hidden" name="zrxzqh.fmflag" value="true">
</c:if>

<tr>

    <td class=td1 align="right" width="15%">是否可制卡：</td>
    <td class=td1 align="left" width="26%">
        <input type="radio" name="zrxzqh.dkflag" ${fn:trim(zrxzqh.dkflag  eq "1"?"checked":"")}
               value="1">
        是
        <input type="radio" name="zrxzqh.dkflag" value="0"  ${fn:trim(zrxzqh.dkflag  ne  "1"  ?"checked":"")}>
        否
    </td>
    <td align="right" class=td1>证书年检方式：</td>
    <td align="left" class=td1>
        <input id="njfs_gd" type="radio" name="zrxzqh.njfs" value="0" onclick="disp('none');"
        ${fn:trim(zrxzqh.njfs eq '0'?'checked':'')} >
        办证日期加一年&nbsp;<input id="njfs_dq" type="radio" name="zrxzqh.njfs" onclick="disp('block');"
    ${fn:trim(zrxzqh.njfs eq '0'?'':'checked')} value="1">
        定期年检
    </td>
</tr>
<tr>
    <td align="right" class=td1>年检提示：</td>
    <td align="left" class=td1>

        <input type="radio" name="zrxzqh.njtsbz" value="true"  ${zrxzqh.njtsbz ?'checked':''} > 显示&nbsp;
        <input type="radio" name="zrxzqh.njtsbz"   value="false"  ${zrxzqh.njtsbz ?'':'checked'} > 隐藏
    </td>
    <td align="left" class=td1 colspan="2">


        <div align="left" style="display:${zrxzqh.njfs eq '0'?'none':'block'}; margin-left: 100px;" id="dqnj">
            定期年检：每年从
            <input type="text" name="zrxzqh.njqsrq" id="njqsrq" title="定期年检日期，格式为：MMDD"
                   onclick="WdatePicker({el:$dp.$('njqsrq1'),dateFmt: 'MMdd',minDate: '%y-01-01', maxDate: '\#{%y+1}-01-01' })"
                   value="${fn:trim(zrxzqh.njqsrq) }"
                   size="4" maxlength="4">
            至
            <input type="text" name="zrxzqh.njjzrq" id="njjzrq"
                   value="${fn:trim(zrxzqh.njjzrq)}"
                   onclick="WdatePicker({el:$dp.$('njqsrq1'),dateFmt: 'MMdd',minDate: '%y-01-01', maxDate: '\#{%y+1}-01-01' })"
                   size="4" maxlength="4" title="定期年检日期，格式为：MMDD">
            日定期年检
        </div>
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">证书打印通告1：</td>
    <td colspan="3" align="left" class=td1>
        <input type="text" name="zrxzqh.zstg1" size="100" maxlength="100"
               value="${fn:trim(zrxzqh.zstg1)}"
               onblur="checkLength(this,100,'系统限制最大长度不超过100个字符，或50个汉字')"
               onkeyup="checkLength(this,100,'系统限制最大长度不超过100个字符，或50个汉字')">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">证书打印通告2：</td>
    <td colspan="3" align="left" class=td1>
        <input type="text" name="zrxzqh.zstg2" size="100" maxlength="100"
               value="${fn:trim(zrxzqh.zstg2)}"
               onblur="checkLength(this,100,'系统限制最大长度不超过100个字符，或50个汉字')"
               onkeyup="checkLength(this,100,'系统限制最大长度不超过100个字符，或50个汉字')">
    </td>
</tr>
<tr>
    <td class=td1 width="10%" colspan="4" align="right">
        <div align="left">&nbsp;注：设置&quot;证书打印通告<span style="color:#FF0000;">2</span>&quot;时可以用字符%代表年检期限月份，&amp;代表年检期限日期；打印证书时系统自动将该符号转换成月份或日期。
        </div>
    </td>
</tr>
</table>
<div class="listbtn">
    <input type="button" name="btok" value="${(source eq 'update_xzqh')?'保 存':'准 入'}"
           onClick="javascript:return fCheckValue();"
           class="newBtn1">&nbsp;<input type="button" value="返 回" name="cmdExit" class="newBtn1"
                                   onclick=" history.back()">
</div>
</form>
</div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
    $(function () {
        $("#dh").blur(function () {
            var obj = this;
            if (/^((\d{3,4}\-\d{7,8})|13\d{9,9})$/.test(this.value)) {
            } else {
                ymPrompt.alert('请输入正确格式的电话号码，如：010-88888888,131012345678', 330, 220, '提示信息', function () {
                });
            }
        });

        $("#mc").keyup(function () {
            if ($(this).val().realLength() > 60) {
                $(this).val($(this).val().zh_substr(0, 60));
                $("#propmc").css("color", "red").html("系统限制名称最长60个字符，或30个汉字！");
            }
        }).blur(function () {
                    if ($(this).val().realLength() > 60) {
                        $(this).val($(this).val().zh_substr(0, 60));
                        $("#propmc").css("color", "red").html("系统限制名称最长60个字符，或30个汉字！");
                        return false;
                    }
                    dwr.engine.setAsync(false);
                    var flag = true;
                    zrxzqhBs.isMcUsedById($(this).val(), $("#xzqh").val(), function (xzqh) {
                        if (xzqh) {
                            flag = false;
                            $("#propmc").css("color", "red").html("名称已经存在，请重新填写！");
                        } else {
                            flag = true;
                            $("#propmc").css("color", "green").html("名称可以使用！");
                        }
                    });
                    return flag;
                });
        $("#jc").keyup(function () {
            if ($(this).val().realLength() > 20) {
                $(this).val($(this).val().zh_substr(0, 20));
                $("#propjc").css("color", "red").html("单位简称最长20个字符或10个汉字！");
            }
        }).blur(function () {
                    if ($(this).val().realLength() > 20) {
                        $(this).val($(this).val().zh_substr(0, 20));
                        $("#propjc").css("color", "red").html("单位简称最长20个字符或10个汉字！");
                        return false;
                    } else {
                        flag = true;
                        $("#propjc").css("color", "green").html("单位简称可以使用！");
                        return true;
                    }
                });
        $("#zslsh").keyup(function () {
            $(this).val($(this).val().trim().replace(/[^\d]+/, ""));
            if ($(this).val().realLength() > 20) {
                $(this).val($(this).val().zh_substr(0, 20));
                $("#propzslsh").css("color", "red").html("组代管流水号最长20个数字！");
            }
        }).blur(function () {
                    $(this).val($(this).val().trim().replace(/[^\d]+/, ""));
                    if ($(this).val().realLength() > 20) {
                        $(this).val($(this).val().zh_substr(0, 20));
                        $("#propjc").css("color", "red").html("组代管流水号最长20个数字！");
                        return false;
                    } else {
                        flag = true;
                        $("#propzslsh").css("color", "green").html("组代管流水号可以使用！");
                        return true;
                    }
                });
        $("#jgmc").blur(function () {
            if ($(this).val().realLength() > 60) {
                $(this).val($(this).val().zh_substr(0, 60));
                $("#propjgmc").css("color", "red").html("系统限制证书颁发单位最长60个字符，或30个汉字！");
                return false;
            } else {
                $("#propjgmc").css("color", "green").html("证书颁发单位输入正确！");
                return true;
            }
        }).keyup(function () {
                    if ($(this).val().realLength() > 60) {
                        $(this).val($(this).val().zh_substr(0, 60));
                        $("#propjgmc").css("color", "red").html("系统限制证书颁发单位最长60个字符，或30个汉字！");
                        return false;
                    }
                    return true;
                });
        $("#jgdm").keyup(function () {
            $(this).val($(this).val().trim().toUpperCase());
            if (/^[A-Z\d]{9}$/.test($(this).val())) {
                return true;
            } else {
                $(this).val($(this).val().replace(/[^A-Z\d]/, ''));
                return false;
            }
        }).blur(function () {
                    $(this).val($(this).val().trim().toUpperCase());
                    if (/^[A-Z\d]{9}$/.test($(this).val())) {
                        $("#propjgdm").css("color", "green").html("机构代码输入正确！");

                        return true;
                    } else {
                        $(this).val($(this).val().replace(/[^A-Z\d]/, ''));
                        $("#propjgdm").css("color", "red").html("机构代码输入错误，只能是9位字母或数字！");
                        return false;
                    }
                });


        $("#yzbm").bind("blur", function () {
            var obj = this;
            if (/^\d{6,6}$/.test(this.value)) {
            } else {
                ymPrompt.alert('请输入正确格式的邮政编码，如：123456', 330, 220, '提示信息', function () {
                });
            }
        });
        $("#dqnj input").bind("blur", function () {
            var obj = $("#njjzrq");
            var zhis = $(this);
            if (!/^\d{4}$/.test(zhis.val())) {
                ymPrompt.alert('请输入正确格式的日期：MMdd', 330, 220, '提示信息', function () {
                });
            } else {
                if (Number(zhis.val().substr(0, 2)) > 12 || Number(zhis.val().substr(2, 4)) > 31) {
                    ymPrompt.alert('请输入正确格式的日期：MMdd', 330, 220, '提示信息', function () {
                    });
                }
            }
            if ($("#njqsrq").val() > $("#njjzrq").val()) {
                ymPrompt.alert('年检的起始日期不能大于截止日期', 330, 220, '提示信息', function () {
                });
            }
        });
        $("#lxr").bind("keyup blur", function () {
            return checkLength(this, 20, '系统限制最大长度不超过20个字符，或10个汉字');
        });
        $("#ip").blur(function () {
            var obj = this;
            if (isIP(obj.value)) {
                return true;
            } else {
                ymPrompt.alert('请输入正确格式的IP地址，如：192.168.0.1', 330, 220, '提示信息', function () {
                });
                return false;
            }
        });
    })
    ;
    <c:if test="${message!=null && message!=''}">
    ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </c:if>
</script>
</body>
</html>