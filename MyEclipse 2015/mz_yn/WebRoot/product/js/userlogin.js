/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����2:20
 * To change this template use File | Settings | File Templates.
 */
function startAction(url){
	  window.location.href=url;
  }
 function query(){
	 document.searchForm.pageno.value=1;
	 checkForm();
  }
 

function checkForm(){
    var specialChar;
    if(typeof(document.searchForm.searchValue)!='undefined'){
        if(!isEmpty(document.searchForm.searchValue.value)){
          specialChar = CheckSpecialChar(document.searchForm.searchValue.value,special_char.username);
            if(specialChar){
                 ymPrompt.alert('��ѯ�ؼ��ֲ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.searchValue.focus();}});
                 return false;
	        }
        }
    }
    if(typeof(document.searchForm.userLoginValue)!='undefined'){
        if(!isEmpty(document.searchForm.userLoginValue.value)){
          specialChar = CheckSpecialChar(document.searchForm.userLoginValue.value,special_char.username);
            if(specialChar){
                 ymPrompt.alert('��ѯ�ؼ��ֲ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.userLoginValue.focus();}});
                 return false;
	        }
        }
    }
	var startDate = document.searchForm.startDate.value;
	var endDate = document.searchForm.endDate.value;

	if(startDate>endDate){
		ymPrompt.alert('��ʼ���ڲ��ܴ��ڽ������ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){}});
		 return false;
	}
   if(!isNumber(document.searchForm.pageno.value)){

		ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.pageno.focus();}});
		return false;
   }else{
        var pageCount = parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){

		ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.pageno.focus();}});
			return false;
		}

   }
   document.searchForm.submit();
}
