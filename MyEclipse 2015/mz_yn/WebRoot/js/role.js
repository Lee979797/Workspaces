function checkForm(){

	
	if(isEmpty(roleForm.roleName.value)){
		
		 
		 ymPrompt.alert('请输入角色名称！',330,220,'提示信息',function(data){if(data == "ok"){roleForm.roleName.focus();}});
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(roleForm.roleName.value,special_char.username);
		 if(specialChar){
			  ymPrompt.alert('角色名称不能包含'+specialChar+'字符！',330,220,'提示信息',function(data){if(data == "ok"){roleForm.roleName.focus();}});
			
			 return false;
		 }
	}
	
	if(isEmpty(roleForm.roleMemo.value)){
		 
		 ymPrompt.alert('请输入详细描述！',330,220,'提示信息',function(data){if(data == "ok"){roleForm.roleMemo.focus();}});
		
		 return false;
		 
	}else{
	
		 var specialChar = CheckSpecialChar(roleForm.roleMemo.value,special_char.passwd);
		 if(specialChar){
			ymPrompt.alert('详细描述不能包含'+specialChar+'字符！',330,220,'提示信息',function(data){if(data == "ok"){roleForm.roleMemo.focus();}});
		
			 return false;
		 }
	}
	

	
  roleForm.submit();
}

function dosome(){
}