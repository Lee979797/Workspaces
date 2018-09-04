<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jdbc.business.system.clsProvinceBus" %>
<%@ page import="com.ninemax.jdbc.to.system.clsProvinceTO" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.system.model.PoliticalLandscape" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    UserGroupBo userGroupBo = new UserGroupBo();
    List<UserGroup> groups = userGroupBo.findAll();//全部用户组
    String centerId = ((User) session.getAttribute("sysUser")).getBzjgdm();
    clsProvinceBus provinceBus = new clsProvinceBus();
%>
<c:set value="<%=InitSysParams.bzjgdmMap%>" var="bzjgMap"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
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
    <style type="text/css">
        table.table_bj1 td{height:38px;}
    </style>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户管理 &gt;&gt; 新增用户</div>
<form method="post" action="/action/UserAction" name="userForm">
<input type="hidden" name="method" value="add"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>"/>
<input type="hidden" name="firstXzqh" value="<%=centerId%>"/>
<input type="hidden" name="certId" value=""/>
<input type="hidden" name="userLevel" value="0"/>
<input type="hidden" name="item1" value="totalWebSite"/>
<input type="hidden" name="userCompanyAddress" value=" "/>
<input type="hidden" name="userNature" value="0"/>
<input type="hidden" name="userKind" value="1"/>
<input type="hidden" name="userStatus" value="0"/>
<input type="hidden" name="printName" id="printName"/>

<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
<tr class="table1_tr1">
    <td width="15%" class="table1_td1">用户名<span style="color: #FF0000">(*)</span>：</td>
    <td  style="position:relative;display:block;overflow:visible;">
        <input type="text" id="userName" name="userName" maxlength="10" size="30" isnull="false"
                           onBlur="checkName()" class="page_input2"/>
        <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userDiv"></span>
    </td>
    <td width="15%" class="table1_td1" nowrap>真实姓名<span style="color: #FF0000">(*)</span>：</td>
    <td ><input type="text" name="userChinesename" maxlength="30" size="30" isnull="false"
               class="page_input2">
    </td>
</tr>
<tr class="table1_tr1">
    <td class="table1_td1">密码<span style="color: #FF0000">(*)</span>：</td>
    <td><input type="password" name="user_password1" maxlength="16" isnull="false" size="30"
               class="page_input2"/></td>
    <td class="table1_td1">确认密码<span style="color: #FF0000">(*)</span>：</td>
    <td style="position:relative;display:block;overflow:visible;">
        <input type="password" name="user_password2" maxlength="16" size="30" isnull="false"
               onBlur="checkPassword2(this.value)" class="page_input2"/>
        <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="pwd2Div"></span>
    </td>
</tr>
<!-- 
<tr class="table1_tr1">
    <td class="table1_td1">密码查询问题<span style="color: #FF0000">(*)</span>：</td>
    <td><input type="text" name="userLostpwshow" maxlength="16" size="30" isnull="false"
               class="page_input2"/>
    </td>
    <td class="table1_td1" nowrap>密码查询答案<span style="color: #FF0000">(*)</span>：</td>
    <td><input type="text" name="userShowproblem" maxlength="16" size="30" isnull="false"
               class="page_input2">
    </td>
</tr>
 -->
<tr class="table1_tr1">
    <td class="table1_td1">用户组<span style="color: #FF0000">(*)</span>：</td>
    <td>
        <select name="usergroupId" id="usergroupId">
            <option value="">---请选择用户组---</option>
            <%
                if (groups != null && groups.size() > 0) {
                    for (UserGroup u : groups) {

            %>
            <option value="<%=u.getUsergroupId() %>"><%=u.getUsergroupName() %>
            </option>
            <%
                    }

                }%>
        </select>
    </td>
    <td class="table1_td1">通讯地址：</td>
    <td><input type="text" name="userAddress" maxlength="30" size="30" isnull="false" class="page_input2"/>
    </td>
