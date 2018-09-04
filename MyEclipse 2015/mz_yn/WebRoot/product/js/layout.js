<!--
var x0=0,y0=0,x1=0,y1=0,w0=0,h0=0,w1=0,h1=0;
var offx=6,offy=6,offw=6,offh=6;
var moveable=false,sizeable=false;
var hover='orange',normal='#EFF5FF',normalBorder='#79A7E2';//color;'#336699'
var index=10000;//z-index;

//开始拖动;
function startDrag(obj)
{
  if(event.button==1)
  {
    //锁定标题栏;
    obj.setCapture();
    //定义对象;
    var win = obj.parentNode;
    var sha = eval("bg"+win.id);//win.nextSibling;
    //记录鼠标和层位置;
    x0 = event.clientX;
    y0 = event.clientY;
    x1 = parseInt(win.style.left);
    y1 = parseInt(win.style.top);
    //记录颜色;
    normal = obj.style.backgroundColor;
    //改变风格;
    obj.style.backgroundColor = '#FFEED3';//hover; 
    win.style.borderColor = hover;
    moveable = true;
  }
}
//拖动;
function drag(obj)
{
  if(moveable)
  {
    var win = obj.parentNode;
	change(win,y1 + event.clientY - y0,x1 + event.clientX - x0,0,0);
  }
}
//停止拖动;
function stopDrag(obj)
{
  if(moveable)
  {
    var win = obj.parentNode;
    var sha = eval("bg"+win.id);//win.nextSibling;

    var msg = obj.nextSibling;
    win.style.borderColor     = "#79A7E2";//normal;
    obj.style.backgroundColor = normal;
    msg.style.color           = "#000000"//normal;

	obj.releaseCapture();
	layout(obj);
    moveable = false;
  }
}
//获得焦点;
function getFocus(obj)
{
  if(obj.style.zIndex!=index)
  {
    index = index + 2;
    var idx = index;
    obj.style.zIndex=idx;

    obj.nextSibling.style.zIndex=idx-1;
  }
  setCurrentd(obj.id);
}
//最小化;
function min(obj)
{
  var win = obj.parentNode.parentNode;
  var sha = win.nextSibling;
  var tit = obj.parentNode;
  var msg = tit.nextSibling;
  var flg = msg.style.display=="none";
  if(flg)
  {
    win.style.height  = parseInt(msg.style.height) + parseInt(tit.style.height) + 2*2;
    sha.style.height  = win.style.height;
    msg.style.display = "block";
    obj.innerHTML = "0";
  }
  else
  {
    win.style.height  = parseInt(tit.style.height) + 2*2;
    sha.style.height  = win.style.height;
    obj.innerHTML = "2";
    msg.style.display = "none";
  }
}
//创建一个对象;
var arrWin = new Array();
var couWin=-1;
function xWin(id,w,h,l,t,area,ioc,tit,des,msg)
{
  index = index+2;
  this.id      = id;
  this.width   = w;
  this.height  = h;
  this.left    = l;
  this.top     = t;
  this.zIndex  = index;
  this.title   = tit;
  this.desc	   =des;
  this.message = msg;
  this.obj     = null;
  this.bulid   = bulid;
  this.ioc	   =ioc;
  this.area    =area;
  this.bulid(area);
}
//初始化;
function bulid(area)
{
  var str = ""
    + "<div id=xMsg" + this.id + " "//窗口
	+ "area=" + this.area + " "
    + "style='"
    + "z-index:" + this.zIndex + ";"
    + "width:" + this.width + ";"
    + "height:" + this.height + ";"
    + "left:" + this.left + ";"
    + "top:" + this.top + ";"
    + "background-color: " + normal + ";"//+ normal + ";"
    + "color:" + normal + ";"
    + "font-size:8pt;"
    + "font-family:Tahoma;"
    + "position:absolute;"
    + "cursor:default;"
    + "border:1px solid " + normalBorder + ";"
    + "' "
    + "onmousedown='getFocus(this)' "
	+">"
		+ "<input type=hidden id=xhidxMsg" + this.id + " name=area value='" + area + "'> "//隐藏框
		+ "<div "//标题栏
		+ "title=" +this.desc + " "
		+ "id=idtitlexMsg" + this.id + " "
		+ "style='"
		+ "background-color:" + normal + ";"
		+ "color:black;"
		+ "width:" + (this.width-2*1) + ";"
		+ "height:20;"
		+ "cursor:move;"
		+ "' "
		+ "onmousedown='startDrag(this)' "
		+ "onmouseup='stopDrag(this)' "
		+ "onmousemove='drag(this)' "
		+ ">"
		+ "<span "//标题
			+"id=idspanxMsg" + this.id + " "
			+"style='width:" + (this.width-2*12-40) +" ;"
			+"font-weight:bold;"
			+"font-size:14;"
			+"padding-left:3px;"
			+"'>"
				+"<img "//图片
				+"src='" + this.ioc + "' "
				+"width='16' "
				+"height='16' "
				+"vspace='4' "
				+"align='absmiddle' "
				+"/>" 
				+ this.title
			+ "</span>"
			+ "<span style='width:12;border-width:0px;cursor:pointer;' onclick=\"reFresh(this,'"+this.id+"')\" title='刷新'>"
				+"<img "
				+"src='images/ico_19.gif' "
				+"width='16' "
				+"height='16' "
				+"align='absmiddle' "
				+"/>" 
			+"</span>"//刷新
			+ "<span style='width:12;border-width:0px;cursor:pointer;' onclick=\"reMore(this,'"+this.id+"')\" title='更多'>"
				+"<img "
				+"src='images/ico_89.gif' "
				+"width='16' "
				+"height='16' "
				+"align='absmiddle' "
				+"/>" 
			+"</span>"//更多
	+ "</div>"
	+ "<div "//内容
	+ "id=idconxMsg" + this.id + " "
	+ "style='"
	+ "width:100%;"
	+ "height:" + (this.height-20) + ";"
	+ "background-color:White;"
	//+ "background-color:red;"
	+ "color:black;"	
	+ "line-height:14px;"
	+ "word-break:break-all;"
	+ "padding:3px;"
	+ " PADDING-TOP: 15px;"
	//+ " padding-bottom: 15px;"	
	+ " overflow:hidden;"
	+ "'>" + this.message + "</div>"
    + "</div>"
    + "<div id=bgxMsg" + this.id + " style='"//窗口的背景
    + "width:" + (this.width+6) +";"
    + "height:" + (this.height+12) + ";"
    + "top:" + (this.top-3) + ";"
    + "left:" + (this.left-3) + ";"
    + "z-index:" + (this.zIndex-1) + ";"
    + "position:absolute;"
    + "background-color:#eeeeee;"
    + "'>"
	+ "</div>";

	document.body.insertAdjacentHTML("beforeEnd",str);
	
	couWin=couWin+1;

	arrWin[couWin] = "xMsg"+this.id;
}

