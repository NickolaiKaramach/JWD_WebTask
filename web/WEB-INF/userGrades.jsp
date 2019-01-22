<%@ page import="by.etc.karamach.bean.Grade" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kosoj_rus
  Date: 1/14/19
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<c:set var="path" value="" scope="request"/>

<fmt:bundle basename="locale">
    <fmt:message key="locale.test.user.grages.title" var="title" scope="request"/>
</fmt:bundle>

<html lang="${sessionScope.locale}">
<head>
    <c:import url="head/head.jsp" charEncoding="UTF-8"/>
</head>

<body>
<c:import url="header/header.jsp" charEncoding="utf-8"/>
<c:import url="error-handler/error-handler.jsp" charEncoding="UTF-8"/>

<fmt:bundle basename="locale">

    <div class="test_list">
        <h1><fmt:message key="locale.test.user.grages.table.title"/></h1>
        <h3><fmt:message key="locale.test.user.grages.table.subtitle"/></h3>
        <table class="results">
            <thead>
            <tr>
                <td><fmt:message key="locale.test.user.grages.column.test.name"/></td>
                <td><fmt:message key="locale.test.user.grages.column.degree.name"/></td>
                <td><fmt:message key="locale.test.user.grages.column.finish_time.name"/></td>
                <td><fmt:message key="locale.test.user.grages.column.action.name"/></td>
            </tr>
            </thead>

            <tbody>
            <c:if test="${requestScope.grades ne null}">
                <%
                    List<Grade> grades = ((List<Grade>) request.getAttribute("grades"));
                    int i = 0;

                %>
                <c:forEach items="${requestScope.grades}" var="currentGrade">
                    <tr>
                        <td>
                                ${currentGrade.test.name}
                        </td>
                        <td>
                                ${currentGrade.mark}%
                        </td>
                        <td>
                            <%=grades.get(i++).getFinishTime().toString()%>
                        </td>
                        <td>
                            <a href="${path}controller?command=take_grade&grade_id=${currentGrade.id}">
                                <fmt:message key="locale.test.user.grades.details.button"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>
        </table>
</div>

</fmt:bundle>
<c:import url="footer/footer.jsp" charEncoding="utf-8"/>
</body>
</html>
