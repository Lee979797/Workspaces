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
	//typeҳ���������� 1ɾ�� 2У�� 3��ϸ
	String type = (String) request.getAttribute("type");
	String title = "";
	if ("1".equals(type)) {
		title = "ɾ����Ϣ";
	}
	if ("2".equals(type)) {
		title = "У����Ϣ";
	}
	if ("3".equals(type)) {
		title = "�鿴��Ϣ";
	}
	String formType = request.getParameter("formType");
	String jglx = request.getParameter("jglx");
	if (clsStringTool.isEmpty(formType)) {
		jglx = (String) request.getAttribute("jglx");
	}
	if (clsStringTool.isEmpty(formType)) {
		formType = (String) request.getAttribute("formType");
	}
	String tit = "�����ɾ��";
	String nav = request.getParameter("nav");
	if ("1".equals(nav)) {
		tit = "�����Ǽ�";
	}
	TJgdmSave tJgdm = new TJgdmSave();
	//�Ѵ�t_jgdm����ȡ�õ����ݸ��Ƶ�t_jgdm_save�У����ڹ���һ��ҳ��
	//�����ж������ɾ����ʶ
	String delMessage = "";
	String delFlag = request.getParameter("delFlag");
	if (clsStringTool.isEmpty(delFlag)) {
		delFlag = "";
	}
	if ("0".equals(delFlag)) {
		delMessage = "ɾ�������ѷ��ͣ����ڵȴ�ʡ������ˣ�";
	}
	if ("1".equals(delFlag)) {
		delMessage = "���ͨ��,����ɾ���˻������룡";
	}
	if ("2".equals(delFlag)) {
		delMessage = "ɾ����Ҫ����ʡ���ĵ���ˣ���ʡ���ķ���ɾ������";
	}
	if ("3".equals(delFlag)) {
		delMessage = "��˲�ͨ��,������ɾ���˻������룡";
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
		btnName = "У�Ը���";
		btnName2 = "��ӡУ����Ϣ";
	} else {
		btnName = "У�Ը���";
		btnName2 = "��ӡУ����Ϣ";
	}
	//ҳ��������Դ page���Ե���ҳ�� ���������б�ҳ�� ����ҳ��ķ��ز������б�ҳ�淵�ز�����һ��
	String path = request.getParameter("path");
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ѡ���֤����</title>
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
    sprnstr="<!--startprint12312-->"; //��ʼ��ӡ��ʶ�ַ�����22���ַ�
    eprnstr="<!--endprint12312-->"; //������ӡ��ʶ�ַ���
    prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+22); //�ӿ�ʼ��    ӡ��ʶ֮�������
    prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); //��ȡ��ʼ��ʶ�ͽ�����ʶ֮�������
    window.document.body.innerHTML=prnhtml; //����Ҫ��ӡ��ָ�����ݸ���body.innerHTML
    window.print(); //����������Ĵ�ӡ���ܴ�ӡָ������
    window.document.body.innerHTML=bdhtml;//���¸�ҳ�����ݸ�ֵ��
        }


        function del() {
            if (confirm("ȷ��Ҫɾ����")) {
                window.location.href = '/bsweb/certificate_delete.action?id=<%=tJgdm.getId() == null ? 0 : tJgdm.getId()%>&jgmc=<%=clsStringTool.convertNull(tJgdm.getJgmc())%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx%>';
            }
        }
        function send() {
            var reason = document.getElementById("czreason").value;
            if (isEmpty(reason)) {
                ymPrompt.alert('ɾ��ԭ����Ϊ��!', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        document.getElementById("czreason").focus();
                    }
                });
            } else if (reason.length > 50) {
                ymPrompt.alert('ɾ��ԭ���ܳ���50������!', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        document.getElementById("czreason").focus();
                    }
                });
            } else {
                if (confirm("�Ƿ���ɾ����������<%=tJgdm.getJgdm()%>������?")) {
                    window.location.href = '/bsweb/certificate_send.action?jgdm=<%=tJgdm.getJgdm() == null ? 0 : tJgdm.getJgdm()%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&reason=' + reason;
                }
            }
        }
        function delApplyForm() {
            if (confirm("ȷ��Ҫɾ����������<%=tJgdm.getJgdm()%>��")) {
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
			<strong> �Ǽ�&gt;&gt; ����ҵ�� &gt;&gt; <%=title%>
			</strong>
		</div>
		<div align="right" style="width: 30% ; float: right;">
			<%--������������Ÿ���ɾ������Ԥ����ɾ��--%>
			<%
				if (!"4".equals(formType)) {
					if (("1".equals(type) && ("1".equals(delFlag)))
							|| ("1".equals(type) && "0".equals(formType))
							|| ("1".equals(type) && "".equals(delFlag))) {
			%>
			<INPUT class="newBtn1" onClick="del();" type=button value="ɾ ��"
				name="btok" />
			<%
				}
					if ("1".equals(type)
							&& ("2".equals(delFlag) || "3".equals(delFlag))) {
			%>
			<INPUT class="newBtn1" onClick="send();" type=button value="�� ��"
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
				type=button value="�� ��" name="cmdExit" />
			<%
				}
			%>

			<!-- �����ɾ�� -->
			<%
				if ("4".equals(formType)) {
					if ("2".equals(delFlag) || "3".equals(delFlag)) {
			%>
			<INPUT class="newBtn1" onClick="send();" type=button value="�� ��"
				name="btok" />
			<%
				}
					if ("1".equals(delFlag) || "".equals(delFlag)) {
			%>
			<INPUT class="newBtn1" onClick="delApplyForm();" type=button
				value="ɾ ��" name="btok" />
			<%
				}
			%><INPUT class="newBtn1" onClick="history.back()" type=button
				value="�� ��" name="cmdExit" />
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
							<%-- ����������Ÿ���1��Ԥ����2,����� 4,ɾ�� ��Ҫ��˻����δͨ����Ҫ����ɾ��ԭ�� --%>
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
								<TD class=td1 align=right>ɾ��ԭ��</TD>
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
								<TD class=td1 align=right>�������룺</TD>
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
						<INPUT class="newBtn1" onClick="del();" type=button value="ɾ ��"
							name="btok" />
						<%
							}
								if ("1".equals(type)
										&& ("2".equals(delFlag) || "3".equals(delFlag))) {
						%>
						<INPUT class="newBtn1" onClick="send();" type=button value="�� ��"
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
							type=button value="�� ��" name="cmdExit" />
						<%
							}
						%>

						<!-- �����ɾ�� -->
						<%
							if ("4".equals(formType)) {
								if ("2".equals(delFlag) || "3".equals(delFlag)) {
						%>
						<INPUT class="newBtn1" onClick="send();" type=button value="�� ��"
							name="btok" />
						<%
							}
								if ("1".equals(delFlag) || "".equals(delFlag)) {
						%>
						<INPUT class="newBtn1" onClick="delApplyForm();" type=button
							value="ɾ ��" name="btok" />&nbsp;<%
							}
						%><INPUT class="newBtn1" onClick="history.back()"
							type=button value="�� ��" name="cmdExit" />
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
        var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
                .text($backToTopTxt).attr("title", $backToTopTxt).click(function () {
                    $("html, body").animate({ scrollTop: 0 }, 120);
                }), $backToTopFun = function () {
            var st = $(document).scrollTop(), winh = $(window).height();
            (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
            //IE6�µĶ�λ
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
    ymPrompt.succeedInfo('�����ɹ���', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("NoCode".equals(msg.toString())) {%>
    ymPrompt.alert('�޿��õ����,�뵽���������������!', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("CodeExist".equals(msg.toString())) {%>
    ymPrompt.alert('���������Ѿ����ڣ����ܸ���!', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("DataWrong".equals(msg.toString())) {%>
    ymPrompt.alert('���ݲ���������ȥԤ�����֤ģ���������!', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%} else if ("canNotFm".equals(msg.toString())) {%>
    ymPrompt.alert({message: "ϵͳ���ƻ�������Ҫ��<%=DateUtil.dateToStr(DateUtil.dayAfter(
							tJgdm.getBzrq(), InitSysParams.system.getFmqx()))%>��ſɰ���", width: 330, height: 220,
        slideShowHide: false, title: '��ʾ��Ϣ'});
    <%} else {%>
    ymPrompt.alert('ϵͳ��æ!���Ժ�����!', 330, 220, '��ʾ��Ϣ', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}
			}%> 
</script>
</html>
