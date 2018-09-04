<%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.TSystem" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.nacao.business.message.SystemMessageBus" %>
<%@ page import="com.ninemax.nacao.to.message.SystemMessageTO" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="sps" type="java.util.List<com.ninemax.jpa.code.model.TSp>"--%>
<%--@elvariable id="startDate" type="java.util.date"--%>
<%--@elvariable id="endDate" type="java.util.date"--%>
<%--@elvariable id="prompt" type="java.lang.String"--%>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    TSystem system =InitSysParams.system;
    List<SystemMessageTO> messageList = null;
    SystemMessageBus sysMessBus = new SystemMessageBus();
    if (system != null && system.getXsgg()) {
        messageList = sysMessBus.getFirstTop();
    }
    request.setAttribute("system", system);
    request.setAttribute("messageList", messageList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="xzqhMap" value="<%=InitSysParams.zrxzqhMap2%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>用户审核管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
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
    <script type="text/javascript" src="/dwr/interface/sptpBus.js"></script>
    <style type="text/css">
        .welcome_ht {
            width: 100%;
            margin: 0px auto;
            padding-bottom: 30px;
            font-family: "宋体", serif;
            position: relative;
            margin-top:-10px;
        }

        .gonggao {
            width: 750px;
            height: 20px;
            line-height: 20px;
            position: absolute;
            top: 0px;
            left: 90px;
            font-size: 14px;
            cursor: pointer;
        }

        .imgGg {
            position: absolute;
            top: 3px; left:10px;
        }
        .imgGg img{ float:left; margin-right:5px;}
        .gonggao span {
            color: #0093e7;
            text-decoration: underline;
        }

        .gonggao img {
            position: relative;
            top: 5px;
        }

        .welcome_ht p {
            width: 750px;
            height: 230px;
            margin: 0px;
            padding: 0px;
        }

        .welcome_ht h3 {
            width: 750px;
            height: 30px;
            line-height: 30px;
            margin: 10px 0px;
            padding: 0px;
            font-size: 14px;
        }

        .welcome_ht ul {
            width: 800px;
            margin: 0px;
            padding: 0px;
        }

        .welcome_ht ul li {
            float: left;
            font-size: 12px;
            margin: 0px 30px 0px 0px;
            padding: 0px;
            list-style: none;
        }

        .welcome_ht ul li a {
            font-size: 12px;
            color: #008ad2;
            text-decoration: none;
        }

        .welcome_ht ul li a img {
            border: none;
        }
         <!--
        #shangfan{ line-height:24px; height:24px; width:400px; /*border:solid 1px #ccc;*/overflow:hidden;}
        #shangfan ol{margin: 0px 10px;padding: 0px;list-style-type: none;}
        #shangfan ol li{overflow:hidden;text-overflow:ellipsis;white-space: nowrap;margin:0;padding: 0px; line-height:24px;}
        #shangfan ol li img{ position:relative; top:-3px;}
        -->
    </style>
    <link rel="stylesheet" type="text/css" href="/js/highslide-4.1.8/highslide/highslidezx.css"/>
    <script type="text/javascript" src="/js/highslide-4.1.8/highslide/highslide-with-html.js" charset="gbk"></script>

    <script type="text/javascript">
        hs.graphicsDir = '/js/highslide-4.1.8/highslide/graphics/';
        hs.outlineType = 'rounded-white';
        hs.showCredits = false;
        hs.wrapperClassName = 'draggable-header';
    </script>
    <script type="text/javascript">
        function showBoard(title,content) {
            document.getElementById("show").innerHTML="<h3>"+title+"</h3>"+content;
            document.getElementById('btn').onclick();
        }
    </script>
</head>
<body ${(prompt !=null && prompt != '')?'onload="document.getElementById(\'btn2\').onclick();"':''}
        style="background:#fff;">
<span style="margin-left:50%;" id="btn" onclick="return hs.htmlExpand(this, { headingText: '系统公告' })">&nbsp;</span>

<div id="show" class="highslide-maincontent" style="display:none;"></div>
<div class="welcome_ht">
    <c:if test="${system.xsgg}">
        <div class="imgGg"><img  src="../images/icon_volume.gif"/> <b>系统公告：</b></div>
        <div id="shangfan" class="gonggao">
            <div id="holder" >
                <ol>
                    <c:forEach varStatus="i" var="gonggao" items="${messageList}">
                        <li onclick="showBoard('${gonggao.send_title}','${fn:escapeXml(gonggao.send_content)}');">${gonggao.send_title} <c:if test="${i.count  eq 1 }"><img src="../images/icon_news.gif" /></c:if></li>
                    </c:forEach>
                </ol>
            </div>
        </div>

        <c:if test="${sessionScope.prompt !=null && sessionScope.prompt != '' }">
            <span id="btn2" style="margin-left:50%; font-size: 0px; line-height: 0px; height:0px;"
                  onclick="return hs.htmlExpand(this, { headingText: '码段预警提醒' })">&nbsp;</span>

            <div class="highslide-maincontent">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="list_tr">
                        <td><b>${sessionScope.prompt }</b></td>
                    </tr>
                </table>
            </div>
        </c:if>
    </c:if>
    <div style="clear:both; font-size:0px; line-height:0px; height:0px;"></div>
</div>
<div class="page_top">办证机构提交审核项目列表</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/pendApproval_list.action">
        <div class="list_box_top">
            申请日期：
            <input id="CalendarSelector1" name="startDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${startDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector1'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector1'})"/>
            至：
            <input id="CalendarSelector2" name="endDate" type="text" class="input_120"
                   value="<fmt:formatDate value='${endDate}'/>"
                   onfocus="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG src="/product/jsp/images/icon_day.gif" style="cursor:pointer;"
                 align=absMiddle onClick="WdatePicker({el:'CalendarSelector2'})"/>
            机构代码：<input name="jgdm.jgdm" type="text" class="input_120" id="jgdm" maxlength="9" value="${jgdm.jgdm}"/>
            <input name="textfield3" type="text" class="input_120" id="textfield3" style="display:none"/>
            <input name="button2" type="button" class="newBtn1" value="查 询"
                   onclick="Page.verify()"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">序号</td>
                    <td class="list_table_top_td">
                        <div style="float:left">业务类型</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('ywlx','${(page.orderByField eq 'ywlx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'ywlx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">机构代码</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <%--    <td class="list_table_top_td">
                            <div style="float:left">机构名称</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>--%>
                    <%--   <td class="list_table_top_td">
                           <div style="float:left">办证机构</div>
                           <div class="jt_box" style="float:right">
                               <a href="#"
                                  onclick="Page.sort('sendxzqh','${(page.orderByField eq 'sendxzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                   <img src="../images/${(page.orderByField eq 'sendxzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                        width="16" height="16" title="排序字段"/></a>
                           </div>
                       </td>--%>
                    <%--  <td class="list_table_top_td">
                          <div style="float:left">申请人</div>
                          <div class="jt_box" style="float:right">
                              <a href="#"
                                 onclick="Page.sort('sendman','${(page.orderByField eq 'sendman' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                  <img src="../images/${(page.orderByField eq 'sendman' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                       width="16" height="16" title="排序字段"/></a>
                          </div>
                      </td>--%>
                    <td class="list_table_top_td">
                        <div style="float:left">申请时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('sendtime','${(page.orderByField eq 'sendtime' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'sendtime' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">审核时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('shtime','${(page.orderByField eq 'shtime' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'shtime' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">审核意见</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('shreason','${(page.orderByField eq 'shreason' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'shreason' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">审核结果</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('shflag','${(page.orderByField eq 'shflag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'shflag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">状态</div>
                        <div class="jt_box" style="float:right">
                            <a href="#"
                               onclick="Page.sort('flag','${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                <img src="../images/${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                     width="16" height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <td class="list_table_top_td" align="center">查看</td>
                    <td class="list_table_top_td" align="center">处理</td>
                  <%--  <td class="list_table_top_td" align="center">删除</td>--%>
                </tr>


                <c:forEach varStatus="i" var="sp" items="${sps}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <c:set var="ywlxmc" value="${ywlxs[sp.ywlx]}"/>
                        <td>${fn:substring(ywlxmc,0,fn:length(ywlxmc)-2)}${(sp.submitType eq 0)?'':(sp.submitType eq 1)?"重名":(sp.submitType eq 2)?"重注册号":"重名重注册号"}${fn:substring(ywlxmc,fn:length(ywlxmc)-2,fn:length(ywlxmc))}</td>
                        <td>${sp.jgdm }</td>
                            <%-- <td>${xzqhMap[fn:trim(sp.sendxzqh)].mc}</td>--%>
                            <%-- <td>${sp.sendman }</td>--%>
                        <td><fmt:formatDate value="${sp.sendtime }" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${sp.shtime }" pattern="yyyy-MM-dd"/></td>
                        <td>${sp.shreason }</td>
                        <td>${fn:trim(sp.flag)eq '1'? fn:trim(sp.shflag)eq '1'?'审核通过':'审核不通过':"" }</td>
                        <td>${fn:trim(sp.flag)eq '1'?'已审核':'未审核' }</td>
                        <td align="center">
                            <img src="/images/icon_chakan.gif" width="16" height="16" onclick="show('${sp.gllsh}')"
                                 style="cursor:pointer;" title="查看"/>
                        </td>
                        <td align="center">
                            <c:if test="${fn:trim(sp.flag ) eq '1'}">
                                <img src="/product/images/icon_shenhe.gif"
                                     width="16" style="cursor:pointer;" title="处理"
                                     height="16"
                                     onclick="doIt('${fn:trim(sp.jgdm)}','${fn:trim(sp.ywlx)}','${fn:trim(sp.flag )}','${fn:trim(sp.shflag)}','${sp.gllsh}')"/>

                            </c:if>
                        </td>
                       <%-- <td align="center">
                            <c:if test="${ (fn:trim(sp.flag) eq '1') and (fn:trim(sp.shflag ) eq '0')}">
                                <img src="/product/images/icon_del.gif"
                                     width="16" style="cursor:pointer;" title="删除"
                                     height="16"
                                     onclick="deleteIt('${fn:trim(sp.lsh)}','${fn:trim(sp.jgdm)}')"/>

                            </c:if>
                        </td>--%>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
    <form method="get" name='thisForm' action="/bsweb/business_search.action">
        <input name="mc" type="hidden" id="mc"/>
        <input name="jgdm.jgdm" type="hidden" id="jgdm2"/>
        <input type="hidden" name="type" id="type">
        <input type="hidden" name="source" value="pendApproval" id="source">
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="true" id="audit"/>
        <input type="hidden" name="checkCfjl" value="yes" id="checkCfjl"/>
        <input type="hidden" name="ywlx" id="ywlx"/>

    </form>
</div>
<div style="background:url(/product/images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
<c:if test="${system.xsgg}">
    <script type="text/javascript">
        function marquee(height,speed,delay){
            var scrollT;
            var pause = false;
            var ScrollBox = document.getElementById("shangfan");
            if(document.getElementById("holder").offsetHeight <= height) return;
            var _tmp = ScrollBox.innerHTML.replace('holder', 'holder2')
            ScrollBox.innerHTML += _tmp;
            ScrollBox.onmouseover = function(){pause = true}
            ScrollBox.onmouseout = function(){pause = false}
            ScrollBox.scrollTop = 0;
            function start(){
                 scrollT = setInterval(scrolling,speed);
                 if(!pause) ScrollBox.scrollTop += 2;
            }
            function scrolling(){
                 if(ScrollBox.scrollTop % height != 0){
                     ScrollBox.scrollTop += 2;
                     if(ScrollBox.scrollTop >= ScrollBox.scrollHeight/2) ScrollBox.scrollTop = 0;
                 }
               else{
                     clearInterval(scrollT);
                     setTimeout(start,delay);
                 }
            }
            setTimeout(start,delay);
        }
        marquee(24,30,3000);
    </script>
</c:if>
<script type="text/javascript">
function show(jgdm) {
    window.location.href = '/bsweb/pendApproval_show?jgdm.jgdm=' + jgdm;
}
function show_sp(lsh, ywlx) {
    if (ywlx == '06' || ywlx == '10' || ywlx == '11') {
        window.location.href = 'bsweb/auditing_findInSameName?sp.lsh=' + lsh;
    } else {
        window.location.href = 'bsweb/auditingfindInData?sp.lsh=' + lsh;
    }
}
function deleteIt(lsh, jgdm) {
    ymPrompt.confirmInfo('确认删除机构代码（' + jgdm + '）的审核不通过审批数据？', 330, 220, '提示信息', function (tp) {
        if (tp == 'ok') {
            $.post(
                    "/bsweb/auditing_delete",
                    {'sp.lsh': lsh},
                    function (data, status) {
                        if (status == 'success') {
                            ymPrompt.alert('机构代码（' + jgdm + '）的审核不通过审批数据删除成功！', 330, 220, '提示信息', function () {
                                document.location.reload();
                            });
                        } else {
                            ymPrompt.alert("审核数据删除失败，请重试。", 330, 220, '提示信息');
                        }
                    });
        }
    });

}
function doIt(jgdm, lx, type, shRe, lsh) {
    if (type != 1) {
        show(lsh);
        return;
    }
    var ywlx = document.getElementById('ywlx');
    var source = document.getElementById('source');
    var needAudit = document.getElementById('needAudit');
    if (shRe == 0) {
        needAudit.value = "true"
    }
    var tp = document.getElementById('type');
    document.getElementById('jgdm2').value = jgdm;
    document.getElementById('mc').value = jgdm;
    switch (lx) {
        case '00':
        {
            //申请表删除
            var delFlag;
            //审核通过
            if (shRe == 0) {
                delFlag = '3';
            } else {
                delFlag = '1';
            }
            window.location.href = "/bsweb/certificate_viewPage.action?jgdm=" + jgdm + "&type=1&formType=4&delFlag=" + delFlag;
            return;
          }
        case '01':
        {       //注销
            tp.value = "validate";
            ywlx.value = '01';
            break;
        }
        case '02':
        {   //换证
            window.location.href = "/bsweb/certificate_search.action?jgdm=" + jgdm + "&source=certChange&&bzjgdm=${sysUser.bzjgdm}";
            return;
        }
        case '03':
        {    //删除
            tp.value = "delete";
            ywlx.value = '03';
            break;
        }

        case '04':
        {   //注销回复
            tp.value = "unvalidate";
            ywlx.value = '04';
            break;
        }
        case '05':
        {      //迁至
            dwr.engine.setAsync(false);
            document.thisForm.action = "/bsweb/change_search";
            sptpBus.qzlx(jgdm, lx, function (data) {
                if (data == '1')
                    source.value = "innerRedo";
                if (data == '3')
                    source.value = "outerRedo";

            });
            tp.value="pendApproval";
            ywlx.value = '05';
            break;
        }
        case '06':
        {
            document.thisForm.action = "/bsweb/change_search";
            source.value = "innerIn";
            tp.value="pendApproval";
            ywlx.value = '06';
            break;
        }
        case '13':
        {
            document.thisForm.action = "/bsweb/change_search";
            source.value = "outerIn";
            tp.value="pendApproval";
            ywlx.value = '13';
            break;
        }
        case '17':
        {        //无证书变更
            tp.value = "update";
            ywlx.value = '17';
            break;
        }
        case '07':
        {        //证书变更
            tp.value = "update_no";
            ywlx.value = '07';
            break;
        }
        case '08':
        {        //其它部门赋码删除
            var delFlag;
            //审核通过
            if (shRe == 0) {
                delFlag = '3';
            } else {
                delFlag = '1';
            }
            window.location.href = "/bsweb/certificate_viewPage.action?id=" + jgdm + "&type=1&formType=1&delFlag=" + delFlag;
            return;
          }
        case '09':
        {        //预赋码删除
            var delFlag;
            //审核通过
            if (shRe == 0) {
                delFlag = '3';
            } else {
                delFlag = '1';
            }
            window.location.href = "/bsweb/certificate_viewPage.action?id=" + jgdm + "&type=1&formType=2&delFlag=" + delFlag;
            return;
       }
        case '10':
        {
            //普通申请表重名
            //审核通过 1 未通过 0
            var sourceTable;
            if (shRe == 0) {
                sourceTable = 't_jgdm_save';
            } else {
                sourceTable = 't_sptemp';
            }
            window.location.href = "/bsweb/certificate_updatePage.action?jgdm=" + jgdm + "&id=" + jgdm + "&formType=0&nav=1&sourceTable=" + sourceTable;
            return;
          
        }
        case '11':
        {
            //其他部门申请表
            var sourceTable;
            if (shRe == 0) {
                sourceTable = 't_jgdm_save';
            } else {
                sourceTable = 't_sptemp';
            }
            window.location.href = "/bsweb/certificate_updatePage.action?jgdm=" + jgdm + "&id=" + jgdm + "&formType=1&nav=1&sourceTable=" + sourceTable;
            return;
         
        }
        case '12':
        {        //年检
            tp.value = "check";
            ywlx.value = '12';
            break;
        }
        case '14':
        {        //预赋码
            document.thisForm.action = "/bsweb/change_search";
            source.value = "yfmIn";
            tp.value="pendApproval";
            ywlx.value = '14';
            break;
        }
        case '15':
        {
            //预赋码申请表业务
            var sourceTable;
            if (shRe == 0) {
                sourceTable = 't_jgdm_save';
            } else {
                sourceTable = 't_sptemp';
            }
            window.location.href = "/bsweb/certificate_updatePage.action?jgdm=" + jgdm + "&id=" + jgdm + "&formType=2&nav=1&pageno=1&rowNumsView=20&sourceTable=" + sourceTable;
            return;
         
        }
        case '16':
        {
            //变更
            //审核通过 1 未通过 0
            var sourceTable;
            if (shRe == 0) {
                sourceTable = 't_jgdm';
            } else {
                sourceTable = 't_sptemp';
            }
            window.location.href = "/bsweb/certificate_search.action?jgdm=" + jgdm + "&source=update&bzjgdm=${sysUser.bzjgdm}&sourceTable=" + sourceTable;
            return;
         
        }
    }
    if (source.value.length > 0) {
        document.thisForm.submit();
    }
}
</script>
</body>
</html>
