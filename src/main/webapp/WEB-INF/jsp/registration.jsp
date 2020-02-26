<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Sign up, newcomer!</title>
    <link rel="stylesheet" href="../recources/css/registration.css">
</head>

<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form:form method="POST" modelAttribute="userForm">
            <div>
                <div>
                    <form:input type="text" path="username" placeholder="Username" class="fadeIn second"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                        ${usernameError}
                </div>
                <div>
                    <form:input type="password" path="password"   class="fadeIn third"  placeholder="Password"></form:input>
                </div>
                <div>
                    <form:input type="password" path="passwordConfirm"  class="fadeIn third"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="password"></form:errors>
                        ${passwordError}
                </div>
                <button type="submit">Sign Up</button>
            </div>




        </form:form>
    </div>
</div>
<div>

    <a href="/">Main</a>
</div>
</body>
</html>