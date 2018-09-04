<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.Role" %>
<%@ page import="com.ninemax.jpa.system.bo.RoleBo" %>
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
    RoleBo roleBo = new RoleBo();
    clsPageComponent pageComponent = new clsPageComponent();
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

    if (clsStringTool.isEmpty(searchField)) searchField = "roleName";
    if (clsStringTool.isEmpty(searchValue)) searchValue = "";
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }

    int pageNo = Integer.parseInt(pageno);

    List<Role> list = roleBo.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
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
     *  040403 用户组管理
     *  04040301 添加 04040302 修改 04040303 删除 04040304 查看 04040305 分配角色
     **/
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User user = (User) session.getAttribute("sysUser");

    boolean canAdd = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040301");
    boolean canMod = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040302");
    boolean canDel = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040303");
    boolean canView = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040304");
    boolean canAddRight = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040305");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>角色管理</title>
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
<div class="page_top">系统 &gt;&gt; 用户角色管理 &gt;&gt; 角色管理</div>
<div id="list_main">
    <form name="searchForm" method="post" action="roleList.jsp">
        <input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
        <input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
        <input type="hidden" name="totalPages" value="<%=totalPages%>" id="totalPages"/>
        <input type="hidden" name="currentPage" value="<%=currentPage%>" id="currentPage"/>
        <input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
        <input type="hidden" name="rowNums" value="<%=rowNums%>" id="rowNums"/>

        <div class="list_box">
            <div class="list_box_top">
                <label for="searchField">查询字段：</label>
                <select name="searchField" id="searchField" class="input_120">
                    <option value="roleName" <%if ("roleName".equals(searchField)) out.println("selected");%>>角色名称
                    </option>
                    <option value="roleMemo" <%if ("roleMemo".equals(searchField)) out.println("selected");%>>详细描述
                    </option>
                </select>

                <input name="searchValue" type="text" class="input_120" id="searchValue" value="<%=searchValue%>"/>
                <input name="button2" type="button" class="newBtn1" id="button2" onclick="checkForm();" value="查 询"/>
                <%if (canAdd) {%>
                <input name="button" type="button" class="newBtn1" id="button" value="新 增"
                       onclick="startAction('addRole.jsp');"/>
                <%} %>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">序号</td>

                    <%if (orderbyColum.equals("roleName")) {%>
                    <td class="list_table_top_td">
                        <div style="float:left">角色名称</div>
                        <div class="jt_box" style="float:right">
                            <%if(orderbyMethod.equals("desc")){%><!--排序字段是否降序排序-->
                            <a href="#" onclick="pageSort('roleName','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="排序字段"/></a>
                            <%} else {%>
                            <a href="#" onclick="pageSort('roleName','desc')"><img src="../images/jt_1.gif" width="16"
                                                                                   height="16" title="排序字段"/></a>
                            <%}%>
                        </div>
                    </td>
                    <%} else {%>
                    <td class="list_table_top_td">
                        <div style="float:left">角色名称</div>
                        <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('roleName','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <%}%>
                    <td class="list_table_top_td">权限分配</td>


                    <td class="list_table_top_td" align="center">查看</td>
                    <td class="list_table_top_td" align="center">修改</td>
                    <td class="list_table_top_td" align="center">删除</td>
                </tr>

                <%
                    int user_crsIndex = 0;
                    for (Role r : list) {
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
                    <td><%=r.getRoleName() %>
                    </td>
                    <td>
                        <%if (canAddRight) { %>
                        <a href="rightManage.jsp?role_id=<%=r.getRoleId()%>" target="_self"><font
                                color="red">分配权限</font></a>
                        <%} else { %>
                        <a href="#" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});" style="cursor:pointer">分配权限</a>
                        <%} %>
                    </td>
                    <td align="center"><a href="#">
                        <%if (canView) {%>
                        <img src="../../images/icon_chakan.gif" width="16" height="16"
                             onclick="window.location.href='viewRole.jsp?role_id=<%=r.getRoleId()%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                             style="cursor:pointer" title="查看"/>
                        <%} else { %>
                        <img src="../../images/icon_chakan1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                             style="cursor:pointer" title="查看"/>
                        <%} %>
                    </a></td>
                    <td align="center"><a href="#">
                        <%if (canMod) {%>
                        <img src="../../images/icon_edit.gif" width="16" height="16"
                             onclick="window.location.href='modifyRole.jsp?role_id=<%=r.getRoleId()%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                             style="cursor:pointer" title="修改"/>
                        <%} else { %>
                        <img src="../../images/icon_edit1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                             style="cursor:pointer" title="修改"/>
                        <%} %>
                    </a></td>
                    <td align="center"><a href="#">
                        <%if (canDel) {%>
                        <img src="../../images/icon_del.gif"
                             onclick="ymPrompt.confirmInfo('确认删除信息?',330,220,'提示信息',function (data){if(data == 'ok'){delRoleAjax('/action/RoleAction?method=delete&role_id=<%=String.valueOf(r.getRoleId())%>');}else{return false;}})"
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
                    <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="checkForm()"
                           style="cursor:pointer"/>
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
