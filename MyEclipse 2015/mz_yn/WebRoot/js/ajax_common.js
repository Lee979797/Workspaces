
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


function AjaxSync(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
		
		
			 	
			 	//alert(xmlhttp.responseText.trim());
			//document.getElementById("visitorCount").innerHTML = xmlhttp.responseText.trim();
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
	
								
	
		}    
  }   
xmlhttp.send(null);   
   
}
/*����ͼ����û���¼*/
function commonAjaxLogin(URL) {//ͬ��
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,false);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {  
				if(xmlhttp.responseText.trim().indexOf("emptyUserName") > -1){
					alert("�û���Ϊ��");
				}else if(xmlhttp.responseText.trim().indexOf("emptyPassword") > -1){
					alert("����Ϊ��");
				}else if(xmlhttp.responseText.trim().indexOf("errorPassword") > -1){
					alert("�û������������");
				}else if(xmlhttp.responseText.trim().indexOf("errorValidateCode") > -1){
					alert("��֤�����");
				}else if(xmlhttp.responseText.trim().indexOf("success") > -1){
					window.location.href = document.loginForm.goPage.value;
				}
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				status=false;
			}    
  }   
xmlhttp.send(null);   
return status;
} 
/*���������Ҳ�ҳ������*/
function commonAjaxWorkRight(URL) {//�첽

var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {  
				//alert(xmlhttp.responseText.trim());
				document.getElementById("work_right").innerHTML = xmlhttp.responseText.trim();
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				status=false;
			}    
  }   
xmlhttp.send(null);   
return status;
} 
function commonAjax(URL) {//ͬ��
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,false);   
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

function commonAjaxNone(URL) {
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,false);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {  
				if(xmlhttp.responseText.indexOf("success") > -1){
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
function commonAjaxNoneSyc(URL) {//�첽
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {  
				if(xmlhttp.responseText.indexOf("success") > -1){
					status=true;
				}else{
					status=false;
				}
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				status=false;
			}    
  }   
xmlhttp.send(null);   
} 
