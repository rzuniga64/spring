<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
</head>
<body>

<c:forEach var="offer" items="${offers}">
   <p><c:out value="${offer}"></c:out></p>
</c:forEach>

</body>
</html>