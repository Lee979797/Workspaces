/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-9-2
 * Time: ����3:18
 * To change this template use File | Settings | File Templates.
 */

function checkForm(){
	if(isEmpty(document.languageForm.jgdm.value)){
		ymPrompt.alert('��������ҵ�������룡',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ }});
		return false;
	}
	if(isEmpty(document.languageForm.productname.value)){
		ymPrompt.alert('�������Ʒ���ƣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ }});
		return false;
	}

	if(isEmpty(document.languageForm.zryy.value)){
		ymPrompt.alert('��������Ȼ���ԣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ }});
		return false;

	}else{
		 var specialChar = CheckSpecialChar(document.languageForm.zryy.value,special_char.username);
		 if(specialChar){
			ymPrompt.alert('��Ȼ���Բ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){ }});

		return false;
		 }
	}
	 document.languageForm.submit();
}
