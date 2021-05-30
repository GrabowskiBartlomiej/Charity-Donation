<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Użytkownicy</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/adminHeader.jsp"%>
</header>
<h2>Panel Użytkowników</h2>
<a href="/admin/users/add" class="btn btn--without-border btn--highlighted" style="margin: 3%;">Dodaj Nowego Użytkownika</a>

<table id="customTables" class="center">
    <tr>
        <th>Email</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Role</th>
        <th>Operacje</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.roles}</td>
            <td>
                <a href="/admin/users/delete/${user.id}">Usuń</a><br>
                <a href="/admin/users/edit/${user.id}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
