<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="" scope="request"/>

<!doctype html>
<html lang="${sessionScope.locale}">

<fmt:bundle basename="locale">
    <fmt:message key="locale.index.title" var="title" scope="request"/>
</fmt:bundle>

<head>
    <c:import url="${path}WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>
<body>


<c:import url="${path}WEB-INF/header/header.jsp" charEncoding="UTF-8"/>


<h1>
    <fmt:bundle basename="locale">
        <fmt:message key="locale.index.page.welcome"/>
    </fmt:bundle>
</h1>
<c:import url="${path}WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<br>

<c:import url="${path}WEB-INF/footer/footer.jsp" charEncoding="UTF-8"/>

</body>
</html>