function change(obj,top,left,width,height){
	var sha = eval("bg"+obj.id);//obj.nextSibling;
	if (width!=0){
		obj.style.width=width;
		sha.style.width=width+6;

		var tmptitle=eval("idtitle"+obj.id);
		tmptitle.style.width=width-2*1;
		var tmptitlespan=eval("idspan"+obj.id);

		tmptitlespan.style.width=width-2*12-10;
		var tmpcon=eval("idcon"+obj.id);
		tmpcon.style.width=width-2*1;
	}
	if(height!=0){
		obj.style.height=height;
		sha.style.height=height+6;

		var tmpcon=eval("idcon"+obj.id);
		tmpcon.style.height=height-20;
	}
	if(top!=0){
		obj.style.top=top;
		sha.style.top=top-3;	
	}
	if(left!=0){
		obj.style.left=left;
		sha.style.left=left-3;			
	}
	if (width!=0)
	{

		//改变信息宽度
		var tpmCou=parseInt((width-15)/fontWith)+1;
		//alert(tpmCou);
		var tmpA = obj.getElementsByTagName("A");
		var strttmpAs="";

		for (var i=0;i<tmpA.length;i++)
		{
			strttmpAs=tmpA[i].title;
			if (strttmpAs!="")
			{
				//alert(tpmCou);
				tmpA[i].innerText=strttmpAs.substr(0,tpmCou);
			}
			
	}
	}
}

