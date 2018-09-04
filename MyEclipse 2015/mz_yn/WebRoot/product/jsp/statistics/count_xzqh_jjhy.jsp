<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<c:set var="njjhyMap" value="<%=InitSysParams.njjhyMap%>"/>
<c:set var="njjhyBigMap" value="<%=InitSysParams.njjhyBigMap%>"/>
<c:set var="jjlxMap" value="<%=InitSysParams.jjlxMap%>"/>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>

    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
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
                var axisType = new Axis("行政区划");
                var axisZone = new Axis("${columnName}");
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
                <c:forEach  var="model" items="${models}">
                index = hasElement(type_keys, '${model.column1}');
                if (index == -1) {
                    if (index > 1) {
                        gastaxDataVortex.setValue(metricAccounts, "查看信息图", [type_values[index - 1], axisZone.makeNewBucket("查看信息图")]);
                    }
                    tp = axisType.makeNewBucket("${bzjgMap[fn:trim(model.column1)]}");
                    type_values.push(tp);
                    type_keys.push('${model.column1}');
                } else {
                    tp = type_values[index];
                }
                <c:if test="${type eq true}">

                <c:set var="dm" value="${fn:trim(model.column2)}"/>
                <c:set var="mc" value="${njjhyBigMap[dm]}"/>
                index = hasElement(zone_keys, '${dm}');
                if (index == -1) {
                    zone = axisZone.makeNewBucket("${mc}");
                    zone_values.push(zone);
                    zone_keys.push('${dm}');
                } else {
                    zone = zone_values[index];
                }
                </c:if>
                <c:if test="${type eq null or !type}">
                <c:set var="fl" value="${model.column3}"/>
                <c:set var="mc" value="${fl}"/>
                index = hasElement(zone_keys, 'fl_${fl}');
                if (index == -1) {
                    zone = axisZone.makeNewBucket("${mc}");
                    zone_values.push(zone);
                    zone_keys.push('fl_${fl}');
                } else {
                    zone = zone_values[index];
                }
                </c:if>

                //gastaxDataVortex.setValue(metricAccounts, $/{model.count1}, [tp, zone]);

                <c:if test="${(model.count1> 0 and fn:length(dm)<5)}">
                gastaxDataVortex.setValue(metricAccounts, '<a href="#" onclick="goto(\'${dm}\',\'${fn:trim(model.column1)}\',\'${fn:trim(model.column3)}\')">${model.count1}</a>', [tp, zone]);
                </c:if>
                <c:if test="${!(model.count1> 0 and fn:length(dm)<5)}">
                gastaxDataVortex.setValue(metricAccounts, '${model.count1}', [tp, zone]);
                </c:if>
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
        </script>
        <script type="text/javascript" src="/product/jsp/statistics/pivotTable/pivot_table.js"></script>
    </c:if>
    <script type="text/javascript">
        function goto(jjhy, xzqh, njjhy) {
            document.getElementById("njjhy").value = njjhy;
            document.getElementById("jjhy").value = jjhy;
            document.getElementById("xzqh").value = xzqh;
            document.getElementById("type").value = true;
            document.searchForm.submit();
        }
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

</head>
<body>
<div class="page_top">
    <div align="right" style="float: right;display:inline-block;">
        <input type="button" class="newBtn1"
               onclick="exportThis(true)" name="下载"
               style="" value="下载"/>
        &nbsp;
        <c:if test="${source eq 'jglx'}">
            <input type="button" class="newBtn1"
                   onclick="window.location.href='/bsweb/jsp/statistics_monthCounsc_xzqh_jglx_tu'" name="查看信息图"
                   style="" value="信息图"/>
            &nbsp;&nbsp;
        </c:if>
    </div>
    ${title}

</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_counsc_xzqh_${source}.action">
        <input type="hidden" name="source" value="${source}" id="source"/>
        <input type="hidden" name="type" value="false" id="type"/>
        <input type="hidden" name="jgdm.jjhy" id="jjhy"/>

        <div class="list_box_top" style="border: 1px;">
            行政区划：
            <select name="jgdm.xzqh" class="input_200" id="xzqh">
                <option value="*"></option>
                <c:forEach var="type" items="${bzjgMap}">
                    <option value="${type.key}" ${type.key eq jgdm.xzqh?"selected":""}>
                            ${type.value} </option>
                </c:forEach>
            </select>&nbsp;产业类型：
            <c:set var="types" value=""/>
            <c:set var="lx" value="${jgdm.jjhy}"/>
            <select name="jgdm.njjhy" id="njjhy">
                <option value="*"></option>
                <option ${jgdm.njjhy eq '第一产业'?'selected':''} value="第一产业">第一产业</option>
                <option ${jgdm.njjhy eq '第二产业'?'selected':''} value="第二产业">第二产业</option>
                <option ${jgdm.njjhy eq '第三产业'?'selected':''} value="第三产业">第三产业</option>
            </select>&nbsp;<input name="search" type="button" onclick="return exportThis(false);" class="newBtn1" id="btn1"
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
