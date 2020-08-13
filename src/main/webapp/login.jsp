
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录页面</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<style>
    body{
        background: url(/img/4.jpg) no-repeat fixed center;
        background-size: 100%;
    }
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type=password], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
    #big {
        width: 350px;
        height: 418px;
        /*border: 1px solid red;*/
        position: absolute;
        right: 150px;
        top: 50%;
        margin-top: -209px;
        border-radius: 15px;
        background: rgba(255, 255, 255, 0.0);
    }
    label,h2{
        color: gainsboro;
        font-family: "微软雅黑";
    }

</style>
<body>

<div>
    <form id="big" action="/login" method="post">
        <h2>登录页面</h2>
        <label class="col-10">用户名</label><a href="/register.jsp">注册</a>
        <input type="text" id="fname" name="name" placeholder="请输入用户名">
        <label class="col-10">密码</label>
        <input type="password" id="lname" name="pwd" placeholder="请输入密码">

        <label class="col-10">验证码</label>
        <input type="text" id="lname2" name="yzm" placeholder="请输入验证码">
        <a href="javaScript:refreshCode()"><img src="/verify" title="看不清点击刷新" id="vcode"  style="width: 220px; height: 90px;"/></a>
        <input type="submit" value="登录">
    </form>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script>
    function refreshCode() {
        var img = document.getElementById("vcode");
        img.src = "/verify?time="+new Date();
    }
    $(function () {
        var message = '${message}';
        if(message !=''){
            window.alert(message);
        }
    })
</script>
</body>
</html>
