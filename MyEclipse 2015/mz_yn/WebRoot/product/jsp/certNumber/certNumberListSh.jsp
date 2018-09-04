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
</head>
<body>
<div class="page_top_fixed">
	
	
	<div align="left" style=" float: left;"><strong>发证 &gt;&gt; 证书打印 &gt;&gt; 证书损耗录入</strong></div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form method="POST" name="frmThis" action="/bsweb/certificateNumber_ListSh.action">
                        <table width="100%" border="0" align=center cellpadding="0" cellspacing="1" class=tableBorder0>
                            <tr>
                                <td align="right" class=td1 width="14%"><label for="zsbh">
                                    	注销编号：
                                </label></td>
                                <td align="left" class=td1>
                                    <input name="zs.zsbh" type="text" id="zsbh" maxlength="15" value="${zs.zsbh}">
                                    
                                    <select name='zs.zstype'>
                                    <option value='0'>正本</option>
                                    <option value='1'>副本</option>
                                    </select>
                                    <strong style="font-size:12px;">(<span
                                            style="color:#ff0000;">*</span>)证书耗损录入</strong>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="listbtn">
                        <div id="pr">
                            <input type="button" onclick="document.frmThis.submit()" value="确 定" class="newBtn1">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<c:if test="${message!=null && message!=''}">
    <script type="text/javascript">
        ymPrompt.alert('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</html>
