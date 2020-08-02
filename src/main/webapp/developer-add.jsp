<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 14.06.2020
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Developer</title>
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
        <form action="/servlet/developers" method="post">
            <ul>
                <li>Name: <input type="text" name="name"></li>
                <li>Age: <input type="text" name="age"></li>
                <li>Sex:
                    <input type="radio" id="male" name="sex" value="MALE">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="sex" value="FEMALE">
                    <label for="female">Female</label>
                </li>
                <li>Id of IT Company:
                    <select name="itCompanyId">
                        <c:forEach var="company" items="${companies}">
                        <option value="<c:out value="${company.id}"/>"><c:out value="${company.name}"/></option>
                        </c:forEach>
                    </select>
                </li>
                <li>Salary: <input type="text" name="salary"></li>
            <input type="submit" value="Submit">
            </ul>
        </form>
    </body>
</html>
