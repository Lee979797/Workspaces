<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="java.util.Map" %>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
String currentPath = request.getRequestURI();
if(request.getQueryString() != null){
    currentPath = currentPath +"?"+request.getQueryString();
}
String title = "֤���ӡ";
TJgdm tJgdm = (TJgdm)request.getAttribute("tjgdm");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<title>ѡ���֤����</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/product/jsp/frame/js/alert/ymPrompt.js"></script>
 <link rel="stylesheet" id='skin' type="text/css" href="<%=request.getContextPath()%>/js/alert/skin/dmm-green/ymPrompt.css"/>
<script type="text/javascript" src="/js/tools.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>
<div id="box">
  <div id="content">
    <div id="right">
    	<div class="rightpart">
            <div class="list listblue">
                <h3><b><%=title%></b></h3>
        		<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%" >
                    <TR>
                        <TD class=td1 align=right>
                            ֤����ˮ�ţ�
                        </TD>
                        <TD class=td1 colspan="3">
                            ${tjgdm.zslsh}
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������ͣ�
                        </TD>
                        <TD class=td1>
                                <%
                                    List<TJglx> jglxList = InitSysParams.tjglxList;
                                    if(jglxList!=null&&jglxList.size()>0){
                                        for(TJglx jglx : jglxList){
                                            if(jglx!=null){
                                                 if((tJgdm.getJglx()==null?"":tJgdm.getJglx()).equals(jglx.getDm())){
                                                    out.print(jglx.getDm()+"&nbsp;("+jglx.getMc()+")");
                                                    break;
                                                 }
                                            }
                                        }
                                    }
                                %>
                        </TD>
                        <TD class=td1 colSpan=2>&nbsp;<%if("0".equals(tJgdm.getFkbz())){out.print("�ݲ�����");}%>
                            <%if("1".equals(tJgdm.getFkbz())){out.print("����");}%>&nbsp;����������<%=tJgdm.getFksl()%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������ƣ�
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJgmc())%>
                        </TD>
                        <TD class=td1 colSpan=2>&nbsp;���������� <%=tJgdm.getZbsl()==null?0:tJgdm.getZbsl()%>&nbsp;���������� <%=tJgdm.getFbsl()==null?0:tJgdm.getFbsl()%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ���˴���
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getFddbr())%>
                        </TD>
                        <TD class=td1 colSpan=2>&nbsp;<%
                                List<TZjlx> zjlxList = InitSysParams.tZjlxList;
                                if(zjlxList!=null&&zjlxList.size()>0){
                                    for(TZjlx zjlx : zjlxList){
                                        if(zjlx!=null){
                                            if(clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getZjlx())){
                                                out.print(zjlx.getMc()+"��");
                                                break;
                                            }
                                        }
                                    }
                                }
                            %>&nbsp;<%=clsStringTool.convertNull(tJgdm.getZjhm())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ӫ��Χ��
                        </TD>
                        <TD class=td1 colSpan=3 >
                            <%=clsStringTool.convertNull(tJgdm.getJyfw())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ������ҵ(2000��)��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getNjjhy())%>  (<%=InitSysParams.njjhyMap.get(tJgdm.getNjjhy())==null?"":InitSysParams.njjhyMap.get(tJgdm.getNjjhy())%>)

                        </TD>
                        <TD class=td1 align=right>
                             ��������(2000��)��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getNjjlx())%>  (<%=InitSysParams.njjlxMap.get(tJgdm.getNjjlx())==null?"":InitSysParams.njjlxMap.get(tJgdm.getNjjlx())%>)

                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ������ҵ(94��)��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJjhy())%>  (<%=InitSysParams.jjhyMap.get(tJgdm.getJjhy())==null?"":InitSysParams.jjhyMap.get(tJgdm.getJjhy())%>)
                        </TD>
                        <TD class=td1 align=right>
                            ��������(94��)��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJjlx())%>  (<%=InitSysParams.jjlxMap.get(tJgdm.getJjlx()==null?"":tJgdm.getJjlx().trim())==null?"":InitSysParams.jjlxMap.get(tJgdm.getJjlx().trim())%>)
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������ڣ�
                        </TD>
                        <TD class=td1>
                            <%=tJgdm.getZcrq()==null?"":tJgdm.getZcrq().toString().substring(0, 10)%>
                        </TD>
                        <TD class=td1 align=right>
                            ְ��������
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZgrs()))%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ���ܻ�����
                        </TD>
                        <td colspan="3">
                            <%=clsStringTool.convertNull(tJgdm.getZgdm())%>  (<%=tJgdm.getZgdm()==null||"".equals(tJgdm.getZgdm().trim())?"":(InitSysParams.zgjgMap.get(tJgdm.getZgdm().trim())==null?"":InitSysParams.zgjgMap.get(tJgdm.getZgdm().trim()))%>)
                        </td>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��׼������
                        </TD>
                        <TD class=td1 colspan="3">
                            <% Map<String,String> pzjgMap= InitSysParams.bzjgPzjgMaps.get(((User)session.getAttribute("sysUser")).getBzjgdm());%>
                            <%=clsStringTool.convertNull(tJgdm.getPzjgdm())%>  (<%=pzjgMap.get(tJgdm.getPzjgdm())==null?"":pzjgMap.get(tJgdm.getPzjgdm().trim())%>)
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ע���ʽ�
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZczj()))%>
                        </TD>
                        <TD class=td1 align=right>
                            �������ࣺ
                        </TD>
                        <TD class=td1>
                            <DIV>
                                <%
                                    List<THb> list = InitSysParams.thbList;
                                    if(list!=null&&list.size()>0){
                                        for(THb hb : list){
                                            if(hb!=null){
                                                if(clsStringTool.convertNull(hb.getDm()).equals(tJgdm.getHbzl())){
                                                    out.print(hb.getDm()+"&nbsp;("+hb.getMc()+")");
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
                           ����������
                        </TD>
                        <TD class=td1 colspan="3">
                            <%=clsStringTool.convertNull(tJgdm.getXzqh())%>  (<%=InitSysParams.xzqhMap.get(tJgdm.getXzqh())==null?"":InitSysParams.xzqhMap.get(tJgdm.getXzqh())%>)
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                             �ⷽ����
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getWftzgb())%>  (<%=tJgdm.getWftzgb()==null||tJgdm.getWftzgb().trim().equals("")?"":(InitSysParams.gjMap.get(tJgdm.getWftzgb())==null?"":InitSysParams.gjMap.get(tJgdm.getWftzgb()))%>)

                        </TD>
                        <TD class=td1 align=right>
                            EMAIL��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getEmail())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��λ��ַ��
                        </TD>
                        <TD class=td1 colSpan=3>
                            <%=clsStringTool.convertNull(tJgdm.getJgdz())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������룺
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getYzbm())%>
                        </TD>
                        <TD class=td1 align=right>
                            ��ϵ�绰��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getDhhm())%>
                        </TD>
                    </TR>

                    <TR>
                        <TD class=td1 align=right>
                            ע&nbsp;��&nbsp;�ţ�
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getZch())%>&nbsp;<font color="red">���ȣ�(<%=tJgdm.getZch()==null?"0":tJgdm.getZch().length()%>)</font>
                        </TD>
                        <TD class=td1 align=right>
                            �Ƿ񹫿���
                        </TD>
                        <TD class=td1>
                            <%if("1".equals(clsStringTool.convertNull(tJgdm.getGk()))){out.print("��");}%>
                            <%if("2".equals(clsStringTool.convertNull(tJgdm.getGk()))){out.print("��");}%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �״ΰ�֤��
                        </TD>
                        <TD class=td1>
                            <fmt:formatDate value="${tjgdm.scbzrq}" pattern="yyyy-MM-dd" />
                        </TD>
                        <TD class=td1 align=right>
                            ��֤���ڣ�
                        </TD>
                        <TD class=td1>
                            <%=tJgdm.getBzrq()==null?"":tJgdm.getBzrq().toString().substring(0,10)%>
                        </TD>

                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ������ޣ�
                        </TD>
                        <TD class=td1>
                            <%=tJgdm.getNjqx()==null?"":tJgdm.getNjqx().toString().substring(0,10)%>
                        </TD>
                        <TD class=td1 align=right>
                            �������ڣ�
                        </TD>
                        <TD class=td1>
                            <%=tJgdm.getZfrq()==null?"":tJgdm.getZfrq().toString().substring(0,10)%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �����ֻ���
                        </TD>
                        <TD class=td1>
                           <%=clsStringTool.convertNull(tJgdm.getMobile())%>
                        </TD>
                        <TD class=td1 align=right>
                            �� ַ��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getUrl())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ������������
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getTbrxm())%>
                        </TD>
                        <TD class=td1 align=right>
                            ֤�����룺
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getTbrsfzh())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������ֻ���
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getTbrlxfs())%>
                        </TD>
                        <TD class=td1 align=right>
                            ��Ӫ���ޣ�
                        </TD>
                        <TD class=td1>
                            <%=tJgdm.getGsfzrq()==null?"":tJgdm.getGsfzrq()%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ӫ��ַ��
                        </TD>
                        <TD class=td1 colSpan=3>
                            <%=clsStringTool.convertNull(tJgdm.getJydz())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ӫ�ʱࣺ
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJyyb())%>
                        </TD>
                        <TD class=td1 align=right>
                            ��Ӫ�绰��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJydh())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �������У�
                        </TD>
                        <TD class=td1 colSpan=3>
                            <%=clsStringTool.convertNull(tJgdm.getKhyh())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            �����˺ţ�
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getKhzh())%>
                        </TD>
                        <TD class=td1 align=right>
                            ������Դ��
                        </TD>
                        <TD class=td1>
                            <%=clsStringTool.convertNull(tJgdm.getJfly())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��&nbsp;ע2��
                        </TD>
                        <TD class=td1 colSpan=3>
                           <%=clsStringTool.convertNull(tJgdm.getMemo2())%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ҫ��Ʒ1��
                        </TD>
                        <TD class=td1 colspan="3">
                            <%=clsStringTool.convertNull(tJgdm.getZycp1())%> <%=tJgdm.getZycp1()==null||"".equals(tJgdm.getZycp1().trim())?"":(InitSysParams.zycpMap.get(tJgdm.getZycp1().trim())==null?"":InitSysParams.zycpMap.get(tJgdm.getZycp1().trim()))%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ҫ��Ʒ2��
                        </TD>
                        <TD class=td1 colspan="3">
                            <%=clsStringTool.convertNull(tJgdm.getZycp2())%> <%=tJgdm.getZycp2()==null||"".equals(tJgdm.getZycp2().trim())?"":(InitSysParams.zycpMap.get(tJgdm.getZycp2().trim())==null?"":InitSysParams.zycpMap.get(tJgdm.getZycp2().trim()))%>
                        </TD>
                    </TR>
                    <TR>
                        <TD class=td1 align=right>
                            ��Ҫ��Ʒ3��
                        </TD>
                        <TD class=td1 colspan="3">
                            <%=clsStringTool.convertNull(tJgdm.getZycp3())%> <%=tJgdm.getZycp3()==null||"".equals(tJgdm.getZycp3().trim())?"":(InitSysParams.zycpMap.get(tJgdm.getZycp3().trim())==null?"":InitSysParams.zycpMap.get(tJgdm.getZycp3().trim()))%>
                        </TD>
                    </TR>
                </TABLE>
            </div>
            <div class="listbtn">
                <INPUT class=btn2 <%--onClick="window.location.href='#'"--%> type=button value="��ӡ֤��" name="btok" />&nbsp;<INPUT class="newBtn1" onClick=" history.back()" type=button value="�� ��" name='cmdExit' />&nbsp;<a href="#">��ӡУ�Ե�</a>&nbsp;<a href="#">��ӡУ�Ե����</a>
            </div>
        </div>
    </div>
  </div>
</div>
</body>
<script>
(function() {
	var $backToTopTxt = "���ض���", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
		.text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
			$("html, body").animate({ scrollTop: 0 }, 120);
	}), $backToTopFun = function() {
		var st = $(document).scrollTop(), winh = $(window).height();
		(st > 0)? $backToTopEle.show(): $backToTopEle.hide();
		//IE6�µĶ�λ
		if (!window.XMLHttpRequest) {
			$backToTopEle.css("top", st + winh - 166);
		}
	};
	$(window).bind("scroll", $backToTopFun);
	$(function() { $backToTopFun(); });
})();
</script>
</html>
