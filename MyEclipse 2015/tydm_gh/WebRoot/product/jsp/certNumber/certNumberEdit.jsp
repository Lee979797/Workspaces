<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="zs" type="com.ninemax.jpa.code.model.TZs"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=GBK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>证书编号</title>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
	$(function(){   $("#zsbh").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function goto() {
            window.location.href = "/bsweb/certificateNumber_listCertBook";
        }
    </script>
</head>
<body>
<div class="page_top" onkeypress="ches(document.frmThis)">
    <div align="left" style=" float: left;">${title}</div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form method="POST" name="frmThis" action="/bsweb/certificateNumber_saveCertBook.action">
                        <input name="zs.lsh" type="hidden" value="${zs.lsh}">
                        <input name="zs.zstype" type="hidden" value="${zs.zstype}">
                        <table width="100%" border="0" align=center cellpadding="0" cellspacing="1" class=tableBorder0>
                            <tr>
                                <td width="21%" rowspan="5" align="center" class=td1>&nbsp;</td>
                                <td align="right" class=td1 width="14%">机构代码：</td>
                                <td width="46%" align="left" class=td1>${zs.jgdm}</td>
                                <td width="19%" rowspan="5" align="center" class=td1>&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="right" class=td1 width="14%">登 记 号：</td>
                                <td align="left" class=td1>${zs.djh}</td>
                            </tr>
                            <tr>
                                <td align="right" class=td1 width="14%">旧 编 号：</td>
                                <td align="left" class=td1>${zs.zsbh}&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="right" class=td1 width="14%"><label for="zsbh">
                                    新 编 号：
                                </label></td>
                                <td align="left" class=td1>
                                    <input name="zs.zsbh" type="text" id="zsbh" maxlength="15" value="${zs.zsbh}">

                                    <strong style="font-size:12px;">(<span
                                            style="color:#ff0000;">*</span>)如果为空，则把旧编号置为“空闲”状态</strong>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" class=td1 colspan="2">

                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="listbtn">
                        <div id="pr">
                            <input type="button" onclick="document.frmThis.submit()" value="确 定" class="newBtn1">&nbsp;
                            <input type="button" name="back" value="返 回" onClick="goto()" class="newBtn1">
                        </div>
                    </div>

                </div>


            </div>

        </div>

    </div>
</div>
</body>
<%--@elvariable id="message" type="java.lang.String"--%>
<c:if test="${message!=null && message!=''}">
    <script type="text/javascript">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</html>
