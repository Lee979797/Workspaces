<%@ page contentType="text/html; charset=gbk"  %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.util.clsPageComponent" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.system.bo.BzjgdmBo" %>
<%@ page import="com.ninemax.jpa.system.model.Bzjgdm" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus,com.ninemax.jpa.code.bus.PrintCertBus" %>
<%@page import="java.net.URLDecoder"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	 //zx 修改 解决网页过期问题
     response.setHeader("Cache-Control","Public");
     response.setHeader("Pragma","no-cache");
     response.setDateHeader("Expires",0);
     String currentPath = request.getRequestURI();
if(request.getQueryString() != null)
	currentPath = currentPath +"?"+request.getQueryString();

String jgdm = request.getParameter("jgdm");
User user = (User)session.getAttribute("sysUser");
//-------------------------
PrintCertBus certBus = new PrintCertBus();
int i=0;
Hashtable hashData=null;
//必输项vector
Vector vecBsx=null;
//从Bean里取得的返回值
Vector vecRet=certBus.printJd(jgdm,user.getBzjgdm());
  //提取返回值
  hashData=(Hashtable)vecRet.elementAt(0);
	String strJgdm=(String)hashData.get("jgdm");
  String strJgmc=(String)hashData.get("jgmc");
  String strJglx=(String)hashData.get("jglx");
String strJglx1=(String)hashData.get("jglx1");
  String strFddbr=(String)hashData.get("fddbr");
  String strZjlx=(String)hashData.get("zjlx1");
  String strZjhm=(String)hashData.get("zjhm");
String strJyfw=(String)hashData.get("jyfw");
  String strJjhy=(String)hashData.get("jjhy");
  String strJjhy1=(String)hashData.get("jjhy1");
  String strNjjhy=(String)hashData.get("njjhy");
  String strNjjhy1=(String)hashData.get("njjhy1");
  String strJjlx=(String)hashData.get("jjlx");
  String strJjlx1=(String)hashData.get("jjlx1");
  String strNjjlx=(String)hashData.get("njjlx");
  String strNjjlx1=(String)hashData.get("njjlx1");
  String strZgdm=(String)hashData.get("zgdm");
  String strZcrq=(String)hashData.get("zcrq");
  String strZgmc=(String)hashData.get("zgmc");
  String strZycp1=(String)hashData.get("zycp1");
  String strZycp11=(String)hashData.get("zycp11");
  String strZycp2=(String)hashData.get("zycp2");
  String strZycp21=(String)hashData.get("zycp21");
  String strZycp3=(String)hashData.get("zycp3");
  String strZycp31=(String)hashData.get("zycp31");
  String strZgrs=(String)hashData.get("zgrs");
  String strYzbm=(String)hashData.get("yzbm");
  String strJgdz=(String)hashData.get("jgdz");
  String strDhhm=(String)hashData.get("dhhm");
  String strEmail=(String)hashData.get("email");
  String strUrl=(String)hashData.get("url");
  String strMobile=(String)hashData.get("mobile");
  String strHbzl=(String)hashData.get("hbzl");
  String strHbzl1=(String)hashData.get("hbzl1");
  String strZczj=(String)hashData.get("zczj");
  String strWftzgb=(String)hashData.get("wftzgb");
  String strWftzgb1=(String)hashData.get("wftzgb1");
  String strXzqh=(String)hashData.get("xzqh");
  String strXzqh1=(String)hashData.get("xzqh1");
  String strPzjgdm=(String)hashData.get("pzjgdm");
  String strPzjgmc=(String)hashData.get("pzjgmc");
  String strPzwh=(String)hashData.get("pzwh");
  String strZch=(String)hashData.get("zch");
  String strScbzrq=(String)hashData.get("scbzrq");
  String strBzrq=(String)hashData.get("bzrq");
  String strNjqx=(String)hashData.get("njqx");
  String strZfrq=(String)hashData.get("zfrq");
  String strGk=(String)hashData.get("gk");
  String strFkbz=(String)hashData.get("fkbz");
  String strFksl=(String)hashData.get("fksl");
  String strZbsl=(String)hashData.get("zbsl");
  String strFbsl=(String)hashData.get("fbsl");
  String strMemo=(String)hashData.get("memo");
  String strMemo2=(String)hashData.get("memo2");
  String strBzjgdm=(String)hashData.get("bzjgdm");
  String strCzy=(String)hashData.get("lry");
  String strXgr=(String)hashData.get("xgr");
  String strFzr=(String)hashData.get("fzr");


	String strZslsh="";
	if (hashData.get("zslsh")!=null) strZslsh=(String)hashData.get("zslsh");

	String strNjrq="";
	if (hashData.get("njrq")!=null) strNjrq=(String)hashData.get("njrq");

	String strBgrq="";
	if (hashData.get("bgrq")!=null) strBgrq=(String)hashData.get("bgrq");

	String strFzrq="";
	if (hashData.get("fzrq")!=null) strFzrq=(String)hashData.get("fzrq");

	String strQzrq="";
	if (hashData.get("qzrq")!=null) strQzrq=(String)hashData.get("qzrq");

  String strTbrxm=(String)hashData.get("tbrxm");
  String strTbrsfzh=(String)hashData.get("tbrsfzh");
  String strTbrlxfs=(String)hashData.get("tbrlxfs");
  String strGsfzrq=(String)hashData.get("gsfzrq");
  String strJydz=(String)hashData.get("jydz");
  String strJyyb=(String)hashData.get("jyyb");
  String strJydh=(String)hashData.get("jydh");
  String strJfly=(String)hashData.get("jfly");
  String strKhyh=(String)hashData.get("khyh");
  String strKhzh=(String)hashData.get("khzh");
	String strToday=(String)hashData.get("today");

	if (strFkbz.equals("0")){strFksl="否";} else {strFksl="发卡数量"+strFksl+"张";}

  if (strGk.equals("1")){strGk="否";}
	if (strGk.equals("2")){strGk="是";}
	if (strGk.equals("0")){strGk="未知";}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>校对单打印</title>
