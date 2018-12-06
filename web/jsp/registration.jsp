<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="/controller" method="post">
    <input type="hidden" name="command" value="registration"/>
    Login<br>
    <input type="text" name="login" value=""/>
    <br>Password<br>
    <input type="password" name="password" value=""/>
    <br>
    <input type="button" value="Отправить" onclick="holdRegForm(this.form)"/>
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

    function holdRegForm(form) {
        var elements = form.elements;
        var noErrors = true;

        if (!elements.login.value) {
            noErrors = false;
            showError(elements.login.parentNode, "Логин не может быть пустым!")
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
