/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-29
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */

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
   document.searchForm.submit();
}
