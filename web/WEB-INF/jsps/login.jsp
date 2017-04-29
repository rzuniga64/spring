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

        <c:if test="{${param.error != null}">
            <p class="error">
                Login failed. Check that your username and password are correct.
            </p>
        </c:if>

        <form name="f"
              action="${pageContext.request.contextPath}/login"
              method="POST">
            <table class="formtable">
                <tbody>
                <tr>
                    <td>User:</td>
                    <td>
                        <input name="username" value="" type="text">
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input name="password" type="password">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input name="submit" value="Login" type="submit">
                    </td>
                </tr>
                <!--input name="_csrf"
                       value="c150829a-4647-412a-850f-83b1d2e1a9ee"
                       type="hidden"-->
                </tbody>
            </table>
        </form>
    </body>
</html>
