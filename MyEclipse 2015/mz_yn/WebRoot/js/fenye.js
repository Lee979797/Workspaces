var endNum = 0; //����ҳ��
var startNum = 1; //��ʼҳ��
var intPageCount; //��ҳ��
var intPage = 1;//��ǰ�ڼ�ҳ
var listContent;
//��ҳ��ʾ����
function listData(list){
		
	
	intPageCount = list.length;
	startNum = 1;
	endNum = intPageCount;
	
	//================�����ʾ����====================
	document.getElementById("content").innerHTML = list[parseInt(intPage)-1];
	
	//================end=====================
	
	//=============��ʾ��ҳ����===============
	var fenye = "<div id=\"tnt_pagination\">";
	
	if(parseInt(intPage)>1){
			fenye += "<a href=\"javascript:void(0);\"  onclick=\"javascript:up();\">��һҳ</a>";
			if(document.getElementById("summary")){
			document.getElementById("summary").style.display="none";
			}
		}else{
				fenye += "<span class=\"disabled_tnt_pagination\">��һҳ</span>";
				if(document.getElementById("summary")){
				document.getElementById("summary").style.display="block";
				}
		}
	for(var i = startNum;i<= endNum;i++){
			
			if((intPage) != i){
					fenye += "<a href=\"javascript:void(0);\" onclick=\"javascript:go("+i+");\">"+i+"</a>";
				}else{
						fenye += "<span class=\"active_tnt_link\">"+i+"</span>";
					}
		}
	
	if(parseInt(intPage)<parseInt(intPageCount)){
			fenye += "<a href=\"javascript:void(0);\" onclick=\"javascript:down();\"><font size=\"2\">��һҳ</font></a>";
		}else{
				fenye += "<span class=\"disabled_tnt_pagination\">��һҳ</span>";
			}
	fenye += "</div>";
	
	document.getElementById("fenye").innerHTML = fenye;
	for(var i=0;i<document.getElementById("content").getElementsByTagName("img").length;i++){
		var tempImg=document.getElementById("content").getElementsByTagName("img")[i].src.toString();
		var tempStr=i+"fuck"+tempImg;
		try{
		setTimeout("loadImg("+i+")",500);

		}catch (e){
		 alert(e);
		}
//alert(fuck);
	};
	
	//==================end====================
	
		
}
function loadImg(index){
	document.getElementById("content").getElementsByTagName("img")[index].src=document.getElementById("content").getElementsByTagName("img")[index].src+"?r="+Math.random();
 }
function up(){
	intPage = parseInt(intPage)-1;
	try{
		listData(listContent);
		goto_top();
	}catch(e){
		alert(e);	
	}	
}
function down(){
	intPage = parseInt(intPage)+1;
	try{
		listData(listContent);
		goto_top();
	}catch(e){
		alert(e);	
	}
}
function go(page){
	
	intPage = parseInt(page);
	try{
		listData(listContent);
		goto_top();
	}catch(e){
		alert(e);	
	}
}

var goto_top_type = -1; 
var goto_top_itv = 0; 

function goto_top_timer() 
{ 
var y = goto_top_type == 1 ? document.documentElement.scrollTop : document.body.scrollTop; 
var moveby = 15; 

y -= Math.ceil(y * moveby / 100); 
if (y < 0) { 
y = 0; 
} 

if (goto_top_type == 1) { 
document.documentElement.scrollTop = y; 
} 
else { 
document.body.scrollTop = y; 
} 

if (y == 0) { 
clearInterval(goto_top_itv); 
goto_top_itv = 0; 
} 
} 

function goto_top() 
{ 
if (goto_top_itv == 0) { 
if (document.documentElement && document.documentElement.scrollTop) { 
goto_top_type = 1; 
} 
else if (document.body && document.body.scrollTop) { 
goto_top_type = 2; 
} 
else { 
goto_top_type = 0; 
} 

if (goto_top_type > 0) { 
goto_top_itv = setInterval('goto_top_timer()', 10); 
} 
} 
} 
