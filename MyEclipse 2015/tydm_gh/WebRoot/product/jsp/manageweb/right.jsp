<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.nacao.business.system.StatisticsBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsSysUserLoginLogBus" %>
<%@ page import="com.ninemax.nacao.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.nacao.to.system.clsSysUserTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.StringTokenizer" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>中国环境监测总站外网信息发布系统</title>
    <link href="css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/manageweb/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/manageweb/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/PublishInfoBus.js'></script>
    <script type='text/javascript' src='/dwr/interface/ChannelBus.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript">

        var shareChannelNum = null;
        var shareNewsNum = null;

        function getShareChannelNum() {
            DWREngine.setAsync(false);
            ChannelBus.waitingSharingChannels(getChannelNum);
            DWREngine.setAsync(true);
        }
        function getChannelNum(data) {
            if (data != null) {

                shareChannelNum = data.length;
            }
        }
        function getShareNewsNum() {
            DWREngine.setAsync(false);
            PublishInfoBus.waitingSharingNews(getNewsNum);
            DWREngine.setAsync(true);
        }
        function getNewsNum(data) {
            if (data != null) {

                shareNewsNum = data.length;
            }
        }


        function aa() {
            ymPrompt.win('sysuser/modPassword.jsp', 400, 200, '密码修改', null, null, null, {id:'a'})
        }
    </script>
    <style type="text/css">
        <!--
        body {

            background-color: #fff;
        }

        a:link {
            color: #425ca3;
        }

        a:hover {
            color: #000;
        }

        a:visited {
            color: #425ca3;
        }

        -->
    </style>
</head>
<%
clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");

String userName = sysuser.getUser_name();
String c_userid = sysuser.getUser_id();

String agent = request.getHeader("user-agent"); 
StringTokenizer st = new StringTokenizer(agent,";"); 
st.nextToken(); 
//得到用户的浏览器名 
String userbrowser = "";
try{
userbrowser = st.nextToken(); 
}catch(Exception e){
	userbrowser="unkonwn";
}
//得到用户的操作系统名 
String useros =""; 
try{
useros = st.nextToken(); 
}catch(Exception e){
	useros="unkonwn";
}
  
//权限
clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
boolean canBBS =  userRightKeyBus.HasRight(sysuser.getUser_id(),"0604");
boolean canFile =  userRightKeyBus.HasRight(sysuser.getUser_id(),"0901");
boolean canWatchNews =  userRightKeyBus.HasRight(sysuser.getUser_id(),"070702");
boolean canChannel =  userRightKeyBus.HasRight(sysuser.getUser_id(),"0204");
boolean canUnit =  userRightKeyBus.HasRight(sysuser.getUser_id(),"0202");
boolean canEditTemplate =  userRightKeyBus.HasRight(sysuser.getUser_id(),"020301");


boolean canLineMess =  userRightKeyBus.HasRight(sysuser.getUser_id(),"0115");
boolean canRegUser =  userRightKeyBus.HasRight(sysuser.getUser_id(),"011009");
boolean canSysUser =  userRightKeyBus.HasRight(sysuser.getUser_id(),"011008");
boolean canRole =  userRightKeyBus.HasRight(sysuser.getUser_id(),"011003");
boolean canGroup =  userRightKeyBus.HasRight(sysuser.getUser_id(),"011002");
boolean canDepartMent =  userRightKeyBus.HasRight(sysuser.getUser_id(),"011010");

clsSysUserLoginLogBus userLoginLogBus = new clsSysUserLoginLogBus();

//最近操作记录
ArrayList sysUserLoginLogs = userLoginLogBus.controlPanelList(c_userid);

//数据统计
StatisticsBus statisticsBus = new StatisticsBus();
String newsNum = statisticsBus.getNewNumber();
String documentsNum = statisticsBus.getDocumentsNumber("doc");
String softwareNum = statisticsBus.getDocumentsNumber("soft");

//在线人数
ArrayList showList = (ArrayList)(getServletContext().getAttribute("list")); 
int show = 0;
if(showList!=null&& showList.size()>0){
	show = showList.size();
}
%>
<body scroll="no">
<div class="home_topbj">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td><div class="home_topleft"></div></td>
      <td><div class="home_topright"></div></td>
    </tr>
  </table>
  </div>
