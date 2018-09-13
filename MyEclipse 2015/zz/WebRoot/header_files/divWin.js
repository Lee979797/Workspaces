DivWin = function DivWin(){};
//若Client浏览器为NetsCape
DivWin.agt=navigator.userAgent.toLowerCase();
DivWin.ns  = ((DivWin.agt.indexOf('mozilla')!=-1) && (DivWin.agt.indexOf('spoofer')==-1)
            && (DivWin.agt.indexOf('compatible') == -1) && (DivWin.agt.indexOf('opera')==-1)
            && (DivWin.agt.indexOf('webtv')==-1) && (DivWin.agt.indexOf('hotjava')==-1));
DivWin.BROWSERNAME="";
DivWin.shadowDiv=null;
switch(navigator.appName.toLowerCase()){
	case "netscape":
		DivWin.BROWSERNAME="ns";
	break;
	case "microsoft internet explorer":
	default:
		DivWin.BROWSERNAME="ie";
	break;
}
//**设置全局定时器******
var topDivWin=null;
if(typeof(DivWinTimer)=="undefined"){
	var DivWinTimer={
		events:new Array(),
		objs:new Array(),
		handle:null,
		exec:function(){
			for(var i=0;i<DivWinTimer.events.length;i++){
				try{
					with(DivWinTimer.objs[i]){
						eval(DivWinTimer.events[i]);
					}
				}catch(e){}
			}
		},
		pop:function(i){
			DivWinTimer.events[i]=null;
			DivWinTimer.objs[i]=null;
		},
		push:function(strV,obj){
			for(var i=0;i<DivWinTimer.events.length;i++){
				if(DivWinTimer.events[i]==null){
					DivWinTimer.events[i]=strV;
					DivWinTimer.objs[i]=obj;
					return(i);
				}
			}
			DivWinTimer.events[i]=strV;
			DivWinTimer.objs[i]=obj;
			return(i);
		},
		start:function(){
			DivWinTimer.stop();
			DivWinTimer.handle=setInterval(DivWinTimer.exec,30);
		},
		stop:function(){
			clearInterval(DivWinTimer.handle);
		}
	};
	DivWinTimer.start();
}
//**初始化函数******
DivWin.divWindow_init=function(){
	var allTheWindows=document.getElementsByTagName("div");
	for(var i=0;i<allTheWindows.length;i++){
		if(allTheWindows[i].className=="divWindow")DivWin.divWindow_event_doInit(allTheWindows[i]);
	}
}
//**事件响应函数区******
DivWin.divWindow_event_doInit=function (element){
	//初始化变量
	element.ownerDocument.index=isNaN(element.ownerDocument.index)?10000:parseInt(element.ownerDocument.index)+1;
	element.x0=0;element.y0=0;
	element.x1=0;element.y1=0;
	element.w0=0;element.h0=0;
	element.offx=6;element.offy=6;
	element.padx=0;element.pady=0;
	element.minW=90;element.minH=(DivWin.BROWSERNAME=="ns"?20:20);
	element.moveable=false;
	element.resizable=false;
	element.hover='orange';element.normal='#336699';
	element.minButton=DivWin.BROWSERNAME=="ie"?"0":"_";
	element.maxButton=DivWin.BROWSERNAME=="ie"?"1":"=";
	element.normalButton=DivWin.BROWSERNAME=="ie"?"2":"+";
	element.closeButton=DivWin.BROWSERNAME=="ie"?"r":"X";
	element.title="Untitled Window";
	element.body="";
	element.winRect={l:0,t:0,w:0,h:0};
	element.restoredWinRect={l:0,t:0,w:0,h:0};
	element.windowState="normal";
	element.settingNode=DivWin.getElementByClassName(element,"divWindowSetting");
	if(!element.settingNode){
		element.settingNode=document.createElement("div");
		element.settingNode.className="divWindowSetting";
		element.settingNode.divWindow=element;
		element.appendChild(element.settingNode);
	}
	element.divWindow=element;
	//设置方法
	element.Close=DivWin.divWindow_method_Close;
	element.Destroy=DivWin.divWindow_method_Destroy;
	element.GetSetting=DivWin.divWindow_method_GetSetting;
	element.Max=DivWin.divWindow_method_Max;
	element.Min=DivWin.divWindow_method_Min;
	element.MoveTo=DivWin.divWindow_method_MoveTo;
	element.ResizeTo=DivWin.divWindow_method_ResizeTo;
	element.SetContent=DivWin.divWindow_method_SetContent;
	element.SetTitle=DivWin.divWindow_method_SetTitle;
	element.ShowHide=DivWin.divWindow_method_ShowHide;
	
	//设置事件
	element.onmousedown=DivWin.divWindow_event_doMDown;
	element.onmouseup=element.onlosecapture=DivWin.divWindow_event_doMUp;
	element.onmousemove=DivWin.divWindow_event_doMMove;
	element.onmouseout=DivWin.divWindow_event_doMOut;
	element.onclick=DivWin.divWindow_event_doClick;
	element.onselectstart=element.onselect=DivWin.divWindow_event_doSelect;
	
	//记录显示风格
	var tempDisplay=element.style.display;
	//改变显示风格
	//element.style.display="block";
	//设置窗口变量
	var w=parseInt(element.GetSetting("width"));
	w=isNaN(w)?(element.offsetWidth+10):parseInt(w);
	w=w<element.minW?element.minW:w;
	var h=parseInt(element.GetSetting("height"));
	h=isNaN(h)?(element.offsetHeight+30):parseInt(h);
	h=h<element.minH?element.minH:h;
	var l=parseInt(element.GetSetting("left"));
	l=isNaN(l)?element.offsetLeft:parseInt(l);
	l=l<1?1:l;
	var t=parseInt(element.GetSetting("top"));
	t=isNaN(t)?element.offsetTop:parseInt(t);
	t=t<1?1:t;
	var z=element.ownerDocument.index;
	var title=new String(element.GetSetting("title"));	
	//设置窗口标题
	element.oTitle=element.ownerDocument.createElement("div");
	element.oTitle.divWindow=element;
	element.oTitle.className="xTitle";
	element.oTitle.width=w;
	element.appendChild(element.oTitle);
	
	
	//设置窗口标题内容
	element.oTitleContent=element.ownerDocument.createElement("span");
	element.oTitleContent.divWindow=element;
	element.oTitleContent.className="divWindowTitleContent";
	element.oTitle.appendChild(element.oTitleContent);
	element.oTitleContent.ondblclick=function(){this.divWindow.Max();};
	element.SetTitle(title);
	
	//设置窗口标题关闭按钮
	element.oTitleCButton=element.ownerDocument.createElement("input");
	element.oTitleCButton.divWindow=element;
	element.oTitleCButton.type="button";
	element.oTitleCButton.className="divWindowTitleCloseButton";
	element.oTitle.appendChild(element.oTitleCButton);
	element.oTitleCButton.onclick=function(){this.divWindow.ShowHide("none");};
	element.oTitleCButton.value=element.closeButton;
	
	//设置窗口标题最大化按钮
	element.oTitleMaButton=element.ownerDocument.createElement("input");
	element.oTitleMaButton.divWindow=element;
	element.oTitleMaButton.type="button";
	element.oTitleMaButton.className="divWindowTitleMaxButton";
	element.oTitle.appendChild(element.oTitleMaButton);
	element.oTitleMaButton.onclick=function(){this.divWindow.Max();};
	element.oTitleMaButton.value=element.maxButton;
	
	//设置窗口标题最小化按钮
	element.oTitleMButton=element.ownerDocument.createElement("input");
	element.oTitleMButton.divWindow=element;
	element.oTitleMButton.type="button";
	element.oTitleMButton.className="divWindowTitleMinButton";
	element.oTitle.appendChild(element.oTitleMButton);
	element.oTitleMButton.onclick=function(){this.divWindow.Min();};
	element.oTitleMButton.value=element.minButton;
	
	//设置窗口内容
	element.oContent=element.ownerDocument.createElement("div");
	element.oContent.divWindow=element;
	element.oContent.className="divWindowBody";
	element.appendChild(element.oContent);
	oC=element.firstChild;
	while(oC){
		tC=oC.nextSibling;
		if(oC!=element.oTitle&&oC!=element.oContent){			
			element.oContent.appendChild(oC);
		}
		oC=tC;
	}
	
	//设置窗口阴影
	element.oShadow=element.ownerDocument.createElement("div");
	element.oShadow.divWindow=element;
	element.oShadow.className="xShadow";
	element.parentNode.insertBefore(element.oShadow,element.nextSibling);
	element.oShadow.style.zIndex=z-1;
	element.MoveTo(l,t);
	element.ResizeTo(w,h);
	//恢复显示风格
	element.style.display=tempDisplay;
	//设置窗口样式
	with(element.style){
		zIndex=z;
		backgroundColor=element.normal;
		color=element.normal;
	}
	padx=element.offsetWidth-element.clientWidth;
	pady=element.offsetHeight-element.clientHeight;
	return element;
}

