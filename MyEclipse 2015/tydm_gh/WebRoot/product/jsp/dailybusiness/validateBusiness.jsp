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
    <title>选择办证机构</title>
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
            	ymPrompt.alert("请输入注销批准文号", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("zxpzwh").focus();
					}
				});
				return false;
            }
            
            if(b == ""|| b == null){
            	ymPrompt.alert("经办人姓名不能为空", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("tbrxm").focus();
					}
				});
				return false;
            }
            
            if(c == ""|| c == null){
            	ymPrompt.alert("经办人证件号码不能为空", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("tbrsfzh").focus();
					}
				});
				return false;
            }
            
            if(d == ""|| d == null){
            	ymPrompt.alert("经办人手机不能为空", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("tbrmobile").focus();
					}
				});
				return false;
            }
            
             if(sjghmc == ""|| sjghmc == null){
            	ymPrompt.alert("批准上级工会不能为空", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("sjghmc").focus();
					}
				});
				return false;
            }
            
            if(pzzxrq == ""|| pzzxrq == null){
            	ymPrompt.alert("上级工会批准注销日期不能为空", 330, 220, "提示信息", function (data) {
					if (data == "ok") {
						document.getElementById("pzzxrq").focus();
					}
				});
				return false;
            }

        
        	if (confirm("确认要提交？")) {
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
    <div align="left" style=" float: left;"><strong>登记 &gt;&gt;  <c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if>&gt;&gt; 注销登记</strong></div>
    <div align="right" style=" float: right;">
        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();" type="button"
               value="${needAudit==true?"提交审核":"注 销"}">
        &nbsp;
        <INPUT class="newBtn1" onClick="back()" type=button value="返 回" name='cmdExit'>
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
                        <h3><b>代码注销</b></h3>
                    		<table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
                    		<tr>
                    			
                    			<Td class=td1 align=right width="15%">
                                  	 注销批准文号
                                </Td>
                                <Td class=td1 >
                                       <input type="text" name="fzdm.zxpzwh" id="zxpzwh" value="${zxpzwh}" maxlength="70" required ="true"/>        
                                <FONT color=red> * </FONT>                			
                    			 </Td>
                    		</tr>
                    		<tr>
								<td colspan=1 align="right">
									统一社会信用代码：
								</td>
								<td colspan=3 align="left">
									${jgdm.tyshxydm }
								</td>							
							</tr>
							<tr>
								<td colspan=1 align="right">
									机构名称：
								</td>
								<td colspan=3 align="left">
									${jgdm.jgmc }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									住所地址：
								</td>
								<td colspan=3 align="left">
									${jgdm.jgdz }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									住所行政区划：
								</td>
								<td class=td1>
									${jgdm.xzqh }
								</td>
								<td class=td1 align=right>
									住所邮政编码 ：
								</td>
								<td class=td1 >
									${jgdm.yzbm }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									办公地址：
								</td>
								<td colspan=3 align="left">
									${jgdm.bgjgdz }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									办公行政区划：
								</td>
								<td class=td1>
									${jgdm.bgxzqh }
								</td>
								<td class=td1 align=right>
									办公邮政编码 ：
								</td>
								<td class=td1 >
									${jgdm.bgyzbm }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									所在用人单位：
								</td>
								<td class=td1>
									${jgdm.zgmc }
								</td>
								<td class=td1 align=right>
									所在用人单位代码 ：
								</td>
								<td class=td1 >
									${jgdm.zgdm }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									业务范围：
								</td>
								<td colspan=3 align="left">
									${jgdm.jyfw }
								</td>
							</tr>
							<tr>
								<td colspan=1 align="right">
									网址：
								</td>
								<td colspan=1 align="left">
									${jgdm.url }
								</td>
														
								<td colspan=1 align="right">
									发证机关：
								</td>
								<td colspan=1 align="left">
									${jgdm.pzjgmc }
								</td>
				
							</tr>							
							<tr>
								<td class=td1 align=right>
									成立日期：
								</td>
								<td class=td1>
									${jgdm.zcrq }
								</td>
								<td class=td1 align=right>
									核准日期 ：
								</td>
								<td class=td1 >
									${jgdm.bzrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									批复建立工会文号：
								</td>
								<td class=td1>
									${jgdm.jlwh }
								</td>
								<td class=td1 align=right>
									审批日期 ：
								</td>
								<td class=td1 >
									${jgdm.jlrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									批复选举结果文号：
								</td>
								<td class=td1>
									${jgdm.xjwh }
								</td>
								<td class=td1 align=right>
									审批日期 ：
								</td>
								<td class=td1 >
									${jgdm.xjrq }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									有效期起：
								</td>
								<td class=td1>
								${jgdm.yxqxs }
								</td>
								<td class=td1 align=right>
									有效期至 ：
								</td>
								<td class=td1 >
									${jgdm.yxqxe }
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									单位电话：
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.dhhm" id="dhhm" value="" style=" width:200px;"/>
								</td>
								<td class=td1 align=right>
									申请注销日期 ：
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
									批准上级工会名称：
								</td>
								<td colspan=3 class=td1>
								 <input maxlength="70" size=28 name="fzdm.sjghmc" id="sjghmc" value="" style="width:75%;"/>
								<FONT color=red> * </FONT>
								</td>
							</tr>
							<tr>
								<td colspan=1 class=td1 align=right>
									单位注销原因：
								</td>
								<td colspan=3 class=td1>
									<SELECT name="fzdm.dwzxyy" id="dwzxyy">	
										<OPTION value="所在单位终止" >所在单位终止</OPTION>
										<OPTION value="所在单位撤销" >所在单位撤销</OPTION>
										<OPTION value="其他" >其他</OPTION>
									</SELECT>								
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									单位注销日期：
								</td>
								<td class=td1>
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('dwzxrq')}); "onclick="WdatePicker({el:$dp.$('dwzxrq')});" maxLength=10 size=23 name="fzdm.dwzxrq" id="dwzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('dwzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						        </A>
								</td>
								<td class=td1 align=right>
									清算完毕日期 ：
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
									上级工会批准注销日期：
								</td>
								<td class=td1>
								<INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('pzzxrq')}); "onclick="WdatePicker({el:$dp.$('pzzxrq')});" maxLength=10 size=23 name="fzdm.pzzxrq" id="pzzxrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;" value="" readonly="true"/>
						        <A hideFocus onclick="WdatePicker({el:$dp.$('pzzxrq')});" href="javascript:void(0)">
						            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
						       	<FONT color=red> * </FONT>
						        </A>
								</td>
								<td class=td1 align=right>
									准予注销日期 ：
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
									经办人姓名：
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.tbrxm" id="tbrxm" value="" style=" width:200px;"/>
								 <FONT color=red> * </FONT>
								</td>
								<td class=td1 align=right>
									证件号码 ：
								</td>
								<td class=td1 >
								 <input maxlength="70" size=28 name="fzdm.tbrsfzh" id="tbrsfzh" value="" style=" width:200px;"/>
								<FONT color=red> * </FONT>
								</td>
							</tr>
							<tr>
								<td class=td1 align=right>
									经办人手机：
								</td>
								<td class=td1>
								 <input maxlength="70" size=28 name="fzdm.tbrmobile" id="tbrmobile" value="" style=" width:200px;"/>
								<FONT color=red> * </FONT>
								</td>
								<td class=td1 align=right>
									经办人座机 ：
								</td>
								<td class=td1 >
								 <input maxlength="70" size=28 name="fzdm.tbrlxfs" id="tbrlxfs" value="" style=" width:200px;"/>
								</td>
							</tr>
							<tr>
								<td colspan=1 class=td1 align=right>
									备注：
								</td>
								<td colspan=3 class=td1>
								 <input maxlength="70" size=28 name="fzdm.memo" id="memo" value="" style=" width:75%;"/>
								</td>
							</tr>
							
                    		</table>
                    <div class="listbtn">
                        <INPUT class="${needAudit==true?"newBtn1":"newBtn1"}" onClick="return validateBus();"
                               type="button" value="${needAudit==true?"提交审核":"注 销"}" name="btok">
                        &nbsp;
                        <INPUT class="newBtn1" onClick="back()" type=button value="返 回"
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
