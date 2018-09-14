var bHaveClicked=false; //avoiding  click readcard button more than one times
 function fReadCard(){
    //cmdReadCard.enabled=false
	if (bHaveClicked){
		return false;
	}else{
		bHaveClicked=true;
	}
	
	var rtn=false;
	rtn=jgdmicread.readcard(cardreadViewForm.getForm().findField("listCom").getValue());
	
	if (rtn=false){
        alert("打开串口失败!错误原因:"+jgdmicread.errorText);//定义信息。
    	bHaveClicked=false;
	    return false;
	}
		
	cardreadViewForm.getForm().findField("jgmc").setValue(jgdmicread.jgmc);
	cardreadViewForm.getForm().findField("jgdz").setValue(jgdmicread.jgdz);
	cardreadViewForm.getForm().findField("jgdm").setValue(jgdmicread.jgdm);
	cardreadViewForm.getForm().findField("jglxOld").setValue(jgdmicread.jglx);
	cardreadViewForm.getForm().findField("jglxdmOld").setValue(jgdmicread.jglxdm);
	cardreadViewForm.getForm().findField("bfdw").setValue(jgdmicread.bfdwmc);
	cardreadViewForm.getForm().findField("bzrq").setValue(jgdmicread.bfrq);
	cardreadViewForm.getForm().findField("fddbr").setValue(jgdmicread.fddbr);
	cardreadViewForm.getForm().findField("hbzl").setValue(jgdmicread.hbzl);
	cardreadViewForm.getForm().findField("hbzldm").setValue(jgdmicread.hbzldm);
	cardreadViewForm.getForm().findField("jjlx").setValue(jgdmicread.jjlx);
	cardreadViewForm.getForm().findField("jjlxdm").setValue(jgdmicread.jjlxdm);
	cardreadViewForm.getForm().findField("xzqhCode").setValue(jgdmicread.xzqh);
	cardreadViewForm.getForm().findField("zch").setValue(jgdmicread.zch);
	cardreadViewForm.getForm().findField("yzbm").setValue(jgdmicread.yzbm);
	cardreadViewForm.getForm().findField("zczj").setValue(jgdmicread.zczj);
	cardreadViewForm.getForm().findField("njqx").setValue(jgdmicread.njqx);
	cardreadViewForm.getForm().findField("wftzgb").setValue(jgdmicread.wftzgb);
	cardreadViewForm.getForm().findField("wftzgbdm").setValue(jgdmicread.wftzgbdm);
	cardreadViewForm.getForm().findField("njrq").setValue(jgdmicread.njrq);
	cardreadViewForm.getForm().findField("dhhm").setValue(jgdmicread.dhhm);
	
	bHaveClicked=false;
	
    return true;
 }
function fReStart(){
  	jgdmicread.jgmc="";
	jgdmicread.jgdz="";
	jgdmicread.jgdm="";
	jgdmicread.jglx="";
	jgdmicread.jglxdm="";
	jgdmicread.bfdwmc="";
	jgdmicread.bfrq="";
	jgdmicread.fddbr="";
	jgdmicread.hbzl="";
	jgdmicread.hbzldm="";
	jgdmicread.jjlx="";
	jgdmicread.jjlxdm="";
	jgdmicread.xzqh="";
	jgdmicread.zch="";
	jgdmicread.yzbm="";
	jgdmicread.zczj="";
	jgdmicread.njqx="";
	jgdmicread.wftzgb="";
	jgdmicread.wftzgbdm="";
	jgdmicread.njrq="";
	jgdmicread.dhhm="";
 }