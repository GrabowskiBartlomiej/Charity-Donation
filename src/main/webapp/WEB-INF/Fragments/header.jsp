<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <nav class="container container--70">

            <c:choose>
                <c:when test="${user==null}">
                    <ul class="nav--actions">
                        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
                    </ul>

                    <ul>
                        <li><a href="/app/add" class="btn btn--without-border active">Start</a></li>
                        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
                        <li><a href="#" class="btn btn--without-border">O nas</a></li>
                        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
                        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav--actions">
                        <c:choose>
                            <c:when test="${user.roles == 'ADMIN'}">
                                <li><a href="/admin/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><p>Witaj ${user.name}</p></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                    <ul>
                        <li><a href="/app/add" class="btn btn--without-border active">Podaruj</a></li>
                        <li><a href="/user/userEdit" class="btn btn--without-border">Edytuj</a></li>
                        <li><a href="/user/myDonations" class="btn btn--without-border">Moje Dary</a></li>
                        <li><form action="/logout" method="post"><button class="btn btn--without-border" type="submit">Wyloguj</button></form></li>
                    </ul>

                </c:otherwise>
            </c:choose>

    </nav>

