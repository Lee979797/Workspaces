<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.code.model.TZrxzqh" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    User user = (User) session.getAttribute("sysUser");
    String id = (String) request.getAttribute("id");
    String bzDate = DateUtil.dateToStr(new Date());
    String validate = DateUtil.dateToStr(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
    String dateLimit = "";
    TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
    //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
    if (zrxzqh != null) {
        if ("0".equals(zrxzqh.getNjfs())) {
            dateLimit = DateUtil.addMonth(DateUtil.dateToStr(new Date()), 12);
        } else {
            dateLimit = DateUtil.addMonth(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2), 12);
        }
    }

    String formType = request.getParameter("formType");
    if (clsStringTool.isEmpty(formType)) {
        formType = "0";
    }
    String title = "";
    if ("0".equals(formType)) {
        title = "��������ǼǱ�¼��";
    }
    if ("1".equals(formType)) {
        title = "�������Ÿ���ǼǱ�¼��";
    }
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
     <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
  
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/public.js"></script>

    <script type="text/javascript">
    function fCheckValue(){
    	if (fCheckItem(document.getElementById("jgdm"), "��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jgmc"), "��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeTime"), "�ռ�ʱ��")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("consigneeName"), "�ռ���")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("bzjgdm"), "��֤��������")) {
            return false;
        }
    	if (fCheckItem(document.getElementById("jkdh"), "�ɿ��")) {
            return false;
        }

    	busForm.submit();
        }
       
    </script>
    <style type="text/css">
        .highslide-maincontent a:hover{
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!------------------------------------------------------------------------------------------------->
<div class="page_top_fixed">
    <div align="left" style=" float: left;"><strong> �ռ� &gt;&gt; �ռ��Ǽ� &gt;&gt;�ռ���ϸ��Ϣ¼�� 
    </strong>

    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="return fCheckValue();" type=button value="�� ��" name="btok"/>&nbsp;<INPUT
            class="newBtn1"
            onClick="window.location.href='/bsweb/conAction_list.action'"
            type=button value="�� ��" name="cmdExit"/>&nbsp;
    </div>
    <div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>
</div>

<form method="post" action="/bsweb/conAction_addCon.action" name="busForm">


<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b>�ռ���Ϣ��</b><span></span></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >

<TR>
    <TD class=td1 align=right>
        ��������
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=20 
               name="consignee.jgdm" id="jgdm" value="${consignee.jgdm}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
    
     <TD class=td1 align=right>
        ��������
    </TD>
    <TD class=td1 colSpan=3>
  
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=100 size="158"
               name="consignee.jgmc" id="jgmc" value="${consignee.jgmc}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        �ռ�ʱ��
    </TD>
<TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')});" onblur="this.className='input_off';"
               maxLength=10 size=23
               name="consignee.consigneeTime" id="consigneeTime" style=" width:200px;"
                pattern='yyyy-MM-dd' onclick="WdatePicker({el:$dp.$('consigneeTime')});"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('consigneeTime')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </TD>
    
     <TD class=td1 align=right>
        �ռ���
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="consignee.consigneeName" id="consigneeName" value="${consignee.consigneeName}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        ��֤��������
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 
               name="consignee.bzjgdm" id="bzjgdm" value="${consignee.bzjgdm}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
    
     <TD class=td1 align=right>
       �ɿ��
    </TD>
    <TD class=td1 colSpan=3>
        <INPUT onfocus="this.className='input_on';" onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=120 size="158"
               name="consignee.jkdh" id="jkdh" value="${consignee.jkdh}" style="width:75%;"/>
               <span class="required">*</span>
    </TD>
</TR>


                            <tr >
                                <td colspan="8">
                                    <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj2">
                                        <tr height="1">
										  <td width="25%"></td>
										  <td width="8%"></td>
										  <td width="25%"></td>
										  <td width="8%"></td>
										  <td width="25%"></td>
										  <td width="8%"></td>
										</tr>
                                        <tr class="table1_tr1">
                                            <th colspan="6">�ռ�����ѡ��:</th>
                                        </tr>
                                        <tr>
  
                                            <TD class="td1" align="right">
                                                    ԭ����֤����������ڻ�֤����
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox   value="true"
                                                       name="consignee.ydmzk"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   ���Ʊ��֪ͨ��ӡ������λ���Ʊ������
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.mcbg"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   �������д�������Ӹǹ��£�
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.application"/>
                                            </TD>
        
                                        </tr>
                                                                              <tr>
  
                                            <TD class="td1" align="right">
                                                    �ϼ����븴ӡ������֧��������
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.sjdm"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   ���������֤��ӡ����A4˫�棩��
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.card"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                   ����ί������֤����ί�д��죩��
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.dmwts"/>
                                            </TD>
        
                                        </tr>
                                                                              <tr>
  
                                            <TD class="td1" align="right">
                                                   ��λ���˴�����������֤���գ�
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.dwdb"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                  ̨��֤��ӡ����A4˫�棩��
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox   value="true"
                                                       name="consignee.tbz"/>
                                            </TD>
                                            <TD class="td1" align="right">
                                                  ��˵�λ�����ļ�ԭ�����ṩ��Ч��ӡ����
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.yhdw"/>
                                            </TD>
        
                                        </tr>
                                        <tr>
                                        <TD class="td1" align="right">
                                                  ������
                                            </TD>
                                            <TD class="td1">
                                                <INPUT type=checkbox    value="true"
                                                       name="consignee.other"/>
                                            </TD>
                                        
                                        </tr>
                                        
                                        
                                        
                                        <tr>



                                        </tr>
                                    </TABLE>
                                </td>
                            </tr>

</TABLE>
</div>

<div class="listbtn">
    <INPUT class="newBtn1" onClick="javascript:return fCheckValue();" type=button value="�� ��" name="btok"/>&nbsp;<INPUT
        class="newBtn1"
        onClick="window.location.href='/bsweb/conAction_list.action'"
        type=button
        value="�� ��" name="cmdExit"/>&nbsp;
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



</html>
