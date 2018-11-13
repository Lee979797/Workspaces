<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=gbk"%>
<%@ page import="com.ninemax.jpa.util.clsStringTool"%>
<%@ page import="com.ninemax.jpa.global.InitSysParams"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ninemax.jpa.code.model.*"%>
<%@ page import="net.sf.cglib.beans.BeanCopier"%>
<%@ page import="com.ninemax.jpa.util.DateUtil"%>
<%@ page import="java.util.Date"%>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>" />
<c:set var="zList" value="<%=InitSysParams.zwList%>" />
<c:set var="mList" value="<%=InitSysParams.mzList%>" />
<c:set var="gList" value="<%=InitSysParams.gjList%>" />
<c:set var="zzList" value="<%=InitSysParams.zzmmList%>" />
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	String currentPath = request.getRequestURI();
	if (request.getQueryString() != null) {
		currentPath = currentPath + "?" + request.getQueryString();
	}
	//type页面请求类型 1删除 2校对 3详细
	String type = (String) request.getAttribute("type");
	String title = "";
	if ("1".equals(type)) {
		title = "删除信息";
	}
	if ("2".equals(type)) {
		title = "校对信息";
	}
	if ("3".equals(type)) {
		title = "查看信息";
	}
	String formType = request.getParameter("formType");
	String jglx = request.getParameter("jglx");
	if (clsStringTool.isEmpty(formType)) {
		jglx = (String) request.getAttribute("jglx");
	}
	if (clsStringTool.isEmpty(formType)) {
		formType = (String) request.getAttribute("formType");
	}
	String tit = "申请表删除";
	String nav = request.getParameter("nav");
	if ("1".equals(nav)) {
		tit = "申请表登记";
	}
	TJgdmSave tJgdm = new TJgdmSave();
	//把从t_jgdm表中取得的数据复制到t_jgdm_save中，用于公用一个页面
	//用于判断申请表删除标识
	String delMessage = "";
	String delFlag = request.getParameter("delFlag");
	if (clsStringTool.isEmpty(delFlag)) {
		delFlag = "";
	}
	if ("0".equals(delFlag)) {
		delMessage = "删除请求已发送，正在等待省中心审核！";
	}
	if ("1".equals(delFlag)) {
		delMessage = "审核通过,允许删除此机构代码！";
	}
	if ("2".equals(delFlag)) {
		delMessage = "删除需要经过省中心的审核，向省中心发送删除请求！";
	}
	if ("3".equals(delFlag)) {
		delMessage = "审核不通过,不允许删除此机构代码！";
	}
	if ("4".equals(formType)) {
		TJgdm tjgdm = (TJgdm) request.getAttribute("tjgdm");
		BeanCopier beanCopier = BeanCopier.create(TJgdm.class,
				TJgdmSave.class, false);
		beanCopier.copy(tjgdm, tJgdm, null);
	} else {
		tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
		System.out.println("-----------------" + tJgdm.getJgmc());
		System.out.println("tJgdm.getJglx()" + tJgdm.getJglx());
		System.out.println("formType" + formType);
	}
	String btnName = "";
	String btnName2 = "";

	if ("2".equals(formType)) {
		btnName = "校对赋码";
		btnName2 = "打印校对信息";
	} else {
		btnName = "校对赋码";
		btnName2 = "打印校对信息";
	}
	//页面请求来源 page来自单独页面 否则来自列表页面 单独页面的返回操作和列表页面返回操作不一样
	String path = request.getParameter("path");
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>选择办证机构</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css"
	href="<%=request.getContextPath()%>/js/alert/skin/dmm-green/ymPrompt.css" />
