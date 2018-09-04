<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="jglxMap" value="<%=InitSysParams.jglxMap%>"/>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�û���˹���</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript" src="/product/jsp/statistics/pivotTable/data_vortex.js"></script>
    <link rel="stylesheet" type="text/css" href="/product/jsp/statistics/pivotTable/pivot_table.css"/>
    <c:if test="${ ! empty modelMaps}">
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
                var axisZone = new Axis("��������");
                var axisType = new Axis("���ݿ�");

                //     var axisform = new Axis("������");
                var type_keys = new Array();
                var type_values = new Array();
                var zone_keys = new Array();
                var zone_values = new Array();
                var tp;
                var zone;
                var index;
                var gastaxDataVortex = new DataVortex([ axisZone, axisType]);
                gastaxDataVortex.metricList.push(metricAccounts);
                //   var num_date = axisform.makeNewBucket("ҵ����");
                // var rate_date = axisform.makeNewBucket("ҵ�����");
                <c:forEach  var="map" items="${modelMaps}">
                index = hasElement(type_keys, '${map.key}');
                if (index == -1) {
                    tp = axisType.makeNewBucket("${map.key=='t_jgdm'?'����':map.key=='t_fzdm'?'ע����':'��Ч��'}");
                    type_values.push(tp);
                    type_keys.push('${map.key}');
                } else {
                    tp = type_values[index];
                }
                <c:forEach var="model" items="${map.value}">
                index = hasElement(zone_keys, '${model.column1}');
                if (index == -1) {
                    zone = axisZone.makeNewBucket("${bzjgMap[fn:trim(model.column1)]}");
                    zone_values.push(zone);
                    zone_keys.push('${model.column1}');
                } else {
                    zone = zone_values[index];
                }
                //gastaxDataVortex.setValue(metricAccounts, $/{model.count1}, [tp, zone]);
                gastaxDataVortex.setValue(metricAccounts, ${model.count1}, [tp, zone]);
                </c:forEach>

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
               onclick="exportThis(true);" name="����"
               style="" value="����"/>
        &nbsp;
    </div>
    ${title}
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_countCodeBase_xzqh.action">
        <input type="hidden" name="totalPage" value="${totalPage }" id="totalPages"/>
        <input type="hidden" name="currentPage" value="${currentPage }" id="currentPage"/>
        <input type="hidden" name="pageSize" value="${pageSize }" id="pageSize"/>
        <input type="hidden" name="jgdm.jgmc" value="${jgdm.jgmc }" id="jgmc"/>
        <input type="hidden" name="source" value="${source}" id="source"/>

        <div class="list_box_top" style="border: 1px;">
         &nbsp;���ݿ⣺
            <select name="database" class="input_120">
                <option value="*">ȫ��</option>
                <option value="t_jgdm" ${database eq 't_jgdm'?"selected":""}>��Ч��</option>
                <option value="t_fzdm" ${database eq 't_fzdm'?"selected":""}>ע����</option>
               <%-- <option value="t_ljdm" ${database eq 't_ljdm'?"selected":""}>��Ч�����</option>--%> 

            </select>&nbsp;�������ͣ�
               <select name="jgdm.jglx" id="type">
                    <option value="*">ȫ��</option>
                    <c:forEach var="type" items="${jglxMap}">
                        <option value="${type.key}" ${type.key eq jgdm.jglx?"selected":""}>${type.value} </option>
                    </c:forEach>
                </select>&nbsp;
            <input name="search" type="button" onclick="return exportThis(false);" class="newBtn1" id="btn1"
                                  value="ͳ  ��"/>
        </div>
        <c:if test="${ ! empty modelMaps}">
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
        <c:if test="${ empty modelMaps}">
            <strong style="margin-left: 100px; margin-top:20px;margin-bottom: 20px; text-align: center;">��ѯ�����ݲ����ڣ�</strong>
        </c:if>
    </form>
    <form action="/bsweb/statistics_show_dm.action" name="showForm">
        <input type="hidden" name="jgdm.jgdm" id="jgdm"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
