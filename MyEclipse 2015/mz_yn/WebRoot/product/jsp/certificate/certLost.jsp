<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="java.util.Map" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPath = currentPath + "?" + request.getQueryString();
    }
    TJgdm tJgdm = (TJgdm) request.getAttribute("tjgdm");
    Wgs wgs=(Wgs)request.getAttribute("wgs");
    if(wgs==null){
    	wgs=new Wgs();
    }
    String source = (String) request.getAttribute("source");
    String title = "";
    if ("yygs".equals(source)) {
        title = "证书预约挂失";
    }
    if ("qxgs".equals(source)) {
        title = "取消预约挂失";
    }
    if ("qrgs".equals(source)) {
        title = "证书确认挂失";
    }
%>
<c:set var="jgdm" value="<%=tJgdm%>"/>
<c:set var="wgs" value="<%=wgs%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath()%>/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript">
	$(function(){   $("#gsyj").focus();  })
	document.onkeydown=function(){
		 if(event.keyCode==13)
		  {
		     event.keyCode=9;
		  }
	   }
	</script>
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
            var top = document.getElementById("page_top");
            var bottom = document.getElementById("page_bottom");
            top.style.display = 'none';
            bottom.style.display = 'none';
            pagesetup_null();
            window.print();
            top.style.display = 'inline';
            bottom.style.display = 'inline';
        }
    </script>
    <script type="text/javascript">
        function validateBus() {
            if (document.busForm.gsyj != undefined) {
                if (isEmpty(document.busForm.gsyj.value)) {
                    ymPrompt.alert({message: '挂失依据不能为空!', width: 330, height: 220, title: '提示信息', handler: function () {
                        document.getElementById("gsyj").focus();
                    }});

                    return false;
                } else {
                    if (document.busForm.gsyj.value.length > 25) {
                        ymPrompt.alert({message: '挂失依据长度不能超过25个汉字!', width: 330, height: 220, title: '提示信息', handler: function () {
                            document.getElementById("gsyj").focus();
                        }});
                        return false;
                    }
                }
                if (isEmpty(document.busForm.gsreason.value)) {
                    ymPrompt.alert({message: '挂失原因不能为空!', width: 330, height: 220, title: '提示信息', handler: function () {
                        document.getElementById("gsreason").focus();
                    }});
                    return false;
                } else {
                    if (document.busForm.gsreason.value.length > 100) {
                        ymPrompt.alert({message: '挂失原因长度不能超过100个汉字!', width: 330, height: 220, title: '提示信息', handler: function () {
                            document.getElementById("gsreason").focus();
                        }});
                        return false;
                    }
                }
            }
            var flag = false;
            var array = document.getElementsByName("djh");
            for (var i = 0; i < array.length; i++) {
                if (array[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ymPrompt.alert({message: '请选择挂失证书登记号!', width: 330, height: 220, title: '提示信息'});
                return false;
            }
            document.busForm.submit();
            document.busForm.btok.disabled = true;
        }
    </script>
</head>
<body>
<div class="page_top_fixed" id="page_top">
    <div align="left" style=" float: left;"><strong> 日常 &gt;&gt; 证书挂失 &gt;&gt; <%=title%>
    </strong>
    </div>
    <div align="right" style=" float: right;">
        <INPUT class="newBtn1" onClick="javascript:return validateBus();" type=button value="确  认" name="btok">
        <INPUT class="newBtn1" onClick=" history.back()" type=button value="返  回" name='cmdExit'>
        &nbsp;&nbsp;
    </div>
</div>
<form method="post" action="/bsweb/certificate_certLost.action" name="busForm">
<input type="hidden" name="source" value="<%=source%>"/>
<input type="hidden" name="currentPath" value="<%=currentPath%>"/>
<input type="hidden" name="jgdm" value="<%=tJgdm.getJgdm()%>"/>
<input type="hidden" name="zfrq" value="<%=tJgdm.getZfrq().toString().substring(0, 10)%>"/>

<div id="box">
<div id="content">
<div id="right">
<div class="rightpart">
<div class="list listblue">
<h3><b><%=title%>
</b></h3>
<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >
<%
    if ("qrgs".equals(source)) {
%>
<TR>
    <TD class=td1 align=right width="15%">
        挂失依据：
    </TD>
    <TD class=td1>
        <TEXTAREA name="gsyj" id="gsyj" rows=3 style="width:100%;">${wgs!=null?wgs.gsyj:""}</TEXTAREA>
    </TD>
    <TD class=td1 align=right width="15%">
        挂失原因：
    </TD>
    <TD class=td1>
        <TEXTAREA name="gsreason" id="gsreason" rows=3 style="width:100%;">${wgs!=null?wgs.gsyy:""}</TEXTAREA>
    </TD>
</TR>
<%
    }
%>
<TR>
    <TD class=td1 align=right>
        机构代码：
    </TD>
    <TD class=td1 colspan="3">
        <%=tJgdm.getJgdm()%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right width="15%">
        机构类型：
    </TD>
    <TD class=td1>
        <%
            List<TJglx> jglxList = InitSysParams.tjglxList;
            if (jglxList != null && jglxList.size() > 0) {
                for (TJglx jglx : jglxList) {
                    if (jglx != null) {
                        if (tJgdm.getJglx().equals(jglx.getDm())) {
                            out.print(jglx.getDm() + "&nbsp;(" + jglx.getMc() + ")");
                            break;
                        }
                    }
                }
            }
        %>
    </TD>
    <TD class=td1 align=right width="15%">
        新机构类型：
    </TD>
    <TD class=td1>
        <%
            List<TNJglx> njglxList = InitSysParams.tnJglxList;
            if (njglxList != null && njglxList.size() > 0) {
                for (TNJglx jglx : njglxList) {
                    if (jglx != null) {
                        if ((tJgdm.getNjglx() == null ? "" : tJgdm.getNjglx()).equals(jglx.getDm())) {
                            out.print(jglx.getMc());
                            break;
                        }
                    }
                }
            }
        %>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        机构名称：
    </TD>
    <TD class=td1 colspan="3">
        <%=clsStringTool.convertNull(tJgdm.getJgmc())%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        法人代表：
    </TD>
    <TD class=td1>
        <%=tJgdm.getFddbr()%>
    </TD>
    <TD class=td1 align="right" width="15%">&nbsp;<%
        List<TZjlx> zjlxList = InitSysParams.tZjlxList;
        if (zjlxList != null && zjlxList.size() > 0) {
            for (TZjlx zjlx : zjlxList) {
                if (zjlx != null) {
                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getZjlx())) {
                        out.print(zjlx.getMc() + "：");
                        break;
                    }
                }
            }
        }
    %>
    </TD>
    <TD class="td1">
        <%=clsStringTool.convertNull(tJgdm.getZjhm())%>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        经营范围：
    </TD>
    <TD class=td1 colSpan=3>
        <%=clsStringTool.convertNull(tJgdm.getJyfw())%>
    </TD>
