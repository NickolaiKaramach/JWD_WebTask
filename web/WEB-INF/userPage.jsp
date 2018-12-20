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

<div>
    <%
        out.println(request.getAttribute(RequestParameterName.MSG));
    %>
</div>

<div>
    <br>
    <a href="/controller?command=get_my_tests"> <fmt:message key="locale.user.panel.mytests.button"/> </a>
    <br>
</div>

<div>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="create_test">
        <fmt:message key="locale.user.panel.newtest.name"/><br>
        <input type="text" name="name">
        <input type="submit">
    </form>
</div>

</body>
</html>
