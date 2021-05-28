<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Change Password</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/user/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
        </ul>

        <ul>
            <li><a href="/admin/allDonations" class="btn btn--without-border">Dary</a></li>
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

<section class="login-page">
<h2>Zmień hasło administratora</h2>
    <form method="post">
        <div class="form-group">
            <input   id="psw" type="password" name="password" placeholder="Nowe Hasło" />
        </div>
        <div class="form-group">
            <input id="psw2" type="password" name="password2" placeholder="Powtórz Hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zmień hasło</button>
        </div>
    </form>
</section>

<script src="<c:url value="../../resources/js/register.js"/>"></script>
</body>
</html>
