<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20 0020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人财务管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- fullCalendar -->
    <link rel="stylesheet" href="/plugins/fullcalendar/main.min.css">
    <link rel="stylesheet" href="/plugins/fullcalendar-daygrid/main.min.css">
    <link rel="stylesheet" href="/plugins/fullcalendar-timegrid/main.min.css">
    <link rel="stylesheet" href="/plugins/fullcalendar-bootstrap/main.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- 顶部导航 -->
    <jsp:include page="module/header.jsp"></jsp:include>
    <!-- /.顶部导航结尾 -->

    <!-- 左侧菜单栏 -->
    <jsp:include page="module/sidebar.jsp"></jsp:include>

    <!-- 正文部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>统计页面</h1>
                    </div>
                </div>
            </div>
        </section>

        <div class="card-body">
            <div id="jsGrid1">
                <table class="table table-bordered">
                    <tr>
                        <th>近期总收入</th>
                        <th>近期总支出</th>
                        <th>近期收支情况</th>
                        <th>使用科目的比例</th>
                    </tr>
                    <tr>
                        <th>${gincome}</th>
                        <th>${texpenditure}</th>
                        <th>${iesituation}</th>
                        <th><a href="/statindexs?pageNum=1&rows=5">查询详细情况</a></th>
                    </tr>
                </table>
            </div>
        </div>
        <!-- 正文结束 -->

        <!-- 底部 -->
        <jsp:include page="module/module.jsp"></jsp:include>
        <!-- 底部结束 -->
        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery UI -->
    <script src="/plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- AdminLTE App -->
    <script src="/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/dist/js/demo.js"></script>
    <!-- fullCalendar 2.2.5 -->
    <script src="/plugins/moment/moment.min.js"></script>
    <script src="/plugins/fullcalendar/main.min.js"></script>
    <script src="/plugins/fullcalendar-daygrid/main.min.js"></script>
    <script src="/plugins/fullcalendar-timegrid/main.min.js"></script>
    <script src="/plugins/fullcalendar-interaction/main.min.js"></script>
    <script src="/plugins/fullcalendar-bootstrap/main.min.js"></script>
    <!-- Page specific script -->

</body>
</html>
