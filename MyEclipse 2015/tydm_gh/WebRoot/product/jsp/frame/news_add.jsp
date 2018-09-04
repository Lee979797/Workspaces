<%@ page language="java" import="java.util.*" pageEncoding="GBK" %>
<%@ page import="com.ninemax.jpa.util.DateProcess" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.nacao.business.message.SystemMessageBus" %>
<%@ page import="com.ninemax.nacao.to.message.SystemMessageTO" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.nacao.business.message.AttachmentBus" %>
<%@ page import="com.ninemax.nacao.to.message.AttachmentTO" %>
<%
    String uuid = StringUtils.getUUID(); // Ϊ���渽�� - ���õ� Ψһ��ʶ i
    request.getSession().setAttribute("uuid", uuid);
    String ids = request.getParameter("id");
    User sysuser = (User) session.getAttribute("sysUser");
    String c_userid = sysuser.getUserId() + "";
    String title = "";
    String oper = "";
    SystemMessageTO sysMes = null;
    List<AttachmentTO> atList = null;
    String url = "";
    if (clsStringTool.isEmpty(ids)) {
        title = "����";
        oper = "new";

    } else {
        title = "�޸�";
        oper = "newmod";
        SystemMessageBus sysMessBus = new SystemMessageBus();
        AttachmentBus attachmentBus = new AttachmentBus();
        sysMes = sysMessBus.findBySysID(ids);
        sysMes.setSend_content(sysMes.getSend_content().replace("\"",
                ""));
        // ��������
        atList = attachmentBus.getAttachmentInfoToJson(ids);
        // ����·��
        String savePath =  CommonPropertiesUtil.getValue("common.properties", "filepath");
        url = request.getContextPath() + "/servlet/DownServlet?path=" + savePath;
    }
    request.setAttribute("sysMes", sysMes);
    String sysDate = DateProcess.getSysDate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script src="<%=request.getContextPath()%>/fckeditor/fckeditor.js"
            type="text/javascript"></script>
    <script type="text/javascript" src="../frame/js/alert/ymPrompt.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/dwr/interface/ForbidwordBo.js'></script>
    <script type='text/javascript' src='/dwr/interface/AttachmentBus.js'></script>

    <link rel="stylesheet" id='skin' type="text/css"
          href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
    <SCRIPT LANGUAGE="JavaScript">
        /////////////////////////////////////////////////////
        function _submit(oper) {
            var isTrue = true;
            var send_title = document.getElementById("send_title");
            if (send_title.value == '' || send_title.value == "undefined" || send_title.value.replace(/(^\s*)|(\s*$)/g, "") == "") {
                ymPrompt.alert("�����빫����⣡", 280, 190, "��ʾ��Ϣ", function (data) {
                    if (data == "ok") {
                        searchForm.send_title.focus();
                    }
                });
                isTrue = false;
                return;
            }
            if (send_title.value.length > 1000) {
                ymPrompt.alert("����Ĺ�����ⲻ������1000�ַ���", 280, 190, "��ʾ��Ϣ", function (data) {
                    if (data == "ok") {
                        searchForm.send_title.focus();
                    }
                });
                isTrue = false;
                return;
            }

            var flag;
            dwr.engine.setAsync(false);
            ForbidwordBo.getBadWordsInPost(send_title.value, {callback: function (dwrreturn) {
                flag = dwrreturn;
            }
            });
            dwr.engine.setAsync(true);

            if (!flag) {
                ymPrompt.alert("��ȥ�������е����дʣ�", 280, 190, "��ʾ��Ϣ", function (data) {
                    if (data == "ok") {
                        searchForm.send_title.focus();
                    }
                });

                return;
            }


            /*var send_time = document.getElementById("CalendarSelector1");
             if (send_time.value == '' || send_time.value == "undefined") {
             ymPrompt.alert("��ѡ����Ч�ڣ�", 280, 190, "��ʾ��Ϣ", function(data) {
             if (data == "ok") {
             searchForm.send_time.focus();
             }
             });
             isTrue = false;
             return;
             }*/

            var send_content = document.getElementById("send_content");
            send_content.value = FCKeditorAPI.GetInstance('test').GetHTML(true);
            if (send_content.value.length == 0 || send_content.value.replace(/(^\s*)|(\s*$)/g, "") == "") {
                ymPrompt.alert({message: "�����빫�����ݣ�", width: 330, height: 220, title: '��ʾ��Ϣ'});
                isTrue = false;
                return;
            }
            if (send_content.value.replace(/(^\s*)|(\s*$)/g, "") == "") {
                ymPrompt.alert({message: "�����빫�����ݣ�", width: 330, height: 220, title: '��ʾ��Ϣ'});
                isTrue = false;
                return;
            }
            if (send_content.value.replace(/[^\x00-\xff]/g, "**").length > 4000) {
                ymPrompt.alert({message: "����Ĺ������ݲ�������2000���ֻ�4000�ַ���\nע:ϵͳ�������HTML��ʽ���뾡�����ÿո񣬻س����ַ���", width: 330, height: 220, title: '��ʾ��Ϣ'});
                isTrue = false;
                return;
            }
            var regR = /[\r]/g;
            var regN = /[\n]/g;
            var defVal = send_content.value;
            defVal = defVal.replace(regR, "<br>");// ����������Ļ���
            defVal = defVal.replace(regN, "");    // DB��ȡ�����ҳ��Ļس�
            searchForm.send_content.value = defVal;
            var cflag;
            dwr.engine.setAsync(false);
            ForbidwordBo.getBadWordsInPost(send_content.value, {callback: function (dwrreturn) {
                cflag = dwrreturn;
            }
            });
            dwr.engine.setAsync(true);

            if (!cflag) {
                ymPrompt.alert("��ȥ�������е����дʣ�", 280, 190, "��ʾ��Ϣ", function (data) {
                    if (data == "ok") {
                        searchForm.send_content.focus();
                    }
                });

                return;
            }

            searchForm.operFlag.value = oper;
            if (isTrue) {
                searchForm.submit();
            }
        }
        //////////////////////////////////////////////////////////
        function trimIntputValue(obj) {
            obj.value = obj.value.replace(/^( |[\s��])+|( |[\s��])+$/g, "");
        }
        // ɾ������
        function delUpload(diva, fileId) {
            dwr.engine.setAsync(false);
            AttachmentBus.deleteAttachmen(fileId, function (data) {
                //��ʼ �� ������ƴ ���� ��Ϣ
                if (data == '0') {
                    ymPrompt.alert({message: "ɾ�������ɹ���", width: 330, height: 220, title: '��ʾ��Ϣ'});
                }
                document.getElementById(diva).parentNode.removeChild(document.getElementById(diva));
            });
        }
        // �򿪸�������
        function addUpload() {
            var strPage = "<%=request.getContextPath()%>/product/jsp/frame/upload.jsp";
            var winFeatures = "dialogHeight:500px; dialogWidth:800px;status:no;scroll:no;dialogTop:300;dialogLeft:400px;center:Yes;help:no;status:no;";
            window.showModalDialog(strPage, window, winFeatures);
        }

    </SCRIPT>

