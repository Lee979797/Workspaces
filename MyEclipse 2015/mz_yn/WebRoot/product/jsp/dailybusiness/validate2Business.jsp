<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String bzDate = DateUtil.dateToStr(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
        <script type='text/javascript' src='/dwr/engine.js'></script>
            <script type="text/javascript" src="/js/public.js"></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript">
    	$(function(){   $("#fzyj").focus();  })
    	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
    </script>
    <script type="text/javascript">

        function validateBus() {
            
        	if (confirm("确认要提交？")) {
            var zxpzwh=$("#zxpzwh").val();
            var fzrq=$("#fzrq").val();
            if(zxpzwh==''){
            	ymPrompt.alert({message: "撤销批准文号不能为空！", width: 330, height: 220, title: '提示信息'});
            	return false;
                }else if(dateCompareSingle(fzrq)){
                	ymPrompt.alert({message: "撤销日期不能大于当前时间！", width: 330, height: 220, title: '提示信息'});
                	return false;
                    }else{

            	document.busForm.btok.disabled = "true";
           		document.busForm.submit();
                }
        	}

        }
        function redoAudit() {
            document.busForm.action = "/bsweb/business_search.action";
            document.busForm.btok.disabled = "true";
            document.busForm.submit();

        }
        function back() {

            <c:if test="${source eq 'pendApproval'}">
            window.location.href = '/bsweb/pendApproval_list';
            </c:if>
            <c:if test="${source eq 'validate'}">
            window.location.href = '/bsweb/business_list?source=validate&jglx=${jglx}';
            </c:if>
        }
    </script>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="left" style=" float: left;"><strong>登记 &gt;&gt;  <c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if>&gt;&gt; 撤销登记</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();" type="button"
               value="${needAudit==true?"提交审核":"撤 销"}">
        &nbsp;
        <INPUT class="newBtn1" onClick="back()" type=button value="返 回" name='cmdExit'>
        &nbsp;
    </div>
</div>
<form method="post" action="/bsweb/business_${needAudit==true?"auditValidate":"validateDM"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.tyshxydm" value="${jgdm.tyshxydm}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="validate2" id="type"/>
    <input type="hidden" name="mc" value="${jgdm.tyshxydm}" id="mc"/>
	<input type="hidden" name="jglx" value="${jglx }">
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>代码撤销</b></h3>
                    		<table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
                            
                            <c:if test="${audit}">
                                <tr>
                                    <TD class=td1 align=right width="15%">
                                        审核结果：
                                    </td>
                                    <TD class=td1 >
                                        <b>${("1" eq shresult)?"通过":"未通过"}</b>
                                    </td>
                                    <TD class=td1 align=right width="15%">
                                        审核依据：
                                    </td>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </td>
                                </tr>
                            </c:if>
                            <c:choose>
                                <c:when test="${audit &&!needAudit}">
                                
             
                                </c:when>
                                <c:otherwise>
                                            <TR>
                                <TD class=td1 align=right width="15%">
                                  	 撤销批准文号
                                </TD>
                                <TD class=td1 >
                                       <input type="text" name="zxpzwh" id="zxpzwh" value="${zxpzwh}" maxlength="70"/>
                                </TD>
                                <TD class=td1 align=right width="15%">
                                 	  撤销日期
                                </TD>
                                 <TD class=td1 >
                                   <c:set var="bzDate" value="<%=DateUtil.strToDate(bzDate)%>"/>
    									 <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')}); "onclick="WdatePicker({el:$dp.$('zfrq')});"
              							 maxLength=10 size=23
              				 				name="fzrq" id="fzrq"  readonly="true" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
              					 value="<fmt:formatDate value='${bzDate}' pattern='yyyy-MM-dd'/>"
               					/>
        						<A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});" href="javascript:void(0)">
            						<IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        						</A>
                                </TD>
                            </TR>
                                 <TR>
                                <TD class=td1 align=right width="15%">
                                   	 统一代码
                                </TD>
                                <TD class=td1 >
                                        ${jgdm.tyshxydm}
                                </TD>
                                <TD class=td1 align=right width="15%">
                                        ${jgdm.njrq ne null ?'上次年检':''}
                                </TD>
                                <TD class=td1 >
                                    <c:if test="${jgdm.njrq ne null}">
                                        <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"/>
                                    </c:if>
                                </TD>
                            </TR>
                                  
                                </c:otherwise>
                            </c:choose>
                            
                            
					<jsp:include page="../common/show-jgdm.jsp"/> 												
 
 
 
 
                             
 <%--	
                             <jsp:include page="../common/edit-jgdm-part1.jsp"/>--%>
 
                       </table>
                        <%-- <jsp:include page="../common/edit-jgdm-part2.jsp"/>--%>
                    </div>
                    
                     <jsp:include page="../common/show-fzr.jsp"/>
                    <div class="listbtn">
                        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();"
                               type="button" value="${needAudit==true?"提交审核":"撤 销"}" name="btok">
                        &nbsp;
                        <INPUT class="newBtn1" onClick="back()" type=button value="返 回"
                               name='cmdExit'>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
