<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.ninemax.jpa.util.CommonPropertiesUtil" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    HashMap PMTranslates = InitSysParams.PMTranslates;//错作结果提示中文
    String error = request.getParameter("error");
    if (!clsStringTool.isEmpty(error)) {
        error = (String) PMTranslates.get(error);
    } else {
        error = "";
    }
    error = clsStringTool.convertNull(error);
    String xtmc=CommonPropertiesUtil.getValue("common.properties", "xtmc");
    //if(xtmc.length()>17){
    	
    //xtmc= xtmc.substring(0,15);
    //}
    //xtmc=new String(xtmc.getBytes("ISO_8859_1"),"gbk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 解决兼容性问题，登录页面窗口偏离 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="always" name="referrer" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title><%=xtmc %></title>
    <link href="<%=request.getContextPath()%>/css/newlogin.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script language="JavaScript" src="<%=request.getContextPath()%>/js/readiccard.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="${pageContext.request.contextPath}/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script language="JavaScript">

        function checkForm(oper) {

            if (oper == 1) {
                if (isEmpty(document.loginForm.username.value)) {
                    document.getElementById("usernameInfo").innerHTML = "请输入用户名！";
                    document.loginForm.username.focus();
                    return false;

                } else {
                    var specialChar = CheckSpecialChar(document.loginForm.username.value, special_char.username);
                    if (specialChar) {
                        //alert("用户名不能包含+specialChar+");
                        document.getElementById("usernameInfo").innerHTML = "用户名不能包含+specialChar+";
                        document.loginForm.username.focus();
                        return false;
                    }
                }

                if (isEmpty(document.loginForm.password.value)) {

                    //alert("请输入密码！");
                    document.getElementById("passwordInfo").innerHTML = "请输入密码！";
                    document.loginForm.password.focus();
                    return false;

                } else {

                    var specialChar = CheckSpecialChar(document.loginForm.password.value, special_char.passwd);
                    if (specialChar) {
                        //alert("密码不能包含+specialChar+");
                        document.getElementById("passwordInfo").innerHTML = "密码不能包含+specialChar+";
                        document.loginForm.password.focus();
                        return false;
                    }
                }

                if (isEmpty(document.loginForm.ValidateCode.value)) {
                    //alert("请输入验证码！");
                    document.getElementById("codeInfo").innerHTML = "请输入验证码！";
                    document.loginForm.ValidateCode.focus();
                    return false;
                }
            }
            document.loginForm.loginType.value = oper;
            if (oper == 2) {
                var strPage = "${pageContext.request.contextPath}/product/checkpwd.jsp?random=" + Math.random();
                var winFeatures = "dialogHeight:100px; dialogWidth:360px;status:no;scroll:no;dialogTop:300;dialogLeft:400px;";
                var value = window.showModalDialog(strPage, "", winFeatures);
                if (value == 'undefined') {
                    return false;
                }
                var values = value.split('@');
                document.loginForm.passwords.value = values[0];
                document.loginForm.listCom.value = values[1];
                Action_Do('icRead');
                //fReadCard();
                document.loginForm.submit();
            }


            return true;

        }
        function view(val) {
            /* //ymPrompt.win('
            ${pageContext.request.contextPath}'/product/CALogin2.jsp', 400, 300, 'CA登录页面', null, null, null, {id: 'a'}        )*/
            document.location.href = ${pageContext.request.contextPath}'/product/CALogin2.jsp';
        }

    </script>
</head>

<body id="body_bj">
<div class="screen">
    <form name="loginForm" action="/action/UserAction" method="post" onsubmit="return checkForm('1')">
        <input type="hidden" name="method" value="login"/>
        <input type="hidden" name="goPage" value="/product/index.html"/>
        <input type="hidden" name="currentPage" value="<%=request.getRequestURI()%>"/>
        <input type="hidden" name="listCom" id="listCom" value="1"/>
        <input type="hidden" name="jgdm" id="jgdm"/>
        <input type="hidden" name="loginType" id="loginType" value="1"/>
        <input type="hidden" name="passwords" id="passwords"/>

        <div class="content">
        <!--标题-->
        	<div class="heading">
            <!-- 	<img src="../images/login/logo.png" /> -->
            	<h3><%=xtmc %></h3>
            </div>
            <!--登录-->
            <div class="login">
                <!-- <h3>
                    <a href="#" onclick="view('a')" name="calogin" title="CA登录">
                        <img border="0" src="/images/ca_login.png" align="absmiddle"/>CA登录
                    </a>
                </h3>
                -->
                <ul>
                    <li>
                        <label>用户名</label>

                        <p class="wid1">
                            <input type="text" id="username" name="username" class="inp1"/>
                            <em id="usernameInfo"></em>
                        </p>

                    </li>
                    <li>
                        <label>密码</label>

                        <p class="wid2">
                            <input type="password" id="password" name="password" class="inp1"/>
                            <em id="passwordInfo"></em>
                        </p>
                    </li>
                      <li>
                        <label>验证码</label>

                        <p class="wid3">
                            <input maxlength="4" type="text" name="ValidateCode" id="ValidateCode"
                                               class="inp2"/>
                            <a href="#" onclick="document.loginForm.validate.src='/action/ValidateCodeServlet?time='+Math.random();">
                                <img src="/action/ValidateCodeServlet" width=90 height=30 border="0" align="top"
                                     style="vertical-align:top" id="validate"/>
                            </a>
                         	<em id="codeInfo"></em>
                        </p>
                    </li>
                    
                    <li>

                        <p style="text-align:center;">
                            <input type="submit" class="login_btn" id="loginSubmit" name="loginSubmit" value="登录"/>
                        </p>
                    </li>
                    
                </ul>
            </div>
        </div>
        <span class="clear"></span>
    </form>
</div>
</body>
<script type="text/javascript">
    document.loginForm.loginSubmit.focus();
    document.loginForm.username.focus();
    document.getElementById("codeInfo").innerHTML = "<%=error%>";
</script>
</html>
