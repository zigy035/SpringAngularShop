<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/jquery-ui.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-1.12.1.min.js"></script>		
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-ui.min.js"></script>
	 -->

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/style.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/angular.min.js"></script>
	<script type="text/javascript">
		var baseURL = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/app.js"></script>
</head>
<body>
	<h2>Cart Page</h2>
	<div ng-app="cartApp" ng-controller="cartController">
		<table class="stripeMe sample">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="cartItem in cartData">
					<td>{{cartItem.productName}}</td>
					<td>{{cartItem.productPrice}}</td>
					<td>
						<input type="text" ng-model="cartItem.quantity" 
							ng-blur="updateCartItem(cartItem.id, cartItem.quantity)"/>
						<br/>
						<a href="javascript:void(0)" ng-click="deleteCartItem(cartItem.id)">Remove</a>
					</td>
					<td>{{cartItem.productPrice * cartItem.quantity | currency:2}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
