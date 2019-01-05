<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/20
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生信息</title>
    <link rel="stylesheet" type="text/css" href="../css/showClass.css">
</head>
<body>

    <form action="add_Student.action" method="post" class="form_add">
        班级:<input type="text" name="student.classId"/><br>
        学号:<input type="text" name="student.studentId"/><br>
        姓名:<input type="text" name="student.studentName"/><br>
        年龄:<input type="text" name="student.studentAge"/><br>
        <input type="submit" value="确定" class="submit"/><br>
    </form>

</body>
</html>
