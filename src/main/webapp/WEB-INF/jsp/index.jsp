<%@ page import="cn.edu.csu.dyp.model.User" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019/10/14
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello,${requestScope.User.username},your nickname is${requestScope.User.nickname},your <del>password</del>phone number is${requestScope.User.phoneNumber}
</body>
</html>
