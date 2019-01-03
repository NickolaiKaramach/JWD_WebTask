<%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 12/20/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale"/>
<html lang="${sessionScope.locale}">
<head>
    <title><fmt:message key="locale.test.page.title"/></title>
</head>
<body>
${requestScope.test.name}
<br>
------------------------------------------
<br>

<div>
    <c:forEach items="${requestScope.test.questionList}" var="question">

        <div>
                ${question.description}
        </div>
        <div>
            <a href="/controller?command=edit_question&question_id=${question.id}">
                <fmt:message key="locale.question.edit.button"/>
            </a>
        </div>

        <div>
            <a href="/controller?command=delete_question&question_id=${question.id}&test_id=${requestScope.test.id}">
                <fmt:message key="locale.question.delete.button"/>
            </a>
        </div>

        <br>
    </c:forEach>
</div>

<button>Add</button>
<button>Save</button>

</body>
</html>
