<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%
    String savePath =  CommonPropertiesUtil.getValue("common.properties", "filepath");
    String tempPath = savePath;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>�����ϴ�</title>
    <!--װ���ļ�-->
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script src="<%=request.getContextPath()%>/fckeditor/fckeditor.js"
            type="text/javascript"></script>
    <script type="text/javascript" src="../frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/dwr/interface/AttachmentBus.js'></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <link href="/jquery/uploadify.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/jquery/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="/jquery/swfobject.js"></script>
    <script type="text/javascript"
            src="/jquery/jquery.uploadify.v2.1.0.min.js"></script>
    <!--ready�¼�-->
    <script type="text/javascript">
        var arr = window.dialogArguments.document.getElementsByName("file");
        var fileArray = [];
        fileArray = parentFiles(arr);
        $(document).ready(
                function () {
                    var uuid=window.dialogArguments.document.getElementById("uuid").value;
                    $("#uploadify").uploadify({//��ʼ������
                        'uploader': '/jquery/uploadify.swf',//flash�� ��λ�ã�ע��·��
                        'script': '<%=request.getContextPath()%>/servlet/Upload',//��̨���������
                        'cancelImg': '/jquery/cancel.png',//ȡ����ťͼƬ
                        'folder': '/jquery/uploadsFolder',//���뽫�ļ����浽��·������auto����Ϊtrue������ã���Ȼ��������ȥ�����Ǿ�����˵����
                        'queueID': 'fileQueue',//��������ϴ��ļ��б�id��Ӧ
                        'queueSizeLimit': 8,//�ϴ��ļ�������
                        'scriptData': {
                            'uuid':uuid
                        },//���̨��������
                        'fileDesc': 'rar�ļ���zip�ļ�',//�ϴ��ļ�����˵��
                        //    'fileExt' :'*.rar;*.zip;*txt,*doc,*docx', //���ƿ��ϴ��ļ�����չ�������ñ���ʱ��ͬʱ����fileDesc
                        'method': 'get',//������̨�������ݣ�������get
                        'sizeLimit': 2097152,//�ļ��ϴ��Ĵ�С���ƣ���λ���ֽ� 2m
                        'auto': false,//�Ƿ��Զ��ϴ�
                        'multi': true,
                        'simUploadLimit': 1,//ͬʱ�ϴ��ļ��������������������������ô���������multi:true��queueSizeLimit��8�����Զ�ѡ8���ļ��������һ���㽫simUploadLimitҲ�����ˣ���ôֻ���ϴ��������ָ�����ļ��������������ϴ�����
                        'onSelect': function (event, queueID, fileObj) {
                            if (fileObj.size > 2097152) {
                                alert("�ļ���:" + fileObj.name + "  ��������С���ܳ���2M,���޷��ϴ�!��");
                                return false;
                            }
                            return true;
                            //ȡ������Ϣ
                        },
                        'buttonText': '���',//�����ťͼƬ
                        'onAllComplete': function (event, data) {//���ϴ���ɺ�Ļص�������ajax��ʽŶ~~
                            //ȡ������Ϣ
                            showParentWindow(uuid, window.dialogArguments);
                            //ȡ������Ϣ
                        }
                    });
                });
        //��Ӹ���  ��ҳ����ʾ
        //var count= 0 ;
        //  var maxfile = 5;
        //����Ԫ��
        function addUpload(fileName, fileId, saveName, parent) {
            var path = document.getElementById("path").value;
            var url = "<%=request.getContextPath()%>/servlet/DownServlet?path=" + path + saveName + "";
            // if(count >= maxfile)
            //return;//�������maxfile���ļ���
            //count++;
            //����id��ͬ��HTML���󣬲����ӵ��������
            var newDiv = "<div id=divUpload" + fileId + ">"
                    + " <input type='hidden' id='file' name='file'  size=50  value='" + fileId + "' >"
                    + " <input type='hidden' id='fileName' name='fileName'  size=50  value='" + saveName + "' >"
                    + "<img src='/product/jsp/images/fujian_tubiao.jpg' /><a href='" + url + "' >" + fileName + "</A>"
                    + " <a href=javascript:delUpload('divUpload" + fileId + "'," + fileId + ");>ɾ��</a>"
                    + "</div>";

            parent.document.getElementById("uploadContent").insertAdjacentHTML("beforeEnd", newDiv);
        }
        // ������� ���ļ���Ϣ ��ӳ�� ��������
        function showParentWindow(uuid, parent) {
            dwr.engine.setAsync(false);
            AttachmentBus.getAttachmentInfoToJson(uuid, function (data) {
                //��ʼ �� ������ƴ ���� ��Ϣ
                for (var i in data) {
                    if (fileIdByParent(fileArray, data[i].fileId)) {
                        addUpload(data[i].fileName, data[i].fileId, data[i].saveName, parent);
                    }
                }
                window.close();
            });
        }
        // �Ƚ� -��ҳ�� ����Ԫ��
        function fileIdByParent(arr, fileId) {
            var i = true;
            for (var c = 0; c < arr.length; c++) {
                if (arr[c] == fileId) {
                    i = false;
                }
            }
            return i;
        }
        // һ�������� ��ҳ��Ԫ��
        function parentFiles(arr) {
            for (var i = 0; i < arr.length; i++) {
                fileArray[i] = arr[i].value;
            }
            return fileArray;
        }
        // ������С �ж�
        function SizeEstimation() {
        }

    </script>
</head>

<body>
<form name="searchForm" action="<%=request.getContextPath()%>/servlet/DownServlet"
      method="get">
    <input type="hidden" id="path" name="path" value="<%=tempPath%>"/>
</form>
<div id="fileQueue"></div>

<input type="file" name="uploadify" id="uploadify"/>

<p>

     <a href="#" onclick="jQuery('#uploadify').uploadifyUpload();">��ʼ�ϴ�</a>&nbsp;

    <a href="#" onclick="jQuery('#uploadify').uploadifyClearQueue();">ȡ�������ϴ�</a>

</p>

</body>

</html>
