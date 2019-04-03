<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!Doctype html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">



    <link rel="stylesheet" href="/static/assets/css/normalize.css">
    <link rel="stylesheet" href="/static/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/assets/css/themify-icons.css">
    <link rel="stylesheet" href="/static/assets/css/pe-icon-7-filled.css">
    <link rel="stylesheet" href="/static/assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="/static/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/static/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body class="bg-dark">

<div class="sufee-login d-flex align-content-center flex-wrap">
    <div class="container">
        <div class="login-content">
            <div class="login-logo">
                <a href="index.html">
                    <img class="align-content" src="/static/images/logo.png" alt="">
                </a>
            </div>
            <div class="login-form">
                <form action="/login/regist" method="post">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" name="name" class="form-control" placeholder="User Name">
                    </div>
                    <div class="form-group">
                        <label>邮箱</label>
                        <input type="email" name="email" class="form-control" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label>手机号</label>
                        <input type="tel" name="phone" class="form-control" placeholder="phone">
                    </div>
                    <div class="row form-group">
                        <div class="col col-md-3"><label for="select" class="form-control-label">性别</label></div>
                        <div class="col-12 col-md-9">
                            <select name="gender" id="select" class="form-control">
                                <option value="MALE">男</option>
                                <option value="FEMALE">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">注册</button>
                    <div class="register-link m-t-15 text-center">
                        <p>已经有账号了 ? <a href="/login/page">前往登录</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/static/assets/js/vendor/jquery-2.1.4.min.js"></script>
<script src="/static/assets/js/popper.min.js"></script>
<script src="/static/assets/js/bootstrap.min.js"></script>
<script src="/static/assets/js/jquery.matchHeight.min.js"></script>
<script src="/static/assets/js/main.js"></script>

</body>
</html>
