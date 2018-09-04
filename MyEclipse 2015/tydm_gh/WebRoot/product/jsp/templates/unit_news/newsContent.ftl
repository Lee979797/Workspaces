<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/css/fenye.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/newsContent.css" />
<link rel="stylesheet" href="/css/viewPicture.css" />
<script type='text/javascript' src='/js/tools.js'></script>
<script type='text/javascript' src='/js/ajax_common.js'></script>
<script type='text/javascript' src='/js/fenye.js'></script>
<script type="text/javascript" src="/dwr/interface/getBbsJs.js"></script> 
<script type='text/javascript' src='/dwr/interface/RemarkBus.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src='/js/template/newsContent.js'></script>


  <div class="page_box"> 
  
    <h2>${TITLE}</h2>
    <h4><#if DEPUTY_TITLE_DSP=="1">${DEPUTY_TITLE}</#if></h4>

	   <h3>${PUB_DATE}&nbsp;<#if LY_DSP=="1">
					来源：${ly}&nbsp;</#if>
		   <#if OPER_DSP=="1">
				${OPER_name}：${OPER}&nbsp;</#if>
		 </h3>
	 
	  <#if SUMMARY_DSP=="1">
	
	 		<div  class="page_box_zheyao" id="summary">摘要：${SUMMARY}</div>
		</#if>
    <div>&nbsp;</div>
   
    <div id="contentStyle" class="artical">

	   <#if !isPage>
	   
	   <p>${CONTENT}</p>
  
			<br/>
			<p></p>

				<div align="right">
			<p></p>

			<#if PUB_COMPANY_DSP=="1">
			 <p class="tail"><font color="#666666">发布机构：${PUB_COMPANY}&nbsp;</font></p>
			</#if>
			<#if TAGS_DSP=="1">
			      <p class="tail"><font color="#666666">关键字：${splitStr(tags)}&nbsp;</font></p>
			</#if>
			</div>
   <#else>
   	<div id="contentStyle" class="contentStyle2"><span id="content">&nbsp;</span></div>
   	<div><span id="fenye">&nbsp;</span></div>
 		<div align="right">
			<br/>
			<p></p>
			<#if PUB_COMPANY_DSP=="1">
			 <p class="tail"><font color="#666666">发布机构：${PUB_COMPANY}&nbsp;</font></p>
			</#if>
			<#if TAGS_DSP=="1">
			      <p class="tail"><font color="#666666">关键字：${splitStr(tags)}&nbsp;</font></p>
			</#if>
		</div>

	   <script type="text/javascript">
	   
	    var htmlContent = "${replaceContent}";
	    var contentArray = htmlContent.split("[NextPage][/NextPage]");
	    listContent = contentArray;
	    listData(listContent);
	   </script>
   </#if>
   
   <#if fileList?size !=0>
    <#list fileList as file>
     <div><p>附件${file_index+1}：<img src="/images/attach.gif" /><a href="/news/downLoad.jsp?filePath=${file.file_name}&describe=${file.file_describe}"  target="_blank">${file.file_describe}</a></p></div>
    </#list>
   </#if>
  </div>
<br/>     
 <div class="toolbar" "> <tr  align="center"><td>&nbsp;<a href="javascript:void(0);" target="_self" onclick="javascript:AddFavor()">加入收藏</a>&nbsp;| <a href="javascript:void(0);" target="_self" onclick="javascript:copyToClipBoard()">复制网址</a>&nbsp;| 【字体：<a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',16)">大</a> <a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',13)">中</a> <a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',12)">小</a>】&nbsp;| <img src="/images/print.jpg" /><a href="javascript:void(0);" onclick="javascript:window.print();" target="_self">打印</a>&nbsp;| <img src="/images/closewindow.jpg" /><a href="#" onClick="javascript:window.close();" target="_self">关闭</a></td></tr></div>
<br/>

  </div>