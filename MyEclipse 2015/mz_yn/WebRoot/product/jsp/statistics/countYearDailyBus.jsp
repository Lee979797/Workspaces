<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>登记表查询</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <c:set var="typeMap" value="<%=InitSysParams.optTypeMap%>"/>
    <script type="text/javascript">
        function verifydate() {
            var reg = new RegExp(/[\d]{4}-([\d]{2})-([\d]{2})/);
            //  var reg = new RegExp(/[\d]{4}-(([\d])|(0[\d])|(1[12]))-((([\d])|([012][\d])|(3[01])))/);
            if (!reg.test(document.searchForm.startDate.value)) {
                document.searchForm.startDate.focus();
                ymPrompt.alert({message:"请输入正确格式的开始时间！fmt：yyyy-MM-dd", width:330, height:220, title:'提示信息'});
                return false;
            }
            if (!reg.test(document.searchForm.endDate.value)) {
                document.searchForm.endDate.focus();
                ymPrompt.alert({message:"请输入正确格式的结束时间！fmt：yyyy-MM-dd", width:330, height:220, title:'提示信息'});
                return false;

            }
            var current = document.getElementById("currentPage");
            if (current)
                current.value = 1;
            document.searchForm.submit();
            return true;
        }
        function modify(lsh) {
            document.getElementById("modify").value = lsh;
            document.modifyForm.submit();
        }
    </script>
    <script type="text/javascript" src="/product/jsp/statistics/pivotTable/data_vortex.js"></script>
    <link rel="stylesheet" type="text/css" href="/product/jsp/statistics/pivotTable/pivot_table.css"/>
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
                var axisZone = new Axis("业务类型");
                var axisForm = new Axis("年份");
                var type_keys = new Array();
                var type_values = new Array();
                var zone_keys = new Array();
                var zone_values = new Array();
                var year_keys = new Array();
                var year_values = new Array();
                var year;

                var tp;
                var zone;
                var index;
                var gastaxDataVortex = new DataVortex([axisType, axisZone, axisForm]);
                gastaxDataVortex.metricList.push(metricAccounts);
                // var num_date = axisform.makeNewBucket("业务量");
                // var rate_date = axisform.makeNewBucket("业务比例");
            <c:forEach  var="model" items="${models}">
                index = hasElement(type_keys, '${model.column1}');
                if (index == -1) {
                    tp = axisType.makeNewBucket("${bzjgMap[fn:trim(model.column1)]}");
                    type_values.push(tp);
                    type_keys.push('${model.column1}');
                } else {
                    tp = type_values[index];
                }
                index = hasElement(zone_keys, '${model.column2}');
                if (index == -1) {
                    zone = axisZone.makeNewBucket("${typeMap[fn:trim(model.column2)]}");
                    zone_values.push(zone);
                    zone_keys.push('${model.column2}');
                } else {
                    zone = zone_values[index];
                }
                index = hasElement(year_keys, '${model.column3}');
                if (index == -1) {
                    year = axisForm.makeNewBucket("${fn:trim(model.column3)}");
                    year_values.push(year);
                    year_keys.push('${model.column3}');
                } else {
                    year = year_values[index];
                }
                //gastaxDataVortex.setValue(metricAccounts, $/{model.count1}, [tp, zone]);
                gastaxDataVortex.setValue(metricAccounts, ${model.count1}, [year, tp, zone]);
            </c:forEach>
                return gastaxDataVortex;
            }

            function _onLoad() {
                elementMainArea = document.getElementById("mainArea");
                numberOfCallsToDebug = 0;
                var gastaxVortex = makeGastaxDataVortex();
                var gastaxPivot = new PivotTable("tableOne", gastaxVortex, [gastaxVortex.axisList[0]], [gastaxVortex.axisList[1], gastaxVortex.axisList[2]]);
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
        function validate() {
            if (Number(document.getElementById("year").value) > Number(document.getElementById("month").value)) {
                ymPrompt.alert({message:"结束年份不能大于开始年份！", width:330, height:220, handle:function () {
                    document.getElementById("month").focus();
                }});
                return false;
            } else {
                document.getElementById("source").value = "${source}";
                document.searchForm.submit();
                return true;
            }
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
    <div align="right" style=" float: right;">
        <input type="button" class="newBtn1"
               onclick="exportThis(true)" name="下载"
               style="" value="下载"/>
        &nbsp;
        <input type="button" class="newBtn1"
               onclick="window.location.href='/bsweb/jsp/statistics_countYearDailyBus_tu'" name="查看信息图"
               style="" value="信息图"/>
        &nbsp;
    </div>
    ${title}

</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_countYearDailyBus.action">
        <input type="hidden" name="source" value="${source}" id="source"/>
        <div class="list_box_top" style="border: 1px;">
            <select name="year" id='year'>
                <% Integer year = (Integer) request.getAttribute("year");
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    for (int i = currentYear - 10; i <= currentYear; i++) {
                %>
                <option value="<%=i%>" <% if (i == year) out.print("selected"); %>><%=i%>
                </option>
                <%
                    }
                %>
            </select>年&nbsp;至&nbsp;<select name="month" id="month">
            <% year = (Integer) request.getAttribute("month");
                for (int i = currentYear - 10; i <= currentYear; i++) {
            %>
            <option value="<%=i%>" <% if (i == year) out.print("selected"); %>><%=i%>
            </option>
            <%
                }
            %>
        </select>年&nbsp;行政区划：
            <select name="jgdm.xzqh" class="input_200">
                <option value="*"></option>
                <c:forEach var="type" items="${bzjgMap}">
                    <option value="${type.key}" ${type.key eq jgdm.xzqh?"selected":""}>
                            ${type.value} </option>
                </c:forEach>
            </select>&nbsp;<input name="search" type="button" onclick="validate();" class="newBtn1" id="btn1"
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
    <form action="/bsweb/certificateNumber_certBook.action" name="modifyForm">
        <input type="hidden" name="zs.lsh" id="modify"/>
    </form>

</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
