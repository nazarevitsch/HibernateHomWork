<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 14.06.2020
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>List of Developers</title>
</head>
    <body>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Age</td>
                <td>Sex</td>
                <td>It Company Id</td>
                <td>Salary</td>
            </tr>
            <c:forEach var="developer" items="${developers}">
                <tr>
                    <td><c:out value="${developer.id}"/></td>
                    <td><c:out value="${developer.name}"/></td>
                    <td><c:out value="${developer.age}"/></td>
                    <td><c:out value="${developer.sex}"/></td>
                    <td><c:out value="${developer.itCompanyId}"/></td>
                    <td><c:out value="${developer.salary}"/></td>
                    <td id="<c:out value='${developer.id}'/>"><button type="button" onclick="handleDelete(this)">Remove</button></td>
                </tr>
            </c:forEach>
        </table>
    <script type="text/javascript">
        function handleDelete(element) {
            $.ajax({
                url: "/servlet/developers?id=" + element.parentElement.id,
                type: "DELETE",
                success: () => {
                    location.reload();
                }
            });
        }
    </script>
    </body>
</html>
