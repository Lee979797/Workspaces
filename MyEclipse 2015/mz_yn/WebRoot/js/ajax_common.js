
//创建XML对象   
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
/*国家图书馆用户登录*/
function commonAjaxLogin(URL) {//同步
var status=false;
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,false);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {  
				if(xmlhttp.responseText.trim().indexOf("emptyUserName") > -1){
					alert("用户名为空");
				}else if(xmlhttp.responseText.trim().indexOf("emptyPassword") > -1){
					alert("密码为空");
				}else if(xmlhttp.responseText.trim().indexOf("errorPassword") > -1){
					alert("用户名或密码错误");
				}else if(xmlhttp.responseText.trim().indexOf("errorValidateCode") > -1){
					alert("验证码错误");
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
/*工作管理右侧页面载入*/
function commonAjaxWorkRight(URL) {//异步

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
function commonAjax(URL) {//同步
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
function commonAjaxNoneSyc(URL) {//异步
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
