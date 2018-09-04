<%--@elvariable id="zrxzqh" type="com.ninemax.jpa.code.model.TZrxzqh"--%>
<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <TITLE>准入办证机构</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <META content="Microsoft FrontPage 4.0" name=GENERATOR>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/zrxzqhBs.js"></script>
    <script type="text/javascript">
	$(function(){   $("#smyq").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function verifyValue(obj) {
            if (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40") {
                return;
            }
            if (obj && obj.value && obj.value.length > 0 && !/^\d*$/.test(obj.value)) {
                obj.value = obj.value.replace(/[\D\s]/gm, "");
                obj.focus();
            }
            if (obj && obj.value && obj.value.length > 0 && /^0+\d+$/.test(obj.value)) {
                obj.value = obj.value.replace(/^0*(\d+)$/, "$1");
                obj.focus();
            }
        }
    </script>
    <style type="text/css">
        table.tableBorder0 td {
            height: 37px;
        }
    </style>
</head>
<body style="background:#fff;">
<div class="page_top">
    <div align="left" style=" float: left;">${fn:trim(fn:trim(title))}</div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form method="POST" name="thisForm" action="/bsweb/xzqhManage_yq_xzqh.action">
                        <input type="hidden" value="${fn:trim(zrxzqh.flag)}" name="zrxzqh.flag">
                        <input type="hidden" name="zrxzqh.csxzqh" value="${zrxzqh.csxzqh}">
                        <table align=center border=0 class=tableBorder0 cellpadding=0 cellspacing=0 width="100%">
                            <tr>
                                <td class=td1 align="right" >办证机构：</td>
                                <td class=td1 align="left">
                                    <input type="text" name="zrxzqh.xzqh" id="xzqh" value="${zrxzqh.xzqh}"
                                           readonly="readonly"
                                           size="35" maxlength="6" style="BACKGROUND-COLOR: #e0e0e0;"/><%--&nbsp;<span id="prop" style="color: #ff0000;">*</span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td class=td1 align="right">名称：</td>
                                <td class=td1 align="left" style="position:relative;display:block;overflow:visible;">
                                    ${fn:trim(zrxzqh.mc)}
                                </td>
                            </tr>
                            <tr>
                                <TD class="td1" align="right">
                                    扫描任务:
                                </TD>
                                <TD class="td1">
                                    <INPUT type="text" value="${zrxzqh.smyq}" id="smyq" onkeyup="verifyValue(this)"
                                           onblur="verifyValue(this)"
                                           style="width: 40px"
                                           maxlength="2"
                                           name="zrxzqh.smyq"/>&nbsp;天
                                </TD>
                            </tr>
                            <tr>
                                <TD class="td1" align="right">
                                    问题档案：
                                </TD>
                                <TD class="td1">
                                    <INPUT type="text" value="${zrxzqh.dayq}" id="dayq" onkeyup="verifyValue(this)"
                                           onblur="verifyValue(this)"
                                           style="width: 40px"
                                           maxlength="2"
                                           name="zrxzqh.dayq"/>&nbsp;天
                                </TD>
                            </tr>
                            <tr>
                                <TD class="td1" align="right">
                                    问题数据：
                                </TD>
                                <TD class="td1">
                                    <INPUT type="text" value="${zrxzqh.sjyq}" id="sjyq" onkeyup="verifyValue(this)"
                                           onblur="verifyValue(this)"
                                           style="width: 40px"
                                           maxlength="2"
                                           name="zrxzqh.sjyq"/>&nbsp;天
                                </TD>
                            </tr>
                        </table>
                        <div class="listbtn">
                            <input type="submit" name="btok" value="保 存" class="newBtn1">
                            &nbsp;
                            <input type="button" value="返 回" name="cmdExit" class="newBtn1" onclick=" history.back()">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>