<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>REIMBURSE | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="loginUI.do"><b>REIMBURSE</b></a>
    </div>
    <!-- /.doLogin-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form method="post">
            <div class="form-group has-feedback">
                <input type="text" id="usernameId" name="username" class="form-control" placeholder="username" onkeydown="if (event.keyCode === 13) {doLogin()}">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" id="passwordId" name="password" class="form-control" placeholder="Password" onkeydown="if (event.keyCode === 13) {doLogin()}">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>


            <div class="row">
                <div class="col-xs-8">
                    <%--<div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> Remember Me
                        </label>
                    </div>--%>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat btn-login">Sign In</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
    <!-- /.doLogin-box-body -->
</div>
<!-- /.doLogin-box -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        /*$(".btn").click(function(){
             doLogin();
         });*/
        $(".btn").click(doLogin);
    });

    function doLogin() {
        var params = {
            username: $("#usernameId").val(),
            password: $("#passwordId").val()
        };
        var url = "doLogin.do";
        $.post(url, params, function (result) {
            if (result.state === 1) {
                location.href = "indexUI.do";
            } else {
                $(".login-box-msg").html(result.message);
            }
            return false;
        });
    }
</script>
</body>
</html>
