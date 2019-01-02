<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/2/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.question.page.titile"/></title>
</head>
<body>
${requestScope.question.description}
<br>
------------------------------------------
<br>

<div>
    <c:forEach items="${requestScope.question.answerList}" var="answer">

        <div>
                ${answer.description}
        </div>
        <div>
            <a href="/controller?command=edit_answer&answer_id=${answer.id}">
                <fmt:message key="locale.question.page.edit.button"/>
            </a>
        </div>

        <div>
            <a href="/controller?command=delete_answer&answer_id=${answer.id}">
                <fmt:message key="locale.question.page.delete.button"/>
            </a>
        </div>

        <br>
    </c:forEach>
</div>

<button>Add</button>
<button>Save</button>
</body>
</html>
