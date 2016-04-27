<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body ng-app="shopApp">
	
	<div id="wrapper">
		<div id="header">
			<div id="nav">
				<h1>CoolShop</h1>
				<a href="#/product">Products</a> | <a href="#/cart">Cart</a>
				<span ng-show="!isAuthUser">| <a href="#/login">Login</a></span>
				<span ng-show="isAuthUser">| <a href="#/logout">Logout</a></span>
			</div>
		</div>
		<div id="main">
			<div ng-view=""></div>
		</div>
		<div id="footer">
			<p>Copyright &copy; 2016 CoolShop.com</p>
		</div>
	</div>
	
	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/angular-route.min.js"></script>
	<script src="resources/js/app.js"></script>
	<script src="resources/js/controllers/CartController.js"></script>
	<script src="resources/js/controllers/ProductController.js"></script>
	<script src="resources/js/controllers/LoginController.js"></script>
	
</body>
</html>