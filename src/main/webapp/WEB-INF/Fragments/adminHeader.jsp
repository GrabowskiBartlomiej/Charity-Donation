<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="/user/dashboard" class="btn btn--small btn--without-border">Witaj ${user.name}</a></li>
    </ul>

    <ul>
        <li><a href="/admin/donations/all" class="btn btn--without-border">Dary</a></li>
        <li><a href="/admin/admins/all" class="btn btn--without-border">Administracja</a></li>
        <li><a href="/admin/users/all" class="btn btn--without-border">Użytkownicy</a></li>
        <li><a href="/admin/institutions/all" class="btn btn--without-border">Fundacje</a></li>
        <li><form action="/logout" method="post"><button class="btn btn--without-border" type="submit">Wyloguj</button></form></li>
    </ul>
</nav>