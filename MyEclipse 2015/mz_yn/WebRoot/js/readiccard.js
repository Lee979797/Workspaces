 var bHaveClicked=false; //avoiding  click readcard button more than one times
 function fReadCard(){
	 codeInfo.innerHTML="���ڶ���...";
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
              alert("�򿪴���ʧ��!����ԭ��:"+jgdmicread.errorText);//������Ϣ��
    	      bHaveClicked=false;
    	      codeInfo.innerHTML="��������ʧ��!����ѡ����ȷ�Ķ˿ںţ�������!";
	      return;
	}
	
	//edit_err_msg.value=jgdmicread.jgdm
	loginForm.jgdm.value=jgdmicread.jgdm;
	//alert(jgdmicread.jgdm);
 	bHaveClicked=false;
 	codeInfo.innerHTML="�����������........";
        return;
 }
function fReStart(){
	loginForm.jgdm.value="";
  	
  	codeInfo.innerHTML="�����IC��........";	

 }
