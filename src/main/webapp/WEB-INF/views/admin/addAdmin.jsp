<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="formr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Dodaj Admina</title>
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
        <h2>Nowy administrator</h2>
        <form:form modelAttribute="newUser" method="post">
            <div class="form-group">
                <form:input type="text" path="name" placeholder="Imię" />
            </div>
            <div class="form-group">
                <form:input type="text" path="surname" placeholder="Nazwisko" />
            </div>
            <div class="form-group">
                <form:input type="email" path="email" placeholder="Email" />
            </div>
            <div class="form-group">
                <p>Przynajmniej po jednej dużej i małej literze. Hasło o długości 6-20 znaków.</p>
                <form:input id="psw" type="password" path="password" placeholder="Hasło" pattern="^(?=.*[a-z])(?=.*[A-Z]).{6,20}$"/>
            </div>
            <div class="form-group">
                <input id="psw2" type="password" name="password2" placeholder="Powtórz hasło" />
                <p id="failPswCheck" style="display: none; color: red">Hasła się nie zgadzają.</p>
            </div>

            <div class="form-group form-group--buttons">
                <form:button class="btn" type="submit">Załóż konto</form:button>
            </div>
        </form:form>
</section>
</body>
</html>
