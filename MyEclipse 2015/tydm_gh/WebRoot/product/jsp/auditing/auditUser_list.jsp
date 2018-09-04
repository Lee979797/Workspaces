<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�û���˹���</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
</head>
<body>
<div class="page_top">��� &gt;&gt; ��˹��� &gt;&gt; �û����</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/auditingauditUserList.action">
        <div class="list_box_top">
            ��ʼ���ڣ�
            <input id="CalendarSelector1" readOnly name="startDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${startDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector1'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            ��ֹ���ڣ�
            <input id="CalendarSelector2" readOnly name="endDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${endDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector2'})"/>
            �û�����<input name="_jgdm" type="text" class="input_120" id="_jgdm" value=""/>
            <input name="textfield3" type="text" class="input_120" id="textfield3" style="display:none"/>
            <input name="button2" type="button" class="newBtn1" id="bu" value="�� ѯ" onclick="Page.verify()"/>

        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">���</td>
                    <td class="list_table_top_td">
                        <div style="float:left">�û���</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('username','${(page.orderByField eq 'username' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'username' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>

                    <td class="list_table_top_td">
                        <div style="float:left">��֯��������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center">���</td>
                </tr>

                <c:forEach varStatus="i" var="user" items="${userList}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${user.username }</td>
                        <td>${user.jgmc }</td>
                        <td align="center">
                            <img src="/product/images/icon_shenhe.gif" width="16" height="16"
                                 onclick="window.location.href='/bsweb/auditinguserOfAudit.html?user.id=${user.id}'"
                                 style="cursor:pointer;" title="���"/>
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
