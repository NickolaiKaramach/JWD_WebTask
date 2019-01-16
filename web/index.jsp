<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>

<!doctype html>
<html lang="${sessionScope.locale}">
<fmt:bundle basename="locale">
    <fmt:message key="locale.index.title" var="title" scope="request"/>
</fmt:bundle>

<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>
<body>


<c:import url="/WEB-INF/header/header.jsp" charEncoding="UTF-8"/>


<h1>
    <fmt:bundle basename="locale">
        <fmt:message key="locale.index.page.welcome"/>
    </fmt:bundle>
</h1>
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<br>

<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="UTF-8"/>

</body>
</html>