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
                <div class="col-lg-9"  style="margin: 0 auto;">
                    <div class="card">
                        <div class="card-header"><strong>设备采购</strong></div>
                        <div class="card-body card-block">
                            <form action="/device/add" method="post">
                                <div class="form-group"><label  class="form-control-label">设备名称</label><input type="text" id="name" name="name" placeholder="请输入设备名称，例如：打印机（中型）" class="form-control required" required="required"></div>
                                <div class="form-group"><label  class=" form-control-label">设备价格</label><input type="text" id="price" name="price" placeholder="请输入价格（元），例如：36.8" class="form-control number" required="required"></div>
                                <div class="form-group"><label  class=" form-control-label">设备数量</label><input type="text" id="number" name="number" placeholder="请输入数量，例如：5" class="form-control digits" required="required"></div>
                                <div class="form-group">
                                    <div class="form-control-label"><label class=" form-control-label">设备描述</label></div>
                                    <div class="col-12 col-md-12"><textarea name="description" id="textarea-input" rows="12" placeholder="请输入设备描述，例如：HP/惠普M254DW彩色激光打印机自动双面打印高速彩打 无线有线网络打印个人办公商用高效。" class="form-control" required="required"></textarea></div>
                                </div>
                                <%--<div class="form-group"><label  class=" form-control-label">设备描述</label><input type="text" id="desc" placeholder="请输入设备描述，例如：" class="form-control"></div>--%>
                                <div class="form-group">
                                    <div class="form-control-label"><label class=" form-control-label">设备来源</label></div>
                                    <div class="col-12 col-md-12"><textarea name="source" id="textarea-input1" rows="12" placeholder="请输入来源，例如：京东购入，地址是 https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.2.1d9c515ckwpn8m&id=560711148620&skuId=3509144241012&user_id=2081659341&cat_id=2&is_b=1&rn=5be8964d7a4929b98af9dbeac06c63bb" class="form-control" required="required"></textarea></div>
                                </div>
                                <%--<div class="form-group"><label  class=" form-control-label">设备来源</label><input type="text" id="source" placeholder="请输入来源，例如：京东购入，地址是 https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.2.1d9c515ckwpn8m&id=560711148620&skuId=3509144241012&user_id=2081659341&cat_id=2&is_b=1&rn=5be8964d7a4929b98af9dbeac06c63bb" class="form-control"></div>--%>
                                <%--<div class="form-group"><label  class="form-control-label">示例图片</label><input type="text" id="image" placeholder="Country name" class="form-control"></div>--%>
                                <div style="text-align: center">
                                    <button type="submit" class="btn btn-success">提交</button>
                                    <button type="reset" class="btn btn-secondary">重置表单</button>
                                </div>
                            </form>
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
