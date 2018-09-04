<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
		404页面
  <%
  String aa="<p></p>\n" +
          "<p></p>\n" +
          "<p></p>\n" +
          "<p class=\"MsoNormal\" align=\"center\" style=\"text-align: center; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"></p>\n" +
          "<p></p>\n" +
          "<p class=\"MsoNormal\" align=\"center\" style=\"text-align: center; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 黑体; color: red; font-size: 18pt; mso-bidi-font-family: 黑体\">北京市物价局、北京市人民政府文教办公室、<span lang=\"EN-US\"><o:p></o:p></span></span></p>\n" +
          "<p class=\"MsoNormal\" align=\"center\" style=\"text-align: center; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 黑体; color: red; font-size: 18pt; mso-bidi-font-family: 黑体\">北京市财政局、北京市教育局、北京市卫生局<span lang=\"EN-US\"><o:p></o:p></span></span></p>\n" +
          "<p class=\"MsoNormal\" align=\"center\" style=\"text-align: center; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 黑体; color: red; font-size: 18pt; mso-bidi-font-family: 黑体\">关于控制托幼园所收费标准的通知<span lang=\"EN-US\"><o:p></o:p></span></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span lang=\"EN-US\" style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><o:p><font color=\"#000000\" size=\"3\">&nbsp;</font></o:p></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">各区（县）人民政府、各区（县）文教办（托幼办）、物价局、财政局、教育局、卫生局及市各有关局、总公司：<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">经市政府批准，市政府文教办公室、市物价局于１９９２年１０月１４日下发了<span lang=\"EN-US\">&quot;</span>关于下放托幼园所收费标准审批权限的通知<span lang=\"EN-US\">&quot;</span>（京价〈收〉字〔１９９２〕第〈４１２〉号）。该通知对提高办园质量和办园积极性，增强园所的活力，起到了一定的作用。但是，有的部门对所属园所收费标准调整过高，加重了家长的经济负担，引起了较大反应。为了稳定价格水平，减少社会震动，经研究，决定对托幼园所的收费标准采取限价措施，通知如下：<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">一、收费项目和收费标准<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">１．保育费（含杂费、卫生费、取暖费等）每人每月收费标准为：<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"background-color: #3366ff\"><span style=\"color: #ff0000\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\">一级一类园所</font></span></span></span><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">：日托</font>５０元，<font color=\"#000000\">整托７０元。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">二级二类园所：日托４０元，整托５５元。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">三级三类园所：日托３０元，整托４５元。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">其中三岁以下的托儿每人每月可增收１０<span lang=\"EN-US\">-</span>２０元。</font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">没有验收定级的园所按二级二类以下标准收费。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">２．托儿补助费：每人每月４０元。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">３．园所代办费：每人每月日托２０元，整托３０元（只限单位自办园所收取，市立和街道园所不得收取）。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">４．伙食费标准由各园所自定。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">二、除以上收费项目外，各园所不得另立收费项目。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">三、以上标准为最高限价，各区（县）、各部门在限价范围内可自行定价，不得突破。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"text-indent: 17.95pt; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"><span style=\"font-family: 宋体; mso-bidi-font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-hansi-font-family: Calibri; mso-hansi-theme-font: minor-latin\"><font size=\"3\"><font color=\"#000000\">四、本通知自１９９３年１月１日起执行。<span lang=\"EN-US\"><o:p></o:p></span></font></font></span></p>\n" +
          "<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt\"><span lang=\"EN-US\"><o:p><font color=\"#000000\" size=\"3\" face=\"Calibri\">&nbsp;</font></o:p></span></p>\n" +
          "<p class=\"MsoNormal\" align=\"center\" style=\"text-align: center; margin: 0cm 0cm 0pt; mso-layout-grid-align: none\"></p>";
  %>
  </body>
</html>
