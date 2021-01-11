<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Person</title>
</head>
<body>
<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
<ul>
    <li>License Number: <c:out value="${person.license.numberAsString}"/></li>
    <li>State: <c:out value="${person.license.state}"/></li>
    <li>Expiration Date: <c:out value="${person.license.formatedDate}"/></li>
</ul>
</body>
</html>
