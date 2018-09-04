<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%--@elvariable id="ttables" type="java.util.List<com.ninemax.jpa.code.model.Ttable>"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
<link href="/css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
<script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="/js/jgdmSearch.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
<script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
<script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<script type='text/javascript' src='/js/tools.js'></script>
<script type="text/javascript">
    $(function () {
        $("#txtvalue").focus();
    })
    document.onkeydown = function () {
        if (event.keyCode == '13') {
            event.keyCode = 9;
        }
    }
</script>

<title>信息查询</title>
<script type="text/javascript">
var fields = ['nnjjlx', 'nnjjhy', 'njjlx', 'njjhy', 'zycp3', 'zycp2', 'zycp1', 'zgdm', 'hbzl', 'wftzgb', 'xzqh', 'pzjgdm', 'jjlx', 'jjhy', 'jglx', 'njglx'];
function fCheckValue() {
    var sql = document.getElementById('where').innerHTML;
    if (undefined == sql || "" == sql) {
        ymPrompt.alert({message: "请添加查询条件后再执行检索！", width: 330, height: 220, title: '提示信息'});
        return;
    }
    document.thisForm.sqlwhere.value = sql;
    var regSQL = /^.*and(\s*)$/;
    var regSQL2 = /^.*or(\s*)$/;
    if (regSQL.exec(sql)) {
        document.thisForm.sqlwhere.value = sql.substring(0, sql.lastIndexOf("and"));
    }
    if (regSQL2.exec(sql)) {
        document.thisForm.sqlwhere.value = sql.substring(0, sql.lastIndexOf("or"));
    }
    document.thisForm.sqlwhere.value = sql.replace(/=\s*(\w)/g, " = '$1'");
    document.thisForm.order.value = ' order by ' + document.thisForm.orderby.value + " " + document.thisForm.ordercode.value;
    document.thisForm.submit();
}
function callBack(tp) {
    if (tp != 'close' && tp != '') {
        var values = tp.split(';');
        var dms = values[0].split(':');
        var mcs = values[1].split(":");
        $("#propbar").show();
        document.getElementById("txtvalue").value = dms[0];
        document.getElementById("valuemc").innerHTML = mcs[0];
    }
}
function setcode() {
//    document.thisForm.relations.options.length = 0;
    var strCondi = ":!=:like:&gt;:&gt;=:=:&lt;=:";
    var conditions = strCondi.split(":");
    var index = 0;
    var columns = document.thisForm.column.value.split(":");
    var isSelect = false;
    var isDate = false;
    var isNumber = false;
    var obj;
    obj = $("#txtvalue");
    obj.val("");
    $("#propbar").hide();
    $("#valuemc").html("");
    for (var i = 0; i < fields.length; i++) {
        if (columns[0] == fields[i]) {
            if ("zgdm" == columns[0]) {
                columns[0] = 'zgjg';
            }
            if ("wftzgb" == columns[0]) {
                columns[0] = 'wfgb';
            }
            if ("pzjgdm" == columns[0]) {
                columns[0] = 'pzjg';
            }
            isSelect = true;
            break;
        }
    }
    /*  switch (columns[1]) {
     case '1':
     {
     document.thisForm.relations.options.add(new Option("等于(=)", "="));
     document.thisForm.relations.options.add(new Option("不等于(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("为空", "is null"));
     document.thisForm.relations.options.add(new Option("不为空", "is not null"));
     if (!isSelect) {
     document.thisForm.relations.options.add(new Option("包含(like)", "like"));
     }
     break;
     }
     case '2':
     {
     document.thisForm.relations.options.add(new Option("等于(=)", "="));
     document.thisForm.relations.options.add(new Option("大于(>)", ">"));
     document.thisForm.relations.options.add(new Option("大于等于(>=)", ">="));
     document.thisForm.relations.options.add(new Option("小于(<)", "<"));
     document.thisForm.relations.options.add(new Option("小于等于(<=)", "<="));
     document.thisForm.relations.options.add(new Option("不等于(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("为空", "is null"));
     document.thisForm.relations.options.add(new Option("不为空", "is not null"));
     isNumber = true;

     break;
     }
     case '3' :
     {
     document.thisForm.relations.options.add(new Option("等于(=)", "="));
     document.thisForm.relations.options.add(new Option("大于(>)", ">"));
     document.thisForm.relations.options.add(new Option("大于等于(>=)", ">="));
     document.thisForm.relations.options.add(new Option("小于(<)", "<"));
     document.thisForm.relations.options.add(new Option("小于等于(<=)", "<="));
     document.thisForm.relations.options.add(new Option("不等于(<>)", "<>"));
     document.thisForm.relations.options.add(new Option("为空", "is null"));
     document.thisForm.relations.options.add(new Option("不为空", "is not null"));
     isDate = true;
     break;
     }

     }*/
    if (isDate) {
        $("#txtvalue").unbind().bind('click', function () {
            WdatePicker({el: $dp.$('zcrq')});
        });
        $("#dateselect").show();
        return;
    } else {
        $("#txtvalue").attr("readonly", false);
        $("#dateselect").hide();
    }
    if (isNumber) {
        $("#txtvalue").unbind().bind("keyup", function () {
            if (/^\d*\.?\d*$/.test(obj.val())) {
                return true;
            }
            obj.val(obj.val().replace(/\D/g, ""));
            return false;
        }).bind("blur", function () {
            if (/^\d*\.?\d*$/.test(obj.val())) {
                return true;
            }
            obj.val(obj.val().replace(/\D/g, ""));
            obj.focus();
            return false;
        });
        $("#dateselect").hide();
        return;
    } else {
        $("#txtvalue").attr("readonly", false);
        $("#dateselect").hide();
    }

    if (isSelect) {
        var source = "/action/autoComplete?method=" + columns[0] + "&rand=" + new Date().getTime();
        var message = "/bsweb/select_search.action?source=t_" + columns[0];
        $("#txtvalue").attr("readonly", false).unbind().autocomplete({
            autofill: true,
            source: source,
            select: function (event, ui) {
                this.value = ui.item.dm;
                $("#propbar").show();
                $("#valuemc").html(ui.item.mc);
                return false;
            },
            change: function (event, ui) {
                this.value = ui.item.dm;
                $("#propbar").show();
                $("#valuemc").html(ui.item.mc);
                return false;
            }
        }).data("autocomplete")._renderItem = function (ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a style='width:188px;height:20px;'>" + "<span style='float:left;'>" + item.dm + "</span>" + "<span style='float:right;'>" + (item.mc.length > 8 ? item.mc.substring(0, 7) + '...' : item.mc) + "</span>" + "</a>").appendTo(ul);
        };
        /*  $("#txtselect").unbind().bind('click', function () {
         ymPrompt.win({message: message, handler: callBack, width: 630, height: 460, dragOut: false, title: '信息查询', iframe: true});
         });
         $("#select").show();*/
        return;
    } else {
        /*  $("#select").hide();*/

    }
    if (!(isDate || isSelect)) {
        $("#txtvalue").unbind();
    }


}

