<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/19/18
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.tests.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>

<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">
<div class="test_list">
    <h1><fmt:message key="locale.tests.page.table.title"/></h1>
    <h3><fmt:message key="locale.tests.page.table.subtitle"/></h3>
    <table class="results">
        <thead>
        <tr>
            <td><fmt:message key="locale.tests.page.column.name.title"/></td>
            <td><fmt:message key="locale.tests.page.column.action.title"/></td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.tests}" var="currentTest">
            <tr>
                <td> ${currentTest.name}</td>
                <td>
                    <a href="controller?command=prepare_for_test&test_id=${currentTest.id}">
                        <fmt:message key="locale.tests.details.button"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</fmt:bundle>
<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
