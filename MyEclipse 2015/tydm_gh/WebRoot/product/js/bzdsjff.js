/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����5:24
 * To change this template use File | Settings | File Templates.
 */
function allSelected() {
	var handleEl = document.getElementById("pcheckedall");
	var checkBoxList = document.getElementsByName("pchecked");
	for(i=0; i < checkBoxList.length; i++) {
		checkBoxList[i].checked = handleEl.checked;
	}
}

function Combined(){
	var checkBoxList = document.getElementsByName("pchecked");
	var flag = false;
	for(i=0; i < checkBoxList.length; i++) {
		if(checkBoxList[i].checked == true){
			flag = true;
		}
	}
	if(!flag){
		ymPrompt.alert({message:"��ѡ����Ϣ��", width:330, height:220, title:'��ʾ��Ϣ'});
	}else{
		ymPrompt.alert({message:'�����ɹ���', width:330, height:220, title:'��ʾ��Ϣ'});
	}
}
function startAction(url){
	  window.location.href=url;
  }
 function query(){

	 document.searchForm.pageno.value=1;
	 checkFormSelect();
  }
function checkForm(){
   if(!isNumber(document.searchForm.pageno.value)){
        ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
		return false;
   }else{
        var pageCount =  parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){
		    ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
			return false;
		}

   }
   document.searchForm.submit();
}
function checkFormSelect(){

	var specialChar;
    if(typeof(document.searchForm.searchValue)!='undefined'){
        if(!isEmpty(document.searchForm.searchValue.value)){
            specialChar = CheckSpecialChar(document.searchForm.searchValue.value,special_char.searchs);
         }
    }
	var specialChar2;
    if(typeof(document.searchForm.searchValueStatus)!='undefined'){
         if(!isEmpty(document.searchForm.searchValueStatus.value)){
            specialChar2 = CheckSpecialChar(document.searchForm.searchValueStatus.value,special_char.searchs);
         }
    }
	if(specialChar){
		 ymPrompt.alert({message:"��ѯ�ؼ��ֲ��ܰ���", width:330, height:220, title:'��ʾ��Ϣ'});
         return false;
	}
    if(specialChar2){
		 ymPrompt.alert({message:"��ѯ�ؼ��ֲ��ܰ���", width:330, height:220, title:'��ʾ��Ϣ'});
         return false;
	}
	document.searchForm.submit();
}

//���ݷַ�
   function dataSend(id){
            //ȷ���Ƿ�ַ�����
            ymPrompt.confirmInfo('��ȷ�Ͻ����������ݷַ���֤��?',330,220,'��ʾ��Ϣ',function (data){if(data == 'ok'){
                FeedbackBo.feedbackSend(id,callback);
            }else{
                return false;
            }
            }
            )
        }
        function callback(data){
            if(data=="success"){
                var _log= {userid:document.getElementById("userid").value,username:document.getElementById("username").value,citysiteName:document.getElementById("citysite_name").value,opername:"���������·�",opervalue:"���ݷַ��ɹ�",operdate:document.getElementById("date").value};

				logbo.save(_log);
                ymPrompt.succeedInfo('���ݷַ��ɹ���',330,220,'��ʾ��Ϣ',function(){
 								history.go(0);});


            }else if(data=="fail"){
                ymPrompt.confirmInfo('���ݷַ�ʧ�ܣ�',330,220,'��ʾ��Ϣ',function(){
 history.go(0);
});
            }else{
                ymPrompt.succeedInfo('���ݷַ�ʧ�ܣ�',330,220,'��ʾ��Ϣ',function(){
 history.go(0);
});
            }
        }
function validateForm(){
     var startDate = document.searchForm.startDate.value;
	 var endDate = document.searchForm.endDate.value;
     if(!isEmpty(endDate)){
        if(isEmpty(startDate)){
            ymPrompt.alert('��ʼ���ڲ���Ϊ�գ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){}});
		    return false;
        }
     }
	 if(startDate>endDate){
		 ymPrompt.alert('��ʼ���ڲ��ܴ��ڽ������ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){}});
		 return false;
	 }
	 document.searchForm.submit();
}