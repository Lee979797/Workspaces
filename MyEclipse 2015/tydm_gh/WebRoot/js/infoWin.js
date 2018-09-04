function XsendDate(vPath,vhttValue){

	var X=new XMLHttpRequest();
	X.onreadystatechange=function(){
		if(X.readyState==4){
			if(X.status==200){
				//alert(X.responseTex);
				try{
				eval(X.responseText);
				}catch(e){} 
			}
			else{
				//alert(X.statusText);
			}
		}
		else{
			//idStateMsg.value="正在提取数据...";
		}
	}
	X.open('POST',vPath,true);
	X.setRequestHeader('Content-Type','application/x-www-form-urlencoded');		
	X.send(vhttValue);	
}
//关闭消息窗口
function pophide()
{
	try
	{		
	clearTimeout(poptime);	
	}catch(e){}
	oPopup.hide();	
	popTop=50;
}
var oPopup = window.createPopup();
var popTop=50;
function openNotRead(v1,v2,v3){
	
		var winstr=""
		+"<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\">"
		+"  <tr>"
		+"    <td bgcolor=\"#EEEEEE\"><table width=\"193\" border=\"0\" align=\"center\" cellpadding=\"1\" cellspacing=\"0\" style=\"border:solid 1px #79A7E2\">"
		+"      <tr>"
		+"        <td height=\"104\" valign=\"top\" style=\"filter:progid:DXImageTransform.Microsoft.Gradient(startColorStr=#ffffff endColorStr=#EFF5FF, gradientType=0)\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
		+"          <tr>"
		+"            <td width=\"35\"><img src=\"images/info_01.gif\" width=\"35\" height=\"19\" /></td>"
		+"            <td width=\"134\" background=\"images/info_02.gif\">&nbsp;</td>"
		+"            <td width=\"19\"><img src=\"images/info_03.gif\" width=\"19\" height=\"19\" onclick=\"top.pophide();\"/></td>"
		+"          </tr>"
		+"        </table>"
		+"          <table width=\"189\" height=\"83\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" onClick=\"top.getCallInfos()\">"
		+"            <tr>"
		+"             <td width=\"88\" align=\"center\" valign=\"top\"><img src=\"images/info_04.gif\" width=\"81\" height=\"66\" /></td>"
		+"              <td width=\"101\">"
		+			"<div align=center>"+ v2 + "</div><br>"
		+"				<span style=\"color:#02417E; font-weight: bold; font-size:12px;\">"
		+   v1
		+"				</span></td>"
		+"            </tr>"
		+"          </table><embed width=23 height=14 src='system/Mcitest.mid' hidden></td>"
		+"      </tr>"
		+"    </table></td>"
		+"  </tr>"
		+"</table>";
		oPopup.document.body.innerHTML = winstr;
		popshow();
}

function errNotRead(vError){
			var winstr=""
		+"<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\">"
		+"  <tr>"
		+"    <td bgcolor=\"#EEEEEE\"><table width=\"193\" border=\"0\" align=\"center\" cellpadding=\"1\" cellspacing=\"0\" style=\"border:solid 1px #F659FF\">"
		+"      <tr>"
		+"        <td height=\"104\" valign=\"top\" style=\"filter:progid:DXImageTransform.Microsoft.Gradient(startColorStr=#ffffff endColorStr=#FFF7FD, gradientType=0)\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
		+"          <tr>"
		+"            <td width=\"35\"><img src=\"images/info_05.gif\" width=\"35\" height=\"19\" /></td>"
		+"            <td width=\"134\" background=\"images/info_06.gif\">&nbsp;</td>"
		+"            <td width=\"19\"><img src=\"images/info_07.gif\" width=\"19\" height=\"19\" onclick=\"top.pophide();\" /></td>"
		+"          </tr>"
		+"        </table>"
		+"          <table width=\"189\" height=\"83\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"
		+"            <tr>"
		+"             <td width=\"88\" align=\"center\" valign=\"top\"><img src=\"images/info_08.gif\"/></td>"
		+"              <td width=\"101\">"
		+"				<span style=\"color:#02417E; font-weight: bold; font-size:12px;\" onClick=\"top.getErrorInfos()\">"
		+vError
		+"				</span></td>"
		+"            </tr>"
		+"          </table></td>"
		+"      </tr>"
		+"    </table></td>"
		+"  </tr>"
		+"</table>";
		oPopup.document.body.innerHTML = winstr;
		popshow();
}
var poptime=null;
function popshow(){
		//window.status=popTop;
		if(popTop>1720){
		clearTimeout(poptime);
		//oPopup.hide();
		popTop = 50;
		return;
		}else if(popTop>1520&&popTop<1720){
		oPopup.show(screen.width-200,screen.height,200,110);
		//oPopup.show(screen.width-200,screen.height,200,1720-popTop);
		}else if(popTop>1500&&popTop<1520){
		oPopup.show(screen.width-200,screen.height,200,110);
		//oPopup.show(screen.width-200,screen.height+(popTop-1720),200,110);
		}else if(popTop<110){
		//oPopup.show(screen.width-200,screen.height,200,110);
		oPopup.show(screen.width-200,screen.height,200,popTop);
		}else if(popTop<220){
		oPopup.show(screen.width-200,screen.height,200,110);
		//oPopup.show(screen.width-200,screen.height-popTop,200,110);
		}
		popTop+=10;
		poptime=setTimeout("popshow();",60);
}	
//有寻呼
function getNotRead(vUserCode){
	var vhtt="htpUserCode="+vUserCode;
	var vpath="indexset/IndexScanCall.asp";
	XsendDate(vpath,vhtt);
	//修改人：  李斌
	//修改时间：2009-4-30
	//修改内容：修改刷新时间
	setTimeout("getNotRead('"+vUserCode+"')",5000);
}
//待阅，待办等

