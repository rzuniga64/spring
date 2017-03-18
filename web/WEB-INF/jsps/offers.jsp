<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css"
          rel="stylesheet" type="text/css">
</head>
<body>

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
</body>
</html>