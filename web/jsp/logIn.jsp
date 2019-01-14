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

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
    <title><fmt:message key="locale.login.title"/></title>
    <script src="/jsp/js/login.js"></script>
    <link href="/jsp/css/registration.css" rel="stylesheet">
    <link href="/jsp/css/error.css" rel="stylesheet">
</head>
<body>

<!-- TODO: Create another showing case!!! -->


<h1><fmt:message key="locale.login.message"/></h1>

<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<form method="POST" id="form" action="../controller">
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


</body>
</html>
