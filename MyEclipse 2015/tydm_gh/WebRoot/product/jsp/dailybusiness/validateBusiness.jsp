<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String bzDate = DateUtil.dateToStr(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>ѡ���֤����</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
        <script type='text/javascript' src='/dwr/engine.js'></script>
            <script type="text/javascript" src="/js/public.js"></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/zycpBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/xzqhBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/gjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/ajaxBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript">
    	$(function(){   $("#fzyj").focus();  })
    	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
    </script>
    <script type="text/javascript">

        function validateBus() {
            
            var a =document.getElementById("zxpzwh").value;
            var b = document.getElementById("tbrxm").value;
 			var c = document.getElementById("tbrsfzh").value;
        	var d = document.getElementById("tbrmobile").value;  
        	var sjghmc = document.getElementById("sjghmc").value;  
        	var pzzxrq = document.getElementById("pzzxrq").value;  
       	  
            if(a == ""|| a == null){
            	ymPrompt.alert("������ע����׼�ĺ�", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("zxpzwh").focus();
					}
				});
				return false;
            }
            
            if(b == ""|| b == null){
            	ymPrompt.alert("��������������Ϊ��", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("tbrxm").focus();
					}
				});
				return false;
            }
            
            if(c == ""|| c == null){
            	ymPrompt.alert("������֤�����벻��Ϊ��", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("tbrsfzh").focus();
					}
				});
				return false;
            }
            
            if(d == ""|| d == null){
            	ymPrompt.alert("�������ֻ�����Ϊ��", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("tbrmobile").focus();
					}
				});
				return false;
            }
            
             if(sjghmc == ""|| sjghmc == null){
            	ymPrompt.alert("��׼�ϼ����᲻��Ϊ��", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("sjghmc").focus();
					}
				});
				return false;
            }
            
            if(pzzxrq == ""|| pzzxrq == null){
            	ymPrompt.alert("�ϼ�������׼ע�����ڲ���Ϊ��", 330, 220, "��ʾ��Ϣ", function (data) {
					if (data == "ok") {
						document.getElementById("pzzxrq").focus();
					}
				});
				return false;
            }

        
        	if (confirm("ȷ��Ҫ�ύ��")) {
	            document.busForm.btok.disabled = "true";
	       		document.busForm.submit();
        	}

        }
        function redoAudit() {
            document.busForm.action = "/bsweb/business_search.action";
            document.busForm.btok.disabled = "true";
            document.busForm.submit();

        }
        function back() {

            <c:if test="${source eq 'pendApproval'}">
            window.location.href = '/bsweb/pendApproval_list';
            </c:if>
            <c:if test="${source eq 'validate'}">
            window.location.href = '/bsweb/business_list?source=validate&jglx=${jglx}';
            </c:if>
        }
    </script>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="left" style=" float: left;"><strong>�Ǽ� &gt;&gt;  <c:if test='${1 eq jglx}'>
   
 
    �������ҵ��
    </c:if>
     <c:if test='${2 eq jglx}'>  
    ������ҵ��λҵ��
  </c:if>
     <c:if test='${3 eq jglx}'>
    �����ҵ��
     </c:if>&gt;&gt; ע���Ǽ�</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();" type="button"
               value="${needAudit==true?"�ύ���":"ע ��"}">
        &nbsp;
        <INPUT class="newBtn1" onClick="back()" type=button value="�� ��" name='cmdExit'>
        &nbsp;
    </div>