function addToCondition() {
    var column = document.thisForm.column;
    var txtvalue = document.thisForm.txtvalue;
    var sqlwhere = document.thisForm.sqlwhere;
    var relation = document.thisForm.relations;
    sqlwhere.value = document.getElementById('where').innerHTML;
    if (column.value == undefined) {
        ymPrompt.alert({message: "请选择条件字段", handle: function () {
            column.focus();
        }});
        return;
    }
    if (!/\s*is\s*((not)?)\s+null\s*/i.test(relation.value) && ( txtvalue.value == undefined || txtvalue.value == '')) {
        ymPrompt.alert({message: "请输入合适的查询值", handle: function () {
            txtvalue.focus();
        }});
        return;
    }
    if (sqlwhere.value == undefined) {
        sqlwhere.value = '';
    }
    if ((sqlwhere.value != '') && (!/[\s\S]*(and|or)[\s]*$/i.test(sqlwhere.value))) {
        sqlwhere.value += " and ";
    }
    sqlwhere.value += column.value.split(":")[0] + " " + relation.value + " ";
    if (!/\s*is\s*((not)?)\s+null\s*/i.test(relation.value)) {
        if ("like" == relation.value) {
            sqlwhere.value += ( "'%" + txtvalue.value + "%'");
        } else if ("likl" == relation.value) {
            sqlwhere.value = sqlwhere.value.replace("likl", "like");
            sqlwhere.value += ("'" + txtvalue.value + "%'");
        } else {
            sqlwhere.value += (" '" + txtvalue.value + "' ");
        }
        sqlwhere.value += document.thisForm.logic.value + " ";
    }
    document.getElementById('where').innerHTML = sqlwhere.value;
}

