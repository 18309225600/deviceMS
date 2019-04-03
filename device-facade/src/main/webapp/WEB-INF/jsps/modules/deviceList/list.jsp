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
    <link rel="stylesheet" href="/static/assets/css/flag-icon.min.css"><link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
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
                        <a class="nav-link" href="#"><i class="fa fa-power -off"></i>登出系统</a>
                    </div>
                </div>

            </div>
        </div>
    </header>
    <!-- /#header -->
    <!-- Content -->
    <div class="content">
        <div class="animated fadeIn">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">设备列表</strong>
                        </div>
                        <div class="card-body">
                            <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Salary</th>
                                </tr>
                                </thead>
                                <tbody>
                                  <c:forEach items="${list}" var="list" varStatus="s">
                                      <tr>
                                          <td>Donna Snider</td>
                                          <td>Customer Support</td>
                                          <td>New York</td>
                                          <td>$112,000</td>
                                      </tr>
                                  </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


            </div>
        </div><!-- .animated -->
    </div><!-- .content -->
    <!-- /#right-panel -->

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
</div>
</body>
</html>
