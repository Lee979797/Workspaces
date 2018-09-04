<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 <ul style="list-style-type:none;margin:0px;padding:0px;background-color:#908d8d;">
				<li style="text-align:center;">
					<c:if test="${param.btnDisplayTrace}">
						<input type="button" value="显示留痕" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_ShowRevisions(v_egov_Word_OCX, true, ${param.docReadOnly});">					
					</c:if>
					<c:if test="${param.btnHideTrace}">
						<input type="button" value="隐藏留痕" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_ShowRevisions(v_egov_Word_OCX, false, ${param.docReadOnly});">					
					</c:if>
					<c:if test="${param.btnHandwrittenAnnotation}">
						<input type="button" value="手写批注" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_DoHandSign(v_egov_Word_OCX, '');">	
					</c:if>
					<c:if test="${param.btnSaveContent}">
						<input type="button" value="保存正文" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_SaveFile(v_egov_Word_OCX, '${param.documentUri}', true);">					
					</c:if>
					<c:if test="${param.btnCopyContent}">
						<input type="button" value="复制正文" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_CopyContent(v_egov_Word_OCX, ${param.docReadOnly});">					
					</c:if>
					<c:if test="${param.btnPrintContent}">
						<input type="button" value="打印正文" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_PrintCA(v_egov_Word_OCX);">	
					</c:if>
					<c:if test="${param.btnLoadTemplate}">
						<input type="button" value="加载模板" style="margin-top:7px;margin-left:10px;" onclick="fn_egov_Word_ShowTemplates(v_egov_Word_OCX);">
					</c:if>
					<c:if test="${param.btnDownload}">
					<input type="button" value="下载正文" style="margin-top:7px;margin-left:10px;" onclick="downloadContext('${param.documentUri}')" />				
					</c:if>
				</li>
				<li style="margin-top:5px;">
					<object id='OfficeOCX' classid='clsid:AA4B3738-B61C-4bcc-AEE7-0AA47D3C0DDA' codebase='/OfficeControl.cab#version=4,0,2,3' width='100%' height='90%'>
						<param name='Caption' value='Word文档在线编辑器'>
						<param name='MakerCaption' value='重庆xxx'>
						<param name='MakerKey' value='2E14E739088E448E70CB15D59B7030DD0C33856F'>
						<param name="ProductCaption" value="xxx">
						<param name="ProductKey" value="E112EDD97513B0E3F3946F2D8966008A73502A36">
						<param name='Menubar' value='-1'>
						<param name='IsNoCopy' value='0'>
						<param name='FileNew' value='0'>
						<param name='FileOpen' value='1'>
						<param name='FileClose' value='0'>
						<param name='FileSave' value='0'>
						<param name='FileSaveAs' value='1'>
						<param name='FilePrint' value='1'>
						<span style='color:red'>不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</span>
					</object>
				</li>
			</ul>
  </body>
</html>
