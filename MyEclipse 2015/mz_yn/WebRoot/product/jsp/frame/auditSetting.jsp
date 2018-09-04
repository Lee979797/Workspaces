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
                ymPrompt.alert({ message: "请输入合适的打证延迟日期！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        printAfterDay.focus();
                    }
                });
                return false;

            }
            if (!reg.test(njqx.val())) {
                ymPrompt.alert({ message: "请输入合适的年检办理期限！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        njqx.focus();
                    }
                });
                return false;

            }
            if (!reg.test(hzqx.val())) {
                ymPrompt.alert({ message: "请输入合适的换证办理期限！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        hzqx.focus();
                    }
                });
                return false;

            }
            if (!reg.test(gtcfsz.val())) {
                ymPrompt.alert({ message: "数据类型不正确，请输入整数！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        gtcfsz.focus();
                    }
                });
                return false;
            }
            if (!reg.test(cfjesx.val())) {
                ymPrompt.alert({ message: "数据类型不正确，请输入整数！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        cfjesx.focus();
                    }
                });
                return false;
            }
            if (Number(gtcfsz.val()) > Number(cfjesx.val())) {
                ymPrompt.alert({ message: "罚款金额下限不能大于上限！",
                    width: 330, height: 220, title: "提示信息", handler: function (tp) {
                        gtcfsz.focus();
                    }
                });
                return false;
            }
            document.busForm.submit();
        }
        function run(message) {
            if (message != null && "" != message) {
                ymPrompt.succeedInfo(message, 380, 220, '提示信息', function () {
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
    <div style="float:left;"><strong>系统 &gt;&gt; 系统设置 &gt;&gt; 参数设置 </strong></div>
    <div align="class="newBtn1"="width: 30% ; float: right;">
        &nbsp;
        <input name="button" type="button" onclick="fCheckValue()" class="btn1" id="submit" value="保 存"/>
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
                    处罚设置
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    业务办理前是否检查处罚：
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.isPunish?"checked":""} value="true"
                           name="system.isPunish"/>
                    是
                    <INPUT type="radio"  ${!system.isPunish?"checked":""} value="false"
                           name="system.isPunish"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    罚款金额限制：
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.gtcfsz}" style="width: 40px" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           maxlength="4" id="gtcfsz"
                           name="system.gtcfsz"/><label for="gtcfsz">&nbsp;至&nbsp;</label>
                    <INPUT type="text" value="${system.cfjesx}" style="width: 40px" maxlength="4" id="cfjesx"
                           name="system.cfjesx" onkeyup="verifyValue(this)" onblur="verifyValue(this);"/><label
                        for="cfjesx">&nbsp;元</label>
                </TD>
                <TD class="td1" align="right">
                    新办超期时间：到期前&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.xbcqsz==null?30:system.xbcqsz}" id="xbcqsz"
                           onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.xbcqsz"/>&nbsp;日
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
                    功能设置
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    显示公告：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.xsgg?"checked":""} value="true" name="system.xsgg"/>
                    是
                    <INPUT type=radio  ${!system.xsgg?"checked":""} value="false" name="system.xsgg"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    工商数据提取：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.isGs?"checked":""} value="true" name="system.isGs"/>
                    是
                    <INPUT type=radio  ${!system.isGs?"checked":""} value="false" name="system.isGs"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    打印证书强制录入编号：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.forceEntryNo?"checked":""} value="true" name="system.forceEntryNo"/>
                    是
                    <INPUT type=radio  ${!system.forceEntryNo?"checked":""} value="false" name="system.forceEntryNo"/>
                    否
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
                    码段设置
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    集中赋代码&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.jzfm?"checked":""} value="true" name="system.jzfm"/>
                    是
                    <INPUT type="radio"  ${!system.jzfm?"checked":""} value="false" name="system.jzfm"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    码段预警值：剩余代码&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.mdyjs}" id="mdyjs" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="4"
                           name="system.mdyjs"/>&nbsp;个
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
                    法人证件号注销超期检查
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    新增：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.xbfz?"checked":""} value="true" name="system.xbfz"/>
                    是
                    <INPUT type=radio  ${!system.xbfz?"checked":""} value="false" name="system.xbfz"/>
                    否
                </TD>

                <TD class="td1" align="right">
                    年检：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.njfz?"checked":""} value="true" name="system.njfz"/>
                    是
                    <INPUT type=radio  ${!system.njfz?"checked":""} value="false" name="system.njfz"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    换证：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzfz?"checked":""} value="true" name="system.hzfz"/>
                    是
                    <INPUT type=radio  ${!system.hzfz?"checked":""} value="false" name="system.hzfz"/>
                    否
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
                    扫描任务设置
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    <span style="font-weight:bold;">开启</span>：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.isSmTask?"checked":""} value="true"
                           name="system.isSmTask" onclick="$('.smtask').show()"/>
                    是
                    <INPUT type=radio  ${!system.isSmTask?"checked":""} value="false"
                           name="system.isSmTask" onclick="$('.smtask').hide()"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    操作期限： 最多&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.smqx}" id="smqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.smqx"/>&nbsp;天
                </TD>
                <TD class="td1" align="right">
                    前置扫描：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qzsm?"checked":""} value="true" name="system.qzsm"/>
                    是
                    <INPUT type=radio  ${!system.qzsm?"checked":""} value="false" name="system.qzsm"/>
                    否
                </TD>
            </tr>
         <%--   <tr style="${system.isSmTask?'':'display:none ;'}width: 100%; " class="smtask">
                <TD class="td1" align="right">
                    新增：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.addJgdmSmTask?"checked":""} value="true"
                           name="system.addJgdmSmTask"/>
                    是
                    <INPUT type=radio  ${!system.addJgdmSmTask?"checked":""} value="false"
                           name="system.addJgdmSmTask"/>
                    否
                </TD>

                <TD class="td1" align="right">
                    其他赋码：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qtfmSmTask?"checked":""} value="true" name="system.qtfmSmTask"/>
                    是
                    <INPUT type=radio  ${!system.qtfmSmTask?"checked":""} value="false"
                           name="system.qtfmSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    预赋码：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.yfmSmTask?"checked":""} value="true"
                           name="system.yfmSmTask"/>
                    是
                    <INPUT type=radio  ${!system.yfmSmTask?"checked":""} value="false"
                           name="system.yfmSmTask"/>
                    否
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    变更：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.bgSmTask?"checked":""} value="true"
                           name="system.bgSmTask"/>
                    是
                    <INPUT type=radio  ${!system.bgSmTask?"checked":""} value="false"
                           name="system.bgSmTask"/>
                    否
                </TD>

                <TD class="td1" align="right">
                    换证：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzSmTask?"checked":""} value="true" name="system.hzSmTask"/>
                    是
                    <INPUT type=radio  ${!system.hzSmTask?"checked":""} value="false"
                           name="system.hzSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    年检：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.njSmTask?"checked":""} value="true"
                           name="system.njSmTask"/>
                    是
                    <INPUT type=radio  ${!system.njSmTask?"checked":""} value="false"
                           name="system.njSmTask"/>
                    否
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    省间迁入：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sjjrSmTask?"checked":""} value="true"
                           name="system.sjjrSmTask"/>
                    是
                    <INPUT type=radio  ${!system.sjjrSmTask?"checked":""} value="false"
                           name="system.sjjrSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    省间迁出：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sjqcSmTask?"checked":""} value="true"
                           name="system.sjqcSmTask"/>
                    是
                    <INPUT type=radio  ${!system.sjqcSmTask?"checked":""} value="false"
                           name="system.sjqcSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    省内迁入：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.snqrSmTask?"checked":""} value="true"
                           name="system.snqrSmTask"/>
                    是
                    <INPUT type=radio  ${!system.snqrSmTask?"checked":""} value="false"
                           name="system.snqrSmTask"/>
                    否
                </TD>
            </tr>
            <tr style="${system.isSmTask?'':'display:none ;'} ;width: 100%;" class="smtask">
                <TD class="td1" align="right">
                    省内迁出：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.snqcSmTask?"checked":""} value="true"
                           name="system.snqcSmTask"/>
                    是
                    <INPUT type=radio  ${!system.snqcSmTask?"checked":""} value="false"
                           name="system.snqcSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    注销：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzSmTask?"checked":""} value="true"
                           name="system.fzSmTask"/>
                    是
                    <INPUT type=radio  ${!system.fzSmTask?"checked":""} value="false"
                           name="system.fzSmTask"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    注销恢复：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzhfSmTask?"checked":""} value="true"
                           name="system.fzhfSmTask"/>
                    是
                    <INPUT type=radio  ${!system.fzhfSmTask?"checked":""} value="false"
                           name="system.fzhfSmTask"/>
                    否
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
                    业务办理限制设置
                </th>
            </tr>
            <tr>
                <%--<TD class="td1" align="right">
                    是否开启业务流程：
                </TD>
                <TD class="td1">
                    <INPUT type="radio"  ${system.isYwlc?"checked":""} value="true"
                           name="system.isYwlc"/>
                    是
                    <INPUT type="radio"  ${!system.isYwlc?"checked":""} value="false"
                           name="system.isYwlc"/>
                    否
                </TD>--%>
                <TD class="td1" align="right">
                    打证延迟时间：
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" id="printAfterDay" value="${system.printAfterDay}" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.printAfterDay"/>&nbsp;日
                </TD>
                <TD class="td1" align="right">
                    赋码延迟时间：
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.fmqx}" id="fmqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.fmqx"/>&nbsp;日
                </TD>
                <TD class="td1" align="right">
                    年检办理期限：到期前&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.njqx}" id="njqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="3"
                           name="system.njqx"/>&nbsp;日
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    换证办理期限：到期前&nbsp;
                </TD>
                <TD class="td1" align="left">
                    <INPUT type="text" value="${system.hzqx}" id="hzqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="4"
                           name="system.hzqx"/>&nbsp;日
                </TD>
                <TD class="td1" align="right">
                    问题档案处理期限： 最多&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.daqx}" id="daqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.daqx"/>&nbsp;天
                </TD>
                <TD class="td1" align="right">
                    问题数据处理期限： 最多&nbsp;
                </TD>
                <TD class="td1">
                    <INPUT type="text" value="${system.sjqx}" id="sjqx" onkeyup="verifyValue(this)"
                           onblur="verifyValue(this)"
                           style="width: 40px"
                           maxlength="2"
                           name="system.sjqx"/>&nbsp;天
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
                    需审核业务设置
                </th>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    申请表删除：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.sqbscsh?"checked":""} value="true"
                           name="system.sqbscsh"/>
                    是
                    <INPUT type=radio  ${!system.sqbscsh?"checked":""} value="false"
                           name="system.sqbscsh"/>
                    否
                </TD>

                <TD class="td1" align="right">
                    机构代码注销：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzsh?"checked":""} value="true" name="system.fzsh"/>
                    是
                    <INPUT type=radio  ${!system.fzsh?"checked":""} value="false"
                           name="system.fzsh"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    机构代码注销恢复：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.fzhfsh?"checked":""} value="true"
                           name="system.fzhfsh"/>
                    是
                    <INPUT type=radio  ${!system.fzhfsh?"checked":""} value="false"
                           name="system.fzhfsh"/>
                    否
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    机构代码删除：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.deletesh?"checked":""} value="true"
                           name="system.deletesh"/>
                    是
                    <INPUT type=radio  ${!system.deletesh?"checked":""} value="false"
                           name="system.deletesh"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    机构代码迁址恢复：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qzsh?"checked":""} value="true" name="system.qzsh"/>
                    是
                    <INPUT type=radio  ${!system.qzsh?"checked":""} value="false"
                           name="system.qzsh"/>
                    否
                </TD>

                <TD class="td1" align="right">
                    机构代码变更：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.bgsh?"checked":""} value="true" name="system.bgsh"/>
                    是
                    <INPUT type=radio  ${!system.bgsh?"checked":""} value="false"
                           name="system.bgsh"/>
                    否
                </TD>
            </tr>
            <tr>
                <TD class="td1" align="right">
                    机构代码换证：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.hzsh?"checked":""} value="true" name="system.hzsh"/>
                    是
                    <INPUT type=radio  ${!system.hzsh?"checked":""} value="false"
                           name="system.hzsh"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    其他部门赋码删除审核：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.qtbmfmsh?"checked":""} value="true" name="system.qtbmfmsh"/>
                    是
                    <INPUT type=radio  ${!system.qtbmfmsh?"checked":""} value="false"
             class="newBtn1"  name="system.qtbmfmsh"/>
                    否
                </TD>
                <TD class="td1" align="right">
                    预赋码删除审核：
                </TD>
                <TD class="td1">
                    <INPUT type=radio  ${system.yfmscsh?"checked":""} value="true" name="system.yfmscsh"/>
                    是
                    <INPUT type=radio  ${!system.yfmscsh?"checked":""} value="false"
                           name="system.yfmscsh"/>
                    否
                </TD>
            </tr>
        </TABLE>
    </td>
</tr>
</table>
<div class="listbtn">
    <input name="button" type="button" onclick="fCheckValue()" class="btn1" id="button" value="保 存"/>
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
