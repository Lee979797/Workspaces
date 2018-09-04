<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.HashMap" %>
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
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
       <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/modpassword.js'></script>
</head>
<script type="text/javascript">
if('${title}'=='ok'){
	alert("添加成功！");
	// ymPrompt.alert({message: "当前机构证书库存不足，补足证书后才能打印证书", width: 330, height: 220, title: '提示信息'});
}
   
</script>
<body>
<div class="page_top">系统 &gt;&gt; 设置机构打印 &gt;&gt; 提示输入</div>
<form method="post" action="/bsweb/certificatePrint_add" name="userForm" id="userForm">
    <input type="hidden" name="method" value="modPassword"/>
    <input type="hidden" name="currentPage" value="/product/jsp/user/modPassword.jsp"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" style="margin:0 auto;" align="center" border="0" cellpadding="5"
                               cellspacing="0">
                            <tr class="">
                                <td class="" align="right" width="40%">企业法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org1" id="org1" maxlength="50"
                                           class="" value="${orgType.org1 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%-- 
                                                                                           开启 <input type="radio" name='1'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='1'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr></br>
                                                        <tr class="">
                                <td class="" align="right" width="40%">企业非法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org2" id="org2" maxlength="50"
                                           class="" value="${orgType.org2 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%-- 
                                                                                           开启 <input type="radio" name='2'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='2'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">事业法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org3" id="org3" maxlength="50"
                                           class="" value="${orgType.org3 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%-- 
                                                                                           开启 <input type="radio" name='3'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='3'  value="0"/>
                                                                                  --%>         
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">事业非法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org4" id="org4" maxlength="50"
                                           class="" value="${orgType.org4 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%--
                                                                                           开启 <input type="radio" name='4'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='4'  value="0"/>
                                                                                           --%> 
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">社团法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org5" id="org5" maxlength="50"
                                           class="" value="${orgType.org5 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             
                              <%--
                                                                                           开启 <input type="radio" name='5'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='5'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">社团非法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org6" id="org6" maxlength="50"
                                           class="" value="${orgType.org6 }" size="50"/>&nbsp;&nbsp;&nbsp;
                              <%--
                                                                                           开启 <input type="radio" name='6'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='6'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">机关法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org7" id="org7" maxlength="50"
                                           class="" value="${orgType.org7 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%--
                                                                                           开启 <input type="radio" name='7'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='7'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">机关非法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org8" id="org8" maxlength="50"
                                           class="" value="${orgType.org8 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%--
                                                                                           开启 <input type="radio" name='8'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='8'  value="0"/>
                                                                                           --%>
                                </td>
                            </tr>
                                                        <tr class="">
                                <td class="" align="right" width="40%">其它机构：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org9" id="org9" maxlength="50"
                                           class="" value="${orgType.org9 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%--
                                                                                           开启 <input type="radio" name='9'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='9'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                               <tr class="">
                                <td class="" align="right" width="40%">民办非企业单位：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org10" id="org10" maxlength="50"
                                           class="" value="${orgType.org10 }" size="50"/>&nbsp;&nbsp;&nbsp;
                             <%--
                                                                                           开启 <input type="radio" name='10' value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='10'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                               <tr class="">
                                <td class="" align="right" width="40%">个体：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org11" id="org11" maxlength="50"
                                           class="" value="${orgType.org11 }" size="50"/>&nbsp;&nbsp;&nbsp;
                              <%--
                                                                                           开启 <input type="radio" name='11'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='11'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>
                               <tr class="">
                                <td class="" align="right" width="40%">工会法人：</td>
                                <td width="60%">
                                    <input type="text" name="orgType.org12" id="org12" maxlength="50"
                                           class="" value="${orgType.org12 }" size="50"/>&nbsp;&nbsp;&nbsp;
                              <%--
                                                                                           开启 <input type="radio" name='orgType.12'  value="1" checked="checked"/>
                                                                                          关闭 <input type="radio" name='12'  value="0"/>
                                                                                          --%>
                                </td>
                            </tr>

                            
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="submit" class="newBtn1" id="saveButton" value="保 存"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="重 填"
                               onclick="userForm.reset()"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</body>

</html>
