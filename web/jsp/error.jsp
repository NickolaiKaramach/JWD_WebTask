<%@ page import="by.etc.karamach.controller.RequestParameterName" contentType="text/html;charset=UTF-8" %><%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/3/18
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<%
    String str = (String) request.getAttribute(RequestParameterName.ERROR_MSG);
    if (str != null) {
        out.println("<h1>" + str + "</h1>");
    } else {
        out.println("<h1>UNKNOWN E R R O R</h1>");
    }

%>

</body>
</html>
