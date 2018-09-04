<%@ page language="java" import="com.ninemax.jdbc.dao.clsPageComponent" pageEncoding="GBK" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.nacao.business.message.SystemMessageBus" %>
<%@ page import="com.ninemax.nacao.to.message.SystemMessageTO" %>
<%@ page import="java.util.ArrayList" %>
<%
    User userSys = (User) session.getAttribute("sysUser");
    SystemMessageBus sysMessBus = new SystemMessageBus();
    clsPageComponent pageComponent = new clsPageComponent();
    String content = request.getParameter("content");
    String delid = request.getParameter("delid");
    String userId = request.getParameter("userId");
    String userName = request.getParameter("userName");
    String orderbyColum = request.getParameter("orderbyColum");//�����ֶ�
    String orderbyMethod = request.getParameter("orderbyMethod");//�������
    String pageSizes = request.getParameter("pageSize");
    UserBo userBo = new UserBo();
    if (clsStringTool.isEmpty(orderbyColum)) {
        orderbyColum = "";
    }
    if (clsStringTool.isEmpty(orderbyMethod)) {
        orderbyMethod = "";
    }
    if (!clsStringTool.isEmpty(orderbyColum) && !clsStringTool.isEmpty(orderbyMethod)) {
        pageComponent.setOrderByContent(" " + orderbyColum + " " + orderbyMethod);
    } else {
        pageComponent.setOrderByContent("oper_date desc");
    }
    if (!clsStringTool.isEmpty(delid)) {
        sysMessBus.delSysMessage(delid, userId, userName);
    }
    int pageSize = 15;
    if (!clsStringTool.isEmpty(pageSizes)) {
        pageSize = Integer.parseInt(pageSizes);
    }
    if (request.getParameter("pageSize") != null) {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    String pageno = request.getParameter("pageno");
    if (clsStringTool.isEmpty(pageno) || "0".equals(pageno)) {
        pageno = "1";
    }
    int pageNo = Integer.parseInt(pageno);
    ArrayList<SystemMessageTO> sysMessList = sysMessBus.listAdministrativeNotice(content, pageNo, pageSize, pageComponent);
    int totalSize = pageComponent.getTotalSize(); //�ܼ�¼��
    int totalPages = pageComponent.getTotalPages(); //��ҳ��
    int currentPage = pageComponent.getCurrentPage(); //��ǰҳ
    int lastPage = pageComponent.getLastPage();
    int rowNumber = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="js/tools.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#textfield").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		checkForm();
		}
	   }
	</script>
    
    <script type="text/javascript">
        function checkForm() {
            if (!isNumber(searchForm.pageno.value)) {
                ymPrompt.alert("���������֣�", 300, 185, "��ʾ��Ϣ", function (data) {
                    if (data == "ok") {
                        searchForm.pageno.focus();
                    }
                });

                return false;
            }
            else {
                var pageCount = <%=totalPages%>;
                if (searchForm.pageno.value > pageCount) {
                    ymPrompt.alert("�������ֲ��ܴ�����ҳ����", 300, 185, "��ʾ��Ϣ", function (data) {
                        if (data == "ok") {
                            searchForm.pageno.focus();
                        }
                    });

                    return false;
                }

            }
            searchForm.submit();
        }

        function previousPage() {

            searchForm.pageno.value = <%=currentPage%>-1;
            searchForm.submit();
        }
        function nextPage() {

            searchForm.pageno.value = <%=currentPage%>+1;
            searchForm.submit();
        }
        function firstPage() {

            searchForm.pageno.value = 1;
            searchForm.submit();
        }
        function lastPage() {

            searchForm.pageno.value = <%=lastPage%>;
            searchForm.submit();
        }
        function refreshPage() {

            searchForm.pageno.value = 1;
            searchForm.submit();
        }
        function pageSort(filed, type) {
            document.getElementById("orderbyColum").value = filed;
            document.getElementById("orderbyMethod").value = type;
            searchForm.submit();
        }
        function endPage() {
            document.searchForm.pageno.value = parseInt(document.getElementById("lastPage").value);
            document.searchForm.submit();
        }
        function del(id) {
            var userId = document.getElementById("userId").value;
            var userName = document.getElementById("userName").value;
            ymPrompt.confirmInfo("ȷ��ɾ��?", 330, 220, "��ʾ��Ϣ", function (data) {
                if (data == 'ok') {
                    window.location.href = "gonggao.jsp?delid=" + id + "&userId=" + userId + "&userName=" + userName;
                }
            });
        }
        function commitRowNum() {
            document.searchForm.pageno.value = 1;
            var types = document.getElementById("rowNumsView");
            document.getElementById("rowNums").value = types.options(types.selectedIndex).value;
            document.searchForm.submit();
        }
        document.onkeypress = function () {
            if (event.keyCode == 13) {
                checkForm();
            }
        };
    </script>

    <style type="text/css">
        <!--
        .STYLE5 {
            color: #FF0000
        }

        -->
    </style>
