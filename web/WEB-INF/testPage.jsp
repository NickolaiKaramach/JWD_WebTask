<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/20/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.test.page.title"/></title>
</head>
<body>
${requestScope.test.name}

<br>

<c:forEach items="${requestScope.test.questionList}" var="question">

    ${question.description}

    <br>
    <c:forEach items="${question.answerList}" var="answer">
        ${answer.description}
        <br>
    </c:forEach>
    <br>
    <br>
</c:forEach>

<button>Add</button>
<button>Save</button>

</body>
</html>