<script type="text/javascript" src="/js/tools.js"></script>
<script type="text/javascript" src="/js/shadow.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
<script type="text/javascript">
       function fm() {
       //alert("zhixingzhege fm");
       					var formType='${formType}';
             	//window.location.href = '/bsweb/certificate_revision.action?djh=${djh}&ywlsh=${ywlsh}&id=<%=tJgdm.getId()%>&formType=<%=formType%>&type=<%=type%>&path=${path}&jglx=<%=jglx%>';
             	<%-- if(formType=='1'){
             		window.location.href = '/bsweb/certificate_revision1.action?djh=${djh}&ywlsh=${ywlsh}&id=<%=tJgdm.getId()%>&formType=<%=formType%>&type=<%=type%>&path=${path}&jglx=<%=jglx%>';
             	}else{ --%>
             	ajaxCode(0, document.busForm, '<%=tJgdm.getId()%>');
             	/* } */
        }
        
        function pt(){
        	bdhtml=window.document.body.innerHTML; 
    sprnstr="<!--startprint12312-->"; //开始打印标识字符串有22个字符
    eprnstr="<!--endprint12312-->"; //结束打印标识字符串
    prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+22); //从开始打    印标识之后的内容
    prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
    window.document.body.innerHTML=prnhtml; //把需要打印的指定内容赋给body.innerHTML
    window.print(); //调用浏览器的打印功能打印指定区域
    window.document.body.innerHTML=bdhtml;//重新给页面内容赋值；
        }


        function del() {
            if (confirm("确认要删除？")) {
                window.location.href = '/bsweb/certificate_delete.action?id=<%=tJgdm.getId() == null ? 0 : tJgdm.getId()%>&jgmc=<%=clsStringTool.convertNull(tJgdm.getJgmc())%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx%>';
            }
        }
        function send() {
            var reason = document.getElementById("czreason").value;
            if (isEmpty(reason)) {
                ymPrompt.alert('删除原因不能为空!', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        document.getElementById("czreason").focus();
                    }
                });
            } else if (reason.length > 50) {
                ymPrompt.alert('删除原因不能超过50个汉字!', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        document.getElementById("czreason").focus();
                    }
                });
            } else {
                if (confirm("是否发送删除机构代码<%=tJgdm.getJgdm()%>的请求?")) {
                    window.location.href = '/bsweb/certificate_send.action?jgdm=<%=tJgdm.getJgdm() == null ? 0 : tJgdm.getJgdm()%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&reason=' + reason;
                }
            }
        }
        function delApplyForm() {
            if (confirm("确认要删除机构代码<%=tJgdm.getJgdm()%>？")) {
                window.location.href = '/bsweb/certificate_deleteApplyForm.action?jgdm=<%=tJgdm.getJgdm() == null ? 0 : tJgdm.getJgdm()%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}';
            }
        }

    </script>
