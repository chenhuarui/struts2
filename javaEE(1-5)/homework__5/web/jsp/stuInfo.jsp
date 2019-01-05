<%@ page import="java.util.List" %>
<%@ page import="entity.StudentEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/9/21
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>学生的信息查询窗口</title>

    <link rel="stylesheet" type="text/css" href="../css/showClass.css">

    <script type="text/javascript" src="../js/stuInfo.js"></script>
</head>
<body onload="onChange()">

        <form action="queryStudent.action" method="post" class="form">

            属性
            <s:select list="#request.listName" name="className" id="className"/>
            
            <s:select list="{'姓名','学号','年龄'}"  name="attribute" id="attribute" onclick="onChange()" class="select"/>

            <s:select list="{'包含','等于','大于','大于等于','小于','小于等于'}" name="operation" id="operate"/>

            <s:textfield name="key"/>
            <input type="submit" value="查询" class="button">
        </form>
        <a href="../jsp/addStudent.jsp" class="addStudent">新增</a>

        <s:if test="#request.classOfStudents.size == 0 || #request.classOfStudents == null">
            <script type="text/javascript">alert("本列表没有该搜索信息")</script>
        </s:if>
        <s:else>
            <table border='1' width='600' cellspacing="4" class="table">
                <tr class="show">
                    <td>班级</td>
                    <td>学号</td>
                    <td>姓名</td>
                    <td class="age">年龄</td>
                    <td>操作</td>
                </tr>

                <%
                    List<StudentEntity> studentEntities = (List<StudentEntity>) request.getAttribute("classOfStudents");

                    for (StudentEntity studentEntity : studentEntities) {
                %>

                <tr>
                    <td>
                        <%=studentEntity.getClassId()%>
                    </td>
                    <td>
                        <%=studentEntity.getStudentId()%>
                    </td>
                    <td>
                        <%=studentEntity.getStudentName()%>
                    </td>
                    <td>
                        <%=studentEntity.getStudentAge()%>
                    </td>

                    <td><a href="input_Student.action?student.studentId=<%=studentEntity.getStudentId()%>">编辑</a>
                        &nbsp;&nbsp;
                        <a href="delete_Student.action?student.studentId=<%=studentEntity.getStudentId()%>
                                    &student.classId=<%=studentEntity.getClassId()%>">删除</a></td>
                </tr>
                <% }%>

                <tr>
                    <td colspan='5' align='middle'>共${request.classOfStudents.size()}人</td>
                </tr>

            </table>
        </s:else>
</body>
</html>
