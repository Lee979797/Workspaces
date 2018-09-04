<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    TJgdm tJgdm = (TJgdm) request.getAttribute("tjgdm");
    String bzDate = tJgdm.getBzrq() == null ? "" : tJgdm.getBzrq().toString().substring(0, 10);
    String njDate = tJgdm.getNjqx() == null ? "" : tJgdm.getNjqx().toString().substring(0, 10);
    String zfDate = tJgdm.getZfrq() == null ? "" : tJgdm.getZfrq().toString().substring(0, 10);
    request.setAttribute("tJgdm", tJgdm);
%>
<c:set var="requireds" value="<%= InitSysParams.requiredItems%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type="text/javascript" src="/js/newbus.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jglxBsxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/btxBus.js"></script>


    <script type="text/javascript">
        function getItems(items) {
            if (items && items.length > 0) {
                var fields = items.split(",");
                for (var i = 0; i < fields.length; i++) {
                    var item = $(fields[i]);
                    if (item != undefined && (item.val() == null || item.val() == '')) {
                        return fields[i].substring(1, fields[i].length);
                    }
                }
            }
            return undefined;
        }
        function checkNotNull() {
            var item = getItems($("#btxs").val());

            if (item == undefined || item == null) {
                return true;
            } else {
                dwr.engine.setAsync(false);
                btxBus.getFieldName(item, function (data) {
                    ymPrompt.alert({message: data + "不能为空!", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                        if ("ok" == tp) {
                            $("#" + item).focus()
                            ;
                        }
                    }});
                });
                return false;
            }
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div style=" float: left;"> 发证 &gt;&gt; 常用工具 &gt;&gt;非证书项强制修改</div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('forceUpdate');" type=button value="修 改" name="btok"/>&nbsp;
        <INPUT class="newBtn1"
               onClick="window.location.href='<%=request.getContextPath() %>/product/jsp/certificate/forceUpdateNoZs.jsp'"
               type=button value="返 回" name="cmdExit"/>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>
<c:set var="jgdm" value="${tJgdm}"/>
<form method="post" action="/bsweb/certificate_forceUpdate.action" name="busForm">
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <INPUT type="hidden" name="btxs" id="btxs"/>
    <input type="hidden" name="bzjgdm" id="bzjgdm" value="${fn:trim(tJgdm.bzjgdm) }"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>基础数据项</b><span>（请注意：此区域内容必须填写。）</span></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >

                            <TR>
                                <TD class=td1 width="15%" align=right id="needJgdm">
                                    机构代码
                                </TD>
                                <TD class=td1>
                                    <INPUT size=28 name="type" id="type" type="hidden"
                                           value="1"
                                           style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"/>
                                    <INPUT readonly="true" size=28 name="jgdm" id="jgdm"
                                           value="<%=tJgdm.getJgdm()%>"
                                           style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"/>
                                </TD>
                                <td class=td1 width="15%" align="right"></td>
                                <td class=td1></td>
                            </TR>

                            <%@ include file="../common/edit-jgdm-part1-3.jsp" %>

                        </TABLE>
                    </div>
                    <%@ include file="common_edit_choose2.jsp" %>
                    <div class="listbtn">
                        <INPUT class="newBtn1" onClick="javascript:return fCheckValue('forceUpdate');" type=button value="修 改"
                               name="btok"/>&nbsp;
                        <INPUT class="newBtn1"
                               onClick="window.location.href='<%=request.getContextPath() %>/product/jsp/certificate/forceUpdateNoZs.jsp'"
                               type=button value="返 回" name="cmdExit"/>
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>
</body>
<script>
    (function () {
        var $backToTopTxt = "返回顶部", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6下的定位
            if (!window.XMLHttpRequest) {
                $backToTopEle.css("top", st + winh - 166);
            }
        };
        $(window).bind("scroll", $backToTopFun);
        $(function () {
            $backToTopFun();
        });
    })();
</script>
<script>
    <%
   Object msg = request.getAttribute("resultMsg");
    if(msg != null&&!"".equals(msg.toString().trim())){
         if("codeRepeat".equals(msg.toString())){
    %>
    ymPrompt.alert('机构名称重复!存在${sourceTable}里!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}else if("zchRepeat".equals(msg.toString())){%>
    ymPrompt.alert('注册号重复!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}else if("fzcRepeat".equals(msg.toString())){%>
    ymPrompt.alert('机构名称，注册号不允许同时重复!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%
    }else{%>
    ymPrompt.alert('系统繁忙!请稍后再试!', 330, 220, '提示信息', function () {
        /*history.back();*/
    });
    <%}
    }
    %>
</script>
<script type="text/javascript">
    window.onload = function () {
        dwr.engine.setAsync(false);
        var lx = $("#jglx").val();
        if (lx == null || lx.trim() == "") {
            return;
        }
        btxBus.getBtx(lx.trim(), function (data) {
            $(".required").remove();
            $("#btxs").val(data);
            $(data).after('<span class="required">*</span>');
        });
    }
</script>
</html>
