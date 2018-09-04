<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%
    //zx 修改 解决网页过期问题
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<c:set var="hbMap" value="<%= InitSysParams.hbMap%>"/>
<c:set var="zjlxMap" value="<%= InitSysParams.zjlxMap%>"/>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="njjhyMap" value="<%= InitSysParams.njjhyMap%>"/>
<c:set var="nnjjhyMap" value="<%= InitSysParams.jjhy2k1Map%>"/>
<c:set var="jjhyMap" value="<%= InitSysParams.jjhyMap%>"/>
<c:set var="njjlxMap" value="<%= InitSysParams.njjlxMap%>"/>
<c:set var="jjlxMap" value="<%= InitSysParams.jjlxMap%>"/>
<c:set var="xzqhMap" value="<%= InitSysParams.xzqhMap%>"/>
<c:set var="pzjgMap" value='<%=InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm())%>'/>
<c:set var="zgjgMap" value="<%= InitSysParams.zgjgMap%>"/>
<c:set var="gjMap" value="<%= InitSysParams.gjMap%>"/>
<c:set var="zycpMap" value="<%= InitSysParams.zycpMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <TITLE>代码证书校对单打印</TITLE>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript">
        var hkey_root, hkey_path, hkey_key
        hkey_root = "HKEY_CURRENT_USER"
        hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
        //设置网页打印的页眉页脚为空
        function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
            } catch (e) {
            }
        }
        function printPage() {
            page_top.style.display = 'none';
            pagesetup_null();
            window.print();
            page_top.style.display = 'inline';
        }
    </script>
 <style type="text/css">
html,body{ margin:0px; padding:0px;}
*{ margin:0px; padding:0px;}
.container{ width:620px; margin:0px auto;}
.header{ line-height:50px; font-size:30px; text-align:center;}
.date{ padding:5px 0px;}
.date p{ height:25px; line-height:25px; text-align:right; font-size:14px;}
.date p strong{ font-weight:normal; font-size:20px;}
.date p span{ float:left; display:inline-block;}
.title{ line-height:50px; font-size:16px;}
.title strong{}
.title span{ float:right; font-size:12px;}
.table_box{ border-collapse:collapse;}
.table_box td{ line-height:20px; padding:3px; font-size:12px;}
.info{}
.info h1{ font-size:18px; line-height:40px; text-align:center;}
.info ul{}
.info ul li{ list-style:none; line-height:23px; font-size:14px;}
.info h3{ font-size:16px; line-height:30px; padding:10px 0px;}
.info h6{ font-size:14px; line-height:20px; padding:10px 0px;}
</style>
</head>
<body>
<div class="page_top_fixed" id="page_top" style="float: right;">
    <input name="button3" type="button" class="newBtn1" id="button31" value="打 印"
           onclick="printPage();"/>
    &nbsp;
    <input name="button3" type="button" class="newBtn1" id="button32" value="关闭"
           onclick="window.close();"/>
