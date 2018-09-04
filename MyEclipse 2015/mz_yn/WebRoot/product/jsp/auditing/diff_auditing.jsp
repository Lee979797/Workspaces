<%--@elvariable id="sp" type="com.ninemax.jpa.code.model.TSp"--%>
<%@ page language="java" pageEncoding="GBK" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    String currentPath = request.getRequestURI();
    if (request.getQueryString() != null)
        currentPath = currentPath + "?" + request.getQueryString();
%>
<c:set var="jglxs" value="<%=InitSysParams.jglxMap%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>内网数据审核</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/csshaojy.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/js/alert/skin/dmm-green/ymPrompt.css"/>

    <script type="text/javascript">

        function checkPass() {
            if (!showLength(document.getElementById("info1"))) {
                return;
            }
            document.getElementById("ispass").value = "1";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }

        function checkNoPass() {
            if (!showLength(document.getElementById("info1"))) {
                return;
            }
            document.getElementById("ispass").value = "0";
            trimIntputValue(document.getElementById("info1"));
            document.form1.submit();
        }
        function showLength(obj) {
            if (obj.value.length > 100) {
                obj.value = obj.value.substr(0, 100);
                ymPrompt.alert({message: "审核意见不能超过100个字符!", width: 330, height: 220, title: '提示信息'});
                return false;
            }
            return true;
        }
        function show(dm) {
            $.get("/bsweb/auditing_show",
                    {'jgdm.tyshxydm': dm},
                    function (data, status) {
                        if (status == 'success') {
                            $("#frame").html(data);
                        }
                    });
        }
        
    </script>
    <style type="text/css">
        .toolabsolute {
            width: 90%;
            position: absolute;
            z-index: 100;
            top: 300px;
            left: 41px;
        }

        .box {
            width: 90%;
            height: 100%;
            text-align: left;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="right" style="width: 30% ; float: right;margin-top: 3px;">
        <input name="button3" type="reset" class="newBtn1"
               id="button31" value="返 回"
               onclick="history.go(-1);"/>&nbsp;&nbsp;&nbsp;</div>
    登记 &gt;&gt; <c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if> &gt;&gt; 数据审核
</div>
<div id="list_main">
    <form name="form1" id="form1" action="/bsweb/auditingauditIndata.action" method="post" style="margin:0; padding:0;">
        <input name="sp.shflag" id="ispass" type="hidden" value=""/>
        <input name="sp.ywlx" id="ywlx" type="hidden" value="${sp.ywlx}"/>
        <input name="sp.lsh" id="lsh" type="hidden" value="${sp.lsh}"/>
        <input type="hidden" name="currentPath" value="<%=currentPath%>"/>
		<input type="hidden" name="jglx" value="${jglx }">
        <div style="padding: 10px;"><br/>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="80" align="center" nowrap="nowrap"><label for="info1">审核意见：</label></td>
                    <td align="center">
                        <TEXTAREA class="input_txt_morebz" onpaste="showLength(this);" onkeyup="showLength(this);"
                                  name="sp.shreason" id="info1" rows="3" cols="1"></TEXTAREA>
                    </td>
                </tr>
                <tr>
                    <td align="center">审核结果：</td>
                    <td height="35" align="left" style="height: 35px; line-height: 35px ;  overflow: hidden;
    vertical-align:middle;"><input
                            name="button3" type="button" class="btn_yes" id="button3"
                            value=" " onclick="checkPass();"/>
                        <input name="button3" type="button" class="btn_no" id="button4" value=" "
                               onclick="checkNoPass();"/>
                     
                    </td>
                </tr>
            </table>
        </div>
        <br/>
    </form>
    <div class="box">
        <div class="list" id="mytool">
            <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
                <tr>
                    <td class="title_txt">审核数据</td>
                </tr>
            </table>
            <div class="content">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bottom_border">
           
                </table>
            </div>
            <div class="list_box">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="list_table_top">

                        <td class="list_table_top_td">
                            <div style="float:left">统一代码</div>
                        </td>

                        <td class="list_table_top_td">
                            <div style="float:left">机构名称</div>
                        </td>

                        <td class="list_table_top_td">
                            <div style="float:left">机构类型</div>
                        </td>

                        <td class="list_table_top_td">
                            <div style="float:left">法定代表人</div>
                        </td>
                        <td class="list_table_top_td">
                            <div style="float:left">有效日期</div>
                        </td>
                        <td class="list_table_top_td">
                            <div style="float:left">数据来源</div>
                        </td>

                        <td class="list_table_top_td" align="center">查看详细</td>
                    </tr>
                    <c:forEach varStatus="i" var="tjgdmsave" items="${jgdms}">
                        <tr style="${i.count ==1?'background-color: #90ee90;':''}"  ${i.count % 2==1?"class='list_tr'":"class='list_tr2'" }>
                            <td>${ (fn:length(fn:trim(tjgdmsave.tyshxydm)) ne 18 )?"无":tjgdmsave.tyshxydm }</td>
                            <td>${tjgdmsave.jgmc }</td>
                            <td>${jglxs[tjgdmsave.bzjgdm]}</td>
                            <td>${tjgdmsave.fddbr }</td>
                            <td>${tjgdmsave.zfrq}</td>
                            <td>${tjgdmsave.sjly}</td>
                          
                       		<td align="center">
                                <img src="../../images/icon_chakan.gif" width="16" height="16"
                                     onclick="show('${fn:trim(tjgdmsave.tyshxydm)}')"
                                     style="cursor:pointer"
                                     title="查看"/>
                            </td>
                    	
                    	
                            
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <table border="0" cellpadding="0" cellspacing="0" class="f_5a" width="100%">
                <tr>
                    <td class="title_txt">详细信息</td>
                </tr>
            </table>
            <div class="content" id="frame">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bottom_border">
                    <jsp:include page="../common/show-jgdm.jsp"/>
                </table>
            </div>

        </div>
    </div>
</div>
</body>

<script language="javascript">
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg!=null && !clsStringTool.isEmpty(msg.toString())){
    %>
    ymPrompt.succeedInfo('<%=msg.toString()%>', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/auditinginDataList.html";
    });
    <%}%>
</script>
<script type="text/javascript">
    $(document).ready(function () {
        var mytooltop;
        var scrolltop;
        var toolleft;
        var cloned = false;
        toolleft = $(".box").get(0).offsetLeft;
        $("#mytool").clone(true).insertAfter("#list_main").css("left", toolleft + "px").addClass("toolabsolute");
        $(".toolabsolute").hide();
        $("#list_main").scroll(function () {
            mytooltop = $("#mytool").get(0).offsetTop;
            scrolltop = document.getElementById("list_main").scrollTop;
            if (scrolltop >= mytooltop && cloned == false) {
                $(".toolabsolute").show();
                cloned = true;
            }
            if (!(scrolltop >= mytooltop) && cloned == true) {
                $(".toolabsolute").hide();
                cloned = false;
            }
        })
    })
</script>
</html>
