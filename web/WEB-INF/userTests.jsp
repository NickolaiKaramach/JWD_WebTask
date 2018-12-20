<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/20/18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.tests.title"/></title>
</head>
<body>
<c:forEach items="${requestScope.mytests}" var="tests_list">
    <ul>
        <div>
                ${tests_list.name}
        </div>
        <div>
            <a href="/get/tests/${tests_list.id}">
                <fmt:message key="locale.tests.details.button"/>
            </a>
        </div>
    </ul>
</c:forEach>
</body>
</html>
