<%@ page import="com.ninemax.jpa.code.model.SmTaskType" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="startDate" type="java.util.Date"--%>
<%--@elvariable id="endDate" type="java.util.Date"--%>
<%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
<%--@elvariable id="task" type="com.ninemax.jpa.code.model.TSmrw"--%>
<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="tasks" type="java.util.List<com.ninemax.jpa.code.model.TSmrw>"--%>
<%--@elvariable id="smrwwcs" type="java.util.List<com.ninemax.jpa.code.model.TSmrwwc>"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>收件列表</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
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
    <script type="text/javascript" src="/js/page.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#jgdm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		Page.verify();
		}
	   }
	</script>
    <script type="text/javascript">
        function fCheckValue(jgdm) {
            document.thisForm.mc.value = jgdm;
            dwr.engine.setAsync(false);
            flag = checkJgdmCode(jgdm) && checkValidate(jgdm);
        }
        function checkValidate(jgdm) {
            var bzjgdm = document.thisForm.bzjgdm.value;
            var source = document.getElementById("source").value;
            if (source != "unvalidate") {
                if (!checkJgdmWithBzjgdm(jgdm, bzjgdm)) {
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
                        ymPrompt.alert({message: vs[1], handle: handler});
                        b = false;
                    } else {
                        b = true;
                    }
                });
                if (b)
                    document.thisForm.submit();
                return false;
            }
            if (source == "update") {
                if (needAudia(jgdm, "bgsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            if (source == "unvalidate") {
                if (needAudia(jgdm, "fzhfsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }
            }
            if (source == "validate") {
                if (needAudia(jgdm, "fzsh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            if (source == "delete") {
                if (needAudia(jgdm, "deletesh")) {
                    return true;
                } else {
                    document.thisForm.submit();
                }

            }
            return true;
        }
    </script>
</head>
<c:set var="bzjgdmMap" value="<%=InitSysParams.zrxzqhMap%>"/>
<body>
<div class="page_top">收件 &gt;&gt; 收件管理 &gt;&gt;收件列表查询 


</div>
<div id="list_main">
<form name="searchForm" method="post" action="/bsweb/conAction_list.action">
<input type="hidden" value="list" id="source" name="source">


<div class="list_box_top">
    <label for="jgdm">机构代码：</label>
    <input type="text" name="consignee.jgdm" size="13" id="jgdm" maxlength="9" value="${consignee.jgdm}"
           class="input_120">
    &nbsp;
    <label for="jgdm">机构名称：</label>
    <input type="text" name="consignee.jgmc" size="13" id="jgmc" maxlength="9" value="${consignee.jgmc}"
           class="input_120">
    &nbsp;
       <label for="jgdm">收件人：</label>
    <input type="text" name="consignee.consigneeName" size="13" id="jgmc" maxlength="9" value="${consignee.consigneeName}"
           class="input_120">
    &nbsp;
       <label for="jgdm">办证机构代码：</label>
    <input type="text" name="consignee.bzjgdm" size="13" id="jgmc" maxlength="9" value="${consignee.bzjgdm}"
           class="input_120">
    &nbsp;
    

    <input name="button2" type="button" class="newBtn1" id="btn" value="查 询"
           onclick="Page.verify();"/>
        <INPUT class="newBtn1" onClick="javascript:window.location.href='/product/jsp/consignee/addconsignee.jsp'" 
    type=button value="新增" name="btok"/>
</div>
<div class="list_box">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    
         <tr class="list_table_top">
            <td class="list_table_top_td" style="width:5%">序号</td>
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
                <div style="float:left">收件时间</div>
                <div class="jt_box" style="float:right">
                    <a href="#"
                       onclick="Page.sort('consigneeTime','${(page.orderByField eq 'consigneeTime' and page.orderByType eq 'asc')?'desc':'asc'}')">
                        <img src="../images/${(page.orderByField eq 'consigneeTime' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                             width="16" height="16" title="排序字段"/></a>
                </div>
            </td>
            <td class="list_table_top_td">
                <div style="float:left">收件人</div>
                <div class="jt_box" style="float:right">
                    <a href="#"
                       onclick="Page.sort('consigneeName','${(page.orderByField eq 'consigneeName' and page.orderByType eq 'asc')?'desc':'asc'}')">
                        <img src="../images/${(page.orderByField eq 'consigneeName' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                             width="16" height="16" title="排序字段"/></a>
                </div>
            </td>
            <td class="list_table_top_td">
                <div style="float:left">办证机构代码</div>
                <div class="jt_box" style="float:right">
                    <a href="#"
                       onclick="Page.sort('bzjgdm','${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                        <img src="../images/${(page.orderByField eq 'bzjgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                             width="16" height="16" title="排序字段"/></a>
                </div>
            </td>
                   <td class="list_table_top_td">
                <div style="float:left">缴款单号</div>
                <div class="jt_box" style="float:right">
                    <a href="#"
                       onclick="Page.sort('jkdh','${(page.orderByField eq 'jkdh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                        <img src="../images/${(page.orderByField eq 'jkdh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                             width="16" height="16" title="排序字段"/></a>
                </div>
            </td>
             <td class="list_table_top_td" align="center">查看</td>
            </tr>
 

        
        <c:forEach varStatus="i" var="rw" items="${conList}">
            <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                <td>&nbsp;${i.count }</td>
                <td>${rw.jgdm}</td>
                <td>${rw.jgmc}</td>
                <td>${rw.consigneeTime} </td>
                <td>${rw.consigneeName} </td>
                <td>${rw.bzjgdm} </td>
                <td>${rw.jkdh} </td>
               
                <td align="center">
                <a href="/bsweb/conAction_search.action?consignee.lsh=${rw.lsh}">
                            <img src="/product/images/icon_chakan.gif" width="16"
                                 height="16"
                                 
                                 style="cursor:pointer;" title="${title}"/></a>
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
