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
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>内网数据审核</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
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

        function checkpass() {
            if (!showLength(document.getElementById("info1"))) {
                return;
            }
            document.getElementById("ispass").value = "1";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }

        function checknopass() {
            if (!showLength(document.getElementById("info1"))) {
                return;
            }
            document.getElementById("ispass").value = "0";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }
        function showLength(obj) {
            if (obj.value.length > 100) {
                obj.value = obj.value.substr(0, 100);
                ymPrompt.alert({message:"审核意见不能超过100个字符!", width:330, height:220, title:'提示信息'});
                return false;
            }
            return true;
        }
    </script>

</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="right" style="width: 30% ; float: right;margin-top: 3px;">
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/>&nbsp;&nbsp;&nbsp;</div>
    登记 &gt;&gt;  <c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if> &gt;&gt; 数据审核
</div>
<div id="list_main">
    <form name="form1" id="form1" action="/bsweb/auditingauditIndata.action" method="post" style="margin:0; padding:0;">
        <input name="sp.shflag" id="ispass" type="hidden" value=""/>
        <input name="sp.ywlx" id="ywlx" type="hidden" value="${sp.ywlx}"/>
        <input name="sp.lsh" id="lsh" type="hidden" value="${sp.lsh}"/>
        <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
		<input type="hidden" name="jglx" value="${jglx }">
        <div style="padding: 10px;"><br/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="80" align="center" nowrap="nowrap">审核意见：</td>
                    <td align="center">
                        <TEXTAREA class="input_txt_morebz" onpaste="showLength(this);" onkeyup="showLength(this);"
                                  name="sp.shreason" id="info1" rows="3"></TEXTAREA>
                    </td>
                </tr>
                <tr>
                    <td align="center">审核结果：</td>
                    <td height="35" align="left"><input name="button3" type="button" class="btn_yes" id="button3"
                                                        value=" " onclick="checkpass();"/>
                        <input name="button3" type="button" class="btn_no" id="button4" value=" "
                               onclick="checknopass();"/></td>
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
    ymPrompt.succeedInfo('<%=msg.toString()%>', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/auditinginDataList.html";
    });
    <%}%>
</script>
</html>
