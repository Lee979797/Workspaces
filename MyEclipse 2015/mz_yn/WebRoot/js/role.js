function checkForm(){

	
	if(isEmpty(roleForm.roleName.value)){
		
		 
		 ymPrompt.alert('�������ɫ���ƣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){roleForm.roleName.focus();}});
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(roleForm.roleName.value,special_char.username);
		 if(specialChar){
			  ymPrompt.alert('��ɫ���Ʋ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){roleForm.roleName.focus();}});
			
			 return false;
		 }
	}
	
	if(isEmpty(roleForm.roleMemo.value)){
		 
		 ymPrompt.alert('��������ϸ������',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){roleForm.roleMemo.focus();}});
		
		 return false;
		 
	}else{
	
		 var specialChar = CheckSpecialChar(roleForm.roleMemo.value,special_char.passwd);
		 if(specialChar){
			ymPrompt.alert('��ϸ�������ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){roleForm.roleMemo.focus();}});
		
			 return false;
		 }
	}
	

	
  roleForm.submit();
}

function dosome(){
}