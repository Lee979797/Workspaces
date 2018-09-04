<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="jglx" type="com.ninemax.jpa.code.model.TJglx"--%>
<%--@elvariable id="btxs" type="java.lang.String"--%>
<c:set var="jglxs" value="<%=InitSysParams.jglxMap%>"/>
<c:set var="btxList" value="${fn:split(scan.jglxs,',')}"/>
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
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>分配角色</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript">

        function add() {
            var jglxs = document.getElementById("jglxs");
            var btxs = document.getElementById("btxs");
            if (jglxs) {
                if (jglxs.selectedIndex < 0) {
                    ymPrompt.alert('请选择要添加的审核项!', 330, 220, '提示信息');
                    return;
                }
                if (jglxs.length > 0) {
                    var selectedOptions = [];
                    for (var allIndex = 0; allIndex < jglxs.length; allIndex++) {

                        if (jglxs.options[allIndex].selected) {

                            var select = document.createElement("OPTION");
                            select.value = jglxs[allIndex].value;
                            select.text = jglxs[allIndex].innerText;

                            btxs.options.add(select);

                            selectedOptions.push(allIndex);
                        }
                    }
                    if (selectedOptions.length > 0) {
                        var index = 0;
                        for (var selectedOptionIndex = 0; selectedOptionIndex < selectedOptions.length; selectedOptionIndex++) {
                            jglxs.options.remove(selectedOptions[selectedOptionIndex] - index);
                            index++;
                        }
                    }
                }
            }


        }

        function addAll() {
            var jglxs = document.getElementById("jglxs");
            var btxs = document.getElementById("btxs");
            if (jglxs) {
                if (jglxs.length > 0) {
                    var selectedOptions = [];
                    for (var allIndex = 0; allIndex < jglxs.length; allIndex++) {

                        var select = document.createElement("OPTION");
                        select.value = jglxs[allIndex].value;
                        select.text = jglxs[allIndex].innerText;

                        btxs.options.add(select);

                        selectedOptions.push(allIndex);

                    }

                    if (selectedOptions.length > 0) {
                        var index = 0;
                        for (var selectedIndex = 0; selectedIndex < selectedOptions.length; selectedIndex++) {

                            jglxs.options.remove(selectedOptions[selectedIndex] - index);
                            index++;
                        }
                    }
                }
            }


        }

        function del() {

            var jglxs = document.getElementById("jglxs");
            var btxs = document.getElementById("btxs");


            if (btxs) {
                if (btxs.selectedIndex < 0) {
                    ymPrompt.alert('请选择您所要去除的审核项！', 330, 220, '提示信息');
                    return;
                }
                if (btxs.length > 0) {
                    var selectedOptions = [];
                    for (var selectedRoleIndex = 0; selectedRoleIndex < btxs.length; selectedRoleIndex++) {

                        if (btxs.options[selectedRoleIndex].selected) {
                            var select = document.createElement("OPTION");
                            select.value = btxs[selectedRoleIndex].value;
                            select.text = btxs[selectedRoleIndex].innerText;
                            jglxs.options.add(select);
                            selectedOptions.push(selectedRoleIndex);
                        }
                    }

                    if (selectedOptions.length > 0) {

                        var index = 0;
                        for (var selectedOptionIndex = 0; selectedOptionIndex < selectedOptions.length; selectedOptionIndex++) {


                            btxs.options.remove(selectedOptions[selectedOptionIndex] - index);
                            index++;
                        }
                    }
                }
            }

        }

        function delAll() {
            var jglxs = document.getElementById("jglxs");
            var btxs = document.getElementById("btxs");
            if (btxs) {
                if (btxs.length > 0) {
                    var selectedOptions = [];
                    for (var selectedRoleIndex = 0; selectedRoleIndex < btxs.length; selectedRoleIndex++) {

                        var select = document.createElement("OPTION");
                        select.value = btxs[selectedRoleIndex].value;
                        select.text = btxs[selectedRoleIndex].innerText;
                        jglxs.options.add(select);
                        selectedOptions.push(selectedRoleIndex);
                    }

                    if (selectedOptions.length > 0) {

                        var index = 0;
                        for (var selectedOptionIndex = 0; selectedOptionIndex < selectedOptions.length; selectedOptionIndex++) {


                            btxs.options.remove(selectedOptions[selectedOptionIndex] - index);
                            index++;
                        }
                    }
                }
            }

        }
        function checkValid() {
            var btxs = document.getElementById("btxs");
            var options = btxs.options;
            var opt;
            for (var i = 0; i < options.length; i++) {
                opt = options[i];
                opt.selected = true;
            }
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 系统设置 &gt;&gt; 前置审核管理</div>
<c:set var="xzqhs" value="<%=InitSysParams.zrxzqhMap%>"></c:set>
<form method="post" action="/bsweb/preScan_save" name="groupForm">
    <input type="hidden" name="scan.xzqh" value="${scan.xzqh}">
    <input type="hidden" name="scan.type" value="${scan.type}">

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <span> <img src="/product/jsp/images/icon_addgxlm.gif" width="16"
                                    height="16"/>
                                    ${xzqhs[scan.xzqh]}-${scan.type eq '0'?'新增':scan.type eq '3'?'变更':scan.type eq '0'?'换证':'挂失'}
                        </span>
                        <br/>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                            <tr class="tr_top">
                                <td width="42%" align="center" class="box1">不需要前置审核项</td>
                                <td width="16%" align="center" class="box1">&nbsp;</td>
                                <td width="42%" align="center" class="box1">需要前置审核项</td>
                            </tr>

                            <tr align='center'>
                                <td class="box2">
                                    <label>
                                        <select name="jglxs" id="jglxs" size="30" style="width:200px" multiple>
                                            <c:forEach var="field" items="${jglxs}">
                                                <c:set var="has" value="${false}"/>
                                                <c:forEach items="${btxList}" var="btx">
                                                    <c:if test="${fn:trim(btx ) eq  fn:trim(field.key)}">
                                                        <c:set var="has" value="${true}"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${!has}">
                                                    <option value="${field.key}">${field.value}
                                                    </option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </label></td>
                                <td>
                                    <div align="center" style="height: 48px">
                                        <input name="addbutton" type="button" value="&gt;&gt;" class="btn_more"
                                               onClick="addAll()"/>
                                    </div>
                                    <div align="center" style="height: 48px">
                                        <input name="addbutton" type="button" value="&gt;" class="btn_more"
                                               onClick="add()"/>
                                    </div>
                                    <div align="center" style="height: 48px">
                                        <input name="delbutton" type="button" value="&lt;" class="btn_more"
                                               onClick="del()"/>
                                    </div>
                                    <div align="center" style="height: 48px">
                                        <input name="delbutton" type="button" value="&lt;&lt;" class="btn_more"
                                               onClick="delAll()"/>
                                    </div>
                                </td>
                                <td class="box2">
                                    <label for="btxs">
                                        <select name="scan.jglxs" id="btxs" size="30" style="width:200px"
                                                multiple>
                                            <c:forEach var="field" items="${jglxs}">
                                                <c:set var="has" value="${false}"/>
                                                <c:forEach items="${btxList}" var="btx">
                                                    <c:if test="${fn:trim(btx ) eq  fn:trim(field.key)}">
                                                        <c:set var="has" value="${true}"/>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${has}">
                                                    <option value="${field.key}">${field.value}
                                                    </option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </td>
                            </tr>

                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="button" class="newBtn1" id="button" onclick="checkValid()" value="保 存"/>
                        <input name="button" type="button" class="newBtn1" id="back" value="返 回"
                               onclick="location.href='/bsweb/preScan_list'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<c:if test="${message ne null and '' ne message }">
    <script type="text/javascript">
        ymPrompt.succeedInfo('${message}', 330, 220, '提示信息');

    </script>
</c:if>

</html>
