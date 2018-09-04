<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="dmmcs" type="java.util.List<com.ninemax.jpa.code.model.Model>"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-5-20
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>信息结果</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="/css/csstable.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/page_common.js'></script>
    <script type="text/javascript">
        ymPrompt.setDefaultCfg({showMask: false});
        function giveValue(dm) {
            window.parent.ymPrompt.doHandler("${source};" + dm, true);
        }
    </script>
</head>
<body>
<form name="searchForm" method="post" action="/bsweb/select_result.action" onsubmit="return checkForm();">
    <input type="hidden" name="source" value="${source}" id="source"/>
    <input type="hidden" name="mc" value="${mc}" id="mc"/>
    <input type="hidden" name="filter" value="${filter}"/>

    <div class="list_box" style="height:100%;">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td width="10%">
                    <div style="float:left">代码</div>
                </td>
                <td width="20%">
                    <div style="float:left">名称</div>
                </td>
                <c:if test="${source eq 'nnjjhy'}">
                 <td width="50%">
                    <div style="float:left">备注</div>
                </td>
                </c:if>
                <td width="5%">
                    <div style="float:left">添加</div>
                </td>
            </tr>
            <c:forEach varStatus="i" var="dm" items="${dmmcs}">
                <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                    <td>${dm.column1}</td>
                    <td><a onclick="giveValue('${dm.column1}');" style="cursor: pointer;"> ${dm.column2} </a>
                    </td>
                     <c:if test="${source eq 'nnjjhy'}">
	                 <td><a onclick="giveValue('${dm.column1}');" style="cursor: pointer;"> ${dm.column3} </a>
	                 </c:if>
                    <td><a onclick="giveValue('${dm.column1}');" style="cursor: pointer;">
                        <img src="/images/select.gif" style="cursor:pointer;" alt="添加"></a></td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="../common/pageCommon.jsp"/>
    </div>
</form>
</body>
</html>