
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册页面</title>
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
    input[type=email], select {
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
    #form {
        width: 350px;
        height: 418px;
        /*border: 1px solid red;*/
        position: absolute;
        right: 150px;
        top: 50%;
        margin-top: -209px;
        border-radius: 15px;
        background: rgba(255, 255, 255,0.0);
    }
    label,h2{
        color: rgba(189,195,199,0.7);
        font-family: "微软雅黑";
    }
    img{
        width: 120px;
        height: 120px;
    }
    .image{
        background: rgba(255, 255, 255,0.0);
    }
</style>
<body>

<div>
    <form id="form"  method="post" enctype="multipart/form-data">
        <h2>注册页面</h2>
        <div class="image">
            <img id="img" src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" onclick="fileSelect()" alt="User Image">
            <input type="file" name="file" id="file" onchange="fileSelected(this)" style="display:none;">
        </div>
        <label >用户名</label>
        <input type="text" id="name" name="name" placeholder="请输入用户名">
        <label >密码</label>
        <input type="password" id="pwd" name="pwd" placeholder="请输入密码">
        <label >再次输入密码</label>
        <input type="password" id="pwd2"  placeholder="请再次输入密码">
        <label  id="notes"></label><br>
        <label >邮箱</label>
        <input type="email" id="email" name="email" placeholder="请输入邮箱">
        <label >手机号</label>
        <input type="text" id="cell" name="cell" placeholder="请输入手机号">
        <input type="submit" id="SignIn" value="注册">
    </form>
</div>
<!-- /.register-box -->

<!-- jQuery -->
<!-- jQuery -->
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script>
    $(function () {
        $("#pwd2").change(function () {
            if ($("#pwd").val()!==$("#pwd2").val()) {
                $("#notes").text("密码不一致");
                $("#notes").css({color:"red"});
                var i=$("#file").val().split('\\');

                alert(i[i.length-1])
            }else{
                $("#notes").text("- OR -");
                $("#notes").css({color:"beige"});

                $("#SignIn").click(function () {
                    if ($("#name").val()!==""){
                        let str=JSON.stringify({"name":$("#name").val(),"pwd":$("#pwd").val(),"file":$("#file").val(),"email":$("#email").val(),"cell":$("#cell").val()});
                        $.post("/index",{"user":str},function () {

                        })
                        $("#form").attr("action","/register").submit
                    }else {
                        $("#form").attr("action","/register.jsp").submit
                        alert("用户名不能为空")
                    }
                })
            }
        })
    })
    function fileSelect() {
        document.getElementById("file").click();
    }

    function fileSelected(obj) {
        // 文件选择后触发此函数
        var name =  document.getElementById("file").value;
        console.log(name);
        $("#img").attr("src",name);
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
