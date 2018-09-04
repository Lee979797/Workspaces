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
    <title>附件上传</title>
    <!--装载文件-->
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
    <!--ready事件-->
    <script type="text/javascript">
        var arr = window.dialogArguments.document.getElementsByName("file");
        var fileArray = [];
        fileArray = parentFiles(arr);
        $(document).ready(
                function () {
                    var uuid=window.dialogArguments.document.getElementById("uuid").value;
                    $("#uploadify").uploadify({//初始化函数
                        'uploader': '/jquery/uploadify.swf',//flash文 件位置，注意路径
                        'script': '<%=request.getContextPath()%>/servlet/Upload',//后台处理的请求
                        'cancelImg': '/jquery/cancel.png',//取消按钮图片
                        'folder': '/jquery/uploadsFolder',//您想将文件保存到的路径，将auto设置为true里才有用，不然跳到类里去处理，那就那里说了算
                        'queueID': 'fileQueue',//与下面的上传文件列表id对应
                        'queueSizeLimit': 8,//上传文件的数量
                        'scriptData': {
                            'uuid':uuid
                        },//向后台传的数据
                        'fileDesc': 'rar文件或zip文件',//上传文件类型说明
                        //    'fileExt' :'*.rar;*.zip;*txt,*doc,*docx', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc
                        'method': 'get',//如果向后台传输数据，必须是get
                        'sizeLimit': 2097152,//文件上传的大小限制，单位是字节 2m
                        'auto': false,//是否自动上传
                        'multi': true,
                        'simUploadLimit': 1,//同时上传文件的数量，设置了这个参数后，那么你会因设置multi:true和queueSizeLimit：8而可以多选8个文件，但如果一旦你将simUploadLimit也设置了，那么只会上传这个参数指定的文件个数，其它就上传不了
                        'onSelect': function (event, queueID, fileObj) {
                            if (fileObj.size > 2097152) {
                                alert("文件名:" + fileObj.name + "  （附件大小不能超过2M,将无法上传!）");
                                return false;
                            }
                            return true;
                            //取附件信息
                        },
                        'buttonText': '浏览',//浏览按钮图片
                        'onAllComplete': function (event, data) {//当上传完成后的回调函数，ajax方式哦~~
                            //取附件信息
                            showParentWindow(uuid, window.dialogArguments);
                            //取附件信息
                        }
                    });
                });
        //添加附件  父页面显示
        //var count= 0 ;
        //  var maxfile = 5;
        //增加元素
        function addUpload(fileName, fileId, saveName, parent) {
            var path = document.getElementById("path").value;
            var url = "<%=request.getContextPath()%>/servlet/DownServlet?path=" + path + saveName + "";
            // if(count >= maxfile)
            //return;//限制最多maxfile个文件框
            //count++;
            //自增id不同的HTML对象，并附加到容器最后
            var newDiv = "<div id=divUpload" + fileId + ">"
                    + " <input type='hidden' id='file' name='file'  size=50  value='" + fileId + "' >"
                    + " <input type='hidden' id='fileName' name='fileName'  size=50  value='" + saveName + "' >"
                    + "<img src='/product/jsp/images/fujian_tubiao.jpg' /><a href='" + url + "' >" + fileName + "</A>"
                    + " <a href=javascript:delUpload('divUpload" + fileId + "'," + fileId + ");>删除</a>"
                    + "</div>";

            parent.document.getElementById("uploadContent").insertAdjacentHTML("beforeEnd", newDiv);
        }
        // 保存完成 的文件信息 反映到 父窗口上
        function showParentWindow(uuid, parent) {
            dwr.engine.setAsync(false);
            AttachmentBus.getAttachmentInfoToJson(uuid, function (data) {
                //开始 往 父窗口拼 附件 信息
                for (var i in data) {
                    if (fileIdByParent(fileArray, data[i].fileId)) {
                        addUpload(data[i].fileName, data[i].fileId, data[i].saveName, parent);
                    }
                }
                window.close();
            });
        }
        // 比较 -父页面 已有元素
        function fileIdByParent(arr, fileId) {
            var i = true;
            for (var c = 0; c < arr.length; c++) {
                if (arr[c] == fileId) {
                    i = false;
                }
            }
            return i;
        }
        // 一次性载入 父页面元素
        function parentFiles(arr) {
            for (var i = 0; i < arr.length; i++) {
                fileArray[i] = arr[i].value;
            }
            return fileArray;
        }
        // 附件大小 判断
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

     <a href="#" onclick="jQuery('#uploadify').uploadifyUpload();">开始上传</a>&nbsp;

    <a href="#" onclick="jQuery('#uploadify').uploadifyClearQueue();">取消所有上传</a>

</p>

</body>

</html>
