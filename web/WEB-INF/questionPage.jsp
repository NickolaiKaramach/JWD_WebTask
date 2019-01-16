<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/2/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8" />
    <title><fmt:message key="locale.question.page.tittle"/></title>
    <link href="/jsp/css/tests.css" rel="stylesheet">
    <link href="/jsp/css/registration.css" rel="stylesheet">
    <script src="/jsp/js/testPage.js"></script>
</head>
<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8" />
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<h1 style="margin: 30px 10px 0px 10px">
    <fmt:message key="locale.question.page.question.name.label"/>
</h1>
<br>


<h1 style="margin: 30px 10px 0px 35px">
    ${requestScope.question.description}
</h1>

<button style="margin: 0px 10px 0px 30px" onclick="change_display_type('new_question_name')"><fmt:message
        key="locale.question.page.change.name.hide.button"/></button>

<div id="new_question_name" style="display:none">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="change_question_name">
        <input type="hidden" name="question_id" value="${requestScope.question.id}">

        <section class="form_fields">
            <label for="name"> <fmt:message key="locale.question.page.newName"/></label>
            <input type="text" name="name" id="name"/>
        </section>

        <input type="submit" id="submit" value=" <fmt:message key="locale.question.page.newName.button"/>">
    </form>
</div>

<br>

<div class="test_list">
    <h1><fmt:message key="locale.question.page.table.title"/></h1>
    <h3><fmt:message key="locale.question.page.table.subtitle"/></h3>
    <table class="results">
        <thead>
        <tr>
            <td><fmt:message key="locale.question.page.column.answer.name"/></td>
            <td><fmt:message key="locale.question.page.column.action.name"/></td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.question.answerList}" var="answer">

            <tr>
                <td>${answer.description}</td>
                <td>
                    <a href="controller?command=edit_answer&answer_id=${answer.id}">
                        <fmt:message key="locale.question.page.edit.button"/>
                    </a>
                    <br>
                    <a href="controller?command=delete_answer&answer_id=${answer.id}&question_id=${requestScope.question.id}">
                        <fmt:message key="locale.question.page.delete.button"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br>
<br>
<button onclick="change_display_type('new_answer')"><fmt:message
        key="locale.question.page.new.answer.hide.button"/></button>

<div id="new_answer" style="display:none">
    <form action="controller" method="post">
        <input type="hidden" name="question_id" value="${requestScope.question.id}">
        <input type="hidden" name="command" value="create_answer">

        <section id="section" class="form_fields">
            <label for="description"><fmt:message key="locale.question.page.new.answer.description"/></label>
            <input id="description" type="text" name="description"/>

            <label for="isRight"> <fmt:message key="locale.question.page.new.answer.isRight"/> </label>
            <input id="isRight" type="checkbox" name="isRight"/>

        </section>

        <input type="submit" id="button" value="<fmt:message key="locale.question.page.new.answer.button"/>"/>
    </form>
</div>


<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8" />

</body>
</html>
