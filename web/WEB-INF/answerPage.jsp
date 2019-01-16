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
    <link href="/jsp/css/tests.css" rel="stylesheet">
    <link href="/jsp/css/registration.css" rel="stylesheet">
    <script src="/jsp/js/testPage.js"></script>
</head>
<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8" />
<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

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
    <form action="controller" method="post">
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


<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8" />
</body>
</html>
