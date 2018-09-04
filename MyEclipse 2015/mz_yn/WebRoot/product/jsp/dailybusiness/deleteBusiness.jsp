<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
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
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="/css/dtree.css" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/dtree.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript">
	  $(function(){   $("#fzyj").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		  event.keyCode=9;
		}
	   }
	</script>
    <script type="text/javascript">

        function validateBus() {
            var fzyj = document.getElementById("fzyj");
            var fzreson = document.getElementById("fzreason");

            if (isEmpty(document.getElementById("fzyj").value)) {
             /*   ymPrompt.alert({message: "删除依据不能为空!", width: 330, height: 220, title: '提示信息' ,handler:function (){
                    fzyj.focus();
                }});
                return false;*/
            } else {
                if (document.getElementById("fzyj").value.length > 25) {
                    ymPrompt.alert({message: "删除依据长度不能超过25个汉字!", width: 330, height: 220, title: '提示信息' ,handler:function (){
                        fzyj.focus();
                    }});
                    return false;
                }
            }
            if (isEmpty(document.getElementById("fzreason").value)) {
             /*   ymPrompt.alert({message: "删除原因不能为空!", width: 330, height: 220, title: '提示信息' ,handler:function (){
                    fzreson.focus();
                }});
                return false;*/
            } else {
                if (document.getElementById("fzreason").value.length > 100) {
                    ymPrompt.alert({message: "删除原因长度不能超过100个汉字!", width: 330, height: 220, title: '提示信息' ,handler:function (){
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
            document.busForm.btok1.disabled = "true";
            document.busForm.submit();

        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">日常 &gt;&gt; 日常业务 &gt;&gt; 代码删除</div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit==true?"btn2":"btn1"}" onClick="return validateBus();" type=button
               value="${needAudit==true?"提交审核":"删 除"}">
        &nbsp;
        <INPUT class="newBtn1" onClick=" history.back()" type="button" value="返 回">
        &nbsp;
    </div>
</div>
<form method="post" action="/bsweb/business_${needAudit==true?"auditDelete":"delete"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="type" value="delete" id="type"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>代码删除</b></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <c:if test="${audit}">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        审核结果：
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"通过":"未通过"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        审核依据：
                                    </TD>
                                    <TD class=td1 >
                                        <span style="font-weight: bold;">${shyj}</span>
                                    </TD>
                                </TR>
                            </c:if>
                            <c:choose>
                                <c:when test="${audit &&!needAudit}">
                                    <TR>
                                        <TD class=td1 align=right width="15%">
                                            删除依据：
                                        </TD>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzyj" id="fzyj"

                                                      readonly='true' rows=3
                                                      style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzyj}</TEXTAREA>
                                        </TD>
                                        <TD class=td1 align=right width="15%">
                                            删除原因：
                                        </TD>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzreason" id="fzreason"

                                                      readonly='true' rows=3
                                                      style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzreason}</TEXTAREA>
                                        </TD>
                                    </TR>
                                </c:when>
                                <c:otherwise>
                                    <TR>
                                        <TD class=td1 align=right width="15%">
                                            删除依据：
                                        </TD>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzyj" id="fzyj"

                                                      rows=3
                                                      style=" width:100%;">${fzyj}</TEXTAREA>
                                        </TD>
                                        <TD class=td1 align=right width="15%">
                                            删除原因：
                                        </TD>
                                        <TD class=td1 >
                                            <TEXTAREA name="fzreason" id="fzreason"

                                                      rows=3
                                                      style=" width:100%;">${fzreason}</TEXTAREA>
                                        </TD>
                                    </TR>
                                </c:otherwise>
                            </c:choose>

                            <jsp:include page="../common/show-jgdm.jsp"/>
                        </TABLE>
                    </div>
                    <div class="listbtn">
                        <INPUT class="${needAudit==true?"btn2":"btn1"}" onClick="return validateBus();"
                               type=button     name="btok"
                               value="${needAudit==true?"提交审核":"删 除"}">
                        &nbsp;
                        <INPUT class="newBtn1" onClick=" history.back()" type=button value="返 回" name='cmdExit'>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
