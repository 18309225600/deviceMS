<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<header id="header" class="header">
    <div class="top-left">
        <div class="navbar-header">
            <h4>办公设备管理系统</h4>
        </div>
    </div>
    <div class="top-right">
        <div class="header-menu">

            <div class="user-area dropdown float-right">
                <a href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <%--<img class="user-avatar rounded-circle" src="/static/images/admin.jpg" alt="User Avatar">--%>
                    <div>${sessionScope.user.name}</div>
                </a>

                <div class="user-menu dropdown-menu">
                    <a class="nav-link" href="/login/repassPage"><i class="fa fa-power -off"></i>修改密码</a>
                    <a class="nav-link" href="/login/exit"><i class="fa fa-power -off"></i>登出系统</a>
                </div>
            </div>

        </div>
    </div>
</header>