//显示隐藏窗口
function ShowHide(dis){

	for (var i = 2; i < arrWin.length; i++)
	{
		if (dis==1)
		{
			document.getElementById(arrWin[i]).style.display = "none";
			document.getElementById("bg"+arrWin[i]).style.display = "none";
			zWin.style.display = "";
			bgzWin.style.display = "";			
		}
		else{

			document.getElementById(arrWin[i]).style.display = "";
			document.getElementById("bg"+arrWin[i]).style.display = "";
			zWin.style.display = "none";
			bgzWin.style.display = "none";
		}
	}
}

//刷新窗口
function reFresh(obj,vid){
	var xobj=eval("idconxMsg" + vid);
	getIndexInfos(vid,parseInt(xobj.style.width));
}
//更多
function reMore(obj,vid){
	//var xobj=eval("idconxMsg" + vid);
	getMoreInfos(vid);
}
//打开窗口
var arrNWin = new Array();
//var delayWinHandle=null;
var Loading="<marquee align=middle direction=right scrolldelay=1  scrollamount=2 bgcolor=#dcdcdc style=' COLOR: #c0ff00; WIDTH: 133px;HEIGHT: 5px;font-size:5;' behavior=slide>███████████████████████████████████████████████████████████████████████████████</marquee>"
function openWin(title,url){
	
	try
	{
        doHelpOut(null);  
    }catch(e){}

 document.getElementById("idtitlezWin").style.display = "";

 WinTitle.innerHTML=title;
 //loadWin(url);
 
  getFocus(zWin);
  
  iframeWin.window.location.href=url;
  perF.innerHTML=Loading;

  var tmpwl=arrNWin.length;
  
  arrNWin[tmpwl]=new Array();  
  arrNWin[tmpwl][0]=title;
  arrNWin[tmpwl][1]=url;
  ShowHide(1);

}
//loading窗口
function loadWin(vurl){
iframeWin.document.write("<SCRIPT>top.perF.style.display='';var myTime=0;function counter(){myTime++;if(myTime<100)setTimeout('counter()',40);else{location.href='"+vurl+"'}}counter();</SCRIPT>")
}
//延迟打开窗口
function delayWin()
{
 // ShowHide(1);
 // if(delayWinHandle!=null)  window.clearInterval(delayWinHandle)

}
//关闭窗口
function closeWin()
{
	//if(delayWinHandle!=null) window.clearInterval(delayWinHandle)
	if(iframeWin.closeWin!=null)
		iframeWin.closeWin()
	else
		ShowHide(0);
	iframeWin.window.location.href="about:blank";
  //zWin.style.display = "none";
  //bgzWin.style.display = "none";
}

