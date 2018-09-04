	
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

function AjaxStaticHtml(URL) { 
var xmlhttp = createXMLHttps();   
xmlhttp.open("Get",URL,true);   
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   
xmlhttp.onreadystatechange = function() {   

	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {   
         
		
		
         
		 }else if(xmlhttp.readyState == 4 && xmlhttp.status==404){
	
								
	
			}    
  }   
xmlhttp.send(null);   
   
}  

function make(){
	var array = ["index","SiteMap_index","header_index","header2_index","footer_index","contactUS_index","legalNotice_index","relatedLinks_index"];
	for(var i=0;i<array.length;i++){
		AjaxStaticHtml("/action/indexTemplate?file_name="+array[i]);
	}

	alert("静态发布成功！");
	/**
	var array2 = ["siteMap","onlineMessage","manScriptExpress","email","legalNotice","aboutUS","contactUS","header2","enterpriseCulture","CoOffice"];
	for(var i=0;i<array2.length;i++){
		AjaxStaticHtml("/action/indexTemplate?file_name="+array2[i]);
	}
	var array3 = ["newsListA","newsListC","newsListP"];
	for(var i=0;i<array3.length;i++){
		AjaxStaticHtml("/servlet/tuisonglistTempldate?file_name="+array3[i]);
	}
	*/
}
function make2(array){
	for(var i=0;i<array.length;i++){
		if(array[i].lastIndexOf("index")>-1){
		AjaxStaticHtml("/action/indexTemplate?file_name="+array[i]);
		}
	}
	alert("发布成功！");
	
}