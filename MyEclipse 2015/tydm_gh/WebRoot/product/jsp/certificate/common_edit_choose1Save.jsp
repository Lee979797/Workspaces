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


<TR>
    <TD class="td1" align="right" width="15%">
        工会名称
    </TD>
    <TD class="td1" colspan="3">
        <INPUT onblur="this.className='input_off';return judgeCodeName();"
               maxLength="120" size="28" name="jgdm.jgmc" id="jgmc" value="${tJgdm.jgmc}"
               style="width:75%;"/>
        <span style="color:red;" id="mcInfo"></span>
    </TD>
</TR>
<TR>
    <td class=td1 align=right width="15%">
          办公地址
    </td>
     <td class=td1 colspan="3" >
        <INPUT onkeyup="onlyMc(this);"
                onblur="this.className='input_off';trimIntputValue(this);return judgeCodeName();"
                maxLength=240 size=28 name="jgdm.jgdz" id="jgdz" style="width:75%;"
                value="${tJgdm.jgdz}"/>
        <span style="color:red;" id="mcInfo"></span>
    </td>
  
</TR>
<tr>
	<TD class="td1" align="right">
       行政区划
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);" onblur="addYzbm()"
               maxLength="6" size="28"
               value="${fn:endsWith(source,'in')?'': fn:trim(tJgdm.xzqh)}" name="jgdm.xzqh" id="xzqh"
               style="z-index: 100; position: relative; width:200px;"/>
        <INPUT class="button" onClick="return selectUpWindow('xzqh');" type="button" value=选择
               name="btselect2"/>&nbsp;
               <span
            style="position:absolute; top:25px; left:5px;"
            id="xzqh1">${xzqhMap[fn:trim(tJgdm.xzqh)]==null?"":xzqhMap[fn:trim(tJgdm.xzqh)]}</span>
    </TD>
       <TD class="td1" align="right">
        邮政编码
    </TD>
    <TD class="td1">
        <INPUT 
               onkeyup="onlyDecimalZero(this);" onafterpaste="onlyDecimalZero(this);"
               maxLength="6" size="28" name="jgdm.yzbm" id="yzbm" value="${tJgdm.yzbm}" style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="postInfo"></span>
    </TD>
</tr>
<tr>

        <TD class="td1" align="right">
        成立日期
    </TD>
    <TD class="td1">
        <INPUT 
               maxLength="10" size="23" onfocus="this.className='input_on';WdatePicker({el:$dp.$('zcrq')}); "onclick="WdatePicker({el:$dp.$('zcrq')});"
               name="jgdm.zcrq" id="zcrq"
               value="<fmt:formatDate value='${tJgdm.zcrq}' pattern='yyyy-MM-dd'/>"
               style=" width:200px;" />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zcrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align="absMiddle" name="popcal"/>
        </A>
    </TD>
      <TD class="td1" align="right">
        发证日期
    </TD>
    <TD class="td1">
        <c:set var="date" value="<%=new Date()%>"/>
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njfs}" id="njfs">
        <input type="hidden" value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njjzrq}" id="njjzrq">
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('bzrq')});"
                maxLength="10" size="23"
                onChange="changeBzrq(this);" name="jgdm.bzrq" id="bzrq" 
                value="<fmt:formatDate value='${tJgdm.bzrq}' pattern='yyyy-MM-dd'/>"
                style=" width:200px;"/>
           <A hideFocus onclick="WdatePicker({el:$dp.$('bzrq')});"
              href="javascript:void(0)">
               <IMG src="/images/icon_rili.gif" align="absMiddle" border="0" name="popcal"/>
           </A>
    </TD>
</tr>
<tr>

     <td class=td1 align=right>
       有效期限自
    </td>
    <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('yxqxs')}); "onclick="WdatePicker({el:$dp.$('yxqxs')});"
               maxLength=10 size=23
               name="jgdm.yxqxs" id="yxqxs" style=" width:200px;"
               value="<fmt:formatDate value='${tJgdm.yxqxs}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('yxqxs')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>
   <td class=td1 align=right >
        有效期限至
    </td>
    <td class=td1>
    <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('zfrq')}); "onclick="WdatePicker({el:$dp.$('zfrq')});"
               maxLength=10 size=23
               name="jgdm.yxqxe" id="zfrq" style=" width:200px;"
               value="<fmt:formatDate value='${tJgdm.yxqxe}' pattern='yyyy-MM-dd'/>"
               />
        <A hideFocus onclick="WdatePicker({el:$dp.$('zfrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>
</tr>
<!-- <tr>
       <td class=td1 align=right>
        批复建立工会文号
    </td>
    <td class=td1>
        <input name="jlwh" id="jlwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.jlwh }">
        <span id="pzjginfo"></span>
    </td>
    <td class=td1 align=right>
        审批日期
    </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('jlrq')}); "onclick="WdatePicker({el:$dp.$('jlrq')});"
               maxLength=10 size=23
               name="tjlrq" id="jlrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdm.jlrq }' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('jlrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>

