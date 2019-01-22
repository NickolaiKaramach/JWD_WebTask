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
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="" scope="request"/>
<fmt:bundle basename="locale">
    <fmt:message key="locale.test.assessment.page.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="head/head.jsp" charEncoding="UTF-8"/>
</head>
<body>
<c:import url="header/header.jsp" charEncoding="utf-8"/>
<c:import url="error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">


    <h3 style="font-family: Arial"><fmt:message
            key="locale.test.assessment.page.question"/> ${requestScope.question.description}</h3>

    <form method="POST" action="${path}controller">
        <input type="hidden" name="command" value="make_choice">
        <input type="hidden" name="question_id" value="${requestScope.question.id}">

        <section id="section">
            <c:forEach items="${requestScope.answer_list}" var="answer">
                <input type="radio" id="${answer.id}" name="answer" value="${answer.id}" checked>
                <label for="${answer.id}" style="font-family: Arial;font-size: 25px">${answer.description}</label>
                <br>
            </c:forEach>
        </section>

        <input type="submit" name="submit" id="submit" style="font-size: 25px;"
               value="<fmt:message key="locale.test.assessment.page.next"/>">
        <input type="button" name="finish_test" id="finish_test" style="font-size: 25px;"
               value=" <fmt:message key="locale.test.assessment.page.end"/>"
               onclick="window.location='controller?command=finish_test'"/>

    </form>

</fmt:bundle>

<c:import url="footer/footer.jsp" charEncoding="utf-8"/>

</body>
</html>
