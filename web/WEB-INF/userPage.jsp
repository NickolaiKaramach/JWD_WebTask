<%@ page import="by.etc.karamach.controller.RequestParameterName" contentType="text/html;charset=UTF-8" %><%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.user.panel.title"/></title>
</head>
<body>

<%
    out.println(request.getAttribute(RequestParameterName.MSG));
%>

<a href="/get/tests/my"> <fmt:message key="locale.user.panmel.mytests.button"/> </a>

</body>
</html>
