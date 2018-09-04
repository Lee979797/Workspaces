<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdmSave" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    TJgdmSave tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
    String time = DateUtil.getCurrentDateTime().substring(0, 4);
    String bzDate = DateUtil.dateToStr(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools.js"></script>
        <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/shadow.js"></script>
    <script type="text/javascript">
        function update() {
            var jgdm = document.getElementById("jgdm");
            if (jgdm.value == undefined || jgdm.value == null || jgdm.value.trim() == "") {
                var jzfm =<%=InitSysParams.system.getJzfm()%>;
                if (jzfm) {
                    ajaxCode(0, document.busForm, null, document.busForm.jgmc.value, document.busForm.pzwh.value, "");
                }else{

                document.busForm.submit();
                    }
            } else {
                document.busForm.submit();
            }
        }
    </script>
</head>
<body style="background:#fff;">
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart" style="width:700px;border:0;padding-top:20px;margin-left:auto;margin-right:auto;">
                <table border="0" width="90%" cellpadding="0" cellspacing="0">

                    <tr>
                        <td height="40">
                            <p align="center" style="line-height:40pt"><b><font face="����_gbk"
                                                                                size="5">ȫ����֯�������븳��֪ͨ��</font></b>&nbsp;
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div align="center">
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                    <tr>
                                        <td width="50%"></td>
                                        <td width="25%" align="center">��ţ���<%=time%>��</td>
                                        <td width="25%" align="center">�� <%=tJgdm.getWjwlsh()%> ��</td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td height="30">
                            <p><%=tJgdm.getPzjgmc()%>
                        </td>
                    </tr>
                    <tr>
                        <td height="30">
                            <p>������λ����ȡ��֯��������</td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">
                                <table border="1" cellpadding="0" cellspacing="0" width="100%" bordercolor="#000000"
                                       bordercolorlight="#000000" bordercolordark="#000000">
                                    <tr>
                                        <td width="32%" align="center" height="25" valign="middle">��������</td>
                                        <td width="68%" valign="middle" align="left">&nbsp;<%=tJgdm.getJgmc()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="32%" align="center" height="25" valign="middle">��׼�ĺ�<br>
                                            ������׼֤����׼�ţ�
                                        </td>
                                        <td width="68%" valign="middle" align="left">&nbsp;<%=tJgdm.getPzwh()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="32%" align="center" height="25" valign="middle">��������<br>
                                            ������׼֤��䷢���ڣ�
                                        </td>
                                        <td width="68%" valign="middle" align="left">
                                            &nbsp;<%=tJgdm.getPwrq().toString().substring(0, 10)%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="32%" align="center" height="25" valign="middle">��֯��������</td>
                                        <td width="68%" valign="middle" align="left">&nbsp;<%=tJgdm.getJgdm()==null?"":tJgdm.getJgdm()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="32%" align="center" height="25" valign="middle">��������</td>
                                        <td width="68%" valign="middle" align="left">
                                            &nbsp;<%=tJgdm.getBzrq().toString().substring(0, 10)%>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" height="30">���ǩ���ˣ�<input type="text" size="20" name="wjwtbr"
                                                                   value="<%=tJgdm.getWjwtbr()%>"
                                                                   style="border:1px solid black; background:#fff;border-left-style: solid; border-left-color: #FFFFFF; border-right-style: solid; border-right-color: #FFFFFF; border-top-style: solid; border-top-color: #FFFFFF; border-bottom-style:solid "
                                                                   maxlength="4"></td>
                    </tr>
                    <tr>
                        <td align="right" height="30"><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>(�����������)
                        </td>
                    </tr>
                    <tr>
                        <td align="right" height="30">
                            <p style="margin-right: 95"><%=bzDate%>
                        </td>
                    </tr>
                </table>
                <div class="listbtn">

                    <c:if test="${audit}">
                        <INPUT class="newBtn1" onClick="update();" type="button" value="�� ��" name="btok"/>&nbsp;
                    </c:if>
                    <INPUT class="newBtn1" onClick="javascript:history.go(-1);" type=button value="�� ��" name="cmdExit"/>

                    <div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<form method="post" action="/bsweb/certificate_updateRequisition.action" name="busForm">
    <input type="hidden" name="formType" value="2"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="${needAudit}"/>
    <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}"/>
    <input type="hidden" name="nameType" id="nameType" value="addReq"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>
    <input type="hidden" name="sslcode" id="sslcode"/>
    <input type="hidden" name="id" id="id" value="<%=tJgdm.getId()%>"/>
    <input type="hidden" name="jgdm" id="jgdm" value="<%=tJgdm.getJgdm()==null?"":tJgdm.getJgdm()%>"/>
    <input type="hidden" name="jgmc" id="jgmc" value="<%=tJgdm.getJgmc()==null?"":tJgdm.getJgmc()%>"/>
    <input type="hidden" name="pzwh" id="pzwh" value="<%=tJgdm.getPzwh()%>">
</form>
</body>
<script>
    (function () {
        var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6�µĶ�λ
            if (!window.XMLHttpRequest) {
                $backToTopEle.css("top", st + winh - 166);
            }
        };
        $(window).bind("scroll", $backToTopFun);
        $(function () {
            $backToTopFun();
        });
    })();
</script>
</html>
