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

  <%@include file="../Fragments/header.jsp"%>

    <section class="form--steps">
      <div class="form--steps-instructions">
        <div class="form--steps-container">
          <h3>Ważne!</h3>
          <p data-step="1" class="active">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="2">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="3">
           Wybierz jedną, do
            której trafi Twoja przesyłka.
          </p>
          <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
      </div>

      <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>


        <form:form modelAttribute="donation" method="post" >

          <!-- STEP 1: class .active is switching steps -->
          <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>

            <c:forEach items="${allCategories}" var="category">
              <div class="form-group form-group--checkbox">
                  <label>
                    <input id="${category.name}" type="checkbox" value="${category.id}" name="categories"/>
                    <span class="checkbox"></span>
                    <span class="description">${category.name}</span>
                  </label>
              </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
              <form:button type="button" class="btn next-step">Dalej</form:button>
            </div>
          </div>

          <!-- STEP 2 -->
          <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline">
              <label>
                Liczba 60l worków:
                <form:input id="quantity" type="number" step="1" min="1"  path="quantity"/>
              </label>
            </div>

            <div class="form-group form-group--buttons">
              <form:button type="button" class="btn prev-step">Wstecz</form:button>
              <form:button type="button" class="btn next-step">Dalej</form:button>
            </div>
          </div>

          <!-- STEP 3 -->
          <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach items="${institutions}" var="institution">
              <div class="form-group form-group--checkbox">
                <label>
                  <input id="${institution.name}" type="radio" value="${institution.id}"  name="institution"/>
                  <span class="checkbox radio"></span>
                  <span class="description">
                    <div class="title">Fundacja ${institution.name}</div>
                    <div class="subtitle">${institution.description}</div>
                  </span>
                </label>
              </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
              <form:button type="button" class="btn prev-step">Wstecz</form:button>
              <form:button type="button" class="btn next-step">Dalej</form:button>
            </div>
          </div>

          <!-- STEP 4 -->
          <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
              <div class="form-section--column">
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Ulica <form:input id="street" type="text" path="street" /> </label>
                </div>

                <div class="form-group form-group--inline">
                  <label> Miasto <form:input id="city" type="text" path="city" /> </label>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Kod pocztowy <form:input id="zip" type="text" path="zipCode" />
                  </label>
                </div>
              </div>
              <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Data <form:input id="date" type="date" path="pickUpDate" /> </label>
                </div>

                <div class="form-group form-group--inline">
                  <label> Godzina <form:input id="time" type="time" path="pickUpTime" /> </label>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Uwagi dla kuriera
                    <form:textarea id="comments" path="pickUpComment" rows="5"></form:textarea>
                  </label>
                </div>
              </div>
            </div>
            <div class="form-group form-group--buttons">
              <form:button type="button" class="btn prev-step">Wstecz</form:button>
              <form:button type="button" class="btn next-step">Dalej</form:button>
            </div>
          </div>

          <!-- STEP 5 -->
          <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
              <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                  <li>
                    <span class="icon icon-bag"></span>
                        <span class="summary--text" id="bags-categories"></span>
                  </li>
                  <li>
                    <span class="icon icon-hand"></span>
                    <span class="summary--text" id="institution"></span>
                  </li>
                </ul>
              </div>

              <div class="form-section form-section--columns">
                <div class="form-section--column">
                  <h4>Adres odbioru:</h4>
                  <ul id="address">
                  </ul>
                </div>

                <div class="form-section--column">
                  <h4>Termin odbioru:</h4>
                  <ul id="shipping">
                  </ul>
                </div>
              </div>
            </div>

            <div class="form-group form-group--buttons">
              <form:button type="button" class="btn prev-step">Wstecz</form:button>
              <form:button type="submit" class="btn">Potwierdzam</form:button>
            </div>
          </div>
        </form:form>
      </div>
    </section>

  <%@include file="../Fragments/footer.jsp"%>

  <script src="<c:url value="../../resources/js/app.js"/>"></script>
  </body>
</html>
