<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Edytuj Administratora</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/user/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
        </ul>

        <ul>
            <li><a href="/admin/dashboard" class="btn btn--without-border">Dashboard</a></li>
            <li><a href="/admin/allUsers" class="btn btn--without-border">Użytkownicy</a></li>
            <li><a href="/admin/allInstitutions" class="btn btn--without-border">Fundacje</a></li>
            <li>
                <form action="/logout" method="post">
                    <button class="btn btn--without-border" type="submit">Wyloguj</button>
                </form>
            </li>
        </ul>
    </nav>
</header>

<h2>Edytuj Administratora</h2>
<section class="login-page">
    <form:form modelAttribute="editAdmin" method="post">
        <p style="font-size: 15px;">Email:</p>
        <div style="display: none">
            <form:input path="id" placeholder="${editAdmin.id}" readonly="true"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="email" placeholder="#{editAdmin.email}}"/>
        </div>
        <p style="font-size: 15px;">Imię:</p>
        <div class="form-group">
            <form:input type="text" path="name" placeholder="${editAdmin.name}"/>
        </div>
        <p style="font-size: 15px;">Nazwisko:</p>
        <div class="form-group">
            <form:input type="text" path="surname" placeholder="${editAdmin.surname}"/>
        </div>
        <p style="font-size: 15px;">Rola:</p>
        <div class="form-group">
            <form:radiobutton path="roles" value="ADMIN"/>ADMIN
            <form:radiobutton path="roles" value="USER"/>USER
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/changePassword" class="btn btn--without-border">Zmień hasło</a>
            <form:button class="btn" type="submit">Zatwierdź Zmiany</form:button>
        </div>
    </form:form>
</section>
</body>
</html>