</TR>

<TR>
    <TD class=td1 align=right>
        经济行业(2000版)：
    </TD>
    <TD class=td1>
        <%=InitSysParams.njjhyMap.get(tJgdm.getNjjhy() == null ? "" : tJgdm.getNjjhy().trim()) == null ? "无" : InitSysParams.njjhyMap.get(tJgdm.getNjjhy() == null ? "" : tJgdm.getNjjhy().trim())%>
    </TD>
    <TD class=td1 align=right>
        经济行业(94版)：
    </TD>
    <TD class=td1>
        <%=InitSysParams.jjhyMap.get(tJgdm.getJjhy()) == null ? "无" : InitSysParams.jjhyMap.get(tJgdm.getJjhy())%>
    </TD>

</TR>
<TR>
    <TD class=td1 align=right>
        经济类型(2000版)：
    </TD>
    <TD class=td1>
        <%=InitSysParams.njjlxMap.get(tJgdm.getNjjlx()) == null ? "无" : InitSysParams.njjlxMap.get(tJgdm.getNjjlx())%>
    </TD>
    <TD class=td1 align=right>
        经济类型(94版)：
    </TD>
    <TD class=td1>
        <%=InitSysParams.jjlxMap.get(tJgdm.getJjlx() == null ? "" : tJgdm.getJjlx().trim()) == null ? "无" : InitSysParams.jjlxMap.get(tJgdm.getJjlx().trim())%>
    </TD>
