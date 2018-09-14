function formatStr(str){
	return str.substring(0,4)+""+str.substring(5,7)+""+str.substring(8,10);
}

var bHaveClicked=false;
function fWriteCardNJ(){
	var ret=0;
	
	if (bHaveClicked){
		return false;
	}else{
		bHaveClicked=true;
	}

	prt1.jgdm=cardnjViewForm.getForm().findField('jgdm').getValue();
	prt1.fddbr=cardnjViewForm.getForm().findField('fddbr').getValue();
	prt1.jjlxdm =cardnjViewForm.getForm().findField('jjlxdm').getValue();
	prt1.jjlx =cardnjViewForm.getForm().findField('jjlx').getValue();
	prt1.zch = cardnjViewForm.getForm().findField('zch').getValue();
	prt1.zczj = cardnjViewForm.getForm().findField('zczj').getValue();
	prt1.hbzldm = cardnjViewForm.getForm().findField('hbzldm').getValue();
	prt1.hbzl =cardnjViewForm.getForm().findField('hbzl').getValue();
	prt1.wftzgbdm = cardnjViewForm.getForm().findField('wftzgbdm').getValue();
	prt1.wftzgb = cardnjViewForm.getForm().findField('wftzgb').getValue();
	prt1.xzqh = cardnjViewForm.getForm().findField('xzqhCode').getValue();
	prt1.yzbm = cardnjViewForm.getForm().findField('yzbm').getValue();
	prt1.dhhm = cardnjViewForm.getForm().findField('dhhm').getValue();
	
	var d = cardnjViewForm.getForm().findField('njqx').getValue();
	prt1.njqx = formatStr(d);
	d = cardnjViewForm.getForm().findField('njrq').getValue();
	prt1.njrq = formatStr(d);
	
	ret=prt1.WriteQXCard(0,cardnjViewForm.getForm().findField('listCom').getValue());
	
	if (ret!=0){
	 	bHaveClicked=false;
	    return false;
	}
	
 	bHaveClicked=false;
    return true;
}