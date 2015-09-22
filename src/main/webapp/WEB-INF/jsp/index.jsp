<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Activity Log</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-select.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3>User Activity Log</h3>
    <form:form method="post" action="/" modelAttribute="reportcriteria">
        <div class="row">
            <div class="form-group col-md-3">
                <label>From:</label>
                <from:input path="from" cssClass="form-control" placeholder="dd/MM/yyyy HH"/>
            </div>

            <div class="form-group col-md-3">
                <label>To:</label>
                <from:input path="to" cssClass="form-control" placeholder="dd/MM/yyyy HH"/>
            </div>
            <div class="form-group col-md-2">
                <label>Interval:</label>
                <from:select path="interval" cssClass="form-control selectpicker">
                    <c:forEach items="${intervals}" var="interval">
                        <option value="${interval.key}">${interval.value}</option>
                    </c:forEach>
                </from:select>
            </div>
            <div class="form-group col-md-2">
                <label>Users:</label>
                <from:select path="users" multiple="true" cssClass="form-control selectpicker">
                    <c:forEach items="${allUsers}" var="user">
                        <option value="${user.key}">${user.value}</option>
                    </c:forEach>
                </from:select>
            </div>

            <div class="form-group col-md-2" style="height: 58px;">
                <input type="submit" value="View Report" class="btn btn btn-default" style="position: absolute; bottom: 0;">
            </div>
        </div>
    </form:form>
    <table class="table">
        <c:if test="${!empty users}">
            <thead>
            <tr>
                <th>Date</th>
                <c:forEach items="${users}" var="user">
                    <th>${user}</th>
                </c:forEach>
            </tr>
            </thead>
        </c:if>
        <tbody>
        <c:if test="${!empty userActivities}">
            <c:forEach items="${userActivities}" var="userActivity">
                <tr>
                    <td>${userActivity.key}</td>
                    <c:forEach items="${users}" var="user" varStatus="i">
                        <td>
                            <c:forEach items="${userActivity.value}" var="userActivityCount" varStatus="j">
                                <c:if test="${userActivityCount.key == user}">
                                    ${userActivityCount.value}
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <c:if test="${! empty message}">
        <div class="row">
            <p class="lead">${message}</p>
        </div>
    </c:if>
</div>
<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-select.min.js"></script>
<script>
    window.onload = function () {
        $('.selectpicker').selectpicker();
    }
</script>
</body>
</html>
