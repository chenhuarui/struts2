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

    <link rel="stylesheet" type="text/css" href="../../css/stuInfo.css">
    <script type="text/javascript" src="../../js/stuInfo.js"></script>
</head>
<body onload="onChange()">

    <form action="queryStudent.action" method="post" class="form">
            属性
                <s:select list="{'姓名','学号','年龄'}"  name="attribute" id="attribute" onclick="onChange()" class="select"/>

                <s:select list="{'包含','等于','大于','大于等于','小于','小于等于'}" name="operation" id="operate"/>

                <s:textfield name="key"/>
            <input type="submit" value="查询" class="button">
    </form>


    <table border='1' width='600' cellspacing="4" class="table">
        <s:if test="#request.studentList.size == 0 || #request.studentList == null">
            <script type="text/javascript">alert("本列表没有该搜索信息")</script>
        </s:if>
        <s:else>
                <tr class="show">
                    <td>学号</td>
                    <td>姓名</td>
                    <td class="age">年龄</td>
                </tr>

            <%--对值栈的操作--%>
            <%--1.向值栈中放数据：可以通过值栈的set，push方法或者在action中提供成员变量然后提供get方法即可。--%>
            <%--2.从值栈中取数据：使用struts2的标签+ognl表达式获取值栈数据 <s:property value=”ognl表达式”/>--%>
            <s:iterator value="studentList" status="list">
                <tr>
                    <td><s:property value="stuNo"/></td>
                    <td><s:property value="stuName"/></td>
                    <td class="age"><s:property value="age"/></td>
                </tr>
            </s:iterator>

        </s:else>
        <tr>
            <td colspan='3' align='middle'>共${request.studentList.size()}人</td>
        </tr>

    </table>


</body>
</html>
