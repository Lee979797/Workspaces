/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-29
 * Time: ����10:11
 * To change this template use File | Settings | File Templates.
 */
  function startAction(url){
	  window.location.href=url;
  }
 function query(){
	// document.searchForm.pageno.value=1;
	 checkForm();
  }
function checkForm(){
    var specialChar = CheckSpecialChar(document.searchForm.searchValue.value,special_char.searchs);
	if(specialChar){
		  ymPrompt.alert('��ѯ�ؼ��ֲ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.searchValue.focus();}});
		 return false;
	}

	var startDate = document.searchForm.startDate.value;
	var endDate = document.searchForm.endDate.value;

	if(startDate>endDate){
		ymPrompt.alert('��ʼ���ڲ��ܴ��ڽ������ڣ�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){}});
		 return false;
	}

   if(!isNumber(document.searchForm.pageno.value)){
       ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
		return false;
   }else{
        var pageCount = parseInt(document.getElementById("totalPages").value);
		if(document.searchForm.pageno.value>pageCount){
		    ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
			return false;
		}
   }
   document.searchForm.submit();
}

function previousPage(){
     document.searchForm.pageno.value = document.getElementById("currentPage").value-1;
	 document.searchForm.submit();
}
function nextPage(){
     var page = document.getElementById("currentPage").value;
     document.searchForm.pageno.value = 1+parseInt(page);
	 document.searchForm.submit();
}
function firstPage(){
     document.searchForm.pageno.value = 1;
	 document.searchForm.submit();
}
function pageSort(filed,type){
	document.getElementById("orderbyColum").value = filed;
	document.getElementById("orderbyMethod").value = type;
	document.searchForm.submit();
}
function lastsPage(){
     document.searchForm.pageno.value = parseInt(document.getElementById("lastPage").value);
	 document.searchForm.submit();
}
function commitRowNum(){
    var types = document.getElementById("rowNumsView");
    document.getElementById("rowNums").value = types.options(types.selectedIndex).value;
    document.searchForm.submit();
}