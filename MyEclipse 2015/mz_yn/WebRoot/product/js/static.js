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
    if(typeof(document.searchForm.cName)!='undefined'){
         if(!isEmpty(document.searchForm.cName.value)){
          specialChar = CheckSpecialChar(document.searchForm.cName.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.classID)!='undefined'){
         if(!isEmpty(document.searchForm.classID.value)){
          specialChar = CheckSpecialChar(document.searchForm.classID.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.sname)!='undefined'){
         if(!isEmpty(document.searchForm.sname.value)){
          specialChar = CheckSpecialChar(document.searchForm.sname.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.sID)!='undefined'){
         if(!isEmpty(document.searchForm.sID.value)){
          specialChar = CheckSpecialChar(document.searchForm.sID.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.codeid)!='undefined'){
         if(!isEmpty(document.searchForm.codeid.value)){
          specialChar = CheckSpecialChar(document.searchForm.codeid.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.codeCn)!='undefined'){
         if(!isEmpty(document.searchForm.codeCn.value)){
          specialChar = CheckSpecialChar(document.searchForm.codeCn.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.productName)!='undefined'){
         if(!isEmpty(document.searchForm.productName.value)){
          specialChar = CheckSpecialChar(document.searchForm.productName.value,special_char.searchs);
        }
    }
    if(typeof(document.searchForm.keyword)!='undefined'){
         if(!isEmpty(document.searchForm.keyword.value)){
          specialChar = CheckSpecialChar(document.searchForm.keyword.value,special_char.searchs);
        }
    }
    if(specialChar){
		 ymPrompt.alert({message:"查询关键字不能包含'", width:330, height:220, title:'提示信息'});
         isTrue = false;
		 return false;
	}
   document.searchForm.submit();
}

function checkboxALL()
{
	var chartValues =  document.getElementsByName("chartValue");
	for(var i =0 ; i<chartValues.length ;i++)
	{
		chartValues[i].checked= document.getElementById("chartValue").checked;
	}
}


function pieSubmit(){
    if(checkChoose()){
         document.searchForm.action = 'classPieProduct.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function pieEntSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'classPieEnterprise.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function pieProChart(){
    if(checkChoose()){
        document.searchForm.action = 'classPieProductChart.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function pieEntChart(){
    if(checkChoose()){
        document.searchForm.action = 'classPieEnterpriseChart.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function columnSubmit(){
    if(checkChoose()){
         document.searchForm.action = 'columnProduct.jsp';
         document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function columnEntSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'columnEnterprise.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }

}
function columnProChart(){
    if(checkChoose()){
        document.searchForm.action = 'columnProductChart.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }

}
function columnEntChart(){
    if(checkChoose()){
        document.searchForm.action = 'columnEnterpriseChart.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}
function scrollSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'standardScroll.jsp';
        document.searchForm.submit();
    }else{
       ymPrompt.alert({message:'请选择需要查看的信息', width:330, height:220, title:'提示信息'});
    }
}

function executePro(link){
     document.getElementById("data").style.display='inline';
     static.executePro(function(data){
        if(data=='success'){
            document.getElementById("data").style.display='none';
            document.getElementById("dataFinish").style.display='inline';
            if(link=='xzqh'){
               window.location.href="dataDetail.jsp";
            }else if(link=='data'){
               window.location.href="data.jsp";
            }else{
               window.location.href="newDataDetail.jsp";
            }
        }
     }
     );
}

function query(){
	 document.searchForm.pageno.value=1;
     var startDate = document.searchForm.startDate.value;
	 var endDate = document.searchForm.endDate.value;
	 if(startDate>endDate){
		ymPrompt.alert('开始日期不能大于结束日期！',330,220,'提示信息',function(data){if(data == "ok"){}});
		 return false;
	 }
	 checkForm();
}

function checkChoose(){

    var chartValues =  document.getElementsByName("chartValue");
	var flag = false;
	for(var i =0 ; i<chartValues.length ;i++)
	{
		if(chartValues[i].checked==true)
		{
			flag = true;
		}
	}
    return flag;
}