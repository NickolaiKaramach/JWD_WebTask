<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="" scope="request"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.tests.title" var="title" scope="request"/>
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
    <h1><fmt:message key="locale.user.test.page.table.title"/></h1>
    <h3><fmt:message key="locale.user.test.page.table.subtitle"/></h3>
    <table class="results">
        <thead>
        <tr>
            <td><fmt:message key="locale.user.test.page.column.name.title"/></td>
            <td><fmt:message key="locale.user.test.page.column.action.title"/></td>
        </tr>
        </thead>


        <tbody>
        <c:forEach items="${requestScope.mytests}" var="test">
            <tr>
                <td>${test.name}</td>
                <td>
                    <a href="${path}controller?command=edit_test&test_id=${test.id}">
                        <fmt:message key="locale.test.page.edit.button"/>
                    </a>
                    <br>
                    <a onclick="return confirm('Are you sure?')"
                       href="${path}controller?command=delete_test&test_id=${test.id}">
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

    <button onclick="change_display_type('new_test')"><fmt:message
            key="locale.user.test.page.new.test.hide.button"/></button>

<div id="new_test" style="display:none">
    <%--TODO: Make check on FE--%>
    <form action="${path}controller" method="post">
        <input type="hidden" name="command" value="create_test">

        <section id="section" class="form_fields">
            <label for="name"><fmt:message key="locale.user.test.page.new.test.name.label"/></label>
            <input type="text" name="name" id="name"
                   placeholder="<fmt:message key="locale.user.test.page.new.test.name.input"/>"/>


        </section>
        <input type="submit" value="<fmt:message key="locale.user.test.page.new.test.add.button"/> ">
    </form>
</div>

</fmt:bundle>

<c:import url="footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
