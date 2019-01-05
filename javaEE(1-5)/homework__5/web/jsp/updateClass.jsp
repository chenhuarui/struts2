<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/18
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>编辑班级页面</title>
</head>
<body>

    <s:form action="update_Class" method="post" class="formClass">
        <s:textfield name="clazzEntity.id" label="班级ID" readonly="true"/>
        <s:textfield name="clazzEntity.serialNumber" label="编号"/>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
