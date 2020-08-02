<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 02.08.2020
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Project</title>
</head>
<body>
<ul>
    <li><a href="index.jsp">Main Page</a></li>
    <li><a href="/servlet/developers">List Of Developers</a></li>
    <li><a href="/servlet/developer_add">Add Developers</a></li>
    <li><a href="/servlet/projects">List Of Projects</a></li>
    <li><a href="/servlet/project-add.jsp">Add Projects</a></li>
    <li><a href="/servlet/developersProjects">List of Developers Projects</a></li>
    <li><a href="/servlet/developer_project_add">Add Developers Projects</a></li>
</ul>
    <form action="/servlet/project_edit" method="post">
        <ul>
            <li>ID: <c:out value="${project.id}"/><input hidden name="id" value="<c:out value="${project.id}"/>"/> </li>
            <li>Name: <input type="text" name="name" value="<c:out value="${project.name}"/>"/></li>
            <li>Start Date:
                <input type="date"  name="startDate" value="<c:out value="${project.startDate}"/>"/>
            </li>
            <li>End Date:
                <input type="date" name="endDate" value="<c:out value="${project.endDate}"/>" >
            </li>
            <input type="submit" value="Submit">
        </ul>
    </form>
</body>
</html>
