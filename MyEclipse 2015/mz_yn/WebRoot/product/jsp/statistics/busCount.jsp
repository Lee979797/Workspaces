<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Calendar" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="typeMap" value="<%=InitSysParams.optTypeMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript" src="/product/jsp/statistics/pivotTable/data_vortex.js"></script>
    <link rel="stylesheet" type="text/css" href="/product/jsp/statistics/pivotTable/pivot_table.css"/>
    <script type="text/javascript" src="/js/page.js"></script>
    <c:if test="${! empty models}">
        <script type="text/javascript">
            function hasElement(arr, key) {
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i] == key) {
                        return i;
                    }
                }
                return -1;
            }
            function makeGastaxDataVortex() {
                var metricAccounts = new Metric("Test", Datatype.STRING);

                // Axes
                var axisType = new Axis("${columnName}");
                var axisZone = new Axis("业务类型");
                // var axisform = new Axis("表单");
                var type_keys = new Array();
                var type_values = new Array();
                var zone_keys = new Array();
                var zone_values = new Array();
                var tp;
                var zone;
                var index;
                var gastaxDataVortex = new DataVortex([axisType, axisZone]);
                gastaxDataVortex.metricList.push(metricAccounts);
                // var num_date = axisform.makeNewBucket("业务量");
                // var rate_date = axisform.makeNewBucket("业务比例");

                tp = axisType.makeNewBucket("${columnName}");
                <c:forEach  var="model" items="${models}">
                index = hasElement(zone_keys, '${model.column1}');
                if (index == -1) {
                    zone = axisZone.makeNewBucket("${typeMap[fn:trim(model.column1)]}");
                    zone_values.push(zone);
                    zone_keys.push('${model.column1}');
                } else {
                    zone = zone_values[index];
                }
                gastaxDataVortex.setValue(metricAccounts, ${model.count1}, [tp, zone]);
                </c:forEach>
                return gastaxDataVortex;
            }

            function _onLoad() {
                elementMainArea = document.getElementById("mainArea");
                numberOfCallsToDebug = 0;
                var gastaxVortex = makeGastaxDataVortex();
                var gastaxPivot = new PivotTable("tableOne", gastaxVortex, [gastaxVortex.axisList[0]], [gastaxVortex.axisList[1]]);
                gastaxPivot.display();
            }
            function displayObjectInDebugTextarea(someObject) {
                var outputText = "";
                for (var i in someObject) {
                    outputText += i + " == " + someObject[i] + "\n";
                }
                displayDebugText(outputText);
            }
            function displayDebugText(someText) {
                numberOfCallsToDebug++;
                if (numberOfCallsToDebug > 20) {
                    return;
                }
                var elementDebugOutput = document.getElementById("debugOutput");
                elementDebugOutput.value += someText + "\n\n============================\n\n";
                elementDebugOutput.style.visibility = "visible";
                elementDebugOutput.style.display = "block";
            }
            window.onload = _onLoad;
            window.onerror = displayObjectInDebugTextarea;
            function exportThis(flag) {
                if (flag) {
                    document.getElementById("source").value = "export";
                    document.searchForm.submit();
                } else {
                    document.getElementById("source").value = "${source}";
                    Page.verify();
                }


            }
        </script>
        <script type="text/javascript" src="/product/jsp/statistics/pivotTable/pivot_table.js"></script>
    </c:if>
</head>
<body>

<div class="page_top">
    <div align="right" style="float: right;display:inline-block;">
        <input type="button" class="newBtn1"
               onclick="exportThis(true)" name="下载"
               style="" value="下载"/>
        &nbsp;
    </div>
    ${title}
</div>
<div id="list_main" align="">
    <form name="searchForm" method="post" action="/bsweb/statistics_${source}BusCount.action">
        <input type="hidden" name="totalPage" value="${totalPage }" id="totalPages"/>
        <input type="hidden" name="currentPage" value="${currentPage }" id="currentPage"/>
        <input type="hidden" name="pageSize" value="${pageSize }" id="pageSize"/>
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }" id="jgmc"/>
        <input type="hidden" name="source" value="${source}" id="source"/>

        <div class="list_box_top" style="border: 1px;">
            <c:if test="${startDate!=null}">
                时间：
                <INPUT name="startDate" id="startDate" onclick="WdatePicker({el:$dp.$('startDate')});"
                       value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>"
                       class="input_120"/>
                <A hideFocus onclick="WdatePicker({el:$dp.$('startDate')});" href="javascript:void(0)">
                    <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
                </A>&nbsp;</c:if>
            <c:if test="${year!=null}">
                <select name="year">
                    <% Integer year = (Integer) request.getAttribute("year");
                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        for (int i = currentYear - 10; i <= currentYear; i++) {
                    %>
                    <option value="<%=i%>" <% if (i == year) out.print("selected"); %>><%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>&nbsp;年
                <select name="month">
                    <% Integer month = (Integer) request.getAttribute("month");
                        for (int i = 1; i <= 12; i++) {
                    %>
                    <option value="<%=i%>" <% if (i == month) out.print("selected"); %>><%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>&nbsp;月&nbsp;</c:if>
                
                                        &nbsp;机构类型：
               <select name="jgdm.jglx" id="type">
                    <option value="*">全部</option>
                    <c:forEach var="type" items="${jglxMap}">
                        <option value="${type.key}" ${type.key eq jgdm.jglx?"selected":""}>${type.value} </option>
                    </c:forEach>
                </select>
            <input name="search" type="button" onclick="return exportThis(false);" class="newBtn1" id="btn1"
                   value="统  计"/>

        </div>
        <c:if test="${! empty models}">
            <div id="mainArea">
                <div id="tableOne">
                </div>
                <div id="tableTwo">
                </div>
                <div id="tableThree">
                </div>
                <div id="tableFour">
                </div>
            </div>
        </c:if>
        <c:if test="${ empty models}">
            <strong style="margin-left: 100px; margin-top:20px;margin-bottom: 20px; text-align: center;">查询的数据不存在！</strong>
        </c:if>
    </form>
    <form action="/bsweb/statistics_show_dm.action" name="showForm">
        <input type="hidden" name="jgdm.jgdm" id="jgdm"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
