<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/18
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增班级界面</title>
    <link rel="stylesheet" type="text/css" href="../css/showClass.css">
</head>
<body>

    <form action="add_Class.action" method="post" class="form_add">
        班级ID:<input type="text" name="clazzEntity.id">
        编号:<input type="text" name="clazzEntity.serialNumber">
        <input type="submit" value="确定" class="submit">
    </form>

</body>
</html>
