<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>����������Ϣ</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
    <script type="text/javascript">
        function fCheckValue() {
        	if($("#opJglx").val()==''){
            	ymPrompt.alert("��ѡ���˴���", 330, 220, "��Ϣ��ʾ");
                return false;

                }
            
            var num = document.getElementById("fbsl").value;
            var flag;
            dwr.engine.setAsync(false);
            if (/[\d]+/.test(num) && num > 0) {

                certPrintBus.hasCert('${sysUser.bzjgdm}', '1', num, function (value) {
                    flag = value;
                });
                if (!flag) {
                    ymPrompt.alert({message:"��ǰ����֤���治�㣬����֤�����ܴ�ӡ֤��", width:330, height:220, title:'��ʾ��Ϣ'});
                    return false;
                }

                document.printCert.submit();
            } else {
                ymPrompt.alert({message:"��������ȷ�ļ�ӡ������", width:330, height:220, title:'��ʾ��Ϣ'});
            }
        }
        function _goBack() {
            window.history.back();
            //  window.location.href = "/bsweb/certificatePrint_list_has_print";
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right; ">
        <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
            <input type="button" class="btn2" value="��ӡ֤��" name="btok" onClick="fCheckValue();">
        </c:if>
        &nbsp;
        <input type="button" value="�� ��" name="cmdExit" class="newBtn1" onclick="_goBack();">
        &nbsp;
    </div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form action="/bsweb/certificatePrint_fb_print.action" name="printCert">
                        <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
                        <input type="hidden" name="source" value="${certi.type}" id="source"/>
                        <input type="hidden" name="certi.type" value="2"/>
                        <table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <tr>
                                 <c:choose>

											<c:when
												test="${fn:containsIgnoreCase('9A',fn:trim(jgdm.jglx)) }">
												<td class=td1 align="center" colspan="3" width="80%">
													��������(${jgdm.jgdm})
												</td>
												<td class=td1 align="center" colspan="1" width="20%">
													���˴���ѡ��

													<SELECT name="opJglx" id="opJglx" style="">
														<option value="">
															��ѡ��
														</option>
														<option value="������">
															������
														</option>
														<option value="����������">
															����������
														</option>

													</SELECT>
												</td>
											</c:when>

											<c:otherwise>
												<td class=td1 align="center" colspan="4" width="100%">
													��������(${jgdm.jgdm})
												</td>
											</c:otherwise>

										</c:choose>
                            </tr>
                            <tr>
                                <td class="td1" width="10%" align="right">֤����ˮ�ţ�</td>
                                <td class="td1" align="left">
                                    <input type="text"
                                           value="${jgdm.zslsh}" name="jgdm.zslsh" id="zslsh"
                                    ${fn:length(jgdm.zslsh)==6?'style="BACKGROUND-COLOR: #e0e0e0; width:200px;"':''}
                                           readonly="${fn:length(jgdm.zslsh)==6?'true':'false'}"/>

                                </td>
                                <td class="td1" td width="10%" align="right">��ӡ����������</td>
                                <td class="td1" align="left">
                                    <INPUT onkeyup="onlyDecimal(this);" onafterpaste="onlyDecimal(this);" type="text"

                                           maxLength=2 value="1" name="jgdm.fbsl" id="fbsl"/>
                                </td>
                            </tr>
                            <jsp:include page="../common/show-jgdm2.jsp"/>
                        </table>
                    </form>
                </div>
                <div class="listbtn">
                    <div id="pr">
                        <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
                            <input type="button" class="btn2" value="��ӡ֤��" name="btok" onClick="fCheckValue();">
                        </c:if>
                        &nbsp;
                        <input type="button" value="�� ��" name="cmdExit" class="newBtn1" onclick="_goBack();">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>
