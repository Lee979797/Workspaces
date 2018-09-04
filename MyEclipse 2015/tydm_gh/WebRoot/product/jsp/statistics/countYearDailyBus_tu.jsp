<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="bzjgMap" value="<%=InitSysParams.zrxzqhMap%>"/>
<c:set var="typeMap" value="<%=InitSysParams.optTypeMap%>"/>
<%
    String[] colorArray = {"00", "11", "22", "33",
            "44", "55", "66", "77",
            "88", "99", "AA", "BB",
            "CC", "DD", "EE", "FF",};
    String[] types = {"年检", "换证", "新办", "发证", "注销", "变更"};
    String[] key_types = {"type2", "type6", "type1", "typem", "type8", "type3"};
    String[] colors =
            {"#ee4339",
                    "#eed236",
                    "#a7ee70",
                    "#36abee",
                    "#a244ea",
                    "#e33fc7"
            };
%>
<c:set var="colors" value="<%=colors%>"/>
<c:set var="types" value="<%=types%>"/>
<c:set var="type_keys" value="<%=key_types%>"/>

<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script src="/js/codebase/dhtmlxchart_debug.js" type="text/javascript"></script>
    <link rel="STYLESHEET" type="text/css" href="/js/codebase/dhtmlxchart_debug.css">
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <style>
        .dhx_chart_title {
            padding-left: 3px
        }
    </style>
    <script>
        var json;
        window.onload = function () {
            <c:forEach  var="modelMap" varStatus="status"  items="${types}">
            <c:if test="${status.count eq 1}">
            var barChart = new dhtmlXChart({
                view:"spline",
                container:"chart_container",
                value:"#${type_keys[status.index]}#",
                item:{
                    borderColor:"${colors[status.index]}",
                    color:"#ffffff"
                },
                line:{
                    color:"${colors[status.index]}",
                    width:3
                },
                tooltip:{
                    template:"#${type_keys[status.index]}#"
                },
                offset:0,
                xAxis:{
                    template:"#year#"
                },
                yAxis:{
                    title:"数据量"
                },
                legend:{
                    layout:"x",
                    width:75,
                    align:"center",
                    valign:"bottom",
                    marker:{
                        type:"round",
                        width:15
                    },
                    values:[
                        <c:forEach var="type" varStatus="tp" items="${types}">
                        {
                            text:"${type}",
                            color:"${colors[tp.index]}"
                        },
                        </c:forEach>
                        {}
                    ]
                }
            });
            </c:if>
            <c:if test="${status.count ne 1}">
            barChart.addSeries({
                value:"#${type_keys[status.index]}#",
                item:{
                    borderColor:"${colors[status.index]}",
                    color:"#ffffff"
                },
                line:{
                    color:"${colors[status.index]}",
                    width:3
                },
                tooltip:{
                    template:"#${type_keys[status.index]}#"
                }
            });

            </c:if>
            </c:forEach>
            barChart.parse(json.value, "json");
        }
        function zhutu() {
            document.getElementById("chart_pie").style.display = "none";
            document.getElementById("chart_container").style.display = "block";
        }
        function changeType() {
            document.getElementById("chart_container").style.display = "none";
            document.getElementById("chart_pie").style.display = "block";
        }

    </script>

</head>
<body>
<div class="page_top">
    <div align="right" style=" float: right;">
        <input type="button" class="newBtn1" onclick="window.location.href='/bsweb/jsp/statistics_countYearDailyBus'"
               name="test" value="返 回"/>&nbsp;
    </div>
    ${title}
</div>
<input type="hidden" name="json" value="[" id="json"/>
<script type="text/javascript">
    json = document.getElementById("json");

</script>
<script type="text/javascript">

    <c:forEach  var="mapMap"  items="${mapMap}">
    <c:forEach  var="modelMap"  items="${mapMap.value}">
    json.value += '{xzqh:"${fn:trim(bzjgMap[mapMap.key])}",year:"${modelMap.key}",';
    <c:forEach  var="model" varStatus="status" items="${modelMap.value}">
    json.value += '"type${fn:trim(model.column2)}":"${model.count1}",';
    </c:forEach>
    json.value = json.value.substr(0, json.value.lastIndexOf(",")) + '},';
    </c:forEach>
    </c:forEach>

</script>
<script type="text/javascript">
    json.value = json.value.substr(0, json.value.lastIndexOf(",")) + "]";
</script>
<div id="chart_container"
     style="width:90%;height:300px;border:1px solid #A4BED4;float:left;margin-right:20px;"></div>
</body>
</html>