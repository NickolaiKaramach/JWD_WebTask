<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/20/18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.tests.title"/></title>
</head>
<body>
<c:if test="${requestScope.error != null}">
    <%
        Exception exception = (Exception) request.getAttribute("error");
        out.print(exception.getMessage());
    %>
</c:if>

<br>

<div>
<c:forEach items="${requestScope.mytests}" var="test">
    <ul>
        <div>
                ${test.name}
        </div>
        <div>
            <a href="/controller?command=edit_test&test_id=${test.id}">
                <fmt:message key="locale.test.page.edit.button"/>
            </a>
        </div>
        <div>
            <a href="/controller?command=delete_test&test_id=${test.id}">
                <fmt:message key="locale.user.panel.mytest.delete"/>
            </a>
        </div>

    </ul>
</c:forEach>

</div>
<br/>
<br/>

<div>
    <%--TODO: Make check on FE--%>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="create_test">
        <fmt:message key="locale.user.panel.newtest.name"/>
        <input type="text" name="name">
        <input type="submit">
    </form>
</div>

</body>
</html>
