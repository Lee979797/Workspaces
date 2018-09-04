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
    <title>�й����������վ������Ϣ����ϵͳ</title>
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
            ymPrompt.win('sysuser/modPassword.jsp', 400, 200, '�����޸�', null, null, null, {id:'a'})
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
//�õ��û���������� 
String userbrowser = "";
try{
userbrowser = st.nextToken(); 
}catch(Exception e){
	userbrowser="unkonwn";
}
//�õ��û��Ĳ���ϵͳ�� 
String useros =""; 
try{
useros = st.nextToken(); 
}catch(Exception e){
	useros="unkonwn";
}
  
//Ȩ��
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

//���������¼
ArrayList sysUserLoginLogs = userLoginLogBus.controlPanelList(c_userid);

//����ͳ��
StatisticsBus statisticsBus = new StatisticsBus();
String newsNum = statisticsBus.getNewNumber();
String documentsNum = statisticsBus.getDocumentsNumber("doc");
String softwareNum = statisticsBus.getDocumentsNumber("soft");

//��������
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
	  <td align="center"><a href="webSite/newWebSite.jsp"><img src="images/home_icon_11.gif" width="35" height="35" title="��̳����" /></a></td>
      <%}%>
	  <%if(canFile){%>
	  <td align="center"><a href="webSite/manageWebSite.jsp"><img src="images/home_icon_7.gif" width="35" height="35" title="�ĵ�����"/></a></td>
      <%}%>
	  <%if(canChannel){%>
	  <td align="center"><a href="portal/systemLayout.htm"><img src="images/home_icon_3.gif" width="35" height="35" title="Ƶ������"/></a></td>
      <%}%>
	  <%if(canEditTemplate){%>
	  <td align="center"><a href="crm/channel.jsp"><img src="images/home_icon_4.gif" width="35" height="35" title="ģ�����"/></a></td>
	  <%}%>
	  <%if(canUnit){%>
	  <td align="center"><a href="portal/unitList.jsp"><img src="images/home_icon_9.gif" width="35" height="35" title="��Ŀ����"/></a></td>
      <%}%>
	  <%if(canWatchNews){%>
	  <td align="center"><a href="portal/template/index.jsp"><img src="images/home_icon_8.gif" width="35" height="35" title="�ɼ���Ϣ����"/></a></td>
     <%}%>
    </tr>
    <tr>
	  <%if(canBBS){%>
      <td align="center"><a href="webSite/newWebSite.jsp">��̳����</a></td>
       <%}%>
	  <%if(canFile){%>
	  <td align="center"><a href="webSite/manageWebSite.jsp">�ĵ�����</a></td>
      <%}%>
	  <%if(canChannel){%>
	  <td align="center"><a href="portal/systemLayout.htm">Ƶ������</a></td>
       <%}%>
	  <%if(canEditTemplate){%>
	  <td align="center"><a href="crm/channel.jsp">ģ�����</a></td>
      <%}%>
	  <%if(canUnit){%>
	  <td align="center"><a href="portal/unitList.jsp">��Ŀ����</a></td>
	  <%}%>
	  <%if(canWatchNews){%>
	  <td align="center"><a href="portal/template/index.jsp">�ɼ���Ϣ����</a></td>
      <%}%>
    </tr>
    <tr>
	  <%if(canLineMess){%>
	 <td align="center"><a href="publishInfo/news/listNotice.jsp?type=1"><img src="images/home_icon_6.gif" width="35" height="35" title="ҵ����ѯ"/></a></td>
      <%}%>
	  <%if(canRegUser){%>  
	  <td align="center"><a href="publishInfo/locationNotice/listNotice.jsp?type=2"><img src="images/home_icon_2.gif" width="35" height="35" title="ע���û�����"/></a></td>
       <%}%>
	   <%if(canSysUser){%>  
	  <td align="center"><a href="publishInfo/industryNotice/listNotice.jsp?type=3"><img src="images/home_icon_5.gif" width="35" height="35" title="ϵͳ�û�����"/></a></td>  
      <%}%>
	  <%if(canRole){%>
	  <td align="center"><a href="/vote/voteservlet?method=vote_select"><img src="images/home_icon_10.gif" width="35" height="35" title="��ɫ����"/></a></td>
      <%}%>
	  <%if(canGroup){%>
	  <td align="center"><a href="crm/remarkList.jsp"><img src="images/home_icon_1.gif" width="35" height="35" title="�û������"/></a></td>
      <%}%>
	  <%if(canDepartMent){%>
	  <td align="center"><a href="crm/adManage.jsp"><img src="images/home_icon_12.gif" width="35" height="35" title="���Ź���"/></a></td>
      <%}%>
	</tr>
    <tr> 
	   <%if(canLineMess){%>
       <td align="center"><a href="publishInfo/news/listNotice.jsp?type=1">ҵ����ѯ</a></td>
	   <%}%>
	  <%if(canRegUser){%> 
	  <td align="center"><a href="publishInfo/locationNotice/listNotice.jsp?type=2">ע���û�����</a></td>
      <%}%>
	   <%if(canSysUser){%>
	  <td align="center"><a href="publishInfo/industryNotice/listNotice.jsp?type=3">ϵͳ�û�����</a></td>   
      <%}%>
	  <%if(canRole){%>
	  <td align="center"><a href="/vote/voteservlet?method=vote_select">��ɫ����</a></td>
      <%}%>
	  <%if(canGroup){%>
	  <td align="center"><a href="crm/remarkList.jsp">�û������</a></td>
       <%}%>
	  <%if(canDepartMent){%>
	  <td align="center"><a href="crm/adManage.jsp">���Ź���</a></td>
	   <%}%>
    </tr>
  </table>
  -->
</div>
<div class="home_footer">
  <table width="100%" border="0" cellpadding="0" cellspacing="5">
    <tr>
      <td><div class="home_footer_box">
        <h1>ϵͳ����</h1>
        <ul><li>����汾���������ݹ���ƽ̨ V3.9</li>
        <li>�û���<%=userName%> [<a href="#" onclick="javascript:return false;aa()" title="����޸�����" disabled>�޸�����</a>]</li>
		<li>����ϵͳ�汾��<%=useros%></li>
        <li>��������ͣ�<%=userbrowser%> </li>
        <li>JAVA���л�����Java(TM) SE Runtime Envionment 1.6.0_05-b13 </li>
        </ul>
        </div></td>
      <!--
      <td><div class="home_footer_box">
        <h1>����ͳ��</h1>
        <ul>
			
			<li style="width: 340px;">����������&nbsp;<font color="#6699FF" style="font-weight:800"><%=newsNum%></font>&nbsp;��&nbsp;</li>
			<li style="width: 340px;">�ĵ�������&nbsp;<font color="#6699FF" style="font-weight:800"><%=documentsNum%></font>&nbsp;��&nbsp;</li>
			<li style="width: 340px;">���������&nbsp;<font color="#6699FF" style="font-weight:800"><%=softwareNum%></font>&nbsp;��&nbsp;</li>
			<li style="width: 340px;">�����û���&nbsp;<font color="#6699FF" style="font-weight:800"><%=show%></font>&nbsp;��&nbsp;</li>
		
          </ul>
        </div></td>-->
    </tr>
  </table>
</div>
</body>
</html>
