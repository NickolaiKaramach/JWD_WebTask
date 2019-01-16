<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/14/19
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="error">
    <%
        if (request.getParameter("errmsg") != null) {
            out.print(request.getParameter("errmsg"));
        }
    %>
</div>
