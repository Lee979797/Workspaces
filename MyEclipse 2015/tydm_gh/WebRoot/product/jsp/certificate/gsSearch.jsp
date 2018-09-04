<%@ page import="com.ninemax.jpa.code.model.Qiye" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //zx �޸� �����ҳ��������
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
    String title = "";
    String source = request.getParameter("source");
    String jgdmcode = request.getParameter("jgdm");
    List<Qiye> qiyeList = (List<Qiye>) request.getAttribute("qiyeList");
    if ("gsCheck".equals(source)) {
        title = "��֤ &gt;&gt; �����Ǽ� &gt;&gt; ����ע��Ų�ѯ";
    }
    if ("outerIn".equals(source)) {
        title = "��֤ &gt;&gt; Ǩַ���� &gt;&gt;ʡ��Ǩ�� &gt;&gt; ����ע��Ų�ѯ";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <script type='text/javascript' src="/js/tools.js"></script>
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

    <title>��Ϣ��ѯ</title>
    <script type="text/javascript">

        function fCheckValue() {
            if (isEmpty(thisForm.dzch.value)) {
                ymPrompt.alert({message: "����ע��Ų���Ϊ��!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            /*  dwr.engine.setAsync(false);
             var codeflag;
             codecheck.isCheckCode(thisForm.jgdm.value, function (value) {
             if (value != true) {
             ymPrompt.alert({message:"����ע��Ų���ȷ!", width:330, height:220, title:'��ʾ��Ϣ'});
             codeflag = true;
             return;
             }
             });
             if (codeflag) {
             return;
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
    <form method="POST" name='thisForm' action="/bsweb/gsAction_search.action">
        <input type="hidden" name="source" value="<%=source%>" id="source"/>
        <input type="hidden" name="jgdmcode" value="<%=jgdmcode%>" id="jgdmcode"/>
        <input type="hidden" name="bzjgdm" value="${sysUser.bzjgdm}" id="bzjgdm"/>
        <input type="hidden" name="needAudit" value="false" id="needAudit"/>
        <input type="hidden" name="audit" value="false" id="audit"/>
        <input type="hidden" name="ywlx" id="ywlx"/>

        <div class="list_box">
            <div class="list_box_top" style="text-align: center;">
                ����ע��ţ�
                <input name="dzch" type="text" class="input_120" maxlength="30" id="dzch" value="${dzch}"/>
                &nbsp; <input name="button2" type="button" class="newBtn1" id="button2" value="ȷ ��"
                              onclick="fCheckValue();"/>
                <c:if test="${qiyeList!=null && fn:length(qiyeList)>0}">
                    <script type="text/javascript">
                        var _msg = "<ul><li>��ҵ����:<b>${qiyeList[0].vqymc }</b></li><li>Ӫҵִ�շ�֤����:<b><%=DateUtil.dateToStr(qiyeList.get(0).getDhzrq()) %></b></li></ul>";
                        ymPrompt.confirmInfo({message: _msg, width: 380, height: 180, title: '��ʾ��Ϣ', handler: function (opt) {
                            if (opt == 'ok') {
                                window.location.href = '/bsweb/gsAction_findGs.action?jgdmcode=${jgdmcode}&source=${source}&gslx=${gslx}&cwybs=${qiyeList[0].cwybs }';
                            } else {
                                if (${source eq 'gsCheck'}) {
                                    window.location.href = '/product/jsp/certificate/addinfomationEnter.jsp?formType=0';
                                } else {
                                    window.location.href = '/bsweb/change_search.action?needAudit=false&audit=false&source=outerIn&checkCfjl=yes&type=outerIn&mc=${jgdmcode}';
                                }

                            }
                        }});
                    </script>
                </c:if>
            </div>
        </div>
        <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
    </form>
</div>
</body>
<c:if test="${resultMsg!=null and resultMsg!=''}">
    <script type="text/javascript">
        ymPrompt.confirmInfo({message: "${resultMsg}", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (data) {
            if ('ok' == data) {
                if (${source eq 'gsCheck'}) {
                    window.location.href = '/product/jsp/certificate/addinfomationEnter.jsp?formType=0';
                } else {
                    window.location.href = '/bsweb/change_search.action?needAudit=false&audit=false&source=outerIn&checkCfjl=yes&type=outerIn&mc=${jgdmcode}';
                }
            }

        }});
    </script>
</c:if>
</html>
