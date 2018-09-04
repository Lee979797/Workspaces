<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String jglx = (String) request.getAttribute("jglx");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<title>外网数据审核</title>
<link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>

<script type='text/javascript' src='/js/tools.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
<script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
<script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
<script type="text/javascript" src="/dwr/interface/gsBus.js"></script>
<script type="text/javascript" src="/js/jgdmSearch.js?v=${applicationScope.applicationModel.currentDate}"></script>

<script type="text/javascript">
function smartCardSearch() {
    ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
    var object = new ActiveXObject("ICCardCOM.ICCardInterface");
    var ret = object.ReadICCard();
    if (ret == 0) {
        ymPrompt.close();
        ymPrompt.alert("打开串口失败!错误原因：" + object.GetLastErrMsg());
        bHaveClicked = false;
        StatusDisp.innerHTML = "　　读卡失败!请先选择正确的端口号，再重试!";
        return;
    } else {
        document.getElementById("jgdm").value = object.JGDM.trim();
        ymPrompt.close();
        search();
        return;
    }
}
function cardSearch() {
    document.jgdmicread.nport = 1;//document.getElementById('listCom').value;
    ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});

    var rtn = document.jgdmicread.readcard(document.jgdmicread.nport);
    if (rtn == false) {
        ymPrompt.close();
        ymPrompt.alert({message: "打开串口失败!错误原因：" + document.jgdmicread.errorText,
            slideShowHide: false, width: 330, height: 220, title: '提示信息'});
        return;
    }
    document.getElementById("jgdm").value = document.jgdmicread.jgdm.trim();
    ymPrompt.close();
    search();
}
function search() {
    var obj = document.getElementById("jgdm");

    Page._curent(1);
    var jgdm = document.getElementById("jgdm").value;
    /* if (!/^[a-zA-Z0-9]+$/.test(jgdm)) {
        jgdm = jgdm.toUpperCase();
        obj.value = jgdm.replace(/[^a-zA-Z0-9]/gm, "");
        ymPrompt.alert({message: "请输入正确的机构代码！",
            slideShowHide: false, width: 330, height: 220, title: '提示信息'});
        return false;
    } */
    //fCheckValue(jgdm);
    
    Page._curent(1);
            //document.getElementById("jgdm").value ="";
            document.searchForm.submit();
    return false;
}
function checkValidate2(jgdm) {
    var bzjgdm = thisForm.bzjgdm.value;
    var source = document.getElementById("source").value;
    if (source != "unvalidate") {
        if (!checkJgdmWithBzjgdm(jgdm, bzjgdm,'${sysUser.userName}')) {
            return false;
        }
    } else {
        if (!checkFzdmExit(jgdm)) {
            return false;
        }
    }
    if (source == "check") {
        var b = false;
        kqnjBus.checkYear(jgdm, bzjgdm, function (value) {
            var vs = value.split(":");
            if ("false" == vs[0]) {
                ymPrompt.alert({message: vs[1], width: 330, height: 220, title: "提示信息"});
                b = false;
            } else {
                b = true;
            }
        });

        if (b)
            document.searchForm.submit();
        return false;

    }
    document.searchForm.submit();
    return true;
}
function fCheckValue(jgdm) {
    document.thisForm.mc.value = jgdm;
    var source1 = document.getElementById("source").value;
    var isOk = true;
    dwr.engine.setAsync(false);
    if (source1 == 'check' || source1 == 'update_no') {
        gsBus.isQiyeFindZch(jgdm, source1, function (value) {
            if (value != '' && value != 'null') {
                ymPrompt.win({message: '/product/jsp/dailybusiness/gsData.jsp?source=' + source1 + '&jgdm=' + jgdm + '&zch=' + value, width: 360, height: 180, title: '工商数据提取', handler: function (opt) {
                    if (opt == 'fsearch') {
                        checkJgdmCode(jgdm) && checkValidate(jgdm);
                    } else if (opt.indexOf("daoru") != -1) {
                        document.getElementById("dzch").value = opt.substring(opt.indexOf("|") + 1);
                        checkJgdmCode(jgdm) && checkValidate(jgdm);
                    } else if (opt == 'validate') {
                        document.getElementById("source").value = "validate";
                        thisForm.type.value = "validate";
                        thisForm.source.value = "validate";
                        checkJgdmCode(jgdm) && checkValidate(jgdm);
                    } else if (opt == 'changeCard') {
                        window.location.href = "/bsweb/certificate_search.action?jgdm=" + jgdm + "&source=certChange&bzjgdm=${sysUser.bzjgdm}&pageno=1&rowNumsView=1";
                    } else if (opt == 'goReturn') {
                        window.location.href = "/bsweb/business_list?source=update_no";

                    }
                }, iframe: true});
                isOk = false;
            }
        });
    }
    if (isOk) {
        flag = checkJgdmCode(jgdm) && checkValidate(jgdm);
    }
}
function checkValidate(jgdm) {
    dwr.engine.setAsync(false);
    var bzjgdm = thisForm.bzjgdm.value;
    var source = document.getElementById("source").value;
    document.getElementById("mc").value=jgdm;
    //if (source != "unvalidate") {
        //if (!checkJgdmWithBzjgdm(jgdm, bzjgdm,'${sysUser.userName}')) {
          //  return false;
        //}
    //} else {
        //if (!checkFzdmExit(jgdm)) {
            //return false;
        //}
   // }
    if (!ywkz(jgdm, source)) {
        return false;
    }
    if (source == "check") {
        var b = false;
        kqnjBus.checkYear(jgdm, bzjgdm, function (value) {
            var vs = value.split(":");
            if ("false" == vs[0]) {
                ymPrompt.alert({message: vs[1], width: 330, height: 220,
                    slideShowHide: false, title: '提示信息', handle: handler});
                b = false;
            } else {
                b = true;
            }
        });
        if (b) {
            var re1 = true;
            spBus.isAudiaAll(jgdm, '12', function (data) {
                var index = data.indexOf(":");
                var s1 = data.substring(0, index);
                var s2 = data.substring(index + 1, data.length);
                if (s1 == "0") {
                    document.thisForm.submit();
                    re1 = true;
                }
                if (s1 == "1") {
                    ymPrompt.alert({message: s2, width: 330, height: 220,
                        slideShowHide: false, title: '提示信息'});
                    re1 = false;
                }
            });
            return  re1;
        }

        return false;
    }
    if (source == "update") {
       // if (needAudia(jgdm, "17")) {

            //return true;
       // } else {
            document.thisForm.submit();
        //}

    }
    if (source == "update_no") {
        if (needAudia(jgdm, "bgsh")) {
				
            return true;
        } else {
            document.thisForm.submit();
            return true;
        }

    }
    if (source == "unvalidate") {
        if (needAudia(jgdm, "fzhfsh")) {
            return true;
        } else {
            document.thisForm.submit();
            return true;
        }
    }
    if (source == "validate") {
        //if (needAudia(jgdm, "fzsh")) {
            //return true;
       // } else {
            document.thisForm.submit();
            return true;
        //}

    }
    if (source == "validate2") {
        //if (needAudia(jgdm, "fzsh")) {
            //return true;
       // } else {
            document.thisForm.submit();
            return true;
        //}

    }
    if (source == "delete") {
        //if (needAudia(jgdm, "deletesh")) {
           // return true;
       // } else {
            document.thisForm.submit();
            return true;
       // }

    }
    return true;
}
function checkAll() {
    var jgdms = document.getElementsByName("checkedJgdms");
    var sel = document.getElementById("checkJgdm");
    if (sel.checked == true) {
        for (var i = 0; i < jgdms.length; i++) {
            jgdms[i].checked = true;
        }
    } else {
        for (var j = 0; j < jgdms.length; j++) {
            jgdms[j].checked = false;
        }
    }

}
function deleteAll() {

    var checkIdObj = eval("searchForm.checkedJgdms");
    var allJgdms = document.getElementById("allJgdms");
    //判断对象是否为空
    allJgdms.value = "";
    if (checkIdObj == null) {
        return false;
    }
    if (checkIdObj.length > 0) {


        for (var i = 0; i < checkIdObj.length; i++) {
            if (checkIdObj[i].checked) {
                allJgdms.value += checkIdObj[i].value + ",";
            }
        }
    } else if (checkIdObj.checked) {
        allJgdms.value = checkIdObj.value;
    }
    if (allJgdms.value != null && allJgdms.value != "") {
        if (confirm("确认注销所选机构？")) {
            document.deleteAllForm.submit();
            return true;
        } else {
            return false;
        }

    }
    ymPrompt.alert({message: "请先选择记录！", width: 330, height: 220, title: '提示信息'});
    return false;


}

