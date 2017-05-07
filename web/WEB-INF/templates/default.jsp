<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="title" /></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div>
        <tiles:insertAttribute name="header"></tiles:insertAttribute>
    </div>
    <div>
        <tiles:insertAttribute name="content"></tiles:insertAttribute>
    </div>
    <div>
        <tiles:insertAttribute name="footer"></tiles:insertAttribute>
    </div>

</body>
</html>