<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.ninemax.nacao.business.publishInfo.clsPublishInfoBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.nacao.business.website.clsWebSiteBus" %>
<%@ page import="com.ninemax.nacao.to.publishInfo.clsNewsChildType" %>
<%@ page import="com.ninemax.nacao.to.system.clsRightKeyTO" %>
<%@ page import="com.ninemax.nacao.to.system.clsSysUserTO" %>
<%@ page import="com.ninemax.nacao.util.clsStringTool" %>
<%@ page import="java.util.ArrayList" %>

<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

String parentId = request.getParameter("parentId");
String parentName = request.getParameter("parentName");
if(parentId == null){
	parentId = "02";
	parentName = "系统";
}
clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");
clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
clsPublishInfoBus publishInfoBus = new clsPublishInfoBus();
clsRightKeyBus rightKeyBus = new clsRightKeyBus();
ArrayList rightKeys = rightKeyBus.ListFirstRight(parentId);
String web_id = sysuser.getItem1();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<script type="text/javascript" src="js/ken_menu.js"></script>
<script type="text/javascript">
// <![CDATA[
var myMenu;
window.onload = function() {
		try{
			myMenu = new SDMenu("my_menu");
			myMenu.init();
			myMenu.oneSmOnly =  true;
		}catch(e){
			setTimeout("loading()", 3000);
		}
};
function loading(){
		myMenu = new SDMenu("my_menu");
		myMenu.init();
		myMenu.oneSmOnly =  true;
	}
function changeClass(obj){
 for(var i=0;i<document.getElementsByName("hrefs").length;i++){
  document.getElementsByName("hrefs")[i].className="menu_off";
 }
 obj.className="menu_on";
}
// ]]>

function showSub(index,length){
   
  /* for(var i=0;i<length;i++){
	   if(document.getElementById("subdiv"+i)&&i!=index){
	    document.getElementById("subdiv"+i).style.display="none";
	   }
   }*/
   var status=document.getElementById("subdiv"+index).style.display;
	if(status=="none"){
		document.getElementById("subdiv"+index).style.display="block";
     }else{
		document.getElementById("subdiv"+index).style.display="none";
     }
}
function killerrors() { 
return true; 
} 
window.onerror = killerrors; 
</script>
<title>中国环境监测总站业务管理系统</title>
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
body {
	background-color: #f1fafe;
	background-image: url(img/left_bj.gif);
	background-repeat: repeat-y;
	background-position: right;
}
-->
</style>
<link href="css/systel.css" rel="stylesheet" type="text/css" />
</head>
<body scrolling=no>

<div id="left_main">
  <div style="float: left" id="my_menu" class="sdmenu">
  
  <%
