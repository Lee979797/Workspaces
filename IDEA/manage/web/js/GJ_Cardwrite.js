 
 function formatStr(str){
	return str.substring(0,4)+""+str.substring(5,7)+""+str.substring(8,10);
 }
 
 var bHaveClicked=false; //avoiding  click readcard button more than one times
 var nIcCardKxlh=0;
 function fWriteCard(){
 	
 	if (bHaveClicked){
		return false;
	}else{
		bHaveClicked=true;
	}
	
	SmartCard.nport=cardwriteViewForm.getForm().findField('listCom').getValue();
	
    var rtn=SmartCard.GetSerialNO() ;
    
    if (rtn!=0)
    {    
       alert("无法取得卡序列号！错误原因："+SmartCard.GetLastError(rtn));
       bHaveClicked=false;
       return false;
    }
    pbar.updateProgress(0.4);
    
    nIcCardKxlh=SmartCard.serialNO;
	//机构代码
 	SmartCard.jgdm =cardwriteViewForm.getForm().findField('jgdm').getValue();
 	//机构名称
	SmartCard.jgmc =cardwriteViewForm.getForm().findField('jgmc').getValue();
	//地址
	SmartCard.jgdz =cardwriteViewForm.getForm().findField('jgdz').getValue();
	
	SmartCard.jglx =cardwriteViewForm.getForm().findField('jglxOld').getValue();
	SmartCard.jglxdm=cardwriteViewForm.getForm().findField('jglxdmOld').getValue();
	SmartCard.bfdw=cardwriteViewForm.getForm().findField('bfdw').getValue();
	
	var d = Ext.get("bzrq_cardwrite").dom.value;//cardwriteViewForm.getForm().findField('bzrq').getValue();
	SmartCard.bfrq=formatStr(d);
	
	SmartCard.fddbr=cardwriteViewForm.getForm().findField('fddbr').getValue();
	SmartCard.jjlx=cardwriteViewForm.getForm().findField('jjlx').getValue();
	SmartCard.jjlxdm=cardwriteViewForm.getForm().findField('jjlxdm').getValue();
	SmartCard.zch=cardwriteViewForm.getForm().findField('zch').getValue();
	SmartCard.zczj=cardwriteViewForm.getForm().findField('zczj').getValue();
	SmartCard.hbzl=cardwriteViewForm.getForm().findField('hbzl').getValue();
	SmartCard.hbzldm=cardwriteViewForm.getForm().findField('hbzldm').getValue();
	SmartCard.wftzgb=cardwriteViewForm.getForm().findField('wftzgb').getValue();
	SmartCard.wftzgbdm=cardwriteViewForm.getForm().findField('wftzgbdm').getValue();
	SmartCard.xzqh=cardwriteViewForm.getForm().findField('xzqhCode').getValue();
	SmartCard.yzbm=cardwriteViewForm.getForm().findField('yzbm').getValue();
	SmartCard.dhhm=cardwriteViewForm.getForm().findField('dhhm').getValue();
	
	d = Ext.get("njqx_cardwrite").dom.value;//cardwriteViewForm.getForm().findField('njqx').getValue();
	SmartCard.njqx=formatStr(d);
	
	d = Ext.get("njrq_cardwrite").dom.value;//cardwriteViewForm.getForm().findField('njrq').getValue();
	SmartCard.njrq=formatStr(d);
	
	pbar.updateProgress(0.6);
	rtn=SmartCard.writeCard();
	pbar.updateProgress(0.8);
	
	if (rtn==0) {
		pbar.updateProgress(1);
	}else{
	 	
        alert("打开串口失败!错误原因:"+SmartCard.GetLastError(rtn));//定义信息。
        
        win.close();
        return false;
	}
	bHaveClicked=false;
    return true;
 }
/*function fReStart(){
  	textjgdm.value="";
	textjgmc.value="";
	textjgdz.value="";
	textjglxdm.value="";
	textjglx.value="";
	textbfdwmc.value="";
	textbfrq.value="";
	textfddbr.value="";
	textjjlxdm.value="";
	textjjlx.value="";
	textzch.value="";
	textzczj.value="";
	texthbzldm.value="";
	texthbzl.value="";
	textwftzgbdm.value="";
	textwftzgb.value="";
	textxzqh.value="";
	textyzbm.value="";
	textdhhm.value="";
	textnjqx.value="";
	textnjrq.value="";
        StatusDisp.innerHTML="请插入IC卡........";	

 }
 function fCheckPSW(){
 	var rtn=1;
 	var str="";
 	str=window.prompt("请输入省级密钥卡密码","");
	SmartCard.nport=listCom.value;
	if(str==null || str.length<=0){
	  alert("请输入省级密钥卡密码");
	  return false;
	}
	rtn=SmartCard.CheckPWD(str);
	if (rtn==0) {
	 strErr="校验成功";
	}else{
	 strErr="校验失败";
	}
	StatusDisp.innerHTML="   "+strErr+"........";
 }*/