//刷新窗口
function reloadWin(){
 iframeWin.window.location.reload();
}
//返回
function backWin(){
	//alert(iframeWin.window.location);
	//return false;
	if(iframeWin.backWin!=null)
		iframeWin.backWin()
	else
		iframeWin.history.go(-1);

	
/*	
	 var tmpurl=iframeWin.window.location.href;
	 var tmpi=0;
	 var tmpTitle="";
	 var tmpUrl="";
	 for(var i=1;i<arrNWin.length;i++){

		var tmpl=tmpurl.indexOf(arrNWin[i][1]);

		if (tmpl>0)
		{
			tmpi=i-1;
			tmpUrl=arrNWin[tmpi][1];
			tmpTitle=arrNWin[tmpi][0];
			iframeWin.window.location.href=tmpUrl;
			WinTitle.innerHTML=tmpTitle;
		}
	 }
	 */
}
//返回
//前进
function goWin(){
	history.forward();	
}
//前进
//演示动画 
function demoWin(){
	var strHref=iframeWin.window.location.pathname;

	if(strHref.toLowerCase().indexOf("approve_begin.asp")>0)
	{	
		strHref = iframeWin.window.location.search;

	    if(strHref.lastIndexOf("IOA_DefineModule")>0) strHref="module/module.JPG"
		if(strHref.toLowerCase().indexOf("ioa_accept")>0) strHref="accept/accept.swf"
		if(strHref.toLowerCase().indexOf("ioa_send")>0) {strHref="senddocument/senddocument.swf";}
		if(strHref.toLowerCase().indexOf("ioa_ask")>0) strHref="ask/ask.swf"
		if(strHref.toLowerCase().indexOf("ioa_news")>0) strHref="news/news.swf"
		if(strHref.toLowerCase().indexOf("ioa_message")>0) strHref="message/message.swf"
		if(strHref.toLowerCase().indexOf("ioa_meet")>0) strHref="meet/meet.swf"
		if(strHref.toLowerCase().indexOf("ioa_know")>0) strHref="know/know.swf"
		if(strHref.toLowerCase().indexOf("ioa_magazine")>0) strHref="magazine/magazine.swf"
		if(strHref.toLowerCase().indexOf("ioa_vehicle")>0) strHref="vehicle/vehicle.swf"
		if(strHref.toLowerCase().indexOf("ioa_vehicleprivate")>0) strHref="vehicle/vehicle.swf"
		if(strHref.toLowerCase().indexOf("ioa_officesupply")>0) strHref="officesupply/officesupply.swf"
		if(strHref.toLowerCase().indexOf("ioa_month")>0) strHref="month/month.swf"
		if(strHref.toLowerCase().indexOf("ioa_borrow")>0) strHref="archives/archives.swf"
		if(strHref.toLowerCase().indexOf("ioa_bookborrow")>0) strHref="book/book.swf"
		if(strHref.toLowerCase().indexOf("ioa_criterate")>0) strHref="Criteration/Criteration.swf"
		if(strHref.toLowerCase().indexOf("ihrm_dossierregularworker")>0) strHref="ihrm/dossier/dossier.swf"
		if(strHref.toLowerCase().indexOf("ihrm_dossierleavework")>0) strHref="ihrm/dossier/dossier.swf"
		if(strHref.toLowerCase().indexOf("ihrm_dossiermove")>0) strHref="ihrm/dossier/dossier.swf"
		if(strHref.toLowerCase().indexOf("ihrm_attendanceoff")>0) strHref="ihrm/attendance40/attendance40.swf"
		if(strHref.toLowerCase().indexOf("ihrm_attendanceleave")>0) strHref="ihrm/attendance40/attendance40.swf"
		if(strHref.toLowerCase().indexOf("ihrm_attendanceovertime")>0) strHref="ihrm/attendance40/attendance40.swf"
		if(strHref.toLowerCase().indexOf("ihrm_attendanceevecion")>0) strHref="ihrm/attendance40/attendance40.swf"	
     	
	}
	else
	{
		var intSPos = strHref.lastIndexOf("/");
		var intEPos = strHref.lastIndexOf("/",intSPos-1); 
		var strWhere = strHref.substring(intEPos+1,intSPos);
		if (strWhere.toLowerCase()=="attendance40"||strWhere.toLowerCase()=="dossier"||strWhere.toLowerCase()=="station40")
		{
			strHref="ihrm/"+strWhere+"/"+strWhere+".swf";
		}
		else if(strHref.toLowerCase().indexOf("substitute_setsub.asp")>0)
		{
			strHref=strWhere+"/"+strWhere+"sub.swf";
		}
		else if(strHref.toLowerCase().indexOf("diary_manager1.asp")>0)
		{
			strHref=strWhere+"/"+strWhere+"sub.swf";
		}
		else
		{
			strHref=strWhere+"/"+strWhere+".swf";
		}
	}
	try {var xhttp = new ActiveXObject("Microsoft.XMLHTTP")}
	catch (e) { }

	try { 

		xhttp.open("get",strHref,false)
		xhttp.send();

		if (xhttp.status==200) 
		{			
			iframeWin.location = strHref;
		}
		else if(xhttp.status==404)
		{
			strHref = iframeWin.window.location.search;
			if( strHref != "" )
			{
			  strHref = iframeWin.window.location.href.replace(/\.asp\?/g,"/");
			  strHref = strHref+".swf";
			  try
			  {
				 xhttp.open("get",strHref,false)
				 xhttp.send();
				 if (xhttp.status==200) 
				 {
					 iframeWin.location = strHref;               
				 }
			  }
			  catch(e){}
			}        
		}
	}
	catch (e) {alert(true);}
}
//演示动画
//帮助 
function helpWin(){

 var strHref=iframeWin.window.location.pathname;

     //alert(strHref);

    // strHref=strHref+".htm";

    var pageUrl =  strHref;
    pageUrl = pageUrl.substr(pageUrl.lastIndexOf("/")+1); 

    var pageDir = strHref.replace(pageUrl,"");
    if(pageDir.substr(pageDir.length-1,1)=="/")
     {
	pageDir = pageDir.substr(0,pageDir.length-1);	
	pageDir = pageDir.substr(pageDir.lastIndexOf("/")+1);
     }
    
    strHref = "http://www.jh-club.com/service/api.php?f=ioas&action=help&pageDir=" + pageDir + "&pageUrl=" + pageUrl + "&defaultPage="+escape(WinTitle.innerText);
    //alert(pageDir);
    //alert(pageUrl);

try {
    var xhttp = new ActiveXObject("Microsoft.XMLHTTP")
    }
    catch (e) { }
//alert(strHref);
try { 
    xhttp.open("get",strHref,false)
    xhttp.send();
  
    if (xhttp.status==200) 
    {
       window.open(strHref,"_blank","");
    }
    else if(xhttp.status==404)
    {
        strHref = iframeWin.window.location.search;
        if( strHref != "" )
        {
          strHref = iframeWin.window.location.href.replace(/\.asp\?/g,"/");
          strHref = strHref+".htm";
          try
          {
             xhttp.open("get",strHref,false)
             xhttp.send();
             if (xhttp.status==200) 
             {
               window.open(strHref,"_blank","");
             }
          }
          catch(e){}
        }        
    }
 }
catch (e) {
	alert("此页面没有帮助。");
	}

// if(strHref.indexOf(".htm.htm")==-1)
}
//帮助
//提示框
function alertWin(vAlert){
	window.status =vAlert;
}
var currentdid		//拖动的窗口
var currentdtop		//拖动的窗口的top
var currentdleft	//拖动的窗口的left
var currentdheight	//拖动的窗口的height
/*
var topmargin=80	//窗口上边距
var leftmargin=200	//窗口左边距
var hspace=10		//窗口间距
var areaAWith=200	//第一列窗口宽度
var areaBWith=0		//第二列窗口宽度
var areaCWith=200	//第三列窗口宽度
*/
var areaALeft=0				//第一列窗口left
var areaBLeft=0		//第二列窗口left
var areaCLeft=0		//第三列窗口left

