<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <%--
      Created by IntelliJ IDEA.
      User: yanzh
      Date: 12-5-20
      Time: 上午11:50
      To change this template use File | Settings | File Templates.
    --%>
    <script type="text/javascript">
        function to(url) {
            document.location.href = url;
        }

    </script>
    <title>更新成功</title>

</head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="">
    <br>
    <table align=center border=1 cellpadding=1 cellspacing=0 class=tableBorder0
           style="border-collapse:collapse; font-size:14px; line-height:30px; width:500px;" bordercolor="#cccccc">

        <tr class="list_table_top">
            <td align="center" class=td1 colspan="4" bgcolor="#f5f5f5" style="font-weight:bold;">

            </td>
        </tr>
        <tr>

            <td align="center" style="font-size:12px;">
                您要查询的数据不存在！
            </td>
        </tr>
        <tr class="list_tr">
            <td align="center" class=td1 colspan="1">
                <input type="button" class="list_ym_btn" name="modify" value="确 定"
                       onClick="javascript:to('/bsweb/business_list?source=${source}');" class=button>

            </td>
        </tr>


    </table>
</form>
</body>
</html>
