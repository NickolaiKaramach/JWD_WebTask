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
        out.println("<h3>" + str + "</h3>");
    } else {
        out.println("<h3>UNKNOWN E R R O R</h3>");
    }

%>

</body>
</html>
