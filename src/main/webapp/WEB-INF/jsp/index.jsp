<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Activity Log</title>
</head>
<body>
<form:form method="get" action="view" modelAttribute="view">
    <table>
        <tr>
            <td>
                <form:label path="from">From:</form:label>
            </td>
            <td>
                <from:input path="from"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="view">
            </td>
        </tr>
    </table>
</form:form>
<table>
    <thead>
        <tr>
            <th>Date</th>
            <c:if test="${!empty users}">
                <c:forEach items="${users}" var="user">
                    <th>${user}</th>
                </c:forEach>
            </c:if>
        </tr>
    </thead>
    <tbody>
    <c:if test="${!empty userActivities}">
            <c:forEach items="${userActivities}" var="userActivity">
                <tr>
                <td>${userActivity.key}</td>
                <c:forEach items="${userActivity.value}" var="activitiesCount" varStatus="loop">
                    <td>${activitiesCount.value}</td>
                </c:forEach>
                </tr>
            </c:forEach>
    </c:if>
    </tbody>
</table>

</body>
</html>
