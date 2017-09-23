<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 04.08.2016
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Virtual Library</title>
    <meta charset="utf-8">
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>
<body class = "jumbotron">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Library Project</a>
        </div>
    </div>
</nav>

<div class = "container" id="login-box">
    <div class="col-lg-offset-4 col-lg-4">
        <h3>Please sign in! :)</h3>

        <form class="form-login" action="<c:url value='/j_spring_security_check' />" method="POST">
            <input id="j_username" name="j_username" class="form-control" placeholder="Login" required autofocus>
            <input id="j_password" name="j_password" type = "PASSWORD" class="form-control" placeholder="Password" required autofocus>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>

</div>


</body>
</html>