</div>
<form method="post" action="/bsweb/business_validateDM.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.tyshxydm" value="${jgdm.tyshxydm}"/>
    <input type="hidden" name="jgdm.bzjgdm" value="${jgdm.bzjgdm}" id="bzjgdm"/>
    <input type="hidden" name="audit" value="${audit}"/>
    <input type="hidden" name="needAudit" value="true" id="needAudit"/>
    <input type="hidden" name="type" value="validate" id="type"/>
    <input type="hidden" name="mc" value="${jgdm.tyshxydm}" id="mc"/>
	<input type="hidden" name="jglx" value="${jglx }">
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>����ע��</b></h3>
                    		<table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
                    		<tr>
                    			
                    			<Td class=td1 align=right width="15%">
                                  	 ע����׼�ĺ�
                                </Td>
                                <Td class=td1 >
                                       <input type="text" name="fzdm.zxpzwh" id="zxpzwh" value="${zxpzwh}" maxlength="70" required ="true"/>        
                                <FONT color=red> * </FONT>                			
                    			 </Td>
                    		</tr>
                    		<tr>
								<td colspan=1 align="right">
									ͳһ������ô��룺
								</td>
								<td colspan=3 align="left">
									${jgdm.tyshxydm }
								</td>							
							</tr>
							<tr>
								<td colspan=1 align="right">
									�������ƣ�
								</td>
								<td colspan=3 align="left">
									${jgdm.jgmc }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									ס����ַ��
								</td>
								<td colspan=3 align="left">
									${jgdm.jgdz }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									ס������������
								</td>
								<td class=td1>
									${jgdm.xzqh }
								</td>
								<td class=td1 align=right>
									ס���������� ��
								</td>
								<td class=td1 >
									${jgdm.yzbm }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									�칫��ַ��
								</td>
								<td colspan=3 align="left">
									${jgdm.bgjgdz }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									�칫����������
								</td>
								<td class=td1>
									${jgdm.bgxzqh }
								</td>
								<td class=td1 align=right>
									�칫�������� ��
								</td>
								<td class=td1 >
									${jgdm.bgyzbm }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									�������˵�λ��
								</td>
								<td class=td1>
									${jgdm.zgmc }
								</td>
								<td class=td1 align=right>
									�������˵�λ���� ��
								</td>
								<td class=td1 >
									${jgdm.zgdm }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									ҵ��Χ��
								</td>
								<td colspan=3 align="left">
									${jgdm.jyfw }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									��ַ��
								</td>
								<td colspan=1 align="left">
									${jgdm.url }
								</td>
														
								<td colspan=1 align="right">
									��֤���أ�
								</td>
								<td colspan=1 align="left">
									${jgdm.pzjgmc }
								</td>
				
							</tr>							
							<tr>
								<td class=td1 align=right>
									�������ڣ�
								</td>
								<td class=td1>
									${jgdm.zcrq }
								</td>
								<td class=td1 align=right>
									��׼���� ��
								</td>
								<td class=td1 >
									${jgdm.bzrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									�������������ĺţ�
								</td>
								<td class=td1>
									${jgdm.jlwh }
								</td>
								<td class=td1 align=right>
									�������� ��
								</td>
								<td class=td1 >
									${jgdm.jlrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									����ѡ�ٽ���ĺţ�
								</td>
								<td class=td1>
									${jgdm.xjwh }
								</td>
								<td class=td1 align=right>
									�������� ��
								</td>
								<td class=td1 >
									${jgdm.xjrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									��Ч����
								</td>
								<td class=td1>
								${jgdm.yxqxs }
								</td>
								<td class=td1 align=right>
									��Ч���� ��
								</td>
								<td class=td1 >
									${jgdm.yxqxe }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									��λ�绰��
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.dhhm" id="dhhm" value="" style=" width:200px;"/>
								</td>
								<td class=td1 align=right>
									����ע������ ��
								</td>
								<td class=td1 >
						        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('sqzxrq')}); "onclick="WdatePicker({el:$dp.$('zcrq')});" maxLength=10 size=23 name="fzdm.sqzxrq" id="sqzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('sqzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						        </A>
								</td>
							</tr>
							<tr>
								<td colspan=1 class=td1 align=right>
									��׼�ϼ��������ƣ�
								</td>
								<td colspan=3 class=td1>
								 <input maxlength="70" size=28 name="fzdm.sjghmc" id="sjghmc" value="" style="width:75%;"/>
								<FONT color=red> * </FONT>
								</td>
							</tr>
							<tr>
								<td colspan=1 class=td1 align=right>
									��λע��ԭ��
								</td>
								<td colspan=3 class=td1>
									<SELECT name="fzdm.dwzxyy" id="dwzxyy">	
										<OPTION value="���ڵ�λ��ֹ" >���ڵ�λ��ֹ</OPTION>
										<OPTION value="���ڵ�λ����" >���ڵ�λ����</OPTION>
										<OPTION value="����" >����</OPTION>
									</SELECT>								
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									��λע�����ڣ�
								</td>
								<td class=td1>
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('dwzxrq')}); "onclick="WdatePicker({el:$dp.$('dwzxrq')});" maxLength=10 size=23 name="fzdm.dwzxrq" id="dwzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('dwzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						        </A>
								</td>
								<td class=td1 align=right>
									����������� ��
								</td>
								<td class=td1 >
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('qswbrq')}); "onclick="WdatePicker({el:$dp.$('qswbrq')});" maxLength=10 size=23 name="fzdm.qswbrq" id="qswbrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('qswbrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						        </A>
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									�ϼ�������׼ע�����ڣ�
								</td>
								<td class=td1>
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('pzzxrq')}); "onclick="WdatePicker({el:$dp.$('pzzxrq')});" maxLength=10 size=23 name="fzdm.pzzxrq" id="pzzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('pzzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						       	<FONT color=red> * </FONT>
						        </A>
								</td>
								<td class=td1 align=right>
									׼��ע������ ��
								</td>
								<td class=td1 >
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zyzxrq')}); "onclick="WdatePicker({el:$dp.$('zyzxrq')});" maxLength=10 size=23 name="fzdm.zyzxrq" id="zyzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('zyzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						        </A>
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									������������
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.tbrxm" id="tbrxm" value="" style=" width:200px;"/>
								 <FONT color=red> * </FONT>
								</td>
								<td class=td1 align=right>
									֤������ ��
								</td>
								<td class=td1 >
								 <input maxlength="70" size=28 name="fzdm.tbrsfzh" id="tbrsfzh" value="" style=" width:200px;"/>
								<FONT color=red> * </FONT>
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									�������ֻ���
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.tbrmobile" id="tbrmobile" value="" style=" width:200px;"/>
								<FONT color=red> * </FONT>
								</td>
								<td class=td1 align=right>
									���������� ��
								</td>
								<td class=td1 >
								 <input maxlength="70" size=28 name="fzdm.tbrlxfs" id="tbrlxfs" value="" style=" width:200px;"/>
								</td>
							</tr>
							<tr>
								<td colspan=1 class=td1 align=right>
									��ע��
								</td>
								<td colspan=3 class=td1>
								 <input maxlength="70" size=28 name="fzdm.memo" id="memo" value="" style=" width:75%;"/>
								</td>
							</tr>
							
                    		</table>
                    <div class="listbtn">
                        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();"
                               type="button" value="${needAudit==true?"�ύ���":"ע ��"}" name="btok">
                        &nbsp;
                        <INPUT class="newBtn1" onClick="back()" type=button value="�� ��"
                               name='cmdExit'>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<style type="text/css">
    table.tableBorder0 td {
        border: #c4dbe5 1px solid;
    }
</style>
<jsp:include page="../common/onload.jsp"/>
</html>
