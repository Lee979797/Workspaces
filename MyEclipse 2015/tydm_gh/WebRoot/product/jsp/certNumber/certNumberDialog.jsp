<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%--@elvariable id="zs" type="com.ninemax.jpa.code.model.TZs"--%>
<%--@elvariable id="zsbhb" type="com.ninemax.jpa.code.model.TZsbhb"--%>
<%--@elvariable id="source" type="java.lang.String"--%>
<%--@elvariable id="bh" type="com.ninemax.jpa.code.model.TZsbhb"--%>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String source = request.getParameter("source");
    if (source == null)
        source = (String) request.getAttribute("source");
    session.setAttribute("source", source);
%>
<c:set var="forceEntryNo" value="<%= InitSysParams.system.getForceEntryNo()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>输入证书编号</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
           <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="text/javascript">
	  $(function(){   $("#zsbh_suf").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
			fCheckValue();
		}
	   }
	</script>
    <script type="text/javascript">
        function fCheckValue() {
            var zsbh = document.getElementById("zsbh_suf");
            if (zsbh.value == "") {
                ymPrompt.alert("编号不允许为空！", 330, 220, "提示信息", function (tp) {
                    zsbh.focus();
                });
                return false;
            }
            document.getElementById("zsbh").value = document.getElementById("zsbh_pre").value + zsbh.value;

            document.frmThis.submit();
            return true;
        }
        function closeThis(flag) {
            window.parent.ymPrompt.doHandler("${zsbhb.djh};${zsbhb.id.zslx};${index};${flag};${again};" + flag, true);
        }
        (function () {
            <c:if test="${source eq '1' or source eq null}">
            closeThis(true);
            return;
            </c:if>
            <c:if test="${source eq '0' and bh eq null}">
            ymPrompt.alert("您输入的证书编号( <span style='color: #FF0000;'>${zsbhb.id.zsbh}</span> )不存在!", 330, 220, "提示信息", function (tp) {
                document.getElementById("zsbh_suf").focus();
            });
            </c:if>
        })();
        function ches() {
            if (event && event.keyCode == 13) {
                return false;
            }
        }
    </script>
</head>
<base target="_self">
<body onkeypress="return ches();">
<div class="page_top" style="font-weight:bold;color:#014d7f">提示信息 ( <span style="color: #0000ff;">
    ${(zsbhb.id.zslx eq '0')?'正本':'副本'}
</span>
            <span style="color: #FF0000;">
                已打印出，请按其右下角编号输入！
            </span>)
</div>
<div id="list_main">
    <form name="frmThis" method="post"
          action="${pageContext.request.contextPath}/bsweb/certificateNumber_saveCertNumber.action">
        <input name="zsbhb.id.zslx" type="hidden" value="${zsbhb.id.zslx}">
        <input name="zs.jgdm" type="hidden" value="${zs.jgdm}">
        <input type="hidden" name="zsbhb.id.zsbh" id="zsbh">
        <input type="hidden" name="index" value="${index}"/>
        <input type="hidden" name="flag" value="${flag}"/>
        <input type="hidden" name="again" value="${again}"/>
        <input name="zsbhb.djh" type="hidden" id="djh23" value="${ zsbhb.djh}" size="28">
        <input type="hidden" id="zsbh_pre" name="zsbh_pre" size="10"
               value="${zsbhb.id.zslx=='0'?sysUser.zsbhpre:sysUser.zsbhpreFb}">

        <div class="list_box_top" style="margin-left: 20px;" align="center">
            <div style="text-align: left;margin-left: 50px">
                登 记
                号：组代管${sysUser.bzjgdm}-${zsbhb.djh}${index}<br/>
                证书编号：${zsbhb.id.zslx=='0'?sysUser.zsbhpre:sysUser.zsbhpreFb}
                <input type="text" id="zsbh_suf" name="zsbh_suf" class="input_120">
            </div>
            <br/>
            <input type="button" class="newBtn1" id="queren" value="确 认"
                   onclick="fCheckValue()">
            <c:if test="${!forceEntryNo}">
                &nbsp;
                <input type="button" value="取 消" class="newBtn1" id="cancel"
                       onclick="closeThis(true);">
            </c:if>
        </div>
    </form>
    <div class="list_box">
        <c:if test="${source eq '0' and bh ne null}">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="list_table_top">
                    <td class="list_table_top_td">证书编号</td>
                    <td class="list_table_top_td">证书类型</td>
                    <td class="list_table_top_td">办证机构</td>
                    <td class="list_table_top_td">登 记 号</td>
                    <td class="list_table_top_td">操 作 员</td>
                    <td class="list_table_top_td">打印时间</td>
                </tr>
                <tr class="list_tr">
                    <td>${bh.id.zsbh} </td>
                    <td>${bh.id.zslx=='0'?'正本':'副本'} </td>
                    <td>${bh.ssbzjg} </td>
                    <td>${bh.djh} </td>
                    <td>${bh.czy} </td>
                    <td>${bh.dysj} </td>
                </tr>
                <tr class="list_tr2">
                    <td colspan="6">
                        该编号处于<span style="color:#FF0000 ">${bh.flag=='1'?'使用':bh.flag=='1'?'损耗':'闲置'} </span>状态
                    </td>
                </tr>

            </table>
        </c:if>
    </div>
    <div style="margin-left: 10px">
            <span style="font-weight:bold;">
                注意：
            </span>

        <div style="padding-left: 20px">
            <span style="color:#FF0000;">如果证书没有正确打印出来，请点击取消！</span> <br/>
            <span style="color:#FF0000;">*</span> 谨慎输入，证书编号用作辨别证书真伪！ <br/>
            <span style="color:#FF0000;">*</span> 出现卡纸，走空纸等非正常情况，请不要输入编号！
        </div>
            <span style="font-weight:bold;">
                解决办法：
            </span>

        <div style="padding-left: 20px">
            1、等再次打印时再输入正确编号<br/>
            2、打印正确后到“修改证书编号”中输入。
        </div>
    </div>
</div>
</body>
</html>