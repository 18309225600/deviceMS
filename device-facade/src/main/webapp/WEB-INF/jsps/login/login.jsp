<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>办公设备管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link rel="stylesheet" href="/static/assets/css/normalize.css">
    <link rel="stylesheet" href="/static/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/assets/css/themify-icons.css">
    <link rel="stylesheet" href="/static/assets/css/pe-icon-7-filled.css">
    <link rel="stylesheet" href="/static/assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="/static/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/static/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
</head>

<body class="bg-dark">

<div class="sufee-login d-flex align-content-center flex-wrap">
    <div class="container">
        <div class="login-content">
            <div class="login-logo">
                <a href="index.html">
                   <h1>企业办公设备管理系统</h1>
                   <br />
                   <br />
                   <br />
                </a>
            </div>
            <div class="login-form">
                <form action="/login/exe" method="post">
                    <div style="text-align: center;color:red;">${msg}</div>
                    <div class="form-group">
                        <label>邮箱:</label>
                        <input type="email" name="email" class="form-control" placeholder="请输入邮箱">
                    </div>
                    <div class="form-group">
                        <label>密码:</label>
                        <input type="password" name="password" class="form-control" placeholder="请输入密码">
                    </div>
                    <%--<div class="checkbox">
                        &lt;%&ndash;<label>
                            <input type="checkbox"> Remember Me
                        </label>&ndash;%&gt;
                        <label class="pull-right">
                            <a href="${ctx}/login/repassPage">密码忘记了?</a>
                        </label>

                    </div>--%>
                    <button type="submit" class="btn btn-success btn-flat m-b-30 m-t-30">登录</button>
                    <%--<div class="social-login-content">
                        <div class="social-button">
                            <button type="button" class="btn social facebook btn-flat btn-addon mb-3"><i class="ti-facebook"></i>Sign in with facebook</button>
                            <button type="button" class="btn social twitter btn-flat btn-addon mt-2"><i class="ti-twitter"></i>Sign in with twitter</button>
                        </div>
                    </div>--%>
                    <div class="register-link m-t-15 text-center">
                        <p>还没有账号 ? <a href="/login/regist"> 立即注册</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/static/modules/login/login.js"></script>
<script src="/static/assets/js/vendor/jquery-2.1.4.min.js"></script>
<script src="/static/assets/js/popper.min.js"></script>
<script src="/static/assets/js/bootstrap.min.js"></script>
<script src="/static/assets/js/jquery.matchHeight.min.js"></script>
<script src="/static/assets/js/main.js"></script>

</body>

</html>
