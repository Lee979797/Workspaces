<%@ page contentType="text/html; charset=GBK"  %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%
String currentPage = request.getRequestURI();
if(request.getQueryString() != null){
	currentPage = currentPage +"?"+request.getQueryString();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
    <title>home</title>
    <link href="../../css/css.css" rel="stylesheet" type="text/css" />
     <link href="../../css/csshaojy.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css" />
<script type='text/javascript' src='/dwr/interface/ForbidwordBo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='../../js/forbilist.js'></script>
<script type='text/javascript' src='/js/tools.js'></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 应用功能 &gt;&gt; 敏感字过滤 &gt;&gt; 新增词条</div>
<form name="frmAction" method="post" action="/action/ForbidwordAction">
<input type="hidden" name="method" value="add"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>" />
<div id="list_main">
  <div class="list_box">
<div class="list_box_top">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
        <tr>
          <td ><img src="../images/icon_addgxlm.gif" width="16" height="16" />新增词条：</td>
          
		  <td align="right">
		  <input name="button"  type="button" class="newBtn1" id="button"  value="提  交" onclick="forbidInsert()"  />
		  <input name="button2" type="button" class="newBtn1" id="button2" value="重 填" onclick="frmAction.reset()" />
		  
		  <input name="button" type="button" class="newBtn1" id="button" value="返 回" onclick="location.href='forbidList.jsp'" /></td>
        </tr>
      </table>



</div>
    <table width="503" border="0" cellpadding="0" cellspacing="1"  height="205">
		
       
        <tr >
          <td width="11%" align="right" >词条：</td>
          <td colspan="3" width="89%"><textarea class="page_input_txt" name="forbidWord" rows=8 cols=54 style="width:100%"  onblur="trimIntputValue(this);" ></textarea>&nbsp;<span id="wordDiv"></span></td>
        </tr>
     
   		<tr>
			<td colspan="4" width="89%" style="text-align: left;">&nbsp;在此增加敏感字词条，若要增加多个，可用分号";"间隔，例如“暴力;色情”
			</td>
						
		</tr>
 
    </table>
    
  </div>
  <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>
</form>
</body>
<script>
   <%
   if(!clsStringTool.isEmpty(request.getParameter("msg"))){
        if("OperSuc".equals(request.getParameter("msg").trim())){
   %>
      ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>',330,220,'提示信息',function(){
            window.location.href="forbidList.jsp";
      });
   <%}else{%>
      ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>',330,220,'提示信息',function(){
            window.location.href="forbidList.jsp";
      });
   <%
        }
   }
   %>
</script>
</html>
