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
<c:set var="nnjjhyMap" value="<%= InitSysParams.jjhy2k1Map%>"/>
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
    <script type="text/javascript" src="/js/tools.js"></script>
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
            page_top.style.display = 'none';
            pagesetup_null();
            window.print();
            page_top.style.display = 'inline';
        }
    </script>
 <style type="text/css">
html,body{ margin:0px; padding:0px;}
*{ margin:0px; padding:0px;}
.container{ width:620px; margin:0px auto;}
.header{ line-height:50px; font-size:30px; text-align:center;}
.date{ padding:5px 0px;}
.date p{ height:25px; line-height:25px; text-align:right; font-size:14px;}
.date p strong{ font-weight:normal; font-size:20px;}
.date p span{ float:left; display:inline-block;}
.title{ line-height:50px; font-size:16px;}
.title strong{}
.title span{ float:right; font-size:12px;}
.table_box{ border-collapse:collapse;}
.table_box td{ line-height:20px; padding:3px; font-size:12px;}
.info{}
.info h1{ font-size:18px; line-height:40px; text-align:center;}
.info ul{}
.info ul li{ list-style:none; line-height:23px; font-size:14px;}
.info h3{ font-size:16px; line-height:30px; padding:10px 0px;}
.info h6{ font-size:14px; line-height:20px; padding:10px 0px;}
</style>
</head>
<body>
<div class="page_top_fixed" id="page_top" style="float: right;">
    <input name="button3" type="button" class="newBtn1" id="button31" value="�� ӡ"
           onclick="printPage();"/>
    &nbsp;
    <input name="button3" type="button" class="newBtn1" id="button32" value="�ر�"
           onclick="window.close();"/>
