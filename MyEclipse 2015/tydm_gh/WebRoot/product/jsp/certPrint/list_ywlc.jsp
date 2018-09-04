<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�����������</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript">

        function show(lsh, jgdm, xzqh) {
            dwr.engine.setAsync(false);
            var flag;
            var result;
            var num;
            jgdmBus.getZssl(jgdm, function (value) {
                num = value;
            });
            if (num == "error") {
                ymPrompt.alert({message: "��ǰ�������벻���ڣ�", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            var zb_fb = num.split(":");
            certPrintBus.hasCert(xzqh, zb_fb[0], zb_fb[1], function (value) {
                flag = value;
            });
            if (!flag) {
                ymPrompt.alert({message: "��ǰ����֤���治�㣬����֤�����ܴ�ӡ֤��", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            certPrintBus.checkTime(jgdm,'${sysUser.bzjgdm}',true, function (value) {
                var ss = value.split(':');
                flag = ss[0];
                result = ss.length > 1 ? ss[1] : '';
            });

            if (flag != "true") {
                ymPrompt.alert(result);
                return false;
            }
            certPrintBus.isALLScanComplete(jgdm, xzqh, function (value) {
                flag = value;

            });
            if (flag) {
                document.getElementById("jgdm").value = jgdm;
                document.getElementById("lsh").value = lsh;
                document.showForm.submit();
                return true;
            } else {
                ymPrompt.alert({message: "�������루" + jgdm + "����Ҫ�����ɨ��������ܴ�ӡ֤��", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
        }
    </script>
</head>
<body>
<div class="page_top">��֤ &gt;&gt; ֤���ӡ &gt;&gt; ����֤���ӡ
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/certificatePrint_list_no_print">
        <input type="hidden" value="${source}" id="source" name="source">

        <div class="list_box_top">
            ҵ����ˮ�ţ�
            <input type="text" name="ywlc.ywlsh" size="13" id="ywlsh" maxlength="12" value="${ywlc.ywlsh}"
                   class="input_120">
            �������룺
            <input type="text" name="ywlc.jgdm" size="13" maxlength="9" value="${ywlc.jgdm}"
                   class="input_120">
            &nbsp;<input name="button2" type="button" class="newBtn1" id="btn" value="�� ѯ" onclick="Page.verify();"/>
        </div>
        <div class="list_box">
            <c:set var="dms" value="${ywlcs}"/>

            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">���</td>
                    <td class="list_table_top_td">
                        <div style="float:left">ҵ����ˮ��</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ywlsh','${(page.orderByField eq 'ywlsh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ywlsh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">��������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">��������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">ҵ����������</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('clsj','${(page.orderByField eq 'clsj' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'clsj' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="�����ֶ�"/></a>
                        </div>
                    </td>
                    <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
                        <td class="list_table_top_td" align="center">����</td>
                    </c:if>
                </tr>
                <c:forEach varStatus="i" var="dm" items="${dms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${dm.ywlsh}</td>
                        <td>${dm.jgdm}</td>
                        <td>${dm.jgmc}</td>
                        <td>
                            <fmt:formatDate value="${dm.clsj}"/>
                        </td>
                        <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
                            <td align="center">
                                <img src="/product/images/print_16x16.gif" width="16"
                                     height="16"
                                     onclick="show('${dm.ywlsh}','${dm.jgdm}','${dm.bzjgdm}');"
                                     style="cursor:pointer;" title="��ӡ"/>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>

        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
    <form action="/bsweb/certificatePrint_zb_info.action" name="showForm">
        <input type="hidden" name="ywlc.jgdm" id="jgdm"/>
        <input type="hidden" name="ywlc.ywlsh" id="lsh"/>
    </form>
</div>
</body>
</html>
