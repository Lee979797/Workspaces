<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ninemax.jpa.code.model.*" %>
<%@ page import="net.sf.cglib.beans.BeanCopier" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<c:set var="zjlx" value="<%=InitSysParams.tZjlxList%>"/>
<c:set var="zList" value="<%= InitSysParams.zwList%>"/>
<c:set var="mList" value="<%= InitSysParams.mzList%>"/>
<c:set var="gList" value="<%= InitSysParams.gjList%>"/>
<c:set var="zzList" value="<%= InitSysParams.zzmmList%>"/>
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
        BeanCopier beanCopier = BeanCopier.create(TJgdm.class, TJgdmSave.class, false);
        beanCopier.copy(tjgdm, tJgdm, null);
    } else {
        tJgdm = (TJgdmSave) request.getAttribute("jgdmSave");
    }
    String btnName = "";
    if ("2".equals(formType)) {
        btnName = "校对赋码";
    } else {
        btnName = "校对赋码";
    }
    //页面请求来源 page来自单独页面 否则来自列表页面 单独页面的返回操作和列表页面返回操作不一样
    String path = request.getParameter("path");
    pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>选择办证机构</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="<%=request.getContextPath()%>/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/shadow.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type="text/javascript" src="/dwr/interface/tjgdmSaveBus.js"></script>
    <script type="text/javascript">
        function fm() {

            
   
                   
                  
       
              
                        window.location.href = '/bsweb/certificate_revision.action?djh=${djh}&ywlsh=${ywlsh}&id=<%=tJgdm.getId()%>&formType=<%=formType%>&type=<%=type%>&path=${path}&jglx=<%=jglx%>';
               
              
        
        }


        function del() {
            if (confirm("确认要删除？")) {
                window.location.href = '/bsweb/certificate_delete.action?id=<%=tJgdm.getId()==null?0:tJgdm.getId()%>&jgmc=<%=clsStringTool.convertNull(tJgdm.getJgmc())%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&jglx=<%=jglx%>';
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
                    window.location.href = '/bsweb/certificate_send.action?jgdm=<%=tJgdm.getJgdm()==null?0:tJgdm.getJgdm()%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}&reason=' + reason;
                }
            }
        }
        function delApplyForm() {
            if (confirm("确认要删除机构代码<%=tJgdm.getJgdm()%>？")) {
                window.location.href = '/bsweb/certificate_deleteApplyForm.action?jgdm=<%=tJgdm.getJgdm()==null?0:tJgdm.getJgdm()%>&formType=<%=formType%>&type=<%=type%>&pageno=${pageno}&rowNumsView=${rowNumsView}';
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
    <div align="left" style=" float: left;"><strong> 登记&gt;&gt; 
   <c:if test='${1 eq jglx}'>
   
 
    社会团体业务
    </c:if>
     <c:if test='${2 eq jglx}'>  
    民办非企业单位业务
  </c:if>
     <c:if test='${3 eq jglx}'>
    基金会业务
     </c:if>
      &gt;&gt; <%=title%>
    </strong>
    </div>
    <div align="right" style="width: 30% ; float: right;">
        <%--如果是其他部门赋码删除或者预赋码删除--%>
        <%
            if (!"4".equals(formType)) {
                if (("1".equals(type) && ("1".equals(delFlag))) || ("1".equals(type) && "0".equals(formType)) || ("1".equals(type) && "".equals(delFlag))) {
        %>
        <INPUT class="newBtn1" onClick="del();" type=button value="删 除" name="btok"/><%
        }
        if ("1".equals(type) && ("2".equals(delFlag) || "3".equals(delFlag))) {
    %>
        <INPUT class="newBtn1" onClick="send();" type=button value="发 送" name="btok"/>
        <%
            }
            if ("2".equals(type)) {
        %>
        <INPUT class="newBtn1" onclick="fm();" type=button value="<%=btnName%>" name="btok"/>
        <%
            }
        %>&nbsp;<INPUT class="newBtn1"
                       <c:if test="${path eq null}">onClick="history.back()"</c:if>
                       <c:if test="${path eq 'page'}">onClick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=${formType}'"</c:if>
                       type=button
                       value="返 回" name="cmdExit"/>
        <%}%>

        <%--申请表删除--%>
        <%
            if ("4".equals(formType)) {
                if ("2".equals(delFlag) || "3".equals(delFlag)) {
        %>
        <INPUT class="newBtn1" onClick="send();" type=button value="发 送" name="btok"/>
        <%
            }
            if ("1".equals(delFlag) || "".equals(delFlag)) {
        %>
        <INPUT class="newBtn1" onClick="delApplyForm();" type=button value="删 除" name="btok"/>
        <%
            }
        %><INPUT class="newBtn1" onClick="history.back()" type=button value="返 回" name="cmdExit"/>
        <%
            }
        %>&nbsp;</div>
</div>
<form method="post" action="/bsweb/certificate_revision.action" name="busForm">
    <input type="hidden" name="djh" value="${djh}" id="djh"/>
    <input type="hidden" name="ywlsh" value="${ywlsh}" id="ywlsh"/>
    <input type="text" name="id" value="${id}" id="id"/>
    <input type="hidden" name="formType" value="${formType}" id="formType"/>
    <input type="hidden" name="type" value="${type}" id="type"/>
    <input type="hidden" name="path" value="${path}" id="path"/>
    <input type="jglx" name="jglx" value="${jglx }">
    <input type="hidden" name="sslcode" id="sslcode"/>
</form>
<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <h3><b><%=title%>
                    </b></h3>
                    <TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%"
                           >
                        <%-- 如果其他部门赋码1，预赋码2,申请表单 4,删除 需要审核或审核未通过需要发送删除原因 --%>
                        <%
                            if (("1".equals(formType) || "2".equals(formType) || "4".equals(formType)) && ("2".equals(delFlag) || "3".equals(delFlag))) {
                        %>
                        <TR>
                            <TD class=td1 align=right>
                            </TD>
                            <TD class=td1 colspan="3">
                                <%=delMessage%>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=td1 align=right>删除原因：</TD>
                            <TD class=td1 colspan="3">
                                <TEXTAREA
                                        name="czreason" id="czreason" rows=3 cols=129 style="width:75%;"></TEXTAREA>
                            </TD>
                        </TR>
                        <%
                            }
                        %>
                        <%
                            if (("1".equals(formType) || "2".equals(formType) || "4".equals(formType)) && ("0".equals(delFlag))) {
                        %>
                        <TR>
                            <TD class=td1 align=right>
                            </TD>
                            <TD class=td1 colspan="3">
                                <%=delMessage%>
                            </TD>
                        </TR>
                        <%
                            }
                        %>
                        <%
                            if (("1".equals(formType) || "2".equals(formType) || "4".equals(formType)) && "1".equals(delFlag)) {
                        %>
                        <TR>
                            <TD class=td1 align=right>
                            </TD>
                            <TD class=td1 colspan="3">
                                <%=delMessage%>
                            </TD>
                        </TR>
                        <%
                            }
                        %>
                        <%
                            if ("1".equals(formType) || "2".equals(formType) || "4".equals(formType)) {
                        %>
                        <TR>
                            <TD class=td1 align=right>
                                机构代码：
                            </TD>
                            <TD class=td1 colspan="3">
                                <%=clsStringTool.convertNull(tJgdm.getJgdm())%>
                            </TD>
                        </TR>
                        <%
                            }
                        %>

                        <%@ include file="common_view.jsp" %>
                    </TABLE>
                </div>
                <c:set var="jglx" value="<%=tJgdm.getJglx() %>"/>
                <div id="dj" class="list listblue">
					<h3><b>党建信息	&nbsp;&nbsp;
					<c:set var="isdang" value="<%=tJgdm.getIsdang()%>"/>
					<c:if test="${isdang eq '0'}">
					 已建立党组织
					</c:if>
					<c:if test="${isdang eq '1'}">
					未建立党组织
					</c:if>
			         </b></h3>
					
				
				    
					<div id="dangjian" style="display:${isdang eq '0'?'':'none'}">
					<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
						<tr>
				    
				
				     <td class=td1  align=right>
				    	 党组织类型：
				    </td>
				    
				    <td class=td1 colSpan=3>
				     	
				     
				   <c:set var="dzzlx" value="<%=tJgdm.getDzzlx() %>"/>
				   <c:if test="${dzzlx eq '1'}">单独组建</c:if>
				   <c:if test="${dzzlx eq '2'}">联合组建:按行业组建</c:if>
				   <c:if test="${dzzlx eq '3'}">联合组建:按单位组建</c:if>
				   <c:if test="${dzzlx eq '4'}">联合组建:按区域组建</c:if>

				    </td>
				</TR>
				<tr>
				 <td class=td1 align=right>
				    	 党组织负责人：
				    </td>
				    
				    <td class=td1>
				     	 <%=clsStringTool.convertNull(tJgdm.getDzzfzr())%>
				     
				    </td>
				    <td class=td1 align=right>
				         &nbsp;<%
							         zjlxList = InitSysParams.tZjlxList;
							        if (zjlxList != null && zjlxList.size() > 0) {
							            for (TZjlx zjlx : zjlxList) {
							                if (zjlx != null) {
							                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getDzzfzrzjlx())) {
							                        out.print(zjlx.getMc() + "：");
							                        break;
							                    }
							                }
							            }
							        }
							    %>

				    </td>
				    
				    <td class=td1>
				     	
				     <%=clsStringTool.convertNull(tJgdm.getDzzfzrzjhm())%>

				    </td>
				</tr>
				<tr>
				 <td class=td1 align=right>
				    	 党建联系人：
				    </td>
				    
				    <td class=td1>
				     	
				          <%=clsStringTool.convertNull(tJgdm.getDjlxr())%>
				   
				    </td>
				    <td class=td1 align=right>
				    				         &nbsp;<%
							         zjlxList = InitSysParams.tZjlxList;
							        if (zjlxList != null && zjlxList.size() > 0) {
							            for (TZjlx zjlx : zjlxList) {
							                if (zjlx != null) {
							                    if (clsStringTool.convertNull(zjlx.getDm()).equals(tJgdm.getDjlxrzjlx())) {
							                        out.print(zjlx.getMc() + "：");
							                        break;
							                    }
							                }
							            }
							        }
							    %>
				    </td>
				    
				    <td class=td1>
				     	
				      <%=clsStringTool.convertNull(tJgdm.getDjlxrzjhm())%>

				    </td>
				</tr>
				<tr>
				     <td class=td1 align=right>
				       	党建联系人电话：
				    </td>
				    <td class=td1>
				     <%=clsStringTool.convertNull(tJgdm.getDjlxrdhhm())%>
				    </td>
				     <td class=td1 align=right>
				        	党组织成立时间：
				    </td>
				    <td class=td1>
				    <%=tJgdm.getDzzclrq() == null ? "" : tJgdm.getDzzclrq().toString().substring(0, 10)%>

				    </td>
				  
				    
				</TR>
				<tr>
					  <td class=td1 align=right>
				       	上级党组织名称：
				    </td>
				    <td class=td1  colSpan=3>
				    <%=clsStringTool.convertNull(tJgdm.getSjdzzmc())%>
				    </td>
				</tr>
				<tr>
				    
				    <td class=td1 align=right>
				       专职工作人员数量中党员数量：
				    </td>
				    <td class=td1>
				     <%=clsStringTool.convertNull(String.valueOf(tJgdm.getZzdysl()))%>
				    </td>
				     <td class=td1 align=right>
				    	兼职工作人员数量中党员数量：
				    </td>
				    
				    <td class=td1>
				     	
				      <%=clsStringTool.convertNull(String.valueOf(tJgdm.getJzdysl()))%>
				   
				    </td>
				</TR>
					</TABLE>
					</div>
					<div id="dangjianf" style="display:${isdang eq '1'?'':'none'}">
					<TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0" width="100%" bgcolor="#ffffff">
					<tr>
						<td class=td1 align=right>
						未建立原因：
						</td> 
						<td class=td1>
						<c:set var="wjlyy" value="<%=tJgdm.getWjlyy() %>"/>
						<c:if test="${wjlyy eq '1'}">符合建立党组织条件但尚未建立</c:if>
						<c:if test="${wjlyy eq '2'}">有党员但不符合建立条件</c:if>
						<c:if test="${wjlyy eq '3'}">无党员</c:if>
						</td>
					</tr>
					</TABLE>
					</div>
				</div>
				
				<div id="list_context" class="list listblue">
					<h3><b>负责人信息</b></h3>
					 <c:forEach var="list" items="${listFzr}">
					<div id="lizi" style=""> 
					<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
					<input type="hidden" name="fzr.id" value=""/>
						<tr>
							<td class=td1 align=right>
								姓名：
							</td>
							<td class=td1>
							${list.xm }
							</td>
							    <td class=td1 align="right">&nbsp;
							    	&nbsp;<%
							         zjlxList = InitSysParams.tZjlxList;
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
				   				</td>
						
						
							<td class=td1>
							${list.zjhm }
							</td>
						
						</tr>
						<tr>
							<td class=td1 align=right>
								性别：
							</td>
							<td class=td1>
							${list.xb}

							</td>
								<td class=td1 align=right>
								职务：
							</td>
							<td class=td1>
							
							<c:forEach items="${zList}" var="zw">
								<c:if test="${zw.dm eq list.zw and zw.jglx eq jglx}">
								${zw.mc }
								</c:if>
			       			 </c:forEach>

							</td>
							
						</tr>
						
						<tr>
						<td class=td1 align=right>
								民族：
							</td>
							<td class=td1>
							<c:forEach items="${mList}" var="mz">
								<c:if test="${mz.dm eq list.mz}">
								${mz.mc }
								</c:if>
			       			 </c:forEach>
			       			 
							</td>
							<td class=td1 align=right>
								国别：
							</td>
							<td class=td1>
						
						     <c:forEach items="${gList}" var="gj">
								<c:if test="${gj.dm eq list.gj}">
								${gj.mc }
								</c:if>
			       			 </c:forEach>
			       			 
							</td>
						
						</tr>
							<tr>
							<td class=td1 align=right>
								任职时间：
							</td>
							<td class=td1>
							<fmt:formatDate value='${list.rzsj}' pattern='yyyy-MM-dd' />
							</td>
								<td class=td1 align=right>
								政治面貌：
							</td>
							<td class=td1>
							 <c:forEach items="${zzList}" var="zz">
								<c:if test="${zz.dm eq list.zzmm}">
								${zz.mc }
								</c:if>
			       			 </c:forEach>

							</td>
							
						</tr>
							<tr>
								<td class=td1 align=right>
								工作单位：
							</td>
							<td class=td1>
							${list.dzdw }
							</td>
							<td class=td1 align=right>
								专职/兼职：
							</td>
							<td class=td1>
							<c:if test="${list.iszz eq '0'}">专职</c:if>
							<c:if test="${list.iszz eq '1'}">兼职</c:if>
							</td>
						</tr>
							<tr>
							<td class=td1 align=right>
								座机：
							</td>
							<td class=td1>
							${list.lxdh }
							</td>
								<td class=td1 align=right>
								手机：
							</td>
							<td class=td1>
							${list.lxmobile }
							</td>
						
						</tr>
						
						</tr>
							<tr>
							<td class=td1 align=right>
								通讯地址：
							</td>
							<td class=td1 colSpan=3>
							${list.txdz }
							</td>
						</tr>
					<tr>
					
							<td class=td1 align=right>
								邮编：
							</td>
							<td class=td1>
							${list.yb }
							</td>
							<td class=td1 align=right>
								电子邮箱：
							</td>
							<td class=td1>
							${list.email }
							</td>
						
						</tr>
				
						
					</table>
								<hr color="#88a6d4" width="80%" style="...."/>
				
				</div> 
					
					</c:forEach>
				 </div> 

                <div class="listbtn">
                    <%
                        if (!"4".equals(formType)) {
                            if (("1".equals(type) && ("1".equals(delFlag))) || ("1".equals(type) && "0".equals(formType)) || ("1".equals(type) && "".equals(delFlag))) {
                    %>
                    <INPUT class="newBtn1" onClick="del();" type=button value="删 除" name="btok"/>
                    <%
                        }
                        if ("1".equals(type) && ("2".equals(delFlag) || "3".equals(delFlag))) {
                    %>
                    <INPUT class="newBtn1" onClick="send();" type=button value="发 送" name="btok"/>
                    <%
                        }
                        if ("2".equals(type)) {
                    %>
                    <INPUT class="newBtn1" onClick="fm();"
                           type=button value="<%=btnName%>" name="btok"/>
                    <%
                        }
                    %>&nbsp;<INPUT class="newBtn1"
                                   <c:if test="${path eq null}">onClick="history.back()"</c:if>
                                   <c:if test="${path eq 'page'}">onClick="window.location.href='/product/jsp/certificate/addinfomationEnter.jsp?formType=${formType}'"</c:if>
                                   type=button
                                   value="返 回" name="cmdExit"/>
                    <%}%>

                    <%--申请表删除--%>
                    <%
                        if ("4".equals(formType)) {
                            if ("2".equals(delFlag) || "3".equals(delFlag)) {
                    %>
                    <INPUT class="newBtn1" onClick="send();" type=button value="发 送" name="btok"/>
                    <%
                        }
                        if ("1".equals(delFlag) || "".equals(delFlag)) {
                    %>
                    <INPUT class="newBtn1" onClick="delApplyForm();" type=button value="删 除" name="btok"/>&nbsp;<%
                    }
                %><INPUT class="newBtn1" onClick="history.back()" type=button value="返 回" name="cmdExit"/>
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
    <%
    Object msg = request.getAttribute("resultMsg");
    if(msg != null&&!"".equals(msg.toString().trim())){
         if("success".equals(msg.toString())){
    %>
    ymPrompt.succeedInfo('操作成功！', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}else if("NoCode".equals(msg.toString())){%>
    ymPrompt.alert('无可用的码段,请到国家中心下载码段!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}else if("CodeExist".equals(msg.toString())){%>
    ymPrompt.alert('机构代码已经存在，不能赋码!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}else if("DataWrong".equals(msg.toString())){%>
    ymPrompt.alert('数据不完整，请去预赋码颁证模块更新数据!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}else if("canNotFm".equals(msg.toString())){%>
    ymPrompt.alert({message: "系统限制机构赋码要到<%=DateUtil.dateToStr(DateUtil.dayAfter(tJgdm.getBzrq(), InitSysParams.system.getFmqx()))%>后才可办理！", width: 330, height: 220,
        slideShowHide: false, title: '提示信息'});
    <%}else{%>
    ymPrompt.alert('系统繁忙!请稍后再试!', 330, 220, '提示信息', function () {
        window.location.href = "/bsweb/certificate_list.action?formType=<%=formType%>";
    });
    <%}
        }
%>
</script>
</html>
