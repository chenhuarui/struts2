<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <s:form action="add_Student" method="POST" class="formClass">
        <s:textfield name="student.classId" label="班级ID"/>
        <s:textfield name="student.studentId" label="学生ID"/>
        <s:textfield name="student.studentName" label="学生姓名"/>
        <s:textfield name="student.studentAge" label="学生年龄"/>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
