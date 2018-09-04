<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.Forbidword" %>
<%@ page import="com.ninemax.jpa.system.bo.ForbidwordBo" %>
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
    ForbidwordBo forbidwordBo = new ForbidwordBo();
    clsPageComponent pageComponent = new clsPageComponent();

    String searchField = request.getParameter("searchField");//查询字段
    String searchValue = request.getParameter("keyword");//查询词
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
    if (clsStringTool.isEmpty(searchField)) searchField = "forbidWord";
    if (clsStringTool.isEmpty(searchValue)) searchValue = "";
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }

    int pageNo = Integer.parseInt(pageno);

    List<Forbidword> list = forbidwordBo.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
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
    //权限说明
    // 040201 敏感字过滤
    // 04020101 添加 04020102 修改 04020103 删除

    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User user = (User) session.getAttribute("sysUser");

    boolean canAdd = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04020101");
    boolean canMod = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04020102");
    boolean canDel = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04020103");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src='/product/js/delete_ajax.js'></script>
    <script type='text/javascript' src='../../js/page_common.js'></script>
    <script type='text/javascript' src='../enterpriseinfomation/js/enterprisemanagelistChang.js'></script>
    <script type='text/javascript' src='../../js/forbilist.js'></script>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 应用功能 &gt;&gt; 敏感字过滤</div>
<div id="list_main">

    <form name="searchForm" method="post" action="forbidList.jsp">
        <input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
        <input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
        <input type="hidden" name="totalPages" value="<%=totalPages%>" id="totalPages"/>
        <input type="hidden" name="currentPage" value="<%=currentPage%>" id="currentPage"/>
        <input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
        <input type="hidden" name="rowNums" value="<%=rowNums%>" id="rowNums"/>

        <div class="list_box">
            <div class="list_box_top">

                敏感字：
                <input name="keyword" type="text" class="input_120" id="keyword" value="<%=searchValue%>"/>

                <input name="button2" type="button" class="newBtn1" id="button2" onclick="query();" value="查 询"/>
                <!-- <input name="button3" type="button" class="list_btn_guolvzhixing" id="button3" value="   " /> -->
                <%if (canAdd) {%>
                <input name="button" type="button" class="newBtn1" id="button" value="新 增"
                       onclick="startAction('addForbid.jsp');"/>
                <%} %>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <!--   <td nowrap="nowrap"><input type="checkbox" name="pcheckedall" id="pcheckedall" onclick="allSelected()"></td> -->
                    <td class="list_table_top_td">序号</td>

                    <%if (orderbyColum.equals("forbidWord")) {%>
                    <td class="list_table_top_td">
                        <div style="float:left">敏感字</div>
                        <div class="jt_box" style="float:right">
                            <%if(orderbyMethod.equals("desc")){%><!--排序字段是否降序排序-->
                            <a href="#" onclick="pageSort('forbidWord','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                    height="16" title="排序字段"/></a>
                            <%} else {%>
                            <a href="#" onclick="pageSort('forbidWord','desc')"><img src="../images/jt_1.gif" width="16"
                                                                                     height="16" title="排序字段"/></a>
                            <%}%>
                        </div>
                    </td>
                    <%} else {%>
                    <td class="list_table_top_td">
                        <div style="float:left">敏感字</div>
                        <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('forbidWord','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                    height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <%}%>

                    <%if (orderbyColum.equals("operdate")) {%>
                    <td class="list_table_top_td">
                        <div style="float:left">数据录入时间</div>
                        <div class="jt_box" style="float:right">
                            <%if(orderbyMethod.equals("desc")){%><!--排序字段是否降序排序-->
                            <a href="#" onclick="pageSort('operdate','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="排序字段"/></a>
                            <%} else {%>
                            <a href="#" onclick="pageSort('operdate','desc')"><img src="../images/jt_1.gif" width="16"
                                                                                   height="16" title="排序字段"/></a>
                            <%}%>
                        </div>
                    </td>
                    <%} else {%>
                    <td class="list_table_top_td">
                        <div style="float:left">数据录入时间</div>
                        <div class="jt_box" style="float:right">
                            <a href="#" onclick="pageSort('operdate','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="排序字段"/></a>
                        </div>
                    </td>
                    <%}%>

                    <td class="list_table_top_td" align="center">修改</td>
                    <td class="list_table_top_td" align="center">删除</td>

                </tr>
                <%
                    int user_crsIndex = 0;
                    for (Forbidword f : list) {
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
                    <td><%=f.getForbidWord() %>
                    </td>
                    <td><%=f.getOperdate() %>
                    </td>
                    <td align="center"><a href="#">
                        <%if (canMod) {%>
                        <img src="../../images/icon_edit.gif" width="16" height="16"
                             onclick="window.location.href='modifyForbid.jsp?forbidId=<%=String.valueOf(f.getForbidId()) %>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                             style="cursor:pointer" title="修改"/>
                        <%} else { %>
                        <img src="../../images/icon_edit1.gif" onclick="ymPrompt.alert({message:'您没有权限！', width:330, height:220, title:'提示信息'});"
                             style="cursor:pointer" title="修改"/>
                        <%} %>
                    </a></td>
                    <td align="center"><a href="#">
                        <%if (canDel) {%>
                        <img src="../../images/icon_del.gif"
                             onclick="ymPrompt.confirmInfo('确认删除信息?',330,220,'提示信息',function (data){if(data == 'ok'){deleteAjax('/action/ForbidwordAction?method=delete&forbidId=<%=String.valueOf(f.getForbidId()) %>');}else{return false;}})"
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
                    <input name="button2" class="list_ym_btn" type="button" id="button2" value="上一页"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    <%if (pageComponent.hasNextPage()) {%>
                    <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页"
                           onClick="nextPage();" style="cursor:pointer"/>
                    <%} else {%>
                    <input name="button3" class="list_ym_btn" type="button" id="button3" value="下一页"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    <%if (pageComponent.hasNextPage()) {%>

                    <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页" onClick="endPage();"
                           style="cursor:pointer"/>
                    <%} else {%>
                    <input name="button4" class="list_ym_btn" type="button" id="button4" value="尾页"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    转到
                    <input value="<%=currentPage%>" name="pageno" type="text" class="input_ym"/>
                    <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="checkForm()"
                           style="cursor:pointer"/>

                    页
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
