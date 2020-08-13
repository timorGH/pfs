<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20 0020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Logo -->
    <div class="brand-link">
        <img src="../dist/img/AdminLTELogo.png"
             alt="AdminLTE Logo"
             class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">财务管理</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a style="color: #ff0000" class="bt1">注销</a>
    </div>
    <!-- 个人信息 -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img data-toggle="modal" data-target="#exampleModal" src="${loginUser.fileurl}" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a  data-toggle="modal" data-target="#exampleModal" class="d-block">${loginUser.username} Welcome</a>

            </div>

        </div>
        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview">
                    <a href="/index.jsp" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            首页
                        </p>
                    </a>

                </li>

                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-copy"></i>
                        <p>
                            个人财务管理
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>收入管理</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/expenditureIndex?pageNum=1&rows=5" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>支出管理</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/statisticsIndex" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>查询统计</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>

    </div>
    <!-- /.sidebar-menu -->
    <!-- /.sidebar -->
</aside>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">个人信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/updateUserInfoServlet" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="image" align="center">
                        <img  style="width: 75px; height: 75px" id="img" src="${loginUser.fileurl}" class="img-circle elevation-2" onclick="fileSelect()" alt="User Image">
                        <input type="file" name="file" id="file" onclick="fileSelected(this)" style="display:none;">
                    </div>
                    <input name="id" value="${loginUser.id}" type="hidden">
                    <div class="form-group">
                        <label>用户名：</label>
                        <input type="text" class="form-control" id="name" name="username"  placeholder="请输入用户名" value="${loginUser.username}" />
                    </div>
                    <div class="form-group">
                        <label >手机号：</label>
                        <input type="text" class="form-control" id="telphone" value="${loginUser.telphone}" name="cell" placeholder="请输入手机号码"/>
                    </div>

                    <div class="form-group">
                        <label >Email：</label>
                        <input type="email" class="form-control" id="email" value="${loginUser.email}" name="email" placeholder="请输入邮箱地址"/>
                    </div>
                    <div class="form-group">
                        <label >密码：</label>
                        <input type="password" class="form-control" id="password" value="${loginUser.password}" name="password" placeholder="请输入新密码"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" id="MO" class="btn btn-default" data-dismiss="modal">退出</button>
                    <input type="submit" id="MD" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>

        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
        <span class="glyphicon-class">glyphicon glyphicon-off</span>

</div>
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script>
    function fileSelect() {
        document.getElementById("file").click();
    }

    function fileSelected(obj) {
        // 文件选择后触发此函数
        $("#img").src="${pageContext.request.contextPath}"+obj;
    }
    $('#exampleModal').on('shown.bs.modal', function () {
        $('#myInput').focus()
    })

    $(function(){
        $(".bt1").click(function(){
            if(confirm("你确定要退出吗")==true){
                window.location.href="/login.jsp"
            }
        })
    })
</script>





</body>
</html>
