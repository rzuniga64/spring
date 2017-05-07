<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Authorised Users Only!</h3>

<table class="table">
    <thead>
        <tr>
            <th>Username</th><th>Email</th><th>Role</th><th>Enabled</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">

            <tr><td><c:out value="${user.username}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.authority}"></c:out></td>
                <td><c:out value="${user.enabled}"></c:out></td>
            </tr>

        </c:forEach>
    </tbody>
</table>
