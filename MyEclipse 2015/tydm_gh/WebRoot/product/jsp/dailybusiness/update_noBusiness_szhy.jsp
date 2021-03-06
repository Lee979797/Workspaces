<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.util.UserPropertiesData" %>
<%--@elvariable id="audit" type="java.lang.String"--%>
<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
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
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
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
     <link rel="stylesheet" type="text/css" href="/js/highslide-4.1.8/highslide/highslidezx.css"/>
      <script type="text/javascript" src="/js/highslide-4.1.8/highslide/highslide-with-html.js" charset="gbk"></script>
    <script type="text/javascript">
        hs.graphicsDir = '/js/highslide-4.1.8/highslide/graphics/';
        hs.outlineType = 'rounded-white';
        hs.showCredits = false;
        hs.wrapperClassName = 'draggable-header';
        hs.width=1000;
    </script>
    
    <script type="text/javascript">
    if('<%=UserPropertiesData.getValueByPropertyName("gsTwoCode")%>'=='on'){
		ymPrompt.win({message: '/product/jsp/dailybusiness/gsUrlData.jsp', width: 750, height: 200, title:'工商二维码扫描', iframe: true});
	}
	
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
            /* if (isEmpty(fzyj.value)) {
             ymPrompt.alert({message: "变更依据不能为空!", width: 330, height: 220, title: '提示信息', handler: function () {
             fzyj.focus();
             }});

             return false;
             } else {*/
            if (fzyj.value.length > 25) {
                ymPrompt.alert({message: "变更依据长度不能超过25个汉字!", width: 330, height: 220, title: '提示信息', handler: function () {
                    fzyj.focus();
                }});
                return false;
            }
            /* }
             if (isEmpty(fzreson.value)) {
             ymPrompt.alert({message: "变更原因不能为空!", width: 330, height: 220, title: '提示信息', handler: function () {
             fzreson.focus();
             }});

             return false;
             } else {*/
            if (fzreson.value.length > 100) {
                ymPrompt.alert({message: "变更原因长度不能超过100个汉字!", width: 330, height: 220, title: '提示信息', handler: function () {
                    fzreson.focus();
                }});
                return false;
            }
//            }
            return fCheckValue();
        }
        function formSubmit() {
            document.busForm.submit();
            //  dwr.engine.setAsync(false);
            /* jgdmBus.problemDatas(document.getElementById("jgdm").value, function (data) {
             if (data != "false") {
             ymPrompt.confirmInfo({message: data.split(":")[1], width: 330, height: 220, title: '提示信息', handler: function (tp) {
             if (tp == 'ok') {
             document.busForm.submit()
             }
             }});
             }
             });*/
        }
        function back() {

            <c:if test="${source eq 'pendApproval'}">
            window.location.href = '/bsweb/pendApproval_list';
            </c:if>
            <c:if test="${source eq 'update_no'}">
            window.location.href = '/bsweb/business_list?source=update_no';
            </c:if>
            <c:if test="${source eq 'uploadProblemData'}">
            window.location.href = '/bsweb/qualityManager_uploadProblemData';
            </c:if>
            <c:if test="${source eq 'nationProblemData'}">
            window.location.href = '/bsweb/qualityManager_nationProblemData';
            </c:if>
            <c:if test="${source eq 'auditProblemData'}">
            window.location.href = '/bsweb/qualityManager_auditProblemData';
            </c:if>
        }
    </script>
