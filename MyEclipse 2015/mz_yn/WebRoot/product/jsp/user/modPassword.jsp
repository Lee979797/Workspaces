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
    HashMap PMTranslates = InitSysParams.PMTranslates;//��������ʾ����
    String message = request.getParameter("message");
    if (message != null) {
        message = (String) PMTranslates.get(message);
    } else {
        message = "";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�޸�����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/modpassword.js'></script>
    <script type="text/javascript">
	$(function(){   $("#old").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
</head>
<body>
<div class="page_top">ϵͳ &gt;&gt; �û���ɫ���� &gt;&gt; �޸�����</div>
<form method="post" action="/action/UserAction" name="userForm" id="userForm">
    <input type="hidden" name="method" value="modPassword"/>
    <input type="hidden" name="currentPage" value="/product/jsp/user/modPassword.jsp"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="100%" style="margin:0 auto;" align="center" border="0" cellpadding="5"
                               cellspacing="0">
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right" width="40%">�����룺</td>
                                <td width="60%">
                                    <input type="password" name="user_oldpassword" id="old" maxlength="16"
                                           class="page_input2" size="25"/>
                                    <span id="oldpasswordMsg"></span>
                                </td>
                            </tr>

                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">�����룺</td>
                                <td><input type="password" class="page_input2" id="new" size="25"
                                           name="user_newpassword1"
                                           maxlength="16"/>
                                    <span id="newpassword1Msg"></span>
                                </td>

                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">ȷ�������룺</td>
                                <td><input type="password" class="page_input2" id="double" size="25"
                                           name="user_newpassword2"
                                           maxlength="16"/>
                                    <span id="newpassword2Msg"></span>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="button" type="submit" class="newBtn1" id="saveButton" value="�� ��"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="�� ��"
                               onclick="userForm.reset()"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</body>
<script type="text/javascript">
    $("#userForm").submit(function () {
        if (!checkOld()) {
            $("#old").focus();
            return false;
        }
        if (!checkNew()) {
            $("#new").focus();
            return false;
        }
        if (!checkDouble()) {
            $("#double").focus();
            return false;
        }
        return true;
    });
    $("#old").bind("blur keyup", function () {
        if (filterKeyUp())
            return true;
        return checkOld();
    });
    $("#new").bind("blur keyup", function () {
        if (filterKeyUp())
            return true;
        return checkNew();
    });
    $("#double").bind("blur keyup", function () {
        if (filterKeyUp())
            return true;
        return checkDouble();
    });
    function checkOld() {
        var obj = $("#old");
        obj.val(obj.val().trim());
        if (obj.val().length <= 0) {
            $("#oldpasswordMsg").css("color", "red").html("ԭʼ���벻��Ϊ�գ�");
            return false;
        } else {
            $("#oldpasswordMsg").html("");
            return true;
        }
    }
    function checkNew() {
        var obj = $("#new");
        obj.val(obj.val().trim());
        if (obj.val().length <= 0) {
            $("#newpassword1Msg").css("color", "red").html("�����벻��Ϊ�գ�");
            return false;
        }
        if (obj.val().length < 6) {
            $("#newpassword1Msg").css("color", "red").html("���볤����СӦΪ6λ�ַ���");
            return false;
        }
        if (!/^[\d_\w]*$/.test(obj.val())) {
            $("#newpassword1Msg").css("color", "red").html("ϵͳҪ������ֻ��Ϊ���֡��»��߼�Ӣ���ַ���");
            return false;
        }
        var old = $("#old");
        var obj2 = $("#double");
        if (old.val() == obj.val()) {
            $("#newpassword1Msg").css("color", "red").html("������������벻����ͬ��");
            return false;
        }
        $("#newpassword1Msg").css("color", "green").html("������������ȷ��");
        if (obj2.val().length > 0 && obj2.val() != obj.val()) {
            $("#newpassword2Msg").css("color", "red").html("�����������벻һ�£�");
            return false;
        }
        return true;
    }
    function checkDouble() {
        var obj2 = $("#new");
        var obj = $("#double");
        if (obj2.val() != obj.val()) {
            $("#newpassword2Msg").css("color", "red").html("�����������벻һ�£�");
            return false;
        }
        $("#newpassword2Msg").css("color", "green").html("ȷ������������ȷ��");
        return true;
    }
    <%
    if(!clsStringTool.isEmpty(message)){%>
    ymPrompt.alert('<%=message%>', 330, 220, '��ʾ��Ϣ');
    <%}%>
</script>
</html>
