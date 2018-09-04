<%@page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>已准入办证机构详细信息</TITLE>
    <META content="text/html; charset=gbk" http-equiv=Content-Type>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <style type="text/css">
        table.tableBorder0 td {
            border: #c4dbe5 1px solid;
        }
    </style>
    <script type="text/javascript">
        function submitForm() {
            document.thisForm.submit();
        }
    </script>
</HEAD>
<body style="background:#fff;" class=body leftMargin=0 onload='window.defaultStatus="欢迎进入组织机构代码管理系统!!!"' topMargin=0>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form method="POST" name="thisForm" action="/bsweb/xzqhManage_${source}.action">
                        <input type="hidden" name="zrxzqh.xzqh" value="${zrxzqh.xzqh}">
                        <table align=center width="100%" border=0 class=tableBorder0 cellpadding=5 cellspacing=0>
                            <tr>
                                <td class=td1 align="right" width="15%">办证机构：</td>
                                <td class=td1 width="34%" align="left">${zrxzqh.xzqh}&nbsp;</td>
                                <td class=td1 align="right" width="15%">名称：</td>
                                <td class=td1 align="left" >${zrxzqh.mc}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">机构代码：</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.jgdm}&nbsp;</td>
                                <td class=td1 align="right" width="15%">证书颁发单位：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.jgmc}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">行政级别：</td>
                                <td class=td1 width="24%" align="left">
                                    ${(zrxzqh.zdlevel eq '0')?'中心级':(zrxzqh.zdlevel eq '1')?'地区':(zrxzqh.zdlevel eq '2')?'县级':'未知'}</td>
                                <td class=td1 align="right" width="15%">上级行政区划：</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.sjxzqh}</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">是否可制卡：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.dkflag=='1'?'是':'否'}</td>
                                <td class=td1 align="right" width="15%">是否可发证：</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.fzflag=='1'?'是':'否'}</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">单位地址：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.dz}&nbsp;</td>
                                <td class=td1 align="right" width="15%">邮政编码：</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.yzbm}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">联系人：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.lxr}&nbsp;</td>
                                <td class=td1 align="right" width="15%">联系电话：</td>
                                <td class=td1 align="left" width="26%">${zrxzqh.dh}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">组代管流水号：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.zsbh}&nbsp;</td>
                                <td class=td1 align="right" width="15%">状态：</td>
                                <td class=td1 width="24%" align="left">${(zrxzqh.flag eq '1')?'启用':'未启用'}&nbsp;</td>
                            </tr>
                            <tr>
                                <td class=td1 align="right" width="15%">IP：</td>
                                <td class=td1 width="24%" align="left">${zrxzqh.ip}&nbsp;</td>
                                <td class=td1 align="right" width="15%">&nbsp;</td>
                                <td class=td1 align="left" width="26%">&nbsp;</td>
                            </tr>
                        </table>
                    </FORM>
                </div>
                <div class="listbtn">
                    <c:if test="${source eq 'update_nqtsbz'}">
                        <input type="button" value="${zrxzqh.njtsbz ?'隐 藏':'显 示'}" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <c:if test="${source eq 'update_smdr'}">
                        <input type="button" value="${zrxzqh.smdr ?'关 闭':'开 启'}" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <c:if test="${source eq 'update_zr'}">
                        <input type="button" value="${(zrxzqh.flag eq '1')?'取消':'恢复'}准入" name="cmdExit" class=btn2
                               onclick="submitForm()">
                    </c:if>
                    <input type="button" value="返 回" name="cmdExit" class="newBtn1"
                           onClick=" history.back()">
                </div>
            </div>
        </div>
    </div>
</div>
</BODY>
</HTML>