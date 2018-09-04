<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.UserGroup" %>
<%@ page import="com.ninemax.jpa.system.bo.UserGroupBo" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    //--end
    UserGroupBo userGroupBo = new UserGroupBo();
    clsPageComponent pageComponent = new clsPageComponent();

    String usergroupKind = request.getParameter("usergroupKind");
    String searchField = request.getParameter("searchField");//查询字段
    String searchValue = request.getParameter("searchValue");//查询词
    String pageno = request.getParameter("pageno");//当前页数
    String orderbyColum = request.getParameter("orderbyColum");//排序字段
    String orderbyMethod = request.getParameter("orderbyMethod");//排序规则
    int rowNums = Integer.parseInt(request.getParameter("rowNums") != null ? request.getParameter("rowNums") : "0");
    if (clsStringTool.isEmpty(orderbyColum)) {
        orderbyColum = "";
    }
    if (clsStringTool.isEmpty(orderbyMethod)) {
        orderbyMethod = "";
    }
    int pageSize = 15;
    if (rowNums > 0) pageSize = rowNums;
    if (clsStringTool.isEmpty(usergroupKind)) usergroupKind = "-1";
    if (clsStringTool.isEmpty(searchField)) searchField = "usergroupName";
    if (clsStringTool.isEmpty(searchValue)) searchValue = "";
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }

    int pageNo = Integer.parseInt(pageno);

    List<com.ninemax.jpa.system.model.UserGroup> list = userGroupBo.findPageList(searchField, searchValue, usergroupKind, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    int totalSize = pageComponent.getTotalSize(); //总记录数
    int totalPages = pageComponent.getTotalPages(); //总页数
    int currentPage = pageComponent.getCurrentPage(); //当前页
    int lastPage = pageComponent.getLastPage();
    int rowNumber = 0;
    String paramString = "";
    if (request.getQueryString() != null) {
        paramString = "?" + request.getQueryString();
    }

    //权限
    /**
     *权限说明
     *  040402 用户组管理
     *  04040201 添加 04040202 修改 04040203 删除 04040204 查看 04040205 分配角色
     **/
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User user = (User) session.getAttribute("sysUser");

    boolean canAdd = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040201");
    boolean canMod = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040202");
    boolean canDel = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040203");
    boolean canView = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040204");
    boolean canAddRole = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040205");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>用户组管理</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/product/js/delete_ajax.js'></script>
    <script type='text/javascript' src='/js/page_common.js'></script>
    <script type='text/javascript' src='/product/js/userlist.js'></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#searchValue").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		checkForm();
		}
	   }
	</script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 用户组管理</div>
<div id="list_main">
<form name="searchForm" method="post" action="groupList.jsp">
<input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
<input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
<input type="hidden" name="usergroupKind" value="<%=usergroupKind%>" id="usergroupKind"/>
<input type="hidden" name="totalPages" value="<%=totalPages%>" id="totalPages"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>" id="currentPage"/>
<input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
<input type="hidden" name="rowNums" value="<%=rowNums%>" id="rowNums"/>

