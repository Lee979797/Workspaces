<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
        function fCheckValue() {

            var checkIdObj = eval("searchForm.checkedsns");
            var sns = document.getElementById("sns");
            //判断对象是否为空
            if (checkIdObj == null) {
                ymPrompt.alert({message: "请先选择需要对比的记录！", width: 330, height: 220, title: '提示信息'});
                return false;
            }
            var flag = 0;
            //如果check列表对象多于一个
            if (checkIdObj.length && checkIdObj.length >= 2) {
                for (var i = 0; i < checkIdObj.length; i++) {
                    if (checkIdObj[i].checked) {
                        sns.value += checkIdObj[i].value + ",";
                        flag++;
                    }
                }
            } else {
                if (checkIdObj.checked) {
                    sns.value = checkIdObj.value;
                    flag = true;
                }
            }
            if (flag > 2) {
                ymPrompt.confirmInfo({message: "系统当前只提供两条记录的对比，你选择了多于两条的记录，点击'确定'将对比前两条，否则请取消！", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                    if (tp == 'ok') {
                        document.showForm.submit();
                    }
                }});
                return false;
            } else if (flag >= 1) {
                document.showForm.submit();
                return true;
            } else {
                ymPrompt.alert({message: "请先选择需要对比的记录！", width: 330, height: 220, title: '提示信息'});
                return false;
            }

        }

    </script>
</head>
<body>
<div class="page_top">
    查询 &gt;&gt; 机构查询 &gt;&gt; 法人查重
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_list_frs">
        <div class="list_box_top">
            法人姓名：<input name="jgdm.fddbr" type="text" class="input_120" id="fddbr" value="${jgdm.fddbr}"
                        maxlength="10"/>
            证件号码：<input name="jgdm.zjhm" type="text" class="input_200" id="zjhm" value="${jgdm.zjhm}" maxlength="18"/>
            <input name="button2" type="button" onclick="Page.verify();" class="newBtn1" value="查 询"/>
            &nbsp;
            <input type="button" name="save" value="对 比" onClick="return fCheckValue();" class="newBtn1"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="vertical-align: middle;width: 3%" align="center">
                        选择
                    </td>
                    <td class="list_table_top_td" style="width:5%">序号</td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">机构名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构类型</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jglx','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">法人代表</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('fddbr','${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">证件号码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('zjhm','${(page.orderByField eq 'zjhm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'zjhm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">办证日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                </tr>

                <%--@elvariable id="jgdms" type="java.util.List<com.ninemax.jpa.code.model.TJgdm>"--%>
                <c:forEach varStatus="i" var="bg" items="${jgdms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td align="center"><input type="checkbox" name="checkedsns" value="${bg.jgdm}">
                        </td>
                        <td>&nbsp;${i.count }</td>
                        <td>${bg.jgdm }</td>
                        <td>${bg.jgmc }</td>
                        <td>${jglxMap[bg.jglx] }</td>
                        <td> ${bg.fddbr}</td>
                        <td> ${bg.zjhm}</td>
                        <td><fmt:formatDate value="${bg.bzrq}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/statistics_show_frs.action" name="showForm">
        <input type="hidden" name="sns" id="sns"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
