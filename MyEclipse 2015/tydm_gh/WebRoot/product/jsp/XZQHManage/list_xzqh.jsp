<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="zrxzqhs" type="java.util.List<com.ninemax.jpa.code.model.TZrxzqh>"--%>
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
    <title>需处罚机构查询</title>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript">
	  $(function(){   $("#dm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		Page.verify();
		}
	   }
	</script>
</head>
<body>
<div class="page_top">${title}</div>
<form name="searchForm" method="post" action="/bsweb/xzqhManage_lissc_xzqh.action">
    <div class="list_box">
        <div class="list_box_top">
            办证机构：<input name="zrxzqh.xzqh" type="text" class="input_120" id="dm" value="${zrxzqh.xzqh}"
                        maxlength="9"/>
            是否准入：
            <select name="zrxzqh.flag"  class="input_120">
                <option value="">全部</option>
                <option value="1" ${zrxzqh.flag eq '1'?'selected':''}>是</option>
                <option value="0" ${zrxzqh.flag eq '0'?'selected':''}>否</option>
            </select>
            <input name="button2" type="button" class="newBtn1" value="查 询" onclick=" Page.verify();"/>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="list_table_top">
                <td class="list_table_top_td" style="width:5%">序号</td>
                <td class="list_table_top_td">
                    <div style="float:left">办证机构</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('xzqh','${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'xzqh' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">名称</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('mc','${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'mc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">机构代码</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td" >
                    <div style="float:left">证书颁发单位</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td">
                    <div style="float:left">是否准入</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('flag','${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'flag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td" >
                    <div style="float:left">主/从</div>
                    <div class="jt_box" style="float:right">
                        <a href="#"
                           onclick="Page.sort('bzjgflag','${(page.orderByField eq 'bzjgflag' and page.orderByType eq 'asc')?'desc':'asc'}')">
                            <img src="../images/${(page.orderByField eq 'bzjgflag' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                 width="16" height="16" title="排序字段"/></a>
                    </div>
                </td>
                <td class="list_table_top_td" align="center">编辑
                </td>
                <td class="list_table_top_td" align="center">准入
                </td>
              <%--  <td class="list_table_top_td" align="center">年检提示
                </td>--%>
                <td class="list_table_top_td" align="center">档案导入
                </td>
                <td class="list_table_top_td" align="center">详细信息
                </td>
            </tr>

            <c:forEach varStatus="i" var="cf" items="${zrxzqhs}">
                <tr ${(i.count % 2 eq 1)?"class='list_tr'":"class='list_tr2'" }>
                    <td>&nbsp;${i.count }</td>
                    <td>&nbsp;${cf.xzqh }</td>
                    <td>&nbsp;${cf.mc }</td>
                    <td>&nbsp;${cf.jgdm }</td>
                    <td>&nbsp;${cf.jgmc }</td>
                    <td align="center">&nbsp;${(cf.flag eq '1')?'是':'否'}&nbsp;</td>
                    <td align="center">&nbsp;${cf.bzjgflag?'主':'从' }</td>
                    <td align="center">
                        <a href="/bsweb/xzqhManage_edisc_xzqh?zrxzqh.xzqh=${cf.xzqh}">
                            <img src="../../images/icon_edit.gif" width="16" height="16" style="cursor:pointer"
                                 title="修改"/>
                        </a>
                    </td>
                    <td align="center">
                        <a href="/bsweb/xzqhManage_zr_xzqh?zrxzqh.xzqh=${cf.xzqh}">
                            <img src="../../images/gonggaogl.png" width="16" height="16"
                                 style="cursor:pointer" title="${(fn:trim(cf.flag) eq '1')?'已经开启,点击取消':'已经取消,点击开启'}"/>
                        </a>
                    </td>
                  <%--  <td align="center">
                        <a href="/bsweb/xzqhManage_njtsbz?zrxzqh.xzqh=${cf.xzqh}">
                            <img src="../../images/gonggaogl.png" width="16" height="16"
                                 style="cursor:pointer" title="${cf.njtsbz?'已经显示，点击隐藏':'已经隐藏，点击显示'}"/>
                        </a>
                    </td>--%>
                    <td align="center">
                        <a href="/bsweb/xzqhManage_smdr?zrxzqh.xzqh=${cf.xzqh}">
                            <img src="../../images/gonggaogl.png" width="16" height="16"
                                 style="cursor:pointer" title="${cf.smdr?'已经开启，点击关闭':'已经关闭，点击开启'}"/>
                        </a>
                    </td>
                    <td align="center">
                        <a href="/bsweb/xzqhManage_show_xzqh?zrxzqh.xzqh=${cf.xzqh}">
                            <img
                                    src="../../images/icon_chakan.gif" width="16" height="16" style="cursor:pointer"
                                    title="查看"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="../common/pageCommon.jsp"/>
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</form>
<form action=""></form>
</body>
<c:if test="${message!=null}">
    <script language="javascript">
        ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '提示信息'});
    </script>
</c:if>
</html>

