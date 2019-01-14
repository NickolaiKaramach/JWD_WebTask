<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/13/19
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <c:import url="/WEB-INF/head/head.jsp" charEncoding="UTF-8"/>
    <title><fmt:message key="locale.registration.title"/></title>
    <script src="/jsp/js/registration.js"></script>
    <link href="/jsp/css/registration.css" rel="stylesheet">

</head>
<body>

<h1><fmt:message key="locale.signup.message"/></h1>

<c:import url="/WEB-INF/error-handler/error-handler.jsp" charEncoding="UTF-8"/>


<c:if test="${requestScope.error != null}">
    <div id="error">
        <h1 id="error_title">
            <%
                Exception exception = (Exception) request.getAttribute("error");
                out.print(exception.getMessage());
            %>
        </h1>
    </div>
</c:if>

<form method="POST" id="form" action="../controller">
    <input type="hidden" name="command" value="registration">

    <section id="section" class="form_fields">
        <label for="name"><fmt:message key="locale.registration.name.label"/></label>
        <input type="text" name="name" id="name" placeholder="<fmt:message key="locale.registration.name.input"/>"/>
        <label for="email"><fmt:message key="locale.registration.email.label"/> </label>
        <input type="email" name="email" id="email"
               placeholder="<fmt:message key="locale.registration.email.input"/> "/>
        <label for="pass"><fmt:message key="locale.registration.password.label"/> </label>
        <input type="password" name="pass" id="pass"
               placeholder="<fmt:message key="locale.registration.password.input"/> "/>
        <label for="re_pass"><fmt:message key="locale.registration.re_password.label"/> </label>
        <input type="password" name="re_pass" id="re_pass"
               placeholder="<fmt:message key="locale.registration.re_password.input"/>"/>
    </section>

    <input type="button" value="<fmt:message key="locale.registration.register.button"/> " onclick="holdRegForm(this)"/>
    <input type="button" value="<fmt:message key="locale.registration.back.button"/> "
           onclick="window.location='../index.jsp'"/>
</form>
<p>
    <fmt:message key="locale.registration.already.message"/> <a href="/jsp/logIn.jsp"><fmt:message
        key="locale.registration.click.to.login"/> </a>
</p>
</body>
</html>
