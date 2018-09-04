/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-9-2
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */

function checkForm(){
	if(isEmpty(document.languageForm.jgdm.value)){
		ymPrompt.alert('请输入企业机构代码！',330,220,'提示信息',function(data){if(data == "ok"){ }});
		return false;
	}
	if(isEmpty(document.languageForm.productname.value)){
		ymPrompt.alert('请输入产品名称！',330,220,'提示信息',function(data){if(data == "ok"){ }});
		return false;
	}

	if(isEmpty(document.languageForm.zryy.value)){
		ymPrompt.alert('请输入自然语言！',330,220,'提示信息',function(data){if(data == "ok"){ }});
		return false;

	}else{
		 var specialChar = CheckSpecialChar(document.languageForm.zryy.value,special_char.username);
		 if(specialChar){
			ymPrompt.alert('自然语言不能包含'+specialChar+'字符！',330,220,'提示信息',function(data){if(data == "ok"){ }});

		return false;
		 }
	}
	 document.languageForm.submit();
}
