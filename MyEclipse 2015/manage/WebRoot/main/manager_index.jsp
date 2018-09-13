<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="java.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.lhq.prj.bms.po.Ywset" %>
<%@ page import="com.lhq.prj.bms.po.Qx" %>
<%@ page import="com.lhq.prj.bms.core.MyUtils" %>

<html xmlns:v="urn:schemas-microsoft-com:vml"xmlns:o="urn:schemas-microsoft-com:office:office">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><%=application.getAttribute("sysAppName") %>--网上办公</title>
	<link rel="shortcut icon" href="<%=application.getAttribute("sysWebUrl") %>/images/favicon.ico"/>
	<script type="text/javascript"> 
		
		//var errCode = '2146827286' & 'x0FFFF';
		//alert(errCode);
	    
		//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外   
		function banBackSpace(e){      
		    var ev = e || window.event;//获取event对象      
		    var obj = ev.target || ev.srcElement;//获取事件源      
		       
		    var t = obj.type || obj.getAttribute('type');//获取事件源类型     
		       
		    //获取作为判断条件的事件类型   
		    var vReadOnly = obj.getAttribute('readonly');   
		    var vEnabled = obj.getAttribute('enabled');   
		    //处理null值情况   
		    vReadOnly = (vReadOnly == null) ? false : vReadOnly;   
		    vEnabled = (vEnabled == null) ? true : vEnabled;   
		       
		    //当敲Backspace键时，事件源类型为密码或单行、多行文本的，   
		    //并且readonly属性为true或enabled属性为false的，则退格键失效   
		    var flag1=(ev.keyCode == 8 && (t=="password" || t=="text" || t=="textarea")    
		                && (vReadOnly==true || vEnabled!=true))?true:false;   
		      
		    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效   
		    var flag2=(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea")   
		                ?true:false;           
		       
		    //判断   
		    if(flag2){   
		        return false;   
		    }   
		    if(flag1){      
		        return false;      
		    }      
		}   
		  
		//禁止后退键 作用于Firefox、Opera   
		document.onkeypress=banBackSpace;   
		//禁止后退键  作用于IE、Chrome   
		document.onkeydown=banBackSpace;   
		 
		
		function Fkey(){
			var WsShell = new ActiveXObject('WScript.Shell');
			WsShell.SendKeys('{F11}');
		}
	</script>  
	<style type="text/css">
		#loading{
	        position:absolute;
	        left:40%;
	        top:40%;
	        padding:2px;
	        z-index:20001;
	        height:auto;
	    }
	    #loading a {
	        color:#225588;
	    }
	    #loading .loading-indicator{
	        background:white;
	        color:#444;
	        font:bold 13px tahoma,arial,helvetica;
	        padding:10px;
	        margin:0;
	        height:auto;
	    }
	    #loading-msg {
	        font: normal 10px arial,tahoma,sans-serif;
	    }
	</style>
	<script type="text/javascript">
	
		var currentZzUsername = '<s:property value="#session.user.getUserName()"/>';
		var currentZzUser='<s:property value="#session.user.emplName"/>';
		var currentZzUserBzjgmc='<s:property value="#session.user.bzjgName"/>';
		var currentZzUserBzjgdm='<s:property value="#session.user.bzjgCode"/>';
		var currentZzUserCenterid='<s:property value="#session.user.centerCode"/>';
		var currentZzUserCenterName='<s:property value="#session.user.centerName"/>';
		var currentZzUserYwqx='<s:property value="#session.user.ywqx"/>';
		var currentZzUserMsg = '当前用户:<s:property value="#session.user.emplName"/>';
		var scanWorkVersion='<%=application.getAttribute("scanWorkVersion") %>';
		var scanCheckMode='<%=application.getAttribute("scanCheckMode") %>';
		var sysWorkStartime='<%=application.getAttribute("sysWorkStartime") %>';
		var sysWorkEndtime='<%=application.getAttribute("sysWorkEndtime") %>';
		var sysXcWorkMode='<%=application.getAttribute("sysXcWorkMode") %>';
		var sysNetWorkMode='<%=application.getAttribute("sysNetWorkMode") %>';
		var sysNjqxDate='<%=application.getAttribute("sysNjqxDate") %>';
		var sysZsbfdw='<%=application.getAttribute("sysZsbfdw") %>';
		var sysZsFddbrBz='<%=application.getAttribute("sysZsFddbrBz") %>';
		var sysPrintNote='<%=application.getAttribute("sysPrintNote") %>';
		var sysOcrSwitch='<%=application.getAttribute("sysOcrSwitch") %>';
		var sysBzjgLimitMode='<%=application.getAttribute("sysBzjgLimitMode") %>';
		var useUpPageSize='<s:property value="#session.user.useUpPageSize"/>';
		if(useUpPageSize==""){
			useUpPageSize=<%=application.getAttribute("sysUpPageSize") %>;
		}
		var useDownPageSize='<s:property value="#session.user.useDownPageSize"/>';
		if(useDownPageSize==""){
			useDownPageSize=<%=application.getAttribute("sysDownPageSize") %>;
		}
		var useFullPageSize='<s:property value="#session.user.useFullPageSize"/>';
		if(useFullPageSize==""){
			useFullPageSize=<%=application.getAttribute("sysFullPageSize") %>;
		}
		var sysGdqx='<%=application.getAttribute("sysGdqx") %>';
		var sysMsgInterval='<%=application.getAttribute("sysMsgInterval") %>';
		var sysMsgRepeat='<%=application.getAttribute("sysMsgRepeat") %>';
		var sysAutoMailMode='<%=application.getAttribute("sysAutoMailMode") %>';
		var sysAutoMail=true;
		if(sysAutoMailMode=='1'){
			sysAutoMail=false;
		};
		
		var sysStrYwxcSet='';
		var sysStrYwnetSet='';
		<%
		if("1".equals(application.getAttribute("sysXcWorkMode"))){
			String strYwxc="";
			List ywxcList = new ArrayList();
			ywxcList=(List)session.getAttribute("ywxcList");
			for (int j = 0; j < ywxcList.size(); j++) {
				Qx qx=new Qx();
				qx=(Qx)ywxcList.get(j);
				String strYwlx=qx.getYwlx();
				String strShbz=String.valueOf(qx.getShbz());	
				strYwxc=strYwxc+"|"+strYwlx+"|"+strShbz+"|";
			}
		%>
		sysStrYwxcSet='<%=strYwxc %>';
		<%}%>
		<%
		if("1".equals(application.getAttribute("sysNetWorkMode"))){
			String strYwnet="";
			List ywnetList = new ArrayList();
			ywnetList=(List)application.getAttribute("ywnetList");
			for (int j = 0; j < ywnetList.size(); j++) {
				Ywset ywset=new Ywset();
				ywset=(Ywset)ywnetList.get(j);
				String strYwlx=ywset.getYwlx();
				String strBzjgdm=ywset.getBzjgdm();	
				strYwnet=strYwnet+"|"+strYwlx+"|"+strBzjgdm+"|";
			}
		%>
			sysStrYwnetSet='<%=strYwnet%>';
		<%}%>
		var strPfunc = '<%=session.getAttribute("strPfunc")%>';	
			
		var nav = '<s:property value="tip"/>'; 
		if(nav == '' || nav.length <= 0){
			location = '/manage/index.jsp';
		}
		function LocationMainPage()
		{	
			Ext.getCmp('content-panel').layout.setActiveItem('start-panel');
		}
		function hiddenTop()
		{		
			//Ext.getDom('top-panel').height = '0';
			//Ext.getCmp('top-panel').hide();
			Ext.getCmp('top-panel').setHeight('0');
			alert('sss');
		}				
		
		function ReLogin()
		{		
			Ext.Msg.confirm('操作提示', '您确定要退出本系统?', function(btn) {
				if ('yes' == btn) {
					Ext.Ajax.request({
						url : 'logout.action',
						success : function() {
							location = '/manage/index.jsp';
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '退出系统失败!',
								icon : Ext.Msg.ERROR,
								buttons : Ext.Msg.OK
							});
						}
					});
				}
			});
		}				
	</script>
	</head>
	<body>
	</object> 
		<div id="loading">
			<div class="loading-indicator">
				<img src="/manage/images/loading.gif" width="39" height="39" style="margin-right:8px;float:left;vertical-align:top;" />
				组织机构代码网上办证系统  V1.0
				<br />
				<span id="loading-msg">加载样式和图片...</span>
			</div>
		</div>
		<div id="bd">
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载核心.';</script>
			<link rel="stylesheet" type="text/css" media="all" href="<%=application.getAttribute("sysWebUrl") %>/resources/css/ext-all.css" />
			<link rel="stylesheet" type="text/css" media="all" href="<%=application.getAttribute("sysWebUrl") %>/css/index.css" />
			<link rel="stylesheet" type="text/css" media="all" href="<%=application.getAttribute("sysWebUrl") %>/css/global.css" />
			<link rel="stylesheet" type="text/css" href="<%=application.getAttribute("sysWebUrl") %>/css/menus.css" />
			<link rel="stylesheet" type="text/css" href="<%=application.getAttribute("sysWebUrl") %>/css/LovCombo.css" />
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载核心..';</script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/adapter/ext/ext-base.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/ext-all.js"></script>
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载核心...';</script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/LovCombo.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/RowExpander.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/NewFormLayout.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/ext-lang-zh_CN.js"></script>
			
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/Cardnjprint.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/Cardread.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/Cardwrite.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/Cardprint.js"></script>
			
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/validate/validate.js"></script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/zzIncludeFunc.js"></script>
			
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载UI组件...';</script>
			<%	String strPfunc2 = (String)session.getAttribute("strPfunc2");
				String[] arrPfuncList2=MyUtils.split(strPfunc2,",");
				for (int j = 0; j < arrPfuncList2.length; j++) {
					String strFuncFile=arrPfuncList2[j];
					if("zzBzjgDateReport".equals(strFuncFile)){
			%>
						<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/report/zxt.js"></script>
						<link rel="stylesheet" type="text/css" href="<%=application.getAttribute("sysWebUrl") %>/report/zxtCss.css" />
			<%	
					}
					if("zzXzqhYwReport".equals(strFuncFile)){
			%>
						<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/report/xzqhYwReport.js"></script>
						<link rel="stylesheet" type="text/css" href="<%=application.getAttribute("sysWebUrl") %>/report/xzqhYwReportCss.css" />
			<%	
					}
					if("zzLeafHelp".equals(strFuncFile)){
			%>
						<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/StarHtmleditor.js"></script>
			<%	
					}
					strFuncFile=strFuncFile+".js";
			%>
					<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/<%=strFuncFile%>"></script>
			<%
				}
			%>
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '模块初始化.';</script>
			<script type="text/javascript" src="<%=application.getAttribute("sysWebUrl") %>/js/main.js"></script>
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '模块初始化...';</script>
		</div>
		<div id="header" >
