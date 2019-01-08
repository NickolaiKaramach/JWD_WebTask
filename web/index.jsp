<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${param.locale}"/>
<fmt:setBundle basename="locale"/>

<!doctype html>
<html lang="${sessionScope.locale}">


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/navbar-static/navbar-top.css" rel="stylesheet">

    <title><fmt:message key="locale.index.title"/></title>
</head>
<body>
<c:if test="${requestScope.error != null}">
    <%
        Exception exception = (Exception) request.getAttribute("error");
        out.print(exception.getMessage());
    %>
</c:if>

<br>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <fmt:setLocale value="${requestScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <fmt:message bundle="${loc}" key="locale.login.button" var="login_button"/>

    <fmt:message bundle="${loc}" key="locale.register.button"
                 var="register_button"/>


    <img src="/jsp/images/logo.jpg" class="navbar-brand" href="#" width="48" height="48"/>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.id == null}">
                <li class="nav-item active">
                    <a class="nav-link" href="/jsp/logIn.jsp"> <fmt:message key="locale.login.button"/> <span
                            class="sr-only">(current)</span></a>
                </li>
            </c:if>

            <c:if test="${sessionScope.id != null}">
                <li class="nav-item active">
                    <a class="nav-link" href="/controller?command=logout"> <fmt:message key="locale.logout.button"/>
                        <span
                                class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/jsp/userPage.jsp"> <fmt:message
                            key="locale.user.panel.button"/> </a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="/jsp/registration.jsp"> <fmt:message key="locale.register.button"/> </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/controller?command=get_tests"> <fmt:message key="locale.tests.title"/> </a>
            </li>

        </ul>
    </div>
</nav>

<a href="/?locale=en"> <fmt:message key="locale.lang.en"/> </a>

<a href="/?locale=ru"> <fmt:message key="locale.lang.ru"/> </a>

</body>
</html>