
//����XML����   
function createXMLHttps(){   
var ret = null;   
try {ret = new ActiveXObject('Msxml2.XMLHTTP')}   
catch (e) {   
    try {ret = new ActiveXObject('Microsoft.XMLHTTP')}   
        catch (ee) {ret = null}   
    }   
if (!ret&&typeof XMLHttpRequest !='undefined') ret = new XMLHttpRequest();   
return ret;   
}   

//====�첽ɾ���б�����=====
function deleteAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.succeedInfo('ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.errorInfo("ɾ��ʧ�ܣ�",330,220,"��ʾ��Ϣ");
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.errorInfo("ɾ��ʧ�ܣ�",330,220,"��ʾ��Ϣ");
								
	
			}    
  }   
xmlhttp.send(null);   

}  


function restoreAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.succeedInfo('�ָ��ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.errorInfo("�ָ�ʧ�ܣ�",330,220,"��ʾ��Ϣ");
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.errorInfo("�ָ�ʧ�ܣ�",330,220,"��ʾ��Ϣ");
								
	
			}    
  }   
xmlhttp.send(null);   

}  




function statusAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.alert('�����ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   

}  

   
//====�첽�����ö�=====
function forAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("forwardNewSucc") > -1){
					ymPrompt.alert('�����ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

function deleteAjaxForMore(URL) {
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					status=true;
				}else{
					status=false;
				}
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				status=false;
			}    
  }   
xmlhttp.send(null);   
return status;
} 

//====�첽�����ö�����ˣ�=====
function audiAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiNewSucc") > -1){
					ymPrompt.alert('��˳ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"���ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"���ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 
//�ύ
function audcommitAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiNewSucc") > -1){
					ymPrompt.alert('�ύ�ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"�ύʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"�ύʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 
//====ȡ�����=====
function unAudiAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiNewSucc") > -1){
					ymPrompt.alert('ȡ����˳ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ȡ�����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ȡ�����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====����====
function audiShareeAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiShareeSucc") > -1){
					ymPrompt.alert('����ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====ȡ������====
function unAudiShareeAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiShareeSucc") > -1){
					ymPrompt.alert('ȡ������ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====����=====
function audiMemo2Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiMemo2Succ") > -1){
					ymPrompt.alert('���óɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====ȡ������=====
function unAudiMemo2Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiMemo2Succ") > -1){
					ymPrompt.alert('ȡ�����óɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====����=====
function audiMemo3Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiMemo3Succ") > -1){
					ymPrompt.alert('�����ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====ȡ������=====
function unAudiMemo3Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiMemo3Succ") > -1){
					ymPrompt.alert('ȡ�������ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====����=====
function audiConsultAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiConsultSucc") > -1){
					ymPrompt.alert('���̳ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====ȡ������=====
function unAudiConsultAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiConsultSucc") > -1){
					ymPrompt.alert('ȡ�����̳ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ȡ������ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====ɾ����ɫ=====
function delRoleAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("delRoleSuc") > -1){
					ymPrompt.alert('ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleHasTOGroup") > -1){
					
					ymPrompt.alert({message:"��ɫ�Ѿ������û��飡", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleHasTOUser") > -1){
					
					ymPrompt.alert({message:"��ɫ�Ѿ������û���", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleidNULL") > -1){
					
					ymPrompt.alert({message:"��ɫIDΪ�գ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}else{
					ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====ɾ���û���=====
function delGroupAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("delGroupSuc") > -1){
					ymPrompt.alert('�û���ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("groupHasTOUser") > -1){
					
					ymPrompt.alert({message:"�û����Ѿ������û���", width:330, height:220, title:'��ʾ��Ϣ'});
					
				
				}else{
					ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====��ͨ����=====
function execAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.alert('�����ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 




//====ɾ��Ԫ����=====
function delEgovfuncAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("deleteNewSucc") > -1){
					ymPrompt.alert('ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("egovHasTOMeta") > -1){
					
					ymPrompt.alert({message:"ɾ��ʧ�ܣ���������Ԫ���ݣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				
				}
				else{
					ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====ɾ��Ԫ����2=====
function delEgovfuncMetaAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("deleteNewSucc") > -1){
					ymPrompt.alert('ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====ɾ����������=====
function delSuggestAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				if(xmlhttp.responseText.indexOf("deleteNewSucc") > -1||xmlhttp.responseText.indexOf("DelWorkSuc")>-1){
					ymPrompt.alert('ɾ���ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"ɾ��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====������̳�б�˳��=====
function uploadSortAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.alert('����˳��ɹ���',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"����˳��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"����˳��ʧ�ܣ�", width:330, height:220, title:'��ʾ��Ϣ'});
								
	
			}    
  }   
xmlhttp.send(null);   

}  