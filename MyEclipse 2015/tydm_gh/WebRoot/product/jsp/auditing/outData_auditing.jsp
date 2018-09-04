<%@ page language="java" pageEncoding="GBK" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>外网网数据审核</title>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>
           <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
          
          <script type="text/javascript">
	$(function(){   $("#info1").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>

    <script type="text/javascript">

        function check_pass() {

            if (document.getElementById("info1").value.length > 200) {
                ymPrompt.alert({message:"审核意见不能超过200个字!", width:330, height:220, title:'提示信息'});
                return;
            }
            document.getElementById("ispass").value = "1";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }

        function check_no_pass() {
            if (Clength(document.getElementById("info1").value) > 200) {
                ymPrompt.alert({message:"审核意见不能超过200个字符，或者100个汉字!", width:330, height:220, title:'提示信息'});
                return;
            }
            document.getElementById("ispass").value = "2";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }
    </script>

</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">
    <div align="left" style=" float: left;"> 审核 &gt;&gt; 审核管理 &gt;&gt; 外网数据审核</div>
    <div align="right" style="width: 30% ; float: right;">
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/></div>
</div>
<div id="list_main">
    <form name="form1" id="form1" action="/bsweb/auditingoutDataAudit.action" method="post"
          style="margin:0; padding:0;">
        <input name="sp.shflag" id="ispass" type="hidden" value=""/>
        <input name="_jgdm" id="lsh" type="hidden" value="${_jgdm}"/>

        <div class="page_div2 f_10"><br/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="80" align="center" nowrap="nowrap"><label for="info1">审核意见：</label></td>
                    <td align="center"><textarea name="sp.shreason" rows="3" class="input_txt_morebz"
                                                 id="info1" cols="1"></textarea></td>
                </tr>
                <tr>
                    <td align="center">审核结果：</td>
                    <td height="35" align="left"><input name="button3" type="button" class="btn_yes" id="button3"
                                                        value=" " onclick="check_pass();"/>
                        <input name="button3" type="button" class="btn_no" id="button4" value=" "
                               onclick="check_no_pass();"/></td>
                </tr>
            </table>
        </div>
        <br/>
    </form>
    <div class="list">
        <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
            <tr>
                <td class="title_txt">审核数据</td>
            </tr>
        </table>
        <div class="content">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bottom_border">
                <jsp:include page="../common/show-jgdm.jsp"/>
            </table>
        </div>

    </div>
</div>
</body>
<script language="javascript">
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg!=null && !clsStringTool.isEmpty(msg.toString())){
    %>
    ymPrompt.succeedInfo('<%=msg.toString()%>',330,220, '提示信息', function () {
        window.location.href = "/bsweb/auditinginDataList.html";
    });
    <%}%>
</script>
</html>
