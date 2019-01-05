<%@ page import="entity.ClazzEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈华睿
  Date: 2018/10/16
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>班级展示</title>
    <link rel="stylesheet" type="text/css" href="../css/showClass.css">

</head>
    <div class="addClass"><s:a href="/jsp/addClass.jsp">新增</s:a></div>
    <table border='1' width='600' cellspacing="4" class="table">
        <tr class="show">
            <td class="ID">ID</td>
            <td>编号</td>
            <td class="option">操作</td>
        </tr>

      <%
          List<ClazzEntity> classes = (List<ClazzEntity>) request.getAttribute("clazzEntities");
          List<Long> numbers = (List<Long>) request.getAttribute("countList");
          for(int i=0;i<classes.size();i++) {
      %>

        <tr>
            <td><%=classes.get(i).getId()%></td>
            <td><%=classes.get(i).getSerialNumber()%>(<%=numbers.get(i)%>人)</td>
            <td><a href="input_Class.action?clazzEntity.id=<%=classes.get(i).getId()%>">编辑</a>
                &nbsp&nbsp
                <% if(numbers.get(i)==0) { %>
                    <a href="delete_Class.action?clazzEntity.id=<%=classes.get(i).getId()%>">删除</a>
                <% }else { %>
                    <a href="details_Class.action?clazzEntity.id=<%=classes.get(i).getId()%>">查看</a>
                <% }%>

            </td>
        </tr>
        <% }%>

        <tr>
            <td colspan='3' align='middle'>共${request.clazzEntities.size()}班</td>
        </tr>

    </table>

</body>
</html>
