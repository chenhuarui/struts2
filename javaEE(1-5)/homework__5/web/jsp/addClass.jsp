<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <s:form action="add_Class" method="POST" class="formClass">
        <s:textfield name="clazzEntity.id" label="班级ID"/>
        <s:textfield name="clazzEntity.serialNumber" label="班级名称"/>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