if(rightKeys!=null && rightKeys.size()>0){
    
    for(int index=0;index<rightKeys.size();index++){
	    
		clsRightKeyTO rightKeyTO = (clsRightKeyTO)rightKeys.get(index);
		
		String rightKeyId = rightKeyTO.getRightKey_id();
		String level = rightKeyTO.getRightKey_depth();
		String pictrue = rightKeyTO.getPictrue();
		String linkPage = rightKeyTO.getLinkPage();
		String title = rightKeyTO.getRightKey_name();
		if(clsStringTool.isEmpty(linkPage)){
		    linkPage="";
		}	
		if(userRightKeyBus.HasRight(sysuser.getUser_id(),rightKeyId)){ //如果有权限才显示	
			ArrayList child_rightKeys = rightKeyBus.ListFirstRight(rightKeyId);//子类型
			if(child_rightKeys!=null && child_rightKeys.size()>0){
				//有子节点
				%>
				   <div  class="collapsed"> 
						<span><%=title%></span> 
				 
				<%
				if(web_id.equals("totalWebSite")){
				//循环子节点
				for(int child_index=0;child_index<child_rightKeys.size();child_index++){
			
					clsRightKeyTO child_rightKeyTO = (clsRightKeyTO)child_rightKeys.get(child_index);
					
					String child_rightKeyId = child_rightKeyTO.getRightKey_id();
					String child_level = child_rightKeyTO.getRightKey_depth();
					String child_pictrue = child_rightKeyTO.getPictrue();
					String child_linkPage = child_rightKeyTO.getLinkPage();
					String child_title = child_rightKeyTO.getRightKey_name();
					String channelName="";
					if(clsStringTool.isEmpty(child_linkPage)){
						child_linkPage="";
					}
					if(userRightKeyBus.HasRight(sysuser.getUser_id(),child_rightKeyId)){ //如果有权限才显示	
					String temp="";
					if(title.equals("信息发布")){
					
					     channelName=publishInfoBus.getChannelNameByUnitName(child_title,web_id);
						 if(clsStringTool.isEmpty(channelName)){
						channelName="其他";
					    }
						channelName="["+channelName+"] ";
							if(child_title.length()>6){
							temp=child_title.substring(0,6);
						}else{
							temp=child_title;
						}
					}else{
					temp=child_title;
					}
						
						%>
						
						<a href="<%=child_linkPage%>" onclick="changeClass(this);showSub('<%=child_index%>',<%=child_rightKeys.size()%>);" name="hrefs" target="kunFrame" title="<%=child_title%>"><%=channelName%><%=temp%> </a>
                        
						<% ArrayList listsub =publishInfoBus.listChildType(child_title,web_id); 
						String getunit_id=child_linkPage.substring(child_linkPage.indexOf("unit_id=")+"unit_id=".length());
										
									if(listsub.size() >0 && listsub != null){
										out.print("<ul id='subdiv"+child_index+"' style='display:none;'>");
										for(int i=0;i<listsub.size();i++){
											clsNewsChildType  childType = new clsNewsChildType();
											childType = (clsNewsChildType)listsub.get(i);
											String child_id = childType.getId();
											String child_type = childType.getChild_type();
							%>
							<a href="/manageweb/publishInfo/commonInfo/listChildNotice.jsp?child_type=<%=child_id%>&unit_id=<%=getunit_id%>" style="color:#336; font-size:11px; font-family:Tahoma, 微软雅黑, 宋体; background-color:#f1fafe; overflow:hidden; background-image:none" title="<%=child_type%>" target="kunFrame" >&nbsp;<%=child_type%></a>
							<%
									}
									out.print("</ul>");
								}
							%>
                        
						<%
					}
				  }
			     }else{
				   if(title.equals("信息发布")){
				      clsWebSiteBus siteBus = new clsWebSiteBus();
				     child_rightKeys = siteBus.getWebSiteUnitByWebSite(web_id);
					 for(int child_index=0;child_index<child_rightKeys.size();child_index++){
					 clsRightKeyTO child_rightKeyTO = (clsRightKeyTO)child_rightKeys.get(child_index);
					 String child_title = child_rightKeyTO.getRightKey_name();
					 String child_linkPage = child_rightKeyTO.getLinkPage();
					 String channelName="";
					 channelName=publishInfoBus.getChannelNameByUnitName(child_title,web_id);
						 if(clsStringTool.isEmpty(channelName)){
						channelName="其他";
					    }
					 %>
						
						<a href="/manageweb/publishInfo/commonInfo/listNotice.jsp?unit_id=<%=child_linkPage%>" onclick="changeClass(this);showSub('<%=child_index%>',<%=child_rightKeys.size()%>);" name="hrefs" target="kunFrame" style="overflow:hidden;" title="<%=child_title%>"><%=child_title%> </a>
                        
                        <% ArrayList listsub =publishInfoBus.listChildType(child_title,web_id); 
										
									if(listsub.size() >0 && listsub != null){
										out.print("<ul id='subdiv"+child_index+"' style='display:none;'>");
										for(int i=0;i<listsub.size();i++){
											clsNewsChildType  childType = new clsNewsChildType();
											childType = (clsNewsChildType)listsub.get(i);
											String child_id = childType.getId();
											String child_type = childType.getChild_type();
							%>
							<a href="/manageweb/publishInfo/commonInfo/listChildNotice.jsp?child_type=<%=child_id%>&unit_id=<%=child_linkPage%>" style="color:#336; font-size:11px; font-family:Tahoma, 微软雅黑, 宋体; background-color:#f1fafe; overflow:hidden; background-image:none" title="<%=child_type%>" target="kunFrame" >&nbsp;<%=child_type%></a>
							<%
									}
									out.print("</ul>");
								}
							%>
                        
                        
						<%
						}
				    
				   }else{
				    for(int child_index=0;child_index<child_rightKeys.size();child_index++){
			
					clsRightKeyTO child_rightKeyTO = (clsRightKeyTO)child_rightKeys.get(child_index);
					
					String child_rightKeyId = child_rightKeyTO.getRightKey_id();
					String child_level = child_rightKeyTO.getRightKey_depth();
					String child_pictrue = child_rightKeyTO.getPictrue();
					String child_linkPage = child_rightKeyTO.getLinkPage();
					String child_title = child_rightKeyTO.getRightKey_name();
					if(clsStringTool.isEmpty(child_linkPage)){
						child_linkPage="";
					}
					if(userRightKeyBus.HasRight(sysuser.getUser_id(),child_rightKeyId)){ //如果有权限才显示	
						%>
						
						<a href="<%=child_linkPage%>" onclick="changeClass(this);" name="hrefs" target="kunFrame"><%=child_title%> </a>
						<%
					}
				  }
				    
				   
				   
				   }
				 
				}
				%>
				</div>
				<%
			}else{
				//没有子节点
				if(web_id.equals("totalWebSite")||(!web_id.equals("totalWebSite")&&!title.equals("建立分站点"))){
				%>
					<div class="collapsed"> 
						<span > <%=title%></span> 
						<a href="<%=linkPage%>" target="kunFrame"> <%=title%> </a>
					</div>
				<%
				}
			}
		}
	}
	
}%>	
    
  </div>
<!--      <div class="box_left">
      <div class="box_left_top">客服中心</div>
      <div class="box_kehu">
	  	总机：010-<br />&nbsp;010-<br />
        传真：010-<br />
        E-mail:</div>
    </div>-->
  <div class="clear"></div>
</div>
  </body>
</html>
