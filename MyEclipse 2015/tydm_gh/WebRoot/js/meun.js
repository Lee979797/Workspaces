
var selectedItem = null;

var targetWin;

document.onclick = handleClick;
document.onmouseover = handleOver;
document.onmouseout = handleOut;
document.onmousedown = handleDown;
document.onmouseup = handleUp;

document.write(writeSubPadding(10));  

function handleClick(srcObj) {

        if(srcObj==null) el = getReal(window.event.srcElement, "tagName", "DIV");
	else el = getReal(srcObj , "tagName", "DIV");

	if ((el.className == "topFolder") || (el.className == "subFolder")) {
		el.sub = eval(el.id + "Sub");
		if (el.sub.style.display == null) el.sub.style.display = "none";
	 
		if (el.sub.style.display != "block") { 
			
			//第一次打开菜单;
			if (el.className=="topFolder")
			{
				el.getElementsByTagName("IMG")[0].src="images/ico_88.gif";
			}
			if(el.className=="subFolder"){
				el.getElementsByTagName("IMG")[0].src="images/ico_92.gif";
			}
			//alert(el.parentElement.openedSub);
 
			if (el.parentElement.openedSub != null) {
				//alert(el.parentElement.openedSub);
				
				var opener = eval(el.parentElement.openedSub + ".opener");
				//隐藏其他兄弟菜单
				hide(el.parentElement.openedSub);
				if (opener.className == "topFolder")
					outTopItem(opener);
			}
			el.sub.style.display = "block";
			el.sub.parentElement.openedSub = el.sub.id;
			el.sub.opener = el;
		}
		else {			
			if (el.sub.openedSub != null) hide(el.sub.openedSub);
			else hide(el.sub.id);
		}
	}

	if ((el.className == "subItem") || (el.className == "subFolder")) {
		if (selectedItem != null)
			restoreSubItem(selectedItem);
		highlightSubItem(el);
	}
	
	if ((el.className == "topItem") || (el.className == "topFolder")) {
		
		if (selectedItem != null){
			restoreSubItem(selectedItem);
		}
	}

	if ((el.className == "topItem") || (el.className == "subItem")) {
		if ((el.href != null) && (el.href != "")) {
			if ((el.target == null) || (el.target == "")) {
				if (window.opener == null) {
					if (document.all.tags("BASE").item(0) != null)
						//window.open(el.href, document.all.tags("BASE").item(0).target);
						openWin((el.innerText).replace("·",""),el.href);
					else 
						//window.location = el.href;					// HERE IS THE LOADING!!!
						openWin((el.innerText).replace("·",""),el.href);
				}
				else {
					//window.opener.location =  el.href;
					openWin((el.innerText).replace("·",""),el.href);
				}
			}
			else {
				//window.open(el.href, el.target);
				openWin((el.innerText).replace("·",""),el.href);
			}
		}
	}
	
	var tmp  = getReal(el, "className", "favMenu");
	if (tmp.className == "favMenu") fixScroll(tmp);

}

function handleOver() {

	var fromEl = getReal(window.event.fromElement, "tagName", "DIV");
	var toEl = getReal(window.event.toElement, "tagName", "DIV");
	if (fromEl == toEl) return;
	
	el = toEl;
	
	if ((el.className == "topFolder") || (el.className == "topItem")) overTopItem(el);
	if ((el.className == "subFolder") || (el.className == "subItem")) overSubItem(el);
	
	if ((el.className == "topItem") || (el.className == "subItem")) {
		if (el.href != null) {
			if (el.oldtitle == null) el.oldtitle = el.title;
			if (el.oldtitle != "")
				el.title = el.oldtitle; //+ "\n" + el.href;
			else
				el.title = el.oldtitle;// + el.href;
		}
	}
	
	if (el.className == "scrollButton") overscrollButton(el);
}

function handleOut() {
	var fromEl = getReal(window.event.fromElement, "tagName", "DIV");
	var toEl = getReal(window.event.toElement, "tagName", "DIV");
	if (fromEl == toEl) return;
	
	el = fromEl;

	if ((el.className == "topFolder") || (el.className == "topItem")) outTopItem(el);
	if ((el.className == "subFolder") || (el.className == "subItem")) outSubItem(el);
	if (el.className == "scrollButton") outscrollButton(el);
}

function handleDown() {
	el = getReal(window.event.srcElement, "tagName", "DIV");
		
	if (el.className == "scrollButton") {
		downscrollButton(el);
		var mark = Math.max(el.id.indexOf("Up"), el.id.indexOf("Down"));
		var type = el.id.substr(mark);
		var menuID = el.id.substring(0,mark);
		eval("scroll" + type + "(" + menuID + ")");
	}
}

function handleUp() {
	el = getReal(window.event.srcElement, "tagName", "DIV");
		
	if (el.className == "scrollButton") {
		upscrollButton(el);
		window.clearTimeout(scrolltimer);
	}
}

