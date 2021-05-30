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
    <title>Edytuj Administratora</title>
    <base href="/">
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/adminHeader.jsp"%>
</header>

<h2>Edytuj Administratora</h2>
<section class="login-page">
    <form:form modelAttribute="editUser" method="post">
        <div style="display: none">
            <form:input path="id" placeholder="${editUser.id}" readonly="true"/>
        </div>
        <div style="display: none">
            <form:input type="text" path="password" placeholder="#{editUser.password}}" readonly="true"/>
        </div>
        <p style="font-size: 15px;">Email:</p>
        <div class="form-group">
            <form:input type="text" path="email" placeholder="#{editUser.email}}"/>
        </div>
        <p style="font-size: 15px;">Imię:</p>
        <div class="form-group">
            <form:input type="text" path="name" placeholder="${editUser.name}"/>
        </div>
        <p style="font-size: 15px;">Nazwisko:</p>
        <div class="form-group">
            <form:input type="text" path="surname" placeholder="${editUser.surname}"/>
        </div>
        <p style="font-size: 15px;">Rola:</p>
        <div class="form-group">
            <form:radiobutton path="roles" value="ADMIN"/>ADMIN
            <form:radiobutton path="roles" value="USER"/>USER
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/change-password/${editUser.id}" class="btn btn--without-border">Zmień hasło</a>
            <form:button class="btn" type="submit">Zatwierdź Zmiany</form:button>
        </div>
    </form:form>
</section>
</body>
</html>
