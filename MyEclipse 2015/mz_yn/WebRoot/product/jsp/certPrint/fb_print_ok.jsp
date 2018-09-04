<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<c:set var="forceEntryNo" value="<%= InitSysParams.system.getForceEntryNo()%>"/>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <TITLE>打印</TITLE>
    <META content="text/html; charset=GBK" http-equiv=Content-Type>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <%-- <jsp:include page="print_common.jsp"/>--%>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <%--suppress CheckValidXmlInScriptTagBody --%>
    <script language="javascript" type="text/javascript">
        var start = Number("${certi.fbSn}");
        var fbNum = Number('${certi.fbNumber}');
        var force = '${forceEntryNo}';
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
            /*  if (p == 5) {
             ymPrompt.alert("打印机名称设置错误，请先执行打印设置！", 330, 220, "提示信息");
             return false;
             }*/
            var printSUC = print.uo_printzdg("组代管${sysUser.bzjgdm}-" + djh + "" + index);
            if (printSUC == 0 && flag) {
                ymPrompt.win({message: '/bsweb/certificateNumber_certNumberPreForPrint?zs.jgdm=${certi.jgdm}&zsbhb.id.zslx=' + type + '&zsbhb.djh=' + djh + '&source=3&index=' + index + '&flag=' + flag + '&again=' + again,
                    handler: callback, closeBtn: false, titleBar: false,
                    width: 400, height: 330, dragOut: false, iframe: true});
                return true;
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
                if (index == "")
                    return;

                if (isRight && isRight == 'true') {
                    index = Number(index) + 1;
                } else {
                    index = Number(index)
                }
                if (index <= (start + fbNum)) {
                    print_djh(djh, type, index, flag, again);
                } else {
                    if (Number('${certi.zbNumber}') > 0
                        //打印完如果是再次打印，不执行打印正本
                            && (again && again == "false")) {
                        print_djh(djh, 0, "", again);
                    }
                }

            }
        }
        function prints() {
            if (fbNum > 1) {
                if (force && force == true) {
                    print_djh("${fn:trim(certi.djhFbPre)}", 1, (start + 1), true, true)
                } else {
                    var b = confirm("输入副本编号吗？共需要输入'" + fbNum + "'次，取消后，可以在证书修改页填写证书编号");
                    print_djh("${fn:trim(certi.djhFbPre)}", 1, (start + 1), b, true)
                }
            } else {
                print_djh("${fn:trim(certi.djhFbPre)}", 1, (start + 1), true, true)
            }
        }
    </script>

</HEAD>
<BODY style="background:#fff;" class="body">
<jsp:include page="common.jsp"/>
<div class="prompt">
    <div class="promptou">提示信息</div>
    <div class="prompti">
        <form method="POST" name='frmThis'
              action="/bsweb/certificatePrint_${source eq "3"?'search?source=3':'list_has_print'}">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <li>
                        <input class="btn2" type="button" value="再次打印" name="B2" onclick="prints()">
                        <span>副本(不减库存)</span>
                    </li>
                    <li>
                        <strong>卡坏证书处理</strong>：先取消输入证书编号，点击再次打印，当打印正确后再输入相应编号；完成打印后，将卡坏的证书做资源损耗；<br>
                        <strong>打印出空白证书处理</strong>：先取消输入证书编号，把打出来的空白证书放回打印机，然后点击再次打印，并输入相应编号&nbsp;<br>
                        <strong>再次打印时流水号不变,封皮库存不变</strong>
                    </li>
                    <li>
                        <b> <a href="#" onclick="document.frmThis.submit();">开始新的打印</a> </b>
                    </li>
                </ul>
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</BODY>
<script type="text/javascript" language="javascript">
    (function () {
        prints();
    })();
</script>
</HTML>