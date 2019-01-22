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

<nav>
    <fmt:bundle basename="locale">
        <div><fmt:message key="locale.header.title"/></div>


        <c:if test="${sessionScope.id != null}">
            <a href="${path}controller?command=logout"> <fmt:message key="locale.header.logout.button"/> </a>
            <a href="${path}jsp/userPage.jsp"><fmt:message key="locale.header.user.panel.button"/> </a>
        </c:if>

        <c:if test="${sessionScope.id == null}">
            <a href="${path}jsp/logIn.jsp"> <fmt:message key="locale.header.login.button"/> </a>
            <a href="${path}jsp/registration.jsp"><fmt:message key="locale.header.register.button"/> </a>
        </c:if>

        <a href="${path}controller?command=take_tests"><fmt:message key="locale.header.tests.button"/> </a>

        <div class="language">
            <a href="${path}?locale=en"><fmt:message key="locale.lang.en"/></a>
            <a href="${path}?locale=ru"><fmt:message key="locale.lang.ru"/></a>
        </div>
    </fmt:bundle>
</nav>