</TR>
<tr>
    <TD class=td1 align=right>
        成立日期：
    </TD>
    <TD class=td1>
        <%=tJgdm.getZcrq() == null ? "" : tJgdm.getZcrq().toString().substring(0, 10)%>
    </TD>
    <TD class=td1 align=right>
        办证日期：
    </TD>
    <TD class=td1>
        <%=tJgdm.getBzrq().toString().substring(0, 10)%>
    </TD>
</tr>
<TR>
    <TD class=td1 align=right>
        年检期限：
    </TD>
    <TD class=td1>
        <%=tJgdm.getNjqx().toString().substring(0, 10)%>
    </TD>
    <TD class=td1 align=right>
        作废日期：
    </TD>
    <TD class=td1>
        <%=tJgdm.getZfrq().toString().substring(0, 10)%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        行政区划：
    </TD>
    <TD class=td1>
        <%=tJgdm.getXzqh()%>
        (<%=InitSysParams.xzqhMap.get(tJgdm.getXzqh()) == null ? "" : InitSysParams.xzqhMap.get(tJgdm.getXzqh())%>)
    </TD>
    <TD class=td1 align=right>
        职工人数：
    </TD>
    <TD class=td1>
        <%=tJgdm.getZgrs()%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        单位地址：
    </TD>
    <TD class=td1 colSpan=3>
        <%=tJgdm.getJgdz()%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        注册资金：
    </TD>
    <TD class=td1>
        <fmt:formatNumber value='<%=tJgdm.getZczj()==null?0:tJgdm.getZczj()%>' pattern="##.0000"/>万元
    </TD>
    <TD class=td1 align=right>
        货币种类：
    </TD>
    <TD class=td1>
        <DIV>
            <%
                List<THb> list = InitSysParams.thbList;
                if (list != null && list.size() > 0) {
                    for (THb hb : list) {
                        if (hb != null) {
                            if (hb.getDm().equals(tJgdm.getHbzl())) {
                                out.print(hb.getDm() + "&nbsp;(" + hb.getMc() + ")");
                                break;
                            }
                        }
                    }
                }
            %>
        </DIV>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        邮政编码：
    </TD>
    <TD class=td1>
        <%=tJgdm.getYzbm()%>
    </TD>
    <TD class=td1 align=right>
        联系电话：
    </TD>
    <TD class=td1>
        <%=tJgdm.getDhhm()%>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        批准机构：
    </TD>
    <TD class=td1 colspan="3">
        <%=tJgdm.getPzjgdm()%>
        <% Map<String,String> pzjgMap= InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm());%>
        (<%=pzjgMap.get(tJgdm.getPzjgdm() == null ? "" : tJgdm.getPzjgdm().trim()) == null ? " 无" :pzjgMap.get(tJgdm.getPzjgdm() == null ? "" : tJgdm.getPzjgdm().trim())%>
        )
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        注&nbsp;册&nbsp;号：
    </TD>
    <TD class=td1>
        <%=tJgdm.getZch()%>
    </TD>
    <TD class=td1 align=right>
        是否公开：
    </TD>
    <TD class=td1>
        <%
            if ("1".equals(tJgdm.getGk())) {
                out.print("是");
            }
        %>
        <%
            if ("2".equals(tJgdm.getGk())) {
                out.print("否");
            }
        %>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        主管机构：
    </TD>
    <td class="td1">
        <%=tJgdm.getZgdm() == null ? "" : tJgdm.getZgdm()%>
        (
        <%=tJgdm.getZgdm() == null || "".equals(tJgdm.getZgdm().trim()) ? "无" : (InitSysParams.zgjgMap == null ? "" : InitSysParams.zgjgMap.get(tJgdm.getZgdm().trim()) == null ? "" : InitSysParams.zgjgMap.get(tJgdm.getZgdm().trim()))%>
        )
    </td>
    <TD class=td1 align=right>
        外方国别：
    </TD>
    <TD class=td1>
        <%=tJgdm.getWftzgb() == null ? "" : tJgdm.getWftzgb()%>
        (<%=clsStringTool.isEmpty(tJgdm.getWftzgb()) ? " 无" : (InitSysParams.gjMap.get(tJgdm.getWftzgb().trim()) == null ? "" : InitSysParams.gjMap.get(tJgdm.getWftzgb().trim()))%>
        )

    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        正本数量：
    </TD>
    <TD class=td1>
        <%=tJgdm.getZbsl() == null ? 0 : tJgdm.getZbsl()%>
    </TD>
    <TD class=td1 align=right>
        副本数量：
    </TD>
    <TD class=td1>
        <%=tJgdm.getFbsl() == null ? 0 : tJgdm.getFbsl()%>
    </TD>
