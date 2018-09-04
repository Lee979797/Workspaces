<%@ page import="java.util.Map" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="njjlxList" value="<%=InitSysParams.tnnJjlxList%>"/>
<c:set var="bzjgdmMap" value="<%=InitSysParams.bzjgdmMapMc1%>"/>
<%
    String formType2 = request.getParameter("formType");
%>
  <script type="text/javascript">
    	function hqGssj(){
        	var zch=$("#zch").val();
        	var jgmc="";
        if(zch!=""){
        	$.post("${pageContext.request.contextPath}/servlet/HqGssj_hzServlet?method=hqGssj",
    				{zch:encodeURIComponent(zch),jgmc:encodeURIComponent(jgmc)},
    				function (data){
    					if(data==2){
    	            		alert("未找到对应工商数据");
    	        		}else if(data==1){
    	        			alert("程序出错,请联系管理员!");
    	        		}else{
    	        			/*
    	        		     0QYMC,1GSZCH,2FDDBR,3FRSFZH,4ZCZB,5ZCDZ,6JYFW,7DJJG,8CLRQ,9HZRQ,10DHHM,JYQX1,JYQX2,UPDATETIME
    	        		     */
    		    			var dataObj=data.split("+-");
    		    			$("#jgmc").val(dataObj[0]);
    		    			$("#zch").val(dataObj[1]);
    		    			$("#fddbr").val(dataObj[2]);
    		    			$("#zjhm").val(dataObj[3]);
    		    			$("#zczj").val(dataObj[4]);
    		    			$("#jgdz").val(dataObj[5]);
    		    			$("#jyfw").val(dataObj[6]);
    		    			$("#jglx").val(dataObj[7]);
    		    			$("#zcrq").val(dataObj[8]);
    		    			$("#dhhm").val(dataObj[10]);
    		    			$("#gsfzrq").val(dataObj[12]);
    	        		}
    	    			
    			});
        }else{
            alert("注册号不能为空!");
        }

     }
    	
 </script>   




<TR>
    <TD class="td1" align="right" width="15%">
        名称
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
    
        <INPUT  onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength="120" size="28" name="jgmc" id="jgmc" value="<%=clsStringTool.convertNull(tJgdm.getJgmc())%>"
                style=" width:180%; position:absolute;" />
                  <span style="color:red;position:absolute; left:190%;">*</span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="mcInfo"></span>
       	<span style="color:red;" id="mcInfo"></span>
    </TD>
    <TD class="td1" align="right"></TD>
    <TD class="td1"></TD>
</TR>
<TR>
  <%
	if("2".equals(jglx)){
   %>
    <td class=td1 align=right>
       <SELECT name="fzxs" id="fzxs"/>
         <OPTION value="法定代表人" <%=("法定负责人").equals(tJgdm.getFzxs())?"selected":""%>>法定代表人</OPTION>
         <OPTION value="负责人" <%=("负责人").equals(tJgdm.getFzxs())?"selected":""%>>负责人</OPTION>
       </SELECT>
    </td>
    <%
    }else{
    %>

    <td class=td1 align=right>
     	  法定代表人
    </td> 
    <% 
    }
    %>
    <TD class="td1" >
        <INPUT
                onblur="this.className='input_off';trimIntputValue(this);return judgeFddbr();" maxLength="50" size="28"
                name="fddbr" id="fddbr" value="<%=tJgdm.getFddbr()==null?"":tJgdm.getFddbr()%>"

                style=" width:200px;"/>
                 <span style="color:red">*</span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="fddbrInfo"></span>
        

    </TD>
    <TD class="td1" align="right">
        <SELECT name="zjlx" id="zjlx"/>
        <%
            List<TZjlx> zjlxList = InitSysParams.tZjlxList;
            if (zjlxList != null && zjlxList.size() > 0) {
                for (TZjlx zjlx : zjlxList) {
                    if (zjlx != null) {
        %>
        <OPTION value="<%=zjlx.getDm()%>" <%
            if (zjlx.getDm().equals(tJgdm.getZjlx())) {
                out.print("selected");
            }
        %> >
            <%=zjlx.getMc()%>
        </OPTION>
        <% }
        }
        }
        %>
        </SELECT>
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
              onblur="this.className='input_off';trimIntputValue(this);return judgeFddbrZjh(${jglx });"
                onpaste=" showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('zjhm'), document.getElementById('zjhmlength'), 18);" name="zjhm"
                maxLength="18"
                id="zjhm" value="<%=tJgdm.getZjhm()==null?"":tJgdm.getZjhm()%>"
                style=" width:200px; float:left; margin-right:5px;"/>
                 <span style="color:red">*</span>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="zjhmInfo"></span>
           <INPUT class="num no-border-bx" id="zjhmlength"
               tabIndex=100 readOnly size=4 value="${18 - fn:length(jgdmSave.zjhm)}" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("zjhm"), document.getElementById("zjhmlength"), 18);
        </script>
    </TD>
