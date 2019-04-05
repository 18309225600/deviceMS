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
                <div class="col-md-9" style="margin: 0 auto;">
                    <aside class="profile-nav alt">
                        <section class="card">
                            <div class="card-header user-header alt bg-dark">
                                <div class="media">
                                    <a href="#">
                                        <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="images/admin.jpg">
                                    </a>
                                    <div class="media-body">
                                        <h2 class="text-light display-6">${device.id}号设备详情</h2>
                                        <p>
                                            <c:if test="${device.status eq 'NOMAL'}">正常</c:if>
                                            <c:if test="${device.status eq 'LOST'}">丢失</c:if>
                                            <c:if test="${device.status eq 'REPAIRING'}">待维修</c:if>
                                            <c:if test="${device.status eq 'DUMPED'}">已损坏</c:if>
                                        </p>
                                    </div>
                                </div>
                            </div>


                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <i class="fa fa-star-half-o"></i> 设备编号 <span class="badge badge-primary pull-right">${device.code}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-tasks"></i> 设备名称 <span class="badge badge-danger pull-right">${device.name}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-cny"></i> 设备价格 <span class="badge badge-success pull-right">${device.price/100}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-subscript"></i> 同类型设备数量 <span class="badge badge-success pull-right">${device.number}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-comments-o"></i> 设备描述 <span class="badge badge-warning pull-right r-activity">${device.description}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-truck"></i> 设备来源 <span class="badge badge-warning pull-right r-activity">${device.source}</span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-table"></i> 设备采购时间 <span class="badge badge-warning pull-right r-activity"><fmt:formatDate value="${device.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                                </li>
                                <li class="list-group-item">
                                    <i class="fa fa-file-text"></i> 备注 <span class="badge badge-warning pull-right r-activity">${device.remark}</span>
                                </li>
                            </ul>

                        </section>
                    </aside>
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
<script src="/static/modules/deviceList/detail.js"></script>

</body>
</html>
