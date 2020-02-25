<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add some furniture in our DB & in your life!</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="productForm">
        <h2>Adding furniture in DB</h2>
        <div>
            <form:input type="text" path="productName" placeholder="Product Name"
                        autofocus="true"></form:input>
<%--            <form:errors path="username"></form:errors>--%>
<%--                ${usernameError}--%>
        </div>
        <div>
            <form:input type="text" path="price" placeholder="Price"></form:input>
        </div>
        <div>
            <form:input type="text" path="productType"
                        placeholder="Type of Product"></form:input>
<%--            <form:errors path="password"></form:errors>--%>
<%--                ${passwordError}--%>
        </div>
        <button type="submit">Add Product</button>
    </form:form>
    <a href="/">Main</a>
</div>
</body>
</html>