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
</head>
<body>

    <span>${requestScope.msg}<br></span>
    <form action="testLogin.action" method="post">
        userName: <input type="text" name="userName">
        password: <input type="password" name="password">
        <input type="submit" value="Login">
    </form>

</body>
</html>
