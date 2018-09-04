/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-31
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */

function checkForm(oper){

	if(oper == 1){

		if(isEmpty(loginForm.username.value)){

			 //alert("请输入用户名！");
			 document.getElementById("usernameInfo").innerHTML = "请输入用户名！";
			 loginForm.username.focus();
			 return false;

		}else{
			 var specialChar = CheckSpecialChar(loginForm.username.value,special_char.username);
			 if(specialChar){
				 //alert("用户名不能包含+specialChar+");
				 document.getElementById("usernameInfo").innerHTML = "用户名不能包含+specialChar+";
				 loginForm.username.focus();
				 return false;
			 }
		}

		if(isEmpty(loginForm.password.value)){

			 document.getElementById("passwordInfo").innerHTML = "请输入密码！";
			 loginForm.password.focus();
			 return false;

		}else{

			 var specialChar = CheckSpecialChar(loginForm.password.value,special_char.passwd);
			 if(specialChar){
				 //alert("密码不能包含+specialChar+");
				 document.getElementById("passwordInfo").innerHTML = "密码不能包含+specialChar+";
				 loginForm.password.focus();
				 return false;
			 }
		}
	}
	loginForm.loginType.value=oper;
	if(oper == 2){

        var strPage = "<%=request.getContextPath() %>/product/checkpwd.jsp?random="+Math.random();
        var winFeatures = "dialogHeight:100px; dialogWidth:360px;status:no;scroll:no;dialogTop:300;dialogLeft:400px;";
        var value = window.showModalDialog(strPage,"",winFeatures);
        if(value == 'undefined'){
            return;
        }
        var values = value.split('@');
        loginForm.passwords.value = values[0];
        loginForm.listCom.value= values[1];
        fReadCard();
		loginForm.submit();
	}
}
