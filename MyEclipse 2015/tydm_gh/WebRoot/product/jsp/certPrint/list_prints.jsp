<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="jgdms" type="java.util.List<com.ninemax.jpa.code.model.TJgdm>"--%>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="zrxzqhs" value="<%=InitSysParams.zrxzqhMap2%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<title>登记表查询</title>
<link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
<link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<script type='text/javascript' src='/js/tools.js'></script>
<script type='text/javascript' src='/product/js/page_common.js'></script>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
<script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="/js/page.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript">
    function verifyData() {
        var current = document.getElementById("currentPage");
        if (current)
            current.value = 1;
        document.searchForm.submit();
        return true;
    }
    function print_djh(certi, djh) {
        var print;
        print = document.getElementById("print");

        var p = print.CheckPrintName('');
        if (p == 1) {
            ymPrompt.alert("打印机缺纸！", 330, 220, "提示信息");
            return false;
        }
        if (p == 2) {
            ymPrompt.alert("打印机无联系！", 330, 220, "提示信息");
            return false;
        }
        if (p == 3) {
            ymPrompt.alert("打印机异常！", 330, 220, "提示信息");
            return false;
        }
        if (p == 4) {
            ymPrompt.alert("没有安装打印机！", 330, 220, "提示信息");
            return false;
        }
        if (p == 5) {
            ymPrompt.alert("打印机名称设置错误，请先执行打印设置！", 330, 220, "提示信息");
            return false;
        }
        var printSUC = print.uo_printBatch(certi.jgdm, certi.jgmc, certi.jglx, certi.frdbMc, certi.frdbValue, certi.jgdz, certi.yxq, certi.bzjgdm, djh, "1312313dkasdask", certi.tsxx1 + certi.tsxx2 + certi.tsxx3);
        if (printSUC == 0) {
            return true;
        } else {
            ymPrompt.alert("打印机异常,打印失败！", 330, 220, "提示信息");
            return false;
        }
    }
    function printThis(certi, text, type, flag) {
        var sucs = print_djh(certi, "组代管${sysUser.bzjgdm}-" + text);
        if (sucs && flag) {
            showModalDialog('/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + text + "&source=3",
                    window, "dialogHeight:330px; dialogWidth: 400px; edge: raised; center: Yes; help: No; resizable: No; status: No; unadorned:1;");
        }

    }
    function certPrint(certi) {
        var start = Number(certi.fbSn);
        var fbNum = Number(certi.fbNumber);
        var b = false;
        if (fbNum > 1) {
            b = confirm("输入副本编号吗？共需要输入'" + fbNum + "'次，取消后，可以在证书修改页填写证书编号");
            for (var i = start; i < start + fbNum; i++) {
                printThis(certi, certi.djhFbPre + "" + (i + 1), 1, b);
            }
        } else {
            if (fbNum > 0)
                printThis(certi, certi.djhFbPre + "" + (start + 1), 1, true);
        }
        if (certi.zbNumber > 0)
            printThis(certi, certi.djhZb, 0, true);
    }
    function checkAll() {
        var i;
        var jgdms = document.getElementsByName("checkedJgdms");
        var sel = document.getElementById("checkJgdm");
        if (sel.checked == true) {
            for (i = 0; i < jgdms.length; i++) {
                jgdms[i].checked = true;
            }
        } else {
            for (i = 0; i < jgdms.length; i++) {
                jgdms[i].checked = false;
            }
        }

    }
    function fCheckValue() {
        var i;
        var checkIdObj = eval("searchForm.checkedJgdms");
        var jgdmIds = document.getElementById("jgdmIds");
        //判断对象是否为空
        if (checkIdObj == null) {
            ymPrompt.alert({message: "请先选择记录！", width: 330, height: 220, title: '提示信息'});
            return false;
        }
        var flag = false;
        //如果check列表对象多于一个
        dwr.engine.setAsync(false);
        if (checkIdObj.length) {
            for (i = 0; i < checkIdObj.length; i++) {
                if (checkIdObj[i].checked) {
                    certPrintBus.printCert(checkIdObj[i].value, '${sysUser.bzjgdm}', function (cert) {
                        if (cert.jgdm && cert.jgdm.length == 9) {
                            certPrint(cert);
                            flag = true;
                        } else {
                            ymPrompt.alert(cert.tsxx1, 330, 220, "提示信息");
                            flag = false;
                        }
                    });
                    if (!flag)
                        return false;
                    flag = true;
                }
            }
        } else {
            if (checkIdObj.checked) {
                certPrintBus.printCert(checkIdObj.value, '${sysUser.bzjgdm}', function (cert) {
                    if (cert.jgdm && cert.jgdm.length == 9) {
                        certPrint(cert);
                        flag = true;
                    } else {
                        ymPrompt.alert(cert.tsxx1, 330, 220, "提示信息");
                        flag = false;
                    }
                });
                if (!flag)
                    return false;
                flag = true;
            }
        }
        if (flag) {
            ymPrompt.alert({message: "批量打印成功！", width: 330, height: 220, title: '提示信息', handler: function () {
                window.location.href = '/bsweb/certificatePrint_list_prints.action';
            }});

            return true;
        } else {
            ymPrompt.alert({message: "请先选择记录！", width: 330, height: 220, title: '提示信息'});
            return false;
        }

    }
    function check(jgdm, zb, fb) {
        dwr.engine.setAsync(false);
        var flag = true;
        var result = '';
        certPrintBus.hasCert('${sysUser.bzjgdm}', zb, fb, function (value) {
            flag = value;
        });
        if (!flag) {
            ymPrompt.alert({message: "当前机构证书库存不足，补足证书后才能打印证书", width: 330, height: 220, title: '提示信息'});
            return false;
        }
        certPrintBus.checkTime(jgdm,'${sysUser.bzjgdm}',true, function (value) {
            var ss = value.split(':');
            flag = ss[0];
            result = ss.length > 1 ? ss[1] : '';
        });

        if (!flag) {
            ymPrompt.alert(result);
            return false;
        }
     /*   certPrintBus.isALLScanComplete(jgdm, '${sysUser.bzjgdm}', function (value) {
            flag = value;
        });*/
        if (flag) {
            spBus.isAudiaAll(jgdm, '', function (data) {
                var index = data.indexOf(":");
                var s1 = data.substring(0, index);
                var s2 = data.substring(index + 1, data.length);
                if (s1 == "0") {
                    document.showForm.jgdm.value = jgdm;
                    document.showForm.submit();
                    flag = true;
                }
                if (s1 == "1") {
                    ymPrompt.alert({message: s2, width: 330, height: 220,
                        slideShowHide: false, title: '打印证书'});
                    flag = false;
                }
            });
            return flag;
        } else {
            ymPrompt.alert({message: "机构代码（" + jgdm + "）需要先完成扫描任务才能打印证书", width: 330, height: 220, title: '提示信息'});
            return false;
        }
    }
