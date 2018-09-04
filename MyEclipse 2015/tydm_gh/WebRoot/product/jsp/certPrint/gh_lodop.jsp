<%@page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMap%>"/>
<c:set var="nnjglxMap" value="<%=InitSysParams.jjlx2k1Map%>"/>
<c:set var="name" value="${nnjglxMap[fn:trim(jgdm.jjlx2011)]}"/>
<c:set var="jjhlx" value="${nnjglxMap[fn:trim(jgdm.jjhlx)]}"/>
<script type="text/javascript">
var tyshxydm='${jgdm.tyshxydm}';
var pzjgmc='${jgdm.pzjgmc}';
var bzrq='${jgdm.bzrq}'.substring(0,10);
var yxqxe='${jgdm.yxqxe}'.substring(0,10);
var fromY='${jgdm.bzrq}';
var jgmc='${jgdm.jgmc}';
var jgdz='${jgdm.jgdz}';
var fddbr='${jgdm.fddbr}';
var fzjg='${sysUser.printName}';
var bzjgdm='${jgdm.bzjgdm}';
var lsh='${jgdm.lsh}';

//控制机构名称字体大小，加判断自由设置
var jgmcSize="";
if(jgmc.length>22){
	jgmcSize=12;
}else{
	jgmcSize=15;
}

var jgdzSize="";
if(jgdz.length>45){
	jgdzSize=10;
}else{
	jgdzSize=12;
}
////////////处理日期开始

//发证日期
var startTime = "${jgdm.bzrq}".substring(0,10);
var  startTimeDate = new Date(Date.parse(startTime.replace(/-/g, "/")));
var startY=startTimeDate.getFullYear();
var startM=startTimeDate.getMonth()+1;
var startD=startTimeDate.getDate();
if(startM<10){
	startM='0'+startM;
}
if(startD<10){
	startD='0'+startD;
}

//有效日期
var  YxqxestartTimeDate = new Date(Date.parse(yxqxe.replace(/-/g, "/")));
var YxqxestartY=YxqxestartTimeDate.getFullYear();
var YxqxestartM=YxqxestartTimeDate.getMonth()+1;
var YxqxestartD=YxqxestartTimeDate.getDate();
if(YxqxestartM<10){
	YxqxestartM='0'+YxqxestartM;
}
if(YxqxestartD<10){
	YxqxestartD='0'+YxqxestartD;
}
var YxqxeStr = YxqxestartY+'年'+YxqxestartM+'月'+YxqxestartD+'日';
/**
 * 民非正本
 */
function CreatePrint(flag) {

	LODOP.PRINT_INITA(-1,0,1079,776,"minfei_zb0122");
	LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
	LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' src='../images/temp/gh.jpg'>");
	LODOP.SET_SHOW_MODE("BKIMG_WIDTH",1079);
	LODOP.SET_SHOW_MODE("BKIMG_HEIGHT",776);
	LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",true);
	LODOP.ADD_PRINT_TEXT(237,764,212,25,tyshxydm);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_TEXT(101,106,233,25,"NO："+bzjgdm+"-"+lsh);
	LODOP.SET_PRINT_STYLEA(0,"FontName","Arial");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	/* LODOP.ADD_PRINT_TEXT(101,186,150,25,lsh);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14); */
	LODOP.ADD_PRINT_TEXT(453,367,232,25,jgmc);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_TEXT(498,367,245,25,jgdz);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_TEXT(542,367,211,25,fddbr);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",3);
	
	LODOP.ADD_PRINT_TEXT(585,367,211,25,YxqxeStr);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14); 
	
	LODOP.ADD_PRINT_TEXT(619,723,53,25,startY);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_TEXT(619,823,36,25,startM);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_TEXT(619,905,32,25,startD);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	/* LODOP.ADD_PRINT_TEXT(383,127,215,31,"统一社会信用代码：");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15); */
	LODOP.ADD_PRINT_TEXT(490,761,230,25,fzjg);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	if(flag=='view'){
		LODOP.PREVIEW();	
		}else{
		LODOP.PRINT_SETUP();	
		}	
}



</script>
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0></object>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
		<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
	</object>