function hide(elID) {
	var el = eval(elID);
	el.style.display = "none";

	var tmpid=el.id.toString();
	tmpid=tmpid.substr(tmpid,tmpid.length-3);

	if(eval(tmpid).className=="topFolder"){
		eval(tmpid).getElementsByTagName("IMG")[0].src="images/ico_90.gif";
	}
	if(eval(tmpid).className=="subFolder"){
		eval(tmpid).getElementsByTagName("IMG")[0].src="images/ico_89.gif";
	}
	el.parentElement.openedSub = null;
	if (el.openedSub != null) hide(el.openedSub);
}

function writeSubPadding(depth) {
	var str, str2, val;

	var str = "<style type='text/css'>\n";
	
	for (var i=0; i < depth; i++) {
		str2 = "";
		val  = 0;
		for (var j=0; j < i; j++) {
			str2 += ".sub "
			val += 22;
		}
		str += str2 + ".subFolder {padding-left: " + val + "px;}\n";
		str += str2 + ".subItem   {padding-left: " + val + "px;}\n";
	}
	
	str += "</style>\n";
	return str;
}

function overTopItem(el) {
	with (el.style) {
		background   = "#EFF5FF";
		color		 = "#FBAA32";
		//borderLeft   = "1px solid buttonhighlight";
		//borderRight  = "1px solid buttonshadow";
		//borderTop    = "1px solid buttonhighlight";
		//borderBottom = "1px solid buttonshadow";
		//paddingBottom = "2px";
	}
}

function outTopItem(el) {
	if ((el.sub != null) && (el.parentElement.openedSub == el.sub.id)) { //opened
		with(el.style) {
			color		 = "#000000";
			//borderTop = "1px solid buttonshadow";
			//borderLeft  = "1px solid buttonshadow";
			//borderRight    = "1px solid buttonhighlight";
			//borderBottom = "0px";
			//paddingBottom = "3px";
			background = "#EFF5FF";
		}
	}
	else {
		with (el.style) {
			//border = "1px solid #EFF5FF";
			color="#000000";
			background = "#EFF5FF";
			//padding = "2px";
		}
	}
}

function overSubItem(el) {
	//el.style.textDecoration = "underline";
	el.style.color = "#79A7E2";
}

function outSubItem(el) {
	//el.style.textDecoration = "none";
	el.style.color = "#000000";
}

function highlightSubItem(el) {
	//el.style.background = "buttonshadow";//菜单选中时背景色
	//el.style.color      = "white"; //"highlighttext";//鼠标点击时颜色
	selectedItem = el;
}

function restoreSubItem(el) {
	el.style.background = "#EFF5FF";
	el.style.color      = "#000000";//"menutext";
	selectedItem = null;
}


function getReal(el, type, value) {
	temp = el;
	while ((temp != null) && (temp.tagName != "BODY")) {
		if (eval("temp." + type) == value) {
			el = temp;
			return el;
		}
		temp = temp.parentElement;
	}
	return el;
}

var scrolltimer;
var scrollAmount = 20;

function scrollDown(el) {
	if (el.offsetHeight > el.parentElement.offsetHeight) {
		var mt = parseInt(el.style.marginTop);
		mt -= scrollAmount;
		if (mt >= el.parentElement.offsetHeight - el.offsetHeight - 2) {
			el.style.marginTop = mt;
			scrolltimer = window.setTimeout("scrollDown(" + el.id + ")",100);
		}
		else {
			el.style.marginTop = el.parentElement.offsetHeight - el.offsetHeight - 2;
		}
	}
	fixScroll(el)
}

function scrollUp(el) {
	var mt = parseInt(el.style.marginTop);
	mt += scrollAmount;
	if (mt >= 0) {
		el.style.marginTop = 0;
	}
	else {
		el.style.marginTop = mt;
		scrolltimer = window.setTimeout("scrollUp(" + el.id + ")",100);
	}
	fixScroll(el);
}

function fixScroll(el) {
	//return false;
	if (el.style.marginTop == "") el.style.margin = "0px";
	mt = parseInt(el.style.marginTop);
	var downButton = eval(el.id + "Down");
	var upButton   = eval(el.id + "Up");

	upButton.style.left = leftPos(el.parentElement.parentElement) + 2;	// for outer
	upButton.style.top = topPos(el.parentElement.parentElement) + 2;
	upButton.style.width = el.parentElement.offsetWidth - 2;
	downButton.style.left = leftPos(el.parentElement.parentElement) + 2;
	downButton.style.top = topPos(el.parentElement.parentElement) + el.parentElement.offsetHeight - 16;
	downButton.style.width = el.parentElement.offsetWidth - 2;

	upButton.style.display   = (mt < 0) ? "block" : "none";
	downButton.style.display = ((mt == el.parentElement.offsetHeight - el.offsetHeight - 2)
		 || (el.offsetHeight <= el.parentElement.offsetHeight)) ? "none" : "inline";
		 
	if (el.offsetHeight < el.parentElement.offsetHeight) {
		el.style.marginTop = 0;
		upButton.style.display = "none";
	}
}

