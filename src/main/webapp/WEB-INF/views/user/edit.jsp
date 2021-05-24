<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Edytuj Dane</title>
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>" />
</head>
<body>
    <form:form modelAttribute="editUser" method="post">
        <div class="form-group">
            <form:input type="text" path="name" placeholder="${user.name}" />
        </div>
        <div class="form-group">
            <form:input type="text" path="surname" placeholder="${user.surname}" />
        </div>

        <div class="form-group">
            <p>Pamiętaj że adres e-mail to Twój login!</p>
            <form:input type="email" path="email" placeholder="${user.email}" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/user/changePassword" class="btn btn--without-border">Zmień hasło</a>
            <form:button class="btn" type="submit">Zmień Dane</form:button>
        </div>
    </form:form>
</body>
</html>