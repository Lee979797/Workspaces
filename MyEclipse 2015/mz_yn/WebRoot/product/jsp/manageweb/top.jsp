<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.nacao.business.group.BaseGroupSortFacade" %>
<%@ page import="com.ninemax.nacao.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsUserBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.nacao.business.website.clsWebSiteBus" %>
<%@ page import="com.ninemax.nacao.to.system.clsRightKeyTO" %>
<%@ page import="com.ninemax.nacao.to.system.clsSysUserTO" %>
<%@ page import="com.ninemax.nacao.to.system.clsUserTO" %>
<%@ page import="com.ninemax.nacao.to.website.clsWebSiteTO" %>
<%@ page import="com.ninemax.nacao.util.clsStringTool"%>
<%@ page import="java.util.ArrayList" %>
<%
clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");
String username = sysuser.getUser_name();
clsUserBus userBus = new clsUserBus();
clsUserTO userTO = userBus.FindUserById(sysuser.getUser_id());
String user_kind = userTO.getUser_kind(); 
clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
clsRightKeyBus rightKeyBus = new clsRightKeyBus();
ArrayList rightKeys = rightKeyBus.ListFirstRight("0");
String web_id = sysuser.getItem1();

String user_chinessName = userTO.getUser_chineseName();

if(user_chinessName.getBytes().length > 22){
	user_chinessName = clsStringTool.bSubstring(user_chinessName,20)+"..";//最多显示15个字
}

String user_branch = userTO.getUser_branch();
BaseGroupSortFacade groupSortFacade = new BaseGroupSortFacade();
//CachedRowSet crs = groupSortFacade.getGroupName(user_branch);
String group_name = "";
//while(crs.next())
//{
//	 group_name = crs.getString("group_name");
//}

%>
 <%
							ArrayList webSites = new clsWebSiteBus().getWebSiteList();
                            String user_webSite_name = "主站";
							if(webSites !=null){
								for(int i = 0;i<webSites.size();i++){
									clsWebSiteTO to = (clsWebSiteTO)webSites.get(i);
									String user_webSite_id = to.getWebsite_id();

									%>
										<%if(user_webSite_id.equals(web_id)){user_webSite_name='to'.getWebsite_name();break;}%>
									<%
								}
							}
%>		
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>top</title>
<link href="css/systel.css" rel="stylesheet" type="text/css" />
<SCRIPT language=JavaScript src="/js/tools.js"></SCRIPT>
<SCRIPT language=JavaScript src="/manageweb/js/ajax_left.js"></SCRIPT>

<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<script type="text/javascript">

var topSize = null;
function changeStyle(topnum){
	
	for(var i =0;i<topSize;i++){
		if(i == topnum){
			document.getElementById("top_"+i).className = "hei";
		}else{
			document.getElementById("top_"+i).className = "";
		}
	}
}

function openthisWindow(num,id,title,rightUrl)
{
	
	changeStyle(num);
	if(id != null && id != "" && id != "null"){
	  window.open("left.jsp?parentId="+id+"&parentName="+title,"leftFrame","");
	  window.open("right.jsp?parentName="+title,"kunFrame","");
	}else{
	 window.open("left.html","leftFrame","");
	 window.open("right.jsp","kunFrame","");
	}
	
}

function logOut(){
	if(confirm("确认退出本系统？")){
		//UtilBus.logout();
		window.parent.location.href = '/servlet/sysUserAction?actions=exit';
		//先关闭框架页面， 再打开新的页面。
		window.parent.location.href = 'http://'+window.location.host+"/manageweb/login.jsp";
	}
}
function logOutToPortal(){
	if(confirm("确认退出本系统？")){
		//UtilBus.logout();
		window.parent.location.href = '/servlet/sysUserAction?actions=exit';
		//先关闭框架页面， 再打开新的页面。
		window.parent.location.href = 'http://'+window.location.host+"/";
	}
}

