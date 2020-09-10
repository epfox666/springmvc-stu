<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-10
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>我是首页</h1>
    ${loginuser}
    <a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
