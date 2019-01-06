<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/6/19
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<!-- TODO: Add style-->
<%
    String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();
%>
<!DOCTYPE html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="locale.error.page.title"/></title>
</head>
<body>
<h2><fmt:message key="locale.error.page.description"/></h2>
<p><fmt:message key="locale.error.page.error.type"/> <%= exception%>
</p>
<p><fmt:message key="locale.error.page.error.message"/> <%= message %>
</p>
</body>
</html>