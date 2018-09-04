<%--@elvariable id="dfile" type="com.ninemax.jpa.code.model.DFile0"--%>
<%@ page language="java" pageEncoding="GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title> �����������</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript">

        function checkpass() {
            document.getElementById("ispass").value = "1";
            document.form1.submit();
        }

        function checknopass() {
            document.getElementById("ispass").value = "2";
            document.form1.submit();
        }
    </script>

</head>
<body>
<div class="page_top_fixed">
    <div align="right" style="width: 30% ; float: right;margin-top: 3px;">

        <input name="button3" type="button" class="newBtn1"
               id="button" value="�� ��"
               onclick="checkpass();"/>
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="�� ��"
               onclick="window.location.href='/bsweb/scanTask_list_dfile'"/> &nbsp;&nbsp;&nbsp;</div>
    ��� &gt;&gt; ��˹��� &gt;&gt; �������
</div>
<div id="list_main">
<form name="form1" id="form1" action="/bsweb/scanTask_auditing.action" method="post" style="margin:0; padding:0;">
    <input name="dfile.did" type="hidden" value="${dfile.did}"/>
    <input name="dfile.jgdm" type="hidden" value="${dfile.jgdm}"/>
    <input name="dfile.attr" id="ispass" type="hidden" value=""/>

    <div style="padding: 10px 0px;"><br/>
        <table width="100%" bgcolor="#ddf1fa" bordercolor="#8ec2e0" border="1" style="border-collapse:collapse; "
               cellpadding="0" cellspacing="0">
            <tr>
                <td width="80" align="center" nowrap="nowrap" bgcolor="#b3e0fa"> �������⣺</td>
                <td align="left"
                    style="height: 28px;    line-height: 28px;    overflow: hidden;vertical-align:top;overflow: hidden;">
                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="radio" checked="checked" name="dfile.errorflag" value="-1"/> ��
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="1"> ͼ������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="2"/> ͼ��ڱߡ���б
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="3"/> ͼ���ɨ
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="4"> ͼ���ȱ
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="5"> �������ڴ���
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="6"> �����������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="7"> ������ʶ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="8"> ��׼֤���ʶ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="9"> ���֤���ļ���ʶ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="10"> �����ļ���ʾ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="11"> ��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="12"> ��׼�ļ����ϸ�
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="13"> ȱҳ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="14"> δ������
                    </div>


                </td>
            </tr>
            <tr>
                <td width="80" align="center" nowrap="nowrap" bgcolor="#b3e0fa"> �������⣺</td>
                <td align="left"
                    style=" vertical-align:top;overflow: hidden;">

                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="checkbox" name="data[0]" id="data_jgmc" value="1"/> <label for="data_jgmc">
                        �������� </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[1]" id="data_jgdz" value="1"/> <label for="data_jgdz">
                        ������ַ </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[2]" id="data_jydz" value="1"/> <label for="data_jydz">
                        ��Ӫ��ַ </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[3]" id="data_bzjgdm" value="1"/> <label
                            for="data_bzjgdm">
                        ��֤�������� </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[4]" id="data_jglx" value="1"/> <label for="data_jglx">
                        �������� </label>
                    </div>
                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="checkbox" name="data[5]" id="data_njjlx" value="1"/> <label for="data_njjlx">
                        �¾������� </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[6]" id="data_jjlx" value="1"/> <label for="data_jjlx">
                        �������� </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[7]" id="data_njjhy" value="1"/> <label for="data_njjhy">
                        �¾�����ҵ </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[8]" id="data_jjhy" value="1"/> <label for="data_jjhy">
                        ������ҵ </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[9]" id="data_xzqh" value="1"/> <label for="data_xzqh">
                        �������� </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[10]" value="1"/> ���ܻ�������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[11]" value="1"/> ���ܻ�������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[12]" value="1"/> ��׼��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[13]" value="1"/> ��׼��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[14]" value="1"/> �ⷽͶ�ʹ���
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[15]" value="1"/> ����������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[16]" value="1"/> ֤������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[17]" value="1"/> �绰����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[18]" value="1"/> ע���ʽ�
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[19]" value="1"/> ��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[20]" value="1"/> ��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[21]" value="1"/> ��׼�ĺ�
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[22]" value="1"/> ע���
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[23]" value="1"/> ע������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[24]" value="1"/> ְ������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[25]" value="1"/> ��֤����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[26]" value="1"/> ��������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[27]" value="1"/> �������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[28]" value="1"/> �������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[29]" value="1"/> �������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[30]" value="1"/> ���������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[31]" value="1"/> ����
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[32]" value="1"/> ����������
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[33]" value="1"/> ���������֤��
                        <input type="hidden" name="data[34]" value="1"/>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <br/>
