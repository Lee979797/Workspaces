
 function fWriteCard(){
 	
	    /*Ext.Ajax.request({
			url : 'getSign.action',
			params : {jgdm:cardwriteViewForm.getForm().findField('jgdm').getValue(),bzjgdm:currentZzUserBzjgdm,bzrq:cardwriteViewForm.getForm().findField('bzrq').getValue()},
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
 					//alert("进入");
					var returnValue = HD_GetIndexInfo.GetAuth(0);		
					//alert("认证权限的返回值：" + returnValue);
					if(returnValue>=0){
						var flag = false;
						try{					
							if(HD_GetIndexInfo.GetRecordAuth(1,1)>=0){//alert("写入基本信息");
								HD_GetIndexInfo.UpdateRecordFileData(0,1,0,cardwriteViewForm.getForm().findField('jgdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,1,cardwriteViewForm.getForm().findField('jgmc').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,2,cardwriteViewForm.getForm().findField('jgdz').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,3,cardwriteViewForm.getForm().findField('jglxdmOld').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,4,cardwriteViewForm.getForm().findField('jglxOld').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,5,cardwriteViewForm.getForm().findField('bfdw').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,6,cardwriteViewForm.getForm().findField('bzrq').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,7,cardwriteViewForm.getForm().findField('jjlxdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,8,cardwriteViewForm.getForm().findField('jjlx').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,10,cardwriteViewForm.getForm().findField('fddbr').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,11,cardwriteViewForm.getForm().findField('xzqhCode').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,1,13,cardwriteViewForm.getForm().findField('dhhm').getValue());
								flag = true;
							}else{
								alert("写入基本信息没有权限");
								flag = false;
							}
							
							if(HD_GetIndexInfo.GetRecordAuth(2,1)>=0){///alert("写入扩展信息");
								HD_GetIndexInfo.UpdateRecordFileData(0,2,2,cardwriteViewForm.getForm().findField('zch').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,3,cardwriteViewForm.getForm().findField('zczj').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,4,cardwriteViewForm.getForm().findField('hbzl').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,5,cardwriteViewForm.getForm().findField('hbzldm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,6,cardwriteViewForm.getForm().findField('wftzgb').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,7,cardwriteViewForm.getForm().findField('wftzgbdm').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,2,8,cardwriteViewForm.getForm().findField('yzbm').getValue());
								flag = true;
							}else{
								alert("写入扩展信息没有权限");
								flag = false;
							}
							
							if(HD_GetIndexInfo.GetRecordAuth(4,1)>=0){//alert("写入年检信息");
								HD_GetIndexInfo.UpdateRecordFileData(0,4,0,cardwriteViewForm.getForm().findField('njrq').getValue());
								HD_GetIndexInfo.UpdateRecordFileData(0,4,1,cardwriteViewForm.getForm().findField('njqx').getValue());
								flag = true;
							}else{
								alert("写入年检信息没有权限");
								flag = false;
							}
							
							/*var a = HD_GetIndexInfo.UpdateRecordFileData(0,5,0,signData);
							if(a!=0){
								alert("写入签名数据失败！");
								flag = false;
							}*/
							
						}catch(e){
						 alert(e);
						}
						
						if(flag){
							Ext.Ajax.request({
								url : 'saveICKxlh.action',
								params : {ickxlh:HD_GetIndexInfo.GetDeviceSN(0),printerName:currentZzUsername,centerid:currentZzUserCenterid,orgCode:cardwriteViewForm.getForm().findField('jgdm').getValue()},
								method:'post', 
								waitTitle: '提示',
							    waitMsg: '数据正在重新加载中，请稍后',
								success : function(result,request) {
									alert("写卡成功！");
									cardwriteViewForm.getForm().reset();
								},
								failure: function(){
									alert("保存信息不成功！");
								}
							});
						}
						
					}else{
						alert("无权限操作！认证权限的返回值：" + returnValue);
					}
					
					
					//////////////////////////////////////////////////
				/*}else{
					alert("初始化失败："+reResult.errorMessage);
				}
			},
			failure: function(){
				alert("写入3+1信息失败！key出现错误请联系厂家！");
			}
		});*/
	    
 }