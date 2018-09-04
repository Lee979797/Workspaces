<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="zrxzqhs" type="java.util.List<com.ninemax.jpa.code.model.TZrxzqh>"--%>
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
    <title>�账��������ѯ</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
</head>
<body>
<c:set var="scanMap" value="<%=InitSysParams.frontZrxzqh%>"/>
<div class="page_top">ϵͳ >> ϵͳ���� >> ǰ��ɨ�����</div>
<form name="searchForm" method="post" action="/bsweb/preScan_list">
    <div class="list_box">
        <div class="list_box_top">
            ��֤������<input name="scan.xzqh" type="text" class="input_120" id="dm" value="${scan.xzqh}"
                        maxlength="9"/>
            <input name="button2" type="button" class="newBtn1" value="�� ѯ" onclick="Page.verify();"/>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td class="list_table_top_td" style="width:5%">���</td>
                <td class="list_table_top_td">
                    <div style="float:left">��֤����</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('xzqh','${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="�����ֶ�"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">����</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('mc','${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="�����ֶ�"/></a>
                    </div>
                </td>
                <td class="list_table_top_td" align="center">�Ƿ���
                </td>
                <td class="list_table_top_td" align="center">��/��ɨ��
                </td>
                <td class="list_table_top_td" align="center">�°�ǰ�����
                </td>
                <td class="list_table_top_td" align="center">���ǰ�����
                </td>
                <td class="list_table_top_td" align="center">��֤ǰ�����
                </td>
                <td class="list_table_top_td" align="center">��ʧǰ�����
                </td>

            </tr>

            <c:forEach varStatus="i" var="cf" items="${xzqhs}">
            <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                <td>&nbsp;${i.count }</td>
                <td>&nbsp;${cf.xzqh }</td>
                <td>&nbsp;${cf.mc }</td>
                <td align="center">&nbsp;${scanMap[fn:trim(cf.xzqh)]=='0'?'��':'<font color=red>��</font>'}</td>
                <td align="center">
                    <a href="/bsweb/preScan_frontScanShow?scanManage.xzqh=${cf.xzqh}&scanManage.memo1=${cf.mc }">
                        <img src="../../images/gonggaogl.png" width="16" height="16"
                             style="cursor:pointer" title="${scanMap[fn:trim(cf.xzqh)]=='0'?'��':'�ر�'}"/>
                    </a>
                </td>
                <td align="center">
                    <a href="/bsweb/preScan_show?scan.xzqh=${cf.xzqh}&scan.type=0">
                        <img src="../../images/gonggaogl.png" width="16" height="16"
                             style="cursor:pointer" title="�°�"/>
                    </a>
                </td>
                <td align="center">
                    <a href="/bsweb/preScan_show?scan.xzqh=${cf.xzqh}&scan.type=3">
                        <img src="../../images/gonggaogl.png" width="16" height="16"
                             style="cursor:pointer" title="���"/>
                    </a>
                </td>
                <td align="center">
                    <a href="/bsweb/preScan_show?scan.xzqh=${cf.xzqh}&scan.type=4">
                        <img src="../../images/gonggaogl.png" width="16" height="16"
                             style="cursor:pointer" title="��֤"/>
                    </a>
                </td>
                <td align="center">
                    <a href="/bsweb/preScan_show?scan.xzqh=${cf.xzqh}&scan.type=13">
                        <img src="../../images/gonggaogl.png" width="16" height="16"
                             style="cursor:pointer" title="��ʧ"/>
                    </a>
                </td>


                </c:forEach>
        </table>
        <jsp:include page="../common/pageCommon.jsp"/>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</form>
<form action=""></form>
</body>
<c:if test="${message!=null}">
    <script language="javascript">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '��ʾ��Ϣ'});
    </script>
</c:if>
</html>

