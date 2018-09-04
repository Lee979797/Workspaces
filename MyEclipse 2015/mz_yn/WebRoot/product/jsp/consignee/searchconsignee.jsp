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
  
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>

    <script type="text/javascript">
    function fCheckValue(){
    	if (fCheckItem(document.getElementById("jgdm"), "机构代码")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jgmc"), "机构名称")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeTime"), "收件时间")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeName"), "收件人")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("bzjgdm"), "办证机构代码")) {
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
    <div align="left" style=" float: left;"><strong> 收件 &gt;&gt; 收件登记 &gt;&gt;收件详细信息
    </strong>

    </div>
    <div align="right" style="width: 30% ; float: right;">
       <INPUT
            class="newBtn1"
            onClick="window.location.href='/bsweb/conAction_list.action'"
            type=button value="返 回" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/conAction_addCon.action" name="busForm">


<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>基础数据项</b><span></span></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >

<tr>
	<TD class=td1 align=right>
        收件流水号:
    </TD>
    <TD class=td1 colSpan=3><h5>${mes}</h5>
        
              
    </TD>
    
	
</tr>
<TR>
    <TD class=td1 align=right>
        机构代码:
    </TD>
    <TD class=td1 colSpan=3>${consignee.jgdm}
        
              
    </TD>
    
     <TD class=td1 align=right>
        机构名称:
    </TD>
    <TD class=td1 colSpan=3>${consignee.jgmc}
        
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        收件时间:
    </TD>
    <TD class=td1 colSpan=3>${consignee.consigneeTime}
        
    </TD>
    
     <TD class=td1 align=right>
        收件人:
    </TD>
    <TD class=td1 colSpan=3>${consignee.consigneeName}
        
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        办证机构代码:
    </TD>
    <TD class=td1 colSpan=3>${consignee.bzjgdm}
        
    </TD>
    
     <TD class=td1 align=right>
       缴款单号:
    </TD>
    <TD class=td1 colSpan=3>${consignee.jkdh}
       
    </TD>
</TR>


                            <tr >
                                <td colspan="8">
                                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                                        
                                        <tr height="1">
										  <td width="25%"></td>
										  <td width="8%"></td>
										  <td width="25%"></td>
										  <td width="8%"></td>
										  <td width="25%"></td>
										  <td width="8%"></td>
										</tr>
                                        <tr class="table1_tr1">
                                            <th colspan="6">
                                               收件材料选项:
                                            </th>
                                        </tr>
                                        <tr>
  
                                            <TD class="td1" align="right">
                                                    原代码证卡（变更或到期换证）：
                                            </TD>
                                            <TD class="td1" >
                                                <INPUT type=checkbox ${consignee.ydmzk?"checked":""}  value="true"
                                                       name="consignee.ydmzk"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   名称变更通知复印件（单位名称变更）：
                                            </TD>
                                            <TD class="td1" >
                                                <INPUT type=checkbox  ${consignee.mcbg?"checked":""}  value="true"
                                                       name="consignee.mcbg"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   申请表填写完整并加盖公章：
                                            </TD>
                                            <TD class="td1" >
                                                <INPUT type=checkbox   ${consignee.application?"checked":""}  value="true"
                                                       name="consignee.application"/>
                                            </TD>
        
                                        </tr>
                                                                              <tr>
  
                                            <TD class="td1" align="right">
                                                    上级代码复印件（分支机构）：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox  ${consignee.sjdm?"checked":""}   value="true"
                                                       name="consignee.sjdm"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   经办人身份证复印件（A4双面）：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox ${consignee.card?"checked":""}   value="true"
                                                       name="consignee.card"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   代办委托书面证明（委托代办）：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox ${consignee.dmwts?"checked":""}   value="true"
                                                       name="consignee.dmwts"/>
                                            </TD>
        
                                        </tr>
                                                                              <tr>
  
                                            <TD class="td1" align="right">
                                                   单位法人代表或负责人身份证或护照：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox ${consignee.dwdb?"checked":""}   value="true"
                                                       name="consignee.dwdb"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                  台胞证复印件（A4双面）：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox ${consignee.tbz?"checked":""}  value="true"
                                                       name="consignee.tbz"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                  验核单位成立文件原件并提供有效复印件：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox  ${consignee.yhdw?"checked":""}  value="true"
                                                       name="consignee.yhdw"/>
                                            </TD>
        
                                        </tr>
                                        <tr>
                                        <TD class="td1" align="right">
                                                  其它：
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox  ${consignee.other?"checked":""}  value="true"
                                                       name="consignee.other"/>
                                            </TD>
                                        
                                        </tr>
                                        
                                        
                                        
                                        <tr>



                                        </tr>
                                    </TABLE>
                                </td>
                            </tr>

</TABLE>
</div>

<div class="listbtn">
   &nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/conAction_list.action'"
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
