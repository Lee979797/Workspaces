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
    <title>��ʾ��Ϣ</title>
   </head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="">
    <div class="prompt">
        <div class="promptou">��ʾ��Ϣ</div>
        <div class="prompti">
            <div class="prompt_left"><img src="/images/prompt_success.jpg"/></div>
            <div class="prompt_right">
                <ul>
                    <li><b>��֯����(${jgdm.jgdm})��λ���ɹ�!</b></li>
                    <li><b><a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >��ӡ�걨��</a>
                      <%--  <a href="/bsweb/certificatePrint_apply_info?jgdm.jgdm=${jgdm.jgdm}" target="_blank" >��ӡУ�Ե�</a>--%> </b>
                    </li>
                    <li>
                        <c:if test="${jgdm.fkbz eq '1'}">
                            <input type="button" name="modify" value="�����"
                                   onClick="javascript:to('/bsweb/icCardOpt_search?source=check&jgdm.jgdm=${jgdm.jgdm}');"
 class="newBtn1"                        class=btn1>
                        </c:if>
                        <input type="button" name="modify" value="�� ��"
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
