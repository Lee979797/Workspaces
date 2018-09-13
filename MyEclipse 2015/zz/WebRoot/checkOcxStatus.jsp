<%@page contentType="text/html;charset=UTF-8"%>
<%@ page language = "java" import="java.sql.*,java.lang.*,java.util.*"%>
<HTML><TITLE>检测OCX页面</TITLE>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<META content="text/html; charset=GBK" http-equiv=Content-Type>
<style type="text/css">
body, a, table, div, span, td, th, input, select{font:9pt;font-family: "宋体", Verdana, Arial, Helvetica, sans-serif;}
body {padding:5px}
</style>
<script LANGUAGE="JavaScript">
var scanNetVersion='<%=application.getAttribute("scanNetVersion") %>';
function checkOcxStatus() {
    var NewObj;
    //alert(scanNetVersion);
    try {
    	//parent.showMsg(3);
        NewObj = new ActiveXObject("NacaoScanProj.NacaoScan");
        if (typeof NewObj != 'undefined') {
            if(scanNetVersion!=null){
            	if(scanNetVersion!=scannerwsbz.FileVersion){
                	parent.showMsg(1);
        		}else{
        			parent.showMsg(3);
        		}
            }
            return true;
        }
    } catch (e) {
        NewObj = null;
        parent.showMsg(2);
        return false;
    }
}

</script>
</head>
<body onLoad="checkOcxStatus()">
<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"  width=0  height=0 align=center hspace=0 vspace=0 id="scannerwsbz"  name="scannerwsbz" >
<param name="ShowCount" value="8">
<param name="sModel" value="1">
<param name="OCRFlag" value="1">
</OBJECT>
</body>
</html>