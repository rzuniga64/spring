<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Offer</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="offer" items="${offers}">
            <tr>
                <td><c:out value="${offer.name}"></c:out></td>
                <td><c:out value="${offer.email}"></c:out></td>
                <td><c:out value="${offer.text}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
