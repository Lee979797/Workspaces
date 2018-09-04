<%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="zs" type="com.ninemax.jpa.code.model.TZs"--%>
<%--@elvariable id="startDate" type="java.util.Date"--%>
<%--@elvariable id="endDate" type="java.util.Date"--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="bzjgMap" value="<%=InitSysParams.xzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>登记表查询</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript">
	  $(function(){   $("#startDate").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			verifyData();
		}
	   }
	   </script>
    <script type="text/javascript">
        function verifyData() {
            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }

        function modify(lsh) {
            document.getElementById("modify").value = lsh;
            document.modifyForm.submit();
        }
    </script>
</head>
<body>
<c:set var="bzjgdmMap" value="<%=InitSysParams.zrxzqhMap%>"/>
<div class="page_top">${title}</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/certificateNumber_listCertBook.action">
        <div class="list_box_top" style="border: 1px;">
            <label for="startDate">发证时间：</label>
            <INPUT maxLength=10 size=23 name="startDate" id="startDate" onclick="WdatePicker({el:$dp.$('startDate')});"
                   class="input_120" value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>"/>
            <A hideFocus onclick="WdatePicker({el:$dp.$('startDate')});" href="javascript:void(0)">
                <IMG src="/images/icon_rili.gif" align="middle"/>
            </A><label for="endDate">至</label>
            <INPUT maxLength=10 size=23 onclick="WdatePicker({el:$dp.$('endDate')});" class="input_120" name="endDate"
                   id="endDate"
                   value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"/>
            <A hideFocus onclick="WdatePicker({el:$dp.$('endDate')});" href="javascript:void(0)">
                <IMG src="/images/icon_rili.gif" align="middle"/>
            </A>
            &nbsp;
            <label for="jgdm">办证机构：</label>
            <select name="zs.bzjgdm" id="bzjgdm"
                    class="input_200">
                <option value=""></option>
                <c:forEach var="bzjg" items="${zrxzqhMap}">
                    <option value="${bzjg.key}" ${zs.bzjgdm eq bzjg.key?'selected="selected"':''} >${bzjg.value}</option>
                </c:forEach>
            </select>
            

            <label for="jgdm">机构代码：</label>
            <input name="zs.jgdm" type="text" id="jgdm" size="9" class="input_120" maxlength="9"
                   value="${zs.jgdm}"/>
            <label for="djh"> 登记号：</label>
            <input name="zs.djh" type="text" id="djh" size="20" value="${zs.djh}"
                   class="input_120">&nbsp;
            <input name="search" type="button" onclick="return verifyData();" class="newBtn1" id="btn1" value="查 询"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">
                        <div style="float:left">&nbsp;序号</div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:5%">
                        <div style="float:left">类型</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('zstype','${(page.orderByField eq 'zstype' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'zstype' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">登记号</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('djh','${(page.orderByField eq 'djh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'djh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:5%">
                        <div style="float:left">状态</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('flag','${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">证书编号</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('zsbh','${(page.orderByField eq 'zsbh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'zsbh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="">
                        <div style="float:left">发证机构</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('fzr','${(page.orderByField eq 'fzr' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'fzr' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">发证时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('fzsj','${(page.orderByField eq 'fzsj' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'fzsj' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center" style="width:3%">
                        修改
                    </td>
                </tr>
                <%--@elvariable id="zses" type="java.util.List<com.ninemax.jpa.code.model.TZs>"--%>
                <c:forEach varStatus="i" var="vzs" items="${zses}">
                    <tr ${i.index % 2==0?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.index+1 }</td>
                        <td>${vzs.jgdm }</td>
                        <td>${vzs.zstype=='0'?'正本':'副本'}</td>
                        <td>${vzs.djh }</td>
                        <td>${vzs.flag=='0'?'无效':'有效' }</td>
                        <td>${vzs.zsbh}</td>
                        <td>${bzjgMap[fn:trim(vzs.fzr)]}</td>
                        <td><fmt:formatDate value='${vzs.fzsj}' pattern='yyyy-MM-dd'/></td>
                        <td align="center">
                            <img src="/images/icon_edit.gif" width="16" height="16"
                                 onclick="modify('${vzs.lsh}')"
                                 style="cursor:pointer" title="修改"/></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/certificateNumber_certBook.action" name="modifyForm">
        <input type="hidden" name="zs.lsh" id="modify"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
