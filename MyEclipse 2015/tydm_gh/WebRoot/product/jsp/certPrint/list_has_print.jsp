<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>登记表查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
    <script type="text/javascript">
        function verifydate() {
            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }
        function showFB(jgdm, xzqh, type, num) {
            var flag;
            dwr.engine.setAsync(false);
            var codeflag;
            certPrintBus.hasCert(xzqh, type, num, function (value) {
                flag = value;
                if (!flag) {
                    codeflag = true;
                    ymPrompt.alert({message: "当前机构证书库存不足，补足证书后才能打印证书!", width: 330, height: 220, title: '提示信息'});
                    return false;
                }
            });

            if (codeflag) {
                return;
            }
            certPrintBus.checkBzjgdm(jgdm, '${sysUser.bzjgdm}', function (data) {
                flag = data;
                if (flag != 'success') {
                    codeflag = true;
                    ymPrompt.alert({message: "机构代码(" + jgdm + ")不属于本办证机构管辖!", width: 330, height: 220, title: '提示信息'});
                    return false;
                }
            });

            if (codeflag) {
                return;
            }
            certPrintBus.checkFb(jgdm, '${sysUser.bzjgdm}', function (data) {
                flag = data;
                if (!flag) {
                    codeflag = true;
                    ymPrompt.alert({message: "副本库存已经耗尽,补充副本后方可操作!", width: 330, height: 220, title: '提示信息'});
                    return false;
                }
            });
            if (codeflag) {
                return;
            }
            document.getElementById("jgdm").value = jgdm;
            document.showForm.submit();
            return true;
        }
        function showSpecial(jgdm, xzqh, zb, fb) {
            var flag;
            dwr.engine.setAsync(false);
            certPrintBus.hasCert(xzqh, zb, fb, function (value) {
                flag = value;
            });
            if (!flag) {
                ymPrompt.alert({message: "当前机构证书库存不足，补足证书后才能打印证书", width: 330, height: 220, title: '提示信息'});
                return false;
            }
            document.getElementById("jgdm2").value = jgdm;
            document.showForm2.submit();
            return true;
        }
    </script>
</head>
<body onkeypress="ches(document.searchForm,verifydate);">
<div class="page_top">${title}
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/certificatePrint_list_has_print.action">
        <div class="list_box_top" style="border: 1px;">
            机构代码：
            <input type="text" name="jgdm.jgdm" size="13" id="jgdm1"
                   maxlength="9" value="${jgdm.jgdm}" class="input_120"
                    >&nbsp;<span
                id="length" style="color: #ff0000"></span>
            办证时间：
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

            <input name="search" type="button" onclick="return verifydate();" class="newBtn1" id="btn1" value="查 询"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:3%">
                        <div style="float:left">&nbsp;序号</div>
                    </td>

                    <td class="list_table_top_td" >
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
                    <td class="list_table_top_td" >
                        <div style="float:left">办证日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" >
                        <div style="float:left">业务变更日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('lastdate','${(page.orderByField eq 'lastdate' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'lastdate' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <%--  <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
                          <td class="list_table_top_td" align="center" >
                              副本打印
                          </td>
                          <td class="list_table_top_td" align="center" >
                              特殊打印
                          </td>
                          <td class="list_table_top_td" align="center" style="width:10%">
                              操作
                          </td>
                      </c:if>--%>
                </tr>
                <c:forEach varStatus="i" var="dm" items="${jgdms}">
                    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${dm.jgdm }</td>
                        <td>${dm.jgmc}</td>
                        <td><fmt:formatDate value="${dm.bzrq}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${dm.lastdate}" pattern="yyyy-MM-dd"/></td>
                            <%--   <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
                                   <td align="center">
                                       <img src="/product/images/print_16x16.gif" width="16" height="16"
                                            onclick="showFB('${dm.jgdm}','${dm.bzjgdm}',0,${dm.fbsl})"
                                            style="cursor:pointer" title="打证副本"/></td>
                                   <td align="center">
                                       <img src="/product/images/print_16x16.gif" width="16" height="16"
                                            onclick="showSpecial('${dm.jgdm}','${dm.bzjgdm}',${dm.zbsl},${dm.fbsl})"
                                            style="cursor:pointer" title="特殊打印"/>
                                   </td>
                                   <td align="center">
                                       <a href="/bsweb/certificatePrint_verify_invoice?jgdm.jgdm=${dm.jgdm}">校对单</a>
                                       &nbsp; &nbsp;
                                       <a href="/bsweb/certificatePrint_simple_verify_invoice?jgdm.jgdm=${dm.jgdm}">校对单简表</a>
                                   </td>
                               </c:if>--%>

                    </tr>
                </c:forEach>

            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/certificatePrint_fb_info.action" name="showForm">
        <input type="hidden" name="jgdm.jgdm" id="jgdm"/>
    </form>
    <form action="/bsweb/certificatePrint_special_info" name="showForm2">
        <input type="hidden" name="jgdm.jgdm" id="jgdm2"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
<script language="javascript" type="text/javascript">
    (function () {
        <c:if test="${message!=null && message!=''}">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
        </c:if>
        document.getElementById("jgdm1").focus();
    })();
</script>
</html>