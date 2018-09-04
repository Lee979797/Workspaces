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
    <title>操作成功页面</title>
    <%--@elvariable id="source" type="java.lang.String"--%>
    <c:set var="url"
           value="${source eq 'update_no'?'/bsweb/business_list?source=update_no':source eq 'update'?'/bsweb/business_list?source=update':source eq 'uploadProblemData'?'/bsweb/qualityManager_uploadProblemData': source eq 'auditProblemData'?'/bsweb/qualityManager_auditProblemData':source eq 'problem_datas'?'/bsweb/qualityManager_problem_datas':source eq 'welcome_wtdj'?'/bsweb/scanTask_welcome_task':'/bsweb/qualityManager_nationProblemData'}"/>
</head>
<body>
<form method="POST" name='thisForm' action="">
    <div class="prompt">
        <div class="promptou">提示信息</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <c:choose>
                        <c:when test="${dy=='1'}">
                            <li><b>
                                卡内信息发生变化,但未改变卡表面信息,应修改卡信息!
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">打印申报表</a>
                                    <%--  <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >打印校对单</a>--%>
                            </b>
                            </li>
                            <li>
                                <input type="button" value="修 改"
                                       onClick="to('/bsweb/icCardOpt_search?source=update&jgdm.jgdm=${jgdm.jgdm}');"
class="newBtn1"                              class=btn1>
                                <input type="button" value="返 回"
                                       onClick="to('${url}')class="newBtn1"                                 class=btn1>
                            </li>
                        </c:when>
                        <c:when test="${dy=='0'}">
                            <li><b>
                                证书已经作废,请重新打印证书!<br/>
                                卡表面信息发生变化,应补发新卡,原卡将被注销!
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">打印申报表</a>
                                    <%-- <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >打印校对单</a>--%>
                            </b>
                            </li>
                            <li>
                                    <%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
                                <c:if test="${'1' eq zrxzqhs[sysUser.bzjgdm].fzflag}">
                                    <input type="button" value="打印证书"
                                           onClick="to('/bsweb/certificatePrint_zb_print?jgdm.jgdm=${jgdm.jgdm}&certi.type=1');"
                                          class="newBtn1""/>
                                </c:if>

                                <input type="button" value="返 回"
                                       onClick="to('${url}');"
                                      class="newBtn1"">

                            </li>
                        </c:when>
                        <c:otherwise><%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
                            <li><b>
                                机构代码（${jgdm.jgdm}）信息更新成功！
                            </b></li>
                            <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank">打印申报表</a>
                                    <%-- <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >打印校对单</a> --%>
                            </b>
                            </li>
                            <li>
                                <input type="button" value="确 定"
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
