<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/8/19
  Time: 17:33
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
    <title><fmt:message key="locale.unknown.command.title"/></title>
</head>
<body>
<c:import url="header/header.jsp" charEncoding="utf-8"/>
<h2><fmt:message key="locale.unknown.command.description"/></h2>
<c:import url="footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
