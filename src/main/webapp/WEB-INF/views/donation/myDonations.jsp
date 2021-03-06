<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Moje Dary</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/header.jsp"%>
</header>
<h2>Moje Dary</h2>
<section class="form--steps">
    <div class="form--steps-container">
        <table id="customTables" class="center">
            <tr>
                <th>Kategoria</th>
                <th>Ilość worków</th>
                <th>Data utworzenia</th>
                <th>Data odbioru</th>
                <th>Status</th>
                <th>Operacje</th>
            </tr>
            <c:forEach items="${myDonations}" var="donation">
                <tr>
                    <td><c:forEach items="${donation.categories}" var="category">${category.name}; </c:forEach></td>
                    <td>${donation.quantity}</td>
                    <td>${donation.creationTime}</td>
                    <td><c:choose><c:when test="${donation.picked == 1}">${donation.pickedInDate}</c:when><c:otherwise>Jeszcze nie</c:otherwise></c:choose></td>
                    <td>
                        <c:choose>
                            <c:when test="${donation.picked==0}">Nieodebrana</c:when>
                            <c:otherwise>Odebrana</c:otherwise>
                        </c:choose
                        ></td>
                    <td>
                        <a href="/user/donations/details/${donation.id}">Szczegóły</a><br>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
