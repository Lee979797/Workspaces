<%@page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>��׼���֤������ϸ��Ϣ</TITLE>
    <META content="text/html; charset=gbk" http-equiv=Content-Type>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <style type="text/css">
        table.tableBorder0 td {
            border: #c4dbe5 1px solid;
        }
    </style>
    <script type="text/javascript">
        function submitForm() {
            document.thisForm.submit();
        }
    </script>
</HEAD>
<body style="background:#fff;" class=body leftMargin=0 onload='window.defaultStatus="��ӭ������֯�����������ϵͳ!!!"' topMargin=0>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form method="POST" name="thisForm" action="/bsweb/xzqhManage_${source}.action">
                        <input type="hidden" name="zrxzqh.xzqh" value="${zrxzqh.xzqh}">
                        <table align=center width="100%" border=0 class=tableBorder0 cellpadding=5 cellspacing=0>
                            <tr>
                                <td class=td1 align="right" width="15%">��֤������</td>
                                <td class=td1 width="34%" align="left">${zrxzqh.xzqh}&nbsp;</td>
                                <td class=td1 align="right" width="15%">���ƣ�</td>
                                <td class=td1 align="left" >${zrxzqh.mc}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">�������룺</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.jgdm}&nbsp;</td>
                                <td class=td1 align="right" width="15%">֤��䷢��λ��</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.jgmc}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">��������</td>
                                <td class=td1 width="24%" align="left">
                                    ${(zrxzqh.zdlevel eq '0')?'���ļ�':(zrxzqh.zdlevel eq '1')?'����':(zrxzqh.zdlevel eq '2')?'�ؼ�':'δ֪'}</td>
                                <td class=td1 align="right" width="15%">�ϼ�����������</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.sjxzqh}</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">�Ƿ���ƿ���</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.dkflag=='1'?'��':'��'}</td>
                                <td class=td1 align="right" width="15%">�Ƿ�ɷ�֤��</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.fzflag=='1'?'��':'��'}</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">��λ��ַ��</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.dz}&nbsp;</td>
                                <td class=td1 align="right" width="15%">�������룺</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.yzbm}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">��ϵ�ˣ�</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.lxr}&nbsp;</td>
                                <td class=td1 align="right" width="15%">��ϵ�绰��</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.dh}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">�������ˮ�ţ�</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.zsbh}&nbsp;</td>
                                <td class=td1 align="right" width="15%">״̬��</td>
                                <td class=td1 width="24%" align="left">${(zrxzqh.flag eq '1')?'����':'δ����'}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">IP��</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.ip}&nbsp;</td>
                                <td class=td1 align="right" width="15%">&nbsp;</td>
                                <td class=td1 align="left" width="26%">&nbsp;</td>
                            </tr>
                        </table>
                    </FORM>
                </div>
                <div class="listbtn">
                    <c:if test="${source eq 'update_nqtsbz'}">
                        <input type="button" value="${zrxzqh.njtsbz ?'�� ��':'�� ʾ'}" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <c:if test="${source eq 'update_smdr'}">
                        <input type="button" value="${zrxzqh.smdr ?'�� ��':'�� ��'}" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <c:if test="${source eq 'update_zr'}">
                        <input type="button" value="${(zrxzqh.flag eq '1')?'ȡ��':'�ָ�'}׼��" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <input type="button" value="�� ��" name="cmdExit" class="newBtn1"
                           onClick=" history.back()">
                </div>
            </div>
        </div>
    </div>
</div>
</BODY>
</HTML>