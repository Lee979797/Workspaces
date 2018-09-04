function checkForm(){

	if(isEmpty(groupForm.usergroupName.value)){
		ymPrompt.alert('请输入组名称！',330,220,'提示信息',function(data){if(data == "ok"){groupForm.usergroupName.focus();}});
		 
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(groupForm.usergroupName.value,special_char.username);
		 if(specialChar){
			 ymPrompt.alert('组名称不能包含'+specialChar+'字符！',330,220,'提示信息',function(data){if(data == "ok"){groupForm.usergroupName.focus();}});
		 
			 return false;
		 }
	}
	
	if(isEmpty(groupForm.usergroupMemo.value)){
		 ymPrompt.alert('请输入详细描述！',330,220,'提示信息',function(data){if(data == "ok"){groupForm.usergroupMemo.focus();}});
		
		 return false;
		 
	}else{
	
		 var specialChar = CheckSpecialChar(groupForm.usergroupMemo.value,special_char.passwd);
		 if(specialChar){
			 ymPrompt.alert('详细描述不能包含'+specialChar+'字符！',330,220,'提示信息',function(data){if(data == "ok"){groupForm.usergroupMemo.focus();}});
		
			 return false;
		 }
	}
	
  groupForm.submit();
}

function dosome(){
}