</div>
<div class="container">
    <div class="date">
        <p style="padding-right:200px;">�������룺<span>��ˮ�ţ�</span></p>
    </div>
	<div class="header">��������֯��������֤�걨��</div>
    <div class="date">
        <p><span>��������д��</span></p>
    </div>
    <table class="table_box" bordercolor="#333333" cellpadding="0" cellspacing="0" border="1" width="100%" style="margin-bottom:10px;">
    	<tr>
        	<td align="center">��֯��������</td>
            <td colspan="8">${jgdm.jgmc}</td>
        </tr>
        <tr>
        	<td rowspan="2" align="center">����������<br />�������ˣ�</td>
            <td colspan="2">${jgdm.fddbr}</td>
            <td colspan="3" align="center">����������(������)���֤������</td>
            <td colspan="3">${zjlxMap[fn:trim(jgdm.zjlx)]}</td>
        </tr>
        <tr>
        	<td align="center" width="9%">�ֻ�</td>
            <td colspan="2">${jgdm.mobile}</td>
            <td colspan="5">${jgdm.zjhm}</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">��Ӫ(ҵ��)��Χ<br />����ְ��<br />(��ҵ����ҵ��λ��<br />����������֤��)</td>
            <td colspan="7" height="60">
            <c:set var="len" value="${fn:length(fn:trim(jgdm.jyfw))}"/>
                    <div align="left" id="${len>800?'jyfw':len>600?'jyfw1':len>400?'jyfw2':'jyfw3'}">
                        &nbsp;${jgdm.jyfw}</div>
            </td>
        </tr>
        <tr>
        	<td align="center">��������</td>
            <td colspan="2" align="center"><fmt:formatDate pattern="yyyy��MM��dd��" value="${jgdm.zcrq}"/></td>
            <td align="center">��Ч����</td>
            <td colspan="3" align="center"><fmt:formatDate pattern="yyyy��MM��dd��" value="${jgdm.zfrq}"/></td>
            <td align="center">ְ������</td>
            <td align="right">${jgdm.zgrs}(��)</td>            
        </tr>
        <tr>
        	<td colspan="2" align="center">ע��(����)�ʽ�</td>
            <td align="right" colspan="2"><fmt:formatNumber pattern="0.####" value="${jgdm.zczj}"/>&nbsp;����Ԫ��</td>
            <td align="center">��������</td>
            <td>${hbMap[fn:trim(jgdm.hbzl)]}</td>
            <td align="center">��ҵע������</td>
            <td colspan="2">${jglxMap[fn:trim(jgdm.jglx)]}</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">���ܲ���</td>
            <td colspan="3">${jgdm.zgmc}</td>
            <td align="center">��������</td>
            <td colspan="3">${jgdm.jgdm}</td>
        </tr>
        <tr>
        	<td rowspan="2" align="center">ע���ַ</td>
            <td colspan="8">&nbsp;${jgdm.jgdz}</td>
        </tr>
        <tr>
        	<td align="center">��������</td>
            <td colspan="4">${xzqhMap[fn:trim(jgdm.xzqh)]}</td>
            <td align="center">��������</td>
            <td colspan="2">${jgdm.yzbm}</td>
        </tr>
        <tr>
        	<td rowspan="4" align="center">ͨѶ����</td>
            <td align="center">�绰1</td>
            <td colspan="2">${jgdm.mobile}</td>
            <td colspan="2" align="center">��˰�ǼǺ�</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td align="center">�绰2</td>
            <td colspan="2">${jgdm.dhhm}</td>
            <td colspan="2" align="center">��˰�ǼǺ�</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td align="center">����</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">��������</td>
            <td colspan="3">${jgdm.khyh}</td>
        </tr>
        <tr>
            <td align="center">��������</td>
            <td colspan="2">${jgdm.email}</td>
            <td colspan="2" align="center">�����˺�</td>
            <td colspan="3">${jgdm.khzh}</td>
        </tr>
        <tr>
        	<td align="center">�Ǽ���׼����</td>
            <td colspan="3">${jgdm.pzjgmc}</td>
            <td colspan="2" align="center">�Ǽ���׼�ĺŻ�ע���</td>
            <td colspan="3">${jgdm.zch}</td>
        </tr>
        <tr>
        	<td width="12%" align="center">������Ϣ<br />�Ƿ�����</td>
            <td width="20%" colspan="2" align="center">${(jgdm.gk ne '1')?'��':'��'}</td>
            <td width="9%" align="center">����U-key</td>
            <td width="9%"></td>
            <td width="10%" align="center">����IC��</td>
            <td width="12%">${"1"==jgdmSave.fkbz?"jgdmSave.fksl":"��"}</td>
            <td width="8%" align="center">����<br />֤�鸱��</td>
            <td width="10%" align="right">${jgdm.fbsl}</td>
        </tr>
        <tr>
        	<td colspan="9">
            	<p style="text-indent:24px; font-weight:bold;">����������λί�����¾�����������֯��������֤�顣����λ��ŵ������Ϣ��ʵ׼ȷ�����ύ��֤���ļ���֤����ԭ������ʵ�����Է��ġ���֤�����ջ��ء�����λԸ�е�����ύ�����Ϣ��������������ȫ�����ɺ����</p>
                <p style="text-align:right; font-weight:bold;">�����ˣ�ǩ�֣���________________ ��ϵ�绰��_______________</p>
                <p style="text-align:right; font-weight:bold;">���뵥λ�����£���________________________</p>
                <p style="text-align:right; font-weight:bold;">������ڣ�________��____��____��</p>
            </td>
        </tr>
        <tr>
        	<td colspan="2" align="center">���������֤������</td>
            <td >���֤��</td>
            <td colspan="6"> ${jgdm.tbrsfzh}</td>
        </tr>
    </table>
    
    <div class="date">
        <p><span>��֤������д��</span></p>
    </div>
	
    <table class="table_box" bordercolor="#333333" cellpadding="0" cellspacing="0" border="1" width="100%">
    	<tr>
        	<td width="8%" align="center">���걨</td>
            <td width="6%"></td>
            <td width="6%" align="center">��֤</td>
            <td width="6%"></td>
            <td width="10%" align="center">���ڻ�֤</td>
            <td width="6%"></td>
            <td width="10%" align="center">�����֤</td>
            <td width="6%"></td>
            <td width="12%" align="center">U-key��IC��</td>
            <td width="6%"></td>
            <td width="6%" align="center">����</td>
            <td width="6%"></td>
            <td width="6%" align="center">����</td>
            <td width="6%"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">��������(94��)</td>
            <td colspan="4"> </td>
            <td colspan="2" align="center">������ҵ(94��)</td>
            <td colspan="5"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">��������</td>
            <td colspan="4">${jglxMap[fn:trim(jgdm.jglx)]}</td>
            <td colspan="2" align="center">��׼��������</td>
            <td colspan="5">${jgdm.pzjgdm}</td>
        </tr>
        <tr>
        	<td colspan="3" align="center">����֤��Ч��</td>
            <td colspan="5" align="center"><fmt:formatDate pattern="yyyy��MM��dd��" value="${jgdm.bzrq}"/></td>
            <td align="center">��</td>
            <td colspan="5" align="center"><fmt:formatDate pattern="yyyy��MM��dd��" value="${jgdm.zfrq}"/></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">������</td>
            <td colspan="2"><%=((User)session.getAttribute("sysUser")).getUserName()%></td>
            <td align="center">���Ա</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">¼��Ա</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">У����</td>
            <td colspan="2"></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">��ˮ��</td>
            <td colspan="4"></td>
            <td align="center">֤����</td>
            <td colspan="2">${jgdm.zsbh}</td>
            <td align="center" colspan="2">��ע</td>
            <td colspan="3">${jgdm.memo}${jgdm.memo1}${jgdm.memo2}</td>
        </tr>
    </table>
    
    <div class="date">
        <p><span>������ݣ��������� ��&nbsp;&nbsp;&nbsp;&nbsp;������ַ ��&nbsp;&nbsp;&nbsp;&nbsp;���˴��� ��&nbsp;&nbsp;&nbsp;&nbsp;�������� ��&nbsp;&nbsp;&nbsp;&nbsp;</span></p>
        <p>��������֯�����������������</p>
    </div>
    
</div>
</body>
</html>