//showDivWindow

//创建一个div窗口口对象;
DivWin.showDivWindow=function (eventElem,winID,srcUrl,width,height,left,top,title,isShowRefresh,reFreshUrl,isMax)
{
	if(isMax)
	{
	  left=0;
	  top=0;
	}
	var divID="xWin_"+winID;
	var divElem=document.getElementById(divID);
	var oldFlag=false;
	this.isShowRefresh=isShowRefresh;
	if(divElem!=null){
		var iframe=DivWin.getMainIframe(divElem);
		var mainDiv=DivWin.getMainDiv(divElem);
		if(mainDiv!=null&&iframe!=null)
		{
			if(encodeURI(srcUrl)!=encodeURI(iframe.src))
			{
				var iframeNew=DivWin.createIframe(divID,iframe.style.width,iframe.style.height,srcUrl);
				mainDiv.replaceChild(iframeNew,iframe);
				this.isShowRefresh=false;
			}
			if(this.isShowRefresh)
			  iframe.src=srcUrl;
			DivWin.resetPlace(divElem,width,height,left,top,title,srcUrl,isShowRefresh,reFreshUrl);
		}		
		oldFlag=true;
	}
	else
	{
		var divElem=DivWin.bulidWindow(divID,width,height,left,top,title,srcUrl,isShowRefresh,reFreshUrl);
		DivWin.divWindow_event_doInit(divElem);
		if(isMax)
		  divElem.Max();
	}
	if(divElem.style.visibility=="hidden")
	{
		DivWin.showDiv(divElem, "block");
	}
	divElem.style.zIndex=DivWin.getMaxDivIndex();
	if(!DivWin.ns && oldFlag)
	{
		//PubUtil.showTags(shadowDiv.previousSibling);
		PubUtil.hiddenTags(shadowDiv.previousSibling);
	}	
	return true;
}


