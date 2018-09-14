
var bHaveClicked=false; //avoiding  click readcard button more than one times

function ToDBC(str) 
{ 
	var tmp = ""; 
	for(var i=0;i<str.length;i++) 
	{ 
		if(str.charCodeAt(i)==32) 
		{ 
			tmp= tmp+ String.fromCharCode(12288); 
		} 
		if(str.charCodeAt(i)<127) 
		{ 
			tmp=tmp+String.fromCharCode(str.charCodeAt(i)+65248); 
		} 
	} 
	return tmp; 
} 

function formatStr(str){
	return str.substring(0,4)+""+str.substring(5,7)+""+str.substring(8,10);
}

function fPrintCard(){
	
	var ret=0;
	//打印端口
	//prt.gPrintPort="LPT1:";
	//通讯波特率
	//prt.gBaudRate=9600;
	//打印机类型
	//prt.gPrinterType=2;
	//通讯端口
	//prt.gCommunicationPort=1;
	
	if (bHaveClicked){
		return false;
	}else{
		bHaveClicked=true;
	}
	
	var dm = cardDPrintViewForm.getForm().findField('jgdm').getValue();
	var dm1 = dm.substring(0,8)+'-'+dm.charAt(8);
	prt.jgdm = dm;
	prt.jgdm1 = ToDBC(dm1);
	prt.jgmc = cardDPrintViewForm.getForm().findField('jgmc').getValue();
	var d = cardDPrintViewForm.getForm().findField('jgdz').getValue();
	prt.jgdz= d.substr(0,39);
	prt.jglx= cardDPrintViewForm.getForm().findField('jglxOld').getValue();
	prt.fddbr= cardDPrintViewForm.getForm().findField('fddbr').getValue();
	prt.bfdw= cardDPrintViewForm.getForm().findField('bfdw').getValue();
	
	d = cardDPrintViewForm.getForm().findField('bzrq').getValue();
	prt.bfrq1= d.substring(0,4)+"年"+d.substring(5,7)+"月"+d.substring(8,10)+"日";
	prt.bfrq =  formatStr(d);	
	
	prt.jglxdm = cardDPrintViewForm.getForm().findField('jglxdmOld').getValue();
	
	prt.jjlxdm =cardDPrintViewForm.getForm().findField('jjlxdm').getValue();
	prt.jjlx = cardDPrintViewForm.getForm().findField('jjlx').getValue();
	prt.zch = cardDPrintViewForm.getForm().findField('zch').getValue();
	prt.zczj = cardDPrintViewForm.getForm().findField('zczj').getValue();
	prt.hbzldm = cardDPrintViewForm.getForm().findField('hbzldm').getValue();
	prt.hbzl = cardDPrintViewForm.getForm().findField('hbzl').getValue();
	prt.wftzgbdm = cardDPrintViewForm.getForm().findField('wftzgbdm').getValue();
	prt.wftzgb = cardDPrintViewForm.getForm().findField('wftzgb').getValue();
	prt.xzqh = cardDPrintViewForm.getForm().findField('xzqhCode').getValue();
	prt.yzbm = cardDPrintViewForm.getForm().findField('yzbm').getValue();
	prt.dhhm = cardDPrintViewForm.getForm().findField('dhhm').getValue();
	
	d = cardDPrintViewForm.getForm().findField('njqx').getValue();
	prt.njqx = formatStr(d);
	
	d = cardDPrintViewForm.getForm().findField('njrq').getValue();
	prt.njrq = formatStr(d);

	ret=prt.PrintIcCard(1);
	
	if (ret!=0){alert(ret);
	 	bHaveClicked=false;
	   	alert("打印IC失败!请先确认打卡机连接正确，再重试!");
	 	return false;
	}
	
 	bHaveClicked=false;
 	return true;
}	