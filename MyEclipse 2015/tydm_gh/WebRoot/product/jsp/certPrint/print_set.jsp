<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="user" type="com.ninemax.jpa.system.model.User"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<head>
    <title>全国组织机构代码业务信息采集实验系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript">
        function savePrintSet() {
            var print = document.getElementById("print");
            var printName = print.getPrintname();
            var x = print.getOffsetX();
            var y = print.getOffsetY();
            var prt = document.prt;
            $("#printName").val(printName);
            $("#offsetx").val(x);
            $("#offsety").val(y);
            prt.submit();
        }

    </script>
</head>
<body>
<form name="prt" method=post action="/bsweb/certificatePrint_print_set">

    <input type="hidden" name="user.userId" id="userId" value="${user.userId}"/>
    <input type="hidden" name="user.printName" id="printName"/>
    <input type="hidden" name="user.offsetx" id="offsetx"/>
    <input type="hidden" name="user.offsety" id="offsety"/>
</form>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right;">
        &nbsp;<input type="button" onclick="savePrintSet()" class="btn2" value="保存设置"/>
    </div>
</div>
<div align="center">
    <table align="center" style="margin-top: 20px;width: 941px">
        <tr>
            <td align="center" style="text-align: left">
                <label>1.可设置控件里的"整体偏移量"来进行打印信息的整体移动,打印机纸张设置为A4大小<br>
                    2.可通过"打印"测试偏移量设置是否合适,向上 向左移动输入负数(-),向下 向右输入正数<br>
                </label>
            </td>
        </tr>
        <tr>
            <td align="center">
                <OBJECT ID="print"
                        CLASSID="CLSID:230DA4AF-6773-4D8E-AE36-FCE670FE3695"
                        CODEBASE="/product/jsp/icocx/dmcj.CAB#version=1,7,0,0" width="940" height="760">
                    <param name="jgdm" value="000000000">
                    <param name="frlx" value="法定代表人">
                    <param name="frmc" value="负责人">
                    <param name="jgmc" value="全国组织机构代码信息采集系统名称打印测试">
                    <param name="jglxmc" value="企业法人">
                    <param name="jgdz" value="全国组织机构代码信息采集系统地址打印测试">
                    <param name="yxq" value="自2012年12月13日至2016年12月12日">
                    <param name="bfdw" value="济南市质量技术监督局">
                    <param name="djh" value="组代管460000-000000">
                    <param name="fbsl" value="3">
                    <param name="ewm" value="000000000;全国组织机构代码信息采集系统名称打印测试;全国组织机构代码信息采集系统地址打印测试">
                    <param name="ts"
                           value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njtsbz?certi.tsxx1:''}${certi.tsxx2}${certi.tsxx3}">
                    <param name="ermx" value="0">
                    <param name="ermy" value="0">
                    <param name="dyerm" value="0">
                    <param name="osx" value="${user.offsetx}">
                    <param name="osy" value="${user.offsety}">
                    <param name="printname" value="${user.printName}">
                </OBJECT>
            </td>
        </tr>
    </table>
</div>

<script type="text/javascript">
    (function () {
        var print = document.getElementById("print");
        print.isSetup();
        <%--@elvariable id="message" type="java.lang.String"--%>
        <c:if test="${message !=null and message ne ''}" >
            ymPrompt.alert('${message}', 330, 220, '提示信息');
        </c:if>
//            print.openPrtSetup();
    })();

</script>

</body>
</html>
