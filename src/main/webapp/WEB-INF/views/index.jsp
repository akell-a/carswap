<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
<div align="center">
    <h1>Contact List</h1>
    <table border="1">
        <th>Name</th>
        <th>Second Name</th>

        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.name}</td>
                <td>${user.secondName}</td>
            </tr>
        </c:forEach>

        <%--<tr>--%>
            <%--<td>${user1.name}</td>--%>
            <%--<td>${user1.secondName}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>${user2.name}</td>--%>
            <%--<td>${user2.secondName}</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>${user3.name}</td>--%>
            <%--<td>${user3.secondName}</td>--%>
        <%--</tr>--%>
    </table>
</div>
</body>
</html>