<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>代码证书打印</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <%--  <script language="javascript" src="/js/LodopFuncs.js"></script>--%>
    <%--

        <jsp:include page="print_common.jsp"/>
    --%>
    <script type='text/javascript'>
        var fbids = [];
        <c:forEach var="fb" items="${certi.fbs}">
        fbids.push('${fb}');
        </c:forEach>
        /**
         *   djh 登记号
         *  type 证书类型
         *  index 副本编号
         *  flag 输入编号
         *  again 再次打印
         **/
        function print_djh(djh, type, index, flag, again) {
            var print;
            print = document.getElementById("print");
            var p = print.CheckPrintName('${sysUser.printName}');
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
            /* if (p == 5) {
             ymPrompt.alert("打印机名称设置错误，请先执行打印设置！", 330, 220, "提示信息");
             return false;
             }*/
            var printSUC = print.uo_printzdg("组代管${sysUser.bzjgdm}-" + djh + "" + index);
            if (printSUC == 0) {
                if (flag && (flag == true || flag == "true")) {
                    ymPrompt.win({message: '/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + djh + '&source=3&index=' + index + '&flag=' + flag + '&again=' + again,
                        handler: callback, closeBtn: false, titleBar: false,
                        width: 400, height: 330, dragOut: false, iframe: true});
                    return true;
                } else {
                    callback(djh + ";" + type + ";" + index + ";" + flag + ";" + false + ";" + true);
                }
            } else {
                ymPrompt.alert("打印机异常,打印失败！", 330, 220, "提示信息");
                return false;
            }
        }
        function callback(tp) {
            /**
             *   values[0] 登记号
             *  values[1] 证书类型
             *  values[2] 副本编号
             *  values[3] 输入编号
             *  values[4]重新打印
             *   isRight 是否编号输入正确
             **/
            var djh, type, index, flag, again, isRight;
            if (tp != 'close' && tp != '') {
                var values = tp.split(';');
                djh = values[0];
                type = values[1];
                index = values[2];
                flag = values[3];
                again = values[4];
                isRight = values[5];
                //打印完正本，不执行回调函数
                if (index == "") {
                    document.searchForm.submit();
                    return;
                }
                if (fbids.length > 0) {
                    if (isRight && isRight == 'true') {
                        index = fbids.pop();
                    }
                    print_djh(djh, type, index, flag, again);
                } else {
                    document.searchForm.submit();
                    return;
                }
            }
        }
        function _printCode(tp) {
            if (tp == 'ok') {
                <c:if test="${'1' eq certi.type}">
                if (fbids.length > 1) {
                    var flag = confirm("输入副本编号吗？共需要输入'" + fbids.length + "'次，取消后，可以在证书修改页填写证书编号");
                    print_djh("${fn:trim(certi.djh)}-", 1, fbids.pop(), flag, false)
                } else if (fbids.length > 0) {
                    print_djh("${fn:trim(certi.djh)}-", 1, fbids.pop(), true, false)
                }
                </c:if>
                <c:if test="${'1' ne certi.type}">
                print_djh("${fn:trim(certi.djh)}", 0, '', true, false);
                </c:if>

            }
        }
        function _goBack() {
            window.history.back();
        }
    </script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<form name="searchForm" method="post" action="/bsweb/certificatePrint_print_special.action">
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}">
    <input type="hidden" name="jgdm.fbsl" value="${jgdm.fbsl}">
    <input type="hidden" name="certi.type" value="${certi.type}">

</form>
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style="width: 30% ; float: right;">
        <input type="button" class=btn2 value="打印证书" name="btok"
               onClick="ymPrompt.confirmInfo('您确定打印吗？',null,null,null,_printCode);">
        &nbsp;
        <input type="button"
               value="返 回"
               name="cmdExit"
               class="newBtn1"
               onclick="_goBack();">&nbsp;
    </div>
</div>

<jsp:include page="print_common.jsp"/>
</body>
</html>
