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
<h2 style="text-align:center">Create New Account</h2>
<div class="container">
    <div class="row"></div>
    <sf:form method="post"
             action="${pageContext.request.contextPath}/createaccount"
             commandName="user">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <sf:input type="text"
                          class="form-control"
                          id="username"
                          name="username"
                          path="username"
                          placeholder="Username"/>
            </div>
            <br />
            <sf:errors path="username" cssClass="error"></sf:errors>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <sf:input type="email"
                          class="form-control"
                          id="email"
                          name="email"
                          path="email"
                          placeholder="Email"/>
            </div>
            <br />
            <sf:errors path="email" cssClass="error"></sf:errors>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <sf:input type="text"
                          class="form-control"
                          id="password"
                          name="password"
                          path="password"
                          placeholder="Password"/>
            </div>
            <br />
            <sf:errors path="password" cssClass="error"></sf:errors>
        </div>
        <div class="form-group">
            <label for="confirmpass" class="col-sm-2 control-label">Confirm Password</label>
            <div class="col-sm-10">
                <input type="text"
                          class="form-control"
                          id="confirmpass"
                          name="confirmpass"
                          placeholder="Password"/>
            </div>
            <br />
        </div>
        <button type="submit" class="btn btn-default">Create Account</button>

    </sf:form>
</div>
</body>
</html>