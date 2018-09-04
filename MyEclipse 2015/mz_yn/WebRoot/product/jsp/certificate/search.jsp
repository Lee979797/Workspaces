<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
    String title = "";
    String source = request.getParameter("source");
    if ("update".equals(source)) {
        title = "发证 &gt;&gt; 申请表修改 &gt;&gt;申请表修改";
    }
    if ("delete".equals(source)) {
        title = "发证 &gt;&gt; 申请表删除 &gt;&gt;申请表删除";
    }
    if ("certChange".equals(source)) {
        title = "发证 &gt;&gt; 换证管理 &gt;&gt;换证处理 ";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <title>信息查询</title>
    <script type="text/javascript">
        function cardSearch() {
            document.jgdmicread.nport = 1;//document.getElementById('listCom').value;
            var rtn = document.jgdmicread.readcard(document.jgdmicread.nport);
            ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});

            if (rtn == false) {
                ymPrompt.alert({message: "打开串口失败!错误原因：" + document.jgdmicread.errorText,
                    slideShowHide: false, width: 330, height: 220, title: '提示信息'});
                return;
            }
            document.getElementById("jgdm").value = document.jgdmicread.jgdm.trim();
          ymPrompt.close();
            fCheckValue();
        }
        function fCheckValue() {
            if (isEmpty(thisForm.jgdm.value)) {
                ymPrompt.alert({message:"机构代码不能为空!", width:330, height:220, title:'提示信息'});
                return false;
            }
            dwr.engine.setAsync(false);
            var codeflag;
            codecheck.isCheckCode(thisForm.jgdm.value, function (value) {
                if (value != true) {
                    ymPrompt.alert({message:"机构代码不正确!", width:330, height:220, title:'提示信息'});
                    codeflag = true;
                    return;
                }
            });
            if (codeflag) {
                return;
            }
            var source = document.getElementById("source").value;
            jgdmBus.checkCert(thisForm.jgdm.value, thisForm.bzjgdm.value,'${fn:fn:trim(sysUser.userName)}', source, function (value) {
                var vs = value.split(":");
                if ("false" == vs[0]) {
                    ymPrompt.alert(vs[1], 330,220, '提示信息');
                    codeflag = true;
                    return;
                }
            });
            if (codeflag) {
                return;
            }
            /*if(source=='delete'){
             return  needAudia(thisForm.jgdm.value, "sqbscsh");
             }
             if(source=='certChange'){
             return  needAudia(thisForm.jgdm.value, "hzsh");
             }*/
            thisForm.submit();
            return true;
        }
    </script>
</head>
<object scope="application" width="32" height="32" classid="CLSID:3EE0206D-697A-11D5-9BD3-00E01819D1CC"
        codebase="icocx/jgdmicread.cab" name="jgdmicread" style="display:None">
</object>
<body>
<div class="page_top"><%=title%>
</div>
<div id="list_main">
    <form method="POST" name='thisForm' action="/bsweb/certificate_search.action">
        <input type="hidden" name="source" value="${param.source}" id="source"/>
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="ywlx" id="ywlx"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                机构代码：
                <input name="jgdm" type="text" class="input_120" maxlength="9" id="jgdm" value=""/>
                &nbsp; <input name="button2" type="button" class="newBtn1" id="button2" value="查 询" onclick="fCheckValue();"/>
               <%
                   if ("certChange".equals(source)) {
                     %> &nbsp;<input name="button3" type="hidden" class="newBtn1" id="btn3" value="IC卡办理" onclick="cardSearch()"/><%
                   }
               %>

            </div>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
<c:if test="${resultMsg!=null and resultMsg!=''}">
    <script type="text/javascript">
        ymPrompt.alert({message:"${resultMsg}", width:330, height:220, title:'提示信息'});
    </script>
</c:if>
</html>
