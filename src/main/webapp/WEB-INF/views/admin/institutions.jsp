<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Fundacje</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/adminHeader.jsp"%>
</header>
<h2>Panel Fundacji</h2>


<a href="/admin/institutions/add" class="btn btn--without-border btn--highlighted" style="margin: 3%;">Dodaj
    Fundację</a>


<table id="customTables" class="center">
    <tr>
        <th>Nazwa Fundacji</th>
        <th>Opis</th>
        <th>Operacje</th>
    </tr>
    <c:forEach items="${fundations}" var="fundation">
        <tr>
            <td>${fundation.name}</td>
            <td>${fundation.description}</td>
            <td>
                <a href="/admin/institutions/delete/${fundation.id}">Usuń</a><br>
                <a href="/admin/institutions/edit/${fundation.id}">Edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
