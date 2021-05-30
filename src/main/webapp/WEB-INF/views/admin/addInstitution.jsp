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
    <title>Dodaj Fundację</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@include file="../../Fragments/adminHeader.jsp"%>
</header>

<h2>Nowa Fundacja</h2>
<section class="login-page">
    <form:form modelAttribute="newInstitution" method="post">
        <div style="display: none;">
            <form:input readonly="true" path="id" />
        </div>
        <p style="font-size: 15px;">Nazwa fundacji:</p>
        <div class="form-group">
            <form:input type="text" path="name" placeholder="Nazwa"/>
        </div>
        <p style="font-size: 15px;">Opis fundacji:</p>
        <div class="form-group">
            <form:textarea rows="5" path="description" placeholder="Opis"/>
        </div>
        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Dodaj Fundację</form:button>
        </div>
    </form:form>
</section>
</body>
</html>
