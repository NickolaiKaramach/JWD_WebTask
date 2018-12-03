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
    <input type="text" name="login" value=""/>
    <input type="password" name="password" value=""/>
    <input type="submit" value="Отправить"/>
</form>
</body>
</html>
