/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-31
 * Time: ����9:30
 * To change this template use File | Settings | File Templates.
 */

function checkForm(oper){

	if(oper == 1){

		if(isEmpty(loginForm.username.value)){

			 //alert("�������û�����");
			 document.getElementById("usernameInfo").innerHTML = "�������û�����";
			 loginForm.username.focus();
			 return false;

		}else{
			 var specialChar = CheckSpecialChar(loginForm.username.value,special_char.username);
			 if(specialChar){
				 //alert("�û������ܰ���+specialChar+");
				 document.getElementById("usernameInfo").innerHTML = "�û������ܰ���+specialChar+";
				 loginForm.username.focus();
				 return false;
			 }
		}

		if(isEmpty(loginForm.password.value)){

			 document.getElementById("passwordInfo").innerHTML = "���������룡";
			 loginForm.password.focus();
			 return false;

		}else{

			 var specialChar = CheckSpecialChar(loginForm.password.value,special_char.passwd);
			 if(specialChar){
				 //alert("���벻�ܰ���+specialChar+");
				 document.getElementById("passwordInfo").innerHTML = "���벻�ܰ���+specialChar+";
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
