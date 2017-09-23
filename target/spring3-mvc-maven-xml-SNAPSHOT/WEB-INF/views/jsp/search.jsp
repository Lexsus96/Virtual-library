<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12.08.2016
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                <li><a href="/welcome/personalArea">Home</a></li>
                <li><a href="/welcome/myBook">My books</a></li>
                <li class="active"><a href="/welcome/search">Search</a></li>
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
        <h1>Поиск</h1>
        <div class="row">
            <div class="col-lg-10">
                <form class="form-horizontal input-group" role="form" action = "/welcome/searching">
                    <div class="input-group-btn search-panel">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span id="search_concept">Filter by</span> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#author">Author</a></li>
                            <li><a href="#title">Title</a></li>
                            <li><a href="#year">Year</a></li>
                            <li class="divider"></li>
                            <li><a href="#all">Show all</a></li>
                        </ul>
                    </div>
                        <input type="hidden" name="search_param" value="all" id="search_param">
                        <input type="text" class="form-control" name="x" placeholder="Search term...">
                <span class="input-group-btn">
                    <button type = "submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                </span>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-10">
                <table class="table table-hover table-striped">
                    <tbody>
                    <thread>
                        <tr>
                            <th>
                                Title
                            </th>
                            <th>
                                Year
                            </th>
                            <th>
                                Author
                            </th>
                            <th>
                                ISBN
                            </th>
                            <th></th><th></th>
                        </tr>
                    </thread>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.getTitle()}</td>
                            <td>${book.getYear()}</td>
                            <td>${book.getAuthor().getFirst_name()} ${book.getAuthor().getSecond_name()}</td>
                            <td>${book.getIsbn()}</td>
                            <td class = "col-lg-1">
                                <a href="#">
                                    <span class="glyphicon glyphicon-search"></span>
                                </a>
                            </td>
                            <td class = "col-lg-1">
                                <a href="/welcome/search/read/${book.getIsbn()}">
                                    <span class=" btn btn-default">Читать</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
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
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<script src="${coreJs}"></script>
</body>
</html>