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
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8" />
    <title><fmt:message key="locale.test.preassessment.details.title"/></title>
</head>
<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8" />

<fmt:message key="locale.test.preassessment.details.test.name.label"/> ${requestScope.test.name}

<br>
<br>

<fmt:message key="locale.test.preassessment.details.test.length.label"/> 60 <fmt:message
        key="locale.additional.minutes"/>

<br>
<a href="controller?command=start_test&test_id=${requestScope.test.id}"><fmt:message
        key="locale.test.preassessment.details.begin.button"/> </a>
<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8" />
</body>
</html>