<TABLE style="BACKGROUND-POSITION: 50% top; BACKGROUND-REPEAT: repeat-x" height=60 cellSpacing=0 cellPadding=0 width="100%" background=images/bg.gif border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE  style="BACKGROUND-POSITION: right top; BACKGROUND-REPEAT: no-repeat" height=60 cellSpacing=0 cellPadding=0 width="100%" background=images/bg_main.gif border=0>
        <TBODY>
        <TR>
        	<td rowSpan=2 width="50px">&nbsp;&nbsp;&nbsp;</td>
          	<TD rowSpan=2><IMG  src="images/zzsl_03.gif"></TD>
          	<TD rowSpan=2 valign="middle">
          		<TABLE height=60 cellSpacing=0 cellPadding=0 width=362  border=0>
		        	<TBODY>
			            <TR>
			                <TD vAlign=bottom align=left height=40><IMG src="images/zzsl_04.gif"></TD>
			            </TR>
			            <TR>
			                <TD  height=20 align=left>&nbsp;&nbsp;&nbsp;<font color=#04436d><span class="STYLE5"><span class="STYLE9">当前办证机构</span>&gt;&gt;<span class="STYLE9" id="">&nbsp;<s:property value="#session.user.bzjgName"/> <s:property value="#session.user.bzjgCode"/></span></span></font></TD>
			            </TR>
		            </TBODY>
				</TABLE>
          		
          	</TD>
          	<TD vAlign=top align=right width="100%">
		            <TABLE height=21 cellSpacing=0 cellPadding=0 width=169  bgColor=#000000 border=0>
		              <TBODY>
			              <TR>
			                <TD vAlign=bottom align=left width=8><IMG onclick="javascript:hiddenTop();" height=4 
			                  src="images/left_bottom.gif" width=4></TD>
			                <TD><A style="cursor:hand"><IMG class=pointer 
			                  onclick="javascript:LocationMainPage();" 
			                  height=21 src="images/home.gif" alert="显示系统主页" width=54 border=0></A></TD>
			                 <TD><A style="cursor:hand"><IMG class=pointer 
			                  onclick="javascript:luckPage();" 
			                  height=21 src="images/luck.gif"  alert="锁定本地系统操作" width=54 border=0></A></TD>
			                 <TD><A style="cursor:hand"><IMG class=pointer 
			                  onclick="javascript:Fkey();" 
			                  height=21 src="images/quanping.gif"  alert="全屏显示,可按F11键" width=54 border=0></A></TD>
			                <TD><A style="cursor:hand"><IMG 
			                  class=pointer height=21 src="images/help.gif" width=54 
			                  border=0></A></TD>
			                <TD><A style="cursor:hand"><IMG onclick="javascript:ReLogin();" 
			                  height=21 src="images/exit.gif"   alert="退出系统登录" width=54 border=0></A></TD>
			                <TD vAlign=bottom align=right width=16><IMG height=4 
			                  src="images/right_bottom.gif" width=4></TD>
			            	</TR>
		            	</TBODY>
		            </TABLE>
        	</TD>
        </TR>
        </TBODY>
	</TABLE>
    </TD>
  </TR>
  </TBODY>
</TABLE>
		</div>
	</body>
</html>
<script type="text/javascript">
	if(currentZzUser == '' || currentZzUser.length <= 0){
		alert("系统长时间没使用，请重新登录！");
		window.location = '/manage/index.jsp';
	}
</script>
