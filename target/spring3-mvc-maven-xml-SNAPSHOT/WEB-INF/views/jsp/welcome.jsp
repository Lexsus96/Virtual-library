<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 11.08.2016
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Virtual Library</title>
    <meta charset="utf-8">
    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Library Project</a>
        </div>
    </div>
</nav>
<p>...</p>
<p>...</p>
<div class="jumbotron">
    <div class="col-lg-offset-2" class="container">
        <h1>Hello, ${name}!</h1>
        <p>It's example of electronic library! Enjoy it! :)</p>
        <p> <a class="btn btn-primary btn-lg" role="button" href="/welcome/personalArea">Перейти в личный кабинет</a>
            <a class="btn btn-danger btn-lg  col-lg-offset-1" role="button" href="<c:url value="/j_spring_security_logout" />">
                Разлогиниться</a>
        </p>
    </div>
</div>

<div class="container">
    <hr>
    <footer>
        <p>&copy; Vinokurov 2016</p>
    </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>