</TR>
      <td class=td1 align=right>
        批复选举结果文号
    </td>
    <td class=td1>
        <input name="xjwh" id="xjwh" type="text" maxLength=150 style="z-index: 100; position: relative; width:200px;"
               value="${jgdm.xjwh }">
        <span id="pzjginfo"></span>
    </td>
    <td class=td1 align=right>
        审批日期
    </td>
     <td class=td1>
        <INPUT onfocus="this.className='input_on';WdatePicker({el:$dp.$('xjrq')}); "onclick="WdatePicker({el:$dp.$('xjrq')});"
               maxLength=10 size=23
               name="txjrq" id="xjrq" style=" width:200px;BACKGROUND-COLOR: #e0e0e0;"
               value="<fmt:formatDate value='${jgdm.xjrq}' pattern='yyyy-MM-dd'/>"
                readonly="true"/>
        <A hideFocus onclick="WdatePicker({el:$dp.$('xjrq')});" href="javascript:void(0)">
            <IMG src="/images/icon_rili.gif" align=absMiddle name=popcal/>
        </A>
    </td>

</TR>
 -->

<TR>
 
    <TD class="td1" align="right">
      电话
    </TD>
    <TD class="td1" style="position:relative;display:block;overflow:visible;">
        <INPUT maxLength="25" size="19" name="jgdm.dhhm" id="dhhm" value="${tJgdm.dhhm}" 
          onpaste=" showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('dhhm'), document.getElementById('dhhmlength'), 18);"
        style=" width:200px;"/>
        <span style="color:red;position:absolute; top:25px; left:5px;" id="telInfo"></span>
                      <INPUT class="num no-border-bx" id="dhhmlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("dhhm"), document.getElementById("dhhmlength"), 0);
        </script>
    </TD>
<%--     <td class=td1 align=right>
         承担民事责任能力状况
    </td>
   	<td class=td1 >
				<SELECT name="jgdm.cdnl" id="cdnl">
				<OPTION value="能" ${tJgdm.cdnl eq '0'?"selected":""}>能 </OPTION>
				<OPTION value="否" ${tJgdm.cdnl eq '1'?"selected":""}>否</OPTION>
				</SELECT>
	</td> --%>
</TR>
<tr>
    
    <td class=td1 align=right>
        	经办人姓名
    </td>
    <td class=td1>
        <input name="jgdm.tbrxm" id="tbrxm" type="text" maxLength="60"  style="z-index: 100; position: relative; width:200px;"
               value="${tJgdm.tbrxm }">
    </td>
     <td class=td1 align=right>
      <SELECT name="jgdm.tbrzjlx" id="tbrzjlx"/>
   
         <c:forEach items="${zjlxList}" var="zjlx">
            <OPTION value="${zjlx.dm}" ${tJgdm.tbrzjlx==zjlx.dm?"selected":""} >${zjlx.mc} </OPTION>
        </c:forEach>
       
        </SELECT>
    </td>
    
    <td class=td1>
        <input name="jgdm.tbrsfzh" id="tbrsfzh" type="text"  style="z-index: 100; position: relative; width:200px;" maxLength="18"
         onpaste=" showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);" onkeyup="onlySfzh(this);showLength(document.getElementById('tbrsfzh'), document.getElementById('tbrsfzhlength'), 18);"
               value="${tJgdm.tbrsfzh }">
         <span style="color:red">*</span>
                       <INPUT class="num no-border-bx" id="tbrsfzhlength"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrsfzh"), document.getElementById("tbrsfzhlength"), 0);
        </script>
    </td>
</TR>
<TR>
    <td class=td1 align=right>
        	经办人手机
    </td>
    <td class=td1>
        <input name="jgdm.tbrmobile" id="tbrmobile" type="text" maxLength="11"  
        onpaste=" showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrmobile'), document.getElementById('tbrmobilelength'), 18);"
        style="z-index: 100; position: relative; width:200px;"
               value="${tJgdm.tbrmobile }">
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
        <input name="jgdm.tbrlxfs" id="tbrlxfs" type="text" maxLength="25"  style="z-index: 100; position: relative; width:200px;"
         onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="onlyDecimalTel(this);showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               value="${tJgdm.tbrlxfs }">
        <span id="pzjginfo"></span>
                          <INPUT class="num no-border-bx" id="tbrlxfslength"
                      onpaste=" showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);" onkeyup="showLength(document.getElementById('tbrlxfs'), document.getElementById('tbrlxfslength'), 18);"
               tabIndex=100 readOnly size=4 value="0" name="charsmonitor"/>
        <script type="text/javascript">
            showLength(document.getElementById("tbrlxfs"), document.getElementById("tbrlxfslength"), 0);
        </script>
    </td>
</TR>
<tr>

    <td class=td1 align=right>
        	备注
    </td>
    <td class=td1 colSpan=3>
        <input name="jgdm.memo" id="memo" size="158" type="text"  style="width:75%;"
            maxLength="500"   value="${tJgdm.memo }">
        <span id="pzjginfo"></span>
    </td>
</tr>