//初始化;
DivWin.bulidWindow=function(divID,width,height,left,top,title,srcUrl,isShowRefresh,reFreshUrl)
{
	var divElem=document.createElement("div");
	if(width==null||width<=0)width=500;
	if(height==null||height<=0)height=450;
	//if(left==null||left==""||left<0)left=-1;//error
	if(left==null||left<0)left=-1;
	if(top==null||top<0)top=-1;
	var normal = '#336699';
	
	if(left==-1&&top==-1)
	{
		
	  var bwidth=document.body.clientWidth;
	  var bheight=document.body.clientHeight;
	  if(width>=bwidth)
	  {
		  //left=0;
		  width=bwidth*9/10;
			left=(bwidth-width)/2+document.body.scrollLeft;
	  }
	  else if (width<bwidth)
		 left=(bwidth-width)/2+document.body.scrollLeft;
	  if(height>bheight)
	  {
		  height=bheight;//*4/5;
		  //top=0;
		  top=(bheight-height)/2+document.body.scrollTop;
	  }
	  else if (height<bheight)
		 top=(bheight-height)/2+document.body.scrollTop;
	}
	else 
	{
		if(left==9999) left=document.body.clientWidth-width;
		if(top==9999) top=document.body.clientHeight-height;
	}
	divElem.className="divWindow";
	divElem.id=divID;
	divElem.closePoint=left+","+top+","+width+","+height;
	divElem.name="xWin";
	divElem.style.width=width;
	divElem.style.height=height;
	divElem.style.visibility="hidden";
	divElem.style.display="";
	var str = "<span class=\"divWindowSetting\" style=\"display:none\">width="+width+" height="+height+"  top="+top+" left="+left+" title="+title+" </span>";
	divElem.innerHTML=str;
	var iframe=DivWin.createIframe(divID,width,height,srcUrl);
	var mainDiv=document.createElement("div");
	mainDiv.id=divID+"_MainBody";
	mainDiv.style.cssText="width:100%;height:100%;background-color:white;text-align:left;";
	mainDiv.appendChild(iframe);
	divElem.appendChild(mainDiv);
	document.body.appendChild(divElem); 
	return divElem;
}

DivWin.resetPlace=function(divElem,width,height,left,top,title,srcUrl,isShowRefresh,reFreshUrl)
{
	if(width==null || width<=0)width=500;
	if(height==null || height<=0)height=450;
	if(left==null || left<0) left=-1;// not use if(left==null || left=="" || left<0),error
	if(top==null || top<0) top=-1;
	var normal = '#336699';
	if(left==-1 && top==-1)
	{		
	  var bwidth=document.body.clientWidth;
	  var bheight=document.body.clientHeight;
	  if(width>=bwidth)
	  {
		  //left=0;
		  width=bwidth*9/10;
		  left=(bwidth-width)/2+document.body.scrollLeft;
	  }
	  else if (width<bwidth)
		 left=(bwidth-width)/2+document.body.scrollLeft;
	  if(height>bheight)
	  {
		  height=bheight;//*4/5;
		  //top=0;
		  top=(bheight-height)/2+document.body.scrollTop;
	  }
	  else if (height<bheight)
		 top=(bheight-height)/2+document.body.scrollTop;
	}
	else 
	{
		if(left==9999) left=document.body.clientWidth-width;
		if(top==9999) top=document.body.clientHeight-height;
	}
	divElem.closePoint=left+","+top+","+width+","+height;	
	divElem.style.left=left;
	divElem.style.top=top;
}

