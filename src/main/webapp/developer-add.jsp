<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 14.06.2020
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Developer</title>
</head>
    <body>
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
                <li>Id of IT Company: <input type="text" name="itCompanyId"></li>
                <li>Salary: <input type="text" name="salary"></li>
            <input type="submit" value="Submit">
            </ul>
        </form>
    </body>
</html>
