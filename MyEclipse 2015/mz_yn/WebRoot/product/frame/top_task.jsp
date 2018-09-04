<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%
    User ses_user = (User) session.getAttribute("sysUser");
    int user_id = ses_user.getUserId();

    UserBo userBo = new UserBo();
    User user = userBo.findById(user_id);

    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    clsRightKeyBus rightKeyBus = new clsRightKeyBus();
    ArrayList rightKeys = rightKeyBus.ListFirstRight("0");

    //权限
    /**
     *权限说明
     *
     *  01010101 发证  01050101 换证 02010101 变更
     **/

    boolean canFz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01010101");
    boolean canHz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01050101");
    boolean canBg = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010101");
    boolean canNj = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010201");
    boolean canVz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010301");
    boolean canDy = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01060101");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <title>全国组织机构代码管理系统</title>
    <link href="../css/css.css" rel="stylesheet" type="text/css"/>
    <script type='text/javascript' src="/js/tools.js"></script>
    <script type="text/javascript">
        <!--
        function MM_swapImgRestore() { //v3.0
            var i, x, a = document.MM_sr;
            for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
        }
        function MM_preloadImages() { //v3.0
            var d = document;
            if (d.images) {
                if (!d.MM_p) d.MM_p = new Array();
                var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
                for (i = 0; i < a.length; i++)
                    if (a[i].indexOf("#") != 0) {
                        d.MM_p[j] = new Image;
                        d.MM_p[j++].src = a[i];
                    }
            }
        }

        function MM_findObj(n, d) { //v4.01
            var p, i, x;
            if (!d) d = document;
            if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                d = parent.frames[n.substring(p + 1)].document;
                n = n.substring(0, p);
            }
            if (!(x = d[n]) && d.all) x = d.all[n];
            for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
            for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
            if (!x && d.getElementById) x = d.getElementById(n);
            return x;
        }

        function MM_swapImage() { //v3.0
            var i, j = 0, x, a = MM_swapImage.arguments;
            document.MM_sr = new Array;
            for (i = 0; i < (a.length - 2); i += 3)
                if ((x = MM_findObj(a[i])) != null) {
                    document.MM_sr[j++] = x;
                    if (!x.oSrc) x.oSrc = x.src;
                    x.src = a[i + 2];
                }
        }
        //-->
    </script>
    <script type="text/javascript">

        var topSize = null;
        function changeStyle(topnum) {

            for (var i = 0; i < topSize; i++) {
                if (i == topnum) {
                    document.getElementById("top_" + i).className = "hei";
                } else {
                    document.getElementById("top_" + i).className = "";
                }
            }
        }

        function openthisWindow(num, id, title, rightUrl) {

            changeStyle(num);
            if (id != null && id != "" && id != "null") {
                window.open("left.jsp?parentId=" + id + "&parentName=" + title, "leftFrame", "");
                window.open("right.jsp?parentName=" + title, "kunFrame", "");
            } else {
                window.open("left.html", "leftFrame", "");
                window.open("right.jsp", "kunFrame", "");
            }

        }

        function logOut() {
            if (confirm("确认注销本系统？")) {
                //UtilBus.logout();
                window.parent.location.href = '/action/UserAction?method=exit';
                //先关闭框架页面， 再打开新的页面。
                window.parent.location.href = 'http://' + window.location.host + "/product/login.jsp";
            }
        }
        function home() {
            window.parent.location.href = '/product/index.html';
        }
        function logOutToPortal() {
            if (confirm("确认退出本系统？")) {
                //UtilBus.logout();
                window.parent.location.href = '/action/UserAction?method=exit';
                //先关闭框架页面， 再打开新的页面。
                window.parent.location.href = 'http://' + window.location.host + "/";
            }
        }

    </script>

</head>

<body>
<!-- 头部 -->
<div id="head-top" style="width: auto">
    <div class="top_left">

        <h1><a href="javascript:void(0);">全国组织机构代码管理系统</a></h1>


    </div>

    <div class="top_right">
        <!-- 右侧退出 -->
        <div class="top_quit">
            <ul>
                <li><a href="#" onclick="logOutToPortal();"><img src="../images/zhuxiao.png" alt="注销"/><br/>注销</a></li>
            </ul>
        </div>
        <!-- 菜单 -->
    </div>
    　

</div>
<!-- 头部结束 -->

</body>
</html>