function topPos(el) {
	return doPosLoop(el, "Top");
}

function leftPos(el) {
	return doPosLoop(el, "Left");
}

function doPosLoop(el, val) {
	var temp = el;
	var x = eval("temp.offset" + val);
	while ((temp.tagName!="BODY") && (temp.offsetParent.style.position != "absolute")) {
//	while (temp.tagName!="BODY") {
		temp = temp.offsetParent;
		x += eval("temp.offset" + val);
	}
	return x;
}

function operateInfo(){
   if (idInfo.style.display=="")
   {
		idInfo.style.display="none";
		idInfoImg.src="images/ico_90.gif";
   }
   else{
		idInfo.style.display="";
		idInfoImg.src="images/ico_88.gif";
   }
}

function onmouseInfo(obj,flag){

	var tmpInfo = window.event.srcElement;
	switch (flag) {
		case 0 :
			tmpInfo.style.color="#000000";
			break;
		case 1 :
			tmpInfo.style.color="#6593BE";
			break;
	} 
}
//浮动窗口
var nbottom=0,speed=10;
var shortLeft=0;
function onmouseShort(obj,flag){
	//funarrWin();
	//return false;
	shortLeft=obj.offsetParent.offsetLeft;
	var tmpShort = window.event.srcElement;
	if(tmpShort.tagName=="IMG"){

		var objID=event.srcElement.id;
		tmpShort.style.cursor="hand";
		var index=objID.indexOf("_");
		var mainID=objID.substring(0,index);
		var numID=objID.substring(index+1,objID.length);

		//if (numID=="0")
		//{
		//	return false;
		//}

		switch (flag) {
			case 0 :	
				if (numID>"7") return false;				
				for(var jj=0;jj<=7;jj++)
				{
					//eval("document.all.Shortm_"+jj+".src='images/ShortImg_"+jj+"_0.gif'");
					document.getElementById("Shortm_"+jj).src = "images/ShortImg_"+jj+"_0.gif";

					//tmpShort.src="images/ShortImg_"+jj+"_0.gif";
					nbottom=0;
					eval("Shortms_"+jj+".style.display='none'");
					
				}
				tmpShort.src="images/ShortImg_"+numID+"_1.gif";
				eval("showShort("+"Shortms_"+numID+","+numID+")");	
				break;
			case 1 :
				//tmpShort.src="images/ShortImg_"+numID+"_0.gif";
				//if (numID=="7") return false;
				//eval("hideShort("+"Shortms_"+numID+")");				
				break;
		} 
	}
}
function closeShortMenu()
{
	for(var jj=1;jj<=7;jj++)
	{
		eval("Shortm_"+jj+".src='images/ShortImg_"+jj+"_0.gif'");
		nbottom=0;
		eval("Shortms_"+jj+".style.display='none'");
	}
}
function displayShort(obj)
{
obj.style.clip="rect(0 100% "+nbottom+"% 0)";
nbottom+=speed;
if(nbottom<=100) 
{
timerID=setTimeout("displayShort("+obj.id+"),70");
}
else clearTimeout(timerID);
}
function showShort(obj,vNum)
{
	getFocus(obj);
	obj.style.display="block";
	obj.style.clip="rect(0 0 0 0)";
	vNum=vNum-1;
	
	var vNum2=0;
	
	var objLeft=shortLeft+(vNum*72)-vNum2;
	var bodyWidth=document.body.offsetWidth;
	
	if(bodyWidth<(objLeft+obj.offsetWidth))
	obj.style.left=objLeft-((objLeft+obj.offsetWidth)-bodyWidth)-20;
	else
	obj.style.left=objLeft;

	nbottom=5;
	displayShort(obj);
}
function hideShort(obj)
{
	nbottom=0;
	obj.style.display="none";
}
function keepShort(obj)
{

	obj.style.display="block";
}

//窗口排序
function funarrWin(){
	return false;
	//var vl=alert.length;
//for(i=0;i<arrWin.length;i++){
//	alert(arrWin[i]);
//}
//var ss=arrWin.sort();
//for(i=0;i<ss.length;i++){
//	alert(ss[i]);
//}
}
//隐藏菜单

function hiddenLeft()
{
	var left=document.getElementById("menu");
	var tmpl=10;
	if(left.style.display=="none"){
		left.style.display="block";
		tmpl=200;
	}
	else{
		left.style.display="none";
		tmpl=10;
	}
	leftmargin=tmpl;

	layoutZ();
	layoutI();
	
}