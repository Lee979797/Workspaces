<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    User user = (User) session.getAttribute("sysUser");
    String id = (String) request.getAttribute("id");
    String bzDate = DateUtil.dateToStr(new Date());
    String validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
    String dateLimit = "";
    TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
    //1是定期年检 0是办证日期加一年
    if (zrxzqh != null) {
        if ("0".equals(zrxzqh.getNjfs())) {
            dateLimit = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12);
        } else {
            dateLimit = DateUtil.addMonth(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2), 12);
        }
    }

    String formType = request.getParameter("formType");
    if (clsStringTool.isEmpty(formType)) {
        formType = "0";
    }
    String title = "";
    if ("0".equals(formType)) {
        title = "机构代码登记表录入";
    }
    if ("1".equals(formType)) {
        title = "其他部门赋码登记表录入";
    }
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
  <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>

    <script type="text/javascript">
    function fCheckValue(){
    	if (fCheckItem(document.getElementById("serialNumber"), "发证序列号")) {
            return false;
        }	
        if (fCheckItem(document.getElementById("jgdm"), "机构代码")) {
            return false;
        }
        if (fCheckItem(document.getElementById("fzTime"), "发证时间")) {
            return false;
        }
        if (fCheckItem(document.getElementById("operator"), "经办人")) {
            return false;
        }
        if (fCheckItem(document.getElementById("consigneeLsh"), "收件流水号")) {
            return false;
        }
        if (fCheckItem(document.getElementById("wsbzSerial"), "网上办证序列号")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jkdh"), "缴款单号")) {
            return false;
        }

    	busForm.submit();
        }
       
    </script>
    <style type="text/css">
        .highslide-maincontent a:hover{
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!------------------------------------------------------------------------------------------------->
<div class="page_top_fixed">
    <div align="left" style=" float: left;"><strong> 发证 &gt;&gt; 发证管理&gt;&gt;发证详细信息录入 
    </strong>

    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="return fCheckValue();" type=button value="保 存" name="btok"/>&nbsp;<INPUT
            class="newBtn1"
            onClick="window.location.href='/bsweb/cerAction_list.action'"
            type=button value="返 回" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/cerAction_addCer.action" name="busForm">


<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>基础数据项</b><span></span></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >

<TR>
    <TD class=td1 align=right>
        发证序列号
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 
               name="certificate.serialNumber" id="serialNumber" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
    
     <TD class=td1 align=right>
        机构代码
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="certificate.jgdm" id="jgdm" value="${consignee.jgdm}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        发证时间
    </TD>
    <TD class=td1 colSpan=3>
       <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')});" onblur="this.className='input_off';"
               maxLength=10 size=23
               name="certificate.fzTime" id="fzTime" style=" width:200px;"
                pattern='yyyy-MM-dd' onclick="WdatePicker({el:$dp.$('fzTime')});"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('fzTime')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </TD>
    
     <TD class=td1 align=right>
        经办人
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="certificate.operator" id="operator" value="${certificate.operator}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        收件流水号
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 
               name="certificate.consigneeLsh" id="consigneeLsh" value="${certificate.consigneeLsh}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
    
     <TD class=td1 align=right>
       网上办证序列号
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="certificate.wsbzSerial" id="wsbzSerial" value="${certificate.wsbzSerial}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>

<TR >

<TD class=td1 align=right >
       缴款单号
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="certificate.jkdh" id="jkdh" value="${certificate.jkdh}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</tr>



</TABLE>
</div>

<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return fCheckValue();" type=button value="保 存" name="btok"/>&nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/cerAction_list.action'"
        type=button
        value="返 回" name="cmdExit"/>&nbsp;
    <div>
    </div>
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



</html>
