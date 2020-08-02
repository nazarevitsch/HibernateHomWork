<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 17.06.2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>List of developers-projects</title>
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
<table border="1px">
    <tr>
        <td>Id</td>
        <td>Id of developer</td>
        <td>Id of project</td>
        <td>DELETE</td>
    </tr>
    <c:forEach var="developerProject" items="${developersProjects}">
        <tr>
            <td><c:out value="${developerProject.id}"/></td>
            <td><c:out value="${developerProject.developerId}"/></td>
            <td><c:out value="${developerProject.projectId}"/></td>
            <td id="<c:out value='${developerProject.id}'/>"><button type="button" onclick="handleDelete(this)">Remove</button></td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    function handleDelete(element) {
        console.log(element.parentElement.id);
        $.ajax({
            url: "/servlet/developersProjects?id=" + element.parentElement.id,
            type: "DELETE",
            success: () => {
                location.reload();
            }
        });
    }
</script>
</body>
</html>
