<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsps/common/base.jsp" %>
<!DOCTYPE html>

<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>办公设备管理系统</title>
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
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <link href="/static/assets/weather/css/weather-icons.css" rel="stylesheet" />
    <link href="/static/assets/calendar/fullcalendar.css" rel="stylesheet" />

    <link href="/static/assets/css/charts/chartist.min.css" rel="stylesheet">
    <link href="/static/assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">

    <style>
        #weatherWidget .currentDesc {
            color: #ffffff!important;
        }
        .traffic-chart {
            min-height: 335px;
        }
        #flotPie1  {
            height: 150px;
        }
        #flotPie1 td {
            padding:3px;
        }
        #flotPie1 table {
            top: 20px!important;
            right: -10px!important;
        }
        .chart-container {
            display: table;
            min-width: 270px ;
            text-align: left;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        #flotLine5  {
            height: 105px;
        }

        #flotBarChart {
            height: 150px;
        }
        #cellPaiChart{
            height: 160px;
        }

    </style>
</head>
<body>
<!-- Left Panel -->
<jsp:include  page="/WEB-INF/jsps/common/navigator.jsp" flush="true"/>
<!-- /#left-panel -->
<!-- Right Panel -->
<div id="right-panel" class="right-panel">
    <!-- Header-->
    <jsp:include  page="/WEB-INF/jsps/common/header.jsp" flush="true"/>
    <!-- /#header -->
    <!-- Content -->
    <div class="content">
        <div class="animated fadeIn">
            <div class="row">
                <div class="col-lg-6" style="margin: 0 auto;">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title mb-3">个人信息</strong>
                        </div>
                        <div class="card-body">
                            <div class="mx-auto d-block">
                                <%--<img class="rounded-circle mx-auto d-block" src="images/admin.jpg" alt="Card image cap">--%>
                                <h4 class="text-sm-center mt-2 mb-1"><strong>${sessionScope.user.name}</strong></h4>
                                <div class="location text-sm-center"><i class="fa fa-male"></i>${sessionScope.user.gender eq 'MALE' ? '男' : '女'}</div>
                            </div>

                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <a href="#"><i class="fa fa-facebook pr-1">${sessionScope.user.phone}</i></a>
                                </li>
                                <li class="list-group-item">
                                    <a href="#"><i class="fa fa-twitter pr-1">${sessionScope.user.email}</i></a>
                                </li>
                                <li class="list-group-item">
                                    <a href="#"><i class="fa fa-linkedin pr-1">
                                        <c:if test="${sessionScope.user.role eq 'EMPLOYEE'}">企业员工</c:if>
                                        <c:if test="${sessionScope.user.role eq 'DEVICE_MANAGER'}">设备管理人员</c:if>
                                        <c:if test="${sessionScope.user.role eq 'SYSTEM_MANAGER'}">系统管理人员</c:if>
                                    </i></a>
                                </li>
                                <li class="list-group-item">
                                    <a href="#"><i class="fa fa-calendar pr-1"><fmt:formatDate value="${sessionScope.user.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/static/assets/js/vendor/jquery-2.1.4.min.js"></script>
<script src="/static/assets/js/popper.min.js"></script>
<script src="/static/assets/js/bootstrap.min.js"></script>
<script src="/static/assets/js/jquery.matchHeight.min.js"></script>
<script src="/static/assets/js/main.js"></script>


<script src="/static/assets/js/lib/data-table/datatables.min.js"></script>
<script src="/static/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
<script src="/static/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
<script src="/static/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
<script src="/static/assets/js/lib/data-table/jszip.min.js"></script>
<script src="/static/assets/js/lib/data-table/vfs_fonts.js"></script>
<script src="/static/assets/js/lib/data-table/buttons.html5.min.js"></script>
<script src="/static/assets/js/lib/data-table/buttons.print.min.js"></script>
<script src="/static/assets/js/lib/data-table/buttons.colVis.min.js"></script>
<script src="/static/assets/js/init/datatables-init.js"></script>
<script src="/static/modules/user/myInfo.js"></script>

</body>
</html>
