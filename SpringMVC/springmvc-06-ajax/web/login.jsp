<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
        function a1() {
            $.post("${pageContext.request.contextPath}/a3",{"name":$("#username").val()},function (data) {
                if(data.toString()==="ok"){
                    $("#userInfo").css("color","green")
                }else{
                    $("#userInfo").css("color","red")
                }
                $("#userInfo").html(data)
            })
        }
        function a2() {
            $.post("${pageContext.request.contextPath}/a3",{"pwd":$("#password").val()},function (data) {
                if(data.toString()==="ok"){
                    $("#pwdInfo").css("color","green")
                }else{
                    $("#pwdInfo").css("color","red")
                }
                $("#pwdInfo").html(data)
            })
        }
    </script>
</head>
<body>
用户名：<input type="text" id="username" onblur="a1()">
        <span id="userInfo"></span><br>
密码：<input type="text" id="password" onblur="a2()">
        <span id="pwdInfo"></span>
</body>
</html>
