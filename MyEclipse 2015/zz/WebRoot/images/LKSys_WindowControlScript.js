//==========[BEGIN]发布时考虑用后台输出的脚本，加在检查Session的公用函数中============//
	//=======================================Begin
	/*屏蔽鼠标右键方法，但是如果双击鼠标，会弹出一个鼠标右键记忆地址的新页面，
	所以，需要配合我们检查Session的函数来限制，这样，只要在每个页面中加入了检查
	Session的代码，如果弹出的页面是我们的页面，就会被报告“无效用户！”而无法进入！
	*/
//	document.oncontextmenu=new Function ("return false;");	
	//=======================================End

	//=======================================Begin
	//禁止选择页面上的文字！(实现禁止复制页面内容的功能)
/*	function disableselect(e){
	return false;
	}

	function reEnable(){
	return true;
	}
	//if IE4+
	document.onselectstart=new Function ("return false");
	//if NS6
	if (window.sidebar){
	document.onmousedown=disableselect;
	document.onclick=reEnable;
	}
*/	
	//=======================================End
	
	//=======================================Begin
	/* 
	******************************************************************************
	* 函数名称: LKSYS_PubDisableKey
	* 函数功能: 在WEB页面上按下键盘时，将一些键置为无效
	* 说    明: 目前，该函数封闭了BackSpace键
	* 调用方法: <body onkeydown=PubDisableKey()>
	* 编码人员:	彭志飞
	********************************************************************************
	*/ 
	function LKSYS_PubDisableKey(){
		if (event.keyCode==8){
			event.keyCode=0;
			event.returnValue=false;
		}
/*		if ((event.keyCode==8) || //屏蔽退格删除键
		(event.keyCode==116)|| //屏蔽 F5 刷新键
		(event.ctrlKey && event.keyCode==82)){ //Ctrl + R
		event.keyCode=0;
		event.returnValue=false;
		}

		if ((window.event.altKey)&&
			((window.event.keyCode==37)|| //屏蔽 Alt+ 方向键 ←
			(window.event.keyCode==39))){ //屏蔽 Alt+ 方向键 →
			alert("为了数据安全，系统不允许您使用ALT+方向键前进或后退页面！");
			event.returnValue=false;
			}
		/* 注：这还不是真正地屏蔽 Alt+ 方向键，
		因为 Alt+ 方向键弹出警告框时，按住 Alt 键不放，
		用鼠标点掉警告框，这种屏蔽方法就失效了。以后若
		有哪位高手有真正屏蔽 Alt 键的方法，请告知。*/
/*		
		if ((event.ctrlKey)&&(event.keyCode==78)) //屏蔽 Ctrl+n
		event.returnValue=false;
		if ((event.shiftKey)&&(event.keyCode==121)) //屏蔽 shift+F10
		event.returnValue=false;
*/
	}
	//=======================================End
	//=======================================Begin
	/* 
	******************************************************************************
	* 函数名称: LKSYS_PubDisableMouseRKey
	* 函数功能: 在WEB页面上点击鼠标右键无效，主要防止用户可以随意查看HTML源代码以及文件名称
	* 调用方法: <body onmousedown=PubDisableMouseRKey()>(暂时不要调用！！)
	* 编码人员:	彭志飞
	********************************************************************************
	*/ 
	function LKSYS_PubDisableMouseRKey(){	
/*		if(event.button==2){	//鼠标右键键值
			alert("北京联达动力信息科技发展有限公司[版权所有]");
			//event.button = 1;
			window.event.returnValue=false;		
		}*/
	}
	//=======================================End
//==========[END]发布时考虑用后台输出的交办，加在检查Session的公用函数中============//




//************************以下为在程序中供调用的脚本函数集合************************\\

//		'===============================================================
//		'函数名称：PubOpenWindow(strUrlPath, strWindowName, iWidth, iHeight)
//		'功能描述：用客户端脚本新开一个窗口，该窗口为系统统一风格的弹出式窗口。
//		'参数说明：strUrlPath:要打开程序的路径名称（相对路径）	
//		'			strWindowName:弹出窗口的名称，一般为空，除非有些数据只能打开一个弹出窗口需要将该窗口命名
//		'			iWidth:指定弹出窗口的宽度,如果为空，则是当前屏幕宽度
//		'			iHeight:指定弹出窗口的高度，如果为空，则是当前屏幕高度
//		'一般在预览、查询详细资料等功能页面可能用到弹出窗口
//		'例如：PubOpenWindow("../ggxx/ggxx_xx_view.aspx?xh=1", "", 800,600)
//		'返回值：无
//		'===============================================================
function LKSYS_PubOpenWindow(strUrlPath, strWindowName, iWidth, iHeight)
{
	var objNewWin;
	var windowAttribs;
	if (iWidth == "") {iWidth = screen.availWidth;}
	if (iHeight == "") {iHeight = screen.availHeight;}
	windowAttribs = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=5,height=5,top=0,left=0,fullscreen=0";
	//windowAttribs = "fullscreen=5";	//窗口为最大化大小，没有关闭、最小化以及最大化按钮，但是窗口可以移动
	try{
	objNewWin = window.open(strUrlPath,strWindowName,windowAttribs);
	objNewWin.resizeTo(iWidth,iHeight);
	objNewWin.moveTo((screen.availWidth-iWidth)/2,(screen.availHeight-iHeight)/2);
	objNewWin.focus();
	}catch(e){}
	
}

