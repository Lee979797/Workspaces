<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.system.bo.BzjgdmBo" %>
<%@ page import="com.ninemax.jpa.system.model.*" %>
<%@ page import="com.ninemax.jpa.code.dao.TZrxzqhDAO" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="java.text.ParseException" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    //--end
    UserBo userBo = new UserBo();
    clsPageComponent pageComponent = new clsPageComponent();

    String searchField = request.getParameter("searchField");//��ѯ�ֶ�
    String searchValue = request.getParameter("searchValue");//��ѯ��
    String pageno = request.getParameter("pageno");//��ǰҳ��
    String orderbyColum = request.getParameter("orderbyColum");//�����ֶ�
    String orderbyMethod = request.getParameter("orderbyMethod");//�������
    int rowNums = Integer.parseInt(request.getParameter("rowNums") != null ? request.getParameter("rowNums") : "0");
    if (clsStringTool.isEmpty(orderbyColum)) {
        orderbyColum = "";
    }
    if (clsStringTool.isEmpty(orderbyMethod)) {
        orderbyMethod = "";
    }
    int pageSize = 15;
    if (rowNums > 0) pageSize = rowNums;
    if (clsStringTool.isEmpty(searchField)) searchField = "UserName";
    if (clsStringTool.isEmpty(searchValue)) searchValue = "";
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }

    int pageNo = Integer.parseInt(pageno);

    List<User> list = null;
    try {
        list = userBo.findPageList(searchField, searchValue, orderbyColum, orderbyMethod, pageSize, pageNo, pageComponent);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    int totalSize = pageComponent.getTotalSize(); //�ܼ�¼��
    int totalPages = pageComponent.getTotalPages(); //��ҳ��
    int currentPage = pageComponent.getCurrentPage(); //��ǰҳ
    int lastPage = pageComponent.getLastPage();
    int rowNumber = 0;
    //Ȩ��
    /**
     *Ȩ��˵��
     *  040401 �û�����
     *  04040101 ��� 04040102 �޸� 04040103 ɾ�� 04040104 �鿴 04040105 ��ʼ������
     **/
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User user = (User) session.getAttribute("sysUser");

    boolean canAdd = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040101");
    boolean canMod = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040102");
    boolean canDel = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040103");
    boolean canView = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040104");
    boolean canInitPassword = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "04040105");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�û�����</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src='/product/js/delete_ajax.js'></script>
    <script type='text/javascript' src='/product/js/page_common.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/UserBo.js"></script>
    <script type='text/javascript' src='/product/js/userlist.js'></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#searchValue").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		checkForm();
		}
	   }

	   function checkForm(){

		   if(!isNumber(document.searchForm.pageno.value)){
		       ymPrompt.alert('���������֣�',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}})
				return false;
		   }else{
		        var pageCount = parseInt(document.getElementById("totalPages").value);
				if(document.searchForm.pageno.value>pageCount){
		            ymPrompt.alert('�������ֲ��ܴ�����ҳ����',330,220,'��ʾ��Ϣ',function(data){if(data == "ok"){document.searchForm.pageno.focus();}});
					return false;
				}
		   }
		   document.getElementById("pageno").value='1';
		   document.searchForm.submit();
		   }
	</script>

</head>
<body>
<div class="page_top">ϵͳ &gt;&gt; �û���ɫ���� &gt;&gt; �û�����</div>
<div id="list_main">
<form name="searchForm" method="post" action="userList.jsp">
<input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
<input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
<input type="hidden" name="totalPages" value="<%=totalPages%>" id="totalPages"/>
<input type="hidden" name="currentPage" value="<%=currentPage%>" id="currentPage"/>
<input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
<input type="hidden" name="rowNums" value="<%=rowNums%>" id="rowNums"/>

