<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/2/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="by.etc.karamach.bean.Answer" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8" />
    <title><fmt:message key="locale.answer.page.title"/></title>
</head>
<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8" />
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<br>
<fmt:message key="locale.answer.page.currentDescription"/>
<br>
${requestScope.answer.description}
<br>
<fmt:message key="locale.answer.page.currentStatus"/>
<br>

<%
    Answer answer = (Answer) request.getAttribute("answer");
    if (answer.isRight()) {
        out.print("+");
    } else {
        out.print("-");
    }
%>

<br>

<form action="controller" method="post">
    <input type="hidden" name="answer_id" value="${requestScope.answer.id}">

    <input type="hidden" name="command" value="update_answer">

    <label for="description"><fmt:message key="locale.answer.page.new.Description"/></label>
    <input id="description" type="text" name="description"/>

    <br>


    <label for="isRight"> <fmt:message key="locale.answer.page.new.isRight"/> </label>
    <input id="isRight" type="checkbox" name="isRight"/>

    <br>

    <input type="submit"/>
</form>
<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8" />
</body>
</html>
