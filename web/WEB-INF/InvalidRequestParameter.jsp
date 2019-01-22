<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/22/19
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<c:set var="path" value="" scope="request"/>

<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <c:import url="head/head.jsp" charEncoding="UTF-8"/>
    <title><fmt:message key="locale.invalid.request.parameters.title"/></title>
</head>
<body>
<c:import url="header/header.jsp" charEncoding="utf-8"/>
<h2><fmt:message key="locale.invalid.request.parameters.description"/></h2>
<c:import url="footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>

