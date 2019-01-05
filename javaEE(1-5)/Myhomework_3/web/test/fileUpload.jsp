<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/1
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>上传文件页面</title>
</head>
<body>

    <%--<s:form action="fileUpload" theme="simple" method="POST" enctype="multipart/form-data">--%>
        <%--<s:file name="file" label="上传文件"/>--%>
        <%--<s:submit value="上传"/>--%>
        <%--<s:reset value="重置"/>--%>
    <%--</s:form>--%>


    <s:form action="upload" method="post" enctype="multipart/form-data">
        <s:file name="file" label="上传的文件"/>
        <s:submit value="上传"/>
    </s:form>

</body>
</html>
