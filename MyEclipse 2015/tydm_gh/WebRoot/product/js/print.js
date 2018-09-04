function PrintContent(el) { 
	 
    var iframe = document.createElement('IFRAME'); 

		var content=document.getElementById(el); 
		
		var doc = null; 
		
		iframe.style.position="absolute"; 
		
		iframe.style.width="0px"; 
		
		iframe.style.height="0px"; 
		
		iframe.style.left="-500px"; 
		
		iframe.style.top="-500px"; 

    document.body.appendChild(iframe); 

    doc = iframe.contentWindow.document;
    var links = window.document.getElementsByTagName('link'); 
    var str = "";
    for (var i = 0; i < links.length; i++) {

        if (links[i].rel.toLowerCase() == 'stylesheet') {

        	
					str += '<link type="text/css" rel="stylesheet" href="' + links[i].href + '"></link>';

				}              
    }
    var css = "<style>.tr_1 {font-size: 12px;line-height: 24px;color: #767676;background-color: #fff;text-indent: 3px;}.page_table {background-color: #efefef;}.page_table2 {background-color: #999;}.page_main {margin: 5px;}.tr_biaoti {font-size: 20px; font-weight:800;line-height: 30px;text-align: center;margin-bottom: 10px;margin-top: 10px;}body {margin: 0px;background-color: #fff;}.tr_td_4 {font-size: 14px;line-height: 24px;color: #000;background-color: #fff;text-indent: 3px;}</style>";
    var _tempContent = replacdAandImage(content.innerHTML);
		doc.write('<TBODY><br/><center>' + _tempContent + '</center>'+css+'</TBODY>');
		doc.close();
    iframe.contentWindow.focus();
    iframe.contentWindow.print();
    document.body.removeChild(iframe);
}

function replacdAandImage(str){
	 var reg1 = "<A.*?>[\s|\S]*?</A>";
	 var reg2 = "<IMG.*?>";
	 str = str.replaceAll(reg1,"");
	 str = str.replaceAll(reg2,"");
	 return str;
}

String.prototype.replaceAll  = function(AFindText,ARepText){    
	 
	 return this.replace(new RegExp(AFindText,"g"),ARepText);
	 
} 

function remove(){
	var test = document.getElementById("biaotouTable");
	var children = test.childNodes;
	for(i=0;i<children.length;i++){
		test.removeChild(children[i]);
	}
}
