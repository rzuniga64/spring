<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
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
             action="${pageContext.request.contextPath}/createaccount"
             commandName="user">

        <div class="form-group">
            <label for="username">Username</label>
            <sf:input type="text"
                      class="form-control"
                      id="username"
                      name="username"
                      path="username"
                      placeholder="Username"/>
            <br />
            <sf:errors path="username" cssClass="error"></sf:errors>
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
            <label for="password">Password</label>
            <sf:input type="text"
                      class="form-control"
                      id="password"
                      name="password"
                      path="password"
                      placeholder="Password"/>
            <br />
            <sf:errors path="password" cssClass="error"></sf:errors>
        </div>
        <div class="form-group">
            <label for="confirmpass">Confirm Password</label>
            <input type="text"
                      class="form-control"
                      id="confirmpass"
                      name="confirmpass"
                      placeholder="Password"/>
            <br />
        </div>
        <button type="submit" class="btn btn-default">Submit</button>

    </sf:form>
</div>
</body>
</html>