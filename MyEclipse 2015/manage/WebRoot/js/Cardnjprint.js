
function fWriteCardNJ(){
	
/*		Ext.Ajax.request({
			url : 'getSign.action',
			params : {jgdm:cardnjViewForm.getForm().findField('jgdm').getValue(),bzjgdm:currentZzUserBzjgdm,bzrq:cardwriteViewForm.getForm().findField('bzrq').getValue()},
			method:'post', 
			waitTitle: '提示',
		    waitMsg: '数据正在重新加载中，请稍后',
			success : function(result,request) {
				eval("var reResult="+result.responseText);
				
				if(reResult.errorMessage==""){
				    var result = reResult.re;
					result = result.replace(/@n@/g, "\n");
					result = result.replace(/@r@/g, "\r");
					var signData = result;*/
					/////////////////////////////////////////////////
					var returnValue = HD_GetIndexInfo.GetAuth(0);		
					//alert("认证权限的返回值：" + returnValue);
					if(returnValue>=0){
						try{					
							if(HD_GetIndexInfo.GetRecordAuth(1,1)>=0){
								HD_GetIndexInfo.UpdateRecordFileData(0,1,0,cardnjViewForm.getForm().findField('jgdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,7,cardnjViewForm.getForm().findField('jjlxdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,8,cardnjViewForm.getForm().findField('jjlx').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,10,cardnjViewForm.getForm().findField('fddbr').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,11,cardnjViewForm.getForm().findField('xzqhCode').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,13,cardnjViewForm.getForm().findField('dhhm').getValue());
								
							}else{
								alert("写入基本信息没有权限");
							}
							
							if(HD_GetIndexInfo.GetRecordAuth(2,1)>=0){
								HD_GetIndexInfo.UpdateRecordFileData(0,2,2,cardnjViewForm.getForm().findField('zch').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,3,cardnjViewForm.getForm().findField('zczj').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,4,cardnjViewForm.getForm().findField('hbzl').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,5,cardnjViewForm.getForm().findField('hbzldm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,6,cardnjViewForm.getForm().findField('wftzgb').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,7,cardnjViewForm.getForm().findField('wftzgbdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,8,cardnjViewForm.getForm().findField('yzbm').getValue());
								
							}else{
								alert("写入扩展信息没有权限");
							}
							
							if(HD_GetIndexInfo.GetRecordAuth(4,1)>=0){
								HD_GetIndexInfo.UpdateRecordFileData(0,4,0,cardnjViewForm.getForm().findField('njrq').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,4,1,cardnjViewForm.getForm().findField('njqx').getValue());
							}else{
								alert("写入年检信息没有权限");
							}
							
							/*var a = HD_GetIndexInfo.UpdateRecordFileData(0,5,0,signData);
							if(a!=0){
								alert("写入签名数据失败！");
							}*/
							
						}catch(e){
						 alert(e);
						}
						alert("卡年检成功！");
						cardnjViewForm.getForm().reset();
					}else{
						alert("无权限操作！认证权限的返回值：" + returnValue);
					}
					
					
					//////////////////////////////////////////////////
/*				}else{
					alert("初始化失败："+reResult.errorMessage);
				}
			},
			failure: function(){
				alert("写入3+1信息失败！key出现错误请联系厂家！");
			}
		});*/
	    
}