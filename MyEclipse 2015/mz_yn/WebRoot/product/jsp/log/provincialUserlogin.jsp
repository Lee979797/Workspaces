<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserBus" %>
<%@ page import="com.ninemax.jpa.system.bo.UserLogin_logBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.model.UserLogin_log" %>
<%@ page import="com.ninemax.jpa.util.DateProcess" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.List" %>
<%
    response.setHeader("Cache-Control","Public");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    UserLogin_logBo userLogin_logBo = new UserLogin_logBo();
    clsUserBus userBus = new clsUserBus();

    clsPageComponent pageComponent = new clsPageComponent();
    String searchField = request.getParameter("searchField");//��ѯ�ֶ�
    String searchValue = request.getParameter("searchValue");//��ѯ��
    String userLoginValue = request.getParameter("userLoginValue");
    String pageno = request.getParameter("pageno");//��ǰҳ��
    String orderbyColum = request.getParameter("orderbyColum");//�����ֶ�
    String orderbyMethod = request.getParameter("orderbyMethod");//�������
    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");
    int rowNums = Integer.parseInt(request.getParameter("rowNums") != null ? request.getParameter("rowNums") : "0");
    if (clsStringTool.isEmpty(orderbyColum)) {
        orderbyColum = "";
    }
    if (clsStringTool.isEmpty(orderbyMethod)) {
        orderbyMethod = "";
    }
    int pageSize = 15;
    if (rowNums > 0) pageSize = rowNums;

    if (clsStringTool.isEmpty(searchField)) searchField = "username";
    if (clsStringTool.isEmpty(searchValue)) searchValue = "";
    if (clsStringTool.isEmpty(userLoginValue)) userLoginValue = "";
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }
    if (clsStringTool.isEmpty(startDate)) startDate = DateProcess.afterNDay(-300);
    if (clsStringTool.isEmpty(endDate)) endDate = clsStringTool.getNowDate();

    int pageNo = Integer.parseInt(pageno);

    List<UserLogin_log> list = userLogin_logBo.findPageList(searchField, searchValue, userLoginValue, startDate, endDate, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    int totalSize = pageComponent.getTotalSize(); //�ܼ�¼��
    int totalPages = pageComponent.getTotalPages(); //��ҳ��
    int currentPage = pageComponent.getCurrentPage(); //��ǰҳ
    int lastPage = pageComponent.getLastPage();
    int rowNumber = 0;
    String paramString = "";
    if (request.getQueryString() != null) {
        paramString = "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="../frame/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src='../../js/page_common.js'></script>
    <script type='text/javascript' src='../../js/userlogin.js'></script>
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
<div class="page_top">ϵͳ &gt;&gt; ��־��ѯ &gt;&gt; ʡ���û���¼��־</div>
<div id="list_main">
<form name="searchForm" method="post">

<input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
<input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
<input type="hidden" name="totalPages" value="<%=totalPages%>" id="totalPages"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>" id="currentPage"/>
<input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
<input type="hidden" name="rowNums" value="<%=rowNums%>" id="rowNums"/>

<div class="list_box">
<div class="list_box_top">
    <input name="textfield2" type="text" class="input_120" style="display:none"/>

    ��¼�û�����
    <input type="hidden" name="searchField" id="searchField"/>
    <input name="searchValue" type="text" class="input_120" id=searchValue value="<%=searchValue%>"/>
    �û�����
    <input name="userLoginValue" type="text" class="input_120" value="<%=userLoginValue%>"/>

    <label>

        <input name="textfield2" type="text" class="input_120" style="display:none"/>
        ��ʼ���ڣ�
        <label>
            <input id="CalendarSelector1" readOnly name="startDate" type="text" value="<%=startDate%>"
                   class="input_120" onfocus="WdatePicker({el:'CalendarSelector1'})"/><IMG
                src="../images/icon_day.gif" style="cursor:pointer;" align=absMiddle
                onClick="WdatePicker({el:'CalendarSelector1'})"/>
        </label>
        �������ڣ�
        <label>
            <input id="CalendarSelector2" readOnly name="endDate" value="<%=endDate%>" type="text"
                   class="input_120" onfocus="WdatePicker({el:'CalendarSelector2'})"/><IMG
                src="../images/icon_day.gif" style="cursor:pointer;" align=absMiddle
                onClick="WdatePicker({el:'CalendarSelector2'})"/>
        </label>
        <input name="button2" type="button" class="newBtn1" onclick="checkForm()" value="�� ѯ"/>
        <input name="button" type="submit" class="newBtn1" value="�� ��" style="display:none"/>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr class="list_table_top">
        <td class="list_table_top_td">���</td>

        <%if (orderbyColum.equals("userid")) {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼�û���</div>
            <div class="jt_box" style="float:right">
                <%if(orderbyMethod.equals("desc")){%><!--�����ֶ��Ƿ�������-->
                <a href="#" onclick="pageSort('userid','asc')"><img src="../images/jt_2.gif" width="16"
                                                                    height="16" title="�����ֶ�"/></a>
                <%} else {%>
                <a href="#" onclick="pageSort('userid','desc')"><img src="../images/jt_1.gif" width="16"
                                                                     height="16" title="�����ֶ�"/></a>
                <%}%>
            </div>
        </td>
        <%} else {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼�û���</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('userid','asc')"><img src="../images/jt_2.gif" width="16"
                                                                    height="16" title="�����ֶ�"/></a>
            </div>
        </td>
        <%}%>

        <%if (orderbyColum.equals("username")) {%>
        <td class="list_table_top_td">
            <div style="float:left">�û���</div>
            <div class="jt_box" style="float:right">
                <%if(orderbyMethod.equals("desc")){%><!--�����ֶ��Ƿ�������-->
                <a href="#" onclick="pageSort('username','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="�����ֶ�"/></a>
                <%} else {%>
                <a href="#" onclick="pageSort('username','desc')"><img src="../images/jt_1.gif" width="16"
                                                                       height="16" title="�����ֶ�"/></a>
                <%}%>
            </div>
        </td>
        <%} else {%>
        <td class="list_table_top_td">
            <div style="float:left">�û���</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('username','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="�����ֶ�"/></a>
            </div>
        </td>
        <%}%>


        <%if (orderbyColum.equals("userIp")) {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼IP</div>
            <div class="jt_box" style="float:right">
                <%if(orderbyMethod.equals("desc")){%><!--�����ֶ��Ƿ�������-->
                <a href="#" onclick="pageSort('userIp','asc')"><img src="../images/jt_2.gif" width="16"
                                                                    height="16" title="�����ֶ�"/></a>
                <%} else {%>
                <a href="#" onclick="pageSort('userIp','desc')"><img src="../images/jt_1.gif" width="16"
                                                                     height="16" title="�����ֶ�"/></a>
                <%}%>
            </div>
        </td>
        <%} else {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼IP</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('userIp','asc')"><img src="../images/jt_2.gif" width="16"
                                                                    height="16" title="�����ֶ�"/></a>
            </div>
        </td>
        <%}%>


        <%if (orderbyColum.equals("logindate")) {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼ʱ��</div>
            <div class="jt_box" style="float:right">
                <%if(orderbyMethod.equals("desc")){%><!--�����ֶ��Ƿ�������-->
                <a href="#" onclick="pageSort('logindate','asc')"><img src="../images/jt_2.gif" width="16"
                                                                       height="16" title="�����ֶ�"/></a>
                <%} else {%>
                <a href="#" onclick="pageSort('logindate','desc')"><img src="../images/jt_1.gif" width="16"
                                                                        height="16" title="�����ֶ�"/></a>
                <%}%>
            </div>
        </td>
        <%} else {%>
        <td class="list_table_top_td">
            <div style="float:left">��¼ʱ��</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('logindate','asc')"><img src="../images/jt_2.gif" width="16"
                                                                       height="16" title="�����ֶ�"/></a>
            </div>
        </td>
        <%}%>

    </tr>

    <%
        int user_crsIndex = 0;
        for (UserLogin_log u : list) {
        //    if (u.getUserIp() != null && (u.getUserIp().contains("0:0:0:0:0:0:0:1") || u.getUserIp().contains("127.0.0.1") || u.getUserIp().startsWith("127"))) {
          //      continue;
           // }
            user_crsIndex++;
            rowNumber = pageSize * (currentPage - 1) + user_crsIndex;
            String userID = u.getUserid();
            User user = userBus.FindUserById(userID);
            String chineseName = "";
            if (user != null) {
                chineseName = user.getUserChinesename();
            }
            if (rowNumber % 2 == 1) {
    %>
    <tr class="list_tr">

            <%}else{%>
    <tr class="list_tr2">
        <%}%>
        <td>&nbsp;<%=rowNumber%>
        </td>
        <td><%=u.getUsername()%>
        </td>
        <td><%=chineseName%>
        </td>
        <td><%="0:0:0:0:0:0:0:1".equals(clsStringTool.convertNull(u.getUserIp())) ? "127.0.0.1" : u.getUserIp() %>
        </td>
        <td><%=u.getLogindate() %>
        </td>


    </tr>

    <%}%>

</table>
<div class="list_ym">
    <div class="left pageLeft">�� <%=totalSize%> ����¼ ��<%=totalPages%>ҳ ��<%=currentPage%>ҳ</div>
    <div class="right">

        <%if (pageComponent.hasPreviousPage()) {%>
        <input name="button" onclick="firstPage()" type="button" class="list_ym_btn" id="button" value="��ҳ"
               style="cursor:pointer"/>
        <%} else {%>
        <input name="button" class="list_ym_btn" type="button" id="button" value="��ҳ" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        <%if (pageComponent.hasPreviousPage()) {%>
        <input name="button2" class="list_ym_btn" type="button" id="button2" value="��һҳ"
               onClick="previousPage();" style="cursor:pointer"/>
        <%} else {%>
        <input name="button2" class="list_ym_btn" type="button" id="button2" value="��һҳ" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        <%if (pageComponent.hasNextPage()) {%>
        <input name="button3" class="list_ym_btn" type="button" id="button3" value="��һҳ"
               onClick="nextPage();" style="cursor:pointer"/>
        <%} else {%>
        <input name="button3" class="list_ym_btn" type="button" id="button3" value="��һҳ" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        <%if (pageComponent.hasNextPage()) {%>

        <input name="button4" class="list_ym_btn" type="button" id="button4" value="βҳ" onClick="endPage();"
               style="cursor:pointer"/>
        <%} else {%>
        <input name="button4" class="list_ym_btn" type="button" id="button4" value="βҳ" style="cursor:pointer"
               disabled="disabled"/>
        <%}%>
        ת��
        <input value="<%=currentPage%>" name="pageno" type="text" class="input_ym"/>
        ҳ
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
        </select>��
    </div>
</div>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</form>
</div>
</body>
</html>
