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
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js">
    </script>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>

    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    
    <script type="text/javascript" >

       window.onload = function(){ 
         // alert("asasasa");
          var mes = document.getElementById("result").value; 
         // alert(mes);
         // alert(mes.substr(10000,13000));
         // alert(mee.substr(10000,13000));
          //  alert(mes);
          //  alert(11111122222);
          //scanner.SetPageData(mes);
            var	bbh =scanner.FileVersion;
          //	alert(121212);
          //	alert(bbh+"aaaaaaaaaaaaaaaa");
          	var c=document.getElementById("memo").value; 
          //alert(c);
          	if(bbh != c){
          //	alert("aaaaaa")
          	 ymPrompt.alert({message: "版本号过低，请升级版本!", width: 330, height: 220, title: '提示信息', handler: function (tp) {
                        if ("ok" == tp) {
                           history.back()
                            ;
                        }
                         }});
           // setTimeout('history.back()', 3000); //延迟1秒        
          	}  
        };         
           function ajaxFileUpload() {               
            //alert("asasasasas");
            var tydm = document.getElementById("tydm").value; 
            var base64 = null;
            var sn   = document.getElementById("sn").value; 
            // alert(sn)
          	//alert(tydm);	
            var	base64 =scanner.ImageData;
          	$("#base64").val(base64); 
          	var	bbh =scanner.FileVersion;
          	//alert(121212);
          	//alert(bbh);
          	document.getElementById("searchForm").submit();        	
               }         
                </script> 
        <style type="text/css">     
      html, body{ margin:0  !important; padding: 0 !important; width: 100%; height: 100%; overflow: hidden;     	   }
         h4{ margin:20px;}
         .l-page-top{position: relative; z-index:12; }
         .l-panel-btn:hover{background: #E0EDFF url(img/panel-btn.gif) repeat-x;
         }
         .l-panel-btn:hover .l-panel-btn-l{
         	display: block;
         }
         .l-panel-btn:hover .l-panel-btn-r{
         	display: block;
         }
         .l-form{margin: 0px;}
         .l-form li{padding-top:1px;padding-bottom: 1px;}
         .l-button{margin-top:1px;padding:0 3px;}
         .l-text{width:148px;}
         #group{width: 580px;}
         #form1 td{padding: 5px;}
       /*details*/
	  #table {
		border-collapse: collapse; 
		border-spacing: 0; 
		text-align: center;
		margin: 5px 15px;
		}
		#table span{display: inline-block;width:80px; text-align: right;}
		#table td {
		padding: 6px 3px;
		font-size: 13px;
		font-family: Verdana;
		color: rgb(177, 106, 104);
		}
		#table input{width:130px; line-height: 20px;height: 20px; vertical-align: middle; }
		#table .input_wid,#table select{width:230px;border:1px solid #CCCCCC;line-height: 20px;}
		#table textarea{border:1px solid #CCCCCC; resize: none;}
		#table select{width:230px;border:1px solid #CCCCCC;line-height: 20px; }
		/*插件*/
    	#centerbox{overflow: hidden;zoom: 1;}
    	#unreport{float: center;overflow:auto;padding-top:100px;}
    	#unreport p{line-height: 20px;}    	
    </style> 
</head>
<body>
<div  class="left"style='width:100%;border:1px solid #000;height:100px;margin-top:0px;'>
	   <form name="searchForm"  id= "searchForm" method="post" action="/bsweb/statistics_show_sc.action">
	    <tr>
		<td>
		<input type="button" value="上传" onclick="ajaxFileUpload()"> 
		<!-- <input type="file" id="file" name="file" /> -->
		<input type="hidden" name="tydm"  id="tydm" value="${jgdm.tyshxydm}"/>
		<input type="hidden" name="sn"  id="sn" value="${source}"/>
		<input type="hidden" name="base64"  id="base64" value=""/>     
        <input type="hidden" name="memo"  id="memo" value="${memo}"/> 
        </td>
        </tr>
	     </form>
</div>   
<div class="page_top_fixed">
    <div align="left" style=" float: left;">
        ${title}
    </div>
  <div align="right" style="width: 30% ; float: right;">
        <INPUT class="newBtn1" onClick="history.back()" type="button"
               value=""/>
    </div>
</div>
<%-- <form method="post" action="/bsweb/business_${needAudit==true?"auditValidate":"validateDM"}.action" name="busForm"
      id="busForm"> --%>
	 <%--   <<input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
	    <input type="hidden" name="audit" value="${audit}"/>
	    <input typeden" name="needAudit" value="true" id="needAudit"/>
	    <input type="hidden" name="source" value="validate" id="source"/>
	    <input type="hidden" name="mc" value="${jgdm.jgdm}" id="mc"/> --%>
    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue">
                       <!--  <h3><b>机构代码信息显示</b></h3> -->
                        <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
                         <%--    <jsp:include page="../common_gh/show-jgdm.jsp"/>
                            <jsp:include page="../common_gh/show-jgdm-fddbr.jsp"/> --%>
                        </TABLE>
                          <%--   <jsp:include page="../common_gh/show-jgdm-jl.jsp"/> --%>                       
                    </div>                  
                      <div class="listbtn">
                        <INPUT class="newBtn1" onclick="window.history.back();"
                               type=button
                               value=""/>
                        <INPUT type ="hidden"  name = "result"  id ="result" 
                               value= ${result}/>
                    </div> 
                </div>
            </div>
        </div>
    </div>   
     <div id="centerbox">
  	<div id="layout1">
	    <div id="maingrid" position="left" title="数据展示"></div>
	    <div id="unreport" position="center" title="原图展示">
	   <object
		  classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"
		  codebase="NacaoScanProj.ocx#version=1,0,0,0"
		  width=100%
		  height=100%
		  align=center
		  hspace=0
		  vspace=0
		  id="scanner"
		  name="scanner"
		  style="position:absolute;right:0px;top:23px;z-index:1;"
	  	>
		<param name="ShowCount" value="8" />
		<param name="sModel" value="1" />   <!-- "1"代表按钮可以编辑，"2"代表按钮不能编辑 -->
		<param name="OrgType" value="31" />
		<param name="OCRFlag" value="1" />
		<%-- <param name="ImageData" value="${jgdm.memo5 }"/> --%>
	    <param name="ImageData" value="${result}"/> 
		<param name="PageType" value="申领表%企业批准文件%法定代表人身份证件%经办人身份证件" />
		</object>
	   </div>
	 </div>     
<!-- </form> -->
</body>
<%--  <jsp:include page="../common/onload.jsp"/>  --%>
</html>
