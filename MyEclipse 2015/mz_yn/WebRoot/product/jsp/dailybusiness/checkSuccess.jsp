<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link href="/css/prompt.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }

    </script>
    <title>提示信息</title>
   </head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="">
    <div class="prompt">
        <div class="promptou">提示信息</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <li><b>组织机构(${jgdm.jgdm})单位年检成功!</b></li>
                    <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >打印申报表</a>
                      <%--  <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >打印校对单</a>--%> </b>
                    </li>
                    <li>
                        <c:if test="${jgdm.fkbz eq '1'}">
                            <input type="button" name="modify" value="卡年检"
                                   onClick="javascript:to('/bsweb/icCardOpt_search?source=check&jgdm.jgdm=${jgdm.jgdm}');"
 class="newBtn1"                        class=btn1>
                        </c:if>
                        <input type="button" name="modify" value="返 回"
                               onClick="to('/bsweb/business_list?source=checclass="newBtn1"                            class=btn1>

                    </li>
                </ul>
        </div>
            <div class="clear"></div>
        </div>
        <div class="promptdi"></div>
    </div>
</form>
</body>
</html>
