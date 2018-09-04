<%--@elvariable id="dfile" type="com.ninemax.jpa.code.model.DFile0"--%>
<%@ page language="java" pageEncoding="GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title> 内网数据审核</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript">

        function checkpass() {
            document.getElementById("ispass").value = "1";
            document.form1.submit();
        }

        function checknopass() {
            document.getElementById("ispass").value = "2";
            document.form1.submit();
        }
    </script>

</head>
<body>
<div class="page_top_fixed">
    <div align="right" style="width: 30% ; float: right;margin-top: 3px;">

        <input name="button3" type="button" class="newBtn1"
               id="button" value="保 存"
               onclick="checkpass();"/>
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="window.location.href='/bsweb/scanTask_list_dfile'"/> &nbsp;&nbsp;&nbsp;</div>
    审核 &gt;&gt; 审核管理 &gt;&gt; 档案审核
</div>
<div id="list_main">
<form name="form1" id="form1" action="/bsweb/scanTask_auditing.action" method="post" style="margin:0; padding:0;">
    <input name="dfile.did" type="hidden" value="${dfile.did}"/>
    <input name="dfile.jgdm" type="hidden" value="${dfile.jgdm}"/>
    <input name="dfile.attr" id="ispass" type="hidden" value=""/>

    <div style="padding: 10px 0px;"><br/>
        <table width="100%" bgcolor="#ddf1fa" bordercolor="#8ec2e0" border="1" style="border-collapse:collapse; "
               cellpadding="0" cellspacing="0">
            <tr>
                <td width="80" align="center" nowrap="nowrap" bgcolor="#b3e0fa"> 档案问题：</td>
                <td align="left"
                    style="height: 28px;    line-height: 28px;    overflow: hidden;vertical-align:top;overflow: hidden;">
                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="radio" checked="checked" name="dfile.errorflag" value="-1"/> 无
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="1"> 图像不清晰
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="2"/> 图像黑边、倾斜
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="3"/> 图像混扫
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="4"> 图像残缺
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="5"> 建档日期错误
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="6"> 档案分类错误
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="7"> 申请表标识问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="8"> 批准证书标识问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="9"> 身份证明文件标识问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="10"> 其他文件标示问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="11"> 其他问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="12"> 批准文件不合格
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="13"> 缺页问题
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="radio" name="dfile.errorflag" value="14"> 未定问题
                    </div>


                </td>
            </tr>
            <tr>
                <td width="80" align="center" nowrap="nowrap" bgcolor="#b3e0fa"> 数据问题：</td>
                <td align="left"
                    style=" vertical-align:top;overflow: hidden;">

                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="checkbox" name="data[0]" id="data_jgmc" value="1"/> <label for="data_jgmc">
                        机构名称 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[1]" id="data_jgdz" value="1"/> <label for="data_jgdz">
                        机构地址 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[2]" id="data_jydz" value="1"/> <label for="data_jydz">
                        经营地址 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[3]" id="data_bzjgdm" value="1"/> <label
                            for="data_bzjgdm">
                        办证机构代码 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[4]" id="data_jglx" value="1"/> <label for="data_jglx">
                        机构类型 </label>
                    </div>
                    <div class="avgtd" style="float: left;width: 19%; padding-left:1%;">
                        <input type="checkbox" name="data[5]" id="data_njjlx" value="1"/> <label for="data_njjlx">
                        新经济类型 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[6]" id="data_jjlx" value="1"/> <label for="data_jjlx">
                        经济类型 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[7]" id="data_njjhy" value="1"/> <label for="data_njjhy">
                        新经济行业 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[8]" id="data_jjhy" value="1"/> <label for="data_jjhy">
                        经济行业 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[9]" id="data_xzqh" value="1"/> <label for="data_xzqh">
                        行政区划 </label>
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[10]" value="1"/> 主管机构代码
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[11]" value="1"/> 主管机构名称
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[12]" value="1"/> 批准机构代码
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[13]" value="1"/> 批准机构名称
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[14]" value="1"/> 外方投资国别
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[15]" value="1"/> 法定代表人
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[16]" value="1"/> 证件号码
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[17]" value="1"/> 电话号码
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[18]" value="1"/> 注册资金
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[19]" value="1"/> 货币种类
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[20]" value="1"/> 邮政编码
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[21]" value="1"/> 批准文号
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[22]" value="1"/> 注册号
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[23]" value="1"/> 注册日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[24]" value="1"/> 职工人数
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[25]" value="1"/> 办证日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[26]" value="1"/> 作废日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[27]" value="1"/> 年检日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[28]" value="1"/> 年检期限
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[29]" value="1"/> 变更日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[30]" value="1"/> 最后处理日期
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[31]" value="1"/> 公开
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[32]" value="1"/> 经办人姓名
                    </div>
                    <div style="float: left;width: 19%; padding-left:1%;" class="avgtd">
                        <input type="checkbox" name="data[33]" value="1"/> 经办人身份证号
                        <input type="hidden" name="data[34]" value="1"/>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <br/>
