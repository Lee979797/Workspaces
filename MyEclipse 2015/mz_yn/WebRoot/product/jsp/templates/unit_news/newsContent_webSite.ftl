<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/css/fenye.css" rel="stylesheet" type="text/css" />
<link href="/css/css_new.css" rel="stylesheet" type="text/css" />
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


  <div id="small_main_left">
    <div class="small_artical_title">${TITLE}
<#if DEPUTY_TITLE_DSP=="1">

  <div class="small_deputy_title">${DEPUTY_TITLE}
    </div>
   </#if>
    </div>

   <p class="artInfo"><font color="#666666">${PUB_DATE}&nbsp;</font>
   <#if LY_DSP=="1">
<font color="#666666">来源：${ly}&nbsp;</font>
</#if>
 <#if OPER_DSP=="1">
<font color="#666666">${OPER_name}：${OPER}&nbsp;</font>
</#if>
</p>
  <#if SUMMARY_DSP=="1">

 <p class=summary id="summary">摘要：${SUMMARY}</p>
</#if>
      <tr><td height="5">&nbsp;</td></tr>
   
    <div id="contentStyle" class="artical">

   <#if !isPage>
   <tr><td align="left" id="contentStyle1" class="contentStyle2">
   ${CONTENT}
   </td></tr>
<br/>
<p></p>

<div align="right">
<p></p>

<#if PUB_COMPANY_DSP=="1">
 <p class="tail"><font color="#666666">发布机构：${PUB_COMPANY}&nbsp;</font>
 </p>
</#if>
<#if TAGS_DSP=="1">
      <p class="tail"><font color="#666666">关键字：${splitStr(tags)}&nbsp;</font>
 </p>
</#if>
</div>
   <#else>
   <tr><td align="left" id="contentStyle" class="contentStyle2"><span id="content">&nbsp;</span></td></tr>
   <tr><td><span id="fenye">&nbsp;</span></td></tr>
 <div align="right">
<br/>
<p></p>
<#if PUB_COMPANY_DSP=="1">
 <p class="tail"><font color="#666666">发布机构：${PUB_COMPANY}&nbsp;</font>
 </p>
</#if>
<#if TAGS_DSP=="1">
      <p class="tail"><font color="#666666">关键字：${splitStr(tags)}&nbsp;</font>
 </p>
</#if>
</div>

   <script type="text/javascript">
    //document.write("<tr><td align=\"left\" id=\"contentStyle\"><span id=\"content\">&nbsp;</span></td></tr>");
    //document.write("<tr><td><span id=\"fenye\">&nbsp;</span></td></tr>");
    var htmlContent = "${replaceContent}";
    var contentArray = htmlContent.split("[NextPage][/NextPage]");
    listContent = contentArray;
    listData(listContent);
   </script>
   </#if>
   
   <#if fileList?size !=0>
    <#list fileList as file>
     <tr><td align="left">附件${file_index+1}：<img src="/images/attach.gif" /><a href="/news/downLoad.jsp?filePath=${file.file_name}&describe=${file.file_describe}"  target="_blank">${file.file_describe}</a></td></tr>
    </#list>
   </#if>
  </div>
<br/>     
 <div class="toolbar" "> <div class="toolbar"><tr  align="center"><td>&nbsp;<a href="javascript:void(0);" target="_self" onclick="javascript:AddFavor()">加入收藏</a>&nbsp;| <a href="javascript:void(0);" target="_self" onclick="javascript:copyToClipBoard()">复制网址</a>&nbsp;| 【字体：<a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',16)">大</a> <a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',13)">中</a> <a href="javascript:void(0);" target="_self" onclick="chg_FontSize('contentStyle',12)">小</a>】&nbsp;| <#if allowRemark=="1"><img src="/images/icons/comment_edit.gif" />【<a href="/news/listRemark.jsp?notice_id=${ID}" target="_blank">查看评论</a>】|</#if><img src="/images/print.jpg" /><a href="javascript:void(0);" onclick="javascript:window.print();" target="_self">打印</a>&nbsp;| <img src="/images/closewindow.jpg" /><a href="#" onClick="javascript:window.close();" target="_self">关闭</a></td></tr></div> </div>
<br/>

  </div>
