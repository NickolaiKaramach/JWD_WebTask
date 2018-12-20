<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <!-- Font Icon -->
    <link rel="stylesheet" href="/jsp/css/style.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/jsp/fonts/material-icon/css/material-design-iconic-font.min.css">


    <title><fmt:message key="locale.registration.title"/></title>
</head>
<body class="text-center">

<div class="main">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title"><fmt:message key="locale.signup.message"/></h2>
                    <form method="POST" class="register-form" id="register-form" action="/controller">
                        <input type="hidden" name="command" value="registration">

                        <c:if test="${requestScope.get(\"err\")}">
                            <div class="form-group">
                                <c:out value="An error occurred: "/>
                                <c:out value="${requestScope.get(\"errmsg\")}"/>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="name" id="name" placeholder="Name"/>
                        </div>


                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email"/>
                        </div>

                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password"/>
                        </div>

                        <div class="form-group">
                            <label for="re_pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                        </div>

                        <!-- TODO: QUESTION HOW TO USE LOCALE THERE-->
                        <div class="form-group form-button">
                            <input type="button" name="signup" id="signup" class="form-submit"
                                   value="Register" onclick="holdRegForm(this.form)"/>
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="/jsp/images/signup.jpeg" alt="sing up image"></figure>
                    <a href="logIn.jsp" class="signup-image-link"><fmt:message
                            key="locale.already.registered.message"/> </a>
                </div>
            </div>
        </div>
    </section>
</div>

<script type="text/javascript">
    function cypherText(text) {
        var cypherText = "";
        for (var i = text.length - 1; i >= 0; i--) {
            cypherText += text[i];
        }
        return cypherText;
    }


    function holdRegForm(form) {
        //TODO: Implement it
        var elements = form.elements;
        var message = "Invalid data:\n";
        var noErrors = true;

        if (!elements.name.value) {
            noErrors = false;
            message += "*   Name cannot be empty!\n";
        }

        if (!elements.email.value) {
            noErrors = false;
            message += "*   Email cannot be empty!\n";
        } else {
            if (!validateEmail(elements.email.value)) {
                message += "*   Invalid email!\n"
            }
        }

        if (!elements.pass.value) {
            noErrors = false;
            message += "*   Password cannot be empty!\n";
        } else {
            //TODO: Validate: is simple pass?
        }

        if (!elements.re_pass.value) {
            noErrors = false;
            message += "*   Repeated password cannot be empty!\n";
        }

        if (!(elements.re_pass.value === elements.pass.value)) {
            noErrors = false;
            message += "*   Repeated password is not equal to password!\n";
        } else {
            if (noErrors) {
                elements.pass.value = cypherText(elements.pass.value);
            }
        }

        if (!noErrors) {
            alert(message);
        } else {
            form.submit();
        }

    }

    function validateEmail(email) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }
</script>
</body>
</html>