</script>
</head>
<body>
<div class="page_top">${title}</div>
<div id="list_main">
    <jsp:include page="common.jsp"/>
    <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag eq '1'}">
        <form name="searchForm" method="post" action="/bsweb/certificatePrint_list_prints.action">


            <div class="list_box_top" style="border: 1px;">
                业务变更日期：
                <INPUT name="startDate" id="startDate" onclick="WdatePicker({el:$dp.$('startDate')});"
                       value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd'/>"
                       class="input_120"/>
                <A hideFocus onclick="WdatePicker({el:$dp.$('startDate')});" href="javascript:void(0)">
                    <IMG src="/images/icon_rili.gif" style="vertical-align: middle"/>
                </A>至<INPUT onclick="WdatePicker({el:$dp.$('endDate')});"
                            name="endDate" id="endDate"
                            value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"
                            class="input_120"/>
                <A hideFocus onclick="WdatePicker({el:$dp.$('endDate')});" href="javascript:void(0)">
                    <IMG src="/images/icon_rili.gif" style="vertical-align: middle"/>
                </A>&nbsp;机构代码：
                <input class="input_120" type="text" name="jgdm.jgdm" size="13" id="jgdm1"
                       maxlength="9" value="${jgdm.jgdm}"
                        >&nbsp;<span
                    id="length" style="color: #ff0000"></span>

                <input name="search" type="button" onclick="return verifyData();" class="newBtn1" id="btn1" value="查 询"/>
                &nbsp;
                <input type="button" name="save" value="批量打印" onClick="return fCheckValue();" class="btn2"/>
            </div>
            <div class="list_box">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="list_table_top">
                        <td class="list_table_top_td" style="vertical-align: middle;width: 3%" align="center">
                            <input type="checkbox" onclick="checkAll()" id="checkJgdm"
                                   style="margin-top: 5px">
                        </td>
                        <td class="list_table_top_td" style="width:3%">
                            <div style="float:left">&nbsp;序号</div>
                        </td>

                        <td class="list_table_top_td" style="width:8%">
                            <div style="float:left">机构代码</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('jgdm','${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'jgdm' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>
                        <td class="list_table_top_td">
                            <div style="float:left">机构名称</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('jgmc','${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'jgmc' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>
                        <td class="list_table_top_td" style="width:8%">
                            <div style="float:left">办证日期</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('bzrq','${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'bzrq' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>
                        <td class="list_table_top_td" style="width:8%">
                            <div style="float:left">业务变更日期</div>
                            <div class="jt_box" style="float:right">
                                <a href="#"
                                   onclick="Page.sort('lastdate','${(page.orderByField eq 'lastdate' and page.orderByType eq 'asc')?'desc':'asc'}')">
                                    <img src="../images/${(page.orderByField eq 'lastdate' and page.orderByType eq 'asc')?'jt_1':'jt_2'}.gif"
                                         width="16" height="16" title="排序字段"/></a>
                            </div>
                        </td>
                    </tr>

                    <c:forEach varStatus="i" var="dm" items="${jgdms}">
                        <tr ${i.index % 2==0?"class='list_tr'":"class='list_tr2'" }>
                            <td align="center">
                                <input type="checkbox" name="checkedJgdms" value="${dm.jgdm}">
                            </td>
                            <td>&nbsp;${i.index+1 }</td>
                            <td>${dm.jgdm }</td>
                            <td>${dm.jgmc}</td>
                            <td><fmt:formatDate value="${dm.bzrq}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${dm.lastdate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <jsp:include page="../common/pageCommon.jsp"/>
            </div>
        </form>
        <form action="/bsweb/certificatePrint_print_all.action" name="showForm">
            <input type="hidden" name="jgdmIds" id="jgdmIds"/>
        </form>
    </c:if>
    <c:if test="${zrxzqhs[sysUser.bzjgdm].fzflag ne '1'}">
        当前用户没有打证权限，请联系省中心或上级主管部门处理！
    </c:if>
</div>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>

</body>
</html>