<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript">

        function fGetName(name, value) {
            dwr.engine.setAsync(false);

            zrxzqhBus.findByDm(value, function (data) {
                if (data != null) {
                    document.getElementById("zrxzqh").value = value;
                    document.getElementById("zrxzqhmc").innerText = data.mc;
                } else {
                    document.getElementById("zrxzqh").value = "";
                    document.getElementById("zrxzqhmc").innerText = "";
                }
            });
            document.getElementById("zrxzqh").value = value;
        }
        function fPopUpWindow(name) {
            var strPage = "/bsweb/select_search.action?source=" + name;
            viewSubFeeDetail(strPage, name);
        }

        function viewSubFeeDetail(feeId, name) {
            ymPrompt.win({message: feeId, handler: callBack, width: 630, height: 460, dragOut: false, title: '信息查询', iframe: true});
        }
        function callBack(tp) {
            if (tp != 'close' && tp != '') {
                var values = tp.split(';');
                var dms = values[0].split(':');
                var mcs = values[1].split(":");
                document.getElementById("zrxzqh").value = dms[0];
                document.getElementById("zrxzqhmc").innerText = mcs[0];
            }
        }
        function checkAll() {
            var jgdms = document.getElementsByName("checkedJgdms");
            var sel = document.getElementById("checkJgdm");
            if (sel.checked == true) {
                for (var i = 0; i < jgdms.length; i++) {
                    jgdms[i].checked = true;
                }
            } else {
                for ( i = 0; i < jgdms.length; i++) {
                    jgdms[i].checked = false;

                }
            }

        }
        function fCheckValue() {

            var checkIdObj = eval("searchForm.checkedJgdms");
            var sns = document.getElementById("sns");
            //判断对象是否为空
            if (checkIdObj == null) {
                ymPrompt.alert({message: "请先选择需要对比的记录！", width: 330, height: 220, title: '提示信息'});
                return false;
            }
            var flag = false;
            //如果check列表对象多于一个
            if (checkIdObj.length && checkIdObj.length>=2) {
                for (var i = 0; i < checkIdObj.length; i++) {
                    if (checkIdObj[i].checked) {
                        sns.value += checkIdObj[i].value + ",";
                        flag = true;
                    }
                }
            } else {
                if (checkIdObj.checked) {
                    sns.value = checkIdObj.value;
                    flag = true;
                }
            }
            if (flag) {
                frmThis.submit();
                return true;
            } else {
                ymPrompt.alert({message: "请先选择记录！", width: 330, height: 220, title: '提示信息'});
                return false;
            }

        }

    </script>
</head>
<c:set var="bzjgMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<body>
<div class="page_top">${title}

</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/statistics_list_bgks">
        <div class="list_box_top" style="border: 1px;">
            <label for="jgdm">机构代码：</label>
            <input type="text" name="jgdm.jgdm" id="jgdm" size="27" maxlength="26" class="input_120">
            &nbsp;
            <input name="search" type="button" onclick="return Page.verify();" class="newBtn1" id="btn1" value="查 询"/>
            &nbsp;
            <input type="button" name="save" value="对比" onClick="return fCheckValue();" class="btn2"/>
        </div>

        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    >
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="vertical-align: middle;width: 3%" align="center">
                        选择
                    </td>
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">机构类型</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jglx','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">法人代表</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('fddbr','${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'fddbr' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>

                </tr>

                <c:forEach varStatus="i" var="dm" items="${jgdms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td align="center"><input type="checkbox" name="checkedJgdms" value="${dm.jgdm}">
                        </td>
                        <td>&nbsp;${i.count }</td>
                        <td>${dm.jgdm }</td>
                        <td>${dm.jgmc }</td>
                        <td>${jglxMap[dm.jglx] }</td>
                        <td> ${dm.fddbr}</td>

                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form method="POST" name='frmThis' action="/bsweb/statistics_show_diff.action">
        <input type="hidden" name="sns" id="sns"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
