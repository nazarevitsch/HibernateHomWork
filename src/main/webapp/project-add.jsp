<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 15.06.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Project</title>
</head>
    <body>
    <form action="/servlet/projects" method="post">
        <ul>
            <li>Name: <input type="text" name="name"></li>
            <li>Start Date:
                <input type="date"  name="startDate">
            </li>
            <li>End Date:
                <input type="date"  name="endDate">
            </li>
            <input type="submit" value="Submit">
        </ul>
    </form>
    </body>
</html>
