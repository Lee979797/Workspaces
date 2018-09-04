/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-29
 * Time: 下午5:42
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
		ymPrompt.alert({message:"操作成功！',330,220,'提示信息');
	}
}
function startAction(url){
	  window.location.href=url;
}
function query(){

	 document.searchForm.pageno.value=1;
	 checkFormSelect();
}

function checkFormSelect(){

	var specialChar = CheckSpecialChar(document.searchForm.searchValue.value,special_char.searchs);
	if(specialChar){
		  alert(", width:330, height:220, title:'提示信息'});

		 return false;
	}
	  document.searchForm.submit();
}