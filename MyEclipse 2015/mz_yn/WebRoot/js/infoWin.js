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
			//idStateMsg.value="������ȡ����...";
		}
	}
	X.open('POST',vPath,true);
	X.setRequestHeader('Content-Type','application/x-www-form-urlencoded');		
	X.send(vhttValue);	
}
//�ر���Ϣ����
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
//��Ѱ��
function getNotRead(vUserCode){
	var vhtt="htpUserCode="+vUserCode;
	var vpath="indexset/IndexScanCall.asp";
	XsendDate(vpath,vhtt);
	//�޸��ˣ�  ���
	//�޸�ʱ�䣺2009-4-30
	//�޸����ݣ��޸�ˢ��ʱ��
	setTimeout("getNotRead('"+vUserCode+"')",5000);
}
//���ģ������

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
				case  "IOA_New"://��Ϣ
					if(parseInt(arrNotReadCount[i])>0){
						tmpPop=1;
						tmpNew=arrNotReadCount[i];
					}
					break;
				case  "IOA_Info"://����	
					NotRead1.innerText=parseInt(NotRead1.innerText)+parseInt(arrNotReadCount[i]);
					break;					
				case "IOA_Visited"://����
					NotRead2.innerText=arrNotReadCount[i];
					break;
				case "IOA_Message": //֪ͨ
					NotRead3.innerText=arrNotReadCount[i];
					break;	
				case "IOA_Work"://����
					NotRead4.innerText=arrNotReadCount[i];
					break;
				case "IOA_Online"://������Ա
					NotRead5.innerText=parseInt(arrNotReadCount[i]);	
					break;
				case "IOA_NewType"://��Ѱ������
					strNewType=arrNotReadCount[i];
					break;	
				case "IOA_Time": //ʱ��
					try{spanTime.innerText=arrNotReadCount[i];}catch(e){}
					break;
			}						
	}
	if(tmpPop==1){
		switch(strNewType){			
			case "IOA_Call":
				tmpNewType="Ѱ��";
				openNotRead("�����µ���Ϣ.","<img src='images/noseecall.gif'>",0);	
			break;
			case "IOA_Task":
				tmpNewType="����";			
				openNotRead("�����µ�����.","<img src='images/noseetask.gif'>",0);	
			break;
			case "IOA_Advise":
				tmpNewType="����";
				openNotRead("�����µĽ���.","<img src='images/noseeadvise.gif'>",0);				
			break;
			case "IOA_Approve":
				tmpNewType="����";
				openNotRead("�����µĴ���.","<img src='images/noseeapprove.gif'>",0);
			break;
			case "IOA_Calendar":
				tmpNewType="�ճ�";
				openNotRead("�����ŵ��ճ̵���.","<img src='images/noseecalendar.gif'>",0);
				break;
			//�޸��ˣ�Ԭ־��
			//�޸�ʱ�䣺2009.4.28
			//�޸����ݣ�������ŵȲ�����
			default:				
				tmpNewType="Ѱ��";
				openNotRead("�����µ���Ϣ.","<img src='images/noseecall.gif'>",0);	
				break;
			
		}
		//openNotRead("�����µ���Ϣ.",0,0)
		
	}
}
//ȡ��Ϣ
function getIndexInfos(vid){
	var vWidth=parseInt(eval("idconxMsg"+vid).style.width);
	var vhtt="htpUserCode="+strUserCode+"&htpInfosId="+vid+"&htpWidth="+vWidth+"&htpfontWith="+fontWith;
	var vpath="Indexset/IndexInfos.asp";

	//if(vid=="2") 
	//clearTimeout(newstime);
	
	XsendDate(vpath,vhtt);
	setTimeout("getIndexInfos('"+vid+"')",300000);
}
//����˵�
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
   //JT_show("menu/main.htm?width=200","a_ϵͳ����","")
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
		case  "3": //��鶯̬
			strUrl="indexset/indexMoreUserStates.asp";
			break;
		case  "4"://���ĸ���
			strUrl="Visited/info_Search.asp";
			break;
		case  "5": //��ܰ��ʾ
			return false;
			break;
		case  "6": //����
			strUrl="calendar/cal_month.asp";
			break;
		case  "7":	//�ճ̸���
			strUrl="calendar/cal_day.asp";
			break;
		case  "8":	//�������
			strUrl="indexset/indexNoWork.asp";	
			break;				
	}				
	openWin("",strUrl);

}

