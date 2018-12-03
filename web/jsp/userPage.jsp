<%@ page import="by.etc.karamach.controller.RequestParameterName" %><%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
UserPage</br>
<%
    out.println(request.getAttribute(RequestParameterName.MSG));
%>
</body>
</html>
