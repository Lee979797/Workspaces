<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="zrxzqh" type="com.ninemax.jpa.code.model.TZrxzqh"--%>
<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>׼���֤����</TITLE>
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
                ymPrompt.alert({message: '��֤������������,��Ҫ6λ���ȣ�', width: 330, height: 220, title: '��ʾ��Ϣ'});
                xzqh.focus();
                return false;
            }
            if (!isXzqhUsed()) {
                ymPrompt.alert({message: '��֤�����Ѿ����ڣ���������д��', width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            if (mc.value.length <= 0) {
                ymPrompt.alert({message: '���Ʋ���Ϊ�գ�', width: 330, height: 220, title: '��ʾ��Ϣ'});
                mc.focus();
                return false;
            }
            if (!isMcUsed()) {
                ymPrompt.alert({message: '�����Ѿ����ڣ���������д��', width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            if (jc.value.length <= 0) {
                ymPrompt.alert({message: '��λ��Ʋ���Ϊ�գ�', width: 330, height: 220, title: '��ʾ��Ϣ'});
                document.getElementById("jc").focus();
                return false;
            }
            if (sjxzqh.value.length != 6) {
                ymPrompt.alert({message: '�����ϼ�������������', width: 330, height: 220, title: '��ʾ��Ϣ'});
                sjxzqh.focus();
                return false;
            }
            var number = /[\d]+/;
            if (!number.test(zslsh.value) || zslsh.value.length <= 0) {
                ymPrompt.alert({message: '�������ˮ����������,����ֻ�������֣�', width: 330, height: 220, title: '��ʾ��Ϣ'});
                zslsh.focus();
                return false;
            }
            if (jgmc.value.length <= 0) {
                ymPrompt.alert({message: '��������֤��䷢��λ��', width: 330, height: 220, title: '��ʾ��Ϣ'});
                jgmc.focus();
                return false;
            }
            var obj = $("#njjzrq");
            var qsrq = $("#njqsrq");
            if (document.getElementById("njfs_dq").checked && qsrq.val() == "") {
                ymPrompt.alert('������ʼ���ڲ���Ϊ��', 330, 220, '��ʾ��Ϣ', function () {
                    qsrq.focus();
                });
                return false;
            }
            if (document.getElementById("njfs_dq").checked && obj.val() == "") {
                ymPrompt.alert('���Ľ�ֹ���ڲ���Ϊ��', 330, 220, '��ʾ��Ϣ', function () {
                    obj.focus();
                });
                return false;
            }
            if (document.getElementById("njfs_dq").checked && $("#njqsrq").val() > obj.val()) {
                ymPrompt.alert('������ʼ���ڲ��ܴ��ڽ�ֹ����', 330, 220, '��ʾ��Ϣ', function () {
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
                    $("#prop").css("color", "red").html("��֤�����Ѿ����ڣ���������д��");
                    xzqh.focus();
                } else {
                    flag = true;
                    $("#prop").css("color", "green").html("��֤��������ʹ�ã�");
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
                    $("#propmc").css("color", "red").html("�����Ѿ����ڣ���������д��");
                    obj.focus();
                } else {
                    flag = true;
                    $("#propmc").css("color", "green").html("���ƿ���ʹ�ã�");
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
                    ymPrompt.alert({message: message, width: 330, height: 220, title: '��ʾ��Ϣ'});
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
    <td class=td1 align="right" width="15%">��֤������</td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input type="text" name="zrxzqh.xzqh" id="xzqh" value="${fn:trim(zrxzqh.xzqh)}" ${zrxzqh.bzjgflag?'readonly':''}
               size="35" maxlength="6">&nbsp;<span style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="prop"></span>
    </td>
    <td class=td1 align="right" width="15%">���ƣ�</td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.mc" id="mc" type="text" size="35" maxlength="60" value="${fn:trim(zrxzqh.mc)}">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propmc"></span>
    </td>
</tr>
<tr>
    <td align="left" class=td1>
        <div align="right">��λ��ƣ�</div>
    </td>
    <td align="left" class=td1 style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.jc" id='jc' type="text" value="${fn:trim(zrxzqh.jc)}" size="35"
               maxlength="20">&nbsp;<span style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propjc"></span>
    </td>

    <td class=td1 align="right" width="15%">�������룺
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
        <label for="zdlevel">��������</label>

    </td>
    <td class=td1 align="left" >
        <select name="zrxzqh.zdlevel" id="zdlevel" style="width: 210px">
            <c:if test="${fn:substring(fn:trim(zrxzqh.xzqh),2,6) eq '0000' }">
                <option value="0" selected>���ļ�</option>
            </c:if>
            <c:if test="${fn:trim(fn:substring(fn:trim(zrxzqh.xzqh),2,6) ne '0000' and fn:substring(fn:trim(zrxzqh.xzqh),4,6) eq '00' )}">
                <option value="1" selected>���м�</option>
            </c:if>
            <c:if test="${fn:trim(fn:substring(fn:trim(zrxzqh.xzqh),2,6) ne '0000' and fn:substring(fn:trim(zrxzqh.xzqh),4,6) ne '00' )}">
                <option value="2" selected>���ؼ�</option>
            </c:if>
        </select>
        <span style="color: #FF0000;">*</span>
    </td>
    <td class=td1 align="right" width="15%">
        �ϼ�����������
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
        �������ˮ�ţ�
    </td>
    <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
        <input name="zrxzqh.zsbh" id="zslsh" type="text" size="35" value="${fn:trim(zrxzqh.zsbh)}"
               maxlength="6">&nbsp;<span
            style="color: #FF0000;">*</span>
        <span style="position:absolute; top:20px;left:0px; color: #FF0000;" id="propzslsh"></span>
    </td>
    <td class=td1 align="right" width="15%">
        ֤��䷢��λ��
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
        ��λ��ַ��
    </td>
    <td class=td1 align="left" >
        <input name="zrxzqh.dz" id="dz" type="text" size="35" value="${fn:trim(zrxzqh.dz)}" maxlength="120">
    </td>
    <td class=td1 align="right" width="15%">
        �������룺
    </td>
    <td class=td1 align="left" width="26%">
        <input name="zrxzqh.yzbm" id="yzbm" type="text"
               size="35" value="${fn:trim(zrxzqh.yzbm)}"
               maxlength="6">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">��ϵ�ˣ�</td>
    <td class=td1 align="left" >
        <input name="zrxzqh.lxr" id="lxr" type="text" size="35" value="${fn:trim(zrxzqh.lxr)}" maxlength="20">
    </td>
    <td class=td1 align="right" width="15%">��ϵ�绰��</td>
    <td class=td1 align="left" width="26%">
        <input name="zrxzqh.dh" id="dh" type="text" size="35" value="${fn:trim(zrxzqh.dh)}" maxlength="21">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">IP��</td>
    <td class=td1 align="left" >
        <input name="zrxzqh.ip" id="ip" value="${fn:trim(zrxzqh.ip)}" type="text" size="35" maxlength="15">
    </td>
    <td class=td1 align="right" width="15%">���Ӱ�֤�㣺</td>
    <td class=td1 align="left" >
        ${zrxzqh.bzjgflag?"��":"��"}
        <input type="hidden" name="zrxzqh.bzjgflag" value="${zrxzqh.bzjgflag}">
    </td>
</tr>
<c:if test="${!zrxzqh.bzjgflag}">
    <tr>
        <td class=td1 align="right" width="15%">�Ƿ�ɷ�֤��</td>
        <td class=td1 align="left" >
            <input type="radio" name="zrxzqh.fzflag" value="1" ${zrxzqh.fzflag ne '1'? "":"checked"}>
            ��
            <input type="radio" name="zrxzqh.fzflag" ${zrxzqh.fzflag ne '1'? "checked":""} value="0">
            ��
        </td>
        <td class=td1 align="right" width="15%">�Ƿ�ɸ��룺</td>
        <td class=td1 align="left" width="26%">
            <input type="radio" name="zrxzqh.fmflag" value="true" checked>
            ��
            <input type="radio" name="zrxzqh.fmflag" value="false">
            ��
        </td>
    </tr>
</c:if>
<c:if test="${zrxzqh.bzjgflag}">
    <input type="hidden" name="zrxzqh.fzflag" value="1">
    <input type="hidden" name="zrxzqh.fmflag" value="true">
</c:if>

<tr>

    <td class=td1 align="right" width="15%">�Ƿ���ƿ���</td>
    <td class=td1 align="left" width="26%">
        <input type="radio" name="zrxzqh.dkflag" ${fn:trim(zrxzqh.dkflag  eq "1"?"checked":"")}
               value="1">
        ��
        <input type="radio" name="zrxzqh.dkflag" value="0"  ${fn:trim(zrxzqh.dkflag  ne  "1"  ?"checked":"")}>
        ��
    </td>
    <td align="right" class=td1>֤����췽ʽ��</td>
    <td align="left" class=td1>
        <input id="njfs_gd" type="radio" name="zrxzqh.njfs" value="0" onclick="disp('none');"
        ${fn:trim(zrxzqh.njfs eq '0'?'checked':'')} >
        ��֤���ڼ�һ��&nbsp;<input id="njfs_dq" type="radio" name="zrxzqh.njfs" onclick="disp('block');"
    ${fn:trim(zrxzqh.njfs eq '0'?'':'checked')} value="1">
        �������
    </td>
</tr>
<tr>
    <td align="right" class=td1>�����ʾ��</td>
    <td align="left" class=td1>

        <input type="radio" name="zrxzqh.njtsbz" value="true"  ${zrxzqh.njtsbz ?'checked':''} > ��ʾ&nbsp;
        <input type="radio" name="zrxzqh.njtsbz"   value="false"  ${zrxzqh.njtsbz ?'':'checked'} > ����
    </td>
    <td align="left" class=td1 colspan="2">


        <div align="left" style="display:${zrxzqh.njfs eq '0'?'none':'block'}; margin-left: 100px;" id="dqnj">
            ������죺ÿ���
            <input type="text" name="zrxzqh.njqsrq" id="njqsrq" title="����������ڣ���ʽΪ��MMDD"
                   onclick="WdatePicker({el:$dp.$('njqsrq1'),dateFmt: 'MMdd',minDate: '%y-01-01', maxDate: '\#{%y+1}-01-01' })"
                   value="${fn:trim(zrxzqh.njqsrq) }"
                   size="4" maxlength="4">
            ��
            <input type="text" name="zrxzqh.njjzrq" id="njjzrq"
                   value="${fn:trim(zrxzqh.njjzrq)}"
                   onclick="WdatePicker({el:$dp.$('njqsrq1'),dateFmt: 'MMdd',minDate: '%y-01-01', maxDate: '\#{%y+1}-01-01' })"
                   size="4" maxlength="4" title="����������ڣ���ʽΪ��MMDD">
            �ն������
        </div>
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">֤���ӡͨ��1��</td>
    <td colspan="3" align="left" class=td1>
        <input type="text" name="zrxzqh.zstg1" size="100" maxlength="100"
               value="${fn:trim(zrxzqh.zstg1)}"
               onblur="checkLength(this,100,'ϵͳ������󳤶Ȳ�����100���ַ�����50������')"
               onkeyup="checkLength(this,100,'ϵͳ������󳤶Ȳ�����100���ַ�����50������')">
    </td>
</tr>
<tr>
    <td class=td1 align="right" width="15%">֤���ӡͨ��2��</td>
    <td colspan="3" align="left" class=td1>
        <input type="text" name="zrxzqh.zstg2" size="100" maxlength="100"
               value="${fn:trim(zrxzqh.zstg2)}"
               onblur="checkLength(this,100,'ϵͳ������󳤶Ȳ�����100���ַ�����50������')"
               onkeyup="checkLength(this,100,'ϵͳ������󳤶Ȳ�����100���ַ�����50������')">
    </td>
</tr>
<tr>
    <td class=td1 width="10%" colspan="4" align="right">
        <div align="left">&nbsp;ע������&quot;֤���ӡͨ��<span style="color:#FF0000;">2</span>&quot;ʱ�������ַ�%������������·ݣ�&amp;��������������ڣ���ӡ֤��ʱϵͳ�Զ����÷���ת�����·ݻ����ڡ�
        </div>
    </td>
</tr>
</table>
<div class="listbtn">
    <input type="button" name="btok" value="${(source eq 'update_xzqh')?'�� ��':'׼ ��'}"
           onClick="javascript:return fCheckValue();"
           class="newBtn1">&nbsp;<input type="button" value="�� ��" name="cmdExit" class="newBtn1"
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
                ymPrompt.alert('��������ȷ��ʽ�ĵ绰���룬�磺010-88888888,131012345678', 330, 220, '��ʾ��Ϣ', function () {
                });
            }
        });

        $("#mc").keyup(function () {
            if ($(this).val().realLength() > 60) {
                $(this).val($(this).val().zh_substr(0, 60));
                $("#propmc").css("color", "red").html("ϵͳ���������60���ַ�����30�����֣�");
            }
        }).blur(function () {
                    if ($(this).val().realLength() > 60) {
                        $(this).val($(this).val().zh_substr(0, 60));
                        $("#propmc").css("color", "red").html("ϵͳ���������60���ַ�����30�����֣�");
                        return false;
                    }
                    dwr.engine.setAsync(false);
                    var flag = true;
                    zrxzqhBs.isMcUsedById($(this).val(), $("#xzqh").val(), function (xzqh) {
                        if (xzqh) {
                            flag = false;
                            $("#propmc").css("color", "red").html("�����Ѿ����ڣ���������д��");
                        } else {
                            flag = true;
                            $("#propmc").css("color", "green").html("���ƿ���ʹ�ã�");
                        }
                    });
                    return flag;
                });
        $("#jc").keyup(function () {
            if ($(this).val().realLength() > 20) {
                $(this).val($(this).val().zh_substr(0, 20));
                $("#propjc").css("color", "red").html("��λ����20���ַ���10�����֣�");
            }
        }).blur(function () {
                    if ($(this).val().realLength() > 20) {
                        $(this).val($(this).val().zh_substr(0, 20));
                        $("#propjc").css("color", "red").html("��λ����20���ַ���10�����֣�");
                        return false;
                    } else {
                        flag = true;
                        $("#propjc").css("color", "green").html("��λ��ƿ���ʹ�ã�");
                        return true;
                    }
                });
        $("#zslsh").keyup(function () {
            $(this).val($(this).val().trim().replace(/[^\d]+/, ""));
            if ($(this).val().realLength() > 20) {
                $(this).val($(this).val().zh_substr(0, 20));
                $("#propzslsh").css("color", "red").html("�������ˮ���20�����֣�");
            }
        }).blur(function () {
                    $(this).val($(this).val().trim().replace(/[^\d]+/, ""));
                    if ($(this).val().realLength() > 20) {
                        $(this).val($(this).val().zh_substr(0, 20));
                        $("#propjc").css("color", "red").html("�������ˮ���20�����֣�");
                        return false;
                    } else {
                        flag = true;
                        $("#propzslsh").css("color", "green").html("�������ˮ�ſ���ʹ�ã�");
                        return true;
                    }
                });
        $("#jgmc").blur(function () {
            if ($(this).val().realLength() > 60) {
                $(this).val($(this).val().zh_substr(0, 60));
                $("#propjgmc").css("color", "red").html("ϵͳ����֤��䷢��λ�60���ַ�����30�����֣�");
                return false;
            } else {
                $("#propjgmc").css("color", "green").html("֤��䷢��λ������ȷ��");
                return true;
            }
        }).keyup(function () {
                    if ($(this).val().realLength() > 60) {
                        $(this).val($(this).val().zh_substr(0, 60));
                        $("#propjgmc").css("color", "red").html("ϵͳ����֤��䷢��λ�60���ַ�����30�����֣�");
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
                        $("#propjgdm").css("color", "green").html("��������������ȷ��");

                        return true;
                    } else {
                        $(this).val($(this).val().replace(/[^A-Z\d]/, ''));
                        $("#propjgdm").css("color", "red").html("���������������ֻ����9λ��ĸ�����֣�");
                        return false;
                    }
                });


        $("#yzbm").bind("blur", function () {
            var obj = this;
            if (/^\d{6,6}$/.test(this.value)) {
            } else {
                ymPrompt.alert('��������ȷ��ʽ���������룬�磺123456', 330, 220, '��ʾ��Ϣ', function () {
                });
            }
        });
        $("#dqnj input").bind("blur", function () {
            var obj = $("#njjzrq");
            var zhis = $(this);
            if (!/^\d{4}$/.test(zhis.val())) {
                ymPrompt.alert('��������ȷ��ʽ�����ڣ�MMdd', 330, 220, '��ʾ��Ϣ', function () {
                });
            } else {
                if (Number(zhis.val().substr(0, 2)) > 12 || Number(zhis.val().substr(2, 4)) > 31) {
                    ymPrompt.alert('��������ȷ��ʽ�����ڣ�MMdd', 330, 220, '��ʾ��Ϣ', function () {
                    });
                }
            }
            if ($("#njqsrq").val() > $("#njjzrq").val()) {
                ymPrompt.alert('������ʼ���ڲ��ܴ��ڽ�ֹ����', 330, 220, '��ʾ��Ϣ', function () {
                });
            }
        });
        $("#lxr").bind("keyup blur", function () {
            return checkLength(this, 20, 'ϵͳ������󳤶Ȳ�����20���ַ�����10������');
        });
        $("#ip").blur(function () {
            var obj = this;
            if (isIP(obj.value)) {
                return true;
            } else {
                ymPrompt.alert('��������ȷ��ʽ��IP��ַ���磺192.168.0.1', 330, 220, '��ʾ��Ϣ', function () {
                });
                return false;
            }
        });
    })
    ;
    <c:if test="${message!=null && message!=''}">
    ymPrompt.errorInfo('${message}', 330, 220, '��ʾ��Ϣ');
    </c:if>
</script>
</body>
</html>