</TR>
<tr>
	
        <TD class="td1" align="right">
        成立日期
    </TD>
    <TD class="td1">
        <INPUT 
               maxLength="10" size="23" onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')}); "onclick="WdatePicker({el:$dp.$('zcrq')});"
               name="tzcrq" id="zcrq" value="<%=tJgdm.getZcrq()==null?"":DateUtil.dateToStr(tJgdm.getZcrq())%>"
               style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true" />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zcrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
        </A>
         <span style="color:red">*</span>
    </TD>
      <TD class="td1" align="right">
        发证日期
    </TD>
    <TD class="td1">
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njfs}" id="njfs">
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njjzrq}" id="njjzrq">
         <INPUT 
               maxLength=10 size=23
               name="tbzrq" id="bzrq" onChange="changeBzrq(this);"
               value="<fmt:formatDate value='${tJgdm.bzrq}' pattern='yyyy-MM-dd' />"
              
               style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true" />
        <A hideFocus onclick="WdatePicker({el:$dp.$('bzrq')});"
           href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle border=0 name=popcal/>
        </A>
         <span style="color:red">*</span>
    </TD>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自
    </td>
    <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('yxqxs')}); "onclick="WdatePicker({el:$dp.$('yxqxs')});"
               maxLength=10 size=23
               name="tyxqxs" id="yxqxs" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true"
               value="<fmt:formatDate value='${tJgdm.yxqxs }' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('yxqxs')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
         <span style="color:red">*</span>
    </td>
   <TD class="td1" align="right">
        有效期限至
    </TD>
    <TD class="td1">
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')});"
               maxLength="10" size="23"
               name="tzfrq" id="zfrq" value="<%=zfDate%>" style="width:200px;BACKGROUND-COLOR: #e0e0e0;"  readonly="true"
               onclick="WdatePicker({el:$dp.$('zfrq')});"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});"
           href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
        </A>
         <span style="color:red">*</span>
    </TD>
