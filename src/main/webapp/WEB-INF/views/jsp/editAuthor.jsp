<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 08.08.2016
  Time: 12:23
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
                <a class = "navbar-brand" href = "#">Edit Author</a>
            </div>
        </div>
    </nav>

    <div class = "jumbotron jumbotron-">
        <h1>${title}</h1>
        <form class = "form-horizontal" role="form" action = "/a/author/editing" >
            <div class = "form-group">
                <label for = "firstName" class = "col-sm-2 control-label">Name</label>
                <div class = "col-sm-10">
                    <input required name = "firstName" type = "text" class = "form-control" id = "firstName" value = ${author.getFirst_name()}>
                </div>
            </div>
            <div class = "form-group">
                <label name = "secondName" for = "secondName" class = "col-sm-2 control-label">Surname</label>
                <div class = "col-sm-10">
                    <input required name = "secondName" type = "text" class = "form-control" id = "secondName" value = ${author.getSecond_name()}>
                </div>
            </div>
            <div class = "form-group">
                <label for = "id" class = "col-sm-2 control-label">ID</label>
                <div class = "col-sm-10">
                    <input name = "id" type = "text" class = "form-control" id = "id" readonly value = ${author.getId()} >
                </div>
            </div>
            <div class = "form-group container">
                <div class = "row col-lg-12">
                    <button type = "submit" class = "btn btn-success  col-lg-2 col-lg-offset-3">Access</button>
                    <a href="/a/author/list" role="button" class = "btn btn-danger col-lg-2 col-lg-offset-1">Close</a>
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
        myVar = setTimeout(showPage, 500);
    }

    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
    }
</script>

</body>
</html>

