//==========[BEGIN]����ʱ�����ú�̨����Ľű������ڼ��Session�Ĺ��ú�����============//
	//=======================================Begin
	/*��������Ҽ��������������˫����꣬�ᵯ��һ������Ҽ������ַ����ҳ�棬
	���ԣ���Ҫ������Ǽ��Session�ĺ��������ƣ�������ֻҪ��ÿ��ҳ���м����˼��
	Session�Ĵ��룬���������ҳ�������ǵ�ҳ�棬�ͻᱻ���桰��Ч�û��������޷����룡
	*/
//	document.oncontextmenu=new Function ("return false;");	
	//=======================================End

	//=======================================Begin
	//��ֹѡ��ҳ���ϵ����֣�(ʵ�ֽ�ֹ����ҳ�����ݵĹ���)
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
	* ��������: LKSYS_PubDisableKey
	* ��������: ��WEBҳ���ϰ��¼���ʱ����һЩ����Ϊ��Ч
	* ˵    ��: Ŀǰ���ú��������BackSpace��
	* ���÷���: <body onkeydown=PubDisableKey()>
	* ������Ա:	��־��
	********************************************************************************
	*/ 
	function LKSYS_PubDisableKey(){
		if (event.keyCode==8){
			event.keyCode=0;
			event.returnValue=false;
		}
/*		if ((event.keyCode==8) || //�����˸�ɾ����
		(event.keyCode==116)|| //���� F5 ˢ�¼�
		(event.ctrlKey && event.keyCode==82)){ //Ctrl + R
		event.keyCode=0;
		event.returnValue=false;
		}

		if ((window.event.altKey)&&
			((window.event.keyCode==37)|| //���� Alt+ ����� ��
			(window.event.keyCode==39))){ //���� Alt+ ����� ��
			alert("Ϊ�����ݰ�ȫ��ϵͳ��������ʹ��ALT+�����ǰ�������ҳ�棡");
			event.returnValue=false;
			}
		/* ע���⻹�������������� Alt+ �������
		��Ϊ Alt+ ��������������ʱ����ס Alt �����ţ�
		�������������������η�����ʧЧ�ˡ��Ժ���
		����λ�������������� Alt ���ķ��������֪��*/
/*		
		if ((event.ctrlKey)&&(event.keyCode==78)) //���� Ctrl+n
		event.returnValue=false;
		if ((event.shiftKey)&&(event.keyCode==121)) //���� shift+F10
		event.returnValue=false;
*/
	}
	//=======================================End
	//=======================================Begin
	/* 
	******************************************************************************
	* ��������: LKSYS_PubDisableMouseRKey
	* ��������: ��WEBҳ���ϵ������Ҽ���Ч����Ҫ��ֹ�û���������鿴HTMLԴ�����Լ��ļ�����
	* ���÷���: <body onmousedown=PubDisableMouseRKey()>(��ʱ��Ҫ���ã���)
	* ������Ա:	��־��
	********************************************************************************
	*/ 
	function LKSYS_PubDisableMouseRKey(){	
/*		if(event.button==2){	//����Ҽ���ֵ
			alert("�������ﶯ����Ϣ�Ƽ���չ���޹�˾[��Ȩ����]");
			//event.button = 1;
			window.event.returnValue=false;		
		}*/
	}
	//=======================================End
//==========[END]����ʱ�����ú�̨����Ľ��죬���ڼ��Session�Ĺ��ú�����============//




//************************����Ϊ�ڳ����й����õĽű���������************************\\

