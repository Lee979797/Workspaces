<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
        <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
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
            var fzyj = document.getElementById("fzyj");
            var fzreson = document.getElementById("fzreason");
            if (isEmpty(document.getElementById("fzyj").value)) {
           /*     ymPrompt.alert({message: "ע�����ݲ���Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function () {
                    fzyj.focus();
                }});
                return false;*/
            } else {
                if (document.getElementById("fzyj").value.length > 25) {
                    ymPrompt.alert({message: "ע�����ݳ��Ȳ��ܳ���25������!", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function () {
                        fzyj.focus();
                    }});
                    return false;
                }
            }
            if (isEmpty(document.getElementById("fzreason").value)) {
            /*    ymPrompt.alert({message: "ע��ԭ����Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function () {
                    fzreson.focus();
                }});
                return false;*/
            } else {
                if (document.getElementById("fzreason").value.length > 100) {
                    ymPrompt.alert({message: "ע��ԭ�򳤶Ȳ��ܳ���100������!", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function () {
                        fzreson.focus();
                    }});
                    return false;
                }
            }
            document.busForm.btok.disabled = "true";
            document.busForm.submit();

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
            window.location.href = '/bsweb/business_list?source=validate';
            </c:if>
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;"><strong>�ճ� &gt;&gt; �ճ�ҵ�� &gt;&gt; ����ע��</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit==true?"btn2":"btn1"}" onClick="return validateBus();" type="button"
               value="${needAudit==true?"�ύ���":"�� ��"}">
        &nbsp;
        <INPUT class="newBtn1" onClick="back()" type=button value="�� ��" name='cmdExit'>
        &nbsp;
    </div>
</div>
<form method="post" action="/bsweb/business_${needAudit==true?"auditValidate":"validateDM_szhy"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="validate" id="type"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>����ע��</b></h3>
                    		<table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
                            
                            <c:if test="${audit}">
                                <tr>
                                    <TD class=td1 align=right width="15%">
                                        ��˽����
                                    </td>
                                    <TD class=td1 >
                                        <b>${("1" eq shresult)?"ͨ��":"δͨ��"}</b>
                                    </td>
                                    <TD class=td1 align=right width="15%">
                                        ������ݣ�
                                    </td>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </td>
                                </tr>
                            </c:if>
                            <c:choose>
                                <c:when test="${audit &&!needAudit}">
                                
                                    <tr>
                                        <TD class=td1 align=right width="15%">
                                            ע�����ݣ�
                                        </TD>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzyj" id="fzyj"

                                                      readonly='true' rows=3
                                                      style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzyj}</TEXTAREA>
                                        </td>
                                        <TD class=td1 align=right width="15%">
                                            ע��ԭ��
                                        </td>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzreason" id="fzreason"

                                                      readonly='true' rows=3
                                                      style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzreason}</TEXTAREA>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                 <TR>
                                <TD class=td1 align=right width="15%">
                                    ��������
                                </TD>
                                <TD class=td1 >
                                        ${jgdm.jgdm}
                                </TD>
                                <TD class=td1 align=right width="15%">
                                        ${jgdm.njrq ne null ?'�ϴ����':''}
                                </TD>
                                <TD class=td1 >
                                    <c:if test="${jgdm.njrq ne null}">
                                        <fmt:formatDate value="${jgdm.njrq}" pattern="yyyy-MM-dd"/>
                                    </c:if>
                                </TD>
                            </TR>
                                    <tr>
                                        <TD class=td1 align=right width="15%">
                                            ע�����ݣ�
                                        </td>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzyj" id="fzyj"

                                                      rows=3
                                                      style=" width:100%;">${fzyj}</TEXTAREA>
                                        </td>
                                        <TD class=td1 align=right width="15%">
                                            ע��ԭ��
                                        </td>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzreason" id="fzreason"
                                                       rows=3
                                                      style=" width:100%;">${fzreason}</TEXTAREA>
                                        </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            
                            
                            
 <%--						<jsp:include page="../common/show-jgdm.jsp"/> 												--%>
 
 
 
 
 
 
                             <jsp:include page="../common/edit-jgdm-part1.jsp"/>
                       </table>
                        <jsp:include page="../common/edit-jgdm-part2.jsp"/>
                    </div>
                    <div class="listbtn">
                        <INPUT class="${needAudit==true?"btn2":"btn1"}" onClick="return validateBus();"
                               type="button" value="${needAudit==true?"�ύ���":"�� ��"}" name="btok">
                        &nbsp;
                        <INPUT class="newBtn1" onClick="back()" type=button value="�� ��"
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