//设置被选择的窗口
function setCurrentd(objid){
	currentdid=objid;
	currentdarea=eval(currentdid).area;
	currentdtop=parseInt(eval(currentdid).style.top);
	currentdleft=parseInt(eval(currentdid).style.left);
	currentdheight=parseInt(eval(currentdid).style.height);
}

//重新布局列
function layout(obj){

	var objid=obj.id;	

	if (moveable==true){
		var tmpx=event.clientX;
		var tmpy=event.clientY;
	
		//第一列X区域
		var tmpaxB=leftmargin;
		var tmpaxE=tmpaxB+areaAWith+hspace;
		//第二列X区域
		var tmpbxB=tmpaxE;
		var tmpbxE=tmpbxB+areaBWith+hspace;
		//第三列X区域
		var tmpcxB=tmpbxE;
		var tmpcxE=tmpcxB+areaCWith+hspace;
		
		var tmparea="";
		if (tmpx<tmpaxE){
			tmparea="areaA";
		}
		if ((tmpx>=tmpaxE)&&(tmpx<tmpbxE)){
			tmparea="areaB";
		}
		if (tmpx>=tmpbxE){
			tmparea="areaC";
		}
		
if((tmparea==currentdarea)&&(tmpy<(parseInt(currentdtop)+parseInt(currentdheight)))){
		layoutR(currentdarea);
		return false
}
		
		layoutT(tmparea,tmpy);
		layoutR(tmparea);
		layoutR(currentdarea);
		layoutRM();
		//layoutRC();
		layoutSD();
	}
}

