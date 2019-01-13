<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/13/19
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">


    <fmt:message key="locale.login.button" var="login_button"/>

    <fmt:message key="locale.register.button" var="register_button"/>


    <img src="../../jsp/images/logo.jpg" class="navbar-brand" href="#" width="48" height="48"/>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.id == null}">
                <li class="nav-item active">
                    <a class="nav-link" href="../../jsp/logIn.jsp"> <fmt:message key="locale.login.button"/> <span
                            class="sr-only">(current)</span></a>
                </li>
            </c:if>


            <c:if test="${sessionScope.id != null}">
                <li class="nav-item active">
                    <a class="nav-link" href="controller?command=logout"> <fmt:message key="locale.logout.button"/>
                        <span
                                class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="../../jsp/userPage.jsp"> <fmt:message
                            key="locale.user.panel.button"/> </a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="../../jsp/registration.jsp"> <fmt:message key="locale.register.button"/> </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="controller?command=take_tests"> <fmt:message key="locale.tests.title"/> </a>
            </li>

            <li class="nav-item">
                <a class="nav-link"href="?locale=en"> <fmt:message key="locale.lang.en"/> </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="?locale=ru"> <fmt:message key="locale.lang.ru"/> </a>
            </li>
        </ul>
    </div>
</nav>

</body>
</html>