/*创建iframe*/
DivWin.createIframe=function(divID,width,height,srcUrl)
{
	var iframe=document.createElement("iframe");
	iframe.id=divID+"_frame";
	iframe.src=srcUrl;
	iframe.frameborder=0;
	iframe.style.cssText="width:"+width+";height:"+height+";border=0;marginWidth:0;marginHeight:0;scroll:auto";
	return iframe;
}
//显示隐藏窗口
DivWin.showDiv=function (divElem, dis)
{
	var xWin=null;
	xWin=divElem;
	DivWin.shadowDiv=xWin.nextSibling;
	DivWin.shadowDiv.style.display="none";
	if(dis=="none")
		DivWin.winOff(xWin);
	else
		DivWin.winOn(xWin);
}

//关闭窗口效果
DivWin.winOff=function (xWin)
{	
	var ll=xWin.offsetLeft;
	var tt=xWin.offsetTop;
	var ww =xWin.offsetWidth;
	var hh =xWin.clientHeight;
	xWin.closePoint=ll+","+tt+","+ww+","+hh;
	xWin.style.visibility="hidden";
	var times=4;
	var Alltimes=4;
	if(!DivWin.ns)
		PubUtil.showTags(xWin);
	DivWin.winOffEffect(ww,hh,ll,tt,times,Alltimes);
}

//显示打开藏窗口效果
DivWin.winOffEffect=function (ww,hh,ll,tt,times,Alltimes)
{
	shadowDiv=DivWin.shadowDiv;
	if(times<1){
		shadowDiv.style.display="none";
	}
	else{
		shadowDiv.style.width=ww-ww*(Alltimes-times)/Alltimes+"px";
		shadowDiv.style.height=hh-hh*(Alltimes-times)/Alltimes+"px";
		if(DivWin.ns){
			shadowDiv.style.left=ll+ww*(Alltimes-times)/Alltimes/2+"px";
			shadowDiv.style.top=tt+hh*(Alltimes-times)/Alltimes/2+"px";
		}else{
			shadowDiv.style.posLeft=ll+ww*(Alltimes-times)/Alltimes/2;
			shadowDiv.style.posTop=tt+hh*(Alltimes-times)/Alltimes/2;

		}
		times=times-1;
		setTimeout("DivWin.winOffEffect("+ww+","+hh+","+ll+","+tt+","+times+","+Alltimes+")",30);
	}
}

//显示窗口效果
DivWin.winOn=function (xWin)
{
	var pointArr=xWin.closePoint.split(",");
	var ll=parseInt(pointArr[0]);
	var tt=parseInt(pointArr[1]);
	var ww =parseInt(pointArr[2]);
	var hh =parseInt(pointArr[3]);
	var times=1;
	var Alltimes=4;
	DivWin.winOnEffect(ww,hh,ll,tt,times,Alltimes);
}

//显示口效果
DivWin.winOnEffect=function (ww,hh,ll,tt,times,Alltimes)
{
	shadowDiv=DivWin.shadowDiv;
	if(times==4)
	{
		shadowDiv.style.width=ww;
		shadowDiv.style.height=hh;
		if(DivWin.ns){
			shadowDiv.style.left=ll;
			shadowDiv.style.top=tt;
		}else{
			shadowDiv.style.posLeft=ll;
			shadowDiv.style.posTop=tt;
		}
		shadowDiv.previousSibling.style.visibility="visible";
		shadowDiv.previousSibling.style.display="block";

	}
	else{
		shadowDiv.style.width=parseInt(ww*times/Alltimes)+"px";
		shadowDiv.style.height=parseInt(hh*times/Alltimes)+"px";
		if(DivWin.ns){
			shadowDiv.style.left=(ll+ww/2-ww*times/Alltimes/2)+"px";
			shadowDiv.style.top=(tt+hh/2-hh*times/Alltimes/2)+"px";
		}else{
			shadowDiv.style.posLeft=(ll+ww/2-ww*times/Alltimes/2);
			shadowDiv.style.posTop=(tt+hh/2-hh*times/Alltimes/2);
		}
		times=times+1;
		setTimeout("DivWin.winOnEffect("+ww+","+hh+","+ll+","+tt+","+times+","+Alltimes+")",30);
	}
}

