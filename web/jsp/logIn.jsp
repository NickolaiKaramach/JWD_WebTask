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
    <title><fmt:message key="locale.login.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
</head>
<body class="text-center">

<!-- TODO: Create another showing case!!! -->
<c:if test="${requestScope.error != null}">
    <%
        Exception exception = (Exception) request.getAttribute("error");
        out.print(exception.getMessage());
    %>
</c:if>

<form action="../controller" method="post" class="form-signin">
    <input type="hidden" name="command" value="sign_in"/>
    <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="locale.login.message"/></h1>
    <label for="email" class="sr-only"><fmt:message key="locale.email.input"/> </label>
    <input type="text" name="email" id="email" class="form-control" placeholder="Email address" required autofocus/>
    <label for="password" class="sr-only"><fmt:message key="locale.password.input"/></label>
    <input type="password" name="pass" id="password" placeholder="Password" class="form-control" required/>
    <button class="btn btn-lg btn-primary btn-block" onclick="holdForm(this.form)"><fmt:message
            key="locale.signin.action"/></button>
</form>

<script type="text/javascript">
    function cypherText(text) {
        var cypherText = "";
        for (var i = text.length - 1; i >= 0; i--) {
            cypherText += text[i];
        }
        return cypherText;
    }

    function showError(container, errorMessage) {
        container.className = 'error';
        var msgElem = document.createElement('span');
        msgElem.className = "error-message";
        msgElem.innerHTML = errorMessage;
        container.appendChild(msgElem);
    }

    function holdForm(form) {
        var elements = form.elements;
        var noErrors = true;

        if (!elements.email.value) {
            noErrors = false;
            showError(elements.email.parentNode, "Логин не может быть пустым!")
        }

        if (!elements.password.value) {
            noErrors = false;
            showError(elements.password.parentNode, "Пароль не может быть пустым!")
        } else {
            elements.password.value = cypherText(elements.password.value);
        }
        if (noErrors) {
            form.submit();
        }
    }
</script>
</body>
</html>