</TR>
<%--<TR>
    <TD class=td1 align=right>
        IC：
    </TD>
    <TD class=td1> <input type="checkbox" name="djh" ${wgs.ic eq 1?'checked':"" }/>是否挂失IC
        
    </TD>
    <TD class=td1 align=right>
    </TD>
    <TD class=td1>
    </TD>
</TR>
--%>
<TR>
    <TD class=td1 align=right>
        选择挂失证书登记号：
    </TD>
    <TD class=td1 colSpan=3>
        <%
        boolean flag=false;
            if (!"0".equals(tJgdm.getDybz())) {
                List<TZs> listZs = (List<TZs>) request.getAttribute("zsList");
                int i = 0;
                if (listZs != null && listZs.size() > 0) {
                    for (TZs tzs : listZs) {
                    	String djh=wgs.getZsdjh();
                    	if(djh!=null&&djh.indexOf(tzs.getLsh()+"") != -1){
                    		flag=true;
                    	}else{
                    		flag=false;
                    	}
        %> 
        <input type="checkbox" name="djh"
               value="<%=clsStringTool.isEmpty(tzs.getDjh())?"&nbsp;":tzs.getDjh().trim()%>" <%=flag?"checked":""%>/> <span
            style="width:200px;display:inline-block;"><%=clsStringTool.isEmpty(tzs.getDjh()) ? "&nbsp;" : tzs.getDjh().trim()%></span>
        <%
                        i++;
                        if (i % 3 == 0) {
                            out.print("<br />");
                        }
                    }
                }
            }
        %>
    </TD>
</TR>
</TABLE>
</div>
<div class="listbtn" id="page_bottom">
    <INPUT class="newBtn1" onClick="return validateBus();" type=button value="确 认" name="btok">
    &nbsp;&nbsp;
    <INPUT class="newBtn1" onClick="printPage();" type=button value="打 印" name="btok">
    &nbsp;&nbsp;
    <INPUT class="newBtn1" onClick=" history.back()" type=button value="返  回" name='cmdExit'>
</div>
</div>
</div>
</div>
</div>
</form>
</body>
<script>
    (function () {
        var $backToTopTxt = "返回顶部", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6下的定位
            if (!window.XMLHttpRequest) {
                $backToTopEle.css("top", st + winh - 166);
            }
        };
        $(window).bind("scroll", $backToTopFun);
        $(function () {
            $backToTopFun();
        });
    })();
</script>
</html>
