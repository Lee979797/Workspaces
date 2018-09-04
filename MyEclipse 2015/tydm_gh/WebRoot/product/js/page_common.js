function goPage(){
	var psize = searchForm.totalPages.value;
	var pno = searchForm.pageno.value;
    if(!isNumber(document.searchForm.pageno.value)){
        ymPrompt.alert('请输入数字！',330,220,'提示信息',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
		return;
    }
	if(parseInt(pno)<0){
		 ymPrompt.alert({message:'输入页数不合法！', width:330, height:220, title:'提示信息'});
		 return;
	}
	if(parseInt(pno)>parseInt(psize)){
		 ymPrompt.alert({message:'输入数字不能大于总页数！', width:330, height:220, title:'提示信息'});
	}else{
		searchForm.submit();
	}		 
}
function previousPage(){
     document.searchForm.pageno.value = document.getElementById("currentPage").value-1;
	 document.searchForm.submit();
}
function nextPage(){
     document.searchForm.pageno.value = 1+parseInt(document.getElementById("currentPage").value);
	 document.searchForm.submit();
}
function firstPage(){
     document.searchForm.pageno.value = 1;
	 document.searchForm.submit();
}
function endPage(){
     document.searchForm.pageno.value = parseInt(document.getElementById("lastPage").value);
	 document.searchForm.submit();
}
function refreshPage(){
     document.searchForm.pageno.value = 1;
	 document.searchForm.submit();
}
function pageSort(filed,type){
    if(!isNumber(searchForm.pageno.value)){
       document.searchForm.pageno.value = 1;
    }
	document.getElementById("orderbyColum").value = filed;
	document.getElementById("orderbyMethod").value = type;
	document.searchForm.submit();
}
function commitRowNum(){
    document.searchForm.pageno.value = 1;
    var types = document.getElementById("rowNumsView");
    document.getElementById("rowNums").value = types.options(types.selectedIndex).value;
    document.searchForm.submit();
}
