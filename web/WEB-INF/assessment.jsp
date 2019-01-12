<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/8/19
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>

<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.test.assessment.page.title"/></title>
</head>
<body>
<fmt:message key="locale.test.assessment.page.question"/> ${requestScope.question.description}
<br>

<form action="controller" method="post">
    <input type="hidden" name="command" value="make_choice">
    <input type="hidden" name="question_id" value="${requestScope.question.id}">

    <c:forEach items="${requestScope.answer_list}" var="answer">
        <div>
            <input type="radio" id="${answer.id}" name="answer" value="${answer.id}" checked>
            <label for="${answer.id}">${answer.description}</label>
        </div>
    </c:forEach>

    <div>
        <label for="submit"><fmt:message key="locale.test.assessment.page.next"/> </label>
        <input type="submit" name="submit" id="submit">
    </div>
</form>

<a href="controller?command=finish_test" <fmt:message key="locale.test.assessment.page.end"/>

</body>
</html>
