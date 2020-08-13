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
                        <h1>支出页面</h1>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.card-header -->
        <div class="card-body">
            <div class="card-header col-lg-9">
                <form class="form-inline" action="/expenditureIndex?pageNum=1&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">
                    <div class="form-group">
                        <label>金额：</label>
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <input type="text" class="form-control" id="money" name="money" value="${condition.money[0]}" placeholder="金额">
                    </div>
                    <div class="form-group">
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <label>时间：</label>
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <input type="date" class="form-control" name="addtime" value="${condition.addtime[0]}" id="addtime">
                    </div>
                    <div class="form-group">
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <label>类型：</label>
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <select id="classif1" lay-filter="科目名称" name="classif" value="${condition.classif[0]}" style="width: 150px;height: 40px">
                            <option value="" >请选择科目</option>
                            <c:forEach var="subject" items="${subjectList}">
                                <option value="${subject.s_name }" >${subject.s_name }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <label>备注：</label>
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <input type="text" class="form-control" id="remark1" name="remark" value="${condition.remark[0]}" placeholder="备注">
                        <div class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    </div>
                    <button type="submit"id="search" class="btn btn-default">搜索</button>
                </form>
            </div>
            <div class="card-header col-lg-3">
                <button type="button"  class="btn btn-success" data-toggle="modal" data-target="#exampleModal1">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/downAccounts?icategory=0">下载Excel</a>
            </div>
            <div id="jsGrid1">
                <table class="table table-bordered">
                    <tr>
                        <th>编号</th>
                        <th>支出金额</th>
                        <th>添加时间</th>
                        <th>科目类型</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="accounts" varStatus="index">
                        <tr>
                            <td>${index.index+1}</td>
                            <td>${accounts.money}</td>
                            <td>${accounts.addtime}</td>
                            <td>${accounts.classif}</td>
                            <td>${accounts.remark}</td>
                            <td>
                                <a href="/getAccountsById?id=${accounts.id}">修改</a>
                                <a href="/deleteAccountsById?id=${accounts.id}&icategory=0">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">

                    <%--                    上一页 --%>
                    <c:if test="${pageInfo.pageNum == 1}">
                        <li class="page-item disabled" >
                            <a class="page-link" href="/expenditureIndex?pageNum=${(pageInfo.pageNum)-1}&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum != 1}">
                        <li class="page-item">
                            <a class="page-link" href="/expenditureIndex?pageNum=${(pageInfo.pageNum)-1}&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">&laquo;</a>
                        </li>
                    </c:if>

                    <%--                    中间--%>
                    <c:forEach begin="1" end = "${pageInfo.totalPage}" step="1" var="i">
                        <c:if test="${pageInfo.pageNum == i}">
                            <li class="page-item disabled" >
                                <a class="page-link" href="/expenditureIndex?pageNum=${i}&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != i}">
                            <li class="page-item">
                                <a class="page-link" href="/expenditureIndex?pageNum=${i}&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">${i}</a>
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
                            <a class="page-link" href="/expenditureIndex?pageNum=${(pageInfo.pageNum)+1}&rows=5&money=${condition.money[0]}&addtime=${condition.addtime[0]}&classif=${condition.classif[0]}&remark=${condition.remark[0]}">&raquo;</a>
                        </li>
                    </c:if>

                    <li style="margin-left: 20px" >
                        <h3 style="display: inline">总共${pageInfo.totalNum}条记录,共${pageInfo.totalPage}页</h3>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.card-body -->
        <!-- 正文结束 -->

        <!-- 底部 -->
        <jsp:include page="module/module.jsp"></jsp:include>
        <!-- 底部结束 -->
        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
        <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">账务信息</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/insertAccountsServlet?icategory=0" method="post" >
                        <div class="modal-body">
                            <div class="form-group">
                                <label>收入金额：</label>
                                <input type="text" class="form-control" id="name" name="money"  placeholder="请输入金额" />
                            </div>
                            <div class="form-group">
                                <label >科目类型：</label>
                                <select id="classif" lay-filter="科目名称" name="classif" style="width: 466px;height: 40px">
                                    <option value="" >请选择科目</option>
                                    <c:forEach var="subject" items="${subjectList}">
                                        <option value="${subject.s_name }" >${subject.s_name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label >备注：</label>
                                <input type="text" class="form-control" id="remark"  name="remark" placeholder="请输入备注"/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="MO" class="btn btn-default" data-dismiss="modal">退出</button>
                            <input type="submit" id="MD" class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
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

    <script>
        $('#exampleModal1').on('shown.bs.modal', function () {
            $('#myInput').focus()
        })
        $(function () {
            var message = '${message}';
            if(message !=''){
                window.alert(message);
            }
        })
    </script>
</body>
</html>
