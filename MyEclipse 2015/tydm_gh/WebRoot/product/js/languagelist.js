/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����9:43
 * To change this template use File | Settings | File Templates.
 */
  function startAction(url){
	  window.location.href=url;
  }
 function query(){
     var specialChar = CheckSpecialChar(searchForm.searchValue.value,special_char.searchs);
	if(specialChar){
		 ymPrompt.alert('��ѯ�ؼ��ֲ��ܰ���'+specialChar+'�ַ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){searchForm.searchValue.focus();}});

		 return false;
	}
     var num = document.searchForm.pageno.value;
     if(num!=0){
          document.searchForm.pageno.value=1;
     }
	 checkForm();
  }
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
		ymPrompt.alert({message:"��ѡ����Ϣ��", width:330, height:220, title:'��ʾ��Ϣ'});
	}else{
		ymPrompt.alert({message:'�����ɹ���', width:330, height:220, title:'��ʾ��Ϣ'});
	}
}


function view(val){
	ymPrompt.win('viewAddZryy.jsp?id='+val,400,300,'�鿴��Ȼ����',null,null,null,{id:'a'})
}
function down(){
	ymPrompt.win('exportexcel.jsp',400,200,'����Excel!',null,null,null,{id:'a'})
}
