<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/21
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生信息</title>
</head>
<body>

    <s:form action="update_Student" method="post" class="formClass">
        <s:textfield name="student.studentId" label="学生ID" readonly="true"/>
        <s:textfield name="student.studentName" label="学生姓名"/>
        <s:textfield name="student.studentAge" label="学生年龄"/>
        <s:textfield name="student.classId" label="所在班级号"/>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
