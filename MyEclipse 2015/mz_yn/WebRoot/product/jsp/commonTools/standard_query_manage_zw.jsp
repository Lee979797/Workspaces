<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="dm" type="java.lang.String"--%>
<%--@elvariable id="table" type="java.lang.String"--%>
<%--@elvariable id="models" type="java.util.List<com.ninemax.jpa.code.model.Model>"--%>
<%--@elvariable id="page" type="com.ninemax.jpa.code.model.Page"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�����������</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/page.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#dm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		Page.verify();
		}
	   }
	</script>
    <script type="text/javascript">
        function addStandard() {
            var table = $("#table");
            window.location.href = '/bsweb/commonTools_add?table=' + table.val();
        }
        function modify(dm) {
            var table = $("#table");
            window.location.href = '/bsweb/commonTools_modify?dm=' + dm + '&table=' + table.val();
      

        }
        function deleteDM(dm, mc) {
            var table = $("#table");

            ymPrompt.confirmInfo("ȷ��ɾ����" + mc + "����", 330, 200, "��Ϣ��ʾ", function (tp) {
                if (tp == 'ok') {
                    window.location.href = '/bsweb/commonTools_del?dm=' + dm + '&mc='+mc+'&table=' + table.val();
                }
            });

        }
        function changeName() {
            if (document.getElementById("table").value == 't_pzjg') {
                document.getElementById("dmName").innerText = '��׼��������ƣ�';
            } else if (document.getElementById("table").value == 't_zgjg') {
                document.getElementById("dmName").innerText = '���ܴ�������ƣ�';
            } else if (document.getElementById("table").value == 'sc_jglx_pzjg') {
                document.getElementById("dmName").innerText = '��׼�����������ͣ�';
            } else {
                document.getElementById("dmName").innerText = '��׼��������ƣ�';
            }
        }
    </script>
</head>
<body>
<div class="page_top">ϵͳ &gt;&gt; ϵͳ���� &gt;&gt; ��׼ά��
</div>
<div id="list_main">
    <form name="searchForm" method="post" action="/bsweb/commonTools_standard_query_manage">
        <div class="list_box_top">
            <c:choose>
                <c:when test="${table eq 't_pzjg'}">
                    <label id="dmName" for="dm">��׼��������ƣ�</label>
                </c:when>
                <c:when test="${table eq 't_zgjg'}">
                    <label id="dmName" for="dm">���ܴ�������ƣ�</label>
                </c:when>
                <c:when test="${table eq 'sc_jglx_pzjg'}">
                    <label id="dmName" for="dm">��׼�����������ͣ�</label>
                </c:when>
                <c:otherwise>
                    <label id="dmName" for="dm">���ƣ�</label>
                </c:otherwise>
            </c:choose>

            <input type="text" name="dm" size="13" id="dm" maxlength="20" value="${dm}"
                   class="input_120"/>

            &nbsp;
            <input name="button2" type="button" class="newBtn1" id="btn" value="�� ѯ" onclick="Page.verify();"/>
            &nbsp;
            <input name="button2" type="button" class="newBtn1" id="add" value="�� ��" onclick="addStandard();"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">���</td>


                    <c:choose>
                        <c:when test="${table eq 'sc_jglx_pzjg'}">
                            <td class="list_table_top_td">
                                <div style="float:left">��������</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('jglx','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                 
                                            <a href="#"
                                               onclick="Page.sort('mc','${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                                <img src="../images/${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                                     width="16" height="16" title="�����ֶ�"/>
                                            </a>
                                </div>
                            </td>
                        </c:otherwise>
                    </c:choose>
                        <td class="list_table_top_td" align="center">
                            �༭
                        </td>
                  
                    <td class="list_table_top_td" align="center">
                        ɾ��
                    </td>
                </tr>
                <c:forEach varStatus="i" var="model" items="${models}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${model.column1}</td>
                            <td align="center"><img src="/product/images/icon_edit.gif" width="16" height="16"
                                                    onclick="modify('${model.column2}')"
                                                    style="cursor:pointer" title="�޸�"/>
                            </td>
                        <td align="center"><img src="/product/images/icon_del.gif" width="16" height="16"
                                                onclick="deleteDM('${model.column2}','${model.column1}')"
                                                style="cursor:pointer" title="ɾ��"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </form>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
<script>


</script>
</html>
