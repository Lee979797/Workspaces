<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="java.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.lhq.prj.bms.po.Ywset" %>
<%@ page import="com.lhq.prj.bms.po.Qx" %>
<%@ page import="com.lhq.prj.bms.po.Jglx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织机构代码档案管理系统--系统监测</title>
</head>
<body>
<center>
<h2>系&nbsp;&nbsp;&nbsp;统&nbsp;&nbsp;&nbsp;检&nbsp;&nbsp;&nbsp;测&nbsp;&nbsp;&nbsp;清&nbsp;&nbsp;&nbsp;单</h3><h4>The page of system detects</h4>
<hr>
</center>
<center><h3>系统全局参数设置</h3></center>
<table width="1000" cellpadding="3" cellspacing="2" align="center" border=1>
	<tr bgcolor="#e5e5e5" height="30">
		<td width=40 align="center"><b>序号</b></td><td width=200><b>参数名</b></td><td width=180><b>参数值</b></td><td><b>备注</b></td>
	</tr>

<%if(application.getAttribute("sysAppName")!=null){ %>
	<tr>
		<td align="center">1</td><td>后台办公扫描控件版本</td><td><%=application.getAttribute("scanWorkVersion") %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">2</td><td>网上办证扫描控件版本</td><td><%=application.getAttribute("scanNetVersion") %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">3</td><td>扫描原文验证方式</td><td><%=application.getAttribute("scanCheckMode") %></td><td>0 为档案扫描强制校验，1 为业务办理强制校验，2 为归档时候强制校验</td>
	</tr>
	<tr>
		<td align="center">4</td><td>系统工作起始时间</td><td align="center"><%=application.getAttribute("sysWorkStartime") %> 至 <%=application.getAttribute("sysWorkEndtime") %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">5</td><td>系统网上业务审核模式</td><td><%=application.getAttribute("sysNetWorkMode") %></td><td>0 办证机构进行审核，1 分中心进行审核</td>
	</tr>
	<tr>
		<td >&nbsp;</td><td colspan=3>网上申办业务审核设置参数：
	<%
		List ywnetList = new ArrayList();
		ywnetList=(List)application.getAttribute("ywnetList");
		for (int j = 0; j < ywnetList.size(); j++) {
			Ywset ywset=new Ywset();
			ywset=(Ywset)ywnetList.get(j);
			String strYwlx=ywset.getYwlx();
			String strBzjgdm=ywset.getBzjgdm();	
	%><%=strYwlx%><%=strBzjgdm%>、
	<%
		}
	%>
		</td>
	</tr>
	
	<tr>
		<td align="center">6</td><td>系统现场业务审核模式</td><td><%=application.getAttribute("sysXcWorkMode") %></td><td>0 分中心不进行审核，1 分中心进行审核</td>
	</tr>
	<tr>
		<td>&nbsp;</td><td colspan=3>现场办理业务审核设置参数：
	<%
	List ywxcList = new ArrayList();
	ywxcList=(List)session.getAttribute("ywxcList");
	if(ywxcList!=null){
		for (int j = 0; j < ywxcList.size(); j++) {
			Qx qx=new Qx();
			qx=(Qx)ywxcList.get(j);
			String strYwlx2=qx.getYwlx();
			String strShbz=String.valueOf(qx.getShbz());
	%>
			<%=strYwlx2 %><%=strShbz %>、
	<%
		}
	}
	%>
		</td>
	</tr>
	<tr>
		<td align="center">7</td><td>系统自动取码URl</td><td><%=application.getAttribute("sysAutoCodeServerUrl") %></td><td>在线取码服务器地址</td>
	</tr>
	
	<tr>
		<td align="center">8</td><td>办证机构限制标志</td><td><%=application.getAttribute("sysBzjgLimitMode") %></td><td>0可以跨办证机构进行办理，1不可跨办证机构办理</td>
	</tr>
	
	<tr>
		<td align="center">9</td><td>按机构类型审核设置: </td><td colspan=2>
	<%
	List jglxList = new ArrayList();
	jglxList=(List)application.getAttribute("jglxList");
	for (int j = 0; j < jglxList.size(); j++) {
		Jglx jglx=new Jglx();
		jglx=(Jglx)jglxList.get(j);
		String strJglxdm=jglx.getJglxdm();
	%>
		<%=strJglxdm %>、
	<%
	}
	%>
		</td>
	</tr>
	<tr>
		<td align="center">10</td><td>默认年检期限日期</td><td><%=application.getAttribute("sysNjqxDate") %></td><td>机构年检的默认最后日期</td>
	</tr>
	<tr>
		<td align="center">11</td><td>证书颁发机构名称</td><td><%=application.getAttribute("sysZsbfdw") %></td><td>打印证书上的颁发机构名称</td>
	</tr>
	<tr>
		<td align="center">12</td><td>证书中缝默认备注内容</td><td><%=application.getAttribute("sysPrintNote") %></td><td>证书打印是默认中缝打印的备注内容</td>
	</tr>
<%
}else{
%>
	<tr>
		<td>&nbsp;</td><td colspan=3>提醒：系统application参数设置没有启动，请登录系统后再监测！</td>
	</tr>
<%}%>
</table>
<%
Runtime lRuntime = Runtime.getRuntime();
%>
<br><br>
<center><h3>WEB服务器即时监测</h3></center>
<table width="1000" cellpadding="3" cellspacing="2" align="center" border=1>
	<tr bgcolor="#e5e5e5" height="30">
		<td width=40 align="center"><b>序号</b></td><td width=200><b>参数名</b></td><td width=180><b>参数值</b></td><td><b>备注</b></td>
	</tr>
	<tr>
		<td align="center">1</td><td>可用内存数</td><td><%=lRuntime.freeMemory() %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">2</td><td>最大内存数</td><td><%=lRuntime.maxMemory() %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">3</td><td>总内存数</td><td><%=lRuntime.totalMemory() %></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td align="center">4</td><td>CPU处理器个数</td><td><%=lRuntime.availableProcessors() %></td><td>&nbsp;</td>
	</tr>
</body>
</html>