<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="gr__localhost">
    <head>
        <title>Login Page</title>
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
    <body onload="document.f.username.focus();" data-gr-c-s-loaded="true">
        <h3>Login with Username and Password</h3>

        <c:if test="{${param.error}">
            <p class="error">
                Login failed. Check that your username and password are correct.
            </p>
        </c:if>

        <div class="container">
            <div class="row"></div>
            <sf:form method="post"
                     action="${pageContext.request.contextPath}/login"
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
                <input name="${_csrf.parameterName}"
                       value="${_csrf.token}"
                       type="hidden">
                <button type="submit" class="btn btn-default">Submit</button>

            </sf:form>
        </div>
    <p><a href="<c:url value='/newaccount'/>">Create new account</a></p>
    </body>
</html>
