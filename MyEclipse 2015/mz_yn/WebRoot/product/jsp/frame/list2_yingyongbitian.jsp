<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<c:set value="<%=InitSysParams.scCenterMap%>" var="bzjgMap"/>
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript">
	$(function(){   $("#countNum").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
</head>
<body>
<div class="page_top_fixed">
    <div align="right" style="width: 30% ; float: right;">
        &nbsp;
        <input name="button" type="button" onclick="return judegeDate();" class="newBtn1" id="submit"
               value="保 存"/>
        &nbsp;
    </div>
    系统 &gt;&gt; 系统设置 &gt;&gt; 系统设置
</div>
<form name="searchForm" id="searchForm" method="post" action="/bsweb/auditSetting_SetYYBTX">
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
                                                省中心设置
                                            </th>
                                        </tr>
                                        <tr class="table1_tr1" style="height:30px;border: 1px">
                                            <td class="table1_td1">省中心：</td>
                                            <td style="text-align:left;" class="table1_td1" colspan="5">
                                                <select id="center" name="center">
                                                    <c:forEach var="xzqh" items="${bzjgMap}">
                                                    <option value="${xzqh.key}" ${xzqh.key eq center ?'selected':'' }> ${xzqh.key}:${xzqh.value}</option>
                                                    </c:forEach>
                                            </td>
                                        </tr>
                                    </TABLE>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                                        <tr class="table1_tr1">
                                            <th colspan="6">
                                                登录时间设置
                                            </th>
                                        </tr>
                                        <tr class="table1_tr1" style="height:30px;border: 1px">
                                            <td class="table1_td1">起始时间<font color="#FF0000">(*)</font>：</td>
                                            <td style="text-align:left;" class="table1_td1" colspan="2">
                                                <input type="text" name="startDate" id="startDate"
                                                       title="登录时间，格式为：H:mm"
                                                       onfocus="WdatePicker({el:$dp.$('njqsrq1'),qsEnabled:true,quickSel:['0:00:00','8:30:00','12:30:00','18:30:00','23:30:00'],isShowToday:false, dateFmt:'H:mm',minDate:'0:00:00',maxDate:'23:59:59' })"
                                                       value="${startDate}"
                                                       size="4" maxlength="5">
                                                <span id="startDateProp"></span>
                                            </td>
                                            <td class="table1_td1">结束时间<font color="#FF0000">(*)</font>：</td>
                                            <td class="table1_td1" style="text-align:left;" colspan="2">
                                                <input type="text" name="endDate" id="endDate"
                                                       title="登录时间，格式为：H:mm"
                                                       onfocus="WdatePicker({el:$dp.$('njqsrq1'),qsEnabled:true,quickSel:['0:00:00','8:30:00','12:30:00','18:30:00','23:30:00'],isShowToday:false, dateFmt:'H:mm',minDate:'0:00:00',maxDate:'23:59:59' })"
                                                       value="${endDate}"
                                                       size="4" maxlength="5">
                                                <span id="endDateProp"></span>
                                            </td>
                                        </tr>
                                    </TABLE>
                                </td>
                            </tr>
                           <%-- <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                                        <tr class="table1_tr1">
                                            <th colspan="6">
                                                机构信息必录项
                                            </th>
                                            <th colspan="3">
                                                <label for="jglx">机构类型</label>
                                                <SELECT name="jglx" id="jglx" style=" width:200px;">
                                                    <c:forEach var="lx" items="${jglxMap}">
                                                        <OPTION value="${fn:trim(lx.key)}"  ${(fn:trim(lx.key) eq fn:trim(jglx))?'selected':''}>${fn:trim(lx.key)}:${lx.value}</OPTION>
                                                    </c:forEach>
                                                </SELECT>
                                            </th>
                                        </tr>
                                        <tr>
                                            <c:forEach var="field" varStatus="status" items="${fields}">
                                                <td class="avgtd" align="right">
                                                    <input type="hidden" name="fields[${status.index}].fieldId"
                                                           value="${field.fieldId}"/>
                                                        ${field.fieldName}：
                                                    <input type="checkbox"  ${field.required?'checked':''}
                                                           name="fields[${status.index}].required"
                                                           value="true"/>
                                                </td>
                                                ${(status.count % 6 eq 0) ?'</tr><tr>':''}
                                            </c:forEach>
                                        </tr>
                                    </table>
                                </td>
                            </tr>--%>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2"
                                       style="border-bottom:none;">
                                    <tr class="table1_tr1">
                                        <th colspan="4">
                                            主要业务操作设置
                                        </th>
                                    </tr>
                                </table>
                                <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2"
                                       style="border-top:none;">
                                    <tr>
                                        <TD align="right" width=" 17%">
                                            开启代码机构日单一业务：
                                        </TD>
                                        <TD style="width: 10%">
                                            <INPUT type=radio  ${system.oneKind?"checked":""} value="true"
                                                   name="system.oneKind"/>
                                            是
                                            <INPUT type=radio  ${!system.oneKind?"checked":""} value="false"
                                                   name="system.oneKind"/>
                                            否
                                        </TD>
                                        <TD align="right" style="width: 23%">
                                            代码机构每种主要日可操作次数：
                                        </TD>
                                        <TD style="width: 50%">
                                            <INPUT type=text class="num" id="countNum" value="${system.busTimes}" maxlength="2"
                                                   onkeyup="onlyDecimal(this)" onblur="onlyDecimal(this)"
                                                   name="system.busTimes"/>
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
                                                主要业务类型设置
                                            </th>
                                        </tr>
                                        <tr>
                                            <%--@elvariable id="types" type="java.util.List"--%>
                                            <c:forEach items="${types}" var="type" varStatus="status">
                                            <input type="hidden" name="types[${status.index}].czlxdm"
                                                   value="${type.czlxdm}"/>
                                            <TD class="td1" align="right">
                                                    ${fn:trim(type.czlxmc)}：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox   ${type.main?"checked":""} value="true"
                                                       name="types[${status.index}].main"/>
                                            </TD>
                                            <c:if test="${ (status.index-2)%3==0}">
                                        </tr>
                                        <tr>
                                            </c:if>
                                            </c:forEach>


                                        </tr>
                                    </TABLE>
                                </td>
                            </tr>
                        </table>
                        <div class="listbtn">
                            <input name="button" onclick="return judegeDate();" type="button" class="newBtn1" id="button"
                                   value="保 存"/>
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
    function judegeDate() {
        var obj = $("#startDate");
        var obj2 = $("#endDate");
        var objs = obj.val().split(":");
        var obj2s = obj2.val().split(":");
        if (Number(objs[0]) > Number(obj2s[0]) || (Number(objs[0]) == Number(obj2s[0]) && Number(objs[1]) >= Number(obj2s[1]))) {
            $("#endDateProp").css("color", "red").html("结束时间必须小于开始时间！");
            obj2.focus();
            return false;
        } else {
            $("#endDateProp").css("color", "green").html("结束时间输入正确！");
            document.forms[0].submit();
            return true;
        }
    }
    $(function () {
        $("#startDate").blur(function () {
            var obj = $(this);
            var obj2 = $("#endDate");
            var objs = obj.val().split(":");
            var obj2s = obj2.val().split(":");
            if (Number(objs[0]) > Number(obj2s[0]) || (Number(objs[0]) == Number(obj2s[0]) && Number(objs[1]) >= Number(obj2s[1]))) {
                obj2.focus();
                return false;
            } else {
                return true;
            }


        });
        $("#endDate").blur(function () {
            var obj = $("#startDate");
            var obj2 = $(this);
            var objs = obj.val().split(":");
            var obj2s = obj2.val().split(":");
            if (Number(objs[0]) > Number(obj2s[0]) || (Number(objs[0]) == Number(obj2s[0]) && Number(objs[1]) >= Number(obj2s[1]))) {
                $("#endDateProp").css("color", "red").html("结束时间必须小于开始时间！");
                obj2.focus();
                return false;
            } else {
                $("#endDateProp").css("color", "green").html("结束时间输入正确！");
                return true;
            }
        });
        $("#searchForm").submit(function () {
            var obj = $("#startDate");
            var obj2 = $("#endDate");
            var objs = obj.val().split(":");
            var obj2s = obj2.val().split(":");
            if (Number(objs[0]) > Number(obj2s[0]) || (Number(objs[0]) == Number(obj2s[0]) && Number(objs[1]) >= Number(obj2s[1]))) {
                $("#endDateProp").css("color", "red").html("结束时间必须小于开始时间！");
                obj2.focus();
                return false;
            } else {
                $("#endDateProp").css("color", "green").html("结束时间输入正确！");
                return true;
            }
        });
    });
    <c:if test="${(message ne null) and (message ne '')}">
    <c:if test="${(message  eq 'ok')}">
    ymPrompt.succeedInfo('设置成功!', 330, 220, '提示信息');
    </c:if>
    <c:if test="${(message  eq 'no')}">
    ymPrompt.errorInfo('设置失败!', 330, 220, '提示信息');
    </c:if>
    </c:if>
</script>

</html>