<style type="text/css">
.td1 {
	border-bottom: #c4dbe5 1px solid;
}
</style>
</head>
<body>
	<div class="page_top_fixed" style="background:#F8F8F8">
		<div align="left" style=" float: left;">
			<strong> 登记&gt;&gt; 工会业务 &gt;&gt; <%=title%>
			</strong>
		</div>
		<div align="right" style="width: 30% ; float: right;">
			<%--如果是其他部门赋码删除或者预赋码删除--%>
			<%
				if (!"4".equals(formType)) {
					if (("1".equals(type) && ("1".equals(delFlag)))
							|| ("1".equals(type) && "0".equals(formType))
							|| ("1".equals(type) && "".equals(delFlag))) {
			%>
			<INPUT class="newBtn1" onClick="del();" type=button value="删 除"
				name="btok" />
			<%
				}
					if ("1".equals(type)
							&& ("2".equals(delFlag) || "3".equals(delFlag))) {
			%>
			<INPUT class="newBtn1" onClick="send();" type=button value="发 送"
				name="btok" />
			<%
				}
					if ("2".equals(type)) {
			%>
			<INPUT class="newBtn1" onclick="fm();" type=button
				value="<%=btnName%>" name="btok" /> &nbsp; <INPUT class="newBtn1"
				onclick="pt();" type=button value="<%=btnName2%>" name="btok" />
			<%
				}
			%>&nbsp;<INPUT class="newBtn1"
				<c:if test="${path eq null}">onClick="history.back()"</c:if>
				<c:if test="${path eq 'page'}">onClick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=${formType}'"</c:if>
				type=button value="返 回" name="cmdExit" />
			<%
				}
			%>

			<!-- 申请表删除 -->
			<%
				if ("4".equals(formType)) {
					if ("2".equals(delFlag) || "3".equals(delFlag)) {
			%>
			<INPUT class="newBtn1" onClick="send();" type=button value="发 送"
				name="btok" />
			<%
				}
					if ("1".equals(delFlag) || "".equals(delFlag)) {
			%>
			<INPUT class="newBtn1" onClick="delApplyForm();" type=button
				value="删 除" name="btok" />
			<%
				}
			%><INPUT class="newBtn1" onClick="history.back()" type=button
				value="返 回" name="cmdExit" />
			<%
				}
			%>&nbsp;
		</div>
	</div>
	<form method="post" action="/bsweb/certificate_revision.action"
		name="busForm">
		<input type="hidden" name="djh" value="${djh}" id="djh" /> <input
			type="hidden" name="ywlsh" value="${ywlsh}" id="ywlsh" /> <input
			type="text" name="id" value="${id}" id="id" /> <input type="hidden"
			name="formType" value="${formType}" id="formType" /> <input
			type="hidden" name="type" value="${type}" id="type" /> <input
			type="hidden" name="path" value="${path}" id="path" /> <input
			type="hidden" name="jglx" value="${jglx }" /> <input type="hidden"
			name="sslcode" id="sslcode" />
	</form>
	<div id="box">
		<div id="content">
			<div id="right">
				<div class="rightpart">
					<div class="list listblue">
						<h3>
							<b><%=title%> </b>
						</h3>
						<!--startprint12312-->
						<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center
							border=0 width="100%">
							<%-- 如果其他部门赋码1，预赋码2,申请表单 4,删除 需要审核或审核未通过需要发送删除原因 --%>
							<%
								if (("1".equals(formType) || "2".equals(formType) || "4"
										.equals(formType))
										&& ("2".equals(delFlag) || "3".equals(delFlag))) {
							%>
							<TR>
								<TD class=td1 align=right></TD>
								<TD class=td1 colspan="3"><%=delMessage%></TD>
							</TR>
							<TR>
								<TD class=td1 align=right>删除原因：</TD>
								<TD class=td1 colspan="3"><TEXTAREA name="czreason"
										id="czreason" rows=3 cols=129 style="width:75%;"></TEXTAREA></TD>
							</TR>
							<%
								}
							%>
							<%
								if (("1".equals(formType) || "2".equals(formType) || "4"
										.equals(formType)) && ("0".equals(delFlag))) {
							%>
							<TR>
								<TD class=td1 align=right></TD>
								<TD class=td1 colspan="3"><%=delMessage%></TD>
							</TR>
							<%
								}
							%>
							<%
								if (("1".equals(formType) || "2".equals(formType) || "4"
										.equals(formType)) && "1".equals(delFlag)) {
							%>
							<TR>
								<TD class=td1 align=right></TD>
								<TD class=td1 colspan="3"><%=delMessage%></TD>
							</TR>
							<%
								}
							%>
							<%
								if ("1".equals(formType) || "2".equals(formType)
										|| "4".equals(formType)) {
							%>
							<TR>
								<TD class=td1 align=right>机构代码：</TD>
								<TD class=td1 colspan="3"><%=clsStringTool.convertNull(tJgdm.getJgdm())%>
								</TD>
							</TR>
							<%
								}
							%>

							<%@ include file="common_view.jsp"%>
							<jsp:include page="../common_gh/show-jgdm-fddbr.jsp" />
						</TABLE>
						<!--endprint12312-->
					</div>

					<div class="listbtn">
						<%
							if (!"4".equals(formType)) {
								if (("1".equals(type) && ("1".equals(delFlag)))
										|| ("1".equals(type) && "0".equals(formType))
										|| ("1".equals(type) && "".equals(delFlag))) {
						%>
						<INPUT class="newBtn1" onClick="del();" type=button value="删 除"
							name="btok" />
						<%
							}
								if ("1".equals(type)
										&& ("2".equals(delFlag) || "3".equals(delFlag))) {
						%>
						<INPUT class="newBtn1" onClick="send();" type=button value="发 送"
							name="btok" />
						<%
							}
								if ("2".equals(type)) {
						%>
						<INPUT class="newBtn1" onClick="fm();" type=button
							value="<%=btnName%>" name="btok" /> &nbsp; <INPUT class="newBtn1"
							onclick="pt();" type=button value="<%=btnName2%>" name="btok" />
						<%
							}
						%>&nbsp;<INPUT class="newBtn1"
							<c:if test="${path eq null}">onClick="history.back()"</c:if>
							<c:if test="${path eq 'page'}">onClick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=${formType}'"</c:if>
							type=button value="返 回" name="cmdExit" />
						<%
							}
						%>

						<!-- 申请表删除 -->
						<%
							if ("4".equals(formType)) {
								if ("2".equals(delFlag) || "3".equals(delFlag)) {
						%>
						<INPUT class="newBtn1" onClick="send();" type=button value="发 送"
							name="btok" />
						<%
							}
								if ("1".equals(delFlag) || "".equals(delFlag)) {
						%>
						<INPUT class="newBtn1" onClick="delApplyForm();" type=button
							value="删 除" name="btok" />&nbsp;<%
							}
						%><INPUT class="newBtn1" onClick="history.back()"
							type=button value="返 回" name="cmdExit" />
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
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
<script>
     <%Object msg = request.getAttribute("resultMsg");
			if (msg != null && !"".equals(msg.toString().trim())) {
				if ("success".equals(msg.toString())) {%>
    ymPrompt.succeedInfo('操作成功！', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("NoCode".equals(msg.toString())) {%>
    ymPrompt.alert('无可用的码段,请到国家中心下载码段!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("CodeExist".equals(msg.toString())) {%>
    ymPrompt.alert('机构代码已经存在，不能赋码!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("DataWrong".equals(msg.toString())) {%>
    ymPrompt.alert('数据不完整，请去预赋码颁证模块更新数据!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("canNotFm".equals(msg.toString())) {%>
    ymPrompt.alert({message: "系统限制机构赋码要到<%=DateUtil.dateToStr(DateUtil.dayAfter(
							tJgdm.getBzrq(), InitSysParams.system.getFmqx()))%>后才可办理！", width: 330, height: 220,
        slideShowHide: false, title: '提示信息'});
    <%} else {%>
    ymPrompt.alert('系统繁忙!请稍后再试!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}
			}%> 
</script>
</html>
