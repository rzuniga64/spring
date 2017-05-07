<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2 style="text-align:center">Create New Account</h2>
<div class="container">
    <div class="row">
        <sf:form method="post"
                 action="${pageContext.request.contextPath}/createaccount"
                 modelAttribute="user"
                 id="detaisl">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <sf:input type="text"
                          class="form-control"
                          id="username"
                          name="username"
                          path="username"
                          placeholder="Username"/>
                <br />
                <sf:errors path="username" cssClass="error"></sf:errors>
            </div>
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
                <br />
                <sf:errors path="email" cssClass="error"></sf:errors>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <sf:input type="password"
                          class="form-control"
                          id="password"
                          name="password"
                          path="password"
                          placeholder="Password"/>
                <br />
                <sf:errors path="password" cssClass="error"></sf:errors>
            </div>
        </div>
        <div class="form-group">
            <label for="confirmpass" class="col-sm-2 control-label">Confirm Password</label>
            <div class="col-sm-10">
                <input type="password"
                          class="form-control"
                          id="confirmpass"
                          name="confirmpass"
                          placeholder="Password"/>
            </div>
            <div class="col-sm-2"></div>
            <div id="matchpass" class="col-sm-10"></div>
        </div>
        <button type="submit" class="btn btn-default">Create Account</button>

        </sf:form>
    </div><!-- row -->
</div><!-- container -->
