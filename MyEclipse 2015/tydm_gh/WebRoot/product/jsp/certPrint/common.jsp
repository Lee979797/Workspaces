<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<OBJECT ID="print"
        CLASSID="CLSID:230DA4AF-6773-4D8E-AE36-FCE670FE3695" width=0 height=0 style="text-align: center;">
    <param name="jgdm" value="${certi.jgdm}">
    <param name="frlx" value="${certi.frdbMc}">
    <param name="frmc" value="${certi.frdbValue}">
    <param name="jgmc" value="${certi.jgmc}">
    <param name="jglxmc" value="${jglxMap[fn:trim(certi.jglx)] }">
    <param name="jgdz" value="${certi.jgdz }">
    <param name="yxq" value="${certi.yxq}">
    <param name="bfdw" value="${zrxzqhMap[certi.bzjgdm].jgmc}">
    <param name="djh" value="×é´ú¹Ü${fn:trim(sysUser.bzjgdm)}-${certi.djh}">
    <param name="ewm" value="${certi.QRCode}">
    <param name="ts"
           value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njtsbz?certi.tsxx1:''}${certi.tsxx2}${certi.tsxx3}">
    <param name="ermx" value="0">
    <param name="ermy" value="0">
    <param name="dyerm" value="0">
    <param name="osx" value="${sysUser.offsetx}">
    <param name="osy" value="${sysUser.offsety}">
    <param name="printname" value="${sysUser.printName}">
</OBJECT>