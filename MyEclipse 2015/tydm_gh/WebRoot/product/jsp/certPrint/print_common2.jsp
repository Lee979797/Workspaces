<%--@elvariable id="certi" type="com.ninemax.jpa.code.model.Certi"--%>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="jglxMap" value="<%= InitSysParams.jglxMap%>"/>
<c:set var="zrxzqhMap" value="<%= InitSysParams.zrxzqhMap2%>"/>
<script type="text/javascript">
    function createPage() {
        var LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
        LODOP.PRINT_INITA(15, 150, 945, 680, "105");
        LODOP.SET_PRINT_PAGESIZE(2, 0, 0, "B5");
        LODOP.ADD_PRINT_BARCODE(231, 90, 68, 77, "QRCode", "代码：${certi.jgdm}\n登记号：${certi.djh}\n有效期：${certi.yxq}");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 9);
        //    LODOP.SET_PRINT_STYLEA(0, "ReadOnly", 1);
        LODOP.ADD_PRINT_BARCODE(214, 174, 220, 42, "EAN128A", "${certi.jgdm}");
        LODOP.SET_PRINT_STYLEA(0, "ShowBarText", 0);
        LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED", 1);
        //   LODOP.SET_PREVIEW_WINDOW(2,0,0,0,0,""); //按适宽模式显示
        var jgdm = '${certi.jgdm}';
        var b = '';
        var length = jgdm.length;
        for (var i = 0; i < length; i++) {
            if (i == length - 1)
                b += "- ";
            b += jgdm.charAt(i);
            if (i != length)
                b += " ";
        }
        LODOP.ADD_PRINT_TEXT(194, 169, 220, 18, b.trim());
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Alignment", 2);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(296, 169, 274, 63, "${certi.jgmc}");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(374, 169, 274, 24, "${jglxMap[fn:trim(certi.jglx)] }");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(398, 52, 115, 30, "${certi.frdbMc}:");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "汉仪长宋简新");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.ADD_PRINT_TEXT(398, 169, 210, 24, "${certi.frdbValue}");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(425, 169, 274, 24, "${certi.jgdz }");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(503, 169, 316, 48, "${certi.yxq}");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 13);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", -2);
        LODOP.ADD_PRINT_TEXT(554, 169, 273, 48, "${zrxzqhMap[certi.bzjgdm].jgmc}");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        LODOP.ADD_PRINT_TEXT(445, 558, 164, 100, "${certi.tsxx1}${certi.tsxx2}${certi.tsxx3}");
        LODOP.SET_PRINT_STYLEA(0, "FontName", "宋体");
        LODOP.SET_PRINT_STYLEA(0, "FontSize", 10);
        LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
        return LODOP;
    }
    function getLodop(oOBJECT, oEMBED) {
        /**************************
         本函数根据浏览器类型决定采用哪个对象作为控件实例：
         IE系列、IE内核系列的浏览器采用oOBJECT，
         其他浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED。
         **************************/
        var strHtml1 = "<br><span style='color: #FF00FF'>打印控件未安装!点击这里<a href='/icocx/install_lodop.exe'>执行安装</a>,安装后请刷新页面或重新进入。</span>";
        var strHtml2 = "<br><span style='color: #FF00FF'>打印控件需要升级!点击这里<a href='/icocx/install_lodop.exe'>执行升级</a>,升级后请重新进入。</span>";
        var strHtml3 = "<br><br><span style='color: #FF00FF'>注意：<br>1：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它;<br>2：如果浏览器表现出停滞不动等异常，建议关闭其“plugin-container”(网上搜关闭方法)功能;</span>";
        var LODOP = oEMBED;
        try {
            if (navigator.appVersion.indexOf("MSIE") >= 0) LODOP = oOBJECT;

            if ((LODOP == null) || (typeof(LODOP.VERSION) == "undefined")) {
                if (navigator.userAgent.indexOf('Firefox') >= 0)
                    document.documentElement.innerHTML = strHtml3 + document.documentElement.innerHTML;
                if (navigator.appVersion.indexOf("MSIE") >= 0) document.write(strHtml1); else
                    document.documentElement.innerHTML = strHtml1 + document.documentElement.innerHTML;
                return LODOP;
            } else if (LODOP.VERSION < "6.0.5.6") {
                if (navigator.appVersion.indexOf("MSIE") >= 0) document.write(strHtml2); else
                    document.documentElement.innerHTML = strHtml2 + document.documentElement.innerHTML;
                return LODOP;
            }
            //*****如下空白位置适合调用统一功能:*********
            LODOP.SET_LICENSES("北京九瑞网络科技有限公司", "653607179737475919278901905623", "", "");
            //*******************************************
            return LODOP;
        } catch (err) {
            document.documentElement.innerHTML = "Error:" + strHtml1 + document.documentElement.innerHTML;
            return LODOP;
        }
    }


</script>
