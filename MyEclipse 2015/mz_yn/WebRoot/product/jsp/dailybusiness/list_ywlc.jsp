<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>外网数据审核</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
    <script type="text/javascript">
        function fCheckValue(jgdm) {
            document.thisForm.mc.value = jgdm;
            dwr.engine.setAsync(false);
            flag = checkJgdmCode(jgdm) && checkValidate(jgdm);
        }
        function checkValidate(jgdm) {
            var bzjgdm = thisForm.bzjgdm.value;
            var source = document.getElementById("source").value;
            if (source != "unvalidate") {
                if (!checkJgdmWithBzjgdm(jgdm, bzjgdm,'${sysUser.userName}')) {
                    return false;
                }
            } else {
                if (!checkFzdmExit(jgdm)) {
                    return false;
                }
            }
            if (!ywkz(jgdm, source)) {
                return false;
            }
            if (source == "check") {
                var b = false;
                kqnjBus.checkYear(jgdm, bzjgdm, function (value) {
                    var vs = value.split(":");
                    if ("false" == vs[0]) {
                        ymPrompt.alert({message: vs[1], width: 330, height: 220,
                            slideShowHide: false, title: '提示信息', handle: handler});
                        b = false;
                    } else {
                        b = true;
                    }
                });
                if (b) {
                    var re1 = true;
                    spBus.isAudiaAll(jgdm, '12', function (data) {
                        var index = data.indexOf(":");
                        var s1 = data.substring(0, index);
                        var s2 = data.substring(index + 1, data.length);
                        if (s1 == "0") {
                            document.thisForm.submit();
                        }
                        if (s1 == "1") {
                            ymPrompt.alert({message: s2, width: 330, height: 220,
                                slideShowHide: false, title: '提示信息'});
                            re1 = false;
                        }
                        return  re1;
                    });

                }

                return false;
            }
            if (source == "update") {
                if (needAudia(jgdm, "17")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }
            }
            if (source == "update_no") {
                if (needAudia(jgdm, "bgsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                    return true;
                }

            }
            if (source == "unvalidate") {
                if (needAudia(jgdm, "fzhfsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                    return true;
                }
            }
            if (source == "validate") {
                if (needAudia(jgdm, "fzsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                    return true;
                }

            }
            if (source == "delete") {
                if (needAudia(jgdm, "deletesh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                    return true;
                }

            }
            return true;
        }

    </script>
</head>
<body>
<div class="page_top">日常 &gt;&gt; 日常业务 &gt;&gt;<c:if test="${source eq 'update'}">非证书项变更 </c:if>
    <c:if test="${source eq 'update_no'}">证书项变更 </c:if>
    <c:if test="${source ne 'update' and source ne 'update_no' }">代码${title}</c:if>
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/business_list.action">
        <input type="hidden" value="${source}" id="source" name="source">

        <div class="list_box_top">
            业务流水号：
            <input type="text" name="ywlc.ywlsh" size="13" id="ywlsh" maxlength="12" value="${jgdm.jgdm}"
                   class="input_120">
            机构代码：
            <input type="text" name="ywlc.jgdm" size="13" id="jgdm" maxlength="9" value="${jgdm.jgdm}"
                   class="input_120">
            &nbsp;<input name="button2" type="button" class="newBtn1" id="btn" value="查 询" onclick="Page.verify();"/>
        </div>
        <div class="list_box">
            <c:set var="dms" value="${ywlcs}"/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">序号</td>
                    <td class="list_table_top_td">
                        <div style="float:left">业务流水号</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ywlsh','${(page.orderByField eq 'ywlsh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ywlsh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
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
                    <td class="list_table_top_td">
                        <div style="float:left">业务受理日期</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('clsj','${(page.orderByField eq 'clsj' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'clsj' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center">操作</td>

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
                        <td align="center">
                            <img src="/product/images/icon_shenhe.gif" width="16"
                                 height="16"
                                 onclick="fCheckValue('${dm.jgdm}');"
                                 style="cursor:pointer;" title="${title}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>

        </div>

    </form>
    <form method="get" name='thisForm' action="/bsweb/business_search.action">
        <input name="mc" type="hidden" id="mc"/>
        <input type="hidden" value="${source}" name="type">
        <input type="hidden" value="${source}" name="source">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl"/>
        <input type="hidden" name="ywlx" id="ywlx"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
