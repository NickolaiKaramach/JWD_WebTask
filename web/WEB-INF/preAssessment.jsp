<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/8/19
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.test.preassessment.details.title"/></title>
</head>
<body>
<fmt:message key="locale.test.preassessment.details.test.name.label"/> ${requestScope.test.name}

<br>
<br>

<fmt:message key="locale.test.preassessment.details.test.length.label"/> 60 <fmt:message
        key="locale.additional.minutes"/>

<br>
<a href="controller?command=start_test&test_id=${requestScope.test.id}"><fmt:message
        key="locale.test.preassessment.details.begin.button"/> </a>
</body>
</html>
