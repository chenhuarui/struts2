<%@ page import="homework.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/9/21
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
<head>
    <title>学生的信息查询窗口</title>

    <link rel="stylesheet" type="text/css" href="../../css/stuInfo.css">

    <script type="text/javascript" src="../../js/stuInfo.js"></script>
</head>
<body onload="onChange()">

    <%--根据List是否为空判断是否要上传文件--%>
    <%--studentList相当于是application.put的String类型的字符串代码--%>
    <s:if test="#request.studentList == null">
        <s:form action="upload" method="post" enctype="multipart/form-data">
            <s:file name="file" label="上传的文件"></s:file>
            <s:submit value="上传"></s:submit>
        </s:form>

    </s:if>
    <s:else>
        <form action="queryStudent.action" method="post" class="form">
            属性
            <s:select list="{'姓名','学号','年龄'}"  name="attribute" id="attribute" onclick="onChange()" class="select"></s:select>

            <s:select list="{'包含','等于','大于','大于等于','小于','小于等于'}" name="operation" id="operate"></s:select>

            <s:textfield name="key"></s:textfield>
            <input type="submit" value="查询" class="button">
        </form>


        <s:if test="#request.studentList.size == 0 || #request.studentList == null">
            <script type="text/javascript">alert("本列表没有该搜索信息")</script>
        </s:if>
        <s:else>
            <table border='1' width='600' cellspacing="4" class="table">
                <tr class="show">
                    <td>学号</td>
                    <td>姓名</td>
                    <td class="age">年龄</td>
                </tr>

                <% List<Student> students = (List<Student>) request.getAttribute("studentList");
                   for(int i=0; i<students.size(); i++) {
                %>
                    <tr>
                        <td><%=students.get(i).getStuNo()%></td>
                        <td><%=students.get(i).getStuName()%></td>
                        <td class="age"><%=students.get(i).getAge()%></td>
                    </tr>
                <% }%>

                <tr>
                    <td colspan='3' align='middle'>共${request.studentList.size()}人</td>
                </tr>

            </table>
        </s:else>

        <a href="downloadFile.action?screen.attribute=${attribute}&screen.operation=${operation}&screen.key=${key}"
            class="download">Download-file</a>
</s:else>

</body>
</html>
