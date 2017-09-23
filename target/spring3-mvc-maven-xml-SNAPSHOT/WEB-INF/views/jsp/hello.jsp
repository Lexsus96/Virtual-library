<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="jumbotron jumbotron-">
  <div class="col-lg-offset-2" class="container">
	<h1>${title}</h1>
	<p>Welcome to TableExample</p>
	  <div class="row">
		  <a id = "myBtn1" href="/a/book/list" role="button" class="btn btn-primary btn-lg col-lg-2">List of books</a>
		  <a id = "myBtn3" href="/a/author/list" role="button" class="btn btn-primary btn-lg col-lg-2 col-lg-offset-1">List of authors</a>
		  <a id = "myBtn5" href="/a/user/list" role="button" class="btn btn-primary btn-lg col-lg-2 col-lg-offset-1">List of users</a>
	  </div>
	  <div class="row">
		  <a id = "myBtn" href="/welcome/personalArea" role="button" class="btn btn-primary btn-lg col-lg-2">Personal Area</a>
		  <a role="button" class="btn btn-danger btn-lg col-lg-2 col-lg-offset-1" href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	  </div>
	</div>
	<div class="col-lg-offset-2" class="container">
		<hr>
		<h4>Logs <a href="/a/clear" role="button" class = "btn btn-danger">Clear</a></h4>
		<div class="row">
			<div class="col-lg-8">
				<table rowspan = "10" class="table table-hover table-striped">
					<tbody>
					<thread>
						<tr>
							<th>
								[TYPE]
							</th>
							<th>
								Value
							</th>
						</tr>
					</thread>
					<c:forEach var="log" items="${list}">
						<tr>
							<td>${log.getType()}</td>
							<td>${log.getValue()}</td>
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
 
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>