<div class="home_main_icon">
  <!--
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <%if(canBBS){%>
	  <td align="center"><a href="webSite/newWebSite.jsp"><img src="images/home_icon_11.gif" width="35" height="35" title="论坛管理" /></a></td>
      <%}%>
	  <%if(canFile){%>
	  <td align="center"><a href="webSite/manageWebSite.jsp"><img src="images/home_icon_7.gif" width="35" height="35" title="文档管理"/></a></td>
      <%}%>
	  <%if(canChannel){%>
	  <td align="center"><a href="portal/systemLayout.htm"><img src="images/home_icon_3.gif" width="35" height="35" title="频道管理"/></a></td>
      <%}%>
	  <%if(canEditTemplate){%>
	  <td align="center"><a href="crm/channel.jsp"><img src="images/home_icon_4.gif" width="35" height="35" title="模板管理"/></a></td>
	  <%}%>
	  <%if(canUnit){%>
	  <td align="center"><a href="portal/unitList.jsp"><img src="images/home_icon_9.gif" width="35" height="35" title="栏目管理"/></a></td>
      <%}%>
	  <%if(canWatchNews){%>
	  <td align="center"><a href="portal/template/index.jsp"><img src="images/home_icon_8.gif" width="35" height="35" title="采集信息管理"/></a></td>
     <%}%>
    </tr>
    <tr>
	  <%if(canBBS){%>
      <td align="center"><a href="webSite/newWebSite.jsp">论坛管理</a></td>
       <%}%>
	  <%if(canFile){%>
	  <td align="center"><a href="webSite/manageWebSite.jsp">文档管理</a></td>
      <%}%>
	  <%if(canChannel){%>
	  <td align="center"><a href="portal/systemLayout.htm">频道管理</a></td>
       <%}%>
	  <%if(canEditTemplate){%>
	  <td align="center"><a href="crm/channel.jsp">模板管理</a></td>
      <%}%>
	  <%if(canUnit){%>
	  <td align="center"><a href="portal/unitList.jsp">栏目管理</a></td>
	  <%}%>
	  <%if(canWatchNews){%>
	  <td align="center"><a href="portal/template/index.jsp">采集信息管理</a></td>
      <%}%>
    </tr>
    <tr>
	  <%if(canLineMess){%>
	 <td align="center"><a href="publishInfo/news/listNotice.jsp?type=1"><img src="images/home_icon_6.gif" width="35" height="35" title="业务咨询"/></a></td>
      <%}%>
	  <%if(canRegUser){%>  
	  <td align="center"><a href="publishInfo/locationNotice/listNotice.jsp?type=2"><img src="images/home_icon_2.gif" width="35" height="35" title="注册用户管理"/></a></td>
       <%}%>
	   <%if(canSysUser){%>  
	  <td align="center"><a href="publishInfo/industryNotice/listNotice.jsp?type=3"><img src="images/home_icon_5.gif" width="35" height="35" title="系统用户管理"/></a></td>  
      <%}%>
	  <%if(canRole){%>
	  <td align="center"><a href="/vote/voteservlet?method=vote_select"><img src="images/home_icon_10.gif" width="35" height="35" title="角色管理"/></a></td>
      <%}%>
	  <%if(canGroup){%>
	  <td align="center"><a href="crm/remarkList.jsp"><img src="images/home_icon_1.gif" width="35" height="35" title="用户组管理"/></a></td>
      <%}%>
	  <%if(canDepartMent){%>
	  <td align="center"><a href="crm/adManage.jsp"><img src="images/home_icon_12.gif" width="35" height="35" title="部门管理"/></a></td>
      <%}%>
	</tr>
    <tr> 
	   <%if(canLineMess){%>
       <td align="center"><a href="publishInfo/news/listNotice.jsp?type=1">业务咨询</a></td>
	   <%}%>
	  <%if(canRegUser){%> 
	  <td align="center"><a href="publishInfo/locationNotice/listNotice.jsp?type=2">注册用户管理</a></td>
      <%}%>
	   <%if(canSysUser){%>
	  <td align="center"><a href="publishInfo/industryNotice/listNotice.jsp?type=3">系统用户管理</a></td>   
      <%}%>
	  <%if(canRole){%>
	  <td align="center"><a href="/vote/voteservlet?method=vote_select">角色管理</a></td>
      <%}%>
	  <%if(canGroup){%>
	  <td align="center"><a href="crm/remarkList.jsp">用户组管理</a></td>
       <%}%>
	  <%if(canDepartMent){%>
	  <td align="center"><a href="crm/adManage.jsp">部门管理</a></td>
	   <%}%>
    </tr>
  </table>
  -->
</div>
<div class="home_footer">
  <table width="100%" border="0" cellpadding="0" cellspacing="5">
    <tr>
      <td><div class="home_footer_box">
        <h1>系统属性</h1>
        <ul><li>程序版本：九瑞内容管理平台 V3.9</li>
        <li>用户：<%=userName%> [<a href="#" onclick="javascript:return false;aa()" title="点击修改密码" disabled>修改密码</a>]</li>
		<li>操作系统版本：<%=useros%></li>
        <li>浏览器类型：<%=userbrowser%> </li>
        <li>JAVA运行环境：Java(TM) SE Runtime Envionment 1.6.0_05-b13 </li>
        </ul>
        </div></td>
      <!--
      <td><div class="home_footer_box">
        <h1>数据统计</h1>
        <ul>
			
			<li style="width: 340px;">新闻数量：&nbsp;<font color="#6699FF" style="font-weight:800"><%=newsNum%></font>&nbsp;条&nbsp;</li>
			<li style="width: 340px;">文档数量：&nbsp;<font color="#6699FF" style="font-weight:800"><%=documentsNum%></font>&nbsp;个&nbsp;</li>
			<li style="width: 340px;">软件数量：&nbsp;<font color="#6699FF" style="font-weight:800"><%=softwareNum%></font>&nbsp;个&nbsp;</li>
			<li style="width: 340px;">在线用户：&nbsp;<font color="#6699FF" style="font-weight:800"><%=show%></font>&nbsp;人&nbsp;</li>
		
          </ul>
        </div></td>-->
    </tr>
  </table>
</div>
</body>
</html>
