<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jdbc.business.system.clsProvinceBus" %>
<%@ page import="com.ninemax.jpa.system.bo.BzjgdmBo" %>
<%@ page import="com.ninemax.jpa.system.bo.PoliticalLandscapeBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.system.model.Bzjgdm" %>
<%@ page import="com.ninemax.jpa.system.model.PoliticalLandscape" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.code.dao.TZrxzqhDAO" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.List" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    UserGroupBo userGroupBo = new UserGroupBo();
    UserBo userBo = new UserBo();
    String paramString = request.getQueryString();
    List<UserGroup> groups = userGroupBo.findAll();//全部用户组

    String userClassID = "";

    String user_id = request.getParameter("user_id");
    int _user_id = 0;
    if (!clsStringTool.isEmpty(user_id)) {
        _user_id = Integer.parseInt(user_id);
    }
    User user = userBo.findById(_user_id);


    String user_groupId = clsStringTool.convertNull(user.getUsergroupId());

    String user_groupName = "";

    if (!clsStringTool.isEmpty(user_groupId)) {
        user_groupName = userGroupBo.findById(Integer.valueOf(user_groupId)).getUsergroupName();
    }

    String sex = user.getUserSex();

    if ("1".equals(sex)) sex = "男";
    if ("0".equals(sex)) sex = "女";

    BzjgdmBo bzjgdmBo = new BzjgdmBo();
    String ssfzx = "";
    String ssbzd = "";
    String userClass="";
    String zrxzqu="";
    clsProvinceBus provinceBus = new clsProvinceBus();

    ssfzx = user.getUserProvince();
    ssbzd = user.getBzjgdm();
    if(!"".equals(user.getUserClass())&&user.getUserClass()!=null){
    userClass=user.getUserClass().equals("1")?"一级":"二级";
    }
    zrxzqu=user.getZrxzqu();
    if (!clsStringTool.isEmpty(ssfzx)) {
        //true是市级办证机构，否则省直辖市及办证机构
      //  if (provinceBus.isSjFlag(ssfzx.substring(0, 4) + "00")) {
       //     ssfzx = provinceBus.getProvinceName(ssfzx.substring(0, 4) + "00");
      //  } else
            ssfzx = provinceBus.getProvinceName(ssfzx.substring(0, 2) + "0000");

    }
    if (!clsStringTool.isEmpty(ssbzd)) {
       // Bzjgdm bzjgdm = bzjgdmBo.findById(ssbzd);
        TZrxzqhDAO tDao=new TZrxzqhDAO();
        Bzjgdm bzjg=tDao.findById(ssbzd);
        if (bzjg != null) {
            ssbzd = bzjg.getMc();
        }
    } else {
        ssbzd = "";
    }
    if (!clsStringTool.isEmpty(zrxzqu)) {
       // Bzjgdm bzjgdm = bzjgdmBo.findById(ssbzd);
        TZrxzqhDAO tDao=new TZrxzqhDAO();
        Bzjgdm bzjg=tDao.findById(zrxzqu);
        if (bzjg != null) {
        	zrxzqu = bzjg.getMc();
        }
    } else {
    	zrxzqu = "";
    }
    String user_politics = clsStringTool.convertNull(user.getUserPolitics());
    int _user_politics = 0;
    if (!clsStringTool.isEmpty(user_politics)) {
        _user_politics = Integer.valueOf(user_politics);
    }
    PoliticalLandscapeBo politicalLandscapeBo = new PoliticalLandscapeBo();
    //PoliticalLandscape politicalLandscape = politicalLandscapeBo.findById(_user_politics);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/UserBus.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/product/js/user.js'></script>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type="text/javascript" src="/product/js/city.js"></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户管理 &gt;&gt; 查看用户</div>
<form method="post" action="" name="userForm">
    <div id="box">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                        <tr class="table1_tr1">
                            <td width="16%" class="table1_td1">用户名：</td>
                            <td width="34%"><%=user.getUserName() %>
                            </td>
                            <td class="table1_td1" nowrap>真实姓名：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserChinesename()) ? "" : user.getUserChinesename()%>
                            </td>
                        </tr>

                        <tr class="table1_tr1">
                            <td class="table1_td1">密码查询问题：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserLostpwshow()) ? "" : user.getUserLostpwshow()%>
                            </td>
                            <td class="table1_td1" nowrap>密码查询答案：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserShowproblem()) ? "" : user.getUserShowproblem()%>
                            </td>
                        </tr>
                        <tr class="table1_tr1">
                            <td class="table1_td1">用户组：</td>
                            <td>
                                <%=user_groupName %>
                            </td>
                            <td class="table1_td1">通讯地址：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserAddress()) ? "" : user.getUserAddress()%>
                            </td>
                        </tr>

                        <tr class="table1_tr1">
                            <td class="table1_td1">级别：</td>
                            <td><%=userClass %>
                            </td>
                            <td class="table1_td1">所属办证点：</td>
                            <td><%=ssbzd %>
                            </td>
                        </tr>
                        <tr class="table1_tr1">
                            <td class="table1_td1">批准机构名称：</td>
                            <td><%=zrxzqu %>
                            </td>
                            <td class="table1_td1">CA用户：</td>
                            <td><%=clsStringTool.isEmpty(user.getCncode()) ? "" : user.getCncode()%>
                            </td>
                        </tr>
                        <tr class="table1_tr1">
                            <td class="table1_td1">出生日期：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserBirthday()) ? "" : user.getUserBirthday()%>
                            </td>
                            <td class="table1_td1">性别：</td>
                            <td><%=clsStringTool.isEmpty(sex)? "" : sex %>
                            </td>
                        </tr>
                        <tr class="table1_tr1">
                             <td class="table1_td1">手机：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserMobile()) ? "" : user.getUserMobile()%>
                            </td>
                            <td class="table1_td1">电子邮箱：</td>
                            <td><%=clsStringTool.isEmpty(user.getUserEmail()) ? "" : user.getUserEmail()%>
                            </td>
                        </tr>


                    </table>
                </div>
                <div class="listbtn">
                    <input name="button3" type="button" class="newBtn1" id="button3" value="返 回"
                           onclick="javascript:document.location.href='userList.jsp?<%=paramString %>'"/>

                </div>
            </div>
        </div>
    </div>
</form>
</body>

</html>
