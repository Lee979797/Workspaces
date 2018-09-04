<%@ page contentType="text/html; charset=gbk" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String osName = System.getProperty("os.name");
    Boolean linux = false;
    if (osName.contains("linux")) {
        linux = true;
    }
%>
<script type="text/javascript">
    function down() {
        window.location.href = "/servlet/DownLoadAction?id=" + '${task.id}';
    }
</script>
<c:set var="linux" value="<%=linux%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <title>�ޱ����ĵ�</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
</head>
<body>
<div class="page_top">


    <div align="right" style=" float: right;margin-top: 3px;">
        <c:if test="${!(task.imagePath eq null) and imageData ne ''}">
            <%--<a target="_blank"
               href="">
                ���ص���
            </a>--%>
            <%--<input name="button" type="reset" class="btn2" id="button3" value="���ص���" onclick="window.open('http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }');"/>--%>
            <input name="button" type="reset" class="btn2" id="button3" value="���ص���" onclick="down();return false;"/>
        </c:if>
        &nbsp;
        <input name="button3" type="reset" class="newBtn1" id="button31" value="�� ��"
               onclick="window.location.href='/bsweb/scanTask_list?task.status=true'"/>
        &nbsp;
    </div>
    ���� &gt;&gt; ɨ��������� &gt;&gt; �������뵵��
</div>
<div align="left" style="margin-left: 20px;">
    �������룺${task.jgdm}&nbsp;<span>�������ƣ�${task.jgmc}&nbsp;
    �������ڣ�<fmt:formatDate value='${task.createTime}'/>
    ¼�����ڣ�<fmt:formatDate value='${task.compleTime}'/>
</div>
<div align="center">
    <input name="base64" type="hidden" id="base64" value='${imageData}'/>
    <OBJECT
            classid="clsid:A975D268-09B2-4390-ADA2-E83550AA59E4" ID="AAA"
            width=100%
            height=600
            align=center
            hspace=0
            vspace=0
            CODEBASE="http://<%=request.getServerName()+":"+request.getServerPort()%>/product/jsp/scanTask/ImgEdit.CAB#Version=1,0,0,4">
    </OBJECT>
</div>


</body>
<script type='text/javascript'>
    <c:if test="${imageData eq ''}">
    ymPrompt.alert({message: '��Ftp�����������ļ����󣬻���ӵ���δ�ҵ���', width: 330, height: 220, title: '��ʾ��Ϣ'});
    </c:if>
</script>
<script type='text/javascript'>
    (function () {
        var scanner;
        //�ҵ�ͼ��ؼ�                                    S
        scanner = document.getElementById("AAA");
        scanner.ImageMenuText = "{�����,1,1};{��ҵ��׼�ļ�,21,2};{��ҵ��λ��׼�ļ�,22,3};{���������׼�ļ�,23,4};{������׼�ļ�,24,5};{����������׼�ļ�,25,6};{�������������֤��,31,7};{���������֤��,32,8};{С΢��ҵ֤������,5,a};{�����ļ�,4,9}";

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
        //���ÿؼ��Ƿ���ʾ"�༭ģʽ"��ť,ͨ���ð�ť�������ÿؼ��Ƿ���ʾ�༭����,
        scanner.ModifyFlag = 0;
        //���ÿؼ��ڱ���ͼƬʱ�Ƿ���ͼ��ĳߴ�,�������Ϊ1 ,��ImageWidth,ImageHeight���ú�������
        scanner.CheckImageSize = 0;
        //����ָ��URL��ͼ�񵽿ؼ��У����ص�ͼ���Զ���ӵ��ؼ�������ͼ�б��ĩβ
//        txt = "123.txt";
//       ���ÿؼ���ʾ��ͼƬ��עס�����÷ֺŸ���������û������RemarkFlag=1������������ú�������
//        scanner.ImageRemark = txt;
        <c:if test="${imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.Base64ImageStr = base64str;
        <c:if test="${wdidbs !=null and imageData ne ''}">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        </c:if>
        <c:if test="${message!=null && !( '' eq message )}">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '��ʾ��Ϣ'});
        </c:if>
    })();

</script>

</HTML>
