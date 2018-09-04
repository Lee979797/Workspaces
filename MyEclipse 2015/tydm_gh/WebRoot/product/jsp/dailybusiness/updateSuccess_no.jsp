<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }
    </script>
    <title>�����ɹ�ҳ��</title>
    <%--@elvariable id="source" type="java.lang.String"--%>
    <c:set var="url"
           value="${source eq 'update_no'?'/bsweb/business_list?source=update_no':source eq 'update'?'/bsweb/business_list?source=update':source eq 'uploadProblemData'?'/bsweb/qualityManager_uploadProblemData': source eq 'auditProblemData'?'/bsweb/qualityManager_auditProblemData':source eq 'problem_datas'?'/bsweb/qualityManager_problem_datas':source eq 'welcome_wtdj'?'/bsweb/scanTask_welcome_task':'/bsweb/qualityManager_nationProblemData'}"/>
</head>
<body>
<form method="POST" name='thisForm' action="">
    <div class="prompt">
        <div class="promptou">��ʾ��Ϣ</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <c:choose>
                        <c:when test="${dy=='1'}">
                            <li><b>
                                ������Ϣ�����仯,��δ�ı俨������Ϣ,Ӧ�޸Ŀ���Ϣ!
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">��ӡ�걨��</a>
                                    <%--  <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >��ӡУ�Ե�</a>--%>
                            </b>
                            </li>
                            <li>
                                <input type="button" value="�� ��"
                                       onClick="to('/bsweb/icCardOpt_search?source=update&jgdm.jgdm=${jgdm.jgdm}');"
class="newBtn1"                              class=btn1>
                                <input type="button" value="�� ��"
                                       onClick="to('${url}')class="newBtn1"                                 class=btn1>
                            </li>
                        </c:when>
                        <c:when test="${dy=='0'}">
                            <li><b>
                                ֤���Ѿ�����,�����´�ӡ֤��!<br/>
                                ��������Ϣ�����仯,Ӧ�����¿�,ԭ������ע��!
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">��ӡ�걨��</a>
                                    <%-- <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >��ӡУ�Ե�</a>--%>
                            </b>
                            </li>
                            <li>
                                    <%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
                                <c:if test="${'1' eq zrxzqhs[sysUser.bzjgdm].fzflag}">
                                    <input type="button" value="��ӡ֤��"
                                           onClick="to('/bsweb/certificatePrint_zb_print?jgdm.jgdm=${jgdm.jgdm}&certi.type=1');"
                                          class="newBtn1""/>
                                </c:if>

                                <input type="button" value="�� ��"
                                       onClick="to('${url}');"
                                      class="newBtn1"">

                            </li>
                        </c:when>
                        <c:otherwise><%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
                            <li><b>
                                �������루${jgdm.jgdm}����Ϣ���³ɹ���
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">��ӡ�걨��</a>
                                    <%-- <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >��ӡУ�Ե�</a> --%>
                            </b>
                            </li>
                            <li>
                                <input type="button" value="ȷ ��"
                       class="newBtn1"      onClick="to('${url}');"
                                       class=btn1>

                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="promptdi"></div>
    </div>
</form>
</body>
</html>
