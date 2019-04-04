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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">${status}设备列表</strong>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">设备编号</th>
                                    <th scope="col">设备名称</th>
                                    <th scope="col">采购时间</th>
                                    <th scope="col">采购价格</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${list.list}" var="detail">
                                        <tr>
                                            <td>${detail.id}</td>
                                            <td>${detail.code}</td>
                                            <td>${detail.name}</td>
                                            <td><fmt:formatDate value="${detail.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                            <td>${detail.price/100}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <%--pageInfo--%>
                            <div style="text-align: center;">
                                <input type="hidden" id="pageNo" value="${pageNo}"/>
                                <input type="hidden" id="totalPage" value="${list.pages}"/>
                                <div>
                                    <strong style="float: left;">共${list.total}条数据</strong>
                                    <button type="buttom" id="firstPage" class="btn btn-secondary">首页</button>
                                    <button type="buttom" id="proidPage" class="btn btn-success">上一页</button>
                                    <button type="buttom" id="nextPage" class="btn btn-success">下一页</button>
                                    <button type="buttom" id="endPage" class="btn btn-secondary">尾页</button>
                                </div>
                                <%--<div align="center" id="firstPage"><button type="button" class="btn btn-outline-secondary btn-sm">首页</button></div></td>
                                <div align="center" id="proidPage"><button type="button" class="btn btn-outline-secondary btn-sm">上一页</button></div></td>
                                <div align="center" id="nextPage"><button type="button" class="btn btn-outline-secondary btn-sm">下一页</button></div></td>
                                <div align="center" id="endPage"><button type="button" class="btn btn-outline-secondary btn-sm">尾页</button></div></td>--%>
                            </div>

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
    <script src="/static/modules/deviceList/list.js"></script>

</body>
</html>
