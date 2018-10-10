<%--
  Created by IntelliJ IDEA.
  User: 10677
  Date: 2018/10/10
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
    <script src="js/jquery/dist/jquery.min.js"></script>
    <!--icons-css-->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!--Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
    <!--static chart-->
</head>
<body>
<div class="login-page">
    <div class="login-main">
        <div class="login-head">
            <h1>Login</h1>
        </div>
        <div class="login-block">
            <input id="username" type="text" name="email" placeholder="username" required="">
            <input id="password" type="password" name="password" class="lock" placeholder="Password">
            <div class="forgot-top-grids">
                <div class="forgot-grid">
                    <ul>
                        <li>
                            <input type="checkbox" id="brand1" value="">
                            <label for="brand1"><span></span>Remember me</label>
                        </li>
                    </ul>
                </div>
                <div class="forgot">
                    <a href="#">Forgot password?</a>
                </div>
                <div class="clearfix"></div>
            </div>
            <input type="submit" name="Sign In" value="Login" onclick="doLogin()">
            <h3>Not a member?<a href="signUp"> Sign up now</a></h3>
            <h2>or login with</h2>
            <div class="login-icons">
                <ul>
                    <li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#" class="google"><i class="fa fa-google-plus"></i></a></li>
                </ul>
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
<!-- mother grid end here-->
</body>
<script type="text/javascript">
    function doLogin() {
        var params = {
            username: $("#username").val(),
            password: $("#password").val()
        };
        var url = "doLogin";
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
