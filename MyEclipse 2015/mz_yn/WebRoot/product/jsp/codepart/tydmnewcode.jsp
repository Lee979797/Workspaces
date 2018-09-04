<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%
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
    <title>新增码段</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type='text/javascript' src='/js/tools.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/codePart.js"></script>
     <script type="text/javascript" src="/dwr/interface/tydmcodePart.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/product/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
	$(function(){   $("#qsmd").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function verifyCode(obj) {
            if (obj.value && obj.value.length > 0) {
                if (!(/^[A-Z0-9]{1,8}$/.test(obj.value))) {
                    obj.value = obj.value.trim().toUpperCase();
                    obj.value = obj.value.replace(/[^A-Z0-9]/g, "");
                    obj.focus();
                }
            }
        }
        function fCheckValue() {
            var qsmd = document.getElementById("qsmd").value;
            var jzmd = document.getElementById("jzmd").value;
            var mdtype = document.getElementById("mdtype").value;
            var reg = /^[A-Za-z]*\d+$/;

            if (qsmd == null || qsmd == '') {
                ymPrompt.alert({message: '起始码段不能为空!', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (jzmd == null || jzmd == '') {
                ymPrompt.alert({message: '截止码段不能为空!', width: 330, height: 220, title: '提示信息'});
                return false;
            }

            if (qsmd.length != 8 || jzmd.length != 8 || mdtype == "") {
                ymPrompt.alert({message: '您输入的值不足8位或未输入类型！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (!isNumberOrBigChar(qsmd) || !isNumberOrBigChar(jzmd)) {
                ymPrompt.alert({message: '您输入的值含有非法字符或小写字母！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (qsmd > jzmd) {
                ymPrompt.alert({message: '您输入的起始码段大于截止码段！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (!isSameMd(qsmd, jzmd)) {
                ymPrompt.alert({message: '您输入的起始和截止码段不一致！', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            if (!(reg.test(qsmd) && reg.test(jzmd) )) {
                ymPrompt.alert({message: '请输入正确的码段：以连续字母或者数字开头，结尾至少一位数字！', width: 330, height: 220, title: '提示信息'});
                return false;

            }
            dwr.engine.setAsync(false);
            var flag = false;
            var nub = 0;
            tydmcodePart.getMdsl(qsmd, jzmd, function (num) {
                if (num > 20000) {
                    flag = false;
                    ymPrompt.alert({message: '您要输入的码段数量超过20000条请重新输入！', width: 330, height: 220, title: '提示信息', handler: function () {
                        document.getElementById("jzmd").focus();
                    }});
                } else {
                    nub = num;
                    flag = true;
                }
            });
            if (flag) {
                ymPrompt.confirmInfo({message: '确认录入当前码段吗？录入码段从' + qsmd + '到' + jzmd + '共' + nub + '个!', width: 330, height: 220, title: '提示信息', handler: function (data) {
                    if (data == 'ok')
                        document.frmThis.submit();
                }});
            }

            return flag;
        }


    </script>
</head>
<body>
<div class="page_top">码段 &gt;&gt; 码段管理 &gt;&gt; 新增码段录入</div>
<form name="frmThis" method="post" action="/bsweb/tycode_newcode.action">
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>


    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=0 align=center border=0 width="50%"
                               style="margin:0px auto;">

                            <tr class="table1_tr1">
                                <td width="40%" class="table1_td1" align="right">起始码段：</td>
                                <td width="60%" align="left">
                                    <input type="text" onkeyup="verifyCode(this)" onblur="verifyCode(this)"
                                           name="mdsource.qsmd" id="qsmd"
                                           maxlength="8" isnull="false"
                                           size="30"
                                           class="page_input2"/>
                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">截止码段：</td>
                                <td><input type="text" onkeyup="verifyCode(this)" onblur="verifyCode(this)"
                                           name="mdsource.jzmd" id="jzmd"
                                           maxlength="8" isnull="false"
                                           size="30"
                                           class="page_input2"/>
                                </td>
                            </tr>
                            <tr class="table1_tr1">
                                <td class="table1_td1" align="right">码段类型：</td>
                                <td><select name="mdsource.mdtype" id="mdtype" style="width: 188px;">
                                    <option></option>
                                    <option value="0">非个体</option>
                                    <option value="3">个&nbsp;体</option>
                                </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="saveButton" type="button" class="newBtn1" id="saveButton" value="保 存"
                               onClick="fCheckValue()"/>&nbsp;<input name="button2" type="button" class="newBtn1"
                                                                     id="button2" value="重 填"
                                                                     onclick="frmThis.reset()"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

</body>

<script language="javascript">
    <!--
    <%
    String msg = (String)request.getAttribute("resultMsg");
    if(msg!=null && !clsStringTool.isEmpty(msg.toString())){
    %>
    ymPrompt.alert({message: '<%=msg%>', width: 330, height: 220, title: '提示信息'});
    <%}%>
    //-->
</script>
</html>

