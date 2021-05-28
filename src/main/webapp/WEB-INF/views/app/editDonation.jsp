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
    <title>Edytuj dar</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <c:choose>
        <c:when test="${user.roles=='ADMIN'}">
            <nav class="container container--70">
                <ul class="nav--actions">
                    <li><a href="/user/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
                </ul>

                <ul>
                    <li><a href="/admin/dashboard" class="btn btn--without-border">Dashboard</a></li>
                    <li><a href="/admin/allAdmins" class="btn btn--without-border">Administracja</a></li>
                    <li><a href="/admin/allUsers" class="btn btn--without-border">Użytkownicy</a></li>
                    <li><a href="/admin/allInstitutions" class="btn btn--without-border">Fundacje</a></li>
                    <li>
                        <form action="/logout" method="post">
                            <button class="btn btn--without-border" type="submit">Wyloguj</button>
                        </form>
                    </li>
                </ul>
            </nav>
        </c:when>
        <c:otherwise>
            <%@include file="../../Fragments/header.jsp"%>
        </c:otherwise>
    </c:choose>
</header>

<h2>Edytuj dar</h2>
<section class="login-page">
    <form:form modelAttribute="editDonation" method="post">
        <div style="display: none">
            <form:input path="id" placeholder="${editDonation.id}" readonly="true"/>
        </div>
        <p style="font-size: 15px;">Kategorie:</p>
        <div class="form-group">
            <form:checkboxes path="categories" items="${allCategories}"/>
        </div>
        <p style="font-size: 15px;">Ilość worków:</p>
        <div class="form-group">
            <form:input path="quantity" type="number" step="1" min="1"/>
        </div>
        <div class="form-group">
            <form:radiobuttons path="institution" items="${allInstitutions}"/>
        </div>


<%--        <p style="font-size: 15px;">Email:</p>--%>
<%--        <div class="form-group">--%>
<%--            <form:input type="text" path="email" placeholder="#{editUser.email}}"/>--%>
<%--        </div>--%>
<%--        <p style="font-size: 15px;">Imię:</p>--%>
<%--        <div class="form-group">--%>
<%--            <form:input type="text" path="name" placeholder="${editUser.name}"/>--%>
<%--        </div>--%>
<%--        <p style="font-size: 15px;">Nazwisko:</p>--%>
<%--        <div class="form-group">--%>
<%--            <form:input type="text" path="surname" placeholder="${editUser.surname}"/>--%>
<%--        </div>--%>
<%--        <p style="font-size: 15px;">Rola:</p>--%>
<%--        <div class="form-group">--%>
<%--            <form:radiobutton path="roles" value="ADMIN"/>ADMIN--%>
<%--            <form:radiobutton path="roles" value="USER"/>USER--%>
        </div>
        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Zatwierdź Zmiany</form:button>
        </div>
    </form:form>
</section>

</body>
</html>
