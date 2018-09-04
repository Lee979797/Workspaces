<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ page import="com.ninemax.nacao.business.message.SystemMessageBus" %>
<%@ page import="com.ninemax.nacao.to.message.SystemMessageTO" %>
<%@ page import="com.ninemax.jpa.util.*"%>
<%@ page import="com.ninemax.jpa.global.InitSysParams"%>
<%@ page import="com.ninemax.nacao.business.message.AttachmentBus"%>
<%@ page import="com.ninemax.nacao.to.message.AttachmentTO"%>
<%
    String ids = request.getParameter("id");
    SystemMessageBus sysMessBus = new SystemMessageBus();
    SystemMessageTO sysMes = sysMessBus.findBySysID(ids);
    if (sysMes == null) {
        sysMes = new SystemMessageTO();
    }
    	// 附件集合	
        AttachmentBus attachmentBus = new AttachmentBus();			
	    List<AttachmentTO> atList = attachmentBus.getAttachmentInfoToJson(ids);
		// 下载路径
		String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath");
	    String url = request.getContextPath()+"/servlet/DownServlet?path="+savePath;
    request.setAttribute("sysMes", sysMes);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script src="<%=request.getContextPath() %>/fckeditor/fckeditor.js" type="text/javascript"></script>
    <SCRIPT LANGUAGE="JavaScript">
        function _submit(oper) {
            var send_content = document.getElementById("send_content");

            send_content.value = FCKeditorAPI.GetInstance('test').GetHTML(true);
            if (send_content.value.length == 0) {
                ymPrompt.alert({message:"请输入消息内容！", width:330, height:220, title:'提示信息'});

                return false;
            }
            searchForm.operFlag.value = oper;
            searchForm.submit();
        }
    </SCRIPT>

</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">系统 &gt;&gt; 公告管理 &gt;&gt; 公告管理 &gt;&gt; 查看公告</div>
<form name="searchForm" action="<%=request.getContextPath() %>/action/SystemMessageAction" method="get">
    <input type="hidden" name="sys_id" value="${sysMes.sys_id}"/>
    <input type="hidden" name="type" value="3"/>
    <input type="hidden" name="from_person" value="007"/>
    <input type="hidden" name="operFlag"/>

    <div id="list_main">
        <div class="page_box">
            <%--<div class="page_box_top">
                <div class="page_box_top_left"></div>
                <h1><img src="../../images/zsds_r51_c26.png"/>查看公告</h1>

                <div class="page_box_top_right">&nbsp; <p style=" margin-top:-10px; padding-right:5px;">
                    <input name="button" type="button" class="newBtn1" id="button" value="返  回" onclick="history.go(-1);"/>
                </p></div>
            </div>--%>
            <div class="table_box1 f_10">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">公告标题：</td>
                        <td valign="middle" colspan="3">${sysMes.send_title}</td>
                    </tr>
                   <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">公告内容：</td>
                        <td valign="middle" colspan="3">${sysMes.send_content}
                    </tr>
                   <%-- <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">有效期至：</td>
                        <td width="89%" colspan="3">${sysMes.oper_date}</td>
                    </tr>--%>
                    <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">附件：</td>
                         <td valign="middle" colspan="3">
                         	<%if (!clsStringTool.isEmpty(ids)){ 
						      for(AttachmentTO at:atList){%>
                               <img src='/product/jsp/images/fujian_tubiao.jpg' />
                               <a href="<%=url+at.getSaveName()%>" ><%=at.getFileName()%></a>
                            <%}
							   }%>	   
                         </td>
                    </tr>
                </table>
            </div>
            <div class="listbtn">
                <input name="button" type="button" class="newBtn1" id="button3" value="返  回"  onclick="history.go(-1);"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>