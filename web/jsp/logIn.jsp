<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="../" scope="request"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.login.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="${path}WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
</head>
<body>
<fmt:bundle basename="locale">
<h1><fmt:message key="locale.login.message"/></h1>
</fmt:bundle>

<c:import url="${path}WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">
    <form method="POST" id="form" action="${path}controller">
    <input type="hidden" name="command" value="sign_in">

    <section id="section" class="form_fields">

        <label for="email"><fmt:message key="locale.login.email.label"/> </label>
        <input type="text" name="email" id="email" placeholder="<fmt:message key="locale.login.email.input"/> "
               autofocus/>
        <label for="pass"><fmt:message key="locale.login.password.label"/></label>
        <input type="password" name="pass" id="pass" placeholder="<fmt:message key="locale.login.password.input"/>"/>
    </section>


    <input type="button" value="<fmt:message key="locale.signin.action"/>" onclick="holdForm()"/>

</form>
</fmt:bundle>


</body>
</html>
