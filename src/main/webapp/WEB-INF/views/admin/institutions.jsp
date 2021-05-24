<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fundacje</title>
</head>
<body>
<ul>
    <c:forEach items="${fundations}" var="fundation">
        <li>${fundation.name}</li>
    </c:forEach>
</ul>
</body>
</html>
