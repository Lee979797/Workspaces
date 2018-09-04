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
    <title>无标题文档</title>
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
                下载档案
            </a>--%>
            <%--<input name="button" type="reset" class="btn2" id="button3" value="下载档案" onclick="window.open('http://<%=request.getServerName()+":"+request.getServerPort()%>/${linux?'':'upload'}${fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }');"/>--%>
            <input name="button" type="reset" class="btn2" id="button3" value="下载档案" onclick="down();return false;"/>
        </c:if>
        &nbsp;
        <input name="button3" type="reset" class="newBtn1" id="button31" value="返 回"
               onclick="window.location.href='/bsweb/scanTask_list?task.status=true'"/>
        &nbsp;
    </div>
    档案 &gt;&gt; 扫描任务管理 &gt;&gt; 机构代码档案
</div>
<div align="left" style="margin-left: 20px;">
    机构代码：${task.jgdm}&nbsp;<span>机构名称：${task.jgmc}&nbsp;
    建档日期：<fmt:formatDate value='${task.createTime}'/>
    录档日期：<fmt:formatDate value='${task.compleTime}'/>
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
    ymPrompt.alert({message: '从Ftp服务器下载文件错误，或电子档案未找到！', width: 330, height: 220, title: '提示信息'});
    </c:if>
</script>
<script type='text/javascript'>
    (function () {
        var scanner;
        //找到图像控件                                    S
        scanner = document.getElementById("AAA");
        scanner.ImageMenuText = "{申领表,1,1};{企业批准文件,21,2};{事业单位批准文件,22,3};{社会团体批准文件,23,4};{机关批准文件,24,5};{其他机构批准文件,25,6};{法定代表人身份证件,31,7};{经办人身份证件,32,8};{小微企业证明材料,5,a};{其他文件,4,9}";

        //设置扫描分辨率，如果不用扫描仪则可以不设置
        //  scanner.DIP = 150;
        /*scanner.DownLoadImage("http://
        <%=request.getServerName()+":"+request.getServerPort()%>/
        ${linux?'':'upload'}${task.imagePath eq null?'':fn:replace(fn:split(task.imagePath,":" )[1],"\\" ,"/" ) }");*/

        //设置扫描颜色模型,为0表示黑白,为1表示灰度,为2表示RGB彩色
        scanner.ColorModel = 2;
        //设置扫描仪每像素的位大小,为8表示每个像素用8个位来表示
        scanner.Depth = 8;
        //设置控件的编辑模式,为0表示只读,不能修改图像,为1表示只能从文件导入数据,可以进行修改,为2表示能从文件或是扫描仪导入数据,可以进行修改
        scanner.EditModel = 0;
        //设置控件保存图像数据时的最大图像宽度,如果有图像大于最大宽度则不能保存
        // scanner.ImageWidth = 800;
        //设置控件保存图像数据时的最大图像高度,如果有图像大于最大高度则不能保存
        scanner.ImageHeight = 600;
        //设置控件保存图像时的文件格式,为0表示TIFF,可以保存多张图像,为1表示JPEG,只能保存一张图像
        scanner.ImageFormat = 0;
        //设置控件是否显示图片标注,为1 表示显示图片标注,为0表示不是显示图片标注
        scanner.RemarkFlag = 1;
        //设置控件是否显示"编辑模式"按钮,通过该按钮可以设置控件是否显示编辑区域,
        scanner.ModifyFlag = 0;
        //设置控件在保存图片时是否检查图像的尺寸,如果设置为1 ,则ImageWidth,ImageHeight设置后不起作用
        scanner.CheckImageSize = 0;
        //下载指定URL的图像到控件中，下载的图像自动添加到控件的缩略图列表的末尾
//        txt = "123.txt";
//       设置控件显示的图片标注住处，用分号隔开，但如没有设置RemarkFlag=1，则该属性设置后不起作用
//        scanner.ImageRemark = txt;
        <c:if test="${imageData ne ''}">
        var base64str = document.getElementById("base64").value;
        scanner.Base64ImageStr = base64str;
        <c:if test="${wdidbs !=null and imageData ne ''}">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        </c:if>
        <c:if test="${message!=null && !( '' eq message )}">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '提示信息'});
        </c:if>
    })();

</script>

</HTML>
