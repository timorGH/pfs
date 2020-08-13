<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20 0020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="card">
            <div class="card-header">
                <h3 class="card-title">Bordered Table</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th style="width: 10px">编号</th>
                        <th>类型</th>
                        <th>Progress</th>
                        <th style="width: 40px">比例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="remark" varStatus="index">
                    <tr>
                        <td>${index.index+1}</td>
                        <td>${remark.remarkname}</td>
                        <td>
                            <div class="progress progress-xs">
                                <div class="progress-bar progress-bar-danger" style="width: ${remark.proportion}%"></div>
                            </div>
                        </td>
                        <td><span class="badge bg-danger">${remark.proportion}%</span></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /.card-body -->
            <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">

<%--                    上一页 --%>
                    <c:if test="${pageInfo.pageNum == 1}">
                        <li class="page-item disabled" >
                            <a class="page-link" href="/statindexs?pageNum=${(pageInfo.pageNum)-1}&rows=5">&laquo;</a>
                        </li>
                    </c:if>
                   <c:if test="${pageInfo.pageNum != 1}">
                        <li class="page-item">
                            <a class="page-link" href="/statindexs?pageNum=${(pageInfo.pageNum)-1}&rows=5">&laquo;</a>
                        </li>
                    </c:if>

    <%--                    中间--%>
                    <c:forEach begin="1" end = "${pageInfo.totalPage}" step="1" var="i">
                    <c:if test="${pageInfo.pageNum == i}">
                        <li class="page-item disabled" >
                            <a class="page-link" href="/statindexs?pageNum=${i}&rows=5">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != i}">
                        <li class="page-item">
                            <a class="page-link" href="/statindexs?pageNum=${i}&rows=5">${i}</a>
                        </li>
                    </c:if>

                    </c:forEach>

    <%--                    下一页--%>
                    <c:if test="${pageInfo.pageNum == pageInfo.totalPage}">
                        <li class="page-item disabled" >
                            <a class="page-link" href="#">&raquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != pageInfo.totalPage}">
                        <li class="page-item">
                            <a class="page-link" href="/statindexs?pageNum=${(pageInfo.pageNum)+1}&rows=5">&raquo;</a>
                        </li>
                    </c:if>

                    <li style="margin-left: 20px" >
                        <h3 style="display: inline">总共${pageInfo.totalNum}条记录,共${pageInfo.totalPage}页</h3>
                    </li>
                </ul>
            </div>
        </div>

    </div>>

    <!-- 底部 -->
    <jsp:include page="module/module.jsp"></jsp:include>
    <!-- 底部结束 -->
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
