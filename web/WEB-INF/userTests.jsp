<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/20/18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
    <title><fmt:message key="locale.tests.title"/></title>
    <link href="/jsp/css/tests.css" rel="stylesheet">
    <link href="/jsp/css/registration.css" rel="stylesheet">
    <script src="/jsp/js/userTests.js"></script>
</head>

<body>
<c:import url="/WEB-INF/header/header.jsp" charEncoding="utf-8"/>

<c:if test="${requestScope.error != null}">
    <%
        Exception exception = (Exception) request.getAttribute("error");
        out.print(exception.getMessage());
    %>
</c:if>

<br>

<div class="test_list">
    <h1><fmt:message key="locale.user.test.page.table.title"/></h1>
    <h3><fmt:message key="locale.user.test.page.table.subtitle"/></h3>
    <table class="results">
        <thead>
        <tr>
            <td><fmt:message key="locale.user.test.page.column.name.titile"/></td>
            <td><fmt:message key="locale.user.test.page.column.action.title"/></td>
        </tr>
        </thead>


        <tbody>
        <c:forEach items="${requestScope.mytests}" var="test">
            <tr>
                <td>${test.name}</td>
                <td>
                    <a href="controller?command=edit_test&test_id=${test.id}">
                        <fmt:message key="locale.test.page.edit.button"/>
                    </a>
                    <br>
                    <a href="controller?command=delete_test&test_id=${test.id}">
                        <fmt:message key="locale.user.panel.mytest.delete"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br/>
<br/>

<button onclick="change_display_type()"><fmt:message key="locale.user.test.page.new.test.hide.button"/></button>

<div id="new_test" style="display:none">
    <%--TODO: Make check on FE--%>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="create_test">

        <section id="section" class="form_fields">
            <label for="name"><fmt:message key="locale.user.test.page.new.test.name.label"/></label>
            <input type="text" name="name" id="name"
                   placeholder="<fmt:message key="locale.user.test.page.new.test.name.input"/>"/>


        </section>
        <input type="submit" value="<fmt:message key="locale.user.test.page.new.test.add.button"/> ">
    </form>
</div>
<c:import url="/WEB-INF/footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