function getCallInfos(){
	openWin("δ��Ѱ��","indexset/indexNoRead.asp");
	top.window.focus();
}
function getErrorInfos(){

}
function getInfoMessages(){
openWin("������Ϣ","message/message_searchNew.asp");
}
function getInfoReads(){
openWin("������Ϣ","Visited/info_Search.asp");
}
function getInfoApproves(){
openWin("������Ϣ","indexset/indexNoWork.asp");
}
function getInfoTasks(){
openWin("������Ϣ","task/task_search.asp");
}
function getInfoOnlines(){
openWin("������Ա","call/meetlistOnline.asp");
}
var NewsTitle="����";
var NewsDesc="�����͹�����ҵ�ڲ����š�";

var MessagesTitle="֪ͨ";
var MessagesDesc="��ʾ��ҵ�ڲ�֪ͨ��";

var ReadsTitle="����";
var ReadsDesc="��ʾ�ַ��ļ������ĵ��������顢�ڿ���֪ʶ��";

var ApprovesTitle="����";
var ApprovesDesc="��ʾ�������̰�����Ϣ��";

var StatesTitle="��鶯̬";
var StatesDesc="��ʾͬ�����������ݼٶ�̬��";

var GreetingsTitle="��ܰ��ʾ";
var GreetingsDesc="��ʾ�ʺ�����ԡ��������ѣ�ͼ��黹�����Լ�ͬ�¡����ѵ����ա�";

var DatesTitle="����";
var DatesDesc="��ʾ���ں�ʱ�䡣";

CalendarsTitle="�ճ�";
var CalendarsDesc="��ʾ������¼����š�";

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
	//+"	����ʾ�ʺ��ͬ�ºͺ������գ�ת�����ѡ��������ѡ�<br>"
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
	openWin("���Ų鿴","news/News_info.asp?id="+vId);
}
function funShowMsgs(vId){
	openWin("֪ͨ�鿴","message/message_query.asp?id="+vId);	
}
function funShowVisites(vUrl){
	openWin("���Ĳ鿴",vUrl);
}
function funShowCalendar(vUrl){
	openWin("�ճ̲鿴",vUrl);
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

	openWin("����鿴",vUrl);
	
}
var StatesInfo=getStates();
var GreetingsInfo=getGreetings();
var DatesInfo=getDates();//������ʾ����

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
        open("index.asp.htm","ÿ����ʾ","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
    }
    else
    {
        var setTip = GetCookie('setTip');

        if( index ==null ) 
		open("index.asp.htm","ÿ����ʾ","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
        else
        {
        	var date=new Date();
			var today=date.getYear()+"-"+date.getMonth()+"-"+date.getDate()

            if (setTip!= 'false'&&today!=GetCookie('today')) open("index.asp.htm","ÿ����ʾ","width=500,height=285,left="+(screen.width-500)/2+",top="+(screen.height-290)/2);
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
//alert(����);
	openWin("����鿴","ihrm/Appraise/Appraise_senior.asp?hid_Appsid="+Apps_id);
}
function funShowWorksface(){//ԤԼ����
//alert("ԤԼ����");
	openWin("����鿴","ihrm/zhaopin/resume_appointment.asp");
}
function funShowWorksface2(){//����
//alert(����);
	openWin("����鿴","ihrm/zhaopin/resume_View.asp");
}