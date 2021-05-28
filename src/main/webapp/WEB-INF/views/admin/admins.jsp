<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Administracja</title>
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
<h2>Panel Administratorów</h2>

<a href="/admin/addAdmin" class="btn btn--without-border btn--highlighted" style="margin: 3%;">Dodaj Nowe Konto Administratorskie</a>


<table id="customTables" class="center">
    <tr>
        <th>Email</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Role</th>
        <th>Operacje</th>
    </tr>
    <c:forEach items="${admins}" var="admin">
        <tr>
            <td>${admin.email}</td>
            <td>${admin.name}</td>
            <td>${admin.surname}</td>
            <td>${admin.roles}</td>
            <td>
                <a href="/admin/deleteAdmin/${admin.id}">Usuń</a><br>
                <a href="/admin/editAdmin/${admin.id}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
