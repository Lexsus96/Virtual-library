<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 11.08.2016
  Time: 18:05
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
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Library project</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/welcome/personalArea">Home</a></li>
                <li><a href="/welcome/myBook">My books</a></li>
                <li><a href="/welcome/search">Search</a></li>
                <li class="dropdown">
                    <a href="" data-toggle="dropdown" class="dropdown-toggle" >Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/a">I am Admin</a></li>
                        <li><a href="/403">Test /403</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header"></li>
                        <li><a href="/j_spring_security_logout" color = "red">Exit</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="jumbotron">
        <h1>Электронная библиотека</h1>
        <p>Это тестовый проект <strong>электронной библиотеки</strong> создан для освоения базовых технологий в разработке веб-приложений.</p>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <p>Для навигации по проекту используйте верхнее меню.</p>
    </div>
</div>

<div class="container">
    <hr>
    <footer>
        <p>&copy; Vinokurov 2016</p>
    </footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
</body>
</html>
