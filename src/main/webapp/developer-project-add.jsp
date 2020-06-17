<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 17.06.2020
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add developer to project</title>
</head>
    <body>
        <form action="/servlet/developersProjects" method="post">
            <ul>
                <li>Id of developer: <input type="text" name="developerId"></li>
                <li>Id of project: <input type="text" name="projectId"></li>
                <input type="submit" value="Submit">
            </ul>
        </form>
    </body>
</html>
