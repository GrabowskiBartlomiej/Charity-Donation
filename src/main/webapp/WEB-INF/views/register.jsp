<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>" />
  </head>
  <body>

  <header>
  <%@include file="../Fragments/header.jsp"%>
  </header>
    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form modelAttribute="userReg" method="post">
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
          <a href="/login" class="btn btn--without-border">Zaloguj się</a>
          <form:button class="btn" type="submit">Załóż konto</form:button>
        </div>
      </form:form>
    </section>

    <%@include file="../Fragments/footer.jsp"%>

    <script src="<c:url value="../../resources/js/register.js"/>"></script>
  </body>
</html>