<link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath() %>/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css" />
<link href="<%=request.getContextPath() %>/product/jsp/css/Blue_css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="/js/tools.js"></script>
<script type='text/javascript'>
var hkey_root,hkey_path,hkey_key
hkey_root="HKEY_CURRENT_USER"
hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
//设置网页打印的页眉页脚为空
//左右位置的设置，如果在边距设置10，则注册表的值为0.39370
function pagesetup_null(){
try{
var RegWsh = new ActiveXObject("WScript.Shell")
hkey_key="header"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")
hkey_key="footer"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"")
hkey_key="margin_bottom"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"0.19370")
hkey_key="margin_left"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"0.39370")
hkey_key="margin_right"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"0.39370")
hkey_key="margin_top"
RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"0.78740")
window.print()
}catch(e){}
}
</script>
</head>
<body style="overflow-x:hidden; scrollbar-x:none;">
<div class="page_top">发证 &gt;&gt; 证书打印 &gt;&gt; 代码证书打印 &gt;&gt; 打印校对单简表
  <p style="float:right; padding-right:5px;padding-top: 2.5px;"><input name="button3" type="button" class="newBtn1" id="button31" value="打 印"  onclick="page_top.style.display='none';pagesetup_null();" /></p></div>
<div id="list_main">
<center>
<!-- --------------------------- -->
<br/><br/><br/>
<table border="0" width="88%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20"> <p align="right" style="margin-left: 30"><font face="楷体_gbk" size="4">机构代码：<b>&nbsp;<strong><%=strJgdm%></strong></b></font>&nbsp;</td>
  </tr>
  <tr>
    <td height="50"> <p align="center" style="line-height:50pt"><b><font face="楷体_gbk" size="5"><%=user.getUserProvince() %>组织机构代码申报表</font></b>&nbsp;</td>
  </tr>
  <tr>
    <td height="15"> <p align="left" style="margin-left: 30"><font face="楷体_gbk" size="2">申领单位：(盖章)</font>&nbsp;</td>
  </tr>
  <tr>
    <td height="15"> <p align="right" style="margin-right: 30"><font face="楷体_gbk" size="2">&nbsp;日期：<strong><%=strToday%></strong></font></td>
  </tr>
  <tr>
    <td> <div align="center">
      <table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width=667
 style='width:500.4pt;border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;
 mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:.5pt solid windowtext;
 mso-border-insidev:.5pt solid windowtext'>
  </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:18;page-break-inside:avoid;height:17.0pt'>
  <td  width=667 height="32" colspan=42>
  <p class="style6">&nbsp;申办□&nbsp;&nbsp;年检□&nbsp;&nbsp;到期换证□&nbsp;变更换证□&nbsp;IC卡□&nbsp;IC卡□&nbsp;补证□&nbsp;补卡□</p>
  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:1;height:22.3pt'>
  <td width=105 height="29" colspan=4>
  <p align="center" class="style6">机构名称</p>  </td>
  <td width=562 colspan=38 >
  <p align="left" class="style6">&nbsp;<strong><%=strJgmc%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:2;height:22.7pt'>
  <td width=105 height="29" colspan=4 >
  <p align="center" class="style6">法人代表</p>  </td>
  <td width=155 colspan=13 >
  <p class="style6">&nbsp;<strong><%=strFddbr%></strong></p>  </td>
  <td width=89 colspan=5 >
  <p align="center" class="style6">身份证号</p>  </td>
  <td width=318 colspan=20 >
  <p class="style6">&nbsp;<strong><%=strZjhm%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:3;page-break-inside:avoid;height:25.55pt'>
  <td width=105 colspan=4 >
  <p align="center" class="style6">经营或<br>
    业务范围</p>  </td>
  <td width=562 colspan=38 >
  <p class="style6">&nbsp;<strong><%=strJyfw%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:4;page-break-inside:avoid;height:21.6pt'>
  <td width=105 height="30" colspan=4 >
  <p align="center" class="style6">主管部门</p>  </td>
  <td width=562 colspan=38>
  <p class="style6">&nbsp;<strong><%=strZgmc%></strong>&nbsp;<strong><%=strZgdm%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:5;height:21.3pt'>
  <td width=105 height="26" colspan=4>
  <p align="center" class="style6">成立日期</p>  </td>
  <td width=244 colspan=19 >
  <p class="style6">&nbsp;<strong><%=strZcrq%></strong></p>  </td>
   <td width=86 colspan=4>
  <p align="center" class="style6">作废日期</p>
  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strZfrq%></strong></p>
  </td>
</tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:5;height:21.3pt'>
  <td width=105 colspan=4>
  <p align="center" class="style6">注册资金</p>  </td>
  <td width=244 colspan=19>
  <p class="style6">&nbsp;<strong><%=strZczj%></strong>万元</p>  </td>
  <td width=86 colspan=4>
  <p align="center" class="style6">货币种类</p>  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strHbzl%>&nbsp;<%=strHbzl1%></strong></p>  </td>
</tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:6;height:20.4pt'>
  <td width=105 height="26" colspan=4>
  <p align="center" class="style6">外方国别</p>  </td>
  <td width=244 colspan=19>
  <p class="style6">&nbsp;<strong><%=strWftzgb%></strong>&nbsp;<strong><%=strWftzgb1%></strong></p>  </td>
  <td width=86 colspan=4>
  <p align="center" class="style6">职工人数</p>  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strZgrs%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:6;height:20.4pt'>
  <td width=105 colspan=4>
  <p align="center" class="style6">行政区划</p>  </td>
  <td width=244 colspan=19>
  <p class="style6">&nbsp;<strong><%=strXzqh%>&nbsp;<%=strXzqh1%></strong></p>  </td>
  <td width=86 height="27" colspan=4>
  <p align="center" class="style6">邮政编码</p>  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strYzbm%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:7;page-break-inside:avoid;height:21.55pt'>
  <td width=105 height="27" colspan=4 >
  <p align="center" class="style6">注册地址</p>  </td>
  <td width=562 colspan=38>
  <p class="style6">&nbsp;<strong><%=strJgdz%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:9;page-break-inside:avoid;height:19.65pt'>
  <td width=105 height="29" colspan=4>
  <p align="center" class="style6">批准机构</p>  </td>
  <td width=390 colspan=31>
  <p class="style6">&nbsp;<strong><%=strPzjgmc%>&nbsp;<%=strPzjgdm%></strong></p>  </td>
   <td width=86 colspan=4>
  <p align="center" class="style6">是否涉密</p>  </td>
  <td width=86 colspan=3>
  <p class="style6">&nbsp;<strong><%=strGk%></strong></p>  </td>
</tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:8;page-break-inside:avoid;height:19.85pt'>
  <td width=105 height="27" colspan=4>
  <p align="center" class="style6">电话号码</p>  </td>
  <td width=155 colspan=13>
  <p class="style6">&nbsp;<strong><%=strDhhm%></strong></p>  </td>
  <td width=155 colspan=9>
  <p align="center" class="style6">批准文号或注册号</p>  </td>
  <td width=252 colspan=16>
  <p class="style6">&nbsp;<strong><%=strZch%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:2;height:22.7pt'>
  <td width=105 height="29" colspan=4 >
  <p align="center" class="style6">经办人姓名</p>  </td>
  <td width=155 colspan=13 >
  <p class="style6">&nbsp;<strong><%=strTbrxm%></strong></p>  </td>
  <td width=89 colspan=5 >
  <p align="center" class="style6">身份证号</p>  </td>
  <td width=318 colspan=20 >
  <p class="style6">&nbsp;<strong><%=strTbrsfzh%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:10;page-break-inside:avoid;height:21.0pt'>
  <td width=105 height="30" colspan=4>
  <p align="center" class="style6">法人手机</p>
  </td>
  <td width=155 colspan=13>
  <p class="style6">&nbsp;<strong><%=strMobile%></strong></p>
  </td>
  <td width=89 colspan=5>
  <p align="center" class="style6">E-mail</p>
  </td>
  <td width=318 colspan=20>
  <p class="style6">&nbsp;<strong><%=strEmail%></strong></p>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:8;page-break-inside:avoid;height:19.85pt'>
  <td width=105 height="27" colspan=4>
  <p align="center" class="style6">网 址</p>  </td>
  <td width=390 colspan=31>
  <p class="style6">&nbsp;<strong><%=strUrl%></strong></p>  </td>
  <td width=86 colspan=4>
  <p align="center" class="style6">副本数量</p>  </td>
  <td width=86 colspan=3>
  <p class="style6">&nbsp;<strong><%=strFbsl%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:13;page-break-inside:avoid;height:18.65pt'>
  <td width=105 height="30" colspan=4>
  <p align="center" class="style6">经营地址</p>
  </td>
  <td width=562 colspan=38>
  <p class="style6">&nbsp;<strong><%=strJydz%></strong></p>
  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:14;page-break-inside:avoid;height:18.3pt'>
  <td width=105 height="28" colspan=4>
  <p align="center" class="style6">经营邮编</p>
  </td>
  <td width=244 colspan=19>
  <p class="style6">&nbsp;<strong><%=strJyyb%></strong></p>
  </td>
  <td width=86 colspan=4>
  <p align="center" class="style6">经营电话</p>
  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strJydh%></strong></p>
  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:15;page-break-inside:avoid;height:19.4pt'>
  <td width=105 height="29" colspan=4>
  <p align="center" class="style6">开户银行</p>
  </td>
  <td width=244 colspan=19>
  <p class="style6">&nbsp;<strong><%=strKhyh%></strong></p>
  </td>
  <td width=86 colspan=4>
  <p align="center" class="style6">开户账号</p>
  </td>
  <td width=230 colspan=15>
  <p class="style6">&nbsp;<strong><%=strKhzh%></strong></p>
  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:16;page-break-inside:avoid;height:21.7pt'>
  <td width=105 height="60" colspan=4>
  <p align="center" class="style6">主要产品</p>
  </td>
  <td width=562 colspan=38>
  <p class="style6">&nbsp;产品1：<strong><%=strZycp1%>&nbsp;<%=strZycp11%></strong><br>&nbsp;产品2：<strong><%=strZycp2%>&nbsp;<%=strZycp21%></strong><br>&nbsp;产品3：<strong><%=strZycp3%>&nbsp;<%=strZycp31%></strong><br>
  </p>
  </td>
 </tr>
 <tr bordercolor="#FFFFFF" style='mso-yfti-irow:17;page-break-inside:avoid;height:19.85pt'>
  <td width=332 height="23" colspan=21 style='width:248.75pt;border:none;border-bottom:
  solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;height:19.85pt'>
  <p class="style6">下栏由代码管理机关填写</p>  </td>
  <td width=336 colspan=21 style='width:251.65pt;border:none;border-bottom:
  solid windowtext 1.5pt;mso-border-top-alt:solid windowtext 1.5pt;padding:
  0cm 5.4pt 0cm 5.4pt;height:19.85pt'>
  <p><span class="style6"></span></p>  </td>
 <tr bordercolor="#000000" style='mso-yfti-irow:22;page-break-inside:avoid;height:20.3pt'>
  <td width=128 height="26" colspan=6>
  <p align="center" class="style6">机构类型</p>
  </td>
  <td width=539 colspan=36>
  <p class="style6">&nbsp;<strong><%=strJglx%>&nbsp;<%=strJglx1%></strong></p>  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:20;page-break-inside:avoid;height:19.45pt'>
  <td width=128 height="31" colspan=6>
  <p align="center" class="style6">经济行业(2000版)</p></td>
  <td width=220 colspan=20>
  <p class="style6">&nbsp;<strong><%=strNjjhy%>&nbsp;<%=strNjjhy1%></strong></p>
  </td>
  <td width=150 colspan=7>
  <p align="center" class="style6">经济类型(2000版)</p>
  </td>
  <td width=178 colspan=9>
  <p class="style6">&nbsp;<strong><%=strNjjlx%>&nbsp;<%=strNjjlx1%></strong></p>
  </td>
 </tr>
 <tr bordercolor="#000000" style='mso-yfti-irow:19;page-break-inside:avoid;height:18.7pt'>
  <td width=128 height="31" colspan=6>
  <p align="center" class="style6">经济行业(94版)</p>  </td>
  <td width=220 colspan=20>
  <p class="style6">&nbsp;<strong><%=strJjhy%>&nbsp;<%=strJjhy1%></strong></p>  </td>
  <td width=150 colspan=7>
  <p align="center" class="style6">经济类型(94版)</p>
  <td width=178 colspan=9>
  <p class="style6">&nbsp;<strong><%=strJjlx%>&nbsp;<%=strJjlx1%></strong></p>
  </td>
 </tr>

 <tr bordercolor="#000000" style='mso-yfti-irow:24;page-break-inside:avoid;height:17.0pt'>
  <td width=70 height="24" colspan=4>
  <p align="center" class="style6">受理员</p>
  </td>
  <td width=151 colspan=10>
  <p><span class="style6"></span></p>
  </td>
  <td width=70 colspan=4>
  <p align="center" class="style6">审核员</p>
  </td>
  <td width=151 colspan=10>
  <p><span class="style6"></span></p>
  </td>
  <td width=70 colspan=4>
  <p align="center" class="style6">备注</p>
  </td>
  <td width=151 colspan=10>
  <p><span class="style6"></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:25;mso-yfti-lastrow:yes;page-break-inside:avoid;
  height:31.2pt'>
  <td width=667 colspan=42>
  <p>注：若经营（业务）范围涉密或单位不宜公开，请在“机构是否涉密”中填上是，并提供有效证明。上述填报内容将编入“云南省组织机构代码信息数据库”并对社会开放服务。</p>
  </td>
 </tr>
 <![if !supportMisalignedColumns]>
 <tr height=0>
  <td width=83 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=23 style='border:none'></td>
  <td width=3 style='border:none'></td>
  <td width=55 style='border:none'></td>
  <td width=6 style='border:none'></td>
  <td width=21 style='border:none'></td>
  <td width=3 style='border:none'></td>
  <td width=13 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=10 style='border:none'></td>
  <td width=9 style='border:none'></td>
  <td width=5 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=28 style='border:none'></td>
  <td width=10 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=26 style='border:none'></td>
  <td width=23 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=7 style='border:none'></td>
  <td width=12 style='border:none'></td>
  <td width=8 style='border:none'></td>
  <td width=53 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=16 style='border:none'></td>
  <td width=4 style='border:none'></td>
  <td width=8 style='border:none'></td>
  <td width=4 style='border:none'></td>
  <td width=9 style='border:none'></td>
  <td width=15 style='border:none'></td>
  <td width=25 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=5 style='border:none'></td>
  <td width=4 style='border:none'></td>
  <td width=59 style='border:none'></td>
  <td width=3 style='border:none'></td>
  <td width=11 style='border:none'></td>
  <td width=2 style='border:none'></td>
  <td width=84 style='border:none'></td>
 </tr>
 <![endif]>
</table>
    </div></td>
  </tr>
  <tr>
    <td align="left" height="30">&nbsp;请认真核对本表格，确认无误后签字，如发现证书有误由各单位自行负责！</td>
  </tr>
  <tr>
    <td align="right" height="10"> 经办人签字：<u>&nbsp;</u>&nbsp;</td>
  </tr>
</table>
<!-- --------------------------- -->
</center>
</div>
</body>
</html>
