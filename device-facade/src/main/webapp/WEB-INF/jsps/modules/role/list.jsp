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
                <div class="col-lg-9" style="margin: 0 auto;">
                    <div class="card">

                        <%--head--%>
                        <div class="card-header"><strong>修改权限</strong></div>

                        <br>
                        <%--select--%>
                        <div class="row form-group" style="text-align:center;">
                            <div class="col col-md-3"><label for="selectSm" class=" form-control-label">角色</label></div>
                            <div class="col-6 col-md-6">
                                <select name="selectSm" id="selectSm" class="form-control-sm form-control">
                                    <option value="">请选择角色</option>
                                    <option value="EMPLOYEE">企业员工</option>
                                    <option value="DEVICE_MANAGER">设备管理人员</option>
                                    <option value="SYSTEM_MANAGER">系统管理人员</option>
                                </select>
                            </div>
                        </div>
                        <br><br>
                        <%--list--%>
                        <div class="row form-group" style="text-align:center;">
                            <div class="col col-md-3"><label class=" form-control-label">菜单权限</label></div>
                            <div class="col col-md-6">
                                <div class="form-check" style="margin:0 auto;text-align:left;">
                                    <div class="checkbox">
                                        <label for="checkbox1" class="form-check-label ">
                                            <input type="checkbox" id="checkbox1" name="role" value="1" class="form-check-input">总页面
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox1" class="form-check-label ">
                                            <input type="checkbox" id="checkbox2" name="role" value="2" class="form-check-input">正常设备
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox2" class="form-check-label ">
                                            <input type="checkbox" id="checkbox3" name="role" value="3" class="form-check-input"> 待维修设备
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox4" name="role" value="4" class="form-check-input"> 报废设备
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox5" name="role" value="5" class="form-check-input"> 报失设备
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox6" name="role" value="6" class="form-check-input"> 设备采购
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox7" name="role" value="7" class="form-check-input"> 维修记录
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox8" name="role" value="8" class="form-check-input"> 用户管理
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox9" name="role" value="9" class="form-check-input"> 日志管理
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox10" name="role" value="10" class="form-check-input"> 权限管理
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label for="checkbox3" class="form-check-label ">
                                            <input type="checkbox" id="checkbox11" name="role" value="11" class="form-check-input"> 个人信息
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%--button--%>
                        <button type="button" class="btn btn-outline-success btn-lg btn-block saveRole">保存更改</button>
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
<script src="/static/modules/role/list.js"></script>
</body>
</html>