function getNotReadNum(vUserCode){
	var vhtt="htpUserCode="+vUserCode;
	var vpath="indexset/IndexScanNum.asp";
	XsendDate(vpath,vhtt);
	setTimeout("getNotReadNum('"+vUserCode+"')",1800000);
}
//-->
function setNotRead(vType,vContent){
//return false;
	var arrNotReadType=new Array();
	var arrNotReadCount=new Array();
	arrNotReadType=vType.split(",");
	arrNotReadCount=vContent.split(",");
//alert(vContent);
	var tmpPop=0,tmpNew=0,tmpType="";
	NotRead1.innerText=NotRead5.innerText="0";
	for(i=0;i<arrNotReadType.length;i++){
			tmpType=arrNotReadType[i];
			
			//"IOA_New,IOA_Info,IOA_Visited,IOA_Message,IOA_Work"
			switch(tmpType){
				case  "IOA_New"://信息
					if(parseInt(arrNotReadCount[i])>0){
						tmpPop=1;
						tmpNew=arrNotReadCount[i];
					}
					break;
				case  "IOA_Info"://流程	
					NotRead1.innerText=parseInt(NotRead1.innerText)+parseInt(arrNotReadCount[i]);
					break;					
				case "IOA_Visited"://待阅
					NotRead2.innerText=arrNotReadCount[i];
					break;
				case "IOA_Message": //通知
					NotRead3.innerText=arrNotReadCount[i];
					break;	
				case "IOA_Work"://待办
					NotRead4.innerText=arrNotReadCount[i];
					break;
				case "IOA_Online"://在线人员
					NotRead5.innerText=parseInt(arrNotReadCount[i]);	
					break;
				case "IOA_NewType"://新寻呼类型
					strNewType=arrNotReadCount[i];
					break;	
				case "IOA_Time": //时钟
					try{spanTime.innerText=arrNotReadCount[i];}catch(e){}
					break;
			}						
	}
	if(tmpPop==1){
		switch(strNewType){			
			case "IOA_Call":
				tmpNewType="寻呼";
				openNotRead("您有新的信息.","<img src='images/noseecall.gif'>",0);	
			break;
			case "IOA_Task":
				tmpNewType="任务";			
				openNotRead("您有新的任务.","<img src='images/noseetask.gif'>",0);	
			break;
			case "IOA_Advise":
				tmpNewType="建议";
				openNotRead("您有新的建议.","<img src='images/noseeadvise.gif'>",0);				
			break;
			case "IOA_Approve":
				tmpNewType="待办";
				openNotRead("您有新的待办.","<img src='images/noseeapprove.gif'>",0);
			break;
			case "IOA_Calendar":
				tmpNewType="日程";
				openNotRead("您安排的日程到了.","<img src='images/noseecalendar.gif'>",0);
				break;
			//修改人：袁志国
			//修改时间：2009.4.28
			//修改内容：解决短信等不提醒
			default:				
				tmpNewType="寻呼";
				openNotRead("您有新的信息.","<img src='images/noseecall.gif'>",0);	
				break;
			
		}
		//openNotRead("您有新的信息.",0,0)
		
	}
}
//取信息
function getIndexInfos(vid){
	var vWidth=parseInt(eval("idconxMsg"+vid).style.width);
	var vhtt="htpUserCode="+strUserCode+"&htpInfosId="+vid+"&htpWidth="+vWidth+"&htpfontWith="+fontWith;
	var vpath="Indexset/IndexInfos.asp";

	//if(vid=="2") 
	//clearTimeout(newstime);
	
	XsendDate(vpath,vhtt);
	setTimeout("getIndexInfos('"+vid+"')",300000);
}
//读左菜单
function getLeftMenu(file){
	if(file==null)
	  file = 	"ioa_office" 
		//alert(file);
		//alert(file);
	var vhtt="htpUserCode="+strUserCode;
	var vpath="menu/menu.asp?file="+file;
	XsendDate(vpath,vhtt);
}

