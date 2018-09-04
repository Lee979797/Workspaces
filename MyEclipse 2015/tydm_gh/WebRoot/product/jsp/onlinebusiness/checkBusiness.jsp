<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%--@elvariable id="audit" type="java.lang.String"--%>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="shresult" type="java.lang.String"--%>
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
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js?v=2013-3-12.04"></script>

    <c:if test="${!audit}">
        <script type="text/javascript" src="/js/public.js"></script>
        <script type="text/javascript" src="/js/newbus.js?v=2013-3-12.01"></script>
    </c:if>
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
        function back() {
            window.location.href = '/bsweb/onLine_jdList.action?ywlx=${ywlx}';
        }
    </script>
</head>
<body>

<form method="post" action="/bsweb/onlineBus_check.action" name="busForm" id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}" id="jgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="type" value="check" id="nameType"/>
    <input type="hidden" name="source" value="check" id="source"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>

    <div class="page_top_fixed">
        <div align="left" style=" float: left;">审核 &gt;&gt; 审核管理 &gt;&gt; 网上代码年检
        </div>
        <div align="right" style=" float: right;">
            <INPUT class="newBtn1" onClick="${audit?'document.busForm.submit();':'fCheckValue();'} " type=button value="保 存" name='btok'/>
            &nbsp;
            <INPUT class="newBtn1" onClick="back()" type=button
                   value="返 回"
                   name='cmdExit'/>
            &nbsp;
        </div>
    </div>
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><span style="font-weight: bold;">基础数据项</span><span>（请注意：此区域内容必须填写。）</span></h3>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <c:if test="${audit &&!needAudit}">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        机构名称重复审核结果：
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"通过":"未通过"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        机构名称重复审核依据：
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                            </c:if>
                            <TR>
                                <TD class=td1 align=right width="15%">
                                    ${jgdm.njrq ne null ?'上次年检':''}
                                </TD>
                                <TD class=td1 >

                                    <c:if test="${jgdm.njrq ne null}">
                                        <fmt:formatDate value="${jgdm.njrq}"/>
                                        <input type="hidden" id="scnj" value="<fmt:formatDate value="${jgdm.njrq}"/>">
                                    </c:if>
                                </TD>
                                <TD class=td1 align=right width="15%">
                                    已发卡数量
                                </TD>
                                <TD class=td1 >
                                    ${jgdm.fksl}
                                </TD>
                            </TR>
                            <jsp:include page="../common/${(audit&&!needAudit)?'show-jgdm':'edit-jgdm-part1-2'}.jsp"/>
                        </TABLE>
                    </div>
                    <c:if test="${!(audit&&!needAudit)}">
                        <jsp:include page="../common/edit-jgdm-part2.jsp"/>
                    </c:if>
                    <div class="listbtn">
                        <INPUT class="newBtn1" onclick="${audit?'document.busForm.submit();':'fCheckValue();'} " type=button value="保 存"
                               name="btok"/>
                        &nbsp; <INPUT class="newBtn1" onClick=" back()"
                                      type=button value="返 回" name='cmdExit'/>

                    </div>


                </div>

            </div>

        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>