</tr>
<tr class="table1_tr1">
    
    <td class="table1_td1">行政区划<span style="color: #FF0000">(*)</span>：</td>
    <td><span id="branchDiv"></span>
        <select id="zrxzqu" name="zrxzqu" style="width: 192px">
            <option value="">选择</option>
            <%

                /*举例当前页面得到的 city ID*/
                ArrayList twoXzqhs = null;
                String bzjgdm = centerId;
                if (!clsStringTool.isEmpty(bzjgdm)) {
                    //true为市级办证机构
                    //if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                      //  twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 4) + "00");
                   // } else
                        twoXzqhs = provinceBus.ListAll();
                }
                if (twoXzqhs != null && twoXzqhs.size() > 0) {
                    for (Object twoXzqh : twoXzqhs) {
                        clsProvinceTO provinceTO = (clsProvinceTO) twoXzqh;

            %>
            <option value="<%=provinceTO.getId() %>"><%=provinceTO.getId() + ":" + provinceTO.getProvinceName()%>
            </option>
            <%
                    }
                }
            %>
        </select></td>
           <td class="table1_td1">CA用户：</td>
        <td><input type="text" name="cncode" maxlength="20" size="30" isnull="false" class="page_input2"></td>
</tr>
<tr class="table1_tr1">

    <td class="table1_td1">批准机构名称<span style="color: #FF0000">(*)</span>：</td>
    <td><span id="branchDiv"></span>
        <select id="bzjgdm" name="bzjgdm" style="width: 192px">
            <option value="">选择</option>
            <%

                /*举例当前页面得到的 city ID*/
                 bzjgdm = centerId;
                if (!clsStringTool.isEmpty(bzjgdm)) {
                    //true为市级办证机构
                   // if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                     //   twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 4) + "00");
                    //} else
                        twoXzqhs = provinceBus.ListTwoAll(bzjgdm.substring(0, 2) + "0000");
                }
                if (twoXzqhs != null && twoXzqhs.size() > 0) {
                    for (Object twoXzqh : twoXzqhs) {
                    	clsProvinceTO   provinceTO = (clsProvinceTO) twoXzqh;

            %>
            <option value="<%=provinceTO.getId() %>"><%= provinceTO.getProvinceName()%>
            </option>
            <%
                    }
                }
            %>
        </select></td>
         
     <td class="table1_td1">性别：</td>
    <td><input type="radio" name="userSex" value="1" checked/>
        男
        <input type="radio" name="userSex" value="0"/>
        女
    </td>
</tr>
<tr class="table1_tr1">
    <td class="table1_td1">出生日期：</td>
    <td><input type="text" id="CalendarSelector2" name="userBirthday" maxlength="10" size="26"
               isnull="false" onclick="WdatePicker({el:'CalendarSelector2'})"
            />
        <IMG src="../images/icon_day.gif" style="cursor:pointer;" align=absMiddle
             onclick="WdatePicker({el:'CalendarSelector2'})"/></td>
             
    <td class="table1_td1">电子邮箱：</td>
    <td style="position:relative;display:block;overflow:visible;">
        <input type="text" name="userEmail" id="userEmail" maxlength="40" size="30" isnull="false" onblur="valifyEmail()"
               class="page_input2"/>
        <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userEmailInfo"></span>
    </td>
   
</tr>
<tr class="table1_tr1">
    <td class="table1_td1">手机：</td>
    <td style="position:relative;display:block;overflow:visible;">
        <input type="text" name="userMobile" id="userMobile" maxlength="20" size="30" isnull="false" class="page_input2">
        <span  style="position:absolute; top:30px;left:0px; color: #FF0000;" id="userPhoneInfo"></span>
    </td>

</tr>




</table>

</div>
<div class="listbtn">
    <input name="button" type="button" class="newBtn1" id="saveButton" value="保 存"
           onClick="checkForm('add');"/>
    <input name="button2" type="button" class="newBtn1" id="button2" value="重 填" onclick="userForm.reset()"/>
    <input name="button3" type="button" class="newBtn1" id="button3" value="返 回"
           onclick="location.href='userList.jsp'"/>
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
         if("AddRegUserSuc".equals(request.getParameter("msg").trim())){
    %>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "userList.jsp";
    });
    <%}else{%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330, 220, '提示信息', function () {
        window.location.href = "userList.jsp";
    });
    <%
         }
    }
    %>
</script>
</html>
