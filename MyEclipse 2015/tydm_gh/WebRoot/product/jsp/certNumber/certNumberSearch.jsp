<%--@elvariable id="zsbhb" type="com.ninemax.jpa.code.model.TZsbhb"--%>
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
	verifydate();
		}
	   }
	</script>
    <script type="text/javascript">
        function verifydate() {

            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }

        function modify(jgdm) {
            document.getElementById("modify").value = jgdm;
            document.modifyForm.submit();
        }
    </script>
</head>
<body>
<c:set var="bzjgMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<div class="page_top">${title}
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/certificateNumber_listCertNumbers.action">

        <div class="list_box_top" style="border: 1px;">
            占用时间：
            <INPUT name="startDate" id="startDate" onclick="WdatePicker({el:$dp.$('startDate')});"
                   value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>"
                   class="input_120"/>
            <A hideFocus onclick="WdatePicker({el:$dp.$('startDate')});" href="javascript:void(0)">
                <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
            </A>至<INPUT onclick="WdatePicker({el:$dp.$('endDate')});"
                        name="endDate" id="endDate"
                        value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"
                        class="input_120"/>
            <A hideFocus onclick="WdatePicker({el:$dp.$('endDate')});" href="javascript:void(0)">
                <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
            </A>
            证书编号：<input name="zsbhb.id.zsbh" class="input_120" type="text" id="zsbh" size="15" value="${zsbhb.id.zsbh}" onkeyup="onlyNumber(this)">
            
            &nbsp;
            <label for="jgdm">办证机构：</label>
            <select name="zsbhb.ssbzjg" id="bzjgdm"
                    class="input_200">
                <option value=""></option>
                <c:forEach var="bzjg" items="${zrxzqhMap}">
                    <option value="${bzjg.key}" ${zsbhb.ssbzjg eq bzjg.key?'selected="selected"':''} >${bzjg.value}</option>
                </c:forEach>
            </select>
                  状态：<select name="zsbhb.flag" id="flag" class="input_120">
            <option value="*" ${zsbhb.flag eq '*'?'selected':''}>全部</option>
            <option value="0" ${zsbhb.flag eq '0'?'selected':''}>闲置</option>
            <option value="1" ${zsbhb.flag eq '1'?'selected':''}>占用</option>
            <option value="2" ${zsbhb.flag eq '2'?'selected':''}>损耗</option>
        </select>
            
            </br>
            <label for="zstype">证书类型：</label>
            <select name="zsbhb.id.zslx" id="zstype" class="input_120">
                <option value="">所有</option>
                <option value="0" ${zsbhb.id.zslx eq '0'?'selected':''} >正本</option>
                <option value="1" ${zsbhb.id.zslx eq '1'?'selected':''} >副本</option>
            </select>
      &nbsp;<input name="search" type="button" onclick="return verifydate();" class="newBtn1" id="btn1"
                              value="查 询"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">
                        <div style="float:left">&nbsp;序号</div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left"> 证书编号</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('id.zsbh','${(page.orderByField eq 'id.zsbh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'id.zsbh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">类型</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('id.zslx','${(page.orderByField eq 'id.zslx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'id.zslx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">所属机构</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ssbzjg','${(page.orderByField eq 'ssbzjg' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ssbzjg' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    
                    <td class="list_table_top_td">
                        <div style="float:left">办证机构</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ssbzjg','${(page.orderByField eq 'ssbzjg' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ssbzjg' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    
                    <td class="list_table_top_td">
                        <div style="float:left">状态</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('flag','${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">占用时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('dysj','${(page.orderByField eq 'dysj' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'dysj' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">操作员</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('czy','${(page.orderByField eq 'czy' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'czy' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
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
                </tr>
                <c:forEach varStatus="i" var="bh" items="${zsbhbs}">
                    <tr ${i.index % 2==0?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${bh.id.zsbh }</td>
                        <td>${bh.id.zslx=='0'?'正本':'副本'}</td>
                        <td>${bzjgMap[bh.ssbzjg]}</td>
                        <td>${bh.ssbzjg}</td>
                        <td>${bh.flag=='0'?'闲置':bh.flag=='1'?'占用':'损耗' }</td>
                        <td><fmt:formatDate value='${bh.dysj}' pattern='yyyy-MM-dd'/></td>
                        <td>${bh.czy}</td>
                        <td>${bh.djh}</td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/certificateNumber_showCertNumber.action" name="showForm">
        <input type="hidden" name="zsbhb.id.zsbh" id="show"/>
    </form>
    <form action="/bsweb/certificatePrint_show_print_main.action" name="modifyForm">
        <input type="hidden" name="zs.zsbh" id="modify"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
