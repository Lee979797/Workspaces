function checkForm(){

	if(isEmpty(groupForm.usergroupName.value)){
		ymPrompt.alert('�����������ƣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){groupForm.usergroupName.focus();}});
		 
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(groupForm.usergroupName.value,special_char.username);
		 if(specialChar){
			 ymPrompt.alert('�����Ʋ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){groupForm.usergroupName.focus();}});
		 
			 return false;
		 }
	}
	
	if(isEmpty(groupForm.usergroupMemo.value)){
		 ymPrompt.alert('��������ϸ������',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){groupForm.usergroupMemo.focus();}});
		
		 return false;
		 
	}else{
	
		 var specialChar = CheckSpecialChar(groupForm.usergroupMemo.value,special_char.passwd);
		 if(specialChar){
			 ymPrompt.alert('��ϸ�������ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){groupForm.usergroupMemo.focus();}});
		
			 return false;
		 }
	}
	
  groupForm.submit();
}

function dosome(){
}