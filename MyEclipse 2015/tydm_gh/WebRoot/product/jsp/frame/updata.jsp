<%--@elvariable id="system" type="com.ninemax.jpa.code.model.TSystem"--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/product/jsp/frame/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/zrxzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript">
	  $(function(){   $("#jgdm").focus();  })
	  document.onkeydown=function(){
		if(event.keyCode=="13"){
		upload();
		}
	   }
	</script>
    
</head>
<body>
<div class="page_top_fixed">
    <div style="float:left;"><strong>系统 &gt;&gt; 系统设置 &gt;&gt; 数据上报</strong></div>
    <div style="clear:both;"></div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <div style="width: 100%">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                            <tr class="table1_tr1">
                                <th>
                                    数据上报
                                </th>
                            </tr>
                            <tr>
                                <TD class="td1">
                                    <div class="list_box_top">
                                        <label for="jgdm"> 机构代码：</label>
                                        <input type="text" name="jgdm" size="13" onkeyup="" id="jgdm" maxlength="9"
                                               value="" class="input_120">
                                        <label for="startDate"> 数据变更日期:</label><input id="startDate" type="text"
                                                                                      class="input_120"
                                                                                      onfocus="WdatePicker({el:'startDate'})"/>
                                        <IMG src="/product/jsp/images/icon_day.gif"
                                             style="cursor:pointer; vertical-align: middle"
                                             onclick="WdatePicker({el:'startDate'})"/>
                                        <label for="endDate">至：</label><input id="endDate" type="text"
                                                                              class="input_120"
                                                                              onfocus="WdatePicker({el:'endDate'})"/>
                                        <IMG src="/product/jsp/images/icon_day.gif"
                                             style="cursor:pointer;vertical-align: middle"
                                             onclick="WdatePicker({el:'endDate'})"/>
                                        <label for="type">数据表</label>
                                        <select id="type">
                                            <option value="*">全部</option>
                                            <option value="dm">机构代码表</option>
                                            <option value="fz">代码注销表</option>
                                            <option value="sc">代码删除表</option>
                                            <option value="qz">代码迁址表</option>
                                        </select>
                                        <input name="button2" type="button"
                                               onclick="upload()"
                                               class="newBtn1"
                                               value="上 报"/>
                                    </div>
                                </TD>
                        </TABLE>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
<script type="text/javascript">
    $('#jgdm').bind("keyup", function () {
        this.value = this.value.toUpperCase();
        if (!/^[a-zA-Z0-9]+$/.test(this.value)) {
            this.value.value = this.value.replace(/[^a-zA-Z0-9]/gm, "");
            return false;
        }
        return true;
    });
    function upload() {
        var jgdm = $('#jgdm');
        $.post(
                "/bsweb/auditSetting_updata",
                {    jgdm: jgdm.val(),
                    startDate: $('#startDate').val(),
                    endDate: $('#endDate').val(),
                    type: $('#type').val()
                },
                function (data, status) {
                    if (status == 'success') {
                        ymPrompt.close();
                        if (data.toString().indexOf('nok') > 0) {
                            ymPrompt.alert("数据上传异常，请重试。", 330, 220, "提示信息");
                        } else {
                            ymPrompt.alert("数据上报成功。", 330, 220, "提示信息");
                        }
                    } else {
                        ymPrompt.close();
                        ymPrompt.alert("上传图像数据异常，请重试。", 330, 220, "提示信息");
                    }
                });
        ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
        return true;
    }
</script>
</html>