</tr>
<TR>
    <TD class="td1" align="right">
      	 住所
    </TD>
    <TD class="td1" colSpan="3">
        <INPUT 
               maxLength="120" size="158"
               name="jgdz" id="jgdz" value="<%=tJgdm.getJgdz()==null?"":tJgdm.getJgdz()%>" style="width:75%;"/>
     <span style="color:red">*</span>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        住所行政区划
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);;" onblur="addYzbm()"
               maxLength="6" size="28"
               value="<%=tJgdm.getXzqh()==null?"":tJgdm.getXzqh()%>" name="xzqh" id="xzqh"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value="选择" name="btselect2"
               id="btselect2"/>&nbsp;
                <span style="color:red">*</span>
               <span style="position:absolute; top:25px; left:5px;"
                                           id="xzqh1"><%=InitSysParams.xzqhMap.get(tJgdm.getXzqh()) == null ? "" : InitSysParams.xzqhMap.get(tJgdm.getXzqh())%></span>
    </TD>
      <%
    if("3".equals(jglx)){
    %>
           <td class=td1 align=right>
             基金会类型
    </td>
      <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jjhlx" id="jjhlx" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${fn:trim(jjlx.dm) == fn:trim(tJgdm.jjhlx)?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
            <span style="color:red">*</span>
    </TD>
 <%
    }
   %>
   <%
	if("1".equals(jglx)){
%>
   <td class=td1 align=right>
   活动地域
    </td>
    <%-- 以下原版的活动地域，默认取登录用户的办证机构代码进行读取
    <td class=td1>
        <INPUT 
               maxLength=120 size="158"
               name="hddy" id="hddy" value="${bzjgdmMap[fn:trim(sysUser.bzjgdm)]}" style="width:200px;BACKGROUND-COLOR: #e0e0e0;" />
                <span style="color:red">*</span>
    </td> --%>
    <!-- xiaruibo 20170627 将原版活动地域改为默认取当前数据的活动地域，而不用登录用户的办证机构代码去取了 -->
    <td class=td1>
        <INPUT 
               maxLength=120 size="158"
               name="hddy" id="hddy" value="<%=tJgdm.getHddy()==null?"":tJgdm.getHddy()%>" style="width:200px;BACKGROUND-COLOR: #e0e0e0;" />
                <span style="color:red">*</span>
    </td>
   
     <%
	}
%>
   <%
	if("2".equals(jglx)){
%>
	<TD class="td1" align="right">
        	登记类型
    </TD>
  
  <TD class="td1" style="position:relative;display:block;overflow:visible;">
      <SELECT name="jjlx2011" id="jjlx2011" style="width:200px"/>
        <c:forEach items="${jjlx}" var="jjlx">
            <OPTION value="${jjlx.dm}" ${fn:trim(jjlx.dm) == fn:trim(tJgdm.jjlx2011)?"selected":""} >${jjlx.mc} </OPTION>
        </c:forEach>
        </SELECT>
         <span style="color:red">*</span>
    </TD>
   <%
	 }
  %>
</TR>

<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  start -->
<TR>
	<td class="td1" align="right">是否为慈善组织</td>
	<td class="td1" align="left">
		<SELECT name="cishan">
			<OPTION value="2" ${'2' eq tJgdm.cishan?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq tJgdm.cishan?"selected":""}>是</OPTION>
		</SELECT>
	</td>
	<td class="td1" align="right">是否取得募捐资格</td>
	<td class="td1" align="left">
		<SELECT name="mujuan">
			<OPTION value="2" ${'2' eq tJgdm.mujuan?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq tJgdm.mujuan?"selected":""}>是</OPTION>
		</SELECT>
	</td>
</TR>
<%
	if("1".equals(jglx)){
   %>
<TR>
	<td class="td1" align="right">是否为脱钩单位</td>
	<td class="td1" align="left">
		<SELECT name="tuogou">
			<OPTION value="2" ${'2' eq tJgdm.tuogou?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq tJgdm.tuogou?"selected":""}>是</OPTION>
		</SELECT>
	</td>
	<td class="td1" align="right"></td>
	<td class="td1" align="left"></td>
</TR>
   <%
	}
   %>
<!-- xiaruibo 20170220 是否脱钩  是否慈善 是否募捐  end -->

	
<!-- lvwei  20170420  直接登记类型  start -->
<TR>
	<td class="td1" align="right">直接登记类型</td>
	<td class="td1" align="left">
		<SELECT name="zjdjlx">
