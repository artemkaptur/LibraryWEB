<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Corporate Library</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,400italic">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Hind:400,500">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400&amp;subset=devanagari">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>

	<!-- COVER -->
	<div class="cover">
		<div class="title-malistica"></div>
	</div>

	<!-- SECTION NAVIGATION -->
	<section class="navigation"> <nav
		class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#nav-1">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="nav-1">
			<ul class="nav navbar-nav">
				<li role="presentation"><a href="mainPage.jsp">Home </a></li>
				<li role="presentation"><a href="createEmployeePage.jsp">Create
				</a></li>
				<li role="presentation"><a href="deleteEmployeePage.jsp">Delete
				</a></li>
				<li role="presentation"><a href="updateEmployeePage.jsp">
						Update</a></li>
				<li role="presentation"><a href="SearchByEmailPage.jsp">
						Search</a></li>
			</ul>
		</div>
	</div>
	</nav> </section>

	<!-- SECTION PAGINATION -->
	<section class="pagination-section">

	<form method="post" action="s8">
		<input type="submit" value="Show current Library members" name="Ok"><br>
	</form>

	<c:forEach var="employee" items="${requestScope.employees}">
		<ul>

			<li>Name: <c:out value="${employee.name}" /></li>

			<li>Surname: <c:out value="${employee.surname}" /></li>

			<li>Birth date: <c:out value="${employee.dateOfBirth}" /></li>

			<li>Email: <c:out value="${employee.email}" /></li>
		</ul>
		<hr />
	</c:forEach> </section>

	<!-- SECTION FOOTER -->
	<footer class="footer">
	<div class="container container-footer">
		<div
			class="col-lg-6 col-lg-push-3 col-md-6 col-md-push-3 col-sm-10 col-xs-10 col-xs-push-1 column-footer">

			<h1 class="description-site desc-footer">I hope you have enjoyed
				my Beatiful Library, have a nice day!</h1>
			<div class="s-social">
				<a
					href="https://www.facebook.com/people/%D0%90%D1%80%D1%82%D0%B5%D0%BC-%D0%9A%D0%B0%D0%BF%D1%82%D1%83%D1%80/100012159016591"
					class="url-social"><i class="fa fa-facebook"></i></a><a href="#"
					class="url-social"><i class="fa fa-linkedin"></i></a> <a
					href="https://vk.com/artemkaptur" class="url-social"><i
					class="fa fa-vk"></i></a>
			</div>
			<hr class="hr-divider">
			<p class="text-copyright">Designed by Artem Kaptur</p>
		</div>
	</div>
	</footer>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bs-animation.js"></script>
</body>

</html>