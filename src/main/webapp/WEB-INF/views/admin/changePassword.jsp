<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <form id="psw" type="password" name="password" placeholder="Nowe Hasło" />
    </div>
    <div class="form-group">
        <input id="psw2" type="password" name="password2" placeholder="Powtórz Hasło" />
    </div>

    <div class="form-group form-group--buttons">
        <form class="btn" type="submit">Zmień hasło</form>
    </div>
</form>
<script src="<c:url value="../../resources/js/register.js"/>"></script>
</body>
</html>
