<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 17.06.2020
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add developer to project</title>
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
        <form action="/servlet/developersProjects" method="post">
            <ul>
                <li>Id of developer:
                    <select name="developerId">
                        <c:forEach var="developer" items="${developers}">
                            <option value="<c:out value="${developer.id}"/>"><c:out value="${developer.name}"/></option>
                        </c:forEach>
                    </select>
                </li>
                <li>Id of project:
                    <select name="projectId">
                        <c:forEach var="project" items="${projects}">
                            <option value="<c:out value="${project.id}"/>"><c:out value="${project.name}"/></option>
                        </c:forEach>
                    </select>
                </li>
                <input type="submit" value="Submit">
            </ul>
        </form>
    </body>
</html>
