<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administracja</title>
</head>
<body>
<ul>
    <c:forEach items="${admins}" var="admin">
        <li>${admin.name}</li>
    </c:forEach>
</ul>
</body>
</html>
