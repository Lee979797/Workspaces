<%--
  Created by IntelliJ IDEA.
  User: 10677
  Date: 2018/10/10
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!--js-->
    <script src="js/jquery-2.1.1.min.js"></script>
    <!--icons-css-->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!--Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
    <!--//charts-->
</head>
<body>
<!--inner block start here-->
<div class="signup-page-main">
    <div class="signup-main">
        <div class="signup-head">
            <h1>Sign Up</h1>
        </div>
        <div class="signup-block">
            <input id="username" type="text" name="email" placeholder="Name" required="">
            <input id="password" type="password" name="password" class="lock" placeholder="Password">
            <%--<div class="forgot-top-grids">
                <div class="forgot-grid">
                    <ul>
                        <li>
                            <input type="checkbox" id="brand1" value="">
                            <label for="brand1"><span></span>I agree to the terms</label>
                        </li>
                    </ul>
                </div>

                <div class="clearfix"></div>
            </div>--%>
            <input type="button" name="Sign In" value="Sign up" onclick="doSignUp()">
            <div class="sign-down">
                <h4>Already have an account? <a href="${pageContext.request.contextPath}/loginUI"> Login here.</a></h4>
            </div>
        </div>
    </div>
</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
    <p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/"
                                                                                target="_blank" title="模板之家">模板之家</a> -
        Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
</div>
<!--COPY rights end here-->
<!--scrolling js-->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!--//scrolling js-->
<script src="js/bootstrap.js"></script>
<script src="js/jquery.min.js"></script>
<!-- mother grid end here-->
</body>
<script type="text/javascript">
    function doSignUp() {
        var params = {
            username: $("#username").val(),
            password: $("#password").val()
        };
        var url = "doSignUp";
        $.post(url, params, function (result) {
            if (result.state === 1) {
                location.href = "indexUI";
            } else {
                $("#msg").html(result.message);
            }
            return false;
        });
    }
</script>
</html>
