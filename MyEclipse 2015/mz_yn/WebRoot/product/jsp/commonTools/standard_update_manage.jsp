<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=GBK" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    String mcLen = "20";
    String tableName = (String) request.getAttribute("table");
    if ("t_pzjg".equals(tableName) || "sc_jglx_pzjg".equals(tableName) || "t_zgjg".equals(tableName)) {
        mcLen = "35";
    }
    
    String mes = (String)request.getAttribute("mes");
    
%>
<c:set var="jglxList" value="<%=InitSysParams.tjglxList%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>管理修改</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src='/dwr/interface/standardBus.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript'>     
      window.onload =function(){
			var mes = document.getElementById("mes").value;  
			if(mes != null && mes != ""){
				alert(mes);
			}
	  }
    </script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 系统设置 &gt;&gt; 管理修改</div>
	<div >
		<b>机构类型变更</b>
		<br/>
		<form  id="jglx_update" action="/bsweb/statistics_jglx_update_tyshxydm">
			<TR>
					请输入需要变更机构的统一社会信用代码:
					<input type="text" id="tyshxydm" name="tyshxydm"/>				
					想要变更为的机构类型:
					<select id="jglx" name="jglx">
						<option value="0">------选择要变更为的社团------</option>
						<option value="1">社团</option>
						<option value="2">民非</option>
						<option value="3">基金会</option>
					</select>
					<input type="submit" id="jglx_update_button"  value="确认变更"/>
			</TR>			
		</form>	
	</div>
	<br />
	<br />
	<div >
		<h1>审核</h1>
		<br/>
		<form  id="jg_shenhe" action="/bsweb/statistics_jg_shenhe">
			<TR>
					请输入需要审核的地区的行政区划:
					<input type="text" id="xzqh" name="xzqh"/>				
					<input type="submit" id="jglx_update_button"  value="确认审核"/>
			</TR>			
		</form>	
	</div>
	<br />
	<br />
	<div >
		<h1>换码</h1>
		<br/>
		<form  id="dm_update" action="/bsweb/statistics_dm_update">
			<TR>
					系统中的18位码:
					<input type="text" id="tyshxydm" name="tyshxydm"/>	
					要替换为的18位码:
					<input type="text" id="tyshxydm_new" name="tyshxydm_new"/>			
					<input type="submit" id="dm_update_button"  value="确认替换"/>
			</TR>			
		</form>	
	</div>
	<input type="hidden" id="mes" value="${mes }"/>
</body>
</html>
