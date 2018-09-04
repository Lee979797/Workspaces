<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.Page" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdmSave" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="show" value="<%=Page.AttributeType.show%>"/>
<c:set var="sort" value="<%=Page.AttributeType.sort%>"/>
<c:set var="opt" value="<%=Page.AttributeType.opt%>"/>
<c:set var="nnjghyMap" value="<%=InitSysParams.jjhy2k1Map%>"/>
<c:set var="nnjjlxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njglxMap" value="<%= InitSysParams.njglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgdmMap%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
        function exportExcel() {
            document.getElementById("export").disabled = "disabled";
            document.getElementById("back").disabled = "disabled";
            document.exportForm.submit();
        }
    </script>
</head>
<c:set var="dmsave" value="<%=TJgdmSave.class.getName()%>"/>
<body>
<div class="page_top">
    <div align="right" style=" float: right;">
        <input class="newBtn1" type="button" value="返 回" id="back"
               onclick=" window.location.href='/bsweb/statistics_search?source=${source eq 'show_mc'?'bymc':'multitype'}'"/>&nbsp;
    </div>
    ${title}
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_${source}.action">
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }" id="jgmc"/>
        <input type="hidden" name="sqlwhere" value="${sqlwhere }" id="sqlwhere"/>
        <input type="hidden" name="order" value="${order }" id="order"/>
        <input type="hidden" name="database" value="${database }" id="database"/>
        <c:forEach varStatus="status" items="${fields}" var="field">
            <input type="hidden" name="fields[${status.index}].dm"
                   value="${field.dm}"/>
            <input type="hidden" name="fields[${status.index}].name"
                   value="${fn:trim(field.name)}"/>
            <input type="hidden" value="${field.select}"
                   name="fields[${status.index}].select"/>

        </c:forEach>

        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <c:forEach var="attribute" items="${page.showAttributes}">
                        <td class="list_table_top_td"
                            style="width: ${(attribute.dm eq 'jgmc' or attribute.dm eq 'jyfw' or attribute.dm eq 'jgdz' or attribute.dm eq 'cycp3' or attribute.dm eq 'cycp2'or attribute.dm eq 'zycp1' )?'20%':'8%'}">
                            <div style="float:left">${attribute.mc}</div>
                        </td>
                    </c:forEach>
                    <td class="list_table_top_td" align="center" style="width: 3%">查看</td>
                </tr>
                <c:forEach varStatus="i" var="map" items="${page.dataMaps}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <c:forEach var="attribute" items="${page.showAttributes}">

                            <c:if test="${attribute.lx ne opt}">
                                <td>
                                    <c:choose>
                                        <c:when test="${attribute.dm eq 'pzjgdm'}">
                                            ${pzjgMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'jglx'}">
                                            ${jglxMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'njglx'}">
                                            ${njglxMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'jjlx'}">
                                            ${jjlxMap[fn:trim(map[attribute.dm])]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'njjlx'}">
                                            ${njjlxMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'nnjjlx'}">
                                            ${nnjjlxMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'jjhy'}">
                                            ${jjhyMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'njjhy'}">
                                            ${njjhyMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'nnjjhy'}">
                                            ${nnjghyMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'hbzl'}">
                                            ${hbMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'zjlx'}">
                                            ${zjlxMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'xzqh'}">
                                            ${xzqhMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'bzjgdm'}">
                                            ${zrxzqhMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'wftzgb'}">
                                            ${gjMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:when test="${attribute.dm eq 'zycp' or attribute.dm eq 'zycp1' or attribute.dm eq 'zycp2' or attribute.dm eq 'zycp3' }">
                                            ${zycpMap[map[attribute.dm]]}
                                        </c:when>
                                        <c:otherwise>
                                            ${ map[attribute.dm]}
                                        </c:otherwise>
                                    </c:choose>
                                    <c:if test="">

                                    </c:if>

                                </td>
                            </c:if>
                        </c:forEach>
                        <td align="center">
                            <img src="/product/images/icon_chakan.gif" width="16"
                                 height="16"
                                 onclick="Page.show('${database eq dmsave?map['id']: map['tyshxydm']}')"
                                 style="cursor:pointer;" title="查看"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form action="/bsweb/statistics_show_dm.action" name="showForm">
        <input type="hidden" name="jgdm.tyshxydm" id="jgdm"/>
        <input type="hidden" name="database" value="${database }"/>
        <input type="hidden" name="source" value="${source }"/>
    </form>
    <form action="/bsweb/statistics_export_multi.action" name="exportForm">
        <input type="hidden" name="sqlwhere" value="${sqlwhere }"/>
        <input type="hidden" name="order" value="${order }"/>
        <input type="hidden" name="database" value="${database }"/>
        <input type="hidden" name="source" value="${source }"/>
        <c:forEach varStatus="status" items="${fields}" var="field">
            <input type="hidden" name="fields[${status.index}].dm"
                   value="${field.dm}"/>
            <input type="hidden" name="fields[${status.index}].name"
                   value="${fn:trim(field.name)}"/>
            <input type="hidden" value="${field.select}"
                   name="fields[${status.index}].select"/>

        </c:forEach>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
