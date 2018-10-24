<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<script type="text/javascript">
	var app = angular.module("app", [ "ngRoute" ]);
	app.controller("h1", function($scope) {

	});
	app.config(function($routeProvider) {
		$routeProvider.when('/login', {
			templateUrl : './static/html/login.html'
		}).when('/register', {
			templateUrl : './static/html/registration.html'
		}).when('/about', {
			templateUrl : './static/html/about.html'
		}).when('/contact', {
			templateUrl : './static/html/contact.html'
		}).otherwise({
			redirectTo : 'home',
			templateUrl : './static/html/home.html',
		});
	});
</script>
</head>
<body ng-app="app">
	<div class="container">

		<div class="col-sm-12">

			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">HMS::PRO</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="#!/login">Login</a></li>
					<li><a href="#!/register">Register</a></li>
					<li><a href="#!/about">About</a></li>
					<li><a href="#!/contact">Contect</a></li>
				</ul>
			</div>
			</nav>

		</div>

		<div class="col-sm-12">
			<div ng-view></div>
		</div>

		<div class="col-sm-12" id="footer">
			<div class="panel panel-default">
				<div class="panel-footer">@copyright</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>