//重新布局移入的区域
function layoutT(area,y){

	var win=eval(currentdid);
	var tmpw=eval("xhid" + win.id)

	win.area=area;
	tmpw.value=area;

	//重新排序
	layoutS(area,y);	

} 
//重新设置图片
function layoutRM(){
	
	for(var i=1;i<=MaxImg;i++){
		
		if(eval("ni"+i)!=null){
			var tmpO=eval("ni"+i+".parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode");
			
			if (tmpO.area=="areaB")
			{
				eval("ni"+i).style.zoom="1";
			}
			else
			{
				eval("ni"+i).style.zoom="0.7";
		}
		}
	}
}
//重新设置日历
function layoutRC(){
	return false;
	var tmpO=Cal_Title.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;

	switch (tmpO.area) {
	   case "areaA":
			tmpW=areaAWith;
			break;
	   case "areaB":
			tmpW=areaBWith;
			break;
	   case "areaC":
			tmpW=areaCWith;
			break;
	} 
	Cal_Title.style.width=Cal_Week.style.width=Cal_Top.style.width=Cal_Day.style.width=tmpW-2;
}

//重新布局指定区域
function layoutR(area){
	//1var allDiv = document.getElementsByName("area");
	var tmpL=0,tmpW=0;
	var tmpT1=0,tmpT2=0,tmpT3=0;
	//1var tmpi=allDiv.length;
	var tmpi=arrWin.length;
	var win;
	var tmpH=topmargin+vspace;

	switch (area) {
	   case "areaA":
			tmpL=areaALeft;
			tmpW=areaAWith;
			break;
	   case "areaB":
			tmpL=areaBLeft;
			tmpW=areaBWith;
			break;
	   case "areaC":
			tmpL=areaCLeft;
			tmpW=areaCWith;
			break;
	} 
	
	for(i=0;i<tmpi;i++){
		//1tmpO=allDiv[i];
		tmpO=eval("xhid"+arrWin[i]);
		tmpv=tmpO.value;
		//tmpWinS
		if (tmpv==area){
			//1win = allDiv[i].parentNode;
			win = tmpO.parentNode;
			//alert(win.tabIndex);
			change(win,tmpH,tmpL,tmpW,0);
			tmpH=tmpH+parseInt(win.style.height)+vspace;
		}
	}
}
//重新布局所有窗口
function layoutI(){
	
	areaALeft=leftmargin+hspace;
	areaBLeft=areaALeft+areaAWith+hspace;
	areaCLeft=(document.body.clientWidth)-areaCWith-hspace;
	areaBWith=areaCLeft-areaBLeft-hspace;
	
	
	var strWinInfos=personData.value;
	//alert(strWinInfos);
	if((strWinInfos!="")&&(strWinInfos!=null)&&(strWinInfos!="null")){
		var tmpArrInfo=strWinInfos.split("|");
		var strWinIDs=tmpArrInfo[0];
		var strWinAreas=tmpArrInfo[1];
		
		if((strWinIDs!="")&&(strWinAreas!="")){
			var arrWinID=strWinIDs.split(",");
			var arrWinArea=strWinAreas.split(",");
			
			for(var i=0;i<arrWinID.length;i++){
				arrWin[i]=arrWinID[i];
				eval(arrWinID[i]).area=arrWinArea[i];
				eval("xhid"+arrWinID[i]).value=arrWinArea[i];
			}
		}
	}

	layoutR("areaA");
	layoutR("areaB");
	layoutR("areaC");
}
//重新排序窗口
function layoutS(area,y){
	//return ;
var tmpc=eval(currentdid);

var tmpi=0,tmpt=0,tmph=0,tmpci=0,tmpti=0;
var flag=0;

if (y<=topmargin+vspace){
tmpti=0;//第一位
}
else{
flag=1;
var tmpi=arrWin.length;

	for(i=0;i<tmpi;i++){
	
		if(arrWin[i]==currentdid){
			tmpci=i;
		}	
		if ((eval(arrWin[i]).area==area)&&tmpci!=i){
			win=eval(arrWin[i]);
			tmpt=parseInt(win.style.top);
			tmph=parseInt(win.style.height);
			//alert(area + " " + eval(arrWin[i]).area + " " + arrWin[i] +" top:"+tmpt + " height:"+tmph);
			if ((y>tmpt)&&(y<=tmpt+tmph+hspace)){
				tmpti=i;//中间某位
				//alert(tmpti);
			}
		}
	}

}

tmpci=tmpci+1;
tmpti=tmpti+1;

var s="";
for (i=0;i<arrWin.length;i++){
	s=s+";" + arrWin[i]	
}
if (tmpci<tmpti)
{
	var tmp2=arrWin[tmpci-1];
	for(var i=tmpci-1;i<tmpti;i++)
	{
		arrWin[i]=arrWin[i+1];
		//document.writeln(aa[i]);
	}
	arrWin[tmpti-1]=tmp2;

}

if (tmpci>tmpti)
{
	var t=tmpci;
	tmpci=tmpti;
	tmpti=t;
	var tmp1=arrWin[tmpti-1];
	for(var i=tmpti-1;i>tmpci-1;i--)
	{
		arrWin[i]=arrWin[i-1];
	}
	arrWin[tmpci-1]=tmp1;

}
}

