<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.RightkeyBo" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleRightkeyBo" %>
<%@ page import="com.ninemax.jpa.system.model.Rightkey" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.List" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    RoleRightkeyBo roleRightKeyBus = new RoleRightkeyBo();
    RoleBo roleBus = new RoleBo();
    RightkeyBo rightKeyBus = new RightkeyBo();
//clsSysUserTO sysuser = (clsSysUserTO)session.getAttribute("sysUser");
    String role_id = request.getParameter("role_id");
    int _role_id = 0;
    if (!clsStringTool.isEmpty(role_id)) {
        _role_id = Integer.parseInt(role_id);
    }
    String role_name = roleBus.findById(_role_id).getRoleName();
    List<Rightkey> superChannels = rightKeyBus.ListChildNode("0");//取一级栏目
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/rightmanage.js"></script>
    <script language="javascript">
        var count = 1;
        function checkForm() {
        <%
      if(superChannels!=null && superChannels.size()>0){
          for(int index=0;index<superChannels.size();index++){
              Rightkey rightKeyTO = (Rightkey)superChannels.get(index);
              String keyIdL1 =  rightKeyTO.getRightkeyId();//一级编号
              %>
            var isChecked = false;
            var element = document.getElementsByName('<%=keyIdL1%>');
            if (element) {
                //alert(element.length);
                for (var i = 1; i < element.length; i++) {

                    if (element.item(i).checked) {
                        isChecked = true;
                        break;
                    }
                }
                if (i == 1) {
                    if (element.checked) {
                        isChecked = true;
                    }
                }
                if (!isChecked) {
                    element.item(0).disabled = true;
                } else {
                    element.item(0).disabled = false;
                }
            }
        <%
          }
      }
      %>
            searchForm.submit();
        }

        function nextPage(num) {
            count = count + num;
            var last = document.getElementById("buttonlast");
            var next = document.getElementById("buttonnext");
            for (var i = 0; i <<%=superChannels.size()%>; i++) {
                var disp = document.getElementById("disp" + i);
                if (disp) {
                    if (i >= ((count - 1) * 5) && i < 5 * count) {

                        disp.style.display = "block";
                    } else {
                        disp.style.display = "none";
                    }
                }
            }
            if (count > 1) {
                last.disabled = false;
            } else {
                last.disabled = true;
            }
            if (5 * count >=<%=superChannels.size()%>) {
                next.disabled = true;
            } else {
                next.disabled = false;
            }
        }
    </script>
</head>
<body>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">
        <strong>系统 &gt;&gt; 用户角色管理 &gt;&gt; 角色管理&gt;&gt; 分配角色（<%=role_name%>）权限</strong>
    </div>
    <div style=" float: left;width: 20%;text-align:right;">
        <input name="button2" type="button" id="buttonlast" title="上页" value=" < < "
               disabled="disabled" onClick=" nextPage(-1);" style="cursor:pointer"/>
        <input name="button3" type="button" id="buttonnext"  value=" > > "
               onClick="nextPage(1);" style="cursor:pointer"/>

    </div>
    <div align="right" style="width: 30% ; float: right;">
        <input name="button" type="button" class="newBtn1" id="save" value="保 存"
               onClick="checkForm();"/>&nbsp;<input name="button" type="button" class="newBtn1" id="back" value="返 回"
                                                    onclick="location.href='roleList.jsp'"/>&nbsp;</div>
