<%@ page import="com.ninemax.jdbc.business.system.clsProvinceBus" %>
<%@ page import="com.ninemax.jdbc.to.system.clsProvinceTO" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.system.model.PoliticalLandscape" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String userGroupId = ((User) session.getAttribute("sysUser")).getUsergroupId();
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    String paramString = request.getQueryString();
    UserGroupBo userGroupBo = new UserGroupBo();
//ArrayList groups = userGroupBus.GetGroupByKind("1");//�û���

    List<UserGroup> groups = userGroupBo.findAll();//ȫ���û���

    RoleBo roleBo = new RoleBo();
//List<Role> roles = roleBo.ListRoleByKind("1");
    String userClassID = "";

    String user_id = request.getParameter("user_id");
    int _user_id = 0;
    if (!clsStringTool.isEmpty(user_id)) {
        _user_id = Integer.parseInt(user_id);
    }

    UserBo userBo = new UserBo();
    User user = userBo.findById(_user_id);
    String centerId = ((User) session.getAttribute("sysUser")).getBzjgdm();
    String regProvince = user.getUserProvince();
    if (regProvince == null || regProvince.equals("") || "null".equals(regProvince)) {
        regProvince = "no";
    }

    String regBzjgdm = user.getBzjgdm();
    if (regBzjgdm == null || regBzjgdm.equals("") || "null".equals(regBzjgdm)) {
        regBzjgdm = "no";
    }
    String db = user.getDb();
    clsProvinceBus provinceBus = new clsProvinceBus();
    String cnCode = user.getCncode();
    if (cnCode == null || cnCode.equals("") || "null".equals(cnCode)) {
        cnCode = "";
    }
    String icCode = user.getIccade();
    if (icCode == null || icCode.equals("") || "null".equals(icCode)) {

        icCode = "";
    }
