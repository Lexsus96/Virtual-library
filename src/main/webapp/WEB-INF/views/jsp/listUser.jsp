<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 04.08.2016
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

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
                <a class = "navbar-brand" href = "#">List of Users</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron jumbotron-">
        <div class="col-lg-offset-2" class="container">
            <h1>${title}</h1>
        </div>
        <a id = "myBtn4" href="/a/user/add" role="button" class="btn btn-success col-lg-8 col-lg-offset-2">Add user</a>
        <a href="/a" role="button" class = "btn btn-danger col-lg-8 col-lg-offset-2">Close</a>
        <div class="row">
            <div class="col-lg-offset-2 col-lg-8">
                <table class="table table-hover table-striped">
                    <tbody>
                    <thread class = "container">
                        <tr>
                            <th>
                                Login
                            </th>
                            <th>
                                Password
                            </th>
                            <th>
                                Admin
                            </th>
                            <th></th><th>
                        </th>
                        </tr>
                    </thread>
                    <c:forEach var="user" items="${list}">
                        <tr>
                            <td>${user.getLogin()}</td>
                            <td>${user.getPassword()}</td>
                            <td>${user.getAdmin()}</td>
                            <td class = "col-md-1">
                                <a href="/a/user/edit/${user.getLogin()}">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </td>
                            <td class = "col-md-1">
                                <a href="/a/user/delete/${user.getLogin()}">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="container">
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

    <spring:url value="/resources/core/css/hello.js" var="coreJs" />
    <spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

    <script src="${coreJs}"></script>
    <script src="${bootstrapJs}"></script>


</body>
</html>
