<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 04.08.2016
  Time: 17:05
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
                <a class = "navbar-brand" href = "#">List of Books</a>
            </div>
            </div>
        </nav>

        <div class="jumbotron jumbotron-">
            <div class="col-lg-offset-2" class="container">
                <h1>${title}</h1>
            </div>
            <a id = "myBtn" href="/a/book/add" role="button" class="btn btn-success btn-lg col-lg-8 col-lg-offset-2">Add book</a>
            <a href="/a" role="button" class = "btn btn-danger col-lg-8 col-lg-offset-2">Close</a>
            <div class="row">
               <div class="col-lg-offset-1 col-lg-10">
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
                                <th></th><th></th><th></th>
                            </tr>
                       </thread>
                            <c:forEach var="book" items="${list}">
                            <tr>
                            <td>${book.getTitle()}</td>
                            <td>${book.getYear()}</td>
                            <td>${book.getAuthor().getFirst_name()} ${book.getAuthor().getSecond_name()}</td>
                            <td>${book.getIsbn()}</td>
                            <td class = "col-md-1">
                                <a href="#">
                                    <span class="glyphicon glyphicon-search"></span>
                                </a>
                            </td>
                            <td class = "col-md-1">
                                <a href="/a/book/edit/${book.getIsbn()}">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </td>
                            <td class = "col-md-1">
                                <a href="/a/book/delete/${book.getIsbn()}">
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
            myVar = setTimeout(showPage, 1000);
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