DivWin.divWindow_event_doMDown=function(evt){
	var e=evt?evt:window.event;
	var eSrc=e.srcElement?e.srcElement:e.target;
	var leftButton=e.srcElement?e.button==1:e.button==0;
	if(this.style.zIndex!=this.ownerDocument.index){//将窗口放到最前
		this.ownerDocument.index+=2;
		var idx = this.ownerDocument.index;
		this.style.zIndex=idx;
		this.nextSibling.style.zIndex=idx-1;
		this.style.cursor="move";
	}
	if(eSrc==this.oTitleContent&&leftButton&&this.windowState=="normal"){//如果开始拖动
		this.style.zIndex=DivWin.getMaxDivIndex();
		//锁定标题栏;
		this.style.cursor="move";
		document.captureEvents?document.captureEvents("mousemove",this.oTitle):this.oTitle.setCapture();
		//定义对象;
		var win = this;
		var sha = win.nextSibling;
		//记录鼠标和层位置;
		this.x0 = e.clientX;
		this.y0 = e.clientY;
		this.x1 = parseInt(win.style.left);
		this.y1 = parseInt(win.style.top);
		//改变风格;
		this.oTitle.style.backgroundColor = this.hover;
		win.style.borderColor = this.hover;
		this.oTitle.nextSibling.style.color = this.hover;
		sha.style.left = this.x1 + this.offx;
		sha.style.top  = this.y1 + this.offy;
		this.moveable = true;
		return(true);
	}
	if(this.style.cursor!="default"&&this.windowState=="normal"){//开始改变大小
		//锁定标题栏;
		document.captureEvents?document.captureEvents("mousemove",this.oTitle):this.oTitle.setCapture();
		//定义对象;
		var win = this;
		var sha = win.nextSibling;
		//记录鼠标位置和层位置和大小;
		this.x0=e.clientX;
		this.y0=e.clientY;
		this.x1=parseInt(win.offsetLeft);
		this.y1=parseInt(win.offsetTop);
		this.w0=parseInt(win.offsetWidth);
		this.h0=parseInt(win.offsetHeight);
		//改变风格;
		this.oTitle.style.backgroundColor = this.hover;
		win.style.borderColor = this.hover;
		this.oTitle.nextSibling.style.color = this.hover;
		sha.style.left = this.x1 + this.offx;
		sha.style.top  = this.y1 + this.offy;
		this.resizable = true;
		if(DivWin.ns){
			var iframe=DivWin.getMainIframe(this);
			if(iframe!=null){
				iframe.style.display="none";
			}
		}
		return(true);
	}

}

