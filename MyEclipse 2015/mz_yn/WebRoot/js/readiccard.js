 var bHaveClicked=false; //avoiding  click readcard button more than one times
 function fReadCard(){
	 codeInfo.innerHTML="正在读卡...";
	//cmdReadCard.enabled=false
	if (bHaveClicked){
		return false;
	}else{
		bHaveClicked=true;
	}
	jgdmicread.nport=loginForm.listCom.value;
	
	
	var rtn=false;
	rtn=jgdmicread.readcard(jgdmicread.nport);
	if (rtn==false){
              alert("打开串口失败!错误原因:"+jgdmicread.errorText);//定义信息。
    	      bHaveClicked=false;
    	      codeInfo.innerHTML="　　读卡失败!请先选择正确的端口号，再重试!";
	      return;
	}
	
	//edit_err_msg.value=jgdmicread.jgdm
	loginForm.jgdm.value=jgdmicread.jgdm;
	//alert(jgdmicread.jgdm);
 	bHaveClicked=false;
 	codeInfo.innerHTML="　　读卡完毕........";
        return;
 }
function fReStart(){
	loginForm.jgdm.value="";
  	
  	codeInfo.innerHTML="请插入IC卡........";	

 }
