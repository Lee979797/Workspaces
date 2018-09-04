<%@ page contentType="text/html; charset=gbk" %>
<%--@elvariable id="sysUser" type="com.ninemax.jpa.system.model.User"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<c:set var="org" value="<%= InitSysParams.getInstance().orgs%>"/>
<div align="center" style="margin-top:20px;">
    <OBJECT ID="print"
            CLASSID="CLSID:230DA4AF-6773-4D8E-AE36-FCE670FE3695"
            CODEBASE="/product/jsp/icocx/dmcj.CAB#version=1,7,0,0" width="940" height="760" style="text-align: center;">
        <param name="jgdm" value="${certi.jgdm}">
        <param name="frlx" value="${certi.frdbMc}">
        <param name="frmc" value="${certi.frdbValue}">
        <param name="jgmc" value="${certi.jgmc}">
        <param name="jglxmc" value="${jglxMap[fn:trim(certi.jglx)] }">
        <param name="jgdz" value="${certi.jgdz }">
        <param name="yxq" value="${certi.yxq}">
        <param name="bfdw" value="${zrxzqhMap[certi.bzjgdm].jgmc}">
        <param name="djh" value="�����${sysUser.bzjgdm}-${certi.djh}">
        <param name="ewm" value="${certi.QRCode}">
        <param name="ts"
               value="${zrxzqhMap[fn:trim(sysUser.bzjgdm)].njtsbz?certi.tsxx1:''}${certi.tsxx2==null?'':certi.tsxx2}${certi.tsxx3==null?'':certi.tsxx3} ">
        <param name="ermx" value="0">
        <param name="ermy" value="0">
        <param name="dyerm" value="0">
        <param name="osx" value="${sysUser.offsetx}">
        <param name="osy" value="${sysUser.offsety}">
        <param name="printname" value="${sysUser.printName}">
    </OBJECT>
</div>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/dwr/interface/certPrintBus.js"></script>
<script type="text/javascript" src="/dwr/interface/spBus.js"></script>
<script type="text/javascript">
    function printThis(isdy) {

        dwr.engine.setAsync(false);
        var flag = true;
        var result = '';
        certPrintBus.hasCert('${certi.bzjgdm}', '${certi.zbNumber}', '${certi.fbNumber}', function (value) {
            flag = value;
        });
        if (!flag) {
            ymPrompt.alert({message: "��ǰ����֤���治�㣬����֤�����ܴ�ӡ֤��", width: 330, height: 220, title: '��ʾ��Ϣ'});
            return false;
        }
        certPrintBus.checkTime('${certi.jgdm}','${sysUser.bzjgdm}',isdy, function (value) {
            var ss = value.split(':');
            flag = ss[0];
            result = ss.length > 1 ? ss[1] : '';
        });

        if (flag == "false") {
            ymPrompt.alert(result);
            return false;
        }
        certPrintBus.isALLScanComplete('${certi.jgdm}', '${certi.bzjgdm}', function (value) {
            flag = value;
        });
        if (flag) {
            spBus.isAudiaAll('${certi.jgdm}', '', function (data) {
                var index = data.indexOf(":");
                var s1 = data.substring(0, index);
                var s2 = data.substring(index + 1, data.length);
                if (s1 == "0") {
                    var print;
                    print = document.getElementById("print");
                    var p = print.CheckPrintName('${sysUser.printName}');
                    if (p == 1) {
                        ymPrompt.alert("��ӡ��ȱֽ��", 330, 220, "��ʾ��Ϣ");
                        return false;
                    }
                    if (p == 2) {
                        ymPrompt.alert("��ӡ������ϵ��", 330, 220, "��ʾ��Ϣ");
                        return false;
                    }
                    if (p == 3) {
                        ymPrompt.alert("��ӡ���쳣��", 330, 220, "��ʾ��Ϣ");
                        return false;
                    }
                    if (p == 4) {
                        ymPrompt.alert("û�а�װ��ӡ����", 330, 220, "��ʾ��Ϣ");
                        return false;
                    }
                    /* if (p == 5) {
                     ymPrompt.alert("��ӡ���������ô�������ִ�д�ӡ���ã�", 330, 220, "��ʾ��Ϣ");
                     return false;
                     }*/
                    document.searchForm.submit();
                    flag = true;
                    return true;
                }
                if (s1 == "1") {
                    ymPrompt.alert({message: s2, width: 330, height: 220,
                        slideShowHide: false, title: '��ӡ֤��'});
                    flag = false;
                    return false
                }
                return true;
            });
            return flag;
        } else {
            ymPrompt.alert({message: "�������루" + '${certi.jgdm}' + "����Ҫ�����ɨ��������ܴ�ӡ֤��", width: 330, height: 220, title: '��ʾ��Ϣ'});
            return false;
        }

    }
</script>