function restoreSession(realSessionWebId){
 AjaxSilence("/manageweb/left_restoreSeeion.jsp?realSession="+realSessionWebId);
 window.parent.location.reload()
}
</script>
</head>

<body onload="MM_preloadImages('images/btn_mybbs1.gif','images/btn_myxinxi1.gif')">
<div id="heder">
  <div class="heder_top">
  <div class="logo"></div>
    <div class="heder_right">
      <div class="heder_icon">
      <span class="icon_sky"><a href="#" onclick="logOut()">重新登录</a></span>
      <span class="icon_quit"><a href="#" onclick="logOutToPortal()">退出</a></span>
      </div>
    </div>
  </div>

  <div class="heder_menu">
  <ul id="mainMenu">
  <li><a href="#" onclick="openthisWindow('0','','首页','right.jsp')" id="top_0" onclick="changeStyle('0')" class="hei"> <span class="l"></span> <span class="c">首页</span> <span class="r"></span> </a> </li>
<!--  <li class="heder_menu_on"><a href="#"   style="color:#2a79be">消息管理</a></li> -->
  
  <%
if(rightKeys!=null && rightKeys.size()>0){
    int topNum = 1;
    for(int index=0;index<rightKeys.size();index++){
	    
		clsRightKeyTO rightKeyTO = (clsRightKeyTO)rightKeys.get(index);
		
		String rightKeyId = rightKeyTO.getRightKey_id();
		String level = rightKeyTO.getRightKey_depth();
		String pictrue = "menu/"+rightKeyTO.getPictrue();
		String linkPage = rightKeyTO.getLinkPage();
		String title = rightKeyTO.getRightKey_name();
		if(title.equals("网站群管理")){
		 if(!web_id.equals("totalWebSite")){
	      title="站点管理";
         }
		}
		
		
	    String levelSy = "";
		String isOpen = "";
		String pageTarget = "rightFrame"; 
		int fKeyId=0; 
		if("1".equals(level)){  
			if(userRightKeyBus.HasRight(sysuser.getUser_id(),rightKeyId)){ //如果有权限才显示  
			fKeyId = Integer.parseInt(rightKeyId);
			 if(fKeyId<20||fKeyId==30){
	%>	
         
		  <li> <a href="#" onclick="openthisWindow('<%=topNum%>','<%=rightKeyId%>','<%=title%>','<%=linkPage%>')"   id="top_<%=topNum%>"> <span class="l"></span> <span class="c"><%=title %></span> <span class="r"></span> </a> </li>
		 
	 <% 
	 			topNum ++ ;
	 		}
	 		
			}
		
		}
		
	
	}
	%>
	<script type="text/javascript">topSize = '<%=topNum%>';</script>
	<%
}
%>	  
	  
	 </ul>
  
  <div class="heder_menu_right">
          <ul>
          <%
		  boolean canManageAllSites =  userRightKeyBus.HasRight(sysuser.getUser_id(),"05020104");
		  if(canManageAllSites){
		  %>
          <li>站点：<select onchange="restoreSession(this.value)" style="height:18px; line-height:30px;">
                        <option value="totalWebSite">主站</option>
                        <%
							if(webSites !=null){
								for(int i = 0;i<webSites.size();i++){
									clsWebSiteTO to = (clsWebSiteTO)webSites.get(i);
									String webSite_name = to.getWebsite_name();
									String webSite_id = to.getWebsite_id();
									
									%>
										<option value="<%=webSite_id%>" <%if(web_id.equals(webSite_id)){out.println("selected");}%>><%=webSite_name%></option>
									<%
								}
							}
						%>		
                        </select></li> 
        <%}%> 
        <li>您好，<%=user_chinessName%></b>&nbsp;<%=user_webSite_name%>&nbsp;<span id="_date"></span></li><li>&nbsp;</li></ul>
	</div>
  
  </div>
</div>
</body>
<script type="text/javascript">
function getDate(){
 document.getElementById("_date").innerHTML=getChineseDate();
}
getDate();
</script>
</html>
