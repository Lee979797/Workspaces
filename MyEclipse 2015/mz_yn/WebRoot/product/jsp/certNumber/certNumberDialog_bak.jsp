<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="zs" type="com.ninemax.jpa.code.model.TZs"--%>
<%--@elvariable id="zsbhb" type="com.ninemax.jpa.code.model.TZsbhb"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="bh" type="com.ninemax.jpa.code.model.TZsbhb"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String source = request.getParameter("source");
    if (source == null)
        source = (String) request.getAttribute("source");
    session.setAttribute("source", source);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>����֤����</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function fCheckValue() {
            var zsbh = document.getElementById("zsbh_suf");
            if (zsbh.value == "") {
                alert("��Ų�����Ϊ�գ�");
                zsbh.focus();
                return false;
            }
            document.getElementById("zsbh").value = document.getElementById("zsbh_pre").value + zsbh.value;
            document.frmThis.submit();
            return true;
        }
        function window_onfocus() {

            <c:if test="${source eq '1' or source eq null}">
            window.close();
            </c:if>
            document.getElementById("zsbh_suf").focus();
        }
        function ches() {
            switch (event.keyCode) {
                case 13:
                    return   fCheckValue();
                default:
                    return true;
            }

        }
    </script>
</head>
<base target="_self">
<body onLoad="return window_onfocus()" onkeypress="ches()">
<div align="center">
    <form name="frmThis" method="post" action="${pageContext.request.contextPath}/bsweb/certificateNumber_saveCertNumber.action">
        <input name="zsbhb.id.zslx" type="hidden" value="${zsbhb.id.zslx}">
        <input name="zs.jgdm" type="hidden" value="${zs.jgdm}">
        <input type="hidden" name="zsbhb.id.zsbh" id="zsbh">

        <div>
            <span style="color: #0000ff;">
                ${(zsbhb.id.zslx eq '0')?'����':'����'}
            </span>
            <span style="color: #FF0000;">
                �Ѵ�ӡ�����밴�����½Ǳ�����룡
            </span>
        </div>
        <div>
            <c:if test="${source eq '0'}">

                <c:if test="${bh eq null}"> �������֤����( <span style="color: #FF0000;">
                        ${zsbhb.id.zsbh}</span> )������!
                </c:if>
                <c:if test="${bh ne null}">
                    <table border="1" align="center" cellspacing="0">
                        <tr>
                            <td colspan="4">
                                �ñ�Ŵ���
                            <span style="color:#FF0000 ">
                                    ${bh.flag=='1'?'ʹ��':bh.flag=='1'?'���':'����'}
                            </span>
                                ״̬
                            </td>
                        </tr>
                        <tr>
                            <td>֤����</td>
                            <td>${bh.id.zsbh} </td>
                            <td>֤������</td>
                            <td>${bh.id.zslx=='0'?'����':'����'} </td>
                        </tr>
                        <tr>
                            <td>��֤����</td>
                            <td>${bh.ssbzjg} </td>
                            <td>�� �� ��</td>
                            <td>${bh.djh} </td>
                        </tr>
                        <tr>
                            <td>�� �� Ա</td>
                            <td>${bh.czy} </td>
                            <td>��ӡʱ��</td>
                            <td>${bh.dysj} </td>
                        </tr>
                    </table>
                </c:if>
            </c:if>
        </div>
        <table border="0" cellpadding="0" cellspacing="3" align="center">
            <tr style="height: 35px">
                <td align="right" style="width:40%">
                    <label for="djh23">    �� �� �ţ�   </label>
                </td>
                <td align="left" style="width:60%">


                        <input name="zsbhb.djh" readonly="readonly" type="text"  id="djh23"
                               value="�����${sysUser.bzjgdm}-${zsbhb.djh}${zsbhb.id.zslx=='0'?'':''}"
                               size="28">

                </td>
            </tr>
            <tr style="height: 35px">
                <td align="right">
                    ֤���ţ�
                </td>
                <td align="left">
                    <input type="text" id="zsbh_pre" name="zsbh_pre" size="10"
                           value="${zsbhb.id.zslx=='0'?sysUser.zsbhpre:sysUser.zsbhpreFb}">
                    <input type="text" id="zsbh_suf" name="zsbh_suf" onblur="document.getElementById('queren').focus();"
                           size="5">
                </td>
         class="newBtn1"          <tr style="height: 35px">
                <td colspan="2" align="center">
                    <input type="button" claclass="newBtn1"="queren" value="ȷ ��" onclick="fCheckValue()">
                    &nbsp;
                    <input type="button" value="ȡ ��" class="btn1" id="cancel"
                           onclick="window.returnValue = '1'; window.close();">
                </td>
            </tr>
            <tr>
                <td height="37" colspan="2" align="left" style="text-indent:10px;">
                    <span style="color:#FF0000;"> ���֤��û����ȷ��ӡ����������ȡ����
                    </span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left" style="text-indent:10px;">
                    <div>
                        <span style="color:#FF0000;">*</span> �������룬֤�����������֤����α��
                    </div>
                    <div>
                        <span style="color:#FF0000;">*</span> ���ֿ�ֽ���߿�ֽ�ȷ�����������벻Ҫ�����ţ�
                    </div>
                    <div style="font-weight:bold;">
                        ����취��
                    </div>
                    <div> 1�����ٴδ�ӡʱ��������ȷ��ţ�</div>
                    <div> 2����ӡ��ȷ�󵽡��޸�֤���š������롣</div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>