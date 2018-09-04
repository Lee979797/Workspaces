<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=gbk" %>
<%--@elvariable id="audit" type="java.lang.String"--%>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<%--@elvariable id="shresult" type="java.lang.String"--%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>选择办证机构</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript">
        ymPrompt.setDefaultCfg({showMask: false});
        function giveValue() {
            window.parent.ymPrompt.doHandler("${jgdm.jgdz};${jgdm.dhhm};${jgdm.fddbr};${jgdm.zch};${jgdm.jyfw}", true);
        }
    </script>
</head>
<body>


<div id="box">
    <div id="content">
        <div id="right">
            <div class="rightpart">
                <div class="list listblue">
                    <c:if test="${jgdm eq null}">
                        <h3><span style="font-weight: bold;">工商没有相关名称的数据，请手动输入机构相关信息！</span></h3>
                    </c:if>
                    <c:if test="${jgdm !=null}">
                    <TABLE class="tableBorder0" cellSpacing="0" cellPadding="5" align="center" border="0"                         bgcolor="#eaf6fb">
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                机构名称:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.jgmc}
                            </TD>
                        </TR>
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                机构地址:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.jgdz}
                            </TD>
                        </TR>
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                电话号码:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.dhhm}
                            </TD>
                        </TR>
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                法人代表:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.fddbr}
                            </TD>
                        </TR>
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                注册号:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.zch}
                            </TD>
                        </TR>
                        <TR>
                            <TD class="td1" align="right" width="30%">
                                经营范围:
                            </TD>
                            <TD class="td1">
                                    ${jgdm.jyfw}
                            </TD>
                        </TR>
                    </TABLE>
                </div>
                </c:if>
                <div class="listbtn">
                    <c:if test="${jgdm !=null}">
                        <INPUT class="newBtn1" onclick="giveValue()"
                               type="button" value="保 存"
                               name="btok"/>
                    </c:if>
                    &nbsp; <INPUT class="newBtn1" onClick="  window.parent.ymPrompt.close();"
                                  type="button" value="取消"/>

                </div>


            </div>

        </div>

    </div>
</div>
</body>
<jsp:include page="../common/onload.jsp"/>
</html>