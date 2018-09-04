
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

//====异步删除列表数据=====
function deleteAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.succeedInfo('删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.errorInfo("删除失败！",330,220,"提示信息");
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.errorInfo("删除失败！",330,220,"提示信息");
								
	
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
					ymPrompt.succeedInfo('恢复成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.errorInfo("恢复失败！",330,220,"提示信息");
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.errorInfo("恢复失败！",330,220,"提示信息");
								
	
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
					ymPrompt.alert('操作成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   

}  

   
//====异步新闻置顶=====
function forAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("forwardNewSucc") > -1){
					ymPrompt.alert('操作成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
								
	
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

//====异步新闻置顶（审核）=====
function audiAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiNewSucc") > -1){
					ymPrompt.alert('审核成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"审核失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"审核失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 
//提交
function audcommitAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiNewSucc") > -1){
					ymPrompt.alert('提交成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"提交失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"提交失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 
//====取消审核=====
function unAudiAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiNewSucc") > -1){
					ymPrompt.alert('取消审核成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"取消审核失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"取消审核失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====共享====
function audiShareeAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiShareeSucc") > -1){
					ymPrompt.alert('共享成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"共享失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"共享失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====取消共享====
function unAudiShareeAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiShareeSucc") > -1){
					ymPrompt.alert('取消共享成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"取消共享失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"取消共享失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====采用=====
function audiMemo2Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiMemo2Succ") > -1){
					ymPrompt.alert('采用成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"采用失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"采用失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====取消采用=====
function unAudiMemo2Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiMemo2Succ") > -1){
					ymPrompt.alert('取消采用成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"取消采用失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"取消采用失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====发布=====
function audiMemo3Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiMemo3Succ") > -1){
					ymPrompt.alert('发布成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"发布失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"发布失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====取消发布=====
function unAudiMemo3Ajax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiMemo3Succ") > -1){
					ymPrompt.alert('取消发布成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"取消发布失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"取消发布失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}

//====会商=====
function audiConsultAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("audiConsultSucc") > -1){
					ymPrompt.alert('会商成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"会商失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"会商失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====取消会商=====
function unAudiConsultAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("unAudiConsultSucc") > -1){
					ymPrompt.alert('取消会商成功！',330,220,'提示信息',function(data){if(data == "ok"){
					window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"取消会商失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"取消会商失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
}
//====删除角色=====
function delRoleAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("delRoleSuc") > -1){
					ymPrompt.alert('删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleHasTOGroup") > -1){
					
					ymPrompt.alert({message:"角色已经赋予用户组！", width:330, height:220, title:'提示信息'});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleHasTOUser") > -1){
					
					ymPrompt.alert({message:"角色已经赋予用户！", width:330, height:220, title:'提示信息'});
					
				}else if(xmlhttp.responseText.trim().indexOf("roleidNULL") > -1){
					
					ymPrompt.alert({message:"角色ID为空！", width:330, height:220, title:'提示信息'});
					
				}else{
					ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====删除用户组=====
function delGroupAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("delGroupSuc") > -1){
					ymPrompt.alert('用户组删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("groupHasTOUser") > -1){
					
					ymPrompt.alert({message:"用户组已经赋予用户！", width:330, height:220, title:'提示信息'});
					
				
				}else{
					ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====普通操作=====
function execAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.alert('操作成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"操作失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 




//====删除元数据=====
function delEgovfuncAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("deleteNewSucc") > -1){
					ymPrompt.alert('删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else if(xmlhttp.responseText.trim().indexOf("egovHasTOMeta") > -1){
					
					ymPrompt.alert({message:"删除失败，功能下有元数据！", width:330, height:220, title:'提示信息'});
					
				
				}
				else{
					ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====删除元数据2=====
function delEgovfuncMetaAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("deleteNewSucc") > -1){
					ymPrompt.alert('删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====删除在线留言=====
function delSuggestAjax(URL) { 

var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				if(xmlhttp.responseText.indexOf("deleteNewSucc") > -1||xmlhttp.responseText.indexOf("DelWorkSuc")>-1){
					ymPrompt.alert('删除成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
					
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"删除失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   
   
} 

//====更新论坛列表顺序=====
function uploadSortAjax(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
				
				if(xmlhttp.responseText.trim().indexOf("success") > -1){
					ymPrompt.alert('更新顺序成功！',330,220,'提示信息',function(data){if(data == "ok"){window.location.reload();}});
					
				}else{
					ymPrompt.alert({message:"更新顺序失败！", width:330, height:220, title:'提示信息'});
				}
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
				ymPrompt.alert({message:"更新顺序失败！", width:330, height:220, title:'提示信息'});
								
	
			}    
  }   
xmlhttp.send(null);   

}  