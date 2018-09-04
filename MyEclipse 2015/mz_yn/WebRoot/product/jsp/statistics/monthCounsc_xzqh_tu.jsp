<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="bzjgMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<%
    String[] colorArray = {"00", "11", "22", "33",
            "44", "55", "66", "77",
            "88", "99", "AA", "BB",
            "CC", "DD", "EE", "FF",};                 //定义一个颜色的字符串数组.
%>
<c:set var="colors" value="<%=colorArray%>"/>
<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script src="/js/codebase/dhtmlxchart_debug.js" type="text/javascript"></script>
    <link rel="STYLESHEET" type="text/css" href="/js/codebase/dhtmlxchart_debug.css">
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script>
        window.onload = function () {
            var json =${json};
            var barChart = new dhtmlXChart({
                view:"bar",
                container:"chart_container",
                label:"#value#",
                legend:"#chinese#",
                width:30,
                gradient:true,
                tooltip:{
                    template:"#value#"
                },
                xAxis:{
                    title:"<b> ${bzjgMap[jgdm.xzqh]}机构类型统计图</b>",
                    template:"#chinese#"
                },
                yAxis:{
                    title:"数据量"
                },
                gradient:true,
                border:false
            });
            barChart.attachEvent("onItemClick", function (id) {
                id = barChart.get(id).chinese;
                alert(id);
                return true;
            });

            barChart.parse(json, "json");
            var pieChart = new dhtmlXChart({
                view:"pie3D",
                container:"chart_pie",
                value:"#value#",
                legend:"#chinese#",
                pieInnerText:"#name#",
                shadow:0
            });
            pieChart.attachEvent("onMouseMove", function (id) {
                var item = pieChart.get(id);

                return hs.htmlExpand(item, { headingText:'剩余码段数量统计', content:item.chinese + ':' + item.value })
            });
            pieChart.attachEvent("onItemClick", function (id) {
                id = pieChart.get(id).chinese;
                alert(id);
                return true;
            });
            pieChart.parse(json, "json");
            document.getElementById("chart_pie").style.display = "none";
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
    <div align="right" style="width: 30% ; float: right;">
        <input type="button" class="newBtn1" onclick="zhutu()"
               name="test"
               value="柱状图"/>&nbsp;
        <input type="button" class="newBtn1" onclick="changeType();"
               name="test"
               value="饼 图"/>&nbsp;
        <input type="button" class="newBtn1" onclick="window.location.href='/bsweb/jsp/statistics_monthCounsc_xzqh_jglx'"
               name="test"
               value="返 回"/>&nbsp;</div>
    ${title}
</div>
<%--<script type="text/javascript">--%>
<%--<c:forEach  var="model" varStatus="staatus" items="${models}">--%>
<%--json.value += '{name:"${fn:trim(jglxMap[model.column2])}",value:${model.count1 },color:"#${ colors[staatus.count]}${ colors[staatus.count]}${ colors[staatus.count]}"},';--%>
<%--</c:forEach>--%>
<%--</script>--%>
<%--<script type="text/javascript">--%>
<%--json.value = json.value.substr(0, json.value.lastIndexOf(",")) + "]";--%>
<%--</script>--%>

<div id="chart_container"
     style="width:90%;height:300px;border:1px solid #A4BED4;float:left;margin-right:20px;"></div>
<div id="chart_pie"
     style="width:90%;height:300px;border:1px solid #A4BED4;float:left;margin-right:20px;"></div>
<form name="searchForm" method="post" action="/bsweb/statistics_monthCounsc_xzqh_${source}.action">
    <input type="hidden" name="jgdm.xzqh" value="" id="xzqh"/>
    <input type="hidden" name="jgdm.jjhy" value="" id="type"/>
</form>
</body>
<script type="text/javascript">
    function goto(type, xzqh, b) {
        document.getElementById("type").value = type;
        document.getElementById("xzqh").value = xzqh;
        document.getElementById("zuanq").value = b;
        document.searchForm.submit();
    }

</script>
</html>