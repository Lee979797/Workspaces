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
    <div style="float:left;"><strong>ϵͳ &gt;&gt; ϵͳ���� &gt;&gt; �����ϱ�</strong></div>
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
                                    �����ϱ�
                                </th>
                            </tr>
                            <tr>
                                <TD class="td1">
                                    <div class="list_box_top">
                                        <label for="jgdm"> �������룺</label>
                                        <input type="text" name="jgdm" size="13" onkeyup="" id="jgdm" maxlength="9"
                                               value="" class="input_120">
                                        <label for="startDate"> ���ݱ������:</label><input id="startDate" type="text"
                                                                                      class="input_120"
                                                                                      onfocus="WdatePicker({el:'startDate'})"/>
                                        <IMG src="/product/jsp/images/icon_day.gif"
                                             style="cursor:pointer; vertical-align: middle"
                                             onclick="WdatePicker({el:'startDate'})"/>
                                        <label for="endDate">����</label><input id="endDate" type="text"
                                                                              class="input_120"
                                                                              onfocus="WdatePicker({el:'endDate'})"/>
                                        <IMG src="/product/jsp/images/icon_day.gif"
                                             style="cursor:pointer;vertical-align: middle"
                                             onclick="WdatePicker({el:'endDate'})"/>
                                        <label for="type">���ݱ�</label>
                                        <select id="type">
                                            <option value="*">ȫ��</option>
                                            <option value="dm">���������</option>
                                            <option value="fz">����ע����</option>
                                            <option value="sc">����ɾ����</option>
                                            <option value="qz">����Ǩַ��</option>
                                        </select>
                                        <input name="button2" type="button"
                                               onclick="upload()"
                                               class="newBtn1"
                                               value="�� ��"/>
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
                            ymPrompt.alert("�����ϴ��쳣�������ԡ�", 330, 220, "��ʾ��Ϣ");
                        } else {
                            ymPrompt.alert("�����ϱ��ɹ���", 330, 220, "��ʾ��Ϣ");
                        }
                    } else {
                        ymPrompt.close();
                        ymPrompt.alert("�ϴ�ͼ�������쳣�������ԡ�", 330, 220, "��ʾ��Ϣ");
                    }
                });
        ymPrompt.win({message: '/product/jsp/scanTask/loading.html', width: 300, height: 100, titleBar: false, iframe: true});
        return true;
    }
</script>
</html>
