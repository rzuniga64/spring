<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
    $(document).ready(function() {
       document.f.username.focus();
    });
</script>
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
             modelAttribute="user"
             name="f">

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
        <div class="form-group">
            <label for="password">Remember me</label>
            <input type="checkbox"
                      class="form-control"
                      id="_spring_security"
                      name="_spring_security"
                      path=" "
                      checked="checked"/>
            <br />
        </div>
        <input name="${_csrf.parameterName}"
               value="${_csrf.token}"
               type="hidden">
        <button type="submit" class="btn btn-default">Login</button>

    </sf:form>
</div>
<p><a href="<c:url value='/newaccount'/>">Create new account</a></p>

