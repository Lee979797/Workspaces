/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-8-31
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
function checkForm(){
   if(!isNumber(document.searchForm.pageno.value)){
       ymPrompt.alert('请输入数字！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
		return false;
   }else{
        var pageCount = parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){
            ymPrompt.alert('输入数字不能大于总页数！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
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
      ymPrompt.alert({message:"查询关键字不能包含", width:330, height:220, title:'提示信息'});
      return false;
   }
   document.searchForm.submit();
}
function dataSend(taskID){
    //确认是否分发数据
    ymPrompt.confirmInfo('您确认将未处理的任务数据分发给办证点?',330,220,'提示信息',function (data){if(data == 'ok'){
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
        var _log= {userid:userid,username:username,citysiteName:citysite_name,opername:"任务数据下发",opervalue:"数据下发成功",operdate:date};
        logbo.save(_log);
        document.getElementById("data").style.display='none';
        ymPrompt.succeedInfo('数据分发成功！',330,220,'提示信息',function(){
                window.location.href="/action/taskAction?method=nationTaskList";
        });
    }else if(data=="repeat"){
        document.getElementById("data").style.display='none';
        ymPrompt.alert({message:"数据已经分发！", width:330, height:220, title:'提示信息'});
    }else{
        document.getElementById("data").style.display='none';
        ymPrompt.errorInfo("数据分发失败！",300,185,"提示信息");
    }
}
function noRight(){
    ymPrompt.alert({message:"未处理数据不能查看！", width:330, height:220, title:'提示信息'});
}
