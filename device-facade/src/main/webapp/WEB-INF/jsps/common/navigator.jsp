<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">
        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <c:forEach items="${sessionScope.menus}" var="menu">
                    <li>
                        <a href="${ctx}${menu.url}" class="dropdown-toggle"><i class="${menu.style}"></i>${menu.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </nav>
</aside>