</head>
<body>
<form name="searchForm" method="get" action="">
    <input type="hidden" name="orderbyColum" value="<%=orderbyColum%>" id="orderbyColum"/>
    <input type="hidden" name="orderbyMethod" value="<%=orderbyMethod%>" id="orderbyMethod"/>
    <input type="hidden" name="pageSize" value="<%=pageSize%>" id="rowNums"/>
    <input type="hidden" name="lastPage" value="<%=lastPage%>" id="lastPage"/>
    <input type="hidden" name="userId" value="<%=userSys.getUserId()%>" id="userId"/>
    <input type="hidden" name="userName" value="<%=userSys.getUserName()%>" id="userName"/>

    <div class="page_top">ϵͳ &gt;&gt; ������� &gt;&gt; �������</div>
    <div id="list_main">
        <div class="list_box">
            <div class="list_box_top">
                �������
                <label for="textfield"></label>
                <input name="content" type="text" class="input_120" id="textfield"/>
                <input name="textfield2" type="text" class="input_120" id="textfield2" style="display:none"/>
                <input name="button2" type="submit" class="newBtn1" value="��  ѯ"/>
                <input name="button" type="button" class="newBtn1" value="��  ��"
                       onclick="window.location.href='news_add.jsp'"/>

            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" width="6%">
                        <div style="float:left">���</div>

                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">�������</div>
                        <div class="jt_box" style="float:right">
                            <%
                             if(orderbyColum.equals("send_title"))
                             {
                             if(orderbyMethod.equals("desc"))
                             {
                             %><!--�����ֶ��Ƿ�������-->
                            <div class="jt_box"><a href="#" onClick="pageSort('send_title','asc')"><img
                                    src="../images/jt_2.gif" width="16" height="16" title="����"/></a></div>
                            <%} else {%>
                            <div class="jt_box"><a href="#" onClick="pageSort('send_title','desc')"><img
                                    src="../images/jt_1.gif" width="16" height="16" title="����"/></a></div>
                            <%
                                }
                            } else {
                            %>
                            <div class="jt_box"><a href="#" onClick="pageSort('send_title','asc')">
                                <img src="../images/jt_2.gif" width="16" height="16" title="����"/></a>
                            </div>
                            <%}%></div>

                    </td>

                    <td class="list_table_top_td">
                        <div style="float:left">����Ա</div>
                        <div class="jt_box" style="float:right"><%
                         if(orderbyColum.equals("from_person"))
                         {
                         if(orderbyMethod.equals("desc"))
                         {
                         %><!--�����ֶ��Ƿ�������-->
                            <div class="jt_box"><a href="#" onClick="pageSort('from_person','asc')"><img
                                    src="../images/jt_2.gif" width="16" height="16" title="����"/></a></div>
                            <%} else {%>
                            <div class="jt_box"><a href="#" onClick="pageSort('from_person','desc')"><img
                                    src="../images/jt_1.gif" width="16" height="16" title="����"/></a></div>
                            <%
                                }
                            } else {
                            %>
                            <div class="jt_box"><a href="#" onClick="pageSort('from_person','asc')">
                                <img src="../images/jt_2.gif" width="16" height="16" title="����"/></a>
                            </div>
                            <%}%></div>
                    </td>
                    <td class="list_table_top_td">
                        <div style="float:left">���ݸ���ʱ��</div>
                        <div class="jt_box" style="float:right"><%
                             if(orderbyColum.equals("oper_date"))
                             {
                             if(orderbyMethod.equals("desc"))
                             {
                             %><!--�����ֶ��Ƿ�������-->
                            <div class="jt_box"><a href="#" onClick="pageSort('oper_date','asc')"><img
                                    src="../images/jt_2.gif" width="16" height="16" title="����"/></a></div>
                            <%} else {%>
                            <div class="jt_box"><a href="#" onClick="pageSort('oper_date','desc')"><img
                                    src="../images/jt_1.gif" width="16" height="16" title="����"/></a></div>
                            <%
                                }
                            } else {
                            %>
                            <div class="jt_box"><a href="#" onClick="pageSort('oper_date','asc')">
                                <img src="../images/jt_2.gif" width="16" height="16" title="����"/></a>
                            </div>
                            <%}%></div>
                    </td>
                    <td class="list_table_top_td" align="center">�鿴</td>
                    <td class="list_table_top_td" align="center">�޸�</td>
                    <td class="list_table_top_td" align="center">ɾ��</td>
                </tr>
                <%
                    int user_crsIndex = 0;
                    for (SystemMessageTO sysMessage : sysMessList) {
                        user_crsIndex++;
                        String messType = sysMessage.getObject_type();
                        rowNumber = pageSize * (currentPage - 1) + user_crsIndex;
                        String message = sysMessage.getSend_title();
                        User user = userBo.findById(Integer.parseInt(sysMessage.getFrom_person()));
                %>
                <tr class="<%=(rowNumber%2==1?"list_tr":"list_tr2") %>">
                    <td width="4%"><%=rowNumber %>
                    </td>
                    <td width="48%"><span
                            title="<%=message %>"><%=(message != null && message.length() > 20) ? message.substring(0, 20) + "..." : message %></span>
                    </td>
                    <td width="10%"><%=user != null ? user.getUserChinesename() : "" %>
                    </td>
                    <td width="14%"><%=sysMessage.getOper_date() %>
                    </td>
                    <td align="center" width="8%"><a title="�鿴"
                                                     href="detail_news.jsp?id=<%=sysMessage.getSys_id() %>"><img
                            src="../../images/icon_chakan.gif" width="16" height="16"/></a></td>
                    <td align="center" width="8%"><a title="�޸�" href="news_add.jsp?id=<%=sysMessage.getSys_id() %>"><img
                            src="../../images/icon_edit.gif" width="16" height="16"/></a></td>
                    <td align="center" width="8%"><a title="ɾ��" href="#" onclick="del('<%=sysMessage.getSys_id() %>');"><img
                            src="../../images/icon_del.gif"/></a></td>
                </tr>

                <%
                    }
                %>
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
                    <input name="button2" class="list_ym_btn" type="button" id="button2" value="��һҳ"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    <%if (pageComponent.hasNextPage()) {%>
                    <input name="button3" class="list_ym_btn" type="button" id="button3" value="��һҳ"
                           onClick="nextPage();" style="cursor:pointer"/>
                    <%} else {%>
                    <input name="button3" class="list_ym_btn" type="button" id="button3" value="��һҳ"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    <%if (pageComponent.hasNextPage()) {%>

                    <input name="button4" class="list_ym_btn" type="button" id="button4" value="βҳ" onClick="endPage();"
                           style="cursor:pointer"/>
                    <%} else {%>
                    <input name="button4" class="list_ym_btn" type="button" id="button4" value="βҳ"
                           style="cursor:pointer"
                           disabled="disabled"/>
                    <%}%>
                    ת��
                    <input value="<%=currentPage%>" name="pageno" type="text" class="input_ym"/>
                    ҳ
                    <input name="button5" type="button" class="list_ym_btngo" value="GO" onclick="return checkForm()"
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
            <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
        </div>
    </div>
</form>
</body>
</html>
