<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <TITLE>����֤��У�Ե���ӡ</TITLE>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript">
        var hkey_root, hkey_path, hkey_key
        hkey_root = "HKEY_CURRENT_USER"
        hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //������ҳ��ӡ��ҳüҳ��Ϊ��
        function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
            } catch (e) {
            }
        }
        function printPage() {
            pagesetup_null();
            window.print();
            window.close();
        }
    </script>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0;
            font-size: 13px;
            color: #000;
            font-family: Arial, Helvetica, sans-serif;
            line-height: 15px;
        }

        .formpage {
            width: 682px;
            /*     height: 1026px;*/
            margin: 0 auto;
            overflow: hidden;
        }

        h1 {
            font-size: 24px;
            margin: 10px 0;
            text-align: center;
        }

        p {
            margin: 5px 0;
        }

        table, td {
            background: #FFFFFF;
            border-collapse: collapse;
            border: 1px solid #000;
        }

        .formpage span {
            padding: 0 5px;
        }

        .formpage span b {
            font-size: 21px;
        }

        #jyfw {
            font-size: 8px;
            line-height: 10px;
        }

        #jyfw1 {
            font-size: 10px;
            line-height: 12px;
        }

        #jyfw2 {
            font-size: 12px;
            line-height: 14px;
        }
    </style>
</head>
<body>
<div class="page_top_fixed" id="page_top" style="float: right;">

    <input name="button3" type="button" class="newBtn1" id="button31" value="�� ӡ"
           onclick="page_top.style.display='none';printPage();"/>
    &nbsp;