function InitMenu()
{
   //var obj = document.getElementById("economys");
   ///handleClick(obj);
   //JT_show("menu/main.htm?width=200","a_系统设置","")
}

function CreateMenu(str)
{
	//alert(str);
	//a=top.open("","","")
	//a.document.write(str)
	//selectedItem = null;
	document.getElementById("aMenu").openedSub = null; 
	top.document.all.aMenu.innerHTML=str;
        //InitMenu();
}
function getMoreInfos(vid){
	var strUrl="";
	switch(vid){
		case  "1":
			strUrl="message/message_search.asp";
			break;
		case  "2":
			strUrl="news/news_search.asp";
			break;		
		case  "3": //伙伴动态
			strUrl="indexset/indexMoreUserStates.asp";
			break;
		case  "4"://待阅更多
			strUrl="Visited/info_Search.asp";
			break;
		case  "5": //温馨提示
			return false;
			break;
		case  "6": //日历
			strUrl="calendar/cal_month.asp";
			break;
		case  "7":	//日程更多
			strUrl="calendar/cal_day.asp";
			break;
		case  "8":	//待办更多
			strUrl="indexset/indexNoWork.asp";	
			break;				
	}				
	openWin("",strUrl);

}

function getCallInfos(){
	openWin("未阅寻呼","indexset/indexNoRead.asp");
	top.window.focus();
}
function getErrorInfos(){

}
function getInfoMessages(){
openWin("待办信息","message/message_searchNew.asp");
}
function getInfoReads(){
openWin("待阅信息","Visited/info_Search.asp");
}
function getInfoApproves(){
openWin("待办信息","indexset/indexNoWork.asp");
}
function getInfoTasks(){
openWin("待办信息","task/task_search.asp");
}
function getInfoOnlines(){
openWin("在线人员","call/meetlistOnline.asp");
}
var NewsTitle="新闻";
var NewsDesc="发布和管理企业内部新闻。";

var MessagesTitle="通知";
var MessagesDesc="显示企业内部通知。";

var ReadsTitle="待阅";
var ReadsDesc="显示分发文件、借阅档案、建议、期刊、知识。";

var ApprovesTitle="待办";
var ApprovesDesc="显示任务、流程办理信息。";

var StatesTitle="伙伴动态";
var StatesDesc="显示同事外出、出差、休假动态。";

var GreetingsTitle="温馨提示";
var GreetingsDesc="显示问候语、格言、节日提醒，图书归还提醒以及同事、朋友的生日。";

var DatesTitle="日历";
var DatesDesc="显示日期和时间。";

CalendarsTitle="日程";
var CalendarsDesc="显示当天的事件安排。";

function getStates(){
	var str=""
	+"<table width=100% HEIGHT=100% border=0 cellpadding=0 cellspacing=0>"
	+"  <tr>"
	+"    <td valign=top>"

	+"	</td>"
	+"  </tr>"
	+"</table>";
	return str;
}

function getGreetings(){	
	var str=""
	+"<table width=100% HEIGHT=100% border=0 cellpadding=0 cellspacing=0>"
	+"  <tr>"
	+"    <td valign=top class=''>"
	+"	<span id=\"main2\" style=\"position:relative;width:100%;height:"+scrollerheight+";overflow:hiden;color:"+scrollerfontcolor+";background-color:"+scrollerbgcolor+"\">"
	+"	<div style=\"position:absolute;width:100%;height:"+scrollerheight+";clip:rect(0 "+scrollerwidth+" "+scrollerheight+" 0);left:0;top:0\">"
	+"	<div id=\"first2\" style=\"padding-left:6px;position:absolute;width:100%;left:0;top:1;\"></div>"
	+"  <div id=\"second2\" style=\"padding-left:6px;position:absolute;width:100%;left:0;top:0\"></div>"
	+"  </div>"
	+"  </span>"
	+"	</td>"
	+"  </tr>"
	+"</table>";	
	return str;
}

function getDates(){
	var str=""
	+"<table width=100% HEIGHT=100% border=0 cellpadding=0 cellspacing=0>"
	+"  <tr>"
	+"    <td class='weekWin' align=center valign=middle>"
	+getCalendar()
	//+"	·显示问候语、同事和好友生日，转正提醒、节日提醒。<br>"
	+"	</td>"
	+"  </tr>"
	+"</table>";
	return str;
}

