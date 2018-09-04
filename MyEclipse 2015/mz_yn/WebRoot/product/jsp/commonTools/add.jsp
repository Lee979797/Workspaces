<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
    String maxLen = "";
    String mcLen = "20";
    String tableName = (String) request.getAttribute("table");
    if ("t_pzjg".equals(tableName) || "sc_jglx_pzjg".equals(tableName) || "t_zgjg".equals(tableName)) {
        maxLen = "6";
        mcLen = "35";
    } else if ("sc_xzqh1".equals(tableName)) {
        maxLen = "6";
    } else if ("sc_gj".equals(tableName) || "t_hb".equals(tableName) || "t_jjlx".equals(tableName) || "t_njjlx".equals(tableName) || "sc_lx".equals(tableName)) {
        maxLen = "3";
    } else {
        maxLen = "5";
    }
%>
<c:set var="jglxList" value="<%=InitSysParams.tjglxList%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <title>home</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type='text/javascript' src='/dwr/interface/standardBus.js'></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/js/tools.js'></script>
    <script type="text/javascript">
        function rightValues(obj) {
            if (event.keyCode == "35" ||
                    event.keyCode == "36" ||
                    event.keyCode == "37" ||
                    event.keyCode == "38" ||
                    event.keyCode == "39" ||
                    event.keyCode == "40") {
                return;
            }

            if (!(obj && obj.value && obj.value.length > 0 && !/^[A-Z0-9]{1,9}$/.test(obj.value))) {
            } else {
                obj.value = obj.value.trim().toUpperCase();
                obj.value = obj.value.replace(/[^A-Z0-9]/gm, "");
                obj.focus();
            }
        }
        function checkDM() {
            var table = $("#table");
            var dm = document.getElementById("dm").value;
            var flag = true;
            var promptName = '标准代码';
            if (table.val() == 't_pzjg' || table.val() == 'sc_jglx_pzjg') {
                promptName = '批准代码';
            }
            if (table.val() == 't_zgjg') {
                promptName = '主管代码';
            }
            if ("" == dm) {
                $("#dm_prop").html("<span style='color: #ff0000'>请输入" + promptName + "！</span>");
                return false;
            }
            dwr.engine.setAsync(false);
            if ( table.val() == 't_zgjg' || table.val() == 'sc_jglx_pzjg') {
                codecheck.isCheckCode(dm, function (value) {
                    if (value != true) {
                        $("#dm_prop").html("<span style='color: #ff0000'>" + promptName + "格式不正确！</span>");
                        flag = false;
                    } else {
                        flag = true;
                    }
                });
            }
            if (flag) {
                if ("" != dm) {
                    if (table.val() != 'sc_jglx_pzjg' && table.val() != 't_pzjg') {
                        standardBus.isExitDM(table.val(), dm, function (data) {
                            flag = data;
                        });
                    } else {
                        flag = false;
                    }
                } else {
                    $("#dm_prop").html("<span style='color: #ff0000'>请输入" + promptName + "！</span>");
                    return false;
                }
                if (flag) {
                    $("#dm_prop").html("<span style='color: #ff0000'>" + promptName + "已经存在请重新输入！</span>");
                    return false;
                } else {
                    $("#dm_prop").html("<span style='color: green'>" + promptName + "可以使用！</span>");
                    return true;
                }
            } else
                return false;

        }
        function checkMC() {
            var table = $("#table");
            var mc_prop = $("#mc_prop");
            var mc = document.getElementById("mc").value;
            var flag=false;
            var promptName = '标准名称';
            if (table.val() == 't_pzjg' || table.val() == 'sc_jglx_pzjg') {
                promptName = '批准机构名称';
            }
            if (table.val() == 't_zgjg') {
                promptName = '主管机构名称';
            }
            if ("" == mc) {
                mc_prop.html("<span style='color: #ff0000'>请输入" + promptName + "！</span>");
                return false;
            }
            dwr.engine.setAsync(false);
            if ("" != mc) {
          
            if (table.val() != 't_pzjg') {
                    standardBus.isExitName(table.val(), mc, function (data) {
                        flag = data;
                    });
         
            }
                

            } else {
                mc_prop.html("<span style='color: #ff0000'>请输入" + promptName + "！</span>");
                return false;
            }
            if (flag) {
                mc_prop.html("<span style='color: #ff0000'>" + promptName + "已经存在请重新输入！</span>");
                return false;
            } else {
                mc_prop.html("<span style='color: green'>" + promptName + "可以使用！</span>");
                return true;
            }
        }
        function checkZfdm() {
            var zf = document.getElementById("zfdm");
            if (zf == null || zf == 'null') {
                return true;
            } else {
                var zfdm = zf.value;
                var flag;
                dwr.engine.setAsync(false);
                if ("" != zfdm) {
                    standardBus.isExitGbJc(table.val(), zfdm, function (data) {
                        flag = data;
                    });
                } else {
                    $("#zfdm_prop").html("<span style='color: #ff0000'>请输入国别简称！</span>");
                    return false;
                }
                if (flag) {
                    $("#zfdm_prop").html("<span style='color: #ff0000'>国别简称已经存在请重新输入！</span>");
                    return false;
                } else {
                    $("#zfdm_prop").html("<span style='color: green'>国别简称可以使用！</span>");
                    return true;
                }
            }
        }
        function checkBzjgdm() {
            var bzjgdm = document.getElementById("bzjgdm");
            if (bzjgdm == null || bzjgdm == 'null') {
                return true;
            } else {
                var bz = bzjgdm.value;
                if ("" == bz) {
                    $("#bzjgdm_prop").html("<span style='color: #ff0000'>请输入办证机构代码！</span>");
                    return false;
                } else {
                    $("#bzjgdm_prop").html("<span style='color: green'>办证机构代码可以使用！</span>");
                    return true;
                }
            }
        }
        function checkStandard() {
 
            return checkDM() && checkMC() && checkZfdm() ;
        }
    </script>
