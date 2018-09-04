function check_all(menu_id,MENU_ID)
{
 if(document.getElementById(menu_id).checked==true){
   for(var i=0;i<document.getElementsByName(MENU_ID).length;i++){
    document.getElementsByName(MENU_ID)[i].checked=true;
   }
  }else{
   for(var i=0;i<document.getElementsByName(MENU_ID).length;i++){
    document.getElementsByName(MENU_ID)[i].checked=false;
   }
 }
}
function check_level2(nowcheck,menu_name,menu_value){
 if(nowcheck.checked==true){
  for(var i=1;i<document.getElementsByName(menu_name).length;i++){
    if(document.getElementsByName(menu_name)[i].value.substring(0,menu_value.length)==menu_value){
	 document.getElementsByName(menu_name)[i].checked=true;
	}
	if(document.getElementsByName(menu_name)[i].alt==menu_value){
	document.getElementsByName(menu_name)[i].checked=true;
	}

		if(document.getElementsByName(menu_name)[i].value==menu_value.substring(0,4)){
	 document.getElementsByName(menu_name)[i].checked=true;
	}
	if(document.getElementsByName(menu_name)[i].value==menu_value.substring(0,6)){
	 document.getElementsByName(menu_name)[i].checked=true;
	}
	if(document.getElementsByName(menu_name)[i].value==menu_value.substring(0,8)){
	 document.getElementsByName(menu_name)[i].checked=true;
	}
   }
 }else{
   for(var i=1;i<document.getElementsByName(menu_name).length;i++){
    if(document.getElementsByName(menu_name)[i].value.substring(0,menu_value.length)==menu_value){
	 document.getElementsByName(menu_name)[i].checked=false;
	}
	if(document.getElementsByName(menu_name)[i].alt==menu_value){
	document.getElementsByName(menu_name)[i].checked=false;
	}
   }
 }

}