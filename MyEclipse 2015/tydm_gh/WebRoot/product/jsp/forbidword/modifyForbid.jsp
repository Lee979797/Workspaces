<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.bo.ForbidwordBo" %>
<%@ page import="com.ninemax.jpa.system.model.Forbidword" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    String paramString = request.getQueryString();
    String forbidId = request.getParameter("forbidId");
    int _forbidId = 0;
    if (!clsStringTool.isEmpty(forbidId)) {
        _forbidId = Integer.parseInt(forbidId);
    }
    ForbidwordBo forbidwordBo = new ForbidwordBo();
    Forbidword forbidword = forbidwordBo.findById(_forbidId);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>修改词条</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src='/dwr/interface/ForbidwordBo.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script language="JavaScript">

        function forbidUpdate(id) {
            wordid = id;
            var forbidWord = frmAction.forbidWord.value;
            if (isEmpty(forbidWord)) {
                ymPrompt.alert({message:"请输入词条！", width:330, height:220, title:'提示信息'});
                frmAction.forbidWord.focus();
                return false;
            } else if (forbidWord.length > 10) {
                ymPrompt.alert({message:"最多只能录入10个汉字，请重新输入！", width:330, height:220, title:'提示信息'});
                return false;
            }
            var Special_chars = "~!@#$%^&*()_+`-={}|\":>?<,/.;；'[]\\";
            for (i = 0; i < forbidWord.length; i++) {
                if (Special_chars.indexOf(forbidWord.charAt(i)) != -1) {
                    ymPrompt.alert({message:"请去除非法字符! (", width:330, height:220, title:'提示信息'});
                    frmAction.forbidWord.focus();
                    return false;
                }
            }
            var tag = false;
            forbidWord = forbidWord.replace(/[；]/g, ';');

            ForbidwordBo.isExistForbidWord(forbidWord, checkforbidWord);

        }
        var wordid;
        function checkforbidWord(tag) {
            var forbidWord = frmAction.forbidWord.value;
            var preword = frmAction.preword.value;
            if (tag) {
                if (forbidWord == preword) {

                    frmAction.submit();
                } else {
                    document.getElementById("wordDiv").innerHTML = "<font color='red'>词条已经被使用，请重新输入！</font>";

                }
            } else {

                frmAction.submit();
            }
        }
        function isEmpty(str) {
            if ((str.Trim() == null) || (str.Trim().length == 0)) return true;
            else return(false);
        }

        //判断是否为空
        String.prototype.Trim = function () {
            return this.replace(/(^\s*)|(\s*$)/g, "");
        }
    </script>

    <style type="text/css">
        <!--
        .STYLE1 {
            color: #00CC00
        }

        .STYLE4 {
            color: #0099FF
        }

        -->
    </style>
</head>
<body>
<div class="page_top">系统 &gt;&gt; 应用功能 &gt;&gt; 敏感字过滤 &gt;&gt; 修改词条</div>

<form name="frmAction" method="post" action="/action/ForbidwordAction">
    <input type="hidden" name="method" value="modify"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>
    <input type="hidden" name="forbidId" value="<%=forbidId%>"/>
    <input type="hidden" name="preword" value="<%=forbidword.getForbidWord()%>"/>
    <input type="hidden" name="operdate" value="<%=forbidword.getOperdate()%>"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <table width="75%" border="0" cellpadding="0" cellspacing="1">
                            <tr>
                                <td width="11%" align="right">词条：</td>
                                <td colspan="2" width="89%"><textarea class="page_input_txt" name="forbidWord" rows=8
                                                                      cols=54 style="width:100%"
                                                                      onblur="trimIntputValue(this);"><%=forbidword.getForbidWord() %>
                                </textarea>&nbsp;<span id="wordDiv"></span></td>
                            </tr>
                        </table>

                    </div>
                    <div class="listbtn">
                        <input name="button" type="button" class="newBtn1" id="submit" value="提  交"
                               onclick="forbidUpdate(<%=forbidword.getForbidId() %>)"/>
                        <input name="button2" type="button" class="newBtn1" id="button2" value="重 填"
                               onclick="frmAction.reset()"/>

                        <input name="button" type="button" class="newBtn1" id="back" value="返 回"
                               onclick="javascript:document.location.href='forbidList.jsp?<%=paramString %>'"/></td>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    <%
    if(!clsStringTool.isEmpty(request.getParameter("msg"))){
         if("OperSuc".equals(request.getParameter("msg").trim())){
    %>
    ymPrompt.succeedInfo('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>',330,220, '提示信息', function () {
        window.location.href = "forbidList.jsp";
    });
    <%}else{%>
    ymPrompt.alert('<%=InitSysParams.PMTranslates.get(request.getParameter("msg"))%>', 330,220, '提示信息', function () {
        window.location.href = "forbidList.jsp";
    });
    <%
         }
    }
    %>
</script>
</html>
