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
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.tests.title"/></title>
</head>
<body>

<c:forEach items="${requestScope.tests}" var="currentTest">
    <ul>
            ${currentTest.name}


        <a href="controller?command=prepare_for_test&test_id=${currentTest.id}">
            <fmt:message key="locale.tests.details.button"/>
        </a>

    </ul>
</c:forEach>

</body>
</html>
