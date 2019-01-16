<%@ page contentType="text/html;charset=UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.user.panel.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>
<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<br>
<fmt:bundle basename="locale">
    <div>
        <br>
        <a href="../controller?command=take_my_tests"> <fmt:message key="locale.user.panel.mytests.button"/> </a>
        <br>
    </div>

    <div>
        <br>
        <a href="../controller?command=take_user_grades"> <fmt:message key="locale.user.panel.mygrades.button"/> </a>
        <br>
    </div>
</fmt:bundle>

<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
