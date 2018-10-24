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
	var app = angular.module("app1", [ "ngRoute" ]);
	app.controller("h2", function($scope, $http) {
		$scope.getAdmin = function() {
			$http({
				method : 'GET',
				url : 'http://localhost:8088/Hospital_Management/admin/getall'
			}).then(function successCallback(response) {
				$scope.admins = response.data;
				console.log(response);
			}, function errorCallback(response) {
				$scope.admins = response.data;
			});
		}
	});
	/* app.config(function($routeProvider) {
		$routeProvider.when('#', {
			templateUrl : './static/html/superAdminProfile.html'
		}).when('/admin', {
			templateUrl : './static/html/admin.html'
		}).when('/hospital', {
			templateUrl : './static/html/hospital.html'
		}).otherwise({
			redirectTo : 'superadmin'
		});
	}); */
</script>
</head>
<body ng-app="app1" ng-controller="h2">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">head</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="list-group">
					<button class="list-group-item list-group-item-action"
						ng-click="getSuperAdmin()">Profile</button>
					<button class="list-group-item list-group-item-action"
						ng-click="getAdmin()">Admin</button>
					<button class="list-group-item list-group-item-action"
						ng-click="getHospital()">Hospital</button>
				</div>
			</div>
			<div class="col-sm-9">
				<div  ng-repeat="admin in admins">
					{{admin}}
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">footer</div>
		</div>
	</div>
</body>
</html>