//重新布局操作窗口
function layoutZ(){

	var tmpzw=document.body.clientWidth-leftmargin-hspace-hspace;
	var tmpzh=document.body.clientHeight-topmargin-vspace-vspace;

	zWin.style.left=leftmargin+hspace;
	zWin.style.top=topmargin+vspace;
	zWin.style.width=tmpzw;
	zWin.style.height=tmpzh;
	idconzWin.style.height=tmpzh-20;

	bgzWin.style.left=leftmargin+hspace-3;
	bgzWin.style.top=topmargin+vspace-3;
	bgzWin.style.width=tmpzw+6;
	bgzWin.style.height=tmpzh+12;
	
	idtitlezWin.style.width=tmpzw-2*1;
	//修改人：李斌
	//修改时间：2009-4-29
	//修改内容：增加社区服务链接
	idspanzWin.style.width=tmpzw-2*12-78;
	//idspanzWin.style.width=tmpzw-2*12-138//98;

	idconzWin.style.width=tmpzw-2*1;
}
//重新保存信息
function layoutSD(){
	var strWinAreas="";
	var strWinIDs="";

	for (i=0;i<arrWin.length;i++){
		if(strWinIDs==""){
			strWinIDs=arrWin[i];
		}
		else{
			strWinIDs=strWinIDs+","+arrWin[i];
		}
		if(strWinAreas==""){
			strWinAreas=eval(arrWin[i]).area;
		}
		else{
			strWinAreas=strWinAreas+","+eval(arrWin[i]).area;
		}
	}	
	var strWinInfos=strWinIDs+"|"+strWinAreas;
	
	savePerDate(strWinInfos);

}

function loadPerDate(){
	personData.load("JHDataStore");
	personData.value=personData.getAttribute("arrWin");
	return personData.value;
}
function savePerDate(strWinInfos){
	personData.setAttribute("arrWin",strWinInfos);
	personData.save("JHDataStore");
}


function openWinFull(url)
{
try
	{
        doHelpOut(null);  
    }catch(e){}

  getFocus(zWin);
 
  iframeWin.window.location.href=url;

  var tmpwl=arrNWin.length;
 
  arrNWin[tmpwl]=new Array();  
  arrNWin[tmpwl][0] = "";
  arrNWin[tmpwl][1]=url;
  ShowHide(1);

  document.getElementById("idtitlezWin").style.display = "none";

}