</form>
<div class="list" style="padding:0px; border:none;">
    <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
        <tr>
            <td class="title_txt"> 审核数据</td>
        </tr>
    </table>
    <div class="content">
        <table width="100%" border="1" bordercolor="#cccccc" cellpadding="0" cellspacing="0"
               style="border-collapse: collapse;">
            <tr height="35">
                <td align="left" width="15%">
                    申报类别： ${dfile.arctype eq '0'?"新增": dfile.arctype eq '1'?"其他赋码" :dfile.arctype eq '2'?"预赋码更新" :dfile.arctype eq '3'?"变更" :dfile.arctype eq '4'?"换证" :dfile.arctype eq '5'?"年检" :dfile.arctype eq '6'?"省间迁入":dfile.arctype eq '7'?"省间迁入": dfile.arctype eq '8'?"预赋码" :""}
                </td>
                <td align="center" > 机构名称：${dfile.jgmc}</td>
                <td align="right" width="15%"> 机构代码：${dfile.jgdm}</td>
                <td align="right" > 建档日期：<fmt:formatDate value="${dfile.createtime}"/></td>
            <tr>
            <tr>
                <td align="center" valign="top" colspan='4'>
                    <input name="base64" type="hidden" id="base64" value="${imageData}"/>
                    <OBJECT
                            classid="clsid:640D2EE0-67E6-44E0-A4E8-BA9D5A8F1F5B" ID="scanner"
                            width="100%"
                            height="600"
                            align="center"
                            hspace="0"
                            vspace="0"
                            ></OBJECT>
                </td>
            </tr>
            <jsp:include page="../common/show-jgdm.jsp"/>
        </table>
    </div>

</div>
</div>
</body>

<script type='text/javascript'>
    (function () {
        <c:if test="${imageData eq ''}">
        ymPrompt.alert({message: '从Ftp服务器下载文件错误，或电子档案未找到！', width: 330, height: 220, title: '提示信息'});
        </c:if>
        <c:if test="${!(imageData eq '')}">
        var scanner = document.getElementById("scanner");
        scanner.DPI = 200;
        scanner.PixelType = 2;
        scanner.EditModel = 0;
        scanner.ImageMenuText = "{申领表,1,1};{企业批准文件,21,2};{事业单位批准文件,22,3};{社会团体批准文件,23,4};{机关批准文件,24,5};{其他机构批准文件,25,6};{法定代表人身份证件,31,7};{经办人身份证件,32,8};{小微企业证明材料,5,a};{其他文件,4,9}";
        scanner.SetBase64Image(document.getElementById("base64").value);
        <c:if test="${wdidbs !=null}">
        scanner.ImageRemark = '${wdidbs}';
        </c:if>
        </c:if>

    })();
</script>
</html> 
