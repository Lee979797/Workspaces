/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-8-31
 * Time: ����2:57
 * To change this template use File | Settings | File Templates.
 */
function checkForm(){
   if(!isNumber(document.searchForm.pageno.value)){
       ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
		return false;
   }else{
        var pageCount = parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){
            ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
			return false;
		}
   }
   var specialChar;
   if(typeof(document.searchForm.beginCodeId)!='undefined'){
        if(!isEmpty(document.searchForm.beginCodeId.value)){
          specialChar = CheckSpecialChar(document.searchForm.beginCodeId.value,special_char.searchs);
        }
   }
   if(typeof(document.searchForm.endCodeId)!='undefined'){
       if(!isEmpty(document.searchForm.endCodeId.value)){
          specialChar = CheckSpecialChar(document.searchForm.endCodeId.value,special_char.searchs);
       }
   }
   if(typeof(document.searchForm.codeId)!='undefined'){
       if(!isEmpty(document.searchForm.codeId.value)){
          specialChar = CheckSpecialChar(document.searchForm.codeId.value,special_char.searchs);
       }
   }
   if(specialChar){
      ymPrompt.alert({message:"��ѯ�ؼ��ֲ��ܰ���", width:330, height:220, title:'��ʾ��Ϣ'});
      return false;
   }
   document.searchForm.submit();
}
function dataSend(taskID){
    //ȷ���Ƿ�ַ�����
    ymPrompt.confirmInfo('��ȷ�Ͻ�δ������������ݷַ�����֤��?',330,220,'��ʾ��Ϣ',function (data){if(data == 'ok'){
        document.getElementById("data").style.display='inline';
        TaskBo.nationalDataSend(taskID,callback);
    }else{
        return false;
    }
    }
    )
}
function callback(data){
    var userid = document.getElementById("userid").value;
    var username = document.getElementById("username").value;
    var date = document.getElementById("date").value;
    var citysite_name = document.getElementById("citysite_name").value;
    if(data=="success"){
        var _log= {userid:userid,username:username,citysiteName:citysite_name,opername:"���������·�",opervalue:"�����·��ɹ�",operdate:date};
        logbo.save(_log);
        document.getElementById("data").style.display='none';
        ymPrompt.succeedInfo('���ݷַ��ɹ���',330,220,'��ʾ��Ϣ',function(){
                window.location.href="/action/taskAction?method=nationTaskList";
        });
    }else if(data=="repeat"){
        document.getElementById("data").style.display='none';
        ymPrompt.alert({message:"�����Ѿ��ַ���", width:330, height:220, title:'��ʾ��Ϣ'});
    }else{
        document.getElementById("data").style.display='none';
        ymPrompt.errorInfo("���ݷַ�ʧ�ܣ�",300,185,"��ʾ��Ϣ");
    }
}
function noRight(){
    ymPrompt.alert({message:"δ�������ݲ��ܲ鿴��", width:330, height:220, title:'��ʾ��Ϣ'});
}