function chesThis() {
    switch (event.keyCode) {
        case 13:
            search();
            return false;
        default:
            return true;
    }

}
window.onload = function () {
    document.getElementById("jgdm").focus();
}
window.onkeydown = chesThis;
<c:if test="${message ne null and message ne  ''}">
ymPrompt.alert({message: "${message}", slideShowHide: false, width: 330, height: 220, title: '提示信息'});
</c:if>
</script>
</head>
<body onkeydown="chesThis()">
<object scope="application" width="32" height="32" classid="CLSID:3EE0206D-697A-11D5-9BD3-00E01819D1CC"
        codebase="icocx/jgdmicread.cab" name="jgdmicread" style="display:None">
</object>
<div class="page_top">登记 &gt;&gt;   <%
  	if("1".equals(jglx)){
  %>  
    社会团体业务
    <%
  	}
    %>
    <%
  	if("2".equals(jglx)){
  %>  
    民办非企业单位业务
    <%
  	}
    %>
    <%
  	if("3".equals(jglx)){
  %>  
    基金会业务
    <%
  	}
    %> &gt;&gt;
    <c:if test="${source eq 'update_no'}">变更登记 </c:if>
     <c:if test="${source eq 'validate'}">注销登记 </c:if>
     <c:if test="${source eq 'validate2'}">撤销登记 </c:if>
     <c:if test="${source eq 'unvalidate'}">注销恢复</c:if>

