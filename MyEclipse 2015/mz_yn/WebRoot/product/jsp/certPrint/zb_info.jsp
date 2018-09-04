<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="title" type="java.lang.String"--%>
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; c   harset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>����������Ϣ</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src='/js/LodopFuncs.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
		<script type="text/javascript">
  
	function fCheckValue() {
		CreatePrintMinfei_zb('view');
	}
	function _goBack() {
		window.history.back();
	}
	var flag='${jgdm.zgmc}'!=''?false:true;;

	function CreatePrint() {
		if ($("#cls").val() == '0') {

			if (flag) {
				if ('${jgdm.jglx}' == '2') {
					CreatePrintMinfei_zb('weihu');
				} else if ('${jgdm.jglx}' == '1') {
					CreatePrintShetuan_zb('weihu');
				} else if ('${jgdm.jglx}' == '3') {
					CreatePrintJijinhui_zb('weihu');
				}

			} else {
				if ('${jgdm.jglx}' == '2') {
					CreatePrintMinfei_zb_zg('weihu');
				} else if ('${jgdm.jglx}' == '1') {
					CreatePrintShetuan_zb_zg('weihu');
				} else if ('${jgdm.jglx}' == '3') {
					CreatePrintJijinhui_zb_zg('weihu');
				}
			}
		} else {
			if (flag) {
				if ('${jgdm.jglx}' == '2') {
					CreatePrintMinfei_fb('weihu');

				} else if ('${jgdm.jglx}' == '1') {
					CreatePrintShetuan_fb('weihu');
				} else if ('${jgdm.jglx}' == '3') {
					CreatePrintJijinhui_fb('weihu');
				}

			} else {
				if ('${jgdm.jglx}' == '2') {
					CreatePrintMinfei_fb_zg('weihu');

				} else if ('${jgdm.jglx}' == '1') {
					CreatePrintShetuan_fb_zg('weihu');
				} else if ('${jgdm.jglx}' == '3') {
					CreatePrintJijinhui_fb_zg('weihu');
				}

			}

		}
	}

	function fCheckValueZb() {
		if (flag) {

			if ('${jgdm.jglx}' == '2') {
				CreatePrintMinfei_zb('view');

			} else if ('${jgdm.jglx}' == '1') {
				CreatePrintShetuan_zb('view');
			} else if ('${jgdm.jglx}' == '3') {
				CreatePrintJijinhui_zb('view');
			}
		} else {

			if ('${jgdm.jglx}' == '2') {
				CreatePrintMinfei_zb_zg('view');

			} else if ('${jgdm.jglx}' == '1') {
				CreatePrintShetuan_zb_zg('view');
			} else if ('${jgdm.jglx}' == '3') {
				CreatePrintJijinhui_zb_zg('view');
			}

		}

		$.ajax({
			type : "POST",  //�ύ��ʽ
			url : "/bsweb/certificatePrint_zb_print",//·��
			data : {
				"jgdm.tyshxydm" : $("#tyshxydm").val()
			},//���ݣ�����ʹ�õ���Json��ʽ���д���
			success : function(result) {//�������ݸ��ݽ��������Ӧ�Ĵ���
				if(result=='ok'){
					ymPrompt.alert({message: "֤���ӡ�ɹ�!", width: 330, height: 220, title: '��ʾ��Ϣ'});
					}
			}
	    });

		

	}
	function fCheckValueFb() {
		if (flag) {
			if ('${jgdm.jglx}' == '2') {
			
				CreatePrintMinfei_fb('view');

			} else if ('${jgdm.jglx}' == '1') {
				CreatePrintShetuan_fb('view');
			} else if ('${jgdm.jglx}' == '3') {
				CreatePrintJijinhui_fb('view');
			}
		} else {

			if ('${jgdm.jglx}' == '2') {
				CreatePrintMinfei_fb_zg('view');

			} else if ('${jgdm.jglx}' == '1') {
				CreatePrintShetuan_fb_zg('view');
			} else if ('${jgdm.jglx}' == '3') {
				CreatePrintJijinhui_fb_zg('view');
			}
		}
	}

	function test() {
		eval('fCheckValueFb()');

	}
</script>
	</head>
<body>
<div class="page_top_fixed" style="background:#F8F8F8">
    <div align="left" style=" float: left;">${title}</div>
    <div align="right" style=" float: right; ">
    <c:if test="${jgdm.cishan eq '1' && jgdm.mujuan eq '1'}">
   		<select name="cs_gm" id="cs_gm">
		    <option value="cszs">����֤��</option>
		    <option value="gmzs">��ļ֤��</option>
	    </select>
	</c:if>
	    <select name="cls" id="cls">
		    <option value="0">����</option>
		    <option value="1">����</option>
	    </select>
        <input type="button" class="newBtn1" value="ά��" name="btok" onClick="CreatePrint();">
        &nbsp;
        <input type="button" class="newBtn1" value="��ӡ����" name="btok" onClick="fCheckValueZb();">
        &nbsp;
        <input type="button" class="newBtn1" value="��ӡ����" name="btok" onClick="fCheckValueFb();">
        &nbsp;
        <input type="button" value="�� ��" name="cmdExit" class="newBtn1"
               onclick="_goBack();">
        &nbsp;
    </div>
</div>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <form action="/bsweb/certificatePrint_zb_print.action" name="printCert">
                        <input type="hidden" name="jgdm.jgdm" value="${jgdm.jgdm}"/>
                        <input type="hidden" name="jgdm.tyshxydm" id="tyshxydm" value="${jgdm.tyshxydm}"/>
                        <input type="hidden" name="ywlc.ywlsh" value="${ywlc.ywlsh}"/>
                        <input type="hidden" name="certi.type" value="1"/>
                    <table class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                           >
							   <tr>
								<td  align="right">
								ͳһ������ô��룺
								</td>
								<td>
								${jgdm.tyshxydm }
								</td>
								<td align="right">
								��֤�������ƣ�
								</td>
								<td>
								${jgdm.pzjgmc}
								</td>
								</tr>
									</form>

                        <jsp:include page="../common/show-jgdm.jsp"/>
                    </table>
                </div>
                 <jsp:include page="../common/show-fzr.jsp"/>
                <div class="listbtn">
                    <div id="pr">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>


</script>
<jsp:include page="../common/onload.jsp"/>
<jsp:include page="lodop.jsp"/>
</html>