<c:if test="${'1' eq jglx}">
			<OPTION value="1" ${'1' eq tJgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq tJgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>
			<OPTION value="3" ${'3' eq tJgdm.zjdjlx?"selected":""}>行业协会商会类直接登记</OPTION>
			<OPTION value="4" ${'4' eq tJgdm.zjdjlx?"selected":""}>科技类直接登记</OPTION>
			<OPTION value="5" ${'5' eq tJgdm.zjdjlx?"selected":""}>社区服务类直接登记</OPTION>
			<OPTION value="6" ${'7' eq tJgdm.zjdjlx?"selected":""}>其他类直接登记</OPTION>
</c:if>
<c:if test="${'2' eq jglx}">
			<OPTION value="1" ${'1' eq tJgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq tJgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>
			<OPTION value="4" ${'4' eq tJgdm.zjdjlx?"selected":""}>科技类直接登记</OPTION>
			<OPTION value="5" ${'5' eq tJgdm.zjdjlx?"selected":""}>社区服务类直接登记</OPTION>
			<OPTION value="6" ${'7' eq tJgdm.zjdjlx?"selected":""}>其他类直接登记</OPTION>
</c:if>
<c:if test="${'3' eq jglx}">
			<OPTION value="1" ${'1' eq tJgdm.zjdjlx?"selected":""}>非直接登记类</OPTION>
			<OPTION value="2" ${'2' eq tJgdm.zjdjlx?"selected":""}>公益慈善类直接登记</OPTION>
</c:if>
		</SELECT>
	</td>
<td class="td1" align="right">是否为志愿组织</td>
	<td class="td1" align="left">
		<SELECT name="zhiyuan">
			<OPTION value="2" ${'2' eq tJgdm.zhiyuan?"selected":""}>否</OPTION>
			<OPTION value="1" ${'1' eq tJgdm.zhiyuan?"selected":""}>是</OPTION>
		</SELECT>
	</td>
</TR>
<!-- lvwei  20170420  直接登记类型  end -->




<TR>
    <TD class="td1" align="right">
        业务范围
    </TD>
    <TD class="td1" colSpan="3">
        <TEXTAREA onblur="trimIntputValue(this);"
                  name="jyfw" id="jyfw"
                  rows="3" cols="129"
                  style="width:75%;margin-top:3px;"><%=tJgdm.getJyfw() == null ? "" : tJgdm.getJyfw().trim()%>
        </TEXTAREA>
         <span style="color:red">*</span>
            <INPUT class="num no-border-bx" id="jyfwlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("jyfw"), document.getElementById("jyfwlength"), 0);
        </script>
    </TD>
</TR>
<TR>

        <TD class="td1" align="right">
        法定代表人手机
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="11" size="28" name="mobile" id="mobile"
         onpaste=" showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('mobile'), document.getElementById('mobilelength'), 18);"
                value="<%=tJgdm.getMobile()==null?"":tJgdm.getMobile()%>" style=" width:200px;"/>
        ${empty requireds['mobile']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
                <INPUT class="num no-border-bx" id="mobilelength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("mobile"), document.getElementById("mobilelength"), 0);
        </script>
    </TD>
    <td class=td1 align=right>
            法定代表人座机
    </td>
     <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
 			 onpaste="showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('frdhhm'), document.getElementById('frdhhmlength'), 18);"
               maxLength="25" size="28" name="frdhhm" id="frdhhm"
               style=" width:200px;" value="${tJgdm.frdhhm}"/>
        ${empty requireds['frdhhm']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="mobile_warning"></span>
                 <INPUT class="num no-border-bx" id="frdhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("frdhhm"), document.getElementById("frdhhmlength"), 0);
        </script>
    </TD>
</TR>
<TR>
    <TD class="td1" align="right">
        注册资金
    </TD>
    <TD class="td1">
        <INPUT onkeyup="zczjNumber(this);" onafterpaste="zczjNumber(this);"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength="14" size="22"
               name="zczj" id="zczj"
               value="<fmt:formatNumber value='<%=tJgdm.getZczj()==null?0:tJgdm.getZczj()%>' pattern="0.0000"/>"
               style=" width:200px;/>
        <FONT color="red">
            万元
        </FONT>
         <span style="color:red">*</span>
    </TD>
    <TD class="td1" align="right">
        货币种类
    </TD>
    <TD class="td1">
        <DIV>
            <SELECT name="hbzl" id="hbzl" style=" width:200px;">
               <OPTION value="156">156:人民币</OPTION>
            </SELECT>
             <span style="color:red">*</span>
        </DIV>
    </TD>
</TR>
<TR>
    <TD class=td1 align=right>
        经济行业
    </TD>
    <TD class=td1 style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength=6 size=23
               name="jjhy2011" id="nnjjhy" value="${fn:trim(tJgdm.jjhy2011)}"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class=button onClick="return selectUpWindow('t_nnjjhy');" type=button
               value=选择 name=btselect4/>&nbsp;
                <span style="color:red">*</span>
               <span style="position:absolute; top:25px; left:5px;" id="nnjjhy1"></span>
    </TD>
<td class=td1 align=right>
        批准文号
    </td>
    <td  class=td1>
        <input  
        		onblur="this.className='input_off';trimIntputValue(this);return judgeCodeZch();"
                maxlength="70" size=28 name="zch" id="zch" value="${tJgdm.zch}" style=" width:200px;"/>
  	<span style="color:red;" id="zchInfo"></span>
    </td>
</TR>

<TR>
    <TD class="td1" align="right">
        邮政编码
    </TD>
    <TD class="td1">
        <INPUT
               
                onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);;"
                maxLength="6" size="28" name="yzbm" id="yzbm" value="<%=tJgdm.getYzbm()==null?"":tJgdm.getYzbm().trim()%>"
                style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </TD>
    <TD class="td1" align="right">
        单位联系电话
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="25" size="19" name="dhhm" id="dhhm" value="<%=tJgdm.getDhhm()==null?"":tJgdm.getDhhm()%>"
         onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
               style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                   <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </TD>
</TR>
<TR>
    <td class=td1 align=right>
        	电子邮箱
    </td>
   <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
              
               maxLength="50" size="19"
               name="email" id="email" value="${tJgdm.email}" style=" width:200px;"/>
        ${empty requireds['email']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000" id="email_warning" style="position:absolute; top:25px; left:5px;"></span>
    </TD>
    <td class=td1 align=right>
        网址
    </td>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT
             
               maxLength="50"
               size="19"
               name="url" id="url" value="${tJgdm.url}" style=" width:200px;"/>
        ${empty requireds['url']?'':'<span class="required">*</span>'}
        <span style="color: #ff0000;position:absolute; top:25px; left:5px;" id="url_warning"></span>
    </TD>
   
</TR>
<TR>
   <TD class="td1" align="right" width="15%">
        业务主管单位名称
    </TD>
    <TD class="td1">
        <INPUT maxLength="200" size="28"
               name="zgmc" id="zgmc"
               value="${fn:trim(tJgdm.zgmc)}"
               style=" width:200px;"/>
               <INPUT class="button" onClick="addZgdm()" type="button" value=查询
               name="btselect2"/>&nbsp;
        ${empty requireds['zgmc']?'':'<span class="required">*</span>'}
    </TD>
   <TD class="td1" align="right" width="15%">
        业务主管单位代码
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyNumber(this);" maxLength="18" size="28"
               name="zgdm" id="zgdm" style="z-index: 100; position: relative; width:200px;"
               value="${fn:trim(tJgdm.zgdm)}"/>
               <INPUT class="button" onClick="addZgmc()" type="button" value=查询
               name="btselect2"/>&nbsp;
        ${empty requireds['zgdm']?'':'<span class="required">*</span>'}
        &nbsp;<span
            style="position:absolute; top:25px; left:5px;" id="zgjgdmInfo"></span>

    </TD>
 
</TR>
<TR>
    <td class=td1 align=right>
        	专职工作人员数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="zzrysl" id="zzrysl"
                style=" width:200px;" value="${tJgdm.zzrysl}"/>
    </td> 
   
 
     <td class=td1 align=right>
        兼职工作人员数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jzrysl" id="jzrysl"
          style=" width:200px;" value="${tJgdm.jzrysl}"/>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19  name="lssl"
               id="lssl" style=" width:200px;" value="${tJgdm.lssl}"/>
                <span style="color:red">*</span>
    </td> 
   
 
     <td class=td1 align=right>
           监事人数
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="jssl" id="jssl"
              style=" width:200px;" value="${tJgdm.jssl}"/>
    </td>
</TR>
   <%
	if("1".equals(jglx)){
%>
   <TR>
    <td class=td1 align=right>
        	常务理事人数
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="cwlssl"
               id="cwlssl" style=" width:200px;" value="${tJgdm.cwlssl}"/>
    </td> 
   
 
</TR>
<TR>
    <td class=td1 align=right>
        	社团会员（单位会员）数量
    </td>
    <td class=td1>
       <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="dwhysl" id="dwhysl"
            style=" width:200px;" value="${tJgdm.dwhysl}"/>
    </td> 
   
 
     <td class=td1 align=right>
        社团会员（个人会员）数量
    </td>
    <td class=td1>
        <INPUT onkeyup="onlyNumber(this);" onafterpaste="onlyNumber(this);;"
               onblur="this.className='input_off';trimIntputValue(this);"
               maxLength=6 size=19 name="grhysl" id="grhysl"
               style=" width:200px;" value="${tJgdm.grhysl}"/>
    </td>
</TR>
<%
	}
%>
<tr>
   <td class=td1 align=right>
        	经办人姓名
    </td>
    <td class=td1>
        <input name="tbrxm" id="tbrxm" type="text"  style="z-index: 100; position: relative; width:200px;"
               value="${tJgdm.tbrxm }" maxLength="60">
                  <INPUT class="button" onClick="copy()" type="button" value=复制
               name="btselect2"/>&nbsp;
       <span style="color:red">*</span>
    </td>
      <td class=td1 align=right>
      <SELECT name="tbrzjlx" id="tbrzjlx"/>
   
           <c:forEach items="${zjlxList}" var="zjlx">
            <OPTION value="${zjlx.dm}" ${tJgdm.tbrzjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
        </c:forEach>
       
        </SELECT>
    </td>
       <td class=td1>
        <input name="tbrsfzh" id="tbrsfzh" type="text"  style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);"
               value="${tJgdm.tbrsfzh }" maxLength="18">
       <span style="color:red">*</span>
                  <INPUT class="num no-border-bx" id="tbrsfzhlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrsfzh"), document.getElementById("tbrsfzhlength"), 0);
        </script>
    </td>
  
</tr>


 

<tr>
 <td class=td1 align=right>
        	经办人手机
    </td>
    <td class=td1>
        <input name="tbrmobile" id="tbrmobile" type="text"  style="z-index: 100; position: relative; width:200px;"
          onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
               value="${tJgdm.tbrmobile }" maxlength="11">
        <span id="pzjginfo"></span>
                        <INPUT class="num no-border-bx" id="tbrmobilelength"
                     
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrmobile"), document.getElementById("tbrmobilelength"), 0);
        </script>
    </td>
   
	 <td class=td1 align=right>
        	经办人座机
    </td>
    <td class=td1>
        <input name="tbrlxfs" id="tbrlxfs" type="text"  style="z-index: 100; position: relative; width:200px;"
          onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               value="${tJgdm.tbrlxfs }" maxLength="25">
        <span id="pzjginfo"></span>
                          <INPUT class="num no-border-bx" id="tbrlxfslength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrlxfs"), document.getElementById("tbrlxfslength"), 0);
        </script>
       
    </td>
</TR>
<tr>
 <td class=td1 align=right>
        	开户银行
    </td>
    <td class=td1>
        <input name="khyh" id="khyh" type="text"  style="z-index: 100; position: relative; width:200px;"
      
               value="${tJgdm.khyh }" maxlength="200">
    
        
    </td>
   
	 <td class=td1 align=right>
        	开户账号
    </td>
    <td class=td1>
        <input name="kyzh" id="kyzh" type="text"  style="z-index: 100; position: relative; width:200px;"
          onkeyup="onlyDecimalTel(this);"
               value="${tJgdm.kyzh }" maxLength="50">
   
             
        
    </td>
</TR>
<tr>

    <td class=td1 align=right>
        	备注
    </td>
    <td class=td1 colSpan=3>
        <input name="memo" id="memo" type="text"  style="width:75%;"
               value="${tJgdm.memo }">
        <span id="pzjginfo"></span>
    </td>
    </tr>
