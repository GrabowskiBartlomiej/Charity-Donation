<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Donacje</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/adminHeader.jsp"%>
</header>
<h2>Panel Donacji</h2>

<table id="customTables" class="center">
    <tr>
        <th>Użytkownik</th>
        <th>Kategoria</th>
        <th>Ilość worków</th>
        <th>Data utworzenia</th>
        <th>Data odbioru</th>
        <th>Status</th>
        <th>Operacje</th>
    </tr>
    <c:forEach items="${allDonations}" var="donation">
        <tr>
            <td>${donation.user.id}</td>
            <td><c:forEach items="${donation.categories}" var="category">${category.name}; </c:forEach></td>
            <td>${donation.quantity}</td>
            <td>${donation.creationTime}</td>
            <td>${donation.pickUpTime}</td>
            <td>
                <c:choose>
                    <c:when test="${donation.picked==0}">Nieodebrana</c:when>
                    <c:otherwise>Odebrana</c:otherwise>
                </c:choose
            ></td>
            <td>
                <a href="/admin/donations/delete/${donation.id}">Usuń</a><br>
                <a href="/user/donations/edit/${donation.id}">Edytuj</a><br>
                <a href="/admin/donations/change-status/${donation.id}">Zmień status</a>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