%>
<c:set value="<%=InitSysParams.bzjgdmMap%>" var="bzjgMap"/>
<c:set var="user" value="<%=user%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�޸��û���Ϣ</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/jquery.min.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src="../frame/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/dwr/interface/UserBus.js'></script>
    <script type='text/javascript' src='/dwr/interface/ProvinceBus.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/js/city.js"></script>
    <script type='text/javascript' src='/product/js/user.js'></script>
    <script type="text/javascript">
	$(function(){   $("#userName").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <style type="text/css">
        table.table_bj1 td{height:38px;}
    </style>
</head>
<body>
<div class="page_top">ϵͳ &gt;&gt; �û���ɫ���� &gt;&gt; �û����� &gt;&gt; �޸��û�</div>

<form method="post" action="/action/UserAction" name="userForm">
<input type="hidden" name="method" value="modify"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>"/>
<input type="hidden" name="certId" value=""/>
<input type="hidden" name="userLevel" value="0"/>
<input type="hidden" name="item1" value="totalWebSite"/>
<input type="hidden" name="userCompanyAddress" value=" "/>
<input type="hidden" name="userNature" value="0"/>
<input type="hidden" name="userKind" value="1"/>
<input type="hidden" name="userStatus" value="0"/>
<input type="hidden" name="userId" id="userId" value="<%=user_id%>"/>
<input type="hidden" name="firstXzqh" value="${sysUser.bzjgdm}"/>
<input type="hidden" name="printName" id="printName"/>

<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
    <tr class="table1_tr1">
        <td width="15%" class="table1_td1">�û���<span style="color: #FF0000">(*������ʮλ)</span>��</td>
        <td  style="position:relative;display:block;overflow:visible;"><input type="text" id="userName" name="userName" maxlength="10"
                               size="30" isnull="false" onblur="checkName()" readonly="true"
                               value="<%=user.getUserName() %>" class="page_input2"/>
            <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userDiv"></span>
        </td>
        <td width="15%" class="table1_td1" nowrap>��ʵ����<span style="color: #FF0000">(*)</span>��</td>
        <td ><input type="text" name="userChinesename" maxlength="30" size="30" isnull="false"
                   class="page_input2"
                   value="${fn:trim(user.userChinesename)}">
        </td>
    </tr>
<!--
    <tr class="table1_tr1">
        <td class="table1_td1">�����ѯ����<span style="color: #FF0000">(*)</span>��</td>
        <td><input type="text" name="userLostpwshow" maxlength="5" size="30" isnull="false"
                   class="page_input2"
                   value="${fn:trim(user.userLostpwshow)}"/>
        </td>
        <td class="table1_td1" nowrap>�����ѯ��<span style="color: #FF0000">(*)</span>��</td>
        <td><input type="text" name="userShowproblem" maxlength="5" size="30" isnull="false"
                   class="page_input2"
                   value="${fn:trim(user.userShowproblem)}">
        </td>
    </tr>
      -->
    <tr class="table1_tr1">
        <td class="table1_td1">�û���<span style="color: #FF0000">(*)</span>��</td>
        <td>          
            <select name="usergroupId" id="usergroupId" style="width: 192px">
         
            <option value="">---��ѡ���û���---</option>
            <%
            if(userGroupId.trim().equals("1")){  
                if (groups != null && groups.size() > 0) {
                    for (UserGroup u : groups) {   
                    	String selected = "";
                        if (String.valueOf(u.getUsergroupId()).equals(user.getUsergroupId().trim())) {
                        	selected = "selected";
                        }                	                  
            %>
            <option value="<%=u.getUsergroupId()%>"><%=u.getUsergroupName() %>
            </option>
            <%
                    }
				}
            }else{
            	if (groups != null && groups.size() > 0) {
                    for (UserGroup u : groups) {   
                    String selected = "";
                            if (String.valueOf(u.getUsergroupId()).equals(user.getUsergroupId().trim())) {
                                selected = "selected";
                            }
            			if(u.getUsergroupId()==1){
            				continue;             			         			
            			}
             %>
            <option value="<%=u.getUsergroupId()%>"<%=selected%>><%=u.getUsergroupName() %></option>
            <%
            			}
                 }    
            }%>
      
            <%--     <option value="">---��ѡ���û���---</option>
                <%
                    if (groups != null && groups.size() > 0) {
                        for (UserGroup u : groups) {
                            String selected = "";
                            if (String.valueOf(u.getUsergroupId()).equals(user.getUsergroupId().trim())) {
                                selected = "selected";
                            }
                %>
                <option value="<%=u.getUsergroupId() %>" <%=selected%>><%=u.getUsergroupName() %>
                </option>
                <%
                        }
                    }%>
             --%>
            
            
            
            
            
            
            
            
            </select>
        </td>
        <td class="table1_td1">ͨѶ��ַ��</td>
        <td><input type="text" name="userAddress" maxlength="30" size="30" isnull="false"
                   class="page_input2"
                   value="${fn:trim(user.userAddress)}"/>
        </td>
    </tr>
    <tr class="table1_tr1">

        <td class="table1_td1">��������<span style="color: #FF0000">(*)</span>��</td>
        <td><span id="branchDiv"></span>
            <select id="zrxzqu" name="zrxzqu" style="width: 192px">
                <option value="">ѡ��</option>
                <%

                    /*������ǰҳ��õ��� city ID*/
                    ArrayList twoXzqhs = null;
                    String bzjgdm = centerId;
                    if (!clsStringTool.isEmpty(bzjgdm)) {
                        //trueΪ�м���֤����
                       // if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                         //   twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 4) + "00");
                        //} else
                            twoXzqhs = provinceBus.ListAll();
                    }
                    if (twoXzqhs != null && twoXzqhs.size() > 0) {
                        for (int index = 0; index < twoXzqhs.size(); index++) {
                            clsProvinceTO provinceTO = (clsProvinceTO) twoXzqhs.get(index);

                %>
                <option value="<%=provinceTO.getId() %>" <%
                    if (user.getZrxzqu().equals(provinceTO.getId().trim()))
                        out.print("selected");
                %>><%=provinceTO.getId()%>:<%=provinceTO.getProvinceName()%>
                </option>
                <%
                        }
                    }
                %>
            </select>

        </td>
        
        <td class="table1_td1">CA�û���</td>
    <td><input type="text" name="cncode" maxlength="20" size="30" isnull="false" class="page_input2" value="<%=cnCode %>"></td>
    </tr>
    <tr class="table1_tr1">

    <td class="table1_td1">��׼��������<span style="color: #FF0000">(*)</span>��</td>
    <td><span id="branchDiv"></span>
        <select id="bzjgdm" name="bzjgdm" style="width: 192px">
            <option value="">ѡ��</option>
            <%

                /*������ǰҳ��õ��� city ID*/
                 bzjgdm = centerId;
                if (!clsStringTool.isEmpty(bzjgdm)) {
                    //trueΪ�м���֤����
                   // if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                     //   twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 4) + "00");
                    //} else
                        twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 2) + "0000");
                }
                if (twoXzqhs != null && twoXzqhs.size() > 0) {
                    for (Object twoXzqh : twoXzqhs) {
                    	clsProvinceTO   provinceTO = (clsProvinceTO) twoXzqh;

            %>
            <option value="<%=provinceTO.getId() %>" <%
                    if (user.getBzjgdm().equals(provinceTO.getId().trim()))
                        out.print("selected");
                %>><%= provinceTO.getProvinceName()%>
            </option>
            <%
                    }
                }
            %>
        </select></td>
          <td class="table1_td1">�Ա�</td>
        <td><input type="radio" name="userSex" value="1" <%
            if ("1".equals(user.getUserSex())) out.print("checked");%> />
            ��
            <input type="radio" name="userSex" value="0" <%
                if ("0".equals(user.getUserSex())) out.print("checked");%>/>
            Ů
        </td>
	</tr>
    <tr class="table1_tr1">
        <td class="table1_td1">�������ڣ�</td>
        <td><input type="text" id="CalendarSelector2" name="userBirthday" maxlength="10"
                   size="26" isnull="false"
                   value="${fn:trim(user.userBirthday)}"
                   onclick="WdatePicker({el:'CalendarSelector2'})"/>
            <IMG src="../images/icon_day.gif" style="cursor:pointer" align="middle"
                 onclick="WdatePicker({el:'CalendarSelector2'})"/></td>
        <td class="table1_td1">�������䣺</td>
        <td style="position:relative;display:block;overflow:visible;">
            <input type="text" name="userEmail" id="userEmail" maxlength="40" size="30" isnull="false"
                   class="page_input2" onblur="valifyEmail(<%=user_id%>)"
                   value="${fn:trim(user.userEmail)}"/>
            <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userEmailInfo"></span>
        </td>
    </tr>
    <tr class="table1_tr1">
        <td class="table1_td1">�ֻ���</td>
        <td style="position:relative;display:block;overflow:visible;">
            <input type="text" name="userMobile" id="userMobile" maxlength="20" size="30" isnull="false"
                   class="page_input2"
                   value="${fn:trim(user.userMobile)}">
            <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userPhoneInfo"></span>
        </td>

    </tr>

</table>
</div>
<div class="listbtn">
    <input name="button" type="button" class="newBtn1" id="saveButton" value="�� ��"
           onClick="checkForm('mod');"/>
    <input name="button2" type="button" class="newBtn1" id="button2" value="�� ��"
           onclick="userForm.reset()"/>

    <input name="button3" type="button" class="newBtn1" id="button3" value="�� ��"
           onclick="javascript:document.location.href='userList.jsp?<%=paramString %>'"/>
</div>
</div>
</div>
</div>
</div>
</form>
</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){
         if("modRegUserSuc".equals(request.getParameter("msg").trim())){
    %>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "userList.jsp";
    });
    <%}else{%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "userList.jsp";
    });
    <%
         }
    }
    %>
</script>
</html>
