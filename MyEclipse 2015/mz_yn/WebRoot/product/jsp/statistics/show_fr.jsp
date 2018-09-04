<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">��ѯ &gt;&gt; ������ѯ &gt;&gt; ���˲��� &gt;&gt; ���˻�����Ϣ</div>
    <div align="right" style=" float: right;">
        <INPUT class="newBtn1" onClick="window.location.href='/bsweb/statistics_list_frs'" type=button value="�� ��" name='cmdExit'>
        &nbsp;
    </div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width=                  bgcolor="#eaf6fb">
                        <tr>
                            <td class="td1" align=right width="15%">
                                �������룺
                            </td>
                            <td class="td1" >
                                <c:set var="name" value=" ${jgdm.jgdm}"/>
                                ${(name eq '' or name eq null)?"��":name }
                            </td>
                            <TD class=td1 align=right width="15%">
                                �����ʱ�� ��
                            </TD>
                            <TD class=td1 >
                                <fmt:formatDate value="${jgdm.lastdate}" pattern="yyyy-MM-dd"/>
                            </TD>
                        </tr>
                        <jsp:include page="../common/show-jgdm2.jsp"/>
                    </TABLE>
                </div>
                <div class="listbtn">
                    <INPUT class="newBtn1" onClick=" history.back()" type=button value="�� ��"
                           name='cmdExit'>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
