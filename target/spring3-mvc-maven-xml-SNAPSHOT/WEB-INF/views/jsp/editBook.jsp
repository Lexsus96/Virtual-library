<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.08.2016
  Time: 17:44
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
    <spring:url value="/resources/core/css/round.css" var = "round" />
    <link href="${round}" rel="stylesheet" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />

</head>

<body onload = "myFunction()" style = "margin:0;">

<div id = "loader"></div>
<div id = "myDiv">

    <nav class = "navbar navbar-inverse navbar-fixed-top">
        <div class = "container">
            <div class = "navbar-header">
                <a class = "navbar-brand" href = "#">Edit Book</a>
            </div>
        </div>
    </nav>

    <div class = "jumbotron jumbotron-">
        <h1>${title}</h1>
        <form class = "form-horizontal" role="form" action = "/a/book/editing" >
            <div class = "form-group">
                <label for = "title" class = "col-sm-2 control-label">Title</label>
                <div class = "col-sm-10">
                    <input required name = "title" type = "text" class = "form-control" id = "title" value = ${book.getTitle()}>
                </div>
            </div>
            <div class = "form-group">
                <label name = "title" for = "Year" class = "col-sm-2 control-label">Year</label>
                <div class = "col-sm-10">
                    <input required name = "year" type = "text" class = "form-control" id = "Year" value = ${book.getYear()}>
                </div>
            </div>
            <div class = "form-group">
                <label for = "author" class ="col-sm-2 control-label">Author</label>
                <div class = "col-sm-10">
                    <select name = "author" id = "author" class="form-control">
                        <option selected value="${book.getAuthor().getId()}"> ${book.getAuthor().getFirst_name()} ${book.getAuthor().getSecond_name()}</option>
                        <c:forEach var="author" items="${list}">
                            <option value = "${author.getId()}">${author.getFirst_name()} ${author.getSecond_name()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class = "form-group">
                <label for = "isbn" class = "col-sm-2 control-label">ISBN</label>
                <div class = "col-sm-10">
                    <input name = "isbn" type = "text" class = "form-control" id = "isbn" readonly value = ${book.getIsbn()} >
                </div>
            </div>
            <div class = "form-group container">
                <div class = "row col-lg-12">
                    <button type = "submit" class = "btn btn-success  col-lg-2 col-lg-offset-3">Access</button>
                    <a href="/a/book/list" role="button" class = "btn btn-danger col-lg-2 col-lg-offset-1">Close</a>
                </div>
            </div>
        </form>
    </div>
<div class = "container col-md-4">
    <hr>
    <footer>
        <p>&copy; Vinokurov 2016</p>
    </footer>
</div>
</div>

<script>
    var myVar;

    function myFunction() {
        myVar = setTimeout(showPage, 1000);
    }

    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
    }
</script>

</body>
</html>
