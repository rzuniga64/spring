<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="container">
        <div class="row"></div>
        <sf:form method="post"
                 action="${pageContext.request.contextPath}/docreate"
                 commandName="offer">

            <div class="form-group">
                <label for="name">Name</label>
                <sf:input type="text"
                          class="form-control"
                          id="name"
                          name="name"
                          path="name"
                          placeholder="Name"/>
                <br />
                <sf:errors path="name" cssClass="error"></sf:errors>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <sf:input type="email"
                          class="form-control"
                          id="email"
                          name="email"
                          path="email"
                          placeholder="Email"/>
                <br />
                <sf:errors path="email" cssClass="error"></sf:errors>
            </div>
            <div class="form-group">
                <label for="text">Your offer</label>
                <sf:textarea class="form-control"
                             id="text"
                             name="text"
                             path="text"
                             rows="10"
                             cols="10"/>
                <br />
                <sf:errors path="text" cssClass="error"></sf:errors>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>

        </sf:form>
    </div>
</body>
</html>