</head>
<body>
<div class="page_top">j系统  &gt;&gt; 标准维护 &gt;&gt; 新增标准 
    (    <c:if test="${table eq 'sc_dzzlx'}">党组织类型</c:if>
    <c:if test="${table eq 'sc_mz'}">民族</c:if>
    <c:if test="${table eq 'sc_wjdyy'}">未建党原因码表</c:if>
    <c:if test="${table eq 'sc_zzmm'}">政治面貌</c:if>
    <c:if test="${table eq 'sc_zw'}">职务</c:if>
    <c:if test="${table eq 'sc_lx'}">登记类型</c:if>
    <c:if test="${table eq 'sc_xzqh'}">行政区划</c:if>
    <c:if test="${table eq 'sc_bzjgdm'}">办证机构</c:if>
    <c:if test="${table eq 'sc_jjhy'}">经济行业</c:if>
    <c:if test="${table eq 't_zycp'}">主要产品</c:if>
    <c:if test="${table eq 'sc_gj'}">外方国别</c:if>
    <c:if test="${table eq 'sc_xzqh1'}">行政区划</c:if>
    <c:if test="${table eq 'sc_xzqhdz'}">行政区划对照</c:if>
    <c:if test="${table eq 't_hb'}">货币种类</c:if>
    <c:if test="${table eq 't_pzjg'}">批准机构</c:if>
    <c:if test="${table eq 'sc_jglx_pzjg'}">批准类型</c:if>
    <c:if test="${table eq 't_zgjg'}">主管机构</c:if>
    )