</head>
<body>
<form method="post" action="/bsweb/business_${needAudit==true?"auditUpdate_no":"update_no_szhy"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}" id="jgdm"/>
    <input type="hidden" name="audit" id="audit" value="${audit}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="update" id="nameType"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>
    <input type="hidden" name="source" value="${source}" id="source"/>
    <input type="hidden" name="jgdm.njrq" value="<fmt:formatDate value='${jgdm.njrq}' pattern='yyyy-MM-dd'/>" id="njrq"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>
    <input type="hidden" name="updataType" value="true" id="updataType"/>
    <div class="page_top_fixed">
        <div align="left" style=" float: left;">日常 &gt;&gt; 日常业务 &gt;&gt; 证书项变更</div>
        <div align="right" style=" float: right;">
            <INPUT class="${needAudit==true?"btn2":"btn2"}" type=button
                   onclick="${audit?'formSubmit()':'return validateBus();'}"
                   value="${needAudit?"提交审核":"提交更新"}" name="btok"/>
            <c:if test="${!audit}">
                &nbsp;
                <INPUT class="newBtn1" type=button onclick="window.location.reload();" value="重 填" name='reset'/>
            </c:if>
            &nbsp;
            <INPUT class="newBtn1" onClick="back()"
                   type=button value="返 回"/>
            &nbsp;
        </div>
    </div>
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <%-----%>
                        <c:choose>

                        <c:when test="${audit &&!needAudit}">
                            <h3><b>代码变更</b></h3>
                            <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                                   >
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
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        变更依据：
                                    </TD>
                                    <TD class=td1 >
                                        <TEXTAREA name="fzyj" id="fzyj"

                                                  readonly='true' rows=3
                                                  style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzyj}</TEXTAREA>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        变更原因：
                                    </TD>
                                    <TD class=td1 >
                                        <TEXTAREA name="fzreason" id="fzreason"

                                                  readonly='true' rows=3
                                                  style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzreason}</TEXTAREA>
                                    </TD>
                                </TR>
                                <jsp:include page="../common/show-jgdm.jsp"/>
                            </TABLE>
                        </c:when>
                        <c:otherwise>
                        <h3><b>基础数据项</b><span>（请注意：此区域内容必须填写。）</span></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <c:if test="${audit}">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        审核结果
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"通过":"未通过"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        审核依据
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                            </c:if>
                            <TR>
                                <TD class=td1 align=right width="15%">
                                    机构代码
                                </TD>
                                <TD class=td1 >
                                        ${jgdm.jgdm}
                                          
                                        <a href="index.htm"   onclick="return  hs.htmlExpand(this, { headingText: '工商变更数据列表' })">
											<font color='red'>获取工商数据</font>
										</a>
                                     
										<div class="highslide-maincontent" width="50%;">
										<TABLE class=tableBorder0>
											<tr style="font-size: 20px;font-weight: bold;">
											<td class=td1>序号</td>
											<td class=td1>变更事项</td>
											<td class=td1> 变更前内容</td>
											<td class=td1>变更后内容</td>
											</tr>
										<c:forEach  items="${listDetail}" var="list" varStatus="d">
											<tr>
											<td>${d.index+1 }</td>
											<td>${list.bgsx }</td>
											<td>${list.before }</td>
											<td>${list.after }</td>
											</tr>
										
										</c:forEach>
										</TABLE>
										</div>
                                        
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
                            <TR>
                                <TD class=td1 align=right width="15%">
                                    变更依据
                                </TD>
                                <TD class=td1 >
                                    <TEXTAREA name="fzyj" id="fzyj"

                                              rows=3
                                              style="width:100%;">${fzyj}</TEXTAREA>
                                </TD>
                                <TD class=td1 align=right width="15%">
                                    变更原因
                                </TD>
                                <TD class=td1 >
                                    <TEXTAREA name="fzreason" id="fzreason"

                                              rows=3
                                              style="width:100%;">${fzreason}</TEXTAREA>
                                </TD>
                            </TR>
                            <jsp:include page="../common/edit-jgdm-part1.jsp"/>
                        </TABLE>
                    </div>
                    <jsp:include page="../common/edit-jgdm-part2.jsp"/>
                    </c:otherwise>
                    </c:choose>
                    <div class="listbtn">
                        <INPUT class="btn2" type=button
                               onclick="${audit?'formSubmit()':'return validateBus();'}"
                               value="${needAudit?"提交审核":"提交更新"}"/>
                        <c:if test="${!audit}">&nbsp;<INPUT class="newBtn1" type=button onclick="window.location.reload(); " value="重 填"
                            name='reset'/>
                        </c:if>&nbsp;<INPUT class="newBtn1" onClick="back()" type=button value="返 回"/>&nbsp;
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>
<script type="text/javascript">
    (function(){
        changeBzrq(document.getElementById("bzrq"));
    })();
</script>
</body>
<jsp:include page="../common/onload.jsp"/>

</html>