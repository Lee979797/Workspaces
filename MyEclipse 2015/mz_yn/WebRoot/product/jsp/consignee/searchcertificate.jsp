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
    //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
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
        title = "��������ǼǱ�¼��";
    }
    if ("1".equals(formType)) {
        title = "�������Ÿ���ǼǱ�¼��";
    }
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
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
    	if (fCheckItem(document.getElementById("jgdm"), "��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jgmc"), "��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeTime"), "�ռ�ʱ��")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeName"), "�ռ���")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("bzjgdm"), "��֤��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jkdh"), "�ɿ��")) {
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
    <div align="left" style=" float: left;"><strong> ��֤ &gt;&gt; ��֤���� &gt;&gt;��֤��ϸ��Ϣ 
    </strong>

    </div>
    <div align="right" style="width: 30% ; float: right;">
       <INPUT
            class="newBtn1"
            onClick="window.location.href='/bsweb/cerAction_list.action'"
            type=button value="�� ��" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/conAction_addCon.action" name="busForm">


<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>����������</b><span></span></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >

<TR>
    <TD class=td1 align=right>
        ��������:
    </TD>
    <TD class=td1 colSpan=3>${certificate.jgdm}
        
              
    </TD>
    
     <TD class=td1 align=right>
        ��֤���к�:
    </TD>
    <TD class=td1 colSpan=3>${certificate.serialNumber}
        
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        ����ʱ��:
    </TD>
    <TD class=td1 colSpan=3>${certificate.fzTime}
        
    </TD>
    
     <TD class=td1 align=right>
       ������:
    </TD>
    <TD class=td1 colSpan=3>${certificate.operator}
        
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        ���ϰ�֤���к�:
    </TD>
    <TD class=td1 colSpan=3>${certificate.wsbzSerial}
        
    </TD>
    
    <TD class=td1 align=right>
        �ռ���ˮ��:
    </TD>
    <TD class=td1 colSpan=3>${certificate.consigneeLsh}
        
    </TD>
    </tr>
    <tr>
    
     <TD class=td1 align=right>
       �ɿ��:
    </TD>
    <TD class=td1 colSpan=3>${certificate.jkdh}
       
    </TD>
</TR>


                            

</TABLE>
</div>

<div class="listbtn">
   &nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/cerAction_list.action'"
        type=button
        value="�� ��" name="cmdExit"/>&nbsp;
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
        var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6�µĶ�λ
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
