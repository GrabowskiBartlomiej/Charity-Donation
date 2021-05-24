<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
    <header>
        <nav class="container container--70">
            <ul class="nav--actions">
                <li><a href="/user/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
            </ul>

            <ul>
                <li><a href="/admin/allAdmins" class="btn btn--without-border">Administracja</a></li>
                <li><a href="/admin/allUsers" class="btn btn--without-border">Użytkownicy</a></li>
                <li><a href="/admin/allInstitutions" class="btn btn--without-border">Fundacje</a></li>
                <li><form action="/logout" method="post"><button class="btn btn--without-border" type="submit">Wyloguj</button></form></li>
            </ul>
        </nav>
    </header>
    <h2>Admin Dashboard</h2>
    <footer>
        <div class="contact">
        </div>
        <div class="bottom-line">
            <span class="bottom-line--copy">Copyright &copy; 2018</span>
            <div class="bottom-line--icons">
                <a href="#" class="btn btn--small"><img src="<c:url value="../../resources/images/icon-facebook.svg"/>"></a>
                <a href="#" class="btn btn--small"><img src="<c:url value="../../resources/images/icon-instagram.svg"/>"></a>
            </div>
        </div>
    </footer>
</body>
</html>
