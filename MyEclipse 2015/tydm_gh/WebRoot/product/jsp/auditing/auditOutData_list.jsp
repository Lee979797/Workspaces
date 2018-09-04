<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
    //权限
    /**
     *权限说明
     *  100101  用户审核
     *  10010101 审核
     **/
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User user = (User) session.getAttribute("sysUser");

    boolean canAudit = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "10010101");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>外网数据审核</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#CalendarSelector1").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			Page.verify();
		}
	   }
	</script>
</head>
<body>
<div class="page_top">审核 &gt;&gt; 审核管理 &gt;&gt; 外网数据审核</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/auditingoutDataList.action">
        <div class="list_box_top">
            起始日期：
            <input id="CalendarSelector1"  name="startDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${startDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector1'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            截止日期：
            <input id="CalendarSelector2"  name="endDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${endDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector2'})"/>
            机构代码：<input name="_jgdm" type="text" class="input_120" id="jgdm" maxlength="9" value="${_jgdm}"/>
            <input name="textfield3" type="text" class="input_120" id="textfield3" style="display:none"/>
            <input name="button2" type="button" class="newBtn1" id="btn" value="查 询"
                   onclick="Page.verify()"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                   >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">业务类型</div>
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
                        <div style="float:left">办证机构</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bzjgdm','${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center" style="width:5%">审核</td>
                </tr>
                <%--@elvariable id="jgdmwws" type="java.util.List<com.ninemax.jpa.code.model.TJgdmWw>"--%>
                <c:forEach varStatus="i" var="sp" items="${jgdmwws}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>
                                ${1 eq sp.type ?'新办':2 eq sp.type ?'变更':3 eq sp.type ?'换证':4 eq sp.type ?'年检':5 eq sp.type ?'注销':6 eq sp.type ?'挂失':''}
                        </td>
                        <td>${sp.jgdm }</td>
                        <td>${sp.jgmc }</td>
                        <td>${sp.bzjgdm }</td>
                        <td align="center">
                            <img src="/product/images/icon_shenhe.gif" width="16"
                                 height="16"
                                 onclick="window.location.href='bsweb/auditingfindOutData?_jgdm=${sp.id}'"
                                 style="cursor:pointer;" title="审核"/>
                        </td>
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
