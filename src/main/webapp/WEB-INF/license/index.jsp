<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All People</h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
<%--        <th>License #</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td><a href="persons/${person.id}"><c:out value="${person.firstName}"/></a></td>
            <td><c:out value="${person.lastName}"/></td>
<%--            <td><c:out value="${person.license.getStringNumber}"/></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
