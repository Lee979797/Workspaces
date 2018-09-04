<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ninemax.jpa.collection.dao.CheckControlDAO"%>
<%@ page import="com.ninemax.jpa.collection.model.CheckControl"%>
<%@ page import="com.ninemax.jdbc.dao.clsPageComponent"%>
<%@ page import="com.ninemax.jpa.util.clsStringTool"%>
<%@ page import="com.ninemax.jpa.util.DateProcess" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.bo.BzjgdmBo" %>
<%@ page import="com.ninemax.jpa.system.model.Bzjgdm" %>
<%
	BzjgdmBo bzbo = new BzjgdmBo();
	String sysDate = DateProcess.getSysDate();
	User sysuser = (User)session.getAttribute("sysUser");
	//String c_userid = String.valueOf(sysuser.getUserId());

	UserBo userBo = new UserBo();
	User user = userBo.findById(sysuser.getUserId());
	String bzd = user.getUserProvince();
	
	CheckControlDAO ccDAO = new CheckControlDAO();
	String resultJgdm = "";
	List<CheckControl> checkControlList = ccDAO.findAll();
	for(CheckControl checkControl : checkControlList){
		resultJgdm += checkControl.getBzjgdm() + ",";
	}
	List<Bzjgdm> bzList = bzbo.findJdbcBySuperId(bzd);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>home</title>
<link href="../../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/Blue_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link href="../../css/csshaojy.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/dwr/interface/ScFieldsBo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<link rel="stylesheet" id='skin' type="text/css"  href="../frame/js/alert/skin/dmm-green/ymPrompt.css" />
<script type="text/javascript" src="../../js/checkcontrol.js"></script>
	</head>
	<body bgcolor="yellow">
	<form name="checkControlForm" action="/action/CheckControlAction" method="get">
		<div class="page_top">
			系统 &gt;&gt; 应用功能 &gt;&gt; 审核控制
		</div>

			<div id="list_main">
				<div class="list_box">
					<div class="list_box_top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<img src="../images/icon_addgxlm.gif" width="16" height="16" />
									审核控制：
								</td>
								<td align="right">
									<input name="button" type="button" class="newBtn1"
										id="button" value="提  交" onclick="submits();" />
								</td>
							</tr>
						</table>
					</div>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="white">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="1" >
		<tr class="tr_top">
		<td colspan="5">
		<input type="checkbox" onclick="checkAll()" name="checkall" id="checkall"/>&nbsp;<b>全选</b>
		</td>
		</tr>	
		<tr>
          <%
	if(bzList!=null && bzList.size()>0){
	    
		for(int index=0;index<bzList.size();index++){
	    
			Bzjgdm baseGroupSort = (Bzjgdm)bzList.get(index);
			String keyIdL1 =  baseGroupSort.getDm().trim();//一级编号

	%>
	
	<td valign="top" >
		<table border="0" cellspacing="1"  cellpadding="3" align="center" width="100%">
     	 <tr title="<%=baseGroupSort.getMc()%>" >
      <td>
        <input type="checkbox" name="jgdm" value="<%=keyIdL1%>" <%if(resultJgdm.indexOf(keyIdL1) != -1){%>checked<%} %>/>&nbsp;<%=baseGroupSort.getMc()%></td>
     </tr>
	 
	   </table>
	 </td>
	 
	 <%if(index%5==4){out.println("</tr>");}%>
	  
	<%}
   }	
	%> </table></td>
						</tr>
					</table>
					<span class="right"></span>
				</div>

				<div class="div_bian5" id="tongzhi1">
					
				</div>
			</div>
			<div
				style="background: url(../../images/ty.png) repeat-x; height: 5px; width: 100%; overflow: hidden; clear: both;"></div>
			
		</form>
	</body>
</html>
<%
    String message = request.getParameter("msg");
    String oper = clsStringTool.convertNull(request.getParameter("oper"));
    if (message != null) {
        if (message.equals("success")) {
        	if(oper.equals("add")){
        		message = "增加成功";
        	}else{
        		message = "修改成功";
        	}
        } else {
           if(oper.equals("add")){
        		message = "增加失败";
        	}else{
        		message = "修改失败";
        	}
        }
%>
<script type="text/javascript">
   <%if("success".equals(request.getParameter("msg"))){%>
       ymPrompt.succeedInfo("<%=message%>", 330,220, "提示信息", function (data) {
            if (data == 'ok') {
                window.location.href="list_checkControl.jsp";
            }
       });
   <%}else{%>
       ymPrompt.errorInfo("<%=message%>", 330,220, "提示信息", function (data) {
            if (data == 'ok') {
                window.location.href="list_checkControl.jsp";
            }
       });
   <%}%>
</script>
<%
    }
%>
