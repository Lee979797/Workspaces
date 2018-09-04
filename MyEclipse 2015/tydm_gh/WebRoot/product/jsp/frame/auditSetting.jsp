<%--@elvariable id="system" type="com.ninemax.jpa.code.model.TSystem"--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/zrxzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    
    <script type="text/javascript">
	$(function(){   $("#gtcfsz").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function fCheckValue() {
            var printAfterDay = $("#printAfterDay");
            var njqx = $("#njqx");
            var hzqx = $("#hzqx");
            var gtcfsz = $("#gtcfsz");
            var cfjesx = $("#cfjesx");
            var reg = /^\d*$/;
            if (!reg.test(printAfterDay.val())) {
                ymPrompt.alert({ message: "��������ʵĴ�֤�ӳ����ڣ�",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        printAfterDay.focus();
                    }
                });
                return false;

            }
            if (!reg.test(njqx.val())) {
                ymPrompt.alert({ message: "��������ʵ����������ޣ�",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        njqx.focus();
                    }
                });
                return false;

            }
            if (!reg.test(hzqx.val())) {
                ymPrompt.alert({ message: "��������ʵĻ�֤�������ޣ�",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        hzqx.focus();
                    }
                });
                return false;

            }
            if (!reg.test(gtcfsz.val())) {
                ymPrompt.alert({ message: "�������Ͳ���ȷ��������������",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        gtcfsz.focus();
                    }
                });
                return false;
            }
            if (!reg.test(cfjesx.val())) {
                ymPrompt.alert({ message: "�������Ͳ���ȷ��������������",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        cfjesx.focus();
                    }
                });
                return false;
            }
            if (Number(gtcfsz.val()) > Number(cfjesx.val())) {
                ymPrompt.alert({ message: "���������޲��ܴ������ޣ�",
                    width: 330, height: 220, title: "��ʾ��Ϣ", handler: function (tp) {
                        gtcfsz.focus();
                    }
                });
                return false;
            }
            document.busForm.submit();
        }
        function run(message) {
            if (message != null && "" != message) {
                ymPrompt.succeedInfo(message, 380, 220, '��ʾ��Ϣ', function () {
                    //   window.parent.left.location.reload();
                    window.location.href = "/bsweb/auditSetting_setting.html";
                });
            }
        }
        function verifyValue(obj) {
            if (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40") {
                return;
            }
            if (obj && obj.value && obj.value.length > 0 && !/^\d*$/.test(obj.value)) {
                obj.value = obj.value.replace(/[\D\s]/gm, "");
                obj.focus();
            }
            if (obj && obj.value && obj.value.length > 0 && /^0+\d+$/.test(obj.value)) {
                obj.value = obj.value.replace(/^0*(\d+)$/, "$1");
                obj.focus();
            }
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div style="float:left;"><strong>ϵͳ &gt;&gt; ϵͳ���� &gt;&gt; �������� </strong></div>
    <div align="class="newBtn1"="width: 30% ; float: right;">
        &nbsp;
        <input name="button" type="button" onclick="fCheckValue()" class="btn1" id="submit" value="�� ��"/>
        &nbsp;
    </div>
    <div style="clear:both;"></div>
</div>
<form method="post" action="/bsweb/auditSetting_saveSetting.action" name="busForm"
      id="busForm">
<input type="hidden" name="system.xzqhdm" value="${system.xzqhdm}"/>

<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<table width="100%" border="0">

<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    ��������
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ҵ�����ǰ�Ƿ��鴦����
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.isPunish?"checked":""} value="true"
                           name="system.isPunish"/>
                    ��
                    <INPUT type="radio"  ${!system.isPunish?"checked":""} value="false"
                           name="system.isPunish"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ���������ƣ�
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.gtcfsz}" style="width: 40px" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           maxlength="4" id="gtcfsz"
                           name="system.gtcfsz"/><label for="gtcfsz">&nbsp;��&nbsp;</label>
                    <INPUT type="text" value="${system.cfjesx}" style="width: 40px" maxlength="4" id="cfjesx"
                           name="system.cfjesx" onkeyup="verifyValue(this)" onblur="verifyValue(this);"/><label
                        for="cfjesx">&nbsp;Ԫ</label>
                </TD>
                <TD class="td1" align="right">
                    �°쳬��ʱ�䣺����ǰ&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.xbcqsz==null?30:system.xbcqsz}" id="xbcqsz"
                           onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.xbcqsz"/>&nbsp;��
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    ��������
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ��ʾ���棺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.xsgg?"checked":""} value="true" name="system.xsgg"/>
                    ��
                    <INPUT type=radio  ${!system.xsgg?"checked":""} value="false" name="system.xsgg"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ����������ȡ��
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.isGs?"checked":""} value="true" name="system.isGs"/>
                    ��
                    <INPUT type=radio  ${!system.isGs?"checked":""} value="false" name="system.isGs"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ��ӡ֤��ǿ��¼���ţ�
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.forceEntryNo?"checked":""} value="true" name="system.forceEntryNo"/>
                    ��
                    <INPUT type=radio  ${!system.forceEntryNo?"checked":""} value="false" name="system.forceEntryNo"/>
                    ��
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    �������
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ���и�����&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.jzfm?"checked":""} value="true" name="system.jzfm"/>
                    ��
                    <INPUT type="radio"  ${!system.jzfm?"checked":""} value="false" name="system.jzfm"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ���Ԥ��ֵ��ʣ�����&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.mdyjs}" id="mdyjs" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="4"
                           name="system.mdyjs"/>&nbsp;��
                </TD>
                <td colspan="4"></td>
            </tr>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    ����֤����ע�����ڼ��
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ������
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.xbfz?"checked":""} value="true" name="system.xbfz"/>
                    ��
                    <INPUT type=radio  ${!system.xbfz?"checked":""} value="false" name="system.xbfz"/>
                    ��
                </TD>

                <TD class="td1" align="right">
                    ��죺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.njfz?"checked":""} value="true" name="system.njfz"/>
                    ��
                    <INPUT type=radio  ${!system.njfz?"checked":""} value="false" name="system.njfz"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ��֤��
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzfz?"checked":""} value="true" name="system.hzfz"/>
                    ��
                    <INPUT type=radio  ${!system.hzfz?"checked":""} value="false" name="system.hzfz"/>
                    ��
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    ɨ����������
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    <span style="font-weight:bold;">����</span>��
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.isSmTask?"checked":""} value="true"
                           name="system.isSmTask" onclick="$('.smtask').show()"/>
                    ��
                    <INPUT type=radio  ${!system.isSmTask?"checked":""} value="false"
                           name="system.isSmTask" onclick="$('.smtask').hide()"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    �������ޣ� ���&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.smqx}" id="smqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.smqx"/>&nbsp;��
                </TD>
                <TD class="td1" align="right">
                    ǰ��ɨ�裺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qzsm?"checked":""} value="true" name="system.qzsm"/>
                    ��
                    <INPUT type=radio  ${!system.qzsm?"checked":""} value="false" name="system.qzsm"/>
                    ��
                </TD>
            </tr>
         <%--   <tr style="${system.isSmTask?'':'display:none ;'}width: 100%; " class="smtask">
                <TD class="td1" align="right">
                    ������
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.addJgdmSmTask?"checked":""} value="true"
                           name="system.addJgdmSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.addJgdmSmTask?"checked":""} value="false"
                           name="system.addJgdmSmTask"/>
                    ��
                </TD>

                <TD class="td1" align="right">
                    �������룺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qtfmSmTask?"checked":""} value="true" name="system.qtfmSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.qtfmSmTask?"checked":""} value="false"
                           name="system.qtfmSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    Ԥ���룺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.yfmSmTask?"checked":""} value="true"
                           name="system.yfmSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.yfmSmTask?"checked":""} value="false"
                           name="system.yfmSmTask"/>
                    ��
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    �����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.bgSmTask?"checked":""} value="true"
                           name="system.bgSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.bgSmTask?"checked":""} value="false"
                           name="system.bgSmTask"/>
                    ��
                </TD>

                <TD class="td1" align="right">
                    ��֤��
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzSmTask?"checked":""} value="true" name="system.hzSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.hzSmTask?"checked":""} value="false"
                           name="system.hzSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ��죺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.njSmTask?"checked":""} value="true"
                           name="system.njSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.njSmTask?"checked":""} value="false"
                           name="system.njSmTask"/>
                    ��
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    ʡ��Ǩ�룺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sjjrSmTask?"checked":""} value="true"
                           name="system.sjjrSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.sjjrSmTask?"checked":""} value="false"
                           name="system.sjjrSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ʡ��Ǩ����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sjqcSmTask?"checked":""} value="true"
                           name="system.sjqcSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.sjqcSmTask?"checked":""} value="false"
                           name="system.sjqcSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ʡ��Ǩ�룺
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.snqrSmTask?"checked":""} value="true"
                           name="system.snqrSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.snqrSmTask?"checked":""} value="false"
                           name="system.snqrSmTask"/>
                    ��
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    ʡ��Ǩ����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.snqcSmTask?"checked":""} value="true"
                           name="system.snqcSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.snqcSmTask?"checked":""} value="false"
                           name="system.snqcSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ע����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzSmTask?"checked":""} value="true"
                           name="system.fzSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.fzSmTask?"checked":""} value="false"
                           name="system.fzSmTask"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ע���ָ���
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzhfSmTask?"checked":""} value="true"
                           name="system.fzhfSmTask"/>
                    ��
                    <INPUT type=radio  ${!system.fzhfSmTask?"checked":""} value="false"
                           name="system.fzhfSmTask"/>
                    ��
                </TD>
            </tr>--%>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    ҵ�������������
                </th>
            </tr>
            <tr>
                <%--<TD class="td1" align="right">
                    �Ƿ���ҵ�����̣�
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.isYwlc?"checked":""} value="true"
                           name="system.isYwlc"/>
                    ��
                    <INPUT type="radio"  ${!system.isYwlc?"checked":""} value="false"
                           name="system.isYwlc"/>
                    ��
                </TD>--%>
                <TD class="td1" align="right">
                    ��֤�ӳ�ʱ�䣺
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" id="printAfterDay" value="${system.printAfterDay}" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.printAfterDay"/>&nbsp;��
                </TD>
                <TD class="td1" align="right">
                    �����ӳ�ʱ�䣺
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.fmqx}" id="fmqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.fmqx"/>&nbsp;��
                </TD>
                <TD class="td1" align="right">
                    ���������ޣ�����ǰ&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.njqx}" id="njqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.njqx"/>&nbsp;��
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ��֤�������ޣ�����ǰ&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.hzqx}" id="hzqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="4"
                           name="system.hzqx"/>&nbsp;��
                </TD>
                <TD class="td1" align="right">
                    ���⵵���������ޣ� ���&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.daqx}" id="daqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.daqx"/>&nbsp;��
                </TD>
                <TD class="td1" align="right">
                    �������ݴ������ޣ� ���&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.sjqx}" id="sjqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.sjqx"/>&nbsp;��
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
<tr>
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
            <tr class="table1_tr1">
                <th colspan="6">
                    �����ҵ������
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    �����ɾ����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sqbscsh?"checked":""} value="true"
                           name="system.sqbscsh"/>
                    ��
                    <INPUT type=radio  ${!system.sqbscsh?"checked":""} value="false"
                           name="system.sqbscsh"/>
                    ��
                </TD>

                <TD class="td1" align="right">
                    ��������ע����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzsh?"checked":""} value="true" name="system.fzsh"/>
                    ��
                    <INPUT type=radio  ${!system.fzsh?"checked":""} value="false"
                           name="system.fzsh"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ��������ע���ָ���
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzhfsh?"checked":""} value="true"
                           name="system.fzhfsh"/>
                    ��
                    <INPUT type=radio  ${!system.fzhfsh?"checked":""} value="false"
                           name="system.fzhfsh"/>
                    ��
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    ��������ɾ����
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.deletesh?"checked":""} value="true"
                           name="system.deletesh"/>
                    ��
                    <INPUT type=radio  ${!system.deletesh?"checked":""} value="false"
                           name="system.deletesh"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    ��������Ǩַ�ָ���
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qzsh?"checked":""} value="true" name="system.qzsh"/>
                    ��
                    <INPUT type=radio  ${!system.qzsh?"checked":""} value="false"
                           name="system.qzsh"/>
                    ��
                </TD>

                <TD class="td1" align="right">
                    ������������
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.bgsh?"checked":""} value="true" name="system.bgsh"/>
                    ��
                    <INPUT type=radio  ${!system.bgsh?"checked":""} value="false"
                           name="system.bgsh"/>
                    ��
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    �������뻻֤��
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzsh?"checked":""} value="true" name="system.hzsh"/>
                    ��
                    <INPUT type=radio  ${!system.hzsh?"checked":""} value="false"
                           name="system.hzsh"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    �������Ÿ���ɾ����ˣ�
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qtbmfmsh?"checked":""} value="true" name="system.qtbmfmsh"/>
                    ��
                    <INPUT type=radio  ${!system.qtbmfmsh?"checked":""} value="false"
             class="newBtn1"  name="system.qtbmfmsh"/>
                    ��
                </TD>
                <TD class="td1" align="right">
                    Ԥ����ɾ����ˣ�
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.yfmscsh?"checked":""} value="true" name="system.yfmscsh"/>
                    ��
                    <INPUT type=radio  ${!system.yfmscsh?"checked":""} value="false"
                           name="system.yfmscsh"/>
                    ��
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
</table>
<div class="listbtn">
    <input name="button" type="button" onclick="fCheckValue()" class="btn1" id="button" value="�� ��"/>
</div>
</div>

</div>
</div>
</div>
</div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
<script type="text/javascript">
    run('${message}');
</script>
</html>
