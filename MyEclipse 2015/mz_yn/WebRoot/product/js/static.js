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
		 ymPrompt.alert({message:"��ѯ�ؼ��ֲ��ܰ���'", width:330, height:220, title:'��ʾ��Ϣ'});
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
		ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function pieEntSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'classPieEnterprise.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function pieProChart(){
    if(checkChoose()){
        document.searchForm.action = 'classPieProductChart.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function pieEntChart(){
    if(checkChoose()){
        document.searchForm.action = 'classPieEnterpriseChart.jsp';
        document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function columnSubmit(){
    if(checkChoose()){
         document.searchForm.action = 'columnProduct.jsp';
         document.searchForm.submit();
    }else{
		ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function columnEntSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'columnEnterprise.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }

}
function columnProChart(){
    if(checkChoose()){
        document.searchForm.action = 'columnProductChart.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }

}
function columnEntChart(){
    if(checkChoose()){
        document.searchForm.action = 'columnEnterpriseChart.jsp';
        document.searchForm.submit();
    }else{
        ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}
function scrollSubmit(){
    if(checkChoose()){
        document.searchForm.action = 'standardScroll.jsp';
        document.searchForm.submit();
    }else{
       ymPrompt.alert({message:'��ѡ����Ҫ�鿴����Ϣ', width:330, height:220, title:'��ʾ��Ϣ'});
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
		ymPrompt.alert('��ʼ���ڲ��ܴ��ڽ������ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){}});
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