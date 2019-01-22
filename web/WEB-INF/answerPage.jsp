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
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="" scope="request"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.answer.page.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">

<head>
    <c:import url="head/head.jsp" charEncoding="UTF-8"/>
</head>

<body>
<c:import url="header/header.jsp" charEncoding="utf-8"/>
<c:import url="error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">
<div class="test_list">
    <h1><fmt:message key="locale.answer.page.currentDescription"/></h1>
    <table class="results">
        <thead>
        <tr>
            <td><fmt:message key="locale.answer.page.column.answer.name"/></td>
            <td><fmt:message key="locale.answer.page.column.isRight.name"/></td>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td>${requestScope.answer.description}</td>
            <td>
                <%
                    Answer answer = (Answer) request.getAttribute("answer");
                    if (answer.isRight()) {
                        out.print("+");
                    } else {
                        out.print("-");
                    }
                %>
            </td>
        </tr>

        </tbody>
    </table>
</div>

    <br>
<br>

    <button onclick="change_display_type('update_answer')"><fmt:message
            key="locale.answer.page.new.answer.hide.button"/></button>

    <div id="update_answer" style="display:none">
        <form action="${path}controller" method="post">
            <input type="hidden" name="answer_id" value="${requestScope.answer.id}">
            <input type="hidden" name="command" value="update_answer">

            <section id="section" class="form_fields">
                <label for="description"><fmt:message key="locale.answer.page.new.Description"/></label>
                <input id="description" type="text" name="description"/>

                <label for="isRight"> <fmt:message key="locale.answer.page.new.isRight"/> </label>
                <input id="isRight" type="checkbox" name="isRight"/>

            </section>

            <input type="submit" id="button" value="<fmt:message key="locale.answer.page.new.answer.confirm.button"/>"/>
        </form>
</div>
</fmt:bundle>

<c:import url="footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
