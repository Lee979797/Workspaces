/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 下午5:24
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
		ymPrompt.alert({message:"请选择信息！", width:330, height:220, title:'提示信息'});
	}else{
		ymPrompt.alert({message:'操作成功！', width:330, height:220, title:'提示信息'});
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
        ymPrompt.alert('请输入数字！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
		return false;
   }else{
        var pageCount =  parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){
		    ymPrompt.alert('输入数字不能大于总页数！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
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
		 ymPrompt.alert({message:"查询关键字不能包含", width:330, height:220, title:'提示信息'});
         return false;
	}
    if(specialChar2){
		 ymPrompt.alert({message:"查询关键字不能包含", width:330, height:220, title:'提示信息'});
         return false;
	}
	document.searchForm.submit();
}

//数据分发
   function dataSend(id){
            //确认是否分发数据
            ymPrompt.confirmInfo('您确认将该批次数据分发办证点?',330,220,'提示信息',function (data){if(data == 'ok'){
                FeedbackBo.feedbackSend(id,callback);
            }else{
                return false;
            }
            }
            )
        }
        function callback(data){
            if(data=="success"){
                var _log= {userid:document.getElementById("userid").value,username:document.getElementById("username").value,citysiteName:document.getElementById("citysite_name").value,opername:"问题数据下发",opervalue:"数据分发成功",operdate:document.getElementById("date").value};

				logbo.save(_log);
                ymPrompt.succeedInfo('数据分发成功！',330,220,'提示信息',function(){
 								history.go(0);});


            }else if(data=="fail"){
                ymPrompt.confirmInfo('数据分发失败！',330,220,'提示信息',function(){
 history.go(0);
});
            }else{
                ymPrompt.succeedInfo('数据分发失败！',330,220,'提示信息',function(){
 history.go(0);
});
            }
        }
function validateForm(){
     var startDate = document.searchForm.startDate.value;
	 var endDate = document.searchForm.endDate.value;
     if(!isEmpty(endDate)){
        if(isEmpty(startDate)){
            ymPrompt.alert('开始日期不能为空！',330,220,'提示信息',function(data){if(data == "ok"){}});
		    return false;
        }
     }
	 if(startDate>endDate){
		 ymPrompt.alert('开始日期不能大于结束日期！',330,220,'提示信息',function(data){if(data == "ok"){}});
		 return false;
	 }
	 document.searchForm.submit();
}