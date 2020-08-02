<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 02.08.2020
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Developer Edit</title>
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
    <form action="/servlet/developer_edit" method="post">
        <ul>
            <li>Developer ID: <c:out value="${developer.id}"/><input name="id" value="<c:out value="${developer.id}"/>" hidden/></li>

            <li>Name: <input type="text" name="name" value="<c:out value="${developer.name}"/>"></li>
            <li>Age: <input type="text" name="age" value="<c:out value="${developer.age}"/>"></li>
            <li>Sex:
                <c:set var="sex" scope="session" value="${developer.sex}"/>
                <input type="radio" id="male" name="sex" value="MALE" <c:if test="${sex=='MALE'}">checked</c:if>>
                <label for="male">Male</label>
                <input type="radio" id="female" name="sex" value="FEMALE" <c:if test="${sex=='FEMALE'}">checked</c:if>>
                <label for="female">Female</label>
            </li>
            <li>Id of IT Company:
                <select name="itCompanyId">
                    <c:forEach var="company" items="${companies}">
                        <option value="<c:out value="${company.id}"/>" <c:if test="${company.id==developer.itCompanyId}">selected</c:if> ><c:out value="${company.name}"/></option>
                    </c:forEach>
                </select>
            </li>
            <li>Salary: <input type="text" name="salary" value="<c:out value="${developer.salary}"/>"></li>
            <input type="submit" value="Submit">
        </ul>
    </form>
</body>
</html>
