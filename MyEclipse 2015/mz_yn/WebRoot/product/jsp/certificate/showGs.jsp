<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="audit" type="java.lang.Boolean"--%>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="needAudit" type="java.lang.Boolean"--%>
<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="dmStatus" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=gbk" %>
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
    <title>选择办证机构</title>
    <META content="Microsoft FrontPage 4.0" name='GENERATOR'>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
     <script type="text/javascript" src="/js/jgdmSearch.js?v=2"></script>
     <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/qzjgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/qtmdkBus.js"></script>

</head>
<body>
<c:if test="${resultMsg!=null and resultMsg!=''}">
    <script type="text/javascript">
        ymPrompt.alert({message:"${resultMsg}", width:330, height:220, title:'提示信息'});
    </script>
</c:if>
<div class="page_top_fixed">
    <div align="left" style=" float: left;">
        ${title}
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="history.back()" type="button"
               value="返 回"/>
    </div>
</div>
<form method="post" action="/bsweb/tygs_noPass.action" name="busForm"
      id="busForm">
    <input type="hidden" name="jgdm.bzjgdm" value="${sysUser.bzjgdm}"/>
    <input type="hidden" name="type" value="${jgdm.djblx}"/>
  
    <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
    <input type="hidden" name="gsId"  value="${gsdm.id}"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                        <h3><b>统一代码数据信息显示</b></h3><br/>
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                               >
                            <TR>
                                <TD class=td1 align="right">
                                    业务类型：
                                </TD>
                                <TD class=td1
                                    align="left" colspan="3"' >
                        <c:if test="${jgdm.ywlx eq '0'}">新办</c:if>
                        <c:if test="${jgdm.ywlx eq '1'}">变更</c:if>
                        <c:if test="${jgdm.ywlx eq '3'}">注销</c:if>
                        </TD>
                            </TR>
                            <jsp:include page="../common/show-jgdm.jsp"/>
                            <TR id="tr1" style="display:none;">
                                <TD class=td1 align="right">
                                   不通过原因：
                                </TD>
                                <TD class=td1
                                    align="left" colspan="3"' >
                                    <textarea rows="5" cols="2" name="reason" id="reason" ></textarea>
                                </TD>
                            </TR>
                        </TABLE>
                    </div>
                    <div class="listbtn">
                        <INPUT class="newBtn1" onclick="fCheckPass1();"
                               type=button
                               value="校对赋码"/>
             
                 
                               
                        <INPUT class="newBtn1" onclick="window.history.back();"
                               type=button
                               value="返 回"/>
                            <br/><br/>
                         <%-- <a class="newBtn1" target="_blank" href='/bsweb/tygs_showpic?args=${jgdm.bak1}' ><img src="/images/cktp.gif"/></a>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>

<jsp:include page="../common/onload.jsp"/>

</html>
<script type="text/javascript">
function fCheckPass1(){
	//新办（1）、变更（2）、换证（3）、注销（4）、预赋码（5）完成后memo_bak3=A
	var type="${jgdm.ywlx}";
	var jgdm="${jgdm.jgdm}";
	var bzjgdm="${jgdm.bzjgdm}";
	var id="${gsdm.id}";
	var zch="${jgdm.zch}";
	   if(type=='0'){
		window.location.href="/bsweb/tydm_addTjgdm.action?gsId="+id;
	    return true;
	   }
		//if(jgdm==""){
			//ymPrompt.alert("机构代码不能为空!", 330, 220, '提示信息');
			///return false;
		//}
	  // if(type=='03')window.location.href="/bsweb/business_search.action?mc="+jgdm+"&type=update_no&source=update_no&bzjgdm=&needAudit=false&audit=false&checkCfjl=yes&ywlx=17&gsid="+id;
	    if(type=='1'){
	    	window.location.href="/bsweb/tydm_addBg.action?gsId="+id;
		    return true;
		  
		    }
	    if(type=='2'){
	    	window.location.href="/bsweb/tydm_addFz.action?gsId="+id;
		    return true;
		 
		    }
	   if(type=='8')window.location.href="/bsweb/certificate_search.action?jgdm="+jgdm+"&source=certChange&dzch=undefined&bzjgdm=&pageno=0&rowNumsView=20&gsid="+id;
	   if(type=='3')window.location.href="/bsweb/business_search.action?mc="+jgdm+"&type=validate&source=validate&bzjgdm=&needAudit=false&audit=false&checkCfjl=yes&ywlx=01&dzch=&gsid="+id;
	   //if(type=='5')window.location.href="/product/jsp/certificate/addRequisition.jsp?formType=2&pageno=1&rowNumsView=20&gsid="+id;
	   if(type=='9'){
           CheckResult = checkQzjgdmExitForIn(jgdm, bzjgdm, '${sysUser.userName}', '1');
           res = CheckResult.split(":");

           if ("true" == res[0]) {
               var result = true;
               spBus.checkforAudia(jgdm, "qzsh", function (srt) {
                   var index = srt.indexOf(":");
                   var s1 = srt.substring(0, index);
                   var s2 = srt.substring(index + 1, srt.length);
                   if (s1 == "0") {
                       ymPrompt.alert({message: s2, slideShowHide: false, title: '提示信息'});
                       result = false;
                   } else if (s1 == "1") {
                       ymPrompt.alert({message: "机构代码（" + jgdm + "）正在申请迁址恢复审核，请等待完成后再作相关业务！",
                           slideShowHide: false, title: '提示信息'});
                       result = false;
                   }

               });
               if (result) {
                   if (res.length >= 2) {
                       ymPrompt.alert({ message: res[1],
                           width: 330, height: 220, title: "提示信息" });
                   }
                   window.location.href="/bsweb/change_search.action?needAudit=false&audit=false&checkCfjl=yes&source=innerIn&type=innerIn&ywlx=06&mc=${jgdm.jgdm}&gsid="+id;
               }
               return result;
           } else {
               ymPrompt.alert({ message: res[1],
                   width: 330, height: 220, title: "提示信息" });
               return false;
           }
	   }
	   if(type=='9A'){
		   jgdmBus.isExit(jgdm, function (value) {
		        if (value){
		            ymPrompt.alert({message: "机构代码(" + jgdm + ")已经存在!", width: 330, height: 220,
		                slideShowHide: false, title: '提示信息'});
		            return false;
		        }else{
		        	 if (checkQtmdkExit(jgdm)) { 
		          	   window.location.href="/bsweb/change_search.action?needAudit=false&audit=false&checkCfjl=yes&source=outerIn&type=outerIn&ywlx=13&mc=${jgdm.jgdm}&gsid="+id;
		             }
		        }
		    });
          
       }
}
function fCheckNotPass(){
	var reason=document.getElementById("reason");
	if(reason.value.trim()==""){
		ymPrompt.alert("不通过需要输入不通过原因!", 330, 220, '提示信息',function () {document.getElementById("tr1").style.display="block"; reason.focus;});
	}else{
		if(reason.value.length>95){
			ymPrompt.alert("不通过原因不能超过100字!", 330, 220, '提示信息',function () { reason.focus;});
		}else{
	document.busForm.submit();
		}
	}
}
</script>