<div class="list_box">
    <div class="list_box_top">

        <label for="searchField">查询字段：</label>
        <select id="searchField" name="searchField" class="input_120">
            <option value="usergroupName" <%if ("usergroupName".equals(searchField)) out.println("selected");%>>
                组名称
            </option>
            <option value="usergroupMemo" <%if ("usergroupMemo".equals(searchField)) out.println("selected");%>>
                详细描述
            </option>
        </select>
        <input name="searchValue" type="text" class="input_120" id="searchValue" value="<%=searchValue%>"/>
        <input name="textfield3" type="text" class="input_120" id="textfield3" style="display:none"/>
        <input name="button2" type="button" class="newBtn1" id="button2" onclick="checkForm();" value="查 询"/>
        <%if (canAdd) {%>
        <input name="button" type="button" class="newBtn1" id="button" value="新 增"
               onclick="startAction('AddGroup.jsp');"/>
        <%} %>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr class="list_table_top">
            <td class="list_table_top_td" style="width:5%">序号</td>
            <%
                if (orderbyColum.equals("usergroupName")) {
            %>
            <td class="list_table_top_td">
                <div style="float:left">组名称</div>
                <div class="jt_box" style="float:right">
                    <%
        	if(orderbyMethod.equals("desc")){
        %><!--排序字段是否降序排序-->
                    <a href="#" onclick="pageSort('usergroupName','asc')"><img src="../images/jt_2.gif"
                                                                               width="16" height="16"
                                                                               title="排序字段"/></a>
                    <%
                    } else {
                    %>
                    <a href="#" onclick="pageSort('usergroupName','desc')"><img src="../images/jt_1.gif"
                                                                                width="16" height="16"
                                                                                title="排序字段"/></a>
                    <%
                        }
                    %>
                </div>
            </td>
            <%
            } else {
            %>
            <td class="list_table_top_td">
                <div style="float:left">组名称</div>
                <div class="jt_box" style="float:right">
                    <a href="#" onclick="pageSort('usergroupName','asc')"><img src="../images/jt_2.gif"
                                                                               width="16" height="16"
                                                                               title="排序字段"/></a>
                </div>
            </td>
            <%
                }
            %>
            <td class="list_table_top_td" align="center">角色分配</td>


            <td class="list_table_top_td" align="center">查看</td>
            <td class="list_table_top_td" align="center">修改</td>
            <td class="list_table_top_td" align="center">删除</td>
        </tr>


        <%
            int user_crsIndex = 0;
            for (UserGroup u : list) {
                String userGroupID = "";
                userGroupID = String.valueOf(u.getUsergroupId());
                user_crsIndex++;
                rowNumber = pageSize * (currentPage - 1) + user_crsIndex;

                //权限
                //   clsRightKeyTO rightKeyTO = rightKeyBus.GetRightKey(oper_rightkey);
                //	String rightKeyName = rightKeyTO.getRightKey_name();
                if (rowNumber % 2 == 1) {
        %>
        <tr class="list_tr">

                <%}else{%>
        <tr class="list_tr2">
            <%}%>
            <td>&nbsp;<%=rowNumber%>
            </td>
            <td><%=u.getUsergroupName() %>
            </td>
            <td align="center">
                <%if (canAddRole) { %>
                <a href="manageRole.jsp?group_id=<%=userGroupID %>&group_name=<%=u.getUsergroupName()%>"
                   target="_self">分配</a>
                <%} else { %>
                <a href="#" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});" style="cursor:pointer">分配</a>
                <%} %>
            </td>
            <td align="center"><a href="#">
                <%if (canView) {%>
                <img src="../../images/icon_chakan.gif" width="16" height="16"
                     onclick="window.location.href='viewGroup.jsp?userGroup_id=<%=userGroupID%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                     style="cursor:pointer" title="查看"/>
                <%} else { %>
                <img src="../../images/icon_chakan1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                     style="cursor:pointer" title="查看"/>
                <%} %>
            </a></td>
            <td align="center"><a href="#">
                <%if (canMod) {%>
                <img src="../../images/icon_edit.gif" width="16" height="16"
                     onclick="window.location.href='modifyGroup.jsp?userGroup_id=<%=userGroupID%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                     style="cursor:pointer" title="修改"/>
                <%} else { %>
                <img src="../../images/icon_edit1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                     style="cursor:pointer" title="修改"/>
                <%} %>
            </a></td>
            <td align="center"><a href="#">
                <%if (canDel) {%>
                <img src="../../images/icon_del.gif"
                     onclick="ymPrompt.confirmInfo('确认删除信息?',330,220,'提示信息',function (data){if(data == 'ok'){delGroupAjax('/action/userGroupAction?method=delete&usergroup_id=<%=userGroupID%>');}else{return false;}})"
                     style="cursor:pointer" title="删除"/>
                <%} else { %>
                <img src="../../images/icon_del1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                     style="cursor:pointer" title="删除"/>
                <%} %>
            </a></td>

        </tr>

        <%}%>


            </table>
            <div class="list_ym">
                <div class="left pageLeft">共 <%=totalSize%> 条记录 共<%=totalPages%>页 第<%=currentPage%>页</div>
                <div class="right">

            <%if (pageComponent.hasPreviousPage()) {%>
            <input name="button" onclick="firstPage()" type="button" class="list_ym_btn" id="button" value="首页"
                   style="cursor:pointer"/>
            <%} else {%>
            <input name="button" class="list_ym_btn" type="button" id="button" value="首页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasPreviousPage()) {%>
            <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页"
                   onClick="previousPage();" style="cursor:pointer"/>
            <%} else {%>
            <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasNextPage()) {%>
            <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页"
                   onClick="nextPage();" style="cursor:pointer"/>
            <%} else {%>
            <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            <%if (pageComponent.hasNextPage()) {%>

            <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" onClick="endPage();"
                   style="cursor:pointer"/>
            <%} else {%>
            <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" style="cursor:pointer"
                   disabled="disabled"/>
            <%}%>
            转到
            <input value="<%=currentPage%>" name="pageno" type="text" class="input_ym"/>
            页
            <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="checkForm()" style="cursor:pointer"/>
            <select name="rowNumsView" id="rowNumsView" style="height: 20px;" onchange="commitRowNum()">
                <option value="15" <%
                    if (pageSize == 15) {
                        out.println("selected");
                    }
                %> >15
                </option>
                <option value="20" <%
                    if (pageSize == 20) {
                        out.println("selected");
                    }
                %> >20
                </option>
                <option value="50" <%
                    if (pageSize == 50) {
                        out.println("selected");
                    }
                %> >50
                </option>
            </select>条
        </div>
    </div>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>

</form>

</div>
</body>
</html>