</div>
<div class="container">
    <div class="date">
        <p style="padding-right:200px;">机构代码：<span>流水号：</span></p>
    </div>
	<div class="header">西安市组织机构代码证申报表</div>
    <div class="date">
        <p><span>申办机构填写：</span></p>
    </div>
    <table class="table_box" bordercolor="#333333" cellpadding="0" cellspacing="0" border="1" width="100%" style="margin-bottom:10px;">
    	<tr>
        	<td align="center">组织机构名称</td>
            <td colspan="8">${jgdm.jgmc}</td>
        </tr>
        <tr>
        	<td rowspan="2" align="center">法定代表人<br />（负责人）</td>
            <td colspan="2">${jgdm.fddbr}</td>
            <td colspan="3" align="center">法定代表人(负责人)身份证件类型</td>
            <td colspan="3">${zjlxMap[fn:trim(jgdm.zjlx)]}</td>
        </tr>
        <tr>
        	<td align="center" width="9%">手机</td>
            <td colspan="2">${jgdm.mobile}</td>
            <td colspan="5">${jgdm.zjhm}</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">经营(业务)范围<br />或工作职能<br />(企业、事业单位、<br />社团体见相关证明)</td>
            <td colspan="7" height="60">
            <c:set var="len" value="${fn:length(fn:trim(jgdm.jyfw))}"/>
                    <div align="left" id="${len>800?'jyfw':len>600?'jyfw1':len>400?'jyfw2':'jyfw3'}">
                        &nbsp;${jgdm.jyfw}</div>
            </td>
        </tr>
        <tr>
        	<td align="center">成立日期</td>
            <td colspan="2" align="center"><fmt:formatDate pattern="yyyy年MM月dd日" value="${jgdm.zcrq}"/></td>
            <td align="center">有效期至</td>
            <td colspan="3" align="center"><fmt:formatDate pattern="yyyy年MM月dd日" value="${jgdm.zfrq}"/></td>
            <td align="center">职工人数</td>
            <td align="right">${jgdm.zgrs}(人)</td>            
        </tr>
        <tr>
        	<td colspan="2" align="center">注册(开办)资金</td>
            <td align="right" colspan="2"><fmt:formatNumber pattern="0.####" value="${jgdm.zczj}"/>&nbsp;（万元）</td>
            <td align="center">货币种类</td>
            <td>${hbMap[fn:trim(jgdm.hbzl)]}</td>
            <td align="center">企业注册类型</td>
            <td colspan="2">${jglxMap[fn:trim(jgdm.jglx)]}</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">主管部门</td>
            <td colspan="3">${jgdm.zgmc}</td>
            <td align="center">机构代码</td>
            <td colspan="3">${jgdm.jgdm}</td>
        </tr>
        <tr>
        	<td rowspan="2" align="center">注册地址</td>
            <td colspan="8">&nbsp;${jgdm.jgdz}</td>
        </tr>
        <tr>
        	<td align="center">行政区划</td>
            <td colspan="4">${xzqhMap[fn:trim(jgdm.xzqh)]}</td>
            <td align="center">邮政编码</td>
            <td colspan="2">${jgdm.yzbm}</td>
        </tr>
        <tr>
        	<td rowspan="4" align="center">通讯号码</td>
            <td align="center">电话1</td>
            <td colspan="2">${jgdm.mobile}</td>
            <td colspan="2" align="center">国税登记号</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td align="center">电话2</td>
            <td colspan="2">${jgdm.dhhm}</td>
            <td colspan="2" align="center">地税登记号</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td align="center">传真</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">开户银行</td>
            <td colspan="3">${jgdm.khyh}</td>
        </tr>
        <tr>
            <td align="center">电子信箱</td>
            <td colspan="2">${jgdm.email}</td>
            <td colspan="2" align="center">开户账号</td>
            <td colspan="3">${jgdm.khzh}</td>
        </tr>
        <tr>
        	<td align="center">登记批准机构</td>
            <td colspan="3">${jgdm.pzjgmc}</td>
            <td colspan="2" align="center">登记批准文号或注册号</td>
            <td colspan="3">${jgdm.zch}</td>
        </tr>
        <tr>
        	<td width="12%" align="center">所填信息<br />是否涉密</td>
            <td width="20%" colspan="2" align="center">${(jgdm.gk ne '1')?'是':'否'}</td>
            <td width="9%" align="center">申请U-key</td>
            <td width="9%"></td>
            <td width="10%" align="center">申请IC卡</td>
            <td width="12%">${"1"==jgdmSave.fkbz?"jgdmSave.fksl":"否"}</td>
            <td width="8%" align="center">申请<br />证书副本</td>
            <td width="10%" align="right">${jgdm.fbsl}</td>
        </tr>
        <tr>
        	<td colspan="9">
            	<p style="text-indent:24px; font-weight:bold;">声明：本单位委托以下经办人申领组织机构代码证书。本单位承诺所填信息真实准确，所提交的证明文件和证、照原件均真实且来自发文、发证、发照机关。本单位愿承担填报或提交虚假信息、资料所带来的全部法律后果。</p>
                <p style="text-align:right; font-weight:bold;">经办人（签字）：________________ 联系电话：_______________</p>
                <p style="text-align:right; font-weight:bold;">申请单位（盖章）：________________________</p>
                <p style="text-align:right; font-weight:bold;">填表日期：________年____月____日</p>
            </td>
        </tr>
        <tr>
        	<td colspan="2" align="center">经办人身份证件类型</td>
            <td >身份证号</td>
            <td colspan="6"> ${jgdm.tbrsfzh}</td>
        </tr>
    </table>
    
    <div class="date">
        <p><span>发证机关填写：</span></p>
    </div>
	
    <table class="table_box" bordercolor="#333333" cellpadding="0" cellspacing="0" border="1" width="100%">
    	<tr>
        	<td width="8%" align="center">新申报</td>
            <td width="6%"></td>
            <td width="6%" align="center">验证</td>
            <td width="6%"></td>
            <td width="10%" align="center">到期换证</td>
            <td width="6%"></td>
            <td width="10%" align="center">变更验证</td>
            <td width="6%"></td>
            <td width="12%" align="center">U-key或IC卡</td>
            <td width="6%"></td>
            <td width="6%" align="center">补正</td>
            <td width="6%"></td>
            <td width="6%" align="center">补卡</td>
            <td width="6%"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">经济类型(94版)</td>
            <td colspan="4"> </td>
            <td colspan="2" align="center">经济行业(94版)</td>
            <td colspan="5"></td>
        </tr>
        <tr>
        	<td colspan="3" align="center">机构类型</td>
            <td colspan="4">${jglxMap[fn:trim(jgdm.jglx)]}</td>
            <td colspan="2" align="center">批准机构代码</td>
            <td colspan="5">${jgdm.pzjgdm}</td>
        </tr>
        <tr>
        	<td colspan="3" align="center">代码证有效期</td>
            <td colspan="5" align="center"><fmt:formatDate pattern="yyyy年MM月dd日" value="${jgdm.bzrq}"/></td>
            <td align="center">至</td>
            <td colspan="5" align="center"><fmt:formatDate pattern="yyyy年MM月dd日" value="${jgdm.zfrq}"/></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">受理人</td>
            <td colspan="2"><%=((User)session.getAttribute("sysUser")).getUserName()%></td>
            <td align="center">审核员</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">录入员</td>
            <td colspan="2"></td>
            <td colspan="2" align="center">校队人</td>
            <td colspan="2"></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">流水号</td>
            <td colspan="4"></td>
            <td align="center">证书编号</td>
            <td colspan="2">${jgdm.zsbh}</td>
            <td align="center" colspan="2">备注</td>
            <td colspan="3">${jgdm.memo}${jgdm.memo1}${jgdm.memo2}</td>
        </tr>
    </table>
    
    <div class="date">
        <p><span>变更内容：机构名称 □&nbsp;&nbsp;&nbsp;&nbsp;机构地址 □&nbsp;&nbsp;&nbsp;&nbsp;法人代表 □&nbsp;&nbsp;&nbsp;&nbsp;机构类型 □&nbsp;&nbsp;&nbsp;&nbsp;</span></p>
        <p>西安市组织机构代码管理中心制</p>
    </div>
    
</div>
</body>
</html>