</div>
<form name="roleForm" method="post" action="/bsweb/commonTools_save_add" onsubmit="">
    <input type="hidden" name="table" id="table" value="${table}"/>

    <div id="box">
        <div id="content">
            <div id="right">
                <div class="rightpart">
                    <div class="list listblue" style="height:40px;">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1">
                            <tr class="table1_tr1">

                                <c:choose>
                                    <c:when test="${table eq 'sc_zw'}">
                                        <td class="table1_td1" align="right">职务名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="dm" id="dm" maxlength="1" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                      <td class="table1_td1" align="right">机构类型：</td>
		                                <td style="position:relative;display:block;overflow:visible;">
		                                <select name="jglx">
		                                <option value="1">社团</option>
		                                <option value="2">民非</option>
		                                <option value="3">基金会</option>
		                                </select>
									 </td>
                                    
                                    </c:when>
                                     <c:when test="${table eq 'sc_lx'}">
                                        <td class="table1_td1" align="right">类型名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="dm" id="dm" maxlength="3" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                      <td class="table1_td1" align="right">机构类型：</td>
		                                <td style="position:relative;display:block;overflow:visible;">
		                                <select name="jglx" id="">
		                                <option value="1">社团</option>
		                                <option value="2">民非</option>
		                                <option value="3">基金会</option>
		                                </select>
									 </td>
                                    
                                    </c:when>
                                    <c:when test="${table eq 'sc_jjhy'}">
                                        <td class="table1_td1" align="right">名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="tjjhy.mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="tjjhy.dm" id="dm" maxlength="5" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                      <td class="table1_td1" align="right">备注：</td>
		                                <td style="position:relative;display:block;overflow:visible;">
		                                 <input  type="text"
	                                               name="tjjhy.memo" id="dm" maxlength="200" isnull="false"
	                                               onblur="" size="200" class="page_input200"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
									 </td>
                                    
                                    </c:when>
                                    <c:when test="${table eq 'sc_xzqhdz'}">
                                        <td class="table1_td1" align="right">区划名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="xzqhDz.mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="xzqhDz.dm" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                        <td class="table1_td1" align="right">邮政编码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="xzqhDz.yzbm" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                        <td class="table1_td1" align="right">电话区号：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="xzqhDz.dhqh" id="dm" maxlength="4" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
									</c:when>
                                    <c:when test="${table eq 'sc_xzqh'}">
                                        <td class="table1_td1" align="right">区划名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="xzqh.mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="xzqh.dm" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                      <td class="table1_td1" align="right">级别：</td>
		                                <td style="position:relative;display:block;overflow:visible;">
		                                <select name="xzqh.depth">
		                                <option value="0">0</option>
		                                <option value="1">1</option>
		                                <option value="2">2</option>
		                                </select>
									 </td>
									 
                                        <td class="table1_td1" align="right">所属代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="xzqh.dmF" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                    </c:when>
                                    <c:when test="${table eq 'sc_bzjgdm'}">
                                        <td class="table1_td1" align="right">区划名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="bzjgObj.mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;" id="mc_prop"></span>
                                        </td>
                                        <td class="table1_td1" align="right">代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="bzjgObj.dm" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                      <td class="table1_td1" align="right">级别：</td>
		                                <td style="position:relative;display:block;overflow:visible;">
		                                <select name="bzjgObj.depth">
		                                <option value="1">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                </select>
									 </td>
									 
                                        <td class="table1_td1" align="right">所属代码：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input onpaste="rightValues(this);" onkeyup="rightValues(this);" type="text"
	                                               name="bzjgObj.dmF" id="dm" maxlength="6" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                        <td class="table1_td1" align="right">简称：</td>
	                                    <td style="position:relative;display:block;overflow:visible;">
	                                        <input  type="text"
	                                               name="bzjgObj.soMc" id="dm" maxlength="20" isnull="false"
	                                               onblur="" size="20" class="page_input2"/>
	                                        <span style="color:red;position:absolute; top:28px; left:0px;" id="zfdm_prop"></span>
	                                    </td>
                                    
                                    </c:when>

                                    <c:otherwise>
                                        <td class="table1_td1" align="right">名称：</td>
                                        <td style="position:relative;display:block;overflow:visible;">
                                            <input type="text" name="mc" id="mc" maxlength="<%=mcLen%>" isnull="false"
                                                   onblur="checkMC()" size="20" class="page_input2"/>
                                            <span style="color:red;position:absolute; top:28px; left:0px;"
                                                  id="mc_prop"></span>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
   

                            </tr>
                        </table>
                    </div>
                    <div class="listbtn">
                        <input name="saveButton" type="submit" class="newBtn1" id="saveButton" value="保 存"/>
                        &nbsp;
                        <input name="button2" type="reset" class="newBtn1" id="button2" value="重 填"/>
                        &nbsp;
                        <input name="button" type="button" class="newBtn1" id="button" value="返 回"
                               onclick="location.href='/bsweb/commonTools_standard_query_manage?table=${table}&dm='"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<c:if test="${message!=null && message!=''}">
    <script language="javascript">
        ymPrompt.errorInfo('${message}', 330, 220, '提示信息');
    </script>
</c:if>
</body>
</html>
