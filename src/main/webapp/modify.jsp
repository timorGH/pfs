<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- fullCalendar -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fullcalendar/main.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fullcalendar-daygrid/main.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fullcalendar-timegrid/main.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fullcalendar-bootstrap/main.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<head>
    <title></title>
    <style type="text/css">
        .d1{
            width: 500px;
            height: 1000px;
            position:absolute; top:35%;left:50%; margin-top:-100px; margin-left:-200px;
        }
    </style>
</head>
<body>
<!-- 顶部导航 -->
<jsp:include page="module/header.jsp"></jsp:include>
<!-- /.顶部导航结尾 -->

<!-- 左侧菜单栏 -->
<jsp:include page="module/sidebar.jsp"></jsp:include>

!-- 正文部分 -->
<div class="content-wrapper divd1" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>修改单个记录</h1>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <form action="/updateAccountsById" method="post" class="d1">
        <input name="id" value="${accounts.id}" type="hidden">
        <input name="icategory" value="${accounts.icategory}" type="hidden">
        <div class="form-group">
            <label>金额</label>
            <input type="text" name="money" value="${accounts.money}" class="form-control" id="amount" placeholder="Email">
        </div>
        <div class="form-group">
            <label>类型</label>
            <select id="usubname" name="classif" style="height: 40px;width: 500px">
                <option value="">请选择科目</option>
                <c:forEach items="${subjectList}" var="subject">
                    <option value="${subject.s_name}">${subject.s_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>备注</label>
            <input type="text" name="remark" value="${accounts.remark}" class="form-control" id="remarks" placeholder="Password">
        </div>

        <button type="submit" class="btn btn-default">确定</button>
        <input onclick="goback()" class="btn btn-default" type="button" value="返回" />
    </form>
    <!-- 正文结束 -->
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- 底部 -->
<jsp:include page="module/module.jsp"></jsp:include>
<!-- 底部结束 -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jQuery UI -->
<script src="${pageContext.request.contextPath}/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
<!-- fullCalendar 2.2.5 -->
<script src="${pageContext.request.contextPath}/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullcalendar/main.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullcalendar-bootstrap/main.min.js"></script>
<!-- Page specific script -->
<%--               模态框--%>
<%--                模态框结束--%>
<script>
    function goback() {
        var str = '收入';
        if(("${accounts.icategory}")==str){
            window.location.href="/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=";
        }else{
            window.location.href="/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=";
        }
        $(function () {
            var message = '${message}';
            if(message !=''){
                window.alert(message);
            }
        })
    }
</script>
</body>
</html>
