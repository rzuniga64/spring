<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <p>Hi there!</p>

    <%-- With a foreach loop in JSTL you can iterate over a Java List --%>
    <c:forEach var="row" items="${offers}">
        ID: ${row.id}<br/>
        Name: ${row.name}<br/>
        Email: ${row.email}<br/>
        Text: ${row.text}<br/>
    </c:forEach>

</body>
</html>
