<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.List" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    TJgdmSave tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath()%>/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  
    <script type="text/javascript">
    	
        function update() {
       

            window.location.href = '/bsweb/certificate_update1.action?jgdm=<%=tJgdm.getTyshxydm()%>&formType=${formType}&audit=${audit}&needAudit=${needAudit}&jglx=${jglx}';
               
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div style=" float: left;"> ��֤ &gt;&gt; �����Ǽ� &gt;&gt; ������޸�
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="javascript:return update();" type=button value="�� ��" name='btok' />&nbsp;
        <INPUT class="newBtn1" onClick=" history.back()" type=button value="�� ��" name='cmdExit' />&nbsp;
    </div>
</div>
<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>������޸������Ϣ</b></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >

<TR>
    <TD class=td1 align=right>
        ��˽����
    </TD>
    <TD class=td1>
        <b>${shresult=="1"?"ͨ��":"δͨ��"}</b>
    </TD>
    <TD class=td1 align=right>
        ������ݣ�
    </TD>
    <TD class=td1>
        <B>${shyj}</B>
    </TD>
</TR>
<%@ include file="common_view.jsp" %>
</TABLE>
</div>
<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return update();" type=button value="�� ��" name="btok" />&nbsp;
    <INPUT class="newBtn1" onClick=" history.back()" type=button value="�� ��" name="cmdExit" />
</div>
</div>
</div>
</div>
</div>
</body>
<script>
    (function () {
        var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop:0 }, 120);
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
