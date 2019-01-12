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
<c:if test="${requestScope.error != null}">
    <%
        Exception exception = (Exception) request.getAttribute("error");
        out.print(exception.getMessage());
    %>
</c:if>

<br>


<h1>
${requestScope.test.name}
</h1>
<br>
<form action="controller" method="post">
    <input type="hidden" name="command" value="change_test_name">
    <input type="hidden" name="test_id" value="${requestScope.test.id}">

    <ul>
        <li>
            <label for="name"> <fmt:message key="locale.test.page.newName"/> </label>
            <input type="text" name="name" id="name"/>

        </li>
        <li>
            <label for="submit"> <fmt:message key="locale.test.page.newName.button"/> </label>
            <input type="submit" id="submit">
        </li>
    </ul>
</form>
------------------------------------------
<br>

<div>
    <c:forEach items="${requestScope.test.questionList}" var="question">

        <div>
                ${question.description}
        </div>
        <div>
            <a href="controller?command=edit_question&question_id=${question.id}">
                <fmt:message key="locale.question.edit.button"/>
            </a>
        </div>

        <div>
            <a href="controller?command=delete_question&question_id=${question.id}&test_id=${requestScope.test.id}">
                <fmt:message key="locale.question.delete.button"/>
            </a>
        </div>

        <br>
    </c:forEach>
</div>

<form action="controller" method="post">
    <input type="hidden" name="test_id" value="${requestScope.test.id}">

    <input type="hidden" name="command" value="create_question">

    <label for="description"><fmt:message key="locale.test.page.new.question.description"/></label>
    <input id="description" type="text" name="description"/>


    <br>

    <label for="button"><fmt:message key="locale.test.page.new.question.button"/></label>
    <input type="submit" id="button"/>
</form>

<a href="controller?command=publish_test&test_id=${requestScope.test.id}"><fmt:message
        key="locale.test.page.publish.test.button"/> </a>

</body>
</html>