var NowImg = 0;
var bStart = 0;
var bStop =0;
var newstime=null
function fnNewsImages() 
{
	var next = NowImg + 1;

	if(next == MaxImg+1) 
	{
		NowImg = MaxImg;
		next = 1;
	}
	
	if (MaxImg==1){
		bStop=1;
	}
	if(bStop!=1)
	{

		if(bStart == 0)
		{
			bStart = 1;		
			newstime=setTimeout("fnNewsImages()", 4000);
			return;
		}
		else
		{
			oTransContainer.filters[0].Apply();
			
			if(document.images['ni'+next]!=null)
				document.images['ni'+next].style.display = "";
				
			if(document.images['ni'+NowImg]!=null)
			document.images['ni'+NowImg].style.display = "none"; 
			
			oTransContainer.filters[0].Play(duration=2);

			if(NowImg == MaxImg) 
				NowImg = 1;
			else
				NowImg++;
		}
		newstime=setTimeout('fnNewsImages()', 4000);
	}
}


function changeNewsImages()
{
	var tmpNI = window.event.srcElement;
	if (tmpNI.tagName=="IMG")
	{
		bStop=1;
		
		for(var i=1;i<=MaxImg;i++){
			if(eval("ni"+i)!=null)
			eval("ni"+i).style.display = "none";
		}
		var tmpS=(tmpNI.id).substr(3,1);
		if(eval("ni"+tmpS)!=null)
		eval("ni"+tmpS).style.display = "";
	}
	bStop =0;
}
function funShowNews(vId){
	openWin("新闻查看","news/News_info.asp?id="+vId);
}
function funShowMsgs(vId){
	openWin("通知查看","message/message_query.asp?id="+vId);	
}
function funShowVisites(vUrl){
	openWin("待阅查看",vUrl);
}
function funShowCalendar(vUrl){
	openWin("日程查看",vUrl);
}
function funShowUserState(intID,strPath,Ismode)
{
	AttID=intID;
	if(Ismode==1)
	showModalDialog(strPath,window,"help:no;status:no");
	else
	top.openWin("",strPath) ;
}

function funShowWorks(vid,vtpe){
	var vUrl="";

	switch (vtpe)
	{
		case 0:
		vUrl="ihrm/dossier/dossierInfo.asp?httRegCode="+vid;
		break;
		case 1:
		vUrl="task/taskReport.asp?Task_ID="+vid;
		break;
		case 2:
		vUrl="task/taskPeruse.asp?Task_ID="+vid;
		break;		
		case 3:
		vUrl="approve/approve.asp?hidAppID="+vid;
		break;				
	}

	openWin("待办查看",vUrl);
	
}
var StatesInfo=getStates();
var GreetingsInfo=getGreetings();
var DatesInfo=getDates();//掉用显示日历

var popValidate = window.createPopup();
function showPopValidate(obj,str)
{
	var strBodyHtml="<div style=\"width:100%;height:60px;border:solid 1 #eeeeee;font-size:9pt;background:#ffffcc;padding:3pt;color:#ff0000\">"+str+"</div>"
	
	popValidate.document.body.innerHTML=strBodyHtml;
	var intWidth=obj.offsetWidth;
	if(intWidth<80) intWidth=80;
	popValidate.show(0,obj.offsetHeight,intWidth,60,obj);
	
}
function getcookie()
{

    if (document.cookie==null)
    {
        open("index.asp.htm","每日提示","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
    }
    else
    {
        var setTip = GetCookie('setTip');

        if( index ==null ) 
		open("index.asp.htm","每日提示","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
        else
        {
        	var date=new Date();
			var today=date.getYear()+"-"+date.getMonth()+"-"+date.getDate()

            if (setTip!= 'false'&&today!=GetCookie('today')) open("index.asp.htm","每日提示","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
         }   
    }
}

function GetCookie(sName)
{
	var aCookie = document.cookie.split("; ");
	for (var i=0; i < aCookie.length; i++)
	{
		var aCrumb = aCookie[i].split("=");
		if (sName == aCrumb[0])
		return unescape(aCrumb[1]);
	}
	return null;
}

function funShowAppraise(Apps_id)
{
//alert(考评);
	openWin("待办查看","ihrm/Appraise/Appraise_senior.asp?hid_Appsid="+Apps_id);
}
function funShowWorksface(){//预约面试
//alert("预约面试");
	openWin("待办查看","ihrm/zhaopin/resume_appointment.asp");
}
function funShowWorksface2(){//面试
//alert(面试);
	openWin("待办查看","ihrm/zhaopin/resume_View.asp");
}