DivWin.divWindow_event_doMUp=function(evt){
	var e=evt?evt:window.event;
	document.releaseEvents?document.releaseEvents("mousemove",this.oTitle):this.oTitle.releaseCapture();
	if(this.moveable){
		var win = this;
		var sha = win.nextSibling;
		var msg = this.oTitle.nextSibling;
		win.style.borderColor     = "";
		this.oTitle.style.backgroundColor = "";
		msg.style.color           = "";
		sha.style.left = this.oTitle.parentNode.style.left;
		sha.style.top  = this.oTitle.parentNode.style.top;
		this.moveable = false;
		return(false);
	}
	if(this.resizable){
		var win = this;
		var sha = win.nextSibling;
		var msg = this.oTitle.nextSibling;
		win.style.borderColor     = "";
		this.oTitle.style.backgroundColor = "";
		msg.style.color           = "";
		sha.style.left = this.oTitle.parentNode.style.left;
		sha.style.top  = this.oTitle.parentNode.style.top;
		sha.style.width = this.oTitle.parentNode.style.width;
		sha.style.height = this.oTitle.parentNode.style.height;
		this.style.cursor="default";
		this.resizable = false;
		if(DivWin.ns){
			var iframe=DivWin.getMainIframe(this);
			if(iframe!=null){
				iframe.style.display="";
			}
		}
		return(false);
	}
}
 DivWin.divWindow_event_doMOut=function(evt){
	 if(DivWin.ns&&this.resizable){
		//this.moveable = false;
		//this.resizable = false;
	 }
 }
 DivWin.divWindow_event_doMMove=function(evt){
	var e=evt?evt:window.event;
	if(this.moveable){//拖动窗口
		this.MoveTo(this.x1 + e.clientX - this.x0, this.y1 + e.clientY - this.y0);
		
		return(true);
	}
	if(this.resizable){//改变窗口大小
		var xxx=this.style.cursor.substring(0,2).match(/[we]/i);
		var yyy=this.style.cursor.substring(0,2).match(/[ns]/i);
		l=this.offsetLeft;
		t=this.offsetTop;
		w=parseInt(this.style.width);
		h=parseInt(this.style.height);
		if(xxx=="w"){
			l=this.x1+e.clientX - this.x0;
			w=this.w0+this.x0-e.clientX;
			if(l<0){w+=l;l=0;}
			if(w<this.minW){l=l+w-this.minW;w=this.minW;}
		}
		if(xxx=="e"){
			w=this.w0+e.clientX-this.x0;
			w=w<this.minW?this.minW:w;
		}
		if(yyy=="n"){
			t=this.y1+e.clientY - this.y0;
			h=this.h0+this.y0-e.clientY;
			if(t<0){h+=t;t=0;}
			if(h<this.minH){t=t+h-this.minH;h=this.minH;}
		}
		if(yyy=="s"){
			h=this.h0+e.clientY-this.y0;
			h=h<this.minH?this.minH:h;
		}
		this.MoveTo(l,t);
		this.ResizeTo(w,h);
		return(true);
	}
	if(this.windowState=="normal"){
		var cc="";
		x=DivWin.getRealLeft(this);
		y=DivWin.getRealTop(this);
		w=parseInt(this.offsetWidth);
		h=parseInt(this.offsetHeight);
		if(e.clientY-y<5)cc+="n";
		if(y+h-e.clientY<5)cc+="s";
		if(e.clientX-x<5)cc+="w";
		if(x+w-e.clientX<5)cc+="e";
		if(cc!=""){
			this.style.cursor=cc+"-resize";
			return(true);
		}
		if(this.style.cursor!="default"){
			this.style.cursor="default";
		}
	}
}
DivWin.divWindow_event_doClick=function(evt){
	var e=evt?evt:window.event;
}
DivWin.divWindow_event_doSelect=function(evt){
	var e=evt?evt:window.event;
	var eSrc=e.srcElement?e.srcElement:e.target;
	if(eSrc==this.oTitle||this.oTitle.contains(eSrc)){
		e.cancelBubble=true;
		e.returnValue=false;
		return(false);
	}
}
DivWin.divWindowParentNode_event_doScroll=function (evt){
	if(!this.minimizedWindows)return(true);
	for(var i=0;i<this.minimizedWindows.length;i++){
		this.minimizedWindows[i].Min(true);
	}
}
//**方法函数区******
DivWin.divWindow_method_Close=function (){
	this.Destroy();
}
DivWin.divWindow_method_Destroy=function (){
	if(this.minIndex){
		this.parentNode.minimizedWindows[this.minIndex]=null;
		this.minIndex=null;
	}
	this.outerHTML="";
}
DivWin.divWindow_method_GetSetting=function (attributeName){
	var settingString=this.settingNode.innerHTML;
	if(!attributeName)return(settingString);
	var regE=new RegExp(attributeName+"=[ \t]*\"?([^\"]*)","i");
	var re=settingString.match(regE);
	if(re){
		return(re[1]);
	}else{
		return(re);
	}
}
DivWin.divWindow_method_Max=function (reV){
	if(this.windowState=="maximize"&&(!reV)){
		//还原父节点overflow属性
		this.parentNode.style.overflow=this.parentNode.restoredStyle_overflow;
		this.MoveTo(this.restoredWinRect.l,this.restoredWinRect.t);
		this.ResizeTo(this.restoredWinRect.w,this.restoredWinRect.h);
		this.oTitleMButton.value = this.minButton;
		this.oTitleMaButton.value = this.maxButton;
		this.windowState="normal";
	}else{
		if(this.windowState=="normal"){
			this.restoredWinRect.l=this.winRect.l;
			this.restoredWinRect.t=this.winRect.t;
			this.restoredWinRect.w=this.winRect.w;
			this.restoredWinRect.h=this.winRect.h;
			
		}
		if(this.minIndex!=null){
			this.parentNode.minimizedWindows[this.minIndex]=null;
			this.minIndex=null;
		}
		if(this.minTimeHandle!=null){
			DivWinTimer.pop(this.minTimeHandle);
			this.minTimeHandle=null;
		}
		this.parentNode.restoredStyle_overflow=this.parentNode.style.overflow;
		this.parentNode.style.overflow="hidden";
		this.MoveTo(0,0);
		if(this.parentNode!=document.body){
			w=this.parentNode.clientWidth-5;
			h=this.parentNode.clientHeight-4;
		}else{
			w=document.body.clientWidth-5;
			h=document.body.clientHeight-4;
		}
		this.ResizeTo(w,h);
		this.oTitleMButton.value = this.minButton;
		this.oTitleMaButton.value = this.normalButton;
		this.windowState="maximize";
		if(!DivWin.ns)
			this.scrollIntoView();
	}
}
DivWin.divWindow_method_Min=function (reV){
	if(this.windowState=="minimize"&&(!reV)){
		this.MoveTo(this.restoredWinRect.l,this.restoredWinRect.t);
		
		this.oTitleMButton.value = this.minButton;
		this.oTitleMaButton.value = this.maxButton;
		this.windowState="normal";
		this.parentNode.minimizedWindows[this.minIndex]=null;
		this.minIndex=null;
		if(this.minTimeHandle!=null){
			DivWinTimer.pop(this.minTimeHandle);
			this.minTimeHandle=null;
		}
		this.ResizeTo(this.restoredWinRect.w,this.restoredWinRect.h);
	}else{
		if(this.windowState=="normal"){
			this.restoredWinRect.l=this.winRect.l;this.restoredWinRect.t=this.winRect.t;
			this.restoredWinRect.w=this.winRect.w;this.restoredWinRect.h=this.winRect.h;
		}else{
			//还原父节点overflow属性
			try{
				this.parentNode.style.overflow=this.parentNode.restoredStyle_overflow;
			}catch(e){}
		}
		if(!this.parentNode.minimizedWindows)this.parentNode.minimizedWindows=new Array();
		if(this.windowState!="minimize"){
			for(var i=0;i<this.parentNode.minimizedWindows.length;i++){
				if(this.parentNode.minimizedWindows[i]==null)break;
			}
			this.parentNode.minimizedWindows[i]=this;
		}else{
			i=this.minIndex;
		}
		this.ResizeTo(0,0);
		var w=this.offsetWidth;
		var h=this.offsetHeight;
		var mw=DivWin.getParentRect(this).mw;
		var mh=DivWin.getParentRect(this).mh;
		var n=parseInt(mw/w);
		var t=parseInt(i/n)+1;
		this.MoveTo(w*(i%n),mh-t*h-1);
		if(mh>DivWin.getParentRect(this).mh){
			this.MoveTo(w*(i%n),mh-t*h-200);
			mh=getParentRect(this).mh;
			this.MoveTo(w*(i%n),mh-t*h-1);
		}
		this.minIndex=i;
		this.oTitleMButton.value = this.normalButton;
		this.oTitleMaButton.value = this.maxButton;
		this.windowState="minimize";
		if(this.minTimeHandle==null){
			this.minTimeHandle=DivWinTimer.push("Min(true)",this);
			if(!DivWin.ns)
				this.scrollIntoView();
		}
	}
}
DivWin.divWindow_method_MoveTo=function (x,y,divElem){
	var winThis=divElem?divElem:this;
	var win = winThis.oTitle.parentNode;
	var sha = win.nextSibling;
	x=isNaN(x)?0:parseInt(x);
	y=isNaN(y)?0:parseInt(y);
	x=x<0?0:x;
	y=y<0?0:y;
	winThis.style.left=x+"px";
	winThis.style.top=y+"px";
	sha.style.left = parseInt(win.style.left) + ((winThis.moveable||winThis.resizable)?winThis.offx:0)+"px";
	sha.style.top  = parseInt(win.style.top) + ((winThis.moveable||winThis.resizable)?winThis.offy:0)+"px";
	winThis.winRect.l=x;
	winThis.winRect.t=y;
	if(!DivWin.ns){
		PubUtil.showTags(winThis);
		PubUtil.hiddenTags(winThis);
	}
}
DivWin.divWindow_method_ResizeTo=function (w,h){
	var win =this;
	var sha = win.nextSibling;
	var w=isNaN(w)?win.minW:parseInt(w);
	var h=isNaN(h)?win.minH:parseInt(h);
	
	var w=w<win.minW?win.minW:w;
	var h=h<win.minH?win.minH:h;
	
	win.style.width=w+"px";
	win.style.height=h+"px";
	win.oTitle.style.width=parseInt(win.clientWidth)+"px";
	var wTC=win.clientWidth;
	for(var i=0;i<win.oTitle.childNodes.length;i++){
		if(win.oTitle.childNodes[i]!=win.oTitleContent){wTC-=win.oTitle.childNodes[i].offsetWidth;}
	}
	wTC-=8;
	win.oTitleContent.style.width=(wTC<1?1:wTC)+"px";
	var wC=win.clientHeight-win.oTitle.offsetHeight-6;
	win.oContent.style.height=(wC<1?1:wC)+"px";
	win.oContent.style.width=parseInt(win.clientWidth-6)+"px";
	sha.style.left = parseInt(win.style.left) + ((win.moveable||win.resizable)?win.offx:0)+"px";
	sha.style.top  = parseInt(win.style.top) + ((win.moveable||win.resizable)?win.offy:0)+"px";
	sha.style.width = parseInt(win.style.width)+"px";
	sha.style.height = parseInt(win.style.height)+"px";
	win.winRect.w=w;
	win.winRect.h=h;
	DivWin.divWindow_change_iframe(win,w,h);
}
/*窗口大小改变时,关联改变iframe*/
DivWin.divWindow_change_iframe=function(divElem,w,h){
	var iframe=DivWin.getMainIframe(divElem);
	if(iframe==null) return;
	if(DivWin.ns){
		iframe.style.width=parseInt(w-4)+"px";
		if(h>=24)
			iframe.style.height=parseInt(h-24)+"px";	
	}else{
		iframe.style.width=parseInt(w-6)+"px";
		if(h>=26)
			iframe.style.height=parseInt(h-26)+"px";
		
	}
}
DivWin.divWindow_method_SetContent=function (v){
	if(this.oContent){
		if(v==null||v==undefined||v==""){this.body=this.oContent.innerHTML="";return(this.oContent);}
		if(typeof(v)=="string"){
			this.body=this.oContent.innerHTML=v;
			return(this.oContent);
		}else{
			try{
				this.oContent.innerHTML="";
				this.body=this.oContent.appendChild(v);
				return(this.oContent);
			}catch(e){
				throw(e);
			}
		}
	}else{
		this.body=v;
		return(null);
	}
}
DivWin.divWindow_method_SetTitle=function (strT){
	this.title=strT==null?this.title:strT;
	if(this.oTitleContent){
		DivWin.setInnerText(this.oTitleContent,this.title);
	}
}
DivWin.divWindow_method_ShowHide=function (dis){
	//this.nextSibling.style.display="none";
	this.moveable = false;
	this.resizable = false;
	DivWin.showDiv(this,dis);
	var bdisplay = (dis==null)?((this.style.display=="none")?"":"none"):dis;
	if(bdisplay=="none"){
		if(this.windowState=="minimize"){
			this.parentNode.minimizedWindows[this.minIndex]=null;
			this.Index=null;
		}
	}else{
		if(this.windowState=="minimize"){
			//this.Min();
		}
	}

}

