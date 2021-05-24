<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Użytkownicy</title>
</head>
<body>
<ul>
    <c:forEach items="${users}" var="user">
        <li>${user.name}</li>
    </c:forEach>
</ul>
</body>
</html>
