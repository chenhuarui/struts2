<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/9/28
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="../../css/stuInfo.css">
</head>
<body>

    <div class="container">
        <h1 align="center"style="color:black ; font-size:75px">学生班级管理系统</h1>
        <form action="Login.action" method="post" class="loginClass">
            UserName:<input type="text" name="userName">
            <br>
            Password:<input type="password" name="password">
            <br>
            <input type="submit" value="Login" class="loginClass">
        </form>
        <span>${requestScope.msg}<br></span>
    </div>

</body>
</html>
