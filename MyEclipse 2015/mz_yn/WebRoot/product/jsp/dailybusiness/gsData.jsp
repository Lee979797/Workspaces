<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.code.model.Qiye" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String zch = clsStringTool.convertNull(request.getParameter("zch"));
    String jgdm = clsStringTool.convertNull(request.getParameter("jgdm"));
    String source = clsStringTool.convertNull(request.getParameter("source"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript">
        var secs = 10; //����ʱ������
        function Load() {
            for (var i = secs; i >= 0; i--) {
                window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
            }
        }
        function doUpdate(num) {
           // document.getElementById('ShowSec').innerHTML = num;
            if (num == 0) {
                if (${card eq "changeCard"}) {
                    window.parent.ymPrompt.doHandler('changeCard', true);
                } else {
                    window.parent.ymPrompt.doHandler('validate', true);
                }
            }
        }

        /*        if(top.location!=self.location)
         top.location=self.location;*/
        //--------------------------------------------
        function fCheckValue() {
            if (isEmpty(thisForm.dzch.value)) {
                ymPrompt.alert({message: "����ע��Ų���Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            document.thisForm.action = "/bsweb/gsAction_findGsByZch.action?jgdmcode=<%=jgdm%>";
            thisForm.submit();
            return true;
        }
        function fGsVsBs(jgdm, zch) {
            document.thisForm.action = "/bsweb/gsAction_gsVsBsData.action?dzch=" + zch + "&jgdmcode=" + jgdm;
            thisForm.submit();
        }
    </script>
    <title>����ע���</title>
    <style type="text/css">
        ul li {
            text-align: left;
        }

        ul li span {
            font-size: 12px;
            font-weight: 100;
        }

        table tr td, table tr th {
            border: 1px solid #dddee6;
        }

        table tr th {
            width: 60px;
        }

        table tr td {
            font-weight: 100;
        }

        .fname {
            color: red;
        }
    </style>
</head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="/bsweb/gsAction_gsVsBsData.action">
<input type="hidden" name="source" id="source" value="<%=source%>"/>

<div class="list_box_top" style="text-align: center;">
<c:choose>
<c:when test="${zt eq '����' and fn:length(qiyeList)>0}">
    <ul>
        <li><span>��ҵ����:</span><b>${qiyeList[0].vqymc }</b></li>
        <li><span>Ӫҵִ�շ�֤����:</span><b><fmt:formatDate value="${qiyeList[0].dhzrq}" pattern="yyyy-MM-dd"/></b>
        </li>
        <li style="margin-top: 10px;">&nbsp;</li>
        <li>
            <input name="button3" type="button" class="newBtn1" id="button3"
                   onclick="fGsVsBs('${jgdmcode}','${dzch}')" value="ȷ ��"/>
            <input name="button4" type="button" class="newBtn1" id="button4"
                   onclick="window.parent.ymPrompt.doHandler('fsearch',true);" value="ȡ ��"/>
        </li>
    </ul>

</c:when>
<c:when test="${zt eq '����' and fn:length(qiyeList)>0}">
    <ul>
        <li></li>
        <li><span>�û����ڹ����ѱ�ע�������!(�Ƿ�ע��)</span></b>
        </li>
        <li style="margin-top: 10px;">&nbsp;</li>
        <li>
            <input name="button3" type="button" class="newBtn1" id="button3"
                   onclick="doUpdate('0')" value="ȷ ��"/>
            <input name="button4" type="button" class="newBtn1" id="button4"
                   onclick="window.parent.ymPrompt.doHandler('fsearch',true);" value="ȡ ��"/>
                    <script type="text/javascript">
                    //window.parent.ymPrompt.doHandler('fsearch',true);
                   // doUpdate('0');
                    </script>
        </li>
    </ul>

</c:when>
<c:when test="${resultMsg!=null and resultMsg!=''}">
    <p>${resultMsg},�Ƿ��������ҵ��</p>
    <br/>
            <input name="button4" type="button" class="newBtn1" id="button4"
                   onclick="window.parent.ymPrompt.doHandler('fsearch',true);" value="ȷ��"/>
    <input name="button3" type="button" class="newBtn1" id="button3"
                   onclick="window.parent.ymPrompt.doHandler('goReturn',true);" value="����"/>

    
    <script type="text/javascript"></script>
</c:when>
<c:when test="${qiye!=null and tjgdm!=null}"><%--@elvariable id="qiye" type="com.ninemax.jpa.code.model.Gtgsh"--%>
    <%--@elvariable id="tjgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
    <script type="text/javascript">window.parent.ymPrompt.resizeWin(680, 450);</script>
    <c:if test='${card eq "changeCard"}'>
        <div style="font-weight: 100;font-weight: bold;">�������ơ����ˡ���ַ��һ�£�ϵͳ���� <span id="ShowSec"
                                                                                  style="color:#0099FF">10</span>
            ����Զ�ת�뻻֤ҳ�棡
        </div>
        <script type="text/javascript">Load();</script>
        <br/>
    </c:if>

    <table cellpadding="0" cellspacing="0">
        <caption
                style="text-align: left;border: 1px solid #dddee6;background-color: #dddee6;font-size: 14px;">
            <em>
                ���ݶԱ�
            </em>
        </caption>
        <tbody>
        <tr class="pname">
            <th width="10%">
                ��Դ
            </th>
            <td width="45%">
                <b>��������</b>
            </td>
            <td width="45%">
                <b>��������</b>
            </td>
        </tr>
        <tr class="pname">
            <th>
                ��������
            </th>
            <td>
                    ${qiye.vqymc}
            </td>
            <td ${(tjgdm.jgmc ne qiye.vqymc)?"class='fname'":""}>
                    ${tjgdm.jgmc}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ������ַ
            </th>
            <td>
                    ${qiye.vzs}
            </td>
            <td ${(tjgdm.jgdz ne qiye.vzs)?"class='fname'":""}>
                    ${tjgdm.jgdz}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ��Ӫ��Χ
            </th>
            <td>
                    ${qiye.vchrJyfw}
            </td>
            <td ${(tjgdm.jyfw ne qiye.vchrJyfw)?"class='fname'":""}>
                    ${tjgdm.jyfw}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ��������
            </th>
            <td>
                <c:set var="qyrq" value='<%=DateUtil.dateToStr(((Qiye)request.getAttribute("qiye")).getDclrq())%>'/>
                <c:set var="dmrq" value='<%=DateUtil.dateToStr(((TJgdm)request.getAttribute("tjgdm")).getZcrq())%>'/>
                    ${qyrq}
            </td>
            <td ${(dmrq ne qyrq)?"class='fname'":""}>
                    ${dmrq}
            </td>
        </tr>

        <tr class="pname">
            <th>
                ��Ӫ����
            </th>
            <td>
                <c:set var="qyrq" value='<%=DateUtil.dateToStr(((Qiye)request.getAttribute("qiye")).getDjyqxz())%>'/>
                <c:set var="dmrq" value='<%=DateUtil.dateToStr(((TJgdm)request.getAttribute("tjgdm")).getGsfzrq())%>'/>
                    ${qyrq}
            </td>
            <td ${(dmrq ne qyrq)?"class='fname'":""}>
                    ${dmrq}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ע���ʽ�
            </th>
            <td>
                    ${qiye.numZczb}
            </td>
            <td ${(tjgdm.zczj ne qiye.numZczb)?"class='fname'":""}>
                    ${tjgdm.zczj}
            </td>
        </tr>
        <tr>
        <td colspan="3">
        <h5><font color="red">������Ϣ�����鿴�������е��룡</font></h5>
        </td>
        </tr>
        <tr class="pname">
            <th>
                ��׼����
            </th>
            <td>
                    ${qiye.cdjjg}
            </td>
            <td ${(fn:trim(tjgdm.pzjgmc) ne fn:trim(qiye.cdjjg) )?"class='fname'":""}>
                    ${tjgdm.pzjgmc}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ���˴���
            </th>
            <td>
                    ${qiye.vchrXm}
            </td>
            <td ${(tjgdm.fddbr ne qiye.vchrXm)?"class='fname'":""}>
                    ${tjgdm.fddbr}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ��������
            </th>
            <td>
                    ${qiye.cyzbm}
            </td>
            <td ${(tjgdm.yzbm ne qiye.cyzbm)?"class='fname'":""}>
                    ${tjgdm.yzbm}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ��ϵ�绰
            </th>
            <td>
                    ${qiye.vlxdh}
            </td>
            <td ${(tjgdm.dhhm ne qiye.vlxdh)?"class='fname'":""}>
                    ${tjgdm.dhhm}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ֤������
            </th>
            <td>
                    ${qiye.chrZjhm}
            </td>
            <td ${(fn:trim(tjgdm.zjhm)  ne fn:trim(qiye.chrZjhm))?"class='fname'":""}>
                    ${tjgdm.zjhm}
            </td>
        </tr>
        <tr class="pname">
            <th>
                ����������
            </th>
            <td>
                <c:set var="qyrq" value='<%=((Qiye)request.getAttribute("qiye")).getZhnjnd()%>'/>
                <c:set var="dmrq" value='<%=DateUtil.dateToStr(((TJgdm)request.getAttribute("tjgdm")).getNjrq())%>'/>
                <c:set var="source" value='<%=source%>'/>
                    ${qyrq}
            </td>
            <td ${(dmrq ne qyrq)?"class='fname'":""}>
                    ${dmrq}
            </td>
        </tr>
        </tbody>
    </table>

    <c:if test='${card ne "changeCard"}'>
    <c:choose>

   <c:when test="${source eq 'check' and tjgdm.jgmc ne qiye.vqymc and tjgdm.jgdz ne qiye.vzs}">
       <input name="button5" type="button" class="newBtn1" id="button5" disabled="true"
               onclick="window.parent.ymPrompt.doHandler('daoru|${qiye.czch}',true);" value="�� ��"/>
   </c:when>
   <c:otherwise>  
    <input name="button5" type="button" class="newBtn1" id="button5"
               onclick="window.parent.ymPrompt.doHandler('daoru|${qiye.czch}',true);" value="�� ��"/>
   </c:otherwise>
  
</c:choose>
       
        <input name="button6" type="button" class="newBtn1" id="button6"
               onclick="window.parent.ymPrompt.doHandler('fsearch',true);" value="ȡ ��"/>
    </c:if>
</c:when>
<c:otherwise>
    ����ע��ţ�
    <input name="dzch" type="text" class="input_120" maxlength="30" id="dzch" value="<%=zch%>"/>

    <p>&nbsp;</p>
    <input name="button2" type="button" class="newBtn1" id="button2" value="ȷ ��" onclick="fCheckValue();"/>
</c:otherwise>
</c:choose>
</div>
</form>
</body>

</html>
