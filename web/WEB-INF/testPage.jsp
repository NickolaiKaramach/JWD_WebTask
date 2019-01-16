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
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.test.page.title" var="title" scope="session"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>

<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8"/>
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">
<h1 style="margin: 30px 10px 0px 10px">
    <fmt:message key="locale.user.test.page.test.name.label"/>
</h1>
<h1 style="margin: 30px 10px 0px 35px">
        ${requestScope.test.name}
</h1>

    <button style="margin: 0px 10px 0px 30px" onclick="change_display_type('new_test_name')"><fmt:message
            key="locale.test.page.newName.button.hider.name"/></button>

    <div id="new_test_name" style="display:none">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="change_test_name">
            <input type="hidden" name="test_id" value="${requestScope.test.id}">

            <section class="form_fields">
                <label for="name"> <fmt:message key="locale.test.page.newName"/> </label>
                <input type="text" name="name" id="name"/>
            </section>

            <input type="submit" id="submit" value="<fmt:message key="locale.test.page.newName.button"/>">
        </form>
</div>

    <br>

    <div class="test_list">
        <h1><fmt:message key="locale.test.page.table.title"/></h1>
        <h3><fmt:message key="locale.test.page.table.subtitle"/></h3>
        <table class="results">
            <thead>
            <tr>
                <td><fmt:message key="locale.test.page.column.question.name"/></td>
                <td><fmt:message key="locale.test.page.column.action.name"/></td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requestScope.test.questionList}" var="question">
                <tr>
                    <td>${question.description}</td>
                    <td>
                        <a href="controller?command=edit_question&question_id=${question.id}">
                            <fmt:message key="locale.question.edit.button"/>
                        </a>
                        <br>
                        <a href="controller?command=delete_question&question_id=${question.id}&test_id=${requestScope.test.id}">
                            <fmt:message key="locale.question.delete.button"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>

    <br>
<br>
<button onclick="change_display_type('new_question')"><fmt:message
        key="locale.test.page.newQuestion.button.name"/></button>
<div id="new_question" style="display:none">
    <form action="controller" method="post">
        <input type="hidden" name="test_id" value="${requestScope.test.id}">
        <input type="hidden" name="command" value="create_question">

        <section id="section" class="form_fields">
            <label for="description"><fmt:message key="locale.test.page.new.question.description"/></label>
            <input id="description" type="text" name="description"/>

        </section>

        <input type="submit" id="button" value="<fmt:message key="locale.test.page.new.question.button"/>"/>
    </form>
</div>

    <br>
<br>
<a href="controller?command=publish_test&test_id=${requestScope.test.id}"><fmt:message
        key="locale.test.page.publish.test.button"/> </a>
</fmt:bundle>

<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
