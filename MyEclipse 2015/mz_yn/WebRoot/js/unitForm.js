// JavaScript Document
function changeKind(kind){
	
	if(kind.value!=1){
	    document.unitForm.tablename.disabled=true;
		document.unitForm.showcols.disabled=true;
	}else{
		document.unitForm.tablename.disabled=false;
		document.unitForm.showcols.disabled=false;
	}
}

function checkForm(){
    
	//输入栏目名称
	if(isEmpty(unitForm.unit_name.value)){
		  ymPrompt.alert({message:"请输入栏目名称！", width:330, height:220, title:'提示信息'});
		 unitForm.unit_name.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.unit_name.value,special_char.username);
		 if(specialChar){
			  ymPrompt.alert({message:"栏目名称不能包含'", width:330, height:220, title:'提示信息'});
			 unitForm.unit_name.focus();
			 return false;
		 }
	}
	
	//输入栏目标题
	if(isEmpty(unitForm.title.value)){
		  ymPrompt.alert({message:"请输入栏目标题！", width:330, height:220, title:'提示信息'});
		 unitForm.title.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.title.value,special_char.username);
		 if(specialChar){
			   ymPrompt.alert({message:"栏目标题不能包含'", width:330, height:220, title:'提示信息'});
			
			 unitForm.title.focus();
			 return false;
		 }
	}
	//===输入栏目描述
	if(isEmpty(unitForm.descript.value)){
		ymPrompt.alert({message:"请输入栏目描述！", width:330, height:220, title:'提示信息'});
		 unitForm.descript.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.descript.value,special_char.username);
		 if(specialChar){
			 ymPrompt.alert({message:"栏目描述不能包含'", width:330, height:220, title:'提示信息'});
			 unitForm.descript.focus();
			 return false;
		 }
	}
	//==输入栏目高度
	if(isEmpty(unitForm.height.value)){
		 ymPrompt.alert({message:"请输入栏目高度！", width:330, height:220, title:'提示信息'});
		 unitForm.height.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.height.value)){
			ymPrompt.alert({message:"栏目高度必须是数字！", width:330, height:220, title:'提示信息'});
			 unitForm.height.focus();
			 return false;
		 }
	}
	//栏目url
	/**
	if(isEmpty(unitForm.url.value)){
			
		 alert("请输入栏目URL！");
		 unitForm.url.focus();
		 return false;
		 
	}*/
	/*
	//栏目图标
	if(isEmpty(unitForm.ico.value)){
			
		 alert("请选择栏目图标！");
		 unitForm.ico.focus();
		 return false;
		 
	}*/
	//输入默认行位置
	if(isEmpty(unitForm.initrow.value)){
			
		 alert("请输入默认行位置！");
		 unitForm.initrow.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.initrow.value)){
			 alert("默认行位置必须是数字！");
			 unitForm.initrow.focus();
			 return false;
		 }
	}
	//输入默认列位置
	if(isEmpty(unitForm.initcols.value)){
			
		 alert("请输入默认列位置！");
		 unitForm.initcols.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.initcols.value)){
			 alert("默认列位置必须是数字！");
			 unitForm.initcols.focus();
			 return false;
		 }
	}
	
	//输入默认显示记录数
	if(isEmpty(unitForm.showrows.value)){
			
		 alert("请输入默认显示记录数！");
		 unitForm.showrows.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.showrows.value)){
			 alert("默认显示记录数必须是数字！");
			 unitForm.showrows.focus();
			 return false;
		 }
	}
	
		/**
	*是否加权
	**/
	if(unitForm.isRightkey[0].checked){
		unitForm.rightkey.value = '1';
	}
	if(unitForm.isRightkey[1].checked){
		unitForm.rightkey.value = '0';
	}
	
	if(unitForm.operKind.value==1){
	    //输入内容信息表
		if(isEmpty(unitForm.tablename.value)){
			
			 alert("请输入内容信息表！");
			 unitForm.tablename.focus();
			 return false;
			 
		}
	 	//==输入显示字段名称
		if(isEmpty(unitForm.showcols.value)){
				
			 alert("请输入显示字段名称！");
			 unitForm.showcols.focus();
			 return false;
			 
		}
		//==信息表主键
		if(isEmpty(unitForm.PK.value)){
				
			 alert("请输入信息表主键！");
			 unitForm.PK.focus();
			 return false;
			 
		}
		//==详细信息页面
		if(isEmpty(unitForm.detailURL.value)){
				
			 alert("请输入详细信息页面！");
			 unitForm.detailURL.focus();
			 return false;
			
		}
		
	    //==排序字段
		if(isEmpty(unitForm.orderByCol.value)){
				
			 alert("请输入排序字段！");
			 unitForm.orderByCol.focus();
			 return false;
			 
		}
		
	
	
	}
	unitForm.submit();
		
}