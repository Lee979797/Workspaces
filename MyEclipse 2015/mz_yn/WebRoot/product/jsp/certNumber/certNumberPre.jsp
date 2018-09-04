<%@page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>证书编号设置</title>
    <META content="text/html; charset=GBK" http-equiv=Content-Type/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/tools.js?v=2013-3-12.04"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript">
	$(function(){   $("#zpre").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
    <script type="text/javascript">
        function submit() {
            $("#fpre,#zpre").blur();
            document.frmThis.submit();
        }

    </script>
</head>
<BODY style="background:#fff;">
<div class="page_top">
    <div align="left" style=" float: left;">${title}</div>
</div>
<form method="POST" name='frmThis' action="/bsweb/certificateNumber_certNumberPreSave.action">
    <input type="hidden" value="${sysUser.userId}" name="user.userId"/>

    <div id="box">
        <div class="list listblue" style="padding-top:30px;">

            <table align=center border="0" cellspacing="1" cellpadding="0" class=tableBorder0 width="100%">
                <tr>
                    <td width="50%" align="right" class=td1>
                        <div>证书正本编号前缀：</div>
                    </td>
                    <td width="50%" align="left" class=td1>
                        <label>
                            <input name="user.zsbhpre" type="text" id="zpre"
                                   value="${sysUser.zsbhpre}"
                                   maxlength="10" size="15">
                        </label>
                        (位数自定)<font color="#FF0000">&nbsp;</font></td>
                </tr>
                <tr>
                    <td align="right" class=td1>
                        <div>证书副本编号前缀：</div>
                    </td>
                    <td align="left" class=td1><input name="user.zsbhpreFb" type="text" id="fpre"
                                                      value="${sysUser.zsbhpreFb}"
                                                      maxlength="10" size="15">
                        (位数自定)<font color="#FF0000">&nbsp;</font></td>
                </tr>
            </table>
            <div class="listbtn">
                <input type="submit" name="modify" onclick="submit();" value="保 存"
                       class="newBtn1">
            </div>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    (function () {
        $("#fpre,#zpre").bind("blur", function () {
            if (this.value) {
                if (/^\d*$/.test(this.value)) {
                    return true;
                } else {
                    this.value = this.value.replace(/[^\d]/g, "");
                    this.focus();
                    return false;
                }
            }
            return true;
        });
    })();
    <c:if test="${message!=null && message!=''}">
    ymPrompt.alert({message: '${message}', width: 330, height: 220, title: '提示信息'});
    </c:if>
</script>

</html>
