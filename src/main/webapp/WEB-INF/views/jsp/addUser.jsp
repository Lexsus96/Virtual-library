<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 04.08.2016
  Time: 12:37
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
                <a class = "navbar-brand" href = "#">Adding User</a>
            </div>
        </div>
    </nav>

    <div class = "jumbotron jumbotron-">
        <h1>${title}</h1>
        <form class = "form-horizontal" role="form" action = "/a/user/adding" >
            <div class = "form-group">
                <label for = "login" class = "col-sm-2 control-label">Login</label>
                <div class = "col-md-10">
                    <input name = "login" type = "text" class = "form-control" id = "login" placeholder = "Login">
                </div>
            </div>
            <div class = "form-group">
                <label name = "pass" for = "pass" class = "col-sm-2 control-label">Password</label>
                <div class = "col-md-10">
                    <input name = "pass" type = "text" class = "form-control" id = "pass" placeholder = "Password">
                </div>
            </div>
            <div class = "form-group">
                <label for = "admin" class ="col-sm-2 control-label">Admin</label>
                <div class = "col-md-10">
                    <select name = "admin" id = "admin" class="form-control">
                        <option selected type = "text">FALSE</option>
                        <option type = "text">TRUE</option>
                    </select>
                </div>
            </div>
            <div class = "form-group container">
                <div class = "row col-lg-12">
                    <button type = "submit" class = "btn btn-success col-lg-2 col-lg-offset-3">Access</button>
                    <a href="/a/user/list" role="button" class = "btn btn-danger col-lg-2 col-lg-offset-1">Close</a>
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