DivWin.getElementByClassName=function (obj,className){
	for(var i=0;i<obj.childNodes.length;i++){
		if(obj.childNodes[i].className==className)return(obj.childNodes[i]);
	}
	return(null);
}
DivWin.getParentRect=function (obj){
	var re=new Object();
	if(obj.parentNode!=document.body){
		re.mw=Math.max(obj.parentNode.scrollWidth,obj.parentNode.clientWidth);
		re.mh=Math.max(obj.parentNode.scrollHeight,obj.parentNode.clientHeight);
		
	}else{
		re.mw=Math.max(document.body.scrollWidth,document.body.clientWidth);
		re.mh=Math.max(document.body.scrollHeight,document.body.clientHeight);
	}
	return(re);
}

/*
 *查出页面中的所有div,中为nodeType为c的div
 */
 DivWin.findAllDiv=function(){
	var divs=document.getElementsByTagName("div");
	var cdivs =new Array();
	if(divs==null)return null;
	var idx=0;
	for(var i=0,n=divs.length;i<n;i++){
		if(divs[i].name=='xWin'){
			cdivs[idx]=divs[i];
			idx++;
		}
	}
	return divs;
}
/*
 *返回div窗口最大值+1
 */
 DivWin.getMaxDivIndex=function(){
	var cdivs = DivWin.findAllDiv();
	if(cdivs==null)return 100;
	var zIndex=100;
	for(var i=0,n=cdivs.length;i<n;i++){
		if(cdivs[i].style.zIndex>zIndex){
			zIndex=cdivs[i].style.zIndex;
		}
	}
	zIndex=zIndex+1;
	return zIndex;
}

