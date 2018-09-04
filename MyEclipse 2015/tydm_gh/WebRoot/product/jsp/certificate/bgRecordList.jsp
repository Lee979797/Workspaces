<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>�ǼǱ��ѯ</title>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type='text/javascript' src='<%=request.getContextPath() %>/product/js/page_common.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
     <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
    function search() {
        var obj = document.getElementById("tyshxydm");

        Page._curent(1);
        var jgdm = document.getElementById("tyshxydm").value;
        if (!/^[a-zA-Z0-9]+$/.test(jgdm)) {
            jgdm = jgdm.toUpperCase();
            obj.value = jgdm.replace(/[^a-zA-Z0-9]/gm, "");
            ymPrompt.alert({message: "��������ȷ�Ļ������룡",
                slideShowHide: false, width: 330, height: 220, title: '��ʾ��Ϣ'});
            return false;
        }
        //fCheckValue(jgdm);
        
        Page._curent(1);
        document.searchForm.submit();
        return false;
    }
    
        function checkCode(jgdm, sourceTable) {
            dwr.engine.setAsync(false);
            var codeflag = false;
            jgdmBus.checkCert(jgdm, ${sysUser.bzjgdm},'${fn:trim(sysUser.userName)}', 'update', function (value) {
                var vs = value.split(":");
                if ("false" == vs[0]) {
                    ymPrompt.alert(vs[1], 400, 200, '��ʾ��Ϣ');
                    codeflag = true;
                }
            });
            spBus.isAudiaAll(jgdm, '16', function (data) {
                var index = data.indexOf(":");
                var s1 = data.substring(0, index);
                var s2 = data.substring(index + 1, data.length);
                if (s1 == "0") {
                    codeflag = false;
                }
                if (s1 == "1") {
                    ymPrompt.alert({message: s2, width: 330, height: 220, slideShowHide: false, title: '��ʾ��Ϣ'});
                    codeflag = true;
                }
            });
            if (!codeflag) {
                window.location.href = "/bsweb/certificate_search.action?tyshxydm=" + jgdm + "&jglx=${jglx}&source=update&bzjgdm=${sysUser.bzjgdm}&pageno=${pageno}&rowNumsView=${rowNumsView}&sourceTable=" + sourceTable;
            }
        }
    </script>
</head>
<body onload="document.getElementById('tyshxydm').focus()" onkeypress=" return ches(document.searchForm,checkForm);">
<div class="page_top">�Ǽ�&gt;&gt;����ҵ�� &gt;&gt;  �����ѯ</div>
<form name="searchForm" method="post" action="/bsweb/business_bgRecordList.action">
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <input type="hidden" name="orderbyColum" value="${orderbyColum}" id="orderbyColum"/>
    <input type="hidden" name="orderbyMethod" value="${orderbyMethod}" id="orderbyMethod"/>
    <input type="hidden" name="totalPages" value="${pages.totalPages }" id="totalPages"/>
    <input type="hidden" name="currentPage" value="${pages.currentPage }" id="currentPage"/>
    <input type="hidden" name="lastPage" value="${pages.lastPage }" id="lastPage"/>
    <input type="hidden" name="rowNums" value="${pages.pageSize }" id="rowNums"/>
  <input type="hidden" name="jgdm" id="jgdm" value=""/>
    <div id="list_main">
        <div class="list_box">
            <div class="list_box_top">
                ͳһ���룺<input name="jgdm.tyshxydm" type="text" class="input_200" id="tyshxydm" value="${jgdm.tyshxydm}" maxlength="18"/>
                <input name="button2" type="button" class="newBtn1" id="button1" value="�� ѯ" onclick="search()"/>
                &nbsp;<input name="button2" type="button" class="newBtn1" id="btn3" value="� ��" onclick="Page.all();"/>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td" style="width:5%">
                        <div style="float:left">&nbsp;���</div>
                    </td>
                    <c:if test="${orderbyColum eq 'jgdm'}">
                        <td class="list_table_top_td" style="width:10%">
                            <div style="float:left">ͳһ����</div>
                            <div class="jt_box" style="float:right">
                                <c:if test="${orderbyMethod eq 'desc'}">
                                    <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif"
                                                                                      width="16" height="16"
                                                                                      title="�����ֶ�"/></a>
                                </c:if>
                                <c:if test="${orderbyMethod ne 'desc'}">
                                    <a href="#" onclick="pageSort('jgdm','desc')"><img src="../images/jt_1.gif"
                                                                                       width="16" height="16"
                                                                                       title="�����ֶ�"/></a>
                                </c:if>
                            </div>
                        </td>
                    </c:if>
                    <c:if test="${orderbyColum ne 'jgdm'}">
                        <td class="list_table_top_td" style="width:10%">
                            <div style="float:left">ͳһ����</div>
                            <div class="jt_box" style="float:right">
                                <a href="#" onclick="pageSort('jgdm','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="�����ֶ�"/></a>
                            </div>
                        </td>
                    </c:if>
                    <c:if test="${orderbyColum eq 'jgmc'}">
                        <td class="list_table_top_td">
                            <div style="float:left">��������</div>
                            <div class="jt_box" style="float:right">
                                <c:if test="${orderbyMethod eq 'desc'}">
                                    <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif"
                                                                                      width="16" height="16"
                                                                                      title="�����ֶ�"/></a>
                                </c:if>
                                <c:if test="${orderbyMethod ne 'desc'}">
                                    <a href="#" onclick="pageSort('jgmc','desc')"><img src="../images/jt_1.gif"
                                                                                       width="16" height="16"
                                                                                       title="�����ֶ�"/></a>
                                </c:if>
                            </div>
                        </td>
                    </c:if>

                    <c:if test="${orderbyColum ne 'jgmc'}">
                        <td class="list_table_top_td">
                            <div style="float:left">��������</div>
                            <div class="jt_box" style="float:right">
                                <a href="#" onclick="pageSort('jgmc','asc')"><img src="../images/jt_2.gif" width="16"
                                                                                  height="16" title="�����ֶ�"/></a>
                            </div>
                        </td>
                    </c:if>
                       <td class="list_table_top_td">
                            <div style="float:left">��֤����</div>
                      </td>
                      <td class="list_table_top_td">
                            <div style="float:left">��׼�ĺ�</div>
                      </td>
                      <td class="list_table_top_td">
                            <div style="float:left">��֤����</div>
                      </td>

                    <td class="list_table_top_td" style="width:5%" align="center">�鿴</td>
                </tr>
                <c:forEach varStatus="i" var="list" items="${listBgk}">
                    <tr ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count }</td>
                        <td>${list.tyshxydm }</td>
                        <td>${list.jgmc }</td>
                        <td>${list.bzjgdm}</td>
                        <td>${list.zch }</td>
                        <td>${list.bzrq }</td>
                        <td align="center"><a href="/bsweb/business_shwoBgSearch?bgk.sn=${list.sn }"><img src="/product/images/icon_chakan.gif" width="16" height="16"
                                 style="cursor:pointer;" title="${title}"/></a>
                        </td>
                           
                    </tr>
                </c:forEach>
            </table>
             <jsp:include page="../common/pageCommon.jsp"/>
        </div>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </div>

</form>
</body>
</html>