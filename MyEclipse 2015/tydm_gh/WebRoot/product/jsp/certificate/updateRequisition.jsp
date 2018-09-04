<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdmSave" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    TJgdmSave tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
    String time = DateUtil.getCurrentDateTime().substring(0, 4);
    String bzDate = DateUtil.dateToStr(new Date());
    String pageno = request.getParameter("pageno");
    String rowNumsView = request.getParameter("rowNumsView");
    String formType = request.getParameter("formType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#pzjgmc").focus();
        })
        document.onkeydown = function () {
            if (event.keyCode == 13) {
                event.keyCode = 9;
            }
        }
    </script>

    <script type="text/javascript">


        function judgeCodeName() {
            var e = document.getElementById("jgmc");
            var jgdm = document.getElementById("jgdm");
            var id = document.getElementById("id");
            if (e.value == "" || e.value == null) {
                document.getElementById("mcInfo").innerHTML = '�������Ʋ���Ϊ��!';
                return false;
            }
            /*if (e.value.replace(/[^\x00-\xff]/g, "**").length > 200 ) {
             document.getElementById("mcInfo").innerHTML = '����Ļ��������ֽڴ���200���ַ������޸�!';
             e.value = e.value.substring(0, 200);
             return false;
             }*/
            //�ж��û����Ƿ��ѱ�ע��
            var flag = false;
            var sourceTable;
            dwr.engine.setAsync(false);
            var dm = (jgdm.value == undefined || jgdm.value == null || jgdm.value.trim() == "") ? id.value : jgdm.value.trim();
            tjgdmSaveBus.isExistCodeName(e.value, dm, "", function (data) {
                if (data != '') {
                    flag = true;
                    sourceTable = data.split(':')[1];
                }
            });
            dwr.engine.setAsync(true);
            if (flag == true) {
                document.getElementById("mcInfo").innerHTML = '���������Ѿ�����' + sourceTable + '��!';
                return '���������Ѿ�����' + sourceTable + '��!';
            } else {
                document.getElementById("mcInfo").innerHTML = '<font color="green">�������ƿ���ʹ��!</font>';
                return '';
            }
        }

        function fCheckValue() {
            var strYear, strWjwmc, strJgmc, strPzwh, strWjwtbr, strPwrq, strDate;
            strWjwmc = Trim(busForm.pzjgmc.value, 0);
            strJgmc = Trim(busForm.jgmc.value, 0);
            strPzwh = Trim(busForm.pzwh.value, 0);
            strWjwtbr = Trim(busForm.wjwtbr.value, 0);
            strPwrq = Trim(busForm.tpwrq.value, 0);
            strDate = new Date();

            if (strWjwmc.length <= 0) {
                ymPrompt.alert({message: "��������׼��������!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                busForm.pzjgmc.focus();
                return false;
            }

            if (strJgmc.length <= 0) {
                ymPrompt.alert({message: "�������������!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                busForm.jgmc.focus();
                return false;
            }

            if (strPzwh.length <= 0) {
                ymPrompt.alert({message: "��������׼�ĺ�!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                busForm.pzwh.focus();
                return false;
            }

            /*if(strWjwtbr.length<=0){
             alert("�����뾭����")
             busForm.txtwjwtbr.focus();
             return false;
             }*/

            if (strPwrq.length <= 0) {
                ymPrompt.alert({message: "�������ڲ���Ϊ��,����������!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                busForm.tpwrq.focus();
                return false;
            }
            if (!CheckDate(busForm.tpwrq)) {
                busForm.tpwrq.focus();
                return false;
            }
            if (strPwrq <= strDate) {
                ymPrompt.alert({message: "�������ڴ��ڵ�ǰ����,����������!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                busForm.tpwrq.focus();
                return false;
            }
            if (!fItemCheckVaild(busForm)) {
                return false;
            }
            if (!fItemCheckVaild(busForm)) {
                return false;

            }

            var retVal = judgeCodeName();
            if (retVal.indexOf("��ʱ��") > -1) {
                ymPrompt.alert({message: retVal + ",����������!", width: 330, height: 220, title: '��ʾ��Ϣ'});
                return false;
            }
            if (retVal != '') {
                ymPrompt.confirmInfo({message: retVal + "�����ȷ�����ύ��ˣ����ͨ�������ʹ�ø����ƣ�������Ҫ������д�������ȡ������������д�������ƣ�", width: 330, height: 220, title: '��ʾ��Ϣ', handler: function (tp) {
                    if (tp == 'ok') {
                        var form = document.forms[0];
                        document.getElementById("submitType").value = '1';
                        form.submit();
                        return false;
                    }
                }});
                return false;
            }
            document.busForm.submit();
            return true;
        }

        /*$(function () {
         $("#jgmc").keyup(toFullWidth);
         function toFullWidth() {
         if (filterKeyUp())
         return false;
         if (this.value != null) {
         this.value = this.value.toSBC();
         }
         return true;
         }
         })*/
    </script>
</head>
<body style="background:#fff;">
<form method="post" action="/bsweb/certificate_updateRequisition.action" name="busForm">
    <input type="hidden" name="needAudit" value="${needAudit}" id="needAudit"/>
    <input type="hidden" name="audit" value="${audit}" id="audit"/>
    <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
    <input type="hidden" name="formType" value="2"/>
    <input type="hidden" name="id" id="id" value="<%=tJgdm.getId()%>"/>
    <input type="hidden" name="bzjgdm" value="<%=tJgdm.getBzjgdm()%>"/>
    <input type="hidden" name="pageno" value="${pageno}"/>
    <input type="hidden" name="rowNumsView" value="${rowNumsView}"/>
    <input type="hidden" name="ywlsh" value="${ywlsh}"/>
    <input type="hidden" name="nameType" id="nameType" value="updateReq"/>
    <input type="hidden" name="submitType" value="0" id="submitType"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart" style="width:100%;border:0;text-align:center;padding-top:20px;">
                    <table border="0" width="90%" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>
                                <div align="center">
                                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td width="50%"></td>
                                            <td width="25%" align="center">��ţ���<input readonly="true" type="text"
                                                                                      size="5" name="year"
                                                                                      value="<%=time%>" maxlength="0"
                                                                                      style="border-left-style: solid; border-left-color: #FFFFFF; border-right-style: solid; border-right-color: #FFFFFF; border-top-style: solid; border-top-color: #FFFFFF; border-bottom-style: solid">��
                                            </td>
                                            <td width="25%" align="center">�� <input readonly="true" type="text"
                                                                                    size="10" name="wjwlsh"
                                                                                    value="<%=tJgdm.getWjwlsh()%>"
                                                                                    style="border-style: solid; border-color: #FFFFFF"
                                                                                    maxlength="0"> ��
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="40">
                                <p align="center" style="line-height:40pt"><b><font face="����_gbk"
                                                                                    size="5">ȫ����֯�������븳��֪ͨ��</font></b>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td height="30">
                                <p style="margin-left: 20"><input type="text" size="45" id="pzjgmc" name="pzjgmc"
                                                                  maxlength="70"
                                                                  value="<%=tJgdm.getPzjgmc()%>">
                                    (��׼��������)</td>
                        </tr>
                        <tr>
                            <td height="30">
                                <p style="margin-left: 20">������λ����ȡ��֯��������</td>
                        </tr>
                        <tr>
                            <td>
                                <div align="center">
                                    <table border="1" cellpadding="0" cellspacing="0" width="100%" bordercolor="#000000"
                                           bordercolorlight="#000000" bordercolordark="#000000">
                                        <tr>
                                            <td width="32%" align="center" height="25" valign="middle">��������</td>
                                            <td width="68%" align="left" valign="middle"><input type="text" size="45"
                                                                                                name="jgmc" id="jgmc"
                                                                                                onblur="judgeCodeName();"
                                                                                                value="<%=tJgdm.getJgmc()%>"
                                                                                                style="border-style: solid; border-color: #FFFFFF"
                                                                                                maxlength="120">&nbsp;<span
                                                    style="color:red;" id="mcInfo"></span></td>
                                        </tr>
                                        <tr>
                                            <td width="32%" align="center" height="25" valign="middle">��׼�ĺ�<br>
                                                ������׼֤����׼�ţ�
                                            </td>
                                            <td width="68%" align="left" valign="middle"><input type="text" size="45"
                                                                                                name="pzwh"
                                                                                                value="<%=tJgdm.getPzwh()%>"
                                                                                                style="border-style: solid; border-color: #FFFFFF"
                                                                                                maxlength="25"></td>
                                        </tr>
                                        <tr>
                                            <td width="32%" align="center" height="25" valign="middle">��������<br>
                                                ������׼֤��䷢���ڣ�
                                            </td>
                                            <td width="68%" align="left" valign="middle">
                                                <input type="text" size="45"
                                                       name="tpwrq"
                                                       onfocus="WdatePicker({el:$dp.$('tpwrq')});"
                                                       value="<%=tJgdm.getPwrq().toString().substring(0,10)%>"
                                                       style="border-style: solid; border-color: #FFFFFF"
                                                       value="" maxlength="10">
                                                <A hideFocus onclick="WdatePicker({el:$dp.$('tpwrq')});"
                                                   href="javascript:void(0)">
                                                    <IMG src="/images/icon_rili.gif" align=absMiddle name='popcal'/>
                                                </A>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="32%" align="center" height="25" valign="middle">��֯��������</td>
                                            <td width="68%" align="left" valign="middle"><input type="text" size="45"
                                                                                                name="jgdm" id="jgdm"
                                                                                                value="<%=tJgdm.getJgdm()!=null?tJgdm.getJgdm().trim():""%>"
                                                                                                style="border-style: solid; border-color: #FFFFFF"
                                                                                                readonly="true"/></td>
                                        </tr>
                                        <tr>
                                            <td width="32%" align="center" height="25" valign="middle">��������</td>
                                            <td width="68%" align="left" valign="middle" style="font-weight:bold;">
                                                &nbsp;<%=tJgdm.getBzrq().toString().substring(0, 10)%>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" height="30">���ǩ���ˣ�<input type="text" size="20" name="wjwtbr"
                                                                       value="<%=tJgdm.getWjwtbr()%>"
                                                                       style="border:1px solid black;border-left-style: solid; border-left-color: #FFFFFF; border-right-style: solid; border-right-color: #FFFFFF; border-top-style: solid; border-top-color: #FFFFFF; border-bottom-style: solid"
                                                                       maxlength="4"></td>
                        </tr>
                        <tr>
                            <td align="right" height="30"><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>(�����������)
                            </td>
                        </tr>
                        <tr>
                            <td align="right" height="30">
                                <p style="margin-right: 95"><%=bzDate%>
                            </td>
                        </tr>
                    </table>
                    <div class="listbtn">
                        <INPUT class="newBtn1" onClick="javascript:return fCheckValue();" type="button" value="�� ��"
                               name="btok">&nbsp;<INPUT class="newBtn1"
                                                        onClick="window.location.href='/bsweb/certificate_yfmList.action?formType=<%=formType%>&pageno=<%=pageno%>&rowNumsView=<%=rowNumsView%>'"
                                                        type=button value="�� ��" name='cmdExit'>&nbsp;
                        <div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script>
    (function () {
        var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6�µĶ�λ
            if (!window.XMLHttpRequest) {
                $backToTopEle.css("top", st + winh - 166);
            }
        };
        $(window).bind("scroll", $backToTopFun);
        $(function () {
            $backToTopFun();
        });
    })();
</script>

<script>
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg != null&&!"".equals(msg.toString().trim())){
         if("addSuccess".equals(msg.toString())){
    %>
    ymPrompt.succeedInfo('���³ɹ���', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_yfmList.action";
    });
    <%}else if("codeRepeat".equals(msg.toString())){%>
    ymPrompt.alert('���������ظ�!����${sourceTable}��!', 330, 220, '��ʾ��Ϣ', function () {
        /*window.location.href = "/bsweb/certificate_updateRequisitionPage.action?id=
        <%=tJgdm.getId()%>";*/
    });
    <%
    }else{%>
    ymPrompt.alert('ϵͳ��æ!���Ժ�����!', 330, 220, '��ʾ��Ϣ', function () {
        /*window.location.href = "/bsweb/certificate_updateRequisitionPage.action?id=
        <%=tJgdm.getId()%>";*/
    });
    <%}
    }
    %>
</script>
</html>