</div>
<form name="searchForm" method="post" action="/action/RoleAction">
    <input type="hidden" name="method" value="addRightKeyToRole"/>
    <input type="hidden" name="role_id" value="<%=role_id%>"/>
    <input type="hidden" name="currentPage" value="<%=request.getRequestURI()%>?role_id=<%=role_id%>"/>

    <div style="height: 50px; width:100%">&nbsp;</div>
    <div class="rightpart" style=";overflow:hidden;">
        <div class="listblue" style="overflow:hidden;">

            <%
                if (superChannels != null && superChannels.size() > 0) {

                    for (int index = 0; index < superChannels.size(); index++) {

                        Rightkey rightKeyTO = (Rightkey) superChannels.get(index);
                        String keyIdL1 = rightKeyTO.getRightkeyId();//一级编号
            %>

            <div style="<%=index==4?"width: 19.5%":"width: 20%"%>  ;float:left;<%=index>=5?"display:none;":""%>" id="disp<%=index%>">
                <table border="0" cellspacing="1" cellpadding="3" align="center" width="100%">
                    <tr title="<%=rightKeyTO.getRightkeyName()%>" class="tr_top">
                        <td>
                            <input type="checkbox" name="MENU_<%=rightKeyTO.getRightkeyId()%>"
                                   id="MENU_<%=rightKeyTO.getRightkeyId()%>"
                                   onClick="check_all('MENU_<%=rightKeyTO.getRightkeyId()%>','<%=rightKeyTO.getRightkeyId()%>');"><input
                                type="hidden" name="<%=rightKeyTO.getRightkeyId()%>"
                                value="<%=rightKeyTO.getRightkeyId()%>"/>
                            <%--<%=rightKeyTO.getPictrue()%>--%>
                            <img src="../images/menu/demo.gif" width=16
                                 height=16/>&nbsp;<b><%=rightKeyTO.getRightkeyName() %>
                        </b></td>
                    </tr>
                    <%
                        List<Rightkey> superChannels2 = rightKeyBus.ListChildNode(keyIdL1);//取二级级栏目
                        if (superChannels2 != null && superChannels2.size() > 0) {

                            for (int index2 = 0; index2 < superChannels2.size(); index2++) {
                                Rightkey rightKeyTO2 = (Rightkey) superChannels2.get(index2);
                                String keyIdL2 = rightKeyTO2.getRightkeyId();//二级级编号
                                String hasRight2 = "";
                                if (roleRightKeyBus.HasRight(role_id, keyIdL2)) {
                                    hasRight2 = "checked";
                                }
                    %>
                    <tr title="<%=rightKeyTO2.getRightkeyName()%>" class="tr_2">
                        <td>
                            &nbsp;&nbsp;<input type="checkbox" name="<%=rightKeyTO.getRightkeyId()%>"
                                               value="<%=keyIdL2%>" <%=hasRight2%>
                                               onclick="check_level2(this,'<%=rightKeyTO.getRightkeyId()%>','<%=keyIdL2%>')"><!-- <img src="../images/menu/<%=rightKeyTO2.getPictrue()%> --><img
                                src="../images/menu/zsds_r46_c10.png" width=16
                                height=16/>&nbsp;<%=rightKeyTO2.getRightkeyName() %>
                            <%
                                List<Rightkey> superChannels3 = rightKeyBus.ListChildNode(keyIdL2);//取二级级栏目
                                if (superChannels3 != null && superChannels3.size() > 0) {

                                    for (int index3 = 0; index3 < superChannels3.size(); index3++) {
                                        Rightkey rightKeyTO3 = (Rightkey) superChannels3.get(index3);
                                        String keyIdL3 = rightKeyTO3.getRightkeyId();//二级级编号
                                        String hasRight3 = "";
                                        if (roleRightKeyBus.HasRight(role_id, keyIdL3)) {
                                            hasRight3 = "checked";
                                        }
                            %>
                            </br>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
                                                                name="<%=rightKeyTO.getRightkeyId()%>"
                                                                value="<%=keyIdL3%>"  <%=hasRight3%>
                                                                onclick="check_level2(this,'<%=rightKeyTO.getRightkeyId()%>','<%=keyIdL3%>')"><%=rightKeyTO3.getRightkeyName()%>
                                <%
	 String parentTempId=keyIdL3;
	 List<Rightkey> superChannels4 = rightKeyBus.ListChildNode(keyIdL3);//取二级级栏目
	 if(superChannels4!=null && superChannels4.size()>0){
	    
		for(int index4=0;index4<superChannels4.size();index4++){
		    Rightkey rightKeyTO4 = (Rightkey)superChannels4.get(index4);
			String keyIdL4 =  rightKeyTO4.getRightkeyId();//二级级编号
			String hasRight4 = "";
			if(roleRightKeyBus.HasRight(role_id,keyIdL4)){
			    hasRight4 = "checked";
			}
	 %></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input alt="<%=parentTempId%>" type="checkbox"
                         name="<%=rightKeyTO.getRightkeyId()%>"
                         value="<%=keyIdL4%>"  <%=hasRight4%>
                         onclick="check_level2(this,'<%=rightKeyTO.getRightkeyId()%>','<%=keyIdL4%>')"><%=rightKeyTO4.getRightkeyName()%>
                            <%
                                    }

                                }
                            %>

                            <%
                                    }

                                }
                            %>

                        </td>
                    </tr>
                    <%
                            }

                        }
                    %>
                </table>
            </div>
            <%
                    }
                }
            %>
        </div>
        <div class="listbtn">
            <input name="button" type="button" class="newBtn1" id="save1" value="保 存"
                   onClick="checkForm();"/>&nbsp;<input name="button" type="button" class="newBtn1" id="back2" value="返 回"
                                                        onclick="location.href='roleList.jsp'"/>&nbsp;</div>
    </div>
</form>
</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "roleList.jsp";
    });
    <%}%>
</script>
</html>