function clearSQL() {
    document.thisForm.sqlwhere.value = '';
    document.getElementById('where').innerHTML = "";
}

</script>
</head>
<body style="background:#fff;">
<div class="page_top" style="background:#F8F8F8">${title}</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list">
                    <form method="POST" name='thisForm' action="/bsweb/statistics_export_search.action"
                          onkeydown="return chesKey();">
                        <input type="hidden" name="source" value="${source}" id="source"/>
                        <input type="hidden" name="bzjgdm" value="${fn:trim(sysUser.bzjgdm)}" id="bzjgdm"/>
                        <input type="hidden" name="sqlwhere">
                        <input type="hidden" name="order"/>

                        <h1 align="center" style="text-align: center; height:40px; line-height: 40px; font-size: 16px;">
                            组合查询(<span
                                style="color: #FF0000;">由左向右、由上至下生成条件</span>)
                        </h1>
                        <table align="center" border="1" bordercolor="#C4DBE5" cellspacing="0" cellpadding="10"
                               width="100%" style="border-collapse: collapse; background: #EAF6FB;">
                            <tr>
                                <td width="15%" align="right">来源：</td>
                                <td width="85%" align="left" valign="top" colspan="3">
                                    <select name="database" id="database">
                                        <option value="<%=TJgdm.class.getName()%>">有效库</option>
                                         <option value="<%=TFzdm.class.getName()%>">注销库</option>
                                         <%--<option value="<%=TBgk.class.getName()%>">代码变更表</option>
                                        <option value="<%=TLjdm.class.getName()%>">无效代码表</option>
                                        <option value="<%=TQzjgdm.class.getName()%>">代码迁址表</option>
                                        <option value="<%=TJgdmSave.class.getName()%>">代码临时表</option>--%>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td width="15%" align="right">条件：</td>
                                <td width="85%" align="left" valign="top" colspan="3">
                                    <select name="column" onchange="setcode()">
                                        <c:forEach items="${ttables}" var="table">
                                            <option value="${fn:trim(table.columncode)}:${fn:trim(table.type)}">${fn:trim(table.columnname)} </option>
                                        </c:forEach>
                                    </select>

                                    <select name="relations">
                                        <option value="=">等于（=）</option>
                                        <option value=">">大于(>)</option>
                                        <option value=">=">大于等于(>=)</option>
                                        <option value="<">小于(<)</option>
                                        <option value="<=">小于等于(<=)</option>
                                        <option value="<>">不等于(<>)</option>
                                        <option value="like">包含(like)</option>
                                        <option value="likl">左包含</option>
                                        <option value="is null">为空</option>
                                        <option value="is not null">不为空</option>
                                    </select>

                                    <input type="text" style="z-index: 100; position: relative; width:200px;"
                                           name="txtvalue" id='txtvalue' size="15" maxsize="30">
                                    <span id="select" style="display: none;">
                                        <input class=button id="txtselect" type="button" value="选 择"
                                               name="txtselect"></span>
                                     <span id="dateselect" style="display: none;">
                                        <A hideFocus onclick="WdatePicker({el:$dp.$('txtvalue')});"
                                           href="javascript:void(0)">
                                            <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
                                        </A>
                                     </span>

                                    <input type="button" name="baddcon" class="newBtn1" value="添 加"
                                           onClick="addToCondition()">

                                    <div style=" padding-left:260px;" id="propbar">
                                        <table border="0" cellpadding="0" cellspacing="0"
                                               style="border-collapse:collapse;">
                                            <tr>
                                                <td width="3" height="10"
                                                    style="background:url(/product/images/jgg/upper_left_corner.gif) right bottom no-repeat;"></td>
                                                <td height="10"
                                                    style="background:url(/product/images/jgg/upper_mid.gif) bottom repeat-x; text-indent:15px;"
                                                    valign="top"><img src="/product/images/jgg/prompt_arrow.gif"/></td>
                                                <td width="3" height="10"
                                                    style="background:url(/product/images/jgg/upper_right_corner.gif) left bottom no-repeat;"></td>
                                            </tr>
                                            <tr>
                                                <td width="3"
                                                    style="background:url(/product/images/jgg/left_mid.gif) repeat-y;"></td>
                                                <td style="background:#f9f8e4;">
                                                    <div id="valuemc" style="padding:5px 10px; font-size:12px;"></div>
                                                </td>
                                                <td width="3"
                                                    style="background:url(/product/images/jgg/right_mid.gif) repeat-y;"></td>
                                            </tr>
                                            <tr>
                                                <td width="3" height="3"
                                                    style="background:url(/product/images/jgg/lower_left_corner.gif) right top no-repeat;"></td>
                                                <td height="3"
                                                    style="background:url(/product/images/jgg/lower_mid.gif) top repeat-x;"></td>
                                                <td width="3" height="3"
                                                    style="background:url(/product/images/jgg/lower_right_corner.gif) left top no-repeat;"></td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>

                            </tr>
                            <tr>
                                <td align="right">逻辑运算符：</td>
                                <td align="left" valign="middle" colspan="3">
                                    <select name="logic" size="1">
                                        <option value="">&nbsp;</option>
                                        <option value="and">并且</option>
                                        <option value="or">或者</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td align="right">排序条件：</td>
                                <td colspan="3" align="left">
                                    <select name="orderby" size="1">
                                        <c:forEach items="${ttables}" var="table">
                                            <option value="${fn:trim(table.columncode)}">${fn:trim(table.columnname)} </option>
                                        </c:forEach>
                                    </select>&nbsp;<select name="ordercode" size="1">
                                    <option value="asc">升序</option>
                                    <option value="desc">降序</option>
                                </select>
                                </td>
                            </tr>
                            <tr style="background: #ffffff;">
                                <td align="right">查询条件：</td>
                                <td colspan="3">
                                    <textarea id="where">${sqlwhere}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">显示字段：</td>
                                <td colspan="3" align="left">
                                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                                        <%--@elvariable id="fields" type="java.util.List<com.ninemax.jpa.code.action.StatisticsAction.Field>"--%>
                                        <tr>
                                            <c:forEach varStatus="status" items="${fields}" var="field">
                                            <input type="hidden" name="fields[${status.index}].dm"
                                                   value="${field.dm}"/>
                                            <input type="hidden" name="fields[${status.index}].name"
                                                   value="${fn:trim(field.name)}"/>
                                            <TD class="td1" align="right">
                                                    ${fn:trim(field.name)}：
                                            </TD>
                                            <TD class="td1">
                                                <c:if test="${field.dm eq 'jgdm' or field.dm eq 'jgmc'}">
                                                    <input type=hidden value="true"
                                                           name="fields[${status.index}].select"/>
                                                    <input type=checkbox checked readonly="readonly" disabled="disabled"
                                                           value="true"/>
                                                </c:if>
                                                <c:if test="${!(field.dm eq 'jgdm' or field.dm eq 'jgmc')}">
                                                    <input type=checkbox   ${field.select?"checked ":""} value="true"
                                                           name="fields[${status.index}].select"/>
                                                </c:if>

                                            </TD>
                                            <c:if test="${ (status.index-2)%3==0}">
                                        </tr>
                                        <tr>
                                            </c:if>

                                            </c:forEach>
                                        </tr>
                                    </TABLE>
                            </tr>
                            <tr>

                                <td align="center" colspan="4">
                                    <input type="button" name="modify" value="查 询"
                                           onClick="return fCheckValue();"
                                           class="newBtn1">
                                    <input type="button" name="reset" value="重 置" class="newBtn1"
                                           onclick="return clearSQL()">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script language="javascript" type="text/javascript">
    <c:if test="${message!=null && message!=''}">
    ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </c:if>
    $("#propbar").hide();
</script>

</html>
