<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In page</title>
</head>
<body>
<form action="/controller" method="post">
    <input type="hidden" name="command" value="sign_in"/>
    Login</br>
    <input type="text" name="login" value=""/>
    </br>Password</br>
    <input type="password" name="password" value=""/>
    </br>
    <input type="submit" value="Отправить"/>
</form>

</body>
</html>
