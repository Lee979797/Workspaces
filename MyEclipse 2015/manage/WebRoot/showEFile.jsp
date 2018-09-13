 <%@ page contentType = "text/html;charset=UTF-8" 
language="java" 
pageEncoding="UTF-8"
%>
<%  
	if ((session.getAttribute("FileSavePath")==null)||
		(session.getAttribute("FileShowName")==null)||
		(session.getAttribute("EPageType")==null)){
		response.setContentType("text/json; charset=UTF-8"); 
		response.getWriter().write("{success:false,msg:'没有找到文件在服务器上的存储路径。 请重新操作！'}"); //JSON结果 
		response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);//设置失败标识 
		return;
	}
	
	String filePath = session.getAttribute("FileSavePath").toString();
	String fileShowName = session.getAttribute("FileShowName").toString();
	String serverHttpAddr= "http://"+request.getServerName()+":"+request.getServerPort();
    String ePageType=  session.getAttribute("EPageType").toString();

	//System.out.println("serverHttpAddr="+serverHttpAddr);
	//System.out.println("filePath="+filePath);
	//System.out.println("fileShowName="+fileShowName);
	//System.out.println("ePageType="+ePageType);

%>
<html>
<center>
<OBJECT
      classid="clsid:C42F5288-F1A2-4700-84A7-9587BC5F7464"
	  codebase="NamsBrowser.ocx#version=1,0,0,0"
	  width="98%"
	  height="98%"
	  align="center" 
	  hspace=0
	  vspace=0
>
<param name="HttpAddr" value="<%=serverHttpAddr%>">
<param name="SvrFilePath" value="<%=filePath%>">
<param name="LocalFileDir" value="C:/temp">
<param name="FileName" value="<%=fileShowName%>">
<param name="XMLFileName" value="<%=ePageType%>">
</OBJECT>

<!--  
<OBJECT
	  classid="clsid:77CBBF08-CB96-4575-B705-7DA5E3B0A30E"
	  codebase="MyActive/MyActiveX.ocx#version=1,0,0,0"
	  width="715"
	  height="515"
	  align="center"
	  hspace="0"
	  vspace="0"
>

<param name="HttpAddr" value="<%//=serverHttpAddr%>">
<param name="SvrFilePath" value="<%//=filePath%>">
<param name="LocalFileDir" value="c:/temp">
<param name="FileName" value="<%//=fileShowName%>">
</OBJECT>
-->
</html>