</form>
<div class="list" style="padding:0px; border:none;">
    <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
        <tr>
            <td class="title_txt"> �������</td>
        </tr>
    </table>
    <div class="content">
        <table width="100%" border="1" bordercolor="#cccccc" cellpadding="0" cellspacing="0"
               style="border-collapse: collapse;">
            <tr height="35">
                <td align="left" width="15%">
                    �걨��� ${dfile.arctype eq '0'?"����": dfile.arctype eq '1'?"��������" :dfile.arctype eq '2'?"Ԥ�������" :dfile.arctype eq '3'?"���" :dfile.arctype eq '4'?"��֤" :dfile.arctype eq '5'?"���" :dfile.arctype eq '6'?"ʡ��Ǩ��":dfile.arctype eq '7'?"ʡ��Ǩ��": dfile.arctype eq '8'?"Ԥ����" :""}
                </td>
                <td align="center" > �������ƣ�${dfile.jgmc}</td>
                <td align="right" width="15%"> �������룺${dfile.jgdm}</td>
                <td align="right" > �������ڣ�<fmt:formatDate value="${dfile.createtime}"/></td>
            <tr>
            <tr>
                <td align="center" valign="top" colspan='4'>
                    <input name="base64" type="hidden" id="base64" value="${imageData}"/>
                    <OBJECT classid="clsid:A975D268-09B2-4390-ADA2-E83550AA59E4" ID="AAA" width=100% height=600
                            align=center hspace=0 vspace=0
                            CODEBASE="http://<%=request.getServerName()+":"+request.getServerPort()%>/product/jsp/scanTask/ImgEdit.CAB#Version=1,0,0,1">
                    </OBJECT>
                </td>
            </tr>
            <jsp:include page="../common/show-jgdm.jsp"/>
        </table>
    </div>

</div>
</div>
</body>

<script type='text/javascript'>
    (function () {
        var ff , scanner, txt;
        //�ҵ�ͼ��ؼ�
        scanner = document.getElementById("AAA");
        //����ɨ��ֱ��ʣ��������ɨ��������Բ�����
        //  scanner.DIP = 150;
        /*scanner.DownLoadImage("http://
        <%=request.getServerName()+":"+request.getServerPort()%>/
        ${linux?'':'upload'}${task.imagePath eq null?'':fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }");*/

        //����ɨ����ɫģ��,Ϊ0��ʾ�ڰ�,Ϊ1��ʾ�Ҷ�,Ϊ2��ʾRGB��ɫ
        scanner.ColorModel = 2;
        //����ɨ����ÿ���ص�λ��С,Ϊ8��ʾÿ��������8��λ����ʾ
        scanner.Depth = 8;
        //���ÿؼ��ı༭ģʽ,Ϊ0��ʾֻ��,�����޸�ͼ��,Ϊ1��ʾֻ�ܴ��ļ���������,���Խ����޸�,Ϊ2��ʾ�ܴ��ļ�����ɨ���ǵ�������,���Խ����޸�
        scanner.EditModel = 0;
        //���ÿؼ�����ͼ������ʱ�����ͼ����,�����ͼ�������������ܱ���
        // scanner.ImageWidth = 800;
        //���ÿؼ�����ͼ������ʱ�����ͼ��߶�,�����ͼ��������߶����ܱ���
        scanner.ImageHeight = 600;
        //���ÿؼ�����ͼ��ʱ���ļ���ʽ,Ϊ0��ʾTIFF,���Ա������ͼ��,Ϊ1��ʾJPEG,ֻ�ܱ���һ��ͼ��
        scanner.ImageFormat = 0;
        //���ÿؼ��Ƿ���ʾͼƬ��ע,Ϊ1 ��ʾ��ʾͼƬ��ע,Ϊ0��ʾ������ʾͼƬ��ע
        scanner.RemarkFlag = 1;
//        txt = "123.txt";
//       ���ÿؼ���ʾ��ͼƬ��עס�����÷ֺŸ���������û������RemarkFlag=1������������ú�������
//        scanner.ImageRemark = txt;
        <c:if test="${wdidbs !=null and imageData ne ''}">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        //���ÿؼ��Ƿ���ʾ"�༭ģʽ"��ť,ͨ���ð�ť�������ÿؼ��Ƿ���ʾ�༭����,
        scanner.ModifyFlag = 0;
        //���ÿؼ��ڱ���ͼƬʱ�Ƿ���ͼ��ĳߴ�,�������Ϊ1 ,��ImageWidth,ImageHeight���ú�������
        scanner.CheckImageSize = 0;
        //����ָ��URL��ͼ�񵽿ؼ��У����ص�ͼ���Զ���ӵ��ؼ�������ͼ�б��ĩβ
        <c:if test="${imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.Base64ImageStr = base64str;
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        <c:if test="${message!=null && !( '' eq message )}">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '��ʾ��Ϣ'});
        </c:if>
    })();
</script>
</html> 
