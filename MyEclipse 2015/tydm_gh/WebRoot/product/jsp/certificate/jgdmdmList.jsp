<%@ page contentType="text/html; charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<title>外网数据审核</title>
<link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>

<script type='text/javascript' src='/js/tools.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
<script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
<script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
<script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
<script type="text/javascript" src="/dwr/interface/gsBus.js"></script>
<script type="text/javascript" src="/js/jgdmSearch.js"></script>

<script type="text/javascript">
function checkForm(){
	//var jgmc= document.getElementById("jgmc").value;
    //var bak4 = document.getElementById("bak4").value;
	//if (jgmc==""&&bak4=="") {
     //   ymPrompt.alert({message: "请输入查询条件!", width: 330, height: 220, title: '提示信息'});
     //   return false;
   // }
	searchForm.submit();

    
}

</script>
</head>
<body >
<object scope="application" width="32" height="32" classid="CLSID:3EE0206D-697A-11D5-9BD3-00E01819D1CC"
        codebase="icocx/jgdmicread.cab" name="jgdmicread" style="display:None">
</object>
    <form name="searchForm" method="post" action="/bsweb/tygs_list.action">
<div class="page_top">登记 &gt;&gt; 工会业务 &gt;&gt;设立登记
</div>
<div class="list_box_top">

 </div>
<div id="list_main">
        <div class="list_box">
            <c:set var="dms" value="${jgdmdmList }"/>
 

            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <c:if test="${source eq 'validate' and fn:substring(sysUser.bzjgdm,2 ,6 ) eq '0000'}">
                        <%--       <td class="list_table_top_td" align="center" style="width: 3%;">
                                   <input type="checkbox" onclick="checkAll()" id="checkJgdm"
                                          style="margin-top: 5px">
                               </td>--%>
                    </c:if>
                    <td class="list_table_top_td" style="width:3%">序号</td>
                                        <td class="list_table_top_td" style="width:13%">
                        <div style="float:left">机构代码</div>

                    </td>
                    
                    <td class="list_table_top_td" style="width:20%">
                        <div style="float:left">机构名称</div>
 
                    </td>
                          <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">法定代表人</div>

                    </td>
                     </td>
                          <td class="list_table_top_td" style="width:8%">
                        <div style="float:left">注册号</div>

                    </td>
                    
                    <td class="list_table_top_td" style="width:10%">
                        <div style="float:left;">注册日期</div>
                 
                    </td>
                     <td class="list_table_top_td" style="width:10%">
                        <div style="float:left;">办证日期</div>
                 
                    </td>
                     <td class="list_table_top_td" style="width:5%">
                        <div style="float:left;">操作</div>

                    </td>

                </tr>
                <c:forEach varStatus="i" var="dm" items="${jgdmdmList}">
                    <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                        <td>&nbsp;${i.count}</td>
                        <td>${dm.jgdm}</td>
                        <td>${dm.jgmc}</td>
                        <td>${dm.fddbr}</td>
                        <td>${dm.zcrq}</td>
                        <td><fmt:formatDate value='${dm.zcrq}' pattern='yyyy-MM-dd'/></td>
                 		<td><fmt:formatDate value='${dm.bzrq}' pattern='yyyy-MM-dd'/></td>
                       <td> <img src="../../images/icon_edit.gif" width="16" height="16"
                                        onclick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=1&jgdmdm=${dm.jgdm}'"
                                        style="cursor:pointer" title="设立登记"/></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../common/pageCommon.jsp"/>

        </div>

    </form>

</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</body>
</html>