<div class="list_box">
<div class="list_box_top">��ѯ�ֶΣ�
    <select name="searchField">
        <option value="userName" <%if ("userName".equals(searchField)) out.println("selected");%>>�û���
        </option>
        <option value="userChinesename" <%
            if ("userChinesename".equals(searchField)) out.println("selected");%>>����
        </option>
    </select>
    <input name="searchValue" type="text" class="input_120" id="searchValue" value="<%=searchValue%>"/>

    <input name="textfield3" type="text" class="input_120" id="textfield3" style="display:none"/>
    <input name="button2" type="button" class="newBtn1" id="button2" value="�� ѯ" onclick="checkForm();"/>
    <%if (canAdd) {%>
    <input name="button" type="button" class="newBtn1" id="button" value="�� ��"
           onclick="window.location.href='AddUser.jsp'"/>
    <%} %>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr class="list_table_top">
        <td class="list_table_top_td" style="width:5%">���</td>

        <%
            if (orderbyColum.equals("userName")) {
        %>
        <td class="list_table_top_td">
            <div style="float:left">�û���</div>
            <div class="jt_box" style="float:right">
                <%
        	if(orderbyMethod.equals("desc")){
        %><!--�����ֶ��Ƿ�������-->
                <a href="#" onclick="pageSort('userName','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="�����ֶ�"/></a>
                <%
                } else {
                %>
                <a href="#" onclick="pageSort('userName','desc')"><img src="../images/jt_1.gif" width="16"
                                                                       height="16" title="�����ֶ�"/></a>
                <%
                    }
                %>
            </div>
        </td>
        <%
        } else {
        %>
        <td class="list_table_top_td">
            <div style="float:left">�û���</div>
            <div class="jt_box" style="float:right">
                <a href="#" onclick="pageSort('userName','asc')"><img src="../images/jt_2.gif" width="16"
                                                                      height="16" title="�����ֶ�"/></a>
            </div>
        </td>
        <%
            }
        %>


        <td class="list_table_top_td">
            <div style="float:left">����</div>
        </td>
        <td class="list_table_top_td">
            <div style="float:left">������֤�ص�</div>
        </td>
        <!-- 	<td class="list_table_top_td"><div style="float:left">�����û���</div> <a href="#"><div class="jt_box" style="float:right"><img src="../images/jt_2.gif" idth="16" height="16" title="�����ֶ�"/></a></div></td> -->
        <td class="list_table_top_td">
            <div style="float:left">�����ʼ��</div>
        </td>
        <td class="list_table_top_td" align="center">�鿴</td>
        <td class="list_table_top_td" align="center">�޸�</td>
        <td class="list_table_top_td" align="center">ɾ��</td>
    </tr>


    <%
        int user_crsIndex = 0;
        for (User u : list) {
            if ("admin".equals(u.getUserName())) {
                totalSize -= 1;
                continue;
            }
            String userID = "";
            userID = String.valueOf(u.getUserId());
            user_crsIndex++;
            rowNumber = pageSize * (currentPage - 1) + user_crsIndex;


            BzjgdmBo bzjgdmBo = new BzjgdmBo();
            String ssbzd = "";
            ssbzd = u.getBzjgdm();
           // Bzjgdm bzjgdm = bzjgdmBo.findById(ssbzd);
            
            TZrxzqhDAO tDao=new TZrxzqhDAO();
            Bzjgdm bzjg=tDao.findById(ssbzd);
            if (bzjg != null) {
                ssbzd = bzjg.getMc();
            }
            //Ȩ��
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
        <td><%=u.getUserName() %>
        </td>
        <td><%=u.getUserChinesename() %>
        </td>
        <td><%=ssbzd %>
        </td>
        <td>
            <%if (canInitPassword) { %>
            <a href="initPassword.jsp?user_id=<%=userID %>" target="_self">��ʼ������</a>
            <%} else { %>
            <a href="#" onclick="ymPrompt.alert({message:'��û��Ȩ�ޣ�', width:330, height:220, title:'��ʾ��Ϣ'});"
               style="cursor:pointer">��ʼ������</a>
            <%} %>
        </td>

        <td align="center"><a href="#">
            <%if (canView) {%>
            <img src="../../images/icon_chakan.gif" width="16" height="16"
                 onclick="window.location.href='viewUser.jsp?user_id=<%=userID%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                 style="cursor:pointer" title="�鿴"/>
            <%} else { %>
            <img src="../../images/icon_chakan1.gif"
                 onclick="ymPrompt.alert({message:'��û��Ȩ�ޣ�', width:330, height:220, title:'��ʾ��Ϣ'});"
                 style="cursor:pointer" title="�鿴"/>
            <%} %>
        </a></td>
        <td align="center"><a href="#">
            <%if (canMod) {%>
            <img src="../../images/icon_edit.gif" width="16" height="16"
                 onclick="window.location.href='modifyUser.jsp?user_id=<%=userID%>&rowNums=<%=pageSize %>&pageno=<%=pageno %>'"
                 style="cursor:pointer" title="�޸�"/>
            <%} else { %>
            <img src="../../images/icon_edit1.gif"
                 onclick="ymPrompt.alert({message:'��û��Ȩ�ޣ�', width:330, height:220, title:'��ʾ��Ϣ'});"
                 style="cursor:pointer" title="�޸�"/>
            <%} %>
        </a></td>
        <td align="center"><a href="#">
            <%if (canDel) {%>
            <img src="../../images/icon_del.gif"
                 onclick="ymPrompt.confirmInfo('ȷ��ɾ����Ϣ?',330,220,'��ʾ��Ϣ',function (data){if(data == 'ok'){deleteAjax('/action/UserAction?method=delete&user_id=<%=userID%>');}else{return false;}})"
                 style="cursor:pointer" title="ɾ��"/></a>
            <%} else { %>
            <img src="../../images/icon_del1.gif"
                 onclick="ymPrompt.alert({message:'��û��Ȩ�ޣ�', width:330, height:220, title:'��ʾ��Ϣ'});"
                 style="cursor:pointer" title="ɾ��"/>
            <%} %>
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
        <input value="<%=currentPage%>" name="pageno" id="pageno" type="text" class="input_ym"/>
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
