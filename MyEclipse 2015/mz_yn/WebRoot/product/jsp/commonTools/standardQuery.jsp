<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="dm" type="java.lang.String"--%>
<%--@elvariable id="table" type="java.lang.String"--%>
<%--@elvariable id="models" type="java.util.List<com.ninemax.jpa.code.model.Model>"--%>
<%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>外网数据审核</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/page.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#dm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		Page.verify();
		}
	   }
	</script>
</head>
<body>
<div class="page_top">发证 &gt;&gt; 常用工具 &gt;&gt; 标准查询
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/commonTools_standardQuery">
        <div class="list_box_top">
            标准代码或名称：
            <input type="text" name="dm" size="13" id="dm" maxlength="12" value="${dm}"
                   class="input_120">
            数据来源：
            <select class="input_120" name="table">

                <option value="t_jjhy" ${table eq 't_jjhy'?'selected':''}>经济行业(94版)</option>
                <option value="t_njjhy" ${table eq 't_njjhy'?'selected':''}>经济行业(2000版)</option>
                <option value="sc_jjhy" ${table eq 'sc_jjhy'?'selected':''}>经济行业(2011版)</option>
                <option value="t_jjlx" ${table eq 't_jjlx'?'selected':''}>经济类型(94版)</option>
                <option value="t_njjlx" ${table eq 't_njjlx'?'selected':''}>经济类型(2000版)</option>
                <option value="sc_lx" ${table eq 'sc_lx'?'selected':''}>登记类型</option>
                <option value="t_zycp" ${table eq 't_zycp'?'selected':''}>主 要 产 品</option>
                <option value="sc_gj" ${table eq 'sc_gj'?'selected':''}>外 方 国 别</option>
                <option value="sc_xzqh1" ${table eq 'sc_xzqh1'?'selected':''}>行 政 区 划</option>
                <option value="t_hb" ${table eq 't_hb'?'selected':''}>货 币 种 类</option>
            </select>
            &nbsp;<input name="button2" type="button" class="newBtn1" id="btn" value="查 询" onclick="Page.verify();"/>
        </div>
        <div class="list_box">
            <c:set var="dms" value="${models}"/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">序号</td>
                    <td class="list_table_top_td">
                        <div style="float:left">代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('dm','${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('mc','${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                </tr>
                <c:forEach varStatus="i" var="dm" items="${dms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${dm.column1}</td>
                        <td>${dm.column2}</td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
