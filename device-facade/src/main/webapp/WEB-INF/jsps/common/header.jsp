<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<header id="header" class="header">
    <div class="top-left">
        <div class="navbar-header">
            <a class="navbar-brand" href="./"><img src="/static/images/logo.png" alt="Logo"></a>
            <a class="navbar-brand hidden" href="./"><img src="/static/images/logo2.png" alt="Logo"></a>
            <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
        </div>
    </div>
    <div class="top-right">
        <div class="header-menu">

            <div class="user-area dropdown float-right">
                <a href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <%--<img class="user-avatar rounded-circle" src="/static/images/admin.jpg" alt="User Avatar">--%>
                    <div>张三</div>
                </a>

                <div class="user-menu dropdown-menu">
                    <a class="nav-link" href="/login/exit"><i class="fa fa-power -off"></i>登出系统</a>
                </div>
            </div>

        </div>
    </div>
</header>