</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/business_list.action">
        <input type="hidden" value="${source}" id="source" name="source">
		  <input type="hidden" name="jglx" value="<%=jglx %>">
        <div class="list_box_top">
            <label for="jgdm"> 统一代码/机构代码/机构名称：</label>
            <input type="text" name="jgdm.tyshxydm" size="13" id="jgdm" maxlength="18"
                   value="${jgdm.tyshxydm}"
                   class="input_200">
            &nbsp;<input name="button1" type="button" class="newBtn1" id="btn" value="查 询" onclick="search()"/>

            &nbsp;<input name="button2" type="button" class="newBtn1" id="btn3" value="浏 览" onclick="Page.all();"/>
            <c:if test="${source eq 'validate' and fn:substring(sysUser.bzjgdm,2 ,6 ) eq '0000' }">
                <%--   &nbsp;<input type="button" name="save" value="批量注销" onClick="javascript:return deleteAll();" class="btn2"/>--%>
            </c:if>
        </div>
        <div class="list_box">
            <c:set var="dms" value="${ (empty jgdms)?fzdms:jgdms }"/>

            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <c:if test="${source eq 'validate' and fn:substring(sysUser.bzjgdm,2 ,6 ) eq '0000'}">
                        <%--       <td class="list_table_top_td" align="center" style="width: 3%;">
                                   <input type="checkbox" onclick="checkAll()" id="checkJgdm"
                                          style="margin-top: 5px">
                               </td>--%>
                    </c:if>
                    <td class="list_table_top_td" style="width:3%">序号</td>
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">统一代码</div>
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
                    <td class="list_table_top_td" style="width:8%">
                        <div style="float:left;">发证机关</div>
                        <div class="jt_box" style="float:right">
                           
                        </div>
                    </td>
                    <td class="list_table_top_td" style="width:15%">
                        <div style="float:left">批准文号</div>
                        <div class="jt_box" style="float:right">
                         
                        </div>
                    </td>


                      
                        <c:if test="${source eq 'unvalidate1'}">
                    <td class="list_table_top_td" style="width:8%">
                            <div style="float:left">
                                注销人
                            </div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('fzr','${(page.orderByField eq 'fzr' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'fzr' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                    </td>
                        </c:if>


                    <td class="list_table_top_td" style="width:8%">
                        <c:if test="${source ne 'unvalidate'}">
                            <div style="float:left">办证日期</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </c:if>
                        <c:if test="${source eq 'unvalidate'}">
                            <div style="float:left">注销日期</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('fzrq','${(page.orderByField eq 'fzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'fzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </c:if>
                    </td>
                    <td class="list_table_top_td" align="center" style="width:5%">操作</td>

                </tr>
                <c:forEach varStatus="i" var="dm" items="${dms}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <c:if test="${source eq 'validate' and fn:substring(sysUser.bzjgdm,2 ,6 ) eq '0000'}">
                            <%--   <td align="center" style="width: 3%;">
                                   <input type="checkbox" name="checkedJgdms" value="${dm.jgdm}">
                               </td>--%>
                        </c:if>
                        <td>&nbsp;${i.count}</td>
                        <td>${dm.tyshxydm}</td>
                        <td>${dm.jgmc}</td>
                        <td>${dm.bzjgdm}</td>
                        <td>${dm.zch}</td>
                          
                            <c:if test="${source eq 'unvalidate0'}">
                        <td>
                                ${dm.fzr}
                        </td>
                            </c:if>
                        <td>
                            <fmt:formatDate value="${source ne 'unvalidate'?dm.bzrq:dm.fzrq}"/>
                        </td>
                        <td align="center">
                            <img src="/product/images/icon_shenhe.gif" width="16"
                                 height="16"
                                 onclick="checkValidate('${dm.tyshxydm}');"
                                 style="cursor:pointer;" title="${title}"/>
                                 
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
        <input type="hidden" value="${source}" name="source">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="jglx" value="<%=jglx %>">
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl"/>
        <input type="hidden" name="ywlx" id="ywlx"/>
        <!--------------------------------------->
        <input type="hidden" name="dzch" id="dzch"/>
    </form>
    <form method="post" name='deleteAllForm' action="/bsweb/business_validateAll.action">
        <input type="hidden" name="allJgdms" id="allJgdms">
        <input name="mc" type="hidden" id="mc2"/>
        <input type="hidden" value="${source}" name="type">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm2"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit2"/>
        <input type="hidden" name="audit" value="false" id="audit2"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl2"/>
        <input type="hidden" name="ywlx" id="ywlx2"/>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
