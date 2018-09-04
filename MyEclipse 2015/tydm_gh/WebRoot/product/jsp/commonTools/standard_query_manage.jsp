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
                document.getElementById("dmName").innerText = '���ƣ�';
            }
        }
    </script>
</head>
<body>
<div class="page_top">ϵͳ &gt;&gt; ϵͳ���� &gt;&gt;
    <c:if test="${table eq 'sc_dzzlx'}">����֯����ά��</c:if>
    <c:if test="${table eq 'sc_mz'}">����ά��</c:if>
    <c:if test="${table eq 'sc_wjdyy'}">δ����ԭ�����ά��</c:if>
    <c:if test="${table eq 'sc_zzmm'}">������òά��</c:if>
     <c:if test="${table eq 'sc_zw'}">ְ��ά��</c:if>
    <c:if test="${table eq 'sc_xzqh'}">��������ά��</c:if>
    <c:if test="${table eq 'sc_xzqhdz'}">������������ά��</c:if>
    <c:if test="${table eq 'sc_bzjgdm'}">��֤����ά��</c:if>
    <c:if test="${table eq 'sc_lx'}">����ά��</c:if>
    <c:if test="${table eq null}">��׼ά�� </c:if>
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
            
            <c:choose>
                <c:when test="${table ne 'sc_zw' and table ne 'sc_xzqh' and table ne 'sc_bzjgdm' and table ne 'sc_jjhy' and table ne 'sc_xzqhdz' and table ne 'sc_lx'}">
                  <label for="table">���ݱ�</label>
		            <select class="input_120" name="table" id="table" onchange="changeName();">
		
		                   <!--   <option value="sc_dzzlx" ${table eq 'sc_dzzlx'?'selected':''}>����֯����</option>
		                    <option value="sc_wjdyy" ${table eq 'sc_wjdyy'?'selected':''}>δ����ԭ�����</option>-->
		                    <option value="sc_mz" ${table eq 'sc_mz'?'selected':''}>����</option>
		                    <option value="sc_zzmm" ${table eq 'sc_zzmm'?'selected':''}>������ò</option>
		
		               
		            </select>
                
                </c:when>
                
                <c:otherwise>
                    <input type="hidden" name="table" id="table" value="${table}"/>
                </c:otherwise>
            </c:choose>
            
            &nbsp;
            <input name="button2" type="button" class="newBtn1" id="btn" value="�� ѯ" onclick="Page.verify();"/>
            &nbsp;
            <input name="button2" type="button" class="newBtn1" id="add" value="�� ��" onclick="addStandard();"/>
        </div>
        <div class="list_box">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">���</td>
                    
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


			            <c:choose>
			            <c:when test="${table eq 'sc_zw'}">
                            <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dm','${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
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
			            <c:when test="${table eq 'sc_jjhy'}">
                            <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dm','${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                            <td class="list_table_top_td">
                                <div style="float:left">��ע</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('jglx','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
			            
			            </c:when>
			            <c:when test="${table eq 'sc_xzqhdz'}">
			              <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dm','${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                            <td class="list_table_top_td">
                                <div style="float:left">��������</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('depth','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'depth' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                            <td class="list_table_top_td">
                                <div style="float:left">�绰����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dmF','${(page.orderByField eq 'dmF' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'dmF' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
			            </c:when>
			            <c:when test="${table eq 'sc_xzqh' or table eq 'sc_bzjgdm'}">
			              <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dm','${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'dm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                            <td class="list_table_top_td">
                                <div style="float:left">����</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('depth','${(page.orderByField eq 'jglx' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'depth' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
                            <td class="list_table_top_td">
                                <div style="float:left">��������</div>
                                <div class="jt_box" style="float:right">
                                    <a href="#"
                                       onclick="Page.sort('dmF','${(page.orderByField eq 'dmF' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                        <img src="../images/${(page.orderByField eq 'dmF' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                             width="16" height="16" title="�����ֶ�"/></a>
                                </div>
                            </td>
			            </c:when>

			            <c:otherwise></c:otherwise>
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
                        
                        <c:choose>
                        <c:when test="${table eq 'sc_zw'}">
                        <td>${model.column2}</td>
                        <td>${model.column3 eq '1'?'����':model.column3 eq '2'?'���':'�����'}</td>
                         <c:set var="getId" value="${model.column4}"></c:set>
                        </c:when>
                        <c:when test="${table eq 'sc_jjhy'}">
                        <td>${model.column2}</td>
                        <td>${model.column4}</td>
                         <c:set var="getId" value="${model.column3}"></c:set>
                        </c:when>
                        <c:when test="${table eq 'sc_xzqhdz'}">
                         <td>${model.column2}</td>
                         <td>${model.column3}</td>
                         <td>${model.column4}</td>
                         
                         <c:set var="getId" value="${model.column5}"></c:set>
                        </c:when>
                        <c:when test="${table eq 'sc_xzqh' or table eq 'sc_bzjgdm'}">
                         <td>${model.column2}</td>
                         <td>${model.column3}</td>
                         <td>${model.column4}</td>
                         
                         <c:set var="getId" value="${model.column2}"></c:set>
                        </c:when>
                        <c:otherwise>
                        <c:set var="getId" value="${model.column2}"></c:set>
                        </c:otherwise>
                        </c:choose>

                            <td align="center"><img src="/product/images/icon_edit.gif" width="16" height="16"
                                                    onclick="modify('${getId}')"
                                                    style="cursor:pointer" title="�޸�"/>
                            </td>
                        <td align="center"><img src="/product/images/icon_del.gif" width="16" height="16"
                                                onclick="deleteDM('${getId}','${model.column1}')"
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
