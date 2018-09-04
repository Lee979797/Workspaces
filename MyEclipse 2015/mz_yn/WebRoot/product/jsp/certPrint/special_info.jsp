<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>机构代码信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type="text/javascript">
        function fCheckValue(type) {
            $("#type").val(type);
            if($("#opJglx").val()==''){
            	ymPrompt.alert("请选择法人代表！", 330, 220, "信息提示");
                return false;

                }
            document.printCert.submit();
        }
        function _goBack() {
            window.history.back();
        }
        function fbbh() {

        	if($("#opJglx").val()==''){
            	ymPrompt.alert("请选择法人代表！", 330, 220, "信息提示");
                return false;

                }
            
            var zslsh = $("#zslsh");
            var reg = /^(\d+,)*(\d+)/g;
            if (reg.test(zslsh.val())) {
                return true;
            } else {
                var ss = zslsh.val().match(reg)[0];
                zslsh.val(ss ? ss : "");
                return false;
            }
        }
    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top_fixed">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right; ">
        <input type="button" class=btn2 value="打印正本" name="btok" onClick="fCheckValue(0);">
        &nbsp;
        <input type="button" class=btn2 value="打印副本" name="btok" onClick="fCheckValue(1);">
        &nbsp;
        <input type="button" value="返 回" name="cmdExit" class="newBtn1" onclick="_goBack();">
        &nbsp;
    </div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form action="/bsweb/certificatePrint_special_print" name="printCert">
                        <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
                        <input type="hidden" name="certi.type" id="type" value="3"/>
                        <table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <tr class="tabletitle">
                                <c:choose>

											<c:when
												test="${fn:containsIgnoreCase('9A',fn:trim(jgdm.jglx)) }">
												<td class=td1 align="center" colspan="3" width="80%">
													机构代码(${jgdm.jgdm})
												</td>
												<td class=td1 align="center" colspan="1" width="20%">
													法人代表选择：

													<SELECT name="opJglx" id="opJglx" style="">
														<option value="">
															请选择
														</option>
														<option value="负责人">
															负责人
														</option>
														<option value="法定代表人">
															法定代表人
														</option>

													</SELECT>
												</td>
											</c:when>

											<c:otherwise>
												<td class=td1 align="center" colspan="4" width="100%">
													机构代码(${jgdm.jgdm})
												</td>
											</c:otherwise>

										</c:choose>

                            </tr>
                            <tr>
                                <td class=td1 align="right">证书流水号：</td>
                                <td class=td1 align="left">
                                    组代管${sysUser.bzjgdm}-${jgdm.zslsh}-
                                    <select name="certi.djh">
                                        <option value=""></option>
                                        <c:forEach var="fb" items="${certi.fbs}">
                                            <option value="${fb}">${fb}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td class=td1 colspan="2" align="left">注意：
                                    <span style="color: red"> 特殊打印副本时，请选择副本编号,不选择编号，将打印本机构所有有效的副本。</span>
                                </td>
                            </tr>
                            <jsp:include page="../common/show-jgdm2.jsp"/>
                        </table>
                    </form>
                </div>
                <div class="listbtn">
                    <input type="button" class=btn2 value="打印正本" name="btok" onClick="fCheckValue(0);">
                    &nbsp;
                    <input type="button" class=btn2 value="打印副本" name="btok" onClick="fCheckValue(1);">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
