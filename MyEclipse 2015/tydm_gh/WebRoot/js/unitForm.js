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
    
	//������Ŀ����
	if(isEmpty(unitForm.unit_name.value)){
		  ymPrompt.alert({message:"��������Ŀ���ƣ�", width:330, height:220, title:'��ʾ��Ϣ'});
		 unitForm.unit_name.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.unit_name.value,special_char.username);
		 if(specialChar){
			  ymPrompt.alert({message:"��Ŀ���Ʋ��ܰ���'", width:330, height:220, title:'��ʾ��Ϣ'});
			 unitForm.unit_name.focus();
			 return false;
		 }
	}
	
	//������Ŀ����
	if(isEmpty(unitForm.title.value)){
		  ymPrompt.alert({message:"��������Ŀ���⣡", width:330, height:220, title:'��ʾ��Ϣ'});
		 unitForm.title.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.title.value,special_char.username);
		 if(specialChar){
			   ymPrompt.alert({message:"��Ŀ���ⲻ�ܰ���'", width:330, height:220, title:'��ʾ��Ϣ'});
			
			 unitForm.title.focus();
			 return false;
		 }
	}
	//===������Ŀ����
	if(isEmpty(unitForm.descript.value)){
		ymPrompt.alert({message:"��������Ŀ������", width:330, height:220, title:'��ʾ��Ϣ'});
		 unitForm.descript.focus();
		 return false;
		 
	}else{
		 var specialChar = CheckSpecialChar(unitForm.descript.value,special_char.username);
		 if(specialChar){
			 ymPrompt.alert({message:"��Ŀ�������ܰ���'", width:330, height:220, title:'��ʾ��Ϣ'});
			 unitForm.descript.focus();
			 return false;
		 }
	}
	//==������Ŀ�߶�
	if(isEmpty(unitForm.height.value)){
		 ymPrompt.alert({message:"��������Ŀ�߶ȣ�", width:330, height:220, title:'��ʾ��Ϣ'});
		 unitForm.height.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.height.value)){
			ymPrompt.alert({message:"��Ŀ�߶ȱ��������֣�", width:330, height:220, title:'��ʾ��Ϣ'});
			 unitForm.height.focus();
			 return false;
		 }
	}
	//��Ŀurl
	/**
	if(isEmpty(unitForm.url.value)){
			
		 alert("��������ĿURL��");
		 unitForm.url.focus();
		 return false;
		 
	}*/
	/*
	//��Ŀͼ��
	if(isEmpty(unitForm.ico.value)){
			
		 alert("��ѡ����Ŀͼ�꣡");
		 unitForm.ico.focus();
		 return false;
		 
	}*/
	//����Ĭ����λ��
	if(isEmpty(unitForm.initrow.value)){
			
		 alert("������Ĭ����λ�ã�");
		 unitForm.initrow.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.initrow.value)){
			 alert("Ĭ����λ�ñ��������֣�");
			 unitForm.initrow.focus();
			 return false;
		 }
	}
	//����Ĭ����λ��
	if(isEmpty(unitForm.initcols.value)){
			
		 alert("������Ĭ����λ�ã�");
		 unitForm.initcols.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.initcols.value)){
			 alert("Ĭ����λ�ñ��������֣�");
			 unitForm.initcols.focus();
			 return false;
		 }
	}
	
	//����Ĭ����ʾ��¼��
	if(isEmpty(unitForm.showrows.value)){
			
		 alert("������Ĭ����ʾ��¼����");
		 unitForm.showrows.focus();
		 return false;
		 
	}else{
		 
		 if(!isNumber(unitForm.showrows.value)){
			 alert("Ĭ����ʾ��¼�����������֣�");
			 unitForm.showrows.focus();
			 return false;
		 }
	}
	
		/**
	*�Ƿ��Ȩ
	**/
	if(unitForm.isRightkey[0].checked){
		unitForm.rightkey.value = '1';
	}
	if(unitForm.isRightkey[1].checked){
		unitForm.rightkey.value = '0';
	}
	
	if(unitForm.operKind.value==1){
	    //����������Ϣ��
		if(isEmpty(unitForm.tablename.value)){
			
			 alert("������������Ϣ��");
			 unitForm.tablename.focus();
			 return false;
			 
		}
	 	//==������ʾ�ֶ�����
		if(isEmpty(unitForm.showcols.value)){
				
			 alert("��������ʾ�ֶ����ƣ�");
			 unitForm.showcols.focus();
			 return false;
			 
		}
		//==��Ϣ������
		if(isEmpty(unitForm.PK.value)){
				
			 alert("��������Ϣ��������");
			 unitForm.PK.focus();
			 return false;
			 
		}
		//==��ϸ��Ϣҳ��
		if(isEmpty(unitForm.detailURL.value)){
				
			 alert("��������ϸ��Ϣҳ�棡");
			 unitForm.detailURL.focus();
			 return false;
			
		}
		
	    //==�����ֶ�
		if(isEmpty(unitForm.orderByCol.value)){
				
			 alert("�����������ֶΣ�");
			 unitForm.orderByCol.focus();
			 return false;
			 
		}
		
	
	
	}
	unitForm.submit();
		
}