</head>
<body style="overflow-x: hidden; scrollbar-x: none;">
<div class="page_top">
    ϵͳ &gt;&gt; ������� &gt;&gt; ������� &gt;&gt;
    <%=title%>����
</div>
<form name="searchForm"
      action="/action/SystemMessageAction"
      method="post">
    <!-- ָ���ϴ������ļ���С  -->
    <input type="hidden" name="uuid" id="uuid" value="<%=uuid%>"/>
    <input type="hidden" name="sys_id" value="${sysMes.sys_id}"/>
    <input type="hidden" name="type" value="3"/>
    <input type="hidden" name="oper_date" value="<%=sysDate%>"/>
    <input type="hidden" name="from_person" value="<%=c_userid%>"/>
    <input type="hidden" name="operFlag"/>

    <div id="list_main">
        <div class="page_box">
            <div class="table_box1 f_10">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">
                            ������⣺
                        </td>
                        <td valign="middle" colspan="3">
                            <input onblur="trimIntputValue(this);" type="text"
                                   name="send_title" id="send_title" width="350"
                                   style="width: 450px;" value="${sysMes.send_title}"/>
                        </td>
                    </tr>
                    <!-- ��Ӹ��� ��� -->
                    <tr align="left">
                        <td width="105" align="right" valign="middle">
                        </td>
                        <td valign="middle" colspan="3">
                            <!--�н�����file�ļ����HTML����-->
                            <div id="uploadContent">
                                <%
                                    if (!clsStringTool.isEmpty(ids)) {
                                        for (AttachmentTO at : atList) {
                                %>
                                <div id="divUpload<%=at.getFileId()%>">
                                    <input type="hidden" id="file" name="file" size=50 value="<%=at.getFileId()%>">
                                    <input type="hidden" id="fileName" name="fileName" size=50
                                           value="<%=at.getSaveName()%>">
                                    <img src='/product/jsp/images/fujian_tubiao.jpg'/><a
                                        href="<%=url+at.getSaveName()%>"><%=at.getFileName()%>
                                </a>
                                    <a href=javascript:delUpload('divUpload<%=at.getFileId()%>',<%=at.getFileId()%>
                                    );>ɾ��</a>
                                </div>
                                <%
                                        }
                                    }
                                %>
                                <!--Ĭ�ϵ�file�ļ���
               <div id=div1><input id=file1 type=file size=50 name='upload'></div>-->
                            </div>
                        </td>
                    </tr>
                    <tr align="left">
                        <td width="105" align="right" valign="middle">

                        </td>
                        <td valign="middle" colspan="3">
                            <INPUT type="button" onclick="addUpload()" value="��Ӹ���"/>
                        </td>
                    </tr>


                    <%-- <tr class="table_tr1">
              <td width="105" align="right" valign="middle">��Ч������</td>
              <td width="89%" colspan="3"><input name="send_time" type="text" class="input_120" id="CalendarSelector1" value="${sysMes.oper_date}" style="background:#fff url(../../images/icon_edit.gif) no-repeat right;" onfocus="WdatePicker({el:'CalendarSelector1'})" readonly/></td>
            </tr>--%>
                    <tr class="table_tr1">
                        <td width="105" align="right" valign="middle">
                            �������ݣ�
                        </td>
                        <td valign="middle" colspan="3">
                            <div id="ContentWin" style="width: 90%; height: 400px">
                                <script type="text/javascript">
                                    var oFCKeditor = new FCKeditor('test');
                                    oFCKeditor.BasePath = "<%=request.getContextPath()%>/fckeditor/";
                                    oFCKeditor.Config["CustomConfigurationsPath"] = "<%=request.getContextPath()%>/fckeditor/myconfig.js"
                                    oFCKeditor.Config["ImageBrowser"] = true;
                                    oFCKeditor.Config["LinkUpload"] = true;
                                    oFCKeditor.Config["FlashBrowser"] = true;
                                    oFCKeditor.Config["LinkBrowser"] = true;
                                    oFCKeditor.Config["MediaBrowser"] = true;
                                    oFCKeditor.Config["EnterMode"] = 'p';
                                    oFCKeditor.Config["FormatOutput"] = true;
                                    oFCKeditor.Config["FillEmptyBlocks"] = false;
                                    oFCKeditor.Config["SkinPath"] = oFCKeditor.BasePath + 'editor/skins/default/';
                                    oFCKeditor.ToolbarSet = 'jeecms1';
                                    oFCKeditor.Height = 400;
                                    oFCKeditor.Value = "<%=sysMes != null ? sysMes.getSend_content().trim() : ""%>";
                                    oFCKeditor.Create();
                                </script>
                            </div>
                            <textarea name="send_content" id="send_content"
                                      class="page_input_txt" cols="50" rows="25"
                                      style="width: 90%; display: none"></textarea>
                    </tr>
                </table>
            </div>
            <div class="listbtn">
                <input name="button" type="button" class="newBtn1" id="button1"
                       value="��  ��" onclick="_submit('<%=oper%>')"/>
                <input name="button2" type="button" class="newBtn1" id="button2"
                       value="��  ��" onclick="window.location.reload();"/>
                <input name="button" type="button" class="newBtn1" id="button3"
                       value="��  ��" onclick="history.go(-1);"/>
            </div>
        </div>
    </div>
</form>
</body>

</html>
<%
    String message = request.getParameter("msg");
    String opers = clsStringTool.convertNull(request
            .getParameter("oper"));
    if (message != null) {
        if (message.equals("success")) {
            if (opers.equals("add")) {
                message = "���ӳɹ�";
            } else {
                message = "�޸ĳɹ�";
            }
        } else {
            if (opers.equals("add")) {
                message = "����ʧ��";
            } else {
                message = "�޸�ʧ��";
            }
        }
%>
<script type="text/javascript">
    ymPrompt.alert("<%=message%>", 330, 220, "��ʾ��Ϣ", function (data) {
        if (data == 'ok') {
            window.location.href = "gonggao.jsp";
        }
    });
</script>
<%
    }
%>

