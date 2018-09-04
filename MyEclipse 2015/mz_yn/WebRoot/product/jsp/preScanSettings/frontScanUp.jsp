<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.HashMap" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    User userTO = (User) session.getAttribute("sysUser");
    int user_id = userTO.getUserId();
    UserBo userBo = new UserBo();
    User user = userBo.findById(user_id);
    HashMap PMTranslates = InitSysParams.PMTranslates;//错误结果提示中文
    String message = request.getParameter("title");
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>修改密码</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
          <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/modpassword.js'></script>
</head>

<body>
<div class="page_top">系统 &gt;&gt; 前置扫描管理&gt;&gt; 设置</div>
<form method="post" action="/bsweb/preScan_frontScanSave" name="userForm" id="userForm">
    <input type="hidden" name="method" value="modPassword"/>
    <input type="hidden" name="currentPage" value="/product/jsp/user/modPassword.jsp"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue" >
                        <table width="100%" style="margin:0 auto;" align="center" border="0" cellpadding="5"
                               cellspacing="0">
                            <tr class="">
                                <td class="" align="right" width="40%">行政区划：</td>
                                <td width="60%">${scanManage.xzqh }
                                <input type='hidden' name="scanManage.xzqh" value="${scanManage.xzqh }"/>
                            
                             <%-- 
                                                                                           开启 <input type="radio" name='1'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='1'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr></br>
                             <tr class="">
                                <td class="" align="right" width="40%">名称：</td>
                                <td width="60%">
                                    ${scanManage.memo1 }
                             <%-- 
                                                                                           开启 <input type="radio" name='1'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='1'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr></br>
                             <tr class="">
                                <td class="" align="right" width="40%">是否前置扫描：</td>
                                <td width="60%">
                                   
                             
                                                                                           开启 <input type="radio" name='scanManage.status' id="opt" value="1" />
                                                                                          关闭 <input type="radio" name='scanManage.status'  id="opts" value="0"/>
                             
                             
                                                                                         
                                </td>
                            </tr></br>
                                                      
                            
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="submit" class="newBtn1" id="saveButton" value="保 存"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="返回"
                               onClick="window.location.href='/bsweb/preScan_list'"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</body>
<script type="text/javascript">
if(${scanManage.status}=='0'){
	$('#opts').attr("checked", "checked");
}else{
	$('#opt').attr("checked", "checked");
}
if('${title}'=='ok'){
	//alert("添加成功！");
	ymPrompt.alert('更新成功!', 330, 220, '提示信息');
}
   
</script>

</html>
