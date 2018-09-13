
 function fReadCard(){
    
 	//认证权限的返回值
	var returnValue = HD_GetIndexInfo.GetAuth(0);		
	//alert("认证权限的返回值：" + returnValue);
	if(returnValue>=0){
		try{	
			cardreadViewForm.getForm().findField("kxlh").setValue(HD_GetIndexInfo.GetDeviceSN(0));
			if(HD_GetIndexInfo.GetRecordAuth(1,0)>=0){//0-13
				cardreadViewForm.getForm().findField("jgdm").setValue(HD_GetIndexInfo.GetRecordFileData(1,0));
				cardreadViewForm.getForm().findField("jgmc").setValue(HD_GetIndexInfo.GetRecordFileData(1,1));
				cardreadViewForm.getForm().findField("jgdz").setValue(HD_GetIndexInfo.GetRecordFileData(1,2));
				cardreadViewForm.getForm().findField("jglxdmOld").setValue(HD_GetIndexInfo.GetRecordFileData(1,3));
				cardreadViewForm.getForm().findField("jglxOld").setValue(HD_GetIndexInfo.GetRecordFileData(1,4));
				cardreadViewForm.getForm().findField("bfdw").setValue(HD_GetIndexInfo.GetRecordFileData(1,5));
				cardreadViewForm.getForm().findField("bzrq").setValue(HD_GetIndexInfo.GetRecordFileData(1,6));
				cardreadViewForm.getForm().findField("jjlxdm").setValue(HD_GetIndexInfo.GetRecordFileData(1,7));
				cardreadViewForm.getForm().findField("jjlx").setValue(HD_GetIndexInfo.GetRecordFileData(1,8));
				cardreadViewForm.getForm().findField("fddbr").setValue(HD_GetIndexInfo.GetRecordFileData(1,10));
				cardreadViewForm.getForm().findField("xzqhCode").setValue(HD_GetIndexInfo.GetRecordFileData(1,11));
				cardreadViewForm.getForm().findField("dhhm").setValue(HD_GetIndexInfo.GetRecordFileData(1,13));
			}else{
				alert("读取基本信息没有权限");
				return false;
			}
			if(HD_GetIndexInfo.GetRecordAuth(2,0)>=0){//0-32
				cardreadViewForm.getForm().findField("zch").setValue(HD_GetIndexInfo.GetRecordFileData(2,2));
				cardreadViewForm.getForm().findField("zczj").setValue(HD_GetIndexInfo.GetRecordFileData(2,3));
				cardreadViewForm.getForm().findField("hbzl").setValue(HD_GetIndexInfo.GetRecordFileData(2,4));
				cardreadViewForm.getForm().findField("hbzldm").setValue(HD_GetIndexInfo.GetRecordFileData(2,5));
				cardreadViewForm.getForm().findField("wftzgb").setValue(HD_GetIndexInfo.GetRecordFileData(2,6));
				cardreadViewForm.getForm().findField("wftzgbdm").setValue(HD_GetIndexInfo.GetRecordFileData(2,7));
				cardreadViewForm.getForm().findField("yzbm").setValue(HD_GetIndexInfo.GetRecordFileData(2,8));
				
			}else{
				alert("读取扩展信息没有权限");
				return false;
			}
			
			if(HD_GetIndexInfo.GetRecordAuth(4,0)>=0){
				cardreadViewForm.getForm().findField("njrq").setValue(HD_GetIndexInfo.GetRecordFileData(4,0));
				cardreadViewForm.getForm().findField("njqx").setValue(HD_GetIndexInfo.GetRecordFileData(4,1));
				
			}else{
				alert("读取年检信息没有权限");
				return false;
			}
			return true;
		}catch(e){
			alert(e.Exception);
			return false;
		}
	}else{
		alert("初始化失败！");
		return false;
	} 	
}
 