//		'===============================================================
//		'函数名称：LKSYS_PubOpenWindow1(strUrlPath, strWindowName, iWidth, iHeight,
//		bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable)
//		'功能描述：用客户端脚本新开一个窗口，可以定义详细的打开风格，支持自定义风格参数。
//		'参数说明：strUrlPath:要打开程序的路径名称（相对路径）	
//		'			strWindowName:弹出窗口的名称，一般为空，除非有些数据只能打开一个弹出窗口需要将该窗口命名
//		'			iWidth:指定弹出窗口的宽度,如果为空，则是当前屏幕宽度
//		'			iHeight:指定弹出窗口的高度，如果为空，则是当前屏幕高度
//		'bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable 参数的值为 0||1 或者 false||true
//		'一般在预览、查询详细资料等功能页面可能用到弹出窗口
//		'例如：LKSYS_PubOpenWindow1("../ggxx/ggxx_xx_view.aspx?xh=1", "", 800,600,0,0,0,0,0,0,0,0)
//		'返回值：无
//		'===============================================================
function LKSYS_PubOpenWindow1(strUrlPath, strWindowName, iWidth, iHeight,bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable)
{
	var objNewWin;
	var windowAttribs;
	if (iWidth == "") {iWidth = screen.availWidth;}
	if (iHeight == "") {iHeight = screen.availHeight;}
	windowAttribs = "fullscreen=" + bFullScreen + ",toolbar=" + bToolbar + ",location=" + bLocation + ",directories=" + bDirectories +",status=" + bStatus + ",menubar=" + bMenubar +",scrollbars=" + bScrollbars + ",resizable=" + bResizable;
	try{
	objNewWin = window.open(strUrlPath,strWindowName,windowAttribs);
	objNewWin.resizeTo(iWidth,iHeight);
	objNewWin.moveTo((screen.availWidth-iWidth)/2,(screen.availHeight-iHeight)/2);
	//objNewWin.onload = PubMaxWin();
	objNewWin.focus();
	}catch(e){}	
}
//功能类似LKSYS_PubOpenWindow1,最后将窗口定位在定义的LEFT 和 TOP
function LKSYS_PubOpenWindow2(strUrlPath, strWindowName, iWidth, iHeight,bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable,iLeft,iTop)
{
	var objNewWin;
	var windowAttribs;
	if (iWidth == "") {iWidth = screen.availWidth;}
	if (iHeight == "") {iHeight = screen.availHeight;}
	windowAttribs = "fullscreen=" + bFullScreen + ",toolbar=" + bToolbar + ",location=" + bLocation + ",directories=" + bDirectories +",status=" + bStatus + ",menubar=" + bMenubar +",scrollbars=" + bScrollbars + ",resizable=" + bResizable +",left=" + iLeft + ",top=" + iTop;
	try{
	objNewWin = window.open(strUrlPath,strWindowName,windowAttribs);
	objNewWin.resizeTo(iWidth,iHeight);	
	objNewWin.moveTo(iLeft,iTop);
	//objNewWin.onload = PubMaxWin();
	objNewWin.focus();
	}catch(e){}
	
}

function LKSYS_postform(sAspFile,sPostData)         //统一发送XMLHttp函数
{
	//alert(sPostData);
	try
	{
   	var xmlhttp = new ActiveXObject("MSXML2.XMLHTTP.4.0");        //创建XML4.0的XMLHTTP方法
	}
	catch (exception)
	{
		try
		{
			var xmlhttp = new ActiveXObject("MSXML2.XMLHTTP");	         //创建XML3.0的XMLHTTP方法
		}
		catch (exception)
		{
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");        //创建XML2.6的XMLHTTP方法
		}	   
	}
   	xmlhttp.Open("POST", sAspFile,false);
   	xmlhttp.setRequestHeader("Content-Length",sPostData.length);
   	xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	try
	{
    	xmlhttp.Send(sPostData);
	}
	catch (exception)
	{
		alert("服务器忙!");
	}
	try
	{
		var str=xmlhttp.responseXML.xml; //系统错误: -1072896748。
		if (str.length==0) 
		{
     		str=xmlhttp.responseText;
		}
	}
	catch (exception)
	{
		if (exception.description=='系统错误: -1072896748。') 
		{	
			str="";
		}		
	}
	//str=str.replace("&amp;","&amp;");
	//str=str.replace("&lt;","&lt;");
	//str=str.replace("&gt;","&gt;");
	//alert(str);
	return str;
}


//		'===============================================================
//		'函数名称：PubmaxWin()
//		'功能描述：将当前窗口最大化，相当于点击最大化按钮的效果
//		'使用方法：在要使用的页面中加入代码：<body onload="PubMaxWin()">
//		'返回值：无
//		'===============================================================
function LKSYS_PubMaxWin()
{
	try
	{
		var b = top.screenLeft == 0;
		var b = b && top.screen.availHeight - top.screenTop - top.body.offsetHeight - 20 == 0;
		if(!b)
		{
		var str  = '<object id=HHCtrlMax classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
		str += '<param name="Command" value="Maximize"></object>';
		if(typeof(HHCtrlMax)!="object") document.body.insertAdjacentHTML("beforeEnd", str);
		document.getElementById("HHCtrlMax").Click();
		}
	}catch(e){}
}