/*
 *取出窗口中的iframe窗口
 */
 DivWin.getMainIframe=function(divElem){
	var iframe=null;
	var iframes=divElem.getElementsByTagName("iframe");
	if(iframes!=null)
	{
		for(var i=0,m=iframes.length;i<m;i++)
		{
		  if(iframes[i].id=divElem.id+"_frame")
		  {
			  iframe=iframes[i];
			  break;
		  }
		}
	}
	return iframe;
}
/*
 *取出窗口中的主div窗口
 */
 DivWin.getMainDiv=function(divElem){
	var div=null;
	var divs=divElem.getElementsByTagName("div");
	if(divs!=null)
	{
		for(var i=0,m=divs.length;i<m;i++)
		{
			if(divs[i].id=divElem.id+"_MainBody")
			{
				div=divs[i];
			}
		}
	}
	return div;
}
//**通用函数区***
DivWin.getRealLeft=function (o){
	var l=o.offsetLeft-o.scrollLeft;
	while(o=o.offsetParent){
		l+=o.offsetLeft-o.scrollLeft;
	}
	return(l);
}
DivWin.getRealTop=function (o){
	var t=o.offsetTop-o.scrollTop;
	while(o=o.offsetParent){
		t+=o.offsetTop-o.scrollTop;
	}
	return(t);
}
DivWin.setInnerText=function (obj,text){
	switch(DivWin.BROWSERNAME){
		case "ns":
			obj.textContent=text;
		break;
		default:
			obj.innerText=text;
	}
}
	