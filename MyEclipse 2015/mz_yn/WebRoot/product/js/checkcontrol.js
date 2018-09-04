/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: обнГ1:56
 * To change this template use File | Settings | File Templates.
 */
function submits(){
	checkControlForm.submit();
}
function checkAll(){
 if(document.getElementById("checkall").checked==true&&document.getElementsByName("jgdm")!=null){
   for(var i=0;i<document.getElementsByName("jgdm").length;i++){
     document.getElementsByName("jgdm")[i].checked=true;
   }
 }
 if(document.getElementById("checkall").checked==false&&document.getElementsByName("jgdm")!=null){
   for(var i=0;i<document.getElementsByName("jgdm").length;i++){
     document.getElementsByName("jgdm")[i].checked=false;
   }
 }
}