//		'===============================================================
//		'�������ƣ�PubOpenWindow(strUrlPath, strWindowName, iWidth, iHeight)
//		'�����������ÿͻ��˽ű��¿�һ�����ڣ��ô���Ϊϵͳͳһ���ĵ���ʽ���ڡ�
//		'����˵����strUrlPath:Ҫ�򿪳����·�����ƣ����·����	
//		'			strWindowName:�������ڵ����ƣ�һ��Ϊ�գ�������Щ����ֻ�ܴ�һ������������Ҫ���ô�������
//		'			iWidth:ָ���������ڵĿ��,���Ϊ�գ����ǵ�ǰ��Ļ���
//		'			iHeight:ָ���������ڵĸ߶ȣ����Ϊ�գ����ǵ�ǰ��Ļ�߶�
//		'һ����Ԥ������ѯ��ϸ���ϵȹ���ҳ������õ���������
//		'���磺PubOpenWindow("../ggxx/ggxx_xx_view.aspx?xh=1", "", 800,600)
//		'����ֵ����
//		'===============================================================
function LKSYS_PubOpenWindow(strUrlPath, strWindowName, iWidth, iHeight)
{
	var objNewWin;
	var windowAttribs;
	if (iWidth == "") {iWidth = screen.availWidth;}
	if (iHeight == "") {iHeight = screen.availHeight;}
	windowAttribs = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width=5,height=5,top=0,left=0,fullscreen=0";
	//windowAttribs = "fullscreen=5";	//����Ϊ��󻯴�С��û�йرա���С���Լ���󻯰�ť�����Ǵ��ڿ����ƶ�
	try{
	objNewWin = window.open(strUrlPath,strWindowName,windowAttribs);
	objNewWin.resizeTo(iWidth,iHeight);
	objNewWin.moveTo((screen.availWidth-iWidth)/2,(screen.availHeight-iHeight)/2);
	objNewWin.focus();
	}catch(e){}
	
}

//		'===============================================================
//		'�������ƣ�LKSYS_PubOpenWindow1(strUrlPath, strWindowName, iWidth, iHeight,
//		bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable)
//		'�����������ÿͻ��˽ű��¿�һ�����ڣ����Զ�����ϸ�Ĵ򿪷��֧���Զ����������
//		'����˵����strUrlPath:Ҫ�򿪳����·�����ƣ����·����	
//		'			strWindowName:�������ڵ����ƣ�һ��Ϊ�գ�������Щ����ֻ�ܴ�һ������������Ҫ���ô�������
//		'			iWidth:ָ���������ڵĿ��,���Ϊ�գ����ǵ�ǰ��Ļ���
//		'			iHeight:ָ���������ڵĸ߶ȣ����Ϊ�գ����ǵ�ǰ��Ļ�߶�
//		'bFullScreen,bToolbar,bLocation,bDirectories,bStatus,bMenubar,bScrollbars,bResizable ������ֵΪ 0||1 ���� false||true
//		'һ����Ԥ������ѯ��ϸ���ϵȹ���ҳ������õ���������
//		'���磺LKSYS_PubOpenWindow1("../ggxx/ggxx_xx_view.aspx?xh=1", "", 800,600,0,0,0,0,0,0,0,0)
//		'����ֵ����
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
//��������LKSYS_PubOpenWindow1,��󽫴��ڶ�λ�ڶ����LEFT �� TOP
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

function LKSYS_postform(sAspFile,sPostData)         //ͳһ����XMLHttp����
{
	//alert(sPostData);
	try
	{
   	var xmlhttp = new ActiveXObject("MSXML2.XMLHTTP.4.0");        //����XML4.0��XMLHTTP����
	}
	catch (exception)
	{
		try
		{
			var xmlhttp = new ActiveXObject("MSXML2.XMLHTTP");	         //����XML3.0��XMLHTTP����
		}
		catch (exception)
		{
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");        //����XML2.6��XMLHTTP����
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
		alert("������æ!");
	}
	try
	{
		var str=xmlhttp.responseXML.xml; //ϵͳ����: -1072896748��
		if (str.length==0) 
		{
     		str=xmlhttp.responseText;
		}
	}
	catch (exception)
	{
		if (exception.description=='ϵͳ����: -1072896748��') 
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
//		'�������ƣ�PubmaxWin()
//		'��������������ǰ������󻯣��൱�ڵ����󻯰�ť��Ч��
//		'ʹ�÷�������Ҫʹ�õ�ҳ���м�����룺<body onload="PubMaxWin()">
//		'����ֵ����
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