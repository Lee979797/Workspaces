<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
    <c:if test="${!audit}">
        <script type="text/javascript" src="/js/public.js"></script>
        <script type="text/javascript" src="/js/newbus.js"></script>
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
        function validateBus() {
            var fzyj = document.getElementById("fzyj");
            var fzreson = document.getElementById("fzreason");
            if (isEmpty(fzyj.value)) {
                ymPrompt.alert({message:"������ݲ���Ϊ��!", width:330, height:220, title:'��ʾ��Ϣ'});
                fzyj.focus();
                return false;
            } else {
                if (fzyj.value.length > 25) {
                    ymPrompt.alert({message:"������ݳ��Ȳ��ܳ���25������!", width:330, height:220, title:'��ʾ��Ϣ'});
                    fzyj.focus();
                    return false;
                }
            }
            if (isEmpty(fzreson.value)) {
                ymPrompt.alert({message:"���ԭ����Ϊ��!", width:330, height:220, title:'��ʾ��Ϣ'});
                fzreson.focus();
                return false;
            } else {
                if (fzreson.value.length > 100) {
                    ymPrompt.alert({message:"���ԭ�򳤶Ȳ��ܳ���100������!", width:330, height:220, title:'��ʾ��Ϣ'});
                    fzreson.focus();
                    return false;
                }
            }
            return fCheckValue();
        }
        function redoAudit() {
            document.busForm.action = "/bsweb/business_search.action";
            document.busForm.submit();

        }
    </script>
</head>
<body>
<form method="post" action="/bsweb/business_${needAudit==true?"auditUpdate":"update"}.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}" id="jgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="update" id="type"/>
    <input type="hidden" name="source" value="${source}" id="source"/>
    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/>

    <div class="page_top_fixed">
        <div align="left" style=" float: left;">�ճ� &gt;&gt; �ճ�ҵ�� &gt;&gt; �������</div>
        <div align="right" style=" float: right;">
            <INPUT class="${needAudit==true?"btn2":"btn2"}" type=button
                   onclick="${audit?'document.busForm.submit()':'return validateBus();'}"
                   value="${needAudit?"�ύ���":"�ύ����"}" name="btok"/>
            <c:if test="${!audit}">
                &nbsp;
                <INPUT class="newBtn1" type=button onclick="window.location.reload();" value="�� ��" name='reset'/>
            </c:if>
            &nbsp;
            <INPUT class="newBtn1" onClick=" window.location.href='/bsweb/business_list?source=update'"
                   type=button value="�� ��" name='cmdExit'/>
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
                            <h3><b>������</b></h3>
                            <TABLE class=tabcing=0 cellPadding=5 align=center border=0 width="100%"
                                   bgcolor="#eaf6fb">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        ��˽����
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"ͨ��":"δͨ��"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        ������ݣ�
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        ������ݣ�
                                    </TD>
                                    <TD class=td1 >
                                        <TEXTAREA name="fzyj" id="fzyj"

                                                  readonly='true' rows=3
                                                  style="BACKGROUND-COLOR: #e0e0e0; width:100%;">${fzyj}</TEXTAREA>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        ���ԭ��
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
                        <h3><b>����������</b><span>����ע�⣺���������ݱ�����д����</span></            <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               bgcolor="#eaf6fb">
                            <c:if test="${audit}">
                                <TR>
                                    <TD class=td1 align=right width="15%">
                                        ��˽��
                                    </TD>
                                    <TD class=td1 >
                                        <b>${shresult=="1"?"ͨ��":"δͨ��"}</b>
                                    </TD>
                                    <TD class=td1 align=right width="15%">
                                        �������
                                    </TD>
                                    <TD class=td1 >
                                        <B>${shyj}</B>
                                    </TD>
                                </TR>
                            </c:if>
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
                            <TR>
                                <TD class=td1 align=right width="15%">
                                    �������
                                </TD>
                                <TD class=td1 >
                                    <TEXTAREA name="fzyj" id="fzyj"

                                              rows=3
                                              style="width:100%;">${fzyj}</TEXTAREA>
                                </TD>
                                <TD class=td1 align=right width="15%">
                                    ���ԭ��
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
                               onclick="${audit?'document.busForm.submit()':'return validateBus();'}"
                               value="${needAudit?"�ύ���":"�ύ����"}" name="btok"/>
                        <c:if test="${!audit}">&nbsp;<INPUT class="newBtn1" type=button onclick="window.location.reload(); " value="�� ��"
                            name='reset'/>
                        </c:if>&nbsp;<INPUT class="newBtn1"
                                            onClick=" window.location.href='/bsweb/business_list?source=update'"
                                            type=button value="�� ��" name='cmdExit'/>&nbsp;
                    </div>
                </div>

            </div>

        </div>
    </div>
</form>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>