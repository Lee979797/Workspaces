<%--@elvariable id="source" type="java.lang.String"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="cfjlbList" type="java.util.List<com.ninemax.jpa.code.model.TCfjlb>"--%>`
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        table.tableBorder0 td{ border:#c4dbe5 1px solid;}
    </style>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/js/page_common.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/cfjlBus.js"></script>
    <script type="text/javascript">
        ymPrompt.setDefaultCfg({showMask: false});
        function giveValue(dm, mc) {
            window.parent.ymPrompt.doHandler(dm + ";" + mc, true);
        }
        function ok() {
            var jgdm = document.getElementById("mc").value;
            var value = document.getElementById("toltal").value;
            var result = false;
            dwr.engine.setAsync(false);
            result = window.confirm("确认进行处罚？ 处罚金额￥" + value);

            if (result) {
                cfjlBus.saveByJgdm(jgdm, function (flag) {
                    result = flag;
                });
                dwr.engine.setAsync(true);
                if (result) {
                    result = confirm("处罚成功！跳转到业务办理页面！");
                }
                if (result)
                    this.form1.submit();
            }
        }
    </script>
    <title>信息结果</title>
</head>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<body>
<c:set var="cflxMap" value="<%= InitSysParams.cflxMap%>"/>
<div class="page_top">
    <div align="right" style="float: right;margin-top: 3px">
        <input name="button" type="hidden" onclick="return ok()" class="newBtn1" value="处 罚"/>
         <input name="button" type="button" onclick="javascript:history.go(-1);" class="newBtn1" value="返回"/>
        &nbsp;
    </div>
    处罚 &gt;&gt; 违规处罚管理 &gt;&gt; 处罚机构查询
</div>
<form name="form1" method="POST" action="${'hz' eq source?'/bsweb/certificate_certOperList.action':
                                            fn:startsWith(source, 'business_' )?'/bsweb/business_search.action':
                                            fn:startsWith(source, 'change_' )?'/bsweb/change_search.action':
                                             ('/bsweb/certificatePrint_list_no_print.action')}">

    <input type="hidden" name="mc" value="${cfjlbList[0].jgdm}" id="mc"/>
    <input type="hidden" name="jgdm.jgdm" value="${cfjlbList[0].jgdm}" id="jgdm"/>
    <input type="hidden" name="checkCfjl" value="no" id="checkCfjl"/>
    <input type="hidden" name="needAudit" value="${needAudit}" id="needAudit"/>
    <input type="hidden" name="audit" value="${audit}" id="audit"/>
    <input type="hidden" name="source" value="${fn:substring(source,fn:indexOf(source, '_')+1,fn:length(source))}"
           id="source"/>
    <input type="hidden" name="type" value="${fn:substring(source,fn:indexOf(source, '_')+1,fn:length(source))}"
           id="type"/>
    <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="ywlx" id="ywlx"/>

    <div id="content">
        <div id="right">
            <div class="rightpart" style="margin-left:auto;margin-right:auto;">
                <TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" >
                    <tr style="height:30px;">
                        <td width="15%" align="right">机构代码：</td>
                        <td >&nbsp;${cfjlbList[0].jgdm}</td>
                        <td width="15%" align="right">机构名称：</td>
                        <td >&nbsp;${cfjlbList[0].jgmc}</td>
                    </tr>
                    <tr style="height:30px;">
                        <td align="right">机构地址：</td>
                        <td>&nbsp;${cfjlbList[0].jgdz}</td>
                        <td align="right">法定代表人：</td>
                        <td>&nbsp;${cfjlbList[0].fddbr}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="list_box" style="height:100%;width:99.5%;_width:98%; margin-top:10px;margin-left:auto;margin-right:auto;">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" style="text-align: center;">
            <tr class="list_table_top">
                <td>
                    <div style="float:left">违规类型</div>
                </td>
                <td>
                    <div style="float:left">罚款金额</div>
                </td>
                <td colspan="2">
                    <div style="float:left">备注</div>
                </td>
            </tr>
            <c:set value="0" var="toltal"/>

            <c:forEach var="cfjl" items="${cfjlbList}">
                <c:set value="${toltal+cfjl.fkje}" var="toltal"/>
                <tr class="list_tr">
                    <td>${cflxMap[cfjl.cflx]}
                    </td>
                    <td>${cfjl.fkje}
                    </td>
                    <td colspan="2">${cfjl.memo}
                    </td>
                </tr>
            </c:forEach>
            <tr class="list_tr">
                <td>总计：
                </td>
                <td colspan="3">
                    <input type="hidden" value="${toltal}" id="toltal">
                    ${toltal}
                </td>
        </table>
    </div>
</form>
</body>
</html>