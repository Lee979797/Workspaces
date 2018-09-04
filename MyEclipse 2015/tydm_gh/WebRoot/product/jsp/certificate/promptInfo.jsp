<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-5-20
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=gbk" %>
<%
    String formType = (String) request.getAttribute("formType");
    String type = (String) request.getAttribute("type");
    String jgdm = (String) request.getAttribute("jgdm");
    String jgmc = (String) request.getAttribute("jgmc");
    String resultMsg = (String) request.getAttribute("resultMsg");
    if ("2".equals(formType) && "1".equals(type)) {
        if (jgdm != null && jgdm.trim().length() == 9) {
            resultMsg = "机构(" + jgmc + ")删除成功，机构代码(" + jgdm + ")已回收，该预赋码通知单已作废!";
        } else {
            resultMsg = "预赋码机构(" + jgmc + ")删除成功!";
        }

    }
    String title = "提示信息";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="<%=request.getContextPath()%>/css/prompt.css" rel="stylesheet" type="text/css"/>
    <title>信息查询</title>
    <script language="javascript">
        //禁止用F5键
        document.onkeydown = function () {
            if (event.keyCode == 116) {
                event.keyCode = 0;
                event.cancelBubble = true;
                return   false;
            }
        }
        //禁止右键弹出菜单
        document.oncontextmenu = function () {
            return   false;
        }
    </script>
</head>
<body style="background:#fff;">
<div class="prompt">
    <div class="promptou">提示信息</div>
    <div class="prompti">
        <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
        <div class="prompt_right">
            <ul>
                <li><b><%=resultMsg%>
                </b></li>
                <li>
                    <%if ("4".equals(formType)) {%>
                    <input type="submit" name="modify" value="返  回"
                           onClick="window.location.href='/bsweb/certificate_delApplySaveList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=${jglx}'"
                           class="newBtn1"/>
                    <%} else if ("1".equals(formType)) {%>
                    <input type="submit" name="modify" value="返  回"
                           onClick="window.location.href='/bsweb/certificate_delSaveList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&delType=<%=formType%>&jglx=${jglx}'"
                           class="newBtn1"/>
                    <%} else if ("2".equals(formType)) {%>
                    <input type="submit" name="modify" value="返  回"
                           onClick="window.location.href='/bsweb/certificate_delSaveList.action?pageno=${pageno}&rowNumsView=${rowNumsView}&delType=<%=formType%>&jglx=${jglx}'"
                           class="newBtn1"/>
                    <%} else if ("3".equals(formType)) {%>
                    <input type="submit" name="modify" value="打  印"
                           onClick="window.location.href='/bsweb/certificate_printCert.action?formType=<%=formType%>&jgdm=<%=jgdm%>&jglx=${jglx}'"
                           class="newBtn1"/>&nbsp;<input type="submit" name="modify" value="返  回"
                                                      onClick="window.location.href='/product/jsp/certificate/search.jsp?source=certChangejglx=${jglx}'"
                                                      class="newBtn1"/>
                    <%} else {%>
                    <input type="submit" name="modify" value="返  回"
                           onClick="window.location.href='/bsweb/certificate_list.action?formType=<%=formType%>&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=${jglx}'"
                           class="newBtn1"/>
                    <%}%>
                </li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="promptdi"></div>
</div>
</body>
</html>