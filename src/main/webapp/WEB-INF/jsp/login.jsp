<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="../recources/css/login.css">
</head>

<body>

<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <form method="POST" action="/login">
            <div>
                <div><input name="username" class="fadeIn second" type="text" placeholder="Username"
                            autofocus="true"/></div>
                <div><input name="password" type="password" class="fadeIn third" placeholder="Password"/></div>
                <div><input type="submit" class="fadeIn fourth" value="Log In"></div>
                <h4><a href="/registration">Sign Up</a></h4>
            </div>
        </form>
    </div>
</div>

</body>
</html>

