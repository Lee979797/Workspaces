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
<c:set var="bzjgdmMap" value="<%=InitSysParams.zrxzqhMap%>"/>
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
    <script type='text/javascript' src='/js/jgdmSearch.js'></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#dm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			search();
		}
	   }
	</script>
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
        function search() {
            var obj = document.getElementById("dm");

            Page._curent(1);
            var jgdm = document.getElementById("dm").value;
            if (!/^[a-zA-Z0-9]+$/.test(jgdm)) {
                jgdm = jgdm.toUpperCase();
                obj.value = jgdm.replace(/[^a-zA-Z0-9]/gm, "");
                ymPrompt.alert({message: "请输入正确的机构代码！",
                    slideShowHide: false, width: 330, height: 220, title: '提示信息'});
                return false;
            }
            Page.verify();
            return false;
        }
    </script>
</head>
<body onload="document.getElementById('dm').focus()" onkeypress="ches(document.searchForm,search)">
<div class="page_top">
    查询 &gt;&gt; 数据变更历史查询 &gt;&gt; 数据变更历史查询
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_update_history.action">
        <div class="list_box_top">
            机构代码：<input name="bgk.jgdm" type="text" class="input_120" id="dm" value="${bgk.jgdm}" maxlength="9"/>
            <input name="button2" type="button" onclick="search();" class="newBtn1" value="查 询"/>
            &nbsp;
            <input type="button" name="save" value="对 比" onClick="return fCheckValue();" class="newBtn1"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
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
                        <div style="float:left">办证机构</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bzjgdm','${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
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
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">年检日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('njrq','${(page.orderByField eq 'njrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'njrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">变更时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bgsj','${(page.orderByField eq 'bgsj' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bgsj' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                </tr>

                <%--@elvariable id="bgks" type="java.util.List<com.ninemax.jpa.code.model.TBgk>"--%>
                <c:forEach varStatus="i" var="bg" items="${bgks}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td align="center">
                            <input type="checkbox" name="checkedsns"
                                   value="${bg.sn eq 0 ?bg.jgdm:bg.sn}">
                        </td>
                        <td>&nbsp;${i.count }</td>
                        <td>${bg.jgdm }</td>
                        <td>${bg.jgmc }</td>
                        <td>${jglxMap[bg.jglx] }</td>
                        <td> ${bzjgdmMap[bg.bzjgdm]}</td>
                        <td><fmt:formatDate value="${bg.bzrq}"/></td>
                        <td><fmt:formatDate value="${bg.njrq}"/></td>
                        <td><fmt:formatDate value="${bg.bgsj}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/statistics_show_diff.action" name="showForm">
        <input type="hidden" name="sns" id="sns"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