</div>
<div class="formpage">
    <h1>��������֯���������걨��</h1>

    <form action="" method="get">
        <table width="98%" align="center" cellpadding="5" cellspacing="0">
            <tr>
                <td width="18%" align="center">��������</td>
                <td colspan="2">&nbsp;${jgdm.jgdm}
                </td>
                <td width="16%" align="center">�����Ƿ�����</td>
                <td colspan="2">&nbsp;${(jgdm.gk ne '1')?'��':'��'}</td>
            </tr>
            <tr align="center">
                <td align="center">��������</td>
                <td colspan="5" align="left">&nbsp;${jgdm.jgmc}</td>
            </tr>
            <tr>
                <td align="center">���˴���/������
                </td>
                <td colspan="2">&nbsp;${jgdm.fddbr}</td>
                <td align="center">֤���ͺ���</td>
                <td colspan="2">&nbsp;${zjlxMap[jgdm.zjlx]}:${jgdm.zjhm}</td>
            </tr>
            <tr align="center">
                <td height="40" align="center">�ɶ�</td>
                <td colspan="5">&nbsp;${jgdm.bak5}</td>
            </tr>
            <tr>
                <td height="150" align="center">��Ӫ��ҵ��<br/>��&nbsp;&nbsp;&nbsp;&nbsp;Χ
                </td>
                <td colspan="5">
                    <c:set var="len" value="${fn:length(fn:trim(jgdm.jyfw))}"/>
                    <div align="left" id="${len>800?'jyfw':len>600?'jyfw1':len>400?'jyfw2':'jyfw3'}">
                        &nbsp;${jgdm.jyfw}</div>
                </td>
            </tr>
            <tr>
                <td align="center">���ܲ���</td>
                <td colspan="5">&nbsp;${jgdm.zgmc}</td>
            </tr>
            <tr>
                <td align="center">��������</td>
                <td colspan="2">&nbsp;<fmt:formatDate pattern="yyyy��MM��dd��"
                                                      value="${jgdm.zcrq}"/></td>
                <td align="center">ע���ʽ�</td>
                <td colspan="2" align="center">${jgdm.zczj}��Ԫ</td>
            </tr>
            <tr>
                <td align="center">ְ������</td>
                <td width="14%">&nbsp;${jgdm.zgrs}</td>
                <td width="19%" align="center">��������</td>
                <td>&nbsp;${hbMap[fn:trim(jgdm.hbzl)]}</td>
                <td width="18%" align="center">�ⷽ��������</td>
                <td width="17%">&nbsp;${jgdm.wftzgb}</td>
            </tr>
            <tr>
                <td align="center">��Ҫ��Ʒ</td>
                <td colspan="5">
                    &nbsp;${jgdm.zycp1}${(jgdm.zycp1 eq (null or '')?'':';')}${jgdm.zycp2}${(jgdm.zycp2 eq (null or '')?'':';')}${jgdm.zycp3}</td>
            </tr>
            <tr>
                <td rowspan="2" align="center">ע���ַ</td>
                <td colspan="5">&nbsp;${jgdm.jgdz}</td>
            </tr>
            <tr>
                <td align="center">��������</td>
                <td colspan="2">&nbsp;${xzqhMap[fn:trim(jgdm.xzqh)]}</td>
                <td align="center">��������</td>
                <td>&nbsp;${jgdm.yzbm}</td>
            </tr>
            <tr>
                <td align="center">��λ�绰</td>
                <td colspan="2">&nbsp;${jgdm.dhhm}</td>
                <td align="center">�����ֻ�</td>
                <td colspan="2" align="left">&nbsp;${jgdm.mobile}</td>

            </tr>
            <tr>
                <td align="center">�Ǽ���׼����</td>
                <td colspan="3">&nbsp;${jgdm.pzjgmc}</td>
                <td colspan="2" rowspan="6" valign="top">�ҵ�λ�����ṩ���Ϻ����ݵ���ʵ�Գе���Ӧ�ķ������Ρ�
                    <p/>
                    <br/>

                    <p>&nbsp;</p>

                    <p>&nbsp;</p>

                    <p style="text-align: center;">�����£�</p>

                    <p>&nbsp;</p>

                    <p>&nbsp;</p>
                </td>
            </tr>
            <tr>
                <td colspan="1" align="center">ע���</td>
                <td colspan="3">&nbsp;${jgdm.zch}</td>
            </tr>
            <tr>
                <td align="center">��������</td>
                <td align="left">��������&nbsp;${jgdm.zbsl}</td>
                <td align="left">��������&nbsp;${jgdm.fbsl}</td>
                <td align="left">IC������&nbsp;${jgdm.fksl}</td>

            </tr>
            <tr>
                <td align="center">������</td>
                <td>&nbsp;${jgdm.tbrxm}</td>
                <td align="center">�������ֻ�</td>
                <td>&nbsp;${jgdm.tbrlxfs}</td>
            </tr>
            <tr>
                <td align="center">֤������</td>
                <td colspan="3">&nbsp;${jgdm.tbrsfzh}</td>
            </tr>
            <tr>
                <td colspan="4"><p>������˶Ա�����ݣ�ȷ�������ǩ�֡� <br/>
                    �����ˣ� </p>
                    <br/>

                    <p/>

                    <p style="text-align:right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��</p>
                </td>
            </tr>
            <tr>
                <td colspan="6"><p>���������ɴ�����������д��</p>

                    <p>
                        <span>�°� <b>��</b></span> <span>��� <b>��</b></span> <span>��֤ <b>��</b></span>
                        <span>��� <b>��</b></span>
                        <span>���� <b>��</b></span> <span>��֤ <b>��</b></span> <span>ʡ��Ǩ�� <b>��</b></span>
                        <span>ʡ��Ǩ�� <b>��</b></span>
                    </p></td>
            </tr>
            <tr>
                <td align="center">������ҵ2000��</td>
                <td colspan="2">&nbsp;${njjhyMap[fn:trim(jgdm.njjhy)]}</td>
                <td align="center">��ҵ��ҵ1994��</td>
                <td colspan="2">&nbsp;${jjhyMap[fn:trim(jgdm.jjhy)]}</td>
            </tr>
            <tr>
                <td align="center">��������2000��</td>
                <td colspan="2">&nbsp;${njjlxMap[fn:trim(jgdm.njjlx)]}</td>
                <td align="center">��������1994��</td>
                <td colspan="2">&nbsp;${jjlxMap[fn:trim(jgdm.jjlx)]}</td>
            </tr>
            <tr>
                <td align="center">��������</td>
                <td colspan="2">&nbsp;${jglxMap[fn:trim(jgdm.jglx)]}</td>
                <td align="center">��֤����</td>
                <td colspan="2">&nbsp;${zrxzqhMap[fn:trim(jgdm.bzjgdm)]}</td>
            </tr>
            <tr>
                <td align="center">��������</td>
                <td colspan="2">&nbsp;<input type="text" name="tpwrq"
                                             onfocus="WdatePicker({el:$dp.$('tpwrq'),dateFmt:'yyyy��MM��dd��'});"
                                             style="border-style: solid; border-color: #FFFFFF"
                                             value="<fmt:formatDate pattern='yyyy��MM��dd��' value='${jgdm.lastdate}'/>"
                                             maxlength="11"/>
                </td>
                <td align="center">֤��ע������</td>
                <td colspan="2">&nbsp;<fmt:formatDate pattern="yyyy��MM��dd��"
                                                      value="${jgdm.zfrq}"/></td>
            </tr>
            <tr>
                <td align="center">������</td>
                <td>&nbsp;</td>
                <td align="center">�����</td>
                <td>&nbsp;</td>
                <td align="center">¼����</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td height="49" align="center">��ѯ�ͱ�ע</td>
                <td colspan="5">&nbsp;</td>
            </tr>
        </table>
        <p style="width:96%; margin:0 auto; text-align:right;">ȫ����֯��������������ļ���</p>
    </form>
</div>
<!--end formpagee-->
</body>
</html>
